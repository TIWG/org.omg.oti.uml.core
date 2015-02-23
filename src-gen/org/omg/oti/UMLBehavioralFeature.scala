package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A BehavioralFeature is a feature of a Classifier that specifies an aspect of the behavior of its instances.  A BehavioralFeature is implemented (realized) by a Behavior. A BehavioralFeature specifies that a Classifier will respond to a designated request by invoking its implementing method.
 * <!-- end-user-doc --> 
 */
trait UMLBehavioralFeature[Uml <: UML]
  extends UMLFeature[Uml] with UMLNamespace[Uml] with operations.UMLBehavioralFeatureOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		behavioralFeature_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLBehavioralFeature
	 */
	def behavioralFeature_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		feature_metaAttributes,
		namespace_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLBehavioralFeature[Uml]](None, "isAbstract", (x) => booleanToIterable(x.isAbstract, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		behavioralFeature_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLBehavioralFeature
	 */
	def behavioralFeature_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		feature_compositeMetaProperties,
		namespace_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLBehavioralFeature[Uml], UMLParameter[Uml]]("ownedParameter", _.ownedParameter),
		  	MetaPropertyCollection[UMLBehavioralFeature[Uml], UMLParameterSet[Uml]]("ownedParameterSet", _.ownedParameterSet)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		behavioralFeature_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLBehavioralFeature
	 */
	def behavioralFeature_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		feature_referenceMetaProperties,
		namespace_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLBehavioralFeature[Uml], UMLBehavior[Uml]]("method", _.method),
		  	MetaPropertyCollection[UMLBehavioralFeature[Uml], UMLType[Uml]]("raisedException", _.raisedException)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		behavioralFeature_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLBehavioralFeature
	 */
	def behavioralFeature_forwardReferencesFromMetamodelAssociations: Elements =
		feature_forwardReferencesFromMetamodelAssociations ++
		namespace_forwardReferencesFromMetamodelAssociations ++
		method ++
		raisedException 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the semantics of concurrent calls to the same passive instance (i.e., an instance originating from a Class with isActive being false). Active instances control access to their own BehavioralFeatures.
	 * <!-- end-user-doc -->
	 */
	def concurrency: UMLCallConcurrencyKind.Value

	/**
	 * <!-- begin-user-doc --> 
	 * If true, then the BehavioralFeature does not have an implementation, and one must be supplied by a more specific Classifier. If false, the BehavioralFeature must have an implementation in the Classifier or one must be inherited.
	 * <!-- end-user-doc -->
	 */
	def isAbstract: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * A Behavior that implements the BehavioralFeature. There may be at most one Behavior for a particular pairing of a Classifier (as owner of the Behavior) and a BehavioralFeature (as specification of the Behavior).
	 * <!-- end-user-doc -->
	 */
	def method: Set[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ordered set of formal Parameters of this BehavioralFeature.
	 * <!-- end-user-doc -->
	 */
	def ownedParameter: Seq[UMLParameter[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ParameterSets owned by this BehavioralFeature.
	 * <!-- end-user-doc -->
	 */
	def ownedParameterSet: Set[UMLParameterSet[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Types representing exceptions that may be raised during an invocation of this BehavioralFeature.
	 * <!-- end-user-doc -->
	 */
	def raisedException: Set[UMLType[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLBehavioralFeature
