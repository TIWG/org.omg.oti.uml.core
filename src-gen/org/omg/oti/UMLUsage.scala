package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Usage is a Dependency in which the client Element requires the supplier Element (or set of Elements) for its full implementation or operation.
 * <!-- end-user-doc --> 
 */
trait UMLUsage[Uml <: UML]
  extends UMLDependency[Uml] with operations.UMLUsageOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		usage_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLUsage
	 */
	def usage_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		dependency_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		usage_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLUsage
	 */
	def usage_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		dependency_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		usage_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLUsage
	 */
	def usage_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		dependency_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		usage_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLUsage
	 */
	def usage_forwardReferencesFromMetamodelAssociations: Elements =
		dependency_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLUsage
