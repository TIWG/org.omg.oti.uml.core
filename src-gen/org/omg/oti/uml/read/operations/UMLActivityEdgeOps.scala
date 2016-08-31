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
import scala.language.postfixOps
import scala.Boolean
import scala.{Option,Some}
import scala.collection.immutable.Set
// End of user code

/**
  * An ActivityEdge is an abstract class for directed connections between two ActivityNodes.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActivityEdgeOps[Uml <: UML] { self: UMLActivityEdge[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Activity containing the ActivityEdge, if it is directly owned by an Activity.
    *
    * <!-- Start of user code doc for activity -->
    * <!-- End of user code doc for activity -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivity.edge
    */
  def activity: Option[UMLActivity[Uml]] = owner.selectByKindOf { case x: UMLActivity[Uml] => x }

  /**
    * ActivityPartitions containing the ActivityEdge.
    *
    * <!-- Start of user code doc for inPartition -->
    * <!-- End of user code doc for inPartition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityPartition.edge
    */
  def inPartition: Set[UMLActivityPartition[Uml]] = inGroup.selectByKindOf { case x: UMLActivityPartition[Uml] => x }

  /**
    * The StructuredActivityNode containing the ActivityEdge, if it is owned by a StructuredActivityNode.
    *
    * <!-- Start of user code doc for inStructuredNode -->
    * <!-- End of user code doc for inStructuredNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuredActivityNode.edge
    */
  def inStructuredNode: Option[UMLStructuredActivityNode[Uml]] = inGroup.selectByKindOf { case x: UMLStructuredActivityNode[Uml] => x } headOption

  /**
    * ActivityEdges from a generalization of the Activity containing this ActivityEdge that are redefined by this ActivityEdge.
    *
    * <!-- Start of user code doc for redefinedEdge -->
    * <!-- End of user code doc for redefinedEdge -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityEdge.redefinedEdge_activityEdge
    */
  def redefinedEdge: Set[UMLActivityEdge[Uml]] = redefinedElement.selectByKindOf { case x: UMLActivityEdge[Uml] => x }

  /**
    * <!-- Start of user code doc for redefinedEdge_activityEdge -->
    * <!-- End of user code doc for redefinedEdge_activityEdge -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityEdge.redefinedEdge
    */
  def redefinedEdge_activityEdge: Set[UMLActivityEdge[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLActivityEdge[Uml] => x }

  /**
    * <!-- Start of user code doc for isConsistentWith -->
    * <!-- End of user code doc for isConsistentWith -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (redefiningElement.oclIsKindOf(ActivityEdge))
    * }}}
    */
  override def isConsistentWith(redefiningElement: Option[UMLRedefinableElement[Uml]]): Boolean = {
    // Start of user code for "isConsistentWith"
    redefiningElement.isInstanceOf[UMLActivityEdge[Uml]]
    // End of user code
  }

  /**
    * If an ActivityEdge is directly owned by an Activity, then its source and target must be directly or indirectly contained in the same Activity.
    *
    * <!-- Start of user code doc for validate_source_and_target -->
    * <!-- End of user code doc for validate_source_and_target -->
    *
    * {{{
    * OCL Body activity<>null implies source.containingActivity() = activity and target.containingActivity() = activity
    * }}}
    */
  def validate_source_and_target: Boolean = {
    // Start of user code for "source_and_target"
    if (activity.isDefined)
      (source, target) match {
        case (Some(s), Some(t)) => s.containingActivity == activity && t.containingActivity == activity
        case _                  => false
      }
    else
      true
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLActivityEdgeOps
