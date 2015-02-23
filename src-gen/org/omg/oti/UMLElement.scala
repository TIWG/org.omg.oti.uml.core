package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An Element is a constituent of a model. As such, it has the capability of owning other Elements.
 * <!-- end-user-doc --> 
 */
trait UMLElement[Uml <: UML]
 extends operations.UMLElementOps[Uml] {
	
	implicit val ops: operations.UMLOps[Uml]
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	def metaAttributes: MetaAttributeFunctions =
		element_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLElement
	 */
	def element_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	def compositeMetaProperties: MetaPropertyFunctions =
		element_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLElement
	 */
	def element_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		  Seq (MetaPropertyCollection[UMLElement[Uml], UMLComment[Uml]]("ownedComment", _.ownedComment)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	def referenceMetaProperties: MetaPropertyFunctions =
		element_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLElement
	 */
	def element_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	def forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLElement
	 */
	def element_forwardReferencesFromMetamodelAssociations: Elements =
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The Comments owned by this Element.
	 * <!-- end-user-doc -->
	 */
	def ownedComment: Set[UMLComment[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Elements owned by this Element.
	 * <!-- end-user-doc -->
	 */
	def ownedElement: Set[UMLElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Element that owns this Element.
	 * <!-- end-user-doc -->
	 */
	def owner: Option[UMLElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def constrainedElement_constraint: Set[UMLConstraint[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def annotatedElement_comment: Set[UMLComment[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def represents_activityPartition: Set[UMLActivityPartition[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def relatedElement_relationship: Set[UMLRelationship[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def target_directedRelationship: Set[UMLDirectedRelationship[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def source_directedRelationship: Set[UMLDirectedRelationship[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLElement
