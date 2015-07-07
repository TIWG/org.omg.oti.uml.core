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
package org.omg.oti.uml.read

import org.omg.oti.uml.read.api.UML
import org.omg.oti.uml.read.api.UMLElement
import org.omg.oti.uml.read.api.UMLEnumerationLiteral
import org.omg.oti.uml.read.api.UMLProperty
import org.omg.oti.uml.read.api._

import scala.util.Try

/**
 * An abstraction for the value of a stereotype "tag property"
 *
 * The UML 2.5 specification should clarify that a Stereotype properties can be partitioned into two disjoint sets:
 *
 * 1) Properties that have an opposite ExtensionEnd Property
 *
 * Such properties can have only one value: the element on which the stereotype owning the property is applied.
 * In OTI, values of such properties are wrapped as: UMLStereotypeExtendedMetaclassTagValue
 *
 * 2) Properties that do not have an opposite ExtensionEnd Property
 *
 * The UML specification only describes the serialization of such values; it avoids
 * committing to specifying the abstract syntax of this information.
 * In OTI, values of such properties are wrapped as: UMLStereotypePropertyTagValue
 *
 * @tparam Uml A tool-specific implementation of OMG UML
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
   * The stereotype property -- can be (1) or (2)
   */
  val stereotypeTagProperty: UMLProperty[Uml]

  /**
   * The type of the stereotype property
   */
  val stereotypeTagPropertyType: UMLType[Uml]

  /**
   * A stereotype tag property may be typed by a UML metaclass,
   * in which case its value references UML elements.
   */
  val tagPropertyValueElementReferences: Iterable[UMLElement[Uml]]

  /**
   * Does the OTI adapter for the tool-specific implementation of OMG UML
   * provide support for representing values of a stereotype tag property?
   *
   * It is important to distinguish between defining and using a profile.
   * Most OMG UML compliant modeling tools support defining arbitrary profiles.
   * (e.g., see UML 2.5, section 12.5, Figure 12.32)
   *
   * However, there is uneven support for using profiles and serializing them properly.
   * (e.g., see UML 2.5, section 12.5, Figure 12.33)
   *
   * The variability in support stems from the expressiveness of the profile definition.
   *
   * For example, profiles with stereotypes extending a single metaclasse, no stereotype tag properties
   * and no stereotype specializations could be categorized as the simplest category of profile expressiveness.
   * In that case, the example in UML 2.5, section 12.5, Figure 12.32 would belong to a different category
   * of advanced profile expressiveness (stereotype specializations, stereotype properties typed by other stereotypes,
   * stereotype associations, stereotype properties typed by profile-defined classes/datatypes).
   *
   */
  val isSupported: Boolean

  /**
   * Although the UML specification avoids defining the abstract syntax for
   * stereotype tag property values, the serialization is in scope of
   * the specification. Whereas the UML specification only defines
   * this serialization by examples, OTI must delegate the serialization to
   * the tool-specific adaptation layer since the representation of stereotype tag property values
   * is tool-specific.
   *
   * @return OMG UML 2.5 compliant serialization of stereotype tag property values
   */
  def serialize( implicit xmiScopes: scala.xml.NamespaceBinding ): Try[Iterable[scala.xml.Elem]]
}

/**
 * The value of a stereotype property that has an opposite extension end property.
 * Its value is ``extendedElement``
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeExtendedMetaclassTagValue[Uml <: UML]
  extends UMLStereotypeTagValue[Uml] {

  /**
   * By definition, a 'base_...' stereotype property references only the `extendedElement`
   * There is no other referenced element.
   */
  override val tagPropertyValueElementReferences: Iterable[UMLElement[Uml]] = Iterable()

}

/**
 * The value of a stereotype property that does not have an opposite extension end property.
 * There are several cases depending on the type of the property.
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypePropertyTagValue[Uml <: UML]
  extends UMLStereotypeTagValue[Uml]

/**
 * A UMLStereotypePropertyTagValue for a property typed by a UML metaclass
 * Its value is ``tagPropertyValueElementReferences``
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeReferencedMetaclassTagValue[Uml <: UML]
  extends UMLStereotypePropertyTagValue[Uml]

/**
 * A UMLStereotypePropertyTagValue for a property typed by a Profile-defined type
 *
 * -------------------------------
 * @see UML 2.5, section 12.3.3:
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
 * Ambiguity: The paragraph above allows two different uses for a type:
 *
 * 1) the type is in scope of the Profile-defined types (explicitly defined in or imported by a Profile);
 *   therefore, a value of a stereotype tag property by such type is tied to the lifecycle of the profile application;
 *   that is, the value is not accessible from model elements.
 *
 * 2) the type is defined in a UML Package of some kind (could be a Profile or a Model); therefore,
 *   it could be the type of TypedElement in the model or the classifier of an InstanceSpecification in the model
 *
 * This dual-use is relevant for types that are Classes, DataTypes or Associations
 * but not Stereotypes, Enumerations or PrimitiveTypes.
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForProfileDefinedType[Uml <: UML]
  extends UMLStereotypePropertyTagValue[Uml]

/**
 * A UMLStereotypePropertyTagValue for a property typed by a Profile-defined Stereotype
 *
 * Such a property cannot have composite aggregation (see UML 2.5, Section 12.3.3)
 * The serialization is a reference to an instance of a stereotype applied to an element (not the element itself).
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForProfileDefinedStereotype[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml]

/**
 * A UMLStereotypePropertyTagValue for a property typed by a Profile-defined Enumeration
 *
 * The value(s) of such a tag property must refer to the EnumerationLiterals of the Enumeration type.
 * The serialization is the name of the EnumerationLiteral.
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForProfileDefinedEnumerationType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml] {

  override val tagPropertyValueElementReferences: Iterable[UMLEnumerationLiteral[Uml]]

}

/**
 * A UMLStereotypePropertyTagValue for a property typed by a Profile-defined PrimitiveType
 *
 * The serialization is the lexical representation of the value(boolean, string, etc...)
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForProfileDefinedPrimitiveType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml] {

  val value: Iterable[String]

  override val tagPropertyValueElementReferences: Iterable[UMLElement[Uml]] = Iterable()

}

/**
 * A UMLStereotypePropertyTagValue for a property typed by a Profile-defined DataType
 * (not Enumeration, not PrimitiveType)
 *
 * Usage ambiguity: the value of a Stereotype property typed by a Profile-defined DataType could be either:
 * 1) an instance whose lifecycle is tied to the application of the profile or of the stereotype,
 * 2) an instance whose lifecycle is tied to the model and is unaffected by applying & unapplying profiles.
 *
 * Unfortunately, the UML 2.5 specification shows only an example of (2).
 * The difference is important because it affects the serialization behavior.
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForProfileDefinedDataType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml]

trait UMLStereotypeTagValueWithModelLifecycleForProfileDefinedDataType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedDataType[Uml]

trait UMLStereotypeTagValueWithProfileLifecycleForProfileDefinedDataType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedDataType[Uml] {

  override val tagPropertyValueElementReferences: Iterable[UMLElement[Uml]] = Iterable()

}


/**
 * A UMLStereotypePropertyTagValue for a property typed by a Profile-defined Class
 * (not a Stereotype)
 *
 * Usage ambiguity: the value of a Stereotype property typed by a Profile-defined DataType could be either:
 * 1) an instance whose lifecycle is tied to the application of the profile or of the stereotype,
 * 2) an instance whose lifecycle is tied to the model and is unaffected by applying & unapplying profiles.
 *
 * Unfortunately, the UML 2.5 specification shows only an example of (2).
 * The difference is important because it affects the serialization behavior.
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForProfileDefinedClassType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml]

trait UMLStereotypeTagValueWithModelLifecycleForProfileDefinedClassType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedClassType[Uml]

trait UMLStereotypeTagValueWithProfileLifecycleForProfileDefinedClassType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedClassType[Uml] {

  override val tagPropertyValueElementReferences: Iterable[UMLElement[Uml]] = Iterable()

}

/**
 * A UMLStereotypePropertyTagValue for a property typed by a Profile-defined Association
 * (not Extension)
 *
 * Usage ambiguity: the value of a Stereotype property typed by a Profile-defined DataType could be either:
 * 1) an instance whose lifecycle is tied to the application of the profile or of the stereotype,
 * 2) an instance whose lifecycle is tied to the model and is unaffected by applying & unapplying profiles.
 *
 * Unfortunately, the UML 2.5 specification shows only an example of (2).
 * The difference is important because it affects the serialization behavior.
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForProfileDefinedAssociationType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml]

trait UMLStereotypeTagValueWithModelLifecycleForProfileDefinedAssociationType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedAssociationType[Uml]

trait UMLStereotypeTagValueWithProfileLifecycleForProfileDefinedAssociationType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedAssociationType[Uml] {

  override val tagPropertyValueElementReferences: Iterable[UMLElement[Uml]] = Iterable()

}