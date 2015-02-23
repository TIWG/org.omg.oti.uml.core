package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An Enumeration is a DataType whose values are enumerated in the model as EnumerationLiterals.
 * <!-- end-user-doc --> 
 */
trait UMLEnumeration[Uml <: UML]
  extends UMLDataType[Uml] with operations.UMLEnumerationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		enumeration_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLEnumeration
	 */
	def enumeration_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		dataType_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		enumeration_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLEnumeration
	 */
	def enumeration_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		dataType_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLEnumeration[Uml], UMLEnumerationLiteral[Uml]]("ownedLiteral", _.ownedLiteral)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		enumeration_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLEnumeration
	 */
	def enumeration_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		dataType_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		enumeration_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLEnumeration
	 */
	def enumeration_forwardReferencesFromMetamodelAssociations: Elements =
		dataType_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The ordered set of literals owned by this Enumeration.
	 * <!-- end-user-doc -->
	 */
	def ownedLiteral: Seq[UMLEnumerationLiteral[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def classifier_enumerationLiteral: Iterable[UMLEnumerationLiteral[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLEnumeration
