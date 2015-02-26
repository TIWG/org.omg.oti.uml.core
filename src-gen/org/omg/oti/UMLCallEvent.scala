package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A CallEvent models the receipt by an object of a message invoking a call of an Operation.
 * <!-- end-user-doc --> 
 */
trait UMLCallEvent[Uml <: UML]
  extends UMLMessageEvent[Uml] with operations.UMLCallEventOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		callEvent_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCallEvent
	 */
	def callEvent_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		messageEvent_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		callEvent_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCallEvent
	 */
	def callEvent_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		messageEvent_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		callEvent_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCallEvent
	 */
	def callEvent_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		messageEvent_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLCallEvent[Uml], UMLOperation[Uml]]("operation", _.operation)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		callEvent_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCallEvent
	 */
	def callEvent_forwardReferencesFromMetamodelAssociations: Elements =
		messageEvent_forwardReferencesFromMetamodelAssociations ++
		operation 

	/**
	 * <!-- begin-user-doc --> 
	 * Designates the Operation whose invocation raised the CalEvent.
	 * <!-- end-user-doc -->
	 */
	def operation: Option[UMLOperation[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLCallEvent
