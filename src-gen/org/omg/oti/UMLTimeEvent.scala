package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A TimeEvent is an Event that occurs at a specific point in time.
 * <!-- end-user-doc --> 
 */
trait UMLTimeEvent[Uml <: UML]
  extends UMLEvent[Uml] with operations.UMLTimeEventOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		timeEvent_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTimeEvent
	 */
	def timeEvent_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		event_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLTimeEvent[Uml]](None, "isRelative", (x) => booleanToIterable(x.isRelative, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		timeEvent_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTimeEvent
	 */
	def timeEvent_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		event_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLTimeEvent[Uml], UMLTimeExpression[Uml]]("when", _.when)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		timeEvent_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTimeEvent
	 */
	def timeEvent_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		event_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		timeEvent_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTimeEvent
	 */
	def timeEvent_forwardReferencesFromMetamodelAssociations: Elements =
		event_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether the TimeEvent is specified as an absolute or relative time.
	 * <!-- end-user-doc -->
	 */
	def isRelative: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the time of the TimeEvent.
	 * <!-- end-user-doc -->
	 */
	def when: Option[UMLTimeExpression[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLTimeEvent
