package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A FunctionBehavior is an OpaqueBehavior that does not access or modify any objects or other external data.
 * <!-- end-user-doc --> 
 */
trait UMLFunctionBehavior[Uml <: UML]
  extends UMLOpaqueBehavior[Uml] with operations.UMLFunctionBehaviorOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		functionBehavior_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLFunctionBehavior
	 */
	def functionBehavior_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		opaqueBehavior_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		functionBehavior_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLFunctionBehavior
	 */
	def functionBehavior_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		opaqueBehavior_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		functionBehavior_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLFunctionBehavior
	 */
	def functionBehavior_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		opaqueBehavior_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		functionBehavior_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLFunctionBehavior
	 */
	def functionBehavior_forwardReferencesFromMetamodelAssociations: Elements =
		opaqueBehavior_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLFunctionBehavior
