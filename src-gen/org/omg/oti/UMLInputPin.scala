package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An InputPin is a Pin that holds input values to be consumed by an Action.
 * <!-- end-user-doc --> 
 */
trait UMLInputPin[Uml <: UML]
  extends UMLPin[Uml] with operations.UMLInputPinOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		inputPin_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInputPin
	 */
	def inputPin_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		pin_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		inputPin_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInputPin
	 */
	def inputPin_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		pin_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		inputPin_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInputPin
	 */
	def inputPin_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		pin_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		inputPin_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInputPin
	 */
	def inputPin_forwardReferencesFromMetamodelAssociations: Elements =
		pin_forwardReferencesFromMetamodelAssociations ++
		Set () 


	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def removeAt_removeVariableValueAction: Option[UMLRemoveVariableValueAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def structuredNodeInput_structuredActivityNode: Option[UMLStructuredActivityNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def returnInformation_replyAction: Option[UMLReplyAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def second_testIdentityAction: Option[UMLTestIdentityAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def object_reclassifyObjectAction: Option[UMLReclassifyObjectAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def request_sendObjectAction: Option[UMLSendObjectAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def value_qualifierValue: Option[UMLQualifierValue[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def insertAt_addStructuralFeatureValueAction: Option[UMLAddStructuralFeatureValueAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def object_readLinkObjectEndQualifierAction: Option[UMLReadLinkObjectEndQualifierAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def destroyAt_linkEndDestructionData: Option[UMLLinkEndDestructionData[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def object_readLinkObjectEndAction: Option[UMLReadLinkObjectEndAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def insertAt_linkEndCreationData: Option[UMLLinkEndCreationData[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def target_sendObjectAction: Option[UMLSendObjectAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def object_clearAssociationAction: Option[UMLClearAssociationAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def value_linkEndData: Option[UMLLinkEndData[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def value_writeVariableAction: Option[UMLWriteVariableAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def object_structuralFeatureAction: Option[UMLStructuralFeatureAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def value_writeStructuralFeatureAction: Option[UMLWriteStructuralFeatureAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def replyValue_replyAction: Option[UMLReplyAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def insertAt_addVariableValueAction: Option[UMLAddVariableValueAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def object_startClassifierBehaviorAction: Option[UMLStartClassifierBehaviorAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def removeAt_removeStructuralFeatureValueAction: Option[UMLRemoveStructuralFeatureValueAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def first_testIdentityAction: Option[UMLTestIdentityAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def loopVariableInput_loopNode: Option[UMLLoopNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def target_callOperationAction: Option[UMLCallOperationAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def input_action: Option[UMLAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def target_destroyObjectAction: Option[UMLDestroyObjectAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def inputValue_opaqueAction: Option[UMLOpaqueAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def collection_reduceAction: Option[UMLReduceAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def argument_invocationAction: Option[UMLInvocationAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def object_startObjectBehaviorAction: Option[UMLStartObjectBehaviorAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def object_readIsClassifiedObjectAction: Option[UMLReadIsClassifiedObjectAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def target_sendSignalAction: Option[UMLSendSignalAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def exception_raiseExceptionAction: Option[UMLRaiseExceptionAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def object_unmarshallAction: Option[UMLUnmarshallAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def inputValue_linkAction: Option[UMLLinkAction[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLInputPin
