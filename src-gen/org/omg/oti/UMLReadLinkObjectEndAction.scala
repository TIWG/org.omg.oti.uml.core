package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ReadLinkObjectEndAction is an Action that retrieves an end object from a link object.
 * <!-- end-user-doc --> 
 */
trait UMLReadLinkObjectEndAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLReadLinkObjectEndActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		readLinkObjectEndAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReadLinkObjectEndAction
	 */
	def readLinkObjectEndAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		readLinkObjectEndAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReadLinkObjectEndAction
	 */
	def readLinkObjectEndAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLReadLinkObjectEndAction[Uml], UMLInputPin[Uml]]("object", _._object),
		  	MetaPropertyReference[UMLReadLinkObjectEndAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		readLinkObjectEndAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReadLinkObjectEndAction
	 */
	def readLinkObjectEndAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLReadLinkObjectEndAction[Uml], UMLProperty[Uml]]("end", _.end)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		readLinkObjectEndAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReadLinkObjectEndAction
	 */
	def readLinkObjectEndAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		end 

	/**
	 * <!-- begin-user-doc --> 
	 * The Association end to be read.
	 * <!-- end-user-doc -->
	 */
	def end: Option[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The input pin from which the link object is obtained.
	 * <!-- end-user-doc -->
	 */
	def _object: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin where the result value is placed.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLReadLinkObjectEndAction
