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
// End of user code

/**
  * A FinalNode is an abstract ControlNode at which a flow in an Activity stops.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLFinalNodeOps[Uml <: UML] { self: UMLFinalNode[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * A FinalNode has no outgoing ActivityEdges.
    *
    * <!-- Start of user code doc for validate_no_outgoing_edges -->
    * <!-- End of user code doc for validate_no_outgoing_edges -->
    *
    * {{{
    * OCL Body outgoing->isEmpty()
    * }}}
    */
  def validate_no_outgoing_edges: Boolean = {
    // Start of user code for "no_outgoing_edges"
      outgoing.isEmpty
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLFinalNodeOps
