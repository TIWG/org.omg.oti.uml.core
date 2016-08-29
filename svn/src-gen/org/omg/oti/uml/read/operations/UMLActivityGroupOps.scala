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
import scala.{Option,None,Some}
import scala.collection.immutable.Set
// End of user code

/**
  * ActivityGroup is an abstract class for defining sets of ActivityNodes and ActivityEdges in an Activity.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActivityGroupOps[Uml <: UML] { self: UMLActivityGroup[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Activity containing the ActivityGroup, if it is directly owned by an Activity.
    *
    * <!-- Start of user code doc for inActivity -->
    * <!-- End of user code doc for inActivity -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivity.group
    */
  def inActivity: Option[UMLActivity[Uml]] = owner.selectByKindOf { case x: UMLActivity[Uml] => x }

  /**
    * Other ActivityGroups immediately contained in this ActivityGroup.
    *
    * <!-- Start of user code doc for subgroup -->
    * <!-- End of user code doc for subgroup -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityGroup.superGroup
    */
  def subgroup: Set[UMLActivityGroup[Uml]] = ownedElement.selectByKindOf { case x: UMLActivityGroup[Uml] => x }

  /**
    * The ActivityGroup immediately containing this ActivityGroup, if it is directly owned by another ActivityGroup.
    *
    * <!-- Start of user code doc for superGroup -->
    * <!-- End of user code doc for superGroup -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityGroup.subgroup
    */
  def superGroup: Option[UMLActivityGroup[Uml]] = owner.selectByKindOf { case x: UMLActivityGroup[Uml] => x }

  /**
    * The Activity that directly or indirectly contains this ActivityGroup.
    *
    * <!-- Start of user code doc for containingActivity -->
    * <!-- End of user code doc for containingActivity -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..1"
    * {{{
    * OCL Body result = (if superGroup<>null then superGroup.containingActivity()
    * else inActivity
    * endif)
    * }}}
    */
  def containingActivity: Option[UMLActivity[Uml]] = {
    // Start of user code for "containingActivity"
    superGroup match {
      case Some(sg) =>
        sg.containingActivity
      case None =>
        inActivity
    }
    // End of user code
  }

  /**
    * All containedNodes and containeEdges of an ActivityGroup must be in the same Activity as the group.
    *
    * <!-- Start of user code doc for validate_nodes_and_edges -->
    * <!-- End of user code doc for validate_nodes_and_edges -->
    *
    * {{{
    * OCL Body containedNode->forAll(activity = self.containingActivity()) and 
    * containedEdge->forAll(activity = self.containingActivity())
    * }}}
    */
  def validate_nodes_and_edges: Boolean = {
    // Start of user code for "nodes_and_edges"
    containedNode.forall { a => a.activity == self.containingActivity } &&
      containedEdge.forall { a => a.activity == self.containingActivity }
    // End of user code
  }

  /**
    * No containedNode or containedEdge of an ActivityGroup may be contained by its subgroups or its superGroups, transitively.
    *
    * <!-- Start of user code doc for validate_not_contained -->
    * <!-- End of user code doc for validate_not_contained -->
    *
    * {{{
    * OCL Body subgroup->closure(subgroup).containedNode->excludesAll(containedNode) and
    * superGroup->closure(superGroup).containedNode->excludesAll(containedNode) and 
    * subgroup->closure(subgroup).containedEdge->excludesAll(containedEdge) and 
    * superGroup->closure(superGroup).containedEdge->excludesAll(containedEdge)
    * }}}
    */
  def validate_not_contained: Boolean = {
    // Start of user code for "not_contained"
    val subGroups: Set[UMLActivityGroup[Uml]] =
      closure[UMLActivityGroup[Uml], UMLActivityGroup[Uml]]( self, sub => sub.subgroup + sub)
    val supGroups: Set[UMLActivityGroup[Uml]] =
      closure[UMLActivityGroup[Uml], UMLActivityGroup[Uml]]( self, sup => sup.superGroup.toSet + sup)
    val allGroups = subGroups ++ supGroups
    allGroups.forall(g => (g.containedNode & self.containedNode).isEmpty) &&
      allGroups.forall(g => (g.containedEdge & self.containedEdge).isEmpty)
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLActivityGroupOps
