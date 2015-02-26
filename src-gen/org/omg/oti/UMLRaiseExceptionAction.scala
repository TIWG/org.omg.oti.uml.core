package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A RaiseExceptionAction is an Action that causes an exception to occur. The input value becomes the exception object.
 * <!-- end-user-doc --> 
 */
trait UMLRaiseExceptionAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLRaiseExceptionActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		raiseExceptionAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLRaiseExceptionAction
	 */
	def raiseExceptionAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		raiseExceptionAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLRaiseExceptionAction
	 */
	def raiseExceptionAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLRaiseExceptionAction[Uml], UMLInputPin[Uml]]("exception", _.exception)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		raiseExceptionAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLRaiseExceptionAction
	 */
	def raiseExceptionAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		raiseExceptionAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLRaiseExceptionAction
	 */
	def raiseExceptionAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * An InputPin whose value becomes the exception object.
	 * <!-- end-user-doc -->
	 */
	def exception: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLRaiseExceptionAction
