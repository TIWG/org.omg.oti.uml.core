package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A RemoveStructuralFeatureValueAction is a WriteStructuralFeatureAction that removes values from a StructuralFeature.
 * <!-- end-user-doc --> 
 */
trait UMLRemoveStructuralFeatureValueAction[Uml <: UML]
  extends UMLWriteStructuralFeatureAction[Uml] with operations.UMLRemoveStructuralFeatureValueActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		removeStructuralFeatureValueAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLRemoveStructuralFeatureValueAction
	 */
	def removeStructuralFeatureValueAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		writeStructuralFeatureAction_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLRemoveStructuralFeatureValueAction[Uml]](None, "isRemoveDuplicates", (x) => booleanToIterable(x.isRemoveDuplicates, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		removeStructuralFeatureValueAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLRemoveStructuralFeatureValueAction
	 */
	def removeStructuralFeatureValueAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		writeStructuralFeatureAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLRemoveStructuralFeatureValueAction[Uml], UMLInputPin[Uml]]("removeAt", _.removeAt)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		removeStructuralFeatureValueAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLRemoveStructuralFeatureValueAction
	 */
	def removeStructuralFeatureValueAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		writeStructuralFeatureAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		removeStructuralFeatureValueAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLRemoveStructuralFeatureValueAction
	 */
	def removeStructuralFeatureValueAction_forwardReferencesFromMetamodelAssociations: Elements =
		writeStructuralFeatureAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether to remove duplicates of the value in nonunique StructuralFeatures.
	 * <!-- end-user-doc -->
	 */
	def isRemoveDuplicates: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * An InputPin that provides the position of an existing value to remove in ordered, nonunique structural features. The type of the removeAt InputPin is UnlimitedNatural, but the value cannot be zero or unlimited.
	 * <!-- end-user-doc -->
	 */
	def removeAt: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLRemoveStructuralFeatureValueAction
