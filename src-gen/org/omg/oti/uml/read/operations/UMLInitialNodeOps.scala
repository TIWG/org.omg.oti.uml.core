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
  * An InitialNode is a ControlNode that offers a single control token when initially enabled.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInitialNodeOps[Uml <: UML] { self: UMLInitialNode[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * All the outgoing ActivityEdges from an InitialNode must be ControlFlows.
    *
    * <!-- Start of user code doc for validate_control_edges -->
    * <!-- End of user code doc for validate_control_edges -->
    *
    * {{{
    * OCL Body outgoing->forAll(oclIsKindOf(ControlFlow))
    * }}}
    */
  def validate_control_edges: Boolean = {
    // Start of user code for "control_edges"
    ???
    // End of user code
  }

  /**
    * An InitialNode has no incoming ActivityEdges.
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
} //UMLInitialNodeOps
