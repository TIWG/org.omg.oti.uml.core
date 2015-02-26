package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Constraint is a condition or restriction expressed in natural language text or in a machine readable language for the purpose of declaring some of the semantics of an Element or set of Elements.
 * <!-- end-user-doc --> 
 */
trait UMLConstraint[Uml <: UML]
  extends UMLPackageableElement[Uml] with operations.UMLConstraintOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		constraint_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConstraint
	 */
	def constraint_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		packageableElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		constraint_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConstraint
	 */
	def constraint_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		packageableElement_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLConstraint[Uml], UMLValueSpecification[Uml]]("specification", _.specification)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		constraint_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConstraint
	 */
	def constraint_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		packageableElement_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLConstraint[Uml], UMLElement[Uml]]("constrainedElement", _.constrainedElement),
		  	MetaPropertyReference[Uml, UMLConstraint[Uml], UMLNamespace[Uml]]("context", _.context)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		constraint_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConstraint
	 */
	def constraint_forwardReferencesFromMetamodelAssociations: Elements =
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		constrainedElement ++
		context 

	/**
	 * <!-- begin-user-doc --> 
	 * The ordered set of Elements referenced by this Constraint.
	 * <!-- end-user-doc -->
	 */
	def constrainedElement: Seq[UMLElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the Namespace that owns the Constraint.
	 * <!-- end-user-doc -->
	 */
	def context: Option[UMLNamespace[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A condition that must be true when evaluated in order for the Constraint to be satisfied.
	 * <!-- end-user-doc -->
	 */
	def specification: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def bodyCondition_bodyContext: Option[UMLOperation[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def condition_extend: Option[UMLExtend[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def precondition_preContext: Option[UMLOperation[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def invariant_stateInvariant: Option[UMLStateInvariant[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def condition_parameterSet: Option[UMLParameterSet[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def postCondition_owningTransition: Option[UMLProtocolTransition[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def stateInvariant_owningState: Option[UMLState[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def localPrecondition_action: Option[UMLAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def precondition_behavior: Option[UMLBehavior[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def postcondition_postContext: Option[UMLOperation[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def localPostcondition_action: Option[UMLAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def postcondition_behavior: Option[UMLBehavior[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def guard_transition: Option[UMLTransition[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def preCondition_protocolTransition: Option[UMLProtocolTransition[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLConstraint
