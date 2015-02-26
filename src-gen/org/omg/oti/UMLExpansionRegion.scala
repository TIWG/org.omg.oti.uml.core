package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ExpansionRegion is a StructuredActivityNode that executes its content multiple times corresponding to elements of input collection(s).
 * <!-- end-user-doc --> 
 */
trait UMLExpansionRegion[Uml <: UML]
  extends UMLStructuredActivityNode[Uml] with operations.UMLExpansionRegionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		expansionRegion_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExpansionRegion
	 */
	def expansionRegion_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		structuredActivityNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		expansionRegion_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExpansionRegion
	 */
	def expansionRegion_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuredActivityNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		expansionRegion_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExpansionRegion
	 */
	def expansionRegion_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuredActivityNode_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLExpansionRegion[Uml], UMLExpansionNode[Uml]]("inputElement", _.inputElement),
		  	MetaPropertyCollection[Uml, UMLExpansionRegion[Uml], UMLExpansionNode[Uml]]("outputElement", _.outputElement)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		expansionRegion_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExpansionRegion
	 */
	def expansionRegion_forwardReferencesFromMetamodelAssociations: Elements =
		structuredActivityNode_forwardReferencesFromMetamodelAssociations ++
		inputElement ++
		outputElement 

	/**
	 * <!-- begin-user-doc --> 
	 * The ExpansionNodes that hold the input collections for the ExpansionRegion.
	 * <!-- end-user-doc -->
	 */
	def inputElement: Set[UMLExpansionNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The mode in which the ExpansionRegion executes its contents. If parallel, executions are concurrent. If iterative, executions are sequential. If stream, a stream of values flows into a single execution.
	 * <!-- end-user-doc -->
	 */
	def mode: UMLExpansionKind.Value

	/**
	 * <!-- begin-user-doc --> 
	 * The ExpansionNodes that form the output collections of the ExpansionRegion.
	 * <!-- end-user-doc -->
	 */
	def outputElement: Set[UMLExpansionNode[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLExpansionRegion
