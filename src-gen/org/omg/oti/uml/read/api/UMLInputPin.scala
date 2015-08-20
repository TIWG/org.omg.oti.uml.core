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
import org.omg.oti.uml.read.operations.UMLInputPinOps

// End of user code

/**
 * An InputPin is a Pin that holds input values to be consumed by an Action.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLInputPin[Uml <: UML]
	extends UMLPin[Uml]
	with UMLInputPinOps[Uml] {
	
	import ops._

	/**
	 * <!-- Start of user code doc for argument_invocationAction -->
   * <!-- End of user code doc for argument_invocationAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLInvocationAction.argument
	 */
	def argument_invocationAction: Option[UMLInvocationAction[Uml]]

	/**
	 * <!-- Start of user code doc for destroyAt_linkEndDestructionData -->
   * <!-- End of user code doc for destroyAt_linkEndDestructionData -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLLinkEndDestructionData.destroyAt
	 */
	def destroyAt_linkEndDestructionData: Option[UMLLinkEndDestructionData[Uml]]

	/**
	 * <!-- Start of user code doc for first_testIdentityAction -->
   * <!-- End of user code doc for first_testIdentityAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLTestIdentityAction.first
	 */
	def first_testIdentityAction: Option[UMLTestIdentityAction[Uml]]

	/**
	 * <!-- Start of user code doc for input_action -->
   * <!-- End of user code doc for input_action -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLAction.input
	 */
	def input_action: Option[UMLAction[Uml]]

	/**
	 * <!-- Start of user code doc for insertAt_linkEndCreationData -->
   * <!-- End of user code doc for insertAt_linkEndCreationData -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLLinkEndCreationData.insertAt
	 */
	def insertAt_linkEndCreationData: Option[UMLLinkEndCreationData[Uml]]

	/**
	 * <!-- Start of user code doc for object_structuralFeatureAction -->
   * <!-- End of user code doc for object_structuralFeatureAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLStructuralFeatureAction._object
	 */
	def object_structuralFeatureAction: Option[UMLStructuralFeatureAction[Uml]]

	/**
	 * <!-- Start of user code doc for replyValue_replyAction -->
   * <!-- End of user code doc for replyValue_replyAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLReplyAction.replyValue
	 */
	def replyValue_replyAction: Option[UMLReplyAction[Uml]]

	/**
	 * <!-- Start of user code doc for returnInformation_replyAction -->
   * <!-- End of user code doc for returnInformation_replyAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLReplyAction.returnInformation
	 */
	def returnInformation_replyAction: Option[UMLReplyAction[Uml]]

	/**
	 * <!-- Start of user code doc for second_testIdentityAction -->
   * <!-- End of user code doc for second_testIdentityAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLTestIdentityAction.second
	 */
	def second_testIdentityAction: Option[UMLTestIdentityAction[Uml]]

	/**
	 * <!-- Start of user code doc for target_sendObjectAction -->
   * <!-- End of user code doc for target_sendObjectAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLSendObjectAction.target
	 */
	def target_sendObjectAction: Option[UMLSendObjectAction[Uml]]

	/**
	 * <!-- Start of user code doc for value_linkEndData -->
   * <!-- End of user code doc for value_linkEndData -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLLinkEndData.value
	 */
	def value_linkEndData: Option[UMLLinkEndData[Uml]]

	/**
	 * <!-- Start of user code doc for value_qualifierValue -->
   * <!-- End of user code doc for value_qualifierValue -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLQualifierValue.value
	 */
	def value_qualifierValue: Option[UMLQualifierValue[Uml]]

	/**
	 * <!-- Start of user code doc for value_writeStructuralFeatureAction -->
   * <!-- End of user code doc for value_writeStructuralFeatureAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLWriteStructuralFeatureAction.value
	 */
	def value_writeStructuralFeatureAction: Option[UMLWriteStructuralFeatureAction[Uml]]

	/**
	 * <!-- Start of user code doc for value_writeVariableAction -->
   * <!-- End of user code doc for value_writeVariableAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.uml.read.api.UMLWriteVariableAction.value
	 */
	def value_writeVariableAction: Option[UMLWriteVariableAction[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		inputPin_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInputPin
	 *
	 * <!-- Start of user code doc for inputPin_metaAttributes -->
   * <!-- End of user code doc for inputPin_metaAttributes -->
	 */
	def inputPin_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			pin_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		inputPin_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInputPin
	 *
	 * <!-- Start of user code doc for inputPin_compositeMetaProperties -->
   * <!-- End of user code doc for inputPin_compositeMetaProperties -->
	 */
	def inputPin_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			pin_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		inputPin_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInputPin
	 *
	 * <!-- Start of user code doc for inputPin_referenceMetaProperties -->
   * <!-- End of user code doc for inputPin_referenceMetaProperties -->
	 */
	def inputPin_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			pin_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		inputPin_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInputPin
	 *
	 * <!-- Start of user code doc for inputPin_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for inputPin_forwardReferencesFromMetamodelAssociations -->
	 */
	def inputPin_forwardReferencesFromMetamodelAssociations: Elements =
		pin_forwardReferencesFromMetamodelAssociations ++
		Set ()

	// Start of user code for additional features
  // End of user code
} //UMLInputPin
