package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * StructuredClassifiers may contain an internal structure of connected elements each of which plays a role in the overall Behavior modeled by the StructuredClassifier.
 * <!-- end-user-doc --> 
 */
trait UMLStructuredClassifier[Uml <: UML]
  extends UMLClassifier[Uml] with operations.UMLStructuredClassifierOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		structuredClassifier_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStructuredClassifier
	 */
	def structuredClassifier_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		classifier_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		structuredClassifier_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStructuredClassifier
	 */
	def structuredClassifier_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		classifier_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLStructuredClassifier[Uml], UMLProperty[Uml]]("ownedAttribute", _.ownedAttribute),
		  	MetaPropertyCollection[Uml, UMLStructuredClassifier[Uml], UMLConnector[Uml]]("ownedConnector", _.ownedConnector)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		structuredClassifier_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStructuredClassifier
	 */
	def structuredClassifier_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		classifier_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		structuredClassifier_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStructuredClassifier
	 */
	def structuredClassifier_forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The Properties owned by the StructuredClassifier.
	 * <!-- end-user-doc -->
	 */
	def ownedAttribute: Seq[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The connectors owned by the StructuredClassifier.
	 * <!-- end-user-doc -->
	 */
	def ownedConnector: Set[UMLConnector[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Properties specifying instances that the StructuredClassifier owns by composition. This collection is derived, selecting those owned Properties where isComposite is true.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (ownedAttribute->select(isComposite))
	 */
	def part: Set[UMLProperty[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * The roles that instances may play in this StructuredClassifier.
	 * <!-- end-user-doc -->
	 */
	def role: Set[UMLConnectableElement[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLStructuredClassifier
