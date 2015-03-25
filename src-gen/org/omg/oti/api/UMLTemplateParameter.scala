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
 * <!-- begin-model-doc -->
 * A TemplateParameter exposes a ParameterableElement as a formal parameter of a template.
 * <!-- end-model-doc -->
 */
trait UMLTemplateParameter[Uml <: UML]
	extends UMLElement[Uml]
	with UMLTemplateParameterOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The ParameterableElement that is the default for this formal TemplateParameter.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLParameterableElement.default_templateParameter
	 */
	def default: Option[UMLParameterableElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ParameterableElement that is owned by this TemplateParameter for the purpose of providing a default.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLParameterableElement.ownedDefault_templateParameter
	 */
	def ownedDefault: Option[UMLParameterableElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ParameterableElement that is owned by this TemplateParameter for the purpose of exposing it as the parameteredElement.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLParameterableElement.owningTemplateParameter
	 */
	def ownedParameteredElement: Option[UMLParameterableElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ParameterableElement exposed by this TemplateParameter.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLParameterableElement.templateParameter
	 */
	def parameteredElement: Option[UMLParameterableElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The TemplateSignature that owns this TemplateParameter.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLTemplateSignature.ownedParameter
	 */
	def signature: Option[UMLTemplateSignature[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTemplateParameterSubstitution.formal
	 */
	def formal_templateParameterSubstitution: Set[UMLTemplateParameterSubstitution[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRedefinableTemplateSignature.inheritedParameter
	 */
	def inheritedParameter_redefinableTemplateSignature: Set[UMLRedefinableTemplateSignature[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTemplateSignature.parameter
	 */
	def parameter_templateSignature: Set[UMLTemplateSignature[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		templateParameter_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTemplateParameter
	 */
	def templateParameter_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			element_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		templateParameter_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTemplateParameter
	 */
	def templateParameter_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLParameterableElement[Uml]]("ownedDefault", _.ownedDefault),
				MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLParameterableElement[Uml]]("ownedParameteredElement", _.ownedParameteredElement)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		templateParameter_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTemplateParameter
	 */
	def templateParameter_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLParameterableElement[Uml]]("default", _.default),
				MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLParameterableElement[Uml]]("parameteredElement", _.parameteredElement)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		templateParameter_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTemplateParameter
	 */
	def templateParameter_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		default ++
		parameteredElement ++
		signature 

} //UMLTemplateParameter
