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

package org.omg.oti.uml.write.api

// Start of user code for imports
import org.omg.oti.uml.read.api._

import scala.{AnyVal,Option,Unit}
import scala.collection.immutable.Set
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class TransitionUpdater[Uml <: UML](val domain: UMLTransition[Uml]) extends AnyVal {

  def links_Transition_transition_compose_effect_Behavior
  (range: Option[UMLBehavior[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Transition_transition_compose_effect_Behavior(domain, range)

  def links_Transition_transition_compose_guard_Constraint
  (range: Option[UMLConstraint[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Transition_transition_compose_guard_Constraint(domain, range)

  def links_Transition_transition_reference_redefinedTransition_Transition
  (range: Option[UMLTransition[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Transition_transition_reference_redefinedTransition_Transition(domain, range)

  def links_Transition_outgoing_reference_source_Vertex
  (range: Option[UMLVertex[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Transition_outgoing_reference_source_Vertex(domain, range)

  def links_Transition_incoming_reference_target_Vertex
  (range: Option[UMLVertex[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Transition_incoming_reference_target_Vertex(domain, range)

  def links_Transition_transition_compose_trigger_Trigger
  (range: Set[UMLTrigger[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Transition_transition_compose_trigger_Trigger(domain, range)

  def setKind
  (kind: Option[UMLTransitionKind.Value])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Transition_kind(domain, kind)
}
