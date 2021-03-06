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

import scala.{AnyVal,Unit}
import scala.collection.immutable.{Seq,Set}
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class InteractionUpdater[Uml <: UML](val domain: UMLInteraction[Uml]) extends AnyVal {

  def links_Interaction_interaction_compose_action_Action
  (range: Set[UMLAction[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Interaction_interaction_compose_action_Action(domain, range)

  def links_Interaction_interaction_compose_formalGate_Gate
  (range: Set[UMLGate[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Interaction_interaction_compose_formalGate_Gate(domain, range)

  def links_Interaction_enclosingInteraction_compose_fragment_InteractionFragment
  (range: Seq[UMLInteractionFragment[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Interaction_enclosingInteraction_compose_fragment_InteractionFragment(domain, range)

  def links_Interaction_interaction_compose_lifeline_Lifeline
  (range: Set[UMLLifeline[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Interaction_interaction_compose_lifeline_Lifeline(domain, range)

  def links_Interaction_interaction_compose_message_Message
  (range: Set[UMLMessage[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Interaction_interaction_compose_message_Message(domain, range)
}
