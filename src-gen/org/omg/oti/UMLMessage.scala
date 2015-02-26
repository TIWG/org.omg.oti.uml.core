package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Message defines a particular communication between Lifelines of an Interaction.
 * <!-- end-user-doc --> 
 */
trait UMLMessage[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLMessageOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		message_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLMessage
	 */
	def message_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		message_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLMessage
	 */
	def message_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLMessage[Uml], UMLValueSpecification[Uml]]("argument", _.argument)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		message_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLMessage
	 */
	def message_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLMessage[Uml], UMLConnector[Uml]]("connector", _.connector),
		  	MetaPropertyReference[Uml, UMLMessage[Uml], UMLInteraction[Uml]]("interaction", _.interaction),
		  	MetaPropertyReference[Uml, UMLMessage[Uml], UMLMessageEnd[Uml]]("receiveEvent", _.receiveEvent),
		  	MetaPropertyReference[Uml, UMLMessage[Uml], UMLMessageEnd[Uml]]("sendEvent", _.sendEvent),
		  	MetaPropertyReference[Uml, UMLMessage[Uml], UMLNamedElement[Uml]]("signature", _.signature)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		message_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLMessage
	 */
	def message_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		connector ++
		interaction ++
		receiveEvent ++
		sendEvent ++
		signature 

	/**
	 * <!-- begin-user-doc --> 
	 * The arguments of the Message.
	 * <!-- end-user-doc -->
	 */
	def argument: Seq[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Connector on which this Message is sent.
	 * <!-- end-user-doc -->
	 */
	def connector: Option[UMLConnector[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The enclosing Interaction owning the Message.
	 * <!-- end-user-doc -->
	 */
	def interaction: Option[UMLInteraction[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The derived kind of the Message (complete, lost, found, or unknown).
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (messageKind)
	 */
	def messageKind: UMLMessageKind.Value

	/**
	 * <!-- begin-user-doc --> 
	 * The sort of communication reflected by the Message.
	 * <!-- end-user-doc -->
	 */
	def messageSort: UMLMessageSort.Value

	/**
	 * <!-- begin-user-doc --> 
	 * References the Receiving of the Message.
	 * <!-- end-user-doc -->
	 */
	def receiveEvent: Option[UMLMessageEnd[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Sending of the Message.
	 * <!-- end-user-doc -->
	 */
	def sendEvent: Option[UMLMessageEnd[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The signature of the Message is the specification of its content. It refers either an Operation or a Signal.
	 * <!-- end-user-doc -->
	 */
	def signature: Option[UMLNamedElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def message_messageEnd: Set[UMLMessageEnd[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def realizingMessage_informationFlow: Set[UMLInformationFlow[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLMessage
