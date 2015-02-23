package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Classifier represents a classification of instances according to their Features.
 * <!-- end-user-doc --> 
 */
trait UMLClassifier[Uml <: UML]
  extends UMLTemplateableElement[Uml] 
  with UMLType[Uml] 
  with UMLRedefinableElement[Uml] 
  with UMLNamespace[Uml] 
  with operations.UMLClassifierOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		classifier_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLClassifier
	 */
	def classifier_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		templateableElement_metaAttributes,
		type_metaAttributes,
		redefinableElement_metaAttributes,
		namespace_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLClassifier[Uml]](None, "isAbstract", (x) => booleanToIterable(x.isAbstract, false)),
		  	MetaAttributeBooleanFunction[UMLClassifier[Uml]](None, "isFinalSpecialization", (x) => booleanToIterable(x.isFinalSpecialization, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		classifier_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLClassifier
	 */
	def classifier_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		templateableElement_compositeMetaProperties,
		type_compositeMetaProperties,
		redefinableElement_compositeMetaProperties,
		namespace_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLClassifier[Uml], UMLCollaborationUse[Uml]]("collaborationUse", _.collaborationUse),
		  	MetaPropertyCollection[UMLClassifier[Uml], UMLGeneralization[Uml]]("generalization", _.generalization),
		  	MetaPropertyReference[UMLClassifier[Uml], UMLRedefinableTemplateSignature[Uml]]("ownedTemplateSignature", _.classifier_ownedTemplateSignature),
		  	MetaPropertyCollection[UMLClassifier[Uml], UMLUseCase[Uml]]("ownedUseCase", _.ownedUseCase),
		  	MetaPropertyCollection[UMLClassifier[Uml], UMLSubstitution[Uml]]("substitution", _.substitution)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		classifier_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLClassifier
	 */
	def classifier_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		templateableElement_referenceMetaProperties,
		type_referenceMetaProperties,
		redefinableElement_referenceMetaProperties,
		namespace_referenceMetaProperties,
		  Seq (MetaPropertyCollection[UMLClassifier[Uml], UMLGeneralizationSet[Uml]]("powertypeExtent", _.powertypeExtent),
		  	MetaPropertyCollection[UMLClassifier[Uml], UMLClassifier[Uml]]("redefinedClassifier", _.redefinedClassifier),
		  	MetaPropertyReference[UMLClassifier[Uml], UMLCollaborationUse[Uml]]("representation", _.representation),
		  	MetaPropertyReference[UMLClassifier[Uml], UMLClassifierTemplateParameter[Uml]]("templateParameter", _.classifier_templateParameter),
		  	MetaPropertyCollection[UMLClassifier[Uml], UMLUseCase[Uml]]("useCase", _.useCase)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLClassifier
	 */
	def classifier_forwardReferencesFromMetamodelAssociations: Elements =
		templateableElement_forwardReferencesFromMetamodelAssociations ++
		type_forwardReferencesFromMetamodelAssociations ++
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		namespace_forwardReferencesFromMetamodelAssociations ++
		powertypeExtent ++
		redefinedClassifier ++
		representation ++
		templateParameter ++
		useCase 

	/**
	 * <!-- begin-user-doc --> 
	 * All of the Properties that are direct (i.e., not inherited or imported) attributes of the Classifier.
	 * <!-- end-user-doc -->
	 */
	def attribute: Seq[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The CollaborationUses owned by the Classifier.
	 * <!-- end-user-doc -->
	 */
	def collaborationUse: Set[UMLCollaborationUse[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies each Feature directly defined in the classifier. Note that there may be members of the Classifier that are of the type Feature but are not included, e.g., inherited features.
	 * <!-- end-user-doc -->
	 */
	def feature: Set[UMLFeature[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The generalizing Classifiers for this Classifier.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (parents())
	 */
	def general: Iterable[UMLClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * The Generalization relationships for this Classifier. These Generalizations navigate to more general Classifiers in the generalization hierarchy.
	 * <!-- end-user-doc -->
	 */
	def generalization: Set[UMLGeneralization[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * All elements inherited by this Classifier from its general Classifiers.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (inherit(parents()->collect(inheritableMembers(self))->asSet()))
	 */
	def inheritedMember: Set[UMLNamedElement[Uml]] 
  
	/**
	 * <!-- begin-user-doc --> 
	 * If true, the Classifier can only be instantiated by instantiating one of its specializations. An abstract Classifier is intended to be used by other Classifiers e.g., as the target of Associations or Generalizations.
	 * <!-- end-user-doc -->
	 */
	def isAbstract: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * If true, the Classifier cannot be specialized.
	 * <!-- end-user-doc -->
	 */
	def isFinalSpecialization: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * The optional RedefinableTemplateSignature specifying the formal template parameters.
	 * <!-- end-user-doc -->
	 */
	override def ownedTemplateSignature: Option[UMLRedefinableTemplateSignature[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The UseCases owned by this classifier.
	 * <!-- end-user-doc -->
	 */
	def ownedUseCase: Set[UMLUseCase[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The GeneralizationSet of which this Classifier is a power type.
	 * <!-- end-user-doc -->
	 */
	def powertypeExtent: Set[UMLGeneralizationSet[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Classifiers redefined by this Classifier.
	 * <!-- end-user-doc -->
	 */
	def redefinedClassifier: Set[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A CollaborationUse which indicates the Collaboration that represents this Classifier.
	 * <!-- end-user-doc -->
	 */
	def representation: Option[UMLCollaborationUse[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Substitutions owned by this Classifier.
	 * <!-- end-user-doc -->
	 */
	def substitution: Set[UMLSubstitution[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * TheClassifierTemplateParameter that exposes this element as a formal parameter.
	 * <!-- end-user-doc -->
	 */
  override def templateParameter: Option[UMLTemplateParameter[Uml]] 

	def classifier_templateParameter: Option[UMLClassifierTemplateParameter[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The set of UseCases for which this Classifier is the subject.
	 * <!-- end-user-doc -->
	 */
	def useCase: Set[UMLUseCase[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinitionContext_state: Set[UMLState[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def classifier_readIsClassifiedObjectAction: Set[UMLReadIsClassifiedObjectAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def realizingClassifier_componentRealization: Set[UMLComponentRealization[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def classifier_readExtentAction: Option[UMLReadExtentAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def unmarshallType_unmarshallAction: Set[UMLUnmarshallAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def represented_representation: Set[UMLInformationItem[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def newClassifier_reclassifyObjectAction: Set[UMLReclassifyObjectAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinitionContext_transition: Set[UMLTransition[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def oldClassifier_reclassifyObjectAction: Set[UMLReclassifyObjectAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def contract_substitution: Set[UMLSubstitution[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinitionContext_redefinableElement: Set[UMLRedefinableElement[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def nestedClassifier_nestingClass: Option[UMLClass[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def classifier_instanceSpecification: Iterable[UMLInstanceSpecification[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def exceptionType_exceptionHandler: Set[UMLExceptionHandler[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def general_classifier: Set[UMLClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def constrainingClassifier_classifierTemplateParameter: Set[UMLClassifierTemplateParameter[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def conveyed_conveyingFlow: Set[UMLInformationFlow[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinitionContext_region: Set[UMLRegion[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinedClassifier_classifier: Set[UMLClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def context_action: Set[UMLAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def classifier_createObjectAction: Set[UMLCreateObjectAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def general_generalization: Set[UMLGeneralization[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def nestedClassifier_interface: Option[UMLInterface[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLClassifier
