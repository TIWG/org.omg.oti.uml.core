package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ParameterSet designates alternative sets of inputs or outputs that a Behavior may use.
 * <!-- end-user-doc --> 
 */
trait UMLParameterSet[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLParameterSetOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		parameterSet_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLParameterSet
	 */
	def parameterSet_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		parameterSet_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLParameterSet
	 */
	def parameterSet_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLParameterSet[Uml], UMLConstraint[Uml]]("condition", _.condition)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		parameterSet_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLParameterSet
	 */
	def parameterSet_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLParameterSet[Uml], UMLParameter[Uml]]("parameter", _.parameter)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		parameterSet_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLParameterSet
	 */
	def parameterSet_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		parameter 

	/**
	 * <!-- begin-user-doc --> 
	 * A constraint that should be satisfied for the owner of the Parameters in an input ParameterSet to start execution using the values provided for those Parameters, or the owner of the Parameters in an output ParameterSet to end execution providing the values for those Parameters, if all preconditions and conditions on input ParameterSets were satisfied.
	 * <!-- end-user-doc -->
	 */
	def condition: Set[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Parameters in the ParameterSet.
	 * <!-- end-user-doc -->
	 */
	def parameter: Set[UMLParameter[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedParameterSet_behavior: Option[UMLBehavior[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedParameterSet_behavioralFeature: Option[UMLBehavioralFeature[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLParameterSet
