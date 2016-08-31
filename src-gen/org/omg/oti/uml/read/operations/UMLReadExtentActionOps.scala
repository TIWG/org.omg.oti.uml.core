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
  * A ReadExtentAction is an Action that retrieves the current instances of a Classifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReadExtentActionOps[Uml <: UML] { self: UMLReadExtentAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The OutputPin on which the Classifier instances are placed.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_readExtentAction
    */
  def result: Option[UMLOutputPin[Uml]] = output headOption

  /**
    * The multiplicity of the result OutputPin is 0..*.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_result -->
    * <!-- End of user code doc for validate_multiplicity_of_result -->
    *
    * {{{
    * OCL Body result.is(0,*)
    * }}}
    */
  def validate_multiplicity_of_result: Boolean = {
    // Start of user code for "multiplicity_of_result"
    ???
    // End of user code
  }

  /**
    * The type of the result OutputPin is the classifier.
    *
    * <!-- Start of user code doc for validate_type_is_classifier -->
    * <!-- End of user code doc for validate_type_is_classifier -->
    *
    * {{{
    * OCL Body result.type = classifier
    * }}}
    */
  def validate_type_is_classifier: Boolean = {
    // Start of user code for "type_is_classifier"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReadExtentActionOps
