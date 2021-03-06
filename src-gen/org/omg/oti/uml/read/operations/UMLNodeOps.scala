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
import scala.collection.immutable.Set
// End of user code

/**
  * A Node is computational resource upon which artifacts may be deployed for execution. Nodes can be interconnected through communication paths to define network structures.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLNodeOps[Uml <: UML] { self: UMLNode[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Nodes that are defined (nested) within the Node.
    *
    * <!-- Start of user code doc for nestedNode -->
    * <!-- End of user code doc for nestedNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNode.nestedNode_node
    */
  def nestedNode: Set[UMLNode[Uml]] = ownedMember.selectByKindOf { case x: UMLNode[Uml] => x }

  /**
    * <!-- Start of user code doc for nestedNode_node -->
    * <!-- End of user code doc for nestedNode_node -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNode.nestedNode
    */
  def nestedNode_node: Option[UMLNode[Uml]] = namespace.selectByKindOf { case x: UMLNode[Uml] => x }

  /**
    * The internal structure of a Node (if defined) consists solely of parts of type Node.
    *
    * <!-- Start of user code doc for validate_internal_structure -->
    * <!-- End of user code doc for validate_internal_structure -->
    *
    * {{{
    * OCL Body part->forAll(oclIsKindOf(Node))
    * }}}
    */
  def validate_internal_structure: Boolean = {
    // Start of user code for "internal_structure"
    part.forall {
                  case _: UMLNode[Uml] => true
                  case _               => false
                }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLNodeOps
