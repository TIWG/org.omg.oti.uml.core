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
 * A SendSignalAction is an InvocationAction that creates a Signal instance and transmits it to the target object. Values from the argument InputPins are used to provide values for the attributes of the Signal. The requestor continues execution immediately after the Signal instance is sent out and cannot receive reply values.
 * <!-- end-model-doc -->
 */
trait UMLSendSignalAction[Uml <: UML]
	extends UMLInvocationAction[Uml]
	with UMLSendSignalActionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Signal whose instance is transmitted to the target.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLSignal.signal_sendSignalAction
	 */
	def signal: Option[UMLSignal[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The InputPin that provides the target object to which the Signal instance is sent.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.target_sendSignalAction
	 */
	def target: Option[UMLInputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		sendSignalAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLSendSignalAction
	 */
	def sendSignalAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			invocationAction_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		sendSignalAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLSendSignalAction
	 */
	def sendSignalAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			invocationAction_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLSendSignalAction[Uml], UMLInputPin[Uml]]("target", _.target)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		sendSignalAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLSendSignalAction
	 */
	def sendSignalAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			invocationAction_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLSendSignalAction[Uml], UMLSignal[Uml]]("signal", _.signal)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		sendSignalAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLSendSignalAction
	 */
	def sendSignalAction_forwardReferencesFromMetamodelAssociations: Elements =
		invocationAction_forwardReferencesFromMetamodelAssociations ++
		signal 

} //UMLSendSignalAction
