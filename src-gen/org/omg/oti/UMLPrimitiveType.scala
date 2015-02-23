package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A PrimitiveType defines a predefined DataType, without any substructure. A PrimitiveType may have an algebra and operations defined outside of UML, for example, mathematically.
 * <!-- end-user-doc --> 
 */
trait UMLPrimitiveType[Uml <: UML]
  extends UMLDataType[Uml] with operations.UMLPrimitiveTypeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		primitiveType_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPrimitiveType
	 */
	def primitiveType_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		dataType_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		primitiveType_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPrimitiveType
	 */
	def primitiveType_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		dataType_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		primitiveType_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPrimitiveType
	 */
	def primitiveType_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		dataType_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		primitiveType_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPrimitiveType
	 */
	def primitiveType_forwardReferencesFromMetamodelAssociations: Elements =
		dataType_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLPrimitiveType
