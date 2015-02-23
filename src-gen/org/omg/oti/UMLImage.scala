package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * Physical definition of a graphical image.
 * <!-- end-user-doc --> 
 */
trait UMLImage[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLImageOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		image_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLImage
	 */
	def image_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq (MetaAttributeStringFunction[UMLImage[Uml]](None, "content", (x) => stringToIterable(x.content, null)),
		  	MetaAttributeStringFunction[UMLImage[Uml]](None, "format", (x) => stringToIterable(x.format, null)),
		  	MetaAttributeStringFunction[UMLImage[Uml]](None, "location", (x) => stringToIterable(x.location, null))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		image_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLImage
	 */
	def image_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		image_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLImage
	 */
	def image_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		image_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLImage
	 */
	def image_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * This contains the serialization of the image according to the format. The value could represent a bitmap, image such as a GIF file, or drawing 'instructions' using a standard such as Scalable Vector Graphic (SVG) (which is XML based).
	 * <!-- end-user-doc -->
	 */
	def content: Option[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * This indicates the format of the content, which is how the string content should be interpreted. The following values are reserved: SVG, GIF, PNG, JPG, WMF, EMF, BMP. In addition the prefix 'MIME: ' is also reserved. This option can be used as an alternative to express the reserved values above, for example "SVG" could instead be expressed as "MIME: image/svg+xml".
	 * <!-- end-user-doc -->
	 */
	def format: Option[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * This contains a location that can be used by a tool to locate the image as an alternative to embedding it in the stereotype.
	 * <!-- end-user-doc -->
	 */
	def location: Option[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def icon_stereotype: Option[UMLStereotype[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLImage
