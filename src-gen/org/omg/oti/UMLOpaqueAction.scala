package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An OpaqueAction is an Action whose functionality is not specified within UML.
 * <!-- end-user-doc --> 
 */
trait UMLOpaqueAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLOpaqueActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		opaqueAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLOpaqueAction
	 */
	def opaqueAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq (MetaAttributeStringFunction[Uml, UMLOpaqueAction[Uml]](None, "body", _.body),
		  	MetaAttributeStringFunction[Uml, UMLOpaqueAction[Uml]](None, "language", _.language)) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		opaqueAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLOpaqueAction
	 */
	def opaqueAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLOpaqueAction[Uml], UMLInputPin[Uml]]("inputValue", _.inputValue),
		  	MetaPropertyCollection[Uml, UMLOpaqueAction[Uml], UMLOutputPin[Uml]]("outputValue", _.outputValue)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		opaqueAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLOpaqueAction
	 */
	def opaqueAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		opaqueAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLOpaqueAction
	 */
	def opaqueAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Provides a textual specification of the functionality of the Action, in one or more languages other than UML.
	 * <!-- end-user-doc -->
	 */
	def body: Seq[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPins providing inputs to the OpaqueAction.
	 * <!-- end-user-doc -->
	 */
	def inputValue: Set[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * If provided, a specification of the language used for each of the body Strings.
	 * <!-- end-user-doc -->
	 */
	def language: Seq[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPins on which the OpaqueAction provides outputs.
	 * <!-- end-user-doc -->
	 */
	def outputValue: Set[UMLOutputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLOpaqueAction
