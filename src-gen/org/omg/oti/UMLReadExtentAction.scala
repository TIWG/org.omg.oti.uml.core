package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ReadExtentAction is an Action that retrieves the current instances of a Classifier.
 * <!-- end-user-doc --> 
 */
trait UMLReadExtentAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLReadExtentActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		readExtentAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReadExtentAction
	 */
	def readExtentAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		readExtentAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReadExtentAction
	 */
	def readExtentAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLReadExtentAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		readExtentAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReadExtentAction
	 */
	def readExtentAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLReadExtentAction[Uml], UMLClassifier[Uml]]("classifier", _.classifier)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		readExtentAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReadExtentAction
	 */
	def readExtentAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		classifier 

	/**
	 * <!-- begin-user-doc --> 
	 * The Classifier whose instances are to be retrieved.
	 * <!-- end-user-doc -->
	 */
	def classifier: Option[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin on which the Classifier instances are placed.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLReadExtentAction
