package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ObjectFlow is an ActivityEdge that is traversed by object tokens that may hold values. Object flows also support multicast/receive, token selection from object nodes, and transformation of tokens.
 * <!-- end-user-doc --> 
 */
trait UMLObjectFlow[Uml <: UML]
  extends UMLActivityEdge[Uml] with operations.UMLObjectFlowOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		objectFlow_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLObjectFlow
	 */
	def objectFlow_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		activityEdge_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLObjectFlow[Uml]](None, "isMulticast", (x) => booleanToIterable(x.isMulticast, false)),
		  	MetaAttributeBooleanFunction[Uml, UMLObjectFlow[Uml]](None, "isMultireceive", (x) => booleanToIterable(x.isMultireceive, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		objectFlow_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLObjectFlow
	 */
	def objectFlow_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityEdge_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		objectFlow_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLObjectFlow
	 */
	def objectFlow_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityEdge_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLObjectFlow[Uml], UMLBehavior[Uml]]("selection", _.selection),
		  	MetaPropertyReference[Uml, UMLObjectFlow[Uml], UMLBehavior[Uml]]("transformation", _.transformation)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		objectFlow_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLObjectFlow
	 */
	def objectFlow_forwardReferencesFromMetamodelAssociations: Elements =
		activityEdge_forwardReferencesFromMetamodelAssociations ++
		selection ++
		transformation 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether the objects in the ObjectFlow are passed by multicasting.
	 * <!-- end-user-doc -->
	 */
	def isMulticast: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether the objects in the ObjectFlow are gathered from respondents to multicasting.
	 * <!-- end-user-doc -->
	 */
	def isMultireceive: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * A Behavior used to select tokens from a source ObjectNode.
	 * <!-- end-user-doc -->
	 */
	def selection: Option[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A Behavior used to change or replace object tokens flowing along the ObjectFlow.
	 * <!-- end-user-doc -->
	 */
	def transformation: Option[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def decisionInputFlow_decisionNode: Option[UMLDecisionNode[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLObjectFlow
