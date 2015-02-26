package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A LiteralReal is a specification of a Real value.
 * <!-- end-user-doc --> 
 */
trait UMLLiteralReal[Uml <: UML]
  extends UMLLiteralSpecification[Uml] with operations.UMLLiteralRealOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		literalReal_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLiteralReal
	 */
	def literalReal_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		literalSpecification_metaAttributes,
		  Seq (MetaAttributeRealFunction[Uml, UMLLiteralReal[Uml]](None, "value", (x) => realToIterable(x.value, 0.0))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		literalReal_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLiteralReal
	 */
	def literalReal_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		literalSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		literalReal_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLiteralReal
	 */
	def literalReal_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		literalSpecification_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		literalReal_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLiteralReal
	 */
	def literalReal_forwardReferencesFromMetamodelAssociations: Elements =
		literalSpecification_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The specified Real value.
	 * <!-- end-user-doc -->
	 */
	def value: Double 

// Start of user code for additional featuers
// End of user code

} //UMLLiteralReal
