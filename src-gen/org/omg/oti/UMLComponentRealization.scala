package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * Realization is specialized to (optionally) define the Classifiers that realize the contract offered by a Component in terms of its provided and required Interfaces. The Component forms an abstraction from these various Classifiers.
 * <!-- end-user-doc --> 
 */
trait UMLComponentRealization[Uml <: UML]
  extends UMLRealization[Uml] with operations.UMLComponentRealizationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		componentRealization_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLComponentRealization
	 */
	def componentRealization_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		realization_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		componentRealization_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLComponentRealization
	 */
	def componentRealization_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		realization_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		componentRealization_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLComponentRealization
	 */
	def componentRealization_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		realization_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLComponentRealization[Uml], UMLComponent[Uml]]("abstraction", _.abstraction),
		  	MetaPropertyCollection[Uml, UMLComponentRealization[Uml], UMLClassifier[Uml]]("realizingClassifier", _.realizingClassifier)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		componentRealization_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLComponentRealization
	 */
	def componentRealization_forwardReferencesFromMetamodelAssociations: Elements =
		realization_forwardReferencesFromMetamodelAssociations ++
		abstraction ++
		realizingClassifier 

	/**
	 * <!-- begin-user-doc --> 
	 * The Component that owns this ComponentRealization and which is implemented by its realizing Classifiers.
	 * <!-- end-user-doc -->
	 */
	def abstraction: Option[UMLComponent[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Classifiers that are involved in the implementation of the Component that owns this Realization.
	 * <!-- end-user-doc -->
	 */
	def realizingClassifier: Set[UMLClassifier[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLComponentRealization
