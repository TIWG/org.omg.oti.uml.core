package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A relationship from an extending UseCase to an extended UseCase that specifies how and when the behavior defined in the extending UseCase can be inserted into the behavior defined in the extended UseCase.
 * <!-- end-user-doc --> 
 */
trait UMLExtend[Uml <: UML]
  extends UMLNamedElement[Uml] with UMLDirectedRelationship[Uml] with operations.UMLExtendOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		extend_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExtend
	 */
	def extend_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		directedRelationship_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		extend_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExtend
	 */
	def extend_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		directedRelationship_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLExtend[Uml], UMLConstraint[Uml]]("condition", _.condition)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		extend_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExtend
	 */
	def extend_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		directedRelationship_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLExtend[Uml], UMLUseCase[Uml]]("extendedCase", _.extendedCase),
		  	MetaPropertyReference[Uml, UMLExtend[Uml], UMLUseCase[Uml]]("extension", _.extension),
		  	MetaPropertyCollection[Uml, UMLExtend[Uml], UMLExtensionPoint[Uml]]("extensionLocation", _.extensionLocation)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		extend_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExtend
	 */
	def extend_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		extendedCase ++
		extension ++
		extensionLocation 

	/**
	 * <!-- begin-user-doc --> 
	 * References the condition that must hold when the first ExtensionPoint is reached for the extension to take place. If no constraint is associated with the Extend relationship, the extension is unconditional.
	 * <!-- end-user-doc -->
	 */
	def condition: Option[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The UseCase that is being extended.
	 * <!-- end-user-doc -->
	 */
	def extendedCase: Option[UMLUseCase[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The UseCase that represents the extension and owns the Extend relationship.
	 * <!-- end-user-doc -->
	 */
	def extension: Option[UMLUseCase[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An ordered list of ExtensionPoints belonging to the extended UseCase, specifying where the respective behavioral fragments of the extending UseCase are to be inserted. The first fragment in the extending UseCase is associated with the first extension point in the list, the second fragment with the second point, and so on. Note that, in most practical cases, the extending UseCase has just a single behavior fragment, so that the list of ExtensionPoints is trivial.
	 * <!-- end-user-doc -->
	 */
	def extensionLocation: Seq[UMLExtensionPoint[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLExtend
