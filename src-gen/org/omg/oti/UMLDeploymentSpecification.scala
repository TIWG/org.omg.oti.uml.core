package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A deployment specification specifies a set of properties that determine execution parameters of a component artifact that is deployed on a node. A deployment specification can be aimed at a specific type of container. An artifact that reifies or implements deployment specification properties is a deployment descriptor.
 * <!-- end-user-doc --> 
 */
trait UMLDeploymentSpecification[Uml <: UML]
  extends UMLArtifact[Uml] with operations.UMLDeploymentSpecificationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		deploymentSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDeploymentSpecification
	 */
	def deploymentSpecification_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		artifact_metaAttributes,
		  Seq (MetaAttributeStringFunction[UMLDeploymentSpecification[Uml]](None, "deploymentLocation", (x) => stringToIterable(x.deploymentLocation, null)),
		  	MetaAttributeStringFunction[UMLDeploymentSpecification[Uml]](None, "executionLocation", (x) => stringToIterable(x.executionLocation, null))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		deploymentSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDeploymentSpecification
	 */
	def deploymentSpecification_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		artifact_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		deploymentSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDeploymentSpecification
	 */
	def deploymentSpecification_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		artifact_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLDeploymentSpecification[Uml], UMLDeployment[Uml]]("deployment", _.deployment)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		deploymentSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDeploymentSpecification
	 */
	def deploymentSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		artifact_forwardReferencesFromMetamodelAssociations ++
		deployment 

	/**
	 * <!-- begin-user-doc --> 
	 * The deployment with which the DeploymentSpecification is associated.
	 * <!-- end-user-doc -->
	 */
	def deployment: Option[UMLDeployment[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The location where an Artifact is deployed onto a Node. This is typically a 'directory' or 'memory address.'
	 * <!-- end-user-doc -->
	 */
	def deploymentLocation: Option[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * The location where a component Artifact executes. This may be a local or remote location.
	 * <!-- end-user-doc -->
	 */
	def executionLocation: Option[String] 

// Start of user code for additional featuers
// End of user code

} //UMLDeploymentSpecification
