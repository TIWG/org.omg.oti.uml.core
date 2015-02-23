package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A DurationInterval defines the range between two Durations.
 * <!-- end-user-doc --> 
 */
trait UMLDurationInterval[Uml <: UML]
  extends UMLInterval[Uml] with operations.UMLDurationIntervalOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		durationInterval_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDurationInterval
	 */
	def durationInterval_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		interval_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		durationInterval_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDurationInterval
	 */
	def durationInterval_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interval_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		durationInterval_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDurationInterval
	 */
	def durationInterval_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interval_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLDurationInterval[Uml], UMLDuration[Uml]]("max", _.durationInterval_max),
		  	MetaPropertyReference[UMLDurationInterval[Uml], UMLDuration[Uml]]("min", _.durationInterval_min)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		durationInterval_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDurationInterval
	 */
	def durationInterval_forwardReferencesFromMetamodelAssociations: Elements =
		interval_forwardReferencesFromMetamodelAssociations ++
		max ++
		min 

	/**
	 * <!-- begin-user-doc --> 
	 * Refers to the Duration denoting the maximum value of the range.
	 * <!-- end-user-doc -->
	 */
	override def max: Option[UMLValueSpecification[Uml]] 

  def durationInterval_max: Option[UMLDuration[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Refers to the Duration denoting the minimum value of the range.
	 * <!-- end-user-doc -->
	 */
	override def min: Option[UMLValueSpecification[Uml]] 

  def durationInterval_min: Option[UMLDuration[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def specification_durationConstraint: Option[UMLDurationConstraint[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLDurationInterval
