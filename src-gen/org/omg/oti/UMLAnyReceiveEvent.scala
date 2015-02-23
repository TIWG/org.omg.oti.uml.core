package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A trigger for an AnyReceiveEvent is triggered by the receipt of any message that is not explicitly handled by any related trigger.
 * <!-- end-user-doc --> 
 */
trait UMLAnyReceiveEvent[Uml <: UML]
  extends UMLMessageEvent[Uml] with operations.UMLAnyReceiveEventOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		anyReceiveEvent_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAnyReceiveEvent
	 */
	def anyReceiveEvent_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		messageEvent_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		anyReceiveEvent_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAnyReceiveEvent
	 */
	def anyReceiveEvent_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		messageEvent_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		anyReceiveEvent_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAnyReceiveEvent
	 */
	def anyReceiveEvent_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		messageEvent_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		anyReceiveEvent_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAnyReceiveEvent
	 */
	def anyReceiveEvent_forwardReferencesFromMetamodelAssociations: Elements =
		messageEvent_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLAnyReceiveEvent
