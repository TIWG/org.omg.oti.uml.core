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
  * A PartDecomposition is a description of the internal Interactions of one Lifeline relative to an Interaction.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPartDecompositionOps[Uml <: UML] { self: UMLPartDecomposition[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * Assume that within Interaction X, Lifeline L is of class C and decomposed to D. Within X there is a sequence of constructs along L (such constructs are CombinedFragments, InteractionUse and (plain) OccurrenceSpecifications). Then a corresponding sequence of constructs must appear within D, matched one-to-one in the same order. i) CombinedFragment covering L are matched with an extra-global CombinedFragment in D. ii) An InteractionUse covering L is matched with a global (i.e., covering all Lifelines) InteractionUse in D. iii) A plain OccurrenceSpecification on L is considered an actualGate that must be matched by a formalGate of D.
    *
    * <!-- Start of user code doc for validate_assume -->
    * <!-- End of user code doc for validate_assume -->
    *
    * {{{
    * }}}
    */
  def validate_assume: Boolean = {
    // Start of user code for "assume"
    ???
    // End of user code
  }

  /**
    * Assume that within Interaction X, Lifeline L is of class C and decomposed to D. Assume also that there is within X an InteractionUse (say) U that covers L. According to the constraint above U will have a counterpart CU within D. Within the Interaction referenced by U, L should also be decomposed, and the decomposition should reference CU. (This rule is called commutativity of decomposition.)
    *
    * <!-- Start of user code doc for validate_commutativity_of_decomposition -->
    * <!-- End of user code doc for validate_commutativity_of_decomposition -->
    *
    * {{{
    * }}}
    */
  def validate_commutativity_of_decomposition: Boolean = {
    // Start of user code for "commutativity_of_decomposition"
    ???
    // End of user code
  }

  /**
    * PartDecompositions apply only to Parts that are Parts of Internal Structures not to Parts of Collaborations.
    *
    * <!-- Start of user code doc for validate_parts_of_internal_structures -->
    * <!-- End of user code doc for validate_parts_of_internal_structures -->
    *
    * {{{
    * }}}
    */
  def validate_parts_of_internal_structures: Boolean = {
    // Start of user code for "parts_of_internal_structures"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLPartDecompositionOps
