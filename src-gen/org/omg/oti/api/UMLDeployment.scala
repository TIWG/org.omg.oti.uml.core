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
 * A deployment is the allocation of an artifact or artifact instance to a deployment target.
A component deployment is the deployment of one or more artifacts or artifact instances to a deployment target, optionally parameterized by a deployment specification. Examples are executables and configuration files.
 * <!-- end-model-doc -->
 */
trait UMLDeployment[Uml <: UML]
	extends UMLDependency[Uml]
	with UMLDeploymentOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The specification of properties that parameterize the deployment and execution of one or more Artifacts.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDeploymentSpecification.deployment
	 */
	def configuration: Set[UMLDeploymentSpecification[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Artifacts that are deployed onto a Node. This association specializes the supplier association.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDeployedArtifact.deployedArtifact_deploymentForArtifact
	 */
	def deployedArtifact: Set[UMLDeployedArtifact[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The DeployedTarget which is the target of a Deployment.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLDeploymentTarget.deployment
	 */
	def location: Option[UMLDeploymentTarget[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		deployment_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDeployment
	 */
	def deployment_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			dependency_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		deployment_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDeployment
	 */
	def deployment_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			dependency_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLDeployment[Uml], UMLDeploymentSpecification[Uml]]("configuration", _.configuration)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		deployment_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDeployment
	 */
	def deployment_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			dependency_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLDeployment[Uml], UMLDeployedArtifact[Uml]]("deployedArtifact", _.deployedArtifact),
				MetaPropertyReference[Uml, UMLDeployment[Uml], UMLDeploymentTarget[Uml]]("location", _.location)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		deployment_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDeployment
	 */
	def deployment_forwardReferencesFromMetamodelAssociations: Elements =
		dependency_forwardReferencesFromMetamodelAssociations ++
		deployedArtifact ++
		location 

} //UMLDeployment
