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
 * A State models a situation during which some (usually implicit) invariant condition holds.
 * <!-- end-model-doc -->
 */
trait UMLState[Uml <: UML]
	extends UMLNamespace[Uml]
	with UMLRedefinableElement[Uml]
	with UMLVertex[Uml]
	with UMLStateOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The entry and exit connection points used in conjunction with this (submachine) State, i.e., as targets and sources, respectively, in the Region with the submachine State. A connection point reference references the corresponding definition of a connection point Pseudostate in the StateMachine referenced by the submachine State.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnectionPointReference.state
	 */
	def connection: Set[UMLConnectionPointReference[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The entry and exit Pseudostates of a composite State. These can only be entry or exit Pseudostates, and they must have different names. They can only be defined for composite States.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPseudostate.state
	 */
	def connectionPoint: Set[UMLPseudostate[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A list of Triggers that are candidates to be retained by the StateMachine if they trigger no Transitions out of the State (not consumed). A deferred Trigger is retained until the StateMachine reaches a State configuration where it is no longer deferred.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTrigger.deferrableTrigger_state
	 */
	def deferrableTrigger: Set[UMLTrigger[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * An optional Behavior that is executed while being in the State. The execution starts when this State is entered, and ceases either by itself when done, or when the State is exited, whichever comes first.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.doActivity_state
	 */
	def doActivity: Option[UMLBehavior[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * An optional Behavior that is executed whenever this State is entered regardless of the Transition taken to reach the State. If defined, entry Behaviors are always executed to completion prior to any internal Behavior or Transitions performed within the State.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.entry_state
	 */
	def entry: Option[UMLBehavior[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * An optional Behavior that is executed whenever this State is exited regardless of which Transition was taken out of the State. If defined, exit Behaviors are always executed to completion only after all internal and transition Behaviors have completed execution.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.exit_state
	 */
	def exit: Option[UMLBehavior[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A state with isComposite=true is said to be a composite State. A composite State is a State that contains at least one Region.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isComposite: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * A State with isOrthogonal=true is said to be an orthogonal composite State An orthogonal composite State contains two or more Regions.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isOrthogonal: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * A State with isSimple=true is said to be a simple State A simple State does not have any Regions and it does not refer to any submachine StateMachine.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isSimple: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * A State with isSubmachineState=true is said to be a submachine State Such a State refers to another StateMachine(submachine).
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isSubmachineState: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * The State of which this State is a redefinition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLState.redefinedState_state
	 */
	def redefinedState: Option[UMLState[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * References the Classifier in which context this element may be redefined.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLClassifier.redefinitionContext_state
	 */
	override def redefinitionContext: Iterable[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Regions owned directly by the State.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRegion.state
	 */
	def region: Set[UMLRegion[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies conditions that are always true when this State is the current State. In ProtocolStateMachines state invariants are additional conditions to the preconditions of the outgoing Transitions, and to the postcondition of the incoming Transitions.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConstraint.stateInvariant_owningState
	 */
	def stateInvariant: Option[UMLConstraint[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The StateMachine that is to be inserted in place of the (submachine) State.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStateMachine.submachineState
	 */
	def submachine: Option[UMLStateMachine[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLObjectNode.inState
	 */
	def inState_objectNode: Set[UMLObjectNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLState.redefinedState
	 */
	def redefinedState_state: Set[UMLState[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		state_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLState
	 */
	def state_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			namespace_metaAttributes,
			redefinableElement_metaAttributes,
			vertex_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		state_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLState
	 */
	def state_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namespace_compositeMetaProperties,
			redefinableElement_compositeMetaProperties,
			vertex_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLState[Uml], UMLConnectionPointReference[Uml]]("connection", _.connection),
				MetaPropertyCollection[Uml, UMLState[Uml], UMLPseudostate[Uml]]("connectionPoint", _.connectionPoint),
				MetaPropertyCollection[Uml, UMLState[Uml], UMLTrigger[Uml]]("deferrableTrigger", _.deferrableTrigger),
				MetaPropertyReference[Uml, UMLState[Uml], UMLBehavior[Uml]]("doActivity", _.doActivity),
				MetaPropertyReference[Uml, UMLState[Uml], UMLBehavior[Uml]]("entry", _.entry),
				MetaPropertyReference[Uml, UMLState[Uml], UMLBehavior[Uml]]("exit", _.exit),
				MetaPropertyCollection[Uml, UMLState[Uml], UMLRegion[Uml]]("region", _.region)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		state_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLState
	 */
	def state_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namespace_referenceMetaProperties,
			redefinableElement_referenceMetaProperties,
			vertex_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLState[Uml], UMLState[Uml]]("redefinedState", _.redefinedState),
				MetaPropertyReference[Uml, UMLState[Uml], UMLConstraint[Uml]]("stateInvariant", _.stateInvariant),
				MetaPropertyReference[Uml, UMLState[Uml], UMLStateMachine[Uml]]("submachine", _.submachine)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		state_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLState
	 */
	def state_forwardReferencesFromMetamodelAssociations: Elements =
		namespace_forwardReferencesFromMetamodelAssociations ++
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		vertex_forwardReferencesFromMetamodelAssociations ++
		redefinedState ++
		submachine 

} //UMLState
