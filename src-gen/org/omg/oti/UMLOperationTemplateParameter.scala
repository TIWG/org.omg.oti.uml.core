package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An OperationTemplateParameter exposes an Operation as a formal parameter for a template.
 * <!-- end-user-doc --> 
 */
trait UMLOperationTemplateParameter[Uml <: UML]
  extends UMLTemplateParameter[Uml] with operations.UMLOperationTemplateParameterOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		operationTemplateParameter_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLOperationTemplateParameter
	 */
	def operationTemplateParameter_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		templateParameter_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		operationTemplateParameter_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLOperationTemplateParameter
	 */
	def operationTemplateParameter_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		templateParameter_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		operationTemplateParameter_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLOperationTemplateParameter
	 */
	def operationTemplateParameter_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		templateParameter_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLOperationTemplateParameter[Uml], UMLOperation[Uml]]("parameteredElement", _.parameteredElement)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		operationTemplateParameter_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLOperationTemplateParameter
	 */
	def operationTemplateParameter_forwardReferencesFromMetamodelAssociations: Elements =
		templateParameter_forwardReferencesFromMetamodelAssociations ++
		parameteredElement 

	/**
	 * <!-- begin-user-doc --> 
	 * The Operation exposed by this OperationTemplateParameter.
	 * <!-- end-user-doc -->
	 */
	override def parameteredElement: Option[UMLOperation[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLOperationTemplateParameter
