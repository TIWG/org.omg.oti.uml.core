package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Region is a top-level part of a StateMachine or a composite State, that serves as a container for the Vertices and Transitions of the StateMachine. A StateMachine or composite State may contain multiple Regions representing behaviors that may occur in parallel.
 * <!-- end-user-doc --> 
 */
trait UMLRegion[Uml <: UML]
  extends UMLRedefinableElement[Uml] with UMLNamespace[Uml] with operations.UMLRegionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		region_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLRegion
	 */
	def region_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		redefinableElement_metaAttributes,
		namespace_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		region_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLRegion
	 */
	def region_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_compositeMetaProperties,
		namespace_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLRegion[Uml], UMLVertex[Uml]]("subvertex", _.subvertex),
		  	MetaPropertyCollection[UMLRegion[Uml], UMLTransition[Uml]]("transition", _.transition)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		region_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLRegion
	 */
	def region_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_referenceMetaProperties,
		namespace_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLRegion[Uml], UMLRegion[Uml]]("extendedRegion", _.extendedRegion),
		  	MetaPropertyReference[UMLRegion[Uml], UMLState[Uml]]("state", _.state),
		  	MetaPropertyReference[UMLRegion[Uml], UMLStateMachine[Uml]]("stateMachine", _.stateMachine)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		region_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLRegion
	 */
	def region_forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		namespace_forwardReferencesFromMetamodelAssociations ++
		extendedRegion ++
		state ++
		stateMachine 

	/**
	 * <!-- begin-user-doc --> 
	 * The region of which this region is an extension.
	 * <!-- end-user-doc -->
	 */
	def extendedRegion: Option[UMLRegion[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Classifier in which context this element may be redefined.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (let sm : StateMachine = containingStateMachine() in
	 * if sm._'context' = null or sm.general->notEmpty() then
	 *   sm
	 * else
	 *   sm._'context'
	 * endif)
	 */
	override def redefinitionContext: Iterable[UMLClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * The State that owns the Region. If a Region is owned by a State, then it cannot also be owned by a StateMachine.
	 * <!-- end-user-doc -->
	 */
	def state: Option[UMLState[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The StateMachine that owns the Region. If a Region is owned by a StateMachine, then it cannot also be owned by a State.
	 * <!-- end-user-doc -->
	 */
	def stateMachine: Option[UMLStateMachine[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of Vertices that are owned by this Region.
	 * <!-- end-user-doc -->
	 */
	def subvertex: Set[UMLVertex[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of Transitions owned by the Region.
	 * <!-- end-user-doc -->
	 */
	def transition: Set[UMLTransition[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def extendedRegion_region: Set[UMLRegion[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLRegion
