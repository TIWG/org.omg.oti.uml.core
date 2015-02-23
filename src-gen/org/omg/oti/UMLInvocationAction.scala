package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * InvocationAction is an abstract class for the various actions that request Behavior invocation.

 * <!-- end-user-doc --> 
 */
trait UMLInvocationAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLInvocationActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		invocationAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInvocationAction
	 */
	def invocationAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		invocationAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInvocationAction
	 */
	def invocationAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLInvocationAction[Uml], UMLInputPin[Uml]]("argument", _.argument)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		invocationAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInvocationAction
	 */
	def invocationAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLInvocationAction[Uml], UMLPort[Uml]]("onPort", _.onPort)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		invocationAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInvocationAction
	 */
	def invocationAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		onPort 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPins that provide the argument values passed in the invocation request.
	 * <!-- end-user-doc -->
	 */
	def argument: Iterable[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * For CallOperationActions, SendSignalActions, and SendObjectActions, an optional Port of the target object through which the invocation request is sent.
	 * <!-- end-user-doc -->
	 */
	def onPort: Option[UMLPort[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLInvocationAction
