package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * LinkEndData is an Element that identifies on end of a link to be read or written by a LinkAction. As a link (that is not a link object) cannot be passed as a runtime value to or from an Action, it is instead identified by its end objects and qualifier values, if any. A LinkEndData instance provides these values for a single Association end.
 * <!-- end-user-doc --> 
 */
trait UMLLinkEndData[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLLinkEndDataOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		linkEndData_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLinkEndData
	 */
	def linkEndData_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		linkEndData_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLinkEndData
	 */
	def linkEndData_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLLinkEndData[Uml], UMLQualifierValue[Uml]]("qualifier", _.qualifier)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		linkEndData_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLinkEndData
	 */
	def linkEndData_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLLinkEndData[Uml], UMLProperty[Uml]]("end", _.end),
		  	MetaPropertyReference[Uml, UMLLinkEndData[Uml], UMLInputPin[Uml]]("value", _.value)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		linkEndData_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLinkEndData
	 */
	def linkEndData_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		end ++
		value 

	/**
	 * <!-- begin-user-doc --> 
	 * The Association?end?for?which?this?LinkEndData?specifies?values.
	 * <!-- end-user-doc -->
	 */
	def end: Option[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A set of QualifierValues used to provide values for the qualifiers of the end.
	 * <!-- end-user-doc -->
	 */
	def qualifier: Set[UMLQualifierValue[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that provides the specified value for the given end. This InputPin is omitted if the LinkEndData specifies the "open" end for a ReadLinkAction.
	 * <!-- end-user-doc -->
	 */
	def value: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def endData_linkAction: Option[UMLLinkAction[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLLinkEndData
