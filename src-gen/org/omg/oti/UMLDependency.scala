package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Dependency is a Relationship that signifies that a single model Element or a set of model Elements requires other model Elements for their specification or implementation. This means that the complete semantics of the client Element(s) are either semantically or structurally dependent on the definition of the supplier Element(s).
 * <!-- end-user-doc --> 
 */
trait UMLDependency[Uml <: UML]
  extends UMLDirectedRelationship[Uml] with UMLPackageableElement[Uml] with operations.UMLDependencyOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		dependency_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDependency
	 */
	def dependency_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		directedRelationship_metaAttributes,
		packageableElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		dependency_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDependency
	 */
	def dependency_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_compositeMetaProperties,
		packageableElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		dependency_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDependency
	 */
	def dependency_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_referenceMetaProperties,
		packageableElement_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLDependency[Uml], UMLNamedElement[Uml]]("client", _.client),
		  	MetaPropertyCollection[Uml, UMLDependency[Uml], UMLNamedElement[Uml]]("supplier", _.supplier)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		dependency_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDependency
	 */
	def dependency_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		client ++
		supplier 

	/**
	 * <!-- begin-user-doc --> 
	 * The Element(s) dependent on the supplier Element(s). In some cases (such as a trace Abstraction) the assignment of direction (that is, the designation of the client Element) is at the discretion of the modeler and is a stipulation.
	 * <!-- end-user-doc -->
	 */
	def client: Set[UMLNamedElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Element(s) on which the client Element(s) depend in some respect. The modeler may stipulate a sense of Dependency direction suitable for their domain.
	 * <!-- end-user-doc -->
	 */
	def supplier: Set[UMLNamedElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def roleBinding_collaborationUse: Option[UMLCollaborationUse[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLDependency
