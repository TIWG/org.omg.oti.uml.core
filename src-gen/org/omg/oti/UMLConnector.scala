package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Connector specifies links that enables communication between two or more instances. In contrast to Associations, which specify links between any instance of the associated Classifiers, Connectors specify links between instances playing the connected parts only.
 * <!-- end-user-doc --> 
 */
trait UMLConnector[Uml <: UML]
  extends UMLFeature[Uml] with operations.UMLConnectorOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		connector_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConnector
	 */
	def connector_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		feature_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		connector_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConnector
	 */
	def connector_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		feature_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLConnector[Uml], UMLConnectorEnd[Uml]]("end", _.end)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		connector_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConnector
	 */
	def connector_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		feature_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLConnector[Uml], UMLBehavior[Uml]]("contract", _.contract),
		  	MetaPropertyCollection[Uml, UMLConnector[Uml], UMLConnector[Uml]]("redefinedConnector", _.redefinedConnector),
		  	MetaPropertyReference[Uml, UMLConnector[Uml], UMLAssociation[Uml]]("type", _._type)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		connector_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConnector
	 */
	def connector_forwardReferencesFromMetamodelAssociations: Elements =
		feature_forwardReferencesFromMetamodelAssociations ++
		contract ++
		redefinedConnector ++
		_type 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of Behaviors that specify the valid interaction patterns across the Connector.
	 * <!-- end-user-doc -->
	 */
	def contract: Set[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A Connector has at least two ConnectorEnds, each representing the participation of instances of the Classifiers typing the ConnectableElements attached to the end. The set of ConnectorEnds is ordered.
	 * <!-- end-user-doc -->
	 */
	def end: Seq[UMLConnectorEnd[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates the kind of Connector. This is derived: a Connector with one or more ends connected to a Port which is not on a Part and which is not a behavior port is a delegation; otherwise it is an assembly.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if end->exists(
	 * 		role.oclIsKindOf(Port) 
	 * 		and partWithPort->isEmpty()
	 * 		and not role.oclAsType(Port).isBehavior)
	 * then ConnectorKind::delegation 
	 * else ConnectorKind::assembly 
	 * endif)
	 */
	def kind: UMLConnectorKind.Value = {
	    // Start of user code for "kind"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * A Connector may be redefined when its containing Classifier is specialized. The redefining Connector may have a type that specializes the type of the redefined Connector. The types of the ConnectorEnds of the redefining Connector may specialize the types of the ConnectorEnds of the redefined Connector. The properties of the ConnectorEnds of the redefining Connector may be replaced.
	 * <!-- end-user-doc -->
	 */
	def redefinedConnector: Set[UMLConnector[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An optional Association that classifies links corresponding to this Connector.
	 * <!-- end-user-doc -->
	 */
	def _type: Option[UMLAssociation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedConnector_structuredClassifier: Option[UMLStructuredClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def realizingConnector_informationFlow: Set[UMLInformationFlow[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def connector_message: Set[UMLMessage[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinedConnector_connector: Set[UMLConnector[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLConnector
