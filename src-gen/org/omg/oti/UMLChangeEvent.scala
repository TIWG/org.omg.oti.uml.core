package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ChangeEvent models a change in the system configuration that makes a condition true.
 * <!-- end-user-doc --> 
 */
trait UMLChangeEvent[Uml <: UML]
  extends UMLEvent[Uml] with operations.UMLChangeEventOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		changeEvent_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLChangeEvent
	 */
	def changeEvent_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		event_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		changeEvent_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLChangeEvent
	 */
	def changeEvent_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		event_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLChangeEvent[Uml], UMLValueSpecification[Uml]]("changeExpression", _.changeExpression)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		changeEvent_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLChangeEvent
	 */
	def changeEvent_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		event_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		changeEvent_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLChangeEvent
	 */
	def changeEvent_forwardReferencesFromMetamodelAssociations: Elements =
		event_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * A Boolean-valued ValueSpecification that will result in a ChangeEvent whenever its value changes from false to true.
	 * <!-- end-user-doc -->
	 */
	def changeExpression: Option[UMLValueSpecification[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLChangeEvent
