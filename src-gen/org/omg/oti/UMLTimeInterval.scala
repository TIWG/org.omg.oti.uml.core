package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A TimeInterval defines the range between two TimeExpressions.
 * <!-- end-user-doc --> 
 */
trait UMLTimeInterval[Uml <: UML]
  extends UMLInterval[Uml] with operations.UMLTimeIntervalOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		timeInterval_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTimeInterval
	 */
	def timeInterval_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		interval_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		timeInterval_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTimeInterval
	 */
	def timeInterval_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interval_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		timeInterval_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTimeInterval
	 */
	def timeInterval_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interval_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLTimeInterval[Uml], UMLTimeExpression[Uml]]("max", _.timeInterval_max),
		  	MetaPropertyReference[Uml, UMLTimeInterval[Uml], UMLTimeExpression[Uml]]("min", _.timeInterval_min)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		timeInterval_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTimeInterval
	 */
	def timeInterval_forwardReferencesFromMetamodelAssociations: Elements =
		interval_forwardReferencesFromMetamodelAssociations ++
		max ++
		min 

	/**
	 * <!-- begin-user-doc --> 
	 * Refers to the TimeExpression denoting the maximum value of the range.
	 * <!-- end-user-doc -->
	 */
	override def max: Option[UMLValueSpecification[Uml]] 

  def timeInterval_max: Option[UMLTimeExpression[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Refers to the TimeExpression denoting the minimum value of the range.
	 * <!-- end-user-doc -->
	 */
	override def min: Option[UMLValueSpecification[Uml]] 

  def timeInterval_min: Option[UMLTimeExpression[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def specification_timeConstraint: Option[UMLTimeConstraint[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLTimeInterval
