package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A PartDecomposition is a description of the internal Interactions of one Lifeline relative to an Interaction.
 * <!-- end-user-doc --> 
 */
trait UMLPartDecomposition[Uml <: UML]
  extends UMLInteractionUse[Uml] with operations.UMLPartDecompositionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		partDecomposition_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPartDecomposition
	 */
	def partDecomposition_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		interactionUse_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		partDecomposition_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPartDecomposition
	 */
	def partDecomposition_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionUse_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		partDecomposition_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPartDecomposition
	 */
	def partDecomposition_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionUse_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		partDecomposition_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPartDecomposition
	 */
	def partDecomposition_forwardReferencesFromMetamodelAssociations: Elements =
		interactionUse_forwardReferencesFromMetamodelAssociations ++
		Set () 


	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def decomposedAs_lifeline: Option[UMLLifeline[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLPartDecomposition
