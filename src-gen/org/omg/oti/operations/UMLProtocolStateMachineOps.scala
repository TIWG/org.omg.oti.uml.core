/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.operations

// Start of user code for imports
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * <!-- begin-model-doc --> 
 * A ProtocolStateMachine is always defined in the context of a Classifier. It specifies which BehavioralFeatures of the Classifier can be called in which State and under which conditions, thus specifying the allowed invocation sequences on the Classifier's BehavioralFeatures. A ProtocolStateMachine specifies the possible and permitted Transitions on the instances of its context Classifier, together with the BehavioralFeatures that carry the Transitions. In this manner, an instance lifecycle can be specified for a Classifier, by defining the order in which the BehavioralFeatures can be activated and the States through which an instance progresses during its existence.
 * <!-- end-model-doc --> 
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLProtocolStateMachineOps[Uml <: UML] { self: UMLProtocolStateMachine[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * Conformance between ProtocolStateMachine 
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProtocolConformance.specificMachine
	 */
	def conformance: Set[UMLProtocolConformance[Uml]] = ownedElement.selectByKindOf { case x: UMLProtocolConformance[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProtocolConformance.generalMachine
	 */
	def generalMachine_protocolConformance: Set[UMLProtocolConformance[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLProtocolConformance[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * ProtocolStateMachines cannot have deep or shallow history Pseudostates.
	 * <!-- end-model-doc -->
	 *
	 * @body region->forAll (r | r.subvertex->forAll (v | v.oclIsKindOf(Pseudostate) implies
	 * ((v.oclAsType(Pseudostate).kind <>  PseudostateKind::deepHistory) and (v.oclAsType(Pseudostate).kind <> PseudostateKind::shallowHistory))))
	 */
	def validate_deep_or_shallow_history: Boolean  = {
    	// Start of user code for "deep_or_shallow_history"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The states of a ProtocolStateMachine cannot have entry, exit, or do activity Behaviors.
	 * <!-- end-model-doc -->
	 *
	 * @body region->forAll(r | r.subvertex->forAll(v | v.oclIsKindOf(State) implies
	 * (v.oclAsType(State).entry->isEmpty() and v.oclAsType(State).exit->isEmpty() and v.oclAsType(State).doActivity->isEmpty())))
	 */
	def validate_entry_exit_do: Boolean  = {
    	// Start of user code for "entry_exit_do"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A ProtocolStateMachine must only have a Classifier context, not a BehavioralFeature context.
	 * <!-- end-model-doc -->
	 *
	 * @body _'context' <> null and specification = null
	 */
	def validate_protocol_state_machine_classifier_context: Boolean  = {
    	// Start of user code for "protocol_state_machine_classifier_context"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * All Transitions of a ProtocolStateMachine must be ProtocolTransitions.
	 * <!-- end-model-doc -->
	 *
	 * @body region->forAll(r | r.transition->forAll(t | t.oclIsTypeOf(ProtocolTransition)))
	 */
	def validate_protocol_transitions: Boolean  = {
    	// Start of user code for "protocol_transitions"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLProtocolStateMachine
