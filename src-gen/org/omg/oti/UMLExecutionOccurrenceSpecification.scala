package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ExecutionOccurrenceSpecification represents moments in time at which Actions or Behaviors start or finish.
 * <!-- end-user-doc --> 
 */
trait UMLExecutionOccurrenceSpecification[Uml <: UML]
  extends UMLOccurrenceSpecification[Uml] with operations.UMLExecutionOccurrenceSpecificationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		executionOccurrenceSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExecutionOccurrenceSpecification
	 */
	def executionOccurrenceSpecification_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		occurrenceSpecification_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		executionOccurrenceSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExecutionOccurrenceSpecification
	 */
	def executionOccurrenceSpecification_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		occurrenceSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		executionOccurrenceSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExecutionOccurrenceSpecification
	 */
	def executionOccurrenceSpecification_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		occurrenceSpecification_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLExecutionOccurrenceSpecification[Uml], UMLExecutionSpecification[Uml]]("execution", _.execution)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		executionOccurrenceSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExecutionOccurrenceSpecification
	 */
	def executionOccurrenceSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		occurrenceSpecification_forwardReferencesFromMetamodelAssociations ++
		execution 

	/**
	 * <!-- begin-user-doc --> 
	 * References the execution specification describing the execution that is started or finished at this execution event.
	 * <!-- end-user-doc -->
	 */
	def execution: Option[UMLExecutionSpecification[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLExecutionOccurrenceSpecification
