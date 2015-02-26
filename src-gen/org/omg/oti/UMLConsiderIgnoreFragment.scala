package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ConsiderIgnoreFragment is a kind of CombinedFragment that is used for the consider and ignore cases, which require lists of pertinent Messages to be specified.
 * <!-- end-user-doc --> 
 */
trait UMLConsiderIgnoreFragment[Uml <: UML]
  extends UMLCombinedFragment[Uml] with operations.UMLConsiderIgnoreFragmentOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		considerIgnoreFragment_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConsiderIgnoreFragment
	 */
	def considerIgnoreFragment_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		combinedFragment_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		considerIgnoreFragment_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConsiderIgnoreFragment
	 */
	def considerIgnoreFragment_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		combinedFragment_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		considerIgnoreFragment_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConsiderIgnoreFragment
	 */
	def considerIgnoreFragment_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		combinedFragment_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLConsiderIgnoreFragment[Uml], UMLNamedElement[Uml]]("message", _.message)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		considerIgnoreFragment_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConsiderIgnoreFragment
	 */
	def considerIgnoreFragment_forwardReferencesFromMetamodelAssociations: Elements =
		combinedFragment_forwardReferencesFromMetamodelAssociations ++
		message 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of messages that apply to this fragment.
	 * <!-- end-user-doc -->
	 */
	def message: Set[UMLNamedElement[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLConsiderIgnoreFragment
