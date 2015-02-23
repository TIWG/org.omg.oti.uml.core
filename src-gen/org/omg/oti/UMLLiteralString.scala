package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A LiteralString is a specification of a String value.
 * <!-- end-user-doc --> 
 */
trait UMLLiteralString[Uml <: UML]
  extends UMLLiteralSpecification[Uml] with operations.UMLLiteralStringOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		literalString_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLiteralString
	 */
	def literalString_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		literalSpecification_metaAttributes,
		  Seq (MetaAttributeStringFunction[UMLLiteralString[Uml]](None, "value", (x) => stringToIterable(x.value, null))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		literalString_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLiteralString
	 */
	def literalString_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		literalSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		literalString_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLiteralString
	 */
	def literalString_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		literalSpecification_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		literalString_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLiteralString
	 */
	def literalString_forwardReferencesFromMetamodelAssociations: Elements =
		literalSpecification_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The specified String value.
	 * <!-- end-user-doc -->
	 */
	def value: Option[String] 

// Start of user code for additional featuers
// End of user code

} //UMLLiteralString
