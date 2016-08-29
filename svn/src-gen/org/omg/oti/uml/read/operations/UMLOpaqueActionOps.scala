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
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * An OpaqueAction is an Action whose functionality is not specified within UML.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLOpaqueActionOps[Uml <: UML] { self: UMLOpaqueAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The InputPins providing inputs to the OpaqueAction.
    *
    * <!-- Start of user code doc for inputValue -->
    * <!-- End of user code doc for inputValue -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.inputValue_opaqueAction
    */
  def inputValue: Set[UMLInputPin[Uml]] = input.toSet[UMLInputPin[Uml]]

  /**
    * The OutputPins on which the OpaqueAction provides outputs.
    *
    * <!-- Start of user code doc for outputValue -->
    * <!-- End of user code doc for outputValue -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.outputValue_opaqueAction
    */
  def outputValue: Set[UMLOutputPin[Uml]] = output.toSet[UMLOutputPin[Uml]]

  /**
    * If the language attribute is not empty, then the size of the body and language lists must be the same.
    *
    * <!-- Start of user code doc for validate_language_body_size -->
    * <!-- End of user code doc for validate_language_body_size -->
    *
    * {{{
    * OCL Body language->notEmpty() implies (_'body'->size() = language->size())
    * }}}
    */
  def validate_language_body_size: Boolean = {
    // Start of user code for "language_body_size"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLOpaqueActionOps
