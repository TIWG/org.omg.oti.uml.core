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
import scala.Predef.???
// End of user code

/**
  * A DecisionNode is a ControlNode that chooses between outgoing ActivityEdges for the routing of tokens.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDecisionNodeOps[Uml <: UML] { self: UMLDecisionNode[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The decisionInputFlow of a DecisionNode must be an incoming ActivityEdge of the DecisionNode.
    *
    * <!-- Start of user code doc for validate_decision_input_flow_incoming -->
    * <!-- End of user code doc for validate_decision_input_flow_incoming -->
    *
    * {{{
    * OCL Body incoming->includes(decisionInputFlow)
    * }}}
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
    * {{{
    * OCL Body let allEdges: Set(ActivityEdge) = incoming->union(outgoing) in
    * let allRelevantEdges: Set(ActivityEdge) = if decisionInputFlow->notEmpty() then allEdges->excluding(decisionInputFlow) else allEdges endif in
    * allRelevantEdges->forAll(oclIsKindOf(ControlFlow)) or allRelevantEdges->forAll(oclIsKindOf(ObjectFlow))
    * }}}
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
    * {{{
    * OCL Body (decisionInput<>null and decisionInputFlow<>null and incoming->exists(oclIsKindOf(ControlFlow))) implies
    * 	decisionInput.inputParameters()->size()=1
    * }}}
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
    * {{{
    * OCL Body (decisionInput<>null and decisionInputFlow=null and incoming->forAll(oclIsKindOf(ObjectFlow))) implies
    * 	decisionInput.inputParameters()->size()=1
    * }}}
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
    * {{{
    * OCL Body (incoming->size() = 1 or incoming->size() = 2) and outgoing->size() > 0
    * }}}
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
    * {{{
    * OCL Body decisionInput<>null implies 
    *   (decisionInput.ownedParameter->forAll(par | 
    *      par.direction <> ParameterDirectionKind::out and 
    *      par.direction <> ParameterDirectionKind::inout ) and
    *    decisionInput.ownedParameter->one(par | 
    *      par.direction <> ParameterDirectionKind::return))
    *      
    * }}}
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
    * {{{
    * OCL Body (decisionInput<>null and decisionInputFlow<>null and incoming->forAll(oclIsKindOf(ObjectFlow))) implies
    * 	decisionInput.inputParameters()->size()=2
    * }}}
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
    * {{{
    * OCL Body (decisionInput<>null and decisionInputFlow=null and incoming->exists(oclIsKindOf(ControlFlow))) implies
    *    decisionInput.inputParameters()->isEmpty()
    * }}}
    */
  def validate_zero_input_parameters: Boolean = {
    // Start of user code for "zero_input_parameters"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLDecisionNodeOps
