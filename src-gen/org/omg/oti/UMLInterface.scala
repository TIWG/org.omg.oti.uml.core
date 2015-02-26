package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * Interfaces declare coherent services that are implemented by BehavioredClassifiers that implement the Interfaces via InterfaceRealizations.
 * <!-- end-user-doc --> 
 */
trait UMLInterface[Uml <: UML]
  extends UMLClassifier[Uml] with operations.UMLInterfaceOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interface_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInterface
	 */
	def interface_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		classifier_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interface_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInterface
	 */
	def interface_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		classifier_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLInterface[Uml], UMLClassifier[Uml]]("nestedClassifier", _.nestedClassifier),
		  	MetaPropertyCollection[Uml, UMLInterface[Uml], UMLProperty[Uml]]("ownedAttribute", _.ownedAttribute),
		  	MetaPropertyCollection[Uml, UMLInterface[Uml], UMLOperation[Uml]]("ownedOperation", _.ownedOperation),
		  	MetaPropertyCollection[Uml, UMLInterface[Uml], UMLReception[Uml]]("ownedReception", _.ownedReception),
		  	MetaPropertyReference[Uml, UMLInterface[Uml], UMLProtocolStateMachine[Uml]]("protocol", _.protocol)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interface_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInterface
	 */
	def interface_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		classifier_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLInterface[Uml], UMLInterface[Uml]]("redefinedInterface", _.redefinedInterface)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interface_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInterface
	 */
	def interface_forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations ++
		redefinedInterface 

	/**
	 * <!-- begin-user-doc --> 
	 * References all the Classifiers that are defined (nested) within the Interface.
	 * <!-- end-user-doc -->
	 */
	def nestedClassifier: Seq[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The attributes (i.e., the Properties) owned by the Interface.
	 * <!-- end-user-doc -->
	 */
	def ownedAttribute: Seq[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Operations owned by the Interface.
	 * <!-- end-user-doc -->
	 */
	def ownedOperation: Seq[UMLOperation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Receptions that objects providing this Interface are willing to accept.
	 * <!-- end-user-doc -->
	 */
	def ownedReception: Set[UMLReception[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References a ProtocolStateMachine specifying the legal sequences of the invocation of the BehavioralFeatures described in the Interface.
	 * <!-- end-user-doc -->
	 */
	def protocol: Option[UMLProtocolStateMachine[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References all the Interfaces redefined by this Interface.
	 * <!-- end-user-doc -->
	 */
	def redefinedInterface: Set[UMLInterface[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def provided_port: Set[UMLPort[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def required_component: Set[UMLComponent[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinedInterface_interface: Set[UMLInterface[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def required_port: Set[UMLPort[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def contract_interfaceRealization: Set[UMLInterfaceRealization[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def provided_component: Set[UMLComponent[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLInterface
