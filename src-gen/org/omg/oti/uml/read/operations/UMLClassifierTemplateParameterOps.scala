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
import scala.None
import scala.Some
// End of user code

/**
 * A ClassifierTemplateParameter exposes a Classifier as a formal template parameter.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLClassifierTemplateParameterOps[Uml <: UML] { self: UMLClassifierTemplateParameter[Uml] =>

// Start of user code for class imports
// End of user code


	/**
	 * The argument to a ClassifierTemplateParameter is a Classifier.
	 *
	 * <!-- Start of user code doc for validate_actual_is_classifier -->
   * <!-- End of user code doc for validate_actual_is_classifier -->
	 *
	 * {{{
	 * OCL Body  templateParameterSubstitution.actual->forAll(a | a.oclIsKindOf(Classifier))
	 * }}}
	 */
	def validate_actual_is_classifier: Boolean = {
		// Start of user code for "actual_is_classifier"
    formal_templateParameterSubstitution.forall(tps => tps.actual match {
      case Some(_: UMLClassifier[Uml]) => true
      case _                           => false
    })
    // End of user code
	}

	/**
	 * If there are any constrainingClassifiers, then every argument must be the same as or a specialization of them, or if allowSubstitutable is true, then it can also be substitutable.
	 *
	 * <!-- Start of user code doc for validate_constraining_classifiers_constrain_args -->
   * <!-- End of user code doc for validate_constraining_classifiers_constrain_args -->
	 *
	 * {{{
	 * OCL Body templateParameterSubstitution.actual->forAll( a |
	 * }}}
	 * {{{
	 *   let arg : Classifier = a.oclAsType(Classifier) in
	 * }}}
	 * {{{
	 *     constrainingClassifier->forAll(
	 * }}}
	 * {{{
	 *       cc |  
	 * }}}
	 * {{{
	 *          arg = cc or arg.conformsTo(cc) or (allowSubstitutable and arg.isSubstitutableFor(cc))
	 * }}}
	 * {{{
	 *       )
	 * }}}
	 * {{{
	 * )
	 * }}}
	 */
	def validate_constraining_classifiers_constrain_args: Boolean = {
		// Start of user code for "constraining_classifiers_constrain_args"
    formal_templateParameterSubstitution.forall(tps => tps.actual match {
      case Some(a: UMLClassifier[Uml]) =>
        constrainingClassifier.forall {
                                        cc =>
                                          a == cc ||
                                            a.conformsTo(Some(cc)) ||
                                            allowSubstitutable && a.isSubstitutableFor(Some(cc))
                                      }
      case _                           =>
        false
    })
    // End of user code
	}

	/**
	 * If there are any constrainingClassifiers, then the parameteredElement must be the same as or a specialization of them, or if allowSubstitutable is true, then it can also be substitutable.
	 *
	 * <!-- Start of user code doc for validate_constraining_classifiers_constrain_parametered_element -->
   * <!-- End of user code doc for validate_constraining_classifiers_constrain_parametered_element -->
	 *
	 * {{{
	 * OCL Body constrainingClassifier->forAll(
	 * }}}
	 * {{{
	 *      cc |  parameteredElement = cc or parameteredElement.conformsTo(cc) or (allowSubstitutable and parameteredElement.isSubstitutableFor(cc))
	 * }}}
	 * {{{
	 * )
	 * }}}
	 */
	def validate_constraining_classifiers_constrain_parametered_element: Boolean = {
		// Start of user code for "constraining_classifiers_constrain_parametered_element"
    parameteredElement match {
      case Some(pc) =>
        constrainingClassifier.forall {
                                        cc =>
                                          pc == cc ||
                                            pc.conformsTo(Some(cc)) ||
                                            allowSubstitutable && pc.isSubstitutableFor(Some(cc))
                                      }
      case None     =>
        true
    }
    // End of user code
	}

	/**
	 * If allowSubstitutable is true, then there must be a constrainingClassifier.
	 *
	 * <!-- Start of user code doc for validate_has_constraining_classifier -->
   * <!-- End of user code doc for validate_has_constraining_classifier -->
	 *
	 * {{{
	 * OCL Body allowSubstitutable implies constrainingClassifier->notEmpty()
	 * }}}
	 */
	def validate_has_constraining_classifier: Boolean = {
		// Start of user code for "has_constraining_classifier"
    !allowSubstitutable || constrainingClassifier.nonEmpty
    // End of user code
	}

	/**
	 * If the parameteredElement is not abstract, then the Classifier used as an argument shall not be abstract.
	 *
	 * <!-- Start of user code doc for validate_matching_abstract -->
   * <!-- End of user code doc for validate_matching_abstract -->
	 *
	 * {{{
	 * OCL Body (not parameteredElement.isAbstract) implies templateParameterSubstitution.actual->forAll(a | not a.oclAsType(Classifier).isAbstract)
	 * }}}
	 */
	def validate_matching_abstract: Boolean = {
		// Start of user code for "matching_abstract"
    parameteredElement match {
      case Some(pc) =>
        pc.isAbstract ||
          formal_templateParameterSubstitution.forall {
                                                        tps =>
                                                          tps.actual match {
                                                            case Some(a: UMLClassifier[Uml]) =>
                                                              !a.isAbstract
                                                            case _                           =>
                                                              true
                                                          }
                                                      }
      case None     =>
        true
    }
    // End of user code
	}

	/**
	 * The parameteredElement has no direct features, and if constrainedElement is empty it has no generalizations.
	 *
	 * <!-- Start of user code doc for validate_parametered_element_no_features -->
   * <!-- End of user code doc for validate_parametered_element_no_features -->
	 *
	 * {{{
	 * OCL Body parameteredElement.feature->isEmpty() and (constrainingClassifier->isEmpty() implies  parameteredElement.allParents()->isEmpty())
	 * }}}
	 */
	def validate_parametered_element_no_features: Boolean = {
		// Start of user code for "parametered_element_no_features"
    parameteredElement match {
      case Some(pc) =>
        pc.feature.nonEmpty || constrainingClassifier.nonEmpty || pc.allParents.isEmpty
      case None     =>
        true
    }
    // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLClassifierTemplateParameterOps
