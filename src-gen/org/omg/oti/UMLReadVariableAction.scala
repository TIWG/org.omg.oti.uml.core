package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ReadVariableAction is a VariableAction that retrieves the values of a Variable.
 * <!-- end-user-doc --> 
 */
trait UMLReadVariableAction[Uml <: UML]
  extends UMLVariableAction[Uml] with operations.UMLReadVariableActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		readVariableAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReadVariableAction
	 */
	def readVariableAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		variableAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		readVariableAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReadVariableAction
	 */
	def readVariableAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		variableAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLReadVariableAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		readVariableAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReadVariableAction
	 */
	def readVariableAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		variableAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		readVariableAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReadVariableAction
	 */
	def readVariableAction_forwardReferencesFromMetamodelAssociations: Elements =
		variableAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin on which the result values are placed.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLReadVariableAction
