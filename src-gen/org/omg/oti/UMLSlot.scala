package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Slot designates that an entity modeled by an InstanceSpecification has a value or values for a specific StructuralFeature.
 * <!-- end-user-doc --> 
 */
trait UMLSlot[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLSlotOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		slot_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLSlot
	 */
	def slot_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		slot_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLSlot
	 */
	def slot_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLSlot[Uml], UMLValueSpecification[Uml]]("value", _.value)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		slot_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLSlot
	 */
	def slot_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLSlot[Uml], UMLStructuralFeature[Uml]]("definingFeature", _.definingFeature),
		  	MetaPropertyReference[Uml, UMLSlot[Uml], UMLInstanceSpecification[Uml]]("owningInstance", _.owningInstance)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		slot_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLSlot
	 */
	def slot_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		definingFeature ++
		owningInstance 

	/**
	 * <!-- begin-user-doc --> 
	 * The StructuralFeature that specifies the values that may be held by the Slot.
	 * <!-- end-user-doc -->
	 */
	def definingFeature: Option[UMLStructuralFeature[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The InstanceSpecification that owns this Slot.
	 * <!-- end-user-doc -->
	 */
	def owningInstance: Option[UMLInstanceSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The value or values held by the Slot.
	 * <!-- end-user-doc -->
	 */
	def value: Seq[UMLValueSpecification[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLSlot
