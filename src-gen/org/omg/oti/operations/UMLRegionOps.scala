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
 * A Region is a top-level part of a StateMachine or a composite State, that serves as a container for the Vertices and Transitions of the StateMachine. A StateMachine or composite State may contain multiple Regions representing behaviors that may occur in parallel.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLRegionOps[Uml <: UML] { self: UMLRegion[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The region of which this region is an extension.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLRegion.extendedRegion_region
	 */
	def extendedRegion: Option[UMLRegion[Uml]] = redefinedElement.selectByKindOf { case x: UMLRegion[Uml] => x } headOption

	/**
	 * <!-- begin-model-doc -->
	 * References the Classifier in which context this element may be redefined.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLClassifier.redefinitionContext_region
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
	 * The State that owns the Region. If a Region is owned by a State, then it cannot also be owned by a StateMachine.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLState.region
	 */
	def state: Option[UMLState[Uml]] = namespace.selectByKindOf { case x: UMLState[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The StateMachine that owns the Region. If a Region is owned by a StateMachine, then it cannot also be owned by a State.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStateMachine.region
	 */
	def stateMachine: Option[UMLStateMachine[Uml]] = namespace.selectByKindOf { case x: UMLStateMachine[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The set of Vertices that are owned by this Region.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLVertex.container
	 */
	def subvertex: Set[UMLVertex[Uml]] = ownedMember.selectByKindOf { case x: UMLVertex[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The set of Transitions owned by the Region.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTransition.container
	 */
	def transition: Set[UMLTransition[Uml]] = ownedMember.selectByKindOf { case x: UMLTransition[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRegion.extendedRegion
	 */
	def extendedRegion_region: Set[UMLRegion[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLRegion[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The operation belongsToPSM () checks if the Region belongs to a ProtocolStateMachine.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if  stateMachine <> null 
	 * then
	 *   stateMachine.oclIsKindOf(ProtocolStateMachine)
	 * else 
	 *   state <> null  implies  state.container.belongsToPSM()
	 * endif )
	 */
	def belongsToPSM: Boolean  = {
		// Start of user code for "belongsToPSM"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The operation containingStateMachine() returns the StateMachine in which this Region is defined.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if stateMachine = null 
	 * then
	 *   state.containingStateMachine()
	 * else
	 *   stateMachine
	 * endif)
	 */
	def containingStateMachine: Option[UMLStateMachine[Uml]]  = {
		// Start of user code for "containingStateMachine"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query isConsistentWith() specifies that a redefining Region is consistent with a redefined Region provided that the redefining Region is an extension of the Redefined region, i.e., its Vertices and Transitions conform to one of the following: (1) they are equal to corresponding elements of the redefined Region or, (2) they consistently redefine a State or Transition of the redefined region, or (3) they add new States or Transitions.
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
	 * The query isRedefinitionContextValid() specifies whether the redefinition contexts of a Region are properly related to the redefinition contexts of the specified Region to allow this element to redefine the other. The containing StateMachine or State of a redefining Region must Redefine the containing StateMachine or State of the redefined Region.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if redefinedElement.oclIsKindOf(Region) then
	 *   let redefinedRegion : Region = redefinedElement.oclAsType(Region) in
	 *     if stateMachine->isEmpty() then
	 *     -- the Region is owned by a State
	 *       (state.redefinedState->notEmpty() and state.redefinedState.region->includes(redefinedRegion))
	 *     else -- the region is owned by a StateMachine
	 *       (stateMachine.extendedStateMachine->notEmpty() and
	 *         stateMachine.extendedStateMachine->exists(sm : StateMachine |
	 *           sm.region->includes(redefinedRegion)))
	 *     endif
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
	 * A Region can have at most one deep history Vertex.
	 * <!-- end-model-doc -->
	 *
	 * @body self.subvertex->select (oclIsKindOf(Pseudostate))->collect(oclAsType(Pseudostate))->
	 *    select(kind = PseudostateKind::deepHistory)->size() <= 1
	 */
	def validate_deep_history_vertex: Boolean  = {
		// Start of user code for "deep_history_vertex"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A Region can have at most one initial Vertex.
	 * <!-- end-model-doc -->
	 *
	 * @body self.subvertex->select (oclIsKindOf(Pseudostate))->collect(oclAsType(Pseudostate))->
	 *   select(kind = PseudostateKind::initial)->size() <= 1
	 */
	def validate_initial_vertex: Boolean  = {
		// Start of user code for "initial_vertex"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If a Region is owned by a StateMachine, then it cannot also be owned by a State and vice versa.
	 * <!-- end-model-doc -->
	 *
	 * @body (stateMachine <> null implies state = null) and (state <> null implies stateMachine = null)
	 */
	def validate_owned: Boolean  = {
		// Start of user code for "owned"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A Region can have at most one shallow history Vertex.
	 * <!-- end-model-doc -->
	 *
	 * @body subvertex->select(oclIsKindOf(Pseudostate))->collect(oclAsType(Pseudostate))->
	 *   select(kind = PseudostateKind::shallowHistory)->size() <= 1
	 */
	def validate_shallow_history_vertex: Boolean  = {
		// Start of user code for "shallow_history_vertex"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLRegion
