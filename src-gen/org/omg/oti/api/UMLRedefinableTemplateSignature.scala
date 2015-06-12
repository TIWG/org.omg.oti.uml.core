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
package org.omg.oti.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.operations._
// End of user code

/**
 * A RedefinableTemplateSignature supports the addition of formal template parameters in a specialization of a template classifier.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLRedefinableTemplateSignature[Uml <: UML]
	extends UMLRedefinableElement[Uml]
	with UMLTemplateSignature[Uml]
	with UMLRedefinableTemplateSignatureOps[Uml] {
	
	import ops._

	/**
	 * The Classifier that owns this RedefinableTemplateSignature.
	 *
	 * <!-- Start of user code doc for classifier -->
	 * <!-- End of user code doc for classifier -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLClassifier.ownedTemplateSignature
	 */
	def classifier: Option[UMLClassifier[Uml]]

	/**
	 * The signatures extended by this RedefinableTemplateSignature.
	 *
	 * <!-- Start of user code doc for extendedSignature -->
	 * <!-- End of user code doc for extendedSignature -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRedefinableTemplateSignature.extendedSignature_redefinableTemplateSignature
	 */
	def extendedSignature: Set[UMLRedefinableTemplateSignature[Uml]]

	/**
	 * The formal template parameters of the extended signatures.
	 *
	 * <!-- Start of user code doc for inheritedParameter -->
	 * <!-- End of user code doc for inheritedParameter -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTemplateParameter.inheritedParameter_redefinableTemplateSignature
	 * @body result = (if extendedSignature->isEmpty() then Set{} else extendedSignature.parameter->asSet() endif)
	 */
	def inheritedParameter: Set[UMLTemplateParameter[Uml]]

	/**
	 * <!-- Start of user code doc for extendedSignature_redefinableTemplateSignature -->
	 * <!-- End of user code doc for extendedSignature_redefinableTemplateSignature -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRedefinableTemplateSignature.extendedSignature
	 */
	def extendedSignature_redefinableTemplateSignature: Set[UMLRedefinableTemplateSignature[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		redefinableTemplateSignature_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLRedefinableTemplateSignature
	 *
	 * <!-- Start of user code doc for redefinableTemplateSignature_metaAttributes -->
	 * <!-- End of user code doc for redefinableTemplateSignature_metaAttributes -->
	 */
	def redefinableTemplateSignature_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			redefinableElement_metaAttributes,
			templateSignature_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		redefinableTemplateSignature_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLRedefinableTemplateSignature
	 *
	 * <!-- Start of user code doc for redefinableTemplateSignature_compositeMetaProperties -->
	 * <!-- End of user code doc for redefinableTemplateSignature_compositeMetaProperties -->
	 */
	def redefinableTemplateSignature_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			redefinableElement_compositeMetaProperties,
			templateSignature_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		redefinableTemplateSignature_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLRedefinableTemplateSignature
	 *
	 * <!-- Start of user code doc for redefinableTemplateSignature_referenceMetaProperties -->
	 * <!-- End of user code doc for redefinableTemplateSignature_referenceMetaProperties -->
	 */
	def redefinableTemplateSignature_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			redefinableElement_referenceMetaProperties,
			templateSignature_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLRedefinableTemplateSignature[Uml], UMLRedefinableTemplateSignature[Uml]]("extendedSignature", _.extendedSignature)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		redefinableTemplateSignature_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLRedefinableTemplateSignature
	 *
	 * <!-- Start of user code doc for redefinableTemplateSignature_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for redefinableTemplateSignature_forwardReferencesFromMetamodelAssociations -->
	 */
	def redefinableTemplateSignature_forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		templateSignature_forwardReferencesFromMetamodelAssociations ++
		classifier ++
		extendedSignature 

	// Start of user code for additional features
	// End of user code
} //UMLRedefinableTemplateSignature
