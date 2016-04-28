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
package org.omg.oti.uml.read

import org.omg.oti.uml.read.api._
import scala.collection.immutable._
import scala.collection.Iterable

import scala.{Boolean,Int,Double}
import scala.Predef.{require,String}

/**
 * A TagPropertyClassifierValue is an abstraction for an individual value in a collection of values
 * for a stereotype tag property or a Profile-defined Classifier attribute property.
 *
 * A TagPropertyClassifierValue is distinguished by its lifecycle semantics with respect
 * to applying/unapplying a profile (see UML 2.5, section 12.3.3).
 *
 * There are 3 categories of such values:
 *
 * - TagPropertyProfileLifecycleIndependentClassifierValue
 *
 * Such a value is independent of applying/unapplying a profile.
 * This means the value must be a kind of Classifier instance (EnumerationLiteral or InstanceSpecification)
 * that is owned by a UML element of some kind.
 *
 * - TagPropertyPrimitiveValue
 *
 * Such a value serializes as a kind of primitive value (boolean, integer, real, string).
 *
 * - TagPropertyProfileLifecycleDependentClassifierValue.
 *
 * Such a value is dependent on applying/unapplying a profile.
 * It can be created only after applying a profile and is directly or
 * indirectly related to a stereotype tag property value.
 * It is deleted when the profile is unapplied.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
trait TagPropertyClassifierValue[Uml <: UML] {

  /**
   * The property that this is a value for.
   */
  val property: UMLProperty[Uml]

  /**
   * In case the value involves referencing elements
   * whose lifecycle is independent of applying/unapplying a profile
   * (i.e., these referenced elements are owned by UML elements,
   *  not directly or indirectly by instances of stereotypes)
   */
  val tagPropertyValueElementReferences: Iterable[UMLElement[Uml]]
}

/**
 * A Profile-defined Classifier where the value has a lifecycle that
 * is independent of applying/unapplying a profile; that is, the value
 * is a reference to a UML classifier instance owned by a UML element.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API.
 */
trait TagPropertyProfileLifecycleIndependentClassifierValue[Uml <: UML]
  extends TagPropertyClassifierValue[Uml]

/**
 * A reference to an EnumerationLiteral as the value of a stereotype tag property typed by the Enumeration
 * that is the classifier of the EnumerationLiteral. The EnumerationLiteral is owned by a UML Enumeration.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API.
 */
trait TagPropertyEnumerationLiteralValue[Uml <: UML]
  extends TagPropertyProfileLifecycleIndependentClassifierValue[Uml] {

  val value: UMLEnumerationLiteral[Uml]

  override val tagPropertyValueElementReferences
  : Iterable[UMLElement[Uml]]
  = Iterable(value)

}

/**
 * A reference to an InstanceSpecification as the value of a stereotype tag property typed by the Classifier
 * that is the classifier (or a generalization parent classifier) of the InstanceSpecification.
 * The InstanceSpecification is owned by a UML element.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API.
 */
trait TagPropertyInstanceSpecificationValue[Uml <: UML]
  extends TagPropertyProfileLifecycleIndependentClassifierValue[Uml] {

  val value: UMLInstanceSpecification[Uml]

  override val tagPropertyValueElementReferences
  : Iterable[UMLElement[Uml]]
  = Iterable(value)

}

/**
 * A Profile-defined Classifier that is semantically equivalent to one of UML's PrimitiveTypes.
 * The value is owned by the stereotype tag property value collection.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API.
 */
trait TagPropertyPrimitiveValue[Uml <: UML]
  extends TagPropertyClassifierValue[Uml] {

  /**
   * By definition, a primitive value makes no
   * reference to any element whose lifecycle is
   * independent of applying/unapplying a profile.
   */
  override val tagPropertyValueElementReferences
  : Iterable[UMLElement[Uml]] = Iterable()
}


trait TagPropertyBooleanValue[Uml <: UML]
  extends TagPropertyPrimitiveValue[Uml] {

  val value: Boolean
}

trait TagPropertyIntegerValue[Uml <: UML]
  extends TagPropertyPrimitiveValue[Uml] {

  val value: Int
}

trait TagPropertyUnlimitedNaturalValue[Uml <: UML]
  extends TagPropertyPrimitiveValue[Uml] {

  val value: Int

  require (-1 <= value)
}

trait TagPropertyRealValue[Uml <: UML]
  extends TagPropertyPrimitiveValue[Uml] {

  val value: Double
}

trait TagPropertyStringValue[Uml <: UML]
  extends TagPropertyPrimitiveValue[Uml] {

  val value: String
}

/**
 * A value for a stereotype property typed by a Profile-defined classifier
 * that has a structure and whose instances have a lifecycle semantics
 * that is tied to applying/unapplying a profile (i.e., these instance values
 * are deleted if the profile is unapplied).
 *
 * The value is directly or indirectly owned by a stereotype tag property value collection.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API.
 */
trait TagPropertyProfileLifecycleDependentClassifierValue[Uml <: UML]
  extends TagPropertyClassifierValue[Uml]

/**
 * The value is a reference to a classifier value object.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API.
 */
trait TagPropertyProfileLifecycleDependentClassifierValueReference[Uml <: UML]
  extends TagPropertyProfileLifecycleDependentClassifierValue[Uml] {

  /**
   * The referenced value object.
   */
  val value: TagPropertyProfileLifecycleDependentClassifierValueObject[Uml]
}

/**
 * A classifier value object that is an instance of a Profile-defined classifier.
 * (not a stereotype, not an extension)
 * (may be a Class, Enumeration, PrimitiveType, Datatype or Association)
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API.
 */
trait TagPropertyProfileLifecycleDependentClassifierValueObject[Uml <: UML]
  extends TagPropertyProfileLifecycleDependentClassifierValue[Uml] {

  val attributeValues: Seq[(UMLProperty[Uml], Seq[TagPropertyClassifierValue[Uml]])]

}