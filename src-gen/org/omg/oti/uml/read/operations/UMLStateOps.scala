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
  * A State models a situation during which some (usually implicit) invariant condition holds.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStateOps[Uml <: UML] { self: UMLState[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The entry and exit connection points used in conjunction with this (submachine) State, i.e., as targets and sources, respectively, in the Region with the submachine State. A connection point reference references the corresponding definition of a connection point Pseudostate in the StateMachine referenced by the submachine State.
    *
    * <!-- Start of user code doc for connection -->
    * <!-- End of user code doc for connection -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnectionPointReference.state
    */
  def connection: Set[UMLConnectionPointReference[Uml]] = ownedMember.selectByKindOf { case x: UMLConnectionPointReference[Uml] => x }

  /**
    * The entry and exit Pseudostates of a composite State. These can only be entry or exit Pseudostates, and they must have different names. They can only be defined for composite States.
    *
    * <!-- Start of user code doc for connectionPoint -->
    * <!-- End of user code doc for connectionPoint -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPseudostate.state
    */
  def connectionPoint: Set[UMLPseudostate[Uml]] = ownedMember.selectByKindOf { case x: UMLPseudostate[Uml] => x }

  /**
    * A list of Triggers that are candidates to be retained by the StateMachine if they trigger no Transitions out of the State (not consumed). A deferred Trigger is retained until the StateMachine reaches a State configuration where it is no longer deferred.
    *
    * <!-- Start of user code doc for deferrableTrigger -->
    * <!-- End of user code doc for deferrableTrigger -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTrigger.deferrableTrigger_state
    */
  def deferrableTrigger: Set[UMLTrigger[Uml]] = ownedElement.selectByKindOf { case x: UMLTrigger[Uml] => x }

  /**
    * A state with isComposite=true is said to be a composite State. A composite State is a State that contains at least one Region.
    *
    * <!-- Start of user code doc for isComposite -->
    * <!-- End of user code doc for isComposite -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * {{{
    * OCL Body result = (region->notEmpty())
    * }}}
    */
  def isComposite: Boolean = {
    // Start of user code for "isComposite"
    ???
    // End of user code
  }

  /**
    * A State with isOrthogonal=true is said to be an orthogonal composite State An orthogonal composite State contains two or more Regions.
    *
    * <!-- Start of user code doc for isOrthogonal -->
    * <!-- End of user code doc for isOrthogonal -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * {{{
    * OCL Body result = (region->size () > 1)
    * }}}
    */
  def isOrthogonal: Boolean = {
    // Start of user code for "isOrthogonal"
    ???
    // End of user code
  }

  /**
    * A State with isSimple=true is said to be a simple State A simple State does not have any Regions and it does not refer to any submachine StateMachine.
    *
    * <!-- Start of user code doc for isSimple -->
    * <!-- End of user code doc for isSimple -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * {{{
    * OCL Body result = ((region->isEmpty()) and not isSubmachineState())
    * }}}
    */
  def isSimple: Boolean = {
    // Start of user code for "isSimple"
    ???
    // End of user code
  }

  /**
    * A State with isSubmachineState=true is said to be a submachine State Such a State refers to another StateMachine(submachine).
    *
    * <!-- Start of user code doc for isSubmachineState -->
    * <!-- End of user code doc for isSubmachineState -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * {{{
    * OCL Body result = (submachine <> null)
    * }}}
    */
  def isSubmachineState: Boolean = {
    // Start of user code for "isSubmachineState"
    ???
    // End of user code
  }

  /**
    * The State of which this State is a redefinition.
    *
    * <!-- Start of user code doc for redefinedState -->
    * <!-- End of user code doc for redefinedState -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLState.redefinedState_state
    */
  def redefinedState: Option[UMLState[Uml]] = redefinedElement.selectByKindOf { case x: UMLState[Uml] => x } headOption

  /**
    * References the Classifier in which context this element may be redefined.
    *
    * <!-- Start of user code doc for redefinitionContext -->
    * <!-- End of user code doc for redefinitionContext -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.redefinitionContext_state
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
    * The Regions owned directly by the State.
    *
    * <!-- Start of user code doc for region -->
    * <!-- End of user code doc for region -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRegion.state
    */
  def region: Set[UMLRegion[Uml]] = ownedMember.selectByKindOf { case x: UMLRegion[Uml] => x }

  /**
    * <!-- Start of user code doc for redefinedState_state -->
    * <!-- End of user code doc for redefinedState_state -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLState.redefinedState
    */
  def redefinedState_state: Set[UMLState[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLState[Uml] => x }

  /**
    * The query containingStateMachine() returns the StateMachine that contains the State either directly or transitively.
    *
    * <!-- Start of user code doc for containingStateMachine -->
    * <!-- End of user code doc for containingStateMachine -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (container.containingStateMachine())
    * }}}
    */
  override def containingStateMachine: Option[UMLStateMachine[Uml]] = {
    // Start of user code for "containingStateMachine"
    ???
    // End of user code
  }

  /**
    * The query isConsistentWith() specifies that a redefining State is consistent with a redefined State provided that the redefining State is an extension of the redefined State A simple State can be redefined (extended) to become a composite State (by adding one or more Regions) and a composite State can be redefined (extended) by adding Regions and by adding Vertices, States, and Transitions to inherited Regions. All States may add or replace entry, exit, and 'doActivity' Behaviors.
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
    * The query isRedefinitionContextValid() specifies whether the redefinition contexts of a State are properly related to the redefinition contexts of the specified State to allow this element to redefine the other. This means that the containing Region of a redefining State must redefine the containing Region of the redefined State.
    *
    * <!-- Start of user code doc for isRedefinitionContextValid -->
    * <!-- End of user code doc for isRedefinitionContextValid -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (if redefinedElement.oclIsKindOf(State) then
    *   let redefinedState : State = redefinedElement.oclAsType(State) in
    *     container.redefinedElement.oclAsType(Region)->exists(r:Region |
    *       r.subvertex->includes(redefinedState))
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
    * Only composite States can have entry or exit Pseudostates defined.
    *
    * <!-- Start of user code doc for validate_composite_states -->
    * <!-- End of user code doc for validate_composite_states -->
    *
    * {{{
    * OCL Body connectionPoint->notEmpty() implies isComposite
    * }}}
    */
  def validate_composite_states: Boolean = {
    // Start of user code for "composite_states"
    ???
    // End of user code
  }

  /**
    * The connection point references used as destinations/sources of Transitions associated with a submachine State must be defined as entry/exit points in the submachine StateMachine.
    *
    * <!-- Start of user code doc for validate_destinations_or_sources_of_transitions -->
    * <!-- End of user code doc for validate_destinations_or_sources_of_transitions -->
    *
    * {{{
    * OCL Body self.isSubmachineState implies (self.connection->forAll (cp |
    *   cp.entry->forAll (ps | ps.stateMachine = self.submachine) and
    *   cp.exit->forAll (ps | ps.stateMachine = self.submachine)))
    * }}}
    */
  def validate_destinations_or_sources_of_transitions: Boolean = {
    // Start of user code for "destinations_or_sources_of_transitions"
    ???
    // End of user code
  }

  /**
    * Only entry or exit Pseudostates can serve as connection points.
    *
    * <!-- Start of user code doc for validate_entry_or_exit -->
    * <!-- End of user code doc for validate_entry_or_exit -->
    *
    * {{{
    * OCL Body connectionPoint->forAll(kind = PseudostateKind::entryPoint or kind = PseudostateKind::exitPoint)
    * }}}
    */
  def validate_entry_or_exit: Boolean = {
    // Start of user code for "entry_or_exit"
    ???
    // End of user code
  }

  /**
    * A State is not allowed to have both a submachine and Regions.
    *
    * <!-- Start of user code doc for validate_submachine_or_regions -->
    * <!-- End of user code doc for validate_submachine_or_regions -->
    *
    * {{{
    * OCL Body isComposite implies not isSubmachineState
    * }}}
    */
  def validate_submachine_or_regions: Boolean = {
    // Start of user code for "submachine_or_regions"
    ???
    // End of user code
  }

  /**
    * Only submachine States can have connection point references.
    *
    * <!-- Start of user code doc for validate_submachine_states -->
    * <!-- End of user code doc for validate_submachine_states -->
    *
    * {{{
    * OCL Body isSubmachineState implies connection->notEmpty( )
    * }}}
    */
  def validate_submachine_states: Boolean = {
    // Start of user code for "submachine_states"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLStateOps
