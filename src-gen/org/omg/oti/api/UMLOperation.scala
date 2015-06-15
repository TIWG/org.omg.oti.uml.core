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
 * An Operation is a BehavioralFeature of a Classifier that specifies the name, type, parameters, and constraints for invoking an associated Behavior. An Operation may invoke both the execution of method behaviors as well as other behavioral responses. Operation specializes TemplateableElement in order to support specification of template operations and bound operations. Operation specializes ParameterableElement to specify that an operation can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLOperation[Uml <: UML]
	extends UMLBehavioralFeature[Uml]
	with UMLParameterableElement[Uml]
	with UMLTemplateableElement[Uml]
	with UMLOperationOps[Uml] {
	
	import ops._

	/**
	 * The Class that owns this operation, if any.
	 *
	 * <!-- Start of user code doc for _class -->
	 * <!-- End of user code doc for _class -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClass.ownedOperation
	 */
	def _class: Option[UMLClass[Uml]]

	/**
	 * The return type of the operation, if present. This information is derived from the return result for this Operation.
	 *
	 * <!-- Start of user code doc for _type -->
	 * <!-- End of user code doc for _type -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLType.type_operation
	 * @body result = (if returnResult()->notEmpty() then returnResult()->any(true).type else null endif)
	 */
	def _type: Option[UMLType[Uml]]

	/**
	 * An optional Constraint on the result values of an invocation of this Operation.
	 *
	 * <!-- Start of user code doc for bodyCondition -->
	 * <!-- End of user code doc for bodyCondition -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConstraint.bodyCondition_bodyContext
	 */
	def bodyCondition: Option[UMLConstraint[Uml]]

	/**
	 * The DataType that owns this Operation, if any.
	 *
	 * <!-- Start of user code doc for datatype -->
	 * <!-- End of user code doc for datatype -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLDataType.ownedOperation
	 */
	def datatype: Option[UMLDataType[Uml]]

	/**
	 * The Interface that owns this Operation, if any.
	 *
	 * <!-- Start of user code doc for interface -->
	 * <!-- End of user code doc for interface -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInterface.ownedOperation
	 */
	def interface: Option[UMLInterface[Uml]]

	/**
	 * Specifies whether the return parameter is ordered or not, if present.  This information is derived from the return result for this Operation.
	 *
	 * <!-- Start of user code doc for isOrdered -->
	 * <!-- End of user code doc for isOrdered -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @body result = (if returnResult()->notEmpty() then returnResult()-> exists(isOrdered) else false endif)
	 */
	def isOrdered: Boolean

	/**
	 * Specifies whether an execution of the BehavioralFeature leaves the state of the system unchanged (isQuery=true) or whether side effects may occur (isQuery=false).
	 *
	 * <!-- Start of user code doc for isQuery -->
	 * <!-- End of user code doc for isQuery -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isQuery: Boolean

	/**
	 * Specifies whether the return parameter is unique or not, if present. This information is derived from the return result for this Operation.
	 *
	 * <!-- Start of user code doc for isUnique -->
	 * <!-- End of user code doc for isUnique -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @body result = (if returnResult()->notEmpty() then returnResult()->exists(isUnique) else true endif)
	 */
	def isUnique: Boolean

	/**
	 * Specifies the lower multiplicity of the return parameter, if present. This information is derived from the return result for this Operation.
	 *
	 * <!-- Start of user code doc for lower -->
	 * <!-- End of user code doc for lower -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @body result = (if returnResult()->notEmpty() then returnResult()->any(true).lower else null endif)
	 */
	def lower: Option[Integer]

	/**
	 * The parameters owned by this Operation.
	 *
	 * <!-- Start of user code doc for ownedParameter -->
	 * <!-- End of user code doc for ownedParameter -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLParameter.operation
	 */
	override def ownedParameter: Seq[UMLParameter[Uml]]

	/**
	 * An optional set of Constraints specifying the state of the system when the Operation is completed.
	 *
	 * <!-- Start of user code doc for postcondition -->
	 * <!-- End of user code doc for postcondition -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConstraint.postcondition_postContext
	 */
	def postcondition: Set[UMLConstraint[Uml]]

	/**
	 * An optional set of Constraints on the state of the system when the Operation is invoked.
	 *
	 * <!-- Start of user code doc for precondition -->
	 * <!-- End of user code doc for precondition -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConstraint.precondition_preContext
	 */
	def precondition: Set[UMLConstraint[Uml]]

	/**
	 * The Types representing exceptions that may be raised during an invocation of this operation.
	 *
	 * <!-- Start of user code doc for raisedException -->
	 * <!-- End of user code doc for raisedException -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLType.raisedException_operation
	 */
	override def raisedException: Set[UMLType[Uml]]

	/**
	 * The Operations that are redefined by this Operation.
	 *
	 * <!-- Start of user code doc for redefinedOperation -->
	 * <!-- End of user code doc for redefinedOperation -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOperation.redefinedOperation_operation
	 */
	def redefinedOperation: Set[UMLOperation[Uml]]

	/**
	 * The OperationTemplateParameter that exposes this element as a formal parameter.
	 *
	 * <!-- Start of user code doc for templateParameter -->
	 * <!-- End of user code doc for templateParameter -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLOperationTemplateParameter.parameteredElement
	 */
	override def templateParameter: Option[UMLOperationTemplateParameter[Uml]]

	/**
	 * The upper multiplicity of the return parameter, if present. This information is derived from the return result for this Operation.
	 *
	 * <!-- Start of user code doc for upper -->
	 * <!-- End of user code doc for upper -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @body result = (if returnResult()->notEmpty() then returnResult()->any(true).upper else null endif)
	 */
	def upper: Option[Integer]

	/**
	 * <!-- Start of user code doc for operation_callEvent -->
	 * <!-- End of user code doc for operation_callEvent -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLCallEvent.operation
	 */
	def operation_callEvent: Set[UMLCallEvent[Uml]]

	/**
	 * <!-- Start of user code doc for operation_callOperationAction -->
	 * <!-- End of user code doc for operation_callOperationAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLCallOperationAction.operation
	 */
	def operation_callOperationAction: Set[UMLCallOperationAction[Uml]]

	/**
	 * <!-- Start of user code doc for ownedOperation_artifact -->
	 * <!-- End of user code doc for ownedOperation_artifact -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLArtifact.ownedOperation
	 */
	def ownedOperation_artifact: Option[UMLArtifact[Uml]]

	/**
	 * <!-- Start of user code doc for redefinedOperation_operation -->
	 * <!-- End of user code doc for redefinedOperation_operation -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOperation.redefinedOperation
	 */
	def redefinedOperation_operation: Set[UMLOperation[Uml]]

	/**
	 * <!-- Start of user code doc for referred_protocolTransition -->
	 * <!-- End of user code doc for referred_protocolTransition -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProtocolTransition.referred
	 */
	def referred_protocolTransition: Set[UMLProtocolTransition[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		operation_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLOperation
	 *
	 * <!-- Start of user code doc for operation_metaAttributes -->
	 * <!-- End of user code doc for operation_metaAttributes -->
	 */
	def operation_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			behavioralFeature_metaAttributes,
			parameterableElement_metaAttributes,
			templateableElement_metaAttributes,
			Seq (Operation_isQuery))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		operation_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLOperation
	 *
	 * <!-- Start of user code doc for operation_compositeMetaProperties -->
	 * <!-- End of user code doc for operation_compositeMetaProperties -->
	 */
	def operation_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavioralFeature_compositeMetaProperties,
			parameterableElement_compositeMetaProperties,
			templateableElement_compositeMetaProperties,
			Seq (Operation_bodyCondition,
				Operation_ownedParameter,
				Operation_postcondition,
				Operation_precondition))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		operation_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLOperation
	 *
	 * <!-- Start of user code doc for operation_referenceMetaProperties -->
	 * <!-- End of user code doc for operation_referenceMetaProperties -->
	 */
	def operation_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavioralFeature_referenceMetaProperties,
			parameterableElement_referenceMetaProperties,
			templateableElement_referenceMetaProperties,
			Seq (Operation_raisedException,
				Operation_redefinedOperation,
				Operation_templateParameter))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		operation_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLOperation
	 *
	 * <!-- Start of user code doc for operation_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for operation_forwardReferencesFromMetamodelAssociations -->
	 */
	def operation_forwardReferencesFromMetamodelAssociations: Elements =
		behavioralFeature_forwardReferencesFromMetamodelAssociations ++
		parameterableElement_forwardReferencesFromMetamodelAssociations ++
		templateableElement_forwardReferencesFromMetamodelAssociations ++
		_class ++
		datatype ++
		interface ++
		raisedException ++
		redefinedOperation ++
		templateParameter 

	// Start of user code for additional features
	// End of user code
} //UMLOperation
