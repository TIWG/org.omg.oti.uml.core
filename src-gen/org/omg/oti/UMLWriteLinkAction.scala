package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * WriteLinkAction is an abstract class for LinkActions that create and destroy links.
 * <!-- end-user-doc --> 
 */
trait UMLWriteLinkAction[Uml <: UML]
  extends UMLLinkAction[Uml] with operations.UMLWriteLinkActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		writeLinkAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLWriteLinkAction
	 */
	def writeLinkAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		linkAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		writeLinkAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLWriteLinkAction
	 */
	def writeLinkAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		linkAction_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		writeLinkAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLWriteLinkAction
	 */
	def writeLinkAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		linkAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		writeLinkAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLWriteLinkAction
	 */
	def writeLinkAction_forwardReferencesFromMetamodelAssociations: Elements =
		linkAction_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLWriteLinkAction
