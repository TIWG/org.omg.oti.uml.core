package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A QualifierValue is an Element that is used as part of LinkEndData to provide the value for a single qualifier of the end given by the LinkEndData.
 * <!-- end-user-doc --> 
 */
trait UMLQualifierValue[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLQualifierValueOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		qualifierValue_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLQualifierValue
	 */
	def qualifierValue_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		qualifierValue_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLQualifierValue
	 */
	def qualifierValue_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		qualifierValue_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLQualifierValue
	 */
	def qualifierValue_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLQualifierValue[Uml], UMLProperty[Uml]]("qualifier", _.qualifier),
		  	MetaPropertyReference[Uml, UMLQualifierValue[Uml], UMLInputPin[Uml]]("value", _.value)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		qualifierValue_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLQualifierValue
	 */
	def qualifierValue_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		qualifier ++
		value 

	/**
	 * <!-- begin-user-doc --> 
	 * The qualifier Property for which the value is to be specified.
	 * <!-- end-user-doc -->
	 */
	def qualifier: Option[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin from which the specified value for the qualifier is taken.
	 * <!-- end-user-doc -->
	 */
	def value: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def qualifier_linkEndData: Option[UMLLinkEndData[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLQualifierValue
