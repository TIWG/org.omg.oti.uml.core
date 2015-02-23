package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A FlowFinalNode is a FinalNode that terminates a flow by consuming the tokens offered to it.
 * <!-- end-user-doc --> 
 */
trait UMLFlowFinalNode[Uml <: UML]
  extends UMLFinalNode[Uml] with operations.UMLFlowFinalNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		flowFinalNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLFlowFinalNode
	 */
	def flowFinalNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		finalNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		flowFinalNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLFlowFinalNode
	 */
	def flowFinalNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		finalNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		flowFinalNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLFlowFinalNode
	 */
	def flowFinalNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		finalNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		flowFinalNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLFlowFinalNode
	 */
	def flowFinalNode_forwardReferencesFromMetamodelAssociations: Elements =
		finalNode_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLFlowFinalNode
