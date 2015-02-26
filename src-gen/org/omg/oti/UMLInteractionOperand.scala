package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An InteractionOperand is contained in a CombinedFragment. An InteractionOperand represents one operand of the expression given by the enclosing CombinedFragment.
 * <!-- end-user-doc --> 
 */
trait UMLInteractionOperand[Uml <: UML]
  extends UMLInteractionFragment[Uml] with UMLNamespace[Uml] with operations.UMLInteractionOperandOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interactionOperand_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInteractionOperand
	 */
	def interactionOperand_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		interactionFragment_metaAttributes,
		namespace_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interactionOperand_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInteractionOperand
	 */
	def interactionOperand_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_compositeMetaProperties,
		namespace_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLInteractionOperand[Uml], UMLInteractionFragment[Uml]]("fragment", _.fragment),
		  	MetaPropertyReference[Uml, UMLInteractionOperand[Uml], UMLInteractionConstraint[Uml]]("guard", _.guard)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interactionOperand_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInteractionOperand
	 */
	def interactionOperand_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_referenceMetaProperties,
		namespace_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interactionOperand_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInteractionOperand
	 */
	def interactionOperand_forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations ++
		namespace_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The fragments of the operand.
	 * <!-- end-user-doc -->
	 */
	def fragment: Seq[UMLInteractionFragment[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Constraint of the operand.
	 * <!-- end-user-doc -->
	 */
	def guard: Option[UMLInteractionConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def operand_combinedFragment: Option[UMLCombinedFragment[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLInteractionOperand
