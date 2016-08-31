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
  * A ValuePin is an InputPin that provides a value by evaluating a ValueSpecification.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLValuePinOps[Uml <: UML] { self: UMLValuePin[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The type of the value ValueSpecification must conform to the type of the ValuePin.
    *
    * <!-- Start of user code doc for validate_compatible_type -->
    * <!-- End of user code doc for validate_compatible_type -->
    *
    * {{{
    * OCL Body value.type.conformsTo(type)
    * }}}
    */
  def validate_compatible_type: Boolean = {
    // Start of user code for "compatible_type"
    ???
    // End of user code
  }

  /**
    * A ValuePin may have no incoming ActivityEdges.
    *
    * <!-- Start of user code doc for validate_no_incoming_edges -->
    * <!-- End of user code doc for validate_no_incoming_edges -->
    *
    * {{{
    * OCL Body incoming->isEmpty()
    * }}}
    */
  def validate_no_incoming_edges: Boolean = {
    // Start of user code for "no_incoming_edges"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLValuePinOps
