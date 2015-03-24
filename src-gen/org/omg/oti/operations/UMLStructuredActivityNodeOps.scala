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
package org.omg.oti.operations

// Start of user code for imports
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * <!-- begin-model-doc -->
 * A StructuredActivityNode is an Action that is also an ActivityGroup and whose behavior is specified by the ActivityNodes and ActivityEdges it so contains. Unlike other kinds of ActivityGroup, a StructuredActivityNode owns the ActivityNodes and ActivityEdges it contains, and so a node or edge can only be directly contained in one StructuredActivityNode, though StructuredActivityNodes may be nested.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLStructuredActivityNodeOps[Uml <: UML] { self: UMLStructuredActivityNode[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Activity immediately containing the StructuredActivityNode, if it is not contained in another StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivity.structuredNode
	 */
	override def activity: Option[UMLActivity[Uml]] = inActivity

	/**
	 * <!-- begin-model-doc -->
	 * The ActivityEdges immediately contained in the StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.inStructuredNode
	 */
	def edge: Set[UMLActivityEdge[Uml]] = containedEdge

	/**
	 * <!-- begin-model-doc -->
	 * The ActivityNodes immediately contained in the StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityNode.inStructuredNode
	 */
	def node: Set[UMLActivityNode[Uml]] = containedNode

	/**
	 * <!-- begin-model-doc -->
	 * The InputPins owned by the StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInputPin.structuredNodeInput_structuredActivityNode
	 */
	def structuredNodeInput: Set[UMLInputPin[Uml]] = input.toSet[UMLInputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The OutputPins owned by the StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOutputPin.structuredNodeOutput_structuredActivityNode
	 */
	def structuredNodeOutput: Set[UMLOutputPin[Uml]] = output.toSet[UMLOutputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Variables defined in the scope of the StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLVariable.scope
	 */
	def variable: Set[UMLVariable[Uml]] = ownedMember.selectByKindOf { case x: UMLVariable[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * Returns this StructuredActivityNode and all Actions contained in it.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (node->select(oclIsKindOf(Action)).oclAsType(Action).allActions()->including(self)->asSet())
	 */
	override def allActions: Set[UMLAction[Uml]]  = {
		// Start of user code for "allActions"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * Returns all the ActivityNodes contained directly or indirectly within this StructuredActivityNode, in addition to the Pins of the StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (self.Action::allOwnedNodes()->union(node)->union(node->select(oclIsKindOf(Action)).oclAsType(Action).allOwnedNodes())->asSet())
	 */
	override def allOwnedNodes: Set[UMLActivityNode[Uml]]  = {
		// Start of user code for "allOwnedNodes"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The Activity that directly or indirectly contains this StructuredActivityNode (considered as an Action).
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..1"
	 * @body result = (self.Action::containingActivity())
	 */
	override def containingActivity: Option[UMLActivity[Uml]]  = {
		// Start of user code for "containingActivity"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * Return those ActivityNodes contained immediately within the StructuredActivityNode that may act as sources of edges owned by the StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (node->union(input.oclAsType(ActivityNode)->asSet())->
	 *   union(node->select(oclIsKindOf(Action)).oclAsType(Action).output)->asSet())
	 */
	def sourceNodes: Set[UMLActivityNode[Uml]]  = {
		// Start of user code for "sourceNodes"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * Return those ActivityNodes contained immediately within the StructuredActivityNode that may act as targets of edges owned by the StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (node->union(output.oclAsType(ActivityNode)->asSet())->
	 *   union(node->select(oclIsKindOf(Action)).oclAsType(Action).input)->asSet())
	 */
	def targetNodes: Set[UMLActivityNode[Uml]]  = {
		// Start of user code for "targetNodes"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The edges of a StructuredActivityNode are all the ActivityEdges with source and target ActivityNodes contained directly or indirectly within the StructuredActivityNode and at least one of the source or target not contained in any more deeply nested StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @body edge=self.sourceNodes().outgoing->intersection(self.allOwnedNodes().incoming)->
	 * 	union(self.targetNodes().incoming->intersection(self.allOwnedNodes().outgoing))->asSet()
	 */
	def validate_edges: Boolean  = {
		// Start of user code for "edges"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The incoming ActivityEdges of an InputPin of a StructuredActivityNode must have sources that are not within the StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @body input.incoming.source->excludesAll(allOwnedNodes()-output)
	 */
	def validate_input_pin_edges: Boolean  = {
		// Start of user code for "input_pin_edges"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The outgoing ActivityEdges of the OutputPins of a StructuredActivityNode must have targets that are not within the StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @body output.outgoing.target->excludesAll(allOwnedNodes()-input)
	 */
	def validate_output_pin_edges: Boolean  = {
		// Start of user code for "output_pin_edges"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLStructuredActivityNode
