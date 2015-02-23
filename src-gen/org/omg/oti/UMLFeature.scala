package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Feature declares a behavioral or structural characteristic of Classifiers.
 * <!-- end-user-doc --> 
 */
trait UMLFeature[Uml <: UML]
  extends UMLRedefinableElement[Uml] with operations.UMLFeatureOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		feature_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLFeature
	 */
	def feature_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		redefinableElement_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLFeature[Uml]](None, "isStatic", (x) => booleanToIterable(x.isStatic, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		feature_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLFeature
	 */
	def feature_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		feature_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLFeature
	 */
	def feature_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		feature_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLFeature
	 */
	def feature_forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The Classifiers that have this Feature as a feature.
	 * <!-- end-user-doc -->
	 */
	def featuringClassifier: Option[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether this Feature characterizes individual instances classified by the Classifier (false) or the Classifier itself (true).
	 * <!-- end-user-doc -->
	 */
	def isStatic: Boolean = false

// Start of user code for additional featuers
// End of user code

} //UMLFeature
