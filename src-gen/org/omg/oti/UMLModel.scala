package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A model captures a view of a physical system. It is an abstraction of the physical system, with a certain purpose. This purpose determines what is to be included in the model and what is irrelevant. Thus the model completely describes those aspects of the physical system that are relevant to the purpose of the model, at the appropriate level of detail.
 * <!-- end-user-doc --> 
 */
trait UMLModel[Uml <: UML]
  extends UMLPackage[Uml] with operations.UMLModelOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		model_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLModel
	 */
	def model_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		package_metaAttributes,
		  Seq (MetaAttributeStringFunction[UMLModel[Uml]](None, "viewpoint", (x) => stringToIterable(x.viewpoint, null))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		model_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLModel
	 */
	def model_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		package_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		model_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLModel
	 */
	def model_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		package_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		model_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLModel
	 */
	def model_forwardReferencesFromMetamodelAssociations: Elements =
		package_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The name of the viewpoint that is expressed by a model (this name may refer to a profile definition).
	 * <!-- end-user-doc -->
	 */
	def viewpoint: Option[String] 

// Start of user code for additional featuers
// End of user code

} //UMLModel
