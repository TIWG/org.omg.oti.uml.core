package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Namespace is an Element in a model that owns and/or imports a set of NamedElements that can be identified by name.
 * <!-- end-user-doc --> 
 */
trait UMLNamespace[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLNamespaceOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		namespace_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLNamespace
	 */
	def namespace_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		namespace_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLNamespace
	 */
	def namespace_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLNamespace[Uml], UMLElementImport[Uml]]("elementImport", _.elementImport),
		  	MetaPropertyCollection[Uml, UMLNamespace[Uml], UMLConstraint[Uml]]("ownedRule", _.ownedRule),
		  	MetaPropertyCollection[Uml, UMLNamespace[Uml], UMLPackageImport[Uml]]("packageImport", _.packageImport)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		namespace_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLNamespace
	 */
	def namespace_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		namespace_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLNamespace
	 */
	def namespace_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * References the ElementImports owned by the Namespace.
	 * <!-- end-user-doc -->
	 */
	def elementImport: Set[UMLElementImport[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the PackageableElements that are members of this Namespace as a result of either PackageImports or ElementImports.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (self.importMembers(elementImport.importedElement->asSet()->union(packageImport.importedPackage->collect(p | p.visibleMembers()))->asSet()))
	 */
	def importedMember: Set[UMLPackageableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A collection of NamedElements identifiable within the Namespace, either by being owned or by being introduced by importing or inheritance.
	 * <!-- end-user-doc -->
	 */
	def member: Set[UMLNamedElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A collection of NamedElements owned by the Namespace.
	 * <!-- end-user-doc -->
	 */
	def ownedMember: Set[UMLNamedElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies a set of Constraints owned by this Namespace.
	 * <!-- end-user-doc -->
	 */
	def ownedRule: Set[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the PackageImports owned by the Namespace.
	 * <!-- end-user-doc -->
	 */
	def packageImport: Set[UMLPackageImport[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLNamespace
