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
import scala.collection.immutable.Set
// End of user code

/**
  * An Activity is the specification of parameterized Behavior as the coordinated sequencing of subordinate units.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActivityOps[Uml <: UML] { self: UMLActivity[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * ActivityEdges expressing flow between the nodes of the Activity.
    *
    * <!-- Start of user code doc for edge -->
    * <!-- End of user code doc for edge -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityEdge.activity
    */
  def edge: Set[UMLActivityEdge[Uml]] = ownedElement.selectByKindOf { case x: UMLActivityEdge[Uml] => x }

  /**
    * Top-level ActivityGroups in the Activity.
    *
    * <!-- Start of user code doc for group -->
    * <!-- End of user code doc for group -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityGroup.inActivity
    */
  def group: Set[UMLActivityGroup[Uml]] = ownedElement.selectByKindOf { case x: UMLActivityGroup[Uml] => x }

  /**
    * ActivityNodes coordinated by the Activity.
    *
    * <!-- Start of user code doc for node -->
    * <!-- End of user code doc for node -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityNode.activity
    */
  def node: Set[UMLActivityNode[Uml]] = ownedElement.selectByKindOf { case x: UMLActivityNode[Uml] => x }

  /**
    * Top-level StructuredActivityNodes in the Activity.
    *
    * <!-- Start of user code doc for structuredNode -->
    * <!-- End of user code doc for structuredNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuredActivityNode.activity
    */
  def structuredNode: Set[UMLStructuredActivityNode[Uml]] = group.selectByKindOf { case x: UMLStructuredActivityNode[Uml] => x }

  /**
    * Top-level Variables defined by the Activity.
    *
    * <!-- Start of user code doc for variable -->
    * <!-- End of user code doc for variable -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLVariable.activityScope
    */
  def variable: Set[UMLVariable[Uml]] = ownedMember.selectByKindOf { case x: UMLVariable[Uml] => x }

  /**
    * A Parameter with direction other than inout must have exactly one ActivityParameterNode in an Activity.
    *
    * <!-- Start of user code doc for validate_maximum_one_parameter_node -->
    * <!-- End of user code doc for validate_maximum_one_parameter_node -->
    *
    * {{{
    * OCL Body ownedParameter->forAll(p | 
    *    p.direction <> ParameterDirectionKind::inout implies node->select(
    *        oclIsKindOf(ActivityParameterNode) and oclAsType(ActivityParameterNode).parameter = p)->size()= 1)
    * }}}
    */
  def validate_maximum_one_parameter_node: Boolean = {
    // Start of user code for "maximum_one_parameter_node"
    ownedParameter.forall { p =>
      p.direction.fold[Boolean](true) { dir =>
        if (dir != UMLParameterDirectionKind.inout) {
          1 == node.count {
            case apn: UMLActivityParameterNode[Uml] =>
              apn.parameter.contains(p)
            case _ =>
              false
          }
        } else
          true
      }
    }
    // End of user code
  }

  /**
    * A Parameter with direction inout must have exactly two ActivityParameterNodes in an Activity, at most one with incoming ActivityEdges and at most one with outgoing ActivityEdges.
    *
    * <!-- Start of user code doc for validate_maximum_two_parameter_nodes -->
    * <!-- End of user code doc for validate_maximum_two_parameter_nodes -->
    *
    * {{{
    * OCL Body ownedParameter->forAll(p | 
    * p.direction = ParameterDirectionKind::inout implies
    * let associatedNodes : Set(ActivityNode) = node->select(
    *        oclIsKindOf(ActivityParameterNode) and oclAsType(ActivityParameterNode).parameter = p) in 
    *   associatedNodes->size()=2 and
    *   associatedNodes->select(incoming->notEmpty())->size()<=1 and
    *   associatedNodes->select(outgoing->notEmpty())->size()<=1
    * )
    * }}}
    */
  def validate_maximum_two_parameter_nodes: Boolean = {
    // Start of user code for "maximum_two_parameter_nodes"
    ownedParameter.forall { p =>
      p.direction.fold[Boolean](true) { dir =>
        if (dir == UMLParameterDirectionKind.inout) {
          val associatedNodes: Set[UMLActivityNode[Uml]] =
            node.filter {
              case apn: UMLActivityParameterNode[Uml] =>
                apn.parameter.contains(p)
              case _ =>
                false
            }
          2 == associatedNodes.size &&
            1 >= associatedNodes.count { an => an.incoming.nonEmpty } &&
            1 >= associatedNodes.count { an => an.outgoing.nonEmpty }
        } else true
      }
    }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLActivityOps
