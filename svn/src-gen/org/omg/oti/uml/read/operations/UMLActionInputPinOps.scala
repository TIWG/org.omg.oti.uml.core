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
import scala.{Option,None,Some}
// End of user code

/**
  * An ActionInputPin is a kind of InputPin that executes an Action to determine the values to input to another Action.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActionInputPinOps[Uml <: UML] { self: UMLActionInputPin[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Action used to provide the values of the ActionInputPin.
    *
    * <!-- Start of user code doc for fromAction -->
    * <!-- End of user code doc for fromAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAction.fromAction_actionInputPin
    */
  def fromAction: Option[UMLAction[Uml]] = ownedElement.selectByKindOf { case x: UMLAction[Uml] => x } headOption

  /**
    * The fromAction of an ActionInputPin must only have ActionInputPins as InputPins.
    *
    * <!-- Start of user code doc for validate_input_pin -->
    * <!-- End of user code doc for validate_input_pin -->
    *
    * {{{
    * OCL Body fromAction.input->forAll(oclIsKindOf(ActionInputPin))
    * }}}
    */
  def validate_input_pin: Boolean = {
    // Start of user code for "input_pin"
    fromAction match {
      case Some(action) => 
        action.input.forall { p =>
          p match {
            case (_: UMLActionInputPin[Uml]) =>
              true
            case _ =>
              false
          }
        }
      case None =>
        false
    }
    // End of user code
  }

  /**
    * The fromAction of an ActionInputPin cannot have ActivityEdges coming into or out of it or its Pins.
    *
    * <!-- Start of user code doc for validate_no_control_or_object_flow -->
    * <!-- End of user code doc for validate_no_control_or_object_flow -->
    *
    * {{{
    * OCL Body fromAction.incoming->union(outgoing)->isEmpty() and
    * fromAction.input.incoming->isEmpty() and
    * fromAction.output.outgoing->isEmpty()
    * }}}
    */
  def validate_no_control_or_object_flow: Boolean = {
    // Start of user code for "no_control_or_object_flow"
    fromAction match {
      case Some(action) => 
        action.incoming.union(action.outgoing).isEmpty &&
        action.input.forall ( _.incoming.isEmpty ) && 
        action.output.forall ( _.incoming.isEmpty )
      case None =>
        false
    }
    // End of user code
  }

  /**
    * The fromAction of an ActionInputPin must have exactly one OutputPin.
    *
    * <!-- Start of user code doc for validate_one_output_pin -->
    * <!-- End of user code doc for validate_one_output_pin -->
    *
    * {{{
    * OCL Body fromAction.output->size() = 1
    * }}}
    */
  def validate_one_output_pin: Boolean = {
    // Start of user code for "one_output_pin"
    fromAction match {
        case Some(action) =>
          action.output.size == 1
        case None =>
          false
      }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLActionInputPinOps
