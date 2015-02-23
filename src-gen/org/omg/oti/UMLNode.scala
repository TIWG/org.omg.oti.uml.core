package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Node is computational resource upon which artifacts may be deployed for execution. Nodes can be interconnected through communication paths to define network structures.
 * <!-- end-user-doc --> 
 */
trait UMLNode[Uml <: UML]
  extends UMLClass[Uml] with UMLDeploymentTarget[Uml] with operations.UMLNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		node_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLNode
	 */
	def node_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		class_metaAttributes,
		deploymentTarget_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		node_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLNode
	 */
	def node_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		class_compositeMetaProperties,
		deploymentTarget_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLNode[Uml], UMLNode[Uml]]("nestedNode", _.nestedNode)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		node_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLNode
	 */
	def node_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		class_referenceMetaProperties,
		deploymentTarget_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		node_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLNode
	 */
	def node_forwardReferencesFromMetamodelAssociations: Elements =
		class_forwardReferencesFromMetamodelAssociations ++
		deploymentTarget_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The Nodes that are defined (nested) within the Node.
	 * <!-- end-user-doc -->
	 */
	def nestedNode: Set[UMLNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def nestedNode_node: Option[UMLNode[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLNode
