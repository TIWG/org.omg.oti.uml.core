package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A PackageableElement is a NamedElement that may be owned directly by a Package. A PackageableElement is also able to serve as the parameteredElement of a TemplateParameter.
 * <!-- end-user-doc --> 
 */
trait UMLPackageableElement[Uml <: UML]
  extends UMLParameterableElement[Uml] with UMLNamedElement[Uml] with operations.UMLPackageableElementOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		packageableElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPackageableElement
	 */
	def packageableElement_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		parameterableElement_metaAttributes,
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		packageableElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPackageableElement
	 */
	def packageableElement_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		parameterableElement_compositeMetaProperties,
		namedElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		packageableElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPackageableElement
	 */
	def packageableElement_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		parameterableElement_referenceMetaProperties,
		namedElement_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		packageableElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPackageableElement
	 */
	def packageableElement_forwardReferencesFromMetamodelAssociations: Elements =
		parameterableElement_forwardReferencesFromMetamodelAssociations ++
		namedElement_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * A PackageableElement must have a visibility specified if it is owned by a Namespace. The default visibility is public.
	 * <!-- end-user-doc -->
	 */
	override def visibility: UMLVisibilityKind.Value

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def packagedElement_owningPackage: Option[UMLPackage[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def importedElement_import: Set[UMLElementImport[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def deployedElement_deploymentTarget: Set[UMLDeploymentTarget[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def packagedElement_component: Option[UMLComponent[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def importedMember_namespace: Set[UMLNamespace[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def utilizedElement_manifestation: Set[UMLManifestation[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLPackageableElement
