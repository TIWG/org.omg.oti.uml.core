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
import scala.{AnyVal,Boolean,Unit}
import scala.collection.immutable.Set
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class StructuredActivityNodeUpdater[Uml <: UML](val domain: UMLStructuredActivityNode[Uml]) extends AnyVal {

  def links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge
  (range: Set[UMLActivityEdge[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge(domain, range)

  def links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode
  (range: Set[UMLActivityNode[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode(domain, range)

  def links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin
  (range: Set[UMLInputPin[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin(domain, range)

  def links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin
  (range: Set[UMLOutputPin[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin(domain, range)

  def links_StructuredActivityNode_scope_compose_variable_Variable
  (range: Set[UMLVariable[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_StructuredActivityNode_scope_compose_variable_Variable(domain, range)

  def setMustIsolate
  (mustIsolate: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_StructuredActivityNode_mustIsolate(domain, mustIsolate)
}
