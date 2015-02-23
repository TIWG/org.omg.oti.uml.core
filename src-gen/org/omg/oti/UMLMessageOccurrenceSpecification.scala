package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A MessageOccurrenceSpecification specifies the occurrence of Message events, such as sending and receiving of Signals or invoking or receiving of Operation calls. A MessageOccurrenceSpecification is a kind of MessageEnd. Messages are generated either by synchronous Operation calls or asynchronous Signal sends. They are received by the execution of corresponding AcceptEventActions.
 * <!-- end-user-doc --> 
 */
trait UMLMessageOccurrenceSpecification[Uml <: UML]
  extends UMLOccurrenceSpecification[Uml] with UMLMessageEnd[Uml] with operations.UMLMessageOccurrenceSpecificationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		messageOccurrenceSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLMessageOccurrenceSpecification
	 */
	def messageOccurrenceSpecification_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		occurrenceSpecification_metaAttributes,
		messageEnd_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		messageOccurrenceSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLMessageOccurrenceSpecification
	 */
	def messageOccurrenceSpecification_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		occurrenceSpecification_compositeMetaProperties,
		messageEnd_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		messageOccurrenceSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLMessageOccurrenceSpecification
	 */
	def messageOccurrenceSpecification_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		occurrenceSpecification_referenceMetaProperties,
		messageEnd_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		messageOccurrenceSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLMessageOccurrenceSpecification
	 */
	def messageOccurrenceSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		occurrenceSpecification_forwardReferencesFromMetamodelAssociations ++
		messageEnd_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLMessageOccurrenceSpecification
