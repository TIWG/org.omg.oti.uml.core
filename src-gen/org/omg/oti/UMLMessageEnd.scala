package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * MessageEnd is an abstract specialization of NamedElement that represents what can occur at the end of a Message.
 * <!-- end-user-doc --> 
 */
trait UMLMessageEnd[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLMessageEndOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		messageEnd_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLMessageEnd
	 */
	def messageEnd_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		messageEnd_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLMessageEnd
	 */
	def messageEnd_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		messageEnd_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLMessageEnd
	 */
	def messageEnd_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLMessageEnd[Uml], UMLMessage[Uml]]("message", _.message)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		messageEnd_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLMessageEnd
	 */
	def messageEnd_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		message 

	/**
	 * <!-- begin-user-doc --> 
	 * References a Message.
	 * <!-- end-user-doc -->
	 */
	def message: Option[UMLMessage[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def receiveEvent_endMessage: Option[UMLMessage[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def sendEvent_endMessage: Option[UMLMessage[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLMessageEnd
