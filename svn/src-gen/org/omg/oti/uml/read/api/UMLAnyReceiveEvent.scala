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
import org.omg.oti.uml.read.operations.UMLAnyReceiveEventOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A trigger for an AnyReceiveEvent is triggered by the receipt of any message that is not explicitly handled by any related trigger.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAnyReceiveEvent[Uml <: UML]
  extends UMLMessageEvent[Uml]
  with UMLAnyReceiveEventOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      anyReceiveEvent_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLAnyReceiveEvent
    *
    * <!-- Start of user code doc for anyReceiveEvent_metaAttributes -->
    * <!-- End of user code doc for anyReceiveEvent_metaAttributes -->
    */
  def anyReceiveEvent_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     messageEvent_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    anyReceiveEvent_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLAnyReceiveEvent
    *
    * <!-- Start of user code doc for anyReceiveEvent_compositeMetaProperties -->
    * <!-- End of user code doc for anyReceiveEvent_compositeMetaProperties -->
    */
  def anyReceiveEvent_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      messageEvent_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    anyReceiveEvent_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLAnyReceiveEvent
    *
    * <!-- Start of user code doc for anyReceiveEvent_referenceMetaProperties -->
    * <!-- End of user code doc for anyReceiveEvent_referenceMetaProperties -->
    */
  def anyReceiveEvent_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      messageEvent_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    anyReceiveEvent_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLAnyReceiveEvent
    *
    * <!-- Start of user code doc for anyReceiveEvent_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for anyReceiveEvent_forwardReferencesFromMetamodelAssociations -->
    */
  def anyReceiveEvent_forwardReferencesFromMetamodelAssociations: Elements =
    messageEvent_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLAnyReceiveEvent
