package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ProtocolTransition specifies a legal Transition for an Operation. Transitions of ProtocolStateMachines have the following information: a pre-condition (guard), a Trigger, and a post-condition. Every ProtocolTransition is associated with at most one BehavioralFeature belonging to the context Classifier of the ProtocolStateMachine.
 * <!-- end-user-doc --> 
 */
trait UMLProtocolTransition[Uml <: UML]
  extends UMLTransition[Uml] with operations.UMLProtocolTransitionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		protocolTransition_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLProtocolTransition
	 */
	def protocolTransition_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		transition_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		protocolTransition_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLProtocolTransition
	 */
	def protocolTransition_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		transition_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLProtocolTransition[Uml], UMLConstraint[Uml]]("postCondition", _.postCondition),
		  	MetaPropertyReference[Uml, UMLProtocolTransition[Uml], UMLConstraint[Uml]]("preCondition", _.preCondition)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		protocolTransition_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLProtocolTransition
	 */
	def protocolTransition_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		transition_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		protocolTransition_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLProtocolTransition
	 */
	def protocolTransition_forwardReferencesFromMetamodelAssociations: Elements =
		transition_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the post condition of the Transition which is the Condition that should be obtained once the Transition is triggered. This post condition is part of the post condition of the Operation connected to the Transition.
	 * <!-- end-user-doc -->
	 */
	def postCondition: Option[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the precondition of the Transition. It specifies the Condition that should be verified before triggering the Transition. This guard condition added to the source State will be evaluated as part of the precondition of the Operation referred by the Transition if any.
	 * <!-- end-user-doc -->
	 */
	def preCondition: Option[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * This association refers to the associated Operation. It is derived from the Operation of the CallEvent Trigger when applicable.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (trigger->collect(event)->select(oclIsKindOf(CallEvent))->collect(oclAsType(CallEvent).operation)->asSet())
	 */
	def referred: Set[UMLOperation[Uml]] = {
	    // Start of user code for "referred"
	    ???
	    // End of user code
	}

// Start of user code for additional featuers
// End of user code

} //UMLProtocolTransition
