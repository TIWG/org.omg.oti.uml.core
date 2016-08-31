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
  * A merge node is a control node that brings together multiple alternate flows. It is not used to synchronize concurrent flows but to accept one among several alternate flows.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLMergeNodeOps[Uml <: UML] { self: UMLMergeNode[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The ActivityEdges incoming to and outgoing from a MergeNode must be either all ObjectFlows or all ControlFlows.
    *
    * <!-- Start of user code doc for validate_edges -->
    * <!-- End of user code doc for validate_edges -->
    *
    * {{{
    * OCL Body let allEdges : Set(ActivityEdge) = incoming->union(outgoing) in
    * allEdges->forAll(oclIsKindOf(ControlFlow)) or allEdges->forAll(oclIsKindOf(ObjectFlow))
    * }}}
    */
  def validate_edges: Boolean = {
    // Start of user code for "edges"
    ???
    // End of user code
  }

  /**
    * A MergeNode has one outgoing ActivityEdge.
    *
    * <!-- Start of user code doc for validate_one_outgoing_edge -->
    * <!-- End of user code doc for validate_one_outgoing_edge -->
    *
    * {{{
    * OCL Body outgoing->size()=1
    * }}}
    */
  def validate_one_outgoing_edge: Boolean = {
    // Start of user code for "one_outgoing_edge"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLMergeNodeOps
