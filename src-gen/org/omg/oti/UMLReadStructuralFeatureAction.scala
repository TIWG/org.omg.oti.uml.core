package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ReadStructuralFeatureAction is a StructuralFeatureAction that retrieves the values of a StructuralFeature.
 * <!-- end-user-doc --> 
 */
trait UMLReadStructuralFeatureAction[Uml <: UML]
  extends UMLStructuralFeatureAction[Uml] with operations.UMLReadStructuralFeatureActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		readStructuralFeatureAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReadStructuralFeatureAction
	 */
	def readStructuralFeatureAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		structuralFeatureAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		readStructuralFeatureAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReadStructuralFeatureAction
	 */
	def readStructuralFeatureAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuralFeatureAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLReadStructuralFeatureAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		readStructuralFeatureAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReadStructuralFeatureAction
	 */
	def readStructuralFeatureAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuralFeatureAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		readStructuralFeatureAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReadStructuralFeatureAction
	 */
	def readStructuralFeatureAction_forwardReferencesFromMetamodelAssociations: Elements =
		structuralFeatureAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin on which the result values are placed.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLReadStructuralFeatureAction
