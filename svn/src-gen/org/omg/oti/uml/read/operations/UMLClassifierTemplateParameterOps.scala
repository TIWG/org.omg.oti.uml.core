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
import scala.Boolean
import scala.None
import scala.Some
// End of user code

/**
  * A ClassifierTemplateParameter exposes a Classifier as a formal template parameter.
  *
  * <!-- Start of user code documentation --> 
  * <!-- End of user code documentation -->
  */
trait UMLClassifierTemplateParameterOps[Uml <: UML] { self: UMLClassifierTemplateParameter[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The argument to a ClassifierTemplateParameter is a Classifier.
    *
    * <!-- Start of user code doc for validate_actual_is_classifier -->
    * <!-- End of user code doc for validate_actual_is_classifier -->
    *
    * {{{
    * OCL Body  templateParameterSubstitution.actual->forAll(a | a.oclIsKindOf(Classifier))
    * }}}
    */
  def validate_actual_is_classifier: Boolean = {
    // Start of user code for "actual_is_classifier"
    formal_templateParameterSubstitution.forall(tps => tps.actual match {
      case Some(_: UMLClassifier[Uml]) => true
      case _                           => false
    })
    // End of user code
  }

  /**
    * If there are any constrainingClassifiers, then every argument must be the same as or a specialization of them, or if allowSubstitutable is true, then it can also be substitutable.
    *
    * <!-- Start of user code doc for validate_constraining_classifiers_constrain_args -->
    * <!-- End of user code doc for validate_constraining_classifiers_constrain_args -->
    *
    * {{{
    * OCL Body templateParameterSubstitution.actual->forAll( a |
    *   let arg : Classifier = a.oclAsType(Classifier) in
    *     constrainingClassifier->forAll(
    *       cc |  
    *          arg = cc or arg.conformsTo(cc) or (allowSubstitutable and arg.isSubstitutableFor(cc))
    *       )
    * )
    * }}}
    */
  def validate_constraining_classifiers_constrain_args: Boolean = {
    // Start of user code for "constraining_classifiers_constrain_args"
    formal_templateParameterSubstitution.forall(tps => tps.actual match {
      case Some(a: UMLClassifier[Uml]) =>
        constrainingClassifier.forall {
                                        cc =>
                                          a == cc ||
                                            a.conformsTo(Some(cc)) ||
                                            allowSubstitutable && a.isSubstitutableFor(Some(cc))
                                      }
      case _                           =>
        false
    })
    // End of user code
  }

  /**
    * If there are any constrainingClassifiers, then the parameteredElement must be the same as or a specialization of them, or if allowSubstitutable is true, then it can also be substitutable.
    *
    * <!-- Start of user code doc for validate_constraining_classifiers_constrain_parametered_element -->
    * <!-- End of user code doc for validate_constraining_classifiers_constrain_parametered_element -->
    *
    * {{{
    * OCL Body constrainingClassifier->forAll(
    *      cc |  parameteredElement = cc or parameteredElement.conformsTo(cc) or (allowSubstitutable and parameteredElement.isSubstitutableFor(cc))
    * )
    * }}}
    */
  def validate_constraining_classifiers_constrain_parametered_element: Boolean = {
    // Start of user code for "constraining_classifiers_constrain_parametered_element"
    parameteredElement match {
      case Some(pc) =>
        constrainingClassifier.forall {
                                        cc =>
                                          pc == cc ||
                                            pc.conformsTo(Some(cc)) ||
                                            allowSubstitutable && pc.isSubstitutableFor(Some(cc))
                                      }
      case None     =>
        true
    }
    // End of user code
  }

  /**
    * If allowSubstitutable is true, then there must be a constrainingClassifier.
    *
    * <!-- Start of user code doc for validate_has_constraining_classifier -->
    * <!-- End of user code doc for validate_has_constraining_classifier -->
    *
    * {{{
    * OCL Body allowSubstitutable implies constrainingClassifier->notEmpty()
    * }}}
    */
  def validate_has_constraining_classifier: Boolean = {
    // Start of user code for "has_constraining_classifier"
    !allowSubstitutable || constrainingClassifier.nonEmpty
    // End of user code
  }

  /**
    * If the parameteredElement is not abstract, then the Classifier used as an argument shall not be abstract.
    *
    * <!-- Start of user code doc for validate_matching_abstract -->
    * <!-- End of user code doc for validate_matching_abstract -->
    *
    * {{{
    * OCL Body (not parameteredElement.isAbstract) implies templateParameterSubstitution.actual->forAll(a | not a.oclAsType(Classifier).isAbstract)
    * }}}
    */
  def validate_matching_abstract: Boolean = {
    // Start of user code for "matching_abstract"
    parameteredElement match {
      case Some(pc) =>
        pc.isAbstract ||
          formal_templateParameterSubstitution.forall {
                                                        tps =>
                                                          tps.actual match {
                                                            case Some(a: UMLClassifier[Uml]) =>
                                                              !a.isAbstract
                                                            case _                           =>
                                                              true
                                                          }
                                                      }
      case None     =>
        true
    }
    // End of user code
  }

  /**
    * The parameteredElement has no direct features, and if constrainedElement is empty it has no generalizations.
    *
    * <!-- Start of user code doc for validate_parametered_element_no_features -->
    * <!-- End of user code doc for validate_parametered_element_no_features -->
    *
    * {{{
    * OCL Body parameteredElement.feature->isEmpty() and (constrainingClassifier->isEmpty() implies  parameteredElement.allParents()->isEmpty())
    * }}}
    */
  def validate_parametered_element_no_features: Boolean = {
    // Start of user code for "parametered_element_no_features"
    parameteredElement match {
      case Some(pc) =>
        pc.feature.nonEmpty || constrainingClassifier.nonEmpty || pc.allParents.isEmpty
      case None     =>
        true
    }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLClassifierTemplateParameterOps
