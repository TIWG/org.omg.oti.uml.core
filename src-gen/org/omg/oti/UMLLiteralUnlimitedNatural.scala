package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A LiteralUnlimitedNatural is a specification of an UnlimitedNatural number.
 * <!-- end-user-doc --> 
 */
trait UMLLiteralUnlimitedNatural[Uml <: UML]
  extends UMLLiteralSpecification[Uml] with operations.UMLLiteralUnlimitedNaturalOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		literalUnlimitedNatural_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLiteralUnlimitedNatural
	 */
	def literalUnlimitedNatural_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		literalSpecification_metaAttributes,
		  Seq (MetaAttributeIntegerFunction[Uml, UMLLiteralUnlimitedNatural[Uml]](None, "value", (x) => integerToIterable(x.value, 0))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		literalUnlimitedNatural_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLiteralUnlimitedNatural
	 */
	def literalUnlimitedNatural_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		literalSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		literalUnlimitedNatural_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLiteralUnlimitedNatural
	 */
	def literalUnlimitedNatural_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		literalSpecification_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		literalUnlimitedNatural_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLiteralUnlimitedNatural
	 */
	def literalUnlimitedNatural_forwardReferencesFromMetamodelAssociations: Elements =
		literalSpecification_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The specified UnlimitedNatural value.
	 * <!-- end-user-doc -->
	 */
	def value: Integer = 0

// Start of user code for additional featuers
// End of user code

} //UMLLiteralUnlimitedNatural
