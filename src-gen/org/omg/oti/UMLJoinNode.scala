package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A JoinNode is a ControlNode that synchronizes multiple flows.
 * <!-- end-user-doc --> 
 */
trait UMLJoinNode[Uml <: UML]
  extends UMLControlNode[Uml] with operations.UMLJoinNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		joinNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLJoinNode
	 */
	def joinNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		controlNode_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLJoinNode[Uml]](None, "isCombineDuplicate", (x) => booleanToIterable(x.isCombineDuplicate, true))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		joinNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLJoinNode
	 */
	def joinNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		controlNode_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLJoinNode[Uml], UMLValueSpecification[Uml]]("joinSpec", _.joinSpec)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		joinNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLJoinNode
	 */
	def joinNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		controlNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		joinNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLJoinNode
	 */
	def joinNode_forwardReferencesFromMetamodelAssociations: Elements =
		controlNode_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether incoming tokens having objects with the same identity are combined into one by the JoinNode.
	 * <!-- end-user-doc -->
	 */
	def isCombineDuplicate: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * A ValueSpecification giving the condition under which the JoinNode will offer a token on its outgoing ActivityEdge. If no joinSpec is specified, then the JoinNode will offer an outgoing token if tokens are offered on all of its incoming ActivityEdges (an "and" condition).
	 * <!-- end-user-doc -->
	 */
	def joinSpec: Option[UMLValueSpecification[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLJoinNode
