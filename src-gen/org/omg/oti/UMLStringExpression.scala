package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A StringExpression is an Expression that specifies a String value that is derived by concatenating a sequence of operands with String values or a sequence of subExpressions, some of which might be template parameters.
 * <!-- end-user-doc --> 
 */
trait UMLStringExpression[Uml <: UML]
  extends UMLTemplateableElement[Uml] with UMLExpression[Uml] with operations.UMLStringExpressionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		stringExpression_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStringExpression
	 */
	def stringExpression_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		templateableElement_metaAttributes,
		expression_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		stringExpression_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStringExpression
	 */
	def stringExpression_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		templateableElement_compositeMetaProperties,
		expression_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLStringExpression[Uml], UMLStringExpression[Uml]]("subExpression", _.subExpression)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		stringExpression_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStringExpression
	 */
	def stringExpression_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		templateableElement_referenceMetaProperties,
		expression_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLStringExpression[Uml], UMLStringExpression[Uml]]("owningExpression", _.owningExpression)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		stringExpression_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStringExpression
	 */
	def stringExpression_forwardReferencesFromMetamodelAssociations: Elements =
		templateableElement_forwardReferencesFromMetamodelAssociations ++
		expression_forwardReferencesFromMetamodelAssociations ++
		owningExpression 

	/**
	 * <!-- begin-user-doc --> 
	 * The StringExpression of which this StringExpression is a subExpression.
	 * <!-- end-user-doc -->
	 */
	def owningExpression: Option[UMLStringExpression[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The StringExpressions that constitute this StringExpression.
	 * <!-- end-user-doc -->
	 */
	def subExpression: Seq[UMLStringExpression[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def nameExpression_namedElement: Option[UMLNamedElement[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLStringExpression
