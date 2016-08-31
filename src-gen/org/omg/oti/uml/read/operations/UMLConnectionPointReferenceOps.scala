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
  * A ConnectionPointReference represents a usage (as part of a submachine State) of an entry/exit point Pseudostate defined in the StateMachine referenced by the submachine State.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConnectionPointReferenceOps[Uml <: UML] { self: UMLConnectionPointReference[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The State in which the ConnectionPointReference is defined.
    *
    * <!-- Start of user code doc for state -->
    * <!-- End of user code doc for state -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLState.connection
    */
  def state: Option[UMLState[Uml]] = namespace.selectByKindOf { case x: UMLState[Uml] => x }

  /**
    * The entry Pseudostates must be Pseudostates with kind entryPoint.
    *
    * <!-- Start of user code doc for validate_entry_pseudostates -->
    * <!-- End of user code doc for validate_entry_pseudostates -->
    *
    * {{{
    * OCL Body entry->forAll(kind = PseudostateKind::entryPoint)
    * }}}
    */
  def validate_entry_pseudostates: Boolean = {
    // Start of user code for "entry_pseudostates"
    ???
    // End of user code
  }

  /**
    * The exit Pseudostates must be Pseudostates with kind exitPoint.
    *
    * <!-- Start of user code doc for validate_exit_pseudostates -->
    * <!-- End of user code doc for validate_exit_pseudostates -->
    *
    * {{{
    * OCL Body exit->forAll(kind = PseudostateKind::exitPoint)
    * }}}
    */
  def validate_exit_pseudostates: Boolean = {
    // Start of user code for "exit_pseudostates"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLConnectionPointReferenceOps
