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
