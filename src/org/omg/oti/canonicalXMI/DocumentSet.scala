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
  val builtInURIMapper: CatalogURIMapper )( implicit val ops: UMLOps[Uml] ) {

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
  def resolve( ignoreCrossReferencedElementFilter: UMLElement[Uml] => Boolean ): ( ResolvedDocumentSet[Uml], Iterable[UnresolvedElementCrossReference[Uml]] ) = {

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
      eRef <- e.allForwardReferencesToElements
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

    ( ResolvedDocumentSet( this, g, element2document ), unresolved.flatten )
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
    ignoreCrossReferencedElementFilter: Function1[UMLElement[Uml], Boolean] )( implicit ops: UMLOps[Uml] ): Try[( ResolvedDocumentSet[Uml], Iterable[UnresolvedElementCrossReference[Uml]] )] = {

    import ops._
    val ( roots, anonymousRoots ) = specificationRootPackages partition ( _.getEffectiveURI.isDefined )
    if ( anonymousRoots.nonEmpty ) Failure( illegalElementException( "Document-level packages must have an effective URI for export", anonymousRoots ) )
    else {
      val serializableDocuments = for {
        root <- roots
        rootURI <- root.getEffectiveURI
      } yield SerializableDocument( 
          uri = new java.net.URI( rootURI ), 
          nsPrefix = IDGenerator.xmlSafeID(root.name.get), 
          scope = root )

      val ds = DocumentSet( serializableDocuments, builtInDocuments, documentURIMapper, builtInURIMapper )
      Success( ds.resolve( ignoreCrossReferencedElementFilter ) )
    }
  }
}
