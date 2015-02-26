package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ReadLinkObjectEndQualifierAction is an Action that retrieves a qualifier end value from a link object.
 * <!-- end-user-doc --> 
 */
trait UMLReadLinkObjectEndQualifierAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLReadLinkObjectEndQualifierActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		readLinkObjectEndQualifierAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReadLinkObjectEndQualifierAction
	 */
	def readLinkObjectEndQualifierAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		readLinkObjectEndQualifierAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReadLinkObjectEndQualifierAction
	 */
	def readLinkObjectEndQualifierAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLReadLinkObjectEndQualifierAction[Uml], UMLInputPin[Uml]]("object", _._object),
		  	MetaPropertyReference[Uml, UMLReadLinkObjectEndQualifierAction[Uml], UMLOutputPin[Uml]]("result", _.result)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		readLinkObjectEndQualifierAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReadLinkObjectEndQualifierAction
	 */
	def readLinkObjectEndQualifierAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLReadLinkObjectEndQualifierAction[Uml], UMLProperty[Uml]]("qualifier", _.qualifier)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		readLinkObjectEndQualifierAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReadLinkObjectEndQualifierAction
	 */
	def readLinkObjectEndQualifierAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		qualifier 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin from which the link object is obtained.
	 * <!-- end-user-doc -->
	 */
	def _object: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The qualifier Property to be read.
	 * <!-- end-user-doc -->
	 */
	def qualifier: Option[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin where the result value is placed.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLReadLinkObjectEndQualifierAction
