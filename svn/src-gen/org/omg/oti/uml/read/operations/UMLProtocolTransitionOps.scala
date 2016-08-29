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
import scala.collection.immutable.Set
// End of user code

/**
  * A ProtocolTransition specifies a legal Transition for an Operation. Transitions of ProtocolStateMachines have the following information: a pre-condition (guard), a Trigger, and a post-condition. Every ProtocolTransition is associated with at most one BehavioralFeature belonging to the context Classifier of the ProtocolStateMachine.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLProtocolTransitionOps[Uml <: UML] { self: UMLProtocolTransition[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * Specifies the precondition of the Transition. It specifies the Condition that should be verified before triggering the Transition. This guard condition added to the source State will be evaluated as part of the precondition of the Operation referred by the Transition if any.
    *
    * <!-- Start of user code doc for preCondition -->
    * <!-- End of user code doc for preCondition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.preCondition_protocolTransition
    */
  def preCondition: Option[UMLConstraint[Uml]] = guard

  /**
    * This association refers to the associated Operation. It is derived from the Operation of the CallEvent Trigger when applicable.
    *
    * <!-- Start of user code doc for referred -->
    * <!-- End of user code doc for referred -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.referred_protocolTransition
    * {{{
    * OCL Body result = (trigger->collect(event)->select(oclIsKindOf(CallEvent))->collect(oclAsType(CallEvent).operation)->asSet())
    * }}}
    */
  def referred: Set[UMLOperation[Uml]] = {
    // Start of user code for "referred"
    ???
    // End of user code
  }

  /**
    * A ProtocolTransition never has associated Behaviors.
    *
    * <!-- Start of user code doc for validate_associated_actions -->
    * <!-- End of user code doc for validate_associated_actions -->
    *
    * {{{
    * OCL Body effect = null
    * }}}
    */
  def validate_associated_actions: Boolean = {
    // Start of user code for "associated_actions"
    ???
    // End of user code
  }

  /**
    * A ProtocolTransition always belongs to a ProtocolStateMachine.
    *
    * <!-- Start of user code doc for validate_belongs_to_psm -->
    * <!-- End of user code doc for validate_belongs_to_psm -->
    *
    * {{{
    * OCL Body container.belongsToPSM()
    * }}}
    */
  def validate_belongs_to_psm: Boolean = {
    // Start of user code for "belongs_to_psm"
    ???
    // End of user code
  }

  /**
    * If a ProtocolTransition refers to an Operation (i.e., has a CallEvent trigger corresponding to an Operation), then that Operation should apply to the context Classifier of the StateMachine of the ProtocolTransition.
    *
    * <!-- Start of user code doc for validate_refers_to_operation -->
    * <!-- End of user code doc for validate_refers_to_operation -->
    *
    * {{{
    * OCL Body if (referred()->notEmpty() and containingStateMachine()._'context'->notEmpty()) then 
    *     containingStateMachine()._'context'.oclAsType(BehavioredClassifier).allFeatures()->includesAll(referred())
    * else true endif
    * }}}
    */
  def validate_refers_to_operation: Boolean = {
    // Start of user code for "refers_to_operation"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLProtocolTransitionOps
