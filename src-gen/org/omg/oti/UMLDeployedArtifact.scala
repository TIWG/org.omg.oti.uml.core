package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A deployed artifact is an artifact or artifact instance that has been deployed to a deployment target.
 * <!-- end-user-doc --> 
 */
trait UMLDeployedArtifact[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLDeployedArtifactOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		deployedArtifact_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDeployedArtifact
	 */
	def deployedArtifact_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		deployedArtifact_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDeployedArtifact
	 */
	def deployedArtifact_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		deployedArtifact_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDeployedArtifact
	 */
	def deployedArtifact_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		deployedArtifact_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDeployedArtifact
	 */
	def deployedArtifact_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		Set () 


	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def deployedArtifact_deploymentForArtifact: Set[UMLDeployment[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLDeployedArtifact
