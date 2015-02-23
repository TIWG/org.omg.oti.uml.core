package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A CentralBufferNode is an ObjectNode for managing flows from multiple sources and targets.
 * <!-- end-user-doc --> 
 */
trait UMLCentralBufferNode[Uml <: UML]
  extends UMLObjectNode[Uml] with operations.UMLCentralBufferNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		centralBufferNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCentralBufferNode
	 */
	def centralBufferNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		objectNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		centralBufferNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCentralBufferNode
	 */
	def centralBufferNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		objectNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		centralBufferNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCentralBufferNode
	 */
	def centralBufferNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		objectNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		centralBufferNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCentralBufferNode
	 */
	def centralBufferNode_forwardReferencesFromMetamodelAssociations: Elements =
		objectNode_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLCentralBufferNode
