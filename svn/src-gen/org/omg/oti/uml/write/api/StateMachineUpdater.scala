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
import scala.collection.immutable.Set
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class StateMachineUpdater[Uml <: UML](val domain: UMLStateMachine[Uml]) extends AnyVal {

  def links_StateMachine_stateMachine_compose_connectionPoint_Pseudostate
  (range: Set[UMLPseudostate[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_StateMachine_stateMachine_compose_connectionPoint_Pseudostate(domain, range)

  def links_StateMachine_stateMachine_reference_extendedStateMachine_StateMachine
  (range: Set[UMLStateMachine[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_StateMachine_stateMachine_reference_extendedStateMachine_StateMachine(domain, range)

  def links_StateMachine_stateMachine_compose_region_Region
  (range: Set[UMLRegion[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_StateMachine_stateMachine_compose_region_Region(domain, range)

  def links_StateMachine_submachine_reference_submachineState_State
  (range: Set[UMLState[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_StateMachine_submachine_reference_submachineState_State(domain, range)
}
