/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.{Option,None,Some}
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
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
