package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ControlNode is an abstract ActivityNode that coordinates flows in an Activity.
 * <!-- end-user-doc --> 
 */
trait UMLControlNode[Uml <: UML]
  extends UMLActivityNode[Uml] with operations.UMLControlNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		controlNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLControlNode
	 */
	def controlNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		activityNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		controlNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLControlNode
	 */
	def controlNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		controlNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLControlNode
	 */
	def controlNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		controlNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLControlNode
	 */
	def controlNode_forwardReferencesFromMetamodelAssociations: Elements =
		activityNode_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLControlNode
