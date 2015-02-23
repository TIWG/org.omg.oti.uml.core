package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An EncapsulatedClassifier may own Ports to specify typed interaction points.
 * <!-- end-user-doc --> 
 */
trait UMLEncapsulatedClassifier[Uml <: UML]
  extends UMLStructuredClassifier[Uml] with operations.UMLEncapsulatedClassifierOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		encapsulatedClassifier_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLEncapsulatedClassifier
	 */
	def encapsulatedClassifier_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		structuredClassifier_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		encapsulatedClassifier_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLEncapsulatedClassifier
	 */
	def encapsulatedClassifier_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuredClassifier_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		encapsulatedClassifier_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLEncapsulatedClassifier
	 */
	def encapsulatedClassifier_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		structuredClassifier_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		encapsulatedClassifier_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLEncapsulatedClassifier
	 */
	def encapsulatedClassifier_forwardReferencesFromMetamodelAssociations: Elements =
		structuredClassifier_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * The Ports owned by the EncapsulatedClassifier.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (ownedAttribute->select(oclIsKindOf(Port))->collect(oclAsType(Port))->asOrderedSet())
	 */
	def ownedPort: Set[UMLPort[Uml]] = {
	    // Start of user code for "ownedPort"
	    ???
	    // End of user code
	}

// Start of user code for additional featuers
// End of user code

} //UMLEncapsulatedClassifier
