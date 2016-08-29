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
  * A ControlFlow is an ActivityEdge traversed by control tokens or object tokens of control type, which are use to control the execution of ExecutableNodes.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLControlFlowOps[Uml <: UML] { self: UMLControlFlow[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * ControlFlows may not have ObjectNodes at either end, except for ObjectNodes with control type.
    *
    * <!-- Start of user code doc for validate_object_nodes -->
    * <!-- End of user code doc for validate_object_nodes -->
    *
    * {{{
    * OCL Body (source.oclIsKindOf(ObjectNode) implies source.oclAsType(ObjectNode).isControlType) and 
    * (target.oclIsKindOf(ObjectNode) implies target.oclAsType(ObjectNode).isControlType)
    * }}}
    */
  def validate_object_nodes: Boolean = {
    // Start of user code for "object_nodes"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLControlFlowOps
