package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ValueSpecification is the specification of a (possibly empty) set of values. A ValueSpecification is a ParameterableElement that may be exposed as a formal TemplateParameter and provided as the actual parameter in the binding of a template.
 * <!-- end-user-doc --> 
 */
trait UMLValueSpecification[Uml <: UML]
  extends UMLTypedElement[Uml] with UMLPackageableElement[Uml] with operations.UMLValueSpecificationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		valueSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLValueSpecification
	 */
	def valueSpecification_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		typedElement_metaAttributes,
		packageableElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		valueSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLValueSpecification
	 */
	def valueSpecification_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		typedElement_compositeMetaProperties,
		packageableElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		valueSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLValueSpecification
	 */
	def valueSpecification_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		typedElement_referenceMetaProperties,
		packageableElement_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		valueSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLValueSpecification
	 */
	def valueSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		typedElement_forwardReferencesFromMetamodelAssociations ++
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		Set () 


	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def expr_duration: Option[UMLDuration[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def guard_activityEdge: Option[UMLActivityEdge[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def operand_expression: Option[UMLExpression[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def value_owningSlot: Option[UMLSlot[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def changeExpression_changeEvent: Option[UMLChangeEvent[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def returnValue_interactionUse: Option[UMLInteractionUse[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def lowerValue_owningLower: Option[UMLMultiplicityElement[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def min_interval: Iterable[UMLInterval[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def value_valuePin: Option[UMLValuePin[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def maxint_interactionConstraint: Option[UMLInteractionConstraint[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def upperValue_owningUpper: Option[UMLMultiplicityElement[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def argument_message: Option[UMLMessage[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def argument_interactionUse: Option[UMLInteractionUse[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def joinSpec_joinNode: Option[UMLJoinNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def value_valueSpecificationAction: Option[UMLValueSpecificationAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def upperBound_objectNode: Option[UMLObjectNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def specification_owningConstraint: Option[UMLConstraint[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def specification_owningInstanceSpec: Option[UMLInstanceSpecification[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def expr_timeExpression: Option[UMLTimeExpression[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def max_interval: Iterable[UMLInterval[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def defaultValue_owningProperty: Option[UMLProperty[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def selector_lifeline: Option[UMLLifeline[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def weight_activityEdge: Option[UMLActivityEdge[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def defaultValue_owningParameter: Option[UMLParameter[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def minint_interactionConstraint: Option[UMLInteractionConstraint[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLValueSpecification
