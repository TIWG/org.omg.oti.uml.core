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
package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code

/**
 * A Region is a top-level part of a StateMachine or a composite State, that serves as a container for the Vertices and Transitions of the StateMachine. A StateMachine or composite State may contain multiple Regions representing behaviors that may occur in parallel.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLRegionOps[Uml <: UML] { self: UMLRegion[Uml] =>

// Start of user code for class imports
	import self.ops._
// End of user code


	/**
	 * The region of which this region is an extension.
	 *
	 * <!-- Start of user code doc for extendedRegion -->
   * <!-- End of user code doc for extendedRegion -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLRegion.extendedRegion_region
	 */
	def extendedRegion: Option[UMLRegion[Uml]] = redefinedElement.selectByKindOf { case x: UMLRegion[Uml] => x } headOption

	/**
	 * References the Classifier in which context this element may be redefined.
	 *
	 * <!-- Start of user code doc for redefinitionContext -->
   * <!-- End of user code doc for redefinitionContext -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.redefinitionContext_region
	 * {{{
	 * OCL Body result = (let sm : StateMachine = containingStateMachine() in
	 * if sm._'context' = null or sm.general->notEmpty() then
	 *   sm
	 * else
	 *   sm._'context'
	 * endif)
	 * }}}
	 */
	override def redefinitionContext: Iterable[UMLClassifier[Uml]] = {
		// Start of user code for "redefinitionContext"
      ???
      // End of user code
	}

	/**
	 * The State that owns the Region. If a Region is owned by a State, then it cannot also be owned by a StateMachine.
	 *
	 * <!-- Start of user code doc for state -->
   * <!-- End of user code doc for state -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLState.region
	 */
	def state: Option[UMLState[Uml]] = namespace.selectByKindOf { case x: UMLState[Uml] => x }

	/**
	 * The StateMachine that owns the Region. If a Region is owned by a StateMachine, then it cannot also be owned by a State.
	 *
	 * <!-- Start of user code doc for stateMachine -->
   * <!-- End of user code doc for stateMachine -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLStateMachine.region
	 */
	def stateMachine: Option[UMLStateMachine[Uml]] = namespace.selectByKindOf { case x: UMLStateMachine[Uml] => x }

	/**
	 * The set of Vertices that are owned by this Region.
	 *
	 * <!-- Start of user code doc for subvertex -->
   * <!-- End of user code doc for subvertex -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLVertex.container
	 */
	def subvertex: Set[UMLVertex[Uml]] = ownedMember.selectByKindOf { case x: UMLVertex[Uml] => x }

	/**
	 * The set of Transitions owned by the Region.
	 *
	 * <!-- Start of user code doc for transition -->
   * <!-- End of user code doc for transition -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLTransition.container
	 */
	def transition: Set[UMLTransition[Uml]] = ownedMember.selectByKindOf { case x: UMLTransition[Uml] => x }

	/**
	 * <!-- Start of user code doc for extendedRegion_region -->
   * <!-- End of user code doc for extendedRegion_region -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLRegion.extendedRegion
	 */
	def extendedRegion_region: Set[UMLRegion[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLRegion[Uml] => x }

	/**
	 * The operation belongsToPSM () checks if the Region belongs to a ProtocolStateMachine.
	 *
	 * <!-- Start of user code doc for belongsToPSM -->
   * <!-- End of user code doc for belongsToPSM -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (if  stateMachine <> null 
	 * then
	 *   stateMachine.oclIsKindOf(ProtocolStateMachine)
	 * else 
	 *   state <> null  implies  state.container.belongsToPSM()
	 * endif )
	 * }}}
	 */
	def belongsToPSM: Boolean = {
		// Start of user code for "belongsToPSM"
      ???
      // End of user code
	}

	/**
	 * The operation containingStateMachine() returns the StateMachine in which this Region is defined.
	 *
	 * <!-- Start of user code doc for containingStateMachine -->
   * <!-- End of user code doc for containingStateMachine -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (if stateMachine = null 
	 * then
	 *   state.containingStateMachine()
	 * else
	 *   stateMachine
	 * endif)
	 * }}}
	 */
	def containingStateMachine: Option[UMLStateMachine[Uml]] = {
		// Start of user code for "containingStateMachine"
      ???
      // End of user code
	}

	/**
	 * The query isConsistentWith() specifies that a redefining Region is consistent with a redefined Region provided that the redefining Region is an extension of the Redefined region, i.e., its Vertices and Transitions conform to one of the following: (1) they are equal to corresponding elements of the redefined Region or, (2) they consistently redefine a State or Transition of the redefined region, or (3) they add new States or Transitions.
	 *
	 * <!-- Start of user code doc for isConsistentWith -->
   * <!-- End of user code doc for isConsistentWith -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (-- the following is merely a default body; it is expected that the specific form of this constraint will be specified by profiles
	 * true)
	 * }}}
	 */
	override def isConsistentWith(redefiningElement: Option[UMLRedefinableElement[Uml]]): Boolean = {
		// Start of user code for "isConsistentWith"
      ???
      // End of user code
	}

	/**
	 * The query isRedefinitionContextValid() specifies whether the redefinition contexts of a Region are properly related to the redefinition contexts of the specified Region to allow this element to redefine the other. The containing StateMachine or State of a redefining Region must Redefine the containing StateMachine or State of the redefined Region.
	 *
	 * <!-- Start of user code doc for isRedefinitionContextValid -->
   * <!-- End of user code doc for isRedefinitionContextValid -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (if redefinedElement.oclIsKindOf(Region) then
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
	 * }}}
	 */
	override def isRedefinitionContextValid(redefinedElement: Option[UMLRedefinableElement[Uml]]): Boolean = {
		// Start of user code for "isRedefinitionContextValid"
      ???
      // End of user code
	}

	/**
	 * A Region can have at most one deep history Vertex.
	 *
	 * <!-- Start of user code doc for validate_deep_history_vertex -->
   * <!-- End of user code doc for validate_deep_history_vertex -->
	 *
	 * {{{
	 * OCL Body self.subvertex->select (oclIsKindOf(Pseudostate))->collect(oclAsType(Pseudostate))->
	 *    select(kind = PseudostateKind::deepHistory)->size() <= 1
	 * }}}
	 */
	def validate_deep_history_vertex: Boolean = {
		// Start of user code for "deep_history_vertex"
      ???
      // End of user code
	}

	/**
	 * A Region can have at most one initial Vertex.
	 *
	 * <!-- Start of user code doc for validate_initial_vertex -->
   * <!-- End of user code doc for validate_initial_vertex -->
	 *
	 * {{{
	 * OCL Body self.subvertex->select (oclIsKindOf(Pseudostate))->collect(oclAsType(Pseudostate))->
	 *   select(kind = PseudostateKind::initial)->size() <= 1
	 * }}}
	 */
	def validate_initial_vertex: Boolean = {
		// Start of user code for "initial_vertex"
      ???
      // End of user code
	}

	/**
	 * If a Region is owned by a StateMachine, then it cannot also be owned by a State and vice versa.
	 *
	 * <!-- Start of user code doc for validate_owned -->
   * <!-- End of user code doc for validate_owned -->
	 *
	 * {{{
	 * OCL Body (stateMachine <> null implies state = null) and (state <> null implies stateMachine = null)
	 * }}}
	 */
	def validate_owned: Boolean = {
		// Start of user code for "owned"
      ???
      // End of user code
	}

	/**
	 * A Region can have at most one shallow history Vertex.
	 *
	 * <!-- Start of user code doc for validate_shallow_history_vertex -->
   * <!-- End of user code doc for validate_shallow_history_vertex -->
	 *
	 * {{{
	 * OCL Body subvertex->select(oclIsKindOf(Pseudostate))->collect(oclAsType(Pseudostate))->
	 *   select(kind = PseudostateKind::shallowHistory)->size() <= 1
	 * }}}
	 */
	def validate_shallow_history_vertex: Boolean = {
		// Start of user code for "shallow_history_vertex"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLRegionOps
