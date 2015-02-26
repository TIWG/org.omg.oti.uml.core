package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ValueSpecificationAction is an Action that evaluates a ValueSpecification and provides a result.
 * <!-- end-user-doc --> 
 */
trait UMLValueSpecificationAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLValueSpecificationActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		valueSpecificationAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLValueSpecificationAction
	 */
	def valueSpecificationAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		valueSpecificationAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLValueSpecificationAction
	 */
	def valueSpecificationAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLValueSpecificationAction[Uml], UMLOutputPin[Uml]]("result", _.result),
		  	MetaPropertyReference[Uml, UMLValueSpecificationAction[Uml], UMLValueSpecification[Uml]]("value", _.value)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		valueSpecificationAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLValueSpecificationAction
	 */
	def valueSpecificationAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		valueSpecificationAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLValueSpecificationAction
	 */
	def valueSpecificationAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin on which the result value is placed.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ValueSpecification to be evaluated.
	 * <!-- end-user-doc -->
	 */
	def value: Option[UMLValueSpecification[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLValueSpecificationAction
