package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A TypedElement is a NamedElement that may have a Type specified for it.
 * <!-- end-user-doc --> 
 */
trait UMLTypedElement[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLTypedElementOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		typedElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTypedElement
	 */
	def typedElement_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		typedElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTypedElement
	 */
	def typedElement_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		typedElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTypedElement
	 */
	def typedElement_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLTypedElement[Uml], UMLType[Uml]]("type", _._type)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		typedElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTypedElement
	 */
	def typedElement_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		_type 

	/**
	 * <!-- begin-user-doc --> 
	 * The type of the TypedElement.
	 * <!-- end-user-doc -->
	 */
	def _type: Option[UMLType[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLTypedElement
