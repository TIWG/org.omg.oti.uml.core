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

import java.lang.Integer
import scala.{Any,Boolean,Double,Enumeration,Function1,Function2,Int,Option,None,Some,StringContext}
import scala.Predef.String
import scala.collection.Iterable
import scala.reflect._
import scala.language.existentials
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
  val f: Option[U => \/[NonEmptyList[UMLError.UException], Iterable[DT]]]
  val df: Option[(U, IDGenerator[Uml]) => \/[NonEmptyList[UMLError.UException], Iterable[DT]]]

  def evaluate
  (e: UMLElement[Uml], idg: IDGenerator[Uml])
  (implicit etag: ClassTag[UMLElement[Uml]], utag: ClassTag[U])
  : \/[NonEmptyList[UMLError.UException], Iterable[String]] =
    e match {
      case u: U =>
        (f, df) match {
          case (Some(_f), _) =>
            _f(u).map { ds => ds.map(_.toString) }
          case (None, Some(_df)) =>
            _df(u, idg).map { ds => ds.map(_.toString) }
          case _ =>
            -\/(
              NonEmptyList(
                UMLError
                .illegalMetaAttributeEvaluation[Uml, U, U, DT](u, this)))
        }
      case _ =>
        -\/(
          NonEmptyList(
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
 f1: U => \/[NonEmptyList[UMLError.UException], Option[EValue]],
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
 f1: U => \/[NonEmptyList[UMLError.UException], Iterable[Boolean]])
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
 f1: U => \/[NonEmptyList[UMLError.UException], Iterable[Integer]])
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
 f1: U => \/[NonEmptyList[UMLError.UException], Iterable[String]])
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
 f1: U => \/[NonEmptyList[UMLError.UException], Iterable[String]])
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
 f1: U => \/[NonEmptyList[UMLError.UException], Iterable[Double]])
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
 df1: (U, IDGenerator[Uml]) => \/[NonEmptyList[UMLError.UException], Iterable[String]])
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