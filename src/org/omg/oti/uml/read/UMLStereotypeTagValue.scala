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
   * The stereotype property -- can be (1) or (2)
   */
  val stereotypeTagProperty: UMLProperty[Uml]

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
  def serialize: Try[Iterable[scala.xml.Node]]
}

/**
 * The value of a stereotype property that has an opposite extension end property.
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeExtendedMetaclassTagValue[Uml <: UML]
  extends UMLStereotypeTagValue[Uml] {

  /**
   * the element extended by the application of the stereotype owning the stereotypeTagProperty.
   */
  val stereotypeExtendedElement: UMLElement[Uml]
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
 * That is, the value is a collection of UML elements.
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeReferencedMetaclassTagValue[Uml <: UML]
  extends UMLStereotypePropertyTagValue[Uml] {

  val value: Iterable[UMLElement[Uml]]

}

/**
 * A UMLStereotypePropertyTagValue for a property typed by a Profile-defined type
 *
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
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForProfileDefinedType[Uml <: UML]
  extends UMLStereotypePropertyTagValue[Uml]

/**
 * A UMLStereotypePropertyTagValue for a property typed by a Profile-defined Enumeration type
 *
 * The value(s) of such a tag property must refer to the EnumerationLiterals of the Enumeration type.
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForProfileDefinedEnumerationType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml] {

  val value: Iterable[UMLEnumerationLiteral[Uml]]
}

/**
 * A UMLStereotypePropertyTagValue for a property typed by UML's PrimitiveTypes Boolean
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForBooleanType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml] {

  val value: Iterable[Boolean]
}

/**
 * A UMLStereotypePropertyTagValue for a property typed by UML's PrimitiveTypes Integer
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForIntegerType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml] {

  val value: Iterable[Integer]
}

/**
 * A UMLStereotypePropertyTagValue for a property typed by UML's PrimitiveTypes Real
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForRealType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml] {

  val value: Iterable[Double]
}

/**
 * A UMLStereotypePropertyTagValue for a property typed by UML's PrimitiveTypes String
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForStringType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml] {

  val value: Iterable[String]
}

/**
 * A UMLStereotypePropertyTagValue for a property typed by UML's PrimitiveTypes UnlimitedNatural
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForUnlimitedNaturalType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml] {

  val value: Iterable[Integer]
}

/**
 * A UMLStereotypePropertyTagValue for a property typed by a Profile-defined DataType
 * (not Enumeration, not a UML PrimitiveType)
 *
 * Since instances of DataTypes have value semantics, the serialization can be either
 * non-sharing, sharing or a combination of both.
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForProfileDefinedDataType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml]

/**
 * A UMLStereotypePropertyTagValue for a property typed by a Profile-defined Class
 * (not a Stereotype)
 *
 * Since instances of Class types have identity semantics (even if defined in UML profiles),
 * the serialization must preserve the distinction between composite and non-composite
 * references amongst instances of profile-defined class types.
 *
 * This is an advanced capability in UML 2.5 profiles (see section 12.3.3)
 * that some tools do not support.
 *
 * @tparam Uml A tool-specific implementation of OMG UML
 */
trait UMLStereotypeTagValueForProfileClassType[Uml <: UML]
  extends UMLStereotypeTagValueForProfileDefinedType[Uml]
