package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A TemplateableElement is an Element that can optionally be defined as a template and bound to other templates.
 * <!-- end-user-doc --> 
 */
trait UMLTemplateableElement[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLTemplateableElementOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		templateableElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTemplateableElement
	 */
	def templateableElement_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		templateableElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTemplateableElement
	 */
	def templateableElement_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLTemplateableElement[Uml], UMLTemplateSignature[Uml]]("ownedTemplateSignature", _.ownedTemplateSignature),
		  	MetaPropertyCollection[UMLTemplateableElement[Uml], UMLTemplateBinding[Uml]]("templateBinding", _.templateBinding)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		templateableElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTemplateableElement
	 */
	def templateableElement_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		templateableElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTemplateableElement
	 */
	def templateableElement_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The optional TemplateSignature specifying the formal TemplateParameters for this TemplateableElement. If a TemplateableElement has a TemplateSignature, then it is a template.
	 * <!-- end-user-doc -->
	 */
	def ownedTemplateSignature: Option[UMLTemplateSignature[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The optional TemplateBindings from this TemplateableElement to one or more templates.
	 * <!-- end-user-doc -->
	 */
	def templateBinding: Set[UMLTemplateBinding[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLTemplateableElement
