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
package org.omg.oti.uml.read.operations

// Start of user code for imports

import org.omg.oti.uml.read.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * A StructuredActivityNode is an Action that is also an ActivityGroup and whose behavior is specified by the ActivityNodes and ActivityEdges it so contains. Unlike other kinds of ActivityGroup, a StructuredActivityNode owns the ActivityNodes and ActivityEdges it contains, and so a node or edge can only be directly contained in one StructuredActivityNode, though StructuredActivityNodes may be nested.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLStructuredActivityNodeOps[Uml <: UML] { self: UMLStructuredActivityNode[Uml] =>	

	import self.ops._

	/**
	 * The Activity immediately containing the StructuredActivityNode, if it is not contained in another StructuredActivityNode.
	 *
	 * <!-- Start of user code doc for activity -->
	 * <!-- End of user code doc for activity -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivity.structuredNode
	 */
	override def activity: Option[UMLActivity[Uml]] = inActivity

	/**
	 * The ActivityEdges immediately contained in the StructuredActivityNode.
	 *
	 * <!-- Start of user code doc for edge -->
	 * <!-- End of user code doc for edge -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.inStructuredNode
	 */
	def edge: Set[UMLActivityEdge[Uml]] = containedEdge

	/**
	 * The ActivityNodes immediately contained in the StructuredActivityNode.
	 *
	 * <!-- Start of user code doc for node -->
	 * <!-- End of user code doc for node -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityNode.inStructuredNode
	 */
	def node: Set[UMLActivityNode[Uml]] = containedNode

	/**
	 * The InputPins owned by the StructuredActivityNode.
	 *
	 * <!-- Start of user code doc for structuredNodeInput -->
	 * <!-- End of user code doc for structuredNodeInput -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInputPin.structuredNodeInput_structuredActivityNode
	 */
	def structuredNodeInput: Set[UMLInputPin[Uml]] = input.toSet[UMLInputPin[Uml]]

	/**
	 * The OutputPins owned by the StructuredActivityNode.
	 *
	 * <!-- Start of user code doc for structuredNodeOutput -->
	 * <!-- End of user code doc for structuredNodeOutput -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOutputPin.structuredNodeOutput_structuredActivityNode
	 */
	def structuredNodeOutput: Set[UMLOutputPin[Uml]] = output.toSet[UMLOutputPin[Uml]]

	/**
	 * The Variables defined in the scope of the StructuredActivityNode.
	 *
	 * <!-- Start of user code doc for variable -->
	 * <!-- End of user code doc for variable -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLVariable.scope
	 */
	def variable: Set[UMLVariable[Uml]] = ownedMember.selectByKindOf { case x: UMLVariable[Uml] => x }

	/**
	 * Returns this StructuredActivityNode and all Actions contained in it.
	 *
	 * <!-- Start of user code doc for allActions -->
	 * <!-- End of user code doc for allActions -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (node->select(oclIsKindOf(Action)).oclAsType(Action).allActions()->including(self)->asSet())
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
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (self.Action::allOwnedNodes()->union(node)->union(node->select(oclIsKindOf(Action)).oclAsType(Action).allOwnedNodes())->asSet())
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
	 * @operation ordered="false" unique="true" multiplicity="0..1"
	 * @body result = (self.Action::containingActivity())
	 */
	override def containingActivity: Option[UMLActivity[Uml]] = {
		// Start of user code for "containingActivity"
    	???
    	// End of user code
	}

	/**
	 * Return those ActivityNodes contained immediately within the StructuredActivityNode that may act as sources of edges owned by the StructuredActivityNode.
	 *
	 * <!-- Start of user code doc for sourceNodes -->
	 * <!-- End of user code doc for sourceNodes -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (node->union(input.oclAsType(ActivityNode)->asSet())->
	 *   union(node->select(oclIsKindOf(Action)).oclAsType(Action).output)->asSet())
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
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (node->union(output.oclAsType(ActivityNode)->asSet())->
	 *   union(node->select(oclIsKindOf(Action)).oclAsType(Action).input)->asSet())
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
	 * @body edge=self.sourceNodes().outgoing->intersection(self.allOwnedNodes().incoming)->
	 * 	union(self.targetNodes().incoming->intersection(self.allOwnedNodes().outgoing))->asSet()
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
	 * @body input.incoming.source->excludesAll(allOwnedNodes()-output)
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
	 * @body output.outgoing.target->excludesAll(allOwnedNodes()-input)
	 */
	def validate_output_pin_edges: Boolean = {
		// Start of user code for "output_pin_edges"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLStructuredActivityNodeOps
