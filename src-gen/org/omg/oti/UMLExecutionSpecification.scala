package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ExecutionSpecification is a specification of the execution of a unit of Behavior or Action within the Lifeline. The duration of an ExecutionSpecification is represented by two OccurrenceSpecifications, the start OccurrenceSpecification and the finish OccurrenceSpecification.
 * <!-- end-user-doc --> 
 */
trait UMLExecutionSpecification[Uml <: UML]
  extends UMLInteractionFragment[Uml] with operations.UMLExecutionSpecificationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		executionSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExecutionSpecification
	 */
	def executionSpecification_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		interactionFragment_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		executionSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExecutionSpecification
	 */
	def executionSpecification_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		executionSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExecutionSpecification
	 */
	def executionSpecification_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLExecutionSpecification[Uml], UMLOccurrenceSpecification[Uml]]("finish", _.finish),
		  	MetaPropertyReference[Uml, UMLExecutionSpecification[Uml], UMLOccurrenceSpecification[Uml]]("start", _.start)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		executionSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExecutionSpecification
	 */
	def executionSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations ++
		finish ++
		start 

	/**
	 * <!-- begin-user-doc --> 
	 * References the OccurrenceSpecification that designates the finish of the Action or Behavior.
	 * <!-- end-user-doc -->
	 */
	def finish: Option[UMLOccurrenceSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the OccurrenceSpecification that designates the start of the Action or Behavior.
	 * <!-- end-user-doc -->
	 */
	def start: Option[UMLOccurrenceSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def execution_executionOccurrenceSpecification: Set[UMLExecutionOccurrenceSpecification[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLExecutionSpecification
