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
  * A ForkNode is a ControlNode that splits a flow into multiple concurrent flows.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLForkNodeOps[Uml <: UML] { self: UMLForkNode[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The ActivityEdges incoming to and outgoing from a ForkNode must be either all ObjectFlows or all ControlFlows.
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
    (incoming ++ outgoing).forall {
                                    case _: UMLControlFlow[Uml] => true
                                    case _: UMLObjectFlow[Uml]  => true
                                    case _                      => false
                                  }
    // End of user code
  }

  /**
    * A ForkNode has one incoming ActivityEdge.
    *
    * <!-- Start of user code doc for validate_one_incoming_edge -->
    * <!-- End of user code doc for validate_one_incoming_edge -->
    *
    * {{{
    * OCL Body incoming->size()=1
    * }}}
    */
  def validate_one_incoming_edge: Boolean = {
    // Start of user code for "one_incoming_edge"
    1 == incoming.size
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLForkNodeOps
