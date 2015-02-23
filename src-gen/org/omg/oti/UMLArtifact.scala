package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An artifact is the specification of a physical piece of information that is used or produced by a software development process, or by deployment and operation of a system. Examples of artifacts include model files, source files, scripts, and binary executable files, a table in a database system, a development deliverable, or a word-processing document, a mail message.
An artifact is the source of a deployment to a node.
 * <!-- end-user-doc --> 
 */
trait UMLArtifact[Uml <: UML]
  extends UMLDeployedArtifact[Uml] with UMLClassifier[Uml] with operations.UMLArtifactOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		artifact_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLArtifact
	 */
	def artifact_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		deployedArtifact_metaAttributes,
		classifier_metaAttributes,
		  Seq (MetaAttributeStringFunction[UMLArtifact[Uml]](None, "fileName", (x) => stringToIterable(x.fileName, null))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		artifact_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLArtifact
	 */
	def artifact_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		deployedArtifact_compositeMetaProperties,
		classifier_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLArtifact[Uml], UMLManifestation[Uml]]("manifestation", _.manifestation),
		  	MetaPropertyCollection[UMLArtifact[Uml], UMLArtifact[Uml]]("nestedArtifact", _.nestedArtifact),
		  	MetaPropertyCollection[UMLArtifact[Uml], UMLProperty[Uml]]("ownedAttribute", _.ownedAttribute),
		  	MetaPropertyCollection[UMLArtifact[Uml], UMLOperation[Uml]]("ownedOperation", _.ownedOperation)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		artifact_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLArtifact
	 */
	def artifact_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		deployedArtifact_referenceMetaProperties,
		classifier_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		artifact_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLArtifact
	 */
	def artifact_forwardReferencesFromMetamodelAssociations: Elements =
		deployedArtifact_forwardReferencesFromMetamodelAssociations ++
		classifier_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * A concrete name that is used to refer to the Artifact in a physical context. Example: file system name, universal resource locator.
	 * <!-- end-user-doc -->
	 */
	def fileName: Option[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of model elements that are manifested in the Artifact. That is, these model elements are utilized in the construction (or generation) of the artifact.
	 * <!-- end-user-doc -->
	 */
	def manifestation: Set[UMLManifestation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Artifacts that are defined (nested) within the Artifact. The association is a specialization of the ownedMember association from Namespace to NamedElement.
	 * <!-- end-user-doc -->
	 */
	def nestedArtifact: Set[UMLArtifact[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The attributes or association ends defined for the Artifact. The association is a specialization of the ownedMember association.
	 * <!-- end-user-doc -->
	 */
	def ownedAttribute: Seq[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Operations defined for the Artifact. The association is a specialization of the ownedMember association.
	 * <!-- end-user-doc -->
	 */
	def ownedOperation: Seq[UMLOperation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def nestedArtifact_artifact: Option[UMLArtifact[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLArtifact
