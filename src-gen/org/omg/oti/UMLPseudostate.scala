package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Pseudostate is an abstraction that encompasses different types of transient Vertices in the StateMachine graph. A StateMachine instance never comes to rest in a Pseudostate, instead, it will exit and enter the Pseudostate within a single run-to-completion step.
 * <!-- end-user-doc --> 
 */
trait UMLPseudostate[Uml <: UML]
  extends UMLVertex[Uml] with operations.UMLPseudostateOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		pseudostate_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPseudostate
	 */
	def pseudostate_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		vertex_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		pseudostate_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPseudostate
	 */
	def pseudostate_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		vertex_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		pseudostate_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPseudostate
	 */
	def pseudostate_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		vertex_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLPseudostate[Uml], UMLState[Uml]]("state", _.state),
		  	MetaPropertyReference[Uml, UMLPseudostate[Uml], UMLStateMachine[Uml]]("stateMachine", _.stateMachine)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		pseudostate_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPseudostate
	 */
	def pseudostate_forwardReferencesFromMetamodelAssociations: Elements =
		vertex_forwardReferencesFromMetamodelAssociations ++
		state ++
		stateMachine 

	/**
	 * <!-- begin-user-doc --> 
	 * Determines the precise type of the Pseudostate and can be one of: entryPoint, exitPoint, initial, deepHistory, shallowHistory, join, fork, junction, terminate or choice.
	 * <!-- end-user-doc -->
	 */
	def kind: UMLPseudostateKind.Value

	/**
	 * <!-- begin-user-doc --> 
	 * The State that owns this Pseudostate and in which it appears.
	 * <!-- end-user-doc -->
	 */
	def state: Option[UMLState[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The StateMachine in which this Pseudostate is defined. This only applies to Pseudostates of the kind entryPoint or exitPoint.
	 * <!-- end-user-doc -->
	 */
	def stateMachine: Option[UMLStateMachine[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def entry_connectionPointReference: Option[UMLConnectionPointReference[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def exit_connectionPointReference: Option[UMLConnectionPointReference[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLPseudostate
