package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An Event is the specification of some occurrence that may potentially trigger effects by an object.
 * <!-- end-user-doc --> 
 */
trait UMLEvent[Uml <: UML]
  extends UMLPackageableElement[Uml] with operations.UMLEventOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		event_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLEvent
	 */
	def event_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		packageableElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		event_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLEvent
	 */
	def event_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		packageableElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		event_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLEvent
	 */
	def event_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		packageableElement_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		event_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLEvent
	 */
	def event_forwardReferencesFromMetamodelAssociations: Elements =
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		Set () 


	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def event_trigger: Set[UMLTrigger[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLEvent
