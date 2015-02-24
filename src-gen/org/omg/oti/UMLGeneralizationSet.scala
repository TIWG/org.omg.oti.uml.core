package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A GeneralizationSet is a PackageableElement whose instances represent sets of Generalization relationships.
 * <!-- end-user-doc --> 
 */
trait UMLGeneralizationSet[Uml <: UML]
  extends UMLPackageableElement[Uml] with operations.UMLGeneralizationSetOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		generalizationSet_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLGeneralizationSet
	 */
	def generalizationSet_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		packageableElement_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLGeneralizationSet[Uml]](None, "isCovering", (x) => booleanToIterable(x.isCovering, false)),
		  	MetaAttributeBooleanFunction[UMLGeneralizationSet[Uml]](None, "isDisjoint", (x) => booleanToIterable(x.isDisjoint, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		generalizationSet_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLGeneralizationSet
	 */
	def generalizationSet_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		packageableElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		generalizationSet_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLGeneralizationSet
	 */
	def generalizationSet_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		packageableElement_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLGeneralizationSet[Uml], UMLGeneralization[Uml]]("generalization", _.generalization),
		  	MetaPropertyReference[UMLGeneralizationSet[Uml], UMLClassifier[Uml]]("powertype", _.powertype)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		generalizationSet_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLGeneralizationSet
	 */
	def generalizationSet_forwardReferencesFromMetamodelAssociations: Elements =
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		generalization ++
		powertype 

	/**
	 * <!-- begin-user-doc --> 
	 * Designates the instances of Generalization that are members of this GeneralizationSet.
	 * <!-- end-user-doc -->
	 */
	def generalization: Set[UMLGeneralization[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates (via the associated Generalizations) whether or not the set of specific Classifiers are covering for a particular general classifier. When isCovering is true, every instance of a particular general Classifier is also an instance of at least one of its specific Classifiers for the GeneralizationSet. When isCovering is false, there are one or more instances of the particular general Classifier that are not instances of at least one of its specific Classifiers defined for the GeneralizationSet.
	 * <!-- end-user-doc -->
	 */
	def isCovering: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether or not the set of specific Classifiers in a Generalization relationship have instance in common. If isDisjoint is true, the specific Classifiers for a particular GeneralizationSet have no members in common; that is, their intersection is empty. If isDisjoint is false, the specific Classifiers in a particular GeneralizationSet have one or more members in common; that is, their intersection is not empty.
	 * <!-- end-user-doc -->
	 */
	def isDisjoint: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * Designates the Classifier that is defined as the power type for the associated GeneralizationSet, if there is one.
	 * <!-- end-user-doc -->
	 */
	def powertype: Option[UMLClassifier[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLGeneralizationSet
