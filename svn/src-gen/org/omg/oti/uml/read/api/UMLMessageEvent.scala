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
import org.omg.oti.uml.read.operations.UMLMessageEventOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A MessageEvent specifies the receipt by an object of either an Operation call or a Signal instance.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLMessageEvent[Uml <: UML]
  extends UMLEvent[Uml]
  with UMLMessageEventOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      messageEvent_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLMessageEvent
    *
    * <!-- Start of user code doc for messageEvent_metaAttributes -->
    * <!-- End of user code doc for messageEvent_metaAttributes -->
    */
  def messageEvent_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     event_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    messageEvent_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLMessageEvent
    *
    * <!-- Start of user code doc for messageEvent_compositeMetaProperties -->
    * <!-- End of user code doc for messageEvent_compositeMetaProperties -->
    */
  def messageEvent_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      event_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    messageEvent_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLMessageEvent
    *
    * <!-- Start of user code doc for messageEvent_referenceMetaProperties -->
    * <!-- End of user code doc for messageEvent_referenceMetaProperties -->
    */
  def messageEvent_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      event_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    messageEvent_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLMessageEvent
    *
    * <!-- Start of user code doc for messageEvent_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for messageEvent_forwardReferencesFromMetamodelAssociations -->
    */
  def messageEvent_forwardReferencesFromMetamodelAssociations: Elements =
    event_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLMessageEvent
