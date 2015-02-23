package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A PackageImport is a Relationship that imports all the non-private members of a Package into the Namespace owning the PackageImport, so that those Elements may be referred to by their unqualified names in the importingNamespace.
 * <!-- end-user-doc --> 
 */
trait UMLPackageImport[Uml <: UML]
  extends UMLDirectedRelationship[Uml] with operations.UMLPackageImportOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		packageImport_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPackageImport
	 */
	def packageImport_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		directedRelationship_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		packageImport_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPackageImport
	 */
	def packageImport_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		packageImport_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPackageImport
	 */
	def packageImport_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLPackageImport[Uml], UMLPackage[Uml]]("importedPackage", _.importedPackage),
		  	MetaPropertyReference[UMLPackageImport[Uml], UMLNamespace[Uml]]("importingNamespace", _.importingNamespace)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		packageImport_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPackageImport
	 */
	def packageImport_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		importedPackage ++
		importingNamespace 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the Package whose members are imported into a Namespace.
	 * <!-- end-user-doc -->
	 */
	def importedPackage: Option[UMLPackage[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the Namespace that imports the members from a Package.
	 * <!-- end-user-doc -->
	 */
	def importingNamespace: Option[UMLNamespace[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the visibility of the imported PackageableElements within the importingNamespace, i.e., whether imported Elements will in turn be visible to other Namespaces. If the PackageImport is public, the imported Elements will be visible outside the importingNamespace, while, if the PackageImport is private, they will not.
	 * <!-- end-user-doc -->
	 */
	def visibility: UMLVisibilityKind.Value = UMLVisibilityKind.public

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def metamodelReference_profile: Option[UMLProfile[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLPackageImport
