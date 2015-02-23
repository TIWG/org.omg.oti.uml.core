package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * WriteVariableAction is an abstract class for VariableActions that change Variable values.
 * <!-- end-user-doc --> 
 */
trait UMLWriteVariableAction[Uml <: UML]
  extends UMLVariableAction[Uml] with operations.UMLWriteVariableActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		writeVariableAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLWriteVariableAction
	 */
	def writeVariableAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		variableAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		writeVariableAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLWriteVariableAction
	 */
	def writeVariableAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		variableAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLWriteVariableAction[Uml], UMLInputPin[Uml]]("value", _.value)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		writeVariableAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLWriteVariableAction
	 */
	def writeVariableAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		variableAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		writeVariableAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLWriteVariableAction
	 */
	def writeVariableAction_forwardReferencesFromMetamodelAssociations: Elements =
		variableAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that gives the value to be added or removed from the Variable.
	 * <!-- end-user-doc -->
	 */
	def value: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLWriteVariableAction
