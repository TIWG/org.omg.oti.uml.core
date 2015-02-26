package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A DurationObservation is a reference to a duration during an execution. It points out the NamedElement(s) in the model to observe and whether the observations are when this NamedElement is entered or when it is exited.
 * <!-- end-user-doc --> 
 */
trait UMLDurationObservation[Uml <: UML]
  extends UMLObservation[Uml] with operations.UMLDurationObservationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		durationObservation_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDurationObservation
	 */
	def durationObservation_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		observation_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLDurationObservation[Uml]](None, "firstEvent", _.firstEvent)) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		durationObservation_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDurationObservation
	 */
	def durationObservation_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		observation_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		durationObservation_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDurationObservation
	 */
	def durationObservation_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		observation_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLDurationObservation[Uml], UMLNamedElement[Uml]]("event", _.event)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		durationObservation_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDurationObservation
	 */
	def durationObservation_forwardReferencesFromMetamodelAssociations: Elements =
		observation_forwardReferencesFromMetamodelAssociations ++
		event 

	/**
	 * <!-- begin-user-doc --> 
	 * The DurationObservation is determined as the duration between the entering or exiting of a single event Element during execution, or the entering/exiting of one event Element and the entering/exiting of a second.
	 * <!-- end-user-doc -->
	 */
	def event: Seq[UMLNamedElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The value of firstEvent[i] is related to event[i] (where i is 1 or 2). If firstEvent[i] is true, then the corresponding observation event is the first time instant the execution enters event[i]. If firstEvent[i] is false, then the corresponding observation event is the time instant the execution exits event[i].
	 * <!-- end-user-doc -->
	 */
	def firstEvent: Seq[Boolean] 

// Start of user code for additional featuers
// End of user code

} //UMLDurationObservation
