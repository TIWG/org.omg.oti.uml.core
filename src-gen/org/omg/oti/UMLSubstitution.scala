package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A substitution is a relationship between two classifiers signifying that the substituting classifier complies with the contract specified by the contract classifier. This implies that instances of the substituting classifier are runtime substitutable where instances of the contract classifier are expected.
 * <!-- end-user-doc --> 
 */
trait UMLSubstitution[Uml <: UML]
  extends UMLRealization[Uml] with operations.UMLSubstitutionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		substitution_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLSubstitution
	 */
	def substitution_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		realization_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		substitution_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLSubstitution
	 */
	def substitution_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		realization_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		substitution_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLSubstitution
	 */
	def substitution_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		realization_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLSubstitution[Uml], UMLClassifier[Uml]]("contract", _.contract),
		  	MetaPropertyReference[Uml, UMLSubstitution[Uml], UMLClassifier[Uml]]("substitutingClassifier", _.substitutingClassifier)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		substitution_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLSubstitution
	 */
	def substitution_forwardReferencesFromMetamodelAssociations: Elements =
		realization_forwardReferencesFromMetamodelAssociations ++
		contract ++
		substitutingClassifier 

	/**
	 * <!-- begin-user-doc --> 
	 * The contract with which the substituting classifier complies.
	 * <!-- end-user-doc -->
	 */
	def contract: Option[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Instances of the substituting classifier are runtime substitutable where instances of the contract classifier are expected.
	 * <!-- end-user-doc -->
	 */
	def substitutingClassifier: Option[UMLClassifier[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLSubstitution
