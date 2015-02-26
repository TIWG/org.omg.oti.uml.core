package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A DecisionNode is a ControlNode that chooses between outgoing ActivityEdges for the routing of tokens.
 * <!-- end-user-doc --> 
 */
trait UMLDecisionNode[Uml <: UML]
  extends UMLControlNode[Uml] with operations.UMLDecisionNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		decisionNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDecisionNode
	 */
	def decisionNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		controlNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		decisionNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDecisionNode
	 */
	def decisionNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		controlNode_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		decisionNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDecisionNode
	 */
	def decisionNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		controlNode_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLDecisionNode[Uml], UMLBehavior[Uml]]("decisionInput", _.decisionInput),
		  	MetaPropertyReference[Uml, UMLDecisionNode[Uml], UMLObjectFlow[Uml]]("decisionInputFlow", _.decisionInputFlow)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		decisionNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDecisionNode
	 */
	def decisionNode_forwardReferencesFromMetamodelAssociations: Elements =
		controlNode_forwardReferencesFromMetamodelAssociations ++
		decisionInput ++
		decisionInputFlow 

	/**
	 * <!-- begin-user-doc --> 
	 * A Behavior that is executed to provide an input to guard ValueSpecifications on ActivityEdges outgoing from the DecisionNode.
	 * <!-- end-user-doc -->
	 */
	def decisionInput: Option[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An additional ActivityEdge incoming to the DecisionNode that provides a decision input value for the guards ValueSpecifications on ActivityEdges outgoing from the DecisionNode.
	 * <!-- end-user-doc -->
	 */
	def decisionInputFlow: Option[UMLObjectFlow[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLDecisionNode
