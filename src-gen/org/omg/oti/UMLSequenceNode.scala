package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A SequenceNode is a StructuredActivityNode that executes a sequence of ExecutableNodes in order.
 * <!-- end-user-doc --> 
 */
trait UMLSequenceNode[Uml <: UML]
  extends UMLStructuredActivityNode[Uml] with operations.UMLSequenceNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		sequenceNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLSequenceNode
	 */
	def sequenceNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		structuredActivityNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		sequenceNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLSequenceNode
	 */
	def sequenceNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuredActivityNode_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLSequenceNode[Uml], UMLExecutableNode[Uml]]("executableNode", _.executableNode)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		sequenceNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLSequenceNode
	 */
	def sequenceNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuredActivityNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		sequenceNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLSequenceNode
	 */
	def sequenceNode_forwardReferencesFromMetamodelAssociations: Elements =
		structuredActivityNode_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The ordered set of ExecutableNodes to be sequenced.
	 * <!-- end-user-doc -->
	 */
	def executableNode: Iterable[UMLExecutableNode[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLSequenceNode
