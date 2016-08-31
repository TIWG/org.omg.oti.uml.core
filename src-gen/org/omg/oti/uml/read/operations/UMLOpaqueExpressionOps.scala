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
import scala.collection.immutable.Set
import java.lang.Integer

import scalaz._, Scalaz._

// End of user code

/**
  * An OpaqueExpression is a ValueSpecification that specifies the computation of a collection of values either in terms of a UML Behavior or based on a textual statement in a language other than UML
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLOpaqueExpressionOps[Uml <: UML] { self: UMLOpaqueExpression[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * If an OpaqueExpression is specified using a UML Behavior, then this refers to the single required return Parameter of that Behavior. When the Behavior completes execution, the values on this Parameter give the result of evaluating the OpaqueExpression.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLParameter.result_opaqueExpression
    * {{{
    * OCL Body result = (if behavior = null then
    * 	null
    * else
    * 	behavior.ownedParameter->first()
    * endif)
    * }}}
    */
  def result: Option[UMLParameter[Uml]] = {
    // Start of user code for "result"
    ???
    // End of user code
  }

  /**
    * <!-- Start of user code doc for mapping_abstraction -->
    * <!-- End of user code doc for mapping_abstraction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAbstraction.mapping
    */
  def mapping_abstraction: Option[UMLAbstraction[Uml]] = owner.selectByKindOf { case x: UMLAbstraction[Uml] => x }

  /**
    * The query isIntegral() tells whether an expression is intended to produce an Integer.
    *
    * <!-- Start of user code doc for isIntegral -->
    * <!-- End of user code doc for isIntegral -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (false)
    * }}}
    */
  def isIntegral: Boolean = {
    // Start of user code for "isIntegral"
    ???
    // End of user code
  }

  /**
    * The query isNonNegative() tells whether an integer expression has a non-negative value.
    *
    * <!-- Start of user code doc for isNonNegative -->
    * <!-- End of user code doc for isNonNegative -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (false)
    * }}}
    */
  def isNonNegative: Boolean = {
    // Start of user code for "isNonNegative"
    ???
    // End of user code
  }

  /**
    * The query isPositive() tells whether an integer expression has a positive value.
    *
    * <!-- Start of user code doc for isPositive -->
    * <!-- End of user code doc for isPositive -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (false)
    * }}}
    */
  def isPositive: Boolean = {
    // Start of user code for "isPositive"
    ???
    // End of user code
  }

  /**
    * The query value() gives an integer value for an expression intended to produce one.
    *
    * <!-- Start of user code doc for value -->
    * <!-- End of user code doc for value -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (0)
    * }}}
    */
  def value: Integer = {
    // Start of user code for "value"
    ???
    // End of user code
  }

  /**
    * If the language attribute is not empty, then the size of the body and language arrays must be the same.
    *
    * <!-- Start of user code doc for validate_language_body_size -->
    * <!-- End of user code doc for validate_language_body_size -->
    *
    * {{{
    * OCL Body language->notEmpty() implies (_'body'->size() = language->size())
    * }}}
    */
  def validate_language_body_size: Boolean = {
    // Start of user code for "language_body_size"
    ???
    // End of user code
  }

  /**
    * The behavior must have exactly one return result parameter.
    *
    * <!-- Start of user code doc for validate_one_return_result_parameter -->
    * <!-- End of user code doc for validate_one_return_result_parameter -->
    *
    * {{{
    * OCL Body behavior <> null implies
    *    behavior.ownedParameter->select(direction=ParameterDirectionKind::return)->size() = 1
    * }}}
    */
  def validate_one_return_result_parameter: Boolean = {
    // Start of user code for "one_return_result_parameter"
    ???
    // End of user code
  }

  /**
    * The behavior may only have return result parameters.
    *
    * <!-- Start of user code doc for validate_only_return_result_parameters -->
    * <!-- End of user code doc for validate_only_return_result_parameters -->
    *
    * {{{
    * OCL Body behavior <> null implies behavior.ownedParameter->select(direction<>ParameterDirectionKind::return)->isEmpty()
    * }}}
    */
  def validate_only_return_result_parameters: Boolean = {
    // Start of user code for "only_return_result_parameters"
    ???
    // End of user code
  }

  // Start of user code for additional features

  override def asForwardReferencesToImportableOuterPackageableElements
	: Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]] =
    opaqueExpression_asForwardReferencesToImportableOuterPackageableElements

  def opaqueExpression_asForwardReferencesToImportableOuterPackageableElements
  : Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]] =
    (Set[UMLPackageableElement[Uml]](this) ++ behavior.toSet).right

  // End of user code
} //UMLOpaqueExpressionOps
