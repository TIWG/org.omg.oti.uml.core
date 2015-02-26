package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An AcceptCallAction is an AcceptEventAction that handles the receipt of a synchronous call request. In addition to the values from the Operation input parameters, the Action produces an output that is needed later to supply the information to the ReplyAction necessary to return control to the caller. An AcceptCallAction is for synchronous calls. If it is used to handle an asynchronous call, execution of the subsequent ReplyAction will complete immediately with no effect.
 * <!-- end-user-doc --> 
 */
trait UMLAcceptCallAction[Uml <: UML]
  extends UMLAcceptEventAction[Uml] with operations.UMLAcceptCallActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		acceptCallAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAcceptCallAction
	 */
	def acceptCallAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		acceptEventAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		acceptCallAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAcceptCallAction
	 */
	def acceptCallAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		acceptEventAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLAcceptCallAction[Uml], UMLOutputPin[Uml]]("returnInformation", _.returnInformation)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		acceptCallAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAcceptCallAction
	 */
	def acceptCallAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		acceptEventAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		acceptCallAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAcceptCallAction
	 */
	def acceptCallAction_forwardReferencesFromMetamodelAssociations: Elements =
		acceptEventAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * An OutputPin where a value is placed containing sufficient information to perform a subsequent ReplyAction and return control to the caller. The contents of this value are opaque. It can be passed and copied but it cannot be manipulated by the model.
	 * <!-- end-user-doc -->
	 */
	def returnInformation: Option[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLAcceptCallAction
