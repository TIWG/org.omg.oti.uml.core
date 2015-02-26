package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A package can have one or more profile applications to indicate which profiles have been applied. Because a profile is a package, it is possible to apply a profile not only to packages, but also to profiles.
Package specializes TemplateableElement and PackageableElement specializes ParameterableElement to specify that a package can be used as a template and a PackageableElement as a template parameter.
A package is used to group elements, and provides a namespace for the grouped elements.
 * <!-- end-user-doc --> 
 */
trait UMLPackage[Uml <: UML]
  extends UMLTemplateableElement[Uml] with UMLNamespace[Uml] with UMLPackageableElement[Uml] with operations.UMLPackageOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		package_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPackage
	 */
	def package_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		templateableElement_metaAttributes,
		namespace_metaAttributes,
		packageableElement_metaAttributes,
		  Seq (MetaAttributeStringFunction[Uml, UMLPackage[Uml]](None, "URI", (x) => stringToIterable(x.URI, null))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		package_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPackage
	 */
	def package_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		templateableElement_compositeMetaProperties,
		namespace_compositeMetaProperties,
		packageableElement_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLPackage[Uml], UMLPackageMerge[Uml]]("packageMerge", _.packageMerge),
		  	MetaPropertyCollection[Uml, UMLPackage[Uml], UMLPackageableElement[Uml]]("packagedElement", _.packagedElement),
		  	MetaPropertyCollection[Uml, UMLPackage[Uml], UMLProfileApplication[Uml]]("profileApplication", _.profileApplication)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		package_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPackage
	 */
	def package_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		templateableElement_referenceMetaProperties,
		namespace_referenceMetaProperties,
		packageableElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLPackage[Uml], UMLPackage[Uml]]("nestingPackage", _.nestingPackage)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		package_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPackage
	 */
	def package_forwardReferencesFromMetamodelAssociations: Elements =
		templateableElement_forwardReferencesFromMetamodelAssociations ++
		namespace_forwardReferencesFromMetamodelAssociations ++
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		nestingPackage 

	/**
	 * <!-- begin-user-doc --> 
	 * Provides an identifier for the package that can be used for many purposes. A URI is the universally unique identification of the package following the IETF URI specification, RFC 2396 http://www.ietf.org/rfc/rfc2396.txt and it must comply with those syntax rules.
	 * <!-- end-user-doc -->
	 */
	def URI: Option[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the packaged elements that are Packages.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (packagedElement->select(oclIsKindOf(Package))->collect(oclAsType(Package))->asSet())
	 */
	def nestedPackage: Set[UMLPackage[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * References the Package that owns this Package.
	 * <!-- end-user-doc -->
	 */
	def nestingPackage: Option[UMLPackage[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Stereotypes that are owned by the Package.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (packagedElement->select(oclIsKindOf(Stereotype))->collect(oclAsType(Stereotype))->asSet())
	 */
	def ownedStereotype: Set[UMLStereotype[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * References the packaged elements that are Types.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (packagedElement->select(oclIsKindOf(Type))->collect(oclAsType(Type))->asSet())
	 */
	def ownedType: Set[UMLType[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * References the PackageMerges that are owned by this Package.
	 * <!-- end-user-doc -->
	 */
	def packageMerge: Set[UMLPackageMerge[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the packageable elements that are owned by this Package.
	 * <!-- end-user-doc -->
	 */
	def packagedElement: Set[UMLPackageableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the ProfileApplications that indicate which profiles have been applied to the Package.
	 * <!-- end-user-doc -->
	 */
	def profileApplication: Set[UMLProfileApplication[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def importedPackage_packageImport: Set[UMLPackageImport[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def mergedPackage_packageMerge: Set[UMLPackageMerge[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLPackage
