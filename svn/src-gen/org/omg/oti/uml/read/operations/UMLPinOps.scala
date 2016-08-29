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
import scala.Predef.???
// End of user code

/**
  * A Pin is an ObjectNode and MultiplicityElement that provides input values to an Action or accepts output values from an Action.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPinOps[Uml <: UML] { self: UMLPin[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * A control Pin has a control type.
    *
    * <!-- Start of user code doc for validate_control_pins -->
    * <!-- End of user code doc for validate_control_pins -->
    *
    * {{{
    * OCL Body isControl implies isControlType
    * }}}
    */
  def validate_control_pins: Boolean = {
    // Start of user code for "control_pins"
    ???
    // End of user code
  }

  /**
    * Pin multiplicity is not unique.
    *
    * <!-- Start of user code doc for validate_not_unique -->
    * <!-- End of user code doc for validate_not_unique -->
    *
    * {{{
    * OCL Body not isUnique
    * }}}
    */
  def validate_not_unique: Boolean = {
    // Start of user code for "not_unique"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLPinOps
