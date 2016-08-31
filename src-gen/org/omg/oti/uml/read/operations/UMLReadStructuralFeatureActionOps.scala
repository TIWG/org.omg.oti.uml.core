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
  * A ReadStructuralFeatureAction is a StructuralFeatureAction that retrieves the values of a StructuralFeature.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReadStructuralFeatureActionOps[Uml <: UML] { self: UMLReadStructuralFeatureAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The OutputPin on which the result values are placed.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_readStructuralFeatureAction
    */
  def result: Option[UMLOutputPin[Uml]] = output headOption

  /**
    * The multiplicity of the StructuralFeature must be compatible with the multiplicity of the result OutputPin.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_result -->
    * <!-- End of user code doc for validate_multiplicity_of_result -->
    *
    * {{{
    * OCL Body structuralFeature.compatibleWith(result)
    * }}}
    */
  def validate_multiplicity_of_result: Boolean = {
    // Start of user code for "multiplicity_of_result"
    ???
    // End of user code
  }

  /**
    * The type and ordering of the result OutputPin are the same as the type and ordering of the StructuralFeature.
    *
    * <!-- Start of user code doc for validate_type_and_ordering -->
    * <!-- End of user code doc for validate_type_and_ordering -->
    *
    * {{{
    * OCL Body result.type =structuralFeature.type and 
    * result.isOrdered = structuralFeature.isOrdered
    * }}}
    */
  def validate_type_and_ordering: Boolean = {
    // Start of user code for "type_and_ordering"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReadStructuralFeatureActionOps
