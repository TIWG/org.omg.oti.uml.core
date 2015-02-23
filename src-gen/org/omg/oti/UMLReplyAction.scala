package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ReplyAction is an Action that accepts a set of reply values and a value containing return information produced by a previous AcceptCallAction. The ReplyAction returns the values to the caller of the previous call, completing execution of the call.
 * <!-- end-user-doc --> 
 */
trait UMLReplyAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLReplyActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		replyAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReplyAction
	 */
	def replyAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		replyAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReplyAction
	 */
	def replyAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLReplyAction[Uml], UMLInputPin[Uml]]("replyValue", _.replyValue),
		  	MetaPropertyReference[UMLReplyAction[Uml], UMLInputPin[Uml]]("returnInformation", _.returnInformation)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		replyAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReplyAction
	 */
	def replyAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLReplyAction[Uml], UMLTrigger[Uml]]("replyToCall", _.replyToCall)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		replyAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReplyAction
	 */
	def replyAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		replyToCall 

	/**
	 * <!-- begin-user-doc --> 
	 * The Trigger specifying the Operation whose call is being replied to.
	 * <!-- end-user-doc -->
	 */
	def replyToCall: Option[UMLTrigger[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A list of InputPins providing the values for the output (inout, out, and return) Parameters of the Operation. These values are returned to the caller.
	 * <!-- end-user-doc -->
	 */
	def replyValue: Seq[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An InputPin that holds the return information value produced by an earlier AcceptCallAction.
	 * <!-- end-user-doc -->
	 */
	def returnInformation: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLReplyAction
