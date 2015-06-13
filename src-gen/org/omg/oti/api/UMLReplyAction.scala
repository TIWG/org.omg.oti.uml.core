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
 * A ReplyAction is an Action that accepts a set of reply values and a value containing return information produced by a previous AcceptCallAction. The ReplyAction returns the values to the caller of the previous call, completing execution of the call.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLReplyAction[Uml <: UML]
	extends UMLAction[Uml]
	with UMLReplyActionOps[Uml] {
	
	import ops._

	/**
	 * The Trigger specifying the Operation whose call is being replied to.
	 *
	 * <!-- Start of user code doc for replyToCall -->
	 * <!-- End of user code doc for replyToCall -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLTrigger.replyToCall_replyAction
	 */
	def replyToCall: Option[UMLTrigger[Uml]]

	/**
	 * A list of InputPins providing the values for the output (inout, out, and return) Parameters of the Operation. These values are returned to the caller.
	 *
	 * <!-- Start of user code doc for replyValue -->
	 * <!-- End of user code doc for replyValue -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInputPin.replyValue_replyAction
	 */
	def replyValue: Seq[UMLInputPin[Uml]]

	/**
	 * An InputPin that holds the return information value produced by an earlier AcceptCallAction.
	 *
	 * <!-- Start of user code doc for returnInformation -->
	 * <!-- End of user code doc for returnInformation -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.returnInformation_replyAction
	 */
	def returnInformation: Option[UMLInputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		replyAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReplyAction
	 *
	 * <!-- Start of user code doc for replyAction_metaAttributes -->
	 * <!-- End of user code doc for replyAction_metaAttributes -->
	 */
	def replyAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			action_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		replyAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReplyAction
	 *
	 * <!-- Start of user code doc for replyAction_compositeMetaProperties -->
	 * <!-- End of user code doc for replyAction_compositeMetaProperties -->
	 */
	def replyAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLReplyAction[Uml], UMLInputPin[Uml]]("replyValue", _.replyValue, true),
				MetaPropertyReference[Uml, UMLReplyAction[Uml], UMLInputPin[Uml]]("returnInformation", _.returnInformation)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		replyAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReplyAction
	 *
	 * <!-- Start of user code doc for replyAction_referenceMetaProperties -->
	 * <!-- End of user code doc for replyAction_referenceMetaProperties -->
	 */
	def replyAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLReplyAction[Uml], UMLTrigger[Uml]]("replyToCall", _.replyToCall)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		replyAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReplyAction
	 *
	 * <!-- Start of user code doc for replyAction_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for replyAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def replyAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		replyToCall 

	// Start of user code for additional features
	// End of user code
} //UMLReplyAction
