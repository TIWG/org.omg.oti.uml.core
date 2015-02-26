package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A CreateObjectAction is an Action that creates an instance of the specified Classifier.
 * <!-- end-user-doc --> 
 */
trait UMLCreateObjectAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLCreateObjectActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		createObjectAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCreateObjectAction
	 */
	def createObjectAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		createObjectAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCreateObjectAction
	 */
	def createObjectAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLCreateObjectAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		createObjectAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCreateObjectAction
	 */
	def createObjectAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLCreateObjectAction[Uml], UMLClassifier[Uml]]("classifier", _.classifier)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		createObjectAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCreateObjectAction
	 */
	def createObjectAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		classifier 

	/**
	 * <!-- begin-user-doc --> 
	 * The Classifier to be instantiated.
	 * <!-- end-user-doc -->
	 */
	def classifier: Option[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin on which the newly created object is placed.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLCreateObjectAction
