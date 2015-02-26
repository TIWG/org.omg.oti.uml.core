package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * LinkEndDestructionData is LinkEndData used to provide values for one end of a link to be destroyed by a DestroyLinkAction.
 * <!-- end-user-doc --> 
 */
trait UMLLinkEndDestructionData[Uml <: UML]
  extends UMLLinkEndData[Uml] with operations.UMLLinkEndDestructionDataOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		linkEndDestructionData_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLinkEndDestructionData
	 */
	def linkEndDestructionData_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		linkEndData_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLLinkEndDestructionData[Uml]](None, "isDestroyDuplicates", (x) => booleanToIterable(x.isDestroyDuplicates, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		linkEndDestructionData_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLinkEndDestructionData
	 */
	def linkEndDestructionData_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		linkEndData_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		linkEndDestructionData_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLinkEndDestructionData
	 */
	def linkEndDestructionData_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		linkEndData_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLLinkEndDestructionData[Uml], UMLInputPin[Uml]]("destroyAt", _.destroyAt)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		linkEndDestructionData_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLinkEndDestructionData
	 */
	def linkEndDestructionData_forwardReferencesFromMetamodelAssociations: Elements =
		linkEndData_forwardReferencesFromMetamodelAssociations ++
		destroyAt 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that provides the position of an existing link to be destroyed in an ordered, nonunique Association end. The type of the destroyAt InputPin is UnlimitedNatural, but the value cannot be zero or unlimited.
	 * <!-- end-user-doc -->
	 */
	def destroyAt: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether to destroy duplicates of the value in nonunique Association ends.
	 * <!-- end-user-doc -->
	 */
	def isDestroyDuplicates: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def endData_destroyLinkAction: Option[UMLDestroyLinkAction[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLLinkEndDestructionData
