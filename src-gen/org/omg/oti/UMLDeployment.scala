package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A deployment is the allocation of an artifact or artifact instance to a deployment target.
A component deployment is the deployment of one or more artifacts or artifact instances to a deployment target, optionally parameterized by a deployment specification. Examples are executables and configuration files.
 * <!-- end-user-doc --> 
 */
trait UMLDeployment[Uml <: UML]
  extends UMLDependency[Uml] with operations.UMLDeploymentOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		deployment_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDeployment
	 */
	def deployment_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		dependency_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		deployment_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDeployment
	 */
	def deployment_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		dependency_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLDeployment[Uml], UMLDeploymentSpecification[Uml]]("configuration", _.configuration)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		deployment_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDeployment
	 */
	def deployment_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		dependency_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLDeployment[Uml], UMLDeployedArtifact[Uml]]("deployedArtifact", _.deployedArtifact),
		  	MetaPropertyReference[UMLDeployment[Uml], UMLDeploymentTarget[Uml]]("location", _.location)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		deployment_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDeployment
	 */
	def deployment_forwardReferencesFromMetamodelAssociations: Elements =
		dependency_forwardReferencesFromMetamodelAssociations ++
		deployedArtifact ++
		location 

	/**
	 * <!-- begin-user-doc --> 
	 * The specification of properties that parameterize the deployment and execution of one or more Artifacts.
	 * <!-- end-user-doc -->
	 */
	def configuration: Set[UMLDeploymentSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Artifacts that are deployed onto a Node. This association specializes the supplier association.
	 * <!-- end-user-doc -->
	 */
	def deployedArtifact: Set[UMLDeployedArtifact[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The DeployedTarget which is the target of a Deployment.
	 * <!-- end-user-doc -->
	 */
	def location: Option[UMLDeploymentTarget[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLDeployment
