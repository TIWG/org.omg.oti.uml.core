package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A TestIdentityAction is an Action that tests if two values are identical objects.
 * <!-- end-user-doc --> 
 */
trait UMLTestIdentityAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLTestIdentityActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		testIdentityAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTestIdentityAction
	 */
	def testIdentityAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		testIdentityAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTestIdentityAction
	 */
	def testIdentityAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLTestIdentityAction[Uml], UMLInputPin[Uml]]("first", _.first),
		  	MetaPropertyReference[Uml, UMLTestIdentityAction[Uml], UMLOutputPin[Uml]]("result", _.result),
		  	MetaPropertyReference[Uml, UMLTestIdentityAction[Uml], UMLInputPin[Uml]]("second", _.second)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		testIdentityAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTestIdentityAction
	 */
	def testIdentityAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		testIdentityAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTestIdentityAction
	 */
	def testIdentityAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin on which the first input object is placed.
	 * <!-- end-user-doc -->
	 */
	def first: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin whose Boolean value indicates whether the two input objects are identical.
	 * <!-- end-user-doc -->
	 */
	def result: Option[UMLOutputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OutputPin on which the second input object is placed.
	 * <!-- end-user-doc -->
	 */
	def second: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLTestIdentityAction
