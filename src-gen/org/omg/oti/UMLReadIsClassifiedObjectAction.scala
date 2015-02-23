package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ReadIsClassifiedObjectAction is an Action that determines whether an object is classified by a given Classifier.
 * <!-- end-user-doc --> 
 */
trait UMLReadIsClassifiedObjectAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLReadIsClassifiedObjectActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		readIsClassifiedObjectAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReadIsClassifiedObjectAction
	 */
	def readIsClassifiedObjectAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLReadIsClassifiedObjectAction[Uml]](None, "isDirect", (x) => booleanToIterable(x.isDirect, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		readIsClassifiedObjectAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReadIsClassifiedObjectAction
	 */
	def readIsClassifiedObjectAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLReadIsClassifiedObjectAction[Uml], UMLInputPin[Uml]]("object", _._object),
		  	MetaPropertyReference[UMLReadIsClassifiedObjectAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		readIsClassifiedObjectAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReadIsClassifiedObjectAction
	 */
	def readIsClassifiedObjectAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLReadIsClassifiedObjectAction[Uml], UMLClassifier[Uml]]("classifier", _.classifier)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		readIsClassifiedObjectAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReadIsClassifiedObjectAction
	 */
	def readIsClassifiedObjectAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		classifier 

	/**
	 * <!-- begin-user-doc --> 
	 * The Classifier against which the classification of the input object is tested.
	 * <!-- end-user-doc -->
	 */
	def classifier: Option[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether the input object must be directly classified by the given Classifier or whether it may also be an instance of a specialization of the given Classifier.
	 * <!-- end-user-doc -->
	 */
	def isDirect: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that holds the object whose classification is to be tested.
	 * <!-- end-user-doc -->
	 */
	def _object: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin that holds the Boolean result of the test.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLReadIsClassifiedObjectAction
