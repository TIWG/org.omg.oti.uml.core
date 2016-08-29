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
import org.omg.oti.uml.read.operations.UMLFinalNodeOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A FinalNode is an abstract ControlNode at which a flow in an Activity stops.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLFinalNode[Uml <: UML]
  extends UMLControlNode[Uml]
  with UMLFinalNodeOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      finalNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLFinalNode
    *
    * <!-- Start of user code doc for finalNode_metaAttributes -->
    * <!-- End of user code doc for finalNode_metaAttributes -->
    */
  def finalNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     controlNode_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    finalNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLFinalNode
    *
    * <!-- Start of user code doc for finalNode_compositeMetaProperties -->
    * <!-- End of user code doc for finalNode_compositeMetaProperties -->
    */
  def finalNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      controlNode_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    finalNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLFinalNode
    *
    * <!-- Start of user code doc for finalNode_referenceMetaProperties -->
    * <!-- End of user code doc for finalNode_referenceMetaProperties -->
    */
  def finalNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      controlNode_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    finalNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLFinalNode
    *
    * <!-- Start of user code doc for finalNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for finalNode_forwardReferencesFromMetamodelAssociations -->
    */
  def finalNode_forwardReferencesFromMetamodelAssociations: Elements =
    controlNode_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLFinalNode
