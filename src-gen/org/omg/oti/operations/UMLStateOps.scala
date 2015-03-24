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
 * A State models a situation during which some (usually implicit) invariant condition holds.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLStateOps[Uml <: UML] { self: UMLState[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The entry and exit connection points used in conjunction with this (submachine) State, i.e., as targets and sources, respectively, in the Region with the submachine State. A connection point reference references the corresponding definition of a connection point Pseudostate in the StateMachine referenced by the submachine State.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnectionPointReference.state
	 */
	def connection: Set[UMLConnectionPointReference[Uml]] = ownedMember.selectByKindOf { case x: UMLConnectionPointReference[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The entry and exit Pseudostates of a composite State. These can only be entry or exit Pseudostates, and they must have different names. They can only be defined for composite States.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPseudostate.state
	 */
	def connectionPoint: Set[UMLPseudostate[Uml]] = ownedMember.selectByKindOf { case x: UMLPseudostate[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * A list of Triggers that are candidates to be retained by the StateMachine if they trigger no Transitions out of the State (not consumed). A deferred Trigger is retained until the StateMachine reaches a State configuration where it is no longer deferred.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTrigger.deferrableTrigger_state
	 */
	def deferrableTrigger: Set[UMLTrigger[Uml]] = ownedElement.selectByKindOf { case x: UMLTrigger[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * A state with isComposite=true is said to be a composite State. A composite State is a State that contains at least one Region.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @body result = (region->notEmpty())
	 */
	def isComposite: Boolean = {
		// Start of user code for "isComposite"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A State with isOrthogonal=true is said to be an orthogonal composite State An orthogonal composite State contains two or more Regions.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @body result = (region->size () > 1)
	 */
	def isOrthogonal: Boolean = {
		// Start of user code for "isOrthogonal"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A State with isSimple=true is said to be a simple State A simple State does not have any Regions and it does not refer to any submachine StateMachine.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @body result = ((region->isEmpty()) and not isSubmachineState())
	 */
	def isSimple: Boolean = {
		// Start of user code for "isSimple"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A State with isSubmachineState=true is said to be a submachine State Such a State refers to another StateMachine(submachine).
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @body result = (submachine <> null)
	 */
	def isSubmachineState: Boolean = {
		// Start of user code for "isSubmachineState"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The State of which this State is a redefinition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLState.redefinedState_state
	 */
	def redefinedState: Option[UMLState[Uml]] = redefinedElement.selectByKindOf { case x: UMLState[Uml] => x } headOption

	/**
	 * <!-- begin-model-doc -->
	 * References the Classifier in which context this element may be redefined.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLClassifier.redefinitionContext_state
	 * @body result = (let sm : StateMachine = containingStateMachine() in
	 * if sm._'context' = null or sm.general->notEmpty() then
	 *   sm
	 * else
	 *   sm._'context'
	 * endif)
	 */
	override def redefinitionContext: Iterable[UMLClassifier[Uml]] = {
		// Start of user code for "redefinitionContext"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The Regions owned directly by the State.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRegion.state
	 */
	def region: Set[UMLRegion[Uml]] = ownedMember.selectByKindOf { case x: UMLRegion[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * Specifies conditions that are always true when this State is the current State. In ProtocolStateMachines state invariants are additional conditions to the preconditions of the outgoing Transitions, and to the postcondition of the incoming Transitions.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConstraint.stateInvariant_owningState
	 */
	def stateInvariant: Option[UMLConstraint[Uml]] = ownedRule headOption

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLState.redefinedState
	 */
	def redefinedState_state: Set[UMLState[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLState[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The query containingStateMachine() returns the StateMachine that contains the State either directly or transitively.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (container.containingStateMachine())
	 */
	override def containingStateMachine: Option[UMLStateMachine[Uml]]  = {
		// Start of user code for "containingStateMachine"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query isConsistentWith() specifies that a redefining State is consistent with a redefined State provided that the redefining State is an extension of the redefined State A simple State can be redefined (extended) to become a composite State (by adding one or more Regions) and a composite State can be redefined (extended) by adding Regions and by adding Vertices, States, and Transitions to inherited Regions. All States may add or replace entry, exit, and 'doActivity' Behaviors.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (-- the following is merely a default body; it is expected that the specific form of this constraint will be specified by profiles
	 * true)
	 */
	override def isConsistentWith(redefiningElement: Option[UMLRedefinableElement[Uml]]): Boolean  = {
		// Start of user code for "isConsistentWith"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query isRedefinitionContextValid() specifies whether the redefinition contexts of a State are properly related to the redefinition contexts of the specified State to allow this element to redefine the other. This means that the containing Region of a redefining State must redefine the containing Region of the redefined State.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if redefinedElement.oclIsKindOf(State) then
	 *   let redefinedState : State = redefinedElement.oclAsType(State) in
	 *     container.redefinedElement.oclAsType(Region)->exists(r:Region |
	 *       r.subvertex->includes(redefinedState))
	 * else
	 *   false
	 * endif)
	 */
	override def isRedefinitionContextValid(redefinedElement: Option[UMLRedefinableElement[Uml]]): Boolean  = {
		// Start of user code for "isRedefinitionContextValid"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * Only composite States can have entry or exit Pseudostates defined.
	 * <!-- end-model-doc -->
	 *
	 * @body connectionPoint->notEmpty() implies isComposite
	 */
	def validate_composite_states: Boolean  = {
		// Start of user code for "composite_states"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The connection point references used as destinations/sources of Transitions associated with a submachine State must be defined as entry/exit points in the submachine StateMachine.
	 * <!-- end-model-doc -->
	 *
	 * @body self.isSubmachineState implies (self.connection->forAll (cp |
	 *   cp.entry->forAll (ps | ps.stateMachine = self.submachine) and
	 *   cp.exit->forAll (ps | ps.stateMachine = self.submachine)))
	 */
	def validate_destinations_or_sources_of_transitions: Boolean  = {
		// Start of user code for "destinations_or_sources_of_transitions"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * Only entry or exit Pseudostates can serve as connection points.
	 * <!-- end-model-doc -->
	 *
	 * @body connectionPoint->forAll(kind = PseudostateKind::entryPoint or kind = PseudostateKind::exitPoint)
	 */
	def validate_entry_or_exit: Boolean  = {
		// Start of user code for "entry_or_exit"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A State is not allowed to have both a submachine and Regions.
	 * <!-- end-model-doc -->
	 *
	 * @body isComposite implies not isSubmachineState
	 */
	def validate_submachine_or_regions: Boolean  = {
		// Start of user code for "submachine_or_regions"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * Only submachine States can have connection point references.
	 * <!-- end-model-doc -->
	 *
	 * @body isSubmachineState implies connection->notEmpty( )
	 */
	def validate_submachine_states: Boolean  = {
		// Start of user code for "submachine_states"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLState
