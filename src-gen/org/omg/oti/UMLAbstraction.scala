package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An Abstraction is a Relationship that relates two Elements or sets of Elements that represent the same concept at different levels of abstraction or from different viewpoints.
 * <!-- end-user-doc --> 
 */
trait UMLAbstraction[Uml <: UML]
  extends UMLDependency[Uml] with operations.UMLAbstractionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		abstraction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAbstraction
	 */
	def abstraction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		dependency_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		abstraction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAbstraction
	 */
	def abstraction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		dependency_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLAbstraction[Uml], UMLOpaqueExpression[Uml]]("mapping", _.mapping)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		abstraction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAbstraction
	 */
	def abstraction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		dependency_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		abstraction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAbstraction
	 */
	def abstraction_forwardReferencesFromMetamodelAssociations: Elements =
		dependency_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * An OpaqueExpression that states the abstraction relationship between the supplier(s) and the client(s). In some cases, such as derivation, it is usually formal and unidirectional; in other cases, such as trace, it is usually informal and bidirectional. The mapping expression is optional and may be omitted if the precise relationship between the Elements is not specified.
	 * <!-- end-user-doc -->
	 */
	def mapping: Option[UMLOpaqueExpression[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLAbstraction
