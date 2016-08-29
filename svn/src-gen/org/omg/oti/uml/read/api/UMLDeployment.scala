/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLDeploymentOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A deployment is the allocation of an artifact or artifact instance to a deployment target.A component deployment is the deployment of one or more artifacts or artifact instances to a deployment target, optionally parameterized by a deployment specification. Examples are executables and configuration files.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDeployment[Uml <: UML]
  extends UMLDependency[Uml]
  with UMLDeploymentOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Artifacts that are deployed onto a Node. This association specializes the supplier association.
    *
    * <!-- Start of user code doc for deployedArtifact -->
    * <!-- End of user code doc for deployedArtifact -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDeployedArtifact.deployedArtifact_deploymentForArtifact
    */
  def deployedArtifact: Set[UMLDeployedArtifact[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      deployment_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDeployment
    *
    * <!-- Start of user code doc for deployment_metaAttributes -->
    * <!-- End of user code doc for deployment_metaAttributes -->
    */
  def deployment_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     dependency_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    deployment_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDeployment
    *
    * <!-- Start of user code doc for deployment_compositeMetaProperties -->
    * <!-- End of user code doc for deployment_compositeMetaProperties -->
    */
  def deployment_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      dependency_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Deployment_configuration))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    deployment_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDeployment
    *
    * <!-- Start of user code doc for deployment_referenceMetaProperties -->
    * <!-- End of user code doc for deployment_referenceMetaProperties -->
    */
  def deployment_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      dependency_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Deployment_deployedArtifact))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    deployment_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDeployment
    *
    * <!-- Start of user code doc for deployment_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for deployment_forwardReferencesFromMetamodelAssociations -->
    */
  def deployment_forwardReferencesFromMetamodelAssociations: Elements =
    dependency_forwardReferencesFromMetamodelAssociations ++
    deployedArtifact

  // Start of user code for additional features
  // End of user code
} //UMLDeployment
