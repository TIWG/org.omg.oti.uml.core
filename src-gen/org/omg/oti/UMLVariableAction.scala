package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * VariableAction is an abstract class for Actions that operate on a specified Variable.
 * <!-- end-user-doc --> 
 */
trait UMLVariableAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLVariableActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		variableAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLVariableAction
	 */
	def variableAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		variableAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLVariableAction
	 */
	def variableAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		variableAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLVariableAction
	 */
	def variableAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLVariableAction[Uml], UMLVariable[Uml]]("variable", _.variable)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		variableAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLVariableAction
	 */
	def variableAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		variable 

	/**
	 * <!-- begin-user-doc --> 
	 * The Variable to be read or written.
	 * <!-- end-user-doc -->
	 */
	def variable: Option[UMLVariable[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLVariableAction
