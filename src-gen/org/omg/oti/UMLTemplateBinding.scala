package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A TemplateBinding is a DirectedRelationship between a TemplateableElement and a template. A TemplateBinding specifies the TemplateParameterSubstitutions of actual parameters for the formal parameters of the template.
 * <!-- end-user-doc --> 
 */
trait UMLTemplateBinding[Uml <: UML]
  extends UMLDirectedRelationship[Uml] with operations.UMLTemplateBindingOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		templateBinding_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTemplateBinding
	 */
	def templateBinding_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		directedRelationship_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		templateBinding_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTemplateBinding
	 */
	def templateBinding_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLTemplateBinding[Uml], UMLTemplateParameterSubstitution[Uml]]("parameterSubstitution", _.parameterSubstitution)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		templateBinding_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTemplateBinding
	 */
	def templateBinding_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLTemplateBinding[Uml], UMLTemplateableElement[Uml]]("boundElement", _.boundElement),
		  	MetaPropertyReference[Uml, UMLTemplateBinding[Uml], UMLTemplateSignature[Uml]]("signature", _.signature)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		templateBinding_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTemplateBinding
	 */
	def templateBinding_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		boundElement ++
		signature 

	/**
	 * <!-- begin-user-doc --> 
	 * The TemplateableElement that is bound by this TemplateBinding.
	 * <!-- end-user-doc -->
	 */
	def boundElement: Option[UMLTemplateableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The TemplateParameterSubstitutions owned by this TemplateBinding.
	 * <!-- end-user-doc -->
	 */
	def parameterSubstitution: Set[UMLTemplateParameterSubstitution[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The TemplateSignature for the template that is the target of this TemplateBinding.
	 * <!-- end-user-doc -->
	 */
	def signature: Option[UMLTemplateSignature[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLTemplateBinding
