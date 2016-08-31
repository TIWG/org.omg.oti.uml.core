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
  * A ProtocolStateMachine is always defined in the context of a Classifier. It specifies which BehavioralFeatures of the Classifier can be called in which State and under which conditions, thus specifying the allowed invocation sequences on the Classifier's BehavioralFeatures. A ProtocolStateMachine specifies the possible and permitted Transitions on the instances of its context Classifier, together with the BehavioralFeatures that carry the Transitions. In this manner, an instance lifecycle can be specified for a Classifier, by defining the order in which the BehavioralFeatures can be activated and the States through which an instance progresses during its existence.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLProtocolStateMachineOps[Uml <: UML] { self: UMLProtocolStateMachine[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Conformance between ProtocolStateMachine 
    *
    * <!-- Start of user code doc for conformance -->
    * <!-- End of user code doc for conformance -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProtocolConformance.specificMachine
    */
  def conformance: Set[UMLProtocolConformance[Uml]] = ownedElement.selectByKindOf { case x: UMLProtocolConformance[Uml] => x }

  /**
    * <!-- Start of user code doc for generalMachine_protocolConformance -->
    * <!-- End of user code doc for generalMachine_protocolConformance -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProtocolConformance.generalMachine
    */
  def generalMachine_protocolConformance: Set[UMLProtocolConformance[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLProtocolConformance[Uml] => x }

  /**
    * ProtocolStateMachines cannot have deep or shallow history Pseudostates.
    *
    * <!-- Start of user code doc for validate_deep_or_shallow_history -->
    * <!-- End of user code doc for validate_deep_or_shallow_history -->
    *
    * {{{
    * OCL Body region->forAll (r | r.subvertex->forAll (v | v.oclIsKindOf(Pseudostate) implies
    * ((v.oclAsType(Pseudostate).kind <>  PseudostateKind::deepHistory) and (v.oclAsType(Pseudostate).kind <> PseudostateKind::shallowHistory))))
    * }}}
    */
  def validate_deep_or_shallow_history: Boolean = {
    // Start of user code for "deep_or_shallow_history"
    ???
    // End of user code
  }

  /**
    * The states of a ProtocolStateMachine cannot have entry, exit, or do activity Behaviors.
    *
    * <!-- Start of user code doc for validate_entry_exit_do -->
    * <!-- End of user code doc for validate_entry_exit_do -->
    *
    * {{{
    * OCL Body region->forAll(r | r.subvertex->forAll(v | v.oclIsKindOf(State) implies
    * (v.oclAsType(State).entry->isEmpty() and v.oclAsType(State).exit->isEmpty() and v.oclAsType(State).doActivity->isEmpty())))
    * }}}
    */
  def validate_entry_exit_do: Boolean = {
    // Start of user code for "entry_exit_do"
    ???
    // End of user code
  }

  /**
    * A ProtocolStateMachine must only have a Classifier context, not a BehavioralFeature context.
    *
    * <!-- Start of user code doc for validate_protocol_state_machine_classifier_context -->
    * <!-- End of user code doc for validate_protocol_state_machine_classifier_context -->
    *
    * {{{
    * OCL Body _'context' <> null and specification = null
    * }}}
    */
  def validate_protocol_state_machine_classifier_context: Boolean = {
    // Start of user code for "protocol_state_machine_classifier_context"
    ???
    // End of user code
  }

  /**
    * All Transitions of a ProtocolStateMachine must be ProtocolTransitions.
    *
    * <!-- Start of user code doc for validate_protocol_transitions -->
    * <!-- End of user code doc for validate_protocol_transitions -->
    *
    * {{{
    * OCL Body region->forAll(r | r.transition->forAll(t | t.oclIsTypeOf(ProtocolTransition)))
    * }}}
    */
  def validate_protocol_transitions: Boolean = {
    // Start of user code for "protocol_transitions"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLProtocolStateMachineOps
