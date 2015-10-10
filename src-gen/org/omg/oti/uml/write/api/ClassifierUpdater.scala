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
package org.omg.oti.uml.write.api

// Start of user code for imports
import org.omg.oti.uml.UMLError
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
  : ValidationNel[UMLError[Uml]#UException,Unit] =
    umlU.links_Classifier_classifier_compose_collaborationUse_CollaborationUse(domain, range)

  def links_Classifier_specific_compose_generalization_Generalization
  (range: Set[UMLGeneralization[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : ValidationNel[UMLError[Uml]#UException,Unit] =
    umlU.links_Classifier_specific_compose_generalization_Generalization(domain, range)

  def links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature
  (range: Option[UMLRedefinableTemplateSignature[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : ValidationNel[UMLError[Uml]#UException,Unit] =
    umlU.links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature(domain, range)

  def links_Classifier_classifier_compose_ownedUseCase_UseCase
  (range: Set[UMLUseCase[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : ValidationNel[UMLError[Uml]#UException,Unit] =
    umlU.links_Classifier_classifier_compose_ownedUseCase_UseCase(domain, range)

  def links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet
  (range: Set[UMLGeneralizationSet[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : ValidationNel[UMLError[Uml]#UException,Unit] =
    umlU.links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet(domain, range)

  def links_Classifier_classifier_reference_redefinedClassifier_Classifier
  (range: Set[UMLClassifier[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : ValidationNel[UMLError[Uml]#UException,Unit] =
    umlU.links_Classifier_classifier_reference_redefinedClassifier_Classifier(domain, range)

  def links_Classifier_classifier_reference_representation_CollaborationUse
  (range: Option[UMLCollaborationUse[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : ValidationNel[UMLError[Uml]#UException,Unit] =
    umlU.links_Classifier_classifier_reference_representation_CollaborationUse(domain, range)

  def links_Classifier_substitutingClassifier_compose_substitution_Substitution
  (range: Set[UMLSubstitution[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : ValidationNel[UMLError[Uml]#UException,Unit] =
    umlU.links_Classifier_substitutingClassifier_compose_substitution_Substitution(domain, range)

  def links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter
  (range: Option[UMLClassifierTemplateParameter[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : ValidationNel[UMLError[Uml]#UException,Unit] =
    umlU.links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter(domain, range)

  def links_Classifier_subject_reference_useCase_UseCase
  (range: Set[UMLUseCase[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : ValidationNel[UMLError[Uml]#UException,Unit] =
    umlU.links_Classifier_subject_reference_useCase_UseCase(domain, range)

  def setIsAbstract
  (isAbstract: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : ValidationNel[UMLError[Uml]#UException,Unit] =
    umlU.set_Classifier_isAbstract(domain, isAbstract)

  def setIsFinalSpecialization
  (isFinalSpecialization: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : ValidationNel[UMLError[Uml]#UException,Unit] =
    umlU.set_Classifier_isFinalSpecialization(domain, isFinalSpecialization)
}
