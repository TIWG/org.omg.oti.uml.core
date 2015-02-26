package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A TimeObservation is a reference to a time instant during an execution. It points out the NamedElement in the model to observe and whether the observation is when this NamedElement is entered or when it is exited.
 * <!-- end-user-doc --> 
 */
trait UMLTimeObservation[Uml <: UML]
  extends UMLObservation[Uml] with operations.UMLTimeObservationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		timeObservation_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTimeObservation
	 */
	def timeObservation_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		observation_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLTimeObservation[Uml]](None, "firstEvent", _.firstEvent) ) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		timeObservation_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTimeObservation
	 */
	def timeObservation_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		observation_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		timeObservation_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTimeObservation
	 */
	def timeObservation_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		observation_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLTimeObservation[Uml], UMLNamedElement[Uml]]("event", _.event)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		timeObservation_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTimeObservation
	 */
	def timeObservation_forwardReferencesFromMetamodelAssociations: Elements =
		observation_forwardReferencesFromMetamodelAssociations ++
		event 

	/**
	 * <!-- begin-user-doc --> 
	 * The TimeObservation is determined by the entering or exiting of the event Element during execution.
	 * <!-- end-user-doc -->
	 */
	def event: Option[UMLNamedElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The value of firstEvent is related to the event. If firstEvent is true, then the corresponding observation event is the first time instant the execution enters the event Element. If firstEvent is false, then the corresponding observation event is the time instant the execution exits the event Element.
	 * <!-- end-user-doc -->
	 */
	def firstEvent: Option[Boolean]

// Start of user code for additional featuers
// End of user code

} //UMLTimeObservation
