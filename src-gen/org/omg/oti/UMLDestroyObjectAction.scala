package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A DestroyObjectAction is an Action that destroys objects.
 * <!-- end-user-doc --> 
 */
trait UMLDestroyObjectAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLDestroyObjectActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		destroyObjectAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDestroyObjectAction
	 */
	def destroyObjectAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLDestroyObjectAction[Uml]](None, "isDestroyLinks", (x) => booleanToIterable(x.isDestroyLinks, false)),
		  	MetaAttributeBooleanFunction[UMLDestroyObjectAction[Uml]](None, "isDestroyOwnedObjects", (x) => booleanToIterable(x.isDestroyOwnedObjects, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		destroyObjectAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDestroyObjectAction
	 */
	def destroyObjectAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLDestroyObjectAction[Uml], UMLInputPin[Uml]]("target", _.target)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		destroyObjectAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDestroyObjectAction
	 */
	def destroyObjectAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		destroyObjectAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDestroyObjectAction
	 */
	def destroyObjectAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether links in which the object participates are destroyed along with the object.
	 * <!-- end-user-doc -->
	 */
	def isDestroyLinks: Boolean 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether objects owned by the object (via composition) are destroyed along with the object.
	 * <!-- end-user-doc -->
	 */
	def isDestroyOwnedObjects: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin providing the object to be destroyed.
	 * <!-- end-user-doc -->
	 */
	def target: Option[UMLInputPin[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLDestroyObjectAction
