package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An Interaction is a unit of Behavior that focuses on the observable exchange of information between connectable elements.
 * <!-- end-user-doc --> 
 */
trait UMLInteraction[Uml <: UML]
  extends UMLInteractionFragment[Uml] with UMLBehavior[Uml] with operations.UMLInteractionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interaction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInteraction
	 */
	def interaction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		interactionFragment_metaAttributes,
		behavior_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interaction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInteraction
	 */
	def interaction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_compositeMetaProperties,
		behavior_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLInteraction[Uml], UMLAction[Uml]]("action", _.action),
		  	MetaPropertyCollection[Uml, UMLInteraction[Uml], UMLGate[Uml]]("formalGate", _.formalGate),
		  	MetaPropertyCollection[Uml, UMLInteraction[Uml], UMLInteractionFragment[Uml]]("fragment", _.fragment),
		  	MetaPropertyCollection[Uml, UMLInteraction[Uml], UMLLifeline[Uml]]("lifeline", _.lifeline),
		  	MetaPropertyCollection[Uml, UMLInteraction[Uml], UMLMessage[Uml]]("message", _.message)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interaction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInteraction
	 */
	def interaction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_referenceMetaProperties,
		behavior_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interaction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInteraction
	 */
	def interaction_forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations ++
		behavior_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Actions owned by the Interaction.
	 * <!-- end-user-doc -->
	 */
	def action: Set[UMLAction[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the gates that form the message interface between this Interaction and any InteractionUses which reference it.
	 * <!-- end-user-doc -->
	 */
	def formalGate: Set[UMLGate[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ordered set of fragments in the Interaction.
	 * <!-- end-user-doc -->
	 */
	def fragment: Seq[UMLInteractionFragment[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the participants in this Interaction.
	 * <!-- end-user-doc -->
	 */
	def lifeline: Set[UMLLifeline[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Messages contained in this Interaction.
	 * <!-- end-user-doc -->
	 */
	def message: Set[UMLMessage[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def refersTo_interactionUse: Set[UMLInteractionUse[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLInteraction
