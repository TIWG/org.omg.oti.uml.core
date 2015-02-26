package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ClassifierTemplateParameter exposes a Classifier as a formal template parameter.
 * <!-- end-user-doc --> 
 */
trait UMLClassifierTemplateParameter[Uml <: UML]
  extends UMLTemplateParameter[Uml] with operations.UMLClassifierTemplateParameterOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		classifierTemplateParameter_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLClassifierTemplateParameter
	 */
	def classifierTemplateParameter_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		templateParameter_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLClassifierTemplateParameter[Uml]](None, "allowSubstitutable", (x) => booleanToIterable(x.allowSubstitutable, true))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		classifierTemplateParameter_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLClassifierTemplateParameter
	 */
	def classifierTemplateParameter_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		templateParameter_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		classifierTemplateParameter_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLClassifierTemplateParameter
	 */
	def classifierTemplateParameter_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		templateParameter_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLClassifierTemplateParameter[Uml], UMLClassifier[Uml]]("constrainingClassifier", _.constrainingClassifier),
		  	MetaPropertyReference[Uml, UMLClassifierTemplateParameter[Uml], UMLClassifier[Uml]]("parameteredElement", _.parameteredElement)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		classifierTemplateParameter_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLClassifierTemplateParameter
	 */
	def classifierTemplateParameter_forwardReferencesFromMetamodelAssociations: Elements =
		templateParameter_forwardReferencesFromMetamodelAssociations ++
		constrainingClassifier ++
		parameteredElement 

	/**
	 * <!-- begin-user-doc --> 
	 * Constrains the required relationship between an actual parameter and the parameteredElement for this formal parameter.
	 * <!-- end-user-doc -->
	 */
	def allowSubstitutable: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * The classifiers that constrain the argument that can be used for the parameter. If the allowSubstitutable attribute is true, then any Classifier that is compatible with this constraining Classifier can be substituted; otherwise, it must be either this Classifier or one of its specializations. If this property is empty, there are no constraints on the Classifier that can be used as an argument.
	 * <!-- end-user-doc -->
	 */
	def constrainingClassifier: Set[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Classifier exposed by this ClassifierTemplateParameter.
	 * <!-- end-user-doc -->
	 */
	override def parameteredElement: Option[UMLClassifier[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLClassifierTemplateParameter
