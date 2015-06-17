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
package org.omg.oti.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.operations._
// End of user code

/**
 * StateMachines can be used to express event-driven behaviors of parts of a system. Behavior is modeled as a traversal of a graph of Vertices interconnected by one or more joined Transition arcs that are triggered by the dispatching of successive Event occurrences. During this traversal, the StateMachine may execute a sequence of Behaviors associated with various elements of the StateMachine.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLStateMachine[Uml <: UML]
	extends UMLBehavior[Uml]
	with UMLStateMachineOps[Uml] {
	
	import ops._

	/**
	 * References the submachine(s) in case of a submachine State. Multiple machines are referenced in case of a concurrent State.
	 *
	 * <!-- Start of user code doc for submachineState -->
	 * <!-- End of user code doc for submachineState -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLState.submachine
	 */
	def submachineState: Set[UMLState[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		stateMachine_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStateMachine
	 *
	 * <!-- Start of user code doc for stateMachine_metaAttributes -->
	 * <!-- End of user code doc for stateMachine_metaAttributes -->
	 */
	def stateMachine_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			behavior_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		stateMachine_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStateMachine
	 *
	 * <!-- Start of user code doc for stateMachine_compositeMetaProperties -->
	 * <!-- End of user code doc for stateMachine_compositeMetaProperties -->
	 */
	def stateMachine_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavior_compositeMetaProperties,
			Seq (StateMachine_connectionPoint,
				StateMachine_region))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		stateMachine_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStateMachine
	 *
	 * <!-- Start of user code doc for stateMachine_referenceMetaProperties -->
	 * <!-- End of user code doc for stateMachine_referenceMetaProperties -->
	 */
	def stateMachine_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavior_referenceMetaProperties,
			Seq (StateMachine_extendedStateMachine,
				StateMachine_submachineState))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		stateMachine_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStateMachine
	 *
	 * <!-- Start of user code doc for stateMachine_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for stateMachine_forwardReferencesFromMetamodelAssociations -->
	 */
	def stateMachine_forwardReferencesFromMetamodelAssociations: Elements =
		behavior_forwardReferencesFromMetamodelAssociations ++
		extendedStateMachine ++
		submachineState 

	// Start of user code for additional features
	// End of user code
} //UMLStateMachine
