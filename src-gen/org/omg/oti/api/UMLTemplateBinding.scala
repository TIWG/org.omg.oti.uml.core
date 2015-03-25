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
 * A TemplateBinding is a DirectedRelationship between a TemplateableElement and a template. A TemplateBinding specifies the TemplateParameterSubstitutions of actual parameters for the formal parameters of the template.
 * <!-- end-model-doc -->
 */
trait UMLTemplateBinding[Uml <: UML]
	extends UMLDirectedRelationship[Uml]
	with UMLTemplateBindingOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The TemplateableElement that is bound by this TemplateBinding.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLTemplateableElement.templateBinding
	 */
	def boundElement: Option[UMLTemplateableElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The TemplateParameterSubstitutions owned by this TemplateBinding.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTemplateParameterSubstitution.templateBinding
	 */
	def parameterSubstitution: Set[UMLTemplateParameterSubstitution[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The TemplateSignature for the template that is the target of this TemplateBinding.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLTemplateSignature.signature_templateBinding
	 */
	def signature: Option[UMLTemplateSignature[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		templateBinding_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTemplateBinding
	 */
	def templateBinding_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			directedRelationship_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		templateBinding_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTemplateBinding
	 */
	def templateBinding_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			directedRelationship_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLTemplateBinding[Uml], UMLTemplateParameterSubstitution[Uml]]("parameterSubstitution", _.parameterSubstitution)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		templateBinding_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTemplateBinding
	 */
	def templateBinding_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			directedRelationship_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLTemplateBinding[Uml], UMLTemplateSignature[Uml]]("signature", _.signature)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		templateBinding_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTemplateBinding
	 */
	def templateBinding_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		boundElement ++
		signature 

} //UMLTemplateBinding
