package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An AcceptEventAction is an Action that waits for the occurrence of one or more specific Events.
 * <!-- end-user-doc --> 
 */
trait UMLAcceptEventAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLAcceptEventActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		acceptEventAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAcceptEventAction
	 */
	def acceptEventAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLAcceptEventAction[Uml]](None, "isUnmarshall", (x) => booleanToIterable(x.isUnmarshall, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		acceptEventAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAcceptEventAction
	 */
	def acceptEventAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLAcceptEventAction[Uml], UMLOutputPin[Uml]]("result", _.result),
		  	MetaPropertyCollection[UMLAcceptEventAction[Uml], UMLTrigger[Uml]]("trigger", _.trigger)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		acceptEventAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAcceptEventAction
	 */
	def acceptEventAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		acceptEventAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAcceptEventAction
	 */
	def acceptEventAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether there is a single OutputPin for a SignalEvent occurrence, or multiple OutputPins for attribute values of the instance of the Signal associated with a SignalEvent occurrence.
	 * <!-- end-user-doc -->
	 */
	def isUnmarshall: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * OutputPins holding the values received from an Event occurrence.
	 * <!-- end-user-doc -->
	 */
	def result: Seq[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Triggers specifying the Events of which the AcceptEventAction waits for occurrences.
	 * <!-- end-user-doc -->
	 */
	def trigger: Set[UMLTrigger[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLAcceptEventAction
