package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A State models a situation during which some (usually implicit) invariant condition holds.
 * <!-- end-user-doc --> 
 */
trait UMLState[Uml <: UML]
  extends UMLRedefinableElement[Uml] with UMLNamespace[Uml] with UMLVertex[Uml] with operations.UMLStateOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		state_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLState
	 */
	def state_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		redefinableElement_metaAttributes,
		namespace_metaAttributes,
		vertex_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		state_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLState
	 */
	def state_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_compositeMetaProperties,
		namespace_compositeMetaProperties,
		vertex_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLState[Uml], UMLConnectionPointReference[Uml]]("connection", _.connection),
		  	MetaPropertyCollection[Uml, UMLState[Uml], UMLPseudostate[Uml]]("connectionPoint", _.connectionPoint),
		  	MetaPropertyCollection[Uml, UMLState[Uml], UMLTrigger[Uml]]("deferrableTrigger", _.deferrableTrigger),
		  	MetaPropertyReference[Uml, UMLState[Uml], UMLBehavior[Uml]]("doActivity", _.doActivity),
		  	MetaPropertyReference[Uml, UMLState[Uml], UMLBehavior[Uml]]("entry", _.entry),
		  	MetaPropertyReference[Uml, UMLState[Uml], UMLBehavior[Uml]]("exit", _.exit),
		  	MetaPropertyCollection[Uml, UMLState[Uml], UMLRegion[Uml]]("region", _.region),
		  	MetaPropertyReference[Uml, UMLState[Uml], UMLConstraint[Uml]]("stateInvariant", _.stateInvariant)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		state_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLState
	 */
	def state_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_referenceMetaProperties,
		namespace_referenceMetaProperties,
		vertex_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLState[Uml], UMLState[Uml]]("redefinedState", _.redefinedState),
		  	MetaPropertyReference[Uml, UMLState[Uml], UMLStateMachine[Uml]]("submachine", _.submachine)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		state_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLState
	 */
	def state_forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		namespace_forwardReferencesFromMetamodelAssociations ++
		vertex_forwardReferencesFromMetamodelAssociations ++
		redefinedState ++
		submachine 

	/**
	 * <!-- begin-user-doc --> 
	 * The entry and exit connection points used in conjunction with this (submachine) State, i.e., as targets and sources, respectively, in the Region with the submachine State. A connection point reference references the corresponding definition of a connection point Pseudostate in the StateMachine referenced by the submachine State.
	 * <!-- end-user-doc -->
	 */
	def connection: Set[UMLConnectionPointReference[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The entry and exit Pseudostates of a composite State. These can only be entry or exit Pseudostates, and they must have different names. They can only be defined for composite States.
	 * <!-- end-user-doc -->
	 */
	def connectionPoint: Set[UMLPseudostate[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A list of Triggers that are candidates to be retained by the StateMachine if they trigger no Transitions out of the State (not consumed). A deferred Trigger is retained until the StateMachine reaches a State configuration where it is no longer deferred.
	 * <!-- end-user-doc -->
	 */
	def deferrableTrigger: Set[UMLTrigger[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An optional Behavior that is executed while being in the State. The execution starts when this State is entered, and ceases either by itself when done, or when the State is exited, whichever comes first.
	 * <!-- end-user-doc -->
	 */
	def doActivity: Option[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An optional Behavior that is executed whenever this State is entered regardless of the Transition taken to reach the State. If defined, entry Behaviors are always executed to completion prior to any internal Behavior or Transitions performed within the State.
	 * <!-- end-user-doc -->
	 */
	def entry: Option[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An optional Behavior that is executed whenever this State is exited regardless of which Transition was taken out of the State. If defined, exit Behaviors are always executed to completion only after all internal and transition Behaviors have completed execution.
	 * <!-- end-user-doc -->
	 */
	def exit: Option[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A state with isComposite=true is said to be a composite State. A composite State is a State that contains at least one Region.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (region->notEmpty())
	 */
	def isComposite: Boolean = {
	    // Start of user code for "isComposite"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * A State with isOrthogonal=true is said to be an orthogonal composite State An orthogonal composite State contains two or more Regions.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (region->size () > 1)
	 */
	def isOrthogonal: Boolean = {
	    // Start of user code for "isOrthogonal"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * A State with isSimple=true is said to be a simple State A simple State does not have any Regions and it does not refer to any submachine StateMachine.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = ((region->isEmpty()) and not isSubmachineState())
	 */
	def isSimple: Boolean = {
	    // Start of user code for "isSimple"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * A State with isSubmachineState=true is said to be a submachine State Such a State refers to another StateMachine(submachine).
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (submachine <> null)
	 */
	def isSubmachineState: Boolean = {
	    // Start of user code for "isSubmachineState"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * The State of which this State is a redefinition.
	 * <!-- end-user-doc -->
	 */
	def redefinedState: Option[UMLState[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Classifier in which context this element may be redefined.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (let sm : StateMachine = containingStateMachine() in
	 * if sm._'context' = null or sm.general->notEmpty() then
	 *   sm
	 * else
	 *   sm._'context'
	 * endif)
	 */
	override def redefinitionContext: Iterable[UMLClassifier[Uml]] = {
	    // Start of user code for "redefinitionContext"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * The Regions owned directly by the State.
	 * <!-- end-user-doc -->
	 */
	def region: Set[UMLRegion[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies conditions that are always true when this State is the current State. In ProtocolStateMachines state invariants are additional conditions to the preconditions of the outgoing Transitions, and to the postcondition of the incoming Transitions.
	 * <!-- end-user-doc -->
	 */
	def stateInvariant: Option[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The StateMachine that is to be inserted in place of the (submachine) State.
	 * <!-- end-user-doc -->
	 */
	def submachine: Option[UMLStateMachine[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def inState_objectNode: Set[UMLObjectNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinedState_state: Set[UMLState[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLState
