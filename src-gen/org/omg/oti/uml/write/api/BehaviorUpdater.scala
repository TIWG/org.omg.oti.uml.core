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

import scala.{AnyVal,Boolean,Option,Unit}
import scala.collection.immutable.{Seq,Set}
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class BehaviorUpdater[Uml <: UML](val domain: UMLBehavior[Uml]) extends AnyVal {

  def links_Behavior_behavior_compose_ownedParameter_Parameter
  (range: Seq[UMLParameter[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Behavior_behavior_compose_ownedParameter_Parameter(domain, range)

  def links_Behavior_behavior_compose_ownedParameterSet_ParameterSet
  (range: Set[UMLParameterSet[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Behavior_behavior_compose_ownedParameterSet_ParameterSet(domain, range)

  def links_Behavior_behavior_compose_postcondition_Constraint
  (range: Set[UMLConstraint[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Behavior_behavior_compose_postcondition_Constraint(domain, range)

  def links_Behavior_behavior_compose_precondition_Constraint
  (range: Set[UMLConstraint[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Behavior_behavior_compose_precondition_Constraint(domain, range)

  def links_Behavior_behavior_reference_redefinedBehavior_Behavior
  (range: Set[UMLBehavior[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Behavior_behavior_reference_redefinedBehavior_Behavior(domain, range)

  def links_Behavior_method_reference_specification_BehavioralFeature
  (range: Option[UMLBehavioralFeature[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Behavior_method_reference_specification_BehavioralFeature(domain, range)

  def setIsReentrant
  (isReentrant: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Behavior_isReentrant(domain, isReentrant)
}
