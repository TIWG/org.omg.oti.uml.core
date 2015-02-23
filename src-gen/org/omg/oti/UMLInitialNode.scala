package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An InitialNode is a ControlNode that offers a single control token when initially enabled.
 * <!-- end-user-doc --> 
 */
trait UMLInitialNode[Uml <: UML]
  extends UMLControlNode[Uml] with operations.UMLInitialNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		initialNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInitialNode
	 */
	def initialNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		controlNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		initialNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInitialNode
	 */
	def initialNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		controlNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		initialNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInitialNode
	 */
	def initialNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		controlNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		initialNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInitialNode
	 */
	def initialNode_forwardReferencesFromMetamodelAssociations: Elements =
		controlNode_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLInitialNode
