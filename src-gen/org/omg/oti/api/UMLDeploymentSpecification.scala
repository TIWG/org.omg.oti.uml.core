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
 * A deployment specification specifies a set of properties that determine execution parameters of a component artifact that is deployed on a node. A deployment specification can be aimed at a specific type of container. An artifact that reifies or implements deployment specification properties is a deployment descriptor.
 * <!-- end-model-doc --> 
 */
trait UMLDeploymentSpecification[Uml <: UML]
	extends UMLArtifact[Uml]
	with UMLDeploymentSpecificationOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The deployment with which the DeploymentSpecification is associated.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLDeployment.configuration
	 */
	def deployment: Option[UMLDeployment[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The location where an Artifact is deployed onto a Node. This is typically a 'directory' or 'memory address.'
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def deploymentLocation: Option[String]

	/**
	 * <!-- begin-model-doc -->
	 * The location where a component Artifact executes. This may be a local or remote location.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def executionLocation: Option[String]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		deploymentSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDeploymentSpecification
	 */
	def deploymentSpecification_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			artifact_metaAttributes,
			Seq (MetaAttributeStringFunction[Uml, UMLDeploymentSpecification[Uml]](None, "deploymentLocation", _.deploymentLocation),
				MetaAttributeStringFunction[Uml, UMLDeploymentSpecification[Uml]](None, "executionLocation", _.executionLocation)))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		deploymentSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDeploymentSpecification
	 */
	def deploymentSpecification_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			artifact_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		deploymentSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDeploymentSpecification
	 */
	def deploymentSpecification_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			artifact_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLDeploymentSpecification[Uml], UMLDeployment[Uml]]("deployment", _.deployment)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		deploymentSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDeploymentSpecification
	 */
	def deploymentSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		artifact_forwardReferencesFromMetamodelAssociations ++
		deployment 

} //UMLDeploymentSpecification
