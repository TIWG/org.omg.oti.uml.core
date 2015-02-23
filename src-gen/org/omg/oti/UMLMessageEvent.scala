package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A MessageEvent specifies the receipt by an object of either an Operation call or a Signal instance.
 * <!-- end-user-doc --> 
 */
trait UMLMessageEvent[Uml <: UML]
  extends UMLEvent[Uml] with operations.UMLMessageEventOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		messageEvent_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLMessageEvent
	 */
	def messageEvent_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		event_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		messageEvent_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLMessageEvent
	 */
	def messageEvent_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		event_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		messageEvent_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLMessageEvent
	 */
	def messageEvent_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		event_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		messageEvent_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLMessageEvent
	 */
	def messageEvent_forwardReferencesFromMetamodelAssociations: Elements =
		event_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLMessageEvent
