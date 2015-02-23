package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An InstanceSpecification is a model element that represents an instance in a modeled system. An InstanceSpecification can act as a DeploymentTarget in a Deployment relationship, in the case that it represents an instance of a Node. It can also act as a DeployedArtifact, if it represents an instance of an Artifact.
 * <!-- end-user-doc --> 
 */
trait UMLInstanceSpecification[Uml <: UML]
  extends UMLDeploymentTarget[Uml] with UMLDeployedArtifact[Uml] with UMLPackageableElement[Uml] with operations.UMLInstanceSpecificationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		instanceSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInstanceSpecification
	 */
	def instanceSpecification_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		deploymentTarget_metaAttributes,
		deployedArtifact_metaAttributes,
		packageableElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		instanceSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInstanceSpecification
	 */
	def instanceSpecification_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		deploymentTarget_compositeMetaProperties,
		deployedArtifact_compositeMetaProperties,
		packageableElement_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLInstanceSpecification[Uml], UMLSlot[Uml]]("slot", _.slot),
		  	MetaPropertyReference[UMLInstanceSpecification[Uml], UMLValueSpecification[Uml]]("specification", _.specification)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		instanceSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInstanceSpecification
	 */
	def instanceSpecification_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		deploymentTarget_referenceMetaProperties,
		deployedArtifact_referenceMetaProperties,
		packageableElement_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLInstanceSpecification[Uml], UMLClassifier[Uml]]("classifier", _.classifier)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		instanceSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInstanceSpecification
	 */
	def instanceSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		deploymentTarget_forwardReferencesFromMetamodelAssociations ++
		deployedArtifact_forwardReferencesFromMetamodelAssociations ++
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		classifier 

	/**
	 * <!-- begin-user-doc --> 
	 * The Classifier or Classifiers of the represented instance. If multiple Classifiers are specified, the instance is classified by all of them.
	 * <!-- end-user-doc -->
	 */
	def classifier: Iterable[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A Slot giving the value or values of a StructuralFeature of the instance. An InstanceSpecification can have one Slot per StructuralFeature of its Classifiers, including inherited features. It is not necessary to model a Slot for every StructuralFeature, in which case the InstanceSpecification is a partial description.
	 * <!-- end-user-doc -->
	 */
	def slot: Set[UMLSlot[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A specification of how to compute, derive, or construct the instance.
	 * <!-- end-user-doc -->
	 */
	def specification: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def instance_instanceValue: Set[UMLInstanceValue[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLInstanceSpecification
