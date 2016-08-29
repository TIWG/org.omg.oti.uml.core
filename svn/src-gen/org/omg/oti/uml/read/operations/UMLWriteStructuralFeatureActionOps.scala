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
  * WriteStructuralFeatureAction is an abstract class for StructuralFeatureActions that change StructuralFeature values.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLWriteStructuralFeatureActionOps[Uml <: UML] { self: UMLWriteStructuralFeatureAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The OutputPin on which is put the input object as modified by the WriteStructuralFeatureAction.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_writeStructuralFeatureAction
    */
  def result: Option[UMLOutputPin[Uml]] = output headOption

  /**
    * The multiplicity of the result OutputPin must be 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_result -->
    * <!-- End of user code doc for validate_multiplicity_of_result -->
    *
    * {{{
    * OCL Body result <> null implies result.is(1,1)
    * }}}
    */
  def validate_multiplicity_of_result: Boolean = {
    // Start of user code for "multiplicity_of_result"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the value InputPin is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_value -->
    * <!-- End of user code doc for validate_multiplicity_of_value -->
    *
    * {{{
    * OCL Body value<>null implies value.is(1,1)
    * }}}
    */
  def validate_multiplicity_of_value: Boolean = {
    // Start of user code for "multiplicity_of_value"
    ???
    // End of user code
  }

  /**
    * The type of the result OutputPin is the same as the type of the inherited object InputPin.
    *
    * <!-- Start of user code doc for validate_type_of_result -->
    * <!-- End of user code doc for validate_type_of_result -->
    *
    * {{{
    * OCL Body result <> null implies result.type = object.type
    * }}}
    */
  def validate_type_of_result: Boolean = {
    // Start of user code for "type_of_result"
    ???
    // End of user code
  }

  /**
    * The type of the value InputPin must conform to the type of the structuralFeature.
    *
    * <!-- Start of user code doc for validate_type_of_value -->
    * <!-- End of user code doc for validate_type_of_value -->
    *
    * {{{
    * OCL Body value <> null implies value.type.conformsTo(structuralFeature.type)
    * }}}
    */
  def validate_type_of_value: Boolean = {
    // Start of user code for "type_of_value"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLWriteStructuralFeatureActionOps
