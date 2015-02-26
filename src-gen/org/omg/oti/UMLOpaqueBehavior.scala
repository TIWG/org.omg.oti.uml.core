package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An OpaqueBehavior is a Behavior whose specification is given in a textual language other than UML.
 * <!-- end-user-doc --> 
 */
trait UMLOpaqueBehavior[Uml <: UML]
  extends UMLBehavior[Uml] with operations.UMLOpaqueBehaviorOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		opaqueBehavior_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLOpaqueBehavior
	 */
	def opaqueBehavior_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		behavior_metaAttributes,
		  Seq (MetaAttributeStringFunction[Uml, UMLOpaqueBehavior[Uml]](None, "body", _.body),
		  	MetaAttributeStringFunction[Uml, UMLOpaqueBehavior[Uml]](None, "language", _.language)) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		opaqueBehavior_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLOpaqueBehavior
	 */
	def opaqueBehavior_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		behavior_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		opaqueBehavior_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLOpaqueBehavior
	 */
	def opaqueBehavior_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		behavior_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		opaqueBehavior_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLOpaqueBehavior
	 */
	def opaqueBehavior_forwardReferencesFromMetamodelAssociations: Elements =
		behavior_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the behavior in one or more languages.
	 * <!-- end-user-doc -->
	 */
	def body: Seq[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * Languages the body strings use in the same order as the body strings.
	 * <!-- end-user-doc -->
	 */
	def language: Seq[String] 

// Start of user code for additional featuers
// End of user code

} //UMLOpaqueBehavior
