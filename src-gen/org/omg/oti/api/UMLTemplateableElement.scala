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
 * A TemplateableElement is an Element that can optionally be defined as a template and bound to other templates.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLTemplateableElement[Uml <: UML]
	extends UMLElement[Uml]
	with UMLTemplateableElementOps[Uml] {
	
	import ops._

	/**
	 * The optional TemplateSignature specifying the formal TemplateParameters for this TemplateableElement. If a TemplateableElement has a TemplateSignature, then it is a template.
	 *
	 * <!-- Start of user code doc for ownedTemplateSignature -->
	 * <!-- End of user code doc for ownedTemplateSignature -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLTemplateSignature.template
	 */
	def ownedTemplateSignature: Option[UMLTemplateSignature[Uml]]

	/**
	 * The optional TemplateBindings from this TemplateableElement to one or more templates.
	 *
	 * <!-- Start of user code doc for templateBinding -->
	 * <!-- End of user code doc for templateBinding -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTemplateBinding.boundElement
	 */
	def templateBinding: Set[UMLTemplateBinding[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		templateableElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTemplateableElement
	 *
	 * <!-- Start of user code doc for templateableElement_metaAttributes -->
	 * <!-- End of user code doc for templateableElement_metaAttributes -->
	 */
	def templateableElement_metaAttributes: MetaAttributeFunctions = 
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
		templateableElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTemplateableElement
	 *
	 * <!-- Start of user code doc for templateableElement_compositeMetaProperties -->
	 * <!-- End of user code doc for templateableElement_compositeMetaProperties -->
	 */
	def templateableElement_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLTemplateableElement[Uml], UMLTemplateSignature[Uml]]("ownedTemplateSignature", _.ownedTemplateSignature),
				MetaPropertyCollection[Uml, UMLTemplateableElement[Uml], UMLTemplateBinding[Uml]]("templateBinding", _.templateBinding)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		templateableElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTemplateableElement
	 *
	 * <!-- Start of user code doc for templateableElement_referenceMetaProperties -->
	 * <!-- End of user code doc for templateableElement_referenceMetaProperties -->
	 */
	def templateableElement_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		templateableElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTemplateableElement
	 *
	 * <!-- Start of user code doc for templateableElement_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for templateableElement_forwardReferencesFromMetamodelAssociations -->
	 */
	def templateableElement_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLTemplateableElement
