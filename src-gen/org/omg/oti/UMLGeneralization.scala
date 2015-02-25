package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Generalization is a taxonomic relationship between a more general Classifier and a more specific Classifier. Each instance of the specific Classifier is also an instance of the general Classifier. The specific Classifier inherits the features of the more general Classifier. A Generalization is owned by the specific Classifier.
 * <!-- end-user-doc --> 
 */
trait UMLGeneralization[Uml <: UML]
  extends UMLDirectedRelationship[Uml] with operations.UMLGeneralizationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		generalization_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLGeneralization
	 */
	def generalization_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		directedRelationship_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLGeneralization[Uml]](None, "isSubstitutable", _.isSubstitutable)) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		generalization_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLGeneralization
	 */
	def generalization_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		generalization_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLGeneralization
	 */
	def generalization_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLGeneralization[Uml], UMLClassifier[Uml]]("general", _.general),
		  	MetaPropertyCollection[UMLGeneralization[Uml], UMLGeneralizationSet[Uml]]("generalizationSet", _.generalizationSet),
		  	MetaPropertyReference[UMLGeneralization[Uml], UMLClassifier[Uml]]("specific", _.specific)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		generalization_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLGeneralization
	 */
	def generalization_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		general ++
		generalizationSet ++
		specific 

	/**
	 * <!-- begin-user-doc --> 
	 * The general classifier in the Generalization relationship.
	 * <!-- end-user-doc -->
	 */
	def general: Option[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Represents a set of instances of Generalization.  A Generalization may appear in many GeneralizationSets.
	 * <!-- end-user-doc -->
	 */
	def generalizationSet: Set[UMLGeneralizationSet[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether the specific Classifier can be used wherever the general Classifier can be used. If true, the execution traces of the specific Classifier shall be a superset of the execution traces of the general Classifier. If false, there is no such constraint on execution traces. If unset, the modeler has not stated whether there is such a constraint or not.
   * 
   * UML 2.5 BUG:
   * 
   * The description of isSubstitutable makes a distinction between 3 cases:
   * - no value
   * - a value (true)
   * - a value (false)
   * 
   * It completely defeats the purpose of making a distinction amongst 3 cases if we have a default value!
   * If there is a default value, then using that default would loose the ability to represent the case where there is no value!
   * 
   * So instead of:
   * 
   * isSubstitable: Boolean[0..1] = true
   * 
   * it should be defined as: 
   * 
   * isSubstitable: Boolean[0..1]
   * 
   * The OTI API assumes that isSubstituable is really an optional boolean, no default.
	 * <!-- end-user-doc -->
	 */
	def isSubstitutable: Option[Boolean]

	/**
	 * <!-- begin-user-doc --> 
	 * The specializing Classifier in the Generalization relationship.
	 * <!-- end-user-doc -->
	 */
	def specific: Option[UMLClassifier[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLGeneralization
