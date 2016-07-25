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
