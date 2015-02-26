package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A profile application is used to show which profiles have been applied to a package.
 * <!-- end-user-doc --> 
 */
trait UMLProfileApplication[Uml <: UML]
  extends UMLDirectedRelationship[Uml] with operations.UMLProfileApplicationOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		profileApplication_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLProfileApplication
	 */
	def profileApplication_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		directedRelationship_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLProfileApplication[Uml]](None, "isStrict", (x) => booleanToIterable(x.isStrict, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		profileApplication_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLProfileApplication
	 */
	def profileApplication_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		profileApplication_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLProfileApplication
	 */
	def profileApplication_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		directedRelationship_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLProfileApplication[Uml], UMLProfile[Uml]]("appliedProfile", _.appliedProfile),
		  	MetaPropertyReference[Uml, UMLProfileApplication[Uml], UMLPackage[Uml]]("applyingPackage", _.applyingPackage)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		profileApplication_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLProfileApplication
	 */
	def profileApplication_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		appliedProfile ++
		applyingPackage 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Profiles that are applied to a Package through this ProfileApplication.
	 * <!-- end-user-doc -->
	 */
	def appliedProfile: Option[UMLProfile[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The package that owns the profile application.
	 * <!-- end-user-doc -->
	 */
	def applyingPackage: Option[UMLPackage[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies that the Profile filtering rules for the metaclasses of the referenced metamodel shall be strictly applied.
	 * <!-- end-user-doc -->
	 */
	def isStrict: Boolean = false

// Start of user code for additional featuers
// End of user code

} //UMLProfileApplication
