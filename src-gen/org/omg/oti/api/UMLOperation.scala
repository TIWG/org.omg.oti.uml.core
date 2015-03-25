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
 * An Operation is a BehavioralFeature of a Classifier that specifies the name, type, parameters, and constraints for invoking an associated Behavior. An Operation may invoke both the execution of method behaviors as well as other behavioral responses. Operation specializes TemplateableElement in order to support specification of template operations and bound operations. Operation specializes ParameterableElement to specify that an operation can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 * <!-- end-model-doc -->
 */
trait UMLOperation[Uml <: UML]
	extends UMLBehavioralFeature[Uml]
	with UMLParameterableElement[Uml]
	with UMLTemplateableElement[Uml]
	with UMLOperationOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Class that owns this operation, if any.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClass.ownedOperation
	 */
	def _class: Option[UMLClass[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The return type of the operation, if present. This information is derived from the return result for this Operation.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLType.type_operation
	 */
	def _type: Option[UMLType[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * An optional Constraint on the result values of an invocation of this Operation.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConstraint.bodyCondition_bodyContext
	 */
	def bodyCondition: Option[UMLConstraint[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The DataType that owns this Operation, if any.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLDataType.ownedOperation
	 */
	def datatype: Option[UMLDataType[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Interface that owns this Operation, if any.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInterface.ownedOperation
	 */
	def interface: Option[UMLInterface[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies whether the return parameter is ordered or not, if present.  This information is derived from the return result for this Operation.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isOrdered: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Specifies whether an execution of the BehavioralFeature leaves the state of the system unchanged (isQuery=true) or whether side effects may occur (isQuery=false).
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isQuery: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Specifies whether the return parameter is unique or not, if present. This information is derived from the return result for this Operation.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isUnique: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the lower multiplicity of the return parameter, if present. This information is derived from the return result for this Operation.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def lower: Option[Integer]

	/**
	 * <!-- begin-model-doc -->
	 * The parameters owned by this Operation.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLParameter.operation
	 */
	override def ownedParameter: Seq[UMLParameter[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * An optional set of Constraints specifying the state of the system when the Operation is completed.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConstraint.postcondition_postContext
	 */
	def postcondition: Set[UMLConstraint[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * An optional set of Constraints on the state of the system when the Operation is invoked.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConstraint.precondition_preContext
	 */
	def precondition: Set[UMLConstraint[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Types representing exceptions that may be raised during an invocation of this operation.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLType.raisedException_operation
	 */
	override def raisedException: Set[UMLType[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Operations that are redefined by this Operation.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOperation.redefinedOperation_operation
	 */
	def redefinedOperation: Set[UMLOperation[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The OperationTemplateParameter that exposes this element as a formal parameter.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLOperationTemplateParameter.parameteredElement
	 */
	override def templateParameter: Option[UMLOperationTemplateParameter[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The upper multiplicity of the return parameter, if present. This information is derived from the return result for this Operation.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def upper: Option[Integer]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLCallEvent.operation
	 */
	def operation_callEvent: Set[UMLCallEvent[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLCallOperationAction.operation
	 */
	def operation_callOperationAction: Set[UMLCallOperationAction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLArtifact.ownedOperation
	 */
	def ownedOperation_artifact: Option[UMLArtifact[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOperation.redefinedOperation
	 */
	def redefinedOperation_operation: Set[UMLOperation[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProtocolTransition.referred
	 */
	def referred_protocolTransition: Set[UMLProtocolTransition[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		operation_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLOperation
	 */
	def operation_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			behavioralFeature_metaAttributes,
			parameterableElement_metaAttributes,
			templateableElement_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLOperation[Uml]](None, "isQuery", (x) => booleanToIterable(x.isQuery, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		operation_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLOperation
	 */
	def operation_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavioralFeature_compositeMetaProperties,
			parameterableElement_compositeMetaProperties,
			templateableElement_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLOperation[Uml], UMLConstraint[Uml]]("bodyCondition", _.bodyCondition),
				MetaPropertyCollection[Uml, UMLOperation[Uml], UMLParameter[Uml]]("ownedParameter", _.ownedParameter),
				MetaPropertyCollection[Uml, UMLOperation[Uml], UMLConstraint[Uml]]("postcondition", _.postcondition),
				MetaPropertyCollection[Uml, UMLOperation[Uml], UMLConstraint[Uml]]("precondition", _.precondition)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		operation_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLOperation
	 */
	def operation_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavioralFeature_referenceMetaProperties,
			parameterableElement_referenceMetaProperties,
			templateableElement_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLOperation[Uml], UMLType[Uml]]("raisedException", _.raisedException),
				MetaPropertyCollection[Uml, UMLOperation[Uml], UMLOperation[Uml]]("redefinedOperation", _.redefinedOperation),
				MetaPropertyReference[Uml, UMLOperation[Uml], UMLOperationTemplateParameter[Uml]]("templateParameter", _.templateParameter)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		operation_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLOperation
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

} //UMLOperation
