package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An Action is the fundamental unit of executable functionality. The execution of an Action represents some transformation or processing in the modeled system. Actions provide the ExecutableNodes within Activities and may also be used within Interactions.
 * <!-- end-user-doc --> 
 */
trait UMLAction[Uml <: UML]
  extends UMLExecutableNode[Uml] with operations.UMLActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		action_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAction
	 */
	def action_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		executableNode_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLAction[Uml]](None, "isLocallyReentrant", (x) => booleanToIterable(x.isLocallyReentrant, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		action_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAction
	 */
	def action_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		executableNode_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLAction[Uml], UMLConstraint[Uml]]("localPostcondition", _.localPostcondition),
		  	MetaPropertyCollection[UMLAction[Uml], UMLConstraint[Uml]]("localPrecondition", _.localPrecondition)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		action_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAction
	 */
	def action_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		executableNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAction
	 */
	def action_forwardReferencesFromMetamodelAssociations: Elements =
		executableNode_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The context Classifier of the Behavior that contains this Action, or the Behavior itself if it has no context.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (let behavior: Behavior = self.containingBehavior() in
	 * if behavior=null then null
	 * else if behavior._'context' = null then behavior
	 * else behavior._'context'
	 * endif
	 * endif)
	 */
	def context: Option[UMLClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * The ordered set of InputPins representing the inputs to the Action.
	 * <!-- end-user-doc -->
	 */
	def input: Seq[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * If true, the Action can begin a new, concurrent execution, even if there is already another execution of the Action ongoing. If false, the Action cannot begin a new execution until any previous execution has completed.
	 * <!-- end-user-doc -->
	 */
	def isLocallyReentrant: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * A Constraint that must be satisfied when execution of the Action is completed.
	 * <!-- end-user-doc -->
	 */
	def localPostcondition: Set[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A Constraint that must be satisfied when execution of the Action is started.
	 * <!-- end-user-doc -->
	 */
	def localPrecondition: Set[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ordered set of OutputPins representing outputs from the Action.
	 * <!-- end-user-doc -->
	 */
	def output: Seq[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def action_interaction: Option[UMLInteraction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def action_actionExecutionSpecification: Set[UMLActionExecutionSpecification[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def fromAction_actionInputPin: Option[UMLActionInputPin[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLAction
