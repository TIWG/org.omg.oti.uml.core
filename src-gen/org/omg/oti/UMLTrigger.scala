package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Trigger specifies a specific point  at which an Event occurrence may trigger an effect in a Behavior. A Trigger may be qualified by the Port on which the Event occurred.
 * <!-- end-user-doc --> 
 */
trait UMLTrigger[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLTriggerOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		trigger_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTrigger
	 */
	def trigger_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		trigger_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTrigger
	 */
	def trigger_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		trigger_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTrigger
	 */
	def trigger_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLTrigger[Uml], UMLEvent[Uml]]("event", _.event),
		  	MetaPropertyCollection[Uml, UMLTrigger[Uml], UMLPort[Uml]]("port", _.port)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		trigger_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTrigger
	 */
	def trigger_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		event ++
		port 

	/**
	 * <!-- begin-user-doc --> 
	 * The Event that detected by the Trigger.
	 * <!-- end-user-doc -->
	 */
	def event: Option[UMLEvent[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A optional Port of through which the given effect is detected.
	 * <!-- end-user-doc -->
	 */
	def port: Set[UMLPort[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def trigger_transition: Option[UMLTransition[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def replyToCall_replyAction: Option[UMLReplyAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def trigger_acceptEventAction: Option[UMLAcceptEventAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def deferrableTrigger_state: Option[UMLState[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLTrigger
