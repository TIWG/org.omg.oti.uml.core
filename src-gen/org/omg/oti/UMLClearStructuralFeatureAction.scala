package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ClearStructuralFeatureAction is a StructuralFeatureAction that removes all values of a StructuralFeature.
 * <!-- end-user-doc --> 
 */
trait UMLClearStructuralFeatureAction[Uml <: UML]
  extends UMLStructuralFeatureAction[Uml] with operations.UMLClearStructuralFeatureActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		clearStructuralFeatureAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLClearStructuralFeatureAction
	 */
	def clearStructuralFeatureAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		structuralFeatureAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		clearStructuralFeatureAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLClearStructuralFeatureAction
	 */
	def clearStructuralFeatureAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuralFeatureAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLClearStructuralFeatureAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		clearStructuralFeatureAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLClearStructuralFeatureAction
	 */
	def clearStructuralFeatureAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuralFeatureAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		clearStructuralFeatureAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLClearStructuralFeatureAction
	 */
	def clearStructuralFeatureAction_forwardReferencesFromMetamodelAssociations: Elements =
		structuralFeatureAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin on which is put the input object as modified by the ClearStructuralFeatureAction.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLClearStructuralFeatureAction
