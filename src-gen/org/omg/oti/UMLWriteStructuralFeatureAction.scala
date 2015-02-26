package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * WriteStructuralFeatureAction is an abstract class for StructuralFeatureActions that change StructuralFeature values.
 * <!-- end-user-doc --> 
 */
trait UMLWriteStructuralFeatureAction[Uml <: UML]
  extends UMLStructuralFeatureAction[Uml] with operations.UMLWriteStructuralFeatureActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		writeStructuralFeatureAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLWriteStructuralFeatureAction
	 */
	def writeStructuralFeatureAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		structuralFeatureAction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		writeStructuralFeatureAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLWriteStructuralFeatureAction
	 */
	def writeStructuralFeatureAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuralFeatureAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLWriteStructuralFeatureAction[Uml], UMLOutputPin[Uml]]("result", _.result),
		  	MetaPropertyReference[Uml, UMLWriteStructuralFeatureAction[Uml], UMLInputPin[Uml]]("value", _.value)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		writeStructuralFeatureAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLWriteStructuralFeatureAction
	 */
	def writeStructuralFeatureAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuralFeatureAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		writeStructuralFeatureAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLWriteStructuralFeatureAction
	 */
	def writeStructuralFeatureAction_forwardReferencesFromMetamodelAssociations: Elements =
		structuralFeatureAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin on which is put the input object as modified by the WriteStructuralFeatureAction.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that provides the value to be added or removed from the StructuralFeature.
	 * <!-- end-user-doc -->
	 */
	def value: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLWriteStructuralFeatureAction
