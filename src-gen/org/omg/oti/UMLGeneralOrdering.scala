package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A GeneralOrdering represents a binary relation between two OccurrenceSpecifications, to describe that one OccurrenceSpecification must occur before the other in a valid trace. This mechanism provides the ability to define partial orders of OccurrenceSpecifications that may otherwise not have a specified order.
 * <!-- end-user-doc --> 
 */
trait UMLGeneralOrdering[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLGeneralOrderingOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		generalOrdering_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLGeneralOrdering
	 */
	def generalOrdering_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		generalOrdering_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLGeneralOrdering
	 */
	def generalOrdering_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		generalOrdering_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLGeneralOrdering
	 */
	def generalOrdering_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLGeneralOrdering[Uml], UMLOccurrenceSpecification[Uml]]("after", _.after),
		  	MetaPropertyReference[Uml, UMLGeneralOrdering[Uml], UMLOccurrenceSpecification[Uml]]("before", _.before)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		generalOrdering_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLGeneralOrdering
	 */
	def generalOrdering_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		after ++
		before 

	/**
	 * <!-- begin-user-doc --> 
	 * The OccurrenceSpecification referenced comes after the OccurrenceSpecification referenced by before.
	 * <!-- end-user-doc -->
	 */
	def after: Option[UMLOccurrenceSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OccurrenceSpecification referenced comes before the OccurrenceSpecification referenced by after.
	 * <!-- end-user-doc -->
	 */
	def before: Option[UMLOccurrenceSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def generalOrdering_interactionFragment: Option[UMLInteractionFragment[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLGeneralOrdering
