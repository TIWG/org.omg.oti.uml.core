package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A CombinedFragment defines an expression of InteractionFragments. A CombinedFragment is defined by an interaction operator and corresponding InteractionOperands. Through the use of CombinedFragments the user will be able to describe a number of traces in a compact and concise manner.
 * <!-- end-user-doc --> 
 */
trait UMLCombinedFragment[Uml <: UML]
  extends UMLInteractionFragment[Uml] with operations.UMLCombinedFragmentOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		combinedFragment_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCombinedFragment
	 */
	def combinedFragment_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		interactionFragment_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		combinedFragment_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCombinedFragment
	 */
	def combinedFragment_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLCombinedFragment[Uml], UMLGate[Uml]]("cfragmentGate", _.cfragmentGate),
		  	MetaPropertyCollection[Uml, UMLCombinedFragment[Uml], UMLInteractionOperand[Uml]]("operand", _.operand)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		combinedFragment_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCombinedFragment
	 */
	def combinedFragment_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		combinedFragment_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCombinedFragment
	 */
	def combinedFragment_forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the gates that form the interface between this CombinedFragment and its surroundings
	 * <!-- end-user-doc -->
	 */
	def cfragmentGate: Set[UMLGate[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the operation which defines the semantics of this combination of InteractionFragments.
	 * <!-- end-user-doc -->
	 */
	def interactionOperator: UMLInteractionOperatorKind.Value

	/**
	 * <!-- begin-user-doc --> 
	 * The set of operands of the combined fragment.
	 * <!-- end-user-doc -->
	 */
	def operand: Seq[UMLInteractionOperand[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLCombinedFragment
