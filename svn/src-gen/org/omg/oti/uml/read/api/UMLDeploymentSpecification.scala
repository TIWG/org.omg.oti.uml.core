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
import org.omg.oti.uml.read.operations.UMLDeploymentSpecificationOps

import scala.Option
import scala.Predef.String
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A deployment specification specifies a set of properties that determine execution parameters of a component artifact that is deployed on a node. A deployment specification can be aimed at a specific type of container. An artifact that reifies or implements deployment specification properties is a deployment descriptor.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDeploymentSpecification[Uml <: UML]
  extends UMLArtifact[Uml]
  with UMLDeploymentSpecificationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The location where an Artifact is deployed onto a Node. This is typically a 'directory' or 'memory address.'
    *
    * <!-- Start of user code doc for deploymentLocation -->
    * <!-- End of user code doc for deploymentLocation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def deploymentLocation: Option[String]

  /**
    * The location where a component Artifact executes. This may be a local or remote location.
    *
    * <!-- Start of user code doc for executionLocation -->
    * <!-- End of user code doc for executionLocation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def executionLocation: Option[String]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      deploymentSpecification_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDeploymentSpecification
    *
    * <!-- Start of user code doc for deploymentSpecification_metaAttributes -->
    * <!-- End of user code doc for deploymentSpecification_metaAttributes -->
    */
  def deploymentSpecification_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     artifact_metaAttributes,
     Seq[MetaAttributeFunction](DeploymentSpecification_deploymentLocation,
     	DeploymentSpecification_executionLocation))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    deploymentSpecification_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDeploymentSpecification
    *
    * <!-- Start of user code doc for deploymentSpecification_compositeMetaProperties -->
    * <!-- End of user code doc for deploymentSpecification_compositeMetaProperties -->
    */
  def deploymentSpecification_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      artifact_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    deploymentSpecification_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDeploymentSpecification
    *
    * <!-- Start of user code doc for deploymentSpecification_referenceMetaProperties -->
    * <!-- End of user code doc for deploymentSpecification_referenceMetaProperties -->
    */
  def deploymentSpecification_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      artifact_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    deploymentSpecification_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDeploymentSpecification
    *
    * <!-- Start of user code doc for deploymentSpecification_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for deploymentSpecification_forwardReferencesFromMetamodelAssociations -->
    */
  def deploymentSpecification_forwardReferencesFromMetamodelAssociations: Elements =
    artifact_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLDeploymentSpecification
