package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A DirectedRelationship represents a relationship between a collection of source model Elements and a collection of target model Elements.
 * <!-- end-user-doc --> 
 */
trait UMLDirectedRelationship[Uml <: UML]
  extends UMLRelationship[Uml] with operations.UMLDirectedRelationshipOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		directedRelationship_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDirectedRelationship
	 */
	def directedRelationship_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		relationship_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		directedRelationship_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDirectedRelationship
	 */
	def directedRelationship_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		relationship_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		directedRelationship_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDirectedRelationship
	 */
	def directedRelationship_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		relationship_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDirectedRelationship
	 */
	def directedRelationship_forwardReferencesFromMetamodelAssociations: Elements =
		relationship_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the source Element(s) of the DirectedRelationship.
	 * <!-- end-user-doc -->
	 */
	def source: Set[UMLElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the target Element(s) of the DirectedRelationship.
	 * <!-- end-user-doc -->
	 */
	def target: Set[UMLElement[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLDirectedRelationship
