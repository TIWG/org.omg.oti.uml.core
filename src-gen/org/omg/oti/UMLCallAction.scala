package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * CallAction is an abstract class for Actions that invoke a Behavior with given argument values and (if the invocation is synchronous) receive reply values.
 * <!-- end-user-doc --> 
 */
trait UMLCallAction[Uml <: UML]
  extends UMLInvocationAction[Uml] with operations.UMLCallActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		callAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCallAction
	 */
	def callAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		invocationAction_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLCallAction[Uml]](None, "isSynchronous", (x) => booleanToIterable(x.isSynchronous, true))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		callAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCallAction
	 */
	def callAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		invocationAction_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLCallAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		callAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCallAction
	 */
	def callAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		invocationAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		callAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCallAction
	 */
	def callAction_forwardReferencesFromMetamodelAssociations: Elements =
		invocationAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * If true, the call is synchronous and the caller waits for completion of the invoked Behavior. If false, the call is asynchronous and the caller proceeds immediately and cannot receive return values.
	 * <!-- end-user-doc -->
	 */
	def isSynchronous: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPins on which the reply values from the invocation are placed (if the call is synchronous).
	 * <!-- end-user-doc -->
	 */
	def result: Seq[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLCallAction
