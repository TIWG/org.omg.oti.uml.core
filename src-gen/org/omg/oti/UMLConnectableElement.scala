package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * ConnectableElement is an abstract metaclass representing a set of instances that play roles of a StructuredClassifier. ConnectableElements may be joined by attached Connectors and specify configurations of linked instances to be created within an instance of the containing StructuredClassifier.
 * <!-- end-user-doc --> 
 */
trait UMLConnectableElement[Uml <: UML]
  extends UMLParameterableElement[Uml] with UMLTypedElement[Uml] with operations.UMLConnectableElementOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		connectableElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConnectableElement
	 */
	def connectableElement_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		parameterableElement_metaAttributes,
		typedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		connectableElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConnectableElement
	 */
	def connectableElement_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		parameterableElement_compositeMetaProperties,
		typedElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		connectableElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConnectableElement
	 */
	def connectableElement_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		parameterableElement_referenceMetaProperties,
		typedElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLConnectableElement[Uml], UMLConnectableElementTemplateParameter[Uml]]("templateParameter", _.connectableElement_templateParameter)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		connectableElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConnectableElement
	 */
	def connectableElement_forwardReferencesFromMetamodelAssociations: Elements =
		parameterableElement_forwardReferencesFromMetamodelAssociations ++
		typedElement_forwardReferencesFromMetamodelAssociations ++
		templateParameter 

	/**
	 * <!-- begin-user-doc --> 
	 * A set of ConnectorEnds that attach to this ConnectableElement.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (ConnectorEnd.allInstances()->select(role = self))
	 */
	def end: Set[UMLConnectorEnd[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * The ConnectableElementTemplateParameter for this ConnectableElement parameter.
	 * <!-- end-user-doc -->
	 */
	override def templateParameter: Option[UMLTemplateParameter[Uml]] 

  def connectableElement_templateParameter: Option[UMLConnectableElementTemplateParameter[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def collaborationRole_collaboration: Set[UMLCollaboration[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def represents_lifeline: Set[UMLLifeline[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def role_structuredClassifier: Iterable[UMLStructuredClassifier[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLConnectableElement
