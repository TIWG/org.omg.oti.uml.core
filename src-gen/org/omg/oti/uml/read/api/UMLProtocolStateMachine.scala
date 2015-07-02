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
import org.omg.oti.uml.read.operations.UMLProtocolStateMachineOps

// End of user code

/**
 * A ProtocolStateMachine is always defined in the context of a Classifier. It specifies which BehavioralFeatures of the Classifier can be called in which State and under which conditions, thus specifying the allowed invocation sequences on the Classifier's BehavioralFeatures. A ProtocolStateMachine specifies the possible and permitted Transitions on the instances of its context Classifier, together with the BehavioralFeatures that carry the Transitions. In this manner, an instance lifecycle can be specified for a Classifier, by defining the order in which the BehavioralFeatures can be activated and the States through which an instance progresses during its existence.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLProtocolStateMachine[Uml <: UML]
	extends UMLStateMachine[Uml]
	with UMLProtocolStateMachineOps[Uml] {
	
	import ops._

	/**
	 * Specifies the namespace in which the protocol state machine is defined.
	 *
	 * <!-- Start of user code doc for protocol_interface -->
	 * <!-- End of user code doc for protocol_interface -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInterface.protocol
	 */
	def protocol_interface: Option[UMLInterface[Uml]]

	/**
	 * <!-- Start of user code doc for protocol_port -->
	 * <!-- End of user code doc for protocol_port -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPort.protocol
	 */
	def protocol_port: Set[UMLPort[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		protocolStateMachine_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLProtocolStateMachine
	 *
	 * <!-- Start of user code doc for protocolStateMachine_metaAttributes -->
	 * <!-- End of user code doc for protocolStateMachine_metaAttributes -->
	 */
	def protocolStateMachine_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			stateMachine_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		protocolStateMachine_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLProtocolStateMachine
	 *
	 * <!-- Start of user code doc for protocolStateMachine_compositeMetaProperties -->
	 * <!-- End of user code doc for protocolStateMachine_compositeMetaProperties -->
	 */
	def protocolStateMachine_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			stateMachine_compositeMetaProperties,
			Seq (ProtocolStateMachine_conformance))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		protocolStateMachine_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLProtocolStateMachine
	 *
	 * <!-- Start of user code doc for protocolStateMachine_referenceMetaProperties -->
	 * <!-- End of user code doc for protocolStateMachine_referenceMetaProperties -->
	 */
	def protocolStateMachine_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			stateMachine_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		protocolStateMachine_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLProtocolStateMachine
	 *
	 * <!-- Start of user code doc for protocolStateMachine_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for protocolStateMachine_forwardReferencesFromMetamodelAssociations -->
	 */
	def protocolStateMachine_forwardReferencesFromMetamodelAssociations: Elements =
		stateMachine_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLProtocolStateMachine
