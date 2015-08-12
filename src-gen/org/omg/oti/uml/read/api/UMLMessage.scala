/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.uml.read.operations.UMLMessageOps

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

  import ops._

  /**
   * The arguments of the Message.
   *
   * <!-- Start of user code doc for argument -->
   * <!-- End of user code doc for argument -->
   *
   * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
   * @opposite org.omg.oti.api.UMLValueSpecification.argument_message
   */
  def argument: Seq[UMLValueSpecification[Uml]]

  /**
   * The Connector on which this Message is sent.
   *
   * <!-- Start of user code doc for connector -->
   * <!-- End of user code doc for connector -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
   * @opposite org.omg.oti.api.UMLConnector.connector_message
   */
  def connector: Option[UMLConnector[Uml]]

  /**
   * The sort of communication reflected by the Message.
   *
   * <!-- Start of user code doc for messageSort -->
   * <!-- End of user code doc for messageSort -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
   */
  def messageSort: UMLMessageSort.Value

  /**
   * References the Receiving of the Message.
   *
   * <!-- Start of user code doc for receiveEvent -->
   * <!-- End of user code doc for receiveEvent -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
   * @opposite org.omg.oti.api.UMLMessageEnd.receiveEvent_endMessage
   */
  def receiveEvent: Option[UMLMessageEnd[Uml]]

  /**
   * References the Sending of the Message.
   *
   * <!-- Start of user code doc for sendEvent -->
   * <!-- End of user code doc for sendEvent -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
   * @opposite org.omg.oti.api.UMLMessageEnd.sendEvent_endMessage
   */
  def sendEvent: Option[UMLMessageEnd[Uml]]

  /**
   * The signature of the Message is the specification of its content. It refers either an Operation or a Signal.
   *
   * <!-- Start of user code doc for signature -->
   * <!-- End of user code doc for signature -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
   * @opposite org.omg.oti.api.UMLNamedElement.signature_message
   */
  def signature: Option[UMLNamedElement[Uml]]

  /**
   * <!-- Start of user code doc for message_messageEnd -->
   * <!-- End of user code doc for message_messageEnd -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..2"
   * @opposite org.omg.oti.api.UMLMessageEnd.message
   */
  def message_messageEnd: Set[UMLMessageEnd[Uml]]

  /**
   * <!-- Start of user code doc for realizingMessage_informationFlow -->
   * <!-- End of user code doc for realizingMessage_informationFlow -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
   * @opposite org.omg.oti.api.UMLInformationFlow.realizingMessage
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
      Seq ())

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
      Seq (Message_argument))

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
      Seq (Message_connector,
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
