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

import org.omg.oti.uml.read.api.{UML, UMLInteractionOperand, UMLInteractionConstraint}

import scala.language.postfixOps
// End of user code

/**
 * An InteractionConstraint is a Boolean expression that guards an operand in a CombinedFragment.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLInteractionConstraintOps[Uml <: UML] { self: UMLInteractionConstraint[Uml] =>

	import self.ops._

	/**
	 * <!-- Start of user code doc for guard_interactionOperand -->
   * <!-- End of user code doc for guard_interactionOperand -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.uml.read.api.UMLInteractionOperand.guard
	 */
	def guard_interactionOperand: Option[UMLInteractionOperand[Uml]] = owner.selectByKindOf { case x: UMLInteractionOperand[Uml] => x }

	/**
	 * The dynamic variables that take part in the constraint must be owned by the ConnectableElement corresponding to the covered Lifeline.
	 *
	 * <!-- Start of user code doc for validate_dynamic_variables -->
   * <!-- End of user code doc for validate_dynamic_variables -->
	 *
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
	 * @body maxint->notEmpty() implies (minint->notEmpty() and 
	 * maxint->asSequence()->first().integerValue() >=
	 * minint->asSequence()->first().integerValue() )
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
	 * @body maxint->notEmpty() implies 
	 * maxint->asSequence()->first().integerValue() > 0
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
	 * @body maxint->notEmpty() or minint->notEmpty() implies
	 * interactionOperand.combinedFragment.interactionOperator =
	 * InteractionOperatorKind::loop
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
	 * @body minint->notEmpty() implies 
	 * minint->asSequence()->first().integerValue() >= 0
	 */
	def validate_minint_non_negative: Boolean = {
		// Start of user code for "minint_non_negative"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLInteractionConstraintOps
