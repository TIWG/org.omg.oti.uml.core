package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An IntervalConstraint is a Constraint that is specified by an Interval.
 * <!-- end-user-doc --> 
 */
trait UMLIntervalConstraint[Uml <: UML]
  extends UMLConstraint[Uml] with operations.UMLIntervalConstraintOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		intervalConstraint_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLIntervalConstraint
	 */
	def intervalConstraint_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		constraint_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		intervalConstraint_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLIntervalConstraint
	 */
	def intervalConstraint_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		constraint_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLIntervalConstraint[Uml], UMLInterval[Uml]]("specification", _.intervalConstraint_specification)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		intervalConstraint_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLIntervalConstraint
	 */
	def intervalConstraint_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		constraint_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		intervalConstraint_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLIntervalConstraint
	 */
	def intervalConstraint_forwardReferencesFromMetamodelAssociations: Elements =
		constraint_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The Interval that specifies the condition of the IntervalConstraint.
	 * <!-- end-user-doc -->
	 */
	override def specification: Option[UMLValueSpecification[Uml]] 

  def intervalConstraint_specification: Option[UMLInterval[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLIntervalConstraint
