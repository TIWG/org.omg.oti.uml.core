package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Signal is a specification of a kind of communication between objects in which a reaction is asynchronously triggered in the receiver without a reply.
 * <!-- end-user-doc --> 
 */
trait UMLSignal[Uml <: UML]
  extends UMLClassifier[Uml] with operations.UMLSignalOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		signal_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLSignal
	 */
	def signal_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		classifier_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		signal_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLSignal
	 */
	def signal_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		classifier_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLSignal[Uml], UMLProperty[Uml]]("ownedAttribute", _.ownedAttribute)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		signal_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLSignal
	 */
	def signal_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		classifier_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		signal_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLSignal
	 */
	def signal_forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The attributes owned by the Signal.
	 * <!-- end-user-doc -->
	 */
	def ownedAttribute: Seq[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def signal_broadcastSignalAction: Set[UMLBroadcastSignalAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def signal_sendSignalAction: Set[UMLSendSignalAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def signal_signalEvent: Set[UMLSignalEvent[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def signal_reception: Set[UMLReception[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLSignal
