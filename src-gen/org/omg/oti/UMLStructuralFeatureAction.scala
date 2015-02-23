package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * StructuralFeatureAction is an abstract class for all Actions that operate on StructuralFeatures.
 * <!-- end-user-doc --> 
 */
trait UMLStructuralFeatureAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLStructuralFeatureActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		structuralFeatureAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStructuralFeatureAction
	 */
	def structuralFeatureAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		structuralFeatureAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStructuralFeatureAction
	 */
	def structuralFeatureAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLStructuralFeatureAction[Uml], UMLInputPin[Uml]]("object", _._object)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		structuralFeatureAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStructuralFeatureAction
	 */
	def structuralFeatureAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLStructuralFeatureAction[Uml], UMLStructuralFeature[Uml]]("structuralFeature", _.structuralFeature)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		structuralFeatureAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStructuralFeatureAction
	 */
	def structuralFeatureAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		structuralFeature 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin from which the object whose StructuralFeature is to be read or written is obtained.
	 * <!-- end-user-doc -->
	 */
	def _object: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The StructuralFeature to be read or written.
	 * <!-- end-user-doc -->
	 */
	def structuralFeature: Option[UMLStructuralFeature[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLStructuralFeatureAction
