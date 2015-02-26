package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A StructuralFeature is a typed feature of a Classifier that specifies the structure of instances of the Classifier.
 * <!-- end-user-doc --> 
 */
trait UMLStructuralFeature[Uml <: UML]
  extends UMLTypedElement[Uml] with UMLMultiplicityElement[Uml] with UMLFeature[Uml] with operations.UMLStructuralFeatureOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		structuralFeature_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStructuralFeature
	 */
	def structuralFeature_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		typedElement_metaAttributes,
		multiplicityElement_metaAttributes,
		feature_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLStructuralFeature[Uml]](None, "isReadOnly", (x) => booleanToIterable(x.isReadOnly, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		structuralFeature_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStructuralFeature
	 */
	def structuralFeature_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		typedElement_compositeMetaProperties,
		multiplicityElement_compositeMetaProperties,
		feature_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		structuralFeature_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStructuralFeature
	 */
	def structuralFeature_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		typedElement_referenceMetaProperties,
		multiplicityElement_referenceMetaProperties,
		feature_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		structuralFeature_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStructuralFeature
	 */
	def structuralFeature_forwardReferencesFromMetamodelAssociations: Elements =
		typedElement_forwardReferencesFromMetamodelAssociations ++
		multiplicityElement_forwardReferencesFromMetamodelAssociations ++
		feature_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * If isReadOnly is true, the StructuralFeature may not be written to after initialization.
	 * <!-- end-user-doc -->
	 */
	def isReadOnly: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def definingFeature_slot: Set[UMLSlot[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def structuralFeature_structuralFeatureAction: Set[UMLStructuralFeatureAction[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLStructuralFeature
