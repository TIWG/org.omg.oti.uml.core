package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An Activity is the specification of parameterized Behavior as the coordinated sequencing of subordinate units.
 * <!-- end-user-doc --> 
 */
trait UMLActivity[Uml <: UML]
  extends UMLBehavior[Uml] with operations.UMLActivityOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activity_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivity
	 */
	def activity_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		behavior_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLActivity[Uml]](None, "isReadOnly", (x) => booleanToIterable(x.isReadOnly, false)),
		  	MetaAttributeBooleanFunction[Uml, UMLActivity[Uml]](None, "isSingleExecution", (x) => booleanToIterable(x.isSingleExecution, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activity_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivity
	 */
	def activity_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		behavior_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLActivity[Uml], UMLActivityEdge[Uml]]("edge", _.edge),
		  	MetaPropertyCollection[Uml, UMLActivity[Uml], UMLActivityGroup[Uml]]("group", _.group),
		  	MetaPropertyCollection[Uml, UMLActivity[Uml], UMLActivityNode[Uml]]("node", _.node),
		  	MetaPropertyCollection[Uml, UMLActivity[Uml], UMLStructuredActivityNode[Uml]]("structuredNode", _.structuredNode),
		  	MetaPropertyCollection[Uml, UMLActivity[Uml], UMLVariable[Uml]]("variable", _.variable)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activity_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivity
	 */
	def activity_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		behavior_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLActivity[Uml], UMLActivityPartition[Uml]]("partition", _.partition)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activity_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivity
	 */
	def activity_forwardReferencesFromMetamodelAssociations: Elements =
		behavior_forwardReferencesFromMetamodelAssociations ++
		partition 

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityEdges expressing flow between the nodes of the Activity.
	 * <!-- end-user-doc -->
	 */
	def edge: Set[UMLActivityEdge[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Top-level ActivityGroups in the Activity.
	 * <!-- end-user-doc -->
	 */
	def group: Set[UMLActivityGroup[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * If true, this Activity must not make any changes to objects. The default is false (an Activity may make nonlocal changes). (This is an assertion, not an executable property. It may be used by an execution engine to optimize model execution. If the assertion is violated by the Activity, then the model is ill-formed.) 
	 * <!-- end-user-doc -->
	 */
	def isReadOnly: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * If true, all invocations of the Activity are handled by the same execution.
	 * <!-- end-user-doc -->
	 */
	def isSingleExecution: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * ActivityNodes coordinated by the Activity.
	 * <!-- end-user-doc -->
	 */
	def node: Set[UMLActivityNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Top-level ActivityPartitions in the Activity.
	 * <!-- end-user-doc -->
	 */
	def partition: Set[UMLActivityPartition[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Top-level StructuredActivityNodes in the Activity.
	 * <!-- end-user-doc -->
	 */
	def structuredNode: Set[UMLStructuredActivityNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Top-level Variables defined by the Activity.
	 * <!-- end-user-doc -->
	 */
	def variable: Set[UMLVariable[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLActivity
