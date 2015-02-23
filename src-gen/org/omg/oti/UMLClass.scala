package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Class classifies a set of objects and specifies the features that characterize the structure and behavior of those objects.  A Class may have an internal structure and Ports.

 * <!-- end-user-doc --> 
 */
trait UMLClass[Uml <: UML]
  extends UMLEncapsulatedClassifier[Uml] with UMLBehavioredClassifier[Uml] with operations.UMLClassOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		class_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLClass
	 */
	def class_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		encapsulatedClassifier_metaAttributes,
		behavioredClassifier_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLClass[Uml]](None, "isAbstract", (x) => booleanToIterable(x.isAbstract, false)),
		  	MetaAttributeBooleanFunction[UMLClass[Uml]](None, "isActive", (x) => booleanToIterable(x.isActive, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		class_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLClass
	 */
	def class_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		encapsulatedClassifier_compositeMetaProperties,
		behavioredClassifier_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLClass[Uml], UMLClassifier[Uml]]("nestedClassifier", _.nestedClassifier),
		  	MetaPropertyCollection[UMLClass[Uml], UMLProperty[Uml]]("ownedAttribute", _.ownedAttribute),
		  	MetaPropertyCollection[UMLClass[Uml], UMLOperation[Uml]]("ownedOperation", _.ownedOperation),
		  	MetaPropertyCollection[UMLClass[Uml], UMLReception[Uml]]("ownedReception", _.ownedReception)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		class_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLClass
	 */
	def class_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		encapsulatedClassifier_referenceMetaProperties,
		behavioredClassifier_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		class_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLClass
	 */
	def class_forwardReferencesFromMetamodelAssociations: Elements =
		encapsulatedClassifier_forwardReferencesFromMetamodelAssociations ++
		behavioredClassifier_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * This property is used when the Class is acting as a metaclass. It references the Extensions that specify additional properties of the metaclass. The property is derived from the Extensions whose memberEnds are typed by the Class.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (Extension.allInstances()->select(ext | 
	 *   let endTypes : Sequence(Classifier) = ext.memberEnd->collect(type.oclAsType(Classifier)) in
	 *   endTypes->includes(self) or endTypes.allParents()->includes(self) ))
	 */
	def extension: Set[UMLExtension[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * If true, the Class does not provide a complete declaration and cannot be instantiated. An abstract Class is typically used as a target of Associations or Generalizations.
	 * <!-- end-user-doc -->
	 */
	override def isAbstract: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * Determines whether an object specified by this Class is active or not. If true, then the owning Class is referred to as an active Class. If false, then such a Class is referred to as a passive Class.
	 * <!-- end-user-doc -->
	 */
	def isActive: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * The Classifiers owned by the Class that are not ownedBehaviors.
	 * <!-- end-user-doc -->
	 */
	def nestedClassifier: Seq[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The attributes (i.e., the Properties) owned by the Class.
	 * <!-- end-user-doc -->
	 */
	override def ownedAttribute: Seq[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Operations owned by the Class.
	 * <!-- end-user-doc -->
	 */
	def ownedOperation: Seq[UMLOperation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Receptions owned by the Class.
	 * <!-- end-user-doc -->
	 */
	def ownedReception: Set[UMLReception[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The superclasses of a Class, derived from its Generalizations.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (self.general()->select(oclIsKindOf(Class))->collect(oclAsType(Class))->asSet())
	 */
	def superClass: Iterable[UMLClass[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def superClass_class: Set[UMLClass[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLClass
