package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A LoopNode is a StructuredActivityNode that represents an iterative loop with setup, test, and body sections.
 * <!-- end-user-doc --> 
 */
trait UMLLoopNode[Uml <: UML]
  extends UMLStructuredActivityNode[Uml] with operations.UMLLoopNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		loopNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLoopNode
	 */
	def loopNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		structuredActivityNode_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLLoopNode[Uml]](None, "isTestedFirst", (x) => booleanToIterable(x.isTestedFirst, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		loopNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLoopNode
	 */
	def loopNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuredActivityNode_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLLoopNode[Uml], UMLOutputPin[Uml]]("loopVariable", _.loopVariable),
		  	MetaPropertyCollection[UMLLoopNode[Uml], UMLInputPin[Uml]]("loopVariableInput", _.loopVariableInput),
		  	MetaPropertyCollection[UMLLoopNode[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		loopNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLoopNode
	 */
	def loopNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuredActivityNode_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLLoopNode[Uml], UMLOutputPin[Uml]]("bodyOutput", _.bodyOutput),
		  	MetaPropertyCollection[UMLLoopNode[Uml], UMLExecutableNode[Uml]]("bodyPart", _.bodyPart),
		  	MetaPropertyReference[UMLLoopNode[Uml], UMLOutputPin[Uml]]("decider", _.decider),
		  	MetaPropertyCollection[UMLLoopNode[Uml], UMLExecutableNode[Uml]]("setupPart", _.setupPart),
		  	MetaPropertyCollection[UMLLoopNode[Uml], UMLExecutableNode[Uml]]("test", _.test)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		loopNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLoopNode
	 */
	def loopNode_forwardReferencesFromMetamodelAssociations: Elements =
		structuredActivityNode_forwardReferencesFromMetamodelAssociations ++
		bodyOutput ++
		bodyPart ++
		decider ++
		setupPart ++
		test 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPins on Actions within the bodyPart, the values of which are moved to the loopVariable OutputPins after the completion of each execution of the bodyPart, before the next iteration of the loop begins or before the loop exits.
	 * <!-- end-user-doc -->
	 */
	def bodyOutput: Seq[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of ExecutableNodes that perform the repetitive computations of the loop. The bodyPart is executed as long as the test section produces a true value.
	 * <!-- end-user-doc -->
	 */
	def bodyPart: Set[UMLExecutableNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An OutputPin on an Action in the test section whose Boolean value determines whether to continue executing the loop bodyPart.
	 * <!-- end-user-doc -->
	 */
	def decider: Option[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * If true, the test is performed before the first execution of the bodyPart. If false, the bodyPart is executed once before the test is performed.
	 * <!-- end-user-doc -->
	 */
	def isTestedFirst: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * A list of OutputPins that hold the values of the loop variables during an execution of the loop. When the test fails, the values are moved to the result OutputPins of the loop.
	 * <!-- end-user-doc -->
	 */
	def loopVariable: Seq[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A list of InputPins whose values are moved into the loopVariable Pins before the first iteration of the loop.
	 * <!-- end-user-doc -->
	 */
	def loopVariableInput: Iterable[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A list of OutputPins that receive the loopVariable values after the last iteration of the loop and constitute the output of the LoopNode.
	 * <!-- end-user-doc -->
	 */
	def result: Iterable[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of ExecutableNodes executed before the first iteration of the loop, in order to initialize values or perform other setup computations.
	 * <!-- end-user-doc -->
	 */
	def setupPart: Set[UMLExecutableNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of ExecutableNodes executed in order to provide the test result for the loop.
	 * <!-- end-user-doc -->
	 */
	def test: Set[UMLExecutableNode[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLLoopNode
