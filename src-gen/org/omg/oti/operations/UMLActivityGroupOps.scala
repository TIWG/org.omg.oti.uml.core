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
 * ActivityGroup is an abstract class for defining sets of ActivityNodes and ActivityEdges in an Activity.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLActivityGroupOps[Uml <: UML] { self: UMLActivityGroup[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Activity containing the ActivityGroup, if it is directly owned by an Activity.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivity.group
	 */
	def inActivity: Option[UMLActivity[Uml]] = owner.selectByKindOf { case x: UMLActivity[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * Other ActivityGroups immediately contained in this ActivityGroup.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityGroup.superGroup
	 */
	def subgroup: Set[UMLActivityGroup[Uml]] = ownedElement.selectByKindOf { case x: UMLActivityGroup[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The ActivityGroup immediately containing this ActivityGroup, if it is directly owned by another ActivityGroup.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivityGroup.subgroup
	 */
	def superGroup: Option[UMLActivityGroup[Uml]] = owner.selectByKindOf { case x: UMLActivityGroup[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The Activity that directly or indirectly contains this ActivityGroup.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..1"
	 * @body result = (if superGroup<>null then superGroup.containingActivity()
	 * else inActivity
	 * endif)
	 */
	def containingActivity: Option[UMLActivity[Uml]]  = {
		// Start of user code for "containingActivity"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * All containedNodes and containeEdges of an ActivityGroup must be in the same Activity as the group.
	 * <!-- end-model-doc -->
	 *
	 * @body containedNode->forAll(activity = self.containingActivity()) and 
	 * containedEdge->forAll(activity = self.containingActivity())
	 */
	def validate_nodes_and_edges: Boolean  = {
		// Start of user code for "nodes_and_edges"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * No containedNode or containedEdge of an ActivityGroup may be contained by its subgroups or its superGroups, transitively.
	 * <!-- end-model-doc -->
	 *
	 * @body subgroup->closure(subgroup).containedNode->excludesAll(containedNode) and
	 * superGroup->closure(superGroup).containedNode->excludesAll(containedNode) and 
	 * subgroup->closure(subgroup).containedEdge->excludesAll(containedEdge) and 
	 * superGroup->closure(superGroup).containedEdge->excludesAll(containedEdge)
	 */
	def validate_not_contained: Boolean  = {
		// Start of user code for "not_contained"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLActivityGroup
