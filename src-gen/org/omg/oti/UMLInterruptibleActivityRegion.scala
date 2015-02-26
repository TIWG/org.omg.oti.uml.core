package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An InterruptibleActivityRegion is an ActivityGroup that supports the termination of tokens flowing in the portions of an activity within it.
 * <!-- end-user-doc --> 
 */
trait UMLInterruptibleActivityRegion[Uml <: UML]
  extends UMLActivityGroup[Uml] with operations.UMLInterruptibleActivityRegionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interruptibleActivityRegion_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInterruptibleActivityRegion
	 */
	def interruptibleActivityRegion_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		activityGroup_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interruptibleActivityRegion_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInterruptibleActivityRegion
	 */
	def interruptibleActivityRegion_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityGroup_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interruptibleActivityRegion_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInterruptibleActivityRegion
	 */
	def interruptibleActivityRegion_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityGroup_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLInterruptibleActivityRegion[Uml], UMLActivityEdge[Uml]]("interruptingEdge", _.interruptingEdge),
		  	MetaPropertyCollection[Uml, UMLInterruptibleActivityRegion[Uml], UMLActivityNode[Uml]]("node", _.node)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interruptibleActivityRegion_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInterruptibleActivityRegion
	 */
	def interruptibleActivityRegion_forwardReferencesFromMetamodelAssociations: Elements =
		activityGroup_forwardReferencesFromMetamodelAssociations ++
		interruptingEdge ++
		node 

	/**
	 * <!-- begin-user-doc --> 
	 * The ActivityEdges leaving the InterruptibleActivityRegion on which a traversing token will result in the termination of other tokens flowing in the InterruptibleActivityRegion.
	 * <!-- end-user-doc -->
	 */
	def interruptingEdge: Set[UMLActivityEdge[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityNodes immediately contained in the InterruptibleActivityRegion.
	 * <!-- end-user-doc -->
	 */
	def node: Set[UMLActivityNode[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLInterruptibleActivityRegion
