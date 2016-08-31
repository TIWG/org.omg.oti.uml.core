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
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
// End of user code

/**
  * An UnmarshallAction is an Action that retrieves the values of the StructuralFeatures of an object and places them on OutputPins. 
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLUnmarshallActionOps[Uml <: UML] { self: UMLUnmarshallAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The InputPin that gives the object to be unmarshalled.
    *
    * <!-- Start of user code doc for _object -->
    * <!-- End of user code doc for _object -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.object_unmarshallAction
    */
  def _object: Option[UMLInputPin[Uml]] = input headOption

  /**
    * The multiplicity of the object InputPin is 1..1
    *
    * <!-- Start of user code doc for validate_multiplicity_of_object -->
    * <!-- End of user code doc for validate_multiplicity_of_object -->
    *
    * {{{
    * OCL Body object.is(1,1)
    * }}}
    */
  def validate_multiplicity_of_object: Boolean = {
    // Start of user code for "multiplicity_of_object"
    ???
    // End of user code
  }

  /**
    * The number of result outputPins must be the same as the number of attributes of the unmarshallType.
    *
    * <!-- Start of user code doc for validate_number_of_result -->
    * <!-- End of user code doc for validate_number_of_result -->
    *
    * {{{
    * OCL Body unmarshallType.allAttributes()->size() = result->size()
    * }}}
    */
  def validate_number_of_result: Boolean = {
    // Start of user code for "number_of_result"
    ???
    // End of user code
  }

  /**
    * The type of the object InputPin conform to the unmarshallType.
    *
    * <!-- Start of user code doc for validate_object_type -->
    * <!-- End of user code doc for validate_object_type -->
    *
    * {{{
    * OCL Body object.type.conformsTo(unmarshallType)
    * }}}
    */
  def validate_object_type: Boolean = {
    // Start of user code for "object_type"
    ???
    // End of user code
  }

  /**
    * The unmarshallType must have at least one StructuralFeature.
    *
    * <!-- Start of user code doc for validate_structural_feature -->
    * <!-- End of user code doc for validate_structural_feature -->
    *
    * {{{
    * OCL Body unmarshallType.allAttributes()->size() >= 1
    * }}}
    */
  def validate_structural_feature: Boolean = {
    // Start of user code for "structural_feature"
    ???
    // End of user code
  }

  /**
    * The type, ordering and multiplicity of each attribute of the unmarshallType must be compatible with the type, ordering and multiplicity of the corresponding result OutputPin.
    *
    * <!-- Start of user code doc for validate_type_ordering_and_multiplicity -->
    * <!-- End of user code doc for validate_type_ordering_and_multiplicity -->
    *
    * {{{
    * OCL Body let attribute:OrderedSet(Property) = unmarshallType.allAttributes() in
    * Sequence{1..result->size()}->forAll(i | 
    * 	attribute->at(i).type.conformsTo(result->at(i).type) and
    * 	attribute->at(i).isOrdered=result->at(i).isOrdered and
    * 	attribute->at(i).compatibleWith(result->at(i)))
    * }}}
    */
  def validate_type_ordering_and_multiplicity: Boolean = {
    // Start of user code for "type_ordering_and_multiplicity"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLUnmarshallActionOps
