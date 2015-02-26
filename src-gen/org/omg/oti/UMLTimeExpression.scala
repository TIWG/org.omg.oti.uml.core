package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A TimeExpression is a ValueSpecification that represents a time value.
 * <!-- end-user-doc --> 
 */
trait UMLTimeExpression[Uml <: UML]
  extends UMLValueSpecification[Uml] with operations.UMLTimeExpressionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		timeExpression_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTimeExpression
	 */
	def timeExpression_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		valueSpecification_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		timeExpression_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTimeExpression
	 */
	def timeExpression_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLTimeExpression[Uml], UMLValueSpecification[Uml]]("expr", _.expr)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		timeExpression_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTimeExpression
	 */
	def timeExpression_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLTimeExpression[Uml], UMLObservation[Uml]]("observation", _.observation)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		timeExpression_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTimeExpression
	 */
	def timeExpression_forwardReferencesFromMetamodelAssociations: Elements =
		valueSpecification_forwardReferencesFromMetamodelAssociations ++
		observation 

	/**
	 * <!-- begin-user-doc --> 
	 * A ValueSpecification that evaluates to the value of the TimeExpression.
	 * <!-- end-user-doc -->
	 */
	def expr: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Refers to the Observations that are involved in the computation of the TimeExpression value.
	 * <!-- end-user-doc -->
	 */
	def observation: Set[UMLObservation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def when_timeEvent: Option[UMLTimeEvent[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def min_timeInterval: Iterable[UMLTimeInterval[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def max_timeInterval: Iterable[UMLTimeInterval[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLTimeExpression
