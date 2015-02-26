package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An EnumerationLiteral is a user-defined data value for an Enumeration.
 * <!-- end-user-doc --> 
 */
trait UMLEnumerationLiteral[Uml <: UML]
  extends UMLInstanceSpecification[Uml] with operations.UMLEnumerationLiteralOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		enumerationLiteral_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLEnumerationLiteral
	 */
	def enumerationLiteral_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		instanceSpecification_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		enumerationLiteral_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLEnumerationLiteral
	 */
	def enumerationLiteral_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		instanceSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		enumerationLiteral_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLEnumerationLiteral
	 */
	def enumerationLiteral_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		instanceSpecification_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLEnumerationLiteral[Uml], UMLEnumeration[Uml]]("enumeration", _.enumeration)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		enumerationLiteral_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLEnumerationLiteral
	 */
	def enumerationLiteral_forwardReferencesFromMetamodelAssociations: Elements =
		instanceSpecification_forwardReferencesFromMetamodelAssociations ++
		enumeration 

	/**
	 * <!-- begin-user-doc --> 
	 * The classifier of this EnumerationLiteral derived to be equal to its Enumeration.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (enumeration)
	 */
	override def classifier: Iterable[UMLEnumeration[Uml]] = {
	    // Start of user code for "classifier"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * The Enumeration that this EnumerationLiteral is a member of.
	 * <!-- end-user-doc -->
	 */
	def enumeration: Option[UMLEnumeration[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLEnumerationLiteral
