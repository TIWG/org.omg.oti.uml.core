package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A StructuredActivityNode is an Action that is also an ActivityGroup and whose behavior is specified by the ActivityNodes and ActivityEdges it so contains. Unlike other kinds of ActivityGroup, a StructuredActivityNode owns the ActivityNodes and ActivityEdges it contains, and so a node or edge can only be directly contained in one StructuredActivityNode, though StructuredActivityNodes may be nested.
 * <!-- end-user-doc --> 
 */
trait UMLStructuredActivityNode[Uml <: UML]
  extends UMLActivityGroup[Uml] with UMLAction[Uml] with UMLNamespace[Uml] with operations.UMLStructuredActivityNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		structuredActivityNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStructuredActivityNode
	 */
	def structuredActivityNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		activityGroup_metaAttributes,
		action_metaAttributes,
		namespace_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLStructuredActivityNode[Uml]](None, "mustIsolate", (x) => booleanToIterable(x.mustIsolate, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		structuredActivityNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStructuredActivityNode
	 */
	def structuredActivityNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityGroup_compositeMetaProperties,
		action_compositeMetaProperties,
		namespace_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLStructuredActivityNode[Uml], UMLActivityEdge[Uml]]("edge", _.edge),
		  	MetaPropertyCollection[UMLStructuredActivityNode[Uml], UMLActivityNode[Uml]]("node", _.node),
		  	MetaPropertyCollection[UMLStructuredActivityNode[Uml], UMLInputPin[Uml]]("structuredNodeInput", _.structuredNodeInput),
		  	MetaPropertyCollection[UMLStructuredActivityNode[Uml], UMLOutputPin[Uml]]("structuredNodeOutput", _.structuredNodeOutput),
		  	MetaPropertyCollection[UMLStructuredActivityNode[Uml], UMLVariable[Uml]]("variable", _.variable)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		structuredActivityNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStructuredActivityNode
	 */
	def structuredActivityNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityGroup_referenceMetaProperties,
		action_referenceMetaProperties,
		namespace_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLStructuredActivityNode[Uml], UMLActivity[Uml]]("activity", _.activity)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		structuredActivityNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStructuredActivityNode
	 */
	def structuredActivityNode_forwardReferencesFromMetamodelAssociations: Elements =
		activityGroup_forwardReferencesFromMetamodelAssociations ++
		action_forwardReferencesFromMetamodelAssociations ++
		namespace_forwardReferencesFromMetamodelAssociations ++
		activity 

	/**
	 * <!-- begin-user-doc --> 
	 * The Activity immediately containing the StructuredActivityNode, if it is not contained in another StructuredActivityNode.
	 * <!-- end-user-doc -->
	 */
	override def activity: Option[UMLActivity[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ActivityEdges immediately contained in the StructuredActivityNode.
	 * <!-- end-user-doc -->
	 */
	def edge: Set[UMLActivityEdge[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * If true, then any object used by an Action within the StructuredActivityNode cannot be accessed by any Action outside the node until the StructuredActivityNode as a whole completes. Any concurrent Actions that would result in accessing such objects are required to have their execution deferred until the completion of the StructuredActivityNode.

	 * <!-- end-user-doc -->
	 */
	def mustIsolate: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * The ActivityNodes immediately contained in the StructuredActivityNode.
	 * <!-- end-user-doc -->
	 */
	def node: Iterable[UMLActivityNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPins owned by the StructuredActivityNode.
	 * <!-- end-user-doc -->
	 */
	def structuredNodeInput: Iterable[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPins owned by the StructuredActivityNode.
	 * <!-- end-user-doc -->
	 */
	def structuredNodeOutput: Iterable[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Variables defined in the scope of the StructuredActivityNode.
	 * <!-- end-user-doc -->
	 */
	def variable: Set[UMLVariable[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLStructuredActivityNode
