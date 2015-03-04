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
package org.omg.oti.operations

// Start of user code for imports
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * <!-- begin-model-doc --> 
 * A ClassifierTemplateParameter exposes a Classifier as a formal template parameter.
 * <!-- end-model-doc --> 
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLClassifierTemplateParameterOps[Uml <: UML] { self: UMLClassifierTemplateParameter[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The argument to a ClassifierTemplateParameter is a Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @body  templateParameterSubstitution.actual->forAll(a | a.oclIsKindOf(Classifier))
	 */
	def validate_actual_is_classifier: Boolean  = {
    	// Start of user code for "actual_is_classifier"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If there are any constrainingClassifiers, then every argument must be the same as or a specialization of them, or if allowSubstitutable is true, then it can also be substitutable.
	 * <!-- end-model-doc -->
	 *
	 * @body templateParameterSubstitution.actual->forAll( a |
	 *   let arg : Classifier = a.oclAsType(Classifier) in
	 *     constrainingClassifier->forAll(
	 *       cc |  
	 *          arg = cc or arg.conformsTo(cc) or (allowSubstitutable and arg.isSubstitutableFor(cc))
	 *       )
	 * )
	 */
	def validate_constraining_classifiers_constrain_args: Boolean  = {
    	// Start of user code for "constraining_classifiers_constrain_args"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If there are any constrainingClassifiers, then the parameteredElement must be the same as or a specialization of them, or if allowSubstitutable is true, then it can also be substitutable.
	 * <!-- end-model-doc -->
	 *
	 * @body constrainingClassifier->forAll(
	 *      cc |  parameteredElement = cc or parameteredElement.conformsTo(cc) or (allowSubstitutable and parameteredElement.isSubstitutableFor(cc))
	 * )
	 */
	def validate_constraining_classifiers_constrain_parametered_element: Boolean  = {
    	// Start of user code for "constraining_classifiers_constrain_parametered_element"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If allowSubstitutable is true, then there must be a constrainingClassifier.
	 * <!-- end-model-doc -->
	 *
	 * @body allowSubstitutable implies constrainingClassifier->notEmpty()
	 */
	def validate_has_constraining_classifier: Boolean  = {
    	// Start of user code for "has_constraining_classifier"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If the parameteredElement is not abstract, then the Classifier used as an argument shall not be abstract.
	 * <!-- end-model-doc -->
	 *
	 * @body (not parameteredElement.isAbstract) implies templateParameterSubstitution.actual->forAll(a | not a.oclAsType(Classifier).isAbstract)
	 */
	def validate_matching_abstract: Boolean  = {
    	// Start of user code for "matching_abstract"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The parameteredElement has no direct features, and if constrainedElement is empty it has no generalizations.
	 * <!-- end-model-doc -->
	 *
	 * @body parameteredElement.feature->isEmpty() and (constrainingClassifier->isEmpty() implies  parameteredElement.allParents()->isEmpty())
	 */
	def validate_parametered_element_no_features: Boolean  = {
    	// Start of user code for "parametered_element_no_features"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLClassifierTemplateParameter
