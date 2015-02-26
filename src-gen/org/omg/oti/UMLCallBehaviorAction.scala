package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A CallBehaviorAction is a CallAction that invokes a Behavior directly. The argument values of the CallBehaviorAction are passed on the input Parameters of the invoked Behavior. If the call is synchronous, the execution of the CallBehaviorAction waits until the execution of the invoked Behavior completes and the values of output Parameters of the Behavior are placed on the result OutputPins. If the call is asynchronous, the CallBehaviorAction completes immediately and no results values can be provided.
 * <!-- end-user-doc --> 
 */
trait UMLCallBehaviorAction[Uml <: UML]
  extends UMLCallAction[Uml] with operations.UMLCallBehaviorActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		callBehaviorAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCallBehaviorAction
	 */
	def callBehaviorAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		callAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		callBehaviorAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCallBehaviorAction
	 */
	def callBehaviorAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		callAction_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		callBehaviorAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCallBehaviorAction
	 */
	def callBehaviorAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		callAction_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLCallBehaviorAction[Uml], UMLBehavior[Uml]]("behavior", _.behavior)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		callBehaviorAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCallBehaviorAction
	 */
	def callBehaviorAction_forwardReferencesFromMetamodelAssociations: Elements =
		callAction_forwardReferencesFromMetamodelAssociations ++
		behavior 

	/**
	 * <!-- begin-user-doc --> 
	 * The Behavior being invoked.
	 * <!-- end-user-doc -->
	 */
	def behavior: Option[UMLBehavior[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLCallBehaviorAction
