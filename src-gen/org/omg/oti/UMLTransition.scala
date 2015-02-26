package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Transition represents an arc between exactly one source Vertex and exactly one Target vertex (the source and targets may be the same Vertex). It may form part of a compound transition, which takes the StateMachine from one steady State configuration to another, representing the full response of the StateMachine to an occurrence of an Event that triggered it.
 * <!-- end-user-doc --> 
 */
trait UMLTransition[Uml <: UML]
  extends UMLRedefinableElement[Uml] with UMLNamespace[Uml] with operations.UMLTransitionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		transition_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTransition
	 */
	def transition_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		redefinableElement_metaAttributes,
		namespace_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		transition_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTransition
	 */
	def transition_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_compositeMetaProperties,
		namespace_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLTransition[Uml], UMLBehavior[Uml]]("effect", _.effect),
		  	MetaPropertyReference[Uml, UMLTransition[Uml], UMLConstraint[Uml]]("guard", _.guard),
		  	MetaPropertyCollection[Uml, UMLTransition[Uml], UMLTrigger[Uml]]("trigger", _.trigger)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		transition_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTransition
	 */
	def transition_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_referenceMetaProperties,
		namespace_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLTransition[Uml], UMLRegion[Uml]]("container", _.container),
		  	MetaPropertyReference[Uml, UMLTransition[Uml], UMLTransition[Uml]]("redefinedTransition", _.redefinedTransition),
		  	MetaPropertyReference[Uml, UMLTransition[Uml], UMLVertex[Uml]]("source", _.source),
		  	MetaPropertyReference[Uml, UMLTransition[Uml], UMLVertex[Uml]]("target", _.target)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		transition_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTransition
	 */
	def transition_forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		namespace_forwardReferencesFromMetamodelAssociations ++
		container ++
		redefinedTransition ++
		source ++
		target 

	/**
	 * <!-- begin-user-doc --> 
	 * Designates the Region that owns this Transition.
	 * <!-- end-user-doc -->
	 */
	def container: Option[UMLRegion[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies an optional behavior to be performed when the Transition fires.
	 * <!-- end-user-doc -->
	 */
	def effect: Option[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A guard is a Constraint that provides a fine-grained control over the firing of the Transition. The guard is evaluated when an Event occurrence is dispatched by the StateMachine. If the guard is true at that time, the Transition may be enabled, otherwise, it is disabled. Guards should be pure expressions without side effects. Guard expressions with side effects are ill formed.
	 * <!-- end-user-doc -->
	 */
	def guard: Option[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates the precise type of the Transition.
	 * <!-- end-user-doc -->
	 */
	def kind: UMLTransitionKind.Value = UMLTransitionKind.external

	/**
	 * <!-- begin-user-doc --> 
	 * The Transition that is redefined by this Transition.
	 * <!-- end-user-doc -->
	 */
	def redefinedTransition: Option[UMLTransition[Uml]] 

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
	 * Designates the originating Vertex (State or Pseudostate) of the Transition.
	 * <!-- end-user-doc -->
	 */
	def source: Option[UMLVertex[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Designates the target Vertex that is reached when the Transition is taken.
	 * <!-- end-user-doc -->
	 */
	def target: Option[UMLVertex[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the Triggers that may fire the transition.
	 * <!-- end-user-doc -->
	 */
	def trigger: Set[UMLTrigger[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinedTransition_transition: Set[UMLTransition[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLTransition
