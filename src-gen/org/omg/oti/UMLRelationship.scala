package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * Relationship is an abstract concept that specifies some kind of relationship between Elements.
 * <!-- end-user-doc --> 
 */
trait UMLRelationship[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLRelationshipOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		relationship_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLRelationship
	 */
	def relationship_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		relationship_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLRelationship
	 */
	def relationship_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		relationship_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLRelationship
	 */
	def relationship_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		relationship_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLRelationship
	 */
	def relationship_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the elements related by the Relationship.
	 * <!-- end-user-doc -->
	 */
	def relatedElement: Set[UMLElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def realization_abstraction: Set[UMLInformationFlow[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLRelationship
