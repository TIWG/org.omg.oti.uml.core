/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
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
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLClassifierOps

import scala.Boolean
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Classifier represents a classification of instances according to their Features.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLClassifier[Uml <: UML]
  extends UMLNamespace[Uml]
	with UMLRedefinableElement[Uml]
	with UMLTemplateableElement[Uml]
	with UMLType[Uml]
  with UMLClassifierOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * All of the Properties that are direct (i.e., not inherited or imported) attributes of the Classifier.
    *
    * <!-- Start of user code doc for attribute -->
    * <!-- End of user code doc for attribute -->
    *
    * UML Property derived="true" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.attribute_classifier
    */
  def attribute: Seq[UMLProperty[Uml]]

  /**
    * If true, the Classifier can only be instantiated by instantiating one of its specializations. An abstract Classifier is intended to be used by other Classifiers e.g., as the target of Associations or Generalizations.
    *
    * <!-- Start of user code doc for isAbstract -->
    * <!-- End of user code doc for isAbstract -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isAbstract: Boolean

  /**
    * If true, the Classifier cannot be specialized.
    *
    * <!-- Start of user code doc for isFinalSpecialization -->
    * <!-- End of user code doc for isFinalSpecialization -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isFinalSpecialization: Boolean

  /**
    * The GeneralizationSet of which this Classifier is a power type.
    *
    * <!-- Start of user code doc for powertypeExtent -->
    * <!-- End of user code doc for powertypeExtent -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLGeneralizationSet.powertype
    */
  def powertypeExtent: Set[UMLGeneralizationSet[Uml]]

  /**
    * TheClassifierTemplateParameter that exposes this element as a formal parameter.
    *
    * <!-- Start of user code doc for templateParameter -->
    * <!-- End of user code doc for templateParameter -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifierTemplateParameter.parameteredElement
    */
  override def templateParameter: Option[UMLClassifierTemplateParameter[Uml]]

  /**
    * The set of UseCases for which this Classifier is the subject.
    *
    * <!-- Start of user code doc for useCase -->
    * <!-- End of user code doc for useCase -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLUseCase.subject
    */
  def useCase: Set[UMLUseCase[Uml]]

  /**
    * <!-- Start of user code doc for classifier_createObjectAction -->
    * <!-- End of user code doc for classifier_createObjectAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLCreateObjectAction.classifier
    */
  def classifier_createObjectAction: Set[UMLCreateObjectAction[Uml]]

  /**
    * <!-- Start of user code doc for classifier_instanceSpecification -->
    * <!-- End of user code doc for classifier_instanceSpecification -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInstanceSpecification.classifier
    */
  def classifier_instanceSpecification: Set[UMLInstanceSpecification[Uml]]

  /**
    * <!-- Start of user code doc for classifier_readExtentAction -->
    * <!-- End of user code doc for classifier_readExtentAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReadExtentAction.classifier
    */
  def classifier_readExtentAction: Option[UMLReadExtentAction[Uml]]

  /**
    * <!-- Start of user code doc for classifier_readIsClassifiedObjectAction -->
    * <!-- End of user code doc for classifier_readIsClassifiedObjectAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReadIsClassifiedObjectAction.classifier
    */
  def classifier_readIsClassifiedObjectAction: Set[UMLReadIsClassifiedObjectAction[Uml]]

  /**
    * <!-- Start of user code doc for constrainingClassifier_classifierTemplateParameter -->
    * <!-- End of user code doc for constrainingClassifier_classifierTemplateParameter -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifierTemplateParameter.constrainingClassifier
    */
  def constrainingClassifier_classifierTemplateParameter: Set[UMLClassifierTemplateParameter[Uml]]

  /**
    * <!-- Start of user code doc for context_action -->
    * <!-- End of user code doc for context_action -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAction.context
    */
  def context_action: Set[UMLAction[Uml]]

  /**
    * <!-- Start of user code doc for contract_substitution -->
    * <!-- End of user code doc for contract_substitution -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSubstitution.contract
    */
  def contract_substitution: Set[UMLSubstitution[Uml]]

  /**
    * <!-- Start of user code doc for conveyed_conveyingFlow -->
    * <!-- End of user code doc for conveyed_conveyingFlow -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInformationFlow.conveyed
    */
  def conveyed_conveyingFlow: Set[UMLInformationFlow[Uml]]

  /**
    * <!-- Start of user code doc for exceptionType_exceptionHandler -->
    * <!-- End of user code doc for exceptionType_exceptionHandler -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExceptionHandler.exceptionType
    */
  def exceptionType_exceptionHandler: Set[UMLExceptionHandler[Uml]]

  /**
    * <!-- Start of user code doc for general_classifier -->
    * <!-- End of user code doc for general_classifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.general
    */
  def general_classifier: Set[UMLClassifier[Uml]]

  /**
    * <!-- Start of user code doc for newClassifier_reclassifyObjectAction -->
    * <!-- End of user code doc for newClassifier_reclassifyObjectAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReclassifyObjectAction.newClassifier
    */
  def newClassifier_reclassifyObjectAction: Set[UMLReclassifyObjectAction[Uml]]

  /**
    * <!-- Start of user code doc for oldClassifier_reclassifyObjectAction -->
    * <!-- End of user code doc for oldClassifier_reclassifyObjectAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReclassifyObjectAction.oldClassifier
    */
  def oldClassifier_reclassifyObjectAction: Set[UMLReclassifyObjectAction[Uml]]

  /**
    * <!-- Start of user code doc for realizingClassifier_componentRealization -->
    * <!-- End of user code doc for realizingClassifier_componentRealization -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLComponentRealization.realizingClassifier
    */
  def realizingClassifier_componentRealization: Set[UMLComponentRealization[Uml]]

  /**
    * <!-- Start of user code doc for redefinitionContext_redefinableElement -->
    * <!-- End of user code doc for redefinitionContext_redefinableElement -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRedefinableElement.redefinitionContext
    */
  def redefinitionContext_redefinableElement: Set[UMLRedefinableElement[Uml]]

  /**
    * <!-- Start of user code doc for represented_representation -->
    * <!-- End of user code doc for represented_representation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInformationItem.represented
    */
  def represented_representation: Set[UMLInformationItem[Uml]]

  /**
    * <!-- Start of user code doc for unmarshallType_unmarshallAction -->
    * <!-- End of user code doc for unmarshallType_unmarshallAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLUnmarshallAction.unmarshallType
    */
  def unmarshallType_unmarshallAction: Set[UMLUnmarshallAction[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      classifier_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLClassifier
    *
    * <!-- Start of user code doc for classifier_metaAttributes -->
    * <!-- End of user code doc for classifier_metaAttributes -->
    */
  def classifier_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namespace_metaAttributes,
     redefinableElement_metaAttributes,
     templateableElement_metaAttributes,
     type_metaAttributes,
     Seq[MetaAttributeFunction](Classifier_isAbstract,
     	Classifier_isFinalSpecialization))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    classifier_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLClassifier
    *
    * <!-- Start of user code doc for classifier_compositeMetaProperties -->
    * <!-- End of user code doc for classifier_compositeMetaProperties -->
    */
  def classifier_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namespace_compositeMetaProperties,
      redefinableElement_compositeMetaProperties,
      templateableElement_compositeMetaProperties,
      type_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Classifier_collaborationUse,
      	Classifier_generalization,
      	Classifier_ownedTemplateSignature,
      	Classifier_ownedUseCase,
      	Classifier_substitution))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    classifier_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLClassifier
    *
    * <!-- Start of user code doc for classifier_referenceMetaProperties -->
    * <!-- End of user code doc for classifier_referenceMetaProperties -->
    */
  def classifier_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namespace_referenceMetaProperties,
      redefinableElement_referenceMetaProperties,
      templateableElement_referenceMetaProperties,
      type_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Classifier_powertypeExtent,
      	Classifier_redefinedClassifier,
      	Classifier_representation,
      	Classifier_templateParameter,
      	Classifier_useCase))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    classifier_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLClassifier
    *
    * <!-- Start of user code doc for classifier_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for classifier_forwardReferencesFromMetamodelAssociations -->
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

  // Start of user code for additional features
  // End of user code
} //UMLClassifier