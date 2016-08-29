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
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
// End of user code

/**
  * A Transition represents an arc between exactly one source Vertex and exactly one Target vertex (the source and targets may be the same Vertex). It may form part of a compound transition, which takes the StateMachine from one steady State configuration to another, representing the full response of the StateMachine to an occurrence of an Event that triggered it.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTransitionOps[Uml <: UML] { self: UMLTransition[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Designates the Region that owns this Transition.
    *
    * <!-- Start of user code doc for container -->
    * <!-- End of user code doc for container -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRegion.transition
    */
  def container: Option[UMLRegion[Uml]] = namespace.selectByKindOf { case x: UMLRegion[Uml] => x }

  /**
    * Specifies an optional behavior to be performed when the Transition fires.
    *
    * <!-- Start of user code doc for effect -->
    * <!-- End of user code doc for effect -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.effect_transition
    */
  def effect: Option[UMLBehavior[Uml]] = ownedElement.selectByKindOf { case x: UMLBehavior[Uml] => x } headOption

  /**
    * The Transition that is redefined by this Transition.
    *
    * <!-- Start of user code doc for redefinedTransition -->
    * <!-- End of user code doc for redefinedTransition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTransition.redefinedTransition_transition
    */
  def redefinedTransition: Option[UMLTransition[Uml]] = redefinedElement.selectByKindOf { case x: UMLTransition[Uml] => x } headOption

  /**
    * References the Classifier in which context this element may be redefined.
    *
    * <!-- Start of user code doc for redefinitionContext -->
    * <!-- End of user code doc for redefinitionContext -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.redefinitionContext_transition
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
    * Specifies the Triggers that may fire the transition.
    *
    * <!-- Start of user code doc for trigger -->
    * <!-- End of user code doc for trigger -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTrigger.trigger_transition
    */
  def trigger: Set[UMLTrigger[Uml]] = ownedElement.selectByKindOf { case x: UMLTrigger[Uml] => x }

  /**
    * <!-- Start of user code doc for redefinedTransition_transition -->
    * <!-- End of user code doc for redefinedTransition_transition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTransition.redefinedTransition
    */
  def redefinedTransition_transition: Set[UMLTransition[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLTransition[Uml] => x }

  /**
    * The query containingStateMachine() returns the StateMachine that contains the Transition either directly or transitively.
    *
    * <!-- Start of user code doc for containingStateMachine -->
    * <!-- End of user code doc for containingStateMachine -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (container.containingStateMachine())
    * }}}
    */
  def containingStateMachine: Option[UMLStateMachine[Uml]] = {
    // Start of user code for "containingStateMachine"
    ???
    // End of user code
  }

  /**
    * The query isConsistentWith() specifies that a redefining Transition is consistent with a redefined Transition provided that the redefining Transition has the following relation to the redefined Transition: A redefining Transition redefines all properties of the corresponding redefined Transition except the source State and the Trigger.
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
    * A fork segment must not have Guards or Triggers.
    *
    * <!-- Start of user code doc for validate_fork_segment_guards -->
    * <!-- End of user code doc for validate_fork_segment_guards -->
    *
    * {{{
    * OCL Body (source.oclIsKindOf(Pseudostate) and source.oclAsType(Pseudostate).kind = PseudostateKind::fork) implies (guard = null and trigger->isEmpty())
    * }}}
    */
  def validate_fork_segment_guards: Boolean = {
    // Start of user code for "fork_segment_guards"
    ???
    // End of user code
  }

  /**
    * A fork segment must always target a State.
    *
    * <!-- Start of user code doc for validate_fork_segment_state -->
    * <!-- End of user code doc for validate_fork_segment_state -->
    *
    * {{{
    * OCL Body (source.oclIsKindOf(Pseudostate) and  source.oclAsType(Pseudostate).kind = PseudostateKind::fork) implies (target.oclIsKindOf(State))
    * }}}
    */
  def validate_fork_segment_state: Boolean = {
    // Start of user code for "fork_segment_state"
    ???
    // End of user code
  }

  /**
    * An initial Transition at the topmost level Region of a StateMachine that has no Trigger.
    *
    * <!-- Start of user code doc for validate_initial_transition -->
    * <!-- End of user code doc for validate_initial_transition -->
    *
    * {{{
    * OCL Body (source.oclIsKindOf(Pseudostate) and container.stateMachine->notEmpty()) implies
    * 	trigger->isEmpty()
    * }}}
    */
  def validate_initial_transition: Boolean = {
    // Start of user code for "initial_transition"
    ???
    // End of user code
  }

  /**
    * A join segment must not have Guards or Triggers.
    *
    * <!-- Start of user code doc for validate_join_segment_guards -->
    * <!-- End of user code doc for validate_join_segment_guards -->
    *
    * {{{
    * OCL Body (target.oclIsKindOf(Pseudostate) and target.oclAsType(Pseudostate).kind = PseudostateKind::join) implies (guard = null and trigger->isEmpty())
    * }}}
    */
  def validate_join_segment_guards: Boolean = {
    // Start of user code for "join_segment_guards"
    ???
    // End of user code
  }

  /**
    * A join segment must always originate from a State.
    *
    * <!-- Start of user code doc for validate_join_segment_state -->
    * <!-- End of user code doc for validate_join_segment_state -->
    *
    * {{{
    * OCL Body (target.oclIsKindOf(Pseudostate) and target.oclAsType(Pseudostate).kind = PseudostateKind::join) implies (source.oclIsKindOf(State))
    * }}}
    */
  def validate_join_segment_state: Boolean = {
    // Start of user code for "join_segment_state"
    ???
    // End of user code
  }

  /**
    * Transitions outgoing Pseudostates may not have a Trigger.
    *
    * <!-- Start of user code doc for validate_outgoing_pseudostates -->
    * <!-- End of user code doc for validate_outgoing_pseudostates -->
    *
    * {{{
    * OCL Body source.oclIsKindOf(Pseudostate) and (source.oclAsType(Pseudostate).kind <> PseudostateKind::initial) implies trigger->isEmpty()
    * }}}
    */
  def validate_outgoing_pseudostates: Boolean = {
    // Start of user code for "outgoing_pseudostates"
    ???
    // End of user code
  }

  /**
    * A Transition with kind external can source any Vertex except entry points.
    *
    * <!-- Start of user code doc for validate_state_is_external -->
    * <!-- End of user code doc for validate_state_is_external -->
    *
    * {{{
    * OCL Body (kind = TransitionKind::external) implies
    * 	not (source.oclIsKindOf(Pseudostate) and source.oclAsType(Pseudostate).kind = PseudostateKind::entryPoint)
    * }}}
    */
  def validate_state_is_external: Boolean = {
    // Start of user code for "state_is_external"
    ???
    // End of user code
  }

  /**
    * A Transition with kind internal must have a State as its source, and its source and target must be equal.
    *
    * <!-- Start of user code doc for validate_state_is_internal -->
    * <!-- End of user code doc for validate_state_is_internal -->
    *
    * {{{
    * OCL Body (kind = TransitionKind::internal) implies
    * 		(source.oclIsKindOf (State) and source = target)
    * }}}
    */
  def validate_state_is_internal: Boolean = {
    // Start of user code for "state_is_internal"
    ???
    // End of user code
  }

  /**
    * A Transition with kind local must have a composite State or an entry point as its source.
    *
    * <!-- Start of user code doc for validate_state_is_local -->
    * <!-- End of user code doc for validate_state_is_local -->
    *
    * {{{
    * OCL Body (kind = TransitionKind::local) implies
    * 		((source.oclIsKindOf (State) and source.oclAsType(State).isComposite) or
    * 		(source.oclIsKindOf (Pseudostate) and source.oclAsType(Pseudostate).kind = PseudostateKind::entryPoint))
    * }}}
    */
  def validate_state_is_local: Boolean = {
    // Start of user code for "state_is_local"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLTransitionOps
