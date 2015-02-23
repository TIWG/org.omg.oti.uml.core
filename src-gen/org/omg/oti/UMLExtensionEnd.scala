package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An extension end is used to tie an extension to a stereotype when extending a metaclass.
The default multiplicity of an extension end is 0..1.
 * <!-- end-user-doc --> 
 */
trait UMLExtensionEnd[Uml <: UML]
  extends UMLProperty[Uml] with operations.UMLExtensionEndOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		extensionEnd_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExtensionEnd
	 */
	def extensionEnd_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		property_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		extensionEnd_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExtensionEnd
	 */
	def extensionEnd_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		property_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		extensionEnd_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExtensionEnd
	 */
	def extensionEnd_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		property_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLExtensionEnd[Uml], UMLStereotype[Uml]]("type", _._type)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		extensionEnd_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExtensionEnd
	 */
	def extensionEnd_forwardReferencesFromMetamodelAssociations: Elements =
		property_forwardReferencesFromMetamodelAssociations ++
		_type 

	/**
	 * <!-- begin-user-doc --> 
	 * This redefinition changes the default multiplicity of association ends, since model elements are usually extended by 0 or 1 instance of the extension stereotype.
	 * <!-- end-user-doc -->
	 *
	 */
	override def lower: Integer = {
	    // Start of user code for "lower"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * References the type of the ExtensionEnd. Note that this association restricts the possible types of an ExtensionEnd to only be Stereotypes.
	 * <!-- end-user-doc -->
	 */
	override def _type: Option[UMLStereotype[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedEnd_extension: Option[UMLExtension[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLExtensionEnd
