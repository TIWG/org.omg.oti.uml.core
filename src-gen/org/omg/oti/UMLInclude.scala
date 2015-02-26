package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An Include relationship specifies that a UseCase contains the behavior defined in another UseCase.
 * <!-- end-user-doc --> 
 */
trait UMLInclude[Uml <: UML]
  extends UMLNamedElement[Uml] with UMLDirectedRelationship[Uml] with operations.UMLIncludeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		include_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInclude
	 */
	def include_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		directedRelationship_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		include_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInclude
	 */
	def include_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		directedRelationship_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		include_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInclude
	 */
	def include_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		directedRelationship_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLInclude[Uml], UMLUseCase[Uml]]("addition", _.addition),
		  	MetaPropertyReference[Uml, UMLInclude[Uml], UMLUseCase[Uml]]("includingCase", _.includingCase)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		include_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInclude
	 */
	def include_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		addition ++
		includingCase 

	/**
	 * <!-- begin-user-doc --> 
	 * The UseCase that is to be included.
	 * <!-- end-user-doc -->
	 */
	def addition: Option[UMLUseCase[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The UseCase which includes the addition and owns the Include relationship.
	 * <!-- end-user-doc -->
	 */
	def includingCase: Option[UMLUseCase[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLInclude
