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
import scala.{Option,None,Some}
import scala.collection.immutable.Set
// End of user code

/**
  * An Action is the fundamental unit of executable functionality. The execution of an Action represents some transformation or processing in the modeled system. Actions provide the ExecutableNodes within Activities and may also be used within Interactions.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActionOps[Uml <: UML] { self: UMLAction[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The context Classifier of the Behavior that contains this Action, or the Behavior itself if it has no context.
    *
    * <!-- Start of user code doc for context -->
    * <!-- End of user code doc for context -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.context_action
    * {{{
    * OCL Body result = (let behavior: Behavior = self.containingBehavior() in
    * if behavior=null then null
    * else if behavior._'context' = null then behavior
    * else behavior._'context'
    * endif
    * endif)
    * }}}
    */
  def context: Option[UMLClassifier[Uml]] = {
    // Start of user code for "context"
    self.containingBehavior match {
      case None           =>
        None
      case Some(behavior) =>
        behavior.context.orElse(Some(behavior))
    }
    // End of user code
  }

  /**
    * <!-- Start of user code doc for action_interaction -->
    * <!-- End of user code doc for action_interaction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteraction.action
    */
  def action_interaction: Option[UMLInteraction[Uml]] = owner.selectByKindOf { case x: UMLInteraction[Uml] => x }

  /**
    * <!-- Start of user code doc for fromAction_actionInputPin -->
    * <!-- End of user code doc for fromAction_actionInputPin -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActionInputPin.fromAction
    */
  def fromAction_actionInputPin: Option[UMLActionInputPin[Uml]] = owner.selectByKindOf { case x: UMLActionInputPin[Uml] => x }

  /**
    * Return this Action and all Actions contained directly or indirectly in it. By default only the Action itself is returned, but the operation is overridden for StructuredActivityNodes.
    *
    * <!-- Start of user code doc for allActions -->
    * <!-- End of user code doc for allActions -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (self->asSet())
    * }}}
    */
  def allActions: Set[UMLAction[Uml]] = {
    // Start of user code for "allActions"
    Set(self)
    // End of user code
  }

  /**
    * Returns all the ActivityNodes directly or indirectly owned by this Action. This includes at least all the Pins of the Action.
    *
    * <!-- Start of user code doc for allOwnedNodes -->
    * <!-- End of user code doc for allOwnedNodes -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (input.oclAsType(Pin)->asSet()->union(output->asSet()))
    * }}}
    */
  def allOwnedNodes: Set[UMLActivityNode[Uml]] = {
    // Start of user code for "allOwnedNodes"
    input
    .toSet.union(output.toSet)
    // End of user code
  }

  /**
    * <!-- Start of user code doc for containingBehavior -->
    * <!-- End of user code doc for containingBehavior -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..1"
    * {{{
    * OCL Body result = (if inStructuredNode<>null then inStructuredNode.containingBehavior() 
    * else if activity<>null then activity
    * else interaction 
    * endif
    * endif
    * )
    * }}}
    */
  def containingBehavior: Option[UMLBehavior[Uml]] = {
    // Start of user code for "containingBehavior"
    inStructuredNode match {
      case Some(s) =>
        s.containingBehavior
      case None =>
        activity.orElse(action_interaction)
    }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLActionOps
