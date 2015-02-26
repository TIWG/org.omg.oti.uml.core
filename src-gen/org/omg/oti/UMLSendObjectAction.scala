package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A SendObjectAction is an InvocationAction that transmits an input object to the target object, which is handled as a request message by the target object. The requestor continues execution immediately after the object is sent out and cannot receive reply values.
 * <!-- end-user-doc --> 
 */
trait UMLSendObjectAction[Uml <: UML]
  extends UMLInvocationAction[Uml] with operations.UMLSendObjectActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		sendObjectAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLSendObjectAction
	 */
	def sendObjectAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		invocationAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		sendObjectAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLSendObjectAction
	 */
	def sendObjectAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		invocationAction_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLSendObjectAction[Uml], UMLInputPin[Uml]]("request", _.request),
		  	MetaPropertyReference[Uml, UMLSendObjectAction[Uml], UMLInputPin[Uml]]("target", _.target)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		sendObjectAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLSendObjectAction
	 */
	def sendObjectAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		invocationAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		sendObjectAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLSendObjectAction
	 */
	def sendObjectAction_forwardReferencesFromMetamodelAssociations: Elements =
		invocationAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The request object, which is transmitted to the target object. The object may be copied in transmission, so identity might not be preserved.
	 * <!-- end-user-doc -->
	 */
	def request: Iterable[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The target object to which the object is sent.
	 * <!-- end-user-doc -->
	 */
	def target: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLSendObjectAction
