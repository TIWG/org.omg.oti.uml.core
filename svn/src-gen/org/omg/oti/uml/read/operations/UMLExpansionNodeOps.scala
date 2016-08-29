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
  * An ExpansionNode is an ObjectNode used to indicate a collection input or output for an ExpansionRegion. A collection input of an ExpansionRegion contains a collection that is broken into its individual elements inside the region, whose content is executed once per element. A collection output of an ExpansionRegion combines individual elements produced by the execution of the region into a collection for use outside the region.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExpansionNodeOps[Uml <: UML] { self: UMLExpansionNode[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * One of regionAsInput or regionAsOutput must be non-empty, but not both.
    *
    * <!-- Start of user code doc for validate_region_as_input_or_output -->
    * <!-- End of user code doc for validate_region_as_input_or_output -->
    *
    * {{{
    * OCL Body regionAsInput->notEmpty() xor regionAsOutput->notEmpty()
    * }}}
    */
  def validate_region_as_input_or_output: Boolean = {
    // Start of user code for "region_as_input_or_output"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLExpansionNodeOps
