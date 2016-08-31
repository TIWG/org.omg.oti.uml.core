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
import org.omg.oti.uml.read.operations.UMLDeploymentTargetOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A deployment target is the location for a deployed artifact.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDeploymentTarget[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLDeploymentTargetOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      deploymentTarget_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDeploymentTarget
    *
    * <!-- Start of user code doc for deploymentTarget_metaAttributes -->
    * <!-- End of user code doc for deploymentTarget_metaAttributes -->
    */
  def deploymentTarget_metaAttributes: MetaAttributeFunctions = 
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
    deploymentTarget_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDeploymentTarget
    *
    * <!-- Start of user code doc for deploymentTarget_compositeMetaProperties -->
    * <!-- End of user code doc for deploymentTarget_compositeMetaProperties -->
    */
  def deploymentTarget_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](DeploymentTarget_deployment))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    deploymentTarget_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDeploymentTarget
    *
    * <!-- Start of user code doc for deploymentTarget_referenceMetaProperties -->
    * <!-- End of user code doc for deploymentTarget_referenceMetaProperties -->
    */
  def deploymentTarget_referenceMetaProperties: MetaPropertyFunctions = 
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
    deploymentTarget_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDeploymentTarget
    *
    * <!-- Start of user code doc for deploymentTarget_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for deploymentTarget_forwardReferencesFromMetamodelAssociations -->
    */
  def deploymentTarget_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLDeploymentTarget
