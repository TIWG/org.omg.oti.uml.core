package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An InstanceValue is a ValueSpecification that identifies an instance.
 * <!-- end-user-doc --> 
 */
trait UMLInstanceValue[Uml <: UML]
  extends UMLValueSpecification[Uml] with operations.UMLInstanceValueOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		instanceValue_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInstanceValue
	 */
	def instanceValue_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		valueSpecification_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		instanceValue_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInstanceValue
	 */
	def instanceValue_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		instanceValue_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInstanceValue
	 */
	def instanceValue_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLInstanceValue[Uml], UMLInstanceSpecification[Uml]]("instance", _.instance)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		instanceValue_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInstanceValue
	 */
	def instanceValue_forwardReferencesFromMetamodelAssociations: Elements =
		valueSpecification_forwardReferencesFromMetamodelAssociations ++
		instance 

	/**
	 * <!-- begin-user-doc --> 
	 * The InstanceSpecification that represents the specified value.
	 * <!-- end-user-doc -->
	 */
	def instance: Option[UMLInstanceSpecification[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLInstanceValue
