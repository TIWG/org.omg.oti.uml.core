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
 * A DecisionNode is a ControlNode that chooses between outgoing ActivityEdges for the routing of tokens.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLDecisionNodeOps[Uml <: UML] { self: UMLDecisionNode[Uml] =>	

	import self.ops._

	/**
	 * The decisionInputFlow of a DecisionNode must be an incoming ActivityEdge of the DecisionNode.
	 *
	 * <!-- Start of user code doc for validate_decision_input_flow_incoming -->
	 * <!-- End of user code doc for validate_decision_input_flow_incoming -->
	 *
	 * @body incoming->includes(decisionInputFlow)
	 */
	def validate_decision_input_flow_incoming: Boolean = {
		// Start of user code for "decision_input_flow_incoming"
    	???
    	// End of user code
	}

	/**
	 * The ActivityEdges incoming to and outgoing from a DecisionNode, other than the decisionInputFlow (if any), must be either all ObjectFlows or all ControlFlows.
	 *
	 * <!-- Start of user code doc for validate_edges -->
	 * <!-- End of user code doc for validate_edges -->
	 *
	 * @body let allEdges: Set(ActivityEdge) = incoming->union(outgoing) in
	 * let allRelevantEdges: Set(ActivityEdge) = if decisionInputFlow->notEmpty() then allEdges->excluding(decisionInputFlow) else allEdges endif in
	 * allRelevantEdges->forAll(oclIsKindOf(ControlFlow)) or allRelevantEdges->forAll(oclIsKindOf(ObjectFlow))
	 */
	def validate_edges: Boolean = {
		// Start of user code for "edges"
    	???
    	// End of user code
	}

	/**
	 * If the DecisionNode has a decisionInputFlow and an incoming ControlFlow, then any decisionInput Behavior has one in Parameter whose type is the same as or a supertype of the type of object tokens offered on the decisionInputFlow.
	 *
	 * <!-- Start of user code doc for validate_incoming_control_one_input_parameter -->
	 * <!-- End of user code doc for validate_incoming_control_one_input_parameter -->
	 *
	 * @body (decisionInput<>null and decisionInputFlow<>null and incoming->exists(oclIsKindOf(ControlFlow))) implies
	 * 	decisionInput.inputParameters()->size()=1
	 */
	def validate_incoming_control_one_input_parameter: Boolean = {
		// Start of user code for "incoming_control_one_input_parameter"
    	???
    	// End of user code
	}

	/**
	 * If the DecisionNode has no decisionInputFlow and an incoming ObjectFlow, then any decisionInput Behavior has one in Parameter whose type is the same as or a supertype of the type of object tokens offered on the incoming ObjectFlow.
	 *
	 * <!-- Start of user code doc for validate_incoming_object_one_input_parameter -->
	 * <!-- End of user code doc for validate_incoming_object_one_input_parameter -->
	 *
	 * @body (decisionInput<>null and decisionInputFlow=null and incoming->forAll(oclIsKindOf(ObjectFlow))) implies
	 * 	decisionInput.inputParameters()->size()=1
	 */
	def validate_incoming_object_one_input_parameter: Boolean = {
		// Start of user code for "incoming_object_one_input_parameter"
    	???
    	// End of user code
	}

	/**
	 * A DecisionNode has one or two incoming ActivityEdges and at least one outgoing ActivityEdge.
	 *
	 * <!-- Start of user code doc for validate_incoming_outgoing_edges -->
	 * <!-- End of user code doc for validate_incoming_outgoing_edges -->
	 *
	 * @body (incoming->size() = 1 or incoming->size() = 2) and outgoing->size() > 0
	 */
	def validate_incoming_outgoing_edges: Boolean = {
		// Start of user code for "incoming_outgoing_edges"
    	???
    	// End of user code
	}

	/**
	 * A decisionInput Behavior has no out parameters, no inout parameters, and one return parameter.
	 *
	 * <!-- Start of user code doc for validate_parameters -->
	 * <!-- End of user code doc for validate_parameters -->
	 *
	 * @body decisionInput<>null implies 
	 *   (decisionInput.ownedParameter->forAll(par | 
	 *      par.direction <> ParameterDirectionKind::out and 
	 *      par.direction <> ParameterDirectionKind::inout ) and
	 *    decisionInput.ownedParameter->one(par | 
	 *      par.direction <> ParameterDirectionKind::return))
	 *      
	 */
	def validate_parameters: Boolean = {
		// Start of user code for "parameters"
    	???
    	// End of user code
	}

	/**
	 * If the DecisionNode has a decisionInputFlow and an second incoming ObjectFlow, then any decisionInput has two in Parameters, the first of which has a type that is the same as or a supertype of the type of object tokens offered on the non-decisionInputFlow and the second of which has a type that is the same as or a supertype of the type of object tokens offered on the decisionInputFlow.
	 *
	 * <!-- Start of user code doc for validate_two_input_parameters -->
	 * <!-- End of user code doc for validate_two_input_parameters -->
	 *
	 * @body (decisionInput<>null and decisionInputFlow<>null and incoming->forAll(oclIsKindOf(ObjectFlow))) implies
	 * 	decisionInput.inputParameters()->size()=2
	 */
	def validate_two_input_parameters: Boolean = {
		// Start of user code for "two_input_parameters"
    	???
    	// End of user code
	}

	/**
	 * If the DecisionNode has no decisionInputFlow and an incoming ControlFlow, then any decisionInput Behavior has no in parameters.
	 *
	 * <!-- Start of user code doc for validate_zero_input_parameters -->
	 * <!-- End of user code doc for validate_zero_input_parameters -->
	 *
	 * @body (decisionInput<>null and decisionInputFlow=null and incoming->exists(oclIsKindOf(ControlFlow))) implies
	 *    decisionInput.inputParameters()->isEmpty()
	 */
	def validate_zero_input_parameters: Boolean = {
		// Start of user code for "zero_input_parameters"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLDecisionNodeOps
