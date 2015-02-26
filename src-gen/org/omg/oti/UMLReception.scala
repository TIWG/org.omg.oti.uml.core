package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Reception is a declaration stating that a Classifier is prepared to react to the receipt of a Signal.
 * <!-- end-user-doc --> 
 */
trait UMLReception[Uml <: UML]
  extends UMLBehavioralFeature[Uml] with operations.UMLReceptionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		reception_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReception
	 */
	def reception_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		behavioralFeature_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		reception_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReception
	 */
	def reception_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		behavioralFeature_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		reception_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReception
	 */
	def reception_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		behavioralFeature_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLReception[Uml], UMLSignal[Uml]]("signal", _.signal)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		reception_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReception
	 */
	def reception_forwardReferencesFromMetamodelAssociations: Elements =
		behavioralFeature_forwardReferencesFromMetamodelAssociations ++
		signal 

	/**
	 * <!-- begin-user-doc --> 
	 * The Signal that this Reception handles.
	 * <!-- end-user-doc -->
	 */
	def signal: Option[UMLSignal[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedReception_interface: Option[UMLInterface[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedReception_class: Option[UMLClass[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLReception
