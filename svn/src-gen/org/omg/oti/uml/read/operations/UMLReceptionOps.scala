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
import scala.Option
import scala.Predef.???
// End of user code

/**
  * A Reception is a declaration stating that a Classifier is prepared to react to the receipt of a Signal.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReceptionOps[Uml <: UML] { self: UMLReception[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for ownedReception_class -->
    * <!-- End of user code doc for ownedReception_class -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClass.ownedReception
    */
  def ownedReception_class: Option[UMLClass[Uml]] = featuringClassifier.selectByKindOf { case x: UMLClass[Uml] => x }

  /**
    * <!-- Start of user code doc for ownedReception_interface -->
    * <!-- End of user code doc for ownedReception_interface -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.ownedReception
    */
  def ownedReception_interface: Option[UMLInterface[Uml]] = featuringClassifier.selectByKindOf { case x: UMLInterface[Uml] => x }

  /**
    * A Reception has the same name as its signal
    *
    * <!-- Start of user code doc for validate_same_name_as_signal -->
    * <!-- End of user code doc for validate_same_name_as_signal -->
    *
    * {{{
    * OCL Body name = signal.name
    * }}}
    */
  def validate_same_name_as_signal: Boolean = {
    // Start of user code for "same_name_as_signal"
    ???
    // End of user code
  }

  /**
    * A Reception's parameters match the ownedAttributes of its signal by name, type, and multiplicity
    *
    * <!-- Start of user code doc for validate_same_structure_as_signal -->
    * <!-- End of user code doc for validate_same_structure_as_signal -->
    *
    * {{{
    * OCL Body signal.ownedAttribute->size() = ownedParameter->size() and
    * Sequence{1..signal.ownedAttribute->size()}->forAll( i | 
    *     ownedParameter->at(i).direction = ParameterDirectionKind::_'in' and 
    *     ownedParameter->at(i).name = signal.ownedAttribute->at(i).name and
    *     ownedParameter->at(i).type = signal.ownedAttribute->at(i).type and
    *     ownedParameter->at(i).lower() = signal.ownedAttribute->at(i).lower() and
    *     ownedParameter->at(i).upper() = signal.ownedAttribute->at(i).upper()
    * )
    * }}}
    */
  def validate_same_structure_as_signal: Boolean = {
    // Start of user code for "same_structure_as_signal"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReceptionOps
