package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ProtocolStateMachine is always defined in the context of a Classifier. It specifies which BehavioralFeatures of the Classifier can be called in which State and under which conditions, thus specifying the allowed invocation sequences on the Classifier's BehavioralFeatures. A ProtocolStateMachine specifies the possible and permitted Transitions on the instances of its context Classifier, together with the BehavioralFeatures that carry the Transitions. In this manner, an instance lifecycle can be specified for a Classifier, by defining the order in which the BehavioralFeatures can be activated and the States through which an instance progresses during its existence.
 * <!-- end-user-doc --> 
 */
trait UMLProtocolStateMachine[Uml <: UML]
  extends UMLStateMachine[Uml] with operations.UMLProtocolStateMachineOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		protocolStateMachine_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLProtocolStateMachine
	 */
	def protocolStateMachine_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		stateMachine_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		protocolStateMachine_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLProtocolStateMachine
	 */
	def protocolStateMachine_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		stateMachine_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLProtocolStateMachine[Uml], UMLProtocolConformance[Uml]]("conformance", _.conformance)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		protocolStateMachine_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLProtocolStateMachine
	 */
	def protocolStateMachine_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		stateMachine_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		protocolStateMachine_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLProtocolStateMachine
	 */
	def protocolStateMachine_forwardReferencesFromMetamodelAssociations: Elements =
		stateMachine_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Conformance between ProtocolStateMachine 
	 * <!-- end-user-doc -->
	 */
	def conformance: Set[UMLProtocolConformance[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def generalMachine_protocolConformance: Set[UMLProtocolConformance[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def protocol_port: Set[UMLPort[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the namespace in which the protocol state machine is defined.
	 * <!-- end-user-doc -->
	 */
	def protocol_interface: Option[UMLInterface[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLProtocolStateMachine
