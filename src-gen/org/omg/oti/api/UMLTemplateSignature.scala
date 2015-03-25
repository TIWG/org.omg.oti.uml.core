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
 * A Template Signature bundles the set of formal TemplateParameters for a template.
 * <!-- end-model-doc -->
 */
trait UMLTemplateSignature[Uml <: UML]
	extends UMLElement[Uml]
	with UMLTemplateSignatureOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The formal parameters that are owned by this TemplateSignature.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTemplateParameter.signature
	 */
	def ownedParameter: Seq[UMLTemplateParameter[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ordered set of all formal TemplateParameters for this TemplateSignature.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLTemplateParameter.parameter_templateSignature
	 */
	def parameter: Seq[UMLTemplateParameter[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The TemplateableElement that owns this TemplateSignature.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLTemplateableElement.ownedTemplateSignature
	 */
	def template: Option[UMLTemplateableElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTemplateBinding.signature
	 */
	def signature_templateBinding: Set[UMLTemplateBinding[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		templateSignature_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTemplateSignature
	 */
	def templateSignature_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			element_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		templateSignature_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTemplateSignature
	 */
	def templateSignature_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLTemplateSignature[Uml], UMLTemplateParameter[Uml]]("ownedParameter", _.ownedParameter)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		templateSignature_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTemplateSignature
	 */
	def templateSignature_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLTemplateSignature[Uml], UMLTemplateParameter[Uml]]("parameter", _.parameter)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		templateSignature_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTemplateSignature
	 */
	def templateSignature_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		parameter ++
		template 

} //UMLTemplateSignature
