package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * LinkEndCreationData is LinkEndData used to provide values for one end of a link to be created by a CreateLinkAction.
 * <!-- end-user-doc --> 
 */
trait UMLLinkEndCreationData[Uml <: UML]
  extends UMLLinkEndData[Uml] with operations.UMLLinkEndCreationDataOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		linkEndCreationData_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLinkEndCreationData
	 */
	def linkEndCreationData_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		linkEndData_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLLinkEndCreationData[Uml]](None, "isReplaceAll", (x) => booleanToIterable(x.isReplaceAll, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		linkEndCreationData_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLinkEndCreationData
	 */
	def linkEndCreationData_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		linkEndData_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		linkEndCreationData_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLinkEndCreationData
	 */
	def linkEndCreationData_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		linkEndData_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLLinkEndCreationData[Uml], UMLInputPin[Uml]]("insertAt", _.insertAt)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		linkEndCreationData_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLinkEndCreationData
	 */
	def linkEndCreationData_forwardReferencesFromMetamodelAssociations: Elements =
		linkEndData_forwardReferencesFromMetamodelAssociations ++
		insertAt 

	/**
	 * <!-- begin-user-doc --> 
	 * For ordered Association ends, the InputPin that provides the position where the new link should be inserted or where an existing link should be moved to. The type of the insertAt InputPin is UnlimitedNatural, but the input cannot be zero. It is omitted for Association ends that are not ordered.
	 * <!-- end-user-doc -->
	 */
	def insertAt: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether the existing links emanating from the object on this end should be destroyed before creating a new link.
	 * <!-- end-user-doc -->
	 */
	def isReplaceAll: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def endData_createLinkAction: Option[UMLCreateLinkAction[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLLinkEndCreationData
