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

import org.omg.oti.uml.read.api.{UMLStringExpression, UML, UMLElement}
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * A StringExpression is an Expression that specifies a String value that is derived by concatenating a sequence of operands with String values or a sequence of subExpressions, some of which might be template parameters.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLStringExpressionOps[Uml <: UML] { self: UMLStringExpression[Uml] =>	

	import self.ops._

	/**
	 * The StringExpression of which this StringExpression is a subExpression.
	 *
	 * <!-- Start of user code doc for owningExpression -->
	 * <!-- End of user code doc for owningExpression -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStringExpression.subExpression
	 */
	def owningExpression: Option[UMLStringExpression[Uml]] = owner.selectByKindOf { case x: UMLStringExpression[Uml] => x }

	/**
	 * The query stringValue() returns the String resulting from concatenating, in order, all the component String values of all the operands or subExpressions that are part of the StringExpression.
	 *
	 * <!-- Start of user code doc for stringValue -->
	 * <!-- End of user code doc for stringValue -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if subExpression->notEmpty()
	 * then subExpression->iterate(se; stringValue: String = '' | stringValue.concat(se.stringValue()))
	 * else operand->iterate(op; stringValue: String = '' | stringValue.concat(op.stringValue()))
	 * endif)
	 */
	override def stringValue: Option[String] = {
		// Start of user code for "stringValue"
    	???
    	// End of user code
	}

	/**
	 * All the operands of a StringExpression must be LiteralStrings
	 *
	 * <!-- Start of user code doc for validate_operands -->
	 * <!-- End of user code doc for validate_operands -->
	 *
	 * @body operand->forAll (oclIsKindOf (LiteralString))
	 */
	def validate_operands: Boolean = {
		// Start of user code for "operands"
    	???
    	// End of user code
	}

	/**
	 * If a StringExpression has sub-expressions, it cannot have operands and vice versa (this avoids the problem of having to define a collating sequence between operands and subexpressions).
	 *
	 * <!-- Start of user code doc for validate_subexpressions -->
	 * <!-- End of user code doc for validate_subexpressions -->
	 *
	 * @body if subExpression->notEmpty() then operand->isEmpty() else operand->notEmpty() endif
	 */
	def validate_subexpressions: Boolean = {
		// Start of user code for "subexpressions"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLStringExpressionOps
