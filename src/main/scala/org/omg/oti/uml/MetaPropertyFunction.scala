/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml

import org.omg.oti.uml.read.api._

import scala.reflect._
import scala.language.existentials
import scala.{Any,Boolean,Int,Option,None,Some}
import scala.Predef.{require,String}
import scala.collection.immutable.{Set,Vector}
import scala.collection.Iterable
import scala.StringContext
import scalaz._, Scalaz._

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
  
  val isSerializedAsNested: Boolean
  val isSerializedAsReference: Boolean

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
   
  /**
    * For serialization, if an object is a value of a property P, then check P's subsettingMetaProperties, PS.
    * If that object is also a value of any of the subsettingMetaProperties PS, then the object should not be serialized
    * as a value of P because the object will be instead serialized as a value of one of the PS.
    */
  val subsettingMetaProperties: Set[
    _ <: MetaPropertyFunction[Uml,
      _ <: UMLElement[Uml],
      _ <: UMLElement[Uml]]]

  def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]]

  def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]]

  def evaluateTriples(e: UMLElement[Uml]): Set[java.lang.Throwable] \/ Set[RelationTriple[Uml]]
}



case class MetaPropertyReference[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]]
(override val propertyName: String,
 f: U => Option[V],
 override val isComposite: Boolean,
 override val isSerializedAsNested: Boolean=false,
 override val isSerializedAsReference: Boolean=false,
 override val isUnique: Boolean,
 override val isOrdered: Boolean,
 override val redefinedMetaProperties: Set[_ <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]],
 override val subsettingMetaProperties: Set[_ <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]])
(implicit val uType: ClassTag[U], vType: ClassTag[V])
  extends MetaPropertyFunction[Uml, U, V] {

  override val domainType = uType
  override val rangeType = vType

  val isCollection: Boolean = false

  def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]] = Some(this)

  def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]] = None

  override def evaluateTriples(e: UMLElement[Uml])
  : Set[java.lang.Throwable] \/ Set[RelationTriple[Uml]] =
    e match {
      case u: U =>
        evaluate(u)
        .flatMap { ov: Option[UMLElement[Uml]] =>
          ov
          .fold[Set[java.lang.Throwable] \/ Set[RelationTriple[Uml]]](
            Set[RelationTriple[Uml]]().right
          ){ v =>
              if (u.owner.contains(v))
                Set[RelationTriple[Uml]]().right
              else
                Set[RelationTriple[Uml]](AssociationTriple(sub=u, relf=this, obj=v)).right
          }
        }
      case x =>
        -\/(
          Set(
            UMLError
            .illegalElementError[Uml, UMLElement[Uml]](
              s"Type mismatch for evaluating $this on $x (should have been ${domainType.runtimeClass.getName})",
              Iterable(e))))
    }

  def evaluate(e: UMLElement[Uml])
  : Set[java.lang.Throwable] \/ Option[UMLElement[Uml]] =
    e match {
      case u: U =>
        f(u).right
      case _ =>
        -\/(
          Set(
            UMLError
            .illegalMetaPropertyEvaluation[Uml, UMLElement[Uml], this.type](e, this)))
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
(override val propertyName: String,
 f: U => Iterable[V],
 override val isComposite: Boolean,
 override val isSerializedAsNested: Boolean=false,
 override val isSerializedAsReference: Boolean=false,
 override val isUnique: Boolean,
 override val isOrdered: Boolean,
 override val redefinedMetaProperties: Set[_ <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]],
 override val subsettingMetaProperties: Set[_ <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]])
(implicit val uType: ClassTag[U], vType: ClassTag[V])
  extends MetaPropertyFunction[Uml, U, V] {

  override val domainType = uType
  override val rangeType = vType

  val isCollection: Boolean = true

  def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]] = None

  def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]] = Some(this)

  override def evaluateTriples(e: UMLElement[Uml])
  : Set[java.lang.Throwable] \/ Set[RelationTriple[Uml]] =
    e match {
      case u: U =>
        evaluate(u)
        .flatMap { vs =>
          (vs.toSet -- u.owner.toSet)
          .map { v => AssociationTriple(sub=u, relf=this, obj=v).asInstanceOf[RelationTriple[Uml]] }
          .right
        }
    }

  def evaluate(e: UMLElement[Uml])
  : Set[java.lang.Throwable] \/ Vector[UMLElement[Uml]] = {
    require(e != null)
    e match {
      case u: U =>
        val v = f(u)
        require(v != null)
        if (v.isEmpty)
          Vector.empty[UMLElement[Uml]].right
        else if (isOrdered)
          v.to[Vector].right
        else
          v.to[Vector].right
      case _ =>
        -\/(
          Set(
            UMLError
            .illegalMetaPropertyEvaluation[Uml, UMLElement[Uml], this.type](e, this)))
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