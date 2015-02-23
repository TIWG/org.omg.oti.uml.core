package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A RedefinableTemplateSignature supports the addition of formal template parameters in a specialization of a template classifier.
 * <!-- end-user-doc --> 
 */
trait UMLRedefinableTemplateSignature[Uml <: UML]
  extends UMLRedefinableElement[Uml] with UMLTemplateSignature[Uml] with operations.UMLRedefinableTemplateSignatureOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		redefinableTemplateSignature_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLRedefinableTemplateSignature
	 */
	def redefinableTemplateSignature_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		redefinableElement_metaAttributes,
		templateSignature_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		redefinableTemplateSignature_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLRedefinableTemplateSignature
	 */
	def redefinableTemplateSignature_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_compositeMetaProperties,
		templateSignature_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		redefinableTemplateSignature_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLRedefinableTemplateSignature
	 */
	def redefinableTemplateSignature_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_referenceMetaProperties,
		templateSignature_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLRedefinableTemplateSignature[Uml], UMLClassifier[Uml]]("classifier", _.classifier),
		  	MetaPropertyCollection[UMLRedefinableTemplateSignature[Uml], UMLRedefinableTemplateSignature[Uml]]("extendedSignature", _.extendedSignature)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		redefinableTemplateSignature_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLRedefinableTemplateSignature
	 */
	def redefinableTemplateSignature_forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		templateSignature_forwardReferencesFromMetamodelAssociations ++
		classifier ++
		extendedSignature 

	/**
	 * <!-- begin-user-doc --> 
	 * The Classifier that owns this RedefinableTemplateSignature.
	 * <!-- end-user-doc -->
	 */
	def classifier: Option[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The signatures extended by this RedefinableTemplateSignature.
	 * <!-- end-user-doc -->
	 */
	def extendedSignature: Set[UMLRedefinableTemplateSignature[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The formal template parameters of the extended signatures.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if extendedSignature->isEmpty() then Set{} else extendedSignature.parameter->asSet() endif)
	 */
	def inheritedParameter: Set[UMLTemplateParameter[Uml]] = {
	    // Start of user code for "inheritedParameter"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def extendedSignature_redefinableTemplateSignature: Set[UMLRedefinableTemplateSignature[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLRedefinableTemplateSignature
