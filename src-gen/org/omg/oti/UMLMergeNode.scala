package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A merge node is a control node that brings together multiple alternate flows. It is not used to synchronize concurrent flows but to accept one among several alternate flows.
 * <!-- end-user-doc --> 
 */
trait UMLMergeNode[Uml <: UML]
  extends UMLControlNode[Uml] with operations.UMLMergeNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		mergeNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLMergeNode
	 */
	def mergeNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		controlNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		mergeNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLMergeNode
	 */
	def mergeNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		controlNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		mergeNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLMergeNode
	 */
	def mergeNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		controlNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		mergeNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLMergeNode
	 */
	def mergeNode_forwardReferencesFromMetamodelAssociations: Elements =
		controlNode_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLMergeNode
