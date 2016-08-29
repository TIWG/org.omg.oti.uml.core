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
import scala.Predef.{???,String}
// End of user code

/**
  * A StringExpression is an Expression that specifies a String value that is derived by concatenating a sequence of operands with String values or a sequence of subExpressions, some of which might be template parameters.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStringExpressionOps[Uml <: UML] { self: UMLStringExpression[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The StringExpression of which this StringExpression is a subExpression.
    *
    * <!-- Start of user code doc for owningExpression -->
    * <!-- End of user code doc for owningExpression -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStringExpression.subExpression
    */
  def owningExpression: Option[UMLStringExpression[Uml]] = owner.selectByKindOf { case x: UMLStringExpression[Uml] => x }

  /**
    * The query stringValue() returns the String resulting from concatenating, in order, all the component String values of all the operands or subExpressions that are part of the StringExpression.
    *
    * <!-- Start of user code doc for stringValue -->
    * <!-- End of user code doc for stringValue -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (if subExpression->notEmpty()
    * then subExpression->iterate(se; stringValue: String = '' | stringValue.concat(se.stringValue()))
    * else operand->iterate(op; stringValue: String = '' | stringValue.concat(op.stringValue()))
    * endif)
    * }}}
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
    * {{{
    * OCL Body operand->forAll (oclIsKindOf (LiteralString))
    * }}}
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
    * {{{
    * OCL Body if subExpression->notEmpty() then operand->isEmpty() else operand->notEmpty() endif
    * }}}
    */
  def validate_subexpressions: Boolean = {
    // Start of user code for "subexpressions"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLStringExpressionOps
