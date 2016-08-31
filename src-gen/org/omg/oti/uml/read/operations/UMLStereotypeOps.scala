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

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.Boolean
import scala.{Option,None,Some}
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
// End of user code

/**
  * A stereotype defines how an existing metaclass may be extended, and enables the use of platform or domain specific terminology or notation in place of, or in addition to, the ones used for the extended metaclass.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStereotypeOps[Uml <: UML] { self: UMLStereotype[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Stereotype can change the graphical appearance of the extended model element by using attached icons. When this association is not null, it references the location of the icon content to be displayed within diagrams presenting the extended model elements.
    *
    * <!-- Start of user code doc for icon -->
    * <!-- End of user code doc for icon -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLImage.icon_stereotype
    */
  def icon: Set[UMLImage[Uml]] = ownedElement.selectByKindOf { case x: UMLImage[Uml] => x }

  /**
    * The profile that directly or indirectly contains this stereotype.
    *
    * <!-- Start of user code doc for profile -->
    * <!-- End of user code doc for profile -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProfile.profile_stereotype
    * {{{
    * OCL Body result = (self.containingProfile())
    * }}}
    */
  def profile: Option[UMLProfile[Uml]] = {
    // Start of user code for "profile"
    def getOwningProfile( pkg: Option[UMLPackage[Uml]] ): Option[UMLProfile[Uml]] =
      pkg.fold[Option[UMLProfile[Uml]]](None) {
      case pf: UMLProfile[Uml] => Some( pf )
      case p => getOwningProfile( p.packagedElement_owningPackage )
    }
    
    getOwningProfile( packagedElement_owningPackage )
    // End of user code
  }

  /**
    * <!-- Start of user code doc for type_extensionEnd -->
    * <!-- End of user code doc for type_extensionEnd -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExtensionEnd._type
    */
  def type_extensionEnd: Set[UMLExtensionEnd[Uml]] = type_typedElement.selectByKindOf { case x: UMLExtensionEnd[Uml] => x }

  /**
    * The query containingProfile returns the closest profile directly or indirectly containing this stereotype.
    *
    * <!-- Start of user code doc for containingProfile -->
    * <!-- End of user code doc for containingProfile -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (self.namespace.oclAsType(Package).containingProfile())
    * }}}
    */
  def containingProfile: Option[UMLProfile[Uml]] = {
    // Start of user code for "containingProfile"
    ???
    // End of user code
  }

  /**
    * Where a stereotype?s property is an association end for an association other than a kind of extension, and the other end is not a stereotype, the other end must be owned by the association itself.
    *
    * <!-- Start of user code doc for validate_associationEndOwnership -->
    * <!-- End of user code doc for validate_associationEndOwnership -->
    *
    * {{{
    * OCL Body ownedAttribute
    * ->select(association->notEmpty() and not association.oclIsKindOf(Extension) and not type.oclIsKindOf(Stereotype))
    * ->forAll(opposite.owner = association)
    * }}}
    */
  def validate_associationEndOwnership: Boolean = {
    // Start of user code for "associationEndOwnership"
    ???
    // End of user code
  }

  /**
    * If a Stereotype extends more than one metaclass, the multiplicity of the corresponding base-properties shall be [0..1]. At any point in time, only one of these base-properties can contain a metaclass instance during runtime.
    *
    * <!-- Start of user code doc for validate_base_property_multiplicity_multiple_extension -->
    * <!-- End of user code doc for validate_base_property_multiplicity_multiple_extension -->
    *
    * {{{
    * }}}
    */
  def validate_base_property_multiplicity_multiple_extension: Boolean = {
    // Start of user code for "base_property_multiplicity_multiple_extension"
    ???
    // End of user code
  }

  /**
    * If a Stereotype extends only one metaclass, the multiplicity of the corresponding base-property shall be 1..1.
    *
    * <!-- Start of user code doc for validate_base_property_multiplicity_single_extension -->
    * <!-- End of user code doc for validate_base_property_multiplicity_single_extension -->
    *
    * {{{
    * }}}
    */
  def validate_base_property_multiplicity_single_extension: Boolean = {
    // Start of user code for "base_property_multiplicity_single_extension"
    ???
    // End of user code
  }

  /**
    * The upper bound of base-properties is exactly 1.
    *
    * <!-- Start of user code doc for validate_base_property_upper_bound -->
    * <!-- End of user code doc for validate_base_property_upper_bound -->
    *
    * {{{
    * }}}
    */
  def validate_base_property_upper_bound: Boolean = {
    // Start of user code for "base_property_upper_bound"
    ???
    // End of user code
  }

  /**
    * Stereotypes may only participate in binary associations.
    *
    * <!-- Start of user code doc for validate_binaryAssociationsOnly -->
    * <!-- End of user code doc for validate_binaryAssociationsOnly -->
    *
    * {{{
    * OCL Body ownedAttribute.association->forAll(memberEnd->size()=2)
    * }}}
    */
  def validate_binaryAssociationsOnly: Boolean = {
    // Start of user code for "binaryAssociationsOnly"
    ???
    // End of user code
  }

  /**
    * A Stereotype may only generalize or specialize another Stereotype.
    *
    * <!-- Start of user code doc for validate_generalize -->
    * <!-- End of user code doc for validate_generalize -->
    *
    * {{{
    * OCL Body allParents()->forAll(oclIsKindOf(Stereotype)) 
    * and Classifier.allInstances()->forAll(c | c.allParents()->exists(oclIsKindOf(Stereotype)) implies c.oclIsKindOf(Stereotype))
    * }}}
    */
  def validate_generalize: Boolean = {
    // Start of user code for "generalize"
    ???
    // End of user code
  }

  /**
    * Stereotype names should not clash with keyword names for the extended model element.
    *
    * <!-- Start of user code doc for validate_name_not_clash -->
    * <!-- End of user code doc for validate_name_not_clash -->
    *
    * {{{
    * }}}
    */
  def validate_name_not_clash: Boolean = {
    // Start of user code for "name_not_clash"
    ???
    // End of user code
  }

  // Start of user code for additional features

  def baseMetaProperties: Iterable[UMLProperty[Uml]] = for {
    ee <- type_extensionEnd
    base <- ee.opposite
  } yield base
  
  def baseMetaPropertiesExceptRedefined: Iterable[UMLProperty[Uml]] = {
    val allBaseMetaProperties = baseMetaProperties.toSet
    val redefinedBaseMetaProperties = allBaseMetaProperties flatMap (_.redefinedProperty)
    allBaseMetaProperties -- redefinedBaseMetaProperties    
  }

  // End of user code
} //UMLStereotypeOps
