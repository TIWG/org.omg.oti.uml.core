package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Component represents a modular part of a system that encapsulates its contents and whose manifestation is replaceable within its environment.  
 * <!-- end-user-doc --> 
 */
trait UMLComponent[Uml <: UML]
  extends UMLClass[Uml] with operations.UMLComponentOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		component_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLComponent
	 */
	def component_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		class_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[Uml, UMLComponent[Uml]](None, "isIndirectlyInstantiated", (x) => booleanToIterable(x.isIndirectlyInstantiated, true))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		component_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLComponent
	 */
	def component_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		class_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLComponent[Uml], UMLPackageableElement[Uml]]("packagedElement", _.packagedElement),
		  	MetaPropertyCollection[Uml, UMLComponent[Uml], UMLComponentRealization[Uml]]("realization", _.realization)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		component_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLComponent
	 */
	def component_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		class_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		component_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLComponent
	 */
	def component_forwardReferencesFromMetamodelAssociations: Elements =
		class_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * If true, the Component is defined at design-time, but at run-time (or execution-time) an object specified by the Component does not exist, that is, the Component is instantiated indirectly, through the instantiation of its realizing Classifiers or parts.
	 * <!-- end-user-doc -->
	 */
	def isIndirectlyInstantiated: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * The set of PackageableElements that a Component owns. In the namespace of a Component, all model elements that are involved in or related to its definition may be owned or imported explicitly. These may include e.g., Classes, Interfaces, Components, Packages, UseCases, Dependencies (e.g., mappings), and Artifacts.
	 * <!-- end-user-doc -->
	 */
	def packagedElement: Set[UMLPackageableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Interfaces that the Component exposes to its environment. These Interfaces may be Realized by the Component or any of its realizingClassifiers, or they may be the Interfaces that are provided by its public Ports.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (let 	ris : Set(Interface) = allRealizedInterfaces(),
	 *         realizingClassifiers : Set(Classifier) =  self.realization.realizingClassifier->union(self.allParents()->collect(realization.realizingClassifier))->asSet(),
	 *         allRealizingClassifiers : Set(Classifier) = realizingClassifiers->union(realizingClassifiers.allParents())->asSet(),
	 *         realizingClassifierInterfaces : Set(Interface) = allRealizingClassifiers->iterate(c; rci : Set(Interface) = Set{} | rci->union(c.allRealizedInterfaces())),
	 *         ports : Set(Port) = self.ownedPort->union(allParents()->collect(ownedPort))->asSet(),
	 *         providedByPorts : Set(Interface) = ports.provided->asSet()
	 * in     ris->union(realizingClassifierInterfaces) ->union(providedByPorts)->asSet())
	 */
	def provided: Set[UMLInterface[Uml]] 
  
	/**
	 * <!-- begin-user-doc --> 
	 * The set of Realizations owned by the Component. Realizations reference the Classifiers of which the Component is an abstraction; i.e., that realize its behavior.
	 * <!-- end-user-doc -->
	 */
	def realization: Set[UMLComponentRealization[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Interfaces that the Component requires from other Components in its environment in order to be able to offer its full set of provided functionality. These Interfaces may be used by the Component or any of its realizingClassifiers, or they may be the Interfaces that are required by its public Ports.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (let 	uis : Set(Interface) = allUsedInterfaces(),
	 *         realizingClassifiers : Set(Classifier) = self.realization.realizingClassifier->union(self.allParents()->collect(realization.realizingClassifier))->asSet(),
	 *         allRealizingClassifiers : Set(Classifier) = realizingClassifiers->union(realizingClassifiers.allParents())->asSet(),
	 *         realizingClassifierInterfaces : Set(Interface) = allRealizingClassifiers->iterate(c; rci : Set(Interface) = Set{} | rci->union(c.allUsedInterfaces())),
	 *         ports : Set(Port) = self.ownedPort->union(allParents()->collect(ownedPort))->asSet(),
	 *         usedByPorts : Set(Interface) = ports.required->asSet()
	 * in	    uis->union(realizingClassifierInterfaces)->union(usedByPorts)->asSet()
	 * )
	 */
	def required: Set[UMLInterface[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLComponent
