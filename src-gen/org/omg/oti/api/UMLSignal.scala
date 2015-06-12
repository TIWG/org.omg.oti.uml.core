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
 * A Signal is a specification of a kind of communication between objects in which a reaction is asynchronously triggered in the receiver without a reply.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLSignal[Uml <: UML]
	extends UMLClassifier[Uml]
	with UMLSignalOps[Uml] {
	
	import ops._

	/**
	 * The attributes owned by the Signal.
	 *
	 * <!-- Start of user code doc for ownedAttribute -->
	 * <!-- End of user code doc for ownedAttribute -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty.ownedAttribute_owningSignal
	 */
	def ownedAttribute: Seq[UMLProperty[Uml]]

	/**
	 * <!-- Start of user code doc for signal_broadcastSignalAction -->
	 * <!-- End of user code doc for signal_broadcastSignalAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLBroadcastSignalAction.signal
	 */
	def signal_broadcastSignalAction: Set[UMLBroadcastSignalAction[Uml]]

	/**
	 * <!-- Start of user code doc for signal_reception -->
	 * <!-- End of user code doc for signal_reception -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLReception.signal
	 */
	def signal_reception: Set[UMLReception[Uml]]

	/**
	 * <!-- Start of user code doc for signal_sendSignalAction -->
	 * <!-- End of user code doc for signal_sendSignalAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLSendSignalAction.signal
	 */
	def signal_sendSignalAction: Set[UMLSendSignalAction[Uml]]

	/**
	 * <!-- Start of user code doc for signal_signalEvent -->
	 * <!-- End of user code doc for signal_signalEvent -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLSignalEvent.signal
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
			Seq ())

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
			Seq (MetaPropertyCollection[Uml, UMLSignal[Uml], UMLProperty[Uml]]("ownedAttribute", _.ownedAttribute)))

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
			Seq ())

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
