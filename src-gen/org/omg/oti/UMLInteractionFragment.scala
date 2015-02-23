package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * InteractionFragment is an abstract notion of the most general interaction unit. An InteractionFragment is a piece of an Interaction. Each InteractionFragment is conceptually like an Interaction by itself.
 * <!-- end-user-doc --> 
 */
trait UMLInteractionFragment[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLInteractionFragmentOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interactionFragment_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInteractionFragment
	 */
	def interactionFragment_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interactionFragment_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInteractionFragment
	 */
	def interactionFragment_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLInteractionFragment[Uml], UMLGeneralOrdering[Uml]]("generalOrdering", _.generalOrdering)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interactionFragment_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInteractionFragment
	 */
	def interactionFragment_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLInteractionFragment[Uml], UMLLifeline[Uml]]("covered", _.covered),
		  	MetaPropertyReference[UMLInteractionFragment[Uml], UMLInteraction[Uml]]("enclosingInteraction", _.enclosingInteraction),
		  	MetaPropertyReference[UMLInteractionFragment[Uml], UMLInteractionOperand[Uml]]("enclosingOperand", _.enclosingOperand)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInteractionFragment
	 */
	def interactionFragment_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		covered ++
		enclosingInteraction ++
		enclosingOperand 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Lifelines that the InteractionFragment involves.
	 * <!-- end-user-doc -->
	 */
	def covered: Iterable[UMLLifeline[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Interaction enclosing this InteractionFragment.
	 * <!-- end-user-doc -->
	 */
	def enclosingInteraction: Option[UMLInteraction[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The operand enclosing this InteractionFragment (they may nest recursively).
	 * <!-- end-user-doc -->
	 */
	def enclosingOperand: Option[UMLInteractionOperand[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The general ordering relationships contained in this fragment.
	 * <!-- end-user-doc -->
	 */
	def generalOrdering: Set[UMLGeneralOrdering[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLInteractionFragment
