package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An AddStructuralFeatureValueAction is a WriteStructuralFeatureAction for adding values to a StructuralFeature.
 * <!-- end-user-doc --> 
 */
trait UMLAddStructuralFeatureValueAction[Uml <: UML]
  extends UMLWriteStructuralFeatureAction[Uml] with operations.UMLAddStructuralFeatureValueActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		addStructuralFeatureValueAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAddStructuralFeatureValueAction
	 */
	def addStructuralFeatureValueAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		writeStructuralFeatureAction_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLAddStructuralFeatureValueAction[Uml]](None, "isReplaceAll", (x) => booleanToIterable(x.isReplaceAll, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		addStructuralFeatureValueAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAddStructuralFeatureValueAction
	 */
	def addStructuralFeatureValueAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		writeStructuralFeatureAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLAddStructuralFeatureValueAction[Uml], UMLInputPin[Uml]]("insertAt", _.insertAt)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		addStructuralFeatureValueAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAddStructuralFeatureValueAction
	 */
	def addStructuralFeatureValueAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		writeStructuralFeatureAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		addStructuralFeatureValueAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAddStructuralFeatureValueAction
	 */
	def addStructuralFeatureValueAction_forwardReferencesFromMetamodelAssociations: Elements =
		writeStructuralFeatureAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that gives the position at which to insert the value in an ordered StructuralFeature. The type of the insertAt InputPin is UnlimitedNatural, but the value cannot be zero. It is omitted for unordered StructuralFeatures.
	 * <!-- end-user-doc -->
	 */
	def insertAt: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether existing values of the StructuralFeature should be removed before adding the new value.
	 * <!-- end-user-doc -->
	 */
	def isReplaceAll: Boolean

// Start of user code for additional featuers
// End of user code

} //UMLAddStructuralFeatureValueAction
