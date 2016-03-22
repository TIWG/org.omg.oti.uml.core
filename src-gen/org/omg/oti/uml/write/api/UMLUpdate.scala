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
  def links_ConnectorEnd_end_reference_role_ConnectableElement
  (from: UMLConnectorEnd[Uml],
   to: Option[UMLConnectableElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit

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

  def links_Dependency_clientDependency_reference_client_NamedElement
  (from: UMLDependency[Uml],
   to: Set[UMLNamedElement[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
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
  def links_Transition_outgoing_reference_source_Vertex
  (from: UMLTransition[Uml],
   to: Option[UMLVertex[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
  def links_Transition_incoming_reference_target_Vertex
  (from: UMLTransition[Uml],
   to: Option[UMLVertex[Uml]]): NonEmptyList[java.lang.Throwable] \/ Unit
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
        links_ConnectorEnd_end_reference_role_ConnectableElement _,
        ops.ConnectorEnd_role) :+
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
        links_Transition_outgoing_reference_source_Vertex _,
        ops.Transition_source) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Transition_incoming_reference_target_Vertex _,
        ops.Transition_target) :+
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
        links_Dependency_clientDependency_reference_client_NamedElement _,
        ops.Dependency_client) :+
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
  : Map[String, Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]]
  = metaclass_attribute_updater_table
    
  /** Maps the name of each concrete metaclass to map of attribute name to meta-information.
    * Note: Attributes in these maps are metaclass-owned properties typed by a kind of datatype.
    */
  lazy val metaclass_attribute_updater_table
  : Map[String, Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]]
  = Map[String, Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]]() +
    ("Abstraction" -> metaclass_attribute_updater_table_Abstraction) +
    ("AcceptCallAction" -> metaclass_attribute_updater_table_AcceptCallAction) +
    ("AcceptEventAction" -> metaclass_attribute_updater_table_AcceptEventAction) +
    ("ActionExecutionSpecification" -> metaclass_attribute_updater_table_ActionExecutionSpecification) +
    ("ActionInputPin" -> metaclass_attribute_updater_table_ActionInputPin) +
    ("Activity" -> metaclass_attribute_updater_table_Activity) +
    ("ActivityFinalNode" -> metaclass_attribute_updater_table_ActivityFinalNode) +
    ("ActivityParameterNode" -> metaclass_attribute_updater_table_ActivityParameterNode) +
    ("ActivityPartition" -> metaclass_attribute_updater_table_ActivityPartition) +
    ("Actor" -> metaclass_attribute_updater_table_Actor) +
    ("AddStructuralFeatureValueAction" -> metaclass_attribute_updater_table_AddStructuralFeatureValueAction) +
    ("AddVariableValueAction" -> metaclass_attribute_updater_table_AddVariableValueAction) +
    ("AnyReceiveEvent" -> metaclass_attribute_updater_table_AnyReceiveEvent) +
    ("Artifact" -> metaclass_attribute_updater_table_Artifact) +
    ("Association" -> metaclass_attribute_updater_table_Association) +
    ("AssociationClass" -> metaclass_attribute_updater_table_AssociationClass) +
    ("BehaviorExecutionSpecification" -> metaclass_attribute_updater_table_BehaviorExecutionSpecification) +
    ("BroadcastSignalAction" -> metaclass_attribute_updater_table_BroadcastSignalAction) +
    ("CallBehaviorAction" -> metaclass_attribute_updater_table_CallBehaviorAction) +
    ("CallEvent" -> metaclass_attribute_updater_table_CallEvent) +
    ("CallOperationAction" -> metaclass_attribute_updater_table_CallOperationAction) +
    ("CentralBufferNode" -> metaclass_attribute_updater_table_CentralBufferNode) +
    ("ChangeEvent" -> metaclass_attribute_updater_table_ChangeEvent) +
    ("Class" -> metaclass_attribute_updater_table_Class) +
    ("ClassifierTemplateParameter" -> metaclass_attribute_updater_table_ClassifierTemplateParameter) +
    ("Clause" -> metaclass_attribute_updater_table_Clause) +
    ("ClearAssociationAction" -> metaclass_attribute_updater_table_ClearAssociationAction) +
    ("ClearStructuralFeatureAction" -> metaclass_attribute_updater_table_ClearStructuralFeatureAction) +
    ("ClearVariableAction" -> metaclass_attribute_updater_table_ClearVariableAction) +
    ("Collaboration" -> metaclass_attribute_updater_table_Collaboration) +
    ("CollaborationUse" -> metaclass_attribute_updater_table_CollaborationUse) +
    ("CombinedFragment" -> metaclass_attribute_updater_table_CombinedFragment) +
    ("Comment" -> metaclass_attribute_updater_table_Comment) +
    ("CommunicationPath" -> metaclass_attribute_updater_table_CommunicationPath) +
    ("Component" -> metaclass_attribute_updater_table_Component) +
    ("ComponentRealization" -> metaclass_attribute_updater_table_ComponentRealization) +
    ("ConditionalNode" -> metaclass_attribute_updater_table_ConditionalNode) +
    ("ConnectableElementTemplateParameter" -> metaclass_attribute_updater_table_ConnectableElementTemplateParameter) +
    ("ConnectionPointReference" -> metaclass_attribute_updater_table_ConnectionPointReference) +
    ("Connector" -> metaclass_attribute_updater_table_Connector) +
    ("ConnectorEnd" -> metaclass_attribute_updater_table_ConnectorEnd) +
    ("ConsiderIgnoreFragment" -> metaclass_attribute_updater_table_ConsiderIgnoreFragment) +
    ("Constraint" -> metaclass_attribute_updater_table_Constraint) +
    ("Continuation" -> metaclass_attribute_updater_table_Continuation) +
    ("ControlFlow" -> metaclass_attribute_updater_table_ControlFlow) +
    ("CreateLinkAction" -> metaclass_attribute_updater_table_CreateLinkAction) +
    ("CreateLinkObjectAction" -> metaclass_attribute_updater_table_CreateLinkObjectAction) +
    ("CreateObjectAction" -> metaclass_attribute_updater_table_CreateObjectAction) +
    ("DataStoreNode" -> metaclass_attribute_updater_table_DataStoreNode) +
    ("DataType" -> metaclass_attribute_updater_table_DataType) +
    ("DecisionNode" -> metaclass_attribute_updater_table_DecisionNode) +
    ("Dependency" -> metaclass_attribute_updater_table_Dependency) +
    ("Deployment" -> metaclass_attribute_updater_table_Deployment) +
    ("DeploymentSpecification" -> metaclass_attribute_updater_table_DeploymentSpecification) +
    ("DestroyLinkAction" -> metaclass_attribute_updater_table_DestroyLinkAction) +
    ("DestroyObjectAction" -> metaclass_attribute_updater_table_DestroyObjectAction) +
    ("DestructionOccurrenceSpecification" -> metaclass_attribute_updater_table_DestructionOccurrenceSpecification) +
    ("Device" -> metaclass_attribute_updater_table_Device) +
    ("Duration" -> metaclass_attribute_updater_table_Duration) +
    ("DurationConstraint" -> metaclass_attribute_updater_table_DurationConstraint) +
    ("DurationInterval" -> metaclass_attribute_updater_table_DurationInterval) +
    ("DurationObservation" -> metaclass_attribute_updater_table_DurationObservation) +
    ("ElementImport" -> metaclass_attribute_updater_table_ElementImport) +
    ("Enumeration" -> metaclass_attribute_updater_table_Enumeration) +
    ("EnumerationLiteral" -> metaclass_attribute_updater_table_EnumerationLiteral) +
    ("ExceptionHandler" -> metaclass_attribute_updater_table_ExceptionHandler) +
    ("ExecutionEnvironment" -> metaclass_attribute_updater_table_ExecutionEnvironment) +
    ("ExecutionOccurrenceSpecification" -> metaclass_attribute_updater_table_ExecutionOccurrenceSpecification) +
    ("ExpansionNode" -> metaclass_attribute_updater_table_ExpansionNode) +
    ("ExpansionRegion" -> metaclass_attribute_updater_table_ExpansionRegion) +
    ("Expression" -> metaclass_attribute_updater_table_Expression) +
    ("Extend" -> metaclass_attribute_updater_table_Extend) +
    ("Extension" -> metaclass_attribute_updater_table_Extension) +
    ("ExtensionEnd" -> metaclass_attribute_updater_table_ExtensionEnd) +
    ("ExtensionPoint" -> metaclass_attribute_updater_table_ExtensionPoint) +
    ("FinalState" -> metaclass_attribute_updater_table_FinalState) +
    ("FlowFinalNode" -> metaclass_attribute_updater_table_FlowFinalNode) +
    ("ForkNode" -> metaclass_attribute_updater_table_ForkNode) +
    ("FunctionBehavior" -> metaclass_attribute_updater_table_FunctionBehavior) +
    ("Gate" -> metaclass_attribute_updater_table_Gate) +
    ("GeneralOrdering" -> metaclass_attribute_updater_table_GeneralOrdering) +
    ("Generalization" -> metaclass_attribute_updater_table_Generalization) +
    ("GeneralizationSet" -> metaclass_attribute_updater_table_GeneralizationSet) +
    ("Image" -> metaclass_attribute_updater_table_Image) +
    ("Include" -> metaclass_attribute_updater_table_Include) +
    ("InformationFlow" -> metaclass_attribute_updater_table_InformationFlow) +
    ("InformationItem" -> metaclass_attribute_updater_table_InformationItem) +
    ("InitialNode" -> metaclass_attribute_updater_table_InitialNode) +
    ("InputPin" -> metaclass_attribute_updater_table_InputPin) +
    ("InstanceSpecification" -> metaclass_attribute_updater_table_InstanceSpecification) +
    ("InstanceValue" -> metaclass_attribute_updater_table_InstanceValue) +
    ("Interaction" -> metaclass_attribute_updater_table_Interaction) +
    ("InteractionConstraint" -> metaclass_attribute_updater_table_InteractionConstraint) +
    ("InteractionOperand" -> metaclass_attribute_updater_table_InteractionOperand) +
    ("InteractionUse" -> metaclass_attribute_updater_table_InteractionUse) +
    ("Interface" -> metaclass_attribute_updater_table_Interface) +
    ("InterfaceRealization" -> metaclass_attribute_updater_table_InterfaceRealization) +
    ("InterruptibleActivityRegion" -> metaclass_attribute_updater_table_InterruptibleActivityRegion) +
    ("Interval" -> metaclass_attribute_updater_table_Interval) +
    ("IntervalConstraint" -> metaclass_attribute_updater_table_IntervalConstraint) +
    ("JoinNode" -> metaclass_attribute_updater_table_JoinNode) +
    ("Lifeline" -> metaclass_attribute_updater_table_Lifeline) +
    ("LinkEndCreationData" -> metaclass_attribute_updater_table_LinkEndCreationData) +
    ("LinkEndData" -> metaclass_attribute_updater_table_LinkEndData) +
    ("LinkEndDestructionData" -> metaclass_attribute_updater_table_LinkEndDestructionData) +
    ("LiteralBoolean" -> metaclass_attribute_updater_table_LiteralBoolean) +
    ("LiteralInteger" -> metaclass_attribute_updater_table_LiteralInteger) +
    ("LiteralNull" -> metaclass_attribute_updater_table_LiteralNull) +
    ("LiteralReal" -> metaclass_attribute_updater_table_LiteralReal) +
    ("LiteralString" -> metaclass_attribute_updater_table_LiteralString) +
    ("LiteralUnlimitedNatural" -> metaclass_attribute_updater_table_LiteralUnlimitedNatural) +
    ("LoopNode" -> metaclass_attribute_updater_table_LoopNode) +
    ("Manifestation" -> metaclass_attribute_updater_table_Manifestation) +
    ("MergeNode" -> metaclass_attribute_updater_table_MergeNode) +
    ("Message" -> metaclass_attribute_updater_table_Message) +
    ("MessageOccurrenceSpecification" -> metaclass_attribute_updater_table_MessageOccurrenceSpecification) +
    ("Model" -> metaclass_attribute_updater_table_Model) +
    ("Node" -> metaclass_attribute_updater_table_Node) +
    ("ObjectFlow" -> metaclass_attribute_updater_table_ObjectFlow) +
    ("OccurrenceSpecification" -> metaclass_attribute_updater_table_OccurrenceSpecification) +
    ("OpaqueAction" -> metaclass_attribute_updater_table_OpaqueAction) +
    ("OpaqueBehavior" -> metaclass_attribute_updater_table_OpaqueBehavior) +
    ("OpaqueExpression" -> metaclass_attribute_updater_table_OpaqueExpression) +
    ("Operation" -> metaclass_attribute_updater_table_Operation) +
    ("OperationTemplateParameter" -> metaclass_attribute_updater_table_OperationTemplateParameter) +
    ("OutputPin" -> metaclass_attribute_updater_table_OutputPin) +
    ("Package" -> metaclass_attribute_updater_table_Package) +
    ("PackageImport" -> metaclass_attribute_updater_table_PackageImport) +
    ("PackageMerge" -> metaclass_attribute_updater_table_PackageMerge) +
    ("Parameter" -> metaclass_attribute_updater_table_Parameter) +
    ("ParameterSet" -> metaclass_attribute_updater_table_ParameterSet) +
    ("PartDecomposition" -> metaclass_attribute_updater_table_PartDecomposition) +
    ("Port" -> metaclass_attribute_updater_table_Port) +
    ("PrimitiveType" -> metaclass_attribute_updater_table_PrimitiveType) +
    ("Profile" -> metaclass_attribute_updater_table_Profile) +
    ("ProfileApplication" -> metaclass_attribute_updater_table_ProfileApplication) +
    ("Property" -> metaclass_attribute_updater_table_Property) +
    ("ProtocolConformance" -> metaclass_attribute_updater_table_ProtocolConformance) +
    ("ProtocolStateMachine" -> metaclass_attribute_updater_table_ProtocolStateMachine) +
    ("ProtocolTransition" -> metaclass_attribute_updater_table_ProtocolTransition) +
    ("Pseudostate" -> metaclass_attribute_updater_table_Pseudostate) +
    ("QualifierValue" -> metaclass_attribute_updater_table_QualifierValue) +
    ("RaiseExceptionAction" -> metaclass_attribute_updater_table_RaiseExceptionAction) +
    ("ReadExtentAction" -> metaclass_attribute_updater_table_ReadExtentAction) +
    ("ReadIsClassifiedObjectAction" -> metaclass_attribute_updater_table_ReadIsClassifiedObjectAction) +
    ("ReadLinkAction" -> metaclass_attribute_updater_table_ReadLinkAction) +
    ("ReadLinkObjectEndAction" -> metaclass_attribute_updater_table_ReadLinkObjectEndAction) +
    ("ReadLinkObjectEndQualifierAction" -> metaclass_attribute_updater_table_ReadLinkObjectEndQualifierAction) +
    ("ReadSelfAction" -> metaclass_attribute_updater_table_ReadSelfAction) +
    ("ReadStructuralFeatureAction" -> metaclass_attribute_updater_table_ReadStructuralFeatureAction) +
    ("ReadVariableAction" -> metaclass_attribute_updater_table_ReadVariableAction) +
    ("Realization" -> metaclass_attribute_updater_table_Realization) +
    ("Reception" -> metaclass_attribute_updater_table_Reception) +
    ("ReclassifyObjectAction" -> metaclass_attribute_updater_table_ReclassifyObjectAction) +
    ("RedefinableTemplateSignature" -> metaclass_attribute_updater_table_RedefinableTemplateSignature) +
    ("ReduceAction" -> metaclass_attribute_updater_table_ReduceAction) +
    ("Region" -> metaclass_attribute_updater_table_Region) +
    ("RemoveStructuralFeatureValueAction" -> metaclass_attribute_updater_table_RemoveStructuralFeatureValueAction) +
    ("RemoveVariableValueAction" -> metaclass_attribute_updater_table_RemoveVariableValueAction) +
    ("ReplyAction" -> metaclass_attribute_updater_table_ReplyAction) +
    ("SendObjectAction" -> metaclass_attribute_updater_table_SendObjectAction) +
    ("SendSignalAction" -> metaclass_attribute_updater_table_SendSignalAction) +
    ("SequenceNode" -> metaclass_attribute_updater_table_SequenceNode) +
    ("Signal" -> metaclass_attribute_updater_table_Signal) +
    ("SignalEvent" -> metaclass_attribute_updater_table_SignalEvent) +
    ("Slot" -> metaclass_attribute_updater_table_Slot) +
    ("StartClassifierBehaviorAction" -> metaclass_attribute_updater_table_StartClassifierBehaviorAction) +
    ("StartObjectBehaviorAction" -> metaclass_attribute_updater_table_StartObjectBehaviorAction) +
    ("State" -> metaclass_attribute_updater_table_State) +
    ("StateInvariant" -> metaclass_attribute_updater_table_StateInvariant) +
    ("StateMachine" -> metaclass_attribute_updater_table_StateMachine) +
    ("Stereotype" -> metaclass_attribute_updater_table_Stereotype) +
    ("StringExpression" -> metaclass_attribute_updater_table_StringExpression) +
    ("StructuredActivityNode" -> metaclass_attribute_updater_table_StructuredActivityNode) +
    ("Substitution" -> metaclass_attribute_updater_table_Substitution) +
    ("TemplateBinding" -> metaclass_attribute_updater_table_TemplateBinding) +
    ("TemplateParameter" -> metaclass_attribute_updater_table_TemplateParameter) +
    ("TemplateParameterSubstitution" -> metaclass_attribute_updater_table_TemplateParameterSubstitution) +
    ("TemplateSignature" -> metaclass_attribute_updater_table_TemplateSignature) +
    ("TestIdentityAction" -> metaclass_attribute_updater_table_TestIdentityAction) +
    ("TimeConstraint" -> metaclass_attribute_updater_table_TimeConstraint) +
    ("TimeEvent" -> metaclass_attribute_updater_table_TimeEvent) +
    ("TimeExpression" -> metaclass_attribute_updater_table_TimeExpression) +
    ("TimeInterval" -> metaclass_attribute_updater_table_TimeInterval) +
    ("TimeObservation" -> metaclass_attribute_updater_table_TimeObservation) +
    ("Transition" -> metaclass_attribute_updater_table_Transition) +
    ("Trigger" -> metaclass_attribute_updater_table_Trigger) +
    ("UnmarshallAction" -> metaclass_attribute_updater_table_UnmarshallAction) +
    ("Usage" -> metaclass_attribute_updater_table_Usage) +
    ("UseCase" -> metaclass_attribute_updater_table_UseCase) +
    ("ValuePin" -> metaclass_attribute_updater_table_ValuePin) +
    ("ValueSpecificationAction" -> metaclass_attribute_updater_table_ValueSpecificationAction) +
    ("Variable" -> metaclass_attribute_updater_table_Variable)

  lazy val metaclass_attribute_updater_table_Abstraction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_AcceptCallAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isUnmarshall" -> MetaScalarAttributeUpdater_AcceptEventAction_isUnmarshall )

  lazy val metaclass_attribute_updater_table_AcceptEventAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isUnmarshall" -> MetaScalarAttributeUpdater_AcceptEventAction_isUnmarshall )

  lazy val metaclass_attribute_updater_table_ActionExecutionSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_ActionInputPin
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) :+
        ( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering ) :+
        ( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) :+
        ( "isControl" -> MetaScalarAttributeUpdater_Pin_isControl )

  lazy val metaclass_attribute_updater_table_Activity
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) :+
        ( "isReentrant" -> MetaScalarAttributeUpdater_Behavior_isReentrant ) :+
        ( "isReadOnly" -> MetaScalarAttributeUpdater_Activity_isReadOnly ) :+
        ( "isSingleExecution" -> MetaScalarAttributeUpdater_Activity_isSingleExecution )

  lazy val metaclass_attribute_updater_table_ActivityFinalNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_ActivityParameterNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) :+
        ( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering )

  lazy val metaclass_attribute_updater_table_ActivityPartition
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isDimension" -> MetaScalarAttributeUpdater_ActivityPartition_isDimension ) :+
        ( "isExternal" -> MetaScalarAttributeUpdater_ActivityPartition_isExternal )

  lazy val metaclass_attribute_updater_table_Actor
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_AddStructuralFeatureValueAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isReplaceAll" -> MetaScalarAttributeUpdater_AddStructuralFeatureValueAction_isReplaceAll )

  lazy val metaclass_attribute_updater_table_AddVariableValueAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isReplaceAll" -> MetaScalarAttributeUpdater_AddVariableValueAction_isReplaceAll )

  lazy val metaclass_attribute_updater_table_AnyReceiveEvent
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Artifact
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "fileName" -> MetaOptionAttributeUpdater_Artifact_fileName )

  lazy val metaclass_attribute_updater_table_Association
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isDerived" -> MetaScalarAttributeUpdater_Association_isDerived )

  lazy val metaclass_attribute_updater_table_AssociationClass
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) :+
        ( "isDerived" -> MetaScalarAttributeUpdater_Association_isDerived )

  lazy val metaclass_attribute_updater_table_BehaviorExecutionSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_BroadcastSignalAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_CallBehaviorAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isSynchronous" -> MetaScalarAttributeUpdater_CallAction_isSynchronous )

  lazy val metaclass_attribute_updater_table_CallEvent
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_CallOperationAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isSynchronous" -> MetaScalarAttributeUpdater_CallAction_isSynchronous )

  lazy val metaclass_attribute_updater_table_CentralBufferNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) :+
        ( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering )

  lazy val metaclass_attribute_updater_table_ChangeEvent
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Class
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive )

  lazy val metaclass_attribute_updater_table_ClassifierTemplateParameter
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "allowSubstitutable" -> MetaScalarAttributeUpdater_ClassifierTemplateParameter_allowSubstitutable )

  lazy val metaclass_attribute_updater_table_Clause
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_ClearAssociationAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ClearStructuralFeatureAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ClearVariableAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_Collaboration
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_CollaborationUse
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_CombinedFragment
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "interactionOperator" -> MetaEnumerationAttributeUpdater_CombinedFragment_interactionOperator )

  lazy val metaclass_attribute_updater_table_Comment
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "body" -> MetaOptionAttributeUpdater_Comment_body )

  lazy val metaclass_attribute_updater_table_CommunicationPath
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isDerived" -> MetaScalarAttributeUpdater_Association_isDerived )

  lazy val metaclass_attribute_updater_table_Component
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) :+
        ( "isIndirectlyInstantiated" -> MetaScalarAttributeUpdater_Component_isIndirectlyInstantiated )

  lazy val metaclass_attribute_updater_table_ComponentRealization
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_ConditionalNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "mustIsolate" -> MetaScalarAttributeUpdater_StructuredActivityNode_mustIsolate ) :+
        ( "isAssured" -> MetaScalarAttributeUpdater_ConditionalNode_isAssured ) :+
        ( "isDeterminate" -> MetaScalarAttributeUpdater_ConditionalNode_isDeterminate )

  lazy val metaclass_attribute_updater_table_ConnectableElementTemplateParameter
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_ConnectionPointReference
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Connector
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isStatic" -> MetaScalarAttributeUpdater_Feature_isStatic )

  lazy val metaclass_attribute_updater_table_ConnectorEnd
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique )

  lazy val metaclass_attribute_updater_table_ConsiderIgnoreFragment
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "interactionOperator" -> MetaEnumerationAttributeUpdater_CombinedFragment_interactionOperator )

  lazy val metaclass_attribute_updater_table_Constraint
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Continuation
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "setting" -> MetaScalarAttributeUpdater_Continuation_setting )

  lazy val metaclass_attribute_updater_table_ControlFlow
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_CreateLinkAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_CreateLinkObjectAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_CreateObjectAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_DataStoreNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) :+
        ( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering )

  lazy val metaclass_attribute_updater_table_DataType
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_DecisionNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_Dependency
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Deployment
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_DeploymentSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "fileName" -> MetaOptionAttributeUpdater_Artifact_fileName ) :+
        ( "deploymentLocation" -> MetaOptionAttributeUpdater_DeploymentSpecification_deploymentLocation ) :+
        ( "executionLocation" -> MetaOptionAttributeUpdater_DeploymentSpecification_executionLocation )

  lazy val metaclass_attribute_updater_table_DestroyLinkAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_DestroyObjectAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isDestroyLinks" -> MetaScalarAttributeUpdater_DestroyObjectAction_isDestroyLinks ) :+
        ( "isDestroyOwnedObjects" -> MetaScalarAttributeUpdater_DestroyObjectAction_isDestroyOwnedObjects )

  lazy val metaclass_attribute_updater_table_DestructionOccurrenceSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Device
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive )

  lazy val metaclass_attribute_updater_table_Duration
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_DurationConstraint
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "firstEvent" -> MetaSetAttributeUpdater_DurationConstraint_firstEvent )

  lazy val metaclass_attribute_updater_table_DurationInterval
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_DurationObservation
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "firstEvent" -> MetaSeqAttributeUpdater_DurationObservation_firstEvent )

  lazy val metaclass_attribute_updater_table_ElementImport
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "alias" -> MetaOptionAttributeUpdater_ElementImport_alias ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_ElementImport_visibility )

  lazy val metaclass_attribute_updater_table_Enumeration
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_EnumerationLiteral
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_ExceptionHandler
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_ExecutionEnvironment
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive )

  lazy val metaclass_attribute_updater_table_ExecutionOccurrenceSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_ExpansionNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) :+
        ( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering )

  lazy val metaclass_attribute_updater_table_ExpansionRegion
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "mustIsolate" -> MetaScalarAttributeUpdater_StructuredActivityNode_mustIsolate ) :+
        ( "mode" -> MetaEnumerationAttributeUpdater_ExpansionRegion_mode )

  lazy val metaclass_attribute_updater_table_Expression
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "symbol" -> MetaOptionAttributeUpdater_Expression_symbol )

  lazy val metaclass_attribute_updater_table_Extend
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Extension
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isDerived" -> MetaScalarAttributeUpdater_Association_isDerived )

  lazy val metaclass_attribute_updater_table_ExtensionEnd
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) :+
        ( "isStatic" -> MetaScalarAttributeUpdater_Feature_isStatic ) :+
        ( "isReadOnly" -> MetaScalarAttributeUpdater_StructuralFeature_isReadOnly ) :+
        ( "aggregation" -> MetaEnumerationAttributeUpdater_Property_aggregation ) :+
        ( "isDerived" -> MetaScalarAttributeUpdater_Property_isDerived ) :+
        ( "isDerivedUnion" -> MetaScalarAttributeUpdater_Property_isDerivedUnion ) :+
        ( "isID" -> MetaScalarAttributeUpdater_Property_isID )

  lazy val metaclass_attribute_updater_table_ExtensionPoint
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_FinalState
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_FlowFinalNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_ForkNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_FunctionBehavior
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) :+
        ( "isReentrant" -> MetaScalarAttributeUpdater_Behavior_isReentrant ) :+
        ( "body" -> MetaSeqAttributeUpdater_OpaqueBehavior_body ) :+
        ( "language" -> MetaSeqAttributeUpdater_OpaqueBehavior_language )

  lazy val metaclass_attribute_updater_table_Gate
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_GeneralOrdering
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Generalization
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "isSubstitutable" -> MetaOptionAttributeUpdater_Generalization_isSubstitutable )

  lazy val metaclass_attribute_updater_table_GeneralizationSet
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isCovering" -> MetaScalarAttributeUpdater_GeneralizationSet_isCovering ) :+
        ( "isDisjoint" -> MetaScalarAttributeUpdater_GeneralizationSet_isDisjoint )

  lazy val metaclass_attribute_updater_table_Image
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "content" -> MetaOptionAttributeUpdater_Image_content ) :+
        ( "format" -> MetaOptionAttributeUpdater_Image_format ) :+
        ( "location" -> MetaOptionAttributeUpdater_Image_location )

  lazy val metaclass_attribute_updater_table_Include
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_InformationFlow
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_InformationItem
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_InitialNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_InputPin
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) :+
        ( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering ) :+
        ( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) :+
        ( "isControl" -> MetaScalarAttributeUpdater_Pin_isControl )

  lazy val metaclass_attribute_updater_table_InstanceSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_InstanceValue
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Interaction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) :+
        ( "isReentrant" -> MetaScalarAttributeUpdater_Behavior_isReentrant )

  lazy val metaclass_attribute_updater_table_InteractionConstraint
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_InteractionOperand
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_InteractionUse
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Interface
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_InterfaceRealization
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_InterruptibleActivityRegion
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Interval
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_IntervalConstraint
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_JoinNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isCombineDuplicate" -> MetaScalarAttributeUpdater_JoinNode_isCombineDuplicate )

  lazy val metaclass_attribute_updater_table_Lifeline
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_LinkEndCreationData
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "isReplaceAll" -> MetaScalarAttributeUpdater_LinkEndCreationData_isReplaceAll )

  lazy val metaclass_attribute_updater_table_LinkEndData
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_LinkEndDestructionData
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "isDestroyDuplicates" -> MetaScalarAttributeUpdater_LinkEndDestructionData_isDestroyDuplicates )

  lazy val metaclass_attribute_updater_table_LiteralBoolean
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "value" -> MetaScalarAttributeUpdater_LiteralBoolean_value )

  lazy val metaclass_attribute_updater_table_LiteralInteger
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "value" -> MetaScalarAttributeUpdater_LiteralInteger_value )

  lazy val metaclass_attribute_updater_table_LiteralNull
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_LiteralReal
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "value" -> MetaScalarAttributeUpdater_LiteralReal_value )

  lazy val metaclass_attribute_updater_table_LiteralString
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "value" -> MetaOptionAttributeUpdater_LiteralString_value )

  lazy val metaclass_attribute_updater_table_LiteralUnlimitedNatural
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "value" -> MetaScalarAttributeUpdater_LiteralUnlimitedNatural_value )

  lazy val metaclass_attribute_updater_table_LoopNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "mustIsolate" -> MetaScalarAttributeUpdater_StructuredActivityNode_mustIsolate ) :+
        ( "isTestedFirst" -> MetaScalarAttributeUpdater_LoopNode_isTestedFirst )

  lazy val metaclass_attribute_updater_table_Manifestation
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_MergeNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_Message
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "messageSort" -> MetaEnumerationAttributeUpdater_Message_messageSort )

  lazy val metaclass_attribute_updater_table_MessageOccurrenceSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Model
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "URI" -> MetaOptionAttributeUpdater_Package_URI ) :+
        ( "viewpoint" -> MetaOptionAttributeUpdater_Model_viewpoint )

  lazy val metaclass_attribute_updater_table_Node
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive )

  lazy val metaclass_attribute_updater_table_ObjectFlow
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isMulticast" -> MetaScalarAttributeUpdater_ObjectFlow_isMulticast ) :+
        ( "isMultireceive" -> MetaScalarAttributeUpdater_ObjectFlow_isMultireceive )

  lazy val metaclass_attribute_updater_table_OccurrenceSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_OpaqueAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "body" -> MetaSeqAttributeUpdater_OpaqueAction_body ) :+
        ( "language" -> MetaSeqAttributeUpdater_OpaqueAction_language )

  lazy val metaclass_attribute_updater_table_OpaqueBehavior
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) :+
        ( "isReentrant" -> MetaScalarAttributeUpdater_Behavior_isReentrant ) :+
        ( "body" -> MetaSeqAttributeUpdater_OpaqueBehavior_body ) :+
        ( "language" -> MetaSeqAttributeUpdater_OpaqueBehavior_language )

  lazy val metaclass_attribute_updater_table_OpaqueExpression
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "body" -> MetaSeqAttributeUpdater_OpaqueExpression_body ) :+
        ( "language" -> MetaSeqAttributeUpdater_OpaqueExpression_language )

  lazy val metaclass_attribute_updater_table_Operation
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isStatic" -> MetaScalarAttributeUpdater_Feature_isStatic ) :+
        ( "concurrency" -> MetaEnumerationAttributeUpdater_BehavioralFeature_concurrency ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_BehavioralFeature_isAbstract ) :+
        ( "isQuery" -> MetaScalarAttributeUpdater_Operation_isQuery )

  lazy val metaclass_attribute_updater_table_OperationTemplateParameter
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_OutputPin
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) :+
        ( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering ) :+
        ( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) :+
        ( "isControl" -> MetaScalarAttributeUpdater_Pin_isControl )

  lazy val metaclass_attribute_updater_table_Package
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "URI" -> MetaOptionAttributeUpdater_Package_URI )

  lazy val metaclass_attribute_updater_table_PackageImport
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageImport_visibility )

  lazy val metaclass_attribute_updater_table_PackageMerge
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_Parameter
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) :+
        ( "direction" -> MetaEnumerationAttributeUpdater_Parameter_direction ) :+
        ( "effect" -> MetaEnumerationAttributeUpdater_Parameter_effect ) :+
        ( "isException" -> MetaScalarAttributeUpdater_Parameter_isException ) :+
        ( "isStream" -> MetaScalarAttributeUpdater_Parameter_isStream )

  lazy val metaclass_attribute_updater_table_ParameterSet
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_PartDecomposition
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Port
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isStatic" -> MetaScalarAttributeUpdater_Feature_isStatic ) :+
        ( "isReadOnly" -> MetaScalarAttributeUpdater_StructuralFeature_isReadOnly ) :+
        ( "aggregation" -> MetaEnumerationAttributeUpdater_Property_aggregation ) :+
        ( "isDerived" -> MetaScalarAttributeUpdater_Property_isDerived ) :+
        ( "isDerivedUnion" -> MetaScalarAttributeUpdater_Property_isDerivedUnion ) :+
        ( "isID" -> MetaScalarAttributeUpdater_Property_isID ) :+
        ( "isBehavior" -> MetaScalarAttributeUpdater_Port_isBehavior ) :+
        ( "isConjugated" -> MetaScalarAttributeUpdater_Port_isConjugated ) :+
        ( "isService" -> MetaScalarAttributeUpdater_Port_isService )

  lazy val metaclass_attribute_updater_table_PrimitiveType
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_Profile
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "URI" -> MetaOptionAttributeUpdater_Package_URI )

  lazy val metaclass_attribute_updater_table_ProfileApplication
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "isStrict" -> MetaScalarAttributeUpdater_ProfileApplication_isStrict )

  lazy val metaclass_attribute_updater_table_Property
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) :+
        ( "isStatic" -> MetaScalarAttributeUpdater_Feature_isStatic ) :+
        ( "isReadOnly" -> MetaScalarAttributeUpdater_StructuralFeature_isReadOnly ) :+
        ( "aggregation" -> MetaEnumerationAttributeUpdater_Property_aggregation ) :+
        ( "isDerived" -> MetaScalarAttributeUpdater_Property_isDerived ) :+
        ( "isDerivedUnion" -> MetaScalarAttributeUpdater_Property_isDerivedUnion ) :+
        ( "isID" -> MetaScalarAttributeUpdater_Property_isID )

  lazy val metaclass_attribute_updater_table_ProtocolConformance
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_ProtocolStateMachine
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) :+
        ( "isReentrant" -> MetaScalarAttributeUpdater_Behavior_isReentrant )

  lazy val metaclass_attribute_updater_table_ProtocolTransition
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "kind" -> MetaEnumerationAttributeUpdater_Transition_kind )

  lazy val metaclass_attribute_updater_table_Pseudostate
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "kind" -> MetaEnumerationAttributeUpdater_Pseudostate_kind )

  lazy val metaclass_attribute_updater_table_QualifierValue
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_RaiseExceptionAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadExtentAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadIsClassifiedObjectAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isDirect" -> MetaScalarAttributeUpdater_ReadIsClassifiedObjectAction_isDirect )

  lazy val metaclass_attribute_updater_table_ReadLinkAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadLinkObjectEndAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadLinkObjectEndQualifierAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadSelfAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadStructuralFeatureAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadVariableAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_Realization
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Reception
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isStatic" -> MetaScalarAttributeUpdater_Feature_isStatic ) :+
        ( "concurrency" -> MetaEnumerationAttributeUpdater_BehavioralFeature_concurrency ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_BehavioralFeature_isAbstract )

  lazy val metaclass_attribute_updater_table_ReclassifyObjectAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isReplaceAll" -> MetaScalarAttributeUpdater_ReclassifyObjectAction_isReplaceAll )

  lazy val metaclass_attribute_updater_table_RedefinableTemplateSignature
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_ReduceAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isOrdered" -> MetaScalarAttributeUpdater_ReduceAction_isOrdered )

  lazy val metaclass_attribute_updater_table_Region
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_RemoveStructuralFeatureValueAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isRemoveDuplicates" -> MetaScalarAttributeUpdater_RemoveStructuralFeatureValueAction_isRemoveDuplicates )

  lazy val metaclass_attribute_updater_table_RemoveVariableValueAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isRemoveDuplicates" -> MetaScalarAttributeUpdater_RemoveVariableValueAction_isRemoveDuplicates )

  lazy val metaclass_attribute_updater_table_ReplyAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_SendObjectAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_SendSignalAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_SequenceNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "mustIsolate" -> MetaScalarAttributeUpdater_StructuredActivityNode_mustIsolate )

  lazy val metaclass_attribute_updater_table_Signal
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_SignalEvent
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Slot
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_StartClassifierBehaviorAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_StartObjectBehaviorAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "isSynchronous" -> MetaScalarAttributeUpdater_CallAction_isSynchronous )

  lazy val metaclass_attribute_updater_table_State
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_StateInvariant
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_StateMachine
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive ) :+
        ( "isReentrant" -> MetaScalarAttributeUpdater_Behavior_isReentrant )

  lazy val metaclass_attribute_updater_table_Stereotype
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Class_isAbstract ) :+
        ( "isActive" -> MetaScalarAttributeUpdater_Class_isActive )

  lazy val metaclass_attribute_updater_table_StringExpression
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "symbol" -> MetaOptionAttributeUpdater_Expression_symbol )

  lazy val metaclass_attribute_updater_table_StructuredActivityNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant ) :+
        ( "mustIsolate" -> MetaScalarAttributeUpdater_StructuredActivityNode_mustIsolate )

  lazy val metaclass_attribute_updater_table_Substitution
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_TemplateBinding
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_TemplateParameter
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_TemplateParameterSubstitution
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_TemplateSignature
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_TestIdentityAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_TimeConstraint
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "firstEvent" -> MetaOptionAttributeUpdater_TimeConstraint_firstEvent )

  lazy val metaclass_attribute_updater_table_TimeEvent
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isRelative" -> MetaScalarAttributeUpdater_TimeEvent_isRelative )

  lazy val metaclass_attribute_updater_table_TimeExpression
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_TimeInterval
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_TimeObservation
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "firstEvent" -> MetaScalarAttributeUpdater_TimeObservation_firstEvent )

  lazy val metaclass_attribute_updater_table_Transition
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "kind" -> MetaEnumerationAttributeUpdater_Transition_kind )

  lazy val metaclass_attribute_updater_table_Trigger
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_UnmarshallAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_Usage
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_UseCase
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_PackageableElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> MetaScalarAttributeUpdater_Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> MetaScalarAttributeUpdater_Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_ValuePin
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isControlType" -> MetaScalarAttributeUpdater_ObjectNode_isControlType ) :+
        ( "ordering" -> MetaEnumerationAttributeUpdater_ObjectNode_ordering ) :+
        ( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique ) :+
        ( "isControl" -> MetaScalarAttributeUpdater_Pin_isControl )

  lazy val metaclass_attribute_updater_table_ValueSpecificationAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isLeaf" -> MetaScalarAttributeUpdater_RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> MetaScalarAttributeUpdater_Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_Variable
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> MetaOptionAttributeUpdater_NamedElement_name ) :+
        ( "visibility" -> MetaEnumerationAttributeUpdater_NamedElement_visibility ) :+
        ( "isOrdered" -> MetaScalarAttributeUpdater_MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MetaScalarAttributeUpdater_MultiplicityElement_isUnique )

  /** Maps the name of each concrete metaclass to a map of composite property name to meta-information.
    * Note: Composite properties in these maps are metaclass-owned properties typed by a metaclass
    *       with composite aggregation.
    */
  lazy val metaclass_composite_updater_table
  : Map[String, Seq[(String, AssociationMetaPropertyUpdater)]]
  = Map[String, Seq[(String, AssociationMetaPropertyUpdater)]] () +
    ("Abstraction" -> metaclass_composite_updater_table_Abstraction) +
    ("AcceptCallAction" -> metaclass_composite_updater_table_AcceptCallAction) +
    ("AcceptEventAction" -> metaclass_composite_updater_table_AcceptEventAction) +
    ("ActionExecutionSpecification" -> metaclass_composite_updater_table_ActionExecutionSpecification) +
    ("ActionInputPin" -> metaclass_composite_updater_table_ActionInputPin) +
    ("Activity" -> metaclass_composite_updater_table_Activity) +
    ("ActivityFinalNode" -> metaclass_composite_updater_table_ActivityFinalNode) +
    ("ActivityParameterNode" -> metaclass_composite_updater_table_ActivityParameterNode) +
    ("ActivityPartition" -> metaclass_composite_updater_table_ActivityPartition) +
    ("Actor" -> metaclass_composite_updater_table_Actor) +
    ("AddStructuralFeatureValueAction" -> metaclass_composite_updater_table_AddStructuralFeatureValueAction) +
    ("AddVariableValueAction" -> metaclass_composite_updater_table_AddVariableValueAction) +
    ("AnyReceiveEvent" -> metaclass_composite_updater_table_AnyReceiveEvent) +
    ("Artifact" -> metaclass_composite_updater_table_Artifact) +
    ("Association" -> metaclass_composite_updater_table_Association) +
    ("AssociationClass" -> metaclass_composite_updater_table_AssociationClass) +
    ("BehaviorExecutionSpecification" -> metaclass_composite_updater_table_BehaviorExecutionSpecification) +
    ("BroadcastSignalAction" -> metaclass_composite_updater_table_BroadcastSignalAction) +
    ("CallBehaviorAction" -> metaclass_composite_updater_table_CallBehaviorAction) +
    ("CallEvent" -> metaclass_composite_updater_table_CallEvent) +
    ("CallOperationAction" -> metaclass_composite_updater_table_CallOperationAction) +
    ("CentralBufferNode" -> metaclass_composite_updater_table_CentralBufferNode) +
    ("ChangeEvent" -> metaclass_composite_updater_table_ChangeEvent) +
    ("Class" -> metaclass_composite_updater_table_Class) +
    ("ClassifierTemplateParameter" -> metaclass_composite_updater_table_ClassifierTemplateParameter) +
    ("Clause" -> metaclass_composite_updater_table_Clause) +
    ("ClearAssociationAction" -> metaclass_composite_updater_table_ClearAssociationAction) +
    ("ClearStructuralFeatureAction" -> metaclass_composite_updater_table_ClearStructuralFeatureAction) +
    ("ClearVariableAction" -> metaclass_composite_updater_table_ClearVariableAction) +
    ("Collaboration" -> metaclass_composite_updater_table_Collaboration) +
    ("CollaborationUse" -> metaclass_composite_updater_table_CollaborationUse) +
    ("CombinedFragment" -> metaclass_composite_updater_table_CombinedFragment) +
    ("Comment" -> metaclass_composite_updater_table_Comment) +
    ("CommunicationPath" -> metaclass_composite_updater_table_CommunicationPath) +
    ("Component" -> metaclass_composite_updater_table_Component) +
    ("ComponentRealization" -> metaclass_composite_updater_table_ComponentRealization) +
    ("ConditionalNode" -> metaclass_composite_updater_table_ConditionalNode) +
    ("ConnectableElementTemplateParameter" -> metaclass_composite_updater_table_ConnectableElementTemplateParameter) +
    ("ConnectionPointReference" -> metaclass_composite_updater_table_ConnectionPointReference) +
    ("Connector" -> metaclass_composite_updater_table_Connector) +
    ("ConnectorEnd" -> metaclass_composite_updater_table_ConnectorEnd) +
    ("ConsiderIgnoreFragment" -> metaclass_composite_updater_table_ConsiderIgnoreFragment) +
    ("Constraint" -> metaclass_composite_updater_table_Constraint) +
    ("Continuation" -> metaclass_composite_updater_table_Continuation) +
    ("ControlFlow" -> metaclass_composite_updater_table_ControlFlow) +
    ("CreateLinkAction" -> metaclass_composite_updater_table_CreateLinkAction) +
    ("CreateLinkObjectAction" -> metaclass_composite_updater_table_CreateLinkObjectAction) +
    ("CreateObjectAction" -> metaclass_composite_updater_table_CreateObjectAction) +
    ("DataStoreNode" -> metaclass_composite_updater_table_DataStoreNode) +
    ("DataType" -> metaclass_composite_updater_table_DataType) +
    ("DecisionNode" -> metaclass_composite_updater_table_DecisionNode) +
    ("Dependency" -> metaclass_composite_updater_table_Dependency) +
    ("Deployment" -> metaclass_composite_updater_table_Deployment) +
    ("DeploymentSpecification" -> metaclass_composite_updater_table_DeploymentSpecification) +
    ("DestroyLinkAction" -> metaclass_composite_updater_table_DestroyLinkAction) +
    ("DestroyObjectAction" -> metaclass_composite_updater_table_DestroyObjectAction) +
    ("DestructionOccurrenceSpecification" -> metaclass_composite_updater_table_DestructionOccurrenceSpecification) +
    ("Device" -> metaclass_composite_updater_table_Device) +
    ("Duration" -> metaclass_composite_updater_table_Duration) +
    ("DurationConstraint" -> metaclass_composite_updater_table_DurationConstraint) +
    ("DurationInterval" -> metaclass_composite_updater_table_DurationInterval) +
    ("DurationObservation" -> metaclass_composite_updater_table_DurationObservation) +
    ("ElementImport" -> metaclass_composite_updater_table_ElementImport) +
    ("Enumeration" -> metaclass_composite_updater_table_Enumeration) +
    ("EnumerationLiteral" -> metaclass_composite_updater_table_EnumerationLiteral) +
    ("ExceptionHandler" -> metaclass_composite_updater_table_ExceptionHandler) +
    ("ExecutionEnvironment" -> metaclass_composite_updater_table_ExecutionEnvironment) +
    ("ExecutionOccurrenceSpecification" -> metaclass_composite_updater_table_ExecutionOccurrenceSpecification) +
    ("ExpansionNode" -> metaclass_composite_updater_table_ExpansionNode) +
    ("ExpansionRegion" -> metaclass_composite_updater_table_ExpansionRegion) +
    ("Expression" -> metaclass_composite_updater_table_Expression) +
    ("Extend" -> metaclass_composite_updater_table_Extend) +
    ("Extension" -> metaclass_composite_updater_table_Extension) +
    ("ExtensionEnd" -> metaclass_composite_updater_table_ExtensionEnd) +
    ("ExtensionPoint" -> metaclass_composite_updater_table_ExtensionPoint) +
    ("FinalState" -> metaclass_composite_updater_table_FinalState) +
    ("FlowFinalNode" -> metaclass_composite_updater_table_FlowFinalNode) +
    ("ForkNode" -> metaclass_composite_updater_table_ForkNode) +
    ("FunctionBehavior" -> metaclass_composite_updater_table_FunctionBehavior) +
    ("Gate" -> metaclass_composite_updater_table_Gate) +
    ("GeneralOrdering" -> metaclass_composite_updater_table_GeneralOrdering) +
    ("Generalization" -> metaclass_composite_updater_table_Generalization) +
    ("GeneralizationSet" -> metaclass_composite_updater_table_GeneralizationSet) +
    ("Image" -> metaclass_composite_updater_table_Image) +
    ("Include" -> metaclass_composite_updater_table_Include) +
    ("InformationFlow" -> metaclass_composite_updater_table_InformationFlow) +
    ("InformationItem" -> metaclass_composite_updater_table_InformationItem) +
    ("InitialNode" -> metaclass_composite_updater_table_InitialNode) +
    ("InputPin" -> metaclass_composite_updater_table_InputPin) +
    ("InstanceSpecification" -> metaclass_composite_updater_table_InstanceSpecification) +
    ("InstanceValue" -> metaclass_composite_updater_table_InstanceValue) +
    ("Interaction" -> metaclass_composite_updater_table_Interaction) +
    ("InteractionConstraint" -> metaclass_composite_updater_table_InteractionConstraint) +
    ("InteractionOperand" -> metaclass_composite_updater_table_InteractionOperand) +
    ("InteractionUse" -> metaclass_composite_updater_table_InteractionUse) +
    ("Interface" -> metaclass_composite_updater_table_Interface) +
    ("InterfaceRealization" -> metaclass_composite_updater_table_InterfaceRealization) +
    ("InterruptibleActivityRegion" -> metaclass_composite_updater_table_InterruptibleActivityRegion) +
    ("Interval" -> metaclass_composite_updater_table_Interval) +
    ("IntervalConstraint" -> metaclass_composite_updater_table_IntervalConstraint) +
    ("JoinNode" -> metaclass_composite_updater_table_JoinNode) +
    ("Lifeline" -> metaclass_composite_updater_table_Lifeline) +
    ("LinkEndCreationData" -> metaclass_composite_updater_table_LinkEndCreationData) +
    ("LinkEndData" -> metaclass_composite_updater_table_LinkEndData) +
    ("LinkEndDestructionData" -> metaclass_composite_updater_table_LinkEndDestructionData) +
    ("LiteralBoolean" -> metaclass_composite_updater_table_LiteralBoolean) +
    ("LiteralInteger" -> metaclass_composite_updater_table_LiteralInteger) +
    ("LiteralNull" -> metaclass_composite_updater_table_LiteralNull) +
    ("LiteralReal" -> metaclass_composite_updater_table_LiteralReal) +
    ("LiteralString" -> metaclass_composite_updater_table_LiteralString) +
    ("LiteralUnlimitedNatural" -> metaclass_composite_updater_table_LiteralUnlimitedNatural) +
    ("LoopNode" -> metaclass_composite_updater_table_LoopNode) +
    ("Manifestation" -> metaclass_composite_updater_table_Manifestation) +
    ("MergeNode" -> metaclass_composite_updater_table_MergeNode) +
    ("Message" -> metaclass_composite_updater_table_Message) +
    ("MessageOccurrenceSpecification" -> metaclass_composite_updater_table_MessageOccurrenceSpecification) +
    ("Model" -> metaclass_composite_updater_table_Model) +
    ("Node" -> metaclass_composite_updater_table_Node) +
    ("ObjectFlow" -> metaclass_composite_updater_table_ObjectFlow) +
    ("OccurrenceSpecification" -> metaclass_composite_updater_table_OccurrenceSpecification) +
    ("OpaqueAction" -> metaclass_composite_updater_table_OpaqueAction) +
    ("OpaqueBehavior" -> metaclass_composite_updater_table_OpaqueBehavior) +
    ("OpaqueExpression" -> metaclass_composite_updater_table_OpaqueExpression) +
    ("Operation" -> metaclass_composite_updater_table_Operation) +
    ("OperationTemplateParameter" -> metaclass_composite_updater_table_OperationTemplateParameter) +
    ("OutputPin" -> metaclass_composite_updater_table_OutputPin) +
    ("Package" -> metaclass_composite_updater_table_Package) +
    ("PackageImport" -> metaclass_composite_updater_table_PackageImport) +
    ("PackageMerge" -> metaclass_composite_updater_table_PackageMerge) +
    ("Parameter" -> metaclass_composite_updater_table_Parameter) +
    ("ParameterSet" -> metaclass_composite_updater_table_ParameterSet) +
    ("PartDecomposition" -> metaclass_composite_updater_table_PartDecomposition) +
    ("Port" -> metaclass_composite_updater_table_Port) +
    ("PrimitiveType" -> metaclass_composite_updater_table_PrimitiveType) +
    ("Profile" -> metaclass_composite_updater_table_Profile) +
    ("ProfileApplication" -> metaclass_composite_updater_table_ProfileApplication) +
    ("Property" -> metaclass_composite_updater_table_Property) +
    ("ProtocolConformance" -> metaclass_composite_updater_table_ProtocolConformance) +
    ("ProtocolStateMachine" -> metaclass_composite_updater_table_ProtocolStateMachine) +
    ("ProtocolTransition" -> metaclass_composite_updater_table_ProtocolTransition) +
    ("Pseudostate" -> metaclass_composite_updater_table_Pseudostate) +
    ("QualifierValue" -> metaclass_composite_updater_table_QualifierValue) +
    ("RaiseExceptionAction" -> metaclass_composite_updater_table_RaiseExceptionAction) +
    ("ReadExtentAction" -> metaclass_composite_updater_table_ReadExtentAction) +
    ("ReadIsClassifiedObjectAction" -> metaclass_composite_updater_table_ReadIsClassifiedObjectAction) +
    ("ReadLinkAction" -> metaclass_composite_updater_table_ReadLinkAction) +
    ("ReadLinkObjectEndAction" -> metaclass_composite_updater_table_ReadLinkObjectEndAction) +
    ("ReadLinkObjectEndQualifierAction" -> metaclass_composite_updater_table_ReadLinkObjectEndQualifierAction) +
    ("ReadSelfAction" -> metaclass_composite_updater_table_ReadSelfAction) +
    ("ReadStructuralFeatureAction" -> metaclass_composite_updater_table_ReadStructuralFeatureAction) +
    ("ReadVariableAction" -> metaclass_composite_updater_table_ReadVariableAction) +
    ("Realization" -> metaclass_composite_updater_table_Realization) +
    ("Reception" -> metaclass_composite_updater_table_Reception) +
    ("ReclassifyObjectAction" -> metaclass_composite_updater_table_ReclassifyObjectAction) +
    ("RedefinableTemplateSignature" -> metaclass_composite_updater_table_RedefinableTemplateSignature) +
    ("ReduceAction" -> metaclass_composite_updater_table_ReduceAction) +
    ("Region" -> metaclass_composite_updater_table_Region) +
    ("RemoveStructuralFeatureValueAction" -> metaclass_composite_updater_table_RemoveStructuralFeatureValueAction) +
    ("RemoveVariableValueAction" -> metaclass_composite_updater_table_RemoveVariableValueAction) +
    ("ReplyAction" -> metaclass_composite_updater_table_ReplyAction) +
    ("SendObjectAction" -> metaclass_composite_updater_table_SendObjectAction) +
    ("SendSignalAction" -> metaclass_composite_updater_table_SendSignalAction) +
    ("SequenceNode" -> metaclass_composite_updater_table_SequenceNode) +
    ("Signal" -> metaclass_composite_updater_table_Signal) +
    ("SignalEvent" -> metaclass_composite_updater_table_SignalEvent) +
    ("Slot" -> metaclass_composite_updater_table_Slot) +
    ("StartClassifierBehaviorAction" -> metaclass_composite_updater_table_StartClassifierBehaviorAction) +
    ("StartObjectBehaviorAction" -> metaclass_composite_updater_table_StartObjectBehaviorAction) +
    ("State" -> metaclass_composite_updater_table_State) +
    ("StateInvariant" -> metaclass_composite_updater_table_StateInvariant) +
    ("StateMachine" -> metaclass_composite_updater_table_StateMachine) +
    ("Stereotype" -> metaclass_composite_updater_table_Stereotype) +
    ("StringExpression" -> metaclass_composite_updater_table_StringExpression) +
    ("StructuredActivityNode" -> metaclass_composite_updater_table_StructuredActivityNode) +
    ("Substitution" -> metaclass_composite_updater_table_Substitution) +
    ("TemplateBinding" -> metaclass_composite_updater_table_TemplateBinding) +
    ("TemplateParameter" -> metaclass_composite_updater_table_TemplateParameter) +
    ("TemplateParameterSubstitution" -> metaclass_composite_updater_table_TemplateParameterSubstitution) +
    ("TemplateSignature" -> metaclass_composite_updater_table_TemplateSignature) +
    ("TestIdentityAction" -> metaclass_composite_updater_table_TestIdentityAction) +
    ("TimeConstraint" -> metaclass_composite_updater_table_TimeConstraint) +
    ("TimeEvent" -> metaclass_composite_updater_table_TimeEvent) +
    ("TimeExpression" -> metaclass_composite_updater_table_TimeExpression) +
    ("TimeInterval" -> metaclass_composite_updater_table_TimeInterval) +
    ("TimeObservation" -> metaclass_composite_updater_table_TimeObservation) +
    ("Transition" -> metaclass_composite_updater_table_Transition) +
    ("Trigger" -> metaclass_composite_updater_table_Trigger) +
    ("UnmarshallAction" -> metaclass_composite_updater_table_UnmarshallAction) +
    ("Usage" -> metaclass_composite_updater_table_Usage) +
    ("UseCase" -> metaclass_composite_updater_table_UseCase) +
    ("ValuePin" -> metaclass_composite_updater_table_ValuePin) +
    ("ValueSpecificationAction" -> metaclass_composite_updater_table_ValueSpecificationAction) +
    ("Variable" -> metaclass_composite_updater_table_Variable)

  // All parents: {Abstraction, Dependency, DirectedRelationship, PackageableElement, Relationship, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Abstraction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "mapping" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Abstraction_abstraction_compose_mapping_OpaqueExpression _,
          ops.Abstraction_mapping))

  // All parents: {AcceptCallAction, AcceptEventAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_AcceptCallAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "result" -> AssociationMetaPropertySequenceUpdateInfo(
          links_AcceptEventAction_acceptEventAction_compose_result_OutputPin _,
          ops.AcceptEventAction_result)) :+
        ( "trigger" -> AssociationMetaPropertySetUpdateInfo(
          links_AcceptEventAction_acceptEventAction_compose_trigger_Trigger _,
          ops.AcceptEventAction_trigger)) :+
        ( "returnInformation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_AcceptCallAction_acceptCallAction_compose_returnInformation_OutputPin _,
          ops.AcceptCallAction_returnInformation))

  // All parents: {AcceptEventAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_AcceptEventAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "result" -> AssociationMetaPropertySequenceUpdateInfo(
          links_AcceptEventAction_acceptEventAction_compose_result_OutputPin _,
          ops.AcceptEventAction_result)) :+
        ( "trigger" -> AssociationMetaPropertySetUpdateInfo(
          links_AcceptEventAction_acceptEventAction_compose_trigger_Trigger _,
          ops.AcceptEventAction_trigger))

  // All parents: {ActionExecutionSpecification, ExecutionSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ActionExecutionSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering))

  // All parents: {ActionInputPin, InputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ActionInputPin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "upperBound" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_compose_upperBound_ValueSpecification _,
          ops.ObjectNode_upperBound)) :+
        ( "lowerValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
          ops.MultiplicityElement_lowerValue)) :+
        ( "upperValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
          ops.MultiplicityElement_upperValue)) :+
        ( "fromAction" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActionInputPin_actionInputPin_compose_fromAction_Action _,
          ops.ActionInputPin_fromAction))

  // All parents: {Activity, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Activity
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception)) :+
        ( "ownedParameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Behavior_behavior_compose_ownedParameter_Parameter _,
          ops.Behavior_ownedParameter)) :+
        ( "ownedParameterSet" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_ownedParameterSet_ParameterSet _,
          ops.Behavior_ownedParameterSet)) :+
        ( "edge" -> AssociationMetaPropertySetUpdateInfo(
          links_Activity_activity_compose_edge_ActivityEdge _,
          ops.Activity_edge)) :+
        ( "group" -> AssociationMetaPropertySetUpdateInfo(
          links_Activity_inActivity_compose_group_ActivityGroup _,
          ops.Activity_group)) :+
        ( "node" -> AssociationMetaPropertySetUpdateInfo(
          links_Activity_activity_compose_node_ActivityNode _,
          ops.Activity_node)) :+
        ( "variable" -> AssociationMetaPropertySetUpdateInfo(
          links_Activity_activityScope_compose_variable_Variable _,
          ops.Activity_variable))

  // All parents: {ActivityFinalNode, FinalNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ActivityFinalNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {ActivityParameterNode, ObjectNode, ActivityNode, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ActivityParameterNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "upperBound" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_compose_upperBound_ValueSpecification _,
          ops.ObjectNode_upperBound))

  // All parents: {ActivityPartition, ActivityGroup, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ActivityPartition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "subpartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityPartition_superPartition_compose_subpartition_ActivityPartition _,
          ops.ActivityPartition_subpartition))

  // All parents: {Actor, BehavioredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Actor
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior))

  // All parents: {AddStructuralFeatureValueAction, WriteStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_AddStructuralFeatureValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "object" -> AssociationMetaPropertyOptionUpdateInfo(
          links_StructuralFeatureAction_structuralFeatureAction_compose_object_InputPin _,
          ops.StructuralFeatureAction_object)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_result_OutputPin _,
          ops.WriteStructuralFeatureAction_result)) :+
        ( "value" -> AssociationMetaPropertyOptionUpdateInfo(
          links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_value_InputPin _,
          ops.WriteStructuralFeatureAction_value)) :+
        ( "insertAt" -> AssociationMetaPropertyOptionUpdateInfo(
          links_AddStructuralFeatureValueAction_addStructuralFeatureValueAction_compose_insertAt_InputPin _,
          ops.AddStructuralFeatureValueAction_insertAt))

  // All parents: {AddVariableValueAction, WriteVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_AddVariableValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "value" -> AssociationMetaPropertyOptionUpdateInfo(
          links_WriteVariableAction_writeVariableAction_compose_value_InputPin _,
          ops.WriteVariableAction_value)) :+
        ( "insertAt" -> AssociationMetaPropertyOptionUpdateInfo(
          links_AddVariableValueAction_addVariableValueAction_compose_insertAt_InputPin _,
          ops.AddVariableValueAction_insertAt))

  // All parents: {AnyReceiveEvent, MessageEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_AnyReceiveEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {Artifact, Classifier, Namespace, DeployedArtifact, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Artifact
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "manifestation" -> AssociationMetaPropertySetUpdateInfo(
          links_Artifact_artifact_compose_manifestation_Manifestation _,
          ops.Artifact_manifestation)) :+
        ( "nestedArtifact" -> AssociationMetaPropertySetUpdateInfo(
          links_Artifact_artifact_compose_nestedArtifact_Artifact _,
          ops.Artifact_nestedArtifact)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Artifact_artifact_compose_ownedAttribute_Property _,
          ops.Artifact_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Artifact_artifact_compose_ownedOperation_Operation _,
          ops.Artifact_ownedOperation))

  // All parents: {Association, Classifier, Relationship, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Association
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedEnd" -> AssociationMetaPropertyIterableUpdateInfo(
          links_Association_owningAssociation_compose_ownedEnd_Property _,
          ops.Association_ownedEnd))

  // All parents: {AssociationClass, Association, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, Relationship, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_AssociationClass
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception)) :+
        ( "ownedEnd" -> AssociationMetaPropertyIterableUpdateInfo(
          links_Association_owningAssociation_compose_ownedEnd_Property _,
          ops.Association_ownedEnd))

  // All parents: {BehaviorExecutionSpecification, ExecutionSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_BehaviorExecutionSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering))

  // All parents: {BroadcastSignalAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_BroadcastSignalAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "argument" -> AssociationMetaPropertySequenceUpdateInfo(
          links_InvocationAction_invocationAction_compose_argument_InputPin _,
          ops.InvocationAction_argument))

  // All parents: {CallBehaviorAction, CallAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CallBehaviorAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "argument" -> AssociationMetaPropertySequenceUpdateInfo(
          links_InvocationAction_invocationAction_compose_argument_InputPin _,
          ops.InvocationAction_argument)) :+
        ( "result" -> AssociationMetaPropertySequenceUpdateInfo(
          links_CallAction_callAction_compose_result_OutputPin _,
          ops.CallAction_result))

  // All parents: {CallEvent, MessageEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_CallEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {CallOperationAction, CallAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CallOperationAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "argument" -> AssociationMetaPropertySequenceUpdateInfo(
          links_InvocationAction_invocationAction_compose_argument_InputPin _,
          ops.InvocationAction_argument)) :+
        ( "result" -> AssociationMetaPropertySequenceUpdateInfo(
          links_CallAction_callAction_compose_result_OutputPin _,
          ops.CallAction_result)) :+
        ( "target" -> AssociationMetaPropertyOptionUpdateInfo(
          links_CallOperationAction_callOperationAction_compose_target_InputPin _,
          ops.CallOperationAction_target))

  // All parents: {CentralBufferNode, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CentralBufferNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "upperBound" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_compose_upperBound_ValueSpecification _,
          ops.ObjectNode_upperBound))

  // All parents: {ChangeEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_ChangeEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "changeExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ChangeEvent_changeEvent_compose_changeExpression_ValueSpecification _,
          ops.ChangeEvent_changeExpression))

  // All parents: {Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Class
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception))

  // All parents: {ClassifierTemplateParameter, TemplateParameter, Element}
  lazy val metaclass_composite_updater_table_ClassifierTemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "ownedDefault" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_templateParameter_compose_ownedDefault_ParameterableElement _,
          ops.TemplateParameter_ownedDefault)) :+
        ( "ownedParameteredElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_owningTemplateParameter_compose_ownedParameteredElement_ParameterableElement _,
          ops.TemplateParameter_ownedParameteredElement))

  // All parents: {Clause, Element}
  lazy val metaclass_composite_updater_table_Clause
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment))

  // All parents: {ClearAssociationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ClearAssociationAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "object" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ClearAssociationAction_clearAssociationAction_compose_object_InputPin _,
          ops.ClearAssociationAction_object))

  // All parents: {ClearStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ClearStructuralFeatureAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "object" -> AssociationMetaPropertyOptionUpdateInfo(
          links_StructuralFeatureAction_structuralFeatureAction_compose_object_InputPin _,
          ops.StructuralFeatureAction_object)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ClearStructuralFeatureAction_clearStructuralFeatureAction_compose_result_OutputPin _,
          ops.ClearStructuralFeatureAction_result))

  // All parents: {ClearVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ClearVariableAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition))

  // All parents: {Collaboration, BehavioredClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Collaboration
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior))

  // All parents: {CollaborationUse, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CollaborationUse
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "roleBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_CollaborationUse_collaborationUse_compose_roleBinding_Dependency _,
          ops.CollaborationUse_roleBinding))

  // All parents: {CombinedFragment, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CombinedFragment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering)) :+
        ( "cfragmentGate" -> AssociationMetaPropertySetUpdateInfo(
          links_CombinedFragment_combinedFragment_compose_cfragmentGate_Gate _,
          ops.CombinedFragment_cfragmentGate)) :+
        ( "operand" -> AssociationMetaPropertySequenceUpdateInfo(
          links_CombinedFragment_combinedFragment_compose_operand_InteractionOperand _,
          ops.CombinedFragment_operand))

  // All parents: {Comment, Element}
  lazy val metaclass_composite_updater_table_Comment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment))

  // All parents: {CommunicationPath, Association, Classifier, Namespace, Relationship, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_CommunicationPath
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedEnd" -> AssociationMetaPropertyIterableUpdateInfo(
          links_Association_owningAssociation_compose_ownedEnd_Property _,
          ops.Association_ownedEnd))

  // All parents: {Component, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Component
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception)) :+
        ( "packagedElement" -> AssociationMetaPropertySetUpdateInfo(
          links_Component_component_compose_packagedElement_PackageableElement _,
          ops.Component_packagedElement)) :+
        ( "realization" -> AssociationMetaPropertySetUpdateInfo(
          links_Component_abstraction_compose_realization_ComponentRealization _,
          ops.Component_realization))

  // All parents: {ComponentRealization, Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_ComponentRealization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "mapping" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Abstraction_abstraction_compose_mapping_OpaqueExpression _,
          ops.Abstraction_mapping))

  // All parents: {ConditionalNode, StructuredActivityNode, Action, ActivityGroup, ExecutableNode, Namespace, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ConditionalNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "edge" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge _,
          ops.StructuredActivityNode_edge)) :+
        ( "node" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode _,
          ops.StructuredActivityNode_node)) :+
        ( "structuredNodeInput" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin _,
          ops.StructuredActivityNode_structuredNodeInput)) :+
        ( "structuredNodeOutput" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin _,
          ops.StructuredActivityNode_structuredNodeOutput)) :+
        ( "variable" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_scope_compose_variable_Variable _,
          ops.StructuredActivityNode_variable)) :+
        ( "clause" -> AssociationMetaPropertySetUpdateInfo(
          links_ConditionalNode_conditionalNode_compose_clause_Clause _,
          ops.ConditionalNode_clause)) :+
        ( "result" -> AssociationMetaPropertySequenceUpdateInfo(
          links_ConditionalNode_conditionalNode_compose_result_OutputPin _,
          ops.ConditionalNode_result))

  // All parents: {ConnectableElementTemplateParameter, TemplateParameter, Element}
  lazy val metaclass_composite_updater_table_ConnectableElementTemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "ownedDefault" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_templateParameter_compose_ownedDefault_ParameterableElement _,
          ops.TemplateParameter_ownedDefault)) :+
        ( "ownedParameteredElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_owningTemplateParameter_compose_ownedParameteredElement_ParameterableElement _,
          ops.TemplateParameter_ownedParameteredElement))

  // All parents: {ConnectionPointReference, Vertex, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ConnectionPointReference
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {Connector, Feature, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Connector
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "end" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Connector_connector_compose_end_ConnectorEnd _,
          ops.Connector_end))

  // All parents: {ConnectorEnd, MultiplicityElement, Element}
  lazy val metaclass_composite_updater_table_ConnectorEnd
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "lowerValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
          ops.MultiplicityElement_lowerValue)) :+
        ( "upperValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
          ops.MultiplicityElement_upperValue))

  // All parents: {ConsiderIgnoreFragment, CombinedFragment, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ConsiderIgnoreFragment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering)) :+
        ( "cfragmentGate" -> AssociationMetaPropertySetUpdateInfo(
          links_CombinedFragment_combinedFragment_compose_cfragmentGate_Gate _,
          ops.CombinedFragment_cfragmentGate)) :+
        ( "operand" -> AssociationMetaPropertySequenceUpdateInfo(
          links_CombinedFragment_combinedFragment_compose_operand_InteractionOperand _,
          ops.CombinedFragment_operand))

  // All parents: {Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Constraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Constraint_owningConstraint_compose_specification_ValueSpecification _,
          ops.Constraint_specification))

  // All parents: {Continuation, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Continuation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering))

  // All parents: {ControlFlow, ActivityEdge, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ControlFlow
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "guard" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActivityEdge_activityEdge_compose_guard_ValueSpecification _,
          ops.ActivityEdge_guard)) :+
        ( "weight" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActivityEdge_activityEdge_compose_weight_ValueSpecification _,
          ops.ActivityEdge_weight))

  // All parents: {CreateLinkAction, WriteLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CreateLinkAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "endData" -> AssociationMetaPropertyIterableUpdateInfo(
          links_LinkAction_linkAction_compose_endData_LinkEndData _,
          ops.LinkAction_endData)) :+
        ( "inputValue" -> AssociationMetaPropertySetUpdateInfo(
          links_LinkAction_linkAction_compose_inputValue_InputPin _,
          ops.LinkAction_inputValue)) :+
        ( "endData" -> AssociationMetaPropertyIterableUpdateInfo(
          links_CreateLinkAction_createLinkAction_compose_endData_LinkEndCreationData _,
          ops.CreateLinkAction_endData))

  // All parents: {CreateLinkObjectAction, CreateLinkAction, WriteLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CreateLinkObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "endData" -> AssociationMetaPropertyIterableUpdateInfo(
          links_LinkAction_linkAction_compose_endData_LinkEndData _,
          ops.LinkAction_endData)) :+
        ( "inputValue" -> AssociationMetaPropertySetUpdateInfo(
          links_LinkAction_linkAction_compose_inputValue_InputPin _,
          ops.LinkAction_inputValue)) :+
        ( "endData" -> AssociationMetaPropertyIterableUpdateInfo(
          links_CreateLinkAction_createLinkAction_compose_endData_LinkEndCreationData _,
          ops.CreateLinkAction_endData)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_CreateLinkObjectAction_createLinkObjectAction_compose_result_OutputPin _,
          ops.CreateLinkObjectAction_result))

  // All parents: {CreateObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CreateObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_CreateObjectAction_createObjectAction_compose_result_OutputPin _,
          ops.CreateObjectAction_result))

  // All parents: {DataStoreNode, CentralBufferNode, ObjectNode, ActivityNode, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_DataStoreNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "upperBound" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_compose_upperBound_ValueSpecification _,
          ops.ObjectNode_upperBound))

  // All parents: {DataType, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_DataType
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_DataType_datatype_compose_ownedAttribute_Property _,
          ops.DataType_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_DataType_datatype_compose_ownedOperation_Operation _,
          ops.DataType_ownedOperation))

  // All parents: {DecisionNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_DecisionNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {Dependency, DirectedRelationship, PackageableElement, Relationship, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Dependency
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {Deployment, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Deployment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "configuration" -> AssociationMetaPropertySetUpdateInfo(
          links_Deployment_deployment_compose_configuration_DeploymentSpecification _,
          ops.Deployment_configuration))

  // All parents: {DeploymentSpecification, Artifact, Classifier, DeployedArtifact, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_DeploymentSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "manifestation" -> AssociationMetaPropertySetUpdateInfo(
          links_Artifact_artifact_compose_manifestation_Manifestation _,
          ops.Artifact_manifestation)) :+
        ( "nestedArtifact" -> AssociationMetaPropertySetUpdateInfo(
          links_Artifact_artifact_compose_nestedArtifact_Artifact _,
          ops.Artifact_nestedArtifact)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Artifact_artifact_compose_ownedAttribute_Property _,
          ops.Artifact_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Artifact_artifact_compose_ownedOperation_Operation _,
          ops.Artifact_ownedOperation))

  // All parents: {DestroyLinkAction, WriteLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_DestroyLinkAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "endData" -> AssociationMetaPropertyIterableUpdateInfo(
          links_LinkAction_linkAction_compose_endData_LinkEndData _,
          ops.LinkAction_endData)) :+
        ( "inputValue" -> AssociationMetaPropertySetUpdateInfo(
          links_LinkAction_linkAction_compose_inputValue_InputPin _,
          ops.LinkAction_inputValue)) :+
        ( "endData" -> AssociationMetaPropertyIterableUpdateInfo(
          links_DestroyLinkAction_destroyLinkAction_compose_endData_LinkEndDestructionData _,
          ops.DestroyLinkAction_endData))

  // All parents: {DestroyObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_DestroyObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "target" -> AssociationMetaPropertyOptionUpdateInfo(
          links_DestroyObjectAction_destroyObjectAction_compose_target_InputPin _,
          ops.DestroyObjectAction_target))

  // All parents: {DestructionOccurrenceSpecification, MessageOccurrenceSpecification, MessageEnd, OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_DestructionOccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering))

  // All parents: {Device, Node, Class, BehavioredClassifier, DeploymentTarget, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Device
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "deployment" -> AssociationMetaPropertySetUpdateInfo(
          links_DeploymentTarget_location_compose_deployment_Deployment _,
          ops.DeploymentTarget_deployment)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception)) :+
        ( "nestedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_Node_node_compose_nestedNode_Node _,
          ops.Node_nestedNode))

  // All parents: {Duration, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Duration
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "expr" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Duration_duration_compose_expr_ValueSpecification _,
          ops.Duration_expr))

  // All parents: {DurationConstraint, IntervalConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_DurationConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Constraint_owningConstraint_compose_specification_ValueSpecification _,
          ops.Constraint_specification)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_IntervalConstraint_intervalConstraint_compose_specification_Interval _,
          ops.IntervalConstraint_specification)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_DurationConstraint_durationConstraint_compose_specification_DurationInterval _,
          ops.DurationConstraint_specification))

  // All parents: {DurationInterval, Interval, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_DurationInterval
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {DurationObservation, Observation, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_DurationObservation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {ElementImport, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_ElementImport
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment))

  // All parents: {Enumeration, DataType, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Enumeration
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_DataType_datatype_compose_ownedAttribute_Property _,
          ops.DataType_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_DataType_datatype_compose_ownedOperation_Operation _,
          ops.DataType_ownedOperation)) :+
        ( "ownedLiteral" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Enumeration_enumeration_compose_ownedLiteral_EnumerationLiteral _,
          ops.Enumeration_ownedLiteral))

  // All parents: {EnumerationLiteral, InstanceSpecification, DeployedArtifact, DeploymentTarget, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_EnumerationLiteral
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "deployment" -> AssociationMetaPropertySetUpdateInfo(
          links_DeploymentTarget_location_compose_deployment_Deployment _,
          ops.DeploymentTarget_deployment)) :+
        ( "slot" -> AssociationMetaPropertySetUpdateInfo(
          links_InstanceSpecification_owningInstance_compose_slot_Slot _,
          ops.InstanceSpecification_slot)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InstanceSpecification_owningInstanceSpec_compose_specification_ValueSpecification _,
          ops.InstanceSpecification_specification))

  // All parents: {ExceptionHandler, Element}
  lazy val metaclass_composite_updater_table_ExceptionHandler
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment))

  // All parents: {ExecutionEnvironment, Node, Class, DeploymentTarget, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_ExecutionEnvironment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "deployment" -> AssociationMetaPropertySetUpdateInfo(
          links_DeploymentTarget_location_compose_deployment_Deployment _,
          ops.DeploymentTarget_deployment)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception)) :+
        ( "nestedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_Node_node_compose_nestedNode_Node _,
          ops.Node_nestedNode))

  // All parents: {ExecutionOccurrenceSpecification, OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ExecutionOccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering))

  // All parents: {ExpansionNode, ObjectNode, ActivityNode, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ExpansionNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "upperBound" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_compose_upperBound_ValueSpecification _,
          ops.ObjectNode_upperBound))

  // All parents: {ExpansionRegion, StructuredActivityNode, Action, ExecutableNode, ActivityGroup, ActivityNode, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ExpansionRegion
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "edge" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge _,
          ops.StructuredActivityNode_edge)) :+
        ( "node" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode _,
          ops.StructuredActivityNode_node)) :+
        ( "structuredNodeInput" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin _,
          ops.StructuredActivityNode_structuredNodeInput)) :+
        ( "structuredNodeOutput" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin _,
          ops.StructuredActivityNode_structuredNodeOutput)) :+
        ( "variable" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_scope_compose_variable_Variable _,
          ops.StructuredActivityNode_variable))

  // All parents: {Expression, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Expression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "operand" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Expression_expression_compose_operand_ValueSpecification _,
          ops.Expression_operand))

  // All parents: {Extend, DirectedRelationship, Relationship, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Extend
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "condition" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Extend_extend_compose_condition_Constraint _,
          ops.Extend_condition))

  // All parents: {Extension, Association, Classifier, Relationship, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Extension
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedEnd" -> AssociationMetaPropertyIterableUpdateInfo(
          links_Association_owningAssociation_compose_ownedEnd_Property _,
          ops.Association_ownedEnd)) :+
        ( "ownedEnd" -> AssociationMetaPropertyIterableUpdateInfo(
          links_Extension_extension_compose_ownedEnd_ExtensionEnd _,
          ops.Extension_ownedEnd))

  // All parents: {ExtensionEnd, Property, ConnectableElement, DeploymentTarget, ParameterableElement, StructuralFeature, Feature, MultiplicityElement, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ExtensionEnd
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "lowerValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
          ops.MultiplicityElement_lowerValue)) :+
        ( "upperValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
          ops.MultiplicityElement_upperValue)) :+
        ( "deployment" -> AssociationMetaPropertySetUpdateInfo(
          links_DeploymentTarget_location_compose_deployment_Deployment _,
          ops.DeploymentTarget_deployment)) :+
        ( "defaultValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Property_owningProperty_compose_defaultValue_ValueSpecification _,
          ops.Property_defaultValue)) :+
        ( "qualifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Property_associationEnd_compose_qualifier_Property _,
          ops.Property_qualifier))

  // All parents: {ExtensionPoint, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ExtensionPoint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {FinalState, State, Namespace, RedefinableElement, Vertex, NamedElement, Element}
  lazy val metaclass_composite_updater_table_FinalState
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "connection" -> AssociationMetaPropertySetUpdateInfo(
          links_State_state_compose_connection_ConnectionPointReference _,
          ops.State_connection)) :+
        ( "connectionPoint" -> AssociationMetaPropertySetUpdateInfo(
          links_State_state_compose_connectionPoint_Pseudostate _,
          ops.State_connectionPoint)) :+
        ( "deferrableTrigger" -> AssociationMetaPropertySetUpdateInfo(
          links_State_state_compose_deferrableTrigger_Trigger _,
          ops.State_deferrableTrigger)) :+
        ( "doActivity" -> AssociationMetaPropertyOptionUpdateInfo(
          links_State_state_compose_doActivity_Behavior _,
          ops.State_doActivity)) :+
        ( "entry" -> AssociationMetaPropertyOptionUpdateInfo(
          links_State_state_compose_entry_Behavior _,
          ops.State_entry)) :+
        ( "exit" -> AssociationMetaPropertyOptionUpdateInfo(
          links_State_state_compose_exit_Behavior _,
          ops.State_exit)) :+
        ( "region" -> AssociationMetaPropertySetUpdateInfo(
          links_State_state_compose_region_Region _,
          ops.State_region))

  // All parents: {FlowFinalNode, FinalNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_FlowFinalNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {ForkNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ForkNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {FunctionBehavior, OpaqueBehavior, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_FunctionBehavior
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception)) :+
        ( "ownedParameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Behavior_behavior_compose_ownedParameter_Parameter _,
          ops.Behavior_ownedParameter)) :+
        ( "ownedParameterSet" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_ownedParameterSet_ParameterSet _,
          ops.Behavior_ownedParameterSet))

  // All parents: {Gate, MessageEnd, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Gate
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {GeneralOrdering, NamedElement, Element}
  lazy val metaclass_composite_updater_table_GeneralOrdering
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {Generalization, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_Generalization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment))

  // All parents: {GeneralizationSet, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_GeneralizationSet
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {Image, Element}
  lazy val metaclass_composite_updater_table_Image
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment))

  // All parents: {Include, DirectedRelationship, NamedElement, Relationship, Element}
  lazy val metaclass_composite_updater_table_Include
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {InformationFlow, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_InformationFlow
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {InformationItem, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_InformationItem
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution))

  // All parents: {InitialNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_InitialNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {InputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_InputPin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "upperBound" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_compose_upperBound_ValueSpecification _,
          ops.ObjectNode_upperBound)) :+
        ( "lowerValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
          ops.MultiplicityElement_lowerValue)) :+
        ( "upperValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
          ops.MultiplicityElement_upperValue))

  // All parents: {InstanceSpecification, DeployedArtifact, DeploymentTarget, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_InstanceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "deployment" -> AssociationMetaPropertySetUpdateInfo(
          links_DeploymentTarget_location_compose_deployment_Deployment _,
          ops.DeploymentTarget_deployment)) :+
        ( "slot" -> AssociationMetaPropertySetUpdateInfo(
          links_InstanceSpecification_owningInstance_compose_slot_Slot _,
          ops.InstanceSpecification_slot)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InstanceSpecification_owningInstanceSpec_compose_specification_ValueSpecification _,
          ops.InstanceSpecification_specification))

  // All parents: {InstanceValue, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_InstanceValue
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {Interaction, Behavior, InteractionFragment, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Interaction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering)) :+
        ( "ownedParameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Behavior_behavior_compose_ownedParameter_Parameter _,
          ops.Behavior_ownedParameter)) :+
        ( "ownedParameterSet" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_ownedParameterSet_ParameterSet _,
          ops.Behavior_ownedParameterSet)) :+
        ( "action" -> AssociationMetaPropertySetUpdateInfo(
          links_Interaction_interaction_compose_action_Action _,
          ops.Interaction_action)) :+
        ( "formalGate" -> AssociationMetaPropertySetUpdateInfo(
          links_Interaction_interaction_compose_formalGate_Gate _,
          ops.Interaction_formalGate)) :+
        ( "fragment" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Interaction_enclosingInteraction_compose_fragment_InteractionFragment _,
          ops.Interaction_fragment)) :+
        ( "lifeline" -> AssociationMetaPropertySetUpdateInfo(
          links_Interaction_interaction_compose_lifeline_Lifeline _,
          ops.Interaction_lifeline)) :+
        ( "message" -> AssociationMetaPropertySetUpdateInfo(
          links_Interaction_interaction_compose_message_Message _,
          ops.Interaction_message))

  // All parents: {InteractionConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_InteractionConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Constraint_owningConstraint_compose_specification_ValueSpecification _,
          ops.Constraint_specification)) :+
        ( "maxint" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InteractionConstraint_interactionConstraint_compose_maxint_ValueSpecification _,
          ops.InteractionConstraint_maxint)) :+
        ( "minint" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InteractionConstraint_interactionConstraint_compose_minint_ValueSpecification _,
          ops.InteractionConstraint_minint))

  // All parents: {InteractionOperand, InteractionFragment, Namespace, NamedElement, Element}
  lazy val metaclass_composite_updater_table_InteractionOperand
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering)) :+
        ( "fragment" -> AssociationMetaPropertySequenceUpdateInfo(
          links_InteractionOperand_enclosingOperand_compose_fragment_InteractionFragment _,
          ops.InteractionOperand_fragment)) :+
        ( "guard" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InteractionOperand_interactionOperand_compose_guard_InteractionConstraint _,
          ops.InteractionOperand_guard))

  // All parents: {InteractionUse, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_InteractionUse
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering)) :+
        ( "actualGate" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionUse_interactionUse_compose_actualGate_Gate _,
          ops.InteractionUse_actualGate)) :+
        ( "argument" -> AssociationMetaPropertySequenceUpdateInfo(
          links_InteractionUse_interactionUse_compose_argument_ValueSpecification _,
          ops.InteractionUse_argument)) :+
        ( "returnValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InteractionUse_interactionUse_compose_returnValue_ValueSpecification _,
          ops.InteractionUse_returnValue))

  // All parents: {Interface, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Interface
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Interface_interface_compose_nestedClassifier_Classifier _,
          ops.Interface_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Interface_interface_compose_ownedAttribute_Property _,
          ops.Interface_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Interface_interface_compose_ownedOperation_Operation _,
          ops.Interface_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Interface_interface_compose_ownedReception_Reception _,
          ops.Interface_ownedReception)) :+
        ( "protocol" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Interface_interface_compose_protocol_ProtocolStateMachine _,
          ops.Interface_protocol))

  // All parents: {InterfaceRealization, Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_InterfaceRealization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "mapping" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Abstraction_abstraction_compose_mapping_OpaqueExpression _,
          ops.Abstraction_mapping))

  // All parents: {InterruptibleActivityRegion, ActivityGroup, NamedElement, Element}
  lazy val metaclass_composite_updater_table_InterruptibleActivityRegion
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {Interval, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Interval
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {IntervalConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_IntervalConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Constraint_owningConstraint_compose_specification_ValueSpecification _,
          ops.Constraint_specification)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_IntervalConstraint_intervalConstraint_compose_specification_Interval _,
          ops.IntervalConstraint_specification))

  // All parents: {JoinNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_JoinNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "joinSpec" -> AssociationMetaPropertyOptionUpdateInfo(
          links_JoinNode_joinNode_compose_joinSpec_ValueSpecification _,
          ops.JoinNode_joinSpec))

  // All parents: {Lifeline, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Lifeline
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "selector" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Lifeline_lifeline_compose_selector_ValueSpecification _,
          ops.Lifeline_selector))

  // All parents: {LinkEndCreationData, LinkEndData, Element}
  lazy val metaclass_composite_updater_table_LinkEndCreationData
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "qualifier" -> AssociationMetaPropertySetUpdateInfo(
          links_LinkEndData_linkEndData_compose_qualifier_QualifierValue _,
          ops.LinkEndData_qualifier))

  // All parents: {LinkEndData, Element}
  lazy val metaclass_composite_updater_table_LinkEndData
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "qualifier" -> AssociationMetaPropertySetUpdateInfo(
          links_LinkEndData_linkEndData_compose_qualifier_QualifierValue _,
          ops.LinkEndData_qualifier))

  // All parents: {LinkEndDestructionData, LinkEndData, Element}
  lazy val metaclass_composite_updater_table_LinkEndDestructionData
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "qualifier" -> AssociationMetaPropertySetUpdateInfo(
          links_LinkEndData_linkEndData_compose_qualifier_QualifierValue _,
          ops.LinkEndData_qualifier))

  // All parents: {LiteralBoolean, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_LiteralBoolean
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {LiteralInteger, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_LiteralInteger
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {LiteralNull, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_LiteralNull
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {LiteralReal, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_LiteralReal
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {LiteralString, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_LiteralString
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {LiteralUnlimitedNatural, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_LiteralUnlimitedNatural
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {LoopNode, StructuredActivityNode, Action, ActivityGroup, ExecutableNode, Namespace, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_LoopNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "edge" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge _,
          ops.StructuredActivityNode_edge)) :+
        ( "node" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode _,
          ops.StructuredActivityNode_node)) :+
        ( "structuredNodeInput" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin _,
          ops.StructuredActivityNode_structuredNodeInput)) :+
        ( "structuredNodeOutput" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin _,
          ops.StructuredActivityNode_structuredNodeOutput)) :+
        ( "variable" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_scope_compose_variable_Variable _,
          ops.StructuredActivityNode_variable)) :+
        ( "loopVariable" -> AssociationMetaPropertySequenceUpdateInfo(
          links_LoopNode_loopNode_compose_loopVariable_OutputPin _,
          ops.LoopNode_loopVariable)) :+
        ( "loopVariableInput" -> AssociationMetaPropertySequenceUpdateInfo(
          links_LoopNode_loopNode_compose_loopVariableInput_InputPin _,
          ops.LoopNode_loopVariableInput)) :+
        ( "result" -> AssociationMetaPropertySequenceUpdateInfo(
          links_LoopNode_loopNode_compose_result_OutputPin _,
          ops.LoopNode_result))

  // All parents: {Manifestation, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Manifestation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "mapping" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Abstraction_abstraction_compose_mapping_OpaqueExpression _,
          ops.Abstraction_mapping))

  // All parents: {MergeNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_MergeNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {Message, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Message
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "argument" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Message_message_compose_argument_ValueSpecification _,
          ops.Message_argument))

  // All parents: {MessageOccurrenceSpecification, MessageEnd, OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_MessageOccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering))

  // All parents: {Model, Package, Namespace, PackageableElement, TemplateableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Model
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "packageMerge" -> AssociationMetaPropertySetUpdateInfo(
          links_Package_receivingPackage_compose_packageMerge_PackageMerge _,
          ops.Package_packageMerge)) :+
        ( "packagedElement" -> AssociationMetaPropertySetUpdateInfo(
          links_Package_owningPackage_compose_packagedElement_PackageableElement _,
          ops.Package_packagedElement)) :+
        ( "profileApplication" -> AssociationMetaPropertySetUpdateInfo(
          links_Package_applyingPackage_compose_profileApplication_ProfileApplication _,
          ops.Package_profileApplication))

  // All parents: {Node, Class, DeploymentTarget, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Node
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "deployment" -> AssociationMetaPropertySetUpdateInfo(
          links_DeploymentTarget_location_compose_deployment_Deployment _,
          ops.DeploymentTarget_deployment)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception)) :+
        ( "nestedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_Node_node_compose_nestedNode_Node _,
          ops.Node_nestedNode))

  // All parents: {ObjectFlow, ActivityEdge, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ObjectFlow
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "guard" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActivityEdge_activityEdge_compose_guard_ValueSpecification _,
          ops.ActivityEdge_guard)) :+
        ( "weight" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActivityEdge_activityEdge_compose_weight_ValueSpecification _,
          ops.ActivityEdge_weight))

  // All parents: {OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_OccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering))

  // All parents: {OpaqueAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_OpaqueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "inputValue" -> AssociationMetaPropertySetUpdateInfo(
          links_OpaqueAction_opaqueAction_compose_inputValue_InputPin _,
          ops.OpaqueAction_inputValue)) :+
        ( "outputValue" -> AssociationMetaPropertySetUpdateInfo(
          links_OpaqueAction_opaqueAction_compose_outputValue_OutputPin _,
          ops.OpaqueAction_outputValue))

  // All parents: {OpaqueBehavior, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_OpaqueBehavior
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception)) :+
        ( "ownedParameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Behavior_behavior_compose_ownedParameter_Parameter _,
          ops.Behavior_ownedParameter)) :+
        ( "ownedParameterSet" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_ownedParameterSet_ParameterSet _,
          ops.Behavior_ownedParameterSet))

  // All parents: {OpaqueExpression, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_OpaqueExpression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {Operation, BehavioralFeature, Feature, ParameterableElement, RedefinableElement, Namespace, TemplateableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Operation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "ownedParameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_BehavioralFeature_ownerFormalParam_compose_ownedParameter_Parameter _,
          ops.BehavioralFeature_ownedParameter)) :+
        ( "ownedParameterSet" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioralFeature_behavioralFeature_compose_ownedParameterSet_ParameterSet _,
          ops.BehavioralFeature_ownedParameterSet)) :+
        ( "ownedParameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Operation_operation_compose_ownedParameter_Parameter _,
          ops.Operation_ownedParameter))

  // All parents: {OperationTemplateParameter, TemplateParameter, Element}
  lazy val metaclass_composite_updater_table_OperationTemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "ownedDefault" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_templateParameter_compose_ownedDefault_ParameterableElement _,
          ops.TemplateParameter_ownedDefault)) :+
        ( "ownedParameteredElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_owningTemplateParameter_compose_ownedParameteredElement_ParameterableElement _,
          ops.TemplateParameter_ownedParameteredElement))

  // All parents: {OutputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_OutputPin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "upperBound" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_compose_upperBound_ValueSpecification _,
          ops.ObjectNode_upperBound)) :+
        ( "lowerValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
          ops.MultiplicityElement_lowerValue)) :+
        ( "upperValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
          ops.MultiplicityElement_upperValue))

  // All parents: {Package, Namespace, PackageableElement, NamedElement, TemplateableElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Package
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "packageMerge" -> AssociationMetaPropertySetUpdateInfo(
          links_Package_receivingPackage_compose_packageMerge_PackageMerge _,
          ops.Package_packageMerge)) :+
        ( "packagedElement" -> AssociationMetaPropertySetUpdateInfo(
          links_Package_owningPackage_compose_packagedElement_PackageableElement _,
          ops.Package_packagedElement)) :+
        ( "profileApplication" -> AssociationMetaPropertySetUpdateInfo(
          links_Package_applyingPackage_compose_profileApplication_ProfileApplication _,
          ops.Package_profileApplication))

  // All parents: {PackageImport, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_PackageImport
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment))

  // All parents: {PackageMerge, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_PackageMerge
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment))

  // All parents: {Parameter, ConnectableElement, ParameterableElement, MultiplicityElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Parameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "lowerValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
          ops.MultiplicityElement_lowerValue)) :+
        ( "upperValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
          ops.MultiplicityElement_upperValue)) :+
        ( "defaultValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Parameter_owningParameter_compose_defaultValue_ValueSpecification _,
          ops.Parameter_defaultValue))

  // All parents: {ParameterSet, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ParameterSet
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "condition" -> AssociationMetaPropertySetUpdateInfo(
          links_ParameterSet_parameterSet_compose_condition_Constraint _,
          ops.ParameterSet_condition))

  // All parents: {PartDecomposition, InteractionUse, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_PartDecomposition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering)) :+
        ( "actualGate" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionUse_interactionUse_compose_actualGate_Gate _,
          ops.InteractionUse_actualGate)) :+
        ( "argument" -> AssociationMetaPropertySequenceUpdateInfo(
          links_InteractionUse_interactionUse_compose_argument_ValueSpecification _,
          ops.InteractionUse_argument)) :+
        ( "returnValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InteractionUse_interactionUse_compose_returnValue_ValueSpecification _,
          ops.InteractionUse_returnValue))

  // All parents: {Port, Property, ConnectableElement, DeploymentTarget, ParameterableElement, StructuralFeature, Feature, RedefinableElement, MultiplicityElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Port
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "lowerValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
          ops.MultiplicityElement_lowerValue)) :+
        ( "upperValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
          ops.MultiplicityElement_upperValue)) :+
        ( "deployment" -> AssociationMetaPropertySetUpdateInfo(
          links_DeploymentTarget_location_compose_deployment_Deployment _,
          ops.DeploymentTarget_deployment)) :+
        ( "defaultValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Property_owningProperty_compose_defaultValue_ValueSpecification _,
          ops.Property_defaultValue)) :+
        ( "qualifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Property_associationEnd_compose_qualifier_Property _,
          ops.Property_qualifier))

  // All parents: {PrimitiveType, DataType, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_PrimitiveType
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_DataType_datatype_compose_ownedAttribute_Property _,
          ops.DataType_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_DataType_datatype_compose_ownedOperation_Operation _,
          ops.DataType_ownedOperation))

  // All parents: {Profile, Package, Namespace, PackageableElement, NamedElement, TemplateableElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Profile
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "packageMerge" -> AssociationMetaPropertySetUpdateInfo(
          links_Package_receivingPackage_compose_packageMerge_PackageMerge _,
          ops.Package_packageMerge)) :+
        ( "packagedElement" -> AssociationMetaPropertySetUpdateInfo(
          links_Package_owningPackage_compose_packagedElement_PackageableElement _,
          ops.Package_packagedElement)) :+
        ( "profileApplication" -> AssociationMetaPropertySetUpdateInfo(
          links_Package_applyingPackage_compose_profileApplication_ProfileApplication _,
          ops.Package_profileApplication))

  // All parents: {ProfileApplication, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_ProfileApplication
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment))

  // All parents: {Property, ConnectableElement, ParameterableElement, DeploymentTarget, StructuralFeature, Feature, MultiplicityElement, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Property
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "lowerValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
          ops.MultiplicityElement_lowerValue)) :+
        ( "upperValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
          ops.MultiplicityElement_upperValue)) :+
        ( "deployment" -> AssociationMetaPropertySetUpdateInfo(
          links_DeploymentTarget_location_compose_deployment_Deployment _,
          ops.DeploymentTarget_deployment)) :+
        ( "defaultValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Property_owningProperty_compose_defaultValue_ValueSpecification _,
          ops.Property_defaultValue)) :+
        ( "qualifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Property_associationEnd_compose_qualifier_Property _,
          ops.Property_qualifier))

  // All parents: {ProtocolConformance, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_ProtocolConformance
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment))

  // All parents: {ProtocolStateMachine, StateMachine, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_ProtocolStateMachine
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception)) :+
        ( "ownedParameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Behavior_behavior_compose_ownedParameter_Parameter _,
          ops.Behavior_ownedParameter)) :+
        ( "ownedParameterSet" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_ownedParameterSet_ParameterSet _,
          ops.Behavior_ownedParameterSet)) :+
        ( "connectionPoint" -> AssociationMetaPropertySetUpdateInfo(
          links_StateMachine_stateMachine_compose_connectionPoint_Pseudostate _,
          ops.StateMachine_connectionPoint)) :+
        ( "region" -> AssociationMetaPropertySetUpdateInfo(
          links_StateMachine_stateMachine_compose_region_Region _,
          ops.StateMachine_region)) :+
        ( "conformance" -> AssociationMetaPropertySetUpdateInfo(
          links_ProtocolStateMachine_specificMachine_compose_conformance_ProtocolConformance _,
          ops.ProtocolStateMachine_conformance))

  // All parents: {ProtocolTransition, Transition, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ProtocolTransition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "effect" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Transition_transition_compose_effect_Behavior _,
          ops.Transition_effect)) :+
        ( "trigger" -> AssociationMetaPropertySetUpdateInfo(
          links_Transition_transition_compose_trigger_Trigger _,
          ops.Transition_trigger)) :+
        ( "preCondition" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ProtocolTransition_protocolTransition_compose_preCondition_Constraint _,
          ops.ProtocolTransition_preCondition))

  // All parents: {Pseudostate, Vertex, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Pseudostate
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {QualifierValue, Element}
  lazy val metaclass_composite_updater_table_QualifierValue
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment))

  // All parents: {RaiseExceptionAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_RaiseExceptionAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "exception" -> AssociationMetaPropertyOptionUpdateInfo(
          links_RaiseExceptionAction_raiseExceptionAction_compose_exception_InputPin _,
          ops.RaiseExceptionAction_exception))

  // All parents: {ReadExtentAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadExtentAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadExtentAction_readExtentAction_compose_result_OutputPin _,
          ops.ReadExtentAction_result))

  // All parents: {ReadIsClassifiedObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadIsClassifiedObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "object" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_object_InputPin _,
          ops.ReadIsClassifiedObjectAction_object)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_result_OutputPin _,
          ops.ReadIsClassifiedObjectAction_result))

  // All parents: {ReadLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadLinkAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "endData" -> AssociationMetaPropertyIterableUpdateInfo(
          links_LinkAction_linkAction_compose_endData_LinkEndData _,
          ops.LinkAction_endData)) :+
        ( "inputValue" -> AssociationMetaPropertySetUpdateInfo(
          links_LinkAction_linkAction_compose_inputValue_InputPin _,
          ops.LinkAction_inputValue)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadLinkAction_readLinkAction_compose_result_OutputPin _,
          ops.ReadLinkAction_result))

  // All parents: {ReadLinkObjectEndAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadLinkObjectEndAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "object" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_object_InputPin _,
          ops.ReadLinkObjectEndAction_object)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_result_OutputPin _,
          ops.ReadLinkObjectEndAction_result))

  // All parents: {ReadLinkObjectEndQualifierAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadLinkObjectEndQualifierAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "object" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_object_InputPin _,
          ops.ReadLinkObjectEndQualifierAction_object)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_result_OutputPin _,
          ops.ReadLinkObjectEndQualifierAction_result))

  // All parents: {ReadSelfAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadSelfAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadSelfAction_readSelfAction_compose_result_OutputPin _,
          ops.ReadSelfAction_result))

  // All parents: {ReadStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadStructuralFeatureAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "object" -> AssociationMetaPropertyOptionUpdateInfo(
          links_StructuralFeatureAction_structuralFeatureAction_compose_object_InputPin _,
          ops.StructuralFeatureAction_object)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadStructuralFeatureAction_readStructuralFeatureAction_compose_result_OutputPin _,
          ops.ReadStructuralFeatureAction_result))

  // All parents: {ReadVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadVariableAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadVariableAction_readVariableAction_compose_result_OutputPin _,
          ops.ReadVariableAction_result))

  // All parents: {Realization, Abstraction, Dependency, DirectedRelationship, PackageableElement, Relationship, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Realization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "mapping" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Abstraction_abstraction_compose_mapping_OpaqueExpression _,
          ops.Abstraction_mapping))

  // All parents: {Reception, BehavioralFeature, Feature, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Reception
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "ownedParameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_BehavioralFeature_ownerFormalParam_compose_ownedParameter_Parameter _,
          ops.BehavioralFeature_ownedParameter)) :+
        ( "ownedParameterSet" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioralFeature_behavioralFeature_compose_ownedParameterSet_ParameterSet _,
          ops.BehavioralFeature_ownedParameterSet))

  // All parents: {ReclassifyObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReclassifyObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "object" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReclassifyObjectAction_reclassifyObjectAction_compose_object_InputPin _,
          ops.ReclassifyObjectAction_object))

  // All parents: {RedefinableTemplateSignature, RedefinableElement, TemplateSignature, NamedElement, Element}
  lazy val metaclass_composite_updater_table_RedefinableTemplateSignature
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedParameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_TemplateSignature_signature_compose_ownedParameter_TemplateParameter _,
          ops.TemplateSignature_ownedParameter))

  // All parents: {ReduceAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReduceAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "collection" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReduceAction_reduceAction_compose_collection_InputPin _,
          ops.ReduceAction_collection)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReduceAction_reduceAction_compose_result_OutputPin _,
          ops.ReduceAction_result))

  // All parents: {Region, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Region
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "subvertex" -> AssociationMetaPropertySetUpdateInfo(
          links_Region_container_compose_subvertex_Vertex _,
          ops.Region_subvertex)) :+
        ( "transition" -> AssociationMetaPropertySetUpdateInfo(
          links_Region_container_compose_transition_Transition _,
          ops.Region_transition))

  // All parents: {RemoveStructuralFeatureValueAction, WriteStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_RemoveStructuralFeatureValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "object" -> AssociationMetaPropertyOptionUpdateInfo(
          links_StructuralFeatureAction_structuralFeatureAction_compose_object_InputPin _,
          ops.StructuralFeatureAction_object)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_result_OutputPin _,
          ops.WriteStructuralFeatureAction_result)) :+
        ( "value" -> AssociationMetaPropertyOptionUpdateInfo(
          links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_value_InputPin _,
          ops.WriteStructuralFeatureAction_value)) :+
        ( "removeAt" -> AssociationMetaPropertyOptionUpdateInfo(
          links_RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_compose_removeAt_InputPin _,
          ops.RemoveStructuralFeatureValueAction_removeAt))

  // All parents: {RemoveVariableValueAction, WriteVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_RemoveVariableValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "value" -> AssociationMetaPropertyOptionUpdateInfo(
          links_WriteVariableAction_writeVariableAction_compose_value_InputPin _,
          ops.WriteVariableAction_value)) :+
        ( "removeAt" -> AssociationMetaPropertyOptionUpdateInfo(
          links_RemoveVariableValueAction_removeVariableValueAction_compose_removeAt_InputPin _,
          ops.RemoveVariableValueAction_removeAt))

  // All parents: {ReplyAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReplyAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "replyValue" -> AssociationMetaPropertySequenceUpdateInfo(
          links_ReplyAction_replyAction_compose_replyValue_InputPin _,
          ops.ReplyAction_replyValue)) :+
        ( "returnInformation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReplyAction_replyAction_compose_returnInformation_InputPin _,
          ops.ReplyAction_returnInformation))

  // All parents: {SendObjectAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_SendObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "argument" -> AssociationMetaPropertySequenceUpdateInfo(
          links_InvocationAction_invocationAction_compose_argument_InputPin _,
          ops.InvocationAction_argument)) :+
        ( "request" -> AssociationMetaPropertyOptionUpdateInfo(
          links_SendObjectAction_sendObjectAction_compose_request_InputPin _,
          ops.SendObjectAction_request)) :+
        ( "target" -> AssociationMetaPropertyOptionUpdateInfo(
          links_SendObjectAction_sendObjectAction_compose_target_InputPin _,
          ops.SendObjectAction_target))

  // All parents: {SendSignalAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_SendSignalAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "argument" -> AssociationMetaPropertySequenceUpdateInfo(
          links_InvocationAction_invocationAction_compose_argument_InputPin _,
          ops.InvocationAction_argument)) :+
        ( "target" -> AssociationMetaPropertyOptionUpdateInfo(
          links_SendSignalAction_sendSignalAction_compose_target_InputPin _,
          ops.SendSignalAction_target))

  // All parents: {SequenceNode, StructuredActivityNode, Action, ActivityGroup, ExecutableNode, Namespace, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_SequenceNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "edge" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge _,
          ops.StructuredActivityNode_edge)) :+
        ( "node" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode _,
          ops.StructuredActivityNode_node)) :+
        ( "structuredNodeInput" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin _,
          ops.StructuredActivityNode_structuredNodeInput)) :+
        ( "structuredNodeOutput" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin _,
          ops.StructuredActivityNode_structuredNodeOutput)) :+
        ( "variable" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_scope_compose_variable_Variable _,
          ops.StructuredActivityNode_variable)) :+
        ( "executableNode" -> AssociationMetaPropertySequenceUpdateInfo(
          links_SequenceNode_sequenceNode_compose_executableNode_ExecutableNode _,
          ops.SequenceNode_executableNode))

  // All parents: {Signal, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Signal
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Signal_owningSignal_compose_ownedAttribute_Property _,
          ops.Signal_ownedAttribute))

  // All parents: {SignalEvent, MessageEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_SignalEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {Slot, Element}
  lazy val metaclass_composite_updater_table_Slot
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "value" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Slot_owningSlot_compose_value_ValueSpecification _,
          ops.Slot_value))

  // All parents: {StartClassifierBehaviorAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_StartClassifierBehaviorAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "object" -> AssociationMetaPropertyOptionUpdateInfo(
          links_StartClassifierBehaviorAction_startClassifierBehaviorAction_compose_object_InputPin _,
          ops.StartClassifierBehaviorAction_object))

  // All parents: {StartObjectBehaviorAction, CallAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_StartObjectBehaviorAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "argument" -> AssociationMetaPropertySequenceUpdateInfo(
          links_InvocationAction_invocationAction_compose_argument_InputPin _,
          ops.InvocationAction_argument)) :+
        ( "result" -> AssociationMetaPropertySequenceUpdateInfo(
          links_CallAction_callAction_compose_result_OutputPin _,
          ops.CallAction_result)) :+
        ( "object" -> AssociationMetaPropertyOptionUpdateInfo(
          links_StartObjectBehaviorAction_startObjectBehaviorAction_compose_object_InputPin _,
          ops.StartObjectBehaviorAction_object))

  // All parents: {State, Namespace, RedefinableElement, Vertex, NamedElement, Element}
  lazy val metaclass_composite_updater_table_State
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "connection" -> AssociationMetaPropertySetUpdateInfo(
          links_State_state_compose_connection_ConnectionPointReference _,
          ops.State_connection)) :+
        ( "connectionPoint" -> AssociationMetaPropertySetUpdateInfo(
          links_State_state_compose_connectionPoint_Pseudostate _,
          ops.State_connectionPoint)) :+
        ( "deferrableTrigger" -> AssociationMetaPropertySetUpdateInfo(
          links_State_state_compose_deferrableTrigger_Trigger _,
          ops.State_deferrableTrigger)) :+
        ( "doActivity" -> AssociationMetaPropertyOptionUpdateInfo(
          links_State_state_compose_doActivity_Behavior _,
          ops.State_doActivity)) :+
        ( "entry" -> AssociationMetaPropertyOptionUpdateInfo(
          links_State_state_compose_entry_Behavior _,
          ops.State_entry)) :+
        ( "exit" -> AssociationMetaPropertyOptionUpdateInfo(
          links_State_state_compose_exit_Behavior _,
          ops.State_exit)) :+
        ( "region" -> AssociationMetaPropertySetUpdateInfo(
          links_State_state_compose_region_Region _,
          ops.State_region))

  // All parents: {StateInvariant, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_StateInvariant
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "generalOrdering" -> AssociationMetaPropertySetUpdateInfo(
          links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
          ops.InteractionFragment_generalOrdering)) :+
        ( "invariant" -> AssociationMetaPropertyOptionUpdateInfo(
          links_StateInvariant_stateInvariant_compose_invariant_Constraint _,
          ops.StateInvariant_invariant))

  // All parents: {StateMachine, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_StateMachine
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception)) :+
        ( "ownedParameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Behavior_behavior_compose_ownedParameter_Parameter _,
          ops.Behavior_ownedParameter)) :+
        ( "ownedParameterSet" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_ownedParameterSet_ParameterSet _,
          ops.Behavior_ownedParameterSet)) :+
        ( "connectionPoint" -> AssociationMetaPropertySetUpdateInfo(
          links_StateMachine_stateMachine_compose_connectionPoint_Pseudostate _,
          ops.StateMachine_connectionPoint)) :+
        ( "region" -> AssociationMetaPropertySetUpdateInfo(
          links_StateMachine_stateMachine_compose_region_Region _,
          ops.StateMachine_region))

  // All parents: {Stereotype, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Stereotype
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
          ops.StructuredClassifier_ownedAttribute)) :+
        ( "ownedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
          ops.StructuredClassifier_ownedConnector)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "nestedClassifier" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_nestingClass_compose_nestedClassifier_Classifier _,
          ops.Class_nestedClassifier)) :+
        ( "ownedAttribute" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedAttribute_Property _,
          ops.Class_ownedAttribute)) :+
        ( "ownedOperation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Class_class_compose_ownedOperation_Operation _,
          ops.Class_ownedOperation)) :+
        ( "ownedReception" -> AssociationMetaPropertySetUpdateInfo(
          links_Class_class_compose_ownedReception_Reception _,
          ops.Class_ownedReception)) :+
        ( "icon" -> AssociationMetaPropertySetUpdateInfo(
          links_Stereotype_stereotype_compose_icon_Image _,
          ops.Stereotype_icon))

  // All parents: {StringExpression, Expression, TemplateableElement, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_StringExpression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "operand" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Expression_expression_compose_operand_ValueSpecification _,
          ops.Expression_operand)) :+
        ( "subExpression" -> AssociationMetaPropertySequenceUpdateInfo(
          links_StringExpression_owningExpression_compose_subExpression_StringExpression _,
          ops.StringExpression_subExpression))

  // All parents: {StructuredActivityNode, Action, ActivityGroup, ExecutableNode, Namespace, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_StructuredActivityNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "edge" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge _,
          ops.StructuredActivityNode_edge)) :+
        ( "node" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode _,
          ops.StructuredActivityNode_node)) :+
        ( "structuredNodeInput" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin _,
          ops.StructuredActivityNode_structuredNodeInput)) :+
        ( "structuredNodeOutput" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin _,
          ops.StructuredActivityNode_structuredNodeOutput)) :+
        ( "variable" -> AssociationMetaPropertySetUpdateInfo(
          links_StructuredActivityNode_scope_compose_variable_Variable _,
          ops.StructuredActivityNode_variable))

  // All parents: {Substitution, Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Substitution
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "mapping" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Abstraction_abstraction_compose_mapping_OpaqueExpression _,
          ops.Abstraction_mapping))

  // All parents: {TemplateBinding, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_TemplateBinding
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "parameterSubstitution" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateBinding_templateBinding_compose_parameterSubstitution_TemplateParameterSubstitution _,
          ops.TemplateBinding_parameterSubstitution))

  // All parents: {TemplateParameter, Element}
  lazy val metaclass_composite_updater_table_TemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "ownedDefault" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_templateParameter_compose_ownedDefault_ParameterableElement _,
          ops.TemplateParameter_ownedDefault)) :+
        ( "ownedParameteredElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_owningTemplateParameter_compose_ownedParameteredElement_ParameterableElement _,
          ops.TemplateParameter_ownedParameteredElement))

  // All parents: {TemplateParameterSubstitution, Element}
  lazy val metaclass_composite_updater_table_TemplateParameterSubstitution
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "ownedActual" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameterSubstitution_owningTemplateParameterSubstitution_compose_ownedActual_ParameterableElement _,
          ops.TemplateParameterSubstitution_ownedActual))

  // All parents: {TemplateSignature, Element}
  lazy val metaclass_composite_updater_table_TemplateSignature
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "ownedParameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_TemplateSignature_signature_compose_ownedParameter_TemplateParameter _,
          ops.TemplateSignature_ownedParameter))

  // All parents: {TestIdentityAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_TestIdentityAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "first" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TestIdentityAction_testIdentityAction_compose_first_InputPin _,
          ops.TestIdentityAction_first)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TestIdentityAction_testIdentityAction_compose_result_OutputPin _,
          ops.TestIdentityAction_result)) :+
        ( "second" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TestIdentityAction_testIdentityAction_compose_second_InputPin _,
          ops.TestIdentityAction_second))

  // All parents: {TimeConstraint, IntervalConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_TimeConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Constraint_owningConstraint_compose_specification_ValueSpecification _,
          ops.Constraint_specification)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_IntervalConstraint_intervalConstraint_compose_specification_Interval _,
          ops.IntervalConstraint_specification)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TimeConstraint_timeConstraint_compose_specification_TimeInterval _,
          ops.TimeConstraint_specification))

  // All parents: {TimeEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_TimeEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "when" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TimeEvent_timeEvent_compose_when_TimeExpression _,
          ops.TimeEvent_when))

  // All parents: {TimeExpression, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_TimeExpression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "expr" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TimeExpression_timeExpression_compose_expr_ValueSpecification _,
          ops.TimeExpression_expr))

  // All parents: {TimeInterval, Interval, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_TimeInterval
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {TimeObservation, Observation, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_TimeObservation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {Transition, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Transition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "effect" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Transition_transition_compose_effect_Behavior _,
          ops.Transition_effect)) :+
        ( "trigger" -> AssociationMetaPropertySetUpdateInfo(
          links_Transition_transition_compose_trigger_Trigger _,
          ops.Transition_trigger))

  // All parents: {Trigger, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Trigger
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {UnmarshallAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_UnmarshallAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "object" -> AssociationMetaPropertyOptionUpdateInfo(
          links_UnmarshallAction_unmarshallAction_compose_object_InputPin _,
          ops.UnmarshallAction_object)) :+
        ( "result" -> AssociationMetaPropertySequenceUpdateInfo(
          links_UnmarshallAction_unmarshallAction_compose_result_OutputPin _,
          ops.UnmarshallAction_result))

  // All parents: {Usage, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Usage
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression))

  // All parents: {UseCase, BehavioredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_UseCase
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
          ops.TemplateableElement_ownedTemplateSignature)) :+
        ( "templateBinding" -> AssociationMetaPropertySetUpdateInfo(
          links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
          ops.TemplateableElement_templateBinding)) :+
        ( "elementImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
          ops.Namespace_elementImport)) :+
        ( "ownedRule" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_context_compose_ownedRule_Constraint _,
          ops.Namespace_ownedRule)) :+
        ( "packageImport" -> AssociationMetaPropertySetUpdateInfo(
          links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
          ops.Namespace_packageImport)) :+
        ( "collaborationUse" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
          ops.Classifier_collaborationUse)) :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_specific_compose_generalization_Generalization _,
          ops.Classifier_generalization)) :+
        ( "ownedTemplateSignature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
          ops.Classifier_ownedTemplateSignature)) :+
        ( "ownedUseCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_compose_ownedUseCase_UseCase _,
          ops.Classifier_ownedUseCase)) :+
        ( "substitution" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
          ops.Classifier_substitution)) :+
        ( "interfaceRealization" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
          ops.BehavioredClassifier_interfaceRealization)) :+
        ( "ownedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
          ops.BehavioredClassifier_ownedBehavior)) :+
        ( "extend" -> AssociationMetaPropertySetUpdateInfo(
          links_UseCase_extension_compose_extend_Extend _,
          ops.UseCase_extend)) :+
        ( "extensionPoint" -> AssociationMetaPropertySetUpdateInfo(
          links_UseCase_useCase_compose_extensionPoint_ExtensionPoint _,
          ops.UseCase_extensionPoint)) :+
        ( "include" -> AssociationMetaPropertySetUpdateInfo(
          links_UseCase_includingCase_compose_include_Include _,
          ops.UseCase_include))

  // All parents: {ValuePin, InputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ValuePin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "upperBound" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_compose_upperBound_ValueSpecification _,
          ops.ObjectNode_upperBound)) :+
        ( "lowerValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
          ops.MultiplicityElement_lowerValue)) :+
        ( "upperValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
          ops.MultiplicityElement_upperValue)) :+
        ( "value" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ValuePin_valuePin_compose_value_ValueSpecification _,
          ops.ValuePin_value))

  // All parents: {ValueSpecificationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ValueSpecificationAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "handler" -> AssociationMetaPropertySetUpdateInfo(
          links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
          ops.ExecutableNode_handler)) :+
        ( "localPostcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPostcondition_Constraint _,
          ops.Action_localPostcondition)) :+
        ( "localPrecondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Action_action_compose_localPrecondition_Constraint _,
          ops.Action_localPrecondition)) :+
        ( "result" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ValueSpecificationAction_valueSpecificationAction_compose_result_OutputPin _,
          ops.ValueSpecificationAction_result)) :+
        ( "value" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ValueSpecificationAction_valueSpecificationAction_compose_value_ValueSpecification _,
          ops.ValueSpecificationAction_value))

  // All parents: {Variable, ConnectableElement, ParameterableElement, MultiplicityElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Variable
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "ownedComment" -> AssociationMetaPropertySetUpdateInfo(
          links_Element_owningElement_compose_ownedComment_Comment _,
          ops.Element_ownedComment)) :+
        ( "nameExpression" -> AssociationMetaPropertyOptionUpdateInfo(
          links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
          ops.NamedElement_nameExpression)) :+
        ( "lowerValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
          ops.MultiplicityElement_lowerValue)) :+
        ( "upperValue" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
          ops.MultiplicityElement_upperValue))

  /** Maps the name of each concrete metaclass to a map of reference property name to meta-information.
    * Note: Reference properties in these maps are metaclass-owned properties typed by a metaclass
    *       without composite aggregation.
    */
  lazy val metaclass_reference_updater_table
  : Map[String, Seq[(String, AssociationMetaPropertyUpdater)]]
  = Map[String, Seq[(String, AssociationMetaPropertyUpdater)]] () +
   ("Abstraction" -> metaclass_reference_updater_table_Abstraction) +
   ("AcceptCallAction" -> metaclass_reference_updater_table_AcceptCallAction) +
   ("AcceptEventAction" -> metaclass_reference_updater_table_AcceptEventAction) +
   ("ActionExecutionSpecification" -> metaclass_reference_updater_table_ActionExecutionSpecification) +
   ("ActionInputPin" -> metaclass_reference_updater_table_ActionInputPin) +
   ("Activity" -> metaclass_reference_updater_table_Activity) +
   ("ActivityFinalNode" -> metaclass_reference_updater_table_ActivityFinalNode) +
   ("ActivityParameterNode" -> metaclass_reference_updater_table_ActivityParameterNode) +
   ("ActivityPartition" -> metaclass_reference_updater_table_ActivityPartition) +
   ("Actor" -> metaclass_reference_updater_table_Actor) +
   ("AddStructuralFeatureValueAction" -> metaclass_reference_updater_table_AddStructuralFeatureValueAction) +
   ("AddVariableValueAction" -> metaclass_reference_updater_table_AddVariableValueAction) +
   ("AnyReceiveEvent" -> metaclass_reference_updater_table_AnyReceiveEvent) +
   ("Artifact" -> metaclass_reference_updater_table_Artifact) +
   ("Association" -> metaclass_reference_updater_table_Association) +
   ("AssociationClass" -> metaclass_reference_updater_table_AssociationClass) +
   ("BehaviorExecutionSpecification" -> metaclass_reference_updater_table_BehaviorExecutionSpecification) +
   ("BroadcastSignalAction" -> metaclass_reference_updater_table_BroadcastSignalAction) +
   ("CallBehaviorAction" -> metaclass_reference_updater_table_CallBehaviorAction) +
   ("CallEvent" -> metaclass_reference_updater_table_CallEvent) +
   ("CallOperationAction" -> metaclass_reference_updater_table_CallOperationAction) +
   ("CentralBufferNode" -> metaclass_reference_updater_table_CentralBufferNode) +
   ("ChangeEvent" -> metaclass_reference_updater_table_ChangeEvent) +
   ("Class" -> metaclass_reference_updater_table_Class) +
   ("ClassifierTemplateParameter" -> metaclass_reference_updater_table_ClassifierTemplateParameter) +
   ("Clause" -> metaclass_reference_updater_table_Clause) +
   ("ClearAssociationAction" -> metaclass_reference_updater_table_ClearAssociationAction) +
   ("ClearStructuralFeatureAction" -> metaclass_reference_updater_table_ClearStructuralFeatureAction) +
   ("ClearVariableAction" -> metaclass_reference_updater_table_ClearVariableAction) +
   ("Collaboration" -> metaclass_reference_updater_table_Collaboration) +
   ("CollaborationUse" -> metaclass_reference_updater_table_CollaborationUse) +
   ("CombinedFragment" -> metaclass_reference_updater_table_CombinedFragment) +
   ("Comment" -> metaclass_reference_updater_table_Comment) +
   ("CommunicationPath" -> metaclass_reference_updater_table_CommunicationPath) +
   ("Component" -> metaclass_reference_updater_table_Component) +
   ("ComponentRealization" -> metaclass_reference_updater_table_ComponentRealization) +
   ("ConditionalNode" -> metaclass_reference_updater_table_ConditionalNode) +
   ("ConnectableElementTemplateParameter" -> metaclass_reference_updater_table_ConnectableElementTemplateParameter) +
   ("ConnectionPointReference" -> metaclass_reference_updater_table_ConnectionPointReference) +
   ("Connector" -> metaclass_reference_updater_table_Connector) +
   ("ConnectorEnd" -> metaclass_reference_updater_table_ConnectorEnd) +
   ("ConsiderIgnoreFragment" -> metaclass_reference_updater_table_ConsiderIgnoreFragment) +
   ("Constraint" -> metaclass_reference_updater_table_Constraint) +
   ("Continuation" -> metaclass_reference_updater_table_Continuation) +
   ("ControlFlow" -> metaclass_reference_updater_table_ControlFlow) +
   ("CreateLinkAction" -> metaclass_reference_updater_table_CreateLinkAction) +
   ("CreateLinkObjectAction" -> metaclass_reference_updater_table_CreateLinkObjectAction) +
   ("CreateObjectAction" -> metaclass_reference_updater_table_CreateObjectAction) +
   ("DataStoreNode" -> metaclass_reference_updater_table_DataStoreNode) +
   ("DataType" -> metaclass_reference_updater_table_DataType) +
   ("DecisionNode" -> metaclass_reference_updater_table_DecisionNode) +
   ("Dependency" -> metaclass_reference_updater_table_Dependency) +
   ("Deployment" -> metaclass_reference_updater_table_Deployment) +
   ("DeploymentSpecification" -> metaclass_reference_updater_table_DeploymentSpecification) +
   ("DestroyLinkAction" -> metaclass_reference_updater_table_DestroyLinkAction) +
   ("DestroyObjectAction" -> metaclass_reference_updater_table_DestroyObjectAction) +
   ("DestructionOccurrenceSpecification" -> metaclass_reference_updater_table_DestructionOccurrenceSpecification) +
   ("Device" -> metaclass_reference_updater_table_Device) +
   ("Duration" -> metaclass_reference_updater_table_Duration) +
   ("DurationConstraint" -> metaclass_reference_updater_table_DurationConstraint) +
   ("DurationInterval" -> metaclass_reference_updater_table_DurationInterval) +
   ("DurationObservation" -> metaclass_reference_updater_table_DurationObservation) +
   ("ElementImport" -> metaclass_reference_updater_table_ElementImport) +
   ("Enumeration" -> metaclass_reference_updater_table_Enumeration) +
   ("EnumerationLiteral" -> metaclass_reference_updater_table_EnumerationLiteral) +
   ("ExceptionHandler" -> metaclass_reference_updater_table_ExceptionHandler) +
   ("ExecutionEnvironment" -> metaclass_reference_updater_table_ExecutionEnvironment) +
   ("ExecutionOccurrenceSpecification" -> metaclass_reference_updater_table_ExecutionOccurrenceSpecification) +
   ("ExpansionNode" -> metaclass_reference_updater_table_ExpansionNode) +
   ("ExpansionRegion" -> metaclass_reference_updater_table_ExpansionRegion) +
   ("Expression" -> metaclass_reference_updater_table_Expression) +
   ("Extend" -> metaclass_reference_updater_table_Extend) +
   ("Extension" -> metaclass_reference_updater_table_Extension) +
   ("ExtensionEnd" -> metaclass_reference_updater_table_ExtensionEnd) +
   ("ExtensionPoint" -> metaclass_reference_updater_table_ExtensionPoint) +
   ("FinalState" -> metaclass_reference_updater_table_FinalState) +
   ("FlowFinalNode" -> metaclass_reference_updater_table_FlowFinalNode) +
   ("ForkNode" -> metaclass_reference_updater_table_ForkNode) +
   ("FunctionBehavior" -> metaclass_reference_updater_table_FunctionBehavior) +
   ("Gate" -> metaclass_reference_updater_table_Gate) +
   ("GeneralOrdering" -> metaclass_reference_updater_table_GeneralOrdering) +
   ("Generalization" -> metaclass_reference_updater_table_Generalization) +
   ("GeneralizationSet" -> metaclass_reference_updater_table_GeneralizationSet) +
   ("Image" -> metaclass_reference_updater_table_Image) +
   ("Include" -> metaclass_reference_updater_table_Include) +
   ("InformationFlow" -> metaclass_reference_updater_table_InformationFlow) +
   ("InformationItem" -> metaclass_reference_updater_table_InformationItem) +
   ("InitialNode" -> metaclass_reference_updater_table_InitialNode) +
   ("InputPin" -> metaclass_reference_updater_table_InputPin) +
   ("InstanceSpecification" -> metaclass_reference_updater_table_InstanceSpecification) +
   ("InstanceValue" -> metaclass_reference_updater_table_InstanceValue) +
   ("Interaction" -> metaclass_reference_updater_table_Interaction) +
   ("InteractionConstraint" -> metaclass_reference_updater_table_InteractionConstraint) +
   ("InteractionOperand" -> metaclass_reference_updater_table_InteractionOperand) +
   ("InteractionUse" -> metaclass_reference_updater_table_InteractionUse) +
   ("Interface" -> metaclass_reference_updater_table_Interface) +
   ("InterfaceRealization" -> metaclass_reference_updater_table_InterfaceRealization) +
   ("InterruptibleActivityRegion" -> metaclass_reference_updater_table_InterruptibleActivityRegion) +
   ("Interval" -> metaclass_reference_updater_table_Interval) +
   ("IntervalConstraint" -> metaclass_reference_updater_table_IntervalConstraint) +
   ("JoinNode" -> metaclass_reference_updater_table_JoinNode) +
   ("Lifeline" -> metaclass_reference_updater_table_Lifeline) +
   ("LinkEndCreationData" -> metaclass_reference_updater_table_LinkEndCreationData) +
   ("LinkEndData" -> metaclass_reference_updater_table_LinkEndData) +
   ("LinkEndDestructionData" -> metaclass_reference_updater_table_LinkEndDestructionData) +
   ("LiteralBoolean" -> metaclass_reference_updater_table_LiteralBoolean) +
   ("LiteralInteger" -> metaclass_reference_updater_table_LiteralInteger) +
   ("LiteralNull" -> metaclass_reference_updater_table_LiteralNull) +
   ("LiteralReal" -> metaclass_reference_updater_table_LiteralReal) +
   ("LiteralString" -> metaclass_reference_updater_table_LiteralString) +
   ("LiteralUnlimitedNatural" -> metaclass_reference_updater_table_LiteralUnlimitedNatural) +
   ("LoopNode" -> metaclass_reference_updater_table_LoopNode) +
   ("Manifestation" -> metaclass_reference_updater_table_Manifestation) +
   ("MergeNode" -> metaclass_reference_updater_table_MergeNode) +
   ("Message" -> metaclass_reference_updater_table_Message) +
   ("MessageOccurrenceSpecification" -> metaclass_reference_updater_table_MessageOccurrenceSpecification) +
   ("Model" -> metaclass_reference_updater_table_Model) +
   ("Node" -> metaclass_reference_updater_table_Node) +
   ("ObjectFlow" -> metaclass_reference_updater_table_ObjectFlow) +
   ("OccurrenceSpecification" -> metaclass_reference_updater_table_OccurrenceSpecification) +
   ("OpaqueAction" -> metaclass_reference_updater_table_OpaqueAction) +
   ("OpaqueBehavior" -> metaclass_reference_updater_table_OpaqueBehavior) +
   ("OpaqueExpression" -> metaclass_reference_updater_table_OpaqueExpression) +
   ("Operation" -> metaclass_reference_updater_table_Operation) +
   ("OperationTemplateParameter" -> metaclass_reference_updater_table_OperationTemplateParameter) +
   ("OutputPin" -> metaclass_reference_updater_table_OutputPin) +
   ("Package" -> metaclass_reference_updater_table_Package) +
   ("PackageImport" -> metaclass_reference_updater_table_PackageImport) +
   ("PackageMerge" -> metaclass_reference_updater_table_PackageMerge) +
   ("Parameter" -> metaclass_reference_updater_table_Parameter) +
   ("ParameterSet" -> metaclass_reference_updater_table_ParameterSet) +
   ("PartDecomposition" -> metaclass_reference_updater_table_PartDecomposition) +
   ("Port" -> metaclass_reference_updater_table_Port) +
   ("PrimitiveType" -> metaclass_reference_updater_table_PrimitiveType) +
   ("Profile" -> metaclass_reference_updater_table_Profile) +
   ("ProfileApplication" -> metaclass_reference_updater_table_ProfileApplication) +
   ("Property" -> metaclass_reference_updater_table_Property) +
   ("ProtocolConformance" -> metaclass_reference_updater_table_ProtocolConformance) +
   ("ProtocolStateMachine" -> metaclass_reference_updater_table_ProtocolStateMachine) +
   ("ProtocolTransition" -> metaclass_reference_updater_table_ProtocolTransition) +
   ("Pseudostate" -> metaclass_reference_updater_table_Pseudostate) +
   ("QualifierValue" -> metaclass_reference_updater_table_QualifierValue) +
   ("RaiseExceptionAction" -> metaclass_reference_updater_table_RaiseExceptionAction) +
   ("ReadExtentAction" -> metaclass_reference_updater_table_ReadExtentAction) +
   ("ReadIsClassifiedObjectAction" -> metaclass_reference_updater_table_ReadIsClassifiedObjectAction) +
   ("ReadLinkAction" -> metaclass_reference_updater_table_ReadLinkAction) +
   ("ReadLinkObjectEndAction" -> metaclass_reference_updater_table_ReadLinkObjectEndAction) +
   ("ReadLinkObjectEndQualifierAction" -> metaclass_reference_updater_table_ReadLinkObjectEndQualifierAction) +
   ("ReadSelfAction" -> metaclass_reference_updater_table_ReadSelfAction) +
   ("ReadStructuralFeatureAction" -> metaclass_reference_updater_table_ReadStructuralFeatureAction) +
   ("ReadVariableAction" -> metaclass_reference_updater_table_ReadVariableAction) +
   ("Realization" -> metaclass_reference_updater_table_Realization) +
   ("Reception" -> metaclass_reference_updater_table_Reception) +
   ("ReclassifyObjectAction" -> metaclass_reference_updater_table_ReclassifyObjectAction) +
   ("RedefinableTemplateSignature" -> metaclass_reference_updater_table_RedefinableTemplateSignature) +
   ("ReduceAction" -> metaclass_reference_updater_table_ReduceAction) +
   ("Region" -> metaclass_reference_updater_table_Region) +
   ("RemoveStructuralFeatureValueAction" -> metaclass_reference_updater_table_RemoveStructuralFeatureValueAction) +
   ("RemoveVariableValueAction" -> metaclass_reference_updater_table_RemoveVariableValueAction) +
   ("ReplyAction" -> metaclass_reference_updater_table_ReplyAction) +
   ("SendObjectAction" -> metaclass_reference_updater_table_SendObjectAction) +
   ("SendSignalAction" -> metaclass_reference_updater_table_SendSignalAction) +
   ("SequenceNode" -> metaclass_reference_updater_table_SequenceNode) +
   ("Signal" -> metaclass_reference_updater_table_Signal) +
   ("SignalEvent" -> metaclass_reference_updater_table_SignalEvent) +
   ("Slot" -> metaclass_reference_updater_table_Slot) +
   ("StartClassifierBehaviorAction" -> metaclass_reference_updater_table_StartClassifierBehaviorAction) +
   ("StartObjectBehaviorAction" -> metaclass_reference_updater_table_StartObjectBehaviorAction) +
   ("State" -> metaclass_reference_updater_table_State) +
   ("StateInvariant" -> metaclass_reference_updater_table_StateInvariant) +
   ("StateMachine" -> metaclass_reference_updater_table_StateMachine) +
   ("Stereotype" -> metaclass_reference_updater_table_Stereotype) +
   ("StringExpression" -> metaclass_reference_updater_table_StringExpression) +
   ("StructuredActivityNode" -> metaclass_reference_updater_table_StructuredActivityNode) +
   ("Substitution" -> metaclass_reference_updater_table_Substitution) +
   ("TemplateBinding" -> metaclass_reference_updater_table_TemplateBinding) +
   ("TemplateParameter" -> metaclass_reference_updater_table_TemplateParameter) +
   ("TemplateParameterSubstitution" -> metaclass_reference_updater_table_TemplateParameterSubstitution) +
   ("TemplateSignature" -> metaclass_reference_updater_table_TemplateSignature) +
   ("TestIdentityAction" -> metaclass_reference_updater_table_TestIdentityAction) +
   ("TimeConstraint" -> metaclass_reference_updater_table_TimeConstraint) +
   ("TimeEvent" -> metaclass_reference_updater_table_TimeEvent) +
   ("TimeExpression" -> metaclass_reference_updater_table_TimeExpression) +
   ("TimeInterval" -> metaclass_reference_updater_table_TimeInterval) +
   ("TimeObservation" -> metaclass_reference_updater_table_TimeObservation) +
   ("Transition" -> metaclass_reference_updater_table_Transition) +
   ("Trigger" -> metaclass_reference_updater_table_Trigger) +
   ("UnmarshallAction" -> metaclass_reference_updater_table_UnmarshallAction) +
   ("Usage" -> metaclass_reference_updater_table_Usage) +
   ("UseCase" -> metaclass_reference_updater_table_UseCase) +
   ("ValuePin" -> metaclass_reference_updater_table_ValuePin) +
   ("ValueSpecificationAction" -> metaclass_reference_updater_table_ValueSpecificationAction) +
   ("Variable" -> metaclass_reference_updater_table_Variable)

  // All parents: {Abstraction, Dependency, DirectedRelationship, PackageableElement, Relationship, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Abstraction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "client" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_clientDependency_reference_client_NamedElement _,
          ops.Dependency_client)) :+
        ( "supplier" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_supplierDependency_reference_supplier_NamedElement _,
          ops.Dependency_supplier)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {AcceptCallAction, AcceptEventAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_AcceptCallAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {AcceptEventAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_AcceptEventAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ActionExecutionSpecification, ExecutionSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ActionExecutionSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "action" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActionExecutionSpecification_actionExecutionSpecification_reference_action_Action _,
          ops.ActionExecutionSpecification_action)) :+
        ( "finish" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ExecutionSpecification_executionSpecification_reference_finish_OccurrenceSpecification _,
          ops.ExecutionSpecification_finish)) :+
        ( "start" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ExecutionSpecification_executionSpecification_reference_start_OccurrenceSpecification _,
          ops.ExecutionSpecification_start)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {ActionInputPin, InputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ActionInputPin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inState" -> AssociationMetaPropertySetUpdateInfo(
          links_ObjectNode_objectNode_reference_inState_State _,
          ops.ObjectNode_inState)) :+
        ( "selection" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_reference_selection_Behavior _,
          ops.ObjectNode_selection)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

  // All parents: {Activity, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Activity
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "partition" -> AssociationMetaPropertySetUpdateInfo(
          links_Activity_activity_reference_partition_ActivityPartition _,
          ops.Activity_partition)) :+
        ( "structuredNode" -> AssociationMetaPropertySetUpdateInfo(
          links_Activity_activity_compose_structuredNode_StructuredActivityNode _,
          ops.Activity_structuredNode)) :+
        ( "postcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_postcondition_Constraint _,
          ops.Behavior_postcondition)) :+
        ( "precondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_precondition_Constraint _,
          ops.Behavior_precondition)) :+
        ( "redefinedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_reference_redefinedBehavior_Behavior _,
          ops.Behavior_redefinedBehavior)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Behavior_method_reference_specification_BehavioralFeature _,
          ops.Behavior_specification)) :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {ActivityFinalNode, FinalNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ActivityFinalNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ActivityParameterNode, ObjectNode, ActivityNode, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ActivityParameterNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "parameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActivityParameterNode_activityParameterNode_reference_parameter_Parameter _,
          ops.ActivityParameterNode_parameter)) :+
        ( "inState" -> AssociationMetaPropertySetUpdateInfo(
          links_ObjectNode_objectNode_reference_inState_State _,
          ops.ObjectNode_inState)) :+
        ( "selection" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_reference_selection_Behavior _,
          ops.ObjectNode_selection)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

  // All parents: {ActivityPartition, ActivityGroup, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ActivityPartition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "edge" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityPartition_inPartition_reference_edge_ActivityEdge _,
          ops.ActivityPartition_edge)) :+
        ( "node" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityPartition_inPartition_reference_node_ActivityNode _,
          ops.ActivityPartition_node)) :+
        ( "represents" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActivityPartition_activityPartition_reference_represents_Element _,
          ops.ActivityPartition_represents))

  // All parents: {Actor, BehavioredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Actor
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {AddStructuralFeatureValueAction, WriteStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_AddStructuralFeatureValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "structuralFeature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_StructuralFeatureAction_structuralFeatureAction_reference_structuralFeature_StructuralFeature _,
          ops.StructuralFeatureAction_structuralFeature)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {AddVariableValueAction, WriteVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_AddVariableValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "variable" -> AssociationMetaPropertyOptionUpdateInfo(
          links_VariableAction_variableAction_reference_variable_Variable _,
          ops.VariableAction_variable)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {AnyReceiveEvent, MessageEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_AnyReceiveEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Artifact, Classifier, Namespace, DeployedArtifact, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Artifact
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Association, Classifier, Relationship, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Association
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "memberEnd" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Association_association_reference_memberEnd_Property _,
          ops.Association_memberEnd)) :+
        ( "navigableOwnedEnd" -> AssociationMetaPropertySetUpdateInfo(
          links_Association_association_reference_navigableOwnedEnd_Property _,
          ops.Association_navigableOwnedEnd)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {AssociationClass, Association, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, Relationship, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_AssociationClass
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "memberEnd" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Association_association_reference_memberEnd_Property _,
          ops.Association_memberEnd)) :+
        ( "navigableOwnedEnd" -> AssociationMetaPropertySetUpdateInfo(
          links_Association_association_reference_navigableOwnedEnd_Property _,
          ops.Association_navigableOwnedEnd)) :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {BehaviorExecutionSpecification, ExecutionSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_BehaviorExecutionSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "behavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehaviorExecutionSpecification_behaviorExecutionSpecification_reference_behavior_Behavior _,
          ops.BehaviorExecutionSpecification_behavior)) :+
        ( "finish" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ExecutionSpecification_executionSpecification_reference_finish_OccurrenceSpecification _,
          ops.ExecutionSpecification_finish)) :+
        ( "start" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ExecutionSpecification_executionSpecification_reference_start_OccurrenceSpecification _,
          ops.ExecutionSpecification_start)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {BroadcastSignalAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_BroadcastSignalAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "signal" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BroadcastSignalAction_broadcastSignalAction_reference_signal_Signal _,
          ops.BroadcastSignalAction_signal)) :+
        ( "onPort" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InvocationAction_invocationAction_reference_onPort_Port _,
          ops.InvocationAction_onPort)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {CallBehaviorAction, CallAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CallBehaviorAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "behavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_CallBehaviorAction_callBehaviorAction_reference_behavior_Behavior _,
          ops.CallBehaviorAction_behavior)) :+
        ( "onPort" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InvocationAction_invocationAction_reference_onPort_Port _,
          ops.InvocationAction_onPort)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {CallEvent, MessageEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_CallEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "operation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_CallEvent_callEvent_reference_operation_Operation _,
          ops.CallEvent_operation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {CallOperationAction, CallAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CallOperationAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "operation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_CallOperationAction_callOperationAction_reference_operation_Operation _,
          ops.CallOperationAction_operation)) :+
        ( "onPort" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InvocationAction_invocationAction_reference_onPort_Port _,
          ops.InvocationAction_onPort)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {CentralBufferNode, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CentralBufferNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inState" -> AssociationMetaPropertySetUpdateInfo(
          links_ObjectNode_objectNode_reference_inState_State _,
          ops.ObjectNode_inState)) :+
        ( "selection" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_reference_selection_Behavior _,
          ops.ObjectNode_selection)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

  // All parents: {ChangeEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_ChangeEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Class
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {ClassifierTemplateParameter, TemplateParameter, Element}
  lazy val metaclass_reference_updater_table_ClassifierTemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "constrainingClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_ClassifierTemplateParameter_classifierTemplateParameter_reference_constrainingClassifier_Classifier _,
          ops.ClassifierTemplateParameter_constrainingClassifier)) :+
        ( "parameteredElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ClassifierTemplateParameter_templateParameter_reference_parameteredElement_Classifier _,
          ops.ClassifierTemplateParameter_parameteredElement)) :+
        ( "default" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_templateParameter_reference_default_ParameterableElement _,
          ops.TemplateParameter_default)) :+
        ( "parameteredElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_templateParameter_reference_parameteredElement_ParameterableElement _,
          ops.TemplateParameter_parameteredElement))

  // All parents: {Clause, Element}
  lazy val metaclass_reference_updater_table_Clause
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "body" -> AssociationMetaPropertySetUpdateInfo(
          links_Clause_clause_reference_body_ExecutableNode _,
          ops.Clause_body)) :+
        ( "bodyOutput" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Clause_clause_reference_bodyOutput_OutputPin _,
          ops.Clause_bodyOutput)) :+
        ( "decider" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Clause_clause_reference_decider_OutputPin _,
          ops.Clause_decider)) :+
        ( "predecessorClause" -> AssociationMetaPropertySetUpdateInfo(
          links_Clause_successorClause_reference_predecessorClause_Clause _,
          ops.Clause_predecessorClause)) :+
        ( "successorClause" -> AssociationMetaPropertySetUpdateInfo(
          links_Clause_predecessorClause_reference_successorClause_Clause _,
          ops.Clause_successorClause)) :+
        ( "test" -> AssociationMetaPropertySetUpdateInfo(
          links_Clause_clause_reference_test_ExecutableNode _,
          ops.Clause_test))

  // All parents: {ClearAssociationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ClearAssociationAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "association" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ClearAssociationAction_clearAssociationAction_reference_association_Association _,
          ops.ClearAssociationAction_association)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ClearStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ClearStructuralFeatureAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "structuralFeature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_StructuralFeatureAction_structuralFeatureAction_reference_structuralFeature_StructuralFeature _,
          ops.StructuralFeatureAction_structuralFeature)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ClearVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ClearVariableAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "variable" -> AssociationMetaPropertyOptionUpdateInfo(
          links_VariableAction_variableAction_reference_variable_Variable _,
          ops.VariableAction_variable)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {Collaboration, BehavioredClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Collaboration
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "collaborationRole" -> AssociationMetaPropertySetUpdateInfo(
          links_Collaboration_collaboration_reference_collaborationRole_ConnectableElement _,
          ops.Collaboration_collaborationRole)) :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {CollaborationUse, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CollaborationUse
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_CollaborationUse_collaborationUse_reference_type_Collaboration _,
          ops.CollaborationUse_type))

  // All parents: {CombinedFragment, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CombinedFragment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {Comment, Element}
  lazy val metaclass_reference_updater_table_Comment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "annotatedElement" -> AssociationMetaPropertySetUpdateInfo(
          links_Comment_comment_reference_annotatedElement_Element _,
          ops.Comment_annotatedElement))

  // All parents: {CommunicationPath, Association, Classifier, Namespace, Relationship, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_CommunicationPath
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "memberEnd" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Association_association_reference_memberEnd_Property _,
          ops.Association_memberEnd)) :+
        ( "navigableOwnedEnd" -> AssociationMetaPropertySetUpdateInfo(
          links_Association_association_reference_navigableOwnedEnd_Property _,
          ops.Association_navigableOwnedEnd)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Component, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Component
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {ComponentRealization, Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_ComponentRealization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "realizingClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_ComponentRealization_componentRealization_reference_realizingClassifier_Classifier _,
          ops.ComponentRealization_realizingClassifier)) :+
        ( "client" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_clientDependency_reference_client_NamedElement _,
          ops.Dependency_client)) :+
        ( "supplier" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_supplierDependency_reference_supplier_NamedElement _,
          ops.Dependency_supplier)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {ConditionalNode, StructuredActivityNode, Action, ActivityGroup, ExecutableNode, Namespace, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ConditionalNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ConnectableElementTemplateParameter, TemplateParameter, Element}
  lazy val metaclass_reference_updater_table_ConnectableElementTemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "parameteredElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ConnectableElementTemplateParameter_templateParameter_reference_parameteredElement_ConnectableElement _,
          ops.ConnectableElementTemplateParameter_parameteredElement)) :+
        ( "default" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_templateParameter_reference_default_ParameterableElement _,
          ops.TemplateParameter_default)) :+
        ( "parameteredElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_templateParameter_reference_parameteredElement_ParameterableElement _,
          ops.TemplateParameter_parameteredElement))

  // All parents: {ConnectionPointReference, Vertex, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ConnectionPointReference
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "entry" -> AssociationMetaPropertySetUpdateInfo(
          links_ConnectionPointReference_connectionPointReference_reference_entry_Pseudostate _,
          ops.ConnectionPointReference_entry)) :+
        ( "exit" -> AssociationMetaPropertySetUpdateInfo(
          links_ConnectionPointReference_connectionPointReference_reference_exit_Pseudostate _,
          ops.ConnectionPointReference_exit))

  // All parents: {Connector, Feature, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Connector
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "contract" -> AssociationMetaPropertySetUpdateInfo(
          links_Connector_connector_reference_contract_Behavior _,
          ops.Connector_contract)) :+
        ( "redefinedConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_Connector_connector_reference_redefinedConnector_Connector _,
          ops.Connector_redefinedConnector)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Connector_connector_reference_type_Association _,
          ops.Connector_type))

  // All parents: {ConnectorEnd, MultiplicityElement, Element}
  lazy val metaclass_reference_updater_table_ConnectorEnd
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "partWithPort" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ConnectorEnd_connectorEnd_reference_partWithPort_Property _,
          ops.ConnectorEnd_partWithPort)) :+
        ( "role" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ConnectorEnd_end_reference_role_ConnectableElement _,
          ops.ConnectorEnd_role))

  // All parents: {ConsiderIgnoreFragment, CombinedFragment, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ConsiderIgnoreFragment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "message" -> AssociationMetaPropertySetUpdateInfo(
          links_ConsiderIgnoreFragment_considerIgnoreFragment_reference_message_NamedElement _,
          ops.ConsiderIgnoreFragment_message)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Constraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "constrainedElement" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Constraint_constraint_reference_constrainedElement_Element _,
          ops.Constraint_constrainedElement)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Continuation, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Continuation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {ControlFlow, ActivityEdge, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ControlFlow
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityEdge_edge_reference_inPartition_ActivityPartition _,
          ops.ActivityEdge_inPartition)) :+
        ( "interrupts" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActivityEdge_interruptingEdge_reference_interrupts_InterruptibleActivityRegion _,
          ops.ActivityEdge_interrupts)) :+
        ( "redefinedEdge" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityEdge_activityEdge_reference_redefinedEdge_ActivityEdge _,
          ops.ActivityEdge_redefinedEdge)) :+
        ( "source" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActivityEdge_outgoing_reference_source_ActivityNode _,
          ops.ActivityEdge_source)) :+
        ( "target" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActivityEdge_incoming_reference_target_ActivityNode _,
          ops.ActivityEdge_target))

  // All parents: {CreateLinkAction, WriteLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CreateLinkAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {CreateLinkObjectAction, CreateLinkAction, WriteLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CreateLinkObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {CreateObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CreateObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "classifier" -> AssociationMetaPropertyOptionUpdateInfo(
          links_CreateObjectAction_createObjectAction_reference_classifier_Classifier _,
          ops.CreateObjectAction_classifier)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {DataStoreNode, CentralBufferNode, ObjectNode, ActivityNode, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_DataStoreNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inState" -> AssociationMetaPropertySetUpdateInfo(
          links_ObjectNode_objectNode_reference_inState_State _,
          ops.ObjectNode_inState)) :+
        ( "selection" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_reference_selection_Behavior _,
          ops.ObjectNode_selection)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

  // All parents: {DataType, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_DataType
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {DecisionNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_DecisionNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "decisionInput" -> AssociationMetaPropertyOptionUpdateInfo(
          links_DecisionNode_decisionNode_reference_decisionInput_Behavior _,
          ops.DecisionNode_decisionInput)) :+
        ( "decisionInputFlow" -> AssociationMetaPropertyOptionUpdateInfo(
          links_DecisionNode_decisionNode_reference_decisionInputFlow_ObjectFlow _,
          ops.DecisionNode_decisionInputFlow)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {Dependency, DirectedRelationship, PackageableElement, Relationship, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Dependency
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "client" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_clientDependency_reference_client_NamedElement _,
          ops.Dependency_client)) :+
        ( "supplier" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_supplierDependency_reference_supplier_NamedElement _,
          ops.Dependency_supplier)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Deployment, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Deployment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "deployedArtifact" -> AssociationMetaPropertySetUpdateInfo(
          links_Deployment_deploymentForArtifact_reference_deployedArtifact_DeployedArtifact _,
          ops.Deployment_deployedArtifact)) :+
        ( "client" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_clientDependency_reference_client_NamedElement _,
          ops.Dependency_client)) :+
        ( "supplier" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_supplierDependency_reference_supplier_NamedElement _,
          ops.Dependency_supplier)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {DeploymentSpecification, Artifact, Classifier, DeployedArtifact, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_DeploymentSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {DestroyLinkAction, WriteLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_DestroyLinkAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {DestroyObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_DestroyObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {DestructionOccurrenceSpecification, MessageOccurrenceSpecification, MessageEnd, OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_DestructionOccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "message" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MessageEnd_messageEnd_reference_message_Message _,
          ops.MessageEnd_message)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_OccurrenceSpecification_events_reference_covered_Lifeline _,
          ops.OccurrenceSpecification_covered)) :+
        ( "toAfter" -> AssociationMetaPropertySetUpdateInfo(
          links_OccurrenceSpecification_before_reference_toAfter_GeneralOrdering _,
          ops.OccurrenceSpecification_toAfter)) :+
        ( "toBefore" -> AssociationMetaPropertySetUpdateInfo(
          links_OccurrenceSpecification_after_reference_toBefore_GeneralOrdering _,
          ops.OccurrenceSpecification_toBefore)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {Device, Node, Class, BehavioredClassifier, DeploymentTarget, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Device
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Duration, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Duration
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "observation" -> AssociationMetaPropertySetUpdateInfo(
          links_Duration_duration_reference_observation_Observation _,
          ops.Duration_observation)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {DurationConstraint, IntervalConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_DurationConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "constrainedElement" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Constraint_constraint_reference_constrainedElement_Element _,
          ops.Constraint_constrainedElement)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {DurationInterval, Interval, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_DurationInterval
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "max" -> AssociationMetaPropertyOptionUpdateInfo(
          links_DurationInterval_durationInterval_reference_max_Duration _,
          ops.DurationInterval_max)) :+
        ( "min" -> AssociationMetaPropertyOptionUpdateInfo(
          links_DurationInterval_durationInterval_reference_min_Duration _,
          ops.DurationInterval_min)) :+
        ( "max" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Interval_interval_reference_max_ValueSpecification _,
          ops.Interval_max)) :+
        ( "min" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Interval_interval_reference_min_ValueSpecification _,
          ops.Interval_min)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {DurationObservation, Observation, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_DurationObservation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "event" -> AssociationMetaPropertySequenceUpdateInfo(
          links_DurationObservation_durationObservation_reference_event_NamedElement _,
          ops.DurationObservation_event)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {ElementImport, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_ElementImport
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "importedElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ElementImport_import_reference_importedElement_PackageableElement _,
          ops.ElementImport_importedElement))

  // All parents: {Enumeration, DataType, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Enumeration
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {EnumerationLiteral, InstanceSpecification, DeployedArtifact, DeploymentTarget, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_EnumerationLiteral
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "classifier" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InstanceSpecification_instanceSpecification_reference_classifier_Classifier _,
          ops.InstanceSpecification_classifier)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {ExceptionHandler, Element}
  lazy val metaclass_reference_updater_table_ExceptionHandler
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "exceptionInput" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ExceptionHandler_exceptionHandler_reference_exceptionInput_ObjectNode _,
          ops.ExceptionHandler_exceptionInput)) :+
        ( "exceptionType" -> AssociationMetaPropertySetUpdateInfo(
          links_ExceptionHandler_exceptionHandler_reference_exceptionType_Classifier _,
          ops.ExceptionHandler_exceptionType)) :+
        ( "handlerBody" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ExceptionHandler_exceptionHandler_reference_handlerBody_ExecutableNode _,
          ops.ExceptionHandler_handlerBody))

  // All parents: {ExecutionEnvironment, Node, Class, DeploymentTarget, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_ExecutionEnvironment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {ExecutionOccurrenceSpecification, OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ExecutionOccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "execution" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ExecutionOccurrenceSpecification_executionOccurrenceSpecification_reference_execution_ExecutionSpecification _,
          ops.ExecutionOccurrenceSpecification_execution)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_OccurrenceSpecification_events_reference_covered_Lifeline _,
          ops.OccurrenceSpecification_covered)) :+
        ( "toAfter" -> AssociationMetaPropertySetUpdateInfo(
          links_OccurrenceSpecification_before_reference_toAfter_GeneralOrdering _,
          ops.OccurrenceSpecification_toAfter)) :+
        ( "toBefore" -> AssociationMetaPropertySetUpdateInfo(
          links_OccurrenceSpecification_after_reference_toBefore_GeneralOrdering _,
          ops.OccurrenceSpecification_toBefore)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {ExpansionNode, ObjectNode, ActivityNode, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ExpansionNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "regionAsInput" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ExpansionNode_inputElement_reference_regionAsInput_ExpansionRegion _,
          ops.ExpansionNode_regionAsInput)) :+
        ( "regionAsOutput" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ExpansionNode_outputElement_reference_regionAsOutput_ExpansionRegion _,
          ops.ExpansionNode_regionAsOutput)) :+
        ( "inState" -> AssociationMetaPropertySetUpdateInfo(
          links_ObjectNode_objectNode_reference_inState_State _,
          ops.ObjectNode_inState)) :+
        ( "selection" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_reference_selection_Behavior _,
          ops.ObjectNode_selection)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

  // All parents: {ExpansionRegion, StructuredActivityNode, Action, ExecutableNode, ActivityGroup, ActivityNode, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ExpansionRegion
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inputElement" -> AssociationMetaPropertySetUpdateInfo(
          links_ExpansionRegion_regionAsInput_reference_inputElement_ExpansionNode _,
          ops.ExpansionRegion_inputElement)) :+
        ( "outputElement" -> AssociationMetaPropertySetUpdateInfo(
          links_ExpansionRegion_regionAsOutput_reference_outputElement_ExpansionNode _,
          ops.ExpansionRegion_outputElement)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {Expression, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Expression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Extend, DirectedRelationship, Relationship, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Extend
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "extendedCase" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Extend_extend_reference_extendedCase_UseCase _,
          ops.Extend_extendedCase)) :+
        ( "extensionLocation" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Extend_extension_reference_extensionLocation_ExtensionPoint _,
          ops.Extend_extensionLocation))

  // All parents: {Extension, Association, Classifier, Relationship, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Extension
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "memberEnd" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Association_association_reference_memberEnd_Property _,
          ops.Association_memberEnd)) :+
        ( "navigableOwnedEnd" -> AssociationMetaPropertySetUpdateInfo(
          links_Association_association_reference_navigableOwnedEnd_Property _,
          ops.Association_navigableOwnedEnd)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {ExtensionEnd, Property, ConnectableElement, DeploymentTarget, ParameterableElement, StructuralFeature, Feature, MultiplicityElement, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ExtensionEnd
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ExtensionEnd_extensionEnd_reference_type_Stereotype _,
          ops.ExtensionEnd_type)) :+
        ( "association" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Property_memberEnd_reference_association_Association _,
          ops.Property_association)) :+
        ( "redefinedProperty" -> AssociationMetaPropertySetUpdateInfo(
          links_Property_property_reference_redefinedProperty_Property _,
          ops.Property_redefinedProperty)) :+
        ( "subsettedProperty" -> AssociationMetaPropertySetUpdateInfo(
          links_Property_property_reference_subsettedProperty_Property _,
          ops.Property_subsettedProperty)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter _,
          ops.ConnectableElement_templateParameter)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

  // All parents: {ExtensionPoint, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ExtensionPoint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]()

  // All parents: {FinalState, State, Namespace, RedefinableElement, Vertex, NamedElement, Element}
  lazy val metaclass_reference_updater_table_FinalState
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "redefinedState" -> AssociationMetaPropertyOptionUpdateInfo(
          links_State_state_reference_redefinedState_State _,
          ops.State_redefinedState)) :+
        ( "stateInvariant" -> AssociationMetaPropertyOptionUpdateInfo(
          links_State_owningState_compose_stateInvariant_Constraint _,
          ops.State_stateInvariant)) :+
        ( "submachine" -> AssociationMetaPropertyOptionUpdateInfo(
          links_State_submachineState_reference_submachine_StateMachine _,
          ops.State_submachine))

  // All parents: {FlowFinalNode, FinalNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_FlowFinalNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ForkNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ForkNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {FunctionBehavior, OpaqueBehavior, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_FunctionBehavior
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "postcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_postcondition_Constraint _,
          ops.Behavior_postcondition)) :+
        ( "precondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_precondition_Constraint _,
          ops.Behavior_precondition)) :+
        ( "redefinedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_reference_redefinedBehavior_Behavior _,
          ops.Behavior_redefinedBehavior)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Behavior_method_reference_specification_BehavioralFeature _,
          ops.Behavior_specification)) :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Gate, MessageEnd, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Gate
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "message" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MessageEnd_messageEnd_reference_message_Message _,
          ops.MessageEnd_message))

  // All parents: {GeneralOrdering, NamedElement, Element}
  lazy val metaclass_reference_updater_table_GeneralOrdering
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "after" -> AssociationMetaPropertyOptionUpdateInfo(
          links_GeneralOrdering_toBefore_reference_after_OccurrenceSpecification _,
          ops.GeneralOrdering_after)) :+
        ( "before" -> AssociationMetaPropertyOptionUpdateInfo(
          links_GeneralOrdering_toAfter_reference_before_OccurrenceSpecification _,
          ops.GeneralOrdering_before))

  // All parents: {Generalization, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_Generalization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "general" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Generalization_generalization_reference_general_Classifier _,
          ops.Generalization_general)) :+
        ( "generalizationSet" -> AssociationMetaPropertySetUpdateInfo(
          links_Generalization_generalization_reference_generalizationSet_GeneralizationSet _,
          ops.Generalization_generalizationSet))

  // All parents: {GeneralizationSet, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_GeneralizationSet
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "generalization" -> AssociationMetaPropertySetUpdateInfo(
          links_GeneralizationSet_generalizationSet_reference_generalization_Generalization _,
          ops.GeneralizationSet_generalization)) :+
        ( "powertype" -> AssociationMetaPropertyOptionUpdateInfo(
          links_GeneralizationSet_powertypeExtent_reference_powertype_Classifier _,
          ops.GeneralizationSet_powertype)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Image, Element}
  lazy val metaclass_reference_updater_table_Image
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]()

  // All parents: {Include, DirectedRelationship, NamedElement, Relationship, Element}
  lazy val metaclass_reference_updater_table_Include
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "addition" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Include_include_reference_addition_UseCase _,
          ops.Include_addition))

  // All parents: {InformationFlow, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_InformationFlow
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "conveyed" -> AssociationMetaPropertySetUpdateInfo(
          links_InformationFlow_conveyingFlow_reference_conveyed_Classifier _,
          ops.InformationFlow_conveyed)) :+
        ( "informationSource" -> AssociationMetaPropertySetUpdateInfo(
          links_InformationFlow_informationFlow_reference_informationSource_NamedElement _,
          ops.InformationFlow_informationSource)) :+
        ( "informationTarget" -> AssociationMetaPropertySetUpdateInfo(
          links_InformationFlow_informationFlow_reference_informationTarget_NamedElement _,
          ops.InformationFlow_informationTarget)) :+
        ( "realization" -> AssociationMetaPropertySetUpdateInfo(
          links_InformationFlow_abstraction_reference_realization_Relationship _,
          ops.InformationFlow_realization)) :+
        ( "realizingActivityEdge" -> AssociationMetaPropertySetUpdateInfo(
          links_InformationFlow_informationFlow_reference_realizingActivityEdge_ActivityEdge _,
          ops.InformationFlow_realizingActivityEdge)) :+
        ( "realizingConnector" -> AssociationMetaPropertySetUpdateInfo(
          links_InformationFlow_informationFlow_reference_realizingConnector_Connector _,
          ops.InformationFlow_realizingConnector)) :+
        ( "realizingMessage" -> AssociationMetaPropertySetUpdateInfo(
          links_InformationFlow_informationFlow_reference_realizingMessage_Message _,
          ops.InformationFlow_realizingMessage)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {InformationItem, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_InformationItem
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "represented" -> AssociationMetaPropertySetUpdateInfo(
          links_InformationItem_representation_reference_represented_Classifier _,
          ops.InformationItem_represented)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {InitialNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_InitialNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {InputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_InputPin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inState" -> AssociationMetaPropertySetUpdateInfo(
          links_ObjectNode_objectNode_reference_inState_State _,
          ops.ObjectNode_inState)) :+
        ( "selection" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_reference_selection_Behavior _,
          ops.ObjectNode_selection)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

  // All parents: {InstanceSpecification, DeployedArtifact, DeploymentTarget, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_InstanceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "classifier" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InstanceSpecification_instanceSpecification_reference_classifier_Classifier _,
          ops.InstanceSpecification_classifier)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {InstanceValue, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_InstanceValue
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "instance" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InstanceValue_instanceValue_reference_instance_InstanceSpecification _,
          ops.InstanceValue_instance)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Interaction, Behavior, InteractionFragment, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Interaction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "postcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_postcondition_Constraint _,
          ops.Behavior_postcondition)) :+
        ( "precondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_precondition_Constraint _,
          ops.Behavior_precondition)) :+
        ( "redefinedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_reference_redefinedBehavior_Behavior _,
          ops.Behavior_redefinedBehavior)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Behavior_method_reference_specification_BehavioralFeature _,
          ops.Behavior_specification)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered)) :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {InteractionConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_InteractionConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "constrainedElement" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Constraint_constraint_reference_constrainedElement_Element _,
          ops.Constraint_constrainedElement)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {InteractionOperand, InteractionFragment, Namespace, NamedElement, Element}
  lazy val metaclass_reference_updater_table_InteractionOperand
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {InteractionUse, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_InteractionUse
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "refersTo" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InteractionUse_interactionUse_reference_refersTo_Interaction _,
          ops.InteractionUse_refersTo)) :+
        ( "returnValueRecipient" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InteractionUse_interactionUse_reference_returnValueRecipient_Property _,
          ops.InteractionUse_returnValueRecipient)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {Interface, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Interface
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "redefinedInterface" -> AssociationMetaPropertySetUpdateInfo(
          links_Interface_interface_reference_redefinedInterface_Interface _,
          ops.Interface_redefinedInterface)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {InterfaceRealization, Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_InterfaceRealization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "contract" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InterfaceRealization_interfaceRealization_reference_contract_Interface _,
          ops.InterfaceRealization_contract)) :+
        ( "client" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_clientDependency_reference_client_NamedElement _,
          ops.Dependency_client)) :+
        ( "supplier" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_supplierDependency_reference_supplier_NamedElement _,
          ops.Dependency_supplier)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {InterruptibleActivityRegion, ActivityGroup, NamedElement, Element}
  lazy val metaclass_reference_updater_table_InterruptibleActivityRegion
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "interruptingEdge" -> AssociationMetaPropertySetUpdateInfo(
          links_InterruptibleActivityRegion_interrupts_reference_interruptingEdge_ActivityEdge _,
          ops.InterruptibleActivityRegion_interruptingEdge)) :+
        ( "node" -> AssociationMetaPropertySetUpdateInfo(
          links_InterruptibleActivityRegion_inInterruptibleRegion_reference_node_ActivityNode _,
          ops.InterruptibleActivityRegion_node))

  // All parents: {Interval, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Interval
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "max" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Interval_interval_reference_max_ValueSpecification _,
          ops.Interval_max)) :+
        ( "min" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Interval_interval_reference_min_ValueSpecification _,
          ops.Interval_min)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {IntervalConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_IntervalConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "constrainedElement" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Constraint_constraint_reference_constrainedElement_Element _,
          ops.Constraint_constrainedElement)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {JoinNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_JoinNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {Lifeline, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Lifeline
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "coveredBy" -> AssociationMetaPropertySetUpdateInfo(
          links_Lifeline_covered_reference_coveredBy_InteractionFragment _,
          ops.Lifeline_coveredBy)) :+
        ( "decomposedAs" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Lifeline_lifeline_reference_decomposedAs_PartDecomposition _,
          ops.Lifeline_decomposedAs)) :+
        ( "represents" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Lifeline_lifeline_reference_represents_ConnectableElement _,
          ops.Lifeline_represents))

  // All parents: {LinkEndCreationData, LinkEndData, Element}
  lazy val metaclass_reference_updater_table_LinkEndCreationData
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "insertAt" -> AssociationMetaPropertyOptionUpdateInfo(
          links_LinkEndCreationData_linkEndCreationData_reference_insertAt_InputPin _,
          ops.LinkEndCreationData_insertAt)) :+
        ( "end" -> AssociationMetaPropertyOptionUpdateInfo(
          links_LinkEndData_linkEndData_reference_end_Property _,
          ops.LinkEndData_end)) :+
        ( "value" -> AssociationMetaPropertyOptionUpdateInfo(
          links_LinkEndData_linkEndData_reference_value_InputPin _,
          ops.LinkEndData_value))

  // All parents: {LinkEndData, Element}
  lazy val metaclass_reference_updater_table_LinkEndData
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "end" -> AssociationMetaPropertyOptionUpdateInfo(
          links_LinkEndData_linkEndData_reference_end_Property _,
          ops.LinkEndData_end)) :+
        ( "value" -> AssociationMetaPropertyOptionUpdateInfo(
          links_LinkEndData_linkEndData_reference_value_InputPin _,
          ops.LinkEndData_value))

  // All parents: {LinkEndDestructionData, LinkEndData, Element}
  lazy val metaclass_reference_updater_table_LinkEndDestructionData
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "destroyAt" -> AssociationMetaPropertyOptionUpdateInfo(
          links_LinkEndDestructionData_linkEndDestructionData_reference_destroyAt_InputPin _,
          ops.LinkEndDestructionData_destroyAt)) :+
        ( "end" -> AssociationMetaPropertyOptionUpdateInfo(
          links_LinkEndData_linkEndData_reference_end_Property _,
          ops.LinkEndData_end)) :+
        ( "value" -> AssociationMetaPropertyOptionUpdateInfo(
          links_LinkEndData_linkEndData_reference_value_InputPin _,
          ops.LinkEndData_value))

  // All parents: {LiteralBoolean, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_LiteralBoolean
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {LiteralInteger, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_LiteralInteger
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {LiteralNull, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_LiteralNull
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {LiteralReal, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_LiteralReal
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {LiteralString, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_LiteralString
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {LiteralUnlimitedNatural, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_LiteralUnlimitedNatural
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {LoopNode, StructuredActivityNode, Action, ActivityGroup, ExecutableNode, Namespace, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_LoopNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "bodyOutput" -> AssociationMetaPropertySequenceUpdateInfo(
          links_LoopNode_loopNode_reference_bodyOutput_OutputPin _,
          ops.LoopNode_bodyOutput)) :+
        ( "bodyPart" -> AssociationMetaPropertySetUpdateInfo(
          links_LoopNode_loopNode_reference_bodyPart_ExecutableNode _,
          ops.LoopNode_bodyPart)) :+
        ( "decider" -> AssociationMetaPropertyOptionUpdateInfo(
          links_LoopNode_loopNode_reference_decider_OutputPin _,
          ops.LoopNode_decider)) :+
        ( "setupPart" -> AssociationMetaPropertySetUpdateInfo(
          links_LoopNode_loopNode_reference_setupPart_ExecutableNode _,
          ops.LoopNode_setupPart)) :+
        ( "test" -> AssociationMetaPropertySetUpdateInfo(
          links_LoopNode_loopNode_reference_test_ExecutableNode _,
          ops.LoopNode_test)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {Manifestation, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Manifestation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "utilizedElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Manifestation_manifestation_reference_utilizedElement_PackageableElement _,
          ops.Manifestation_utilizedElement)) :+
        ( "client" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_clientDependency_reference_client_NamedElement _,
          ops.Dependency_client)) :+
        ( "supplier" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_supplierDependency_reference_supplier_NamedElement _,
          ops.Dependency_supplier)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {MergeNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_MergeNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {Message, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Message
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "connector" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Message_message_reference_connector_Connector _,
          ops.Message_connector)) :+
        ( "receiveEvent" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Message_endMessage_reference_receiveEvent_MessageEnd _,
          ops.Message_receiveEvent)) :+
        ( "sendEvent" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Message_endMessage_reference_sendEvent_MessageEnd _,
          ops.Message_sendEvent)) :+
        ( "signature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Message_message_reference_signature_NamedElement _,
          ops.Message_signature))

  // All parents: {MessageOccurrenceSpecification, MessageEnd, OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_MessageOccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "message" -> AssociationMetaPropertyOptionUpdateInfo(
          links_MessageEnd_messageEnd_reference_message_Message _,
          ops.MessageEnd_message)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_OccurrenceSpecification_events_reference_covered_Lifeline _,
          ops.OccurrenceSpecification_covered)) :+
        ( "toAfter" -> AssociationMetaPropertySetUpdateInfo(
          links_OccurrenceSpecification_before_reference_toAfter_GeneralOrdering _,
          ops.OccurrenceSpecification_toAfter)) :+
        ( "toBefore" -> AssociationMetaPropertySetUpdateInfo(
          links_OccurrenceSpecification_after_reference_toBefore_GeneralOrdering _,
          ops.OccurrenceSpecification_toBefore)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {Model, Package, Namespace, PackageableElement, TemplateableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Model
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Node, Class, DeploymentTarget, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Node
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {ObjectFlow, ActivityEdge, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ObjectFlow
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "selection" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectFlow_objectFlow_reference_selection_Behavior _,
          ops.ObjectFlow_selection)) :+
        ( "transformation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectFlow_objectFlow_reference_transformation_Behavior _,
          ops.ObjectFlow_transformation)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityEdge_edge_reference_inPartition_ActivityPartition _,
          ops.ActivityEdge_inPartition)) :+
        ( "interrupts" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActivityEdge_interruptingEdge_reference_interrupts_InterruptibleActivityRegion _,
          ops.ActivityEdge_interrupts)) :+
        ( "redefinedEdge" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityEdge_activityEdge_reference_redefinedEdge_ActivityEdge _,
          ops.ActivityEdge_redefinedEdge)) :+
        ( "source" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActivityEdge_outgoing_reference_source_ActivityNode _,
          ops.ActivityEdge_source)) :+
        ( "target" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ActivityEdge_incoming_reference_target_ActivityNode _,
          ops.ActivityEdge_target))

  // All parents: {OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_OccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_OccurrenceSpecification_events_reference_covered_Lifeline _,
          ops.OccurrenceSpecification_covered)) :+
        ( "toAfter" -> AssociationMetaPropertySetUpdateInfo(
          links_OccurrenceSpecification_before_reference_toAfter_GeneralOrdering _,
          ops.OccurrenceSpecification_toAfter)) :+
        ( "toBefore" -> AssociationMetaPropertySetUpdateInfo(
          links_OccurrenceSpecification_after_reference_toBefore_GeneralOrdering _,
          ops.OccurrenceSpecification_toBefore)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {OpaqueAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_OpaqueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {OpaqueBehavior, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_OpaqueBehavior
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "postcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_postcondition_Constraint _,
          ops.Behavior_postcondition)) :+
        ( "precondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_precondition_Constraint _,
          ops.Behavior_precondition)) :+
        ( "redefinedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_reference_redefinedBehavior_Behavior _,
          ops.Behavior_redefinedBehavior)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Behavior_method_reference_specification_BehavioralFeature _,
          ops.Behavior_specification)) :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {OpaqueExpression, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_OpaqueExpression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "behavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_OpaqueExpression_opaqueExpression_reference_behavior_Behavior _,
          ops.OpaqueExpression_behavior)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Operation, BehavioralFeature, Feature, ParameterableElement, RedefinableElement, Namespace, TemplateableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Operation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "bodyCondition" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Operation_bodyContext_compose_bodyCondition_Constraint _,
          ops.Operation_bodyCondition)) :+
        ( "postcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Operation_postContext_compose_postcondition_Constraint _,
          ops.Operation_postcondition)) :+
        ( "precondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Operation_preContext_compose_precondition_Constraint _,
          ops.Operation_precondition)) :+
        ( "raisedException" -> AssociationMetaPropertySetUpdateInfo(
          links_Operation_operation_reference_raisedException_Type _,
          ops.Operation_raisedException)) :+
        ( "redefinedOperation" -> AssociationMetaPropertySetUpdateInfo(
          links_Operation_operation_reference_redefinedOperation_Operation _,
          ops.Operation_redefinedOperation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Operation_parameteredElement_reference_templateParameter_OperationTemplateParameter _,
          ops.Operation_templateParameter)) :+
        ( "method" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioralFeature_specification_reference_method_Behavior _,
          ops.BehavioralFeature_method)) :+
        ( "raisedException" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioralFeature_behavioralFeature_reference_raisedException_Type _,
          ops.BehavioralFeature_raisedException)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {OperationTemplateParameter, TemplateParameter, Element}
  lazy val metaclass_reference_updater_table_OperationTemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "parameteredElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_OperationTemplateParameter_templateParameter_reference_parameteredElement_Operation _,
          ops.OperationTemplateParameter_parameteredElement)) :+
        ( "default" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_templateParameter_reference_default_ParameterableElement _,
          ops.TemplateParameter_default)) :+
        ( "parameteredElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_templateParameter_reference_parameteredElement_ParameterableElement _,
          ops.TemplateParameter_parameteredElement))

  // All parents: {OutputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_OutputPin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inState" -> AssociationMetaPropertySetUpdateInfo(
          links_ObjectNode_objectNode_reference_inState_State _,
          ops.ObjectNode_inState)) :+
        ( "selection" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_reference_selection_Behavior _,
          ops.ObjectNode_selection)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

  // All parents: {Package, Namespace, PackageableElement, NamedElement, TemplateableElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Package
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {PackageImport, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_PackageImport
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "importedPackage" -> AssociationMetaPropertyOptionUpdateInfo(
          links_PackageImport_packageImport_reference_importedPackage_Package _,
          ops.PackageImport_importedPackage))

  // All parents: {PackageMerge, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_PackageMerge
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "mergedPackage" -> AssociationMetaPropertyOptionUpdateInfo(
          links_PackageMerge_packageMerge_reference_mergedPackage_Package _,
          ops.PackageMerge_mergedPackage))

  // All parents: {Parameter, ConnectableElement, ParameterableElement, MultiplicityElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Parameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "parameterSet" -> AssociationMetaPropertySetUpdateInfo(
          links_Parameter_parameter_reference_parameterSet_ParameterSet _,
          ops.Parameter_parameterSet)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter _,
          ops.ConnectableElement_templateParameter)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

  // All parents: {ParameterSet, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ParameterSet
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "parameter" -> AssociationMetaPropertySetUpdateInfo(
          links_ParameterSet_parameterSet_reference_parameter_Parameter _,
          ops.ParameterSet_parameter))

  // All parents: {PartDecomposition, InteractionUse, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_PartDecomposition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "refersTo" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InteractionUse_interactionUse_reference_refersTo_Interaction _,
          ops.InteractionUse_refersTo)) :+
        ( "returnValueRecipient" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InteractionUse_interactionUse_reference_returnValueRecipient_Property _,
          ops.InteractionUse_returnValueRecipient)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {Port, Property, ConnectableElement, DeploymentTarget, ParameterableElement, StructuralFeature, Feature, RedefinableElement, MultiplicityElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Port
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "protocol" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Port_port_reference_protocol_ProtocolStateMachine _,
          ops.Port_protocol)) :+
        ( "redefinedPort" -> AssociationMetaPropertySetUpdateInfo(
          links_Port_port_reference_redefinedPort_Port _,
          ops.Port_redefinedPort)) :+
        ( "association" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Property_memberEnd_reference_association_Association _,
          ops.Property_association)) :+
        ( "redefinedProperty" -> AssociationMetaPropertySetUpdateInfo(
          links_Property_property_reference_redefinedProperty_Property _,
          ops.Property_redefinedProperty)) :+
        ( "subsettedProperty" -> AssociationMetaPropertySetUpdateInfo(
          links_Property_property_reference_subsettedProperty_Property _,
          ops.Property_subsettedProperty)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter _,
          ops.ConnectableElement_templateParameter)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

  // All parents: {PrimitiveType, DataType, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_PrimitiveType
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Profile, Package, Namespace, PackageableElement, NamedElement, TemplateableElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Profile
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "metaclassReference" -> AssociationMetaPropertySetUpdateInfo(
          links_Profile_profile_compose_metaclassReference_ElementImport _,
          ops.Profile_metaclassReference)) :+
        ( "metamodelReference" -> AssociationMetaPropertySetUpdateInfo(
          links_Profile_profile_compose_metamodelReference_PackageImport _,
          ops.Profile_metamodelReference)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {ProfileApplication, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_ProfileApplication
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "appliedProfile" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ProfileApplication_profileApplication_reference_appliedProfile_Profile _,
          ops.ProfileApplication_appliedProfile))

  // All parents: {Property, ConnectableElement, ParameterableElement, DeploymentTarget, StructuralFeature, Feature, MultiplicityElement, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Property
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "association" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Property_memberEnd_reference_association_Association _,
          ops.Property_association)) :+
        ( "redefinedProperty" -> AssociationMetaPropertySetUpdateInfo(
          links_Property_property_reference_redefinedProperty_Property _,
          ops.Property_redefinedProperty)) :+
        ( "subsettedProperty" -> AssociationMetaPropertySetUpdateInfo(
          links_Property_property_reference_subsettedProperty_Property _,
          ops.Property_subsettedProperty)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter _,
          ops.ConnectableElement_templateParameter)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

  // All parents: {ProtocolConformance, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_ProtocolConformance
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "generalMachine" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ProtocolConformance_protocolConformance_reference_generalMachine_ProtocolStateMachine _,
          ops.ProtocolConformance_generalMachine))

  // All parents: {ProtocolStateMachine, StateMachine, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_ProtocolStateMachine
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "extendedStateMachine" -> AssociationMetaPropertySetUpdateInfo(
          links_StateMachine_stateMachine_reference_extendedStateMachine_StateMachine _,
          ops.StateMachine_extendedStateMachine)) :+
        ( "submachineState" -> AssociationMetaPropertySetUpdateInfo(
          links_StateMachine_submachine_reference_submachineState_State _,
          ops.StateMachine_submachineState)) :+
        ( "postcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_postcondition_Constraint _,
          ops.Behavior_postcondition)) :+
        ( "precondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_precondition_Constraint _,
          ops.Behavior_precondition)) :+
        ( "redefinedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_reference_redefinedBehavior_Behavior _,
          ops.Behavior_redefinedBehavior)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Behavior_method_reference_specification_BehavioralFeature _,
          ops.Behavior_specification)) :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {ProtocolTransition, Transition, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ProtocolTransition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "postCondition" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ProtocolTransition_owningTransition_compose_postCondition_Constraint _,
          ops.ProtocolTransition_postCondition)) :+
        ( "guard" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Transition_transition_compose_guard_Constraint _,
          ops.Transition_guard)) :+
        ( "redefinedTransition" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Transition_transition_reference_redefinedTransition_Transition _,
          ops.Transition_redefinedTransition)) :+
        ( "source" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Transition_outgoing_reference_source_Vertex _,
          ops.Transition_source)) :+
        ( "target" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Transition_incoming_reference_target_Vertex _,
          ops.Transition_target))

  // All parents: {Pseudostate, Vertex, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Pseudostate
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]()

  // All parents: {QualifierValue, Element}
  lazy val metaclass_reference_updater_table_QualifierValue
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "qualifier" -> AssociationMetaPropertyOptionUpdateInfo(
          links_QualifierValue_qualifierValue_reference_qualifier_Property _,
          ops.QualifierValue_qualifier)) :+
        ( "value" -> AssociationMetaPropertyOptionUpdateInfo(
          links_QualifierValue_qualifierValue_reference_value_InputPin _,
          ops.QualifierValue_value))

  // All parents: {RaiseExceptionAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_RaiseExceptionAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ReadExtentAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadExtentAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "classifier" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadExtentAction_readExtentAction_reference_classifier_Classifier _,
          ops.ReadExtentAction_classifier)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ReadIsClassifiedObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadIsClassifiedObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "classifier" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_reference_classifier_Classifier _,
          ops.ReadIsClassifiedObjectAction_classifier)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ReadLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadLinkAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ReadLinkObjectEndAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadLinkObjectEndAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "end" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadLinkObjectEndAction_readLinkObjectEndAction_reference_end_Property _,
          ops.ReadLinkObjectEndAction_end)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ReadLinkObjectEndQualifierAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadLinkObjectEndQualifierAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "qualifier" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_reference_qualifier_Property _,
          ops.ReadLinkObjectEndQualifierAction_qualifier)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ReadSelfAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadSelfAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ReadStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadStructuralFeatureAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "structuralFeature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_StructuralFeatureAction_structuralFeatureAction_reference_structuralFeature_StructuralFeature _,
          ops.StructuralFeatureAction_structuralFeature)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ReadVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadVariableAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "variable" -> AssociationMetaPropertyOptionUpdateInfo(
          links_VariableAction_variableAction_reference_variable_Variable _,
          ops.VariableAction_variable)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {Realization, Abstraction, Dependency, DirectedRelationship, PackageableElement, Relationship, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Realization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "client" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_clientDependency_reference_client_NamedElement _,
          ops.Dependency_client)) :+
        ( "supplier" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_supplierDependency_reference_supplier_NamedElement _,
          ops.Dependency_supplier)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Reception, BehavioralFeature, Feature, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Reception
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "signal" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Reception_reception_reference_signal_Signal _,
          ops.Reception_signal)) :+
        ( "method" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioralFeature_specification_reference_method_Behavior _,
          ops.BehavioralFeature_method)) :+
        ( "raisedException" -> AssociationMetaPropertySetUpdateInfo(
          links_BehavioralFeature_behavioralFeature_reference_raisedException_Type _,
          ops.BehavioralFeature_raisedException))

  // All parents: {ReclassifyObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReclassifyObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "newClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_ReclassifyObjectAction_reclassifyObjectAction_reference_newClassifier_Classifier _,
          ops.ReclassifyObjectAction_newClassifier)) :+
        ( "oldClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_ReclassifyObjectAction_reclassifyObjectAction_reference_oldClassifier_Classifier _,
          ops.ReclassifyObjectAction_oldClassifier)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {RedefinableTemplateSignature, RedefinableElement, TemplateSignature, NamedElement, Element}
  lazy val metaclass_reference_updater_table_RedefinableTemplateSignature
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "extendedSignature" -> AssociationMetaPropertySetUpdateInfo(
          links_RedefinableTemplateSignature_redefinableTemplateSignature_reference_extendedSignature_RedefinableTemplateSignature _,
          ops.RedefinableTemplateSignature_extendedSignature)) :+
        ( "parameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_TemplateSignature_templateSignature_reference_parameter_TemplateParameter _,
          ops.TemplateSignature_parameter))

  // All parents: {ReduceAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReduceAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "reducer" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReduceAction_reduceAction_reference_reducer_Behavior _,
          ops.ReduceAction_reducer)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {Region, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Region
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "extendedRegion" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Region_region_reference_extendedRegion_Region _,
          ops.Region_extendedRegion))

  // All parents: {RemoveStructuralFeatureValueAction, WriteStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_RemoveStructuralFeatureValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "structuralFeature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_StructuralFeatureAction_structuralFeatureAction_reference_structuralFeature_StructuralFeature _,
          ops.StructuralFeatureAction_structuralFeature)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {RemoveVariableValueAction, WriteVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_RemoveVariableValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "variable" -> AssociationMetaPropertyOptionUpdateInfo(
          links_VariableAction_variableAction_reference_variable_Variable _,
          ops.VariableAction_variable)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {ReplyAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReplyAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "replyToCall" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ReplyAction_replyAction_reference_replyToCall_Trigger _,
          ops.ReplyAction_replyToCall)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {SendObjectAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_SendObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "onPort" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InvocationAction_invocationAction_reference_onPort_Port _,
          ops.InvocationAction_onPort)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {SendSignalAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_SendSignalAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "signal" -> AssociationMetaPropertyOptionUpdateInfo(
          links_SendSignalAction_sendSignalAction_reference_signal_Signal _,
          ops.SendSignalAction_signal)) :+
        ( "onPort" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InvocationAction_invocationAction_reference_onPort_Port _,
          ops.InvocationAction_onPort)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {SequenceNode, StructuredActivityNode, Action, ActivityGroup, ExecutableNode, Namespace, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_SequenceNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {Signal, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Signal
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {SignalEvent, MessageEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_SignalEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "signal" -> AssociationMetaPropertyOptionUpdateInfo(
          links_SignalEvent_signalEvent_reference_signal_Signal _,
          ops.SignalEvent_signal)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Slot, Element}
  lazy val metaclass_reference_updater_table_Slot
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "definingFeature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Slot_slot_reference_definingFeature_StructuralFeature _,
          ops.Slot_definingFeature))

  // All parents: {StartClassifierBehaviorAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_StartClassifierBehaviorAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {StartObjectBehaviorAction, CallAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_StartObjectBehaviorAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "onPort" -> AssociationMetaPropertyOptionUpdateInfo(
          links_InvocationAction_invocationAction_reference_onPort_Port _,
          ops.InvocationAction_onPort)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {State, Namespace, RedefinableElement, Vertex, NamedElement, Element}
  lazy val metaclass_reference_updater_table_State
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "redefinedState" -> AssociationMetaPropertyOptionUpdateInfo(
          links_State_state_reference_redefinedState_State _,
          ops.State_redefinedState)) :+
        ( "stateInvariant" -> AssociationMetaPropertyOptionUpdateInfo(
          links_State_owningState_compose_stateInvariant_Constraint _,
          ops.State_stateInvariant)) :+
        ( "submachine" -> AssociationMetaPropertyOptionUpdateInfo(
          links_State_submachineState_reference_submachine_StateMachine _,
          ops.State_submachine))

  // All parents: {StateInvariant, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_StateInvariant
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_StateInvariant_stateInvariant_reference_covered_Lifeline _,
          ops.StateInvariant_covered)) :+
        ( "covered" -> AssociationMetaPropertyIterableUpdateInfo(
          links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
          ops.InteractionFragment_covered))

  // All parents: {StateMachine, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_StateMachine
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "extendedStateMachine" -> AssociationMetaPropertySetUpdateInfo(
          links_StateMachine_stateMachine_reference_extendedStateMachine_StateMachine _,
          ops.StateMachine_extendedStateMachine)) :+
        ( "submachineState" -> AssociationMetaPropertySetUpdateInfo(
          links_StateMachine_submachine_reference_submachineState_State _,
          ops.StateMachine_submachineState)) :+
        ( "postcondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_postcondition_Constraint _,
          ops.Behavior_postcondition)) :+
        ( "precondition" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_compose_precondition_Constraint _,
          ops.Behavior_precondition)) :+
        ( "redefinedBehavior" -> AssociationMetaPropertySetUpdateInfo(
          links_Behavior_behavior_reference_redefinedBehavior_Behavior _,
          ops.Behavior_redefinedBehavior)) :+
        ( "specification" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Behavior_method_reference_specification_BehavioralFeature _,
          ops.Behavior_specification)) :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Stereotype, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Stereotype
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {StringExpression, Expression, TemplateableElement, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_StringExpression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {StructuredActivityNode, Action, ActivityGroup, ExecutableNode, Namespace, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_StructuredActivityNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {Substitution, Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Substitution
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "contract" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Substitution_substitution_reference_contract_Classifier _,
          ops.Substitution_contract)) :+
        ( "client" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_clientDependency_reference_client_NamedElement _,
          ops.Dependency_client)) :+
        ( "supplier" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_supplierDependency_reference_supplier_NamedElement _,
          ops.Dependency_supplier)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {TemplateBinding, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_TemplateBinding
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "signature" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateBinding_templateBinding_reference_signature_TemplateSignature _,
          ops.TemplateBinding_signature))

  // All parents: {TemplateParameter, Element}
  lazy val metaclass_reference_updater_table_TemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "default" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_templateParameter_reference_default_ParameterableElement _,
          ops.TemplateParameter_default)) :+
        ( "parameteredElement" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameter_templateParameter_reference_parameteredElement_ParameterableElement _,
          ops.TemplateParameter_parameteredElement))

  // All parents: {TemplateParameterSubstitution, Element}
  lazy val metaclass_reference_updater_table_TemplateParameterSubstitution
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "actual" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameterSubstitution_templateParameterSubstitution_reference_actual_ParameterableElement _,
          ops.TemplateParameterSubstitution_actual)) :+
        ( "formal" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TemplateParameterSubstitution_templateParameterSubstitution_reference_formal_TemplateParameter _,
          ops.TemplateParameterSubstitution_formal))

  // All parents: {TemplateSignature, Element}
  lazy val metaclass_reference_updater_table_TemplateSignature
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "parameter" -> AssociationMetaPropertySequenceUpdateInfo(
          links_TemplateSignature_templateSignature_reference_parameter_TemplateParameter _,
          ops.TemplateSignature_parameter))

  // All parents: {TestIdentityAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_TestIdentityAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {TimeConstraint, IntervalConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_TimeConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "constrainedElement" -> AssociationMetaPropertySequenceUpdateInfo(
          links_Constraint_constraint_reference_constrainedElement_Element _,
          ops.Constraint_constrainedElement)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {TimeEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_TimeEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {TimeExpression, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_TimeExpression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "observation" -> AssociationMetaPropertySetUpdateInfo(
          links_TimeExpression_timeExpression_reference_observation_Observation _,
          ops.TimeExpression_observation)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {TimeInterval, Interval, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_TimeInterval
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "max" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TimeInterval_timeInterval_reference_max_TimeExpression _,
          ops.TimeInterval_max)) :+
        ( "min" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TimeInterval_timeInterval_reference_min_TimeExpression _,
          ops.TimeInterval_min)) :+
        ( "max" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Interval_interval_reference_max_ValueSpecification _,
          ops.Interval_max)) :+
        ( "min" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Interval_interval_reference_min_ValueSpecification _,
          ops.Interval_min)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {TimeObservation, Observation, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_TimeObservation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "event" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TimeObservation_timeObservation_reference_event_NamedElement _,
          ops.TimeObservation_event)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {Transition, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Transition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "guard" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Transition_transition_compose_guard_Constraint _,
          ops.Transition_guard)) :+
        ( "redefinedTransition" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Transition_transition_reference_redefinedTransition_Transition _,
          ops.Transition_redefinedTransition)) :+
        ( "source" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Transition_outgoing_reference_source_Vertex _,
          ops.Transition_source)) :+
        ( "target" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Transition_incoming_reference_target_Vertex _,
          ops.Transition_target))

  // All parents: {Trigger, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Trigger
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "event" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Trigger_trigger_reference_event_Event _,
          ops.Trigger_event)) :+
        ( "port" -> AssociationMetaPropertySetUpdateInfo(
          links_Trigger_trigger_reference_port_Port _,
          ops.Trigger_port))

  // All parents: {UnmarshallAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_UnmarshallAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "unmarshallType" -> AssociationMetaPropertyOptionUpdateInfo(
          links_UnmarshallAction_unmarshallAction_reference_unmarshallType_Classifier _,
          ops.UnmarshallAction_unmarshallType)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {Usage, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Usage
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "client" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_clientDependency_reference_client_NamedElement _,
          ops.Dependency_client)) :+
        ( "supplier" -> AssociationMetaPropertySetUpdateInfo(
          links_Dependency_supplierDependency_reference_supplier_NamedElement _,
          ops.Dependency_supplier)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {UseCase, BehavioredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_UseCase
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "subject" -> AssociationMetaPropertySetUpdateInfo(
          links_UseCase_useCase_reference_subject_Classifier _,
          ops.UseCase_subject)) :+
        ( "classifierBehavior" -> AssociationMetaPropertyOptionUpdateInfo(
          links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
          ops.BehavioredClassifier_classifierBehavior)) :+
        ( "powertypeExtent" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
          ops.Classifier_powertypeExtent)) :+
        ( "redefinedClassifier" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
          ops.Classifier_redefinedClassifier)) :+
        ( "representation" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_classifier_reference_representation_CollaborationUse _,
          ops.Classifier_representation)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
          ops.Classifier_templateParameter)) :+
        ( "useCase" -> AssociationMetaPropertySetUpdateInfo(
          links_Classifier_subject_reference_useCase_UseCase _,
          ops.Classifier_useCase)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter))

  // All parents: {ValuePin, InputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ValuePin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inState" -> AssociationMetaPropertySetUpdateInfo(
          links_ObjectNode_objectNode_reference_inState_State _,
          ops.ObjectNode_inState)) :+
        ( "selection" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ObjectNode_objectNode_reference_selection_Behavior _,
          ops.ObjectNode_selection)) :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

  // All parents: {ValueSpecificationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ValueSpecificationAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "inInterruptibleRegion" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
          ops.ActivityNode_inInterruptibleRegion)) :+
        ( "inPartition" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_node_reference_inPartition_ActivityPartition _,
          ops.ActivityNode_inPartition)) :+
        ( "incoming" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_target_reference_incoming_ActivityEdge _,
          ops.ActivityNode_incoming)) :+
        ( "outgoing" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_source_reference_outgoing_ActivityEdge _,
          ops.ActivityNode_outgoing)) :+
        ( "redefinedNode" -> AssociationMetaPropertySetUpdateInfo(
          links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
          ops.ActivityNode_redefinedNode))

  // All parents: {Variable, ConnectableElement, ParameterableElement, MultiplicityElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Variable
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter _,
          ops.ConnectableElement_templateParameter)) :+
        ( "templateParameter" -> AssociationMetaPropertyOptionUpdateInfo(
          links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
          ops.ParameterableElement_templateParameter)) :+
        ( "type" -> AssociationMetaPropertyOptionUpdateInfo(
          links_TypedElement_typedElement_reference_type_Type _,
          ops.TypedElement_type))

	// Start of user code for additional features
	// End of user code
}
