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
package org.omg.oti.uml

import org.omg.oti.uml.read.api._
import org.omg.oti.uml.xmi.IDGenerator

import scala.reflect._
import scala.language.existentials
import scala.util.{Failure, Success, Try}
import scala.{annotation,Any,Boolean,Double,Int,Option,None,Some}
import scala.Predef.{???,require,String}
import scala.collection.immutable.{List,Nil,Seq,Set,Stream}
import scala.collection.Iterable
import scala.StringContext
import scalaz._, Scalaz._

import java.lang.Exception

/**
 * A MetaPropertyFunction provides information about properties defined on an element's metaclass
 * like MOF Reflection would.
 *
 * With MOF Reflection, given an Element E, its metaclass, MC, is: MC = E.metaclass (see MOF 9.2)
 *
 * MOF is difficult to understand because reflection is described using UML without explicitly
 * distinguishing the use of UML for semantically distinct levels of modeling.
 * Semantically, MOF requires, at minimum, distinguishing between two levels of modeling.
 * That is, the MOF architecture is fundamentally a pattern relating two levels of modeling.
 * This pattern can be stacked to yield an architecture involving multiple levels of modeling (3, 4, ...)
 *
 * The problem is that the 2-level pattern is described by reference to a single modeling language, a subset of UML.
 * For example, MOF 9.2 Reflection defines:
 *
 * Element::/metaclass: Class
 *
 * Here, Element and Class are metaclasses defined in UML; however, they belong to distinct levels of modeling.
 * An explicit distinction would be:
 *
 * [M1]Element::/metaclass: [M2]Class
 *
 * where [L]C denotes the modeling level L that a class C belongs to.
 *
 * For XMI serialization, it necessary to obtain M2-level information about M1-level elements.
 * This M2-level information involves reflective access to an element's metaclass (I.e., M2) as shown above
 * but also to the properties of M2-level metaclasses.
 *
 * See XMI2.5, ptc/14-09-21, 7.8.5 Class-typed Property Representation
 * See MOF5.2, ptc/14-09-18, 15.9 Additional Operations
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam U The metaclass on which the property is defined
 * @tparam V The metaclass that is the type of the property
 */
sealed trait MetaPropertyFunction[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]] {
  val domainType: ClassTag[U]
  val rangeType: ClassTag[V]

  val propertyName: String

  val isComposite: Boolean

  val isUnique: Boolean

  /**
   * Ordering matters for serialization per Canonical XMI ptc/2013-08-31:
   *
   * B5.3 Property Content for Class-typed Properties
   * For ordering of elements within the serialization of a class-typed property value
   * (usually an association end) where the property does not have isOrdered='true'
   * in the metamodel, the ordering is as follows:
   * - All nested elements precede all link elements (those referencing another element)
   *   Within the set of nested elements the order is alphabetically ordered by
   *   the value of the xmi:uuid.
   * - Within the set of link elements all links using xmi:idref preceded elements using href.
   *   The set of xmi:idref elements is alphabetically ordered by the value of the xmi:idref,
   *   and the set of href elements is alphabetically ordered by the value of the href.
   * B5.4 Property Content for DataType-typed Properties
   * For ordering of elements within the serialization of a data-typed property value,
   * where the property does not have isOrdered='true' in the metamodel,
   * there will be no links nor xmi:uuids and the ordering is as follows.
   * Note that for structured Datatypes the properties will be ordered as per B5.1.
   * - For structured datatypes the nested elements are alphabetically ordered by
   *   the values of their properties, taken in order
   *   (if the values of the first properties are identical the second is compared and so on)
   * - For simple datatypes the nested elements are sorted alphabetically by their values.
   * Note that alphabetic ordering is used so that, even if the property is of type Integer,
   * 10 will precede 9.
   */
  val isOrdered: Boolean

  /**
   * Canonical XMI ID generation depends on whether a property is a collection or not.
   *
   * B.6
   * 4) If the object has no identifier, or the base name (after character replacement)
   * is a duplicate of an earlier (by export order) sibling base name, then:
   * a. append underscore '_' if the last character is not already underscore '_';
   * b. append a sequence number, starting with 1 when the object has no name, and 2 if it does.
   * It is possible that an earlier sibling name contains a '_n' suffix that creates a name
   * collision. In this case increment the sequence number until no collision exists.
   */
  val isCollection: Boolean

  /**
   * Redefined properties matters for serialization per XMI 2.5 ptc/14-09-21:
   *
   * 9.4.2 CMOF Package
   * The following additional rules are defined to suppress redundant information.
   * They can be overriden using XMI tags:
   * In the case where a Property redefines another Property, only the redefining Property is serialized.
   * (Note that when serializing an instance of a concrete supertype whose
   *  Property has been redefined the supertype is unaware of the redefinition, and
   *  the Property as defined on the supertype is serialized.)
   */
  val redefinedMetaProperties: Set[
    _ <: MetaPropertyFunction[Uml,
      _ <: UMLElement[Uml],
      _ <: UMLElement[Uml]]]

  def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]]

  def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]]

  def evaluateTriples(e: UMLElement[Uml]): ValidationNel[UMLError.UException, Set[RelationTriple[Uml]]]
}



case class MetaPropertyReference[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]]
(propertyName: String,
 f: U => Option[V],
 isComposite: Boolean,
 isUnique: Boolean,
 isOrdered: Boolean,
 redefinedMetaProperties:
 Set[_ <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]] =
 Set())
(implicit val uType: ClassTag[U], vType: ClassTag[V])
  extends MetaPropertyFunction[Uml, U, V] {

  override val domainType = uType
  override val rangeType = vType

  val isCollection: Boolean = false

  def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]] = Some(this)

  def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]] = None

  override def evaluateTriples(e: UMLElement[Uml])
  : ValidationNel[UMLError.UException, Set[RelationTriple[Uml]]] =
    e match {
      case u: U =>
        evaluate(u).map { ov =>
          ov.fold[Set[RelationTriple[Uml]]](Set()) { v =>
              if (u.owner.contains(v))
                Set[RelationTriple[Uml]]()
              else
                Set[RelationTriple[Uml]](AssociationTriple(sub=u, relf=this, obj=v))
            }
        }
      case x =>
        UMLError
        .illegalElementError[Uml, UMLElement[Uml]](
          s"Type mismatch for evaluating $this on $x (should have been ${domainType.runtimeClass.getName})",
          Iterable(e))
        .failureNel
    }

  def evaluate(e: UMLElement[Uml])
  : ValidationNel[UMLError.UException, Option[UMLElement[Uml]]] =
    e match {
      case u: U =>
        f(u).successNel
      case _ =>
        UMLError
        .illegalMetaPropertyEvaluation[Uml, UMLElement[Uml], this.type](e, this)
        .failureNel
    }

  override def toString: String =
    s"MetaPropertyReference($propertyName on $uType${if (isOrdered) " {ordered}" else ""})"

  override def equals(other: Any): Boolean =
    other match {
      case that: MetaPropertyReference[Uml, _, _] =>
        (that canEqual this) &&
        propertyName == that.propertyName &&
        domainType.runtimeClass.getName == that.domainType.runtimeClass.getName &&
        rangeType.runtimeClass.getName == that.rangeType.runtimeClass.getName
      case _ =>
        false
    }

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[MetaPropertyReference[Uml, _, _]]

  override def hashCode: Int = propertyName.hashCode()
}

case class MetaPropertyCollection[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]]
(propertyName: String,
 f: U => Iterable[V],
 isComposite: Boolean,
 isUnique: Boolean,
 isOrdered: Boolean,
 redefinedMetaProperties:
 Set[_ <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]] =
 Set())
(implicit val uType: ClassTag[U], vType: ClassTag[V])
  extends MetaPropertyFunction[Uml, U, V] {

  override val domainType = uType
  override val rangeType = vType

  val isCollection: Boolean = true

  def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]] = None

  def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]] = Some(this)

  override def evaluateTriples(e: UMLElement[Uml])
  : ValidationNel[UMLError.UException, Set[RelationTriple[Uml]]] =
    e match {
      case u: U =>
        evaluate(u).map { vs =>
          (vs.toSet -- u.owner.toSet).map { v => AssociationTriple(sub=u, relf=this, obj=v) }
        }
    }

  def evaluate(e: UMLElement[Uml])
  : ValidationNel[UMLError.UException, List[UMLElement[Uml]]] = {
    require(e != null)
    e match {
      case u: U =>
        val v = f(u)
        require(v != null)
        if (v.isEmpty)
          Nil.successNel
        else if (isOrdered)
          v.toList.successNel
        else
          v.toList.successNel
      case _ =>
        UMLError
        .illegalMetaPropertyEvaluation[Uml, UMLElement[Uml], this.type](e, this)
        .failureNel
    }
  }

  override def toString: String =
    s"MetaPropertyCollection($propertyName on $uType${if (isOrdered) " {ordered}" else ""})"

  override def equals(other: Any): Boolean =
    other match {
      case that: MetaPropertyCollection[Uml, _, _] =>
        (that canEqual this) &&
        propertyName == that.propertyName &&
        domainType.runtimeClass.getName == that.domainType.runtimeClass.getName &&
        rangeType.runtimeClass.getName == that.rangeType.runtimeClass.getName
      case _ =>
        false
    }

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[MetaPropertyCollection[Uml, _, _]]

  override def hashCode: Int = propertyName.hashCode()
}
