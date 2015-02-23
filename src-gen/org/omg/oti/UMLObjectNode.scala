package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ObjectNode is an abstract ActivityNode that may hold tokens within the object flow in an Activity. ObjectNodes also support token selection, limitation on the number of tokens held, specification of the state required for tokens being held, and carrying control values.

 * <!-- end-user-doc --> 
 */
trait UMLObjectNode[Uml <: UML]
  extends UMLTypedElement[Uml] with UMLActivityNode[Uml] with operations.UMLObjectNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		objectNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLObjectNode
	 */
	def objectNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		typedElement_metaAttributes,
		activityNode_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLObjectNode[Uml]](None, "isControlType", (x) => booleanToIterable(x.isControlType, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		objectNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLObjectNode
	 */
	def objectNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		typedElement_compositeMetaProperties,
		activityNode_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLObjectNode[Uml], UMLValueSpecification[Uml]]("upperBound", _.upperBound)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		objectNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLObjectNode
	 */
	def objectNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		typedElement_referenceMetaProperties,
		activityNode_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLObjectNode[Uml], UMLState[Uml]]("inState", _.inState),
		  	MetaPropertyReference[UMLObjectNode[Uml], UMLBehavior[Uml]]("selection", _.selection)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		objectNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLObjectNode
	 */
	def objectNode_forwardReferencesFromMetamodelAssociations: Elements =
		typedElement_forwardReferencesFromMetamodelAssociations ++
		activityNode_forwardReferencesFromMetamodelAssociations ++
		inState ++
		selection 

	/**
	 * <!-- begin-user-doc --> 
	 * The States required to be associated with the values held by tokens on this ObjectNode.
	 * <!-- end-user-doc -->
	 */
	def inState: Set[UMLState[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether the type of the ObjectNode is to be treated as representing control values that may traverse ControlFlows.
	 * <!-- end-user-doc -->
	 */
	def isControlType: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates how the tokens held by the ObjectNode are ordered for selection to traverse ActivityEdges outgoing from the ObjectNode.
	 * <!-- end-user-doc -->
	 */
	def ordering: UMLObjectNodeOrderingKind.Value = UMLObjectNodeOrderingKind.FIFO

	/**
	 * <!-- begin-user-doc --> 
	 * A Behavior used to select tokens to be offered on outgoing ActivityEdges.
	 * <!-- end-user-doc -->
	 */
	def selection: Option[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The maximum number of tokens that may be held by this ObjectNode. Tokens cannot flow into the ObjectNode if the upperBound is reached. If no upperBound is specified, then there is no limit on how many tokens the ObjectNode can hold.
	 * <!-- end-user-doc -->
	 */
	def upperBound: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def exceptionInput_exceptionHandler: Set[UMLExceptionHandler[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLObjectNode
