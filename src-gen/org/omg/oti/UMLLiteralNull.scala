package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A LiteralNull specifies the lack of a value.
 * <!-- end-user-doc --> 
 */
trait UMLLiteralNull[Uml <: UML]
  extends UMLLiteralSpecification[Uml] with operations.UMLLiteralNullOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		literalNull_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLiteralNull
	 */
	def literalNull_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		literalSpecification_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		literalNull_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLiteralNull
	 */
	def literalNull_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		literalSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		literalNull_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLiteralNull
	 */
	def literalNull_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		literalSpecification_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		literalNull_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLiteralNull
	 */
	def literalNull_forwardReferencesFromMetamodelAssociations: Elements =
		literalSpecification_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLLiteralNull
