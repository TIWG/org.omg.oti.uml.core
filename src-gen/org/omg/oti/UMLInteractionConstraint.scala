package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An InteractionConstraint is a Boolean expression that guards an operand in a CombinedFragment.
 * <!-- end-user-doc --> 
 */
trait UMLInteractionConstraint[Uml <: UML]
  extends UMLConstraint[Uml] with operations.UMLInteractionConstraintOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interactionConstraint_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInteractionConstraint
	 */
	def interactionConstraint_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		constraint_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interactionConstraint_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInteractionConstraint
	 */
	def interactionConstraint_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		constraint_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLInteractionConstraint[Uml], UMLValueSpecification[Uml]]("maxint", _.maxint),
		  	MetaPropertyReference[UMLInteractionConstraint[Uml], UMLValueSpecification[Uml]]("minint", _.minint)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interactionConstraint_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInteractionConstraint
	 */
	def interactionConstraint_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		constraint_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interactionConstraint_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInteractionConstraint
	 */
	def interactionConstraint_forwardReferencesFromMetamodelAssociations: Elements =
		constraint_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The maximum number of iterations of a loop
	 * <!-- end-user-doc -->
	 */
	def maxint: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The minimum number of iterations of a loop
	 * <!-- end-user-doc -->
	 */
	def minint: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def guard_interactionOperand: Option[UMLInteractionOperand[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLInteractionConstraint
