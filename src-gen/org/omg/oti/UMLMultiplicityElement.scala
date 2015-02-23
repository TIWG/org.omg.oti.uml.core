package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A multiplicity is a definition of an inclusive interval of non-negative integers beginning with a lower bound and ending with a (possibly infinite) upper bound. A MultiplicityElement embeds this information to specify the allowable cardinalities for an instantiation of the Element.
 * <!-- end-user-doc --> 
 */
trait UMLMultiplicityElement[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLMultiplicityElementOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		multiplicityElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLMultiplicityElement
	 */
	def multiplicityElement_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLMultiplicityElement[Uml]](None, "isOrdered", (x) => booleanToIterable(x.isOrdered, false)),
		  	MetaAttributeBooleanFunction[UMLMultiplicityElement[Uml]](None, "isUnique", (x) => booleanToIterable(x.isUnique, true))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		multiplicityElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLMultiplicityElement
	 */
	def multiplicityElement_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLMultiplicityElement[Uml], UMLValueSpecification[Uml]]("lowerValue", _.lowerValue),
		  	MetaPropertyReference[UMLMultiplicityElement[Uml], UMLValueSpecification[Uml]]("upperValue", _.upperValue)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		multiplicityElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLMultiplicityElement
	 */
	def multiplicityElement_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		multiplicityElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLMultiplicityElement
	 */
	def multiplicityElement_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * For a multivalued multiplicity, this attribute specifies whether the values in an instantiation of this MultiplicityElement are sequentially ordered.
	 * <!-- end-user-doc -->
	 */
	def isOrdered: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * For a multivalued multiplicity, this attributes specifies whether the values in an instantiation of this MultiplicityElement are unique.
	 * <!-- end-user-doc -->
	 */
	def isUnique: Boolean = true

	/**
	 * <!-- begin-user-doc --> 
	 * The lower bound of the multiplicity interval.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (lowerBound())
	 */
	def lower: Integer


	/**
	 * <!-- begin-user-doc --> 
	 * The specification of the lower bound for this multiplicity.
	 * <!-- end-user-doc -->
	 */
	def lowerValue: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The upper bound of the multiplicity interval.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (upperBound())
	 */
	def upper: Integer

	/**
	 * <!-- begin-user-doc --> 
	 * The specification of the upper bound for this multiplicity.
	 * <!-- end-user-doc -->
	 */
	def upperValue: Option[UMLValueSpecification[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLMultiplicityElement
