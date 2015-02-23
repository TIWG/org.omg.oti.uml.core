package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ParameterableElement is an Element that can be exposed as a formal TemplateParameter for a template, or specified as an actual parameter in a binding of a template.
 * <!-- end-user-doc --> 
 */
trait UMLParameterableElement[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLParameterableElementOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		parameterableElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLParameterableElement
	 */
	def parameterableElement_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		parameterableElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLParameterableElement
	 */
	def parameterableElement_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		parameterableElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLParameterableElement
	 */
	def parameterableElement_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLParameterableElement[Uml], UMLTemplateParameter[Uml]]("owningTemplateParameter", _.owningTemplateParameter),
		  	MetaPropertyReference[UMLParameterableElement[Uml], UMLTemplateParameter[Uml]]("templateParameter", _.templateParameter)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		parameterableElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLParameterableElement
	 */
	def parameterableElement_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		owningTemplateParameter ++
		templateParameter 

	/**
	 * <!-- begin-user-doc --> 
	 * The formal TemplateParameter that owns this ParameterableElement.
	 * <!-- end-user-doc -->
	 */
	def owningTemplateParameter: Option[UMLTemplateParameter[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The TemplateParameter that exposes this ParameterableElement as a formal parameter.
	 * <!-- end-user-doc -->
	 */
	def templateParameter: Option[UMLTemplateParameter[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def actual_templateParameterSubstitution: Iterable[UMLTemplateParameterSubstitution[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedActual_owningTemplateParameterSubstitution: Iterable[UMLTemplateParameterSubstitution[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def default_templateParameter: Iterable[UMLTemplateParameter[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedDefault_templateParameter: Iterable[UMLTemplateParameter[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLParameterableElement
