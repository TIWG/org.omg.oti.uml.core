package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A DestroyLinkAction is a WriteLinkAction that destroys links (including link objects).
 * <!-- end-user-doc --> 
 */
trait UMLDestroyLinkAction[Uml <: UML]
  extends UMLWriteLinkAction[Uml] with operations.UMLDestroyLinkActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		destroyLinkAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDestroyLinkAction
	 */
	def destroyLinkAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		writeLinkAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		destroyLinkAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDestroyLinkAction
	 */
	def destroyLinkAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		writeLinkAction_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLDestroyLinkAction[Uml], UMLLinkEndDestructionData[Uml]]("endData", _.endData)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		destroyLinkAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDestroyLinkAction
	 */
	def destroyLinkAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		writeLinkAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		destroyLinkAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDestroyLinkAction
	 */
	def destroyLinkAction_forwardReferencesFromMetamodelAssociations: Elements =
		writeLinkAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The LinkEndData that the values of the Association ends for the links to be destroyed.
	 * <!-- end-user-doc -->
	 */
	override def endData: Iterable[UMLLinkEndDestructionData[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLDestroyLinkAction
