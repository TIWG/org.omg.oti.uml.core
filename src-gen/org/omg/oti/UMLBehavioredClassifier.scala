package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A BehavioredClassifier may have InterfaceRealizations, and owns a set of Behaviors one of which may specify the behavior of the BehavioredClassifier itself.
 * <!-- end-user-doc --> 
 */
trait UMLBehavioredClassifier[Uml <: UML]
  extends UMLClassifier[Uml] with operations.UMLBehavioredClassifierOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		behavioredClassifier_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLBehavioredClassifier
	 */
	def behavioredClassifier_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		classifier_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		behavioredClassifier_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLBehavioredClassifier
	 */
	def behavioredClassifier_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		classifier_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLBehavioredClassifier[Uml], UMLInterfaceRealization[Uml]]("interfaceRealization", _.interfaceRealization),
		  	MetaPropertyCollection[Uml, UMLBehavioredClassifier[Uml], UMLBehavior[Uml]]("ownedBehavior", _.ownedBehavior)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		behavioredClassifier_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLBehavioredClassifier
	 */
	def behavioredClassifier_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		classifier_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLBehavioredClassifier[Uml], UMLBehavior[Uml]]("classifierBehavior", _.classifierBehavior)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		behavioredClassifier_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLBehavioredClassifier
	 */
	def behavioredClassifier_forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations ++
		classifierBehavior 

	/**
	 * <!-- begin-user-doc --> 
	 * A Behavior that specifies the behavior of the BehavioredClassifier itself.
	 * <!-- end-user-doc -->
	 */
	def classifierBehavior: Option[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of InterfaceRealizations owned by the BehavioredClassifier. Interface realizations reference the Interfaces of which the BehavioredClassifier is an implementation.
	 * <!-- end-user-doc -->
	 */
	def interfaceRealization: Set[UMLInterfaceRealization[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Behaviors owned by a BehavioredClassifier.
	 * <!-- end-user-doc -->
	 */
	def ownedBehavior: Set[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def context_behavior: Set[UMLBehavior[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLBehavioredClassifier
