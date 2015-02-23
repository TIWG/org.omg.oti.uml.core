package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A StartClassifierBehaviorAction is an Action that starts the classifierBehavior of the input object.
 * <!-- end-user-doc --> 
 */
trait UMLStartClassifierBehaviorAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLStartClassifierBehaviorActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		startClassifierBehaviorAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStartClassifierBehaviorAction
	 */
	def startClassifierBehaviorAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		startClassifierBehaviorAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStartClassifierBehaviorAction
	 */
	def startClassifierBehaviorAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLStartClassifierBehaviorAction[Uml], UMLInputPin[Uml]]("object", _._object)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		startClassifierBehaviorAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStartClassifierBehaviorAction
	 */
	def startClassifierBehaviorAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		startClassifierBehaviorAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStartClassifierBehaviorAction
	 */
	def startClassifierBehaviorAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that holds the object whose classifierBehavior is to be started.
	 * <!-- end-user-doc -->
	 */
	def _object: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLStartClassifierBehaviorAction
