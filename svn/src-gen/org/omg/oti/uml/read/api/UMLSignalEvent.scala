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
import org.omg.oti.uml.read.operations.UMLSignalEventOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A SignalEvent represents the receipt of an asynchronous Signal instance.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLSignalEvent[Uml <: UML]
  extends UMLMessageEvent[Uml]
  with UMLSignalEventOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The specific Signal that is associated with this SignalEvent.
    *
    * <!-- Start of user code doc for signal -->
    * <!-- End of user code doc for signal -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSignal.signal_signalEvent
    */
  def signal: Option[UMLSignal[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      signalEvent_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLSignalEvent
    *
    * <!-- Start of user code doc for signalEvent_metaAttributes -->
    * <!-- End of user code doc for signalEvent_metaAttributes -->
    */
  def signalEvent_metaAttributes: MetaAttributeFunctions = 
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
    signalEvent_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLSignalEvent
    *
    * <!-- Start of user code doc for signalEvent_compositeMetaProperties -->
    * <!-- End of user code doc for signalEvent_compositeMetaProperties -->
    */
  def signalEvent_compositeMetaProperties: MetaPropertyFunctions = 
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
    signalEvent_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLSignalEvent
    *
    * <!-- Start of user code doc for signalEvent_referenceMetaProperties -->
    * <!-- End of user code doc for signalEvent_referenceMetaProperties -->
    */
  def signalEvent_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      messageEvent_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](SignalEvent_signal))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    signalEvent_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLSignalEvent
    *
    * <!-- Start of user code doc for signalEvent_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for signalEvent_forwardReferencesFromMetamodelAssociations -->
    */
  def signalEvent_forwardReferencesFromMetamodelAssociations: Elements =
    messageEvent_forwardReferencesFromMetamodelAssociations ++
    signal

  // Start of user code for additional features
  // End of user code
} //UMLSignalEvent
