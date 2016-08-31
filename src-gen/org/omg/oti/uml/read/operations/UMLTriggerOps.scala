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
import scala.Option
import scala.Predef.???
// End of user code

/**
  * A Trigger specifies a specific point  at which an Event occurrence may trigger an effect in a Behavior. A Trigger may be qualified by the Port on which the Event occurred.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTriggerOps[Uml <: UML] { self: UMLTrigger[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for deferrableTrigger_state -->
    * <!-- End of user code doc for deferrableTrigger_state -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLState.deferrableTrigger
    */
  def deferrableTrigger_state: Option[UMLState[Uml]] = owner.selectByKindOf { case x: UMLState[Uml] => x }

  /**
    * <!-- Start of user code doc for trigger_acceptEventAction -->
    * <!-- End of user code doc for trigger_acceptEventAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAcceptEventAction.trigger
    */
  def trigger_acceptEventAction: Option[UMLAcceptEventAction[Uml]] = owner.selectByKindOf { case x: UMLAcceptEventAction[Uml] => x }

  /**
    * <!-- Start of user code doc for trigger_transition -->
    * <!-- End of user code doc for trigger_transition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTransition.trigger
    */
  def trigger_transition: Option[UMLTransition[Uml]] = owner.selectByKindOf { case x: UMLTransition[Uml] => x }

  /**
    * If a Trigger specifies one or more ports, the event of the Trigger must be a MessageEvent.
    *
    * <!-- Start of user code doc for validate_trigger_with_ports -->
    * <!-- End of user code doc for validate_trigger_with_ports -->
    *
    * {{{
    * OCL Body port->notEmpty() implies event.oclIsKindOf(MessageEvent)
    * }}}
    */
  def validate_trigger_with_ports: Boolean = {
    // Start of user code for "trigger_with_ports"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLTriggerOps
