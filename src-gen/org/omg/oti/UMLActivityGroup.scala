package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * ActivityGroup is an abstract class for defining sets of ActivityNodes and ActivityEdges in an Activity.
 * <!-- end-user-doc --> 
 */
trait UMLActivityGroup[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLActivityGroupOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activityGroup_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivityGroup
	 */
	def activityGroup_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activityGroup_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivityGroup
	 */
	def activityGroup_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activityGroup_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivityGroup
	 */
	def activityGroup_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLActivityGroup[Uml], UMLActivity[Uml]]("inActivity", _.inActivity)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activityGroup_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivityGroup
	 */
	def activityGroup_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		inActivity 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityEdges immediately contained in the ActivityGroup.
	 * <!-- end-user-doc -->
	 */
	def containedEdge: Set[UMLActivityEdge[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityNodes immediately contained in the ActivityGroup.
	 * <!-- end-user-doc -->
	 */
	def containedNode: Set[UMLActivityNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Activity containing the ActivityGroup, if it is directly owned by an Activity.
	 * <!-- end-user-doc -->
	 */
	def inActivity: Option[UMLActivity[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Other ActivityGroups immediately contained in this ActivityGroup.
	 * <!-- end-user-doc -->
	 */
	def subgroup: Set[UMLActivityGroup[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ActivityGroup immediately containing this ActivityGroup, if it is directly owned by another ActivityGroup.
	 * <!-- end-user-doc -->
	 */
	def superGroup: Option[UMLActivityGroup[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLActivityGroup
