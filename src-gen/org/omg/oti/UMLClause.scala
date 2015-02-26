package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Clause is an Element that represents a single branch of a ConditionalNode, including a test and a body section. The body section is executed only if (but not necessarily if) the test section evaluates to true.
 * <!-- end-user-doc --> 
 */
trait UMLClause[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLClauseOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		clause_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLClause
	 */
	def clause_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		clause_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLClause
	 */
	def clause_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		clause_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLClause
	 */
	def clause_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLClause[Uml], UMLExecutableNode[Uml]]("body", _.body),
		  	MetaPropertyCollection[Uml, UMLClause[Uml], UMLOutputPin[Uml]]("bodyOutput", _.bodyOutput),
		  	MetaPropertyReference[Uml, UMLClause[Uml], UMLOutputPin[Uml]]("decider", _.decider),
		  	MetaPropertyCollection[Uml, UMLClause[Uml], UMLClause[Uml]]("predecessorClause", _.predecessorClause),
		  	MetaPropertyCollection[Uml, UMLClause[Uml], UMLClause[Uml]]("successorClause", _.successorClause),
		  	MetaPropertyCollection[Uml, UMLClause[Uml], UMLExecutableNode[Uml]]("test", _.test)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		clause_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLClause
	 */
	def clause_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		body ++
		bodyOutput ++
		decider ++
		predecessorClause ++
		successorClause ++
		test 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of ExecutableNodes that are executed if the test evaluates to true and the Clause is chosen over other Clauses within the ConditionalNode that also have tests that evaluate to true.
	 * <!-- end-user-doc -->
	 */
	def body: Set[UMLExecutableNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPins on Actions within the body section whose values are moved to the result OutputPins of the containing ConditionalNode after execution of the body.
	 * <!-- end-user-doc -->
	 */
	def bodyOutput: Seq[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An OutputPin on an Action in the test section whose Boolean value determines the result of the test.
	 * <!-- end-user-doc -->
	 */
	def decider: Option[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A set of Clauses whose tests must all evaluate to false before this Clause can evaluate its test.
	 * <!-- end-user-doc -->
	 */
	def predecessorClause: Set[UMLClause[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A set of Clauses that may not evaluate their tests unless the test for this Clause evaluates to false.
	 * <!-- end-user-doc -->
	 */
	def successorClause: Set[UMLClause[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of ExecutableNodes that are executed in order to provide a test result for the Clause.
	 * <!-- end-user-doc -->
	 */
	def test: Set[UMLExecutableNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def clause_conditionalNode: Option[UMLConditionalNode[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLClause
