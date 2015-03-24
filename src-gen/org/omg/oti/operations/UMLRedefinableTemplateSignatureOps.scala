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
 * A RedefinableTemplateSignature supports the addition of formal template parameters in a specialization of a template classifier.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLRedefinableTemplateSignatureOps[Uml <: UML] { self: UMLRedefinableTemplateSignature[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Classifier that owns this RedefinableTemplateSignature.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLClassifier.ownedTemplateSignature
	 */
	def classifier: Option[UMLClassifier[Uml]] = redefinitionContext headOption

	/**
	 * <!-- begin-model-doc -->
	 * The signatures extended by this RedefinableTemplateSignature.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRedefinableTemplateSignature.extendedSignature_redefinableTemplateSignature
	 */
	def extendedSignature: Set[UMLRedefinableTemplateSignature[Uml]] = redefinedElement.selectByKindOf { case x: UMLRedefinableTemplateSignature[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The formal template parameters of the extended signatures.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTemplateParameter.inheritedParameter_redefinableTemplateSignature
	 * @body result = (if extendedSignature->isEmpty() then Set{} else extendedSignature.parameter->asSet() endif)
	 */
	def inheritedParameter: Set[UMLTemplateParameter[Uml]] = {
		// Start of user code for "inheritedParameter"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRedefinableTemplateSignature.extendedSignature
	 */
	def extendedSignature_redefinableTemplateSignature: Set[UMLRedefinableTemplateSignature[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLRedefinableTemplateSignature[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The query isConsistentWith() specifies, for any two RedefinableTemplateSignatures in a context in which redefinition is possible, whether redefinition would be logically consistent. A redefining template signature is always consistent with a redefined template signature, as redefinition only adds new formal parameters.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (redefiningElement.oclIsKindOf(RedefinableTemplateSignature))
	 */
	override def isConsistentWith(redefiningElement: Option[UMLRedefinableElement[Uml]]): Boolean  = {
		// Start of user code for "isConsistentWith"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If any of the parent Classifiers are a template, then the extendedSignature must include the signature of that Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @body classifier.allParents()->forAll(c | c.ownedTemplateSignature->notEmpty() implies self->closure(extendedSignature)->includes(c.ownedTemplateSignature))
	 */
	def validate_redefines_parents: Boolean  = {
		// Start of user code for "redefines_parents"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLRedefinableTemplateSignature
