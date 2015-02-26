package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An Expression represents a node in an expression tree, which may be non-terminal or terminal. It defines a symbol, and has a possibly empty sequence of operands that are ValueSpecifications. It denotes a (possibly empty) set of values when evaluated in a context.
 * <!-- end-user-doc --> 
 */
trait UMLExpression[Uml <: UML]
  extends UMLValueSpecification[Uml] with operations.UMLExpressionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		expression_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExpression
	 */
	def expression_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		valueSpecification_metaAttributes,
		  Seq (MetaAttributeStringFunction[Uml, UMLExpression[Uml]](None, "symbol", (x) => stringToIterable(x.symbol, null))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		expression_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExpression
	 */
	def expression_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLExpression[Uml], UMLValueSpecification[Uml]]("operand", _.operand)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		expression_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExpression
	 */
	def expression_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		expression_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExpression
	 */
	def expression_forwardReferencesFromMetamodelAssociations: Elements =
		valueSpecification_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies a sequence of operand ValueSpecifications.
	 * <!-- end-user-doc -->
	 */
	def operand: Seq[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The symbol associated with this node in the expression tree.
	 * <!-- end-user-doc -->
	 */
	def symbol: Option[String] 

// Start of user code for additional featuers
// End of user code

} //UMLExpression
