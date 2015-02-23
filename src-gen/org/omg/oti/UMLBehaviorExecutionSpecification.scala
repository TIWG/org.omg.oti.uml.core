package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A BehaviorExecutionSpecification is a kind of ExecutionSpecification representing the execution of a Behavior.
 * <!-- end-user-doc --> 
 */
trait UMLBehaviorExecutionSpecification[Uml <: UML]
  extends UMLExecutionSpecification[Uml] with operations.UMLBehaviorExecutionSpecificationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		behaviorExecutionSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLBehaviorExecutionSpecification
	 */
	def behaviorExecutionSpecification_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		executionSpecification_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		behaviorExecutionSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLBehaviorExecutionSpecification
	 */
	def behaviorExecutionSpecification_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		executionSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		behaviorExecutionSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLBehaviorExecutionSpecification
	 */
	def behaviorExecutionSpecification_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		executionSpecification_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLBehaviorExecutionSpecification[Uml], UMLBehavior[Uml]]("behavior", _.behavior)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		behaviorExecutionSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLBehaviorExecutionSpecification
	 */
	def behaviorExecutionSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		executionSpecification_forwardReferencesFromMetamodelAssociations ++
		behavior 

	/**
	 * <!-- begin-user-doc --> 
	 * Behavior whose execution is occurring.
	 * <!-- end-user-doc -->
	 */
	def behavior: Option[UMLBehavior[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLBehaviorExecutionSpecification
