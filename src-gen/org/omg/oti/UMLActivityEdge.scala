package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ActivityEdge is an abstract class for directed connections between two ActivityNodes.
 * <!-- end-user-doc --> 
 */
trait UMLActivityEdge[Uml <: UML]
  extends UMLRedefinableElement[Uml] with operations.UMLActivityEdgeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activityEdge_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivityEdge
	 */
	def activityEdge_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		redefinableElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activityEdge_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivityEdge
	 */
	def activityEdge_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLValueSpecification[Uml]]("guard", _.guard),
		  	MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLValueSpecification[Uml]]("weight", _.weight)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activityEdge_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivityEdge
	 */
	def activityEdge_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLActivity[Uml]]("activity", _.activity),
		  	MetaPropertyCollection[Uml, UMLActivityEdge[Uml], UMLActivityPartition[Uml]]("inPartition", _.inPartition),
		  	MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLStructuredActivityNode[Uml]]("inStructuredNode", _.inStructuredNode),
		  	MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLInterruptibleActivityRegion[Uml]]("interrupts", _.interrupts),
		  	MetaPropertyCollection[Uml, UMLActivityEdge[Uml], UMLActivityEdge[Uml]]("redefinedEdge", _.redefinedEdge),
		  	MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLActivityNode[Uml]]("source", _.source),
		  	MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLActivityNode[Uml]]("target", _.target)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activityEdge_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivityEdge
	 */
	def activityEdge_forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		activity ++
		inPartition ++
		inStructuredNode ++
		interrupts ++
		redefinedEdge ++
		source ++
		target 

	/**
	 * <!-- begin-user-doc --> 
	 * The Activity containing the ActivityEdge, if it is directly owned by an Activity.
	 * <!-- end-user-doc -->
	 */
	def activity: Option[UMLActivity[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A ValueSpecification that is evaluated to determine if a token can traverse the ActivityEdge. If an ActivityEdge has no guard, then there is no restriction on tokens traversing the edge.
	 * <!-- end-user-doc -->
	 */
	def guard: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityGroups containing the ActivityEdge.
	 * <!-- end-user-doc -->
	 */
	def inGroup: Set[UMLActivityGroup[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityPartitions containing the ActivityEdge.
	 * <!-- end-user-doc -->
	 */
	def inPartition: Set[UMLActivityPartition[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The StructuredActivityNode containing the ActivityEdge, if it is owned by a StructuredActivityNode.
	 * <!-- end-user-doc -->
	 */
	def inStructuredNode: Option[UMLStructuredActivityNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The InterruptibleActivityRegion for which this ActivityEdge is an interruptingEdge.
	 * <!-- end-user-doc -->
	 */
	def interrupts: Option[UMLInterruptibleActivityRegion[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityEdges from a generalization of the Activity containing this ActivityEdge that are redefined by this ActivityEdge.
	 * <!-- end-user-doc -->
	 */
	def redefinedEdge: Set[UMLActivityEdge[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ActivityNode from which tokens are taken when they traverse the ActivityEdge.
	 * <!-- end-user-doc -->
	 */
	def source: Option[UMLActivityNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ActivityNode to which tokens are put when they traverse the ActivityEdge.
	 * <!-- end-user-doc -->
	 */
	def target: Option[UMLActivityNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The minimum number of tokens that must traverse the ActivityEdge at the same time. If no weight is specified, this is equivalent to specifying a constant value of 1.
	 * <!-- end-user-doc -->
	 */
	def weight: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinedEdge_activityEdge: Set[UMLActivityEdge[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def realizingActivityEdge_informationFlow: Set[UMLInformationFlow[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLActivityEdge
