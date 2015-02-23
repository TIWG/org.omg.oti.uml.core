package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A CollaborationUse is used to specify the application of a pattern specified by a Collaboration to a specific situation.
 * <!-- end-user-doc --> 
 */
trait UMLCollaborationUse[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLCollaborationUseOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		collaborationUse_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCollaborationUse
	 */
	def collaborationUse_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		collaborationUse_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCollaborationUse
	 */
	def collaborationUse_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLCollaborationUse[Uml], UMLDependency[Uml]]("roleBinding", _.roleBinding)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		collaborationUse_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCollaborationUse
	 */
	def collaborationUse_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLCollaborationUse[Uml], UMLCollaboration[Uml]]("type", _._type)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		collaborationUse_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCollaborationUse
	 */
	def collaborationUse_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		_type 

	/**
	 * <!-- begin-user-doc --> 
	 * A mapping between features of the Collaboration and features of the owning Classifier. This mapping indicates which ConnectableElement of the Classifier plays which role(s) in the Collaboration. A ConnectableElement may be bound to multiple roles in the same CollaborationUse (that is, it may play multiple roles).
	 * <!-- end-user-doc -->
	 */
	def roleBinding: Set[UMLDependency[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Collaboration which is used in this CollaborationUse. The Collaboration defines the cooperation between its roles which are mapped to ConnectableElements relating to the Classifier owning the CollaborationUse.
	 * <!-- end-user-doc -->
	 */
	def _type: Option[UMLCollaboration[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def representation_classifier: Option[UMLClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def collaborationUse_classifier: Option[UMLClassifier[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLCollaborationUse
