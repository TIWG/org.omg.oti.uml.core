package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A package merge defines how the contents of one package are extended by the contents of another package.
 * <!-- end-user-doc --> 
 */
trait UMLPackageMerge[Uml <: UML]
  extends UMLDirectedRelationship[Uml] with operations.UMLPackageMergeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		packageMerge_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPackageMerge
	 */
	def packageMerge_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		directedRelationship_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		packageMerge_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPackageMerge
	 */
	def packageMerge_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		packageMerge_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPackageMerge
	 */
	def packageMerge_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLPackageMerge[Uml], UMLPackage[Uml]]("mergedPackage", _.mergedPackage),
		  	MetaPropertyReference[Uml, UMLPackageMerge[Uml], UMLPackage[Uml]]("receivingPackage", _.receivingPackage)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		packageMerge_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPackageMerge
	 */
	def packageMerge_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		mergedPackage ++
		receivingPackage 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Package that is to be merged with the receiving package of the PackageMerge.
	 * <!-- end-user-doc -->
	 */
	def mergedPackage: Option[UMLPackage[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Package that is being extended with the contents of the merged package of the PackageMerge.
	 * <!-- end-user-doc -->
	 */
	def receivingPackage: Option[UMLPackage[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLPackageMerge
