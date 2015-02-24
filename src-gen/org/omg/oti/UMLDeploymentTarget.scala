package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A deployment target is the location for a deployed artifact.
 * <!-- end-user-doc --> 
 */
trait UMLDeploymentTarget[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLDeploymentTargetOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		deploymentTarget_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDeploymentTarget
	 */
	def deploymentTarget_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		deploymentTarget_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDeploymentTarget
	 */
	def deploymentTarget_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLDeploymentTarget[Uml], UMLDeployment[Uml]]("deployment", _.deployment)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		deploymentTarget_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDeploymentTarget
	 */
	def deploymentTarget_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		deploymentTarget_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDeploymentTarget
	 */
	def deploymentTarget_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of elements that are manifested in an Artifact that is involved in Deployment to a DeploymentTarget.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (deployment.deployedArtifact->select(oclIsKindOf(Artifact))->collect(oclAsType(Artifact).manifestation)->collect(utilizedElement)->asSet())
	 */
	def deployedElement: Set[UMLPackageableElement[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * The set of Deployments for a DeploymentTarget.
	 * <!-- end-user-doc -->
	 */
	def deployment: Set[UMLDeployment[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLDeploymentTarget
