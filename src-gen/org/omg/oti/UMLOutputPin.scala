package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An OutputPin is a Pin that holds output values produced by an Action.
 * <!-- end-user-doc --> 
 */
trait UMLOutputPin[Uml <: UML]
  extends UMLPin[Uml] with operations.UMLOutputPinOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		outputPin_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLOutputPin
	 */
	def outputPin_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		pin_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		outputPin_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLOutputPin
	 */
	def outputPin_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		pin_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		outputPin_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLOutputPin
	 */
	def outputPin_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		pin_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		outputPin_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLOutputPin
	 */
	def outputPin_forwardReferencesFromMetamodelAssociations: Elements =
		pin_forwardReferencesFromMetamodelAssociations ++
		Set () 


	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def structuredNodeOutput_structuredActivityNode: Option[UMLStructuredActivityNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def decider_loopNode: Option[UMLLoopNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_readLinkObjectEndQualifierAction: Option[UMLReadLinkObjectEndQualifierAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_readSelfAction: Option[UMLReadSelfAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def bodyOutput_clause: Set[UMLClause[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_readLinkObjectEndAction: Option[UMLReadLinkObjectEndAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_reduceAction: Option[UMLReduceAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_testIdentityAction: Option[UMLTestIdentityAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_valueSpecificationAction: Option[UMLValueSpecificationAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def returnInformation_acceptCallAction: Option[UMLAcceptCallAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_conditionalNode: Option[UMLConditionalNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def output_action: Option[UMLAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def decider_clause: Option[UMLClause[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_readExtentAction: Option[UMLReadExtentAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_createLinkObjectAction: Option[UMLCreateLinkObjectAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_readVariableAction: Option[UMLReadVariableAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_readLinkAction: Option[UMLReadLinkAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_readIsClassifiedObjectAction: Option[UMLReadIsClassifiedObjectAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_unmarshallAction: Option[UMLUnmarshallAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_readStructuralFeatureAction: Option[UMLReadStructuralFeatureAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_acceptEventAction: Option[UMLAcceptEventAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_loopNode: Option[UMLLoopNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_callAction: Option[UMLCallAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def bodyOutput_loopNode: Set[UMLLoopNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_createObjectAction: Option[UMLCreateObjectAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def outputValue_opaqueAction: Option[UMLOpaqueAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def loopVariable_loopNode: Option[UMLLoopNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_clearStructuralFeatureAction: Option[UMLClearStructuralFeatureAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_writeStructuralFeatureAction: Option[UMLWriteStructuralFeatureAction[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLOutputPin
