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
import org.omg.oti.uml.read.operations.UMLControlFlowOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ControlFlow is an ActivityEdge traversed by control tokens or object tokens of control type, which are use to control the execution of ExecutableNodes.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLControlFlow[Uml <: UML]
  extends UMLActivityEdge[Uml]
  with UMLControlFlowOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      controlFlow_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLControlFlow
    *
    * <!-- Start of user code doc for controlFlow_metaAttributes -->
    * <!-- End of user code doc for controlFlow_metaAttributes -->
    */
  def controlFlow_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     activityEdge_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    controlFlow_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLControlFlow
    *
    * <!-- Start of user code doc for controlFlow_compositeMetaProperties -->
    * <!-- End of user code doc for controlFlow_compositeMetaProperties -->
    */
  def controlFlow_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      activityEdge_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    controlFlow_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLControlFlow
    *
    * <!-- Start of user code doc for controlFlow_referenceMetaProperties -->
    * <!-- End of user code doc for controlFlow_referenceMetaProperties -->
    */
  def controlFlow_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      activityEdge_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    controlFlow_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLControlFlow
    *
    * <!-- Start of user code doc for controlFlow_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for controlFlow_forwardReferencesFromMetamodelAssociations -->
    */
  def controlFlow_forwardReferencesFromMetamodelAssociations: Elements =
    activityEdge_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLControlFlow
