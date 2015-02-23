package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A CallOperationAction is a CallAction that transmits an Operation call request to the target object, where it may cause the invocation of associated Behavior. The argument values of the CallOperationAction are passed on the input Parameters of the Operation. If call is synchronous, the execution of the CallOperationAction waits until the execution of the invoked Operation completes and the values of output Parameters of the Operation are placed on the result OutputPins. If the call is asynchronous, the CallOperationAction completes immediately and no results values can be provided.
 * <!-- end-user-doc --> 
 */
trait UMLCallOperationAction[Uml <: UML]
  extends UMLCallAction[Uml] with operations.UMLCallOperationActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		callOperationAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCallOperationAction
	 */
	def callOperationAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		callAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		callOperationAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCallOperationAction
	 */
	def callOperationAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		callAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLCallOperationAction[Uml], UMLInputPin[Uml]]("target", _.target)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		callOperationAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCallOperationAction
	 */
	def callOperationAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		callAction_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLCallOperationAction[Uml], UMLOperation[Uml]]("operation", _.operation)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		callOperationAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCallOperationAction
	 */
	def callOperationAction_forwardReferencesFromMetamodelAssociations: Elements =
		callAction_forwardReferencesFromMetamodelAssociations ++
		operation 

	/**
	 * <!-- begin-user-doc --> 
	 * The Operation being invoked.
	 * <!-- end-user-doc -->
	 */
	def operation: Option[UMLOperation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that provides the target object to which the Operation call request is sent.
	 * <!-- end-user-doc -->
	 */
	def target: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLCallOperationAction
