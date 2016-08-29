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

import org.omg.oti.uml.characteristics.OTICharacteristicsProvider
import org.omg.oti.uml.read.api._

import java.lang.Integer
import scala.{Any,Boolean,Double,Enumeration,Int,Option,None,Some,StringContext}
import scala.Predef.String
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.reflect._
import scala.reflect.runtime.universe._

import scalaz._, Scalaz._

sealed trait ConstructorKind
case class OptionConstructor() extends ConstructorKind
case class IterableConstructor() extends ConstructorKind

/**
 * A functional wrapper for a UML Property typed by a PrimitiveType
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam U An OTI UML metaclass
 * @tparam DT A value type corresponding to a UML PrimitiveType
 */
sealed trait MetaAttributeAbstractFunction[Uml <: UML, U <: UMLElement[Uml], DT] {
  implicit val UType: TypeTag[U]
  val attributePrefix: Option[String]
  val attributeName: String
  val f: Option[U => \/[Set[java.lang.Throwable], Iterable[DT]]]
  val df: Option[(U, OTICharacteristicsProvider[Uml]) => \/[Set[java.lang.Throwable], Iterable[DT]]]

  def evaluate
  (e: UMLElement[Uml], otiCharacteristicsProvider: OTICharacteristicsProvider[Uml])
  (implicit etag: ClassTag[UMLElement[Uml]], utag: ClassTag[U])
  : Set[java.lang.Throwable] \/ Iterable[String]
  = e match {
      case u: U =>
        (f, df) match {
          case (Some(_f), _) =>
            _f(u).map { ds => ds.map(_.toString) }
          case (None, Some(_df)) =>
            _df(u, otiCharacteristicsProvider).map { ds => ds.map(_.toString) }
          case _ =>
            -\/(
              Set(
                UMLError
                .illegalMetaAttributeEvaluation[Uml, U, U, DT](u, this)))
        }
      case _ =>
        -\/(
          Set(
            UMLError
            .illegalMetaAttributeEvaluation[Uml, UMLElement[Uml], U, DT](e, this)))
    }

  override def toString: String = {
    val attributeQName: String =
      attributePrefix
      .fold[String](attributeName) { ns =>
        ns + ":" + attributeName
      }
    s"MetaAttribute($attributeQName on ${UType.getClass.getName})"
  }

}


/**
 * A functional wrapper for a UML Property typed by an Enumeration
 *
 * @param attributePrefix optionally, a namespace prefix for the attribute property
 * @param attributeName the name of the attribute property
 * @param f1 the query operation corresponding to the attribute property
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam U An OTI UML metaclass
 */
case class MetaAttributeEnumerationFunction[Uml <: UML, U <: UMLElement[Uml], EValue <: Enumeration#Value, EValueSet <: Enumeration#ValueSet]
(attributePrefix: Option[String],
 attributeName: String,
 f1: U => \/[Set[java.lang.Throwable], Option[EValue]],
 orderedEnumerationValues: EValueSet)
  extends MetaAttributeAbstractFunction[Uml, U, EValue] {
  implicit val UType: TypeTag[U] = typeTag[U]
  override val f = Some((x: U) => f1(x).map(_.toIterable))
  override val df = None

  def this
  (ctr: OptionConstructor,
   attributePrefix: Option[String],
   attributeName: String,
   f1: U => Option[EValue],
   orderedEnumerationValues: EValueSet) {
    this(attributePrefix, attributeName, (u:U) => f1(u).right, orderedEnumerationValues)
  }

  override def equals(other: Any): Boolean =
    other match {
      case that: MetaAttributeEnumerationFunction[Uml, _, _, _] =>
        (that canEqual this) &&
        attributePrefix == that.attributePrefix &&
        attributeName == that.attributeName
      case _ =>
        false
    }

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[MetaAttributeEnumerationFunction[Uml, _, _, _]]

  override def hashCode: Int =
    41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
}

/**
 * A functional wrapper for a UML Property typed by a Boolean PrimitiveType
 *
 * @param attributePrefix optionally, a namespace prefix for the attribute property
 * @param attributeName the name of the attribute property
 * @param f1 the query operation corresponding to the attribute property
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam U An OTI UML metaclass
 */
case class MetaAttributeBooleanFunction[Uml <: UML, U <: UMLElement[Uml]]
(attributePrefix: Option[String],
 attributeName: String,
 f1: U => \/[Set[java.lang.Throwable], Iterable[Boolean]])
  extends MetaAttributeAbstractFunction[Uml, U, Boolean] {
  implicit val UType: TypeTag[U] = typeTag[U]
  override val f = Some(f1)
  override val df = None

  def this(ctr: IterableConstructor, attributePrefix: Option[String], attributeName: String, f1: U => Iterable[Boolean]) {
    this(attributePrefix, attributeName, (u:U) => f1(u).right)
  }

  override def equals(other: Any): Boolean =
    other match {
      case that: MetaAttributeBooleanFunction[Uml, _] =>
        (that canEqual this) &&
        attributePrefix == that.attributePrefix &&
        attributeName == that.attributeName
      case _ =>
        false
    }

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[MetaAttributeBooleanFunction[Uml, _]]

  override def hashCode: Int =
    41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
}

/**
 * A functional wrapper for a UML or MOF Property typed by an Integer PrimitiveType
 *
 * @param attributePrefix optionally, a namespace prefix for the UML or MOF attribute property
 * @param attributeName the name of the UML or MOF attribute property
 * @param f1 the query operation corresponding to the UML or MOF attribute property
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam U An OTI UML metaclass
 */
case class MetaAttributeIntegerFunction[Uml <: UML, U <: UMLElement[Uml]]
(attributePrefix: Option[String],
 attributeName: String,
 f1: U => \/[Set[java.lang.Throwable], Iterable[Integer]])
  extends MetaAttributeAbstractFunction[Uml, U, Integer] {
  implicit val UType: TypeTag[U] = typeTag[U]
  override val f = Some(f1)
  override val df = None

  override def equals(other: Any): Boolean =
    other match {
      case that: MetaAttributeIntegerFunction[Uml, _] =>
        (that canEqual this) &&
        attributePrefix == that.attributePrefix &&
        attributeName == that.attributeName
      case _ =>
        false
    }

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[MetaAttributeIntegerFunction[Uml, _]]

  override def hashCode: Int =
    41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
}

/**
 * A functional wrapper for a UML Property typed by an UnlimitedNatural PrimitiveType
 *
 * @param attributePrefix optionally, a namespace prefix for the UML attribute property
 * @param attributeName the name of the UML attribute property
 * @param f1 the query operation corresponding to the UML attribute property
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam U An OTI UML metaclass
 */
case class MetaAttributeUnlimitedNaturalFunction[Uml <: UML, U <: UMLElement[Uml]]
(attributePrefix: Option[String],
 attributeName: String,
 f1: U => \/[Set[java.lang.Throwable], Iterable[String]])
  extends MetaAttributeAbstractFunction[Uml, U, String] {
  implicit val UType: TypeTag[U] = typeTag[U]
  override val f = Some(f1)
  override val df = None

  override def equals(other: Any): Boolean =
    other match {
      case that: MetaAttributeIntegerFunction[Uml, _] =>
        (that canEqual this) &&
        attributePrefix == that.attributePrefix &&
        attributeName == that.attributeName
      case _ =>
        false
    }

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[MetaAttributeIntegerFunction[Uml, _]]

  override def hashCode: Int =
    41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
}

/**
 * A functional wrapper for a UML Property typed by a String PrimitiveType
 *
 * @param attributePrefix optionally, a namespace prefix for the UML attribute property
 * @param attributeName the name of the UML attribute property
 * @param f1 the query operation corresponding to the UML attribute property
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam U An OTI UML metaclass
 */
case class MetaAttributeStringFunction[Uml <: UML, U <: UMLElement[Uml]]
(attributePrefix: Option[String],
 attributeName: String,
 f1: U => \/[Set[java.lang.Throwable], Iterable[String]])
  extends MetaAttributeAbstractFunction[Uml, U, String] {
  implicit val UType: TypeTag[U] = typeTag[U]
  override val f = Some(f1)
  override val df = None

  def this(ctr: OptionConstructor, attributePrefix: Option[String], attributeName: String, f1: U => Option[String]) {
    this(attributePrefix, attributeName, (u:U) => f1(u).toIterable.right)
  }

  def this(ctr: IterableConstructor, attributePrefix: Option[String], attributeName: String, f1: U => Iterable[String]) {
    this(attributePrefix, attributeName, (u:U) => f1(u).right)
  }

  override def equals(other: Any): Boolean =
    other match {
      case that: MetaAttributeStringFunction[Uml, _] =>
        (that canEqual this) &&
        attributePrefix == that.attributePrefix &&
        attributeName == that.attributeName
      case _ =>
        false
    }

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[MetaAttributeStringFunction[Uml, _]]

  override def hashCode: Int =
    41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
}

/**
 * A functional wrapper for a UML Property typed by a Real PrimitiveType
 *
 * @param attributePrefix optionally, a namespace prefix for the UML attribute property
 * @param attributeName the name of the UML attribute property
 * @param f1 the query operation corresponding to the UML attribute property
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam U An OTI UML metaclass
 */
case class MetaAttributeRealFunction[Uml <: UML, U <: UMLElement[Uml]]
(attributePrefix: Option[String],
 attributeName: String,
 f1: U => \/[Set[java.lang.Throwable], Iterable[Double]])
  extends MetaAttributeAbstractFunction[Uml, U, Double] {
  implicit val UType: TypeTag[U] = typeTag[U]
  override val f = Some(f1)
  override val df = None

  override def equals(other: Any): Boolean =
    other match {
      case that: MetaAttributeRealFunction[Uml, _] =>
        (that canEqual this) &&
        attributePrefix == that.attributePrefix &&
        attributeName == that.attributeName
      case _ =>
        false
    }

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[MetaAttributeRealFunction[Uml, _]]

  override def hashCode: Int =
    41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
}

/**
 * A functional wrapper for a MOF attribute property typed by a String PrimitiveType
 *
 * @param attributePrefix optionally, a namespace prefix for the MOF attribute property
 * @param attributeName the name of the MOF attribute property
 * @param df1 the query operation corresponding to the MOF attribute property
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam U An OTI UML metaclass
 */
case class MetaDocumentAttributeStringFunction[Uml <: UML, U <: UMLElement[Uml]]
(attributePrefix: Option[String],
 attributeName: String,
 df1: (U, OTICharacteristicsProvider[Uml]) => \/[Set[java.lang.Throwable], Iterable[String]])
  extends MetaAttributeAbstractFunction[Uml, U, String] {
  implicit val UType: TypeTag[U] = typeTag[U]
  override val f = None
  override val df = Some(df1)

  override def equals(other: Any): Boolean =
    other match {
      case that: MetaDocumentAttributeStringFunction[Uml, _] =>
        (that canEqual this) &&
        attributePrefix == that.attributePrefix &&
        attributeName == that.attributeName
      case _ =>
        false
    }

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[MetaDocumentAttributeStringFunction[Uml, _]]

  override def hashCode: Int =
    41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
}