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
  * A ReadIsClassifiedObjectAction is an Action that determines whether an object is classified by a given Classifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReadIsClassifiedObjectActionOps[Uml <: UML] { self: UMLReadIsClassifiedObjectAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The InputPin that holds the object whose classification is to be tested.
    *
    * <!-- Start of user code doc for _object -->
    * <!-- End of user code doc for _object -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.object_readIsClassifiedObjectAction
    */
  def _object: Option[UMLInputPin[Uml]] = input headOption

  /**
    * The OutputPin that holds the Boolean result of the test.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_readIsClassifiedObjectAction
    */
  def result: Option[UMLOutputPin[Uml]] = output headOption

  /**
    * The type of the result OutputPin is Boolean.
    *
    * <!-- Start of user code doc for validate_boolean_result -->
    * <!-- End of user code doc for validate_boolean_result -->
    *
    * {{{
    * OCL Body result.type = Boolean
    * }}}
    */
  def validate_boolean_result: Boolean = {
    // Start of user code for "boolean_result"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the object InputPin is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_input -->
    * <!-- End of user code doc for validate_multiplicity_of_input -->
    *
    * {{{
    * OCL Body object.is(1,1)
    * }}}
    */
  def validate_multiplicity_of_input: Boolean = {
    // Start of user code for "multiplicity_of_input"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the result OutputPin is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_output -->
    * <!-- End of user code doc for validate_multiplicity_of_output -->
    *
    * {{{
    * OCL Body result.is(1,1)
    * }}}
    */
  def validate_multiplicity_of_output: Boolean = {
    // Start of user code for "multiplicity_of_output"
    ???
    // End of user code
  }

  /**
    * The object InputPin has no type.
    *
    * <!-- Start of user code doc for validate_no_type -->
    * <!-- End of user code doc for validate_no_type -->
    *
    * {{{
    * OCL Body object.type = null
    * }}}
    */
  def validate_no_type: Boolean = {
    // Start of user code for "no_type"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReadIsClassifiedObjectActionOps
