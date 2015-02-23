package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * ActivityNode is an abstract class for points in the flow of an Activity connected by ActivityEdges.
 * <!-- end-user-doc --> 
 */
trait UMLActivityNode[Uml <: UML]
  extends UMLRedefinableElement[Uml] with operations.UMLActivityNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activityNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivityNode
	 */
	def activityNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		redefinableElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activityNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivityNode
	 */
	def activityNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activityNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivityNode
	 */
	def activityNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLActivityNode[Uml], UMLActivity[Uml]]("activity", _.activity),
		  	MetaPropertyCollection[UMLActivityNode[Uml], UMLInterruptibleActivityRegion[Uml]]("inInterruptibleRegion", _.inInterruptibleRegion),
		  	MetaPropertyCollection[UMLActivityNode[Uml], UMLActivityPartition[Uml]]("inPartition", _.inPartition),
		  	MetaPropertyReference[UMLActivityNode[Uml], UMLStructuredActivityNode[Uml]]("inStructuredNode", _.inStructuredNode),
		  	MetaPropertyCollection[UMLActivityNode[Uml], UMLActivityEdge[Uml]]("incoming", _.incoming),
		  	MetaPropertyCollection[UMLActivityNode[Uml], UMLActivityEdge[Uml]]("outgoing", _.outgoing),
		  	MetaPropertyCollection[UMLActivityNode[Uml], UMLActivityNode[Uml]]("redefinedNode", _.redefinedNode)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activityNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivityNode
	 */
	def activityNode_forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		activity ++
		inInterruptibleRegion ++
		inPartition ++
		inStructuredNode ++
		incoming ++
		outgoing ++
		redefinedNode 

	/**
	 * <!-- begin-user-doc --> 
	 * The Activity containing the ActivityNode, if it is directly owned by an Activity.
	 * <!-- end-user-doc -->
	 */
	def activity: Option[UMLActivity[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityGroups containing the ActivityNode.
	 * <!-- end-user-doc -->
	 */
	def inGroup: Set[UMLActivityGroup[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * InterruptibleActivityRegions containing the ActivityNode.
	 * <!-- end-user-doc -->
	 */
	def inInterruptibleRegion: Set[UMLInterruptibleActivityRegion[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityPartitions containing the ActivityNode.
	 * <!-- end-user-doc -->
	 */
	def inPartition: Set[UMLActivityPartition[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The StructuredActivityNode containing the ActvityNode, if it is directly owned by a StructuredActivityNode.
	 * <!-- end-user-doc -->
	 */
	def inStructuredNode: Option[UMLStructuredActivityNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityEdges that have the ActivityNode as their target.
	 * <!-- end-user-doc -->
	 */
	def incoming: Set[UMLActivityEdge[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityEdges that have the ActivityNode as their source.
	 * <!-- end-user-doc -->
	 */
	def outgoing: Set[UMLActivityEdge[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityNodes from a generalization of the Activity containining this ActivityNode that are redefined by this ActivityNode.
	 * <!-- end-user-doc -->
	 */
	def redefinedNode: Set[UMLActivityNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinedNode_activityNode: Set[UMLActivityNode[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLActivityNode
