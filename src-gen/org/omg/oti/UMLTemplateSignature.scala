package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Template Signature bundles the set of formal TemplateParameters for a template.
 * <!-- end-user-doc --> 
 */
trait UMLTemplateSignature[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLTemplateSignatureOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		templateSignature_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTemplateSignature
	 */
	def templateSignature_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		templateSignature_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTemplateSignature
	 */
	def templateSignature_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLTemplateSignature[Uml], UMLTemplateParameter[Uml]]("ownedParameter", _.ownedParameter)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		templateSignature_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTemplateSignature
	 */
	def templateSignature_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLTemplateSignature[Uml], UMLTemplateParameter[Uml]]("parameter", _.parameter),
		  	MetaPropertyReference[UMLTemplateSignature[Uml], UMLTemplateableElement[Uml]]("template", _.template)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		templateSignature_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTemplateSignature
	 */
	def templateSignature_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		parameter ++
		template 

	/**
	 * <!-- begin-user-doc --> 
	 * The formal parameters that are owned by this TemplateSignature.
	 * <!-- end-user-doc -->
	 */
	def ownedParameter: Seq[UMLTemplateParameter[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ordered set of all formal TemplateParameters for this TemplateSignature.
	 * <!-- end-user-doc -->
	 */
	def parameter: Seq[UMLTemplateParameter[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The TemplateableElement that owns this TemplateSignature.
	 * <!-- end-user-doc -->
	 */
	def template: Option[UMLTemplateableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def signature_templateBinding: Set[UMLTemplateBinding[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLTemplateSignature
