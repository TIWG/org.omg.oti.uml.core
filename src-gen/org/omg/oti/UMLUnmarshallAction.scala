package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An UnmarshallAction is an Action that retrieves the values of the StructuralFeatures of an object and places them on OutputPins. 
 * <!-- end-user-doc --> 
 */
trait UMLUnmarshallAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLUnmarshallActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		unmarshallAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLUnmarshallAction
	 */
	def unmarshallAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		unmarshallAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLUnmarshallAction
	 */
	def unmarshallAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLUnmarshallAction[Uml], UMLInputPin[Uml]]("object", _._object),
		  	MetaPropertyCollection[Uml, UMLUnmarshallAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		unmarshallAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLUnmarshallAction
	 */
	def unmarshallAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLUnmarshallAction[Uml], UMLClassifier[Uml]]("unmarshallType", _.unmarshallType)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		unmarshallAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLUnmarshallAction
	 */
	def unmarshallAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		unmarshallType 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that gives the object to be unmarshalled.
	 * <!-- end-user-doc -->
	 */
	def _object: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPins on which are placed the values of the StructuralFeatures of the input object.
	 * <!-- end-user-doc -->
	 */
	def result: Seq[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The type of the object to be unmarshalled.
	 * <!-- end-user-doc -->
	 */
	def unmarshallType: Option[UMLClassifier[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLUnmarshallAction
