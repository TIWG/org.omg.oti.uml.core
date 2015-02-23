package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * Realization is a specialized Abstraction relationship between two sets of model Elements, one representing a specification (the supplier) and the other represents an implementation of the latter (the client). Realization can be used to model stepwise refinement, optimizations, transformations, templates, model synthesis, framework composition, etc.
 * <!-- end-user-doc --> 
 */
trait UMLRealization[Uml <: UML]
  extends UMLAbstraction[Uml] with operations.UMLRealizationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		realization_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLRealization
	 */
	def realization_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		abstraction_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		realization_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLRealization
	 */
	def realization_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		abstraction_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		realization_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLRealization
	 */
	def realization_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		abstraction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		realization_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLRealization
	 */
	def realization_forwardReferencesFromMetamodelAssociations: Elements =
		abstraction_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLRealization
