package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * Behavior is a specification of how its context BehavioredClassifier changes state over time. This specification may be either a definition of possible behavior execution or emergent behavior, or a selective illustration of an interesting subset of possible executions. The latter form is typically used for capturing examples, such as a trace of a particular execution.
 * <!-- end-user-doc --> 
 */
trait UMLBehavior[Uml <: UML]
  extends UMLClass[Uml] with operations.UMLBehaviorOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		behavior_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLBehavior
	 */
	def behavior_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		class_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLBehavior[Uml]](None, "isReentrant", (x) => booleanToIterable(x.isReentrant, true))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		behavior_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLBehavior
	 */
	def behavior_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		class_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLBehavior[Uml], UMLParameter[Uml]]("ownedParameter", _.ownedParameter),
		  	MetaPropertyCollection[UMLBehavior[Uml], UMLParameterSet[Uml]]("ownedParameterSet", _.ownedParameterSet),
		  	MetaPropertyCollection[UMLBehavior[Uml], UMLConstraint[Uml]]("postcondition", _.postcondition),
		  	MetaPropertyCollection[UMLBehavior[Uml], UMLConstraint[Uml]]("precondition", _.precondition)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		behavior_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLBehavior
	 */
	def behavior_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		class_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLBehavior[Uml], UMLBehavioralFeature[Uml]]("specification", _.specification),
		  	MetaPropertyCollection[UMLBehavior[Uml], UMLBehavior[Uml]]("redefinedBehavior", _.redefinedBehavior)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		behavior_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLBehavior
	 */
	def behavior_forwardReferencesFromMetamodelAssociations: Elements =
		class_forwardReferencesFromMetamodelAssociations ++
		specification ++
		redefinedBehavior 

	/**
	 * <!-- begin-user-doc --> 
	 * The BehavioredClassifier that is the context for the execution of the Behavior. A Behavior that is directly owned as a nestedClassifier does not have a context. Otherwise, to determine the context of a Behavior, find the first BehavioredClassifier reached by following the chain of owner relationships from the Behavior, if any. If there is such a BehavioredClassifier, then it is the context, unless it is itself a Behavior with a non-empty context, in which case that is also the context for the original Behavior. For example, following this algorithm, the context of an entry Behavior in a StateMachine is the BehavioredClassifier that owns the StateMachine. The features of the context BehavioredClassifier as well as the Elements visible to the context Classifier are visible to the Behavior.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if nestingClass <> null then
	 *     null
	 * else
	 *     let b:BehavioredClassifier = self.behavioredClassifier(self.owner) in
	 *     if b.oclIsKindOf(Behavior) and b.oclAsType(Behavior)._'context' <> null then 
	 *         b.oclAsType(Behavior)._'context'
	 *     else 
	 *         b 
	 *     endif
	 * endif
	 *         )
	 */
	def context: Option[UMLBehavioredClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * Tells whether the Behavior can be invoked while it is still executing from a previous invocation.
	 * <!-- end-user-doc -->
	 */
	def isReentrant: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * References a list of Parameters to the Behavior which describes the order and type of arguments that can be given when the Behavior is invoked and of the values which will be returned when the Behavior completes its execution.
	 * <!-- end-user-doc -->
	 */
	def ownedParameter: Seq[UMLParameter[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ParameterSets owned by this Behavior.
	 * <!-- end-user-doc -->
	 */
	def ownedParameterSet: Set[UMLParameterSet[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An optional set of Constraints specifying what is fulfilled after the execution of the Behavior is completed, if its precondition was fulfilled before its invocation.
	 * <!-- end-user-doc -->
	 */
	def postcondition: Set[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An optional set of Constraints specifying what must be fulfilled before the Behavior is invoked.
	 * <!-- end-user-doc -->
	 */
	def precondition: Set[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Designates a BehavioralFeature that the Behavior implements. The BehavioralFeature must be owned by the BehavioredClassifier that owns the Behavior or be inherited by it. The Parameters of the BehavioralFeature and the implementing Behavior must match. A Behavior does not need to have a specification, in which case it either is the classifierBehavior of a BehavioredClassifier or it can only be invoked by another Behavior of the Classifier.
	 * <!-- end-user-doc -->
	 */
	def specification: Option[UMLBehavioralFeature[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Behavior that this Behavior redefines. A subtype of Behavior may redefine any other subtype of Behavior. If the Behavior implements a BehavioralFeature, it replaces the redefined Behavior. If the Behavior is a classifierBehavior, it extends the redefined Behavior.
	 * <!-- end-user-doc -->
	 */
	def redefinedBehavior: Iterable[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def entry_state: Option[UMLState[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def selection_objectFlow: Set[UMLObjectFlow[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def behavior_callBehaviorAction: Set[UMLCallBehaviorAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def behavior_behaviorExecutionSpecification: Set[UMLBehaviorExecutionSpecification[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def exit_state: Option[UMLState[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def decisionInput_decisionNode: Set[UMLDecisionNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def reducer_reduceAction: Set[UMLReduceAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def selection_objectNode: Set[UMLObjectNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def doActivity_state: Option[UMLState[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def effect_transition: Option[UMLTransition[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def transformation_objectFlow: Set[UMLObjectFlow[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def classifierBehavior_behavioredClassifier: Option[UMLBehavioredClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinedBehavior_behavior: Set[UMLBehavior[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def behavior_opaqueExpression: Set[UMLOpaqueExpression[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def contract_connector: Set[UMLConnector[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedBehavior_behavioredClassifier: Option[UMLBehavioredClassifier[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLBehavior
