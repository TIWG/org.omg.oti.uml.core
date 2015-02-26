package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ClearAssociationAction is an Action that destroys all links of an Association in which a particular object participates.
 * <!-- end-user-doc --> 
 */
trait UMLClearAssociationAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLClearAssociationActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		clearAssociationAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLClearAssociationAction
	 */
	def clearAssociationAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		clearAssociationAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLClearAssociationAction
	 */
	def clearAssociationAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLClearAssociationAction[Uml], UMLInputPin[Uml]]("object", _._object)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		clearAssociationAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLClearAssociationAction
	 */
	def clearAssociationAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLClearAssociationAction[Uml], UMLAssociation[Uml]]("association", _.association)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		clearAssociationAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLClearAssociationAction
	 */
	def clearAssociationAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		association 

	/**
	 * <!-- begin-user-doc --> 
	 * The Association to be cleared.
	 * <!-- end-user-doc -->
	 */
	def association: Option[UMLAssociation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that gives the object whose participation in the Association is to be cleared.
	 * <!-- end-user-doc -->
	 */
	def _object: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLClearAssociationAction
