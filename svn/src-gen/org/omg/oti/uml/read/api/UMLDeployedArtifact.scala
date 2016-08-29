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
import org.omg.oti.uml.read.operations.UMLDeployedArtifactOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A deployed artifact is an artifact or artifact instance that has been deployed to a deployment target.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDeployedArtifact[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLDeployedArtifactOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * <!-- Start of user code doc for deployedArtifact_deploymentForArtifact -->
    * <!-- End of user code doc for deployedArtifact_deploymentForArtifact -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDeployment.deployedArtifact
    */
  def deployedArtifact_deploymentForArtifact: Set[UMLDeployment[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      deployedArtifact_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDeployedArtifact
    *
    * <!-- Start of user code doc for deployedArtifact_metaAttributes -->
    * <!-- End of user code doc for deployedArtifact_metaAttributes -->
    */
  def deployedArtifact_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namedElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    deployedArtifact_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDeployedArtifact
    *
    * <!-- Start of user code doc for deployedArtifact_compositeMetaProperties -->
    * <!-- End of user code doc for deployedArtifact_compositeMetaProperties -->
    */
  def deployedArtifact_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    deployedArtifact_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDeployedArtifact
    *
    * <!-- Start of user code doc for deployedArtifact_referenceMetaProperties -->
    * <!-- End of user code doc for deployedArtifact_referenceMetaProperties -->
    */
  def deployedArtifact_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    deployedArtifact_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDeployedArtifact
    *
    * <!-- Start of user code doc for deployedArtifact_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for deployedArtifact_forwardReferencesFromMetamodelAssociations -->
    */
  def deployedArtifact_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLDeployedArtifact
