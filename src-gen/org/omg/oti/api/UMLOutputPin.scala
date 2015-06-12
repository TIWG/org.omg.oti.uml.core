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
 * An OutputPin is a Pin that holds output values produced by an Action.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLOutputPin[Uml <: UML]
	extends UMLPin[Uml]
	with UMLOutputPinOps[Uml] {
	
	import ops._

	/**
	 * <!-- Start of user code doc for bodyOutput_clause -->
	 * <!-- End of user code doc for bodyOutput_clause -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClause.bodyOutput
	 */
	def bodyOutput_clause: Set[UMLClause[Uml]]

	/**
	 * <!-- Start of user code doc for bodyOutput_loopNode -->
	 * <!-- End of user code doc for bodyOutput_loopNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLLoopNode.bodyOutput
	 */
	def bodyOutput_loopNode: Set[UMLLoopNode[Uml]]

	/**
	 * <!-- Start of user code doc for decider_clause -->
	 * <!-- End of user code doc for decider_clause -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClause.decider
	 */
	def decider_clause: Option[UMLClause[Uml]]

	/**
	 * <!-- Start of user code doc for decider_loopNode -->
	 * <!-- End of user code doc for decider_loopNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLLoopNode.decider
	 */
	def decider_loopNode: Option[UMLLoopNode[Uml]]

	/**
	 * <!-- Start of user code doc for loopVariable_loopNode -->
	 * <!-- End of user code doc for loopVariable_loopNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLLoopNode.loopVariable
	 */
	def loopVariable_loopNode: Option[UMLLoopNode[Uml]]

	/**
	 * <!-- Start of user code doc for outputValue_opaqueAction -->
	 * <!-- End of user code doc for outputValue_opaqueAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLOpaqueAction.outputValue
	 */
	def outputValue_opaqueAction: Option[UMLOpaqueAction[Uml]]

	/**
	 * <!-- Start of user code doc for output_action -->
	 * <!-- End of user code doc for output_action -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLAction.output
	 */
	def output_action: Option[UMLAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_acceptEventAction -->
	 * <!-- End of user code doc for result_acceptEventAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLAcceptEventAction.result
	 */
	def result_acceptEventAction: Option[UMLAcceptEventAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_callAction -->
	 * <!-- End of user code doc for result_callAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLCallAction.result
	 */
	def result_callAction: Option[UMLCallAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_clearStructuralFeatureAction -->
	 * <!-- End of user code doc for result_clearStructuralFeatureAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClearStructuralFeatureAction.result
	 */
	def result_clearStructuralFeatureAction: Option[UMLClearStructuralFeatureAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_conditionalNode -->
	 * <!-- End of user code doc for result_conditionalNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConditionalNode.result
	 */
	def result_conditionalNode: Option[UMLConditionalNode[Uml]]

	/**
	 * <!-- Start of user code doc for result_createLinkObjectAction -->
	 * <!-- End of user code doc for result_createLinkObjectAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLCreateLinkObjectAction.result
	 */
	def result_createLinkObjectAction: Option[UMLCreateLinkObjectAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_createObjectAction -->
	 * <!-- End of user code doc for result_createObjectAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLCreateObjectAction.result
	 */
	def result_createObjectAction: Option[UMLCreateObjectAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_loopNode -->
	 * <!-- End of user code doc for result_loopNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLLoopNode.result
	 */
	def result_loopNode: Option[UMLLoopNode[Uml]]

	/**
	 * <!-- Start of user code doc for result_readExtentAction -->
	 * <!-- End of user code doc for result_readExtentAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadExtentAction.result
	 */
	def result_readExtentAction: Option[UMLReadExtentAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_readIsClassifiedObjectAction -->
	 * <!-- End of user code doc for result_readIsClassifiedObjectAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadIsClassifiedObjectAction.result
	 */
	def result_readIsClassifiedObjectAction: Option[UMLReadIsClassifiedObjectAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_readLinkAction -->
	 * <!-- End of user code doc for result_readLinkAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadLinkAction.result
	 */
	def result_readLinkAction: Option[UMLReadLinkAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_readLinkObjectEndAction -->
	 * <!-- End of user code doc for result_readLinkObjectEndAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadLinkObjectEndAction.result
	 */
	def result_readLinkObjectEndAction: Option[UMLReadLinkObjectEndAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_readLinkObjectEndQualifierAction -->
	 * <!-- End of user code doc for result_readLinkObjectEndQualifierAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadLinkObjectEndQualifierAction.result
	 */
	def result_readLinkObjectEndQualifierAction: Option[UMLReadLinkObjectEndQualifierAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_readSelfAction -->
	 * <!-- End of user code doc for result_readSelfAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadSelfAction.result
	 */
	def result_readSelfAction: Option[UMLReadSelfAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_readStructuralFeatureAction -->
	 * <!-- End of user code doc for result_readStructuralFeatureAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadStructuralFeatureAction.result
	 */
	def result_readStructuralFeatureAction: Option[UMLReadStructuralFeatureAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_readVariableAction -->
	 * <!-- End of user code doc for result_readVariableAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadVariableAction.result
	 */
	def result_readVariableAction: Option[UMLReadVariableAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_reduceAction -->
	 * <!-- End of user code doc for result_reduceAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReduceAction.result
	 */
	def result_reduceAction: Option[UMLReduceAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_testIdentityAction -->
	 * <!-- End of user code doc for result_testIdentityAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLTestIdentityAction.result
	 */
	def result_testIdentityAction: Option[UMLTestIdentityAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_unmarshallAction -->
	 * <!-- End of user code doc for result_unmarshallAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLUnmarshallAction.result
	 */
	def result_unmarshallAction: Option[UMLUnmarshallAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_valueSpecificationAction -->
	 * <!-- End of user code doc for result_valueSpecificationAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecificationAction.result
	 */
	def result_valueSpecificationAction: Option[UMLValueSpecificationAction[Uml]]

	/**
	 * <!-- Start of user code doc for result_writeStructuralFeatureAction -->
	 * <!-- End of user code doc for result_writeStructuralFeatureAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLWriteStructuralFeatureAction.result
	 */
	def result_writeStructuralFeatureAction: Option[UMLWriteStructuralFeatureAction[Uml]]

	/**
	 * <!-- Start of user code doc for returnInformation_acceptCallAction -->
	 * <!-- End of user code doc for returnInformation_acceptCallAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLAcceptCallAction.returnInformation
	 */
	def returnInformation_acceptCallAction: Option[UMLAcceptCallAction[Uml]]

	/**
	 * <!-- Start of user code doc for structuredNodeOutput_structuredActivityNode -->
	 * <!-- End of user code doc for structuredNodeOutput_structuredActivityNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStructuredActivityNode.structuredNodeOutput
	 */
	def structuredNodeOutput_structuredActivityNode: Option[UMLStructuredActivityNode[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		outputPin_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLOutputPin
	 *
	 * <!-- Start of user code doc for outputPin_metaAttributes -->
	 * <!-- End of user code doc for outputPin_metaAttributes -->
	 */
	def outputPin_metaAttributes: MetaAttributeFunctions = 
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
		outputPin_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLOutputPin
	 *
	 * <!-- Start of user code doc for outputPin_compositeMetaProperties -->
	 * <!-- End of user code doc for outputPin_compositeMetaProperties -->
	 */
	def outputPin_compositeMetaProperties: MetaPropertyFunctions = 
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
		outputPin_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLOutputPin
	 *
	 * <!-- Start of user code doc for outputPin_referenceMetaProperties -->
	 * <!-- End of user code doc for outputPin_referenceMetaProperties -->
	 */
	def outputPin_referenceMetaProperties: MetaPropertyFunctions = 
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
		outputPin_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLOutputPin
	 *
	 * <!-- Start of user code doc for outputPin_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for outputPin_forwardReferencesFromMetamodelAssociations -->
	 */
	def outputPin_forwardReferencesFromMetamodelAssociations: Elements =
		pin_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLOutputPin
