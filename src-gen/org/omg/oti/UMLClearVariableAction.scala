package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ClearVariableAction is a VariableAction that removes all values of a Variable.
 * <!-- end-user-doc --> 
 */
trait UMLClearVariableAction[Uml <: UML]
  extends UMLVariableAction[Uml] with operations.UMLClearVariableActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		clearVariableAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLClearVariableAction
	 */
	def clearVariableAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		variableAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		clearVariableAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLClearVariableAction
	 */
	def clearVariableAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		variableAction_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		clearVariableAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLClearVariableAction
	 */
	def clearVariableAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		variableAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		clearVariableAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLClearVariableAction
	 */
	def clearVariableAction_forwardReferencesFromMetamodelAssociations: Elements =
		variableAction_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLClearVariableAction
