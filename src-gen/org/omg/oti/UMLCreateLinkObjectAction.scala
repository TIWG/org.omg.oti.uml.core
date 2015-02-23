package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A CreateLinkObjectAction is a CreateLinkAction for creating link objects (AssociationClasse instances).
 * <!-- end-user-doc --> 
 */
trait UMLCreateLinkObjectAction[Uml <: UML]
  extends UMLCreateLinkAction[Uml] with operations.UMLCreateLinkObjectActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		createLinkObjectAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCreateLinkObjectAction
	 */
	def createLinkObjectAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		createLinkAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		createLinkObjectAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCreateLinkObjectAction
	 */
	def createLinkObjectAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		createLinkAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLCreateLinkObjectAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		createLinkObjectAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCreateLinkObjectAction
	 */
	def createLinkObjectAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		createLinkAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		createLinkObjectAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCreateLinkObjectAction
	 */
	def createLinkObjectAction_forwardReferencesFromMetamodelAssociations: Elements =
		createLinkAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The output pin on which the newly created link object is placed.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLCreateLinkObjectAction
