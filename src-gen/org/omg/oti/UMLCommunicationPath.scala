package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A communication path is an association between two deployment targets, through which they are able to exchange signals and messages.
 * <!-- end-user-doc --> 
 */
trait UMLCommunicationPath[Uml <: UML]
  extends UMLAssociation[Uml] with operations.UMLCommunicationPathOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		communicationPath_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCommunicationPath
	 */
	def communicationPath_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		association_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		communicationPath_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCommunicationPath
	 */
	def communicationPath_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		association_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		communicationPath_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCommunicationPath
	 */
	def communicationPath_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		association_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		communicationPath_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCommunicationPath
	 */
	def communicationPath_forwardReferencesFromMetamodelAssociations: Elements =
		association_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLCommunicationPath
