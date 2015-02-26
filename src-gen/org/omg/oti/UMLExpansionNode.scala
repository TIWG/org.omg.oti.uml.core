package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ExpansionNode is an ObjectNode used to indicate a collection input or output for an ExpansionRegion. A collection input of an ExpansionRegion contains a collection that is broken into its individual elements inside the region, whose content is executed once per element. A collection output of an ExpansionRegion combines individual elements produced by the execution of the region into a collection for use outside the region.
 * <!-- end-user-doc --> 
 */
trait UMLExpansionNode[Uml <: UML]
  extends UMLObjectNode[Uml] with operations.UMLExpansionNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		expansionNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExpansionNode
	 */
	def expansionNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		objectNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		expansionNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExpansionNode
	 */
	def expansionNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		objectNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		expansionNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExpansionNode
	 */
	def expansionNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		objectNode_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLExpansionNode[Uml], UMLExpansionRegion[Uml]]("regionAsInput", _.regionAsInput),
		  	MetaPropertyReference[Uml, UMLExpansionNode[Uml], UMLExpansionRegion[Uml]]("regionAsOutput", _.regionAsOutput)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		expansionNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExpansionNode
	 */
	def expansionNode_forwardReferencesFromMetamodelAssociations: Elements =
		objectNode_forwardReferencesFromMetamodelAssociations ++
		regionAsInput ++
		regionAsOutput 

	/**
	 * <!-- begin-user-doc --> 
	 * The ExpansionRegion for which the ExpansionNode is an input.
	 * <!-- end-user-doc -->
	 */
	def regionAsInput: Option[UMLExpansionRegion[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ExpansionRegion for which the ExpansionNode is an output.
	 * <!-- end-user-doc -->
	 */
	def regionAsOutput: Option[UMLExpansionRegion[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLExpansionNode
