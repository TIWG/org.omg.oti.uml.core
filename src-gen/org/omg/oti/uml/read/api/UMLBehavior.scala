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
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLBehaviorOps

import scala.Boolean
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * Behavior is a specification of how its context BehavioredClassifier changes state over time. This specification may be either a definition of possible behavior execution or emergent behavior, or a selective illustration of an interesting subset of possible executions. The latter form is typically used for capturing examples, such as a trace of a particular execution.
 *
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
*/
trait UMLBehavior[Uml <: UML]
	extends UMLClass[Uml]
	with UMLBehaviorOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * Tells whether the Behavior can be invoked while it is still executing from a previous invocation.
	 *
	 * <!-- Start of user code doc for isReentrant -->
	 * <!-- End of user code doc for isReentrant -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isReentrant: Boolean

	/**
	 * References a list of Parameters to the Behavior which describes the order and type of arguments that can be given when the Behavior is invoked and of the values which will be returned when the Behavior completes its execution.
	 *
	 * <!-- Start of user code doc for ownedParameter -->
	 * <!-- End of user code doc for ownedParameter -->
	 *
	 * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLParameter.ownedParameter_behavior
	 */
	def ownedParameter: Seq[UMLParameter[Uml]]

	/**
	 * An optional set of Constraints specifying what is fulfilled after the execution of the Behavior is completed, if its precondition was fulfilled before its invocation.
	 *
	 * <!-- Start of user code doc for postcondition -->
	 * <!-- End of user code doc for postcondition -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.postcondition_behavior
	 */
	def postcondition: Set[UMLConstraint[Uml]]

	/**
	 * An optional set of Constraints specifying what must be fulfilled before the Behavior is invoked.
	 *
	 * <!-- Start of user code doc for precondition -->
	 * <!-- End of user code doc for precondition -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.precondition_behavior
	 */
	def precondition: Set[UMLConstraint[Uml]]

	/**
	 * References the Behavior that this Behavior redefines. A subtype of Behavior may redefine any other subtype of Behavior. If the Behavior implements a BehavioralFeature, it replaces the redefined Behavior. If the Behavior is a classifierBehavior, it extends the redefined Behavior.
	 *
	 * <!-- Start of user code doc for redefinedBehavior -->
	 * <!-- End of user code doc for redefinedBehavior -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.redefinedBehavior_behavior
	 */
	def redefinedBehavior: Set[UMLBehavior[Uml]]

	/**
	 * Designates a BehavioralFeature that the Behavior implements. The BehavioralFeature must be owned by the BehavioredClassifier that owns the Behavior or be inherited by it. The Parameters of the BehavioralFeature and the implementing Behavior must match. A Behavior does not need to have a specification, in which case it either is the classifierBehavior of a BehavioredClassifier or it can only be invoked by another Behavior of the Classifier.
	 *
	 * <!-- Start of user code doc for specification -->
	 * <!-- End of user code doc for specification -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavioralFeature.method
	 */
	def specification: Option[UMLBehavioralFeature[Uml]]

	/**
	 * <!-- Start of user code doc for behavior_behaviorExecutionSpecification -->
	 * <!-- End of user code doc for behavior_behaviorExecutionSpecification -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLBehaviorExecutionSpecification.behavior
	 */
	def behavior_behaviorExecutionSpecification: Set[UMLBehaviorExecutionSpecification[Uml]]

	/**
	 * <!-- Start of user code doc for behavior_callBehaviorAction -->
	 * <!-- End of user code doc for behavior_callBehaviorAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLCallBehaviorAction.behavior
	 */
	def behavior_callBehaviorAction: Set[UMLCallBehaviorAction[Uml]]

	/**
	 * <!-- Start of user code doc for behavior_opaqueExpression -->
	 * <!-- End of user code doc for behavior_opaqueExpression -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOpaqueExpression.behavior
	 */
	def behavior_opaqueExpression: Set[UMLOpaqueExpression[Uml]]

	/**
	 * <!-- Start of user code doc for contract_connector -->
	 * <!-- End of user code doc for contract_connector -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLConnector.contract
	 */
	def contract_connector: Set[UMLConnector[Uml]]

	/**
	 * <!-- Start of user code doc for decisionInput_decisionNode -->
	 * <!-- End of user code doc for decisionInput_decisionNode -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLDecisionNode.decisionInput
	 */
	def decisionInput_decisionNode: Set[UMLDecisionNode[Uml]]

	/**
	 * <!-- Start of user code doc for doActivity_state -->
	 * <!-- End of user code doc for doActivity_state -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLState.doActivity
	 */
	def doActivity_state: Option[UMLState[Uml]]

	/**
	 * <!-- Start of user code doc for entry_state -->
	 * <!-- End of user code doc for entry_state -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLState.entry
	 */
	def entry_state: Option[UMLState[Uml]]

	/**
	 * <!-- Start of user code doc for exit_state -->
	 * <!-- End of user code doc for exit_state -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLState.exit
	 */
	def exit_state: Option[UMLState[Uml]]

	/**
	 * <!-- Start of user code doc for ownedBehavior_behavioredClassifier -->
	 * <!-- End of user code doc for ownedBehavior_behavioredClassifier -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavioredClassifier.ownedBehavior
	 */
	def ownedBehavior_behavioredClassifier: Option[UMLBehavioredClassifier[Uml]]

	/**
	 * <!-- Start of user code doc for redefinedBehavior_behavior -->
	 * <!-- End of user code doc for redefinedBehavior_behavior -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.redefinedBehavior
	 */
	def redefinedBehavior_behavior: Set[UMLBehavior[Uml]]

	/**
	 * <!-- Start of user code doc for reducer_reduceAction -->
	 * <!-- End of user code doc for reducer_reduceAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLReduceAction.reducer
	 */
	def reducer_reduceAction: Set[UMLReduceAction[Uml]]

	/**
	 * <!-- Start of user code doc for selection_objectFlow -->
	 * <!-- End of user code doc for selection_objectFlow -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLObjectFlow.selection
	 */
	def selection_objectFlow: Set[UMLObjectFlow[Uml]]

	/**
	 * <!-- Start of user code doc for selection_objectNode -->
	 * <!-- End of user code doc for selection_objectNode -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLObjectNode.selection
	 */
	def selection_objectNode: Set[UMLObjectNode[Uml]]

	/**
	 * <!-- Start of user code doc for transformation_objectFlow -->
	 * <!-- End of user code doc for transformation_objectFlow -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLObjectFlow.transformation
	 */
	def transformation_objectFlow: Set[UMLObjectFlow[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		behavior_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLBehavior
	 *
	 * <!-- Start of user code doc for behavior_metaAttributes -->
	 * <!-- End of user code doc for behavior_metaAttributes -->
	 */
	def behavior_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			class_metaAttributes,
			Seq[MetaAttributeFunction](Behavior_isReentrant))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		behavior_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLBehavior
	 *
	 * <!-- Start of user code doc for behavior_compositeMetaProperties -->
	 * <!-- End of user code doc for behavior_compositeMetaProperties -->
	 */
	def behavior_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			class_compositeMetaProperties,
			Seq[MetaPropertyEvaluator](Behavior_ownedParameter,
				Behavior_ownedParameterSet,
				Behavior_postcondition,
				Behavior_precondition))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		behavior_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLBehavior
	 *
	 * <!-- Start of user code doc for behavior_referenceMetaProperties -->
	 * <!-- End of user code doc for behavior_referenceMetaProperties -->
	 */
	def behavior_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			class_referenceMetaProperties,
			Seq[MetaPropertyEvaluator](Behavior_redefinedBehavior,
				Behavior_specification))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		behavior_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLBehavior
	 *
	 * <!-- Start of user code doc for behavior_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for behavior_forwardReferencesFromMetamodelAssociations -->
	 */
	def behavior_forwardReferencesFromMetamodelAssociations: Elements =
		class_forwardReferencesFromMetamodelAssociations ++
		redefinedBehavior ++
		specification

	// Start of user code for additional features
	// End of user code
} //UMLBehavior
