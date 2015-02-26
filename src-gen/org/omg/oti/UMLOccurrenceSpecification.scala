package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An OccurrenceSpecification is the basic semantic unit of Interactions. The sequences of occurrences specified by them are the meanings of Interactions.
 * <!-- end-user-doc --> 
 */
trait UMLOccurrenceSpecification[Uml <: UML]
  extends UMLInteractionFragment[Uml] with operations.UMLOccurrenceSpecificationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		occurrenceSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLOccurrenceSpecification
	 */
	def occurrenceSpecification_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		interactionFragment_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		occurrenceSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLOccurrenceSpecification
	 */
	def occurrenceSpecification_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		occurrenceSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLOccurrenceSpecification
	 */
	def occurrenceSpecification_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLOccurrenceSpecification[Uml], UMLLifeline[Uml]]("covered", _.covered),
		  	MetaPropertyCollection[Uml, UMLOccurrenceSpecification[Uml], UMLGeneralOrdering[Uml]]("toAfter", _.toAfter),
		  	MetaPropertyCollection[Uml, UMLOccurrenceSpecification[Uml], UMLGeneralOrdering[Uml]]("toBefore", _.toBefore)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		occurrenceSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLOccurrenceSpecification
	 */
	def occurrenceSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations ++
		covered ++
		toAfter ++
		toBefore 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Lifeline on which the OccurrenceSpecification appears.
	 * <!-- end-user-doc -->
	 */
	override def covered: Iterable[UMLLifeline[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the GeneralOrderings that specify EventOcurrences that must occur after this OccurrenceSpecification.
	 * <!-- end-user-doc -->
	 */
	def toAfter: Set[UMLGeneralOrdering[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the GeneralOrderings that specify EventOcurrences that must occur before this OccurrenceSpecification.
	 * <!-- end-user-doc -->
	 */
	def toBefore: Set[UMLGeneralOrdering[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def finish_executionSpecification: Set[UMLExecutionSpecification[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def start_executionSpecification: Set[UMLExecutionSpecification[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLOccurrenceSpecification
