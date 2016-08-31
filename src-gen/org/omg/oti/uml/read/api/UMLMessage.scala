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
import org.omg.oti.uml.read.operations.UMLMessageOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Message defines a particular communication between Lifelines of an Interaction.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLMessage[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLMessageOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The arguments of the Message.
    *
    * <!-- Start of user code doc for argument -->
    * <!-- End of user code doc for argument -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.argument_message
    */
  def argument: Seq[UMLValueSpecification[Uml]]

  /**
    * The Connector on which this Message is sent.
    *
    * <!-- Start of user code doc for connector -->
    * <!-- End of user code doc for connector -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnector.connector_message
    */
  def connector: Option[UMLConnector[Uml]]

  /**
    * The sort of communication reflected by the Message.
    *
    * <!-- Start of user code doc for messageSort -->
    * <!-- End of user code doc for messageSort -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def messageSort: Option[UMLMessageSort.Value]

  /**
    * References the Receiving of the Message.
    *
    * <!-- Start of user code doc for receiveEvent -->
    * <!-- End of user code doc for receiveEvent -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLMessageEnd.receiveEvent_endMessage
    */
  def receiveEvent: Option[UMLMessageEnd[Uml]]

  /**
    * References the Sending of the Message.
    *
    * <!-- Start of user code doc for sendEvent -->
    * <!-- End of user code doc for sendEvent -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLMessageEnd.sendEvent_endMessage
    */
  def sendEvent: Option[UMLMessageEnd[Uml]]

  /**
    * The signature of the Message is the specification of its content. It refers either an Operation or a Signal.
    *
    * <!-- Start of user code doc for signature -->
    * <!-- End of user code doc for signature -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamedElement.signature_message
    */
  def signature: Option[UMLNamedElement[Uml]]

  /**
    * <!-- Start of user code doc for message_messageEnd -->
    * <!-- End of user code doc for message_messageEnd -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..2"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLMessageEnd.message
    */
  def message_messageEnd: Set[UMLMessageEnd[Uml]]

  /**
    * <!-- Start of user code doc for realizingMessage_informationFlow -->
    * <!-- End of user code doc for realizingMessage_informationFlow -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInformationFlow.realizingMessage
    */
  def realizingMessage_informationFlow: Set[UMLInformationFlow[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      message_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLMessage
    *
    * <!-- Start of user code doc for message_metaAttributes -->
    * <!-- End of user code doc for message_metaAttributes -->
    */
  def message_metaAttributes: MetaAttributeFunctions = 
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
    message_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLMessage
    *
    * <!-- Start of user code doc for message_compositeMetaProperties -->
    * <!-- End of user code doc for message_compositeMetaProperties -->
    */
  def message_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Message_argument))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    message_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLMessage
    *
    * <!-- Start of user code doc for message_referenceMetaProperties -->
    * <!-- End of user code doc for message_referenceMetaProperties -->
    */
  def message_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Message_connector,
      	Message_receiveEvent,
      	Message_sendEvent,
      	Message_signature))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    message_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLMessage
    *
    * <!-- Start of user code doc for message_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for message_forwardReferencesFromMetamodelAssociations -->
    */
  def message_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    connector ++
    receiveEvent ++
    sendEvent ++
    signature

  // Start of user code for additional features
  // End of user code
} //UMLMessage
