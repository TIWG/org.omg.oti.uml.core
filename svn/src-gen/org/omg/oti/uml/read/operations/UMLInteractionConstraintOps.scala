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
// End of user code

/**
  * An InteractionConstraint is a Boolean expression that guards an operand in a CombinedFragment.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInteractionConstraintOps[Uml <: UML] { self: UMLInteractionConstraint[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for guard_interactionOperand -->
    * <!-- End of user code doc for guard_interactionOperand -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionOperand.guard
    */
  def guard_interactionOperand: Option[UMLInteractionOperand[Uml]] = owner.selectByKindOf { case x: UMLInteractionOperand[Uml] => x }

  /**
    * The dynamic variables that take part in the constraint must be owned by the ConnectableElement corresponding to the covered Lifeline.
    *
    * <!-- Start of user code doc for validate_dynamic_variables -->
    * <!-- End of user code doc for validate_dynamic_variables -->
    *
    * {{{
    * }}}
    */
  def validate_dynamic_variables: Boolean = {
    // Start of user code for "dynamic_variables"
    ???
    // End of user code
  }

  /**
    * The constraint may contain references to global data or write-once data.
    *
    * <!-- Start of user code doc for validate_global_data -->
    * <!-- End of user code doc for validate_global_data -->
    *
    * {{{
    * }}}
    */
  def validate_global_data: Boolean = {
    // Start of user code for "global_data"
    ???
    // End of user code
  }

  /**
    * If maxint is specified, then minint must be specified and the evaluation of maxint must be >= the evaluation of minint.
    *
    * <!-- Start of user code doc for validate_maxint_greater_equal_minint -->
    * <!-- End of user code doc for validate_maxint_greater_equal_minint -->
    *
    * {{{
    * OCL Body maxint->notEmpty() implies (minint->notEmpty() and 
    * maxint->asSequence()->first().integerValue() >=
    * minint->asSequence()->first().integerValue() )
    * }}}
    */
  def validate_maxint_greater_equal_minint: Boolean = {
    // Start of user code for "maxint_greater_equal_minint"
    ???
    // End of user code
  }

  /**
    * If maxint is specified, then the expression must evaluate to a positive integer.
    *
    * <!-- Start of user code doc for validate_maxint_positive -->
    * <!-- End of user code doc for validate_maxint_positive -->
    *
    * {{{
    * OCL Body maxint->notEmpty() implies 
    * maxint->asSequence()->first().integerValue() > 0
    * }}}
    */
  def validate_maxint_positive: Boolean = {
    // Start of user code for "maxint_positive"
    ???
    // End of user code
  }

  /**
    * Minint/maxint can only be present if the InteractionConstraint is associated with the operand of a loop CombinedFragment.
    *
    * <!-- Start of user code doc for validate_minint_maxint -->
    * <!-- End of user code doc for validate_minint_maxint -->
    *
    * {{{
    * OCL Body maxint->notEmpty() or minint->notEmpty() implies
    * interactionOperand.combinedFragment.interactionOperator =
    * InteractionOperatorKind::loop
    * }}}
    */
  def validate_minint_maxint: Boolean = {
    // Start of user code for "minint_maxint"
    ???
    // End of user code
  }

  /**
    * If minint is specified, then the expression must evaluate to a non-negative integer.
    *
    * <!-- Start of user code doc for validate_minint_non_negative -->
    * <!-- End of user code doc for validate_minint_non_negative -->
    *
    * {{{
    * OCL Body minint->notEmpty() implies 
    * minint->asSequence()->first().integerValue() >= 0
    * }}}
    */
  def validate_minint_non_negative: Boolean = {
    // Start of user code for "minint_non_negative"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLInteractionConstraintOps
