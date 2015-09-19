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
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code

/**
 * A CombinedFragment defines an expression of InteractionFragments. A CombinedFragment is defined by an interaction operator and corresponding InteractionOperands. Through the use of CombinedFragments the user will be able to describe a number of traces in a compact and concise manner.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLCombinedFragmentOps[Uml <: UML] { self: UMLCombinedFragment[Uml] =>

// Start of user code for class imports
	import self.ops._
// End of user code


	/**
	 * Specifies the gates that form the interface between this CombinedFragment and its surroundings
	 *
	 * <!-- Start of user code doc for cfragmentGate -->
   * <!-- End of user code doc for cfragmentGate -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLGate.cfragmentGate_combinedFragment
	 */
	def cfragmentGate: Set[UMLGate[Uml]] = ownedElement.selectByKindOf { case x: UMLGate[Uml] => x }

	/**
	 * If the interactionOperator is break, the corresponding InteractionOperand must cover all Lifelines covered by the enclosing InteractionFragment.
	 *
	 * <!-- Start of user code doc for validate_break -->
   * <!-- End of user code doc for validate_break -->
	 *
	 * {{{
	 * OCL Body interactionOperator=InteractionOperatorKind::break  implies   
	 * enclosingInteraction.oclAsType(InteractionFragment)->asSet()->union(
	 *    enclosingOperand.oclAsType(InteractionFragment)->asSet()).covered->asSet() = self.covered->asSet()
	 * }}}
	 */
	def validate_break: Boolean = {
		// Start of user code for "break"
      ???
      // End of user code
	}

	/**
	 * The interaction operators 'consider' and 'ignore' can only be used for the ConsiderIgnoreFragment subtype of CombinedFragment
	 *
	 * <!-- Start of user code doc for validate_consider_and_ignore -->
   * <!-- End of user code doc for validate_consider_and_ignore -->
	 *
	 * {{{
	 * OCL Body ((interactionOperator = InteractionOperatorKind::consider) or (interactionOperator =  InteractionOperatorKind::ignore)) implies oclIsKindOf(ConsiderIgnoreFragment)
	 * }}}
	 */
	def validate_consider_and_ignore: Boolean = {
		// Start of user code for "consider_and_ignore"
      ???
      // End of user code
	}

	/**
	 * If the interactionOperator is opt, loop, break, assert or neg, there must be exactly one operand.
	 *
	 * <!-- Start of user code doc for validate_opt_loop_break_neg -->
   * <!-- End of user code doc for validate_opt_loop_break_neg -->
	 *
	 * {{{
	 * OCL Body (interactionOperator =  InteractionOperatorKind::opt or interactionOperator = InteractionOperatorKind::loop or
	 * interactionOperator = InteractionOperatorKind::break or interactionOperator = InteractionOperatorKind::assert or
	 * interactionOperator = InteractionOperatorKind::neg)
	 * implies operand->size()=1
	 * }}}
	 */
	def validate_opt_loop_break_neg: Boolean = {
		// Start of user code for "opt_loop_break_neg"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLCombinedFragmentOps
