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
 * MessageEnd is an abstract specialization of NamedElement that represents what can occur at the end of a Message.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLMessageEnd[Uml <: UML]
	extends UMLNamedElement[Uml]
	with UMLMessageEndOps[Uml] {
	
	import ops._

	/**
	 * References a Message.
	 *
	 * <!-- Start of user code doc for message -->
	 * <!-- End of user code doc for message -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLMessage.message_messageEnd
	 */
	def message: Option[UMLMessage[Uml]]

	/**
	 * <!-- Start of user code doc for receiveEvent_endMessage -->
	 * <!-- End of user code doc for receiveEvent_endMessage -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLMessage.receiveEvent
	 */
	def receiveEvent_endMessage: Option[UMLMessage[Uml]]

	/**
	 * <!-- Start of user code doc for sendEvent_endMessage -->
	 * <!-- End of user code doc for sendEvent_endMessage -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLMessage.sendEvent
	 */
	def sendEvent_endMessage: Option[UMLMessage[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		messageEnd_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLMessageEnd
	 *
	 * <!-- Start of user code doc for messageEnd_metaAttributes -->
	 * <!-- End of user code doc for messageEnd_metaAttributes -->
	 */
	def messageEnd_metaAttributes: MetaAttributeFunctions = 
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
		messageEnd_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLMessageEnd
	 *
	 * <!-- Start of user code doc for messageEnd_compositeMetaProperties -->
	 * <!-- End of user code doc for messageEnd_compositeMetaProperties -->
	 */
	def messageEnd_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		messageEnd_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLMessageEnd
	 *
	 * <!-- Start of user code doc for messageEnd_referenceMetaProperties -->
	 * <!-- End of user code doc for messageEnd_referenceMetaProperties -->
	 */
	def messageEnd_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_referenceMetaProperties,
			Seq (MessageEnd_message))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		messageEnd_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLMessageEnd
	 *
	 * <!-- Start of user code doc for messageEnd_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for messageEnd_forwardReferencesFromMetamodelAssociations -->
	 */
	def messageEnd_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		message 

	// Start of user code for additional features
	// End of user code
} //UMLMessageEnd
