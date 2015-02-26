package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A LiteralBoolean is a specification of a Boolean value.
 * <!-- end-user-doc --> 
 */
trait UMLLiteralBoolean[Uml <: UML]
  extends UMLLiteralSpecification[Uml] with operations.UMLLiteralBooleanOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		literalBoolean_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLiteralBoolean
	 */
	def literalBoolean_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		literalSpecification_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLLiteralBoolean[Uml]](None, "value", (x) => booleanToIterable(x.value, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		literalBoolean_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLiteralBoolean
	 */
	def literalBoolean_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		literalSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		literalBoolean_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLiteralBoolean
	 */
	def literalBoolean_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		literalSpecification_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		literalBoolean_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLiteralBoolean
	 */
	def literalBoolean_forwardReferencesFromMetamodelAssociations: Elements =
		literalSpecification_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The specified Boolean value.
	 * <!-- end-user-doc -->
	 */
	def value: Boolean = false

// Start of user code for additional featuers
// End of user code

} //UMLLiteralBoolean
