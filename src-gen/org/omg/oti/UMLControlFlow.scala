package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ControlFlow is an ActivityEdge traversed by control tokens or object tokens of control type, which are use to control the execution of ExecutableNodes.
 * <!-- end-user-doc --> 
 */
trait UMLControlFlow[Uml <: UML]
  extends UMLActivityEdge[Uml] with operations.UMLControlFlowOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		controlFlow_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLControlFlow
	 */
	def controlFlow_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		activityEdge_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		controlFlow_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLControlFlow
	 */
	def controlFlow_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityEdge_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		controlFlow_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLControlFlow
	 */
	def controlFlow_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityEdge_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		controlFlow_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLControlFlow
	 */
	def controlFlow_forwardReferencesFromMetamodelAssociations: Elements =
		activityEdge_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLControlFlow
