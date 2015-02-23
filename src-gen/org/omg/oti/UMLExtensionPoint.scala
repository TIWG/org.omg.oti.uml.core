package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ExtensionPoint identifies a point in the behavior of a UseCase where that behavior can be extended by the behavior of some other (extending) UseCase, as specified by an Extend relationship.
 * <!-- end-user-doc --> 
 */
trait UMLExtensionPoint[Uml <: UML]
  extends UMLRedefinableElement[Uml] with operations.UMLExtensionPointOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		extensionPoint_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExtensionPoint
	 */
	def extensionPoint_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		redefinableElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		extensionPoint_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExtensionPoint
	 */
	def extensionPoint_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		extensionPoint_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExtensionPoint
	 */
	def extensionPoint_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		redefinableElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLExtensionPoint[Uml], UMLUseCase[Uml]]("useCase", _.useCase)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		extensionPoint_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExtensionPoint
	 */
	def extensionPoint_forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		useCase 

	/**
	 * <!-- begin-user-doc --> 
	 * The UseCase that owns this ExtensionPoint.
	 * <!-- end-user-doc -->
	 */
	def useCase: Option[UMLUseCase[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def extensionLocation_extension: Set[UMLExtend[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLExtensionPoint
