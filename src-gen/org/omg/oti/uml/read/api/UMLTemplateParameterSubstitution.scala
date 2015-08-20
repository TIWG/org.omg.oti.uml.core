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
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.uml.read.operations.UMLTemplateParameterSubstitutionOps

// End of user code

/**
 * A TemplateParameterSubstitution relates the actual parameter to a formal TemplateParameter as part of a template binding.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLTemplateParameterSubstitution[Uml <: UML]
	extends UMLElement[Uml]
	with UMLTemplateParameterSubstitutionOps[Uml] {
	
	import ops._

	/**
	 * The ParameterableElement that is the actual parameter for this TemplateParameterSubstitution.
	 *
	 * <!-- Start of user code doc for actual -->
   * <!-- End of user code doc for actual -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.uml.read.api.UMLParameterableElement.actual_templateParameterSubstitution
	 */
	def actual: Option[UMLParameterableElement[Uml]]

	/**
	 * The formal TemplateParameter that is associated with this TemplateParameterSubstitution.
	 *
	 * <!-- Start of user code doc for formal -->
   * <!-- End of user code doc for formal -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.uml.read.api.UMLTemplateParameter.formal_templateParameterSubstitution
	 */
	def formal: Option[UMLTemplateParameter[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		templateParameterSubstitution_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTemplateParameterSubstitution
	 *
	 * <!-- Start of user code doc for templateParameterSubstitution_metaAttributes -->
   * <!-- End of user code doc for templateParameterSubstitution_metaAttributes -->
	 */
	def templateParameterSubstitution_metaAttributes: MetaAttributeFunctions = 
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
		templateParameterSubstitution_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTemplateParameterSubstitution
	 *
	 * <!-- Start of user code doc for templateParameterSubstitution_compositeMetaProperties -->
   * <!-- End of user code doc for templateParameterSubstitution_compositeMetaProperties -->
	 */
	def templateParameterSubstitution_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_compositeMetaProperties,
			Seq (TemplateParameterSubstitution_ownedActual))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		templateParameterSubstitution_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTemplateParameterSubstitution
	 *
	 * <!-- Start of user code doc for templateParameterSubstitution_referenceMetaProperties -->
   * <!-- End of user code doc for templateParameterSubstitution_referenceMetaProperties -->
	 */
	def templateParameterSubstitution_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_referenceMetaProperties,
			Seq (TemplateParameterSubstitution_actual,
				TemplateParameterSubstitution_formal))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		templateParameterSubstitution_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTemplateParameterSubstitution
	 *
	 * <!-- Start of user code doc for templateParameterSubstitution_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for templateParameterSubstitution_forwardReferencesFromMetamodelAssociations -->
	 */
	def templateParameterSubstitution_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		actual ++
		formal

	// Start of user code for additional features
  // End of user code
} //UMLTemplateParameterSubstitution
