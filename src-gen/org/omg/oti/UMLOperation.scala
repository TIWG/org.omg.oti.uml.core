package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An Operation is a BehavioralFeature of a Classifier that specifies the name, type, parameters, and constraints for invoking an associated Behavior. An Operation may invoke both the execution of method behaviors as well as other behavioral responses. Operation specializes TemplateableElement in order to support specification of template operations and bound operations. Operation specializes ParameterableElement to specify that an operation can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 * <!-- end-user-doc --> 
 */
trait UMLOperation[Uml <: UML]
  extends UMLParameterableElement[Uml] with UMLTemplateableElement[Uml] with UMLBehavioralFeature[Uml] with operations.UMLOperationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		operation_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLOperation
	 */
	def operation_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		parameterableElement_metaAttributes,
		templateableElement_metaAttributes,
		behavioralFeature_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLOperation[Uml]](None, "isQuery", (x) => booleanToIterable(x.isQuery, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		operation_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLOperation
	 */
	def operation_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		parameterableElement_compositeMetaProperties,
		templateableElement_compositeMetaProperties,
		behavioralFeature_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLOperation[Uml], UMLConstraint[Uml]]("bodyCondition", _.bodyCondition),
		  	MetaPropertyCollection[Uml, UMLOperation[Uml], UMLParameter[Uml]]("ownedParameter", _.ownedParameter),
		  	MetaPropertyCollection[Uml, UMLOperation[Uml], UMLConstraint[Uml]]("postcondition", _.postcondition),
		  	MetaPropertyCollection[Uml, UMLOperation[Uml], UMLConstraint[Uml]]("precondition", _.precondition)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		operation_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLOperation
	 */
	def operation_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		parameterableElement_referenceMetaProperties,
		templateableElement_referenceMetaProperties,
		behavioralFeature_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLOperation[Uml], UMLClass[Uml]]("class", _._class),
		  	MetaPropertyReference[Uml, UMLOperation[Uml], UMLDataType[Uml]]("datatype", _.datatype),
		  	MetaPropertyReference[Uml, UMLOperation[Uml], UMLInterface[Uml]]("interface", _.interface),
		  	MetaPropertyCollection[Uml, UMLOperation[Uml], UMLType[Uml]]("raisedException", _.raisedException),
		  	MetaPropertyCollection[Uml, UMLOperation[Uml], UMLOperation[Uml]]("redefinedOperation", _.redefinedOperation),
		  	MetaPropertyReference[Uml, UMLOperation[Uml], UMLOperationTemplateParameter[Uml]]("templateParameter", _.operation_templateParameter)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		operation_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLOperation
	 */
	def operation_forwardReferencesFromMetamodelAssociations: Elements =
		parameterableElement_forwardReferencesFromMetamodelAssociations ++
		templateableElement_forwardReferencesFromMetamodelAssociations ++
		behavioralFeature_forwardReferencesFromMetamodelAssociations ++
		_class ++
		datatype ++
		interface ++
		raisedException ++
		redefinedOperation ++
		templateParameter 

	/**
	 * <!-- begin-user-doc --> 
	 * An optional Constraint on the result values of an invocation of this Operation.
	 * <!-- end-user-doc -->
	 */
	def bodyCondition: Option[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Class that owns this operation, if any.
	 * <!-- end-user-doc -->
	 */
	def _class: Option[UMLClass[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The DataType that owns this Operation, if any.
	 * <!-- end-user-doc -->
	 */
	def datatype: Option[UMLDataType[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Interface that owns this Operation, if any.
	 * <!-- end-user-doc -->
	 */
	def interface: Option[UMLInterface[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether the return parameter is ordered or not, if present.  This information is derived from the return result for this Operation.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if returnResult()->notEmpty() then returnResult()-> exists(isOrdered) else false endif)
	 */
	def isOrdered: Boolean 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether an execution of the BehavioralFeature leaves the state of the system unchanged (isQuery=true) or whether side effects may occur (isQuery=false).
	 * <!-- end-user-doc -->
	 */
	def isQuery: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether the return parameter is unique or not, if present. This information is derived from the return result for this Operation.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if returnResult()->notEmpty() then returnResult()->exists(isUnique) else true endif)
	 */
	def isUnique: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the lower multiplicity of the return parameter, if present. This information is derived from the return result for this Operation.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if returnResult()->notEmpty() then returnResult()->any(true).lower else null endif)
	 */
	def lower: Integer 

	/**
	 * <!-- begin-user-doc --> 
	 * The parameters owned by this Operation.
	 * <!-- end-user-doc -->
	 */
	override def ownedParameter: Seq[UMLParameter[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An optional set of Constraints specifying the state of the system when the Operation is completed.
	 * <!-- end-user-doc -->
	 */
	def postcondition: Set[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An optional set of Constraints on the state of the system when the Operation is invoked.
	 * <!-- end-user-doc -->
	 */
	def precondition: Set[UMLConstraint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Types representing exceptions that may be raised during an invocation of this operation.
	 * <!-- end-user-doc -->
	 */
	override def raisedException: Set[UMLType[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Operations that are redefined by this Operation.
	 * <!-- end-user-doc -->
	 */
	def redefinedOperation: Set[UMLOperation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The OperationTemplateParameter that exposes this element as a formal parameter.
	 * <!-- end-user-doc -->
	 */
	override def templateParameter: Option[UMLTemplateParameter[Uml]] 
  
  def operation_templateParameter: Option[UMLOperationTemplateParameter[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The return type of the operation, if present. This information is derived from the return result for this Operation.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if returnResult()->notEmpty() then returnResult()->any(true).type else null endif)
	 */
	def _type: Option[UMLType[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The upper multiplicity of the return parameter, if present. This information is derived from the return result for this Operation.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if returnResult()->notEmpty() then returnResult()->any(true).upper else null endif)
	 */
	def upper: Integer

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def operation_callOperationAction: Set[UMLCallOperationAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def referred_protocolTransition: Set[UMLProtocolTransition[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedOperation_artifact: Option[UMLArtifact[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinedOperation_operation: Set[UMLOperation[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def operation_callEvent: Set[UMLCallEvent[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLOperation
