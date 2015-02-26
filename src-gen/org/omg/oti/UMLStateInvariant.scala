package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A StateInvariant is a runtime constraint on the participants of the Interaction. It may be used to specify a variety of different kinds of Constraints, such as values of Attributes or Variables, internal or external States, and so on. A StateInvariant is an InteractionFragment and it is placed on a Lifeline.
 * <!-- end-user-doc --> 
 */
trait UMLStateInvariant[Uml <: UML]
  extends UMLInteractionFragment[Uml] with operations.UMLStateInvariantOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		stateInvariant_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStateInvariant
	 */
	def stateInvariant_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		interactionFragment_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		stateInvariant_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStateInvariant
	 */
	def stateInvariant_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLStateInvariant[Uml], UMLConstraint[Uml]]("invariant", _.invariant)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		stateInvariant_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStateInvariant
	 */
	def stateInvariant_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLStateInvariant[Uml], UMLLifeline[Uml]]("covered", _.covered)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		stateInvariant_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStateInvariant
	 */
	def stateInvariant_forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations ++
		covered 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Lifeline on which the StateInvariant appears.
	 * <!-- end-user-doc -->
	 */
	override def covered: Iterable[UMLLifeline[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A Constraint that should hold at runtime for this StateInvariant.
	 * <!-- end-user-doc -->
	 */
	def invariant: Option[UMLConstraint[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLStateInvariant
