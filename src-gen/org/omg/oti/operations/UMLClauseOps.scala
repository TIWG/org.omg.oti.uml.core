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
 * A Clause is an Element that represents a single branch of a ConditionalNode, including a test and a body section. The body section is executed only if (but not necessarily if) the test section evaluates to true.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLClauseOps[Uml <: UML] { self: UMLClause[Uml] =>	

	import self.ops._

	/**
	 * <!-- Start of user code doc for clause_conditionalNode -->
	 * <!-- End of user code doc for clause_conditionalNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLConditionalNode.clause
	 */
	def clause_conditionalNode: Option[UMLConditionalNode[Uml]] = owner.selectByKindOf { case x: UMLConditionalNode[Uml] => x }

	/**
	 * The bodyOutput Pins are OutputPins on Actions in the body of the Clause.
	 *
	 * <!-- Start of user code doc for validate_body_output_pins -->
	 * <!-- End of user code doc for validate_body_output_pins -->
	 *
	 * @body _'body'.oclAsType(Action).allActions().output->includesAll(bodyOutput)
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
	 * @body test.oclAsType(Action).allActions().output->includes(decider) and
	 * decider.type = Boolean and
	 * decider.is(1,1)
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
	 * @body test->intersection(_'body')->isEmpty()
	 */
	def validate_test_and_body: Boolean = {
		// Start of user code for "test_and_body"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLClauseOps
