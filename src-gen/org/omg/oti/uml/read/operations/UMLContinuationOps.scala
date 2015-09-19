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
import scala.Boolean
import scala.Predef.???
// End of user code

/**
 * A Continuation is a syntactic way to define continuations of different branches of an alternative CombinedFragment. Continuations are intuitively similar to labels representing intermediate points in a flow of control.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLContinuationOps[Uml <: UML] { self: UMLContinuation[Uml] =>

// Start of user code for class imports
// End of user code


	/**
	 * Continuations always occur as the very first InteractionFragment or the very last InteractionFragment of the enclosing InteractionOperand.
	 *
	 * <!-- Start of user code doc for validate_first_or_last_interaction_fragment -->
   * <!-- End of user code doc for validate_first_or_last_interaction_fragment -->
	 *
	 * {{{
	 * OCL Body  enclosingOperand->notEmpty() and 
	 *  let peerFragments : OrderedSet(InteractionFragment) =  enclosingOperand.fragment in 
	 *    ( peerFragments->notEmpty() and 
	 *    ((peerFragments->first() = self) or  (peerFragments->last() = self)))
	 * }}}
	 */
	def validate_first_or_last_interaction_fragment: Boolean = {
		// Start of user code for "first_or_last_interaction_fragment"
      ???
      // End of user code
	}

	/**
	 * Continuations are always global in the enclosing InteractionFragment e.g., it always covers all Lifelines covered by the enclosing InteractionOperator.
	 *
	 * <!-- Start of user code doc for validate_global -->
   * <!-- End of user code doc for validate_global -->
	 *
	 * {{{
	 * OCL Body enclosingOperand->notEmpty() and
	 *   let operandLifelines : Set(Lifeline) =  enclosingOperand.covered in 
	 *     (operandLifelines->notEmpty() and 
	 *     operandLifelines->forAll(ol :Lifeline |self.covered->includes(ol)))
	 * }}}
	 */
	def validate_global: Boolean = {
		// Start of user code for "global"
      ???
      // End of user code
	}

	/**
	 * Across all Interaction instances having the same context value, every Lifeline instance covered by a Continuation (self) must be common with one covered Lifeline instance of all other Continuation instances with the same name as self, and every Lifeline instance covered by a Continuation instance with the same name as self must be common with one covered Lifeline instance of self. Lifeline instances are common if they have the same selector and represents associationEnd values.
	 *
	 * <!-- Start of user code doc for validate_same_name -->
   * <!-- End of user code doc for validate_same_name -->
	 *
	 * {{{
	 * OCL Body enclosingOperand.combinedFragment->notEmpty() and
	 * let parentInteraction : Set(Interaction) = 
	 * enclosingOperand.combinedFragment->closure(enclosingOperand.combinedFragment)->
	 * collect(enclosingInteraction).oclAsType(Interaction)->asSet()
	 * in 
	 * (parentInteraction->size() = 1) 
	 * and let peerInteractions : Set(Interaction) =
	 *  (parentInteraction->union(parentInteraction->collect(_'context')->collect(behavior)->
	 *  select(oclIsKindOf(Interaction)).oclAsType(Interaction)->asSet())->asSet()) in
	 *  (peerInteractions->notEmpty()) and 
	 *   let combinedFragments1 : Set(CombinedFragment) = peerInteractions.fragment->
	 *  select(oclIsKindOf(CombinedFragment)).oclAsType(CombinedFragment)->asSet() in
	 *    combinedFragments1->notEmpty() and  combinedFragments1->closure(operand.fragment->
	 *    select(oclIsKindOf(CombinedFragment)).oclAsType(CombinedFragment))->asSet().operand.fragment->
	 *    select(oclIsKindOf(Continuation)).oclAsType(Continuation)->asSet()->
	 *    forAll(c : Continuation |  (c.name = self.name) implies 
	 *   (c.covered->asSet()->forAll(cl : Lifeline | --  cl must be common to one lifeline covered by self
	 *   self.covered->asSet()->
	 *   select(represents = cl.represents and selector = cl.selector)->asSet()->size()=1))
	 *    and
	 *  (self.covered->asSet()->forAll(cl : Lifeline | --  cl must be common to one lifeline covered by c
	 *  c.covered->asSet()->
	 *   select(represents = cl.represents and selector = cl.selector)->asSet()->size()=1))
	 *   )
	 * }}}
	 */
	def validate_same_name: Boolean = {
		// Start of user code for "same_name"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLContinuationOps
