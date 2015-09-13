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
package org.omg.oti.uml.read.operations

// Start of user code for imports

import org.omg.oti.uml.read.api._

import scala.language.postfixOps

// End of user code

/**
 * An Activity is the specification of parameterized Behavior as the coordinated sequencing of subordinate units.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLActivityOps[Uml <: UML] { self: UMLActivity[Uml] =>

	import self.ops._

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
	 * }}}
	 * {{{
	 *    p.direction <> ParameterDirectionKind::inout implies node->select(
	 * }}}
	 * {{{
	 *        oclIsKindOf(ActivityParameterNode) and oclAsType(ActivityParameterNode).parameter = p)->size()= 1)
	 * }}}
	 */
	def validate_maximum_one_parameter_node: Boolean = {
		// Start of user code for "maximum_one_parameter_node"
    ownedParameter.forall {
                            p =>
                              if (p.direction != UMLParameterDirectionKind.inout) {
                                1 == node.count {
                                                  case apn: UMLActivityParameterNode[Uml] => apn.parameter.contains(p)
                                                  case _                                  => false
                                                }
                              } else
                                true
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
	 * }}}
	 * {{{
	 * p.direction = ParameterDirectionKind::inout implies
	 * }}}
	 * {{{
	 * let associatedNodes : Set(ActivityNode) = node->select(
	 * }}}
	 * {{{
	 *        oclIsKindOf(ActivityParameterNode) and oclAsType(ActivityParameterNode).parameter = p) in 
	 * }}}
	 * {{{
	 *   associatedNodes->size()=2 and
	 * }}}
	 * {{{
	 *   associatedNodes->select(incoming->notEmpty())->size()<=1 and
	 * }}}
	 * {{{
	 *   associatedNodes->select(outgoing->notEmpty())->size()<=1
	 * }}}
	 * {{{
	 * )
	 * }}}
	 */
	def validate_maximum_two_parameter_nodes: Boolean = {
		// Start of user code for "maximum_two_parameter_nodes"
    ownedParameter.forall { p =>
      if (p.direction == UMLParameterDirectionKind.inout) {
        val associatedNodes: Set[UMLActivityNode[Uml]] =
          node.filter {
                        case apn: UMLActivityParameterNode[Uml] => apn.parameter.contains(p)
                        case _                                  => false
                      }
        2 == associatedNodes.size &&
          1 >= associatedNodes.count { an => an.incoming.nonEmpty } &&
          1 >= associatedNodes.count { an => an.outgoing.nonEmpty }
      } else true
                          }
    // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLActivityOps
