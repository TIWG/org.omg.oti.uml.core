package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Port is a property of an EncapsulatedClassifier that specifies a distinct interaction point between that EncapsulatedClassifier and its environment or between the (behavior of the) EncapsulatedClassifier and its internal parts. Ports are connected to Properties of the EncapsulatedClassifier by Connectors through which requests can be made to invoke BehavioralFeatures. A Port may specify the services an EncapsulatedClassifier provides (offers) to its environment as well as the services that an EncapsulatedClassifier expects (requires) of its environment.  A Port may have an associated ProtocolStateMachine.
 * <!-- end-user-doc --> 
 */
trait UMLPort[Uml <: UML]
  extends UMLProperty[Uml] with operations.UMLPortOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		port_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPort
	 */
	def port_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		property_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLPort[Uml]](None, "isBehavior", (x) => booleanToIterable(x.isBehavior, false)),
		  	MetaAttributeBooleanFunction[UMLPort[Uml]](None, "isConjugated", (x) => booleanToIterable(x.isConjugated, false)),
		  	MetaAttributeBooleanFunction[UMLPort[Uml]](None, "isService", (x) => booleanToIterable(x.isService, true))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		port_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPort
	 */
	def port_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		property_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		port_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPort
	 */
	def port_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		property_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLPort[Uml], UMLProtocolStateMachine[Uml]]("protocol", _.protocol),
		  	MetaPropertyCollection[UMLPort[Uml], UMLPort[Uml]]("redefinedPort", _.redefinedPort)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		port_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPort
	 */
	def port_forwardReferencesFromMetamodelAssociations: Elements =
		property_forwardReferencesFromMetamodelAssociations ++
		protocol ++
		redefinedPort 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether requests arriving at this Port are sent to the classifier behavior of this EncapsulatedClassifier. Such a Port is referred to as a behavior Port. Any invocation of a BehavioralFeature targeted at a behavior Port will be handled by the instance of the owning EncapsulatedClassifier itself, rather than by any instances that it may contain.
	 * <!-- end-user-doc -->
	 */
	def isBehavior: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the way that the provided and required Interfaces are derived from the Port?s Type.
	 * <!-- end-user-doc -->
	 */
	def isConjugated: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * If true, indicates that this Port is used to provide the published functionality of an EncapsulatedClassifier.  If false, this Port is used to implement the EncapsulatedClassifier but is not part of the essential externally-visible functionality of the EncapsulatedClassifier and can, therefore, be altered or deleted along with the internal implementation of the EncapsulatedClassifier and other properties that are considered part of its implementation.
	 * <!-- end-user-doc -->
	 */
	def isService: Boolean = true

	/**
	 * <!-- begin-user-doc --> 
	 * An optional ProtocolStateMachine which describes valid interactions at this interaction point.
	 * <!-- end-user-doc -->
	 */
	def protocol: Option[UMLProtocolStateMachine[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Interfaces specifying the set of Operations and Receptions that the EncapsulatedCclassifier offers to its environment via this Port, and which it will handle either directly or by forwarding it to a part of its internal structure. This association is derived according to the value of isConjugated. If isConjugated is false, provided is derived as the union of the sets of Interfaces realized by the type of the port and its supertypes, or directly from the type of the Port if the Port is typed by an Interface. If isConjugated is true, it is derived as the union of the sets of Interfaces used by the type of the Port and its supertypes.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if isConjugated then basicRequired() else basicProvided() endif)
	 */
	def provided: Set[UMLInterface[Uml]] = {
	    // Start of user code for "provided"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * A Port may be redefined when its containing EncapsulatedClassifier is specialized. The redefining Port may have additional Interfaces to those that are associated with the redefined Port or it may replace an Interface by one of its subtypes.
	 * <!-- end-user-doc -->
	 */
	def redefinedPort: Set[UMLPort[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Interfaces specifying the set of Operations and Receptions that the EncapsulatedCassifier expects its environment to handle via this port. This association is derived according to the value of isConjugated. If isConjugated is false, required is derived as the union of the sets of Interfaces used by the type of the Port and its supertypes. If isConjugated is true, it is derived as the union of the sets of Interfaces realized by the type of the Port and its supertypes, or directly from the type of the Port if the Port is typed by an Interface.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if isConjugated then basicProvided() else basicRequired() endif)
	 */
	def required: Set[UMLInterface[Uml]] = {
	    // Start of user code for "required"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinedPort_port: Set[UMLPort[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def port_trigger: Set[UMLTrigger[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def onPort_invocationAction: Set[UMLInvocationAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedPort_encapsulatedClassifier: Option[UMLEncapsulatedClassifier[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLPort
