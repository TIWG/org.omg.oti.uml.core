package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Gate is a MessageEnd which serves as a connection point for relating a Message which has a MessageEnd (sendEvent / receiveEvent) outside an InteractionFragment with another Message which has a MessageEnd (receiveEvent / sendEvent)  inside that InteractionFragment.
 * <!-- end-user-doc --> 
 */
trait UMLGate[Uml <: UML]
  extends UMLMessageEnd[Uml] with operations.UMLGateOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		gate_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLGate
	 */
	def gate_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		messageEnd_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		gate_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLGate
	 */
	def gate_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		messageEnd_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		gate_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLGate
	 */
	def gate_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		messageEnd_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		gate_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLGate
	 */
	def gate_forwardReferencesFromMetamodelAssociations: Elements =
		messageEnd_forwardReferencesFromMetamodelAssociations ++
		Set () 


	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def cfragmentGate_combinedFragment: Option[UMLCombinedFragment[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def formalGate_interaction: Option[UMLInteraction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def actualGate_interactionUse: Option[UMLInteractionUse[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLGate
