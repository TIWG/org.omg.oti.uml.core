package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ElementImport identifies a NamedElement in a Namespace other than the one that owns that NamedElement and allows the NamedElement to be referenced using an unqualified name in the Namespace owning the ElementImport.
 * <!-- end-user-doc --> 
 */
trait UMLElementImport[Uml <: UML]
  extends UMLDirectedRelationship[Uml] with operations.UMLElementImportOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		elementImport_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLElementImport
	 */
	def elementImport_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		directedRelationship_metaAttributes,
		  Seq (MetaAttributeStringFunction[Uml, UMLElementImport[Uml]](None, "alias", (x) => stringToIterable(x.alias, null))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		elementImport_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLElementImport
	 */
	def elementImport_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		elementImport_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLElementImport
	 */
	def elementImport_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLElementImport[Uml], UMLPackageableElement[Uml]]("importedElement", _.importedElement),
		  	MetaPropertyReference[Uml, UMLElementImport[Uml], UMLNamespace[Uml]]("importingNamespace", _.importingNamespace)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		elementImport_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLElementImport
	 */
	def elementImport_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		importedElement ++
		importingNamespace 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the name that should be added to the importing Namespace in lieu of the name of the imported PackagableElement. The alias must not clash with any other member in the importing Namespace. By default, no alias is used.
	 * <!-- end-user-doc -->
	 */
	def alias: Option[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the PackageableElement whose name is to be added to a Namespace.
	 * <!-- end-user-doc -->
	 */
	def importedElement: Option[UMLPackageableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the Namespace that imports a PackageableElement from another Namespace.
	 * <!-- end-user-doc -->
	 */
	def importingNamespace: Option[UMLNamespace[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the visibility of the imported PackageableElement within the importingNamespace, i.e., whether the  importedElement will in turn be visible to other Namespaces. If the ElementImport is public, the importedElement will be visible outside the importingNamespace while, if the ElementImport is private, it will not.
	 * <!-- end-user-doc -->
	 */
	def visibility: UMLVisibilityKind.Value = UMLVisibilityKind.public

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def metaclassReference_profile: Option[UMLProfile[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLElementImport
