package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ReadLinkAction is a LinkAction that navigates across an Association to retrieve the objects on one end.
 * <!-- end-user-doc --> 
 */
trait UMLReadLinkAction[Uml <: UML]
  extends UMLLinkAction[Uml] with operations.UMLReadLinkActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		readLinkAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReadLinkAction
	 */
	def readLinkAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		linkAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		readLinkAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReadLinkAction
	 */
	def readLinkAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		linkAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLReadLinkAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		readLinkAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReadLinkAction
	 */
	def readLinkAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		linkAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		readLinkAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReadLinkAction
	 */
	def readLinkAction_forwardReferencesFromMetamodelAssociations: Elements =
		linkAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin on which the objects retrieved from the "open" end of those links whose values on other ends are given by the endData.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLReadLinkAction
