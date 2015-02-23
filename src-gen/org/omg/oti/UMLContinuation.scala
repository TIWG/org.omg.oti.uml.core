package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Continuation is a syntactic way to define continuations of different branches of an alternative CombinedFragment. Continuations are intuitively similar to labels representing intermediate points in a flow of control.
 * <!-- end-user-doc --> 
 */
trait UMLContinuation[Uml <: UML]
  extends UMLInteractionFragment[Uml] with operations.UMLContinuationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		continuation_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLContinuation
	 */
	def continuation_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		interactionFragment_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLContinuation[Uml]](None, "setting", (x) => booleanToIterable(x.setting, true))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		continuation_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLContinuation
	 */
	def continuation_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		continuation_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLContinuation
	 */
	def continuation_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		interactionFragment_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		continuation_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLContinuation
	 */
	def continuation_forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * True: when the Continuation is at the end of the enclosing InteractionFragment and False when it is in the beginning.
	 * <!-- end-user-doc -->
	 */
	def setting: Boolean = true

// Start of user code for additional featuers
// End of user code

} //UMLContinuation
