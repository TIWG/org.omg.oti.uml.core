package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An Interval defines the range between two ValueSpecifications.
 * <!-- end-user-doc --> 
 */
trait UMLInterval[Uml <: UML]
  extends UMLValueSpecification[Uml] with operations.UMLIntervalOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interval_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInterval
	 */
	def interval_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		valueSpecification_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interval_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInterval
	 */
	def interval_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interval_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInterval
	 */
	def interval_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLInterval[Uml], UMLValueSpecification[Uml]]("max", _.max),
		  	MetaPropertyReference[Uml, UMLInterval[Uml], UMLValueSpecification[Uml]]("min", _.min)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interval_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInterval
	 */
	def interval_forwardReferencesFromMetamodelAssociations: Elements =
		valueSpecification_forwardReferencesFromMetamodelAssociations ++
		max ++
		min 

	/**
	 * <!-- begin-user-doc --> 
	 * Refers to the ValueSpecification denoting the maximum value of the range.
	 * <!-- end-user-doc -->
	 */
	def max: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Refers to the ValueSpecification denoting the minimum value of the range.
	 * <!-- end-user-doc -->
	 */
	def min: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def specification_intervalConstraint: Option[UMLIntervalConstraint[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLInterval
