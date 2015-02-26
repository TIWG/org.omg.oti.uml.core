package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An AddVariableValueAction is a WriteVariableAction for adding values to a Variable.
 * <!-- end-user-doc --> 
 */
trait UMLAddVariableValueAction[Uml <: UML]
  extends UMLWriteVariableAction[Uml] with operations.UMLAddVariableValueActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		addVariableValueAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAddVariableValueAction
	 */
	def addVariableValueAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		writeVariableAction_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLAddVariableValueAction[Uml]](None, "isReplaceAll", (x) => booleanToIterable(x.isReplaceAll, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		addVariableValueAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAddVariableValueAction
	 */
	def addVariableValueAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		writeVariableAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLAddVariableValueAction[Uml], UMLInputPin[Uml]]("insertAt", _.insertAt)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		addVariableValueAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAddVariableValueAction
	 */
	def addVariableValueAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		writeVariableAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		addVariableValueAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAddVariableValueAction
	 */
	def addVariableValueAction_forwardReferencesFromMetamodelAssociations: Elements =
		writeVariableAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that gives the position at which to insert a new value or move an existing value in ordered Variables. The type of the insertAt InputPin is UnlimitedNatural, but the value cannot be zero. It is omitted for unordered Variables.
	 * <!-- end-user-doc -->
	 */
	def insertAt: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether existing values of the Variable should be removed before adding the new value.
	 * <!-- end-user-doc -->
	 */
	def isReplaceAll: Boolean

// Start of user code for additional featuers
// End of user code

} //UMLAddVariableValueAction
