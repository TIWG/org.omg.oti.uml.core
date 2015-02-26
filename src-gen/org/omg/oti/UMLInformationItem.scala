package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * InformationItems represent many kinds of information that can flow from sources to targets in very abstract ways.? They represent the kinds of information that may move within a system, but do not elaborate details of the transferred information.? Details of transferred information are the province of other Classifiers that may ultimately define InformationItems.? Consequently, InformationItems cannot be instantiated and do not themselves have features, generalizations, or associations.?An important use of InformationItems is to represent information during early design stages, possibly before the detailed modeling decisions that will ultimately define them have been made. Another purpose of InformationItems is to abstract portions of complex models in less precise, but perhaps more general and communicable, ways. 
 * <!-- end-user-doc --> 
 */
trait UMLInformationItem[Uml <: UML]
  extends UMLClassifier[Uml] with operations.UMLInformationItemOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		informationItem_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInformationItem
	 */
	def informationItem_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		classifier_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		informationItem_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInformationItem
	 */
	def informationItem_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		classifier_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		informationItem_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInformationItem
	 */
	def informationItem_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		classifier_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLInformationItem[Uml], UMLClassifier[Uml]]("represented", _.represented)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		informationItem_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInformationItem
	 */
	def informationItem_forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations ++
		represented 

	/**
	 * <!-- begin-user-doc --> 
	 * Determines the classifiers that will specify the structure and nature of the information. An information item represents all its represented classifiers.
	 * <!-- end-user-doc -->
	 */
	def represented: Set[UMLClassifier[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLInformationItem
