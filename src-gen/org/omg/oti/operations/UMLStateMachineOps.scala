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
 * StateMachines can be used to express event-driven behaviors of parts of a system. Behavior is modeled as a traversal of a graph of Vertices interconnected by one or more joined Transition arcs that are triggered by the dispatching of successive Event occurrences. During this traversal, the StateMachine may execute a sequence of Behaviors associated with various elements of the StateMachine.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLStateMachineOps[Uml <: UML] { self: UMLStateMachine[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The connection points defined for this StateMachine. They represent the interface of the StateMachine when used as part of submachine State
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPseudostate.stateMachine
	 */
	def connectionPoint: Set[UMLPseudostate[Uml]] = ownedMember.selectByKindOf { case x: UMLPseudostate[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The StateMachines of which this is an extension.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLStateMachine.extendedStateMachine_stateMachine
	 */
	def extendedStateMachine: Set[UMLStateMachine[Uml]] = redefinedBehavior.selectByKindOf { case x: UMLStateMachine[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The Regions owned directly by the StateMachine.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLRegion.stateMachine
	 */
	def region: Set[UMLRegion[Uml]] = ownedMember.selectByKindOf { case x: UMLRegion[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLStateMachine.extendedStateMachine
	 */
	def extendedStateMachine_stateMachine: Set[UMLStateMachine[Uml]] = redefinedBehavior_behavior.selectByKindOf { case x: UMLStateMachine[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The operation LCA(s1,s2) returns the Region that is the least common ancestor of Vertices s1 and s2, based on the StateMachine containment hierarchy.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if ancestor(s1, s2) then 
	 *     s2.container
	 * else
	 * 	if ancestor(s2, s1) then
	 * 	    s1.container 
	 * 	else 
	 * 	    LCA(s1.container.state, s2.container.state)
	 * 	endif
	 * endif)
	 */
	def LCA(s1: Option[UMLVertex[Uml]], s2: Option[UMLVertex[Uml]]): Option[UMLRegion[Uml]]  = {
		// Start of user code for "LCA"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * This utility funciton is like the LCA, except that it returns the nearest composite State that contains both input Vertices.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if v2.oclIsTypeOf(State) and ancestor(v1, v2) then
	 * 	v2.oclAsType(State)
	 * else if v1.oclIsTypeOf(State) and ancestor(v2, v1) then
	 * 	v1.oclAsType(State)
	 * else if (v1.container.state->isEmpty() or v2.container.state->isEmpty()) then 
	 * 	null.oclAsType(State)
	 * else LCAState(v1.container.state, v2.container.state)
	 * endif endif endif)
	 */
	def LCAState(v1: Option[UMLVertex[Uml]], v2: Option[UMLVertex[Uml]]): Option[UMLState[Uml]]  = {
		// Start of user code for "LCAState"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query ancestor(s1, s2) checks whether Vertex s2 is an ancestor of Vertex s1.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if (s2 = s1) then 
	 * 	true 
	 * else 
	 * 	if s1.container.stateMachine->notEmpty() then 
	 * 	    true
	 * 	else 
	 * 	    if s2.container.stateMachine->notEmpty() then 
	 * 	        false
	 * 	    else
	 * 	        ancestor(s1, s2.container.state)
	 * 	     endif
	 * 	 endif
	 * endif  )
	 */
	def ancestor(s1: Option[UMLVertex[Uml]], s2: Option[UMLVertex[Uml]]): Boolean  = {
		// Start of user code for "ancestor"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query isConsistentWith() specifies that a redefining StateMachine is consistent with a redefined StateMachine provided that the redefining StateMachine is an extension of the redefined StateMachine : Regions are inherited and Regions can be added, inherited Regions can be redefined. In case of multiple redefining StateMachine, extension implies that the redefining StateMachine gets orthogonal Regions for each of the redefined StateMachine.
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
	 * The query isRedefinitionContextValid() specifies whether the redefinition context of a StateMachine is properly related to the redefinition contexts of the specified StateMachine to allow this element to redefine the other. The context Classifier of a redefining StateMachine must redefine the context Classifier of the redefined StateMachine.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if redefinedElement.oclIsKindOf(StateMachine) then
	 *   let redefinedStateMachine : StateMachine = redefinedElement.oclAsType(StateMachine) in
	 *     self._'context'().oclAsType(BehavioredClassifier).redefinedClassifier->
	 *       includes(redefinedStateMachine._'context'())
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
	 * The connection points of a StateMachine are Pseudostates of kind entry point or exit point.
	 * <!-- end-model-doc -->
	 *
	 * @body connectionPoint->forAll (kind = PseudostateKind::entryPoint or kind = PseudostateKind::exitPoint)
	 */
	def validate_connection_points: Boolean  = {
		// Start of user code for "connection_points"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The context Classifier of the method StateMachine of a BehavioralFeature must be the Classifier that owns the BehavioralFeature.
	 * <!-- end-model-doc -->
	 *
	 * @body specification <> null implies ( _'context' <> null and specification.featuringClassifier->exists(c | c = _'context'))
	 */
	def validate_context_classifier: Boolean  = {
		// Start of user code for "context_classifier"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A StateMachine as the method for a BehavioralFeature cannot have entry/exit connection points.
	 * <!-- end-model-doc -->
	 *
	 * @body specification <> null implies connectionPoint->isEmpty()
	 */
	def validate_method: Boolean  = {
		// Start of user code for "method"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The Classifier context of a StateMachine cannot be an Interface.
	 * <!-- end-model-doc -->
	 *
	 * @body _'context' <> null implies not _'context'.oclIsKindOf(Interface)
	 */
	def validate_state_machine_classifier_context: Boolean  = {
		// Start of user code for "state_machine_classifier_context"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLStateMachine
