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
  * ActivityNode is an abstract class for points in the flow of an Activity connected by ActivityEdges.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActivityNodeOps[Uml <: UML] { self: UMLActivityNode[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Activity containing the ActivityNode, if it is directly owned by an Activity.
    *
    * <!-- Start of user code doc for activity -->
    * <!-- End of user code doc for activity -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivity.node
    */
  def activity: Option[UMLActivity[Uml]] = owner.selectByKindOf { case x: UMLActivity[Uml] => x }

  /**
    * InterruptibleActivityRegions containing the ActivityNode.
    *
    * <!-- Start of user code doc for inInterruptibleRegion -->
    * <!-- End of user code doc for inInterruptibleRegion -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterruptibleActivityRegion.node
    */
  def inInterruptibleRegion: Set[UMLInterruptibleActivityRegion[Uml]] = inGroup.selectByKindOf { case x: UMLInterruptibleActivityRegion[Uml] => x }

  /**
    * ActivityPartitions containing the ActivityNode.
    *
    * <!-- Start of user code doc for inPartition -->
    * <!-- End of user code doc for inPartition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityPartition.node
    */
  def inPartition: Set[UMLActivityPartition[Uml]] = inGroup.selectByKindOf { case x: UMLActivityPartition[Uml] => x }

  /**
    * The StructuredActivityNode containing the ActvityNode, if it is directly owned by a StructuredActivityNode.
    *
    * <!-- Start of user code doc for inStructuredNode -->
    * <!-- End of user code doc for inStructuredNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuredActivityNode.node
    */
  def inStructuredNode: Option[UMLStructuredActivityNode[Uml]] = inGroup.selectByKindOf { case x: UMLStructuredActivityNode[Uml] => x } headOption

  /**
    * ActivityNodes from a generalization of the Activity containining this ActivityNode that are redefined by this ActivityNode.
    *
    * <!-- Start of user code doc for redefinedNode -->
    * <!-- End of user code doc for redefinedNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityNode.redefinedNode_activityNode
    */
  def redefinedNode: Set[UMLActivityNode[Uml]] = redefinedElement.selectByKindOf { case x: UMLActivityNode[Uml] => x }

  /**
    * <!-- Start of user code doc for redefinedNode_activityNode -->
    * <!-- End of user code doc for redefinedNode_activityNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityNode.redefinedNode
    */
  def redefinedNode_activityNode: Set[UMLActivityNode[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLActivityNode[Uml] => x }

  /**
    * The Activity that directly or indirectly contains this ActivityNode.
    *
    * <!-- Start of user code doc for containingActivity -->
    * <!-- End of user code doc for containingActivity -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..1"
    * {{{
    * OCL Body result = (if inStructuredNode<>null then inStructuredNode.containingActivity()
    * else activity
    * endif)
    * }}}
    */
  def containingActivity: Option[UMLActivity[Uml]] = {
    // Start of user code for "containingActivity"
    if (inStructuredNode.isDefined)
      inStructuredNode.get.containingActivity
    else
      activity
    // End of user code
  }

  /**
    * <!-- Start of user code doc for isConsistentWith -->
    * <!-- End of user code doc for isConsistentWith -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (redefiningElement.oclIsKindOf(ActivityNode))
    * }}}
    */
  override def isConsistentWith(redefiningElement: Option[UMLRedefinableElement[Uml]]): Boolean = {
    // Start of user code for "isConsistentWith"
    redefiningElement match {
      case Some(_: UMLActivityNode[Uml]) => true
      case _                             => false
    }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLActivityNodeOps
