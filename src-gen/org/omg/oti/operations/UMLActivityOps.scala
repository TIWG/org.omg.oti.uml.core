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
 * An Activity is the specification of parameterized Behavior as the coordinated sequencing of subordinate units.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLActivityOps[Uml <: UML] { self: UMLActivity[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * ActivityEdges expressing flow between the nodes of the Activity.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.activity
	 */
	def edge: Set[UMLActivityEdge[Uml]] = ownedElement.selectByKindOf { case x: UMLActivityEdge[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * Top-level ActivityGroups in the Activity.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityGroup.inActivity
	 */
	def group: Set[UMLActivityGroup[Uml]] = ownedElement.selectByKindOf { case x: UMLActivityGroup[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * ActivityNodes coordinated by the Activity.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityNode.activity
	 */
	def node: Set[UMLActivityNode[Uml]] = ownedElement.selectByKindOf { case x: UMLActivityNode[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * Top-level Variables defined by the Activity.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLVariable.activityScope
	 */
	def variable: Set[UMLVariable[Uml]] = ownedMember.selectByKindOf { case x: UMLVariable[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * A Parameter with direction other than inout must have exactly one ActivityParameterNode in an Activity.
	 * <!-- end-model-doc -->
	 *
	 * @body ownedParameter->forAll(p | 
	 *    p.direction <> ParameterDirectionKind::inout implies node->select(
	 *        oclIsKindOf(ActivityParameterNode) and oclAsType(ActivityParameterNode).parameter = p)->size()= 1)
	 */
	def validate_maximum_one_parameter_node: Boolean  = {
		// Start of user code for "maximum_one_parameter_node"
    ??? //error... need another case?
//    ownedParameter.forall { p => p.direction match {
//        case _: UMLParameterDirectionKind.inout => true
//        case _ => node.filter { n => 
//            n match {
//              case nd : UMLActivityParameterNode[Uml] => nd.parameter == p
//            }
//          }.size == 1
//      }
//    }
    
    ??? //if okay?
    ownedParameter.forall { p => 
        if ( p.direction != UMLParameterDirectionKind.inout ) {
          node.filter { n => 
            n match {
              case nd : UMLActivityParameterNode[Uml] => nd.parameter == p
            }
          }.size == 1  
        } else true
      } 
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A Parameter with direction inout must have exactly two ActivityParameterNodes in an Activity, at most one with incoming ActivityEdges and at most one with outgoing ActivityEdges.
	 * <!-- end-model-doc -->
	 *
	 * @body ownedParameter->forAll(p | 
	 * p.direction = ParameterDirectionKind::inout implies
	 * let associatedNodes : Set(ActivityNode) = node->select(
	 *        oclIsKindOf(ActivityParameterNode) and oclAsType(ActivityParameterNode).parameter = p) in 
	 *   associatedNodes->size()=2 and
	 *   associatedNodes->select(incoming->notEmpty())->size()<=1 and
	 *   associatedNodes->select(outgoing->notEmpty())->size()<=1
	 * )
	 */
	def validate_maximum_two_parameter_nodes: Boolean  = {
		// Start of user code for "maximum_two_parameter_nodes"
    ??? //see method above
    ownedParameter.forall { p => 
      if (p.direction == UMLParameterDirectionKind.inout) {
        var associatedNodes: Set[UMLActivityNode[Uml]] = 
          node.filter { n => 
            n.isInstanceOf[UMLActivityParameterNode[Uml]] && 
            n.asInstanceOf[UMLActivityParameterNode[Uml]].parameter == Some(p) }
        associatedNodes.size == 2 && 
        associatedNodes.filter { an => !an.incoming.isEmpty }.size <= 1 &&
        associatedNodes.filter { an => !an.outgoing.isEmpty }.size <= 1
      } else true
    }
  	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLActivity
