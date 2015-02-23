package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A stereotype defines how an existing metaclass may be extended, and enables the use of platform or domain specific terminology or notation in place of, or in addition to, the ones used for the extended metaclass.
 * <!-- end-user-doc --> 
 */
trait UMLStereotype[Uml <: UML]
  extends UMLClass[Uml] with operations.UMLStereotypeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		stereotype_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStereotype
	 */
	def stereotype_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		class_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		stereotype_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStereotype
	 */
	def stereotype_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		class_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLStereotype[Uml], UMLImage[Uml]]("icon", _.icon)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		stereotype_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStereotype
	 */
	def stereotype_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		class_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		stereotype_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStereotype
	 */
	def stereotype_forwardReferencesFromMetamodelAssociations: Elements =
		class_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Stereotype can change the graphical appearance of the extended model element by using attached icons. When this association is not null, it references the location of the icon content to be displayed within diagrams presenting the extended model elements.
	 * <!-- end-user-doc -->
	 */
	def icon: Set[UMLImage[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The profile that directly or indirectly contains this stereotype.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (self.containingProfile())
	 */
	def profile: Option[UMLProfile[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedStereotype_owningPackage: Option[UMLPackage[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def type_extensionEnd: Set[UMLExtensionEnd[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLStereotype
