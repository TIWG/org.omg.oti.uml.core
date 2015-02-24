package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Parameter is a specification of an argument used to pass information into or out of an invocation of a BehavioralFeature.  Parameters can be treated as ConnectableElements within Collaborations.
 * <!-- end-user-doc --> 
 */
trait UMLParameter[Uml <: UML]
  extends UMLConnectableElement[Uml] with UMLMultiplicityElement[Uml] with operations.UMLParameterOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		parameter_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLParameter
	 */
	def parameter_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		connectableElement_metaAttributes,
		multiplicityElement_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLParameter[Uml]](None, "isException", (x) => booleanToIterable(x.isException, false)),
		  	MetaAttributeBooleanFunction[UMLParameter[Uml]](None, "isStream", (x) => booleanToIterable(x.isStream, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		parameter_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLParameter
	 */
	def parameter_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		connectableElement_compositeMetaProperties,
		multiplicityElement_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLParameter[Uml], UMLValueSpecification[Uml]]("defaultValue", _.defaultValue)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		parameter_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLParameter
	 */
	def parameter_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		connectableElement_referenceMetaProperties,
		multiplicityElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLParameter[Uml], UMLOperation[Uml]]("operation", _.operation),
		  	MetaPropertyCollection[UMLParameter[Uml], UMLParameterSet[Uml]]("parameterSet", _.parameterSet)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		parameter_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLParameter
	 */
	def parameter_forwardReferencesFromMetamodelAssociations: Elements =
		connectableElement_forwardReferencesFromMetamodelAssociations ++
		multiplicityElement_forwardReferencesFromMetamodelAssociations ++
		operation ++
		parameterSet 

	/**
	 * <!-- begin-user-doc --> 
	 * A String that represents a value to be used when no argument is supplied for the Parameter.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if self.type = String then defaultValue.stringValue() else null endif)
	 */
	def default: Option[String]

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies a ValueSpecification that represents a value to be used when no argument is supplied for the Parameter.
	 * <!-- end-user-doc -->
	 */
	def defaultValue: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether a parameter is being sent into or out of a behavioral element.
	 * <!-- end-user-doc -->
	 */
	def direction: UMLParameterDirectionKind.Value

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the effect that executions of the owner of the Parameter have on objects passed in or out of the parameter.
	 * <!-- end-user-doc -->
	 */
	def effect: UMLParameterEffectKind.Value 

	/**
	 * <!-- begin-user-doc --> 
	 * Tells whether an output parameter may emit a value to the exclusion of the other outputs.
	 * <!-- end-user-doc -->
	 */
	def isException: Boolean
  
	/**
	 * <!-- begin-user-doc --> 
	 * Tells whether an input parameter may accept values while its behavior is executing, or whether an output parameter may post values while the behavior is executing.
	 * <!-- end-user-doc -->
	 */
	def isStream: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * The Operation owning this parameter.
	 * <!-- end-user-doc -->
	 */
	def operation: Option[UMLOperation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ParameterSets containing the parameter. See ParameterSet.
	 * <!-- end-user-doc -->
	 */
	def parameterSet: Set[UMLParameterSet[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedParameter_ownerFormalParam: Option[UMLBehavioralFeature[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def parameter_activityParameterNode: Set[UMLActivityParameterNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedParameter_behavior: Option[UMLBehavior[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def result_opaqueExpression: Set[UMLOpaqueExpression[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLParameter
