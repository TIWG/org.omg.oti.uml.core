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
package org.omg.oti.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.operations._
// End of user code

/**
 * <!-- begin-model-doc --> 
 * A Message defines a particular communication between Lifelines of an Interaction.
 * <!-- end-model-doc --> 
 */
trait UMLMessage[Uml <: UML]
	extends UMLNamedElement[Uml]
	with UMLMessageOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The arguments of the Message.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLValueSpecification.argument_message
	 */
	def argument: Seq[UMLValueSpecification[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Connector on which this Message is sent.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConnector.connector_message
	 */
	def connector: Option[UMLConnector[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The enclosing Interaction owning the Message.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInteraction.message
	 */
	def interaction: Option[UMLInteraction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The derived kind of the Message (complete, lost, found, or unknown).
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def messageKind: UMLMessageKind.Value

	/**
	 * <!-- begin-model-doc -->
	 * The sort of communication reflected by the Message.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def messageSort: UMLMessageSort.Value

	/**
	 * <!-- begin-model-doc -->
	 * References the Receiving of the Message.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLMessageEnd.receiveEvent_endMessage
	 */
	def receiveEvent: Option[UMLMessageEnd[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * References the Sending of the Message.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLMessageEnd.sendEvent_endMessage
	 */
	def sendEvent: Option[UMLMessageEnd[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The signature of the Message is the specification of its content. It refers either an Operation or a Signal.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLNamedElement.signature_message
	 */
	def signature: Option[UMLNamedElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..2"
	 * @opposite org.omg.oti.api.UMLMessageEnd.message
	 */
	def message_messageEnd: Set[UMLMessageEnd[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInformationFlow.realizingMessage
	 */
	def realizingMessage_informationFlow: Set[UMLInformationFlow[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		message_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLMessage
	 */
	def message_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			namedElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		message_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLMessage
	 */
	def message_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLMessage[Uml], UMLValueSpecification[Uml]]("argument", _.argument)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		message_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLMessage
	 */
	def message_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLMessage[Uml], UMLConnector[Uml]]("connector", _.connector),
				MetaPropertyReference[Uml, UMLMessage[Uml], UMLInteraction[Uml]]("interaction", _.interaction),
				MetaPropertyReference[Uml, UMLMessage[Uml], UMLMessageEnd[Uml]]("receiveEvent", _.receiveEvent),
				MetaPropertyReference[Uml, UMLMessage[Uml], UMLMessageEnd[Uml]]("sendEvent", _.sendEvent),
				MetaPropertyReference[Uml, UMLMessage[Uml], UMLNamedElement[Uml]]("signature", _.signature)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		message_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLMessage
	 */
	def message_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		connector ++
		interaction ++
		receiveEvent ++
		sendEvent ++
		signature 

} //UMLMessage
