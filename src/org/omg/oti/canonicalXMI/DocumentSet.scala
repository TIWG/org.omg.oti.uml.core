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

import org.omg.oti._
import scala.annotation.tailrec
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

import scalaz._, Scalaz._, Free._

class DocumentEdge[N]( nodes: Product )
  extends DiEdge[N]( nodes )
  with EdgeCopy[DocumentEdge]
  with OuterEdge[N, DocumentEdge] {

  override def copy[NN]( newNodes: Product ) = DocumentEdge.newEdge[NN]( newNodes )
}

object DocumentEdge extends EdgeCompanion[DocumentEdge] {
  protected def newEdge[N]( nodes: Product ) = new DocumentEdge[N]( nodes )

  def apply[Uml <: UML]( e: DiEdge[Product with Serializable with Document[Uml]] ) = new DocumentEdge[Document[Uml]]( NodeProduct( e.from, e.to ) )
  def apply[Uml <: UML]( from: Document[Uml], to: Document[Uml] ) = new DocumentEdge[Document[Uml]]( NodeProduct( from, to ) )
  def unapply[Uml <: UML]( e: DocumentEdge[Document[Uml]] ) = Some( e )
  def apply[N]( from: N, to: N ): DocumentEdge[N] = new DocumentEdge[N]( NodeProduct( from, to ) )
  override def from[N]( nodes: Product ): DocumentEdge[N] = new DocumentEdge[N]( NodeProduct( nodes.productElement( 1 ), nodes.productElement( 2 ) ) )
}

case class UnresolvedElementCrossReference[Uml <: UML](
  document: Document[Uml],
  documentElement: UMLElement[Uml],
  externalReference: UMLElement[Uml] )

/**
 * @todo: add support for the possibility that a stereotype tag value may refer to an element serialized in a different document.
 */
case class DocumentSet[Uml <: UML](
  val serializableDocuments: Set[SerializableDocument[Uml]],
  val builtInDocuments: Set[BuiltInDocument[Uml]],
  val documentURIMapper: CatalogURIMapper,
  val builtInURIMapper: CatalogURIMapper,
  val valueSpecificationTagConverter: Function1[UMLValueSpecification[Uml], Try[Option[String]]] = DocumentSet.serializeValueSpecificationAsTagValue _ )( implicit val ops: UMLOps[Uml] ) {

  implicit val myConfig = CoreConfig( orderHint = 5000, Hints( 64, 0, 64, 75 ) )

  implicit val documentEdgeTag: TypeTag[DocumentEdge[Document[Uml]]] = typeTag[DocumentEdge[Document[Uml]]]

  class TConnected[CC[N, E[X] <: EdgeLikeIn[X]] <: Graph[N, E] with GraphLike[N, E, CC]]( val factory: GraphConstrainedCompanion[CC] ) {
    implicit val config: Config = NoneConstraint

    def empty() = factory[Document[Uml], DocumentEdge]()
  }

  type MutableDocumentSetGraph = mutable.Graph[Document[Uml], DocumentEdge]
  type ImmutableDocumentSetGraph = immutable.Graph[Document[Uml], DocumentEdge]

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
    ignoreCrossReferencedElementFilter: UMLElement[Uml] => Boolean ): ( MutableDocumentSetGraph, Map[UMLElement[Uml], Document[Uml]], Iterable[UnresolvedElementCrossReference[Uml]] ) = {

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

  def foldTagValues(
    tagValues: Map[UMLProperty[Uml], Seq[UMLValueSpecification[Uml]]] )(
      tagValueAttribute: Try[scala.xml.MetaData],
      property: UMLProperty[Uml] ): Try[scala.xml.MetaData] =
    tagValueAttribute match {
      case Failure( t ) => Failure( t )
      case Success( attribute ) =>
        tagValues.get( property ) match {
          case None =>
            Success( attribute )
          case Some( values ) =>
            val stringValues = values flatMap { v =>
              valueSpecificationTagConverter( v ) match {
                case Failure( t ) => return Failure( t )
                case Success( s ) => s
              }
            }

            if ( stringValues.isEmpty )
              Success( attribute )
            else
              Success(
                new scala.xml.UnprefixedAttribute(
                  key = property.name.get,
                  value = stringValues.mkString( " " ),
                  attribute ) )
        }
    }

  def serialize(
    g: mutable.Graph[Document[Uml], DocumentEdge],
    element2document: Map[UMLElement[Uml], Document[Uml]],
    d: SerializableDocument[Uml] ): Try[Unit] =
    documentURIMapper.resolveURI( d.uri, documentURIMapper.saveResolutionStrategy ) match {
      case Failure( t ) => Failure( t )
      case Success( uri ) =>
        import scala.xml._
        import DocumentSet._

        val referencedProfiles = ( for {
          e <- d.extent
          ( s, p ) <- e.getAppliedStereotypes
          pf <- s.profile
          if (element2document.contains( pf ))
        } yield pf ) toSet

        val emptyScope: NamespaceBinding = null
        
        val profileScopes = ( emptyScope /: referencedProfiles ) {
          case ( scopes, referencedProfile ) =>
            ( referencedProfile.name, referencedProfile.getEffectiveURI ) match {
              case ( None, _ )                      => scopes
              case ( _, None )                      => scopes
              case ( Some( name ), Some( ns_uri ) ) => NamespaceBinding( name, ns_uri, scopes )
            }
        }

        val xmiScopes =
          NamespaceBinding( "xmi", XMI_ns,
            NamespaceBinding( "xsi", XSI_ns,
              NamespaceBinding( "uml", UML_ns,
                NamespaceBinding( "mofext", MOFEXT_ns, profileScopes ) ) ) )

        val elementOrdering = scala.collection.mutable.ArrayBuffer[UMLElement[Uml]]()

        val free: Free[Function0, Try[scala.xml.Node]] =
          generateNodeElement(
            g, element2document, elementOrdering,
            d, "uml", d.scope.xmiElementLabel,
            d.scope, xmiScopes )

        val result: Try[scala.xml.Node] =
          free.go( f => Comonad[Function0].copoint( f ) )( Applicative[Function0] )

        // alternatively:
        // val result = free.run

        result match {
          case Failure( t ) => return Failure( t )
          case Success( top ) =>

            /**
             * @issue: Canonical XMI B4 mofext:Tag
             */
            val mofTag = Elem(
              prefix = "mofext",
              label = "Tag",
              attributes =
                new PrefixedAttribute(
                  pre = "xmi", key = "id", value = d.scope.xmiID.head + "_mofext.Tag",
                  new PrefixedAttribute(
                    pre = "xmi", key = "uuid", value = d.scope.xmiUUID.head + "_mofext.Tag",
                    new PrefixedAttribute(
                      pre = "xmi", key = "type", value = "mofext:Tag",
                      d.scope match {
                        case ne: UMLNamedElement[Uml] =>
                          ne.name match {
                            case None =>
                              Null
                            case Some( name ) =>
                              new UnprefixedAttribute(
                                key = "name", value = "org.omg.xmi.nsPrefix",
                                new UnprefixedAttribute(
                                  key = "value", value = name,
                                  new UnprefixedAttribute(
                                    key = "element", value = d.scope.xmiID.head,
                                    Null ) ) )
                          }
                        case _ =>
                          Null
                      } ) ) ),
              scope = xmiScopes,
              minimizeEmpty = true )

            /**
             *
             */
            val stereotypeTagValues = elementOrdering.toList flatMap { e =>
              val allTagValues = e.stereotypeTagValues
              val appliedStereotypes = e.getAppliedStereotypes filter { case ( s, p ) => element2document.contains( s ) }
              val ordering = appliedStereotypes.toList.sortBy { case ( s, p ) => s.profile.get.xmiUUID.head + s.xmiUUID.head }
              val orderedTagValueElements = ordering map {
                case ( s, p ) =>
                  val tagValueAttributes: scala.xml.MetaData = allTagValues.get( s ) match {
                    case None => Null
                    case Some( tagValues ) =>
                      val properties = tagValues.keys.toList.sortBy( _.xmiUUID.head )
                      val tagValueAttribute0: Try[MetaData] = Success( Null )
                      val tagValueAttributeN = ( tagValueAttribute0 /: properties.reverse )( foldTagValues( tagValues ) _ )
                      tagValueAttributeN match {
                        case Failure( t )                 => return Failure( t )
                        case Success( tagValueAttribute ) => tagValueAttribute
                      }
                  }
                  val xmiTagValueAttributes =
                    new PrefixedAttribute(
                      pre = "xmi", key = "id", value = e.xmiID.head + "-" + s.xmiID.head,
                      new PrefixedAttribute(
                        pre = "xmi", key = "uuid", value = e.xmiUUID.head + "-" + s.xmiUUID.head,
                        new UnprefixedAttribute(
                          key = p.name.get, value = e.xmiID.head,
                          tagValueAttributes ) ) )
                  Elem(
                    prefix = s.profile.get.name.get,
                    label = s.name.get,
                    attributes = xmiTagValueAttributes,
                    scope = xmiScopes,
                    minimizeEmpty = true )
              }
              orderedTagValueElements
            }

            val xmi = Elem(
              prefix = "xmi",
              label = "XMI",
              attributes = Null,
              scope = xmiScopes,
              minimizeEmpty = true,
              ( top :: mofTag :: stereotypeTagValues ): _* )
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

  @tailrec final def append1Node(
    nodes: Seq[scala.xml.Node],
    t: Trampoline[Try[scala.xml.Node]] ): Trampoline[Try[Seq[scala.xml.Node]]] = {

    //    assert( Thread.currentThread().getStackTrace.count( _.getMethodName == "append1Node" ) == 1,
    //      "Verification that the trampolined recursive function 'append1Node' runs stack-free" )

    t.resume match {
      //case -\/( s ) => suspend { append1Node( nodes, s() ) }
      case -\/( s ) => append1Node( nodes, s() )
      case \/-( r ) => r match {
        case Failure( t ) => return_ { Failure( t ) }
        case Success( n ) => return_ { Success( nodes :+ n ) }
      }
    }
  }

  @tailrec final def appendNodes(
    t1: Trampoline[Try[Seq[scala.xml.Node]]],
    t2: Trampoline[Try[scala.xml.Node]] ): Trampoline[Try[Seq[scala.xml.Node]]] = {

    //    assert(
    //      Thread.currentThread().getStackTrace.count( _.getMethodName == "appendNodes" ) == 1,
    //      "Verification that the trampolined recursive function 'appendNodes' runs stack-free" )

    t1.resume match {
      //case -\/( s )             => suspend { appendNodes( s(), t2 ) }
      case -\/( s )            => appendNodes( s(), t2 )
      case \/-( Failure( t ) ) => return_ { Failure( t ) }
      case \/-( Success( ns ) ) =>
        suspend {
          append1Node( ns, t2 )
        }
    }
  }

  @tailrec final def wrapNodes(
    t: Trampoline[Try[Seq[scala.xml.Node]]],
    prefix: String,
    label: String,
    xmlAttributesAndLocalReferences: scala.xml.MetaData,
    xmiScopes: scala.xml.NamespaceBinding ): Trampoline[Try[scala.xml.Node]] = {

    //    assert( Thread.currentThread().getStackTrace.count( _.getMethodName == "wrapNodes" ) == 1,
    //      "Verification that the trampolined function 'wrapNodes' runs recursively stack-free" )

    t.resume match {
      //      case -\/( s ) =>
      //        suspend { wrapNodes( s(), prefix, label, xmlAttributesAndLocalReferences, xmiScopes ) }
      case -\/( s ) =>
        wrapNodes( s(), prefix, label, xmlAttributesAndLocalReferences, xmiScopes )
      case \/-( Failure( t ) ) =>
        return_ { Failure( t ) }
      case \/-( Success( nodes ) ) =>
        import scala.xml._
        val node = Elem(
          prefix = prefix,
          label = label,
          attributes = xmlAttributesAndLocalReferences,
          scope = xmiScopes,
          minimizeEmpty = true,
          nodes: _* )
        return_ { Success( node ) }
    }
  }

  def generateNodeElement(
    g: mutable.Graph[Document[Uml], DocumentEdge],
    element2document: Map[UMLElement[Uml], Document[Uml]],
    elementOrdering: scala.collection.mutable.ArrayBuffer[UMLElement[Uml]],
    d: SerializableDocument[Uml],
    prefix: String,
    label: String,
    e: UMLElement[Uml],
    xmiScopes: scala.xml.NamespaceBinding ): Trampoline[Try[scala.xml.Node]] = {

    elementOrdering += e

    import scala.xml._

    //    assert(
    //      Thread.currentThread().getStackTrace.count( _.getMethodName == "generateNodeElement" ) == 1,
    //      s"Verification that the trampolined function 'wrapNodes' runs recursively stack-free for label=${label}, e=${e.xmiID}" )

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

    def foldLocalReference( next: Try[MetaData], f: e.MetaPropertyEvaluator ): Try[MetaData] =
      next match {
        case Failure( t ) => Failure( t )
        case Success( n ) =>
          f match {
            case rf: e.MetaReferenceEvaluator =>
              rf.evaluate( e ) match {
                case Failure( t )    => Failure( t )
                case Success( None ) => Success( n )
                case Success( Some( eRef ) ) =>
                  element2document.get( eRef ) match {
                    case None =>
                      System.out.println( s"*** foldLocalReference: ref=${f.propertyName} -- no document for: ${eRef.id}" )
                      Success( n )
                    case Some( dRef ) =>
                      if ( d != dRef ) Success( n )
                      else Success( new UnprefixedAttribute( key = f.propertyName, value = eRef.id, n ) )
                  }
              }
            case cf: e.MetaCollectionEvaluator =>
              cf.evaluate( e ) match {
                case Failure( t )   => Failure( t )
                case Success( Nil ) => Success( n )
                case Success( eRefs ) =>
                  val lRefs = eRefs flatMap { eRef =>
                    element2document.get( eRef ) match {
                      case None =>
                        System.out.println( s"*** foldLocalReference: collection=${f.propertyName} -- no document for: ${eRef.id}" )
                        None
                      case Some( dRef ) =>
                        if ( d != dRef ) None
                        else Some( eRef.id )
                    }
                  }
                  if ( lRefs.isEmpty ) Success( n )
                  else Success( new UnprefixedAttribute( key = f.propertyName, value = lRefs.mkString( " " ), n ) )
              }
          }
      }

    def foldCrossReference( nodes: Try[Seq[Node]], f: e.MetaPropertyEvaluator ): Try[Seq[Node]] =
      nodes match {
        case Failure( t ) => Failure( t )
        case Success( ns ) =>
          f match {
            case rf: e.MetaReferenceEvaluator =>
              rf.evaluate( e ) match {
                case Failure( t )    => Failure( t )
                case Success( None ) => Success( ns )
                case Success( Some( eRef ) ) =>
                  element2document.get( eRef ) match {
                    case None =>
                      System.out.println( s"*** foldCrossReference: ref=${f.propertyName} -- no document for: ${eRef.id}" )
                      Success( ns )
                    case Some( dRef ) =>
                      if ( d == dRef ) Success( ns )
                      else {
                        val href = dRef.uri + "#" + eRef.id
                        val externalHRef = dRef match {
                          case _: SerializableDocument[Uml] => href
                          case _: BuiltInDocument[Uml]      => builtInURIMapper.resolve( href )
                        }
                        val hrefAttrib: MetaData = new UnprefixedAttribute( key = "href", value = externalHRef, Null )
                        val hrefNode: Node = Elem( prefix = null, label = f.propertyName, attributes = hrefAttrib, scope = xmiScopes, minimizeEmpty = true )
                        Success( ns :+ hrefNode )
                      }
                  }
              }

            case cf: e.MetaCollectionEvaluator =>
              cf.evaluate( e ) match {
                case Failure( t )   => Failure( t )
                case Success( Nil ) => Success( ns )
                case Success( eRefs ) =>
                  val hRefs = eRefs flatMap { eRef =>
                    element2document.get( eRef ) match {
                      case None =>
                        System.out.println( s"*** foldCrossReference: collection=${f.propertyName} -- no document for: ${eRef.id}" )
                        None
                      case Some( dRef ) =>
                        if ( d == dRef ) None
                        else {
                          val href = dRef.uri + "#" + eRef.id
                          val externalHRef = dRef match {
                            case _: SerializableDocument[Uml] => href
                            case _: BuiltInDocument[Uml]      => builtInURIMapper.resolve( href )
                          }
                          val hrefAttrib: MetaData = new UnprefixedAttribute( key = "href", value = externalHRef, Null )
                          val hrefNode: Node = Elem( prefix = null, label = f.propertyName, attributes = hrefAttrib, scope = xmiScopes, minimizeEmpty = true )
                          hrefNode
                        }
                    }
                  }
                  Success( ns ++ hRefs )
              }
          }
      }

    def callGenerateNodeElement(
      f: e.MetaPropertyEvaluator,
      sub: UMLElement[Uml] ): Trampoline[Try[scala.xml.Node]] =
      generateNodeElement( g, element2document, elementOrdering, d, null, f.propertyName, sub, xmiScopes )

    @tailrec def trampolineSubNode(
      nodes: Trampoline[Try[Seq[Node]]],
      f: e.MetaPropertyEvaluator ): Trampoline[Try[Seq[scala.xml.Node]]] = {

      nodes.resume match {
        //        case -\/( s ) =>
        //          suspend { trampolineSubNode( s(), f ) }
        case -\/( s ) =>
          trampolineSubNode( s(), f )

        case \/-( r ) =>
          r match {
            case Failure( t ) =>
              return_ { Failure( t ) }

            case Success( ns ) =>
              f match {
                case rf: e.MetaReferenceEvaluator =>
                  rf.evaluate( e ) match {
                    case Failure( t )    => return_ { Failure( t ) }
                    case Success( None ) => return_ { Success( ns ) }
                    case Success( Some( sub ) ) =>
                      suspend {
                        append1Node( ns, callGenerateNodeElement( f, sub ) )
                      }
                  }
                case cf: e.MetaCollectionEvaluator =>
                  cf.evaluate( e ) match {
                    case Failure( t )   => return_ { Failure( t ) }
                    case Success( Nil ) => return_ { Success( ns ) }
                    case Success( subs ) =>
                      suspend {
                        val sortedSubs: List[UMLElement[Uml]] = subs.sortBy( _.xmiOrderingKey )
                        val subNodes = for { sub <- sortedSubs }
                          yield callGenerateNodeElement( f, sub )

                        val result0: Trampoline[Try[Seq[scala.xml.Node]]] = return_ { Success( ns ) }
                        val resultN = ( result0 /: subNodes )( appendNodes _ )
                        resultN
                      }
                  }
              }
          }
      }
    }

    val refEvaluators: Seq[e.MetaPropertyEvaluator] = e.referenceMetaProperties.reverse
    val subEvaluators: Seq[e.MetaPropertyEvaluator] = e.compositeMetaProperties
    val duplicates = refEvaluators.toSet.intersect( subEvaluators.toSet )
    require( duplicates.isEmpty, s"${e.xmiType} ${duplicates.size}: ${duplicates}" )

    val xmlInitReferences: Try[MetaData] = Success( Null )
    val xmlLocalReferences = ( xmlInitReferences /: refEvaluators )( foldLocalReference _ )
    ( xmlLocalReferences /: e.metaAttributes.reverse )( foldAttribute _ ) match {
      case Failure( t ) =>
        return_ { Failure( t ) }

      case Success( xmlAttributesAndLocalReferences ) =>
        suspend {
          val xRef0: Try[Seq[Node]] = Success( Seq() )
          val xRefs = ( xRef0 /: refEvaluators )( foldCrossReference _ )
          val xRefsAndSub0: Trampoline[Try[Seq[Node]]] = return_ { xRefs }
          val xRefsAndSubN = ( xRefsAndSub0 /: subEvaluators )( trampolineSubNode _ )
          wrapNodes( xRefsAndSubN, prefix, label, xmlAttributesAndLocalReferences, xmiScopes )
        }
    }
  }
}

object DocumentSet {

  val XMI_Version = "20131001"

  val XMI_ns = "http://www.omg.org/spec/XMI/20131001"
  val XSI_ns = "http://www.w3.org/2001/XMLSchema-instance"
  val UML_ns = "http://www.omg.org/spec/UML/20131001"
  val MOFEXT_ns = "http://www.omg.org/spec/MOF/20131001"

  def serializeValueSpecificationAsTagValue[Uml <: UML]( value: UMLValueSpecification[Uml] ): Try[Option[String]] =
    value match {
      case l: UMLLiteralBoolean[Uml] => Success( Some( l.value.toString ) )
      case l: UMLLiteralInteger[Uml] => Success( Some( l.value.toString ) )
      case l: UMLLiteralReal[Uml]    => Success( l.value match { case None => None; case Some( r ) => Some( r.toString ) } )
      case l: UMLLiteralString[Uml]  => Success( l.value match { case None => None; case Some( s ) => Some( s ) } )
      case iv: UMLInstanceValue[Uml] => Success( iv.instance match { case None => None; case Some( is ) => Some( is.xmiID.head ) } )
      case v                         => Failure( new IllegalArgumentException( s"No value=>string serialization support for ${v.xmiType.head} (ID=${v.xmiID.head})" ) )
    }

  def constructDocumentSetCrossReferenceGraph[Uml <: UML](
    specificationRootPackages: Set[UMLPackage[Uml]],
    documentURIMapper: CatalogURIMapper,
    builtInURIMapper: CatalogURIMapper,
    builtInDocuments: Set[BuiltInDocument[Uml]],
    valueSpecificationTagConverter: Function1[UMLValueSpecification[Uml], Try[Option[String]]],
    ignoreCrossReferencedElementFilter: Function1[UMLElement[Uml], Boolean] )( implicit ops: UMLOps[Uml] ): Try[( DocumentSet[Uml], DocumentSet[Uml]#MutableDocumentSetGraph, Map[UMLElement[Uml], Document[Uml]], Iterable[UnresolvedElementCrossReference[Uml]] )] = {

    import ops._
    val ( roots, anonymousRoots ) = specificationRootPackages partition ( _.getEffectiveURI.isDefined )
    if ( anonymousRoots.nonEmpty ) Failure( illegalElementException( "Document-level packages must have an effective URI for export", anonymousRoots ) )
    else {
      val serializableDocuments = for {
        root <- roots
        rootURI <- root.getEffectiveURI
      } yield SerializableDocument( uri = new java.net.URI( rootURI ), scope = root )

      val ds = DocumentSet( serializableDocuments, builtInDocuments, documentURIMapper, builtInURIMapper, valueSpecificationTagConverter )
      val ( g, element2document, unresolved ) = ds.externalReferenceDocumentGraph( ignoreCrossReferencedElementFilter )
      Success( ( ds, g, element2document, unresolved ) )
    }
  }
}
