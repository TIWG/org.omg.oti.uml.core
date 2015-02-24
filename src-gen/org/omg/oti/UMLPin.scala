package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Pin is an ObjectNode and MultiplicityElement that provides input values to an Action or accepts output values from an Action.
 * <!-- end-user-doc --> 
 */
trait UMLPin[Uml <: UML]
  extends UMLObjectNode[Uml] with UMLMultiplicityElement[Uml] with operations.UMLPinOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		pin_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPin
	 */
	def pin_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		objectNode_metaAttributes,
		multiplicityElement_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLPin[Uml]](None, "isControl", (x) => booleanToIterable(x.isControl, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		pin_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPin
	 */
	def pin_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		objectNode_compositeMetaProperties,
		multiplicityElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		pin_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPin
	 */
	def pin_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		objectNode_referenceMetaProperties,
		multiplicityElement_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		pin_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPin
	 */
	def pin_forwardReferencesFromMetamodelAssociations: Elements =
		objectNode_forwardReferencesFromMetamodelAssociations ++
		multiplicityElement_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether the Pin provides data to the Action or just controls how the Action executes.
	 * <!-- end-user-doc -->
	 */
	def isControl: Boolean

// Start of user code for additional featuers
// End of user code

} //UMLPin
