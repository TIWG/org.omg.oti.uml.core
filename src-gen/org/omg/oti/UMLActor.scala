package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An Actor specifies a role played by a user or any other system that interacts with the subject.
 * <!-- end-user-doc --> 
 */
trait UMLActor[Uml <: UML]
  extends UMLBehavioredClassifier[Uml] with operations.UMLActorOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		actor_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActor
	 */
	def actor_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		behavioredClassifier_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		actor_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActor
	 */
	def actor_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		behavioredClassifier_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		actor_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActor
	 */
	def actor_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		behavioredClassifier_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		actor_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActor
	 */
	def actor_forwardReferencesFromMetamodelAssociations: Elements =
		behavioredClassifier_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLActor
