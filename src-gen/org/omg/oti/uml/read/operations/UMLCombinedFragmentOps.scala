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
import scala.collection.immutable.Set
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
