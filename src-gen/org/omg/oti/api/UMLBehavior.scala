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
 * Behavior is a specification of how its context BehavioredClassifier changes state over time. This specification may be either a definition of possible behavior execution or emergent behavior, or a selective illustration of an interesting subset of possible executions. The latter form is typically used for capturing examples, such as a trace of a particular execution.
 * <!-- end-model-doc -->
 */
trait UMLBehavior[Uml <: UML]
	extends UMLClass[Uml]
	with UMLBehaviorOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The BehavioredClassifier that is the context for the execution of the Behavior. A Behavior that is directly owned as a nestedClassifier does not have a context. Otherwise, to determine the context of a Behavior, find the first BehavioredClassifier reached by following the chain of owner relationships from the Behavior, if any. If there is such a BehavioredClassifier, then it is the context, unless it is itself a Behavior with a non-empty context, in which case that is also the context for the original Behavior. For example, following this algorithm, the context of an entry Behavior in a StateMachine is the BehavioredClassifier that owns the StateMachine. The features of the context BehavioredClassifier as well as the Elements visible to the context Classifier are visible to the Behavior.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavioredClassifier.context_behavior
	 */
	def context: Option[UMLBehavioredClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Tells whether the Behavior can be invoked while it is still executing from a previous invocation.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isReentrant: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * References a list of Parameters to the Behavior which describes the order and type of arguments that can be given when the Behavior is invoked and of the values which will be returned when the Behavior completes its execution.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLParameter.ownedParameter_behavior
	 */
	def ownedParameter: Seq[UMLParameter[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ParameterSets owned by this Behavior.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLParameterSet.ownedParameterSet_behavior
	 */
	def ownedParameterSet: Set[UMLParameterSet[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * An optional set of Constraints specifying what is fulfilled after the execution of the Behavior is completed, if its precondition was fulfilled before its invocation.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConstraint.postcondition_behavior
	 */
	def postcondition: Set[UMLConstraint[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * An optional set of Constraints specifying what must be fulfilled before the Behavior is invoked.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConstraint.precondition_behavior
	 */
	def precondition: Set[UMLConstraint[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * References the Behavior that this Behavior redefines. A subtype of Behavior may redefine any other subtype of Behavior. If the Behavior implements a BehavioralFeature, it replaces the redefined Behavior. If the Behavior is a classifierBehavior, it extends the redefined Behavior.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLBehavior.redefinedBehavior_behavior
	 */
	def redefinedBehavior: Set[UMLBehavior[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Designates a BehavioralFeature that the Behavior implements. The BehavioralFeature must be owned by the BehavioredClassifier that owns the Behavior or be inherited by it. The Parameters of the BehavioralFeature and the implementing Behavior must match. A Behavior does not need to have a specification, in which case it either is the classifierBehavior of a BehavioredClassifier or it can only be invoked by another Behavior of the Classifier.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavioralFeature.method
	 */
	def specification: Option[UMLBehavioralFeature[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLBehaviorExecutionSpecification.behavior
	 */
	def behavior_behaviorExecutionSpecification: Set[UMLBehaviorExecutionSpecification[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLCallBehaviorAction.behavior
	 */
	def behavior_callBehaviorAction: Set[UMLCallBehaviorAction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOpaqueExpression.behavior
	 */
	def behavior_opaqueExpression: Set[UMLOpaqueExpression[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavioredClassifier.classifierBehavior
	 */
	def classifierBehavior_behavioredClassifier: Option[UMLBehavioredClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnector.contract
	 */
	def contract_connector: Set[UMLConnector[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDecisionNode.decisionInput
	 */
	def decisionInput_decisionNode: Set[UMLDecisionNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLState.doActivity
	 */
	def doActivity_state: Option[UMLState[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLTransition.effect
	 */
	def effect_transition: Option[UMLTransition[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLState.entry
	 */
	def entry_state: Option[UMLState[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLState.exit
	 */
	def exit_state: Option[UMLState[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavioredClassifier.ownedBehavior
	 */
	def ownedBehavior_behavioredClassifier: Option[UMLBehavioredClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLBehavior.redefinedBehavior
	 */
	def redefinedBehavior_behavior: Set[UMLBehavior[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLReduceAction.reducer
	 */
	def reducer_reduceAction: Set[UMLReduceAction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLObjectFlow.selection
	 */
	def selection_objectFlow: Set[UMLObjectFlow[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLObjectNode.selection
	 */
	def selection_objectNode: Set[UMLObjectNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLObjectFlow.transformation
	 */
	def transformation_objectFlow: Set[UMLObjectFlow[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		behavior_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLBehavior
	 */
	def behavior_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			class_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLBehavior[Uml]](None, "isReentrant", (x) => booleanToIterable(x.isReentrant, true))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		behavior_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLBehavior
	 */
	def behavior_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			class_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLBehavior[Uml], UMLParameter[Uml]]("ownedParameter", _.ownedParameter),
				MetaPropertyCollection[Uml, UMLBehavior[Uml], UMLParameterSet[Uml]]("ownedParameterSet", _.ownedParameterSet),
				MetaPropertyCollection[Uml, UMLBehavior[Uml], UMLConstraint[Uml]]("postcondition", _.postcondition),
				MetaPropertyCollection[Uml, UMLBehavior[Uml], UMLConstraint[Uml]]("precondition", _.precondition)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		behavior_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLBehavior
	 */
	def behavior_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			class_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLBehavior[Uml], UMLBehavior[Uml]]("redefinedBehavior", _.redefinedBehavior),
				MetaPropertyReference[Uml, UMLBehavior[Uml], UMLBehavioralFeature[Uml]]("specification", _.specification)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		behavior_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLBehavior
	 */
	def behavior_forwardReferencesFromMetamodelAssociations: Elements =
		class_forwardReferencesFromMetamodelAssociations ++
		redefinedBehavior ++
		specification 

} //UMLBehavior
