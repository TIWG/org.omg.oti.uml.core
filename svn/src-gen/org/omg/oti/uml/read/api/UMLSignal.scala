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
import org.omg.oti.uml.read.operations.UMLSignalOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Signal is a specification of a kind of communication between objects in which a reaction is asynchronously triggered in the receiver without a reply.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLSignal[Uml <: UML]
  extends UMLClassifier[Uml]
  with UMLSignalOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The attributes owned by the Signal.
    *
    * <!-- Start of user code doc for ownedAttribute -->
    * <!-- End of user code doc for ownedAttribute -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.ownedAttribute_owningSignal
    */
  def ownedAttribute: Seq[UMLProperty[Uml]]

  /**
    * <!-- Start of user code doc for signal_broadcastSignalAction -->
    * <!-- End of user code doc for signal_broadcastSignalAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBroadcastSignalAction.signal
    */
  def signal_broadcastSignalAction: Set[UMLBroadcastSignalAction[Uml]]

  /**
    * <!-- Start of user code doc for signal_reception -->
    * <!-- End of user code doc for signal_reception -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReception.signal
    */
  def signal_reception: Set[UMLReception[Uml]]

  /**
    * <!-- Start of user code doc for signal_sendSignalAction -->
    * <!-- End of user code doc for signal_sendSignalAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSendSignalAction.signal
    */
  def signal_sendSignalAction: Set[UMLSendSignalAction[Uml]]

  /**
    * <!-- Start of user code doc for signal_signalEvent -->
    * <!-- End of user code doc for signal_signalEvent -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSignalEvent.signal
    */
  def signal_signalEvent: Set[UMLSignalEvent[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      signal_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLSignal
    *
    * <!-- Start of user code doc for signal_metaAttributes -->
    * <!-- End of user code doc for signal_metaAttributes -->
    */
  def signal_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     classifier_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    signal_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLSignal
    *
    * <!-- Start of user code doc for signal_compositeMetaProperties -->
    * <!-- End of user code doc for signal_compositeMetaProperties -->
    */
  def signal_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Signal_ownedAttribute))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    signal_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLSignal
    *
    * <!-- Start of user code doc for signal_referenceMetaProperties -->
    * <!-- End of user code doc for signal_referenceMetaProperties -->
    */
  def signal_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    signal_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLSignal
    *
    * <!-- Start of user code doc for signal_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for signal_forwardReferencesFromMetamodelAssociations -->
    */
  def signal_forwardReferencesFromMetamodelAssociations: Elements =
    classifier_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLSignal
