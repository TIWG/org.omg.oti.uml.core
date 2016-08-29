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
import org.omg.oti.uml.read.operations.UMLDeviceOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A device is a physical computational resource with processing capability upon which artifacts may be deployed for execution. Devices may be complex (i.e., they may consist of other devices).
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDevice[Uml <: UML]
  extends UMLNode[Uml]
  with UMLDeviceOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      device_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDevice
    *
    * <!-- Start of user code doc for device_metaAttributes -->
    * <!-- End of user code doc for device_metaAttributes -->
    */
  def device_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     node_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    device_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDevice
    *
    * <!-- Start of user code doc for device_compositeMetaProperties -->
    * <!-- End of user code doc for device_compositeMetaProperties -->
    */
  def device_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      node_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    device_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDevice
    *
    * <!-- Start of user code doc for device_referenceMetaProperties -->
    * <!-- End of user code doc for device_referenceMetaProperties -->
    */
  def device_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      node_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    device_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDevice
    *
    * <!-- Start of user code doc for device_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for device_forwardReferencesFromMetamodelAssociations -->
    */
  def device_forwardReferencesFromMetamodelAssociations: Elements =
    node_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLDevice
