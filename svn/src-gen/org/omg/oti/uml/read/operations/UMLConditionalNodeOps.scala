/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
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
import scala.Boolean
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * A ConditionalNode is a StructuredActivityNode that chooses one among some number of alternative collections of ExecutableNodes to execute.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConditionalNodeOps[Uml <: UML] { self: UMLConditionalNode[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The set of Clauses composing the ConditionalNode.
    *
    * <!-- Start of user code doc for clause -->
    * <!-- End of user code doc for clause -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClause.clause_conditionalNode
    */
  def clause: Set[UMLClause[Uml]] = ownedElement.selectByKindOf { case x: UMLClause[Uml] => x }

  /**
    * Return only this ConditionalNode. This prevents Actions within the ConditionalNode from having their OutputPins used as bodyOutputs or decider Pins in containing LoopNodes or ConditionalNodes.
    *
    * <!-- Start of user code doc for allActions -->
    * <!-- End of user code doc for allActions -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (self->asSet())
    * }}}
    */
  override def allActions: Set[UMLAction[Uml]] = {
    // Start of user code for "allActions"
    ???
    // End of user code
  }

  /**
    * No two clauses within a ConditionalNode may be predecessorClauses of each other, either directly or indirectly.
    *
    * <!-- Start of user code doc for validate_clause_no_predecessor -->
    * <!-- End of user code doc for validate_clause_no_predecessor -->
    *
    * {{{
    * OCL Body clause->closure(predecessorClause)->intersection(clause)->isEmpty()
    * }}}
    */
  def validate_clause_no_predecessor: Boolean = {
    // Start of user code for "clause_no_predecessor"
    ???
    // End of user code
  }

  /**
    * The union of the ExecutableNodes in the test and body parts of all clauses must be the same as the subset of nodes contained in the ConditionalNode (considered as a StructuredActivityNode) that are ExecutableNodes.
    *
    * <!-- Start of user code doc for validate_executable_nodes -->
    * <!-- End of user code doc for validate_executable_nodes -->
    *
    * {{{
    * OCL Body clause.test->union(clause._'body') = node->select(oclIsKindOf(ExecutableNode)).oclAsType(ExecutableNode)
    * }}}
    */
  def validate_executable_nodes: Boolean = {
    // Start of user code for "executable_nodes"
    ???
    // End of user code
  }

  /**
    * Each clause of a ConditionalNode must have the same number of bodyOutput pins as the ConditionalNode has result OutputPins, and each clause bodyOutput Pin must be compatible with the corresponding result OutputPin (by positional order) in type, multiplicity, ordering, and uniqueness.
    *
    * <!-- Start of user code doc for validate_matching_output_pins -->
    * <!-- End of user code doc for validate_matching_output_pins -->
    *
    * {{{
    * OCL Body clause->forAll(
    * 	bodyOutput->size()=self.result->size() and
    * 	Sequence{1..self.result->size()}->forAll(i |
    * 		bodyOutput->at(i).type.conformsTo(result->at(i).type) and
    * 		bodyOutput->at(i).isOrdered = result->at(i).isOrdered and
    * 		bodyOutput->at(i).isUnique = result->at(i).isUnique and
    * 		bodyOutput->at(i).compatibleWith(result->at(i))))
    * }}}
    */
  def validate_matching_output_pins: Boolean = {
    // Start of user code for "matching_output_pins"
    ???
    // End of user code
  }

  /**
    * A ConditionalNode has no InputPins.
    *
    * <!-- Start of user code doc for validate_no_input_pins -->
    * <!-- End of user code doc for validate_no_input_pins -->
    *
    * {{{
    * OCL Body input->isEmpty()
    * }}}
    */
  def validate_no_input_pins: Boolean = {
    // Start of user code for "no_input_pins"
    ???
    // End of user code
  }

  /**
    * No ExecutableNode in the ConditionNode may appear in the test or body part of more than one clause of a ConditionalNode.
    *
    * <!-- Start of user code doc for validate_one_clause_with_executable_node -->
    * <!-- End of user code doc for validate_one_clause_with_executable_node -->
    *
    * {{{
    * OCL Body node->select(oclIsKindOf(ExecutableNode)).oclAsType(ExecutableNode)->forAll(n | 
    * 	self.clause->select(test->union(_'body')->includes(n))->size()=1)
    * }}}
    */
  def validate_one_clause_with_executable_node: Boolean = {
    // Start of user code for "one_clause_with_executable_node"
    ???
    // End of user code
  }

  /**
    * The result OutputPins have no incoming edges.
    *
    * <!-- Start of user code doc for validate_result_no_incoming -->
    * <!-- End of user code doc for validate_result_no_incoming -->
    *
    * {{{
    * OCL Body result.incoming->isEmpty()
    * }}}
    */
  def validate_result_no_incoming: Boolean = {
    // Start of user code for "result_no_incoming"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLConditionalNodeOps
