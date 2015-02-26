package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A RemoveVariableValueAction is a WriteVariableAction that removes values from a Variables.
 * <!-- end-user-doc --> 
 */
trait UMLRemoveVariableValueAction[Uml <: UML]
  extends UMLWriteVariableAction[Uml] with operations.UMLRemoveVariableValueActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		removeVariableValueAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLRemoveVariableValueAction
	 */
	def removeVariableValueAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		writeVariableAction_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLRemoveVariableValueAction[Uml]](None, "isRemoveDuplicates", (x) => booleanToIterable(x.isRemoveDuplicates, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		removeVariableValueAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLRemoveVariableValueAction
	 */
	def removeVariableValueAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		writeVariableAction_compositeMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLRemoveVariableValueAction[Uml], UMLInputPin[Uml]]("removeAt", _.removeAt)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		removeVariableValueAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLRemoveVariableValueAction
	 */
	def removeVariableValueAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		writeVariableAction_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		removeVariableValueAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLRemoveVariableValueAction
	 */
	def removeVariableValueAction_forwardReferencesFromMetamodelAssociations: Elements =
		writeVariableAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether to remove duplicates of the value in nonunique Variables.
	 * <!-- end-user-doc -->
	 */
	def isRemoveDuplicates: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * An InputPin that provides the position of an existing value to remove in ordered, nonunique Variables. The type of the removeAt InputPin is UnlimitedNatural, but the value cannot be zero or unlimited.
	 * <!-- end-user-doc -->
	 */
	def removeAt: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLRemoveVariableValueAction
