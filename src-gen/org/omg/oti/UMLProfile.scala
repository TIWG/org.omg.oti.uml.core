package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A profile defines limited extensions to a reference metamodel with the purpose of adapting the metamodel to a specific platform or domain.
 * <!-- end-user-doc --> 
 */
trait UMLProfile[Uml <: UML]
  extends UMLPackage[Uml] with operations.UMLProfileOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		profile_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLProfile
	 */
	def profile_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		package_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		profile_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLProfile
	 */
	def profile_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		package_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLProfile[Uml], UMLElementImport[Uml]]("metaclassReference", _.metaclassReference),
		  	MetaPropertyCollection[UMLProfile[Uml], UMLPackageImport[Uml]]("metamodelReference", _.metamodelReference)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		profile_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLProfile
	 */
	def profile_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		package_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		profile_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLProfile
	 */
	def profile_forwardReferencesFromMetamodelAssociations: Elements =
		package_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * References a metaclass that may be extended.
	 * <!-- end-user-doc -->
	 */
	def metaclassReference: Set[UMLElementImport[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References a package containing (directly or indirectly) metaclasses that may be extended.
	 * <!-- end-user-doc -->
	 */
	def metamodelReference: Set[UMLPackageImport[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def appliedProfile_profileApplication: Set[UMLProfileApplication[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def profile_stereotype: Set[UMLStereotype[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLProfile
