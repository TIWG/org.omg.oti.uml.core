/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
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
import scala.Option
import scala.Predef.???
// End of user code

/**
 * A RedefinableElement is an element that, when defined in the context of a Classifier, can be redefined more specifically or differently in the context of another Classifier that specializes (directly or indirectly) the context Classifier.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLRedefinableElementOps[Uml <: UML] { self: UMLRedefinableElement[Uml] =>

// Start of user code for class imports
// End of user code


	/**
	 * The query isConsistentWith() specifies, for any two RedefinableElements in a context in which redefinition is possible, whether redefinition would be logically consistent. By default, this is false; this operation must be overridden for subclasses of RedefinableElement to define the consistency conditions.
	 *
	 * <!-- Start of user code doc for isConsistentWith -->
   * <!-- End of user code doc for isConsistentWith -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (false)
	 * }}}
	 */
	def isConsistentWith(redefiningElement: Option[UMLRedefinableElement[Uml]]): Boolean = {
		// Start of user code for "isConsistentWith"
      ???
      // End of user code
	}

	/**
	 * The query isRedefinitionContextValid() specifies whether the redefinition contexts of this RedefinableElement are properly related to the redefinition contexts of the specified RedefinableElement to allow this element to redefine the other. By default at least one of the redefinition contexts of this element must be a specialization of at least one of the redefinition contexts of the specified element.
	 *
	 * <!-- Start of user code doc for isRedefinitionContextValid -->
   * <!-- End of user code doc for isRedefinitionContextValid -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (redefinitionContext->exists(c | c.allParents()->includesAll(redefinedElement.redefinitionContext)))
	 * }}}
	 */
	def isRedefinitionContextValid(redefinedElement: Option[UMLRedefinableElement[Uml]]): Boolean = {
		// Start of user code for "isRedefinitionContextValid"
      ???
      // End of user code
	}

	/**
	 * A RedefinableElement can only redefine non-leaf RedefinableElements.
	 *
	 * <!-- Start of user code doc for validate_non_leaf_redefinition -->
   * <!-- End of user code doc for validate_non_leaf_redefinition -->
	 *
	 * {{{
	 * OCL Body redefinedElement->forAll(re | not re.isLeaf)
	 * }}}
	 */
	def validate_non_leaf_redefinition: Boolean = {
		// Start of user code for "non_leaf_redefinition"
      ???
      // End of user code
	}

	/**
	 * A redefining element must be consistent with each redefined element.
	 *
	 * <!-- Start of user code doc for validate_redefinition_consistent -->
   * <!-- End of user code doc for validate_redefinition_consistent -->
	 *
	 * {{{
	 * OCL Body redefinedElement->forAll(re | re.isConsistentWith(self))
	 * }}}
	 */
	def validate_redefinition_consistent: Boolean = {
		// Start of user code for "redefinition_consistent"
      ???
      // End of user code
	}

	/**
	 * At least one of the redefinition contexts of the redefining element must be a specialization of at least one of the redefinition contexts for each redefined element.
	 *
	 * <!-- Start of user code doc for validate_redefinition_context_valid -->
   * <!-- End of user code doc for validate_redefinition_context_valid -->
	 *
	 * {{{
	 * OCL Body redefinedElement->forAll(re | self.isRedefinitionContextValid(re))
	 * }}}
	 */
	def validate_redefinition_context_valid: Boolean = {
		// Start of user code for "redefinition_context_valid"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLRedefinableElementOps
