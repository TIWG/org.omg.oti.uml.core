package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * InformationFlows describe circulation of information through a system in a general manner. They do not specify the nature of the information, mechanisms by which it is conveyed, sequences of exchange or any control conditions. During more detailed modeling, representation and realization links may be added to specify which model elements implement an InformationFlow and to show how information is conveyed.  InformationFlows require some kind of ?information channel? for unidirectional transmission of information items from sources to targets.? They specify the information channel?s realizations, if any, and identify the information that flows along them.? Information moving along the information channel may be represented by abstract InformationItems and by concrete Classifiers.
 * <!-- end-user-doc --> 
 */
trait UMLInformationFlow[Uml <: UML]
  extends UMLDirectedRelationship[Uml] with UMLPackageableElement[Uml] with operations.UMLInformationFlowOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		informationFlow_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInformationFlow
	 */
	def informationFlow_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		directedRelationship_metaAttributes,
		packageableElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		informationFlow_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInformationFlow
	 */
	def informationFlow_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_compositeMetaProperties,
		packageableElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		informationFlow_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInformationFlow
	 */
	def informationFlow_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_referenceMetaProperties,
		packageableElement_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLClassifier[Uml]]("conveyed", _.conveyed),
		  	MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLNamedElement[Uml]]("informationSource", _.informationSource),
		  	MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLNamedElement[Uml]]("informationTarget", _.informationTarget),
		  	MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLRelationship[Uml]]("realization", _.realization),
		  	MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLActivityEdge[Uml]]("realizingActivityEdge", _.realizingActivityEdge),
		  	MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLConnector[Uml]]("realizingConnector", _.realizingConnector),
		  	MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLMessage[Uml]]("realizingMessage", _.realizingMessage)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		informationFlow_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInformationFlow
	 */
	def informationFlow_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		conveyed ++
		informationSource ++
		informationTarget ++
		realization ++
		realizingActivityEdge ++
		realizingConnector ++
		realizingMessage 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the information items that may circulate on this information flow.
	 * <!-- end-user-doc -->
	 */
	def conveyed: Set[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Defines from which source the conveyed InformationItems are initiated.
	 * <!-- end-user-doc -->
	 */
	def informationSource: Set[UMLNamedElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Defines to which target the conveyed InformationItems are directed.
	 * <!-- end-user-doc -->
	 */
	def informationTarget: Set[UMLNamedElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Determines which Relationship will realize the specified flow.
	 * <!-- end-user-doc -->
	 */
	def realization: Set[UMLRelationship[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Determines which ActivityEdges will realize the specified flow.
	 * <!-- end-user-doc -->
	 */
	def realizingActivityEdge: Set[UMLActivityEdge[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Determines which Connectors will realize the specified flow.
	 * <!-- end-user-doc -->
	 */
	def realizingConnector: Set[UMLConnector[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Determines which Messages will realize the specified flow.
	 * <!-- end-user-doc -->
	 */
	def realizingMessage: Set[UMLMessage[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLInformationFlow
