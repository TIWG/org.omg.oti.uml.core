package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ActivityParameterNode is an ObjectNode for accepting values from the input Parameters or providing values to the output Parameters of an Activity.
 * <!-- end-user-doc --> 
 */
trait UMLActivityParameterNode[Uml <: UML]
  extends UMLObjectNode[Uml] with operations.UMLActivityParameterNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activityParameterNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivityParameterNode
	 */
	def activityParameterNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		objectNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activityParameterNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivityParameterNode
	 */
	def activityParameterNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		objectNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activityParameterNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivityParameterNode
	 */
	def activityParameterNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		objectNode_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLActivityParameterNode[Uml], UMLParameter[Uml]]("parameter", _.parameter)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activityParameterNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivityParameterNode
	 */
	def activityParameterNode_forwardReferencesFromMetamodelAssociations: Elements =
		objectNode_forwardReferencesFromMetamodelAssociations ++
		parameter 

	/**
	 * <!-- begin-user-doc --> 
	 * The Parameter for which the ActivityParameterNode will be accepting or providing values.
	 * <!-- end-user-doc -->
	 */
	def parameter: Option[UMLParameter[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLActivityParameterNode
