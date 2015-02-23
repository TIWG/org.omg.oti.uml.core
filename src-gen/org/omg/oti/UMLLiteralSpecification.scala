package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A LiteralSpecification identifies a literal constant being modeled.
 * <!-- end-user-doc --> 
 */
trait UMLLiteralSpecification[Uml <: UML]
  extends UMLValueSpecification[Uml] with operations.UMLLiteralSpecificationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		literalSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLiteralSpecification
	 */
	def literalSpecification_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		valueSpecification_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		literalSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLiteralSpecification
	 */
	def literalSpecification_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		literalSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLiteralSpecification
	 */
	def literalSpecification_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		literalSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLiteralSpecification
	 */
	def literalSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		valueSpecification_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLLiteralSpecification
