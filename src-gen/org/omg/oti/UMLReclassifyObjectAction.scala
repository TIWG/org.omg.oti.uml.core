package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A ReclassifyObjectAction is an Action that changes the Classifiers that classify an object.
 * <!-- end-user-doc --> 
 */
trait UMLReclassifyObjectAction[Uml <: UML]
  extends UMLAction[Uml] with operations.UMLReclassifyObjectActionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		reclassifyObjectAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReclassifyObjectAction
	 */
	def reclassifyObjectAction_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		action_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLReclassifyObjectAction[Uml]](None, "isReplaceAll", (x) => booleanToIterable(x.isReplaceAll, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		reclassifyObjectAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReclassifyObjectAction
	 */
	def reclassifyObjectAction_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLReclassifyObjectAction[Uml], UMLInputPin[Uml]]("object", _._object)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		reclassifyObjectAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReclassifyObjectAction
	 */
	def reclassifyObjectAction_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		action_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLReclassifyObjectAction[Uml], UMLClassifier[Uml]]("newClassifier", _.newClassifier),
		  	MetaPropertyCollection[UMLReclassifyObjectAction[Uml], UMLClassifier[Uml]]("oldClassifier", _.oldClassifier)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		reclassifyObjectAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReclassifyObjectAction
	 */
	def reclassifyObjectAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		newClassifier ++
		oldClassifier 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether existing Classifiers should be removed before adding the new Classifiers.
	 * <!-- end-user-doc -->
	 */
	def isReplaceAll: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * A set of Classifiers to be added to the Classifiers of the given object.
	 * <!-- end-user-doc -->
	 */
	def newClassifier: Set[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The InputPin that holds the object to be reclassified.
	 * <!-- end-user-doc -->
	 */
	def _object: Option[UMLInputPin[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A set of Classifiers to be removed from the Classifiers of the given object.
	 * <!-- end-user-doc -->
	 */
	def oldClassifier: Set[UMLClassifier[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLReclassifyObjectAction
