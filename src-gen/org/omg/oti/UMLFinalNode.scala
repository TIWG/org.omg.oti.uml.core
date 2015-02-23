package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A FinalNode is an abstract ControlNode at which a flow in an Activity stops.
 * <!-- end-user-doc --> 
 */
trait UMLFinalNode[Uml <: UML]
  extends UMLControlNode[Uml] with operations.UMLFinalNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		finalNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLFinalNode
	 */
	def finalNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		controlNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		finalNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLFinalNode
	 */
	def finalNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		controlNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		finalNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLFinalNode
	 */
	def finalNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		controlNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		finalNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLFinalNode
	 */
	def finalNode_forwardReferencesFromMetamodelAssociations: Elements =
		controlNode_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLFinalNode
