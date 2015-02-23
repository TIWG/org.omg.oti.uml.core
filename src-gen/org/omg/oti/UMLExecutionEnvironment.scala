package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An execution environment is a node that offers an execution environment for specific types of components that are deployed on it in the form of executable artifacts.
 * <!-- end-user-doc --> 
 */
trait UMLExecutionEnvironment[Uml <: UML]
  extends UMLNode[Uml] with operations.UMLExecutionEnvironmentOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		executionEnvironment_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExecutionEnvironment
	 */
	def executionEnvironment_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		node_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		executionEnvironment_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExecutionEnvironment
	 */
	def executionEnvironment_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		node_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		executionEnvironment_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExecutionEnvironment
	 */
	def executionEnvironment_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		node_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		executionEnvironment_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExecutionEnvironment
	 */
	def executionEnvironment_forwardReferencesFromMetamodelAssociations: Elements =
		node_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLExecutionEnvironment
