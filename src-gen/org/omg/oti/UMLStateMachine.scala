package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * StateMachines can be used to express event-driven behaviors of parts of a system. Behavior is modeled as a traversal of a graph of Vertices interconnected by one or more joined Transition arcs that are triggered by the dispatching of successive Event occurrences. During this traversal, the StateMachine may execute a sequence of Behaviors associated with various elements of the StateMachine.
 * <!-- end-user-doc --> 
 */
trait UMLStateMachine[Uml <: UML]
  extends UMLBehavior[Uml] with operations.UMLStateMachineOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		stateMachine_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStateMachine
	 */
	def stateMachine_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		behavior_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		stateMachine_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStateMachine
	 */
	def stateMachine_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		behavior_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLStateMachine[Uml], UMLPseudostate[Uml]]("connectionPoint", _.connectionPoint),
		  	MetaPropertyCollection[UMLStateMachine[Uml], UMLRegion[Uml]]("region", _.region)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		stateMachine_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStateMachine
	 */
	def stateMachine_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		behavior_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLStateMachine[Uml], UMLStateMachine[Uml]]("extendedStateMachine", _.extendedStateMachine),
		  	MetaPropertyCollection[UMLStateMachine[Uml], UMLState[Uml]]("submachineState", _.submachineState)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		stateMachine_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStateMachine
	 */
	def stateMachine_forwardReferencesFromMetamodelAssociations: Elements =
		behavior_forwardReferencesFromMetamodelAssociations ++
		extendedStateMachine ++
		submachineState 

	/**
	 * <!-- begin-user-doc --> 
	 * The connection points defined for this StateMachine. They represent the interface of the StateMachine when used as part of submachine State
	 * <!-- end-user-doc -->
	 */
	def connectionPoint: Set[UMLPseudostate[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The StateMachines of which this is an extension.
	 * <!-- end-user-doc -->
	 */
	def extendedStateMachine: Iterable[UMLStateMachine[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Regions owned directly by the StateMachine.
	 * <!-- end-user-doc -->
	 */
	def region: Set[UMLRegion[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the submachine(s) in case of a submachine State. Multiple machines are referenced in case of a concurrent State.
	 * <!-- end-user-doc -->
	 */
	def submachineState: Set[UMLState[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def extendedStateMachine_stateMachine: Set[UMLStateMachine[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLStateMachine
