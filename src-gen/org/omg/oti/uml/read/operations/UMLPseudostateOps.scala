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
  * A Pseudostate is an abstraction that encompasses different types of transient Vertices in the StateMachine graph. A StateMachine instance never comes to rest in a Pseudostate, instead, it will exit and enter the Pseudostate within a single run-to-completion step.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPseudostateOps[Uml <: UML] { self: UMLPseudostate[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The State that owns this Pseudostate and in which it appears.
    *
    * <!-- Start of user code doc for state -->
    * <!-- End of user code doc for state -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLState.connectionPoint
    */
  def state: Option[UMLState[Uml]] = namespace.selectByKindOf { case x: UMLState[Uml] => x }

  /**
    * The StateMachine in which this Pseudostate is defined. This only applies to Pseudostates of the kind entryPoint or exitPoint.
    *
    * <!-- Start of user code doc for stateMachine -->
    * <!-- End of user code doc for stateMachine -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStateMachine.connectionPoint
    */
  def stateMachine: Option[UMLStateMachine[Uml]] = namespace.selectByKindOf { case x: UMLStateMachine[Uml] => x }

  /**
    * In a complete statemachine, a choice Vertex must have at least one incoming and one outgoing Transition.
    *
    * <!-- Start of user code doc for validate_choice_vertex -->
    * <!-- End of user code doc for validate_choice_vertex -->
    *
    * {{{
    * OCL Body (kind = PseudostateKind::choice) implies (incoming->size() >= 1 and outgoing->size() >= 1)
    * }}}
    */
  def validate_choice_vertex: Boolean = {
    // Start of user code for "choice_vertex"
    ???
    // End of user code
  }

  /**
    * In a complete StateMachine, a fork Vertex must have at least two outgoing Transitions and exactly one incoming Transition.
    *
    * <!-- Start of user code doc for validate_fork_vertex -->
    * <!-- End of user code doc for validate_fork_vertex -->
    *
    * {{{
    * OCL Body (kind = PseudostateKind::fork) implies (incoming->size() = 1 and outgoing->size() >= 2)
    * }}}
    */
  def validate_fork_vertex: Boolean = {
    // Start of user code for "fork_vertex"
    ???
    // End of user code
  }

  /**
    * History Vertices can have at most one outgoing Transition.
    *
    * <!-- Start of user code doc for validate_history_vertices -->
    * <!-- End of user code doc for validate_history_vertices -->
    *
    * {{{
    * OCL Body ((kind = PseudostateKind::deepHistory) or (kind = PseudostateKind::shallowHistory)) implies (outgoing->size() <= 1)
    * }}}
    */
  def validate_history_vertices: Boolean = {
    // Start of user code for "history_vertices"
    ???
    // End of user code
  }

  /**
    * An initial Vertex can have at most one outgoing Transition.
    *
    * <!-- Start of user code doc for validate_initial_vertex -->
    * <!-- End of user code doc for validate_initial_vertex -->
    *
    * {{{
    * OCL Body (kind = PseudostateKind::initial) implies (outgoing->size() <= 1)
    * }}}
    */
  def validate_initial_vertex: Boolean = {
    // Start of user code for "initial_vertex"
    ???
    // End of user code
  }

  /**
    * In a complete StateMachine, a join Vertex must have at least two incoming Transitions and exactly one outgoing Transition.
    *
    * <!-- Start of user code doc for validate_join_vertex -->
    * <!-- End of user code doc for validate_join_vertex -->
    *
    * {{{
    * OCL Body (kind = PseudostateKind::join) implies (outgoing->size() = 1 and incoming->size() >= 2)
    * }}}
    */
  def validate_join_vertex: Boolean = {
    // Start of user code for "join_vertex"
    ???
    // End of user code
  }

  /**
    * In a complete StateMachine, a junction Vertex must have at least one incoming and one outgoing Transition.
    *
    * <!-- Start of user code doc for validate_junction_vertex -->
    * <!-- End of user code doc for validate_junction_vertex -->
    *
    * {{{
    * OCL Body (kind = PseudostateKind::junction) implies (incoming->size() >= 1 and outgoing->size() >= 1)
    * }}}
    */
  def validate_junction_vertex: Boolean = {
    // Start of user code for "junction_vertex"
    ???
    // End of user code
  }

  /**
    * The outgoing Transition from an initial vertex may have a behavior, but not a trigger or a guard.
    *
    * <!-- Start of user code doc for validate_outgoing_from_initial -->
    * <!-- End of user code doc for validate_outgoing_from_initial -->
    *
    * {{{
    * OCL Body (kind = PseudostateKind::initial) implies (outgoing.guard = null and outgoing.trigger->isEmpty())
    * }}}
    */
  def validate_outgoing_from_initial: Boolean = {
    // Start of user code for "outgoing_from_initial"
    ???
    // End of user code
  }

  /**
    * All Transitions incoming a join Vertex must originate in different Regions of an orthogonal State.
    *
    * <!-- Start of user code doc for validate_transitions_incoming -->
    * <!-- End of user code doc for validate_transitions_incoming -->
    *
    * {{{
    * OCL Body (kind = PseudostateKind::join) implies
    * -- for any pair of incoming transitions there exists an orthogonal state which contains the source vetices of these transitions 
    * -- such that these source vertices belong to different regions of that orthogonal state 
    * incoming->forAll(t1:Transition, t2:Transition | let contState:State = containingStateMachine().LCAState(t1.source, t2.source) in
    * 	((contState <> null) and (contState.region
    * 		->exists(r1:Region, r2: Region | (r1 <> r2) and t1.source.isContainedInRegion(r1) and t2.source.isContainedInRegion(r2)))))
    * }}}
    */
  def validate_transitions_incoming: Boolean = {
    // Start of user code for "transitions_incoming"
    ???
    // End of user code
  }

  /**
    * All transitions outgoing a fork vertex must target states in different regions of an orthogonal state.
    *
    * <!-- Start of user code doc for validate_transitions_outgoing -->
    * <!-- End of user code doc for validate_transitions_outgoing -->
    *
    * {{{
    * OCL Body (kind = PseudostateKind::fork) implies
    * -- for any pair of outgoing transitions there exists an orthogonal state which contains the targets of these transitions 
    * -- such that these targets belong to different regions of that orthogonal state 
    * outgoing->forAll(t1:Transition, t2:Transition | let contState:State = containingStateMachine().LCAState(t1.target, t2.target) in
    * 	((contState <> null) and (contState.region
    * 		->exists(r1:Region, r2: Region | (r1 <> r2) and t1.target.isContainedInRegion(r1) and t2.target.isContainedInRegion(r2)))))
    * 	
    * }}}
    */
  def validate_transitions_outgoing: Boolean = {
    // Start of user code for "transitions_outgoing"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLPseudostateOps
