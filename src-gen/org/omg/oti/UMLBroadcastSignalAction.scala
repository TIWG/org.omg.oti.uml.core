package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A BroadcastSignalAction is an InvocationAction that transmits a Signal instance to all the potential target objects in the system. Values from the argument InputPins are used to provide values for the attributes of the Signal. The requestor continues execution immediately after the Signal instances are sent out and cannot receive reply values.
 * <!-- end-user-doc --> 
 */
trait UMLBroadcastSignalAction[Uml <: UML]
  extends UMLInvocationAction[Uml] with operations.UMLBroadcastSignalActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		broadcastSignalAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLBroadcastSignalAction
	 */
	def broadcastSignalAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		invocationAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		broadcastSignalAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLBroadcastSignalAction
	 */
	def broadcastSignalAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		invocationAction_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		broadcastSignalAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLBroadcastSignalAction
	 */
	def broadcastSignalAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		invocationAction_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLBroadcastSignalAction[Uml], UMLSignal[Uml]]("signal", _.signal)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		broadcastSignalAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLBroadcastSignalAction
	 */
	def broadcastSignalAction_forwardReferencesFromMetamodelAssociations: Elements =
		invocationAction_forwardReferencesFromMetamodelAssociations ++
		signal 

	/**
	 * <!-- begin-user-doc --> 
	 * The Signal whose instances are to be sent.
	 * <!-- end-user-doc -->
	 */
	def signal: Option[UMLSignal[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLBroadcastSignalAction
