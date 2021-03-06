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
import org.omg.oti.uml.read.operations.UMLNodeOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Node is computational resource upon which artifacts may be deployed for execution. Nodes can be interconnected through communication paths to define network structures.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLNode[Uml <: UML]
  extends UMLClass[Uml]
	with UMLDeploymentTarget[Uml]
  with UMLNodeOps[Uml] {

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
      node_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLNode
    *
    * <!-- Start of user code doc for node_metaAttributes -->
    * <!-- End of user code doc for node_metaAttributes -->
    */
  def node_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     class_metaAttributes,
     deploymentTarget_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    node_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLNode
    *
    * <!-- Start of user code doc for node_compositeMetaProperties -->
    * <!-- End of user code doc for node_compositeMetaProperties -->
    */
  def node_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      class_compositeMetaProperties,
      deploymentTarget_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Node_nestedNode))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    node_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLNode
    *
    * <!-- Start of user code doc for node_referenceMetaProperties -->
    * <!-- End of user code doc for node_referenceMetaProperties -->
    */
  def node_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      class_referenceMetaProperties,
      deploymentTarget_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    node_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLNode
    *
    * <!-- Start of user code doc for node_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for node_forwardReferencesFromMetamodelAssociations -->
    */
  def node_forwardReferencesFromMetamodelAssociations: Elements =
    class_forwardReferencesFromMetamodelAssociations ++
    deploymentTarget_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLNode
