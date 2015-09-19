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
 * A GeneralizationSet is a PackageableElement whose instances represent sets of Generalization relationships.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLGeneralizationSetOps[Uml <: UML] { self: UMLGeneralizationSet[Uml] =>

// Start of user code for class imports
// End of user code


	/**
	 * Every Generalization associated with a particular GeneralizationSet must have the same general Classifier.
	 *
	 * <!-- Start of user code doc for validate_generalization_same_classifier -->
   * <!-- End of user code doc for validate_generalization_same_classifier -->
	 *
	 * {{{
	 * OCL Body generalization->collect(general)->asSet()->size() <= 1
	 * }}}
	 */
	def validate_generalization_same_classifier: Boolean = {
		// Start of user code for "generalization_same_classifier"
      ???
      // End of user code
	}

	/**
	 * The Classifier that maps to a GeneralizationSet may neither be a specific nor a general Classifier in any of the Generalization relationships defined for that GeneralizationSet. In other words, a power type may not be an instance of itself nor may its instances be its subclasses.
	 *
	 * <!-- Start of user code doc for validate_maps_to_generalization_set -->
   * <!-- End of user code doc for validate_maps_to_generalization_set -->
	 *
	 * {{{
	 * OCL Body powertype <> null implies generalization->forAll( gen | 
	 *     not (gen.general = powertype) and not gen.general.allParents()->includes(powertype) and not (gen.specific = powertype) and not powertype.allParents()->includes(gen.specific)
	 *   )
	 * }}}
	 */
	def validate_maps_to_generalization_set: Boolean = {
		// Start of user code for "maps_to_generalization_set"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLGeneralizationSetOps
