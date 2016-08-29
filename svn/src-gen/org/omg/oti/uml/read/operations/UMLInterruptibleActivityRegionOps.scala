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
import scala.collection.immutable.Set
// End of user code

/**
  * An InterruptibleActivityRegion is an ActivityGroup that supports the termination of tokens flowing in the portions of an activity within it.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInterruptibleActivityRegionOps[Uml <: UML] { self: UMLInterruptibleActivityRegion[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * ActivityNodes immediately contained in the InterruptibleActivityRegion.
    *
    * <!-- Start of user code doc for node -->
    * <!-- End of user code doc for node -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityNode.inInterruptibleRegion
    */
  def node: Set[UMLActivityNode[Uml]] = containedNode

  /**
    * The interruptingEdges of an InterruptibleActivityRegion must have their source in the region and their target outside the region, but within the same Activity containing the region.
    *
    * <!-- Start of user code doc for validate_interrupting_edges -->
    * <!-- End of user code doc for validate_interrupting_edges -->
    *
    * {{{
    * OCL Body interruptingEdge->forAll(edge | 
    *   node->includes(edge.source) and node->excludes(edge.target) and edge.target.containingActivity() = inActivity)
    * }}}
    */
  def validate_interrupting_edges: Boolean = {
    // Start of user code for "interrupting_edges"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLInterruptibleActivityRegionOps
