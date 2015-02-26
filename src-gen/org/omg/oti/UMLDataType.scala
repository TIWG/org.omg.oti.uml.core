package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A DataType is a type whose instances are identified only by their value.
 * <!-- end-user-doc --> 
 */
trait UMLDataType[Uml <: UML]
  extends UMLClassifier[Uml] with operations.UMLDataTypeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		dataType_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDataType
	 */
	def dataType_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		classifier_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		dataType_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDataType
	 */
	def dataType_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		classifier_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLDataType[Uml], UMLProperty[Uml]]("ownedAttribute", _.ownedAttribute),
		  	MetaPropertyCollection[Uml, UMLDataType[Uml], UMLOperation[Uml]]("ownedOperation", _.ownedOperation)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		dataType_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDataType
	 */
	def dataType_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		classifier_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		dataType_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDataType
	 */
	def dataType_forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The attributes owned by the DataType.
	 * <!-- end-user-doc -->
	 */
	def ownedAttribute: Seq[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Operations owned by the DataType.
	 * <!-- end-user-doc -->
	 */
	def ownedOperation: Seq[UMLOperation[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLDataType
