package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A StartObjectBehaviorAction is an InvocationAction that starts the execution either of a directly instantiated Behavior or of the classifierBehavior of an object. Argument values may be supplied for the input Parameters of the Behavior. If the Behavior is invoked synchronously, then output values may be obtained for output Parameters.
 * <!-- end-user-doc --> 
 */
trait UMLStartObjectBehaviorAction[Uml <: UML]
  extends UMLCallAction[Uml] with operations.UMLStartObjectBehaviorActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		startObjectBehaviorAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStartObjectBehaviorAction
	 */
	def startObjectBehaviorAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		callAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		startObjectBehaviorAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStartObjectBehaviorAction
	 */
	def startObjectBehaviorAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		callAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLStartObjectBehaviorAction[Uml], UMLInputPin[Uml]]("object", _._object)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		startObjectBehaviorAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStartObjectBehaviorAction
	 */
	def startObjectBehaviorAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		callAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		startObjectBehaviorAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStartObjectBehaviorAction
	 */
	def startObjectBehaviorAction_forwardReferencesFromMetamodelAssociations: Elements =
		callAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * An InputPin that holds the object that is either a Behavior to be started or has a classifierBehavior to be started.
	 * <!-- end-user-doc -->
	 */
	def _object: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLStartObjectBehaviorAction
