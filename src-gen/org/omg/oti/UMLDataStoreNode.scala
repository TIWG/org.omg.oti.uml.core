package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A DataStoreNode is a CentralBufferNode for persistent data.
 * <!-- end-user-doc --> 
 */
trait UMLDataStoreNode[Uml <: UML]
  extends UMLCentralBufferNode[Uml] with operations.UMLDataStoreNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		dataStoreNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDataStoreNode
	 */
	def dataStoreNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		centralBufferNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		dataStoreNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDataStoreNode
	 */
	def dataStoreNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		centralBufferNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		dataStoreNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDataStoreNode
	 */
	def dataStoreNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		centralBufferNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		dataStoreNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDataStoreNode
	 */
	def dataStoreNode_forwardReferencesFromMetamodelAssociations: Elements =
		centralBufferNode_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLDataStoreNode
