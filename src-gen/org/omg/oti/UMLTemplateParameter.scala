package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A TemplateParameter exposes a ParameterableElement as a formal parameter of a template.
 * <!-- end-user-doc --> 
 */
trait UMLTemplateParameter[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLTemplateParameterOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		templateParameter_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTemplateParameter
	 */
	def templateParameter_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		templateParameter_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTemplateParameter
	 */
	def templateParameter_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLParameterableElement[Uml]]("ownedDefault", _.ownedDefault),
		  	MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLParameterableElement[Uml]]("ownedParameteredElement", _.ownedParameteredElement)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		templateParameter_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTemplateParameter
	 */
	def templateParameter_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLParameterableElement[Uml]]("default", _.default),
		  	MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLParameterableElement[Uml]]("parameteredElement", _.parameteredElement),
		  	MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLTemplateSignature[Uml]]("signature", _.signature)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		templateParameter_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTemplateParameter
	 */
	def templateParameter_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		default ++
		parameteredElement ++
		signature 

	/**
	 * <!-- begin-user-doc --> 
	 * The ParameterableElement that is the default for this formal TemplateParameter.
	 * <!-- end-user-doc -->
	 */
	def default: Option[UMLParameterableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ParameterableElement that is owned by this TemplateParameter for the purpose of providing a default.
	 * <!-- end-user-doc -->
	 */
	def ownedDefault: Option[UMLParameterableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ParameterableElement that is owned by this TemplateParameter for the purpose of exposing it as the parameteredElement.
	 * <!-- end-user-doc -->
	 */
	def ownedParameteredElement: Option[UMLParameterableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ParameterableElement exposed by this TemplateParameter.
	 * <!-- end-user-doc -->
	 */
	def parameteredElement: Option[UMLParameterableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The TemplateSignature that owns this TemplateParameter.
	 * <!-- end-user-doc -->
	 */
	def signature: Option[UMLTemplateSignature[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def parameter_templateSignature: Set[UMLTemplateSignature[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def formal_templateParameterSubstitution: Set[UMLTemplateParameterSubstitution[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def inheritedParameter_redefinableTemplateSignature: Set[UMLRedefinableTemplateSignature[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLTemplateParameter
