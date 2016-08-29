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
class ActivityEdgeUpdater[Uml <: UML](val domain: UMLActivityEdge[Uml]) extends AnyVal {

  def links_ActivityEdge_activityEdge_compose_guard_ValueSpecification
  (range: Option[UMLValueSpecification[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_ActivityEdge_activityEdge_compose_guard_ValueSpecification(domain, range)

  def links_ActivityEdge_edge_reference_inPartition_ActivityPartition
  (range: Set[UMLActivityPartition[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_ActivityEdge_edge_reference_inPartition_ActivityPartition(domain, range)

  def links_ActivityEdge_interruptingEdge_reference_interrupts_InterruptibleActivityRegion
  (range: Option[UMLInterruptibleActivityRegion[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_ActivityEdge_interruptingEdge_reference_interrupts_InterruptibleActivityRegion(domain, range)

  def links_ActivityEdge_activityEdge_reference_redefinedEdge_ActivityEdge
  (range: Set[UMLActivityEdge[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_ActivityEdge_activityEdge_reference_redefinedEdge_ActivityEdge(domain, range)

  def links_ActivityEdge_outgoing_reference_source_ActivityNode
  (range: Option[UMLActivityNode[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_ActivityEdge_outgoing_reference_source_ActivityNode(domain, range)

  def links_ActivityEdge_incoming_reference_target_ActivityNode
  (range: Option[UMLActivityNode[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_ActivityEdge_incoming_reference_target_ActivityNode(domain, range)

  def links_ActivityEdge_activityEdge_compose_weight_ValueSpecification
  (range: Option[UMLValueSpecification[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_ActivityEdge_activityEdge_compose_weight_ValueSpecification(domain, range)
}
