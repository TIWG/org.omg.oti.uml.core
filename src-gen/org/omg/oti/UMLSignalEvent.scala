package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A SignalEvent represents the receipt of an asynchronous Signal instance.
 * <!-- end-user-doc --> 
 */
trait UMLSignalEvent[Uml <: UML]
  extends UMLMessageEvent[Uml] with operations.UMLSignalEventOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		signalEvent_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLSignalEvent
	 */
	def signalEvent_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		messageEvent_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		signalEvent_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLSignalEvent
	 */
	def signalEvent_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		messageEvent_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		signalEvent_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLSignalEvent
	 */
	def signalEvent_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		messageEvent_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLSignalEvent[Uml], UMLSignal[Uml]]("signal", _.signal)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		signalEvent_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLSignalEvent
	 */
	def signalEvent_forwardReferencesFromMetamodelAssociations: Elements =
		messageEvent_forwardReferencesFromMetamodelAssociations ++
		signal 

	/**
	 * <!-- begin-user-doc --> 
	 * The specific Signal that is associated with this SignalEvent.
	 * <!-- end-user-doc -->
	 */
	def signal: Option[UMLSignal[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLSignalEvent
