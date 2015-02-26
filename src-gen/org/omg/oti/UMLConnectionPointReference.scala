package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ConnectionPointReference represents a usage (as part of a submachine State) of an entry/exit point Pseudostate defined in the StateMachine referenced by the submachine State.
 * <!-- end-user-doc --> 
 */
trait UMLConnectionPointReference[Uml <: UML]
  extends UMLVertex[Uml] with operations.UMLConnectionPointReferenceOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		connectionPointReference_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConnectionPointReference
	 */
	def connectionPointReference_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		vertex_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		connectionPointReference_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConnectionPointReference
	 */
	def connectionPointReference_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		vertex_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		connectionPointReference_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConnectionPointReference
	 */
	def connectionPointReference_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		vertex_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLConnectionPointReference[Uml], UMLPseudostate[Uml]]("entry", _.entry),
		  	MetaPropertyCollection[Uml, UMLConnectionPointReference[Uml], UMLPseudostate[Uml]]("exit", _.exit),
		  	MetaPropertyReference[Uml, UMLConnectionPointReference[Uml], UMLState[Uml]]("state", _.state)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		connectionPointReference_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConnectionPointReference
	 */
	def connectionPointReference_forwardReferencesFromMetamodelAssociations: Elements =
		vertex_forwardReferencesFromMetamodelAssociations ++
		entry ++
		exit ++
		state 

	/**
	 * <!-- begin-user-doc --> 
	 * The entryPoint Pseudostates corresponding to this connection point.
	 * <!-- end-user-doc -->
	 */
	def entry: Set[UMLPseudostate[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The exitPoints kind Pseudostates corresponding to this connection point.
	 * <!-- end-user-doc -->
	 */
	def exit: Set[UMLPseudostate[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The State in which the ConnectionPointReference is defined.
	 * <!-- end-user-doc -->
	 */
	def state: Option[UMLState[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLConnectionPointReference
