package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A DestructionOccurenceSpecification models the destruction of an object.
 * <!-- end-user-doc --> 
 */
trait UMLDestructionOccurrenceSpecification[Uml <: UML]
  extends UMLMessageOccurrenceSpecification[Uml] with operations.UMLDestructionOccurrenceSpecificationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		destructionOccurrenceSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDestructionOccurrenceSpecification
	 */
	def destructionOccurrenceSpecification_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		messageOccurrenceSpecification_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		destructionOccurrenceSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDestructionOccurrenceSpecification
	 */
	def destructionOccurrenceSpecification_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		messageOccurrenceSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		destructionOccurrenceSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDestructionOccurrenceSpecification
	 */
	def destructionOccurrenceSpecification_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		messageOccurrenceSpecification_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		destructionOccurrenceSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDestructionOccurrenceSpecification
	 */
	def destructionOccurrenceSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		messageOccurrenceSpecification_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLDestructionOccurrenceSpecification
