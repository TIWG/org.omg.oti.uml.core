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
package org.omg.oti.uml.write.api

// Start of user code for imports
import org.omg.oti.uml.read.api._

import scala.{AnyVal,Boolean,Unit}
import scala.collection.immutable.Set
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class ActivityUpdater[Uml <: UML](val domain: UMLActivity[Uml]) extends AnyVal {

  def links_Activity_activity_compose_edge_ActivityEdge
  (range: Set[UMLActivityEdge[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[NonEmptyList[java.lang.Throwable],Unit] =
    umlU.links_Activity_activity_compose_edge_ActivityEdge(domain, range)

  def links_Activity_inActivity_compose_group_ActivityGroup
  (range: Set[UMLActivityGroup[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[NonEmptyList[java.lang.Throwable],Unit] =
    umlU.links_Activity_inActivity_compose_group_ActivityGroup(domain, range)

  def links_Activity_activity_compose_node_ActivityNode
  (range: Set[UMLActivityNode[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[NonEmptyList[java.lang.Throwable],Unit] =
    umlU.links_Activity_activity_compose_node_ActivityNode(domain, range)

  def links_Activity_activity_reference_partition_ActivityPartition
  (range: Set[UMLActivityPartition[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[NonEmptyList[java.lang.Throwable],Unit] =
    umlU.links_Activity_activity_reference_partition_ActivityPartition(domain, range)

  def links_Activity_activity_compose_structuredNode_StructuredActivityNode
  (range: Set[UMLStructuredActivityNode[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[NonEmptyList[java.lang.Throwable],Unit] =
    umlU.links_Activity_activity_compose_structuredNode_StructuredActivityNode(domain, range)

  def links_Activity_activityScope_compose_variable_Variable
  (range: Set[UMLVariable[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[NonEmptyList[java.lang.Throwable],Unit] =
    umlU.links_Activity_activityScope_compose_variable_Variable(domain, range)

  def setIsReadOnly
  (isReadOnly: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[NonEmptyList[java.lang.Throwable],Unit] =
    umlU.set_Activity_isReadOnly(domain, isReadOnly)

  def setIsSingleExecution
  (isSingleExecution: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[NonEmptyList[java.lang.Throwable],Unit] =
    umlU.set_Activity_isSingleExecution(domain, isSingleExecution)
}
