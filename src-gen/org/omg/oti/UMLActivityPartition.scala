package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ActivityPartition is a kind of ActivityGroup for identifying ActivityNodes that have some characteristic in common.
 * <!-- end-user-doc --> 
 */
trait UMLActivityPartition[Uml <: UML]
  extends UMLActivityGroup[Uml] with operations.UMLActivityPartitionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activityPartition_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivityPartition
	 */
	def activityPartition_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		activityGroup_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLActivityPartition[Uml]](None, "isDimension", (x) => booleanToIterable(x.isDimension, false)),
		  	MetaAttributeBooleanFunction[Uml, UMLActivityPartition[Uml]](None, "isExternal", (x) => booleanToIterable(x.isExternal, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activityPartition_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivityPartition
	 */
	def activityPartition_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityGroup_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLActivityPartition[Uml], UMLActivityPartition[Uml]]("subpartition", _.subpartition)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activityPartition_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivityPartition
	 */
	def activityPartition_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityGroup_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLActivityPartition[Uml], UMLActivityEdge[Uml]]("edge", _.edge),
		  	MetaPropertyCollection[Uml, UMLActivityPartition[Uml], UMLActivityNode[Uml]]("node", _.node),
		  	MetaPropertyReference[Uml, UMLActivityPartition[Uml], UMLElement[Uml]]("represents", _.represents),
		  	MetaPropertyReference[Uml, UMLActivityPartition[Uml], UMLActivityPartition[Uml]]("superPartition", _.superPartition)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activityPartition_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivityPartition
	 */
	def activityPartition_forwardReferencesFromMetamodelAssociations: Elements =
		activityGroup_forwardReferencesFromMetamodelAssociations ++
		edge ++
		node ++
		represents ++
		superPartition 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityEdges immediately contained in the ActivityPartition.
	 * <!-- end-user-doc -->
	 */
	def edge: Set[UMLActivityEdge[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether the ActivityPartition groups other ActivityPartitions along a dimension.
	 * <!-- end-user-doc -->
	 */
	def isDimension: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether the ActivityPartition represents an entity to which the partitioning structure does not apply.
	 * <!-- end-user-doc -->
	 */
	def isExternal: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityNodes immediately contained in the ActivityPartition.
	 * <!-- end-user-doc -->
	 */
	def node: Set[UMLActivityNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An Element represented by the functionality modeled within the ActivityPartition.
	 * <!-- end-user-doc -->
	 */
	def represents: Option[UMLElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Other ActivityPartitions immediately contained in this ActivityPartition (as its subgroups).
	 * <!-- end-user-doc -->
	 */
	def subpartition: Set[UMLActivityPartition[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Other ActivityPartitions immediately containing this ActivityPartition (as its superGroups).
	 * <!-- end-user-doc -->
	 */
	def superPartition: Option[UMLActivityPartition[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def partition_activity: Option[UMLActivity[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLActivityPartition
