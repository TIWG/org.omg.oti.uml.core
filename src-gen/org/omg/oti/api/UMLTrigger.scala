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
 * A Trigger specifies a specific point  at which an Event occurrence may trigger an effect in a Behavior. A Trigger may be qualified by the Port on which the Event occurred.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLTrigger[Uml <: UML]
	extends UMLNamedElement[Uml]
	with UMLTriggerOps[Uml] {
	
	import ops._

	/**
	 * The Event that detected by the Trigger.
	 *
	 * <!-- Start of user code doc for event -->
	 * <!-- End of user code doc for event -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLEvent.event_trigger
	 */
	def event: Option[UMLEvent[Uml]]

	/**
	 * A optional Port of through which the given effect is detected.
	 *
	 * <!-- Start of user code doc for port -->
	 * <!-- End of user code doc for port -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPort.port_trigger
	 */
	def port: Set[UMLPort[Uml]]

	/**
	 * <!-- Start of user code doc for deferrableTrigger_state -->
	 * <!-- End of user code doc for deferrableTrigger_state -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLState.deferrableTrigger
	 */
	def deferrableTrigger_state: Option[UMLState[Uml]]

	/**
	 * <!-- Start of user code doc for replyToCall_replyAction -->
	 * <!-- End of user code doc for replyToCall_replyAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReplyAction.replyToCall
	 */
	def replyToCall_replyAction: Option[UMLReplyAction[Uml]]

	/**
	 * <!-- Start of user code doc for trigger_acceptEventAction -->
	 * <!-- End of user code doc for trigger_acceptEventAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLAcceptEventAction.trigger
	 */
	def trigger_acceptEventAction: Option[UMLAcceptEventAction[Uml]]

	/**
	 * <!-- Start of user code doc for trigger_transition -->
	 * <!-- End of user code doc for trigger_transition -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLTransition.trigger
	 */
	def trigger_transition: Option[UMLTransition[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		trigger_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTrigger
	 *
	 * <!-- Start of user code doc for trigger_metaAttributes -->
	 * <!-- End of user code doc for trigger_metaAttributes -->
	 */
	def trigger_metaAttributes: MetaAttributeFunctions = 
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
		trigger_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTrigger
	 *
	 * <!-- Start of user code doc for trigger_compositeMetaProperties -->
	 * <!-- End of user code doc for trigger_compositeMetaProperties -->
	 */
	def trigger_compositeMetaProperties: MetaPropertyFunctions = 
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
		trigger_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTrigger
	 *
	 * <!-- Start of user code doc for trigger_referenceMetaProperties -->
	 * <!-- End of user code doc for trigger_referenceMetaProperties -->
	 */
	def trigger_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_referenceMetaProperties,
			Seq (Trigger_event,
				Trigger_port))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		trigger_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTrigger
	 *
	 * <!-- Start of user code doc for trigger_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for trigger_forwardReferencesFromMetamodelAssociations -->
	 */
	def trigger_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		event ++
		port 

	// Start of user code for additional features
	// End of user code
} //UMLTrigger
