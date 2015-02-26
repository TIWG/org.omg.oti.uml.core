package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ProtocolStateMachine can be redefined into a more specific ProtocolStateMachine or into behavioral StateMachine. ProtocolConformance declares that the specific ProtocolStateMachine specifies a protocol that conforms to the general ProtocolStateMachine or that the specific behavioral StateMachine abides by the protocol of the general ProtocolStateMachine.
 * <!-- end-user-doc --> 
 */
trait UMLProtocolConformance[Uml <: UML]
  extends UMLDirectedRelationship[Uml] with operations.UMLProtocolConformanceOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		protocolConformance_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLProtocolConformance
	 */
	def protocolConformance_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		directedRelationship_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		protocolConformance_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLProtocolConformance
	 */
	def protocolConformance_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		protocolConformance_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLProtocolConformance
	 */
	def protocolConformance_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLProtocolConformance[Uml], UMLProtocolStateMachine[Uml]]("generalMachine", _.generalMachine),
		  	MetaPropertyReference[Uml, UMLProtocolConformance[Uml], UMLProtocolStateMachine[Uml]]("specificMachine", _.specificMachine)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		protocolConformance_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLProtocolConformance
	 */
	def protocolConformance_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		generalMachine ++
		specificMachine 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the ProtocolStateMachine to which the specific ProtocolStateMachine conforms.
	 * <!-- end-user-doc -->
	 */
	def generalMachine: Option[UMLProtocolStateMachine[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the ProtocolStateMachine which conforms to the general ProtocolStateMachine.
	 * <!-- end-user-doc -->
	 */
	def specificMachine: Option[UMLProtocolStateMachine[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLProtocolConformance
