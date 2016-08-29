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
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * A StructuredActivityNode is an Action that is also an ActivityGroup and whose behavior is specified by the ActivityNodes and ActivityEdges it so contains. Unlike other kinds of ActivityGroup, a StructuredActivityNode owns the ActivityNodes and ActivityEdges it contains, and so a node or edge can only be directly contained in one StructuredActivityNode, though StructuredActivityNodes may be nested.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStructuredActivityNodeOps[Uml <: UML] { self: UMLStructuredActivityNode[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Activity immediately containing the StructuredActivityNode, if it is not contained in another StructuredActivityNode.
    *
    * <!-- Start of user code doc for activity -->
    * <!-- End of user code doc for activity -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivity.structuredNode
    */
  override def activity: Option[UMLActivity[Uml]] = inActivity

  /**
    * The ActivityEdges immediately contained in the StructuredActivityNode.
    *
    * <!-- Start of user code doc for edge -->
    * <!-- End of user code doc for edge -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityEdge.inStructuredNode
    */
  def edge: Set[UMLActivityEdge[Uml]] = containedEdge

  /**
    * The ActivityNodes immediately contained in the StructuredActivityNode.
    *
    * <!-- Start of user code doc for node -->
    * <!-- End of user code doc for node -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityNode.inStructuredNode
    */
  def node: Set[UMLActivityNode[Uml]] = containedNode

  /**
    * The InputPins owned by the StructuredActivityNode.
    *
    * <!-- Start of user code doc for structuredNodeInput -->
    * <!-- End of user code doc for structuredNodeInput -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.structuredNodeInput_structuredActivityNode
    */
  def structuredNodeInput: Set[UMLInputPin[Uml]] = input.toSet[UMLInputPin[Uml]]

  /**
    * The OutputPins owned by the StructuredActivityNode.
    *
    * <!-- Start of user code doc for structuredNodeOutput -->
    * <!-- End of user code doc for structuredNodeOutput -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.structuredNodeOutput_structuredActivityNode
    */
  def structuredNodeOutput: Set[UMLOutputPin[Uml]] = output.toSet[UMLOutputPin[Uml]]

  /**
    * The Variables defined in the scope of the StructuredActivityNode.
    *
    * <!-- Start of user code doc for variable -->
    * <!-- End of user code doc for variable -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLVariable.scope
    */
  def variable: Set[UMLVariable[Uml]] = ownedMember.selectByKindOf { case x: UMLVariable[Uml] => x }

  /**
    * Returns this StructuredActivityNode and all Actions contained in it.
    *
    * <!-- Start of user code doc for allActions -->
    * <!-- End of user code doc for allActions -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (node->select(oclIsKindOf(Action)).oclAsType(Action).allActions()->including(self)->asSet())
    * }}}
    */
  override def allActions: Set[UMLAction[Uml]] = {
    // Start of user code for "allActions"
    ???
    // End of user code
  }

  /**
    * Returns all the ActivityNodes contained directly or indirectly within this StructuredActivityNode, in addition to the Pins of the StructuredActivityNode.
    *
    * <!-- Start of user code doc for allOwnedNodes -->
    * <!-- End of user code doc for allOwnedNodes -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (self.Action::allOwnedNodes()->union(node)->union(node->select(oclIsKindOf(Action)).oclAsType(Action).allOwnedNodes())->asSet())
    * }}}
    */
  override def allOwnedNodes: Set[UMLActivityNode[Uml]] = {
    // Start of user code for "allOwnedNodes"
    ???
    // End of user code
  }

  /**
    * The Activity that directly or indirectly contains this StructuredActivityNode (considered as an Action).
    *
    * <!-- Start of user code doc for containingActivity -->
    * <!-- End of user code doc for containingActivity -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..1"
    * {{{
    * OCL Body result = (self.Action::containingActivity())
    * }}}
    */
  override def containingActivity: Option[UMLActivity[Uml]] = {
    // Start of user code for "containingActivity"
      activity.orElse(inStructuredNode.flatMap(_.containingActivity))
    // End of user code
  }

  /**
    * Return those ActivityNodes contained immediately within the StructuredActivityNode that may act as sources of edges owned by the StructuredActivityNode.
    *
    * <!-- Start of user code doc for sourceNodes -->
    * <!-- End of user code doc for sourceNodes -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (node->union(input.oclAsType(ActivityNode)->asSet())->
    *   union(node->select(oclIsKindOf(Action)).oclAsType(Action).output)->asSet())
    * }}}
    */
  def sourceNodes: Set[UMLActivityNode[Uml]] = {
    // Start of user code for "sourceNodes"
    ???
    // End of user code
  }

  /**
    * Return those ActivityNodes contained immediately within the StructuredActivityNode that may act as targets of edges owned by the StructuredActivityNode.
    *
    * <!-- Start of user code doc for targetNodes -->
    * <!-- End of user code doc for targetNodes -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (node->union(output.oclAsType(ActivityNode)->asSet())->
    *   union(node->select(oclIsKindOf(Action)).oclAsType(Action).input)->asSet())
    * }}}
    */
  def targetNodes: Set[UMLActivityNode[Uml]] = {
    // Start of user code for "targetNodes"
    ???
    // End of user code
  }

  /**
    * The edges of a StructuredActivityNode are all the ActivityEdges with source and target ActivityNodes contained directly or indirectly within the StructuredActivityNode and at least one of the source or target not contained in any more deeply nested StructuredActivityNode.
    *
    * <!-- Start of user code doc for validate_edges -->
    * <!-- End of user code doc for validate_edges -->
    *
    * {{{
    * OCL Body edge=self.sourceNodes().outgoing->intersection(self.allOwnedNodes().incoming)->
    * 	union(self.targetNodes().incoming->intersection(self.allOwnedNodes().outgoing))->asSet()
    * }}}
    */
  def validate_edges: Boolean = {
    // Start of user code for "edges"
    ???
    // End of user code
  }

  /**
    * The incoming ActivityEdges of an InputPin of a StructuredActivityNode must have sources that are not within the StructuredActivityNode.
    *
    * <!-- Start of user code doc for validate_input_pin_edges -->
    * <!-- End of user code doc for validate_input_pin_edges -->
    *
    * {{{
    * OCL Body input.incoming.source->excludesAll(allOwnedNodes()-output)
    * }}}
    */
  def validate_input_pin_edges: Boolean = {
    // Start of user code for "input_pin_edges"
    ???
    // End of user code
  }

  /**
    * The outgoing ActivityEdges of the OutputPins of a StructuredActivityNode must have targets that are not within the StructuredActivityNode.
    *
    * <!-- Start of user code doc for validate_output_pin_edges -->
    * <!-- End of user code doc for validate_output_pin_edges -->
    *
    * {{{
    * OCL Body output.outgoing.target->excludesAll(allOwnedNodes()-input)
    * }}}
    */
  def validate_output_pin_edges: Boolean = {
    // Start of user code for "output_pin_edges"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLStructuredActivityNodeOps
