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
 * A Transition represents an arc between exactly one source Vertex and exactly one Target vertex (the source and targets may be the same Vertex). It may form part of a compound transition, which takes the StateMachine from one steady State configuration to another, representing the full response of the StateMachine to an occurrence of an Event that triggered it.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLTransitionOps[Uml <: UML] { self: UMLTransition[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * Designates the Region that owns this Transition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLRegion.transition
	 */
	def container: Option[UMLRegion[Uml]] = namespace.selectByKindOf { case x: UMLRegion[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * Specifies an optional behavior to be performed when the Transition fires.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.effect_transition
	 */
	def effect: Option[UMLBehavior[Uml]] = ownedElement.selectByKindOf { case x: UMLBehavior[Uml] => x } headOption

	/**
	 * <!-- begin-model-doc -->
	 * The Transition that is redefined by this Transition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLTransition.redefinedTransition_transition
	 */
	def redefinedTransition: Option[UMLTransition[Uml]] = redefinedElement.selectByKindOf { case x: UMLTransition[Uml] => x } headOption

	/**
	 * <!-- begin-model-doc -->
	 * References the Classifier in which context this element may be redefined.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLClassifier.redefinitionContext_transition
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
	 * Specifies the Triggers that may fire the transition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTrigger.trigger_transition
	 */
	def trigger: Set[UMLTrigger[Uml]] = ownedElement.selectByKindOf { case x: UMLTrigger[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTransition.redefinedTransition
	 */
	def redefinedTransition_transition: Set[UMLTransition[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLTransition[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The query containingStateMachine() returns the StateMachine that contains the Transition either directly or transitively.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (container.containingStateMachine())
	 */
	def containingStateMachine: Option[UMLStateMachine[Uml]]  = {
		// Start of user code for "containingStateMachine"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query isConsistentWith() specifies that a redefining Transition is consistent with a redefined Transition provided that the redefining Transition has the following relation to the redefined Transition: A redefining Transition redefines all properties of the corresponding redefined Transition except the source State and the Trigger.
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
	 * A fork segment must not have Guards or Triggers.
	 * <!-- end-model-doc -->
	 *
	 * @body (source.oclIsKindOf(Pseudostate) and source.oclAsType(Pseudostate).kind = PseudostateKind::fork) implies (guard = null and trigger->isEmpty())
	 */
	def validate_fork_segment_guards: Boolean  = {
		// Start of user code for "fork_segment_guards"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A fork segment must always target a State.
	 * <!-- end-model-doc -->
	 *
	 * @body (source.oclIsKindOf(Pseudostate) and  source.oclAsType(Pseudostate).kind = PseudostateKind::fork) implies (target.oclIsKindOf(State))
	 */
	def validate_fork_segment_state: Boolean  = {
		// Start of user code for "fork_segment_state"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * An initial Transition at the topmost level Region of a StateMachine that has no Trigger.
	 * <!-- end-model-doc -->
	 *
	 * @body (source.oclIsKindOf(Pseudostate) and container.stateMachine->notEmpty()) implies
	 * 	trigger->isEmpty()
	 */
	def validate_initial_transition: Boolean  = {
		// Start of user code for "initial_transition"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A join segment must not have Guards or Triggers.
	 * <!-- end-model-doc -->
	 *
	 * @body (target.oclIsKindOf(Pseudostate) and target.oclAsType(Pseudostate).kind = PseudostateKind::join) implies (guard = null and trigger->isEmpty())
	 */
	def validate_join_segment_guards: Boolean  = {
		// Start of user code for "join_segment_guards"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A join segment must always originate from a State.
	 * <!-- end-model-doc -->
	 *
	 * @body (target.oclIsKindOf(Pseudostate) and target.oclAsType(Pseudostate).kind = PseudostateKind::join) implies (source.oclIsKindOf(State))
	 */
	def validate_join_segment_state: Boolean  = {
		// Start of user code for "join_segment_state"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * Transitions outgoing Pseudostates may not have a Trigger.
	 * <!-- end-model-doc -->
	 *
	 * @body source.oclIsKindOf(Pseudostate) and (source.oclAsType(Pseudostate).kind <> PseudostateKind::initial) implies trigger->isEmpty()
	 */
	def validate_outgoing_pseudostates: Boolean  = {
		// Start of user code for "outgoing_pseudostates"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A Transition with kind external can source any Vertex except entry points.
	 * <!-- end-model-doc -->
	 *
	 * @body (kind = TransitionKind::external) implies
	 * 	not (source.oclIsKindOf(Pseudostate) and source.oclAsType(Pseudostate).kind = PseudostateKind::entryPoint)
	 */
	def validate_state_is_external: Boolean  = {
		// Start of user code for "state_is_external"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A Transition with kind internal must have a State as its source, and its source and target must be equal.
	 * <!-- end-model-doc -->
	 *
	 * @body (kind = TransitionKind::internal) implies
	 * 		(source.oclIsKindOf (State) and source = target)
	 */
	def validate_state_is_internal: Boolean  = {
		// Start of user code for "state_is_internal"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A Transition with kind local must have a composite State or an entry point as its source.
	 * <!-- end-model-doc -->
	 *
	 * @body (kind = TransitionKind::local) implies
	 * 		((source.oclIsKindOf (State) and source.oclAsType(State).isComposite) or
	 * 		(source.oclIsKindOf (Pseudostate) and source.oclAsType(Pseudostate).kind = PseudostateKind::entryPoint))
	 */
	def validate_state_is_local: Boolean  = {
		// Start of user code for "state_is_local"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLTransition
