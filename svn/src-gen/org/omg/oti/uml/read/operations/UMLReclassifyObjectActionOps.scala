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
  * A ReclassifyObjectAction is an Action that changes the Classifiers that classify an object.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReclassifyObjectActionOps[Uml <: UML] { self: UMLReclassifyObjectAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The InputPin that holds the object to be reclassified.
    *
    * <!-- Start of user code doc for _object -->
    * <!-- End of user code doc for _object -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.object_reclassifyObjectAction
    */
  def _object: Option[UMLInputPin[Uml]] = input headOption

  /**
    * None of the newClassifiers may be abstract.
    *
    * <!-- Start of user code doc for validate_classifier_not_abstract -->
    * <!-- End of user code doc for validate_classifier_not_abstract -->
    *
    * {{{
    * OCL Body not newClassifier->exists(isAbstract)
    * }}}
    */
  def validate_classifier_not_abstract: Boolean = {
    // Start of user code for "classifier_not_abstract"
    ???
    // End of user code
  }

  /**
    * The object InputPin has no type.
    *
    * <!-- Start of user code doc for validate_input_pin -->
    * <!-- End of user code doc for validate_input_pin -->
    *
    * {{{
    * OCL Body object.type = null
    * }}}
    */
  def validate_input_pin: Boolean = {
    // Start of user code for "input_pin"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the object InputPin is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity -->
    * <!-- End of user code doc for validate_multiplicity -->
    *
    * {{{
    * OCL Body object.is(1,1)
    * }}}
    */
  def validate_multiplicity: Boolean = {
    // Start of user code for "multiplicity"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReclassifyObjectActionOps
