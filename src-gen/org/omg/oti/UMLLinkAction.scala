package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * LinkAction is an abstract class for all Actions that identify the links to be acted on using LinkEndData.
 * <!-- end-user-doc --> 
 */
trait UMLLinkAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLLinkActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		linkAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLinkAction
	 */
	def linkAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		linkAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLinkAction
	 */
	def linkAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLLinkAction[Uml], UMLLinkEndData[Uml]]("endData", _.endData),
		  	MetaPropertyCollection[UMLLinkAction[Uml], UMLInputPin[Uml]]("inputValue", _.inputValue)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		linkAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLinkAction
	 */
	def linkAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		linkAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLinkAction
	 */
	def linkAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The LinkEndData identifying the values on the ends of the links acting on by this LinkAction.
	 * <!-- end-user-doc -->
	 */
	def endData: Iterable[UMLLinkEndData[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * InputPins used by the LinkEndData of the LinkAction.
	 * <!-- end-user-doc -->
	 */
	def inputValue: Set[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLLinkAction
