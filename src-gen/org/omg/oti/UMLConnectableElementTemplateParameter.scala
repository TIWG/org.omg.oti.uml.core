package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ConnectableElementTemplateParameter exposes a ConnectableElement as a formal parameter for a template.
 * <!-- end-user-doc --> 
 */
trait UMLConnectableElementTemplateParameter[Uml <: UML]
  extends UMLTemplateParameter[Uml] with operations.UMLConnectableElementTemplateParameterOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		connectableElementTemplateParameter_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConnectableElementTemplateParameter
	 */
	def connectableElementTemplateParameter_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		templateParameter_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		connectableElementTemplateParameter_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConnectableElementTemplateParameter
	 */
	def connectableElementTemplateParameter_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		templateParameter_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		connectableElementTemplateParameter_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConnectableElementTemplateParameter
	 */
	def connectableElementTemplateParameter_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		templateParameter_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLConnectableElementTemplateParameter[Uml], UMLConnectableElement[Uml]]("parameteredElement", _.parameteredElement)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		connectableElementTemplateParameter_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConnectableElementTemplateParameter
	 */
	def connectableElementTemplateParameter_forwardReferencesFromMetamodelAssociations: Elements =
		templateParameter_forwardReferencesFromMetamodelAssociations ++
		parameteredElement 

	/**
	 * <!-- begin-user-doc --> 
	 * The ConnectableElement for this ConnectableElementTemplateParameter.
	 * <!-- end-user-doc -->
	 */
	override def parameteredElement: Option[UMLConnectableElement[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLConnectableElementTemplateParameter
