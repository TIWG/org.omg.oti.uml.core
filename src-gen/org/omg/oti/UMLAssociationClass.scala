package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A model element that has both Association and Class properties. An AssociationClass can be seen as an Association that also has Class properties, or as a Class that also has Association properties. It not only connects a set of Classifiers but also defines a set of Features that belong to the Association itself and not to any of the associated Classifiers.
 * <!-- end-user-doc --> 
 */
trait UMLAssociationClass[Uml <: UML]
  extends UMLClass[Uml] with UMLAssociation[Uml] with operations.UMLAssociationClassOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		associationClass_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAssociationClass
	 */
	def associationClass_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		class_metaAttributes,
		association_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		associationClass_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAssociationClass
	 */
	def associationClass_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		class_compositeMetaProperties,
		association_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		associationClass_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAssociationClass
	 */
	def associationClass_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		class_referenceMetaProperties,
		association_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		associationClass_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAssociationClass
	 */
	def associationClass_forwardReferencesFromMetamodelAssociations: Elements =
		class_forwardReferencesFromMetamodelAssociations ++
		association_forwardReferencesFromMetamodelAssociations ++
		Set () 


// Start of user code for additional featuers
// End of user code

} //UMLAssociationClass
