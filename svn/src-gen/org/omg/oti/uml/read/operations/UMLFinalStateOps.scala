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
// End of user code

/**
  * A special kind of State, which, when entered, signifies that the enclosing Region has completed. If the enclosing Region is directly contained in a StateMachine and all other Regions in that StateMachine also are completed, then it means that the entire StateMachine behavior is completed.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLFinalStateOps[Uml <: UML] { self: UMLFinalState[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * A FinalState cannot reference a submachine.
    *
    * <!-- Start of user code doc for validate_cannot_reference_submachine -->
    * <!-- End of user code doc for validate_cannot_reference_submachine -->
    *
    * {{{
    * OCL Body submachine->isEmpty()
    * }}}
    */
  def validate_cannot_reference_submachine: Boolean = {
    // Start of user code for "cannot_reference_submachine"
    ???
    // End of user code
  }

  /**
    * A FinalState has no entry Behavior.
    *
    * <!-- Start of user code doc for validate_no_entry_behavior -->
    * <!-- End of user code doc for validate_no_entry_behavior -->
    *
    * {{{
    * OCL Body entry->isEmpty()
    * }}}
    */
  def validate_no_entry_behavior: Boolean = {
    // Start of user code for "no_entry_behavior"
    ???
    // End of user code
  }

  /**
    * A FinalState has no exit Behavior.
    *
    * <!-- Start of user code doc for validate_no_exit_behavior -->
    * <!-- End of user code doc for validate_no_exit_behavior -->
    *
    * {{{
    * OCL Body exit->isEmpty()
    * }}}
    */
  def validate_no_exit_behavior: Boolean = {
    // Start of user code for "no_exit_behavior"
    ???
    // End of user code
  }

  /**
    * A FinalState cannot have any outgoing Transitions.
    *
    * <!-- Start of user code doc for validate_no_outgoing_transitions -->
    * <!-- End of user code doc for validate_no_outgoing_transitions -->
    *
    * {{{
    * OCL Body outgoing->size() = 0
    * }}}
    */
  def validate_no_outgoing_transitions: Boolean = {
    // Start of user code for "no_outgoing_transitions"
    ???
    // End of user code
  }

  /**
    * A FinalState cannot have Regions.
    *
    * <!-- Start of user code doc for validate_no_regions -->
    * <!-- End of user code doc for validate_no_regions -->
    *
    * {{{
    * OCL Body region->size() = 0
    * }}}
    */
  def validate_no_regions: Boolean = {
    // Start of user code for "no_regions"
    ???
    // End of user code
  }

  /**
    * A FinalState has no state (doActivity) Behavior.
    *
    * <!-- Start of user code doc for validate_no_state_behavior -->
    * <!-- End of user code doc for validate_no_state_behavior -->
    *
    * {{{
    * OCL Body doActivity->isEmpty()
    * }}}
    */
  def validate_no_state_behavior: Boolean = {
    // Start of user code for "no_state_behavior"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLFinalStateOps
