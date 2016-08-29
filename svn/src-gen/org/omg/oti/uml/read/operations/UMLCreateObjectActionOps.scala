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
// End of user code

/**
  * A CreateObjectAction is an Action that creates an instance of the specified Classifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCreateObjectActionOps[Uml <: UML] { self: UMLCreateObjectAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The OutputPin on which the newly created object is placed.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_createObjectAction
    */
  def result: Option[UMLOutputPin[Uml]] = output headOption

  /**
    * The classifier cannot be abstract.
    *
    * <!-- Start of user code doc for validate_classifier_not_abstract -->
    * <!-- End of user code doc for validate_classifier_not_abstract -->
    *
    * {{{
    * OCL Body not classifier.isAbstract 
    * }}}
    */
  def validate_classifier_not_abstract: Boolean = {
    // Start of user code for "classifier_not_abstract"
    ???
    // End of user code
  }

  /**
    * The classifier cannot be an AssociationClass.
    *
    * <!-- Start of user code doc for validate_classifier_not_association_class -->
    * <!-- End of user code doc for validate_classifier_not_association_class -->
    *
    * {{{
    * OCL Body not classifier.oclIsKindOf(AssociationClass)
    * }}}
    */
  def validate_classifier_not_association_class: Boolean = {
    // Start of user code for "classifier_not_association_class"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the result OutputPin is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity -->
    * <!-- End of user code doc for validate_multiplicity -->
    *
    * {{{
    * OCL Body result.is(1,1)
    * }}}
    */
  def validate_multiplicity: Boolean = {
    // Start of user code for "multiplicity"
    ???
    // End of user code
  }

  /**
    * The type of the result OutputPin must be the same as the classifier of the CreateObjectAction.
    *
    * <!-- Start of user code doc for validate_same_type -->
    * <!-- End of user code doc for validate_same_type -->
    *
    * {{{
    * OCL Body result.type = classifier
    * }}}
    */
  def validate_same_type: Boolean = {
    // Start of user code for "same_type"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLCreateObjectActionOps
