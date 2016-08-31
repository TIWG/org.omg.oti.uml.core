/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.write.api

// Start of user code for imports
import org.omg.oti.uml.read.api._

import scala.{AnyVal,Boolean,Option,Unit}
import scala.collection.immutable.Set
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class ClassifierUpdater[Uml <: UML](val domain: UMLClassifier[Uml]) extends AnyVal {

  def links_Classifier_classifier_compose_collaborationUse_CollaborationUse
  (range: Set[UMLCollaborationUse[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Classifier_classifier_compose_collaborationUse_CollaborationUse(domain, range)

  def links_Classifier_specific_compose_generalization_Generalization
  (range: Set[UMLGeneralization[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Classifier_specific_compose_generalization_Generalization(domain, range)

  def links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature
  (range: Option[UMLRedefinableTemplateSignature[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature(domain, range)

  def links_Classifier_classifier_compose_ownedUseCase_UseCase
  (range: Set[UMLUseCase[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Classifier_classifier_compose_ownedUseCase_UseCase(domain, range)

  def links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet
  (range: Set[UMLGeneralizationSet[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet(domain, range)

  def links_Classifier_classifier_reference_redefinedClassifier_Classifier
  (range: Set[UMLClassifier[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Classifier_classifier_reference_redefinedClassifier_Classifier(domain, range)

  def links_Classifier_classifier_reference_representation_CollaborationUse
  (range: Option[UMLCollaborationUse[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Classifier_classifier_reference_representation_CollaborationUse(domain, range)

  def links_Classifier_substitutingClassifier_compose_substitution_Substitution
  (range: Set[UMLSubstitution[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Classifier_substitutingClassifier_compose_substitution_Substitution(domain, range)

  def links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter
  (range: Option[UMLClassifierTemplateParameter[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter(domain, range)

  def links_Classifier_subject_reference_useCase_UseCase
  (range: Set[UMLUseCase[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Classifier_subject_reference_useCase_UseCase(domain, range)

  def setIsAbstract
  (isAbstract: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Classifier_isAbstract(domain, isAbstract)

  def setIsFinalSpecialization
  (isFinalSpecialization: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Classifier_isFinalSpecialization(domain, isFinalSpecialization)
}
