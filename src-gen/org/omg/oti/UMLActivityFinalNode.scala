package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ActivityFinalNode is a FinalNode that terminates the execution of its owning Activity or StructuredActivityNode.
 * <!-- end-user-doc --> 
 */
trait UMLActivityFinalNode[Uml <: UML]
  extends UMLFinalNode[Uml] with operations.UMLActivityFinalNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activityFinalNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivityFinalNode
	 */
	def activityFinalNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		finalNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activityFinalNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivityFinalNode
	 */
	def activityFinalNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		finalNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activityFinalNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivityFinalNode
	 */
	def activityFinalNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		finalNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activityFinalNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivityFinalNode
	 */
	def activityFinalNode_forwardReferencesFromMetamodelAssociations: Elements =
		finalNode_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLActivityFinalNode
