package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A CreateLinkAction is a WriteLinkAction for creating links.
 * <!-- end-user-doc --> 
 */
trait UMLCreateLinkAction[Uml <: UML]
  extends UMLWriteLinkAction[Uml] with operations.UMLCreateLinkActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		createLinkAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCreateLinkAction
	 */
	def createLinkAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		writeLinkAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		createLinkAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCreateLinkAction
	 */
	def createLinkAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		writeLinkAction_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLCreateLinkAction[Uml], UMLLinkEndCreationData[Uml]]("endData", _.endData)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		createLinkAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCreateLinkAction
	 */
	def createLinkAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		writeLinkAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		createLinkAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCreateLinkAction
	 */
	def createLinkAction_forwardReferencesFromMetamodelAssociations: Elements =
		writeLinkAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The LinkEndData that specifies the values to be placed on the Association ends for the new link.
	 * <!-- end-user-doc -->
	 */
	override def endData: Iterable[UMLLinkEndCreationData[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLCreateLinkAction
