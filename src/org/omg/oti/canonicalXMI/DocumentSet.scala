/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.canonicalXMI

import scala.language.higherKinds
import scala.language.implicitConversions
import scala.language.postfixOps
import scala.reflect.runtime.universe
import scala.reflect.runtime.universe._
import org.omg.oti._
import scala.util.Try
import scala.util.Failure
import scala.util.Success
import scalax.collection.config.CoreConfig
import scalax.collection.mutable.ArraySet.Hints
import scalax.collection.GraphEdge._
import scalax.collection.GraphPredef._
import scalax.collection.constrained._
import scalax.collection.constrained.constraints.NoneConstraint
import scalax.collection.constrained.generic.GraphConstrainedCompanion
import scalax.collection.edge.CBase._
import scalax.collection.io.edge.CEdgeParameters
import scalax.collection.io.json.Descriptor
import scalax.collection.io.json.descriptor.CEdgeDescriptor
import scalax.collection.io.json.descriptor.NodeDescriptor
import java.io.FileWriter
import java.io.BufferedWriter
import java.io.PrintWriter

case class DocumentSet[Uml <: UML](
  val serializableDocuments: Set[SerializableDocument[Uml]],
  val builtInDocuments: Set[BuiltInDocument[Uml]],
  val catalogURIMapper: CatalogURIMapper )( implicit val ops: UMLOps[Uml] ) {

  implicit val myConfig = CoreConfig( orderHint = 5000, Hints( 64, 0, 64, 75 ) )

  class DocumentEdge[N]( nodes: Product )
    extends DiEdge[N]( nodes )
    with EdgeCopy[DocumentEdge]
    with OuterEdge[N, DocumentEdge] {

    override def copy[NN]( newNodes: Product ) = DocumentEdge.newEdge[NN]( newNodes )
  }

  object DocumentEdge extends EdgeCompanion[DocumentEdge] {
    protected def newEdge[N]( nodes: Product ) = new DocumentEdge[N]( nodes )

    def apply( e: DiEdge[Product with Serializable with Document[Uml]] ) = new DocumentEdge[Document[Uml]]( NodeProduct( e.from, e.to ) )
    def apply( from: Document[Uml], to: Document[Uml] ) = new DocumentEdge[Document[Uml]]( NodeProduct( from, to ) )
    def unapply( e: DocumentEdge[Document[Uml]] ) = Some( e )
    def apply[N]( from: N, to: N ): DocumentSet.this.DocumentEdge[N] = new DocumentEdge[N]( NodeProduct( from, to ) )
    override def from[N]( nodes: Product ): DocumentEdge[N] = new DocumentEdge[N]( NodeProduct( nodes.productElement( 1 ), nodes.productElement( 2 ) ) )
  }

  implicit val documentEdgeTag: TypeTag[DocumentEdge[Document[Uml]]] = typeTag[DocumentEdge[Document[Uml]]]

  class TConnected[CC[N, E[X] <: EdgeLikeIn[X]] <: Graph[N, E] with GraphLike[N, E, CC]]( val factory: GraphConstrainedCompanion[CC] ) {
    implicit val config: Config = NoneConstraint

    def empty() = factory[Document[Uml], DocumentEdge]()
  }

  case class UnresolvedElementCrossReference(
    document: Document[Uml],
    documentElement: UMLElement[Uml],
    externalReference: UMLElement[Uml] )

  /**
   * Construct the graph of document (nodes) and cross-references among documents (edges) and determine unresolvable cross-references
   *
   * @param ignoreCrossReferencedElementFilter A predicate determing whether to ignore a cross referenced element.
   *   Unresolvable cross references in the result correspond to cross-referenced elements for which the predicate is false.
   * @return a 3-tuple:
   * - the graph of document-level cross references
   * - the map of elements to theirs serialization document
   * - the unresolved cross references
   */
  def externalReferenceDocumentGraph(
    ignoreCrossReferencedElementFilter: UMLElement[Uml] => Boolean ): ( mutable.Graph[Document[Uml], DocumentEdge], Map[UMLElement[Uml], Document[Uml]], Iterable[UnresolvedElementCrossReference] ) = {

    val element2document: Map[UMLElement[Uml], Document[Uml]] =
      ( serializableDocuments ++ builtInDocuments ) flatMap {
        d => d.extent map { e => ( e -> d ) }
      } toMap

    val mc = new TConnected[mutable.Graph]( mutable.Graph )
    val ic = new TConnected[immutable.Graph]( immutable.Graph )
    val g = mc.empty()

    // add each document as a node in the graph
    element2document.values foreach { d => g += d }

    val unresolved = for {
      ( e, d ) <- element2document
      eRef <- e.allForwardReferences
    } yield element2document.get( eRef ) match {
      case None =>
        if ( ignoreCrossReferencedElementFilter( eRef ) ) {
          System.out.println( " => skip" )
          None
        }
        else {
          System.out.println( " => unresolved!" )
          Some( UnresolvedElementCrossReference( d, e, eRef ) )
        }
      case Some( dRef ) =>
        if ( d != dRef ) {
          // add cross-reference edge
          g += DocumentEdge( d, dRef )
        }
        None
    }

    ( g, element2document, unresolved.flatten )
  }

  def serialize(
    g: mutable.Graph[Document[Uml], DocumentEdge],
    element2document: Map[UMLElement[Uml], Document[Uml]] ): Try[Unit] = {

    g.nodes foreach {
      _.value match {
        case _: BuiltInDocument[Uml] => ()
        case d: SerializableDocument[Uml] =>
          serialize( g, element2document, d ) match {
            case Failure( t ) => return Failure( t )
            case Success( _ ) => ()
          }
      }
    }

    Success( Unit )
  }

  def serialize(
    g: mutable.Graph[Document[Uml], DocumentEdge],
    element2document: Map[UMLElement[Uml], Document[Uml]],
    d: SerializableDocument[Uml] ): Try[Unit] =
    catalogURIMapper.resolveURI( d.uri, catalogURIMapper.saveResolutionStrategy ) match {
      case Failure( t ) => Failure( t )
      case Success( uri ) =>
        import scala.xml._
        import DocumentSet._

        val xmiScopes =
          NamespaceBinding( "xmi", XMI_ns,
            NamespaceBinding( "xsi", XSI_ns,
              NamespaceBinding( "uml", UML_ns, null ) ) )

        generateNodeElement( g, element2document, d, "uml", d.scope, xmiScopes ) match {
          case Failure( t ) => return Failure( t )
          case Success( top ) =>

            val xmi = Elem( prefix = "xmi", label = "XMI", attributes = Null, scope = xmiScopes, minimizeEmpty = false, top )
            val dir = ( new java.io.File( uri ) ).getParentFile
            dir.mkdirs()

            val filepath = uri.getPath + ".xmi"
            val xmlFile = new java.io.File( filepath )

            val xmlPrettyPrinter = new PrettyPrinter( width = 200, step = 2 )
            val xmlOutput = xmlPrettyPrinter.format( xmi )

            val bw = new PrintWriter( new FileWriter( xmlFile ) )
            bw.println( "<?xml version='1.0' encoding='UTF-8'?>" )
            bw.println( xmlOutput )
            bw.close()

            Success( Unit )
        }
    }

  def generateNodeElement(
    g: mutable.Graph[Document[Uml], DocumentEdge],
    element2document: Map[UMLElement[Uml], Document[Uml]],
    d: SerializableDocument[Uml],
    prefix: String,
    e: UMLElement[Uml],
    xmiScopes: scala.xml.NamespaceBinding ): Try[scala.xml.Node] = {

    import scala.xml._

    def foldAttribute( next: Try[MetaData], f: e.MetaAttributeFunction ): Try[MetaData] =
      next match {
        case Failure( t ) =>
          Failure( t )
        case Success( n ) =>
          for { fValue <- f.evaluate( e ) }
            yield fValue match {
            case None =>
              n
            case Some( v ) =>
              f.attributePrefix match {
                case None =>
                  new UnprefixedAttribute( key = f.attributeName, value = v, n )
                case Some( aPrefix ) =>
                  new PrefixedAttribute( pre = aPrefix, key = f.attributeName, value = v, n )
              }
          }
      }

    def foldLocalReference( next: Try[MetaData], f: e.MetaReferenceEvaluator ): Try[MetaData] =
      next match {
        case Failure( t ) => Failure( t )
        case Success( n ) =>
          f.evaluate( e ) match {
            case Failure( t )    => Failure( t )
            case Success( None ) => Success( n )
            case Success( Some( eRef ) ) =>
              element2document.get( eRef ) match {
                case None =>
                  Success( n )
                case Some( dRef ) =>
                  if ( d != dRef ) Success( n )
                  else Success( new UnprefixedAttribute( key = f.propertyName, value = eRef.id, n ) )
              }
          }
      }

    def foldCrossReference( nodes: Try[Seq[Node]], f: e.MetaReferenceEvaluator ): Try[Seq[Node]] =
      nodes match {
        case Failure( t ) => Failure( t )
        case Success( ns ) =>
          f.evaluate( e ) match {
            case Failure( t )    => Failure( t )
            case Success( None ) => Success( ns )
            case Success( Some( eRef ) ) =>
              element2document.get( eRef ) match {
                case None =>
                  Success( ns )
                case Some( dRef ) =>
                  if ( d == dRef ) Success( ns )
                  else {
                    val hrefAttrib: MetaData = new UnprefixedAttribute( key = "href", value = s"${dRef.uri}#${eRef.id}", Null )
                    val hrefNode: Node = Elem( prefix = null, label = f.propertyName, attributes = hrefAttrib, scope = xmiScopes, minimizeEmpty = false )
                    Success( ns :+ hrefNode )
                  }
              }
          }
      }

    def foldSubNode( nodes: Try[Seq[Node]], f: e.MetaCollectionEvaluator ): Try[Seq[Node]] =
      nodes match {
        case Failure( t ) => Failure( t )
        case Success( ns ) =>
          f.evaluate( e ) match {
            case Failure( t )   => Failure( t )
            case Success( Nil ) => Success( ns )
            case Success( subs ) =>
              val subNodes = for { sub <- subs }
                yield generateNodeElement( g, element2document, d, null, sub, xmiScopes ) match {
                case Failure( t ) => return Failure( t )
                case Success( n ) => n
              }
              Success( ns ++ subNodes )
          }
      }

    val last: Try[MetaData] = Success( Null )
    ( last /: e.metaAttributes.reverse )( foldAttribute _ ) match {
      case Failure( t ) =>
        Failure( t )

      case Success( xmlAttributes ) =>
        val refEvaluators: Seq[e.MetaReferenceEvaluator] = e.referenceMetaProperties.flatMap { case p: e.MetaPropertyEvaluator => p.getReferenceFunction }
        val subEvaluators: Seq[e.MetaCollectionEvaluator] = e.compositeMetaProperties.flatMap { case p: e.MetaPropertyEvaluator => p.getCollectionFunction }

        val prevAttributes: Try[MetaData] = Success( xmlAttributes )
        ( prevAttributes /: refEvaluators )( foldLocalReference _ ) match {
          case Failure( t ) =>
            Failure( t )

          case Success( xmlAttributesAndLocalReferences ) =>
            val xRef0: Try[Seq[Node]] = Success( Seq() )
            val xRefs = ( xRef0 /: refEvaluators )( foldCrossReference _ )
            val xRefsAndSubs = ( xRefs /: subEvaluators )( foldSubNode _ )

            xRefsAndSubs match {
              case Failure( t ) =>
                Failure( t )

              case Success( nodes ) =>
                val node = Elem(
                  prefix = prefix,
                  label = e.xmiElementLabel,
                  attributes = xmlAttributesAndLocalReferences,
                  scope = xmiScopes,
                  minimizeEmpty = false,
                  nodes: _* )
                Success( node )
            }
        }
    }
  }
}

object DocumentSet {

  val XMI_Version = "20131001"

  val XMI_ns = "http://www.omg.org/spec/XMI/20131001"
  val XSI_ns = "http://www.w3.org/2001/XMLSchema-instance"
  val UML_ns = "http://www.omg.org/spec/UML/20131001"

}
