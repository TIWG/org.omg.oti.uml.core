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
// End of user cod

/**
  * A Clause is an Element that represents a single branch of a ConditionalNode, including a test and a body section. The body section is executed only if (but not necessarily if) the test section evaluates to true.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLClauseOps[Uml <: UML] { self: UMLClause[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for clause_conditionalNode -->
    * <!-- End of user code doc for clause_conditionalNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConditionalNode.clause
    */
  def clause_conditionalNode: Option[UMLConditionalNode[Uml]] = owner.selectByKindOf { case x: UMLConditionalNode[Uml] => x }

  /**
    * The bodyOutput Pins are OutputPins on Actions in the body of the Clause.
    *
    * <!-- Start of user code doc for validate_body_output_pins -->
    * <!-- End of user code doc for validate_body_output_pins -->
    *
    * {{{
    * OCL Body _'body'.oclAsType(Action).allActions().output->includesAll(bodyOutput)
    * }}}
    */
  def validate_body_output_pins: Boolean = {
    // Start of user code for "body_output_pins"
    ???
    // End of user code
  }

  /**
    * The decider Pin must be on an Action in the test section of the Clause and must be of type Boolean with multiplicity 1..1.
    *
    * <!-- Start of user code doc for validate_decider_output -->
    * <!-- End of user code doc for validate_decider_output -->
    *
    * {{{
    * OCL Body test.oclAsType(Action).allActions().output->includes(decider) and
    * decider.type = Boolean and
    * decider.is(1,1)
    * }}}
    */
  def validate_decider_output: Boolean = {
    // Start of user code for "decider_output"
    ???
    // End of user code
  }

  /**
    * The test and body parts of a ConditionalNode must be disjoint with each other.
    *
    * <!-- Start of user code doc for validate_test_and_body -->
    * <!-- End of user code doc for validate_test_and_body -->
    *
    * {{{
    * OCL Body test->intersection(_'body')->isEmpty()
    * }}}
    */
  def validate_test_and_body: Boolean = {
    // Start of user code for "test_and_body"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLClauseOps
