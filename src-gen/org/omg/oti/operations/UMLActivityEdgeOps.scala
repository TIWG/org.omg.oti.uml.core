/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
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
package org.omg.oti.operations

// Start of user code for imports
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * <!-- begin-model-doc -->
 * An ActivityEdge is an abstract class for directed connections between two ActivityNodes.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLActivityEdgeOps[Uml <: UML] { self: UMLActivityEdge[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Activity containing the ActivityEdge, if it is directly owned by an Activity.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivity.edge
	 */
	def activity: Option[UMLActivity[Uml]] = owner.selectByKindOf { case x: UMLActivity[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * ActivityPartitions containing the ActivityEdge.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityPartition.edge
	 */
	def inPartition: Set[UMLActivityPartition[Uml]] = inGroup.selectByKindOf { case x: UMLActivityPartition[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The StructuredActivityNode containing the ActivityEdge, if it is owned by a StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStructuredActivityNode.edge
	 */
	def inStructuredNode: Option[UMLStructuredActivityNode[Uml]] = inGroup.selectByKindOf { case x: UMLStructuredActivityNode[Uml] => x } headOption

	/**
	 * <!-- begin-model-doc -->
	 * ActivityEdges from a generalization of the Activity containing this ActivityEdge that are redefined by this ActivityEdge.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.redefinedEdge_activityEdge
	 */
	def redefinedEdge: Set[UMLActivityEdge[Uml]] = redefinedElement.selectByKindOf { case x: UMLActivityEdge[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.redefinedEdge
	 */
	def redefinedEdge_activityEdge: Set[UMLActivityEdge[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLActivityEdge[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (redefiningElement.oclIsKindOf(ActivityEdge))
	 */
	override def isConsistentWith(redefiningElement: Option[UMLRedefinableElement[Uml]]): Boolean  = {
		// Start of user code for "isConsistentWith"
    	redefiningElement match {
        case Some(_ : UMLActivityEdge[Uml]) => true
        case _ => false
      }
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If an ActivityEdge is directly owned by an Activity, then its source and target must be directly or indirectly contained in the same Activity.
	 * <!-- end-model-doc -->
	 *
	 * @body activity<>null implies source.containingActivity() = activity and target.containingActivity() = activity
	 */
	def validate_source_and_target: Boolean  = {
		// Start of user code for "source_and_target"
    activity match {
      case None => true
      case Some(a) => source match {
        case None => true
        case Some(s) => s.containingActivity match {
          case None => true
          case Some(sAct) => target match {
            case None => true
            case Some(t) => t.containingActivity match {
              case None => true
              case Some(tAct) => sAct == a && tAct == a
            }
          }
        } 
      }
    }
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLActivityEdge
