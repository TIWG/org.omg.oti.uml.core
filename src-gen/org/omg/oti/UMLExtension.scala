package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An extension is used to indicate that the properties of a metaclass are extended through a stereotype, and gives the ability to flexibly add (and later remove) stereotypes to classes.
 * <!-- end-user-doc --> 
 */
trait UMLExtension[Uml <: UML]
  extends UMLAssociation[Uml] with operations.UMLExtensionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		extension_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExtension
	 */
	def extension_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		association_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		extension_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExtension
	 */
	def extension_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		association_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLExtension[Uml], UMLExtensionEnd[Uml]]("ownedEnd", _.ownedEnd)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		extension_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExtension
	 */
	def extension_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		association_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		extension_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExtension
	 */
	def extension_forwardReferencesFromMetamodelAssociations: Elements =
		association_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether an instance of the extending stereotype must be created when an instance of the extended class is created. The attribute value is derived from the value of the lower property of the ExtensionEnd referenced by Extension::ownedEnd; a lower value of 1 means that isRequired is true, but otherwise it is false. Since the default value of ExtensionEnd::lower is 0, the default value of isRequired is false.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (ownedEnd.lowerBound() = 1)
	 */
	def isRequired: Boolean = {
	    // Start of user code for "isRequired"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * References the Class that is extended through an Extension. The property is derived from the type of the memberEnd that is not the ownedEnd.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (metaclassEnd().type.oclAsType(Class))
	 */
	def metaclass: Option[UMLClass[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * References the end of the extension that is typed by a Stereotype.
	 * <!-- end-user-doc -->
	 */
	override def ownedEnd: Iterable[UMLExtensionEnd[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLExtension
