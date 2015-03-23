/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.operations._
// End of user code

/**
 * <!-- begin-model-doc -->
 * A Classifier represents a classification of instances according to their Features.
 * <!-- end-model-doc -->
 */
trait UMLClassifier[Uml <: UML]
	extends UMLNamespace[Uml]
	with UMLRedefinableElement[Uml]
	with UMLTemplateableElement[Uml]
	with UMLType[Uml]
	with UMLClassifierOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * All of the Properties that are direct (i.e., not inherited or imported) attributes of the Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty.attribute_classifier
	 */
	def attribute: Seq[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The CollaborationUses owned by the Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLCollaborationUse.collaborationUse_classifier
	 */
	def collaborationUse: Set[UMLCollaborationUse[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies each Feature directly defined in the classifier. Note that there may be members of the Classifier that are of the type Feature but are not included, e.g., inherited features.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLFeature.featuringClassifier
	 */
	def feature: Set[UMLFeature[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The generalizing Classifiers for this Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.general_classifier
	 */
	def general: Set[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Generalization relationships for this Classifier. These Generalizations navigate to more general Classifiers in the generalization hierarchy.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLGeneralization.specific
	 */
	def generalization: Set[UMLGeneralization[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * All elements inherited by this Classifier from its general Classifiers.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLNamedElement.inheritedMember_inheritingClassifier
	 */
	def inheritedMember: Set[UMLNamedElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * If true, the Classifier can only be instantiated by instantiating one of its specializations. An abstract Classifier is intended to be used by other Classifiers e.g., as the target of Associations or Generalizations.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isAbstract: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * If true, the Classifier cannot be specialized.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isFinalSpecialization: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * The optional RedefinableTemplateSignature specifying the formal template parameters.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLRedefinableTemplateSignature.classifier
	 */
	override def ownedTemplateSignature: Option[UMLRedefinableTemplateSignature[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The UseCases owned by this classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLUseCase.ownedUseCase_classifier
	 */
	def ownedUseCase: Set[UMLUseCase[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The GeneralizationSet of which this Classifier is a power type.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLGeneralizationSet.powertype
	 */
	def powertypeExtent: Set[UMLGeneralizationSet[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Classifiers redefined by this Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.redefinedClassifier_classifier
	 */
	def redefinedClassifier: Set[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A CollaborationUse which indicates the Collaboration that represents this Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLCollaborationUse.representation_classifier
	 */
	def representation: Option[UMLCollaborationUse[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Substitutions owned by this Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLSubstitution.substitutingClassifier
	 */
	def substitution: Set[UMLSubstitution[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * TheClassifierTemplateParameter that exposes this element as a formal parameter.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClassifierTemplateParameter.parameteredElement
	 */
	override def templateParameter: Option[UMLClassifierTemplateParameter[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The set of UseCases for which this Classifier is the subject.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLUseCase.subject
	 */
	def useCase: Set[UMLUseCase[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLCreateObjectAction.classifier
	 */
	def classifier_createObjectAction: Set[UMLCreateObjectAction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInstanceSpecification.classifier
	 */
	def classifier_instanceSpecification: Set[UMLInstanceSpecification[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadExtentAction.classifier
	 */
	def classifier_readExtentAction: Option[UMLReadExtentAction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLReadIsClassifiedObjectAction.classifier
	 */
	def classifier_readIsClassifiedObjectAction: Set[UMLReadIsClassifiedObjectAction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifierTemplateParameter.constrainingClassifier
	 */
	def constrainingClassifier_classifierTemplateParameter: Set[UMLClassifierTemplateParameter[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLAction.context
	 */
	def context_action: Set[UMLAction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLSubstitution.contract
	 */
	def contract_substitution: Set[UMLSubstitution[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInformationFlow.conveyed
	 */
	def conveyed_conveyingFlow: Set[UMLInformationFlow[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExceptionHandler.exceptionType
	 */
	def exceptionType_exceptionHandler: Set[UMLExceptionHandler[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.general
	 */
	def general_classifier: Set[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLGeneralization.general
	 */
	def general_generalization: Set[UMLGeneralization[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInterface.nestedClassifier
	 */
	def nestedClassifier_interface: Option[UMLInterface[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClass.nestedClassifier
	 */
	def nestedClassifier_nestingClass: Option[UMLClass[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLReclassifyObjectAction.newClassifier
	 */
	def newClassifier_reclassifyObjectAction: Set[UMLReclassifyObjectAction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLReclassifyObjectAction.oldClassifier
	 */
	def oldClassifier_reclassifyObjectAction: Set[UMLReclassifyObjectAction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComponentRealization.realizingClassifier
	 */
	def realizingClassifier_componentRealization: Set[UMLComponentRealization[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.redefinedClassifier
	 */
	def redefinedClassifier_classifier: Set[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRedefinableElement.redefinitionContext
	 */
	def redefinitionContext_redefinableElement: Set[UMLRedefinableElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRegion.redefinitionContext
	 */
	def redefinitionContext_region: Set[UMLRegion[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLState.redefinitionContext
	 */
	def redefinitionContext_state: Set[UMLState[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTransition.redefinitionContext
	 */
	def redefinitionContext_transition: Set[UMLTransition[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInformationItem.represented
	 */
	def represented_representation: Set[UMLInformationItem[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLUnmarshallAction.unmarshallType
	 */
	def unmarshallType_unmarshallAction: Set[UMLUnmarshallAction[Uml]]

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
			namespace_metaAttributes,
			redefinableElement_metaAttributes,
			templateableElement_metaAttributes,
			type_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLClassifier[Uml]](None, "isAbstract", (x) => booleanToIterable(x.isAbstract, false)),
				MetaAttributeBooleanFunction[Uml, UMLClassifier[Uml]](None, "isFinalSpecialization", (x) => booleanToIterable(x.isFinalSpecialization, false))))

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
			namespace_compositeMetaProperties,
			redefinableElement_compositeMetaProperties,
			templateableElement_compositeMetaProperties,
			type_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLCollaborationUse[Uml]]("collaborationUse", _.collaborationUse),
				MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLGeneralization[Uml]]("generalization", _.generalization),
				MetaPropertyReference[Uml, UMLClassifier[Uml], UMLRedefinableTemplateSignature[Uml]]("ownedTemplateSignature", _.ownedTemplateSignature),
				MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLUseCase[Uml]]("ownedUseCase", _.ownedUseCase),
				MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLSubstitution[Uml]]("substitution", _.substitution)))

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
			namespace_referenceMetaProperties,
			redefinableElement_referenceMetaProperties,
			templateableElement_referenceMetaProperties,
			type_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLGeneralizationSet[Uml]]("powertypeExtent", _.powertypeExtent),
				MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLClassifier[Uml]]("redefinedClassifier", _.redefinedClassifier),
				MetaPropertyReference[Uml, UMLClassifier[Uml], UMLCollaborationUse[Uml]]("representation", _.representation),
				MetaPropertyReference[Uml, UMLClassifier[Uml], UMLClassifierTemplateParameter[Uml]]("templateParameter", _.templateParameter),
				MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLUseCase[Uml]]("useCase", _.useCase)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLClassifier
	 */
	def classifier_forwardReferencesFromMetamodelAssociations: Elements =
		namespace_forwardReferencesFromMetamodelAssociations ++
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		templateableElement_forwardReferencesFromMetamodelAssociations ++
		type_forwardReferencesFromMetamodelAssociations ++
		powertypeExtent ++
		redefinedClassifier ++
		representation ++
		templateParameter ++
		useCase 

} //UMLClassifier
