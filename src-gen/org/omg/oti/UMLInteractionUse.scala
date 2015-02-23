package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An InteractionUse refers to an Interaction. The InteractionUse is a shorthand for copying the contents of the referenced Interaction where the InteractionUse is. To be accurate the copying must take into account substituting parameters with arguments and connect the formal Gates with the actual ones.
 * <!-- end-user-doc --> 
 */
trait UMLInteractionUse[Uml <: UML]
  extends UMLInteractionFragment[Uml] with operations.UMLInteractionUseOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interactionUse_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInteractionUse
	 */
	def interactionUse_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		interactionFragment_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interactionUse_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInteractionUse
	 */
	def interactionUse_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLInteractionUse[Uml], UMLGate[Uml]]("actualGate", _.actualGate),
		  	MetaPropertyCollection[UMLInteractionUse[Uml], UMLValueSpecification[Uml]]("argument", _.argument),
		  	MetaPropertyReference[UMLInteractionUse[Uml], UMLValueSpecification[Uml]]("returnValue", _.returnValue)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interactionUse_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInteractionUse
	 */
	def interactionUse_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLInteractionUse[Uml], UMLInteraction[Uml]]("refersTo", _.refersTo),
		  	MetaPropertyReference[UMLInteractionUse[Uml], UMLProperty[Uml]]("returnValueRecipient", _.returnValueRecipient)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interactionUse_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInteractionUse
	 */
	def interactionUse_forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations ++
		refersTo ++
		returnValueRecipient 

	/**
	 * <!-- begin-user-doc --> 
	 * The actual gates of the InteractionUse.
	 * <!-- end-user-doc -->
	 */
	def actualGate: Set[UMLGate[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The actual arguments of the Interaction.
	 * <!-- end-user-doc -->
	 */
	def argument: Seq[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Refers to the Interaction that defines its meaning.
	 * <!-- end-user-doc -->
	 */
	def refersTo: Option[UMLInteraction[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The value of the executed Interaction.
	 * <!-- end-user-doc -->
	 */
	def returnValue: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The recipient of the return value.
	 * <!-- end-user-doc -->
	 */
	def returnValueRecipient: Option[UMLProperty[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLInteractionUse
