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
 * A TemplateParameter exposes a ParameterableElement as a formal parameter of a template.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLTemplateParameter[Uml <: UML]
	extends UMLElement[Uml]
	with UMLTemplateParameterOps[Uml] {
	
	import ops._

	/**
	 * The ParameterableElement that is the default for this formal TemplateParameter.
	 *
	 * <!-- Start of user code doc for default -->
	 * <!-- End of user code doc for default -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLParameterableElement.default_templateParameter
	 */
	def default: Option[UMLParameterableElement[Uml]]

	/**
	 * The ParameterableElement that is owned by this TemplateParameter for the purpose of exposing it as the parameteredElement.
	 *
	 * <!-- Start of user code doc for ownedParameteredElement -->
	 * <!-- End of user code doc for ownedParameteredElement -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLParameterableElement.owningTemplateParameter
	 */
	def ownedParameteredElement: Option[UMLParameterableElement[Uml]]

	/**
	 * The ParameterableElement exposed by this TemplateParameter.
	 *
	 * <!-- Start of user code doc for parameteredElement -->
	 * <!-- End of user code doc for parameteredElement -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLParameterableElement.templateParameter
	 */
	def parameteredElement: Option[UMLParameterableElement[Uml]]

	/**
	 * <!-- Start of user code doc for formal_templateParameterSubstitution -->
	 * <!-- End of user code doc for formal_templateParameterSubstitution -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTemplateParameterSubstitution.formal
	 */
	def formal_templateParameterSubstitution: Set[UMLTemplateParameterSubstitution[Uml]]

	/**
	 * <!-- Start of user code doc for inheritedParameter_redefinableTemplateSignature -->
	 * <!-- End of user code doc for inheritedParameter_redefinableTemplateSignature -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRedefinableTemplateSignature.inheritedParameter
	 */
	def inheritedParameter_redefinableTemplateSignature: Set[UMLRedefinableTemplateSignature[Uml]]

	/**
	 * <!-- Start of user code doc for parameter_templateSignature -->
	 * <!-- End of user code doc for parameter_templateSignature -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTemplateSignature.parameter
	 */
	def parameter_templateSignature: Set[UMLTemplateSignature[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		templateParameter_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTemplateParameter
	 *
	 * <!-- Start of user code doc for templateParameter_metaAttributes -->
	 * <!-- End of user code doc for templateParameter_metaAttributes -->
	 */
	def templateParameter_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			element_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		templateParameter_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTemplateParameter
	 *
	 * <!-- Start of user code doc for templateParameter_compositeMetaProperties -->
	 * <!-- End of user code doc for templateParameter_compositeMetaProperties -->
	 */
	def templateParameter_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_compositeMetaProperties,
			Seq (TemplateParameter_ownedDefault,
				TemplateParameter_ownedParameteredElement))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		templateParameter_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTemplateParameter
	 *
	 * <!-- Start of user code doc for templateParameter_referenceMetaProperties -->
	 * <!-- End of user code doc for templateParameter_referenceMetaProperties -->
	 */
	def templateParameter_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_referenceMetaProperties,
			Seq (TemplateParameter_default,
				TemplateParameter_parameteredElement))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		templateParameter_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTemplateParameter
	 *
	 * <!-- Start of user code doc for templateParameter_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for templateParameter_forwardReferencesFromMetamodelAssociations -->
	 */
	def templateParameter_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		default ++
		parameteredElement 

	// Start of user code for additional features
	// End of user code
} //UMLTemplateParameter
