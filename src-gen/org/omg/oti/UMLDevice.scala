package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A device is a physical computational resource with processing capability upon which artifacts may be deployed for execution. Devices may be complex (i.e., they may consist of other devices).
 * <!-- end-user-doc --> 
 */
trait UMLDevice[Uml <: UML]
  extends UMLNode[Uml] with operations.UMLDeviceOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		device_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDevice
	 */
	def device_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		node_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		device_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDevice
	 */
	def device_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		node_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		device_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDevice
	 */
	def device_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		node_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		device_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDevice
	 */
	def device_forwardReferencesFromMetamodelAssociations: Elements =
		node_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLDevice
