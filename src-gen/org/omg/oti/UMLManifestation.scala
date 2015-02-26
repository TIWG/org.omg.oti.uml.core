package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A manifestation is the concrete physical rendering of one or more model elements by an artifact.
 * <!-- end-user-doc --> 
 */
trait UMLManifestation[Uml <: UML]
  extends UMLAbstraction[Uml] with operations.UMLManifestationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		manifestation_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLManifestation
	 */
	def manifestation_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		abstraction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		manifestation_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLManifestation
	 */
	def manifestation_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		abstraction_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		manifestation_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLManifestation
	 */
	def manifestation_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		abstraction_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLManifestation[Uml], UMLPackageableElement[Uml]]("utilizedElement", _.utilizedElement)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		manifestation_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLManifestation
	 */
	def manifestation_forwardReferencesFromMetamodelAssociations: Elements =
		abstraction_forwardReferencesFromMetamodelAssociations ++
		utilizedElement 

	/**
	 * <!-- begin-user-doc --> 
	 * The model element that is utilized in the manifestation in an Artifact.
	 * <!-- end-user-doc -->
	 */
	def utilizedElement: Option[UMLPackageableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def manifestation_artifact: Option[UMLArtifact[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLManifestation
