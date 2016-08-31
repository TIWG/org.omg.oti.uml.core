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
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
// End of user code

/**
  * An InteractionOperand is contained in a CombinedFragment. An InteractionOperand represents one operand of the expression given by the enclosing CombinedFragment.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInteractionOperandOps[Uml <: UML] { self: UMLInteractionOperand[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Constraint of the operand.
    *
    * <!-- Start of user code doc for guard -->
    * <!-- End of user code doc for guard -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionConstraint.guard_interactionOperand
    */
  def guard: Option[UMLInteractionConstraint[Uml]] = ownedElement.selectByKindOf { case x: UMLInteractionConstraint[Uml] => x } headOption

  /**
    * <!-- Start of user code doc for operand_combinedFragment -->
    * <!-- End of user code doc for operand_combinedFragment -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLCombinedFragment.operand
    */
  def operand_combinedFragment: Option[UMLCombinedFragment[Uml]] = owner.selectByKindOf { case x: UMLCombinedFragment[Uml] => x }

  /**
    * The guard must contain only references to values local to the Lifeline on which it resides, or values global to the whole Interaction.
    *
    * <!-- Start of user code doc for validate_guard_contain_references -->
    * <!-- End of user code doc for validate_guard_contain_references -->
    *
    * {{{
    * }}}
    */
  def validate_guard_contain_references: Boolean = {
    // Start of user code for "guard_contain_references"
    ???
    // End of user code
  }

  /**
    * The guard must be placed directly prior to (above) the OccurrenceSpecification that will become the first OccurrenceSpecification within this InteractionOperand.
    *
    * <!-- Start of user code doc for validate_guard_directly_prior -->
    * <!-- End of user code doc for validate_guard_directly_prior -->
    *
    * {{{
    * }}}
    */
  def validate_guard_directly_prior: Boolean = {
    // Start of user code for "guard_directly_prior"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLInteractionOperandOps
