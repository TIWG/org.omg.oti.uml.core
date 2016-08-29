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

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * A RedefinableTemplateSignature supports the addition of formal template parameters in a specialization of a template classifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLRedefinableTemplateSignatureOps[Uml <: UML] { self: UMLRedefinableTemplateSignature[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Classifier that owns this RedefinableTemplateSignature.
    *
    * <!-- Start of user code doc for classifier -->
    * <!-- End of user code doc for classifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.ownedTemplateSignature
    */
  def classifier: Option[UMLClassifier[Uml]] = redefinitionContext headOption

  /**
    * The signatures extended by this RedefinableTemplateSignature.
    *
    * <!-- Start of user code doc for extendedSignature -->
    * <!-- End of user code doc for extendedSignature -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRedefinableTemplateSignature.extendedSignature_redefinableTemplateSignature
    */
  def extendedSignature: Set[UMLRedefinableTemplateSignature[Uml]] = redefinedElement.selectByKindOf { case x: UMLRedefinableTemplateSignature[Uml] => x }

  /**
    * The formal template parameters of the extended signatures.
    *
    * <!-- Start of user code doc for inheritedParameter -->
    * <!-- End of user code doc for inheritedParameter -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateParameter.inheritedParameter_redefinableTemplateSignature
    * {{{
    * OCL Body result = (if extendedSignature->isEmpty() then Set{} else extendedSignature.parameter->asSet() endif)
    * }}}
    */
  def inheritedParameter: Set[UMLTemplateParameter[Uml]] = {
    // Start of user code for "inheritedParameter"
    ???
    // End of user code
  }

  /**
    * <!-- Start of user code doc for extendedSignature_redefinableTemplateSignature -->
    * <!-- End of user code doc for extendedSignature_redefinableTemplateSignature -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRedefinableTemplateSignature.extendedSignature
    */
  def extendedSignature_redefinableTemplateSignature: Set[UMLRedefinableTemplateSignature[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLRedefinableTemplateSignature[Uml] => x }

  /**
    * The query isConsistentWith() specifies, for any two RedefinableTemplateSignatures in a context in which redefinition is possible, whether redefinition would be logically consistent. A redefining template signature is always consistent with a redefined template signature, as redefinition only adds new formal parameters.
    *
    * <!-- Start of user code doc for isConsistentWith -->
    * <!-- End of user code doc for isConsistentWith -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (redefiningElement.oclIsKindOf(RedefinableTemplateSignature))
    * }}}
    */
  override def isConsistentWith(redefiningElement: Option[UMLRedefinableElement[Uml]]): Boolean = {
    // Start of user code for "isConsistentWith"
    ???
    // End of user code
  }

  /**
    * If any of the parent Classifiers are a template, then the extendedSignature must include the signature of that Classifier.
    *
    * <!-- Start of user code doc for validate_redefines_parents -->
    * <!-- End of user code doc for validate_redefines_parents -->
    *
    * {{{
    * OCL Body classifier.allParents()->forAll(c | c.ownedTemplateSignature->notEmpty() implies self->closure(extendedSignature)->includes(c.ownedTemplateSignature))
    * }}}
    */
  def validate_redefines_parents: Boolean = {
    // Start of user code for "redefines_parents"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLRedefinableTemplateSignatureOps
