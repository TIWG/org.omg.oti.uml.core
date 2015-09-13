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
import org.omg.oti.uml.read.operations.UMLPackageableElementOps

// End of user code

/**
 * A PackageableElement is a NamedElement that may be owned directly by a Package. A PackageableElement is also able to serve as the parameteredElement of a TemplateParameter.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLPackageableElement[Uml <: UML]
	extends UMLNamedElement[Uml]
	with UMLParameterableElement[Uml]
	with UMLPackageableElementOps[Uml] {
	
	import ops._

	/**
	 * A PackageableElement must have a visibility specified if it is owned by a Namespace. The default visibility is public.
	 *
	 * <!-- Start of user code doc for visibility -->
   * <!-- End of user code doc for visibility -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	override def visibility: Option[UMLVisibilityKind.Value]

	/**
	 * <!-- Start of user code doc for deployedElement_deploymentTarget -->
   * <!-- End of user code doc for deployedElement_deploymentTarget -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLDeploymentTarget.deployedElement
	 */
	def deployedElement_deploymentTarget: Set[UMLDeploymentTarget[Uml]]

	/**
	 * <!-- Start of user code doc for importedMember_namespace -->
   * <!-- End of user code doc for importedMember_namespace -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLNamespace.importedMember
	 */
	def importedMember_namespace: Set[UMLNamespace[Uml]]

	/**
	 * <!-- Start of user code doc for utilizedElement_manifestation -->
   * <!-- End of user code doc for utilizedElement_manifestation -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLManifestation.utilizedElement
	 */
	def utilizedElement_manifestation: Set[UMLManifestation[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		packageableElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPackageableElement
	 *
	 * <!-- Start of user code doc for packageableElement_metaAttributes -->
   * <!-- End of user code doc for packageableElement_metaAttributes -->
	 */
	def packageableElement_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			namedElement_metaAttributes,
			parameterableElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		packageableElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPackageableElement
	 *
	 * <!-- Start of user code doc for packageableElement_compositeMetaProperties -->
   * <!-- End of user code doc for packageableElement_compositeMetaProperties -->
	 */
	def packageableElement_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_compositeMetaProperties,
			parameterableElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		packageableElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPackageableElement
	 *
	 * <!-- Start of user code doc for packageableElement_referenceMetaProperties -->
   * <!-- End of user code doc for packageableElement_referenceMetaProperties -->
	 */
	def packageableElement_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_referenceMetaProperties,
			parameterableElement_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		packageableElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPackageableElement
	 *
	 * <!-- Start of user code doc for packageableElement_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for packageableElement_forwardReferencesFromMetamodelAssociations -->
	 */
	def packageableElement_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		parameterableElement_forwardReferencesFromMetamodelAssociations ++
		Set ()

	// Start of user code for additional features
  // End of user code
} //UMLPackageableElement
