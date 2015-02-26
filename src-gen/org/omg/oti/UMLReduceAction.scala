package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ReduceAction is an Action that reduces a collection to a single value by repeatedly combining the elements of the collection using a reducer Behavior.
 * <!-- end-user-doc --> 
 */
trait UMLReduceAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLReduceActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		reduceAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReduceAction
	 */
	def reduceAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLReduceAction[Uml]](None, "isOrdered", (x) => booleanToIterable(x.isOrdered, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		reduceAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReduceAction
	 */
	def reduceAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLReduceAction[Uml], UMLInputPin[Uml]]("collection", _.collection),
		  	MetaPropertyReference[Uml, UMLReduceAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		reduceAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReduceAction
	 */
	def reduceAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLReduceAction[Uml], UMLBehavior[Uml]]("reducer", _.reducer)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		reduceAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReduceAction
	 */
	def reduceAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		reducer 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that provides the collection to be reduced.
	 * <!-- end-user-doc -->
	 */
	def collection: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether the order of the input collection should determine the order in which the reducer Behavior is applied to its elements.
	 * <!-- end-user-doc -->
	 */
	def isOrdered: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * A Behavior that is repreatedly applied to two elements of the input collection to produce a value that is of the same type as elements of the collection.
	 * <!-- end-user-doc -->
	 */
	def reducer: Option[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The output pin on which the result value is placed.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLReduceAction
