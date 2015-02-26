package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ValuePin is an InputPin that provides a value by evaluating a ValueSpecification.
 * <!-- end-user-doc --> 
 */
trait UMLValuePin[Uml <: UML]
  extends UMLInputPin[Uml] with operations.UMLValuePinOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		valuePin_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLValuePin
	 */
	def valuePin_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		inputPin_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		valuePin_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLValuePin
	 */
	def valuePin_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		inputPin_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLValuePin[Uml], UMLValueSpecification[Uml]]("value", _.value)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		valuePin_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLValuePin
	 */
	def valuePin_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		inputPin_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		valuePin_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLValuePin
	 */
	def valuePin_forwardReferencesFromMetamodelAssociations: Elements =
		inputPin_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The ValueSpecification that is evaluated to obtain the value that the ValuePin will provide.
	 * <!-- end-user-doc -->
	 */
	def value: Option[UMLValueSpecification[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLValuePin
