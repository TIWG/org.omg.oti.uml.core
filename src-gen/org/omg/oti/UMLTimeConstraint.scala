package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A TimeConstraint is a Constraint that refers to a TimeInterval.
 * <!-- end-user-doc --> 
 */
trait UMLTimeConstraint[Uml <: UML]
  extends UMLIntervalConstraint[Uml] with operations.UMLTimeConstraintOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		timeConstraint_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTimeConstraint
	 */
	def timeConstraint_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		intervalConstraint_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLTimeConstraint[Uml]](None, "firstEvent", _.firstEvent) ) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		timeConstraint_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTimeConstraint
	 */
	def timeConstraint_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		intervalConstraint_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLTimeConstraint[Uml], UMLTimeInterval[Uml]]("specification", _.timeConstraint_specification)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		timeConstraint_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTimeConstraint
	 */
	def timeConstraint_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		intervalConstraint_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		timeConstraint_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTimeConstraint
	 */
	def timeConstraint_forwardReferencesFromMetamodelAssociations: Elements =
		intervalConstraint_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The value of firstEvent is related to the constrainedElement. If firstEvent is true, then the corresponding observation event is the first time instant the execution enters the constrainedElement. If firstEvent is false, then the corresponding observation event is the last time instant the execution is within the constrainedElement.
	 * <!-- end-user-doc -->
	 */
	def firstEvent: Option[Boolean] 

	/**
	 * <!-- begin-user-doc --> 
	 * TheTimeInterval constraining the duration.
	 * <!-- end-user-doc -->
	 */
	override def specification: Option[UMLValueSpecification[Uml]] 

  def timeConstraint_specification: Option[UMLTimeInterval[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLTimeConstraint
