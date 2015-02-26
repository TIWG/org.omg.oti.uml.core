package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A link is a tuple of values that refer to typed objects.  An Association classifies a set of links, each of which is an instance of the Association.  Each value in the link refers to an instance of the type of the corresponding end of the Association.

 * <!-- end-user-doc --> 
 */
trait UMLAssociation[Uml <: UML]
  extends UMLRelationship[Uml] with UMLClassifier[Uml] with operations.UMLAssociationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		association_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAssociation
	 */
	def association_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		relationship_metaAttributes,
		classifier_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLAssociation[Uml]](None, "isDerived", (x) => booleanToIterable(x.isDerived, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		association_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAssociation
	 */
	def association_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		relationship_compositeMetaProperties,
		classifier_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLAssociation[Uml], UMLProperty[Uml]]("ownedEnd", _.ownedEnd)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		association_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAssociation
	 */
	def association_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		relationship_referenceMetaProperties,
		classifier_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLAssociation[Uml], UMLProperty[Uml]]("memberEnd", _.memberEnd),
		  	MetaPropertyCollection[Uml, UMLAssociation[Uml], UMLProperty[Uml]]("navigableOwnedEnd", _.navigableOwnedEnd)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		association_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAssociation
	 */
	def association_forwardReferencesFromMetamodelAssociations: Elements =
		relationship_forwardReferencesFromMetamodelAssociations ++
		classifier_forwardReferencesFromMetamodelAssociations ++
		memberEnd ++
		navigableOwnedEnd 

	/**
	 * <!-- begin-user-doc --> 
	 * The Classifiers that are used as types of the ends of the Association.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (memberEnd->collect(type)->asSet())
	 */
	def endType: Set[UMLType[Uml]] = {
	    // Start of user code for "endType"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether the Association is derived from other model elements such as other Associations.
	 * <!-- end-user-doc -->
	 */
	def isDerived: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * Each end represents participation of instances of the Classifier connected to the end in links of the Association.
	 * <!-- end-user-doc -->
	 */
	def memberEnd: Seq[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The navigable ends that are owned by the Association itself.
	 * <!-- end-user-doc -->
	 */
	def navigableOwnedEnd: Set[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ends that are owned by the Association itself.
	 * <!-- end-user-doc -->
	 */
	def ownedEnd: Iterable[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def association_clearAssociationAction: Option[UMLClearAssociationAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def type_connector: Set[UMLConnector[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLAssociation
