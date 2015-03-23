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
 * <!-- begin-model-doc -->
 * StateMachines can be used to express event-driven behaviors of parts of a system. Behavior is modeled as a traversal of a graph of Vertices interconnected by one or more joined Transition arcs that are triggered by the dispatching of successive Event occurrences. During this traversal, the StateMachine may execute a sequence of Behaviors associated with various elements of the StateMachine.
 * <!-- end-model-doc -->
 */
trait UMLStateMachine[Uml <: UML]
	extends UMLBehavior[Uml]
	with UMLStateMachineOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The connection points defined for this StateMachine. They represent the interface of the StateMachine when used as part of submachine State
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPseudostate.stateMachine
	 */
	def connectionPoint: Set[UMLPseudostate[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The StateMachines of which this is an extension.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLStateMachine.extendedStateMachine_stateMachine
	 */
	def extendedStateMachine: Set[UMLStateMachine[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Regions owned directly by the StateMachine.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLRegion.stateMachine
	 */
	def region: Set[UMLRegion[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * References the submachine(s) in case of a submachine State. Multiple machines are referenced in case of a concurrent State.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLState.submachine
	 */
	def submachineState: Set[UMLState[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLStateMachine.extendedStateMachine
	 */
	def extendedStateMachine_stateMachine: Set[UMLStateMachine[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		stateMachine_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStateMachine
	 */
	def stateMachine_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			behavior_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		stateMachine_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStateMachine
	 */
	def stateMachine_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavior_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLStateMachine[Uml], UMLPseudostate[Uml]]("connectionPoint", _.connectionPoint),
				MetaPropertyCollection[Uml, UMLStateMachine[Uml], UMLRegion[Uml]]("region", _.region)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		stateMachine_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStateMachine
	 */
	def stateMachine_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavior_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLStateMachine[Uml], UMLStateMachine[Uml]]("extendedStateMachine", _.extendedStateMachine),
				MetaPropertyCollection[Uml, UMLStateMachine[Uml], UMLState[Uml]]("submachineState", _.submachineState)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		stateMachine_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStateMachine
	 */
	def stateMachine_forwardReferencesFromMetamodelAssociations: Elements =
		behavior_forwardReferencesFromMetamodelAssociations ++
		extendedStateMachine ++
		submachineState 

} //UMLStateMachine
