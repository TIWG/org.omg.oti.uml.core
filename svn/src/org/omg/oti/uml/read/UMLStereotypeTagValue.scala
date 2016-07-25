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

import org.omg.oti.uml.xmi.IDGenerator
import org.omg.oti.uml.read.api.UML
import org.omg.oti.uml.read.api.UMLElement
import org.omg.oti.uml.read.api.UMLProperty
import org.omg.oti.uml.read.api._

import scala.collection.Iterable
import scala.collection.immutable.Set
import scalaz._

/**
 * An abstraction for the value of a stereotype "tag property".
 *
 * The UML specification avoids defining an abstract syntax for
 * instances of stereotypes and values of stereotype "tag properties".
 * The motivation is to avoid over-committing the specification and provide
 * flexibility for implementing the UML specification.
 *
 * This unfortunately results in a specification that is very complicated
 * to understand and that allows multiple interpretations of the Profile mechanism.
 * In particular, see UML 2.5, section 12.3.3, Semantics, Profiles:
 *
 * -------------------------------
 *
 * A Profile can define or import Classes, Associations, DataTypes,
 * PrimitiveTypes and Enumerations as well as Stereotypes.
 * More precisely all the constraints of a CMOF-compliant metamodel apply to a UML Profile.
 * These are defined in detail in Section 14.4 of the MOF Core Specification.
 * The effect of these constraints is that, except for Stereotypes and Extensions,
 * all other Types defined or imported in a Profile must be exactly one of
 * the Types explicitly mentioned in the above subset and that no specialization outside
 * this subset is allowed.
 * The term Profile-defined Type corresponds to a CMOF-compliant Class, Association,
 * DataType, PrimitiveType or Enumeration defined or imported in a Profile.
 *
 * Profile-defined Types can only be used as the type of Properties
 * in that Profile or as a general classifier of another Profile-defined Type.
 * They cannot be used as Types in models the Profile is applied to,
 * such as the type of a TypedElement, the classifier of an InstanceSpecification or
 * the general or specific classifier in a Generalization relationship.
 * It is however possible to define these types in separate Packages and
 * import them as needed in both Profiles and model Packages in order to use them for both purposes.
 * --------------------------------
 *
 * What are these purposes?
 *
 * Unfortunately, the UML 2.5 specification did not clarify what the purposes are
 * nor how they are affected by the semantics of Profiles.
 *
 * The UML 2.5 specification should clarify the different purposes
 * for the type of a stereotype property that is:
 *
 * - a scalar datatype:
 * the value is semantically equivalent to a literal specification
 * (the value is tied to the lifecycle of applying/unapplying a profile)
 *
 * - a structured datatype:
 * the value is semantically equivalent to an instance specification with slot/values for
 * individual attributes of the datatype
 * (the value is tied to the lifecycle of applying/unapplying a profile)
 *
 * - a metaclass:
 * the value is an element in the model that is unaffected by applying/unapplying a profile
 *
 * - a stereotype:
 * the value is an instance of a stereotype applied to an element; this value is tied
 * to the lifecycle of applying/unapplying a profile
 *
 * - a class or association:
 * The 2nd paragraph above implies that an instance of such a class or association could
 * be either in the model or part of the lifecycle of applying/unapplying a profile
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
trait UMLStereotypeTagValue[Uml <: UML] {

  /**
   * The element on which the stereotype is applied.
   */
  val extendedElement: UMLElement[Uml]

  /**
   * The stereotype applied to the extendedElement.
   */
  val appliedStereotype: UMLStereotype[Uml]

  /**
   * The stereotype property.
   */
  val stereotypeTagProperty: UMLProperty[Uml]

  /**
   * The type of the stereotype property.
   */
  val stereotypeTagPropertyType: UMLType[Uml]

  /**
   * In some cases, the value of a "tag property" refers to elements
   * that are "in the model" in the sense that such elements
   * are unaffected by applying/unapplying a profile.
   */
  val tagPropertyValueElementReferences: Iterable[UMLElement[Uml]]

  /**
   * Although the UML specification avoids defining the abstract syntax for
   * stereotype tag property values, the serialization is in scope of
   * the specification. Whereas the UML specification only defines
   * this serialization by examples, OTI must delegate the serialization to
   * the tool-specific adaptation layer since the representation of stereotype tag property values
   * is tool-specific.
   *
   * @return OMG UML 2.5 compliant serialization of stereotype tag property values.
   */
  def serialize
  ( implicit xmiScopes: scala.xml.NamespaceBinding, idg: IDGenerator[Uml] )
  : Set[java.lang.Throwable] \/ Iterable[scala.xml.Elem]
}

/**
 * The value of a stereotype property that has an opposite extension end property.
 * Its value is ``extendedElement``.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API.
 */
trait UMLStereotypeTagExtendedMetaclassPropertyElementReference[Uml <: UML]
  extends UMLStereotypeTagValue[Uml] {

  /**
   * The stereotype tag property is typed by a UML Class in the UML metamodel.
   * This stereotype property is the opposite of an extension end property.
   */
  override val stereotypeTagPropertyType: UMLClass[Uml]

  /**
   * By definition, a 'base_...' stereotype property references only the `extendedElement`.
   * There is no other referenced element.
   */
  override val tagPropertyValueElementReferences: Iterable[UMLElement[Uml]] = Iterable(extendedElement)

}

/**
 * A stereotype property typed by a UML metaclass.
 * This stereotype property is not the opposite of an extension end property.
 * Its value is the collection ``tagPropertyValueElementReferences``.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API.
 */
trait UMLStereotypeTagPropertyMetaclassElementReference[Uml <: UML]
  extends UMLStereotypeTagValue[Uml] {

  /**
   * The stereotype tag property is typed by a UML Class in the UML metamodel.
   * This stereotype property is not the opposite of an extension end property.
   */
  override val stereotypeTagPropertyType: UMLClass[Uml]

  override val tagPropertyValueElementReferences: Iterable[UMLElement[Uml]]

}

/**
 * A stereotype property typed by a Profile-defined Stereotype.
 *
 * The serialization is a reference to an instance of a stereotype.
 *
 * The value refers to an applied stereotype instance extending an element;
 * tagPropertyValueElementReferences is a singleton collection of that element.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API.
 */
trait UMLStereotypeTagStereotypeInstanceValue[Uml <: UML]
  extends UMLStereotypeTagValue[Uml] {

  /**
   * The stereotype tag property is typed by a UML Stereotype.
   */
  override val stereotypeTagPropertyType: UMLStereotype[Uml]

}

/**
 * A stereotype property typed by a Profile-defined Classifier.
 * (not Stereotype, not Extension)
 * (maybe a PrimitiveType, Enumeration, DataType, Class, Association)
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API.
 */
trait UMLStereotypeTagPropertyClassifierValue[Uml <: UML]
  extends UMLStereotypeTagValue[Uml] {

  override val stereotypeTagPropertyType: UMLClassifier[Uml]

  val values: Iterable[TagPropertyClassifierValue[Uml]]

  override val tagPropertyValueElementReferences: Iterable[UMLElement[Uml]] =
    for {
      value <- values
      ref <- value.tagPropertyValueElementReferences
    } yield ref

}