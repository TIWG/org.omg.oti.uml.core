package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Lifeline represents an individual participant in the Interaction. While parts and structural features may have multiplicity greater than 1, Lifelines represent only one interacting entity.
 * <!-- end-user-doc --> 
 */
trait UMLLifeline[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLLifelineOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		lifeline_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLifeline
	 */
	def lifeline_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		lifeline_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLifeline
	 */
	def lifeline_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLLifeline[Uml], UMLValueSpecification[Uml]]("selector", _.selector)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		lifeline_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLifeline
	 */
	def lifeline_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLLifeline[Uml], UMLInteractionFragment[Uml]]("coveredBy", _.coveredBy),
		  	MetaPropertyReference[Uml, UMLLifeline[Uml], UMLPartDecomposition[Uml]]("decomposedAs", _.decomposedAs),
		  	MetaPropertyReference[Uml, UMLLifeline[Uml], UMLInteraction[Uml]]("interaction", _.interaction),
		  	MetaPropertyReference[Uml, UMLLifeline[Uml], UMLConnectableElement[Uml]]("represents", _.represents)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		lifeline_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLifeline
	 */
	def lifeline_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		coveredBy ++
		decomposedAs ++
		interaction ++
		represents 

	/**
	 * <!-- begin-user-doc --> 
	 * References the InteractionFragments in which this Lifeline takes part.
	 * <!-- end-user-doc -->
	 */
	def coveredBy: Set[UMLInteractionFragment[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Interaction that represents the decomposition.
	 * <!-- end-user-doc -->
	 */
	def decomposedAs: Option[UMLPartDecomposition[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Interaction enclosing this Lifeline.
	 * <!-- end-user-doc -->
	 */
	def interaction: Option[UMLInteraction[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the ConnectableElement within the classifier that contains the enclosing interaction.
	 * <!-- end-user-doc -->
	 */
	def represents: Option[UMLConnectableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * If the referenced ConnectableElement is multivalued, then this specifies the specific individual part within that set.
	 * <!-- end-user-doc -->
	 */
	def selector: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def covered_events: Seq[UMLOccurrenceSpecification[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def covered_stateInvariant: Set[UMLStateInvariant[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLLifeline
