/*
 *
 * License Terms
 *
 * Copyright (c) 2014-2016, California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * *   Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * *   Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the
 *    distribution.
 *
 * *   Neither the name of Caltech nor its operating division, the Jet
 *    Propulsion Laboratory, nor the names of its contributors may be
 *    used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml.write

import org.omg.oti.uml._
import org.omg.oti.uml.read.api._

import scala.{Enumeration,Option,None,Some,StringContext,Unit}
import scala.Predef.{???,String}
import scala.collection.immutable._
import scala.collection.Iterable
import scala.reflect._
import scala.util.control.Exception._
import scalaz._, Scalaz._


/**
 * UMLPropertyUpdater supports
 * 1) creating/deleting link instances of a composite association
 * 2) creating/deleting link instances of a reference association
 *
 * Unfortunately, the names of UML associations is not necessarily consistent with that of the association ends.
 * Differences include:
 * - ordering (e.g., an association from end1 to end2 is sometimes named A_end1_end2 or A_end2_end1)
 * - redefinitions (e.g., there would be name conflicts if the association were to be named according to
 *   the names of its member ends so the association name is different)
 *
 * To avoid these problems and make the API more "litterate", the naming scheme is:
 *
 * For (1)
 * links_<metaclass1>_<end1>_compose_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2TypeOrCollection>): Set[java.lang.Throwable] \/ Unit
 *
 * For (3)
 * links_<metaclass1>_<end1>_reference_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2TypeOrCollection>): Set[java.lang.Throwable] \/ Unit
 *
 * This is done for all non-derived, non-abstract associations whose member ends have each an upper bound > 0
 *
 * The rationale for this association API is to provide flexibility in adapting the OTI UML API
 * to existing implementations of OMG UML 2.5. Even though the OMG defined UML 2.5 as a CMOF metamodel,
 * the UML specification does not explicitly require that a compliant implementation provides API-level
 * support for link-related operations defined in MOF 2.5 (see section 15, CMOF Abstract Semantics).
 * 
 * MOF 2.5 is inconsistent about the semantics of link instances of CMOF metamodel associations.
 *
 * 13.2 (Link) Semantics states:
 * When a Link is created, it is not inserted into any Extent.
 * When one or more ends of the Association are ordered, links carry ordering information in addition to their end values.
 * 
 * The first point contradicts the operations defined for a CMOF Extent (13.7):
 * 
 * linksOfType(type : Association, includesSubtypes : Boolean) : Link[0..*]
 * This returns those links in the extent that are instances of the supplied Association, 
 * or of any of its subclasses if includesSubtypes is true.
 * 
 * The second point (carrying ordering information) is not reflected in the CMOF abstract syntax (section 13)
 * or in the CMOF abstract semantics (section 15)
 *
 * On a practical level, several implementations of OMG UML 2.5 do not expose link instances of their UML 2.5 metamodel.
 * In fact, implementations that use the Eclipse EMF framework (e.g., Eclipse, MagicDraw) typically 
 * do not have Associations either because Associations are not explicitly supported in Eclipse EMF ecore metamodels. 
 * That is, such implementations effectively treat UML as an EMOF metamodel and instead encode the semantics
 * of CMOF associations as part of the API for managing Class-owned association end properties.
 */
trait UMLPropertyUpdater[Uml <: UML] 
extends UMLAttributeUpdater[Uml] {
  
  // was: MetaPropertyCompositeFunctionQuery
  type AssociationMetaPropertyFunctionQuery =
  MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]

  // was: MetaPropertyCompositeReferenceQuery
  type AssociationMetaPropertyReferenceQuery =
  MetaPropertyReference[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]

  // was: CompositeReferenceSingleUpdate
  trait AssociationMetaPropertyUpdater {

    def link(owner: UMLElement[Uml], owned: UMLElement[Uml]): Set[java.lang.Throwable] \/ Unit
    
    def unlink(owner: UMLElement[Uml], owned: UMLElement[Uml]): Set[java.lang.Throwable] \/ Unit
  }

  // was: CompositeReferenceUpdater
  trait AssociationMetaPropertyOptionUpdater extends AssociationMetaPropertyUpdater {
    val links_query: AssociationMetaPropertyReferenceQuery
    def setLinks(owner: UMLElement[Uml], owned: Option[UMLElement[Uml]]): Set[java.lang.Throwable] \/ Unit
  }

  // was: CompositeReferenceUpdate
  case class AssociationMetaPropertyOptionUpdateInfo[U <: UMLElement[Uml], V <: UMLElement[Uml]]
  ( links_composes: (U, Option[V]) => \/[Set[java.lang.Throwable], Unit],
    override val links_query: AssociationMetaPropertyReferenceQuery )
  ( implicit utag: ClassTag[U], vtag: ClassTag[V])
    extends AssociationMetaPropertyOptionUpdater {

    override def setLinks(owner: UMLElement[Uml], owned: Option[UMLElement[Uml]])
    : Set[java.lang.Throwable] \/ Unit 
    = owner match {
        case u: U =>
          owned.fold[Set[java.lang.Throwable] \/ Unit]{
            links_composes(u, None)
          }{
            case v: V =>
              links_composes(u, Some(v))
            case _ =>
              Set(
                UMLError.illegalElementError[Uml, UMLElement[Uml]](
                  s"setLinks update for $links_query: error type mismatch",
                  Iterable(owner) ++ owned.toIterable)).left
          }
        case _ =>
          Set(
            UMLError.illegalElementError[Uml, UMLElement[Uml]](
            s"setLinks update for $links_query: error type mismatch",
            Iterable(owner) ++ owned.toIterable)).left
      }

    override def link(owner: UMLElement[Uml], owned: UMLElement[Uml])
    : Set[java.lang.Throwable] \/ Unit 
    = setLinks(owner, Some(owned))
    
    override def unlink(owner: UMLElement[Uml], owned: UMLElement[Uml])
    : Set[java.lang.Throwable] \/ Unit 
    = links_query
      .evaluate(owner)
      .flatMap { current =>
        if (current.contains(owned))
          setLinks(owner, None)
        else
          Set(UMLError.illegalElementError[Uml, UMLElement[Uml]](
            s"unlink error for $links_query",
            Seq(owner, owned))).left       
      }
    
  }

  // was: MetaPropertyCompositeCollectionQuery
  type AssociationMetaPropertyCollectionQuery =
  MetaPropertyCollection[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]

  // was: CompositeIterableUpdater
  trait AssociationMetaPropertyIterableUpdater extends AssociationMetaPropertyUpdater {
    val links_query: AssociationMetaPropertyCollectionQuery
    def setLinks(owner: UMLElement[Uml], owned: Iterable[UMLElement[Uml]])
    : Set[java.lang.Throwable] \/ Unit
  }

  // was: CompositeIterableUpdate
  case class AssociationMetaPropertyIterableUpdateInfo[U <: UMLElement[Uml], V <: UMLElement[Uml]]
  ( links_composes: (U, Iterable[V]) => \/[Set[java.lang.Throwable], Unit],
    override val links_query: AssociationMetaPropertyCollectionQuery )
  ( implicit utag: ClassTag[U], vtag: ClassTag[V])
    extends AssociationMetaPropertyIterableUpdater {

    override def setLinks(owner: UMLElement[Uml], owned: Iterable[UMLElement[Uml]])
    : Set[java.lang.Throwable] \/ Unit 
    = (owner, owned) match {
        case (u: U, v: Iterable[V]) =>
          links_composes(u, v)
        case _ =>
          Set(
            UMLError.illegalElementError[Uml, UMLElement[Uml]](
            s"setLinks update for $links_query: error type mismatch",
            Iterable(owner) ++ owned.toIterable)).left
      }

    override def link(owner: UMLElement[Uml], owned: UMLElement[Uml])
    : Set[java.lang.Throwable] \/ Unit
    = links_query.evaluate(owner)
      .flatMap { composed =>
        val updated = if (composed.contains(owned)) composed else composed :+ owned
        setLinks(owner, updated)
      }

    override def unlink(owner: UMLElement[Uml], owned: UMLElement[Uml])
    : Set[java.lang.Throwable] \/ Unit
    = links_query.evaluate(owner)
      .flatMap { composed =>
        val index = composed.indexOf(owned)
        if (index < 0)
          Set(
            UMLError.illegalElementError[Uml, UMLElement[Uml]](
            s"setLinks update for $links_query: error type mismatch",
            Seq(owner, owned))).left
        else {          
          val (left, right) = composed.splitAt(index)
          val updated = left ::: right.drop(1)
          setLinks(owner, updated)
        }
      }
  }

  // was: CompositeSequenceUpdater
  trait AssociationMetaPropertySequenceUpdater extends AssociationMetaPropertyUpdater {
    val links_query: AssociationMetaPropertyCollectionQuery
    def setLinks(owner: UMLElement[Uml], owned: Seq[UMLElement[Uml]])
    : Set[java.lang.Throwable] \/ Unit
  }

  // was: CompositeSequenceUpdate
  case class AssociationMetaPropertySequenceUpdateInfo[U <: UMLElement[Uml], V <: UMLElement[Uml]]
  ( links_composes: (U, Seq[V]) => \/[Set[java.lang.Throwable], Unit],
    override val links_query: AssociationMetaPropertyCollectionQuery )
  ( implicit utag: ClassTag[U], vtag: ClassTag[V])
    extends AssociationMetaPropertySequenceUpdater {

    override def setLinks(owner: UMLElement[Uml], owned: Seq[UMLElement[Uml]])
    : Set[java.lang.Throwable] \/ Unit 
    = (owner, owned) match {
        case (u: U, v: Seq[V]) =>
          links_composes(u, v)
        case _ =>
          Set(
            UMLError.illegalElementError[Uml, UMLElement[Uml]](
              s"setLinks update for $links_query: error type mismatch",
              Iterable(owner) ++ owned.toIterable)).left
      }

    override def link(owner: UMLElement[Uml], owned: UMLElement[Uml])
    : Set[java.lang.Throwable] \/ Unit
    = links_query
      .evaluate(owner)
      .flatMap { composed =>
        val updated = if (composed.contains(owned)) composed else composed :+ owned
        setLinks(owner, updated)
      }

    override def unlink(owner: UMLElement[Uml], owned: UMLElement[Uml])
    : Set[java.lang.Throwable] \/ Unit
    = links_query
      .evaluate(owner)
      .flatMap { composed =>
        val index = composed.indexOf(owned)
        if (index < 0)
          Set(
            UMLError.illegalElementError[Uml, UMLElement[Uml]](
            s"setLinks update for $links_query: error type mismatch",
            Seq(owner, owned))).left
        else {          
          val (left, right) = composed.splitAt(index)
          val updated = left ::: right.drop(1)
          setLinks(owner, updated)
        }
      }
  }

  // was: CompositeSetUpdater
  trait AssociationMetaPropertySetUpdater extends AssociationMetaPropertyUpdater {
    val links_query: AssociationMetaPropertyCollectionQuery
    def setLinks(owner: UMLElement[Uml], owned: Iterable[UMLElement[Uml]])
    : Set[java.lang.Throwable] \/ Unit
  }

  // was: CompositeSetUpdate
  case class AssociationMetaPropertySetUpdateInfo[U <: UMLElement[Uml], V <: UMLElement[Uml]]
  ( links_composes: (U, Set[V]) => \/[Set[java.lang.Throwable], Unit],
    override val links_query: AssociationMetaPropertyCollectionQuery)
  ( implicit utag: ClassTag[U], vtag: ClassTag[V])
    extends AssociationMetaPropertySetUpdater {

    override def setLinks(owner: UMLElement[Uml], owned: Iterable[UMLElement[Uml]])
    : Set[java.lang.Throwable] \/ Unit
    = (owner, owned) match {
        case (u: U, v: Iterable[V]) =>
          links_composes(u, v.toSet)
        case _ =>
          Set(
            UMLError
          .illegalElementError[Uml, UMLElement[Uml]](
            s"setLinks update for $links_query: error type mismatch",
            Iterable(owner) ++ owned.toIterable)).left
      }

    override def link(owner: UMLElement[Uml], owned: UMLElement[Uml])
    : Set[java.lang.Throwable] \/ Unit 
    = links_query
      .evaluate(owner)
      .flatMap { composed =>
        val updated = if (composed.contains(owned)) composed else composed :+ owned
        setLinks(owner, updated)
      }

    override def unlink(owner: UMLElement[Uml], owned: UMLElement[Uml])
    : Set[java.lang.Throwable] \/ Unit 
    = links_query
      .evaluate(owner)
      .flatMap { composed =>
        val index = composed.indexOf(owned)
        if (index < 0)
          Set(
            UMLError.illegalElementError[Uml, UMLElement[Uml]](
            s"setLinks update for $links_query: error type mismatch",
            Seq(owner, owned))).left
        else {          
          val (left, right) = composed.splitAt(index)
          val updated = left ::: right.drop(1)
          setLinks(owner, updated)
        }
      }

  }

  def nonFatalCatchUMLException[E <: UMLElement[Uml]]
  (e: E,
   message: String,
   action: => Unit)
  : Set[java.lang.Throwable] \/ Unit
  = nonFatalCatch[Unit]
    .withApply{
      (cause: java.lang.Throwable) =>
        Set(
          UMLError
            .umlUpdateException[Uml, UMLElement[Uml]](
            this, Iterable(e),
            s"Error during $message on $e: ${cause.getMessage}",
            cause))
          .left
    }
    .apply(\/-(action))
}