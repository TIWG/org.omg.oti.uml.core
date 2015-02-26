package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ActionExecutionSpecification is a kind of ExecutionSpecification representing the execution of an Action.
 * <!-- end-user-doc --> 
 */
trait UMLActionExecutionSpecification[Uml <: UML]
  extends UMLExecutionSpecification[Uml] with operations.UMLActionExecutionSpecificationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		actionExecutionSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActionExecutionSpecification
	 */
	def actionExecutionSpecification_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		executionSpecification_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		actionExecutionSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActionExecutionSpecification
	 */
	def actionExecutionSpecification_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		executionSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		actionExecutionSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActionExecutionSpecification
	 */
	def actionExecutionSpecification_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		executionSpecification_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLActionExecutionSpecification[Uml], UMLAction[Uml]]("action", _.action)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		actionExecutionSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActionExecutionSpecification
	 */
	def actionExecutionSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		executionSpecification_forwardReferencesFromMetamodelAssociations ++
		action 

	/**
	 * <!-- begin-user-doc --> 
	 * Action whose execution is occurring.
	 * <!-- end-user-doc -->
	 */
	def action: Option[UMLAction[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLActionExecutionSpecification
