package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Type constrains the values represented by a TypedElement.
 * <!-- end-user-doc --> 
 */
trait UMLType[Uml <: UML]
  extends UMLPackageableElement[Uml] with operations.UMLTypeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		type_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLType
	 */
	def type_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		packageableElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		type_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLType
	 */
	def type_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		packageableElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		type_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLType
	 */
	def type_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		packageableElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLType[Uml], UMLPackage[Uml]]("package", _._package)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		type_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLType
	 */
	def type_forwardReferencesFromMetamodelAssociations: Elements =
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		_package 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the owning Package of this Type, if any.
	 * <!-- end-user-doc -->
	 */
	def _package: Option[UMLPackage[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def endType_association: Set[UMLAssociation[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def type_operation: Set[UMLOperation[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def type_typedElement: Set[UMLTypedElement[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def raisedException_behavioralFeature: Set[UMLBehavioralFeature[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def raisedException_operation: Set[UMLOperation[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLType
