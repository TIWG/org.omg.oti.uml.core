package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A LiteralInteger is a specification of an Integer value.
 * <!-- end-user-doc --> 
 */
trait UMLLiteralInteger[Uml <: UML]
  extends UMLLiteralSpecification[Uml] with operations.UMLLiteralIntegerOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		literalInteger_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLiteralInteger
	 */
	def literalInteger_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		literalSpecification_metaAttributes,
		  Seq (MetaAttributeIntegerFunction[Uml, UMLLiteralInteger[Uml]](None, "value", (x) => integerToIterable(x.value, 0))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		literalInteger_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLiteralInteger
	 */
	def literalInteger_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		literalSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		literalInteger_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLiteralInteger
	 */
	def literalInteger_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		literalSpecification_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		literalInteger_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLiteralInteger
	 */
	def literalInteger_forwardReferencesFromMetamodelAssociations: Elements =
		literalSpecification_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The specified Integer value.
	 * <!-- end-user-doc -->
	 */
	def value: Integer = 0

// Start of user code for additional featuers
// End of user code

} //UMLLiteralInteger
