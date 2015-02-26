package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An InterfaceRealization is a specialized realization relationship between a BehavioredClassifier and an Interface. This relationship signifies that the realizing BehavioredClassifier conforms to the contract specified by the Interface.
 * <!-- end-user-doc --> 
 */
trait UMLInterfaceRealization[Uml <: UML]
  extends UMLRealization[Uml] with operations.UMLInterfaceRealizationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interfaceRealization_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInterfaceRealization
	 */
	def interfaceRealization_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		realization_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interfaceRealization_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInterfaceRealization
	 */
	def interfaceRealization_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		realization_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interfaceRealization_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInterfaceRealization
	 */
	def interfaceRealization_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		realization_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLInterfaceRealization[Uml], UMLInterface[Uml]]("contract", _.contract),
		  	MetaPropertyReference[Uml, UMLInterfaceRealization[Uml], UMLBehavioredClassifier[Uml]]("implementingClassifier", _.implementingClassifier)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interfaceRealization_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInterfaceRealization
	 */
	def interfaceRealization_forwardReferencesFromMetamodelAssociations: Elements =
		realization_forwardReferencesFromMetamodelAssociations ++
		contract ++
		implementingClassifier 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Interface specifying the conformance contract.
	 * <!-- end-user-doc -->
	 */
	def contract: Option[UMLInterface[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the BehavioredClassifier that owns this InterfaceRealization, i.e., the BehavioredClassifier that realizes the Interface to which it refers.
	 * <!-- end-user-doc -->
	 */
	def implementingClassifier: Option[UMLBehavioredClassifier[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLInterfaceRealization
