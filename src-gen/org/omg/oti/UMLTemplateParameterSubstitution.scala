package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A TemplateParameterSubstitution relates the actual parameter to a formal TemplateParameter as part of a template binding.
 * <!-- end-user-doc --> 
 */
trait UMLTemplateParameterSubstitution[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLTemplateParameterSubstitutionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		templateParameterSubstitution_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTemplateParameterSubstitution
	 */
	def templateParameterSubstitution_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		templateParameterSubstitution_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTemplateParameterSubstitution
	 */
	def templateParameterSubstitution_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLTemplateParameterSubstitution[Uml], UMLParameterableElement[Uml]]("ownedActual", _.ownedActual)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		templateParameterSubstitution_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTemplateParameterSubstitution
	 */
	def templateParameterSubstitution_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLTemplateParameterSubstitution[Uml], UMLParameterableElement[Uml]]("actual", _.actual),
		  	MetaPropertyReference[UMLTemplateParameterSubstitution[Uml], UMLTemplateParameter[Uml]]("formal", _.formal),
		  	MetaPropertyReference[UMLTemplateParameterSubstitution[Uml], UMLTemplateBinding[Uml]]("templateBinding", _.templateBinding)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		templateParameterSubstitution_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTemplateParameterSubstitution
	 */
	def templateParameterSubstitution_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		actual ++
		formal ++
		templateBinding 

	/**
	 * <!-- begin-user-doc --> 
	 * The ParameterableElement that is the actual parameter for this TemplateParameterSubstitution.
	 * <!-- end-user-doc -->
	 */
	def actual: Option[UMLParameterableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The formal TemplateParameter that is associated with this TemplateParameterSubstitution.
	 * <!-- end-user-doc -->
	 */
	def formal: Option[UMLTemplateParameter[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ParameterableElement that is owned by this TemplateParameterSubstitution as its actual parameter.
	 * <!-- end-user-doc -->
	 */
	def ownedActual: Option[UMLParameterableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The TemplateBinding that owns this TemplateParameterSubstitution.
	 * <!-- end-user-doc -->
	 */
	def templateBinding: Option[UMLTemplateBinding[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLTemplateParameterSubstitution
