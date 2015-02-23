package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * Observation specifies a value determined by observing an event or events that occur relative to other model Elements.
 * <!-- end-user-doc --> 
 */
trait UMLObservation[Uml <: UML]
  extends UMLPackageableElement[Uml] with operations.UMLObservationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		observation_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLObservation
	 */
	def observation_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		packageableElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		observation_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLObservation
	 */
	def observation_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		packageableElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		observation_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLObservation
	 */
	def observation_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		packageableElement_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		observation_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLObservation
	 */
	def observation_forwardReferencesFromMetamodelAssociations: Elements =
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		Set () 


	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def observation_timeExpression: Option[UMLTimeExpression[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def observation_duration: Option[UMLDuration[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLObservation
