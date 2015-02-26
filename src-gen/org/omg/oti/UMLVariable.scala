package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Variable is a ConnectableElement that may store values during the execution of an Activity. Reading and writing the values of a Variable provides an alternative means for passing data than the use of ObjectFlows. A Variable may be owned directly by an Activity, in which case it is accessible from anywhere within that activity, or it may be owned by a StructuredActivityNode, in which case it is only accessible within that node.
 * <!-- end-user-doc --> 
 */
trait UMLVariable[Uml <: UML]
  extends UMLConnectableElement[Uml] with UMLMultiplicityElement[Uml] with operations.UMLVariableOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		variable_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLVariable
	 */
	def variable_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		connectableElement_metaAttributes,
		multiplicityElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		variable_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLVariable
	 */
	def variable_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		connectableElement_compositeMetaProperties,
		multiplicityElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		variable_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLVariable
	 */
	def variable_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		connectableElement_referenceMetaProperties,
		multiplicityElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLVariable[Uml], UMLActivity[Uml]]("activityScope", _.activityScope),
		  	MetaPropertyReference[Uml, UMLVariable[Uml], UMLStructuredActivityNode[Uml]]("scope", _.scope)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		variable_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLVariable
	 */
	def variable_forwardReferencesFromMetamodelAssociations: Elements =
		connectableElement_forwardReferencesFromMetamodelAssociations ++
		multiplicityElement_forwardReferencesFromMetamodelAssociations ++
		activityScope ++
		scope 

	/**
	 * <!-- begin-user-doc --> 
	 * An Activity that owns the Variable.
	 * <!-- end-user-doc -->
	 */
	def activityScope: Option[UMLActivity[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A StructuredActivityNode that owns the Variable.
	 * <!-- end-user-doc -->
	 */
	def scope: Option[UMLStructuredActivityNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def variable_variableAction: Set[UMLVariableAction[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLVariable
