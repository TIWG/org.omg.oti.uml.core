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
package org.omg.oti.uml.write.api

// Start of user code for imports
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.write._

import scala.{Boolean,Double,Enumeration,Option,None,Some,StringContext,Unit}
import scala.Predef.{Map => _, Set => _, _}
import scala.collection.immutable._
import scala.collection.Iterable
import scala.language.postfixOps
import scala.language.implicitConversions
import scala.language.existentials
import scalaz._

import java.lang.IllegalArgumentException
import java.lang.Integer
// End of user code

trait UMLUpdate[Uml <: UML] 
extends UMLAttributeUpdater[Uml] 
with UMLPropertyUpdater[Uml] {

  def links_Abstraction_abstraction_compose_mapping_OpaqueExpression
  (from: UMLAbstraction[Uml],
   to: Option[UMLOpaqueExpression[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_AcceptCallAction_acceptCallAction_compose_returnInformation_OutputPin
  (from: UMLAcceptCallAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_AcceptEventAction_acceptEventAction_compose_result_OutputPin
  (from: UMLAcceptEventAction[Uml],
   to: Seq[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_AcceptEventAction_acceptEventAction_compose_trigger_Trigger
  (from: UMLAcceptEventAction[Uml],
   to: Set[UMLTrigger[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_AcceptEventAction_isUnmarshall
  (e: UMLAcceptEventAction[Uml], isUnmarshall: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Action_action_compose_localPostcondition_Constraint
  (from: UMLAction[Uml],
   to: Set[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Action_action_compose_localPrecondition_Constraint
  (from: UMLAction[Uml],
   to: Set[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Action_isLocallyReentrant
  (e: UMLAction[Uml], isLocallyReentrant: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ActionExecutionSpecification_actionExecutionSpecification_reference_action_Action
  (from: UMLActionExecutionSpecification[Uml],
   to: Option[UMLAction[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ActionInputPin_actionInputPin_compose_fromAction_Action
  (from: UMLActionInputPin[Uml],
   to: Option[UMLAction[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Activity_activity_compose_edge_ActivityEdge
  (from: UMLActivity[Uml],
   to: Set[UMLActivityEdge[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Activity_inActivity_compose_group_ActivityGroup
  (from: UMLActivity[Uml],
   to: Set[UMLActivityGroup[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Activity_activity_compose_node_ActivityNode
  (from: UMLActivity[Uml],
   to: Set[UMLActivityNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Activity_activity_reference_partition_ActivityPartition
  (from: UMLActivity[Uml],
   to: Set[UMLActivityPartition[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Activity_activity_compose_structuredNode_StructuredActivityNode
  (from: UMLActivity[Uml],
   to: Set[UMLStructuredActivityNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Activity_activityScope_compose_variable_Variable
  (from: UMLActivity[Uml],
   to: Set[UMLVariable[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Activity_isReadOnly
  (e: UMLActivity[Uml], isReadOnly: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Activity_isSingleExecution
  (e: UMLActivity[Uml], isSingleExecution: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ActivityEdge_activityEdge_compose_guard_ValueSpecification
  (from: UMLActivityEdge[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityEdge_edge_reference_inPartition_ActivityPartition
  (from: UMLActivityEdge[Uml],
   to: Set[UMLActivityPartition[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityEdge_interruptingEdge_reference_interrupts_InterruptibleActivityRegion
  (from: UMLActivityEdge[Uml],
   to: Option[UMLInterruptibleActivityRegion[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityEdge_activityEdge_reference_redefinedEdge_ActivityEdge
  (from: UMLActivityEdge[Uml],
   to: Set[UMLActivityEdge[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityEdge_outgoing_reference_source_ActivityNode
  (from: UMLActivityEdge[Uml],
   to: Option[UMLActivityNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityEdge_incoming_reference_target_ActivityNode
  (from: UMLActivityEdge[Uml],
   to: Option[UMLActivityNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityEdge_activityEdge_compose_weight_ValueSpecification
  (from: UMLActivityEdge[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit



  def links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion
  (from: UMLActivityNode[Uml],
   to: Set[UMLInterruptibleActivityRegion[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityNode_node_reference_inPartition_ActivityPartition
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityPartition[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityNode_target_reference_incoming_ActivityEdge
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityEdge[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityNode_source_reference_outgoing_ActivityEdge
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityEdge[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ActivityParameterNode_activityParameterNode_reference_parameter_Parameter
  (from: UMLActivityParameterNode[Uml],
   to: Option[UMLParameter[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ActivityPartition_inPartition_reference_edge_ActivityEdge
  (from: UMLActivityPartition[Uml],
   to: Set[UMLActivityEdge[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityPartition_inPartition_reference_node_ActivityNode
  (from: UMLActivityPartition[Uml],
   to: Set[UMLActivityNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityPartition_activityPartition_reference_represents_Element
  (from: UMLActivityPartition[Uml],
   to: Option[UMLElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ActivityPartition_superPartition_compose_subpartition_ActivityPartition
  (from: UMLActivityPartition[Uml],
   to: Set[UMLActivityPartition[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_ActivityPartition_isDimension
  (e: UMLActivityPartition[Uml], isDimension: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_ActivityPartition_isExternal
  (e: UMLActivityPartition[Uml], isExternal: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_AddStructuralFeatureValueAction_addStructuralFeatureValueAction_compose_insertAt_InputPin
  (from: UMLAddStructuralFeatureValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_AddStructuralFeatureValueAction_isReplaceAll
  (e: UMLAddStructuralFeatureValueAction[Uml], isReplaceAll: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_AddVariableValueAction_addVariableValueAction_compose_insertAt_InputPin
  (from: UMLAddVariableValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_AddVariableValueAction_isReplaceAll
  (e: UMLAddVariableValueAction[Uml], isReplaceAll: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_Artifact_artifact_compose_manifestation_Manifestation
  (from: UMLArtifact[Uml],
   to: Set[UMLManifestation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Artifact_artifact_compose_nestedArtifact_Artifact
  (from: UMLArtifact[Uml],
   to: Set[UMLArtifact[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Artifact_artifact_compose_ownedAttribute_Property
  (from: UMLArtifact[Uml],
   to: Seq[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Artifact_artifact_compose_ownedOperation_Operation
  (from: UMLArtifact[Uml],
   to: Seq[UMLOperation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Artifact_fileName
  (e: UMLArtifact[Uml], fileName: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Association_association_reference_memberEnd_Property
  (from: UMLAssociation[Uml],
   to: Seq[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Association_association_reference_navigableOwnedEnd_Property
  (from: UMLAssociation[Uml],
   to: Set[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Association_owningAssociation_compose_ownedEnd_Property
  (from: UMLAssociation[Uml],
   to: Iterable[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Association_isDerived
  (e: UMLAssociation[Uml], isDerived: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_Behavior_behavior_compose_ownedParameter_Parameter
  (from: UMLBehavior[Uml],
   to: Seq[UMLParameter[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Behavior_behavior_compose_ownedParameterSet_ParameterSet
  (from: UMLBehavior[Uml],
   to: Set[UMLParameterSet[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Behavior_behavior_compose_postcondition_Constraint
  (from: UMLBehavior[Uml],
   to: Set[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Behavior_behavior_compose_precondition_Constraint
  (from: UMLBehavior[Uml],
   to: Set[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Behavior_behavior_reference_redefinedBehavior_Behavior
  (from: UMLBehavior[Uml],
   to: Set[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Behavior_method_reference_specification_BehavioralFeature
  (from: UMLBehavior[Uml],
   to: Option[UMLBehavioralFeature[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Behavior_isReentrant
  (e: UMLBehavior[Uml], isReentrant: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_BehaviorExecutionSpecification_behaviorExecutionSpecification_reference_behavior_Behavior
  (from: UMLBehaviorExecutionSpecification[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_BehavioralFeature_specification_reference_method_Behavior
  (from: UMLBehavioralFeature[Uml],
   to: Set[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_BehavioralFeature_ownerFormalParam_compose_ownedParameter_Parameter
  (from: UMLBehavioralFeature[Uml],
   to: Seq[UMLParameter[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_BehavioralFeature_behavioralFeature_compose_ownedParameterSet_ParameterSet
  (from: UMLBehavioralFeature[Uml],
   to: Set[UMLParameterSet[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_BehavioralFeature_behavioralFeature_reference_raisedException_Type
  (from: UMLBehavioralFeature[Uml],
   to: Set[UMLType[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_BehavioralFeature_concurrency
  (e: UMLBehavioralFeature[Uml], concurrency: Option[UMLCallConcurrencyKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_BehavioralFeature_isAbstract
  (e: UMLBehavioralFeature[Uml], isAbstract: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior
  (from: UMLBehavioredClassifier[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization
  (from: UMLBehavioredClassifier[Uml],
   to: Set[UMLInterfaceRealization[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior
  (from: UMLBehavioredClassifier[Uml],
   to: Set[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_BroadcastSignalAction_broadcastSignalAction_reference_signal_Signal
  (from: UMLBroadcastSignalAction[Uml],
   to: Option[UMLSignal[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_CallAction_callAction_compose_result_OutputPin
  (from: UMLCallAction[Uml],
   to: Seq[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_CallAction_isSynchronous
  (e: UMLCallAction[Uml], isSynchronous: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_CallBehaviorAction_callBehaviorAction_reference_behavior_Behavior
  (from: UMLCallBehaviorAction[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_CallEvent_callEvent_reference_operation_Operation
  (from: UMLCallEvent[Uml],
   to: Option[UMLOperation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_CallOperationAction_callOperationAction_reference_operation_Operation
  (from: UMLCallOperationAction[Uml],
   to: Option[UMLOperation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_CallOperationAction_callOperationAction_compose_target_InputPin
  (from: UMLCallOperationAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_ChangeEvent_changeEvent_compose_changeExpression_ValueSpecification
  (from: UMLChangeEvent[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Class_nestingClass_compose_nestedClassifier_Classifier
  (from: UMLClass[Uml],
   to: Seq[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Class_class_compose_ownedAttribute_Property
  (from: UMLClass[Uml],
   to: Seq[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Class_class_compose_ownedOperation_Operation
  (from: UMLClass[Uml],
   to: Seq[UMLOperation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Class_class_compose_ownedReception_Reception
  (from: UMLClass[Uml],
   to: Set[UMLReception[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Class_isAbstract
  (e: UMLClass[Uml], isAbstract: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Class_isActive
  (e: UMLClass[Uml], isActive: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Classifier_classifier_compose_collaborationUse_CollaborationUse
  (from: UMLClassifier[Uml],
   to: Set[UMLCollaborationUse[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Classifier_specific_compose_generalization_Generalization
  (from: UMLClassifier[Uml],
   to: Set[UMLGeneralization[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature
  (from: UMLClassifier[Uml],
   to: Option[UMLRedefinableTemplateSignature[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Classifier_classifier_compose_ownedUseCase_UseCase
  (from: UMLClassifier[Uml],
   to: Set[UMLUseCase[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet
  (from: UMLClassifier[Uml],
   to: Set[UMLGeneralizationSet[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Classifier_classifier_reference_redefinedClassifier_Classifier
  (from: UMLClassifier[Uml],
   to: Set[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Classifier_classifier_reference_representation_CollaborationUse
  (from: UMLClassifier[Uml],
   to: Option[UMLCollaborationUse[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Classifier_substitutingClassifier_compose_substitution_Substitution
  (from: UMLClassifier[Uml],
   to: Set[UMLSubstitution[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter
  (from: UMLClassifier[Uml],
   to: Option[UMLClassifierTemplateParameter[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Classifier_subject_reference_useCase_UseCase
  (from: UMLClassifier[Uml],
   to: Set[UMLUseCase[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Classifier_isAbstract
  (e: UMLClassifier[Uml], isAbstract: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Classifier_isFinalSpecialization
  (e: UMLClassifier[Uml], isFinalSpecialization: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ClassifierTemplateParameter_classifierTemplateParameter_reference_constrainingClassifier_Classifier
  (from: UMLClassifierTemplateParameter[Uml],
   to: Set[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ClassifierTemplateParameter_templateParameter_reference_parameteredElement_Classifier
  (from: UMLClassifierTemplateParameter[Uml],
   to: Option[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_ClassifierTemplateParameter_allowSubstitutable
  (e: UMLClassifierTemplateParameter[Uml], allowSubstitutable: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Clause_clause_reference_body_ExecutableNode
  (from: UMLClause[Uml],
   to: Set[UMLExecutableNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Clause_clause_reference_bodyOutput_OutputPin
  (from: UMLClause[Uml],
   to: Seq[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Clause_clause_reference_decider_OutputPin
  (from: UMLClause[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Clause_successorClause_reference_predecessorClause_Clause
  (from: UMLClause[Uml],
   to: Set[UMLClause[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Clause_predecessorClause_reference_successorClause_Clause
  (from: UMLClause[Uml],
   to: Set[UMLClause[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Clause_clause_reference_test_ExecutableNode
  (from: UMLClause[Uml],
   to: Set[UMLExecutableNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ClearAssociationAction_clearAssociationAction_reference_association_Association
  (from: UMLClearAssociationAction[Uml],
   to: Option[UMLAssociation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ClearAssociationAction_clearAssociationAction_compose_object_InputPin
  (from: UMLClearAssociationAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ClearStructuralFeatureAction_clearStructuralFeatureAction_compose_result_OutputPin
  (from: UMLClearStructuralFeatureAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_Collaboration_collaboration_reference_collaborationRole_ConnectableElement
  (from: UMLCollaboration[Uml],
   to: Set[UMLConnectableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_CollaborationUse_collaborationUse_compose_roleBinding_Dependency
  (from: UMLCollaborationUse[Uml],
   to: Set[UMLDependency[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_CollaborationUse_collaborationUse_reference_type_Collaboration
  (from: UMLCollaborationUse[Uml],
   to: Option[UMLCollaboration[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_CombinedFragment_combinedFragment_compose_cfragmentGate_Gate
  (from: UMLCombinedFragment[Uml],
   to: Set[UMLGate[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_CombinedFragment_combinedFragment_compose_operand_InteractionOperand
  (from: UMLCombinedFragment[Uml],
   to: Seq[UMLInteractionOperand[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_CombinedFragment_interactionOperator
  (e: UMLCombinedFragment[Uml], interactionOperator: Option[UMLInteractionOperatorKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Comment_comment_reference_annotatedElement_Element
  (from: UMLComment[Uml],
   to: Set[UMLElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Comment_body
  (e: UMLComment[Uml], body: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_Component_component_compose_packagedElement_PackageableElement
  (from: UMLComponent[Uml],
   to: Set[UMLPackageableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Component_abstraction_compose_realization_ComponentRealization
  (from: UMLComponent[Uml],
   to: Set[UMLComponentRealization[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Component_isIndirectlyInstantiated
  (e: UMLComponent[Uml], isIndirectlyInstantiated: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ComponentRealization_componentRealization_reference_realizingClassifier_Classifier
  (from: UMLComponentRealization[Uml],
   to: Set[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ConditionalNode_conditionalNode_compose_clause_Clause
  (from: UMLConditionalNode[Uml],
   to: Set[UMLClause[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ConditionalNode_conditionalNode_compose_result_OutputPin
  (from: UMLConditionalNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_ConditionalNode_isAssured
  (e: UMLConditionalNode[Uml], isAssured: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_ConditionalNode_isDeterminate
  (e: UMLConditionalNode[Uml], isDeterminate: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter
  (from: UMLConnectableElement[Uml],
   to: Option[UMLConnectableElementTemplateParameter[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ConnectableElementTemplateParameter_templateParameter_reference_parameteredElement_ConnectableElement
  (from: UMLConnectableElementTemplateParameter[Uml],
   to: Option[UMLConnectableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ConnectionPointReference_connectionPointReference_reference_entry_Pseudostate
  (from: UMLConnectionPointReference[Uml],
   to: Set[UMLPseudostate[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ConnectionPointReference_connectionPointReference_reference_exit_Pseudostate
  (from: UMLConnectionPointReference[Uml],
   to: Set[UMLPseudostate[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Connector_connector_reference_contract_Behavior
  (from: UMLConnector[Uml],
   to: Set[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Connector_connector_compose_end_ConnectorEnd
  (from: UMLConnector[Uml],
   to: Seq[UMLConnectorEnd[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Connector_connector_reference_redefinedConnector_Connector
  (from: UMLConnector[Uml],
   to: Set[UMLConnector[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Connector_connector_reference_type_Association
  (from: UMLConnector[Uml],
   to: Option[UMLAssociation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ConnectorEnd_connectorEnd_reference_partWithPort_Property
  (from: UMLConnectorEnd[Uml],
   to: Option[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ConsiderIgnoreFragment_considerIgnoreFragment_reference_message_NamedElement
  (from: UMLConsiderIgnoreFragment[Uml],
   to: Set[UMLNamedElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Constraint_constraint_reference_constrainedElement_Element
  (from: UMLConstraint[Uml],
   to: Seq[UMLElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Constraint_owningConstraint_compose_specification_ValueSpecification
  (from: UMLConstraint[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Continuation_setting
  (e: UMLContinuation[Uml], setting: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit



  def links_CreateLinkAction_createLinkAction_compose_endData_LinkEndCreationData
  (from: UMLCreateLinkAction[Uml],
   to: Iterable[UMLLinkEndCreationData[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_CreateLinkObjectAction_createLinkObjectAction_compose_result_OutputPin
  (from: UMLCreateLinkObjectAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_CreateObjectAction_createObjectAction_reference_classifier_Classifier
  (from: UMLCreateObjectAction[Uml],
   to: Option[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_CreateObjectAction_createObjectAction_compose_result_OutputPin
  (from: UMLCreateObjectAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_DataType_datatype_compose_ownedAttribute_Property
  (from: UMLDataType[Uml],
   to: Seq[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_DataType_datatype_compose_ownedOperation_Operation
  (from: UMLDataType[Uml],
   to: Seq[UMLOperation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_DecisionNode_decisionNode_reference_decisionInput_Behavior
  (from: UMLDecisionNode[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_DecisionNode_decisionNode_reference_decisionInputFlow_ObjectFlow
  (from: UMLDecisionNode[Uml],
   to: Option[UMLObjectFlow[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Dependency_supplierDependency_reference_supplier_NamedElement
  (from: UMLDependency[Uml],
   to: Set[UMLNamedElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_Deployment_deployment_compose_configuration_DeploymentSpecification
  (from: UMLDeployment[Uml],
   to: Set[UMLDeploymentSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Deployment_deploymentForArtifact_reference_deployedArtifact_DeployedArtifact
  (from: UMLDeployment[Uml],
   to: Set[UMLDeployedArtifact[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_DeploymentSpecification_deploymentLocation
  (e: UMLDeploymentSpecification[Uml], deploymentLocation: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_DeploymentSpecification_executionLocation
  (e: UMLDeploymentSpecification[Uml], executionLocation: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_DeploymentTarget_location_compose_deployment_Deployment
  (from: UMLDeploymentTarget[Uml],
   to: Set[UMLDeployment[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_DestroyLinkAction_destroyLinkAction_compose_endData_LinkEndDestructionData
  (from: UMLDestroyLinkAction[Uml],
   to: Iterable[UMLLinkEndDestructionData[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_DestroyObjectAction_destroyObjectAction_compose_target_InputPin
  (from: UMLDestroyObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_DestroyObjectAction_isDestroyLinks
  (e: UMLDestroyObjectAction[Uml], isDestroyLinks: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_DestroyObjectAction_isDestroyOwnedObjects
  (e: UMLDestroyObjectAction[Uml], isDestroyOwnedObjects: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit




  def links_Duration_duration_compose_expr_ValueSpecification
  (from: UMLDuration[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Duration_duration_reference_observation_Observation
  (from: UMLDuration[Uml],
   to: Set[UMLObservation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_DurationConstraint_durationConstraint_compose_specification_DurationInterval
  (from: UMLDurationConstraint[Uml],
   to: Option[UMLDurationInterval[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_DurationConstraint_firstEvent
  (e: UMLDurationConstraint[Uml], firstEvent: Set[Boolean]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_DurationInterval_durationInterval_reference_max_Duration
  (from: UMLDurationInterval[Uml],
   to: Option[UMLDuration[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_DurationInterval_durationInterval_reference_min_Duration
  (from: UMLDurationInterval[Uml],
   to: Option[UMLDuration[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_DurationObservation_durationObservation_reference_event_NamedElement
  (from: UMLDurationObservation[Uml],
   to: Seq[UMLNamedElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_DurationObservation_firstEvent
  (e: UMLDurationObservation[Uml], firstEvent: Seq[Boolean]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Element_owningElement_compose_ownedComment_Comment
  (from: UMLElement[Uml],
   to: Set[UMLComment[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ElementImport_import_reference_importedElement_PackageableElement
  (from: UMLElementImport[Uml],
   to: Option[UMLPackageableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_ElementImport_alias
  (e: UMLElementImport[Uml], alias: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_ElementImport_visibility
  (e: UMLElementImport[Uml], visibility: Option[UMLVisibilityKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_Enumeration_enumeration_compose_ownedLiteral_EnumerationLiteral
  (from: UMLEnumeration[Uml],
   to: Seq[UMLEnumerationLiteral[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit



  def links_ExceptionHandler_exceptionHandler_reference_exceptionInput_ObjectNode
  (from: UMLExceptionHandler[Uml],
   to: Option[UMLObjectNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ExceptionHandler_exceptionHandler_reference_exceptionType_Classifier
  (from: UMLExceptionHandler[Uml],
   to: Set[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ExceptionHandler_exceptionHandler_reference_handlerBody_ExecutableNode
  (from: UMLExceptionHandler[Uml],
   to: Option[UMLExecutableNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler
  (from: UMLExecutableNode[Uml],
   to: Set[UMLExceptionHandler[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_ExecutionOccurrenceSpecification_executionOccurrenceSpecification_reference_execution_ExecutionSpecification
  (from: UMLExecutionOccurrenceSpecification[Uml],
   to: Option[UMLExecutionSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ExecutionSpecification_executionSpecification_reference_finish_OccurrenceSpecification
  (from: UMLExecutionSpecification[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ExecutionSpecification_executionSpecification_reference_start_OccurrenceSpecification
  (from: UMLExecutionSpecification[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ExpansionNode_inputElement_reference_regionAsInput_ExpansionRegion
  (from: UMLExpansionNode[Uml],
   to: Option[UMLExpansionRegion[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ExpansionNode_outputElement_reference_regionAsOutput_ExpansionRegion
  (from: UMLExpansionNode[Uml],
   to: Option[UMLExpansionRegion[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ExpansionRegion_regionAsInput_reference_inputElement_ExpansionNode
  (from: UMLExpansionRegion[Uml],
   to: Set[UMLExpansionNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ExpansionRegion_regionAsOutput_reference_outputElement_ExpansionNode
  (from: UMLExpansionRegion[Uml],
   to: Set[UMLExpansionNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_ExpansionRegion_mode
  (e: UMLExpansionRegion[Uml], mode: Option[UMLExpansionKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Expression_expression_compose_operand_ValueSpecification
  (from: UMLExpression[Uml],
   to: Seq[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Expression_symbol
  (e: UMLExpression[Uml], symbol: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Extend_extend_compose_condition_Constraint
  (from: UMLExtend[Uml],
   to: Option[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Extend_extend_reference_extendedCase_UseCase
  (from: UMLExtend[Uml],
   to: Option[UMLUseCase[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Extend_extension_reference_extensionLocation_ExtensionPoint
  (from: UMLExtend[Uml],
   to: Seq[UMLExtensionPoint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Extension_extension_compose_ownedEnd_ExtensionEnd
  (from: UMLExtension[Uml],
   to: Iterable[UMLExtensionEnd[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ExtensionEnd_extensionEnd_reference_type_Stereotype
  (from: UMLExtensionEnd[Uml],
   to: Option[UMLStereotype[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def set_Feature_isStatic
  (e: UMLFeature[Uml], isStatic: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit







  def links_GeneralOrdering_toBefore_reference_after_OccurrenceSpecification
  (from: UMLGeneralOrdering[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_GeneralOrdering_toAfter_reference_before_OccurrenceSpecification
  (from: UMLGeneralOrdering[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Generalization_generalization_reference_general_Classifier
  (from: UMLGeneralization[Uml],
   to: Option[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Generalization_generalization_reference_generalizationSet_GeneralizationSet
  (from: UMLGeneralization[Uml],
   to: Set[UMLGeneralizationSet[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Generalization_isSubstitutable
  (e: UMLGeneralization[Uml], isSubstitutable: Option[Boolean]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_GeneralizationSet_generalizationSet_reference_generalization_Generalization
  (from: UMLGeneralizationSet[Uml],
   to: Set[UMLGeneralization[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_GeneralizationSet_powertypeExtent_reference_powertype_Classifier
  (from: UMLGeneralizationSet[Uml],
   to: Option[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_GeneralizationSet_isCovering
  (e: UMLGeneralizationSet[Uml], isCovering: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_GeneralizationSet_isDisjoint
  (e: UMLGeneralizationSet[Uml], isDisjoint: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Image_content
  (e: UMLImage[Uml], content: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Image_format
  (e: UMLImage[Uml], format: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Image_location
  (e: UMLImage[Uml], location: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Include_include_reference_addition_UseCase
  (from: UMLInclude[Uml],
   to: Option[UMLUseCase[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_InformationFlow_conveyingFlow_reference_conveyed_Classifier
  (from: UMLInformationFlow[Uml],
   to: Set[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InformationFlow_informationFlow_reference_informationSource_NamedElement
  (from: UMLInformationFlow[Uml],
   to: Set[UMLNamedElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InformationFlow_informationFlow_reference_informationTarget_NamedElement
  (from: UMLInformationFlow[Uml],
   to: Set[UMLNamedElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InformationFlow_abstraction_reference_realization_Relationship
  (from: UMLInformationFlow[Uml],
   to: Set[UMLRelationship[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InformationFlow_informationFlow_reference_realizingActivityEdge_ActivityEdge
  (from: UMLInformationFlow[Uml],
   to: Set[UMLActivityEdge[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InformationFlow_informationFlow_reference_realizingConnector_Connector
  (from: UMLInformationFlow[Uml],
   to: Set[UMLConnector[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InformationFlow_informationFlow_reference_realizingMessage_Message
  (from: UMLInformationFlow[Uml],
   to: Set[UMLMessage[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_InformationItem_representation_reference_represented_Classifier
  (from: UMLInformationItem[Uml],
   to: Set[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit



  def links_InstanceSpecification_instanceSpecification_reference_classifier_Classifier
  (from: UMLInstanceSpecification[Uml],
   to: Iterable[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InstanceSpecification_owningInstance_compose_slot_Slot
  (from: UMLInstanceSpecification[Uml],
   to: Set[UMLSlot[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InstanceSpecification_owningInstanceSpec_compose_specification_ValueSpecification
  (from: UMLInstanceSpecification[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_InstanceValue_instanceValue_reference_instance_InstanceSpecification
  (from: UMLInstanceValue[Uml],
   to: Option[UMLInstanceSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Interaction_interaction_compose_action_Action
  (from: UMLInteraction[Uml],
   to: Set[UMLAction[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Interaction_interaction_compose_formalGate_Gate
  (from: UMLInteraction[Uml],
   to: Set[UMLGate[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Interaction_enclosingInteraction_compose_fragment_InteractionFragment
  (from: UMLInteraction[Uml],
   to: Seq[UMLInteractionFragment[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Interaction_interaction_compose_lifeline_Lifeline
  (from: UMLInteraction[Uml],
   to: Set[UMLLifeline[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Interaction_interaction_compose_message_Message
  (from: UMLInteraction[Uml],
   to: Set[UMLMessage[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_InteractionConstraint_interactionConstraint_compose_maxint_ValueSpecification
  (from: UMLInteractionConstraint[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InteractionConstraint_interactionConstraint_compose_minint_ValueSpecification
  (from: UMLInteractionConstraint[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_InteractionFragment_coveredBy_reference_covered_Lifeline
  (from: UMLInteractionFragment[Uml],
   to: Iterable[UMLLifeline[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering
  (from: UMLInteractionFragment[Uml],
   to: Set[UMLGeneralOrdering[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_InteractionOperand_enclosingOperand_compose_fragment_InteractionFragment
  (from: UMLInteractionOperand[Uml],
   to: Seq[UMLInteractionFragment[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InteractionOperand_interactionOperand_compose_guard_InteractionConstraint
  (from: UMLInteractionOperand[Uml],
   to: Option[UMLInteractionConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_InteractionUse_interactionUse_compose_actualGate_Gate
  (from: UMLInteractionUse[Uml],
   to: Set[UMLGate[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InteractionUse_interactionUse_compose_argument_ValueSpecification
  (from: UMLInteractionUse[Uml],
   to: Seq[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InteractionUse_interactionUse_reference_refersTo_Interaction
  (from: UMLInteractionUse[Uml],
   to: Option[UMLInteraction[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InteractionUse_interactionUse_compose_returnValue_ValueSpecification
  (from: UMLInteractionUse[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InteractionUse_interactionUse_reference_returnValueRecipient_Property
  (from: UMLInteractionUse[Uml],
   to: Option[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Interface_interface_compose_nestedClassifier_Classifier
  (from: UMLInterface[Uml],
   to: Seq[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Interface_interface_compose_ownedAttribute_Property
  (from: UMLInterface[Uml],
   to: Seq[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Interface_interface_compose_ownedOperation_Operation
  (from: UMLInterface[Uml],
   to: Seq[UMLOperation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Interface_interface_compose_ownedReception_Reception
  (from: UMLInterface[Uml],
   to: Set[UMLReception[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Interface_interface_compose_protocol_ProtocolStateMachine
  (from: UMLInterface[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Interface_interface_reference_redefinedInterface_Interface
  (from: UMLInterface[Uml],
   to: Set[UMLInterface[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_InterfaceRealization_interfaceRealization_reference_contract_Interface
  (from: UMLInterfaceRealization[Uml],
   to: Option[UMLInterface[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_InterruptibleActivityRegion_interrupts_reference_interruptingEdge_ActivityEdge
  (from: UMLInterruptibleActivityRegion[Uml],
   to: Set[UMLActivityEdge[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InterruptibleActivityRegion_inInterruptibleRegion_reference_node_ActivityNode
  (from: UMLInterruptibleActivityRegion[Uml],
   to: Set[UMLActivityNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Interval_interval_reference_max_ValueSpecification
  (from: UMLInterval[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Interval_interval_reference_min_ValueSpecification
  (from: UMLInterval[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_IntervalConstraint_intervalConstraint_compose_specification_Interval
  (from: UMLIntervalConstraint[Uml],
   to: Option[UMLInterval[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_InvocationAction_invocationAction_compose_argument_InputPin
  (from: UMLInvocationAction[Uml],
   to: Seq[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_InvocationAction_invocationAction_reference_onPort_Port
  (from: UMLInvocationAction[Uml],
   to: Option[UMLPort[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_JoinNode_joinNode_compose_joinSpec_ValueSpecification
  (from: UMLJoinNode[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_JoinNode_isCombineDuplicate
  (e: UMLJoinNode[Uml], isCombineDuplicate: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Lifeline_covered_reference_coveredBy_InteractionFragment
  (from: UMLLifeline[Uml],
   to: Set[UMLInteractionFragment[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Lifeline_lifeline_reference_decomposedAs_PartDecomposition
  (from: UMLLifeline[Uml],
   to: Option[UMLPartDecomposition[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Lifeline_lifeline_reference_represents_ConnectableElement
  (from: UMLLifeline[Uml],
   to: Option[UMLConnectableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Lifeline_lifeline_compose_selector_ValueSpecification
  (from: UMLLifeline[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_LinkAction_linkAction_compose_endData_LinkEndData
  (from: UMLLinkAction[Uml],
   to: Iterable[UMLLinkEndData[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_LinkAction_linkAction_compose_inputValue_InputPin
  (from: UMLLinkAction[Uml],
   to: Set[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_LinkEndCreationData_linkEndCreationData_reference_insertAt_InputPin
  (from: UMLLinkEndCreationData[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_LinkEndCreationData_isReplaceAll
  (e: UMLLinkEndCreationData[Uml], isReplaceAll: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_LinkEndData_linkEndData_reference_end_Property
  (from: UMLLinkEndData[Uml],
   to: Option[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_LinkEndData_linkEndData_compose_qualifier_QualifierValue
  (from: UMLLinkEndData[Uml],
   to: Set[UMLQualifierValue[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_LinkEndData_linkEndData_reference_value_InputPin
  (from: UMLLinkEndData[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_LinkEndDestructionData_linkEndDestructionData_reference_destroyAt_InputPin
  (from: UMLLinkEndDestructionData[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_LinkEndDestructionData_isDestroyDuplicates
  (e: UMLLinkEndDestructionData[Uml], isDestroyDuplicates: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_LiteralBoolean_value
  (e: UMLLiteralBoolean[Uml], value: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_LiteralInteger_value
  (e: UMLLiteralInteger[Uml], value: Integer): NonEmptyList[java.lang.Throwable] \/ Unit


  def set_LiteralReal_value
  (e: UMLLiteralReal[Uml], value: Double): NonEmptyList[java.lang.Throwable] \/ Unit


  def set_LiteralString_value
  (e: UMLLiteralString[Uml], value: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_LiteralUnlimitedNatural_value
  (e: UMLLiteralUnlimitedNatural[Uml], value: String): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_LoopNode_loopNode_reference_bodyOutput_OutputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_LoopNode_loopNode_reference_bodyPart_ExecutableNode
  (from: UMLLoopNode[Uml],
   to: Set[UMLExecutableNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_LoopNode_loopNode_reference_decider_OutputPin
  (from: UMLLoopNode[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_LoopNode_loopNode_compose_loopVariable_OutputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_LoopNode_loopNode_compose_loopVariableInput_InputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_LoopNode_loopNode_compose_result_OutputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_LoopNode_loopNode_reference_setupPart_ExecutableNode
  (from: UMLLoopNode[Uml],
   to: Set[UMLExecutableNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_LoopNode_loopNode_reference_test_ExecutableNode
  (from: UMLLoopNode[Uml],
   to: Set[UMLExecutableNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_LoopNode_isTestedFirst
  (e: UMLLoopNode[Uml], isTestedFirst: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Manifestation_manifestation_reference_utilizedElement_PackageableElement
  (from: UMLManifestation[Uml],
   to: Option[UMLPackageableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_Message_message_compose_argument_ValueSpecification
  (from: UMLMessage[Uml],
   to: Seq[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Message_message_reference_connector_Connector
  (from: UMLMessage[Uml],
   to: Option[UMLConnector[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Message_endMessage_reference_receiveEvent_MessageEnd
  (from: UMLMessage[Uml],
   to: Option[UMLMessageEnd[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Message_endMessage_reference_sendEvent_MessageEnd
  (from: UMLMessage[Uml],
   to: Option[UMLMessageEnd[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Message_message_reference_signature_NamedElement
  (from: UMLMessage[Uml],
   to: Option[UMLNamedElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Message_messageSort
  (e: UMLMessage[Uml], messageSort: Option[UMLMessageSort.Value]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_MessageEnd_messageEnd_reference_message_Message
  (from: UMLMessageEnd[Uml],
   to: Option[UMLMessage[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit



  def set_Model_viewpoint
  (e: UMLModel[Uml], viewpoint: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification
  (from: UMLMultiplicityElement[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification
  (from: UMLMultiplicityElement[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_MultiplicityElement_isOrdered
  (e: UMLMultiplicityElement[Uml], isOrdered: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_MultiplicityElement_isUnique
  (e: UMLMultiplicityElement[Uml], isUnique: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_NamedElement_namedElement_compose_nameExpression_StringExpression
  (from: UMLNamedElement[Uml],
   to: Option[UMLStringExpression[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_NamedElement_name
  (e: UMLNamedElement[Uml], name: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_NamedElement_visibility
  (e: UMLNamedElement[Uml], visibility: Option[UMLVisibilityKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Namespace_importingNamespace_compose_elementImport_ElementImport
  (from: UMLNamespace[Uml],
   to: Set[UMLElementImport[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Namespace_context_compose_ownedRule_Constraint
  (from: UMLNamespace[Uml],
   to: Set[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Namespace_importingNamespace_compose_packageImport_PackageImport
  (from: UMLNamespace[Uml],
   to: Set[UMLPackageImport[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Node_node_compose_nestedNode_Node
  (from: UMLNode[Uml],
   to: Set[UMLNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ObjectFlow_objectFlow_reference_selection_Behavior
  (from: UMLObjectFlow[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ObjectFlow_objectFlow_reference_transformation_Behavior
  (from: UMLObjectFlow[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_ObjectFlow_isMulticast
  (e: UMLObjectFlow[Uml], isMulticast: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_ObjectFlow_isMultireceive
  (e: UMLObjectFlow[Uml], isMultireceive: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ObjectNode_objectNode_reference_inState_State
  (from: UMLObjectNode[Uml],
   to: Set[UMLState[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ObjectNode_objectNode_reference_selection_Behavior
  (from: UMLObjectNode[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ObjectNode_objectNode_compose_upperBound_ValueSpecification
  (from: UMLObjectNode[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_ObjectNode_isControlType
  (e: UMLObjectNode[Uml], isControlType: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_ObjectNode_ordering
  (e: UMLObjectNode[Uml], ordering: Option[UMLObjectNodeOrderingKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_OccurrenceSpecification_events_reference_covered_Lifeline
  (from: UMLOccurrenceSpecification[Uml],
   to: Iterable[UMLLifeline[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_OccurrenceSpecification_before_reference_toAfter_GeneralOrdering
  (from: UMLOccurrenceSpecification[Uml],
   to: Set[UMLGeneralOrdering[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_OccurrenceSpecification_after_reference_toBefore_GeneralOrdering
  (from: UMLOccurrenceSpecification[Uml],
   to: Set[UMLGeneralOrdering[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_OpaqueAction_opaqueAction_compose_inputValue_InputPin
  (from: UMLOpaqueAction[Uml],
   to: Set[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_OpaqueAction_opaqueAction_compose_outputValue_OutputPin
  (from: UMLOpaqueAction[Uml],
   to: Set[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_OpaqueAction_body
  (e: UMLOpaqueAction[Uml], body: Seq[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_OpaqueAction_language
  (e: UMLOpaqueAction[Uml], language: Seq[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_OpaqueBehavior_body
  (e: UMLOpaqueBehavior[Uml], body: Seq[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_OpaqueBehavior_language
  (e: UMLOpaqueBehavior[Uml], language: Seq[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_OpaqueExpression_opaqueExpression_reference_behavior_Behavior
  (from: UMLOpaqueExpression[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_OpaqueExpression_body
  (e: UMLOpaqueExpression[Uml], body: Seq[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_OpaqueExpression_language
  (e: UMLOpaqueExpression[Uml], language: Seq[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Operation_bodyContext_compose_bodyCondition_Constraint
  (from: UMLOperation[Uml],
   to: Option[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Operation_operation_compose_ownedParameter_Parameter
  (from: UMLOperation[Uml],
   to: Seq[UMLParameter[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Operation_postContext_compose_postcondition_Constraint
  (from: UMLOperation[Uml],
   to: Set[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Operation_preContext_compose_precondition_Constraint
  (from: UMLOperation[Uml],
   to: Set[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Operation_operation_reference_raisedException_Type
  (from: UMLOperation[Uml],
   to: Set[UMLType[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Operation_operation_reference_redefinedOperation_Operation
  (from: UMLOperation[Uml],
   to: Set[UMLOperation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Operation_parameteredElement_reference_templateParameter_OperationTemplateParameter
  (from: UMLOperation[Uml],
   to: Option[UMLOperationTemplateParameter[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Operation_isQuery
  (e: UMLOperation[Uml], isQuery: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_OperationTemplateParameter_templateParameter_reference_parameteredElement_Operation
  (from: UMLOperationTemplateParameter[Uml],
   to: Option[UMLOperation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_Package_receivingPackage_compose_packageMerge_PackageMerge
  (from: UMLPackage[Uml],
   to: Set[UMLPackageMerge[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Package_owningPackage_compose_packagedElement_PackageableElement
  (from: UMLPackage[Uml],
   to: Set[UMLPackageableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Package_applyingPackage_compose_profileApplication_ProfileApplication
  (from: UMLPackage[Uml],
   to: Set[UMLProfileApplication[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Package_URI
  (e: UMLPackage[Uml], URI: Option[String]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_PackageImport_packageImport_reference_importedPackage_Package
  (from: UMLPackageImport[Uml],
   to: Option[UMLPackage[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_PackageImport_visibility
  (e: UMLPackageImport[Uml], visibility: Option[UMLVisibilityKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_PackageMerge_packageMerge_reference_mergedPackage_Package
  (from: UMLPackageMerge[Uml],
   to: Option[UMLPackage[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_PackageableElement_visibility
  (e: UMLPackageableElement[Uml], visibility: Option[UMLVisibilityKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Parameter_owningParameter_compose_defaultValue_ValueSpecification
  (from: UMLParameter[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Parameter_parameter_reference_parameterSet_ParameterSet
  (from: UMLParameter[Uml],
   to: Set[UMLParameterSet[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Parameter_direction
  (e: UMLParameter[Uml], direction: Option[UMLParameterDirectionKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Parameter_effect
  (e: UMLParameter[Uml], effect: Option[UMLParameterEffectKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Parameter_isException
  (e: UMLParameter[Uml], isException: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Parameter_isStream
  (e: UMLParameter[Uml], isStream: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ParameterSet_parameterSet_compose_condition_Constraint
  (from: UMLParameterSet[Uml],
   to: Set[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ParameterSet_parameterSet_reference_parameter_Parameter
  (from: UMLParameterSet[Uml],
   to: Set[UMLParameter[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: Option[UMLTemplateParameter[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def set_Pin_isControl
  (e: UMLPin[Uml], isControl: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Port_port_reference_protocol_ProtocolStateMachine
  (from: UMLPort[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Port_port_reference_redefinedPort_Port
  (from: UMLPort[Uml],
   to: Set[UMLPort[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Port_isBehavior
  (e: UMLPort[Uml], isBehavior: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Port_isConjugated
  (e: UMLPort[Uml], isConjugated: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Port_isService
  (e: UMLPort[Uml], isService: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_Profile_profile_compose_metaclassReference_ElementImport
  (from: UMLProfile[Uml],
   to: Set[UMLElementImport[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Profile_profile_compose_metamodelReference_PackageImport
  (from: UMLProfile[Uml],
   to: Set[UMLPackageImport[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ProfileApplication_profileApplication_reference_appliedProfile_Profile
  (from: UMLProfileApplication[Uml],
   to: Option[UMLProfile[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_ProfileApplication_isStrict
  (e: UMLProfileApplication[Uml], isStrict: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Property_memberEnd_reference_association_Association
  (from: UMLProperty[Uml],
   to: Option[UMLAssociation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Property_owningProperty_compose_defaultValue_ValueSpecification
  (from: UMLProperty[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Property_associationEnd_compose_qualifier_Property
  (from: UMLProperty[Uml],
   to: Seq[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Property_property_reference_redefinedProperty_Property
  (from: UMLProperty[Uml],
   to: Set[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Property_property_reference_subsettedProperty_Property
  (from: UMLProperty[Uml],
   to: Set[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Property_aggregation
  (e: UMLProperty[Uml], aggregation: Option[UMLAggregationKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Property_isDerived
  (e: UMLProperty[Uml], isDerived: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Property_isDerivedUnion
  (e: UMLProperty[Uml], isDerivedUnion: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Property_isID
  (e: UMLProperty[Uml], isID: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ProtocolConformance_protocolConformance_reference_generalMachine_ProtocolStateMachine
  (from: UMLProtocolConformance[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ProtocolStateMachine_specificMachine_compose_conformance_ProtocolConformance
  (from: UMLProtocolStateMachine[Uml],
   to: Set[UMLProtocolConformance[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ProtocolTransition_owningTransition_compose_postCondition_Constraint
  (from: UMLProtocolTransition[Uml],
   to: Option[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ProtocolTransition_protocolTransition_compose_preCondition_Constraint
  (from: UMLProtocolTransition[Uml],
   to: Option[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_Pseudostate_kind
  (e: UMLPseudostate[Uml], kind: Option[UMLPseudostateKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_QualifierValue_qualifierValue_reference_qualifier_Property
  (from: UMLQualifierValue[Uml],
   to: Option[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_QualifierValue_qualifierValue_reference_value_InputPin
  (from: UMLQualifierValue[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_RaiseExceptionAction_raiseExceptionAction_compose_exception_InputPin
  (from: UMLRaiseExceptionAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ReadExtentAction_readExtentAction_reference_classifier_Classifier
  (from: UMLReadExtentAction[Uml],
   to: Option[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReadExtentAction_readExtentAction_compose_result_OutputPin
  (from: UMLReadExtentAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_reference_classifier_Classifier
  (from: UMLReadIsClassifiedObjectAction[Uml],
   to: Option[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_object_InputPin
  (from: UMLReadIsClassifiedObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_result_OutputPin
  (from: UMLReadIsClassifiedObjectAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_ReadIsClassifiedObjectAction_isDirect
  (e: UMLReadIsClassifiedObjectAction[Uml], isDirect: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ReadLinkAction_readLinkAction_compose_result_OutputPin
  (from: UMLReadLinkAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ReadLinkObjectEndAction_readLinkObjectEndAction_reference_end_Property
  (from: UMLReadLinkObjectEndAction[Uml],
   to: Option[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_object_InputPin
  (from: UMLReadLinkObjectEndAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_result_OutputPin
  (from: UMLReadLinkObjectEndAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_object_InputPin
  (from: UMLReadLinkObjectEndQualifierAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_reference_qualifier_Property
  (from: UMLReadLinkObjectEndQualifierAction[Uml],
   to: Option[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_result_OutputPin
  (from: UMLReadLinkObjectEndQualifierAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ReadSelfAction_readSelfAction_compose_result_OutputPin
  (from: UMLReadSelfAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ReadStructuralFeatureAction_readStructuralFeatureAction_compose_result_OutputPin
  (from: UMLReadStructuralFeatureAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ReadVariableAction_readVariableAction_compose_result_OutputPin
  (from: UMLReadVariableAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_Reception_reception_reference_signal_Signal
  (from: UMLReception[Uml],
   to: Option[UMLSignal[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ReclassifyObjectAction_reclassifyObjectAction_reference_newClassifier_Classifier
  (from: UMLReclassifyObjectAction[Uml],
   to: Set[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReclassifyObjectAction_reclassifyObjectAction_compose_object_InputPin
  (from: UMLReclassifyObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReclassifyObjectAction_reclassifyObjectAction_reference_oldClassifier_Classifier
  (from: UMLReclassifyObjectAction[Uml],
   to: Set[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_ReclassifyObjectAction_isReplaceAll
  (e: UMLReclassifyObjectAction[Uml], isReplaceAll: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_RedefinableElement_isLeaf
  (e: UMLRedefinableElement[Uml], isLeaf: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_RedefinableTemplateSignature_redefinableTemplateSignature_reference_extendedSignature_RedefinableTemplateSignature
  (from: UMLRedefinableTemplateSignature[Uml],
   to: Set[UMLRedefinableTemplateSignature[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ReduceAction_reduceAction_compose_collection_InputPin
  (from: UMLReduceAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReduceAction_reduceAction_reference_reducer_Behavior
  (from: UMLReduceAction[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReduceAction_reduceAction_compose_result_OutputPin
  (from: UMLReduceAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_ReduceAction_isOrdered
  (e: UMLReduceAction[Uml], isOrdered: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Region_region_reference_extendedRegion_Region
  (from: UMLRegion[Uml],
   to: Option[UMLRegion[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Region_container_compose_subvertex_Vertex
  (from: UMLRegion[Uml],
   to: Set[UMLVertex[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Region_container_compose_transition_Transition
  (from: UMLRegion[Uml],
   to: Set[UMLTransition[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_compose_removeAt_InputPin
  (from: UMLRemoveStructuralFeatureValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_RemoveStructuralFeatureValueAction_isRemoveDuplicates
  (e: UMLRemoveStructuralFeatureValueAction[Uml], isRemoveDuplicates: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_RemoveVariableValueAction_removeVariableValueAction_compose_removeAt_InputPin
  (from: UMLRemoveVariableValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_RemoveVariableValueAction_isRemoveDuplicates
  (e: UMLRemoveVariableValueAction[Uml], isRemoveDuplicates: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ReplyAction_replyAction_reference_replyToCall_Trigger
  (from: UMLReplyAction[Uml],
   to: Option[UMLTrigger[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReplyAction_replyAction_compose_replyValue_InputPin
  (from: UMLReplyAction[Uml],
   to: Seq[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ReplyAction_replyAction_compose_returnInformation_InputPin
  (from: UMLReplyAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_SendObjectAction_sendObjectAction_compose_request_InputPin
  (from: UMLSendObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_SendObjectAction_sendObjectAction_compose_target_InputPin
  (from: UMLSendObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_SendSignalAction_sendSignalAction_reference_signal_Signal
  (from: UMLSendSignalAction[Uml],
   to: Option[UMLSignal[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_SendSignalAction_sendSignalAction_compose_target_InputPin
  (from: UMLSendSignalAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_SequenceNode_sequenceNode_compose_executableNode_ExecutableNode
  (from: UMLSequenceNode[Uml],
   to: Seq[UMLExecutableNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Signal_owningSignal_compose_ownedAttribute_Property
  (from: UMLSignal[Uml],
   to: Seq[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_SignalEvent_signalEvent_reference_signal_Signal
  (from: UMLSignalEvent[Uml],
   to: Option[UMLSignal[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Slot_slot_reference_definingFeature_StructuralFeature
  (from: UMLSlot[Uml],
   to: Option[UMLStructuralFeature[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Slot_owningSlot_compose_value_ValueSpecification
  (from: UMLSlot[Uml],
   to: Seq[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_StartClassifierBehaviorAction_startClassifierBehaviorAction_compose_object_InputPin
  (from: UMLStartClassifierBehaviorAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_StartObjectBehaviorAction_startObjectBehaviorAction_compose_object_InputPin
  (from: UMLStartObjectBehaviorAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_State_state_compose_connection_ConnectionPointReference
  (from: UMLState[Uml],
   to: Set[UMLConnectionPointReference[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_State_state_compose_connectionPoint_Pseudostate
  (from: UMLState[Uml],
   to: Set[UMLPseudostate[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_State_state_compose_deferrableTrigger_Trigger
  (from: UMLState[Uml],
   to: Set[UMLTrigger[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_State_state_compose_doActivity_Behavior
  (from: UMLState[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_State_state_compose_entry_Behavior
  (from: UMLState[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_State_state_compose_exit_Behavior
  (from: UMLState[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_State_state_reference_redefinedState_State
  (from: UMLState[Uml],
   to: Option[UMLState[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_State_state_compose_region_Region
  (from: UMLState[Uml],
   to: Set[UMLRegion[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_State_owningState_compose_stateInvariant_Constraint
  (from: UMLState[Uml],
   to: Option[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_State_submachineState_reference_submachine_StateMachine
  (from: UMLState[Uml],
   to: Option[UMLStateMachine[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_StateInvariant_stateInvariant_reference_covered_Lifeline
  (from: UMLStateInvariant[Uml],
   to: Iterable[UMLLifeline[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_StateInvariant_stateInvariant_compose_invariant_Constraint
  (from: UMLStateInvariant[Uml],
   to: Option[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_StateMachine_stateMachine_compose_connectionPoint_Pseudostate
  (from: UMLStateMachine[Uml],
   to: Set[UMLPseudostate[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_StateMachine_stateMachine_reference_extendedStateMachine_StateMachine
  (from: UMLStateMachine[Uml],
   to: Set[UMLStateMachine[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_StateMachine_stateMachine_compose_region_Region
  (from: UMLStateMachine[Uml],
   to: Set[UMLRegion[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_StateMachine_submachine_reference_submachineState_State
  (from: UMLStateMachine[Uml],
   to: Set[UMLState[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Stereotype_stereotype_compose_icon_Image
  (from: UMLStereotype[Uml],
   to: Set[UMLImage[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_StringExpression_owningExpression_compose_subExpression_StringExpression
  (from: UMLStringExpression[Uml],
   to: Seq[UMLStringExpression[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def set_StructuralFeature_isReadOnly
  (e: UMLStructuralFeature[Uml], isReadOnly: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_StructuralFeatureAction_structuralFeatureAction_compose_object_InputPin
  (from: UMLStructuralFeatureAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_StructuralFeatureAction_structuralFeatureAction_reference_structuralFeature_StructuralFeature
  (from: UMLStructuralFeatureAction[Uml],
   to: Option[UMLStructuralFeature[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLActivityEdge[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLActivityNode[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_StructuredActivityNode_scope_compose_variable_Variable
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLVariable[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_StructuredActivityNode_mustIsolate
  (e: UMLStructuredActivityNode[Uml], mustIsolate: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property
  (from: UMLStructuredClassifier[Uml],
   to: Seq[UMLProperty[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector
  (from: UMLStructuredClassifier[Uml],
   to: Set[UMLConnector[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Substitution_substitution_reference_contract_Classifier
  (from: UMLSubstitution[Uml],
   to: Option[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_TemplateBinding_templateBinding_compose_parameterSubstitution_TemplateParameterSubstitution
  (from: UMLTemplateBinding[Uml],
   to: Set[UMLTemplateParameterSubstitution[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_TemplateBinding_templateBinding_reference_signature_TemplateSignature
  (from: UMLTemplateBinding[Uml],
   to: Option[UMLTemplateSignature[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_TemplateParameter_templateParameter_reference_default_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_TemplateParameter_templateParameter_compose_ownedDefault_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_TemplateParameter_owningTemplateParameter_compose_ownedParameteredElement_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_TemplateParameter_templateParameter_reference_parameteredElement_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_TemplateParameterSubstitution_templateParameterSubstitution_reference_actual_ParameterableElement
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLParameterableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_TemplateParameterSubstitution_templateParameterSubstitution_reference_formal_TemplateParameter
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLTemplateParameter[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_TemplateParameterSubstitution_owningTemplateParameterSubstitution_compose_ownedActual_ParameterableElement
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLParameterableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_TemplateSignature_signature_compose_ownedParameter_TemplateParameter
  (from: UMLTemplateSignature[Uml],
   to: Seq[UMLTemplateParameter[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_TemplateSignature_templateSignature_reference_parameter_TemplateParameter
  (from: UMLTemplateSignature[Uml],
   to: Seq[UMLTemplateParameter[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature
  (from: UMLTemplateableElement[Uml],
   to: Option[UMLTemplateSignature[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding
  (from: UMLTemplateableElement[Uml],
   to: Set[UMLTemplateBinding[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_TestIdentityAction_testIdentityAction_compose_first_InputPin
  (from: UMLTestIdentityAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_TestIdentityAction_testIdentityAction_compose_result_OutputPin
  (from: UMLTestIdentityAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_TestIdentityAction_testIdentityAction_compose_second_InputPin
  (from: UMLTestIdentityAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_TimeConstraint_timeConstraint_compose_specification_TimeInterval
  (from: UMLTimeConstraint[Uml],
   to: Option[UMLTimeInterval[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_TimeConstraint_firstEvent
  (e: UMLTimeConstraint[Uml], firstEvent: Option[Boolean]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_TimeEvent_timeEvent_compose_when_TimeExpression
  (from: UMLTimeEvent[Uml],
   to: Option[UMLTimeExpression[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_TimeEvent_isRelative
  (e: UMLTimeEvent[Uml], isRelative: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_TimeExpression_timeExpression_compose_expr_ValueSpecification
  (from: UMLTimeExpression[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_TimeExpression_timeExpression_reference_observation_Observation
  (from: UMLTimeExpression[Uml],
   to: Set[UMLObservation[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_TimeInterval_timeInterval_reference_max_TimeExpression
  (from: UMLTimeInterval[Uml],
   to: Option[UMLTimeExpression[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_TimeInterval_timeInterval_reference_min_TimeExpression
  (from: UMLTimeInterval[Uml],
   to: Option[UMLTimeExpression[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_TimeObservation_timeObservation_reference_event_NamedElement
  (from: UMLTimeObservation[Uml],
   to: Option[UMLNamedElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_TimeObservation_firstEvent
  (e: UMLTimeObservation[Uml], firstEvent: Boolean): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Transition_transition_compose_effect_Behavior
  (from: UMLTransition[Uml],
   to: Option[UMLBehavior[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Transition_transition_compose_guard_Constraint
  (from: UMLTransition[Uml],
   to: Option[UMLConstraint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Transition_transition_reference_redefinedTransition_Transition
  (from: UMLTransition[Uml],
   to: Option[UMLTransition[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Transition_transition_compose_trigger_Trigger
  (from: UMLTransition[Uml],
   to: Set[UMLTrigger[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def set_Transition_kind
  (e: UMLTransition[Uml], kind: Option[UMLTransitionKind.Value]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_Trigger_trigger_reference_event_Event
  (from: UMLTrigger[Uml],
   to: Option[UMLEvent[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Trigger_trigger_reference_port_Port
  (from: UMLTrigger[Uml],
   to: Set[UMLPort[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_TypedElement_typedElement_reference_type_Type
  (from: UMLTypedElement[Uml],
   to: Option[UMLType[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_UnmarshallAction_unmarshallAction_compose_object_InputPin
  (from: UMLUnmarshallAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_UnmarshallAction_unmarshallAction_compose_result_OutputPin
  (from: UMLUnmarshallAction[Uml],
   to: Seq[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_UnmarshallAction_unmarshallAction_reference_unmarshallType_Classifier
  (from: UMLUnmarshallAction[Uml],
   to: Option[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_UseCase_extension_compose_extend_Extend
  (from: UMLUseCase[Uml],
   to: Set[UMLExtend[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_UseCase_useCase_compose_extensionPoint_ExtensionPoint
  (from: UMLUseCase[Uml],
   to: Set[UMLExtensionPoint[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_UseCase_includingCase_compose_include_Include
  (from: UMLUseCase[Uml],
   to: Set[UMLInclude[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_UseCase_useCase_reference_subject_Classifier
  (from: UMLUseCase[Uml],
   to: Set[UMLClassifier[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_ValuePin_valuePin_compose_value_ValueSpecification
  (from: UMLValuePin[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_ValueSpecificationAction_valueSpecificationAction_compose_result_OutputPin
  (from: UMLValueSpecificationAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_ValueSpecificationAction_valueSpecificationAction_compose_value_ValueSpecification
  (from: UMLValueSpecificationAction[Uml],
   to: Option[UMLValueSpecification[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit


  def links_VariableAction_variableAction_reference_variable_Variable
  (from: UMLVariableAction[Uml],
   to: Option[UMLVariable[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit



  def links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_result_OutputPin
  (from: UMLWriteStructuralFeatureAction[Uml],
   to: Option[UMLOutputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_value_InputPin
  (from: UMLWriteStructuralFeatureAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  def links_WriteVariableAction_writeVariableAction_compose_value_InputPin
  (from: UMLWriteVariableAction[Uml],
   to: Option[UMLInputPin[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

  // was: MetaPropertyReference2LinksUpdate: Seq of CompositeReferenceUpdater
  val AssociationMetaPropertyOption2LinksUpdate
  : Seq[AssociationMetaPropertyOptionUpdater]
  = Seq() :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Abstraction_abstraction_compose_mapping_OpaqueExpression _,
        ops.Abstraction_mapping) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_AcceptCallAction_acceptCallAction_compose_returnInformation_OutputPin _,
        ops.AcceptCallAction_returnInformation) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActionExecutionSpecification_actionExecutionSpecification_reference_action_Action _,
        ops.ActionExecutionSpecification_action) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActionInputPin_actionInputPin_compose_fromAction_Action _,
        ops.ActionInputPin_fromAction) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityEdge_activityEdge_compose_guard_ValueSpecification _,
        ops.ActivityEdge_guard) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityEdge_interruptingEdge_reference_interrupts_InterruptibleActivityRegion _,
        ops.ActivityEdge_interrupts) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityEdge_outgoing_reference_source_ActivityNode _,
        ops.ActivityEdge_source) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityEdge_incoming_reference_target_ActivityNode _,
        ops.ActivityEdge_target) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityEdge_activityEdge_compose_weight_ValueSpecification _,
        ops.ActivityEdge_weight) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityParameterNode_activityParameterNode_reference_parameter_Parameter _,
        ops.ActivityParameterNode_parameter) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityPartition_activityPartition_reference_represents_Element _,
        ops.ActivityPartition_represents) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_AddStructuralFeatureValueAction_addStructuralFeatureValueAction_compose_insertAt_InputPin _,
        ops.AddStructuralFeatureValueAction_insertAt) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_AddVariableValueAction_addVariableValueAction_compose_insertAt_InputPin _,
        ops.AddVariableValueAction_insertAt) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Behavior_method_reference_specification_BehavioralFeature _,
        ops.Behavior_specification) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_BehaviorExecutionSpecification_behaviorExecutionSpecification_reference_behavior_Behavior _,
        ops.BehaviorExecutionSpecification_behavior) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
        ops.BehavioredClassifier_classifierBehavior) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_BroadcastSignalAction_broadcastSignalAction_reference_signal_Signal _,
        ops.BroadcastSignalAction_signal) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CallBehaviorAction_callBehaviorAction_reference_behavior_Behavior _,
        ops.CallBehaviorAction_behavior) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CallEvent_callEvent_reference_operation_Operation _,
        ops.CallEvent_operation) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CallOperationAction_callOperationAction_reference_operation_Operation _,
        ops.CallOperationAction_operation) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CallOperationAction_callOperationAction_compose_target_InputPin _,
        ops.CallOperationAction_target) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ChangeEvent_changeEvent_compose_changeExpression_ValueSpecification _,
        ops.ChangeEvent_changeExpression) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
        ops.Classifier_ownedTemplateSignature) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Classifier_classifier_reference_representation_CollaborationUse _,
        ops.Classifier_representation) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
        ops.Classifier_templateParameter) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ClassifierTemplateParameter_templateParameter_reference_parameteredElement_Classifier _,
        ops.ClassifierTemplateParameter_parameteredElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Clause_clause_reference_decider_OutputPin _,
        ops.Clause_decider) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ClearAssociationAction_clearAssociationAction_reference_association_Association _,
        ops.ClearAssociationAction_association) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ClearAssociationAction_clearAssociationAction_compose_object_InputPin _,
        ops.ClearAssociationAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ClearStructuralFeatureAction_clearStructuralFeatureAction_compose_result_OutputPin _,
        ops.ClearStructuralFeatureAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CollaborationUse_collaborationUse_reference_type_Collaboration _,
        ops.CollaborationUse_type) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter _,
        ops.ConnectableElement_templateParameter) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ConnectableElementTemplateParameter_templateParameter_reference_parameteredElement_ConnectableElement _,
        ops.ConnectableElementTemplateParameter_parameteredElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Connector_connector_reference_type_Association _,
        ops.Connector_type) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ConnectorEnd_connectorEnd_reference_partWithPort_Property _,
        ops.ConnectorEnd_partWithPort) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Constraint_owningConstraint_compose_specification_ValueSpecification _,
        ops.Constraint_specification) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CreateLinkObjectAction_createLinkObjectAction_compose_result_OutputPin _,
        ops.CreateLinkObjectAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CreateObjectAction_createObjectAction_reference_classifier_Classifier _,
        ops.CreateObjectAction_classifier) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CreateObjectAction_createObjectAction_compose_result_OutputPin _,
        ops.CreateObjectAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_DecisionNode_decisionNode_reference_decisionInput_Behavior _,
        ops.DecisionNode_decisionInput) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_DecisionNode_decisionNode_reference_decisionInputFlow_ObjectFlow _,
        ops.DecisionNode_decisionInputFlow) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_DestroyObjectAction_destroyObjectAction_compose_target_InputPin _,
        ops.DestroyObjectAction_target) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Duration_duration_compose_expr_ValueSpecification _,
        ops.Duration_expr) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_DurationConstraint_durationConstraint_compose_specification_DurationInterval _,
        ops.DurationConstraint_specification) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_DurationInterval_durationInterval_reference_max_Duration _,
        ops.DurationInterval_max) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_DurationInterval_durationInterval_reference_min_Duration _,
        ops.DurationInterval_min) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ElementImport_import_reference_importedElement_PackageableElement _,
        ops.ElementImport_importedElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExceptionHandler_exceptionHandler_reference_exceptionInput_ObjectNode _,
        ops.ExceptionHandler_exceptionInput) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExceptionHandler_exceptionHandler_reference_handlerBody_ExecutableNode _,
        ops.ExceptionHandler_handlerBody) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExecutionOccurrenceSpecification_executionOccurrenceSpecification_reference_execution_ExecutionSpecification _,
        ops.ExecutionOccurrenceSpecification_execution) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExecutionSpecification_executionSpecification_reference_finish_OccurrenceSpecification _,
        ops.ExecutionSpecification_finish) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExecutionSpecification_executionSpecification_reference_start_OccurrenceSpecification _,
        ops.ExecutionSpecification_start) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExpansionNode_inputElement_reference_regionAsInput_ExpansionRegion _,
        ops.ExpansionNode_regionAsInput) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExpansionNode_outputElement_reference_regionAsOutput_ExpansionRegion _,
        ops.ExpansionNode_regionAsOutput) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Extend_extend_compose_condition_Constraint _,
        ops.Extend_condition) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Extend_extend_reference_extendedCase_UseCase _,
        ops.Extend_extendedCase) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExtensionEnd_extensionEnd_reference_type_Stereotype _,
        ops.ExtensionEnd_type) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_GeneralOrdering_toBefore_reference_after_OccurrenceSpecification _,
        ops.GeneralOrdering_after) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_GeneralOrdering_toAfter_reference_before_OccurrenceSpecification _,
        ops.GeneralOrdering_before) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Generalization_generalization_reference_general_Classifier _,
        ops.Generalization_general) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_GeneralizationSet_powertypeExtent_reference_powertype_Classifier _,
        ops.GeneralizationSet_powertype) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Include_include_reference_addition_UseCase _,
        ops.Include_addition) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InstanceSpecification_owningInstanceSpec_compose_specification_ValueSpecification _,
        ops.InstanceSpecification_specification) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InstanceValue_instanceValue_reference_instance_InstanceSpecification _,
        ops.InstanceValue_instance) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InteractionConstraint_interactionConstraint_compose_maxint_ValueSpecification _,
        ops.InteractionConstraint_maxint) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InteractionConstraint_interactionConstraint_compose_minint_ValueSpecification _,
        ops.InteractionConstraint_minint) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InteractionOperand_interactionOperand_compose_guard_InteractionConstraint _,
        ops.InteractionOperand_guard) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InteractionUse_interactionUse_reference_refersTo_Interaction _,
        ops.InteractionUse_refersTo) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InteractionUse_interactionUse_compose_returnValue_ValueSpecification _,
        ops.InteractionUse_returnValue) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InteractionUse_interactionUse_reference_returnValueRecipient_Property _,
        ops.InteractionUse_returnValueRecipient) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Interface_interface_compose_protocol_ProtocolStateMachine _,
        ops.Interface_protocol) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InterfaceRealization_interfaceRealization_reference_contract_Interface _,
        ops.InterfaceRealization_contract) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Interval_interval_reference_max_ValueSpecification _,
        ops.Interval_max) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Interval_interval_reference_min_ValueSpecification _,
        ops.Interval_min) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_IntervalConstraint_intervalConstraint_compose_specification_Interval _,
        ops.IntervalConstraint_specification) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InvocationAction_invocationAction_reference_onPort_Port _,
        ops.InvocationAction_onPort) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_JoinNode_joinNode_compose_joinSpec_ValueSpecification _,
        ops.JoinNode_joinSpec) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Lifeline_lifeline_reference_decomposedAs_PartDecomposition _,
        ops.Lifeline_decomposedAs) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Lifeline_lifeline_reference_represents_ConnectableElement _,
        ops.Lifeline_represents) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Lifeline_lifeline_compose_selector_ValueSpecification _,
        ops.Lifeline_selector) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_LinkEndCreationData_linkEndCreationData_reference_insertAt_InputPin _,
        ops.LinkEndCreationData_insertAt) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_LinkEndData_linkEndData_reference_end_Property _,
        ops.LinkEndData_end) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_LinkEndData_linkEndData_reference_value_InputPin _,
        ops.LinkEndData_value) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_LinkEndDestructionData_linkEndDestructionData_reference_destroyAt_InputPin _,
        ops.LinkEndDestructionData_destroyAt) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_LoopNode_loopNode_reference_decider_OutputPin _,
        ops.LoopNode_decider) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Manifestation_manifestation_reference_utilizedElement_PackageableElement _,
        ops.Manifestation_utilizedElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Message_message_reference_connector_Connector _,
        ops.Message_connector) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Message_endMessage_reference_receiveEvent_MessageEnd _,
        ops.Message_receiveEvent) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Message_endMessage_reference_sendEvent_MessageEnd _,
        ops.Message_sendEvent) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Message_message_reference_signature_NamedElement _,
        ops.Message_signature) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_MessageEnd_messageEnd_reference_message_Message _,
        ops.MessageEnd_message) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
        ops.MultiplicityElement_lowerValue) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
        ops.MultiplicityElement_upperValue) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
        ops.NamedElement_nameExpression) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ObjectFlow_objectFlow_reference_selection_Behavior _,
        ops.ObjectFlow_selection) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ObjectFlow_objectFlow_reference_transformation_Behavior _,
        ops.ObjectFlow_transformation) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ObjectNode_objectNode_reference_selection_Behavior _,
        ops.ObjectNode_selection) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ObjectNode_objectNode_compose_upperBound_ValueSpecification _,
        ops.ObjectNode_upperBound) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_OpaqueExpression_opaqueExpression_reference_behavior_Behavior _,
        ops.OpaqueExpression_behavior) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Operation_bodyContext_compose_bodyCondition_Constraint _,
        ops.Operation_bodyCondition) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Operation_parameteredElement_reference_templateParameter_OperationTemplateParameter _,
        ops.Operation_templateParameter) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_OperationTemplateParameter_templateParameter_reference_parameteredElement_Operation _,
        ops.OperationTemplateParameter_parameteredElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_PackageImport_packageImport_reference_importedPackage_Package _,
        ops.PackageImport_importedPackage) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_PackageMerge_packageMerge_reference_mergedPackage_Package _,
        ops.PackageMerge_mergedPackage) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Parameter_owningParameter_compose_defaultValue_ValueSpecification _,
        ops.Parameter_defaultValue) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
        ops.ParameterableElement_templateParameter) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Port_port_reference_protocol_ProtocolStateMachine _,
        ops.Port_protocol) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ProfileApplication_profileApplication_reference_appliedProfile_Profile _,
        ops.ProfileApplication_appliedProfile) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Property_memberEnd_reference_association_Association _,
        ops.Property_association) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Property_owningProperty_compose_defaultValue_ValueSpecification _,
        ops.Property_defaultValue) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ProtocolConformance_protocolConformance_reference_generalMachine_ProtocolStateMachine _,
        ops.ProtocolConformance_generalMachine) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ProtocolTransition_owningTransition_compose_postCondition_Constraint _,
        ops.ProtocolTransition_postCondition) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ProtocolTransition_protocolTransition_compose_preCondition_Constraint _,
        ops.ProtocolTransition_preCondition) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_QualifierValue_qualifierValue_reference_qualifier_Property _,
        ops.QualifierValue_qualifier) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_QualifierValue_qualifierValue_reference_value_InputPin _,
        ops.QualifierValue_value) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_RaiseExceptionAction_raiseExceptionAction_compose_exception_InputPin _,
        ops.RaiseExceptionAction_exception) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadExtentAction_readExtentAction_reference_classifier_Classifier _,
        ops.ReadExtentAction_classifier) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadExtentAction_readExtentAction_compose_result_OutputPin _,
        ops.ReadExtentAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_reference_classifier_Classifier _,
        ops.ReadIsClassifiedObjectAction_classifier) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_object_InputPin _,
        ops.ReadIsClassifiedObjectAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_result_OutputPin _,
        ops.ReadIsClassifiedObjectAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkAction_readLinkAction_compose_result_OutputPin _,
        ops.ReadLinkAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkObjectEndAction_readLinkObjectEndAction_reference_end_Property _,
        ops.ReadLinkObjectEndAction_end) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_object_InputPin _,
        ops.ReadLinkObjectEndAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_result_OutputPin _,
        ops.ReadLinkObjectEndAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_object_InputPin _,
        ops.ReadLinkObjectEndQualifierAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_reference_qualifier_Property _,
        ops.ReadLinkObjectEndQualifierAction_qualifier) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_result_OutputPin _,
        ops.ReadLinkObjectEndQualifierAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadSelfAction_readSelfAction_compose_result_OutputPin _,
        ops.ReadSelfAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadStructuralFeatureAction_readStructuralFeatureAction_compose_result_OutputPin _,
        ops.ReadStructuralFeatureAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadVariableAction_readVariableAction_compose_result_OutputPin _,
        ops.ReadVariableAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Reception_reception_reference_signal_Signal _,
        ops.Reception_signal) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReclassifyObjectAction_reclassifyObjectAction_compose_object_InputPin _,
        ops.ReclassifyObjectAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReduceAction_reduceAction_compose_collection_InputPin _,
        ops.ReduceAction_collection) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReduceAction_reduceAction_reference_reducer_Behavior _,
        ops.ReduceAction_reducer) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReduceAction_reduceAction_compose_result_OutputPin _,
        ops.ReduceAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Region_region_reference_extendedRegion_Region _,
        ops.Region_extendedRegion) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_compose_removeAt_InputPin _,
        ops.RemoveStructuralFeatureValueAction_removeAt) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_RemoveVariableValueAction_removeVariableValueAction_compose_removeAt_InputPin _,
        ops.RemoveVariableValueAction_removeAt) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReplyAction_replyAction_reference_replyToCall_Trigger _,
        ops.ReplyAction_replyToCall) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReplyAction_replyAction_compose_returnInformation_InputPin _,
        ops.ReplyAction_returnInformation) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_SendObjectAction_sendObjectAction_compose_request_InputPin _,
        ops.SendObjectAction_request) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_SendObjectAction_sendObjectAction_compose_target_InputPin _,
        ops.SendObjectAction_target) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_SendSignalAction_sendSignalAction_reference_signal_Signal _,
        ops.SendSignalAction_signal) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_SendSignalAction_sendSignalAction_compose_target_InputPin _,
        ops.SendSignalAction_target) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_SignalEvent_signalEvent_reference_signal_Signal _,
        ops.SignalEvent_signal) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Slot_slot_reference_definingFeature_StructuralFeature _,
        ops.Slot_definingFeature) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_StartClassifierBehaviorAction_startClassifierBehaviorAction_compose_object_InputPin _,
        ops.StartClassifierBehaviorAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_StartObjectBehaviorAction_startObjectBehaviorAction_compose_object_InputPin _,
        ops.StartObjectBehaviorAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_State_state_compose_doActivity_Behavior _,
        ops.State_doActivity) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_State_state_compose_entry_Behavior _,
        ops.State_entry) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_State_state_compose_exit_Behavior _,
        ops.State_exit) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_State_state_reference_redefinedState_State _,
        ops.State_redefinedState) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_State_owningState_compose_stateInvariant_Constraint _,
        ops.State_stateInvariant) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_State_submachineState_reference_submachine_StateMachine _,
        ops.State_submachine) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_StateInvariant_stateInvariant_compose_invariant_Constraint _,
        ops.StateInvariant_invariant) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_StructuralFeatureAction_structuralFeatureAction_compose_object_InputPin _,
        ops.StructuralFeatureAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_StructuralFeatureAction_structuralFeatureAction_reference_structuralFeature_StructuralFeature _,
        ops.StructuralFeatureAction_structuralFeature) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Substitution_substitution_reference_contract_Classifier _,
        ops.Substitution_contract) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateBinding_templateBinding_reference_signature_TemplateSignature _,
        ops.TemplateBinding_signature) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameter_templateParameter_reference_default_ParameterableElement _,
        ops.TemplateParameter_default) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameter_templateParameter_compose_ownedDefault_ParameterableElement _,
        ops.TemplateParameter_ownedDefault) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameter_owningTemplateParameter_compose_ownedParameteredElement_ParameterableElement _,
        ops.TemplateParameter_ownedParameteredElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameter_templateParameter_reference_parameteredElement_ParameterableElement _,
        ops.TemplateParameter_parameteredElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameterSubstitution_templateParameterSubstitution_reference_actual_ParameterableElement _,
        ops.TemplateParameterSubstitution_actual) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameterSubstitution_templateParameterSubstitution_reference_formal_TemplateParameter _,
        ops.TemplateParameterSubstitution_formal) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameterSubstitution_owningTemplateParameterSubstitution_compose_ownedActual_ParameterableElement _,
        ops.TemplateParameterSubstitution_ownedActual) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
        ops.TemplateableElement_ownedTemplateSignature) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TestIdentityAction_testIdentityAction_compose_first_InputPin _,
        ops.TestIdentityAction_first) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TestIdentityAction_testIdentityAction_compose_result_OutputPin _,
        ops.TestIdentityAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TestIdentityAction_testIdentityAction_compose_second_InputPin _,
        ops.TestIdentityAction_second) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TimeConstraint_timeConstraint_compose_specification_TimeInterval _,
        ops.TimeConstraint_specification) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TimeEvent_timeEvent_compose_when_TimeExpression _,
        ops.TimeEvent_when) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TimeExpression_timeExpression_compose_expr_ValueSpecification _,
        ops.TimeExpression_expr) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TimeInterval_timeInterval_reference_max_TimeExpression _,
        ops.TimeInterval_max) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TimeInterval_timeInterval_reference_min_TimeExpression _,
        ops.TimeInterval_min) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TimeObservation_timeObservation_reference_event_NamedElement _,
        ops.TimeObservation_event) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Transition_transition_compose_effect_Behavior _,
        ops.Transition_effect) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Transition_transition_compose_guard_Constraint _,
        ops.Transition_guard) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Transition_transition_reference_redefinedTransition_Transition _,
        ops.Transition_redefinedTransition) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Trigger_trigger_reference_event_Event _,
        ops.Trigger_event) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TypedElement_typedElement_reference_type_Type _,
        ops.TypedElement_type) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_UnmarshallAction_unmarshallAction_compose_object_InputPin _,
        ops.UnmarshallAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_UnmarshallAction_unmarshallAction_reference_unmarshallType_Classifier _,
        ops.UnmarshallAction_unmarshallType) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ValuePin_valuePin_compose_value_ValueSpecification _,
        ops.ValuePin_value) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ValueSpecificationAction_valueSpecificationAction_compose_result_OutputPin _,
        ops.ValueSpecificationAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ValueSpecificationAction_valueSpecificationAction_compose_value_ValueSpecification _,
        ops.ValueSpecificationAction_value) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_VariableAction_variableAction_reference_variable_Variable _,
        ops.VariableAction_variable) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_result_OutputPin _,
        ops.WriteStructuralFeatureAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_value_InputPin _,
        ops.WriteStructuralFeatureAction_value) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_WriteVariableAction_writeVariableAction_compose_value_InputPin _,
        ops.WriteVariableAction_value)
  // was: MetaPropertyIterable2LinksUpdate
  val AssociationMetaPropertyIterable2LinksUpdate
  : Seq[AssociationMetaPropertyIterableUpdater]
  = Seq() :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_Association_owningAssociation_compose_ownedEnd_Property _,
        ops.Association_ownedEnd) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_CreateLinkAction_createLinkAction_compose_endData_LinkEndCreationData _,
        ops.CreateLinkAction_endData) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_DestroyLinkAction_destroyLinkAction_compose_endData_LinkEndDestructionData _,
        ops.DestroyLinkAction_endData) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_Extension_extension_compose_ownedEnd_ExtensionEnd _,
        ops.Extension_ownedEnd) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_InstanceSpecification_instanceSpecification_reference_classifier_Classifier _,
        ops.InstanceSpecification_classifier) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
        ops.InteractionFragment_covered) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_LinkAction_linkAction_compose_endData_LinkEndData _,
        ops.LinkAction_endData) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_OccurrenceSpecification_events_reference_covered_Lifeline _,
        ops.OccurrenceSpecification_covered) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_StateInvariant_stateInvariant_reference_covered_Lifeline _,
        ops.StateInvariant_covered)
  // was: MetaPropertySequence2LinksUpdate
  val AssociationMetaPropertySequence2LinksUpdate
  : Seq[AssociationMetaPropertySequenceUpdater]
  = Seq() :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_AcceptEventAction_acceptEventAction_compose_result_OutputPin _,
        ops.AcceptEventAction_result) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Artifact_artifact_compose_ownedAttribute_Property _,
        ops.Artifact_ownedAttribute) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Artifact_artifact_compose_ownedOperation_Operation _,
        ops.Artifact_ownedOperation) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Association_association_reference_memberEnd_Property _,
        ops.Association_memberEnd) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Behavior_behavior_compose_ownedParameter_Parameter _,
        ops.Behavior_ownedParameter) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_BehavioralFeature_ownerFormalParam_compose_ownedParameter_Parameter _,
        ops.BehavioralFeature_ownedParameter) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_CallAction_callAction_compose_result_OutputPin _,
        ops.CallAction_result) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Class_nestingClass_compose_nestedClassifier_Classifier _,
        ops.Class_nestedClassifier) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Class_class_compose_ownedAttribute_Property _,
        ops.Class_ownedAttribute) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Class_class_compose_ownedOperation_Operation _,
        ops.Class_ownedOperation) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Clause_clause_reference_bodyOutput_OutputPin _,
        ops.Clause_bodyOutput) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_CombinedFragment_combinedFragment_compose_operand_InteractionOperand _,
        ops.CombinedFragment_operand) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_ConditionalNode_conditionalNode_compose_result_OutputPin _,
        ops.ConditionalNode_result) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Connector_connector_compose_end_ConnectorEnd _,
        ops.Connector_end) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Constraint_constraint_reference_constrainedElement_Element _,
        ops.Constraint_constrainedElement) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_DataType_datatype_compose_ownedAttribute_Property _,
        ops.DataType_ownedAttribute) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_DataType_datatype_compose_ownedOperation_Operation _,
        ops.DataType_ownedOperation) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_DurationObservation_durationObservation_reference_event_NamedElement _,
        ops.DurationObservation_event) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Enumeration_enumeration_compose_ownedLiteral_EnumerationLiteral _,
        ops.Enumeration_ownedLiteral) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Expression_expression_compose_operand_ValueSpecification _,
        ops.Expression_operand) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Extend_extension_reference_extensionLocation_ExtensionPoint _,
        ops.Extend_extensionLocation) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Interaction_enclosingInteraction_compose_fragment_InteractionFragment _,
        ops.Interaction_fragment) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_InteractionOperand_enclosingOperand_compose_fragment_InteractionFragment _,
        ops.InteractionOperand_fragment) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_InteractionUse_interactionUse_compose_argument_ValueSpecification _,
        ops.InteractionUse_argument) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Interface_interface_compose_nestedClassifier_Classifier _,
        ops.Interface_nestedClassifier) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Interface_interface_compose_ownedAttribute_Property _,
        ops.Interface_ownedAttribute) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Interface_interface_compose_ownedOperation_Operation _,
        ops.Interface_ownedOperation) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_InvocationAction_invocationAction_compose_argument_InputPin _,
        ops.InvocationAction_argument) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_LoopNode_loopNode_reference_bodyOutput_OutputPin _,
        ops.LoopNode_bodyOutput) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_LoopNode_loopNode_compose_loopVariable_OutputPin _,
        ops.LoopNode_loopVariable) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_LoopNode_loopNode_compose_loopVariableInput_InputPin _,
        ops.LoopNode_loopVariableInput) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_LoopNode_loopNode_compose_result_OutputPin _,
        ops.LoopNode_result) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Message_message_compose_argument_ValueSpecification _,
        ops.Message_argument) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Operation_operation_compose_ownedParameter_Parameter _,
        ops.Operation_ownedParameter) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Property_associationEnd_compose_qualifier_Property _,
        ops.Property_qualifier) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_ReplyAction_replyAction_compose_replyValue_InputPin _,
        ops.ReplyAction_replyValue) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_SequenceNode_sequenceNode_compose_executableNode_ExecutableNode _,
        ops.SequenceNode_executableNode) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Signal_owningSignal_compose_ownedAttribute_Property _,
        ops.Signal_ownedAttribute) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Slot_owningSlot_compose_value_ValueSpecification _,
        ops.Slot_value) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_StringExpression_owningExpression_compose_subExpression_StringExpression _,
        ops.StringExpression_subExpression) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
        ops.StructuredClassifier_ownedAttribute) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_TemplateSignature_signature_compose_ownedParameter_TemplateParameter _,
        ops.TemplateSignature_ownedParameter) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_TemplateSignature_templateSignature_reference_parameter_TemplateParameter _,
        ops.TemplateSignature_parameter) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_UnmarshallAction_unmarshallAction_compose_result_OutputPin _,
        ops.UnmarshallAction_result)
  // was: MetaPropertySet2LinksUpdate
  val AssociationMetaPropertySet2LinksUpdate
  : Seq[AssociationMetaPropertySetUpdater]
  = Seq() :+
      AssociationMetaPropertySetUpdateInfo(
        links_AcceptEventAction_acceptEventAction_compose_trigger_Trigger _,
        ops.AcceptEventAction_trigger) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Action_action_compose_localPostcondition_Constraint _,
        ops.Action_localPostcondition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Action_action_compose_localPrecondition_Constraint _,
        ops.Action_localPrecondition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Activity_activity_compose_edge_ActivityEdge _,
        ops.Activity_edge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Activity_inActivity_compose_group_ActivityGroup _,
        ops.Activity_group) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Activity_activity_compose_node_ActivityNode _,
        ops.Activity_node) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Activity_activity_reference_partition_ActivityPartition _,
        ops.Activity_partition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Activity_activity_compose_structuredNode_StructuredActivityNode _,
        ops.Activity_structuredNode) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Activity_activityScope_compose_variable_Variable _,
        ops.Activity_variable) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityEdge_edge_reference_inPartition_ActivityPartition _,
        ops.ActivityEdge_inPartition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityEdge_activityEdge_reference_redefinedEdge_ActivityEdge _,
        ops.ActivityEdge_redefinedEdge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
        ops.ActivityNode_inInterruptibleRegion) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityNode_node_reference_inPartition_ActivityPartition _,
        ops.ActivityNode_inPartition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityNode_target_reference_incoming_ActivityEdge _,
        ops.ActivityNode_incoming) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityNode_source_reference_outgoing_ActivityEdge _,
        ops.ActivityNode_outgoing) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
        ops.ActivityNode_redefinedNode) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityPartition_inPartition_reference_edge_ActivityEdge _,
        ops.ActivityPartition_edge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityPartition_inPartition_reference_node_ActivityNode _,
        ops.ActivityPartition_node) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityPartition_superPartition_compose_subpartition_ActivityPartition _,
        ops.ActivityPartition_subpartition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Artifact_artifact_compose_manifestation_Manifestation _,
        ops.Artifact_manifestation) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Artifact_artifact_compose_nestedArtifact_Artifact _,
        ops.Artifact_nestedArtifact) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Association_association_reference_navigableOwnedEnd_Property _,
        ops.Association_navigableOwnedEnd) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Behavior_behavior_compose_ownedParameterSet_ParameterSet _,
        ops.Behavior_ownedParameterSet) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Behavior_behavior_compose_postcondition_Constraint _,
        ops.Behavior_postcondition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Behavior_behavior_compose_precondition_Constraint _,
        ops.Behavior_precondition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Behavior_behavior_reference_redefinedBehavior_Behavior _,
        ops.Behavior_redefinedBehavior) :+
      AssociationMetaPropertySetUpdateInfo(
        links_BehavioralFeature_specification_reference_method_Behavior _,
        ops.BehavioralFeature_method) :+
      AssociationMetaPropertySetUpdateInfo(
        links_BehavioralFeature_behavioralFeature_compose_ownedParameterSet_ParameterSet _,
        ops.BehavioralFeature_ownedParameterSet) :+
      AssociationMetaPropertySetUpdateInfo(
        links_BehavioralFeature_behavioralFeature_reference_raisedException_Type _,
        ops.BehavioralFeature_raisedException) :+
      AssociationMetaPropertySetUpdateInfo(
        links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
        ops.BehavioredClassifier_interfaceRealization) :+
      AssociationMetaPropertySetUpdateInfo(
        links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
        ops.BehavioredClassifier_ownedBehavior) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Class_class_compose_ownedReception_Reception _,
        ops.Class_ownedReception) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
        ops.Classifier_collaborationUse) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_specific_compose_generalization_Generalization _,
        ops.Classifier_generalization) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_classifier_compose_ownedUseCase_UseCase _,
        ops.Classifier_ownedUseCase) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
        ops.Classifier_powertypeExtent) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
        ops.Classifier_redefinedClassifier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
        ops.Classifier_substitution) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_subject_reference_useCase_UseCase _,
        ops.Classifier_useCase) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ClassifierTemplateParameter_classifierTemplateParameter_reference_constrainingClassifier_Classifier _,
        ops.ClassifierTemplateParameter_constrainingClassifier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Clause_clause_reference_body_ExecutableNode _,
        ops.Clause_body) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Clause_successorClause_reference_predecessorClause_Clause _,
        ops.Clause_predecessorClause) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Clause_predecessorClause_reference_successorClause_Clause _,
        ops.Clause_successorClause) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Clause_clause_reference_test_ExecutableNode _,
        ops.Clause_test) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Collaboration_collaboration_reference_collaborationRole_ConnectableElement _,
        ops.Collaboration_collaborationRole) :+
      AssociationMetaPropertySetUpdateInfo(
        links_CollaborationUse_collaborationUse_compose_roleBinding_Dependency _,
        ops.CollaborationUse_roleBinding) :+
      AssociationMetaPropertySetUpdateInfo(
        links_CombinedFragment_combinedFragment_compose_cfragmentGate_Gate _,
        ops.CombinedFragment_cfragmentGate) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Comment_comment_reference_annotatedElement_Element _,
        ops.Comment_annotatedElement) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Component_component_compose_packagedElement_PackageableElement _,
        ops.Component_packagedElement) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Component_abstraction_compose_realization_ComponentRealization _,
        ops.Component_realization) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ComponentRealization_componentRealization_reference_realizingClassifier_Classifier _,
        ops.ComponentRealization_realizingClassifier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ConditionalNode_conditionalNode_compose_clause_Clause _,
        ops.ConditionalNode_clause) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ConnectionPointReference_connectionPointReference_reference_entry_Pseudostate _,
        ops.ConnectionPointReference_entry) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ConnectionPointReference_connectionPointReference_reference_exit_Pseudostate _,
        ops.ConnectionPointReference_exit) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Connector_connector_reference_contract_Behavior _,
        ops.Connector_contract) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Connector_connector_reference_redefinedConnector_Connector _,
        ops.Connector_redefinedConnector) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ConsiderIgnoreFragment_considerIgnoreFragment_reference_message_NamedElement _,
        ops.ConsiderIgnoreFragment_message) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Dependency_supplierDependency_reference_supplier_NamedElement _,
        ops.Dependency_supplier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Deployment_deployment_compose_configuration_DeploymentSpecification _,
        ops.Deployment_configuration) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Deployment_deploymentForArtifact_reference_deployedArtifact_DeployedArtifact _,
        ops.Deployment_deployedArtifact) :+
      AssociationMetaPropertySetUpdateInfo(
        links_DeploymentTarget_location_compose_deployment_Deployment _,
        ops.DeploymentTarget_deployment) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Duration_duration_reference_observation_Observation _,
        ops.Duration_observation) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Element_owningElement_compose_ownedComment_Comment _,
        ops.Element_ownedComment) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ExceptionHandler_exceptionHandler_reference_exceptionType_Classifier _,
        ops.ExceptionHandler_exceptionType) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
        ops.ExecutableNode_handler) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ExpansionRegion_regionAsInput_reference_inputElement_ExpansionNode _,
        ops.ExpansionRegion_inputElement) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ExpansionRegion_regionAsOutput_reference_outputElement_ExpansionNode _,
        ops.ExpansionRegion_outputElement) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Generalization_generalization_reference_generalizationSet_GeneralizationSet _,
        ops.Generalization_generalizationSet) :+
      AssociationMetaPropertySetUpdateInfo(
        links_GeneralizationSet_generalizationSet_reference_generalization_Generalization _,
        ops.GeneralizationSet_generalization) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_conveyingFlow_reference_conveyed_Classifier _,
        ops.InformationFlow_conveyed) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_informationFlow_reference_informationSource_NamedElement _,
        ops.InformationFlow_informationSource) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_informationFlow_reference_informationTarget_NamedElement _,
        ops.InformationFlow_informationTarget) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_abstraction_reference_realization_Relationship _,
        ops.InformationFlow_realization) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_informationFlow_reference_realizingActivityEdge_ActivityEdge _,
        ops.InformationFlow_realizingActivityEdge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_informationFlow_reference_realizingConnector_Connector _,
        ops.InformationFlow_realizingConnector) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_informationFlow_reference_realizingMessage_Message _,
        ops.InformationFlow_realizingMessage) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationItem_representation_reference_represented_Classifier _,
        ops.InformationItem_represented) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InstanceSpecification_owningInstance_compose_slot_Slot _,
        ops.InstanceSpecification_slot) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Interaction_interaction_compose_action_Action _,
        ops.Interaction_action) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Interaction_interaction_compose_formalGate_Gate _,
        ops.Interaction_formalGate) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Interaction_interaction_compose_lifeline_Lifeline _,
        ops.Interaction_lifeline) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Interaction_interaction_compose_message_Message _,
        ops.Interaction_message) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
        ops.InteractionFragment_generalOrdering) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InteractionUse_interactionUse_compose_actualGate_Gate _,
        ops.InteractionUse_actualGate) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Interface_interface_compose_ownedReception_Reception _,
        ops.Interface_ownedReception) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Interface_interface_reference_redefinedInterface_Interface _,
        ops.Interface_redefinedInterface) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InterruptibleActivityRegion_interrupts_reference_interruptingEdge_ActivityEdge _,
        ops.InterruptibleActivityRegion_interruptingEdge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InterruptibleActivityRegion_inInterruptibleRegion_reference_node_ActivityNode _,
        ops.InterruptibleActivityRegion_node) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Lifeline_covered_reference_coveredBy_InteractionFragment _,
        ops.Lifeline_coveredBy) :+
      AssociationMetaPropertySetUpdateInfo(
        links_LinkAction_linkAction_compose_inputValue_InputPin _,
        ops.LinkAction_inputValue) :+
      AssociationMetaPropertySetUpdateInfo(
        links_LinkEndData_linkEndData_compose_qualifier_QualifierValue _,
        ops.LinkEndData_qualifier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_LoopNode_loopNode_reference_bodyPart_ExecutableNode _,
        ops.LoopNode_bodyPart) :+
      AssociationMetaPropertySetUpdateInfo(
        links_LoopNode_loopNode_reference_setupPart_ExecutableNode _,
        ops.LoopNode_setupPart) :+
      AssociationMetaPropertySetUpdateInfo(
        links_LoopNode_loopNode_reference_test_ExecutableNode _,
        ops.LoopNode_test) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
        ops.Namespace_elementImport) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Namespace_context_compose_ownedRule_Constraint _,
        ops.Namespace_ownedRule) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
        ops.Namespace_packageImport) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Node_node_compose_nestedNode_Node _,
        ops.Node_nestedNode) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ObjectNode_objectNode_reference_inState_State _,
        ops.ObjectNode_inState) :+
      AssociationMetaPropertySetUpdateInfo(
        links_OccurrenceSpecification_before_reference_toAfter_GeneralOrdering _,
        ops.OccurrenceSpecification_toAfter) :+
      AssociationMetaPropertySetUpdateInfo(
        links_OccurrenceSpecification_after_reference_toBefore_GeneralOrdering _,
        ops.OccurrenceSpecification_toBefore) :+
      AssociationMetaPropertySetUpdateInfo(
        links_OpaqueAction_opaqueAction_compose_inputValue_InputPin _,
        ops.OpaqueAction_inputValue) :+
      AssociationMetaPropertySetUpdateInfo(
        links_OpaqueAction_opaqueAction_compose_outputValue_OutputPin _,
        ops.OpaqueAction_outputValue) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Operation_postContext_compose_postcondition_Constraint _,
        ops.Operation_postcondition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Operation_preContext_compose_precondition_Constraint _,
        ops.Operation_precondition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Operation_operation_reference_raisedException_Type _,
        ops.Operation_raisedException) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Operation_operation_reference_redefinedOperation_Operation _,
        ops.Operation_redefinedOperation) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Package_receivingPackage_compose_packageMerge_PackageMerge _,
        ops.Package_packageMerge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Package_owningPackage_compose_packagedElement_PackageableElement _,
        ops.Package_packagedElement) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Package_applyingPackage_compose_profileApplication_ProfileApplication _,
        ops.Package_profileApplication) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Parameter_parameter_reference_parameterSet_ParameterSet _,
        ops.Parameter_parameterSet) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ParameterSet_parameterSet_compose_condition_Constraint _,
        ops.ParameterSet_condition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ParameterSet_parameterSet_reference_parameter_Parameter _,
        ops.ParameterSet_parameter) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Port_port_reference_redefinedPort_Port _,
        ops.Port_redefinedPort) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Profile_profile_compose_metaclassReference_ElementImport _,
        ops.Profile_metaclassReference) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Profile_profile_compose_metamodelReference_PackageImport _,
        ops.Profile_metamodelReference) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Property_property_reference_redefinedProperty_Property _,
        ops.Property_redefinedProperty) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Property_property_reference_subsettedProperty_Property _,
        ops.Property_subsettedProperty) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ProtocolStateMachine_specificMachine_compose_conformance_ProtocolConformance _,
        ops.ProtocolStateMachine_conformance) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ReclassifyObjectAction_reclassifyObjectAction_reference_newClassifier_Classifier _,
        ops.ReclassifyObjectAction_newClassifier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ReclassifyObjectAction_reclassifyObjectAction_reference_oldClassifier_Classifier _,
        ops.ReclassifyObjectAction_oldClassifier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_RedefinableTemplateSignature_redefinableTemplateSignature_reference_extendedSignature_RedefinableTemplateSignature _,
        ops.RedefinableTemplateSignature_extendedSignature) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Region_container_compose_subvertex_Vertex _,
        ops.Region_subvertex) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Region_container_compose_transition_Transition _,
        ops.Region_transition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_State_state_compose_connection_ConnectionPointReference _,
        ops.State_connection) :+
      AssociationMetaPropertySetUpdateInfo(
        links_State_state_compose_connectionPoint_Pseudostate _,
        ops.State_connectionPoint) :+
      AssociationMetaPropertySetUpdateInfo(
        links_State_state_compose_deferrableTrigger_Trigger _,
        ops.State_deferrableTrigger) :+
      AssociationMetaPropertySetUpdateInfo(
        links_State_state_compose_region_Region _,
        ops.State_region) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StateMachine_stateMachine_compose_connectionPoint_Pseudostate _,
        ops.StateMachine_connectionPoint) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StateMachine_stateMachine_reference_extendedStateMachine_StateMachine _,
        ops.StateMachine_extendedStateMachine) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StateMachine_stateMachine_compose_region_Region _,
        ops.StateMachine_region) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StateMachine_submachine_reference_submachineState_State _,
        ops.StateMachine_submachineState) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Stereotype_stereotype_compose_icon_Image _,
        ops.Stereotype_icon) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge _,
        ops.StructuredActivityNode_edge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode _,
        ops.StructuredActivityNode_node) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin _,
        ops.StructuredActivityNode_structuredNodeInput) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin _,
        ops.StructuredActivityNode_structuredNodeOutput) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StructuredActivityNode_scope_compose_variable_Variable _,
        ops.StructuredActivityNode_variable) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
        ops.StructuredClassifier_ownedConnector) :+
      AssociationMetaPropertySetUpdateInfo(
        links_TemplateBinding_templateBinding_compose_parameterSubstitution_TemplateParameterSubstitution _,
        ops.TemplateBinding_parameterSubstitution) :+
      AssociationMetaPropertySetUpdateInfo(
        links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
        ops.TemplateableElement_templateBinding) :+
      AssociationMetaPropertySetUpdateInfo(
        links_TimeExpression_timeExpression_reference_observation_Observation _,
        ops.TimeExpression_observation) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Transition_transition_compose_trigger_Trigger _,
        ops.Transition_trigger) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Trigger_trigger_reference_port_Port _,
        ops.Trigger_port) :+
      AssociationMetaPropertySetUpdateInfo(
        links_UseCase_extension_compose_extend_Extend _,
        ops.UseCase_extend) :+
      AssociationMetaPropertySetUpdateInfo(
        links_UseCase_useCase_compose_extensionPoint_ExtensionPoint _,
        ops.UseCase_extensionPoint) :+
      AssociationMetaPropertySetUpdateInfo(
        links_UseCase_includingCase_compose_include_Include _,
        ops.UseCase_include) :+
      AssociationMetaPropertySetUpdateInfo(
        links_UseCase_useCase_reference_subject_Classifier _,
        ops.UseCase_subject)
  import UMLAttributeUpdater._


  val MetaScalarAttributeUpdater_AcceptEventAction_isUnmarshall =
      MetaScalarAttributeUpdater(
        set_AcceptEventAction_isUnmarshall _,
        ops.AcceptEventAction_isUnmarshall,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Action_isLocallyReentrant =
      MetaScalarAttributeUpdater(
        set_Action_isLocallyReentrant _,
        ops.Action_isLocallyReentrant,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Activity_isReadOnly =
      MetaScalarAttributeUpdater(
        set_Activity_isReadOnly _,
        ops.Activity_isReadOnly,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Activity_isSingleExecution =
      MetaScalarAttributeUpdater(
        set_Activity_isSingleExecution _,
        ops.Activity_isSingleExecution,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_ActivityPartition_isDimension =
      MetaScalarAttributeUpdater(
        set_ActivityPartition_isDimension _,
        ops.ActivityPartition_isDimension,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_ActivityPartition_isExternal =
      MetaScalarAttributeUpdater(
        set_ActivityPartition_isExternal _,
        ops.ActivityPartition_isExternal,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_AddStructuralFeatureValueAction_isReplaceAll =
      MetaScalarAttributeUpdater(
        set_AddStructuralFeatureValueAction_isReplaceAll _,
        ops.AddStructuralFeatureValueAction_isReplaceAll,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_AddVariableValueAction_isReplaceAll =
      MetaScalarAttributeUpdater(
        set_AddVariableValueAction_isReplaceAll _,
        ops.AddVariableValueAction_isReplaceAll,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Association_isDerived =
      MetaScalarAttributeUpdater(
        set_Association_isDerived _,
        ops.Association_isDerived,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Behavior_isReentrant =
      MetaScalarAttributeUpdater(
        set_Behavior_isReentrant _,
        ops.Behavior_isReentrant,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_BehavioralFeature_isAbstract =
      MetaScalarAttributeUpdater(
        set_BehavioralFeature_isAbstract _,
        ops.BehavioralFeature_isAbstract,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_CallAction_isSynchronous =
      MetaScalarAttributeUpdater(
        set_CallAction_isSynchronous _,
        ops.CallAction_isSynchronous,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Class_isAbstract =
      MetaScalarAttributeUpdater(
        set_Class_isAbstract _,
        ops.Class_isAbstract,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Class_isActive =
      MetaScalarAttributeUpdater(
        set_Class_isActive _,
        ops.Class_isActive,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Classifier_isAbstract =
      MetaScalarAttributeUpdater(
        set_Classifier_isAbstract _,
        ops.Classifier_isAbstract,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Classifier_isFinalSpecialization =
      MetaScalarAttributeUpdater(
        set_Classifier_isFinalSpecialization _,
        ops.Classifier_isFinalSpecialization,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_ClassifierTemplateParameter_allowSubstitutable =
      MetaScalarAttributeUpdater(
        set_ClassifierTemplateParameter_allowSubstitutable _,
        ops.ClassifierTemplateParameter_allowSubstitutable,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Component_isIndirectlyInstantiated =
      MetaScalarAttributeUpdater(
        set_Component_isIndirectlyInstantiated _,
        ops.Component_isIndirectlyInstantiated,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_ConditionalNode_isAssured =
      MetaScalarAttributeUpdater(
        set_ConditionalNode_isAssured _,
        ops.ConditionalNode_isAssured,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_ConditionalNode_isDeterminate =
      MetaScalarAttributeUpdater(
        set_ConditionalNode_isDeterminate _,
        ops.ConditionalNode_isDeterminate,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Continuation_setting =
      MetaScalarAttributeUpdater(
        set_Continuation_setting _,
        ops.Continuation_setting,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_DestroyObjectAction_isDestroyLinks =
      MetaScalarAttributeUpdater(
        set_DestroyObjectAction_isDestroyLinks _,
        ops.DestroyObjectAction_isDestroyLinks,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_DestroyObjectAction_isDestroyOwnedObjects =
      MetaScalarAttributeUpdater(
        set_DestroyObjectAction_isDestroyOwnedObjects _,
        ops.DestroyObjectAction_isDestroyOwnedObjects,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Feature_isStatic =
      MetaScalarAttributeUpdater(
        set_Feature_isStatic _,
        ops.Feature_isStatic,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_GeneralizationSet_isCovering =
      MetaScalarAttributeUpdater(
        set_GeneralizationSet_isCovering _,
        ops.GeneralizationSet_isCovering,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_GeneralizationSet_isDisjoint =
      MetaScalarAttributeUpdater(
        set_GeneralizationSet_isDisjoint _,
        ops.GeneralizationSet_isDisjoint,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_JoinNode_isCombineDuplicate =
      MetaScalarAttributeUpdater(
        set_JoinNode_isCombineDuplicate _,
        ops.JoinNode_isCombineDuplicate,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_LinkEndCreationData_isReplaceAll =
      MetaScalarAttributeUpdater(
        set_LinkEndCreationData_isReplaceAll _,
        ops.LinkEndCreationData_isReplaceAll,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_LinkEndDestructionData_isDestroyDuplicates =
      MetaScalarAttributeUpdater(
        set_LinkEndDestructionData_isDestroyDuplicates _,
        ops.LinkEndDestructionData_isDestroyDuplicates,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_LiteralBoolean_value =
      MetaScalarAttributeUpdater(
        set_LiteralBoolean_value _,
        ops.LiteralBoolean_value,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_LiteralInteger_value =
      MetaScalarAttributeUpdater(
        set_LiteralInteger_value _,
        ops.LiteralInteger_value,
        IntegerValueConverter.convert)

  val MetaScalarAttributeUpdater_LiteralReal_value =
      MetaScalarAttributeUpdater(
        set_LiteralReal_value _,
        ops.LiteralReal_value,
        DoubleValueConverter.convert)

  val MetaScalarAttributeUpdater_LiteralUnlimitedNatural_value =
      MetaScalarAttributeUpdater(
        set_LiteralUnlimitedNatural_value _,
        ops.LiteralUnlimitedNatural_value,
        StringValueConverter.convert)

  val MetaScalarAttributeUpdater_LoopNode_isTestedFirst =
      MetaScalarAttributeUpdater(
        set_LoopNode_isTestedFirst _,
        ops.LoopNode_isTestedFirst,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_MultiplicityElement_isOrdered =
      MetaScalarAttributeUpdater(
        set_MultiplicityElement_isOrdered _,
        ops.MultiplicityElement_isOrdered,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_MultiplicityElement_isUnique =
      MetaScalarAttributeUpdater(
        set_MultiplicityElement_isUnique _,
        ops.MultiplicityElement_isUnique,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_ObjectFlow_isMulticast =
      MetaScalarAttributeUpdater(
        set_ObjectFlow_isMulticast _,
        ops.ObjectFlow_isMulticast,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_ObjectFlow_isMultireceive =
      MetaScalarAttributeUpdater(
        set_ObjectFlow_isMultireceive _,
        ops.ObjectFlow_isMultireceive,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_ObjectNode_isControlType =
      MetaScalarAttributeUpdater(
        set_ObjectNode_isControlType _,
        ops.ObjectNode_isControlType,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Operation_isQuery =
      MetaScalarAttributeUpdater(
        set_Operation_isQuery _,
        ops.Operation_isQuery,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Parameter_isException =
      MetaScalarAttributeUpdater(
        set_Parameter_isException _,
        ops.Parameter_isException,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Parameter_isStream =
      MetaScalarAttributeUpdater(
        set_Parameter_isStream _,
        ops.Parameter_isStream,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Pin_isControl =
      MetaScalarAttributeUpdater(
        set_Pin_isControl _,
        ops.Pin_isControl,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Port_isBehavior =
      MetaScalarAttributeUpdater(
        set_Port_isBehavior _,
        ops.Port_isBehavior,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Port_isConjugated =
      MetaScalarAttributeUpdater(
        set_Port_isConjugated _,
        ops.Port_isConjugated,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Port_isService =
      MetaScalarAttributeUpdater(
        set_Port_isService _,
        ops.Port_isService,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_ProfileApplication_isStrict =
      MetaScalarAttributeUpdater(
        set_ProfileApplication_isStrict _,
        ops.ProfileApplication_isStrict,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Property_isDerived =
      MetaScalarAttributeUpdater(
        set_Property_isDerived _,
        ops.Property_isDerived,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Property_isDerivedUnion =
      MetaScalarAttributeUpdater(
        set_Property_isDerivedUnion _,
        ops.Property_isDerivedUnion,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_Property_isID =
      MetaScalarAttributeUpdater(
        set_Property_isID _,
        ops.Property_isID,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_ReadIsClassifiedObjectAction_isDirect =
      MetaScalarAttributeUpdater(
        set_ReadIsClassifiedObjectAction_isDirect _,
        ops.ReadIsClassifiedObjectAction_isDirect,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_ReclassifyObjectAction_isReplaceAll =
      MetaScalarAttributeUpdater(
        set_ReclassifyObjectAction_isReplaceAll _,
        ops.ReclassifyObjectAction_isReplaceAll,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_RedefinableElement_isLeaf =
      MetaScalarAttributeUpdater(
        set_RedefinableElement_isLeaf _,
        ops.RedefinableElement_isLeaf,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_ReduceAction_isOrdered =
      MetaScalarAttributeUpdater(
        set_ReduceAction_isOrdered _,
        ops.ReduceAction_isOrdered,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_RemoveStructuralFeatureValueAction_isRemoveDuplicates =
      MetaScalarAttributeUpdater(
        set_RemoveStructuralFeatureValueAction_isRemoveDuplicates _,
        ops.RemoveStructuralFeatureValueAction_isRemoveDuplicates,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_RemoveVariableValueAction_isRemoveDuplicates =
      MetaScalarAttributeUpdater(
        set_RemoveVariableValueAction_isRemoveDuplicates _,
        ops.RemoveVariableValueAction_isRemoveDuplicates,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_StructuralFeature_isReadOnly =
      MetaScalarAttributeUpdater(
        set_StructuralFeature_isReadOnly _,
        ops.StructuralFeature_isReadOnly,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_StructuredActivityNode_mustIsolate =
      MetaScalarAttributeUpdater(
        set_StructuredActivityNode_mustIsolate _,
        ops.StructuredActivityNode_mustIsolate,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_TimeEvent_isRelative =
      MetaScalarAttributeUpdater(
        set_TimeEvent_isRelative _,
        ops.TimeEvent_isRelative,
        BooleanValueConverter.convert)

  val MetaScalarAttributeUpdater_TimeObservation_firstEvent =
      MetaScalarAttributeUpdater(
        set_TimeObservation_firstEvent _,
        ops.TimeObservation_firstEvent,
        BooleanValueConverter.convert)

  val MetaPropertyScalarAttributeUpdate
  : Seq[MetaScalarAttributeUpdate]
  = Seq() :+
      MetaScalarAttributeUpdater_AcceptEventAction_isUnmarshall :+
      MetaScalarAttributeUpdater_Action_isLocallyReentrant :+
      MetaScalarAttributeUpdater_Activity_isReadOnly :+
      MetaScalarAttributeUpdater_Activity_isSingleExecution :+
      MetaScalarAttributeUpdater_ActivityPartition_isDimension :+
      MetaScalarAttributeUpdater_ActivityPartition_isExternal :+
      MetaScalarAttributeUpdater_AddStructuralFeatureValueAction_isReplaceAll :+
      MetaScalarAttributeUpdater_AddVariableValueAction_isReplaceAll :+
      MetaScalarAttributeUpdater_Association_isDerived :+
      MetaScalarAttributeUpdater_Behavior_isReentrant :+
      MetaScalarAttributeUpdater_BehavioralFeature_isAbstract :+
      MetaScalarAttributeUpdater_CallAction_isSynchronous :+
      MetaScalarAttributeUpdater_Class_isAbstract :+
      MetaScalarAttributeUpdater_Class_isActive :+
      MetaScalarAttributeUpdater_Classifier_isAbstract :+
      MetaScalarAttributeUpdater_Classifier_isFinalSpecialization :+
      MetaScalarAttributeUpdater_ClassifierTemplateParameter_allowSubstitutable :+
      MetaScalarAttributeUpdater_Component_isIndirectlyInstantiated :+
      MetaScalarAttributeUpdater_ConditionalNode_isAssured :+
      MetaScalarAttributeUpdater_ConditionalNode_isDeterminate :+
      MetaScalarAttributeUpdater_Continuation_setting :+
      MetaScalarAttributeUpdater_DestroyObjectAction_isDestroyLinks :+
      MetaScalarAttributeUpdater_DestroyObjectAction_isDestroyOwnedObjects :+
      MetaScalarAttributeUpdater_Feature_isStatic :+
      MetaScalarAttributeUpdater_GeneralizationSet_isCovering :+
      MetaScalarAttributeUpdater_GeneralizationSet_isDisjoint :+
      MetaScalarAttributeUpdater_JoinNode_isCombineDuplicate :+
      MetaScalarAttributeUpdater_LinkEndCreationData_isReplaceAll :+
      MetaScalarAttributeUpdater_LinkEndDestructionData_isDestroyDuplicates :+
      MetaScalarAttributeUpdater_LiteralBoolean_value :+
      MetaScalarAttributeUpdater_LiteralInteger_value :+
      MetaScalarAttributeUpdater_LiteralReal_value :+
      MetaScalarAttributeUpdater_LiteralUnlimitedNatural_value :+
      MetaScalarAttributeUpdater_LoopNode_isTestedFirst :+
      MetaScalarAttributeUpdater_MultiplicityElement_isOrdered :+
      MetaScalarAttributeUpdater_MultiplicityElement_isUnique :+
      MetaScalarAttributeUpdater_ObjectFlow_isMulticast :+
      MetaScalarAttributeUpdater_ObjectFlow_isMultireceive :+
      MetaScalarAttributeUpdater_ObjectNode_isControlType :+
      MetaScalarAttributeUpdater_Operation_isQuery :+
      MetaScalarAttributeUpdater_Parameter_isException :+
      MetaScalarAttributeUpdater_Parameter_isStream :+
      MetaScalarAttributeUpdater_Pin_isControl :+
      MetaScalarAttributeUpdater_Port_isBehavior :+
      MetaScalarAttributeUpdater_Port_isConjugated :+
      MetaScalarAttributeUpdater_Port_isService :+
      MetaScalarAttributeUpdater_ProfileApplication_isStrict :+
      MetaScalarAttributeUpdater_Property_isDerived :+
      MetaScalarAttributeUpdater_Property_isDerivedUnion :+
      MetaScalarAttributeUpdater_Property_isID :+
      MetaScalarAttributeUpdater_ReadIsClassifiedObjectAction_isDirect :+
      MetaScalarAttributeUpdater_ReclassifyObjectAction_isReplaceAll :+
      MetaScalarAttributeUpdater_RedefinableElement_isLeaf :+
      MetaScalarAttributeUpdater_ReduceAction_isOrdered :+
      MetaScalarAttributeUpdater_RemoveStructuralFeatureValueAction_isRemoveDuplicates :+
      MetaScalarAttributeUpdater_RemoveVariableValueAction_isRemoveDuplicates :+
      MetaScalarAttributeUpdater_StructuralFeature_isReadOnly :+
      MetaScalarAttributeUpdater_StructuredActivityNode_mustIsolate :+
      MetaScalarAttributeUpdater_TimeEvent_isRelative :+
      MetaScalarAttributeUpdater_TimeObservation_firstEvent

  val MetaEnumerationAttributeUpdater_BehavioralFeature_concurrency =
      MetaEnumerationAttributeUpdater(
        set_BehavioralFeature_concurrency _,
        ops.BehavioralFeature_concurrency,
        UMLCallConcurrencyKind.values)

  val MetaEnumerationAttributeUpdater_CombinedFragment_interactionOperator =
      MetaEnumerationAttributeUpdater(
        set_CombinedFragment_interactionOperator _,
        ops.CombinedFragment_interactionOperator,
        UMLInteractionOperatorKind.values)

  val MetaEnumerationAttributeUpdater_ElementImport_visibility =
      MetaEnumerationAttributeUpdater(
        set_ElementImport_visibility _,
        ops.ElementImport_visibility,
        UMLVisibilityKind.values)

  val MetaEnumerationAttributeUpdater_ExpansionRegion_mode =
      MetaEnumerationAttributeUpdater(
        set_ExpansionRegion_mode _,
        ops.ExpansionRegion_mode,
        UMLExpansionKind.values)

  val MetaEnumerationAttributeUpdater_Message_messageSort =
      MetaEnumerationAttributeUpdater(
        set_Message_messageSort _,
        ops.Message_messageSort,
        UMLMessageSort.values)

  val MetaEnumerationAttributeUpdater_NamedElement_visibility =
      MetaEnumerationAttributeUpdater(
        set_NamedElement_visibility _,
        ops.NamedElement_visibility,
        UMLVisibilityKind.values)

  val MetaEnumerationAttributeUpdater_ObjectNode_ordering =
      MetaEnumerationAttributeUpdater(
        set_ObjectNode_ordering _,
        ops.ObjectNode_ordering,
        UMLObjectNodeOrderingKind.values)

  val MetaEnumerationAttributeUpdater_PackageImport_visibility =
      MetaEnumerationAttributeUpdater(
        set_PackageImport_visibility _,
        ops.PackageImport_visibility,
        UMLVisibilityKind.values)

  val MetaEnumerationAttributeUpdater_PackageableElement_visibility =
      MetaEnumerationAttributeUpdater(
        set_PackageableElement_visibility _,
        ops.PackageableElement_visibility,
        UMLVisibilityKind.values)

  val MetaEnumerationAttributeUpdater_Parameter_direction =
      MetaEnumerationAttributeUpdater(
        set_Parameter_direction _,
        ops.Parameter_direction,
        UMLParameterDirectionKind.values)

  val MetaEnumerationAttributeUpdater_Parameter_effect =
      MetaEnumerationAttributeUpdater(
        set_Parameter_effect _,
        ops.Parameter_effect,
        UMLParameterEffectKind.values)

  val MetaEnumerationAttributeUpdater_Property_aggregation =
      MetaEnumerationAttributeUpdater(
        set_Property_aggregation _,
        ops.Property_aggregation,
        UMLAggregationKind.values)

  val MetaEnumerationAttributeUpdater_Pseudostate_kind =
      MetaEnumerationAttributeUpdater(
        set_Pseudostate_kind _,
        ops.Pseudostate_kind,
        UMLPseudostateKind.values)

  val MetaEnumerationAttributeUpdater_Transition_kind =
      MetaEnumerationAttributeUpdater(
        set_Transition_kind _,
        ops.Transition_kind,
        UMLTransitionKind.values)

  val MetaPropertyEnumerationAttributeUpdate
  : Seq[MetaEnumerationAttributeUpdate]
  = Seq() :+
      MetaEnumerationAttributeUpdater_BehavioralFeature_concurrency :+
      MetaEnumerationAttributeUpdater_CombinedFragment_interactionOperator :+
      MetaEnumerationAttributeUpdater_ElementImport_visibility :+
      MetaEnumerationAttributeUpdater_ExpansionRegion_mode :+
      MetaEnumerationAttributeUpdater_Message_messageSort :+
      MetaEnumerationAttributeUpdater_NamedElement_visibility :+
      MetaEnumerationAttributeUpdater_ObjectNode_ordering :+
      MetaEnumerationAttributeUpdater_PackageImport_visibility :+
      MetaEnumerationAttributeUpdater_PackageableElement_visibility :+
      MetaEnumerationAttributeUpdater_Parameter_direction :+
      MetaEnumerationAttributeUpdater_Parameter_effect :+
      MetaEnumerationAttributeUpdater_Property_aggregation :+
      MetaEnumerationAttributeUpdater_Pseudostate_kind :+
      MetaEnumerationAttributeUpdater_Transition_kind

  val MetaOptionAttributeUpdater_Artifact_fileName =
      MetaOptionAttributeUpdater(
        set_Artifact_fileName _,
        ops.Artifact_fileName,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_Comment_body =
      MetaOptionAttributeUpdater(
        set_Comment_body _,
        ops.Comment_body,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_DeploymentSpecification_deploymentLocation =
      MetaOptionAttributeUpdater(
        set_DeploymentSpecification_deploymentLocation _,
        ops.DeploymentSpecification_deploymentLocation,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_DeploymentSpecification_executionLocation =
      MetaOptionAttributeUpdater(
        set_DeploymentSpecification_executionLocation _,
        ops.DeploymentSpecification_executionLocation,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_ElementImport_alias =
      MetaOptionAttributeUpdater(
        set_ElementImport_alias _,
        ops.ElementImport_alias,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_Expression_symbol =
      MetaOptionAttributeUpdater(
        set_Expression_symbol _,
        ops.Expression_symbol,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_Generalization_isSubstitutable =
      MetaOptionAttributeUpdater(
        set_Generalization_isSubstitutable _,
        ops.Generalization_isSubstitutable,
        BooleanValueConverter.convert)

  val MetaOptionAttributeUpdater_Image_content =
      MetaOptionAttributeUpdater(
        set_Image_content _,
        ops.Image_content,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_Image_format =
      MetaOptionAttributeUpdater(
        set_Image_format _,
        ops.Image_format,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_Image_location =
      MetaOptionAttributeUpdater(
        set_Image_location _,
        ops.Image_location,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_LiteralString_value =
      MetaOptionAttributeUpdater(
        set_LiteralString_value _,
        ops.LiteralString_value,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_Model_viewpoint =
      MetaOptionAttributeUpdater(
        set_Model_viewpoint _,
        ops.Model_viewpoint,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_NamedElement_name =
      MetaOptionAttributeUpdater(
        set_NamedElement_name _,
        ops.NamedElement_name,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_Package_URI =
      MetaOptionAttributeUpdater(
        set_Package_URI _,
        ops.Package_URI,
        StringValueConverter.convert)

  val MetaOptionAttributeUpdater_TimeConstraint_firstEvent =
      MetaOptionAttributeUpdater(
        set_TimeConstraint_firstEvent _,
        ops.TimeConstraint_firstEvent,
        BooleanValueConverter.convert)

  val MetaPropertyOptionAttributeUpdate
  : Seq[MetaOptionAttributeUpdate]
  = Seq() :+
      MetaOptionAttributeUpdater_Artifact_fileName :+
      MetaOptionAttributeUpdater_Comment_body :+
      MetaOptionAttributeUpdater_DeploymentSpecification_deploymentLocation :+
      MetaOptionAttributeUpdater_DeploymentSpecification_executionLocation :+
      MetaOptionAttributeUpdater_ElementImport_alias :+
      MetaOptionAttributeUpdater_Expression_symbol :+
      MetaOptionAttributeUpdater_Generalization_isSubstitutable :+
      MetaOptionAttributeUpdater_Image_content :+
      MetaOptionAttributeUpdater_Image_format :+
      MetaOptionAttributeUpdater_Image_location :+
      MetaOptionAttributeUpdater_LiteralString_value :+
      MetaOptionAttributeUpdater_Model_viewpoint :+
      MetaOptionAttributeUpdater_NamedElement_name :+
      MetaOptionAttributeUpdater_Package_URI :+
      MetaOptionAttributeUpdater_TimeConstraint_firstEvent

  val MetaPropertyIterableAttributeUpdate
  : Seq[MetaIterableAttributeUpdate]
  = Seq()

   val MetaSeqAttributeUpdater_DurationObservation_firstEvent =
     MetaSeqAttributeUpdater(
        set_DurationObservation_firstEvent _,
        ops.DurationObservation_firstEvent,
        BooleanValueConverter.convert)

   val MetaSeqAttributeUpdater_OpaqueAction_body =
     MetaSeqAttributeUpdater(
        set_OpaqueAction_body _,
        ops.OpaqueAction_body,
        StringValueConverter.convert)

   val MetaSeqAttributeUpdater_OpaqueAction_language =
     MetaSeqAttributeUpdater(
        set_OpaqueAction_language _,
        ops.OpaqueAction_language,
        StringValueConverter.convert)

   val MetaSeqAttributeUpdater_OpaqueBehavior_body =
     MetaSeqAttributeUpdater(
        set_OpaqueBehavior_body _,
        ops.OpaqueBehavior_body,
        StringValueConverter.convert)

   val MetaSeqAttributeUpdater_OpaqueBehavior_language =
     MetaSeqAttributeUpdater(
        set_OpaqueBehavior_language _,
        ops.OpaqueBehavior_language,
        StringValueConverter.convert)

   val MetaSeqAttributeUpdater_OpaqueExpression_body =
     MetaSeqAttributeUpdater(
        set_OpaqueExpression_body _,
        ops.OpaqueExpression_body,
        StringValueConverter.convert)

   val MetaSeqAttributeUpdater_OpaqueExpression_language =
     MetaSeqAttributeUpdater(
        set_OpaqueExpression_language _,
        ops.OpaqueExpression_language,
        StringValueConverter.convert)

  val MetaPropertySeqAttributeUpdate
  : Seq[MetaSeqAttributeUpdate]
  = Seq() :+
      MetaSeqAttributeUpdater_DurationObservation_firstEvent :+
      MetaSeqAttributeUpdater_OpaqueAction_body :+
      MetaSeqAttributeUpdater_OpaqueAction_language :+
      MetaSeqAttributeUpdater_OpaqueBehavior_body :+
      MetaSeqAttributeUpdater_OpaqueBehavior_language :+
      MetaSeqAttributeUpdater_OpaqueExpression_body :+
      MetaSeqAttributeUpdater_OpaqueExpression_language

  val MetaSetAttributeUpdater_DurationConstraint_firstEvent =
      MetaSetAttributeUpdater(
        set_DurationConstraint_firstEvent _,
        ops.DurationConstraint_firstEvent,
        BooleanValueConverter.convert)

  val MetaPropertySetAttributeUpdate
  : Seq[MetaSetAttributeUpdate]
  = Seq() :+
      MetaSetAttributeUpdater_DurationConstraint_firstEvent

  val metaclass_attribute_updaters
  : Map[String, Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]] =
    metaclass_attribute_updater_table
    
  // this is very long; it has to be in a method otherwise it yields code that exceeds the JVM restrictions 
  // on the size of initialization code.
  def metaclass_attribute_updater_table
  : Map[String, Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]] =
    Map[String, Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]]() ++
    Map( "Abstraction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "AcceptCallAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isUnmarshall" -> MetaScalarAttributeUpdater_AcceptEventAction_isUnmarshall ) ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "AcceptEventAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isUnmarshall" -> MetaScalarAttributeUpdater_AcceptEventAction_isUnmarshall ) ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ActionExecutionSpecification" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ActionInputPin" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) ++
        Map( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) ++
        Map( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) ++
        Map( "isControl" -> MetaScalarAttributeUpdater_Pin_isControl ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering ))) ++
    Map( "Activity" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isReadOnly" -> MetaScalarAttributeUpdater_Activity_isReadOnly ) ++
        Map( "isSingleExecution" -> MetaScalarAttributeUpdater_Activity_isSingleExecution ) ++
        Map( "isReentrant" -> MetaScalarAttributeUpdater_Behavior_isReentrant ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "ActivityFinalNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ActivityParameterNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering ))) ++
    Map( "ActivityPartition" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isDimension" -> MetaScalarAttributeUpdater_ActivityPartition_isDimension ) ++
        Map( "isExternal" -> MetaScalarAttributeUpdater_ActivityPartition_isExternal ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Actor" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "AddStructuralFeatureValueAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isReplaceAll" -> MetaScalarAttributeUpdater_AddStructuralFeatureValueAction_isReplaceAll ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "AddVariableValueAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isReplaceAll" -> MetaScalarAttributeUpdater_AddVariableValueAction_isReplaceAll ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "AnyReceiveEvent" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Artifact" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "fileName" -> MetaOptionAttributeUpdater_Artifact_fileName ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Association" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isDerived" -> MetaScalarAttributeUpdater_Association_isDerived ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "AssociationClass" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isDerived" -> MetaScalarAttributeUpdater_Association_isDerived ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "BehaviorExecutionSpecification" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "BroadcastSignalAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "CallBehaviorAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isSynchronous" -> MetaScalarAttributeUpdater_CallAction_isSynchronous ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "CallEvent" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "CallOperationAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isSynchronous" -> MetaScalarAttributeUpdater_CallAction_isSynchronous ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "CentralBufferNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering ))) ++
    Map( "ChangeEvent" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Class" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "ClassifierTemplateParameter" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "allowSubstitutable" -> MetaScalarAttributeUpdater_ClassifierTemplateParameter_allowSubstitutable ))) ++
    Map( "Clause" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "ClearAssociationAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ClearStructuralFeatureAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ClearVariableAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Collaboration" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "CollaborationUse" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "CombinedFragment" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "interactionOperator" -> MetaEnumerationAttributeUpdater_CombinedFragment_interactionOperator ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Comment" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "body" -> MetaOptionAttributeUpdater_Comment_body ))) ++
    Map( "CommunicationPath" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isDerived" -> MetaScalarAttributeUpdater_Association_isDerived ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Component" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isIndirectlyInstantiated" -> MetaScalarAttributeUpdater_Component_isIndirectlyInstantiated ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "ComponentRealization" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "ConditionalNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isAssured" -> MetaScalarAttributeUpdater_ConditionalNode_isAssured ) ++
        Map( "isDeterminate" -> MetaScalarAttributeUpdater_ConditionalNode_isDeterminate ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "mustIsolate" -> MetaScalarAttributeUpdater_StructuredActivityNode_mustIsolate ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ConnectableElementTemplateParameter" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "ConnectionPointReference" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Connector" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isStatic" -> MetaScalarAttributeUpdater_Feature_isStatic ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ConnectorEnd" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) ++
        Map( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ))) ++
    Map( "ConsiderIgnoreFragment" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "interactionOperator" -> MetaEnumerationAttributeUpdater_CombinedFragment_interactionOperator ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Constraint" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Continuation" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "setting" -> MetaScalarAttributeUpdater_Continuation_setting ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ControlFlow" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "CreateLinkAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "CreateLinkObjectAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "CreateObjectAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "DataStoreNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering ))) ++
    Map( "DataType" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "DecisionNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Dependency" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Deployment" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "DeploymentSpecification" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "fileName" -> MetaOptionAttributeUpdater_Artifact_fileName ) ++
        Map( "deploymentLocation" -> MetaOptionAttributeUpdater_DeploymentSpecification_deploymentLocation ) ++
        Map( "executionLocation" -> MetaOptionAttributeUpdater_DeploymentSpecification_executionLocation ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "DestroyLinkAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "DestroyObjectAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isDestroyLinks" -> MetaScalarAttributeUpdater_DestroyObjectAction_isDestroyLinks ) ++
        Map( "isDestroyOwnedObjects" -> MetaScalarAttributeUpdater_DestroyObjectAction_isDestroyOwnedObjects ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "DestructionOccurrenceSpecification" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Device" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Duration" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "DurationConstraint" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) ++
        Map( "firstEvent" -> MetaSetAttributeUpdater_DurationConstraint_firstEvent ))) ++
    Map( "DurationInterval" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "DurationObservation" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) ++
        Map( "firstEvent" -> MetaSeqAttributeUpdater_DurationObservation_firstEvent ))) ++
    Map( "ElementImport" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "alias" -> MetaOptionAttributeUpdater_ElementImport_alias ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_ElementImport_visibility ))) ++
    Map( "Enumeration" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "EnumerationLiteral" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "ExceptionHandler" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "ExecutionEnvironment" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "ExecutionOccurrenceSpecification" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ExpansionNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering ))) ++
    Map( "ExpansionRegion" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "mustIsolate" -> MetaScalarAttributeUpdater_StructuredActivityNode_mustIsolate ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "mode" -> MetaEnumerationAttributeUpdater_ExpansionRegion_mode ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Expression" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "symbol" -> MetaOptionAttributeUpdater_Expression_symbol ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Extend" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Extension" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isDerived" -> MetaScalarAttributeUpdater_Association_isDerived ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "ExtensionEnd" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isStatic" -> MetaScalarAttributeUpdater_Feature_isStatic ) ++
        Map( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) ++
        Map( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) ++
        Map( "isDerived" -> MetaScalarAttributeUpdater_Property_isDerived ) ++
        Map( "isDerivedUnion" -> MetaScalarAttributeUpdater_Property_isDerivedUnion ) ++
        Map( "isID" -> MetaScalarAttributeUpdater_Property_isID ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "isReadOnly" -> MetaScalarAttributeUpdater_StructuralFeature_isReadOnly ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "aggregation" -> MetaEnumerationAttributeUpdater_Property_aggregation ))) ++
    Map( "ExtensionPoint" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "FinalState" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "FlowFinalNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ForkNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "FunctionBehavior" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isReentrant" -> MetaScalarAttributeUpdater_Behavior_isReentrant ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) ++
        Map( "body" -> MetaSeqAttributeUpdater_OpaqueBehavior_body ) ++
        Map( "language" -> MetaSeqAttributeUpdater_OpaqueBehavior_language ))) ++
    Map( "Gate" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "GeneralOrdering" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Generalization" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isSubstitutable" -> MetaOptionAttributeUpdater_Generalization_isSubstitutable ))) ++
    Map( "GeneralizationSet" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isCovering" -> MetaScalarAttributeUpdater_GeneralizationSet_isCovering ) ++
        Map( "isDisjoint" -> MetaScalarAttributeUpdater_GeneralizationSet_isDisjoint ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Image" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "content" -> MetaOptionAttributeUpdater_Image_content ) ++
        Map( "format" -> MetaOptionAttributeUpdater_Image_format ) ++
        Map( "location" -> MetaOptionAttributeUpdater_Image_location ))) ++
    Map( "Include" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "InformationFlow" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "InformationItem" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "InitialNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "InputPin" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) ++
        Map( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) ++
        Map( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) ++
        Map( "isControl" -> MetaScalarAttributeUpdater_Pin_isControl ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering ))) ++
    Map( "InstanceSpecification" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "InstanceValue" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Interaction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isReentrant" -> MetaScalarAttributeUpdater_Behavior_isReentrant ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "InteractionConstraint" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "InteractionOperand" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "InteractionUse" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Interface" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "InterfaceRealization" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "InterruptibleActivityRegion" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Interval" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "IntervalConstraint" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "JoinNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isCombineDuplicate" -> MetaScalarAttributeUpdater_JoinNode_isCombineDuplicate ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Lifeline" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "LinkEndCreationData" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isReplaceAll" -> MetaScalarAttributeUpdater_LinkEndCreationData_isReplaceAll ))) ++
    Map( "LinkEndData" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "LinkEndDestructionData" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isDestroyDuplicates" -> MetaScalarAttributeUpdater_LinkEndDestructionData_isDestroyDuplicates ))) ++
    Map( "LiteralBoolean" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "value" -> MetaScalarAttributeUpdater_LiteralBoolean_value ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "LiteralInteger" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "value" -> MetaScalarAttributeUpdater_LiteralInteger_value ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "LiteralNull" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "LiteralReal" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "value" -> MetaScalarAttributeUpdater_LiteralReal_value ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "LiteralString" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "value" -> MetaOptionAttributeUpdater_LiteralString_value ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "LiteralUnlimitedNatural" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "value" -> MetaScalarAttributeUpdater_LiteralUnlimitedNatural_value ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "LoopNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isTestedFirst" -> MetaScalarAttributeUpdater_LoopNode_isTestedFirst ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "mustIsolate" -> MetaScalarAttributeUpdater_StructuredActivityNode_mustIsolate ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Manifestation" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "MergeNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Message" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "messageSort" -> MetaEnumerationAttributeUpdater_Message_messageSort ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "MessageOccurrenceSpecification" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Model" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "viewpoint" -> MetaOptionAttributeUpdater_Model_viewpoint ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "URI" -> MetaOptionAttributeUpdater_Package_URI ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Node" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "ObjectFlow" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isMulticast" -> MetaScalarAttributeUpdater_ObjectFlow_isMulticast ) ++
        Map( "isMultireceive" -> MetaScalarAttributeUpdater_ObjectFlow_isMultireceive ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "OccurrenceSpecification" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "OpaqueAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "body" -> MetaSeqAttributeUpdater_OpaqueAction_body ) ++
        Map( "language" -> MetaSeqAttributeUpdater_OpaqueAction_language ))) ++
    Map( "OpaqueBehavior" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isReentrant" -> MetaScalarAttributeUpdater_Behavior_isReentrant ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) ++
        Map( "body" -> MetaSeqAttributeUpdater_OpaqueBehavior_body ) ++
        Map( "language" -> MetaSeqAttributeUpdater_OpaqueBehavior_language ))) ++
    Map( "OpaqueExpression" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) ++
        Map( "body" -> MetaSeqAttributeUpdater_OpaqueExpression_body ) ++
        Map( "language" -> MetaSeqAttributeUpdater_OpaqueExpression_language ))) ++
    Map( "Operation" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_BehavioralFeature_isAbstract ) ++
        Map( "isStatic" -> MetaScalarAttributeUpdater_Feature_isStatic ) ++
        Map( "isQuery" -> MetaScalarAttributeUpdater_Operation_isQuery ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "concurrency" -> MetaEnumerationAttributeUpdater_BehavioralFeature_concurrency ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "OperationTemplateParameter" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "OutputPin" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) ++
        Map( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) ++
        Map( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) ++
        Map( "isControl" -> MetaScalarAttributeUpdater_Pin_isControl ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering ))) ++
    Map( "Package" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "URI" -> MetaOptionAttributeUpdater_Package_URI ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "PackageImport" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageImport_visibility ))) ++
    Map( "PackageMerge" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "Parameter" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) ++
        Map( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) ++
        Map( "isException" -> MetaScalarAttributeUpdater_Parameter_isException ) ++
        Map( "isStream" -> MetaScalarAttributeUpdater_Parameter_isStream ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "direction" -> MetaEnumerationAttributeUpdater_Parameter_direction ) ++
        Map( "effect" -> MetaEnumerationAttributeUpdater_Parameter_effect ))) ++
    Map( "ParameterSet" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "PartDecomposition" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Port" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isStatic" -> MetaScalarAttributeUpdater_Feature_isStatic ) ++
        Map( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) ++
        Map( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) ++
        Map( "isBehavior" -> MetaScalarAttributeUpdater_Port_isBehavior ) ++
        Map( "isConjugated" -> MetaScalarAttributeUpdater_Port_isConjugated ) ++
        Map( "isService" -> MetaScalarAttributeUpdater_Port_isService ) ++
        Map( "isDerived" -> MetaScalarAttributeUpdater_Property_isDerived ) ++
        Map( "isDerivedUnion" -> MetaScalarAttributeUpdater_Property_isDerivedUnion ) ++
        Map( "isID" -> MetaScalarAttributeUpdater_Property_isID ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "isReadOnly" -> MetaScalarAttributeUpdater_StructuralFeature_isReadOnly ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "aggregation" -> MetaEnumerationAttributeUpdater_Property_aggregation ))) ++
    Map( "PrimitiveType" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Profile" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "URI" -> MetaOptionAttributeUpdater_Package_URI ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "ProfileApplication" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isStrict" -> MetaScalarAttributeUpdater_ProfileApplication_isStrict ))) ++
    Map( "Property" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isStatic" -> MetaScalarAttributeUpdater_Feature_isStatic ) ++
        Map( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) ++
        Map( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) ++
        Map( "isDerived" -> MetaScalarAttributeUpdater_Property_isDerived ) ++
        Map( "isDerivedUnion" -> MetaScalarAttributeUpdater_Property_isDerivedUnion ) ++
        Map( "isID" -> MetaScalarAttributeUpdater_Property_isID ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "isReadOnly" -> MetaScalarAttributeUpdater_StructuralFeature_isReadOnly ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "aggregation" -> MetaEnumerationAttributeUpdater_Property_aggregation ))) ++
    Map( "ProtocolConformance" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "ProtocolStateMachine" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isReentrant" -> MetaScalarAttributeUpdater_Behavior_isReentrant ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "ProtocolTransition" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "kind" -> MetaEnumerationAttributeUpdater_Transition_kind ))) ++
    Map( "Pseudostate" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "kind" -> MetaEnumerationAttributeUpdater_Pseudostate_kind ))) ++
    Map( "QualifierValue" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "RaiseExceptionAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ReadExtentAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ReadIsClassifiedObjectAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isDirect" -> MetaScalarAttributeUpdater_ReadIsClassifiedObjectAction_isDirect ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ReadLinkAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ReadLinkObjectEndAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ReadLinkObjectEndQualifierAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ReadSelfAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ReadStructuralFeatureAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ReadVariableAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Realization" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Reception" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_BehavioralFeature_isAbstract ) ++
        Map( "isStatic" -> MetaScalarAttributeUpdater_Feature_isStatic ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "concurrency" -> MetaEnumerationAttributeUpdater_BehavioralFeature_concurrency ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ReclassifyObjectAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isReplaceAll" -> MetaScalarAttributeUpdater_ReclassifyObjectAction_isReplaceAll ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "RedefinableTemplateSignature" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ReduceAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "isOrdered" -> MetaScalarAttributeUpdater_ReduceAction_isOrdered ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Region" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "RemoveStructuralFeatureValueAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "isRemoveDuplicates" -> MetaScalarAttributeUpdater_RemoveStructuralFeatureValueAction_isRemoveDuplicates ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "RemoveVariableValueAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "isRemoveDuplicates" -> MetaScalarAttributeUpdater_RemoveVariableValueAction_isRemoveDuplicates ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "ReplyAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "SendObjectAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "SendSignalAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "SequenceNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "mustIsolate" -> MetaScalarAttributeUpdater_StructuredActivityNode_mustIsolate ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Signal" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "SignalEvent" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Slot" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "StartClassifierBehaviorAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "StartObjectBehaviorAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isSynchronous" -> MetaScalarAttributeUpdater_CallAction_isSynchronous ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "State" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "StateInvariant" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "StateMachine" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isReentrant" -> MetaScalarAttributeUpdater_Behavior_isReentrant ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Stereotype" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) ++
        Map( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "StringExpression" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "symbol" -> MetaOptionAttributeUpdater_Expression_symbol ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "StructuredActivityNode" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "mustIsolate" -> MetaScalarAttributeUpdater_StructuredActivityNode_mustIsolate ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Substitution" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "TemplateBinding" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "TemplateParameter" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "TemplateParameterSubstitution" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "TemplateSignature" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]())) ++
    Map( "TestIdentityAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "TimeConstraint" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "firstEvent" -> MetaOptionAttributeUpdater_TimeConstraint_firstEvent ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "TimeEvent" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isRelative" -> MetaScalarAttributeUpdater_TimeEvent_isRelative ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "TimeExpression" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "TimeInterval" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "TimeObservation" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "firstEvent" -> MetaScalarAttributeUpdater_TimeObservation_firstEvent ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "Transition" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "kind" -> MetaEnumerationAttributeUpdater_Transition_kind ))) ++
    Map( "Trigger" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "UnmarshallAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Usage" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "UseCase" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) ++
        Map( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ))) ++
    Map( "ValuePin" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) ++
        Map( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) ++
        Map( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) ++
        Map( "isControl" -> MetaScalarAttributeUpdater_Pin_isControl ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) ++
        Map( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering ))) ++
    Map( "ValueSpecificationAction" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) ++
        Map( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ))) ++
    Map( "Variable" -> 
      ( Map[String, MetaAttributeUpdate[_ <: UMLElement[Uml]]]() ++
        Map( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) ++
        Map( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) ++
        Map( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) ++
        Map( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )))
	// Start of user code for additional features
	// End of user code
}
