package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A special kind of State, which, when entered, signifies that the enclosing Region has completed. If the enclosing Region is directly contained in a StateMachine and all other Regions in that StateMachine also are completed, then it means that the entire StateMachine behavior is completed.
 * <!-- end-user-doc --> 
 */
trait UMLFinalState[Uml <: UML]
  extends UMLState[Uml] with operations.UMLFinalStateOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		finalState_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLFinalState
	 */
	def finalState_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		state_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		finalState_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLFinalState
	 */
	def finalState_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		state_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		finalState_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLFinalState
	 */
	def finalState_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		state_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		finalState_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLFinalState
	 */
	def finalState_forwardReferencesFromMetamodelAssociations: Elements =
		state_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLFinalState
