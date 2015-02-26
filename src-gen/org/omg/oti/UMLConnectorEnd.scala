package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ConnectorEnd is an endpoint of a Connector, which attaches the Connector to a ConnectableElement.
 * <!-- end-user-doc --> 
 */
trait UMLConnectorEnd[Uml <: UML]
  extends UMLMultiplicityElement[Uml] with operations.UMLConnectorEndOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		connectorEnd_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConnectorEnd
	 */
	def connectorEnd_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		multiplicityElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		connectorEnd_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConnectorEnd
	 */
	def connectorEnd_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		multiplicityElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		connectorEnd_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConnectorEnd
	 */
	def connectorEnd_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		multiplicityElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLConnectorEnd[Uml], UMLProperty[Uml]]("partWithPort", _.partWithPort),
		  	MetaPropertyReference[Uml, UMLConnectorEnd[Uml], UMLConnectableElement[Uml]]("role", _.role)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		connectorEnd_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConnectorEnd
	 */
	def connectorEnd_forwardReferencesFromMetamodelAssociations: Elements =
		multiplicityElement_forwardReferencesFromMetamodelAssociations ++
		partWithPort ++
		role 

	/**
	 * <!-- begin-user-doc --> 
	 * A derived property referencing the corresponding end on the Association which types the Connector owing this ConnectorEnd, if any. It is derived by selecting the end at the same place in the ordering of Association ends as this ConnectorEnd.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if connector.type = null 
	 * then
	 *   null 
	 * else
	 *   let index : Integer = connector.end->indexOf(self) in
	 *     connector.type.memberEnd->at(index)
	 * endif)
	 */
	def definingEnd: Option[UMLProperty[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates the role of the internal structure of a Classifier with the Port to which the ConnectorEnd is attached.
	 * <!-- end-user-doc -->
	 */
	def partWithPort: Option[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ConnectableElement attached at this ConnectorEnd. When an instance of the containing Classifier is created, a link may (depending on the multiplicities) be created to an instance of the Classifier that types this ConnectableElement.
	 * <!-- end-user-doc -->
	 */
	def role: Option[UMLConnectableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def end_connector: Option[UMLConnector[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLConnectorEnd
