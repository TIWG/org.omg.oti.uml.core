package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Collaboration describes a structure of collaborating elements (roles), each performing a specialized function, which collectively accomplish some desired functionality. 
 * <!-- end-user-doc --> 
 */
trait UMLCollaboration[Uml <: UML]
  extends UMLStructuredClassifier[Uml] with UMLBehavioredClassifier[Uml] with operations.UMLCollaborationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		collaboration_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCollaboration
	 */
	def collaboration_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		structuredClassifier_metaAttributes,
		behavioredClassifier_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		collaboration_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCollaboration
	 */
	def collaboration_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuredClassifier_compositeMetaProperties,
		behavioredClassifier_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		collaboration_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCollaboration
	 */
	def collaboration_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuredClassifier_referenceMetaProperties,
		behavioredClassifier_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLCollaboration[Uml], UMLConnectableElement[Uml]]("collaborationRole", _.collaborationRole)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		collaboration_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCollaboration
	 */
	def collaboration_forwardReferencesFromMetamodelAssociations: Elements =
		structuredClassifier_forwardReferencesFromMetamodelAssociations ++
		behavioredClassifier_forwardReferencesFromMetamodelAssociations ++
		collaborationRole 

	/**
	 * <!-- begin-user-doc --> 
	 * Represents the participants in the Collaboration.
	 * <!-- end-user-doc -->
	 */
	def collaborationRole: Set[UMLConnectableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def type_collaborationUse: Set[UMLCollaborationUse[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLCollaboration
