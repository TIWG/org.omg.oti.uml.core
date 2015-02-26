package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ActionInputPin is a kind of InputPin that executes an Action to determine the values to input to another Action.
 * <!-- end-user-doc --> 
 */
trait UMLActionInputPin[Uml <: UML]
  extends UMLInputPin[Uml] with operations.UMLActionInputPinOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		actionInputPin_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActionInputPin
	 */
	def actionInputPin_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		inputPin_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		actionInputPin_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActionInputPin
	 */
	def actionInputPin_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		inputPin_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLActionInputPin[Uml], UMLAction[Uml]]("fromAction", _.fromAction)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		actionInputPin_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActionInputPin
	 */
	def actionInputPin_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		inputPin_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		actionInputPin_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActionInputPin
	 */
	def actionInputPin_forwardReferencesFromMetamodelAssociations: Elements =
		inputPin_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The Action used to provide the values of the ActionInputPin.
	 * <!-- end-user-doc -->
	 */
	def fromAction: Option[UMLAction[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLActionInputPin
