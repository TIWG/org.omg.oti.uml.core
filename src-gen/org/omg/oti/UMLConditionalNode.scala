package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ConditionalNode is a StructuredActivityNode that chooses one among some number of alternative collections of ExecutableNodes to execute.
 * <!-- end-user-doc --> 
 */
trait UMLConditionalNode[Uml <: UML]
  extends UMLStructuredActivityNode[Uml] with operations.UMLConditionalNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		conditionalNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConditionalNode
	 */
	def conditionalNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		structuredActivityNode_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLConditionalNode[Uml]](None, "isAssured", (x) => booleanToIterable(x.isAssured, false)),
		  	MetaAttributeBooleanFunction[UMLConditionalNode[Uml]](None, "isDeterminate", (x) => booleanToIterable(x.isDeterminate, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		conditionalNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConditionalNode
	 */
	def conditionalNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuredActivityNode_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLConditionalNode[Uml], UMLClause[Uml]]("clause", _.clause),
		  	MetaPropertyCollection[UMLConditionalNode[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		conditionalNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConditionalNode
	 */
	def conditionalNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuredActivityNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		conditionalNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConditionalNode
	 */
	def conditionalNode_forwardReferencesFromMetamodelAssociations: Elements =
		structuredActivityNode_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of Clauses composing the ConditionalNode.
	 * <!-- end-user-doc -->
	 */
	def clause: Set[UMLClause[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * If true, the modeler asserts that the test for at least one Clause of the ConditionalNode will succeed.
	 * <!-- end-user-doc -->
	 */
	def isAssured: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * If true, the modeler asserts that the test for at most one Clause of the ConditionalNode will succeed.
	 * <!-- end-user-doc -->
	 */
	def isDeterminate: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPins that onto which are moved values from the bodyOutputs of the Clause selected for execution.
	 * <!-- end-user-doc -->
	 */
	def result: Iterable[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLConditionalNode
