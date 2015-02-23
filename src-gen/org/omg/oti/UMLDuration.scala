package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Duration is a ValueSpecification that specifies the temporal distance between two time instants.
 * <!-- end-user-doc --> 
 */
trait UMLDuration[Uml <: UML]
  extends UMLValueSpecification[Uml] with operations.UMLDurationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		duration_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDuration
	 */
	def duration_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		valueSpecification_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		duration_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDuration
	 */
	def duration_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLDuration[Uml], UMLValueSpecification[Uml]]("expr", _.expr)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		duration_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDuration
	 */
	def duration_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLDuration[Uml], UMLObservation[Uml]]("observation", _.observation)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		duration_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDuration
	 */
	def duration_forwardReferencesFromMetamodelAssociations: Elements =
		valueSpecification_forwardReferencesFromMetamodelAssociations ++
		observation 

	/**
	 * <!-- begin-user-doc --> 
	 * A ValueSpecification that evaluates to the value of the Duration.
	 * <!-- end-user-doc -->
	 */
	def expr: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Refers to the Observations that are involved in the computation of the Duration value
	 * <!-- end-user-doc -->
	 */
	def observation: Set[UMLObservation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def max_durationInterval: Iterable[UMLDurationInterval[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def min_durationInterval: Iterable[UMLDurationInterval[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLDuration
