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

import org.omg.oti.uml.read.api.{UMLPartDecomposition, UML}
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * A PartDecomposition is a description of the internal Interactions of one Lifeline relative to an Interaction.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLPartDecompositionOps[Uml <: UML] { self: UMLPartDecomposition[Uml] =>	

	import self.ops._

	/**
	 * Assume that within Interaction X, Lifeline L is of class C and decomposed to D. Within X there is a sequence of constructs along L (such constructs are CombinedFragments, InteractionUse and (plain) OccurrenceSpecifications). Then a corresponding sequence of constructs must appear within D, matched one-to-one in the same order. i) CombinedFragment covering L are matched with an extra-global CombinedFragment in D. ii) An InteractionUse covering L is matched with a global (i.e., covering all Lifelines) InteractionUse in D. iii) A plain OccurrenceSpecification on L is considered an actualGate that must be matched by a formalGate of D.
	 *
	 * <!-- Start of user code doc for validate_assume -->
	 * <!-- End of user code doc for validate_assume -->
	 *
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
	 */
	def validate_parts_of_internal_structures: Boolean = {
		// Start of user code for "parts_of_internal_structures"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLPartDecompositionOps
