package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ForkNode is a ControlNode that splits a flow into multiple concurrent flows.
 * <!-- end-user-doc --> 
 */
trait UMLForkNode[Uml <: UML]
  extends UMLControlNode[Uml] with operations.UMLForkNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		forkNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLForkNode
	 */
	def forkNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		controlNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		forkNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLForkNode
	 */
	def forkNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		controlNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		forkNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLForkNode
	 */
	def forkNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		controlNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		forkNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLForkNode
	 */
	def forkNode_forwardReferencesFromMetamodelAssociations: Elements =
		controlNode_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLForkNode
