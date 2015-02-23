package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A DurationConstraint is a Constraint that refers to a DurationInterval.
 * <!-- end-user-doc --> 
 */
trait UMLDurationConstraint[Uml <: UML]
  extends UMLIntervalConstraint[Uml] with operations.UMLDurationConstraintOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		durationConstraint_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDurationConstraint
	 */
	def durationConstraint_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		intervalConstraint_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLDurationConstraint[Uml]](None, "firstEvent", _.firstEvent)) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		durationConstraint_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDurationConstraint
	 */
	def durationConstraint_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		intervalConstraint_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLDurationConstraint[Uml], UMLDurationInterval[Uml]]("specification", _.specification)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		durationConstraint_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDurationConstraint
	 */
	def durationConstraint_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		intervalConstraint_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		durationConstraint_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDurationConstraint
	 */
	def durationConstraint_forwardReferencesFromMetamodelAssociations: Elements =
		intervalConstraint_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The value of firstEvent[i] is related to constrainedElement[i] (where i is 1 or 2). If firstEvent[i] is true, then the corresponding observation event is the first time instant the execution enters constrainedElement[i]. If firstEvent[i] is false, then the corresponding observation event is the last time instant the execution is within constrainedElement[i].
	 * <!-- end-user-doc -->
	 */
	def firstEvent: Set[Boolean] 

	/**
	 * <!-- begin-user-doc --> 
	 * The DurationInterval constraining the duration.
	 * <!-- end-user-doc -->
	 */
	override def specification: Option[UMLDurationInterval[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLDurationConstraint
