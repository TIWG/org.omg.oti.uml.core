package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A SendSignalAction is an InvocationAction that creates a Signal instance and transmits it to the target object. Values from the argument InputPins are used to provide values for the attributes of the Signal. The requestor continues execution immediately after the Signal instance is sent out and cannot receive reply values.
 * <!-- end-user-doc --> 
 */
trait UMLSendSignalAction[Uml <: UML]
  extends UMLInvocationAction[Uml] with operations.UMLSendSignalActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		sendSignalAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLSendSignalAction
	 */
	def sendSignalAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		invocationAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		sendSignalAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLSendSignalAction
	 */
	def sendSignalAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		invocationAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLSendSignalAction[Uml], UMLInputPin[Uml]]("target", _.target)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		sendSignalAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLSendSignalAction
	 */
	def sendSignalAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		invocationAction_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLSendSignalAction[Uml], UMLSignal[Uml]]("signal", _.signal)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		sendSignalAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLSendSignalAction
	 */
	def sendSignalAction_forwardReferencesFromMetamodelAssociations: Elements =
		invocationAction_forwardReferencesFromMetamodelAssociations ++
		signal 

	/**
	 * <!-- begin-user-doc --> 
	 * The Signal whose instance is transmitted to the target.
	 * <!-- end-user-doc -->
	 */
	def signal: Option[UMLSignal[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that provides the target object to which the Signal instance is sent.
	 * <!-- end-user-doc -->
	 */
	def target: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLSendSignalAction
