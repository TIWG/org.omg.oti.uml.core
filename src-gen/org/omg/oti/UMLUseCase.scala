package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A UseCase specifies a set of actions performed by its subjects, which yields an observable result that is of value for one or more Actors or other stakeholders of each subject.
 * <!-- end-user-doc --> 
 */
trait UMLUseCase[Uml <: UML]
  extends UMLBehavioredClassifier[Uml] with operations.UMLUseCaseOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		useCase_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLUseCase
	 */
	def useCase_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		behavioredClassifier_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		useCase_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLUseCase
	 */
	def useCase_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		behavioredClassifier_compositeMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLUseCase[Uml], UMLExtend[Uml]]("extend", _.extend),
		  	MetaPropertyCollection[Uml, UMLUseCase[Uml], UMLExtensionPoint[Uml]]("extensionPoint", _.extensionPoint),
		  	MetaPropertyCollection[Uml, UMLUseCase[Uml], UMLInclude[Uml]]("include", _.include)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		useCase_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLUseCase
	 */
	def useCase_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		behavioredClassifier_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLUseCase[Uml], UMLClassifier[Uml]]("subject", _.subject)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		useCase_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLUseCase
	 */
	def useCase_forwardReferencesFromMetamodelAssociations: Elements =
		behavioredClassifier_forwardReferencesFromMetamodelAssociations ++
		subject 

	/**
	 * <!-- begin-user-doc --> 
	 * The Extend relationships owned by this UseCase.
	 * <!-- end-user-doc -->
	 */
	def extend: Set[UMLExtend[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ExtensionPoints owned by this UseCase.
	 * <!-- end-user-doc -->
	 */
	def extensionPoint: Set[UMLExtensionPoint[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Include relationships owned by this UseCase.
	 * <!-- end-user-doc -->
	 */
	def include: Set[UMLInclude[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The subjects to which this UseCase applies. Each subject or its parts realize all the UseCases that apply to it.
	 * <!-- end-user-doc -->
	 */
	def subject: Set[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedUseCase_classifier: Option[UMLClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def extendedCase_extend: Set[UMLExtend[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def addition_include: Set[UMLInclude[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLUseCase
