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

import org.omg.oti.uml.read.api.{UML, UMLLoopNode, UMLAction, UMLActivityNode}

import scala.language.postfixOps
// End of user code

/**
 * A LoopNode is a StructuredActivityNode that represents an iterative loop with setup, test, and body sections.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLLoopNodeOps[Uml <: UML] { self: UMLLoopNode[Uml] =>

	import self.ops._

	/**
	 * Return only this LoopNode. This prevents Actions within the LoopNode from having their OutputPins used as bodyOutputs or decider Pins in containing LoopNodes or ConditionalNodes.
	 *
	 * <!-- Start of user code doc for allActions -->
   * <!-- End of user code doc for allActions -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (self->asSet())
	 */
	override def allActions: Set[UMLAction[Uml]] = {
		// Start of user code for "allActions"
      ???
      // End of user code
	}

	/**
	 * Return the loopVariable OutputPins in addition to other source nodes for the LoopNode as a StructuredActivityNode.
	 *
	 * <!-- Start of user code doc for sourceNodes -->
   * <!-- End of user code doc for sourceNodes -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (self.StructuredActivityNode::sourceNodes()->union(loopVariable))
	 */
	override def sourceNodes: Set[UMLActivityNode[Uml]] = {
		// Start of user code for "sourceNodes"
      ???
      // End of user code
	}

	/**
	 * The bodyOutput pins are OutputPins on Actions in the body of the LoopNode.
	 *
	 * <!-- Start of user code doc for validate_body_output_pins -->
   * <!-- End of user code doc for validate_body_output_pins -->
	 *
	 * @body bodyPart.oclAsType(Action).allActions().output->includesAll(bodyOutput)
	 */
	def validate_body_output_pins: Boolean = {
		// Start of user code for "body_output_pins"
      ???
      // End of user code
	}

	/**
	 * The union of the ExecutableNodes in the setupPart, test and bodyPart of a LoopNode must be the same as the subset of nodes contained in the LoopNode (considered as a StructuredActivityNode) that are ExecutableNodes.
	 *
	 * <!-- Start of user code doc for validate_executable_nodes -->
   * <!-- End of user code doc for validate_executable_nodes -->
	 *
	 * @body setupPart->union(test)->union(bodyPart)=node->select(oclIsKindOf(ExecutableNode)).oclAsType(ExecutableNode)->asSet()
	 */
	def validate_executable_nodes: Boolean = {
		// Start of user code for "executable_nodes"
      ???
      // End of user code
	}

	/**
	 * The loopVariableInputs must not have outgoing edges.
	 *
	 * <!-- Start of user code doc for validate_input_edges -->
   * <!-- End of user code doc for validate_input_edges -->
	 *
	 * @body loopVariableInput.outgoing->isEmpty()
	 */
	def validate_input_edges: Boolean = {
		// Start of user code for "input_edges"
      ???
      // End of user code
	}

	/**
	 * All ActivityEdges outgoing from loopVariable OutputPins must have targets within the LoopNode.
	 *
	 * <!-- Start of user code doc for validate_loop_variable_outgoing -->
   * <!-- End of user code doc for validate_loop_variable_outgoing -->
	 *
	 * @body allOwnedNodes()->includesAll(loopVariable.outgoing.target)
	 */
	def validate_loop_variable_outgoing: Boolean = {
		// Start of user code for "loop_variable_outgoing"
      ???
      // End of user code
	}

	/**
	 * A LoopNode must have the same number of loopVariableInputs and loopVariables, and they must match in type, uniqueness and multiplicity.
	 *
	 * <!-- Start of user code doc for validate_matching_loop_variables -->
   * <!-- End of user code doc for validate_matching_loop_variables -->
	 *
	 * @body loopVariableInput->size()=loopVariable->size() and
	 * loopVariableInput.type=loopVariable.type and
	 * loopVariableInput.isUnique=loopVariable.isUnique and
	 * loopVariableInput.lower=loopVariable.lower and
	 * loopVariableInput.upper=loopVariable.upper
	 */
	def validate_matching_loop_variables: Boolean = {
		// Start of user code for "matching_loop_variables"
      ???
      // End of user code
	}

	/**
	 * A LoopNode must have the same number of bodyOutput Pins as loopVariables, and each bodyOutput Pin must be compatible with the corresponding loopVariable (by positional order) in type, multiplicity, ordering and uniqueness.
	 *
	 * <!-- Start of user code doc for validate_matching_output_pins -->
   * <!-- End of user code doc for validate_matching_output_pins -->
	 *
	 * @body bodyOutput->size()=loopVariable->size() and
	 * Sequence{1..loopVariable->size()}->forAll(i |
	 * 	bodyOutput->at(i).type.conformsTo(loopVariable->at(i).type) and
	 * 	bodyOutput->at(i).isOrdered = loopVariable->at(i).isOrdered and
	 * 	bodyOutput->at(i).isUnique = loopVariable->at(i).isUnique and
	 * 	loopVariable->at(i).includesMultiplicity(bodyOutput->at(i)))
	 */
	def validate_matching_output_pins: Boolean = {
		// Start of user code for "matching_output_pins"
      ???
      // End of user code
	}

	/**
	 * A LoopNode must have the same number of result OutputPins and loopVariables, and they must match in type, uniqueness and multiplicity.
	 *
	 * <!-- Start of user code doc for validate_matching_result_pins -->
   * <!-- End of user code doc for validate_matching_result_pins -->
	 *
	 * @body result->size()=loopVariable->size() and
	 * result.type=loopVariable.type and
	 * result.isUnique=loopVariable.isUnique and
	 * result.lower=loopVariable.lower and
	 * result.upper=loopVariable.upper
	 */
	def validate_matching_result_pins: Boolean = {
		// Start of user code for "matching_result_pins"
      ???
      // End of user code
	}

	/**
	 * The result OutputPins have no incoming edges.
	 *
	 * <!-- Start of user code doc for validate_result_no_incoming -->
   * <!-- End of user code doc for validate_result_no_incoming -->
	 *
	 * @body result.incoming->isEmpty()
	 */
	def validate_result_no_incoming: Boolean = {
		// Start of user code for "result_no_incoming"
      ???
      // End of user code
	}

	/**
	 * The test and body parts of a ConditionalNode must be disjoint with each other.
	 *
	 * <!-- Start of user code doc for validate_setup_test_and_body -->
   * <!-- End of user code doc for validate_setup_test_and_body -->
	 *
	 * @body setupPart->intersection(test)->isEmpty() and
	 * setupPart->intersection(bodyPart)->isEmpty() and
	 * test->intersection(bodyPart)->isEmpty()
	 */
	def validate_setup_test_and_body: Boolean = {
		// Start of user code for "setup_test_and_body"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLLoopNodeOps
