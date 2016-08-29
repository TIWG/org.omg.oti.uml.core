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
import org.omg.oti.uml.read.operations.UMLCentralBufferNodeOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A CentralBufferNode is an ObjectNode for managing flows from multiple sources and targets.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCentralBufferNode[Uml <: UML]
  extends UMLObjectNode[Uml]
  with UMLCentralBufferNodeOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      centralBufferNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLCentralBufferNode
    *
    * <!-- Start of user code doc for centralBufferNode_metaAttributes -->
    * <!-- End of user code doc for centralBufferNode_metaAttributes -->
    */
  def centralBufferNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     objectNode_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    centralBufferNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLCentralBufferNode
    *
    * <!-- Start of user code doc for centralBufferNode_compositeMetaProperties -->
    * <!-- End of user code doc for centralBufferNode_compositeMetaProperties -->
    */
  def centralBufferNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      objectNode_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    centralBufferNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLCentralBufferNode
    *
    * <!-- Start of user code doc for centralBufferNode_referenceMetaProperties -->
    * <!-- End of user code doc for centralBufferNode_referenceMetaProperties -->
    */
  def centralBufferNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      objectNode_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    centralBufferNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLCentralBufferNode
    *
    * <!-- Start of user code doc for centralBufferNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for centralBufferNode_forwardReferencesFromMetamodelAssociations -->
    */
  def centralBufferNode_forwardReferencesFromMetamodelAssociations: Elements =
    objectNode_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLCentralBufferNode
