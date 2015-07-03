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
package org.omg.oti.uml.write.api

// Start of user code for imports
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.util.Try
// End of user code

/**
 * <!-- Start of user code documentation -->
 * There are 5 kinds of update methods:
 * 1) creating/deleting link instances of a composite association
 * 2) creating/deleting link instances of a reference association
 * 3) setting/clearing the value of a DataType metaclass property
 *
 * Unfortunately, the names of UML associations is not necessarily consistent with that of the association ends.
 * Differences include:
 * - ordering (e.g., an association from end1 to end2 is sometimes named A_end1_end2 or A_end2_end1)
 * - redefinitions (e.g., there would be name conflicts if the association were to be named according to
 *   the names of its member ends so the association name is different)
 *
 * To avoid these problems and make the API more "litterate", the naming scheme is:
 *
 * For (1)
 * link_<metaclass1>_<end1>_composes_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2TypeOrCollection>): Try[Unit]
 *
 * For (3)
 * link_<metaclass1>_<end1>_references_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2TypeOrCollection>): Try[Unit]
 *
 * This is done for all non-derived, non-abstract associations whose member ends have each an upper bound > 0
 *
 * The pattern for (5) is:
 *
 * set_<metaclass>_<dataProperty>
 *   (e: <metaclass>, value: <dataPropertyTypeOrCollection>): Try[Unit]
 *
 * <!-- End of user code documentation -->
 */
trait UMLUpdate[Uml <: UML] {
  implicit val ops: UMLOps[Uml]

  // Abstraction

  def link_Abstraction_abstraction_composes_mapping_OpaqueExpression
  (from: UMLAbstraction[Uml],
   to: Option[UMLOpaqueExpression[Uml]]): Try[Unit]

  // AcceptCallAction

  def link_AcceptCallAction_acceptCallAction_composes_returnInformation_OutputPin
  (from: UMLAcceptCallAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  // AcceptEventAction

  def link_AcceptEventAction_acceptEventAction_composes_result_OutputPin
  (from: UMLAcceptEventAction[Uml],
   to: Seq[UMLOutputPin[Uml]]): Try[Unit]

  def link_AcceptEventAction_acceptEventAction_composes_trigger_Trigger
  (from: UMLAcceptEventAction[Uml],
   to: Set[UMLTrigger[Uml]]): Try[Unit]

  def set_AcceptEventAction_isUnmarshall
  (e: UMLAcceptEventAction[Uml], isUnmarshall: Boolean): Try[Unit]

  // Action

  def link_Action_action_composes_localPostcondition_Constraint
  (from: UMLAction[Uml],
   to: Set[UMLConstraint[Uml]]): Try[Unit]

  def link_Action_action_composes_localPrecondition_Constraint
  (from: UMLAction[Uml],
   to: Set[UMLConstraint[Uml]]): Try[Unit]

  def set_Action_isLocallyReentrant
  (e: UMLAction[Uml], isLocallyReentrant: Boolean): Try[Unit]

  // ActionExecutionSpecification

  def link_ActionExecutionSpecification_actionExecutionSpecification_references_action_Action
  (from: UMLActionExecutionSpecification[Uml],
   to: Option[UMLAction[Uml]]): Try[Unit]

  // ActionInputPin

  def link_ActionInputPin_actionInputPin_composes_fromAction_Action
  (from: UMLActionInputPin[Uml],
   to: Option[UMLAction[Uml]]): Try[Unit]

  // Activity

  def link_Activity_activity_composes_edge_ActivityEdge
  (from: UMLActivity[Uml],
   to: Set[UMLActivityEdge[Uml]]): Try[Unit]

  def link_Activity_inActivity_composes_group_ActivityGroup
  (from: UMLActivity[Uml],
   to: Set[UMLActivityGroup[Uml]]): Try[Unit]

  def link_Activity_activity_composes_node_ActivityNode
  (from: UMLActivity[Uml],
   to: Set[UMLActivityNode[Uml]]): Try[Unit]

  def link_Activity_activity_references_partition_ActivityPartition
  (from: UMLActivity[Uml],
   to: Set[UMLActivityPartition[Uml]]): Try[Unit]

  def link_Activity_activity_composes_structuredNode_StructuredActivityNode
  (from: UMLActivity[Uml],
   to: Set[UMLStructuredActivityNode[Uml]]): Try[Unit]

  def link_Activity_activityScope_composes_variable_Variable
  (from: UMLActivity[Uml],
   to: Set[UMLVariable[Uml]]): Try[Unit]

  def set_Activity_isReadOnly
  (e: UMLActivity[Uml], isReadOnly: Boolean): Try[Unit]

  def set_Activity_isSingleExecution
  (e: UMLActivity[Uml], isSingleExecution: Boolean): Try[Unit]

  // ActivityEdge

  def link_ActivityEdge_edge_references_activity_Activity
  (from: UMLActivityEdge[Uml],
   to: Option[UMLActivity[Uml]]): Try[Unit]

  def link_ActivityEdge_activityEdge_composes_guard_ValueSpecification
  (from: UMLActivityEdge[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  def link_ActivityEdge_edge_references_inPartition_ActivityPartition
  (from: UMLActivityEdge[Uml],
   to: Set[UMLActivityPartition[Uml]]): Try[Unit]

  def link_ActivityEdge_edge_references_inStructuredNode_StructuredActivityNode
  (from: UMLActivityEdge[Uml],
   to: Option[UMLStructuredActivityNode[Uml]]): Try[Unit]

  def link_ActivityEdge_interruptingEdge_references_interrupts_InterruptibleActivityRegion
  (from: UMLActivityEdge[Uml],
   to: Option[UMLInterruptibleActivityRegion[Uml]]): Try[Unit]

  def link_ActivityEdge_activityEdge_references_redefinedEdge_ActivityEdge
  (from: UMLActivityEdge[Uml],
   to: Set[UMLActivityEdge[Uml]]): Try[Unit]

  def link_ActivityEdge_outgoing_references_source_ActivityNode
  (from: UMLActivityEdge[Uml],
   to: Option[UMLActivityNode[Uml]]): Try[Unit]

  def link_ActivityEdge_incoming_references_target_ActivityNode
  (from: UMLActivityEdge[Uml],
   to: Option[UMLActivityNode[Uml]]): Try[Unit]

  def link_ActivityEdge_activityEdge_composes_weight_ValueSpecification
  (from: UMLActivityEdge[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  // ActivityFinalNode


  // ActivityGroup

  def link_ActivityGroup_group_references_inActivity_Activity
  (from: UMLActivityGroup[Uml],
   to: Option[UMLActivity[Uml]]): Try[Unit]

  // ActivityNode

  def link_ActivityNode_node_references_activity_Activity
  (from: UMLActivityNode[Uml],
   to: Option[UMLActivity[Uml]]): Try[Unit]

  def link_ActivityNode_node_references_inInterruptibleRegion_InterruptibleActivityRegion
  (from: UMLActivityNode[Uml],
   to: Set[UMLInterruptibleActivityRegion[Uml]]): Try[Unit]

  def link_ActivityNode_node_references_inPartition_ActivityPartition
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityPartition[Uml]]): Try[Unit]

  def link_ActivityNode_node_references_inStructuredNode_StructuredActivityNode
  (from: UMLActivityNode[Uml],
   to: Option[UMLStructuredActivityNode[Uml]]): Try[Unit]

  def link_ActivityNode_target_references_incoming_ActivityEdge
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityEdge[Uml]]): Try[Unit]

  def link_ActivityNode_source_references_outgoing_ActivityEdge
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityEdge[Uml]]): Try[Unit]

  def link_ActivityNode_activityNode_references_redefinedNode_ActivityNode
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityNode[Uml]]): Try[Unit]

  // ActivityParameterNode

  def link_ActivityParameterNode_activityParameterNode_references_parameter_Parameter
  (from: UMLActivityParameterNode[Uml],
   to: Option[UMLParameter[Uml]]): Try[Unit]

  // ActivityPartition

  def link_ActivityPartition_inPartition_references_edge_ActivityEdge
  (from: UMLActivityPartition[Uml],
   to: Set[UMLActivityEdge[Uml]]): Try[Unit]

  def link_ActivityPartition_inPartition_references_node_ActivityNode
  (from: UMLActivityPartition[Uml],
   to: Set[UMLActivityNode[Uml]]): Try[Unit]

  def link_ActivityPartition_activityPartition_references_represents_Element
  (from: UMLActivityPartition[Uml],
   to: Option[UMLElement[Uml]]): Try[Unit]

  def link_ActivityPartition_superPartition_composes_subpartition_ActivityPartition
  (from: UMLActivityPartition[Uml],
   to: Set[UMLActivityPartition[Uml]]): Try[Unit]

  def link_ActivityPartition_subpartition_references_superPartition_ActivityPartition
  (from: UMLActivityPartition[Uml],
   to: Option[UMLActivityPartition[Uml]]): Try[Unit]

  def set_ActivityPartition_isDimension
  (e: UMLActivityPartition[Uml], isDimension: Boolean): Try[Unit]

  def set_ActivityPartition_isExternal
  (e: UMLActivityPartition[Uml], isExternal: Boolean): Try[Unit]

  // Actor


  // AddStructuralFeatureValueAction

  def link_AddStructuralFeatureValueAction_addStructuralFeatureValueAction_composes_insertAt_InputPin
  (from: UMLAddStructuralFeatureValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def set_AddStructuralFeatureValueAction_isReplaceAll
  (e: UMLAddStructuralFeatureValueAction[Uml], isReplaceAll: Boolean): Try[Unit]

  // AddVariableValueAction

  def link_AddVariableValueAction_addVariableValueAction_composes_insertAt_InputPin
  (from: UMLAddVariableValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def set_AddVariableValueAction_isReplaceAll
  (e: UMLAddVariableValueAction[Uml], isReplaceAll: Boolean): Try[Unit]

  // AnyReceiveEvent


  // Artifact

  def link_Artifact_artifact_composes_manifestation_Manifestation
  (from: UMLArtifact[Uml],
   to: Set[UMLManifestation[Uml]]): Try[Unit]

  def link_Artifact_artifact_composes_nestedArtifact_Artifact
  (from: UMLArtifact[Uml],
   to: Set[UMLArtifact[Uml]]): Try[Unit]

  def link_Artifact_artifact_composes_ownedAttribute_Property
  (from: UMLArtifact[Uml],
   to: Seq[UMLProperty[Uml]]): Try[Unit]

  def link_Artifact_artifact_composes_ownedOperation_Operation
  (from: UMLArtifact[Uml],
   to: Seq[UMLOperation[Uml]]): Try[Unit]

  def set_Artifact_fileName
  (e: UMLArtifact[Uml], fileName: Option[String]): Try[Unit]

  // Association

  def link_Association_association_references_memberEnd_Property
  (from: UMLAssociation[Uml],
   to: Seq[UMLProperty[Uml]]): Try[Unit]

  def link_Association_association_references_navigableOwnedEnd_Property
  (from: UMLAssociation[Uml],
   to: Set[UMLProperty[Uml]]): Try[Unit]

  def link_Association_owningAssociation_composes_ownedEnd_Property
  (from: UMLAssociation[Uml],
   to: Iterable[UMLProperty[Uml]]): Try[Unit]

  def set_Association_isDerived
  (e: UMLAssociation[Uml], isDerived: Boolean): Try[Unit]

  // AssociationClass


  // Behavior

  def link_Behavior_behavior_composes_ownedParameter_Parameter
  (from: UMLBehavior[Uml],
   to: Seq[UMLParameter[Uml]]): Try[Unit]

  def link_Behavior_behavior_composes_ownedParameterSet_ParameterSet
  (from: UMLBehavior[Uml],
   to: Set[UMLParameterSet[Uml]]): Try[Unit]

  def link_Behavior_behavior_composes_postcondition_Constraint
  (from: UMLBehavior[Uml],
   to: Set[UMLConstraint[Uml]]): Try[Unit]

  def link_Behavior_behavior_composes_precondition_Constraint
  (from: UMLBehavior[Uml],
   to: Set[UMLConstraint[Uml]]): Try[Unit]

  def link_Behavior_behavior_references_redefinedBehavior_Behavior
  (from: UMLBehavior[Uml],
   to: Set[UMLBehavior[Uml]]): Try[Unit]

  def link_Behavior_method_references_specification_BehavioralFeature
  (from: UMLBehavior[Uml],
   to: Option[UMLBehavioralFeature[Uml]]): Try[Unit]

  def set_Behavior_isReentrant
  (e: UMLBehavior[Uml], isReentrant: Boolean): Try[Unit]

  // BehaviorExecutionSpecification

  def link_BehaviorExecutionSpecification_behaviorExecutionSpecification_references_behavior_Behavior
  (from: UMLBehaviorExecutionSpecification[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  // BehavioralFeature

  def link_BehavioralFeature_specification_references_method_Behavior
  (from: UMLBehavioralFeature[Uml],
   to: Set[UMLBehavior[Uml]]): Try[Unit]

  def link_BehavioralFeature_ownerFormalParam_composes_ownedParameter_Parameter
  (from: UMLBehavioralFeature[Uml],
   to: Seq[UMLParameter[Uml]]): Try[Unit]

  def link_BehavioralFeature_behavioralFeature_composes_ownedParameterSet_ParameterSet
  (from: UMLBehavioralFeature[Uml],
   to: Set[UMLParameterSet[Uml]]): Try[Unit]

  def link_BehavioralFeature_behavioralFeature_references_raisedException_Type
  (from: UMLBehavioralFeature[Uml],
   to: Set[UMLType[Uml]]): Try[Unit]

  def set_BehavioralFeature_concurrency
  (e: UMLBehavioralFeature[Uml], concurrency: UMLCallConcurrencyKind.Value): Try[Unit]

  def set_BehavioralFeature_isAbstract
  (e: UMLBehavioralFeature[Uml], isAbstract: Boolean): Try[Unit]

  // BehavioredClassifier

  def link_BehavioredClassifier_behavioredClassifier_references_classifierBehavior_Behavior
  (from: UMLBehavioredClassifier[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  def link_BehavioredClassifier_implementingClassifier_composes_interfaceRealization_InterfaceRealization
  (from: UMLBehavioredClassifier[Uml],
   to: Set[UMLInterfaceRealization[Uml]]): Try[Unit]

  def link_BehavioredClassifier_behavioredClassifier_composes_ownedBehavior_Behavior
  (from: UMLBehavioredClassifier[Uml],
   to: Set[UMLBehavior[Uml]]): Try[Unit]

  // BroadcastSignalAction

  def link_BroadcastSignalAction_broadcastSignalAction_references_signal_Signal
  (from: UMLBroadcastSignalAction[Uml],
   to: Option[UMLSignal[Uml]]): Try[Unit]

  // CallAction

  def link_CallAction_callAction_composes_result_OutputPin
  (from: UMLCallAction[Uml],
   to: Seq[UMLOutputPin[Uml]]): Try[Unit]

  def set_CallAction_isSynchronous
  (e: UMLCallAction[Uml], isSynchronous: Boolean): Try[Unit]

  // CallBehaviorAction

  def link_CallBehaviorAction_callBehaviorAction_references_behavior_Behavior
  (from: UMLCallBehaviorAction[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  // CallEvent

  def link_CallEvent_callEvent_references_operation_Operation
  (from: UMLCallEvent[Uml],
   to: Option[UMLOperation[Uml]]): Try[Unit]

  // CallOperationAction

  def link_CallOperationAction_callOperationAction_references_operation_Operation
  (from: UMLCallOperationAction[Uml],
   to: Option[UMLOperation[Uml]]): Try[Unit]

  def link_CallOperationAction_callOperationAction_composes_target_InputPin
  (from: UMLCallOperationAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // CentralBufferNode


  // ChangeEvent

  def link_ChangeEvent_changeEvent_composes_changeExpression_ValueSpecification
  (from: UMLChangeEvent[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  // Class

  def link_Class_nestingClass_composes_nestedClassifier_Classifier
  (from: UMLClass[Uml],
   to: Seq[UMLClassifier[Uml]]): Try[Unit]

  def link_Class_class_composes_ownedAttribute_Property
  (from: UMLClass[Uml],
   to: Seq[UMLProperty[Uml]]): Try[Unit]

  def link_Class_class_composes_ownedOperation_Operation
  (from: UMLClass[Uml],
   to: Seq[UMLOperation[Uml]]): Try[Unit]

  def link_Class_class_composes_ownedReception_Reception
  (from: UMLClass[Uml],
   to: Set[UMLReception[Uml]]): Try[Unit]

  def set_Class_isAbstract
  (e: UMLClass[Uml], isAbstract: Boolean): Try[Unit]

  def set_Class_isActive
  (e: UMLClass[Uml], isActive: Boolean): Try[Unit]

  // Classifier

  def link_Classifier_classifier_composes_collaborationUse_CollaborationUse
  (from: UMLClassifier[Uml],
   to: Set[UMLCollaborationUse[Uml]]): Try[Unit]

  def link_Classifier_specific_composes_generalization_Generalization
  (from: UMLClassifier[Uml],
   to: Set[UMLGeneralization[Uml]]): Try[Unit]

  def link_Classifier_classifier_composes_ownedTemplateSignature_RedefinableTemplateSignature
  (from: UMLClassifier[Uml],
   to: Option[UMLRedefinableTemplateSignature[Uml]]): Try[Unit]

  def link_Classifier_classifier_composes_ownedUseCase_UseCase
  (from: UMLClassifier[Uml],
   to: Set[UMLUseCase[Uml]]): Try[Unit]

  def link_Classifier_powertype_references_powertypeExtent_GeneralizationSet
  (from: UMLClassifier[Uml],
   to: Set[UMLGeneralizationSet[Uml]]): Try[Unit]

  def link_Classifier_classifier_references_redefinedClassifier_Classifier
  (from: UMLClassifier[Uml],
   to: Set[UMLClassifier[Uml]]): Try[Unit]

  def link_Classifier_classifier_references_representation_CollaborationUse
  (from: UMLClassifier[Uml],
   to: Option[UMLCollaborationUse[Uml]]): Try[Unit]

  def link_Classifier_substitutingClassifier_composes_substitution_Substitution
  (from: UMLClassifier[Uml],
   to: Set[UMLSubstitution[Uml]]): Try[Unit]

  def link_Classifier_parameteredElement_references_templateParameter_ClassifierTemplateParameter
  (from: UMLClassifier[Uml],
   to: Option[UMLClassifierTemplateParameter[Uml]]): Try[Unit]

  def link_Classifier_subject_references_useCase_UseCase
  (from: UMLClassifier[Uml],
   to: Set[UMLUseCase[Uml]]): Try[Unit]

  def set_Classifier_isAbstract
  (e: UMLClassifier[Uml], isAbstract: Boolean): Try[Unit]

  def set_Classifier_isFinalSpecialization
  (e: UMLClassifier[Uml], isFinalSpecialization: Boolean): Try[Unit]

  // ClassifierTemplateParameter

  def link_ClassifierTemplateParameter_classifierTemplateParameter_references_constrainingClassifier_Classifier
  (from: UMLClassifierTemplateParameter[Uml],
   to: Set[UMLClassifier[Uml]]): Try[Unit]

  def link_ClassifierTemplateParameter_templateParameter_references_parameteredElement_Classifier
  (from: UMLClassifierTemplateParameter[Uml],
   to: Option[UMLClassifier[Uml]]): Try[Unit]

  def set_ClassifierTemplateParameter_allowSubstitutable
  (e: UMLClassifierTemplateParameter[Uml], allowSubstitutable: Boolean): Try[Unit]

  // Clause

  def link_Clause_clause_references_body_ExecutableNode
  (from: UMLClause[Uml],
   to: Set[UMLExecutableNode[Uml]]): Try[Unit]

  def link_Clause_clause_references_bodyOutput_OutputPin
  (from: UMLClause[Uml],
   to: Seq[UMLOutputPin[Uml]]): Try[Unit]

  def link_Clause_clause_references_decider_OutputPin
  (from: UMLClause[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  def link_Clause_successorClause_references_predecessorClause_Clause
  (from: UMLClause[Uml],
   to: Set[UMLClause[Uml]]): Try[Unit]

  def link_Clause_predecessorClause_references_successorClause_Clause
  (from: UMLClause[Uml],
   to: Set[UMLClause[Uml]]): Try[Unit]

  def link_Clause_clause_references_test_ExecutableNode
  (from: UMLClause[Uml],
   to: Set[UMLExecutableNode[Uml]]): Try[Unit]

  // ClearAssociationAction

  def link_ClearAssociationAction_clearAssociationAction_references_association_Association
  (from: UMLClearAssociationAction[Uml],
   to: Option[UMLAssociation[Uml]]): Try[Unit]

  def link_ClearAssociationAction_clearAssociationAction_composes_object_InputPin
  (from: UMLClearAssociationAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // ClearStructuralFeatureAction

  def link_ClearStructuralFeatureAction_clearStructuralFeatureAction_composes_result_OutputPin
  (from: UMLClearStructuralFeatureAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  // ClearVariableAction


  // Collaboration

  def link_Collaboration_collaboration_references_collaborationRole_ConnectableElement
  (from: UMLCollaboration[Uml],
   to: Set[UMLConnectableElement[Uml]]): Try[Unit]

  // CollaborationUse

  def link_CollaborationUse_collaborationUse_composes_roleBinding_Dependency
  (from: UMLCollaborationUse[Uml],
   to: Set[UMLDependency[Uml]]): Try[Unit]

  def link_CollaborationUse_collaborationUse_references_type_Collaboration
  (from: UMLCollaborationUse[Uml],
   to: Option[UMLCollaboration[Uml]]): Try[Unit]

  // CombinedFragment

  def link_CombinedFragment_combinedFragment_composes_cfragmentGate_Gate
  (from: UMLCombinedFragment[Uml],
   to: Set[UMLGate[Uml]]): Try[Unit]

  def link_CombinedFragment_combinedFragment_composes_operand_InteractionOperand
  (from: UMLCombinedFragment[Uml],
   to: Seq[UMLInteractionOperand[Uml]]): Try[Unit]

  def set_CombinedFragment_interactionOperator
  (e: UMLCombinedFragment[Uml], interactionOperator: UMLInteractionOperatorKind.Value): Try[Unit]

  // Comment

  def link_Comment_comment_references_annotatedElement_Element
  (from: UMLComment[Uml],
   to: Set[UMLElement[Uml]]): Try[Unit]

  def set_Comment_body
  (e: UMLComment[Uml], body: Option[String]): Try[Unit]

  // CommunicationPath


  // Component

  def link_Component_component_composes_packagedElement_PackageableElement
  (from: UMLComponent[Uml],
   to: Set[UMLPackageableElement[Uml]]): Try[Unit]

  def link_Component_abstraction_composes_realization_ComponentRealization
  (from: UMLComponent[Uml],
   to: Set[UMLComponentRealization[Uml]]): Try[Unit]

  def set_Component_isIndirectlyInstantiated
  (e: UMLComponent[Uml], isIndirectlyInstantiated: Boolean): Try[Unit]

  // ComponentRealization

  def link_ComponentRealization_realization_references_abstraction_Component
  (from: UMLComponentRealization[Uml],
   to: Option[UMLComponent[Uml]]): Try[Unit]

  def link_ComponentRealization_componentRealization_references_realizingClassifier_Classifier
  (from: UMLComponentRealization[Uml],
   to: Set[UMLClassifier[Uml]]): Try[Unit]

  // ConditionalNode

  def link_ConditionalNode_conditionalNode_composes_clause_Clause
  (from: UMLConditionalNode[Uml],
   to: Set[UMLClause[Uml]]): Try[Unit]

  def link_ConditionalNode_conditionalNode_composes_result_OutputPin
  (from: UMLConditionalNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): Try[Unit]

  def set_ConditionalNode_isAssured
  (e: UMLConditionalNode[Uml], isAssured: Boolean): Try[Unit]

  def set_ConditionalNode_isDeterminate
  (e: UMLConditionalNode[Uml], isDeterminate: Boolean): Try[Unit]

  // ConnectableElement

  def link_ConnectableElement_parameteredElement_references_templateParameter_ConnectableElementTemplateParameter
  (from: UMLConnectableElement[Uml],
   to: Option[UMLConnectableElementTemplateParameter[Uml]]): Try[Unit]

  // ConnectableElementTemplateParameter

  def link_ConnectableElementTemplateParameter_templateParameter_references_parameteredElement_ConnectableElement
  (from: UMLConnectableElementTemplateParameter[Uml],
   to: Option[UMLConnectableElement[Uml]]): Try[Unit]

  // ConnectionPointReference

  def link_ConnectionPointReference_connectionPointReference_references_entry_Pseudostate
  (from: UMLConnectionPointReference[Uml],
   to: Set[UMLPseudostate[Uml]]): Try[Unit]

  def link_ConnectionPointReference_connectionPointReference_references_exit_Pseudostate
  (from: UMLConnectionPointReference[Uml],
   to: Set[UMLPseudostate[Uml]]): Try[Unit]

  def link_ConnectionPointReference_connection_references_state_State
  (from: UMLConnectionPointReference[Uml],
   to: Option[UMLState[Uml]]): Try[Unit]

  // Connector

  def link_Connector_connector_references_contract_Behavior
  (from: UMLConnector[Uml],
   to: Set[UMLBehavior[Uml]]): Try[Unit]

  def link_Connector_connector_composes_end_ConnectorEnd
  (from: UMLConnector[Uml],
   to: Seq[UMLConnectorEnd[Uml]]): Try[Unit]

  def link_Connector_connector_references_redefinedConnector_Connector
  (from: UMLConnector[Uml],
   to: Set[UMLConnector[Uml]]): Try[Unit]

  def link_Connector_connector_references_type_Association
  (from: UMLConnector[Uml],
   to: Option[UMLAssociation[Uml]]): Try[Unit]

  def set_Connector_kind
  (e: UMLConnector[Uml], kind: UMLConnectorKind.Value): Try[Unit]

  // ConnectorEnd

  def link_ConnectorEnd_connectorEnd_references_partWithPort_Property
  (from: UMLConnectorEnd[Uml],
   to: Option[UMLProperty[Uml]]): Try[Unit]

  // ConsiderIgnoreFragment

  def link_ConsiderIgnoreFragment_considerIgnoreFragment_references_message_NamedElement
  (from: UMLConsiderIgnoreFragment[Uml],
   to: Set[UMLNamedElement[Uml]]): Try[Unit]

  // Constraint

  def link_Constraint_constraint_references_constrainedElement_Element
  (from: UMLConstraint[Uml],
   to: Seq[UMLElement[Uml]]): Try[Unit]

  def link_Constraint_ownedRule_references_context_Namespace
  (from: UMLConstraint[Uml],
   to: Option[UMLNamespace[Uml]]): Try[Unit]

  def link_Constraint_owningConstraint_composes_specification_ValueSpecification
  (from: UMLConstraint[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  // Continuation


  def set_Continuation_setting
  (e: UMLContinuation[Uml], setting: Boolean): Try[Unit]

  // ControlFlow


  // ControlNode


  // CreateLinkAction

  def link_CreateLinkAction_createLinkAction_composes_endData_LinkEndCreationData
  (from: UMLCreateLinkAction[Uml],
   to: Iterable[UMLLinkEndCreationData[Uml]]): Try[Unit]

  // CreateLinkObjectAction

  def link_CreateLinkObjectAction_createLinkObjectAction_composes_result_OutputPin
  (from: UMLCreateLinkObjectAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  // CreateObjectAction

  def link_CreateObjectAction_createObjectAction_references_classifier_Classifier
  (from: UMLCreateObjectAction[Uml],
   to: Option[UMLClassifier[Uml]]): Try[Unit]

  def link_CreateObjectAction_createObjectAction_composes_result_OutputPin
  (from: UMLCreateObjectAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  // DataStoreNode


  // DataType

  def link_DataType_datatype_composes_ownedAttribute_Property
  (from: UMLDataType[Uml],
   to: Seq[UMLProperty[Uml]]): Try[Unit]

  def link_DataType_datatype_composes_ownedOperation_Operation
  (from: UMLDataType[Uml],
   to: Seq[UMLOperation[Uml]]): Try[Unit]

  // DecisionNode

  def link_DecisionNode_decisionNode_references_decisionInput_Behavior
  (from: UMLDecisionNode[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  def link_DecisionNode_decisionNode_references_decisionInputFlow_ObjectFlow
  (from: UMLDecisionNode[Uml],
   to: Option[UMLObjectFlow[Uml]]): Try[Unit]

  // Dependency

  def link_Dependency_supplierDependency_references_supplier_NamedElement
  (from: UMLDependency[Uml],
   to: Set[UMLNamedElement[Uml]]): Try[Unit]

  // DeployedArtifact


  // Deployment

  def link_Deployment_deployment_composes_configuration_DeploymentSpecification
  (from: UMLDeployment[Uml],
   to: Set[UMLDeploymentSpecification[Uml]]): Try[Unit]

  def link_Deployment_deploymentForArtifact_references_deployedArtifact_DeployedArtifact
  (from: UMLDeployment[Uml],
   to: Set[UMLDeployedArtifact[Uml]]): Try[Unit]

  def link_Deployment_deployment_references_location_DeploymentTarget
  (from: UMLDeployment[Uml],
   to: Option[UMLDeploymentTarget[Uml]]): Try[Unit]

  // DeploymentSpecification

  def link_DeploymentSpecification_configuration_references_deployment_Deployment
  (from: UMLDeploymentSpecification[Uml],
   to: Option[UMLDeployment[Uml]]): Try[Unit]

  def set_DeploymentSpecification_deploymentLocation
  (e: UMLDeploymentSpecification[Uml], deploymentLocation: Option[String]): Try[Unit]

  def set_DeploymentSpecification_executionLocation
  (e: UMLDeploymentSpecification[Uml], executionLocation: Option[String]): Try[Unit]

  // DeploymentTarget

  def link_DeploymentTarget_location_composes_deployment_Deployment
  (from: UMLDeploymentTarget[Uml],
   to: Set[UMLDeployment[Uml]]): Try[Unit]

  // DestroyLinkAction

  def link_DestroyLinkAction_destroyLinkAction_composes_endData_LinkEndDestructionData
  (from: UMLDestroyLinkAction[Uml],
   to: Iterable[UMLLinkEndDestructionData[Uml]]): Try[Unit]

  // DestroyObjectAction

  def link_DestroyObjectAction_destroyObjectAction_composes_target_InputPin
  (from: UMLDestroyObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def set_DestroyObjectAction_isDestroyLinks
  (e: UMLDestroyObjectAction[Uml], isDestroyLinks: Boolean): Try[Unit]

  def set_DestroyObjectAction_isDestroyOwnedObjects
  (e: UMLDestroyObjectAction[Uml], isDestroyOwnedObjects: Boolean): Try[Unit]

  // DestructionOccurrenceSpecification


  // Device


  // DirectedRelationship


  // Duration

  def link_Duration_duration_composes_expr_ValueSpecification
  (from: UMLDuration[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  def link_Duration_duration_references_observation_Observation
  (from: UMLDuration[Uml],
   to: Set[UMLObservation[Uml]]): Try[Unit]

  // DurationConstraint

  def link_DurationConstraint_durationConstraint_composes_specification_DurationInterval
  (from: UMLDurationConstraint[Uml],
   to: Option[UMLDurationInterval[Uml]]): Try[Unit]

  def set_DurationConstraint_firstEvent
  (e: UMLDurationConstraint[Uml], firstEvent: Set[Boolean]): Try[Unit]

  // DurationInterval

  def link_DurationInterval_durationInterval_references_max_Duration
  (from: UMLDurationInterval[Uml],
   to: Option[UMLDuration[Uml]]): Try[Unit]

  def link_DurationInterval_durationInterval_references_min_Duration
  (from: UMLDurationInterval[Uml],
   to: Option[UMLDuration[Uml]]): Try[Unit]

  // DurationObservation

  def link_DurationObservation_durationObservation_references_event_NamedElement
  (from: UMLDurationObservation[Uml],
   to: Seq[UMLNamedElement[Uml]]): Try[Unit]

  def set_DurationObservation_firstEvent
  (e: UMLDurationObservation[Uml], firstEvent: Seq[Boolean]): Try[Unit]

  // Element

  def link_Element_owningElement_composes_ownedComment_Comment
  (from: UMLElement[Uml],
   to: Set[UMLComment[Uml]]): Try[Unit]

  // ElementImport

  def link_ElementImport_import_references_importedElement_PackageableElement
  (from: UMLElementImport[Uml],
   to: Option[UMLPackageableElement[Uml]]): Try[Unit]

  def link_ElementImport_elementImport_references_importingNamespace_Namespace
  (from: UMLElementImport[Uml],
   to: Option[UMLNamespace[Uml]]): Try[Unit]

  def set_ElementImport_alias
  (e: UMLElementImport[Uml], alias: Option[String]): Try[Unit]

  def set_ElementImport_visibility
  (e: UMLElementImport[Uml], visibility: UMLVisibilityKind.Value): Try[Unit]

  // EncapsulatedClassifier


  // Enumeration

  def link_Enumeration_enumeration_composes_ownedLiteral_EnumerationLiteral
  (from: UMLEnumeration[Uml],
   to: Seq[UMLEnumerationLiteral[Uml]]): Try[Unit]

  // EnumerationLiteral

  def link_EnumerationLiteral_ownedLiteral_references_enumeration_Enumeration
  (from: UMLEnumerationLiteral[Uml],
   to: Option[UMLEnumeration[Uml]]): Try[Unit]

  // Event


  // ExceptionHandler

  def link_ExceptionHandler_exceptionHandler_references_exceptionInput_ObjectNode
  (from: UMLExceptionHandler[Uml],
   to: Option[UMLObjectNode[Uml]]): Try[Unit]

  def link_ExceptionHandler_exceptionHandler_references_exceptionType_Classifier
  (from: UMLExceptionHandler[Uml],
   to: Set[UMLClassifier[Uml]]): Try[Unit]

  def link_ExceptionHandler_exceptionHandler_references_handlerBody_ExecutableNode
  (from: UMLExceptionHandler[Uml],
   to: Option[UMLExecutableNode[Uml]]): Try[Unit]

  def link_ExceptionHandler_handler_references_protectedNode_ExecutableNode
  (from: UMLExceptionHandler[Uml],
   to: Option[UMLExecutableNode[Uml]]): Try[Unit]

  // ExecutableNode

  def link_ExecutableNode_protectedNode_composes_handler_ExceptionHandler
  (from: UMLExecutableNode[Uml],
   to: Set[UMLExceptionHandler[Uml]]): Try[Unit]

  // ExecutionEnvironment


  // ExecutionOccurrenceSpecification

  def link_ExecutionOccurrenceSpecification_executionOccurrenceSpecification_references_execution_ExecutionSpecification
  (from: UMLExecutionOccurrenceSpecification[Uml],
   to: Option[UMLExecutionSpecification[Uml]]): Try[Unit]

  // ExecutionSpecification

  def link_ExecutionSpecification_executionSpecification_references_finish_OccurrenceSpecification
  (from: UMLExecutionSpecification[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): Try[Unit]

  def link_ExecutionSpecification_executionSpecification_references_start_OccurrenceSpecification
  (from: UMLExecutionSpecification[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): Try[Unit]

  // ExpansionNode

  def link_ExpansionNode_inputElement_references_regionAsInput_ExpansionRegion
  (from: UMLExpansionNode[Uml],
   to: Option[UMLExpansionRegion[Uml]]): Try[Unit]

  def link_ExpansionNode_outputElement_references_regionAsOutput_ExpansionRegion
  (from: UMLExpansionNode[Uml],
   to: Option[UMLExpansionRegion[Uml]]): Try[Unit]

  // ExpansionRegion

  def link_ExpansionRegion_regionAsInput_references_inputElement_ExpansionNode
  (from: UMLExpansionRegion[Uml],
   to: Set[UMLExpansionNode[Uml]]): Try[Unit]

  def link_ExpansionRegion_regionAsOutput_references_outputElement_ExpansionNode
  (from: UMLExpansionRegion[Uml],
   to: Set[UMLExpansionNode[Uml]]): Try[Unit]

  def set_ExpansionRegion_mode
  (e: UMLExpansionRegion[Uml], mode: UMLExpansionKind.Value): Try[Unit]

  // Expression

  def link_Expression_expression_composes_operand_ValueSpecification
  (from: UMLExpression[Uml],
   to: Seq[UMLValueSpecification[Uml]]): Try[Unit]

  def set_Expression_symbol
  (e: UMLExpression[Uml], symbol: Option[String]): Try[Unit]

  // Extend

  def link_Extend_extend_composes_condition_Constraint
  (from: UMLExtend[Uml],
   to: Option[UMLConstraint[Uml]]): Try[Unit]

  def link_Extend_extend_references_extendedCase_UseCase
  (from: UMLExtend[Uml],
   to: Option[UMLUseCase[Uml]]): Try[Unit]

  def link_Extend_extend_references_extension_UseCase
  (from: UMLExtend[Uml],
   to: Option[UMLUseCase[Uml]]): Try[Unit]

  def link_Extend_extension_references_extensionLocation_ExtensionPoint
  (from: UMLExtend[Uml],
   to: Seq[UMLExtensionPoint[Uml]]): Try[Unit]

  // Extension

  def link_Extension_extension_composes_ownedEnd_ExtensionEnd
  (from: UMLExtension[Uml],
   to: Iterable[UMLExtensionEnd[Uml]]): Try[Unit]

  def set_Extension_isRequired
  (e: UMLExtension[Uml], isRequired: Boolean): Try[Unit]

  // ExtensionEnd

  def link_ExtensionEnd_extensionEnd_references_type_Stereotype
  (from: UMLExtensionEnd[Uml],
   to: Option[UMLStereotype[Uml]]): Try[Unit]

  def set_ExtensionEnd_lower
  (e: UMLExtensionEnd[Uml], lower: Integer): Try[Unit]

  // ExtensionPoint

  def link_ExtensionPoint_extensionPoint_references_useCase_UseCase
  (from: UMLExtensionPoint[Uml],
   to: Option[UMLUseCase[Uml]]): Try[Unit]

  // Feature


  def set_Feature_isStatic
  (e: UMLFeature[Uml], isStatic: Boolean): Try[Unit]

  // FinalNode


  // FinalState


  // FlowFinalNode


  // ForkNode


  // FunctionBehavior


  // Gate


  // GeneralOrdering

  def link_GeneralOrdering_toBefore_references_after_OccurrenceSpecification
  (from: UMLGeneralOrdering[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): Try[Unit]

  def link_GeneralOrdering_toAfter_references_before_OccurrenceSpecification
  (from: UMLGeneralOrdering[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): Try[Unit]

  // Generalization

  def link_Generalization_generalization_references_general_Classifier
  (from: UMLGeneralization[Uml],
   to: Option[UMLClassifier[Uml]]): Try[Unit]

  def link_Generalization_generalization_references_generalizationSet_GeneralizationSet
  (from: UMLGeneralization[Uml],
   to: Set[UMLGeneralizationSet[Uml]]): Try[Unit]

  def link_Generalization_generalization_references_specific_Classifier
  (from: UMLGeneralization[Uml],
   to: Option[UMLClassifier[Uml]]): Try[Unit]

  def set_Generalization_isSubstitutable
  (e: UMLGeneralization[Uml], isSubstitutable: Option[Boolean]): Try[Unit]

  // GeneralizationSet

  def link_GeneralizationSet_generalizationSet_references_generalization_Generalization
  (from: UMLGeneralizationSet[Uml],
   to: Set[UMLGeneralization[Uml]]): Try[Unit]

  def link_GeneralizationSet_powertypeExtent_references_powertype_Classifier
  (from: UMLGeneralizationSet[Uml],
   to: Option[UMLClassifier[Uml]]): Try[Unit]

  def set_GeneralizationSet_isCovering
  (e: UMLGeneralizationSet[Uml], isCovering: Boolean): Try[Unit]

  def set_GeneralizationSet_isDisjoint
  (e: UMLGeneralizationSet[Uml], isDisjoint: Boolean): Try[Unit]

  // Image


  def set_Image_content
  (e: UMLImage[Uml], content: Option[String]): Try[Unit]

  def set_Image_format
  (e: UMLImage[Uml], format: Option[String]): Try[Unit]

  def set_Image_location
  (e: UMLImage[Uml], location: Option[String]): Try[Unit]

  // Include

  def link_Include_include_references_addition_UseCase
  (from: UMLInclude[Uml],
   to: Option[UMLUseCase[Uml]]): Try[Unit]

  def link_Include_include_references_includingCase_UseCase
  (from: UMLInclude[Uml],
   to: Option[UMLUseCase[Uml]]): Try[Unit]

  // InformationFlow

  def link_InformationFlow_conveyingFlow_references_conveyed_Classifier
  (from: UMLInformationFlow[Uml],
   to: Set[UMLClassifier[Uml]]): Try[Unit]

  def link_InformationFlow_informationFlow_references_informationSource_NamedElement
  (from: UMLInformationFlow[Uml],
   to: Set[UMLNamedElement[Uml]]): Try[Unit]

  def link_InformationFlow_informationFlow_references_informationTarget_NamedElement
  (from: UMLInformationFlow[Uml],
   to: Set[UMLNamedElement[Uml]]): Try[Unit]

  def link_InformationFlow_abstraction_references_realization_Relationship
  (from: UMLInformationFlow[Uml],
   to: Set[UMLRelationship[Uml]]): Try[Unit]

  def link_InformationFlow_informationFlow_references_realizingActivityEdge_ActivityEdge
  (from: UMLInformationFlow[Uml],
   to: Set[UMLActivityEdge[Uml]]): Try[Unit]

  def link_InformationFlow_informationFlow_references_realizingConnector_Connector
  (from: UMLInformationFlow[Uml],
   to: Set[UMLConnector[Uml]]): Try[Unit]

  def link_InformationFlow_informationFlow_references_realizingMessage_Message
  (from: UMLInformationFlow[Uml],
   to: Set[UMLMessage[Uml]]): Try[Unit]

  // InformationItem

  def link_InformationItem_representation_references_represented_Classifier
  (from: UMLInformationItem[Uml],
   to: Set[UMLClassifier[Uml]]): Try[Unit]

  // InitialNode


  // InputPin


  // InstanceSpecification

  def link_InstanceSpecification_instanceSpecification_references_classifier_Classifier
  (from: UMLInstanceSpecification[Uml],
   to: Iterable[UMLClassifier[Uml]]): Try[Unit]

  def link_InstanceSpecification_owningInstance_composes_slot_Slot
  (from: UMLInstanceSpecification[Uml],
   to: Set[UMLSlot[Uml]]): Try[Unit]

  def link_InstanceSpecification_owningInstanceSpec_composes_specification_ValueSpecification
  (from: UMLInstanceSpecification[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  // InstanceValue

  def link_InstanceValue_instanceValue_references_instance_InstanceSpecification
  (from: UMLInstanceValue[Uml],
   to: Option[UMLInstanceSpecification[Uml]]): Try[Unit]

  // Interaction

  def link_Interaction_interaction_composes_action_Action
  (from: UMLInteraction[Uml],
   to: Set[UMLAction[Uml]]): Try[Unit]

  def link_Interaction_interaction_composes_formalGate_Gate
  (from: UMLInteraction[Uml],
   to: Set[UMLGate[Uml]]): Try[Unit]

  def link_Interaction_enclosingInteraction_composes_fragment_InteractionFragment
  (from: UMLInteraction[Uml],
   to: Seq[UMLInteractionFragment[Uml]]): Try[Unit]

  def link_Interaction_interaction_composes_lifeline_Lifeline
  (from: UMLInteraction[Uml],
   to: Set[UMLLifeline[Uml]]): Try[Unit]

  def link_Interaction_interaction_composes_message_Message
  (from: UMLInteraction[Uml],
   to: Set[UMLMessage[Uml]]): Try[Unit]

  // InteractionConstraint

  def link_InteractionConstraint_interactionConstraint_composes_maxint_ValueSpecification
  (from: UMLInteractionConstraint[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  def link_InteractionConstraint_interactionConstraint_composes_minint_ValueSpecification
  (from: UMLInteractionConstraint[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  // InteractionFragment

  def link_InteractionFragment_coveredBy_references_covered_Lifeline
  (from: UMLInteractionFragment[Uml],
   to: Iterable[UMLLifeline[Uml]]): Try[Unit]

  def link_InteractionFragment_fragment_references_enclosingInteraction_Interaction
  (from: UMLInteractionFragment[Uml],
   to: Option[UMLInteraction[Uml]]): Try[Unit]

  def link_InteractionFragment_fragment_references_enclosingOperand_InteractionOperand
  (from: UMLInteractionFragment[Uml],
   to: Option[UMLInteractionOperand[Uml]]): Try[Unit]

  def link_InteractionFragment_interactionFragment_composes_generalOrdering_GeneralOrdering
  (from: UMLInteractionFragment[Uml],
   to: Set[UMLGeneralOrdering[Uml]]): Try[Unit]

  // InteractionOperand

  def link_InteractionOperand_enclosingOperand_composes_fragment_InteractionFragment
  (from: UMLInteractionOperand[Uml],
   to: Seq[UMLInteractionFragment[Uml]]): Try[Unit]

  def link_InteractionOperand_interactionOperand_composes_guard_InteractionConstraint
  (from: UMLInteractionOperand[Uml],
   to: Option[UMLInteractionConstraint[Uml]]): Try[Unit]

  // InteractionUse

  def link_InteractionUse_interactionUse_composes_actualGate_Gate
  (from: UMLInteractionUse[Uml],
   to: Set[UMLGate[Uml]]): Try[Unit]

  def link_InteractionUse_interactionUse_composes_argument_ValueSpecification
  (from: UMLInteractionUse[Uml],
   to: Seq[UMLValueSpecification[Uml]]): Try[Unit]

  def link_InteractionUse_interactionUse_references_refersTo_Interaction
  (from: UMLInteractionUse[Uml],
   to: Option[UMLInteraction[Uml]]): Try[Unit]

  def link_InteractionUse_interactionUse_composes_returnValue_ValueSpecification
  (from: UMLInteractionUse[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  def link_InteractionUse_interactionUse_references_returnValueRecipient_Property
  (from: UMLInteractionUse[Uml],
   to: Option[UMLProperty[Uml]]): Try[Unit]

  // Interface

  def link_Interface_interface_composes_nestedClassifier_Classifier
  (from: UMLInterface[Uml],
   to: Seq[UMLClassifier[Uml]]): Try[Unit]

  def link_Interface_interface_composes_ownedAttribute_Property
  (from: UMLInterface[Uml],
   to: Seq[UMLProperty[Uml]]): Try[Unit]

  def link_Interface_interface_composes_ownedOperation_Operation
  (from: UMLInterface[Uml],
   to: Seq[UMLOperation[Uml]]): Try[Unit]

  def link_Interface_interface_composes_ownedReception_Reception
  (from: UMLInterface[Uml],
   to: Set[UMLReception[Uml]]): Try[Unit]

  def link_Interface_interface_composes_protocol_ProtocolStateMachine
  (from: UMLInterface[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): Try[Unit]

  def link_Interface_interface_references_redefinedInterface_Interface
  (from: UMLInterface[Uml],
   to: Set[UMLInterface[Uml]]): Try[Unit]

  // InterfaceRealization

  def link_InterfaceRealization_interfaceRealization_references_contract_Interface
  (from: UMLInterfaceRealization[Uml],
   to: Option[UMLInterface[Uml]]): Try[Unit]

  def link_InterfaceRealization_interfaceRealization_references_implementingClassifier_BehavioredClassifier
  (from: UMLInterfaceRealization[Uml],
   to: Option[UMLBehavioredClassifier[Uml]]): Try[Unit]

  // InterruptibleActivityRegion

  def link_InterruptibleActivityRegion_interrupts_references_interruptingEdge_ActivityEdge
  (from: UMLInterruptibleActivityRegion[Uml],
   to: Set[UMLActivityEdge[Uml]]): Try[Unit]

  def link_InterruptibleActivityRegion_inInterruptibleRegion_references_node_ActivityNode
  (from: UMLInterruptibleActivityRegion[Uml],
   to: Set[UMLActivityNode[Uml]]): Try[Unit]

  // Interval

  def link_Interval_interval_references_max_ValueSpecification
  (from: UMLInterval[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  def link_Interval_interval_references_min_ValueSpecification
  (from: UMLInterval[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  // IntervalConstraint

  def link_IntervalConstraint_intervalConstraint_composes_specification_Interval
  (from: UMLIntervalConstraint[Uml],
   to: Option[UMLInterval[Uml]]): Try[Unit]

  // InvocationAction

  def link_InvocationAction_invocationAction_composes_argument_InputPin
  (from: UMLInvocationAction[Uml],
   to: Seq[UMLInputPin[Uml]]): Try[Unit]

  def link_InvocationAction_invocationAction_references_onPort_Port
  (from: UMLInvocationAction[Uml],
   to: Option[UMLPort[Uml]]): Try[Unit]

  // JoinNode

  def link_JoinNode_joinNode_composes_joinSpec_ValueSpecification
  (from: UMLJoinNode[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  def set_JoinNode_isCombineDuplicate
  (e: UMLJoinNode[Uml], isCombineDuplicate: Boolean): Try[Unit]

  // Lifeline

  def link_Lifeline_covered_references_coveredBy_InteractionFragment
  (from: UMLLifeline[Uml],
   to: Set[UMLInteractionFragment[Uml]]): Try[Unit]

  def link_Lifeline_lifeline_references_decomposedAs_PartDecomposition
  (from: UMLLifeline[Uml],
   to: Option[UMLPartDecomposition[Uml]]): Try[Unit]

  def link_Lifeline_lifeline_references_interaction_Interaction
  (from: UMLLifeline[Uml],
   to: Option[UMLInteraction[Uml]]): Try[Unit]

  def link_Lifeline_lifeline_references_represents_ConnectableElement
  (from: UMLLifeline[Uml],
   to: Option[UMLConnectableElement[Uml]]): Try[Unit]

  def link_Lifeline_lifeline_composes_selector_ValueSpecification
  (from: UMLLifeline[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  // LinkAction

  def link_LinkAction_linkAction_composes_endData_LinkEndData
  (from: UMLLinkAction[Uml],
   to: Iterable[UMLLinkEndData[Uml]]): Try[Unit]

  def link_LinkAction_linkAction_composes_inputValue_InputPin
  (from: UMLLinkAction[Uml],
   to: Set[UMLInputPin[Uml]]): Try[Unit]

  // LinkEndCreationData

  def link_LinkEndCreationData_linkEndCreationData_references_insertAt_InputPin
  (from: UMLLinkEndCreationData[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def set_LinkEndCreationData_isReplaceAll
  (e: UMLLinkEndCreationData[Uml], isReplaceAll: Boolean): Try[Unit]

  // LinkEndData

  def link_LinkEndData_linkEndData_references_end_Property
  (from: UMLLinkEndData[Uml],
   to: Option[UMLProperty[Uml]]): Try[Unit]

  def link_LinkEndData_linkEndData_composes_qualifier_QualifierValue
  (from: UMLLinkEndData[Uml],
   to: Set[UMLQualifierValue[Uml]]): Try[Unit]

  def link_LinkEndData_linkEndData_references_value_InputPin
  (from: UMLLinkEndData[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // LinkEndDestructionData

  def link_LinkEndDestructionData_linkEndDestructionData_references_destroyAt_InputPin
  (from: UMLLinkEndDestructionData[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def set_LinkEndDestructionData_isDestroyDuplicates
  (e: UMLLinkEndDestructionData[Uml], isDestroyDuplicates: Boolean): Try[Unit]

  // LiteralBoolean


  def set_LiteralBoolean_value
  (e: UMLLiteralBoolean[Uml], value: Boolean): Try[Unit]

  // LiteralInteger


  def set_LiteralInteger_value
  (e: UMLLiteralInteger[Uml], value: Integer): Try[Unit]

  // LiteralNull


  // LiteralReal


  def set_LiteralReal_value
  (e: UMLLiteralReal[Uml], value: Double): Try[Unit]

  // LiteralSpecification


  // LiteralString


  def set_LiteralString_value
  (e: UMLLiteralString[Uml], value: Option[String]): Try[Unit]

  // LiteralUnlimitedNatural


  def set_LiteralUnlimitedNatural_value
  (e: UMLLiteralUnlimitedNatural[Uml], value: Integer): Try[Unit]

  // LoopNode

  def link_LoopNode_loopNode_references_bodyOutput_OutputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): Try[Unit]

  def link_LoopNode_loopNode_references_bodyPart_ExecutableNode
  (from: UMLLoopNode[Uml],
   to: Set[UMLExecutableNode[Uml]]): Try[Unit]

  def link_LoopNode_loopNode_references_decider_OutputPin
  (from: UMLLoopNode[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  def link_LoopNode_loopNode_composes_loopVariable_OutputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): Try[Unit]

  def link_LoopNode_loopNode_composes_loopVariableInput_InputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLInputPin[Uml]]): Try[Unit]

  def link_LoopNode_loopNode_composes_result_OutputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): Try[Unit]

  def link_LoopNode_loopNode_references_setupPart_ExecutableNode
  (from: UMLLoopNode[Uml],
   to: Set[UMLExecutableNode[Uml]]): Try[Unit]

  def link_LoopNode_loopNode_references_test_ExecutableNode
  (from: UMLLoopNode[Uml],
   to: Set[UMLExecutableNode[Uml]]): Try[Unit]

  def set_LoopNode_isTestedFirst
  (e: UMLLoopNode[Uml], isTestedFirst: Boolean): Try[Unit]

  // Manifestation

  def link_Manifestation_manifestation_references_utilizedElement_PackageableElement
  (from: UMLManifestation[Uml],
   to: Option[UMLPackageableElement[Uml]]): Try[Unit]

  // MergeNode


  // Message

  def link_Message_message_composes_argument_ValueSpecification
  (from: UMLMessage[Uml],
   to: Seq[UMLValueSpecification[Uml]]): Try[Unit]

  def link_Message_message_references_connector_Connector
  (from: UMLMessage[Uml],
   to: Option[UMLConnector[Uml]]): Try[Unit]

  def link_Message_message_references_interaction_Interaction
  (from: UMLMessage[Uml],
   to: Option[UMLInteraction[Uml]]): Try[Unit]

  def link_Message_endMessage_references_receiveEvent_MessageEnd
  (from: UMLMessage[Uml],
   to: Option[UMLMessageEnd[Uml]]): Try[Unit]

  def link_Message_endMessage_references_sendEvent_MessageEnd
  (from: UMLMessage[Uml],
   to: Option[UMLMessageEnd[Uml]]): Try[Unit]

  def link_Message_message_references_signature_NamedElement
  (from: UMLMessage[Uml],
   to: Option[UMLNamedElement[Uml]]): Try[Unit]

  def set_Message_messageKind
  (e: UMLMessage[Uml], messageKind: UMLMessageKind.Value): Try[Unit]

  def set_Message_messageSort
  (e: UMLMessage[Uml], messageSort: UMLMessageSort.Value): Try[Unit]

  // MessageEnd

  def link_MessageEnd_messageEnd_references_message_Message
  (from: UMLMessageEnd[Uml],
   to: Option[UMLMessage[Uml]]): Try[Unit]

  // MessageEvent


  // MessageOccurrenceSpecification


  // Model


  def set_Model_viewpoint
  (e: UMLModel[Uml], viewpoint: Option[String]): Try[Unit]

  // MultiplicityElement

  def link_MultiplicityElement_owningLower_composes_lowerValue_ValueSpecification
  (from: UMLMultiplicityElement[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  def link_MultiplicityElement_owningUpper_composes_upperValue_ValueSpecification
  (from: UMLMultiplicityElement[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  def set_MultiplicityElement_isOrdered
  (e: UMLMultiplicityElement[Uml], isOrdered: Boolean): Try[Unit]

  def set_MultiplicityElement_isUnique
  (e: UMLMultiplicityElement[Uml], isUnique: Boolean): Try[Unit]

  def set_MultiplicityElement_lower
  (e: UMLMultiplicityElement[Uml], lower: Integer): Try[Unit]

  def set_MultiplicityElement_upper
  (e: UMLMultiplicityElement[Uml], upper: Integer): Try[Unit]

  // NamedElement

  def link_NamedElement_namedElement_composes_nameExpression_StringExpression
  (from: UMLNamedElement[Uml],
   to: Option[UMLStringExpression[Uml]]): Try[Unit]

  def set_NamedElement_name
  (e: UMLNamedElement[Uml], name: Option[String]): Try[Unit]

  def set_NamedElement_qualifiedName
  (e: UMLNamedElement[Uml], qualifiedName: Option[String]): Try[Unit]

  def set_NamedElement_visibility
  (e: UMLNamedElement[Uml], visibility: Option[UMLVisibilityKind.Value]): Try[Unit]

  // Namespace

  def link_Namespace_importingNamespace_composes_elementImport_ElementImport
  (from: UMLNamespace[Uml],
   to: Set[UMLElementImport[Uml]]): Try[Unit]

  def link_Namespace_context_composes_ownedRule_Constraint
  (from: UMLNamespace[Uml],
   to: Set[UMLConstraint[Uml]]): Try[Unit]

  def link_Namespace_importingNamespace_composes_packageImport_PackageImport
  (from: UMLNamespace[Uml],
   to: Set[UMLPackageImport[Uml]]): Try[Unit]

  // Node

  def link_Node_node_composes_nestedNode_Node
  (from: UMLNode[Uml],
   to: Set[UMLNode[Uml]]): Try[Unit]

  // ObjectFlow

  def link_ObjectFlow_objectFlow_references_selection_Behavior
  (from: UMLObjectFlow[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  def link_ObjectFlow_objectFlow_references_transformation_Behavior
  (from: UMLObjectFlow[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  def set_ObjectFlow_isMulticast
  (e: UMLObjectFlow[Uml], isMulticast: Boolean): Try[Unit]

  def set_ObjectFlow_isMultireceive
  (e: UMLObjectFlow[Uml], isMultireceive: Boolean): Try[Unit]

  // ObjectNode

  def link_ObjectNode_objectNode_references_inState_State
  (from: UMLObjectNode[Uml],
   to: Set[UMLState[Uml]]): Try[Unit]

  def link_ObjectNode_objectNode_references_selection_Behavior
  (from: UMLObjectNode[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  def link_ObjectNode_objectNode_composes_upperBound_ValueSpecification
  (from: UMLObjectNode[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  def set_ObjectNode_isControlType
  (e: UMLObjectNode[Uml], isControlType: Boolean): Try[Unit]

  def set_ObjectNode_ordering
  (e: UMLObjectNode[Uml], ordering: UMLObjectNodeOrderingKind.Value): Try[Unit]

  // Observation


  // OccurrenceSpecification

  def link_OccurrenceSpecification_events_references_covered_Lifeline
  (from: UMLOccurrenceSpecification[Uml],
   to: Iterable[UMLLifeline[Uml]]): Try[Unit]

  def link_OccurrenceSpecification_before_references_toAfter_GeneralOrdering
  (from: UMLOccurrenceSpecification[Uml],
   to: Set[UMLGeneralOrdering[Uml]]): Try[Unit]

  def link_OccurrenceSpecification_after_references_toBefore_GeneralOrdering
  (from: UMLOccurrenceSpecification[Uml],
   to: Set[UMLGeneralOrdering[Uml]]): Try[Unit]

  // OpaqueAction

  def link_OpaqueAction_opaqueAction_composes_inputValue_InputPin
  (from: UMLOpaqueAction[Uml],
   to: Set[UMLInputPin[Uml]]): Try[Unit]

  def link_OpaqueAction_opaqueAction_composes_outputValue_OutputPin
  (from: UMLOpaqueAction[Uml],
   to: Set[UMLOutputPin[Uml]]): Try[Unit]

  def set_OpaqueAction_body
  (e: UMLOpaqueAction[Uml], body: Seq[String]): Try[Unit]

  def set_OpaqueAction_language
  (e: UMLOpaqueAction[Uml], language: Seq[String]): Try[Unit]

  // OpaqueBehavior


  def set_OpaqueBehavior_body
  (e: UMLOpaqueBehavior[Uml], body: Seq[String]): Try[Unit]

  def set_OpaqueBehavior_language
  (e: UMLOpaqueBehavior[Uml], language: Seq[String]): Try[Unit]

  // OpaqueExpression

  def link_OpaqueExpression_opaqueExpression_references_behavior_Behavior
  (from: UMLOpaqueExpression[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  def set_OpaqueExpression_body
  (e: UMLOpaqueExpression[Uml], body: Seq[String]): Try[Unit]

  def set_OpaqueExpression_language
  (e: UMLOpaqueExpression[Uml], language: Seq[String]): Try[Unit]

  // Operation

  def link_Operation_bodyContext_composes_bodyCondition_Constraint
  (from: UMLOperation[Uml],
   to: Option[UMLConstraint[Uml]]): Try[Unit]

  def link_Operation_ownedOperation_references_class_Class
  (from: UMLOperation[Uml],
   to: Option[UMLClass[Uml]]): Try[Unit]

  def link_Operation_ownedOperation_references_datatype_DataType
  (from: UMLOperation[Uml],
   to: Option[UMLDataType[Uml]]): Try[Unit]

  def link_Operation_ownedOperation_references_interface_Interface
  (from: UMLOperation[Uml],
   to: Option[UMLInterface[Uml]]): Try[Unit]

  def link_Operation_operation_composes_ownedParameter_Parameter
  (from: UMLOperation[Uml],
   to: Seq[UMLParameter[Uml]]): Try[Unit]

  def link_Operation_postContext_composes_postcondition_Constraint
  (from: UMLOperation[Uml],
   to: Set[UMLConstraint[Uml]]): Try[Unit]

  def link_Operation_preContext_composes_precondition_Constraint
  (from: UMLOperation[Uml],
   to: Set[UMLConstraint[Uml]]): Try[Unit]

  def link_Operation_operation_references_raisedException_Type
  (from: UMLOperation[Uml],
   to: Set[UMLType[Uml]]): Try[Unit]

  def link_Operation_operation_references_redefinedOperation_Operation
  (from: UMLOperation[Uml],
   to: Set[UMLOperation[Uml]]): Try[Unit]

  def link_Operation_parameteredElement_references_templateParameter_OperationTemplateParameter
  (from: UMLOperation[Uml],
   to: Option[UMLOperationTemplateParameter[Uml]]): Try[Unit]

  def set_Operation_isOrdered
  (e: UMLOperation[Uml], isOrdered: Boolean): Try[Unit]

  def set_Operation_isQuery
  (e: UMLOperation[Uml], isQuery: Boolean): Try[Unit]

  def set_Operation_isUnique
  (e: UMLOperation[Uml], isUnique: Boolean): Try[Unit]

  def set_Operation_lower
  (e: UMLOperation[Uml], lower: Option[Integer]): Try[Unit]

  def set_Operation_upper
  (e: UMLOperation[Uml], upper: Option[Integer]): Try[Unit]

  // OperationTemplateParameter

  def link_OperationTemplateParameter_templateParameter_references_parameteredElement_Operation
  (from: UMLOperationTemplateParameter[Uml],
   to: Option[UMLOperation[Uml]]): Try[Unit]

  // OutputPin


  // Package

  def link_Package_receivingPackage_composes_packageMerge_PackageMerge
  (from: UMLPackage[Uml],
   to: Set[UMLPackageMerge[Uml]]): Try[Unit]

  def link_Package_owningPackage_composes_packagedElement_PackageableElement
  (from: UMLPackage[Uml],
   to: Set[UMLPackageableElement[Uml]]): Try[Unit]

  def link_Package_applyingPackage_composes_profileApplication_ProfileApplication
  (from: UMLPackage[Uml],
   to: Set[UMLProfileApplication[Uml]]): Try[Unit]

  def set_Package_URI
  (e: UMLPackage[Uml], URI: Option[String]): Try[Unit]

  // PackageImport

  def link_PackageImport_packageImport_references_importedPackage_Package
  (from: UMLPackageImport[Uml],
   to: Option[UMLPackage[Uml]]): Try[Unit]

  def link_PackageImport_packageImport_references_importingNamespace_Namespace
  (from: UMLPackageImport[Uml],
   to: Option[UMLNamespace[Uml]]): Try[Unit]

  def set_PackageImport_visibility
  (e: UMLPackageImport[Uml], visibility: UMLVisibilityKind.Value): Try[Unit]

  // PackageMerge

  def link_PackageMerge_packageMerge_references_mergedPackage_Package
  (from: UMLPackageMerge[Uml],
   to: Option[UMLPackage[Uml]]): Try[Unit]

  def link_PackageMerge_packageMerge_references_receivingPackage_Package
  (from: UMLPackageMerge[Uml],
   to: Option[UMLPackage[Uml]]): Try[Unit]

  // PackageableElement


  def set_PackageableElement_visibility
  (e: UMLPackageableElement[Uml], visibility: Option[UMLVisibilityKind.Value]): Try[Unit]

  // Parameter

  def link_Parameter_owningParameter_composes_defaultValue_ValueSpecification
  (from: UMLParameter[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  def link_Parameter_ownedParameter_references_operation_Operation
  (from: UMLParameter[Uml],
   to: Option[UMLOperation[Uml]]): Try[Unit]

  def link_Parameter_parameter_references_parameterSet_ParameterSet
  (from: UMLParameter[Uml],
   to: Set[UMLParameterSet[Uml]]): Try[Unit]

  def set_Parameter_default
  (e: UMLParameter[Uml], default: Option[String]): Try[Unit]

  def set_Parameter_direction
  (e: UMLParameter[Uml], direction: UMLParameterDirectionKind.Value): Try[Unit]

  def set_Parameter_effect
  (e: UMLParameter[Uml], effect: Option[UMLParameterEffectKind.Value]): Try[Unit]

  def set_Parameter_isException
  (e: UMLParameter[Uml], isException: Boolean): Try[Unit]

  def set_Parameter_isStream
  (e: UMLParameter[Uml], isStream: Boolean): Try[Unit]

  // ParameterSet

  def link_ParameterSet_parameterSet_composes_condition_Constraint
  (from: UMLParameterSet[Uml],
   to: Set[UMLConstraint[Uml]]): Try[Unit]

  def link_ParameterSet_parameterSet_references_parameter_Parameter
  (from: UMLParameterSet[Uml],
   to: Set[UMLParameter[Uml]]): Try[Unit]

  // ParameterableElement

  def link_ParameterableElement_ownedParameteredElement_references_owningTemplateParameter_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: Option[UMLTemplateParameter[Uml]]): Try[Unit]

  def link_ParameterableElement_parameteredElement_references_templateParameter_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: Option[UMLTemplateParameter[Uml]]): Try[Unit]

  // PartDecomposition


  // Pin


  def set_Pin_isControl
  (e: UMLPin[Uml], isControl: Boolean): Try[Unit]

  // Port

  def link_Port_port_references_protocol_ProtocolStateMachine
  (from: UMLPort[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): Try[Unit]

  def link_Port_port_references_redefinedPort_Port
  (from: UMLPort[Uml],
   to: Set[UMLPort[Uml]]): Try[Unit]

  def set_Port_isBehavior
  (e: UMLPort[Uml], isBehavior: Boolean): Try[Unit]

  def set_Port_isConjugated
  (e: UMLPort[Uml], isConjugated: Boolean): Try[Unit]

  def set_Port_isService
  (e: UMLPort[Uml], isService: Boolean): Try[Unit]

  // PrimitiveType


  // Profile

  def link_Profile_profile_composes_metaclassReference_ElementImport
  (from: UMLProfile[Uml],
   to: Set[UMLElementImport[Uml]]): Try[Unit]

  def link_Profile_profile_composes_metamodelReference_PackageImport
  (from: UMLProfile[Uml],
   to: Set[UMLPackageImport[Uml]]): Try[Unit]

  // ProfileApplication

  def link_ProfileApplication_profileApplication_references_appliedProfile_Profile
  (from: UMLProfileApplication[Uml],
   to: Option[UMLProfile[Uml]]): Try[Unit]

  def link_ProfileApplication_profileApplication_references_applyingPackage_Package
  (from: UMLProfileApplication[Uml],
   to: Option[UMLPackage[Uml]]): Try[Unit]

  def set_ProfileApplication_isStrict
  (e: UMLProfileApplication[Uml], isStrict: Boolean): Try[Unit]

  // Property

  def link_Property_memberEnd_references_association_Association
  (from: UMLProperty[Uml],
   to: Option[UMLAssociation[Uml]]): Try[Unit]

  def link_Property_qualifier_references_associationEnd_Property
  (from: UMLProperty[Uml],
   to: Option[UMLProperty[Uml]]): Try[Unit]

  def link_Property_ownedAttribute_references_class_Class
  (from: UMLProperty[Uml],
   to: Option[UMLClass[Uml]]): Try[Unit]

  def link_Property_ownedAttribute_references_datatype_DataType
  (from: UMLProperty[Uml],
   to: Option[UMLDataType[Uml]]): Try[Unit]

  def link_Property_owningProperty_composes_defaultValue_ValueSpecification
  (from: UMLProperty[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  def link_Property_ownedAttribute_references_interface_Interface
  (from: UMLProperty[Uml],
   to: Option[UMLInterface[Uml]]): Try[Unit]

  def link_Property_ownedEnd_references_owningAssociation_Association
  (from: UMLProperty[Uml],
   to: Option[UMLAssociation[Uml]]): Try[Unit]

  def link_Property_associationEnd_composes_qualifier_Property
  (from: UMLProperty[Uml],
   to: Seq[UMLProperty[Uml]]): Try[Unit]

  def link_Property_property_references_redefinedProperty_Property
  (from: UMLProperty[Uml],
   to: Set[UMLProperty[Uml]]): Try[Unit]

  def link_Property_property_references_subsettedProperty_Property
  (from: UMLProperty[Uml],
   to: Set[UMLProperty[Uml]]): Try[Unit]

  def set_Property_aggregation
  (e: UMLProperty[Uml], aggregation: UMLAggregationKind.Value): Try[Unit]

  def set_Property_isComposite
  (e: UMLProperty[Uml], isComposite: Boolean): Try[Unit]

  def set_Property_isDerived
  (e: UMLProperty[Uml], isDerived: Boolean): Try[Unit]

  def set_Property_isDerivedUnion
  (e: UMLProperty[Uml], isDerivedUnion: Boolean): Try[Unit]

  def set_Property_isID
  (e: UMLProperty[Uml], isID: Boolean): Try[Unit]

  // ProtocolConformance

  def link_ProtocolConformance_protocolConformance_references_generalMachine_ProtocolStateMachine
  (from: UMLProtocolConformance[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): Try[Unit]

  def link_ProtocolConformance_conformance_references_specificMachine_ProtocolStateMachine
  (from: UMLProtocolConformance[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): Try[Unit]

  // ProtocolStateMachine

  def link_ProtocolStateMachine_specificMachine_composes_conformance_ProtocolConformance
  (from: UMLProtocolStateMachine[Uml],
   to: Set[UMLProtocolConformance[Uml]]): Try[Unit]

  // ProtocolTransition

  def link_ProtocolTransition_owningTransition_composes_postCondition_Constraint
  (from: UMLProtocolTransition[Uml],
   to: Option[UMLConstraint[Uml]]): Try[Unit]

  def link_ProtocolTransition_protocolTransition_composes_preCondition_Constraint
  (from: UMLProtocolTransition[Uml],
   to: Option[UMLConstraint[Uml]]): Try[Unit]

  // Pseudostate

  def link_Pseudostate_connectionPoint_references_state_State
  (from: UMLPseudostate[Uml],
   to: Option[UMLState[Uml]]): Try[Unit]

  def link_Pseudostate_connectionPoint_references_stateMachine_StateMachine
  (from: UMLPseudostate[Uml],
   to: Option[UMLStateMachine[Uml]]): Try[Unit]

  def set_Pseudostate_kind
  (e: UMLPseudostate[Uml], kind: UMLPseudostateKind.Value): Try[Unit]

  // QualifierValue

  def link_QualifierValue_qualifierValue_references_qualifier_Property
  (from: UMLQualifierValue[Uml],
   to: Option[UMLProperty[Uml]]): Try[Unit]

  def link_QualifierValue_qualifierValue_references_value_InputPin
  (from: UMLQualifierValue[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // RaiseExceptionAction

  def link_RaiseExceptionAction_raiseExceptionAction_composes_exception_InputPin
  (from: UMLRaiseExceptionAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // ReadExtentAction

  def link_ReadExtentAction_readExtentAction_references_classifier_Classifier
  (from: UMLReadExtentAction[Uml],
   to: Option[UMLClassifier[Uml]]): Try[Unit]

  def link_ReadExtentAction_readExtentAction_composes_result_OutputPin
  (from: UMLReadExtentAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  // ReadIsClassifiedObjectAction

  def link_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_references_classifier_Classifier
  (from: UMLReadIsClassifiedObjectAction[Uml],
   to: Option[UMLClassifier[Uml]]): Try[Unit]

  def link_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_composes_object_InputPin
  (from: UMLReadIsClassifiedObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def link_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_composes_result_OutputPin
  (from: UMLReadIsClassifiedObjectAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  def set_ReadIsClassifiedObjectAction_isDirect
  (e: UMLReadIsClassifiedObjectAction[Uml], isDirect: Boolean): Try[Unit]

  // ReadLinkAction

  def link_ReadLinkAction_readLinkAction_composes_result_OutputPin
  (from: UMLReadLinkAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  // ReadLinkObjectEndAction

  def link_ReadLinkObjectEndAction_readLinkObjectEndAction_references_end_Property
  (from: UMLReadLinkObjectEndAction[Uml],
   to: Option[UMLProperty[Uml]]): Try[Unit]

  def link_ReadLinkObjectEndAction_readLinkObjectEndAction_composes_object_InputPin
  (from: UMLReadLinkObjectEndAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def link_ReadLinkObjectEndAction_readLinkObjectEndAction_composes_result_OutputPin
  (from: UMLReadLinkObjectEndAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  // ReadLinkObjectEndQualifierAction

  def link_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_composes_object_InputPin
  (from: UMLReadLinkObjectEndQualifierAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def link_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_references_qualifier_Property
  (from: UMLReadLinkObjectEndQualifierAction[Uml],
   to: Option[UMLProperty[Uml]]): Try[Unit]

  def link_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_composes_result_OutputPin
  (from: UMLReadLinkObjectEndQualifierAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  // ReadSelfAction

  def link_ReadSelfAction_readSelfAction_composes_result_OutputPin
  (from: UMLReadSelfAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  // ReadStructuralFeatureAction

  def link_ReadStructuralFeatureAction_readStructuralFeatureAction_composes_result_OutputPin
  (from: UMLReadStructuralFeatureAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  // ReadVariableAction

  def link_ReadVariableAction_readVariableAction_composes_result_OutputPin
  (from: UMLReadVariableAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  // Realization


  // Reception

  def link_Reception_reception_references_signal_Signal
  (from: UMLReception[Uml],
   to: Option[UMLSignal[Uml]]): Try[Unit]

  // ReclassifyObjectAction

  def link_ReclassifyObjectAction_reclassifyObjectAction_references_newClassifier_Classifier
  (from: UMLReclassifyObjectAction[Uml],
   to: Set[UMLClassifier[Uml]]): Try[Unit]

  def link_ReclassifyObjectAction_reclassifyObjectAction_composes_object_InputPin
  (from: UMLReclassifyObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def link_ReclassifyObjectAction_reclassifyObjectAction_references_oldClassifier_Classifier
  (from: UMLReclassifyObjectAction[Uml],
   to: Set[UMLClassifier[Uml]]): Try[Unit]

  def set_ReclassifyObjectAction_isReplaceAll
  (e: UMLReclassifyObjectAction[Uml], isReplaceAll: Boolean): Try[Unit]

  // RedefinableElement


  def set_RedefinableElement_isLeaf
  (e: UMLRedefinableElement[Uml], isLeaf: Boolean): Try[Unit]

  // RedefinableTemplateSignature

  def link_RedefinableTemplateSignature_ownedTemplateSignature_references_classifier_Classifier
  (from: UMLRedefinableTemplateSignature[Uml],
   to: Option[UMLClassifier[Uml]]): Try[Unit]

  def link_RedefinableTemplateSignature_redefinableTemplateSignature_references_extendedSignature_RedefinableTemplateSignature
  (from: UMLRedefinableTemplateSignature[Uml],
   to: Set[UMLRedefinableTemplateSignature[Uml]]): Try[Unit]

  // ReduceAction

  def link_ReduceAction_reduceAction_composes_collection_InputPin
  (from: UMLReduceAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def link_ReduceAction_reduceAction_references_reducer_Behavior
  (from: UMLReduceAction[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  def link_ReduceAction_reduceAction_composes_result_OutputPin
  (from: UMLReduceAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  def set_ReduceAction_isOrdered
  (e: UMLReduceAction[Uml], isOrdered: Boolean): Try[Unit]

  // Region

  def link_Region_region_references_extendedRegion_Region
  (from: UMLRegion[Uml],
   to: Option[UMLRegion[Uml]]): Try[Unit]

  def link_Region_region_references_state_State
  (from: UMLRegion[Uml],
   to: Option[UMLState[Uml]]): Try[Unit]

  def link_Region_region_references_stateMachine_StateMachine
  (from: UMLRegion[Uml],
   to: Option[UMLStateMachine[Uml]]): Try[Unit]

  def link_Region_container_composes_subvertex_Vertex
  (from: UMLRegion[Uml],
   to: Set[UMLVertex[Uml]]): Try[Unit]

  def link_Region_container_composes_transition_Transition
  (from: UMLRegion[Uml],
   to: Set[UMLTransition[Uml]]): Try[Unit]

  // Relationship


  // RemoveStructuralFeatureValueAction

  def link_RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_composes_removeAt_InputPin
  (from: UMLRemoveStructuralFeatureValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def set_RemoveStructuralFeatureValueAction_isRemoveDuplicates
  (e: UMLRemoveStructuralFeatureValueAction[Uml], isRemoveDuplicates: Boolean): Try[Unit]

  // RemoveVariableValueAction

  def link_RemoveVariableValueAction_removeVariableValueAction_composes_removeAt_InputPin
  (from: UMLRemoveVariableValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def set_RemoveVariableValueAction_isRemoveDuplicates
  (e: UMLRemoveVariableValueAction[Uml], isRemoveDuplicates: Boolean): Try[Unit]

  // ReplyAction

  def link_ReplyAction_replyAction_references_replyToCall_Trigger
  (from: UMLReplyAction[Uml],
   to: Option[UMLTrigger[Uml]]): Try[Unit]

  def link_ReplyAction_replyAction_composes_replyValue_InputPin
  (from: UMLReplyAction[Uml],
   to: Seq[UMLInputPin[Uml]]): Try[Unit]

  def link_ReplyAction_replyAction_composes_returnInformation_InputPin
  (from: UMLReplyAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // SendObjectAction

  def link_SendObjectAction_sendObjectAction_composes_request_InputPin
  (from: UMLSendObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def link_SendObjectAction_sendObjectAction_composes_target_InputPin
  (from: UMLSendObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // SendSignalAction

  def link_SendSignalAction_sendSignalAction_references_signal_Signal
  (from: UMLSendSignalAction[Uml],
   to: Option[UMLSignal[Uml]]): Try[Unit]

  def link_SendSignalAction_sendSignalAction_composes_target_InputPin
  (from: UMLSendSignalAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // SequenceNode

  def link_SequenceNode_sequenceNode_composes_executableNode_ExecutableNode
  (from: UMLSequenceNode[Uml],
   to: Seq[UMLExecutableNode[Uml]]): Try[Unit]

  // Signal

  def link_Signal_owningSignal_composes_ownedAttribute_Property
  (from: UMLSignal[Uml],
   to: Seq[UMLProperty[Uml]]): Try[Unit]

  // SignalEvent

  def link_SignalEvent_signalEvent_references_signal_Signal
  (from: UMLSignalEvent[Uml],
   to: Option[UMLSignal[Uml]]): Try[Unit]

  // Slot

  def link_Slot_slot_references_definingFeature_StructuralFeature
  (from: UMLSlot[Uml],
   to: Option[UMLStructuralFeature[Uml]]): Try[Unit]

  def link_Slot_slot_references_owningInstance_InstanceSpecification
  (from: UMLSlot[Uml],
   to: Option[UMLInstanceSpecification[Uml]]): Try[Unit]

  def link_Slot_owningSlot_composes_value_ValueSpecification
  (from: UMLSlot[Uml],
   to: Seq[UMLValueSpecification[Uml]]): Try[Unit]

  // StartClassifierBehaviorAction

  def link_StartClassifierBehaviorAction_startClassifierBehaviorAction_composes_object_InputPin
  (from: UMLStartClassifierBehaviorAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // StartObjectBehaviorAction

  def link_StartObjectBehaviorAction_startObjectBehaviorAction_composes_object_InputPin
  (from: UMLStartObjectBehaviorAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // State

  def link_State_state_composes_connection_ConnectionPointReference
  (from: UMLState[Uml],
   to: Set[UMLConnectionPointReference[Uml]]): Try[Unit]

  def link_State_state_composes_connectionPoint_Pseudostate
  (from: UMLState[Uml],
   to: Set[UMLPseudostate[Uml]]): Try[Unit]

  def link_State_state_composes_deferrableTrigger_Trigger
  (from: UMLState[Uml],
   to: Set[UMLTrigger[Uml]]): Try[Unit]

  def link_State_state_composes_doActivity_Behavior
  (from: UMLState[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  def link_State_state_composes_entry_Behavior
  (from: UMLState[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  def link_State_state_composes_exit_Behavior
  (from: UMLState[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  def link_State_state_references_redefinedState_State
  (from: UMLState[Uml],
   to: Option[UMLState[Uml]]): Try[Unit]

  def link_State_state_composes_region_Region
  (from: UMLState[Uml],
   to: Set[UMLRegion[Uml]]): Try[Unit]

  def link_State_owningState_composes_stateInvariant_Constraint
  (from: UMLState[Uml],
   to: Option[UMLConstraint[Uml]]): Try[Unit]

  def link_State_submachineState_references_submachine_StateMachine
  (from: UMLState[Uml],
   to: Option[UMLStateMachine[Uml]]): Try[Unit]

  def set_State_isComposite
  (e: UMLState[Uml], isComposite: Boolean): Try[Unit]

  def set_State_isOrthogonal
  (e: UMLState[Uml], isOrthogonal: Boolean): Try[Unit]

  def set_State_isSimple
  (e: UMLState[Uml], isSimple: Boolean): Try[Unit]

  def set_State_isSubmachineState
  (e: UMLState[Uml], isSubmachineState: Boolean): Try[Unit]

  // StateInvariant

  def link_StateInvariant_stateInvariant_references_covered_Lifeline
  (from: UMLStateInvariant[Uml],
   to: Iterable[UMLLifeline[Uml]]): Try[Unit]

  def link_StateInvariant_stateInvariant_composes_invariant_Constraint
  (from: UMLStateInvariant[Uml],
   to: Option[UMLConstraint[Uml]]): Try[Unit]

  // StateMachine

  def link_StateMachine_stateMachine_composes_connectionPoint_Pseudostate
  (from: UMLStateMachine[Uml],
   to: Set[UMLPseudostate[Uml]]): Try[Unit]

  def link_StateMachine_stateMachine_references_extendedStateMachine_StateMachine
  (from: UMLStateMachine[Uml],
   to: Set[UMLStateMachine[Uml]]): Try[Unit]

  def link_StateMachine_stateMachine_composes_region_Region
  (from: UMLStateMachine[Uml],
   to: Set[UMLRegion[Uml]]): Try[Unit]

  def link_StateMachine_submachine_references_submachineState_State
  (from: UMLStateMachine[Uml],
   to: Set[UMLState[Uml]]): Try[Unit]

  // Stereotype

  def link_Stereotype_stereotype_composes_icon_Image
  (from: UMLStereotype[Uml],
   to: Set[UMLImage[Uml]]): Try[Unit]

  // StringExpression

  def link_StringExpression_subExpression_references_owningExpression_StringExpression
  (from: UMLStringExpression[Uml],
   to: Option[UMLStringExpression[Uml]]): Try[Unit]

  def link_StringExpression_owningExpression_composes_subExpression_StringExpression
  (from: UMLStringExpression[Uml],
   to: Seq[UMLStringExpression[Uml]]): Try[Unit]

  // StructuralFeature


  def set_StructuralFeature_isReadOnly
  (e: UMLStructuralFeature[Uml], isReadOnly: Boolean): Try[Unit]

  // StructuralFeatureAction

  def link_StructuralFeatureAction_structuralFeatureAction_composes_object_InputPin
  (from: UMLStructuralFeatureAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def link_StructuralFeatureAction_structuralFeatureAction_references_structuralFeature_StructuralFeature
  (from: UMLStructuralFeatureAction[Uml],
   to: Option[UMLStructuralFeature[Uml]]): Try[Unit]

  // StructuredActivityNode

  def link_StructuredActivityNode_structuredNode_references_activity_Activity
  (from: UMLStructuredActivityNode[Uml],
   to: Option[UMLActivity[Uml]]): Try[Unit]

  def link_StructuredActivityNode_inStructuredNode_composes_edge_ActivityEdge
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLActivityEdge[Uml]]): Try[Unit]

  def link_StructuredActivityNode_inStructuredNode_composes_node_ActivityNode
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLActivityNode[Uml]]): Try[Unit]

  def link_StructuredActivityNode_structuredActivityNode_composes_structuredNodeInput_InputPin
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLInputPin[Uml]]): Try[Unit]

  def link_StructuredActivityNode_structuredActivityNode_composes_structuredNodeOutput_OutputPin
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLOutputPin[Uml]]): Try[Unit]

  def link_StructuredActivityNode_scope_composes_variable_Variable
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLVariable[Uml]]): Try[Unit]

  def set_StructuredActivityNode_mustIsolate
  (e: UMLStructuredActivityNode[Uml], mustIsolate: Boolean): Try[Unit]

  // StructuredClassifier

  def link_StructuredClassifier_structuredClassifier_composes_ownedAttribute_Property
  (from: UMLStructuredClassifier[Uml],
   to: Seq[UMLProperty[Uml]]): Try[Unit]

  def link_StructuredClassifier_structuredClassifier_composes_ownedConnector_Connector
  (from: UMLStructuredClassifier[Uml],
   to: Set[UMLConnector[Uml]]): Try[Unit]

  // Substitution

  def link_Substitution_substitution_references_contract_Classifier
  (from: UMLSubstitution[Uml],
   to: Option[UMLClassifier[Uml]]): Try[Unit]

  def link_Substitution_substitution_references_substitutingClassifier_Classifier
  (from: UMLSubstitution[Uml],
   to: Option[UMLClassifier[Uml]]): Try[Unit]

  // TemplateBinding

  def link_TemplateBinding_templateBinding_references_boundElement_TemplateableElement
  (from: UMLTemplateBinding[Uml],
   to: Option[UMLTemplateableElement[Uml]]): Try[Unit]

  def link_TemplateBinding_templateBinding_composes_parameterSubstitution_TemplateParameterSubstitution
  (from: UMLTemplateBinding[Uml],
   to: Set[UMLTemplateParameterSubstitution[Uml]]): Try[Unit]

  def link_TemplateBinding_templateBinding_references_signature_TemplateSignature
  (from: UMLTemplateBinding[Uml],
   to: Option[UMLTemplateSignature[Uml]]): Try[Unit]

  // TemplateParameter

  def link_TemplateParameter_templateParameter_references_default_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): Try[Unit]

  def link_TemplateParameter_templateParameter_composes_ownedDefault_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): Try[Unit]

  def link_TemplateParameter_owningTemplateParameter_composes_ownedParameteredElement_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): Try[Unit]

  def link_TemplateParameter_templateParameter_references_parameteredElement_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): Try[Unit]

  def link_TemplateParameter_ownedParameter_references_signature_TemplateSignature
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLTemplateSignature[Uml]]): Try[Unit]

  // TemplateParameterSubstitution

  def link_TemplateParameterSubstitution_templateParameterSubstitution_references_actual_ParameterableElement
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLParameterableElement[Uml]]): Try[Unit]

  def link_TemplateParameterSubstitution_templateParameterSubstitution_references_formal_TemplateParameter
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLTemplateParameter[Uml]]): Try[Unit]

  def link_TemplateParameterSubstitution_owningTemplateParameterSubstitution_composes_ownedActual_ParameterableElement
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLParameterableElement[Uml]]): Try[Unit]

  def link_TemplateParameterSubstitution_parameterSubstitution_references_templateBinding_TemplateBinding
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLTemplateBinding[Uml]]): Try[Unit]

  // TemplateSignature

  def link_TemplateSignature_signature_composes_ownedParameter_TemplateParameter
  (from: UMLTemplateSignature[Uml],
   to: Seq[UMLTemplateParameter[Uml]]): Try[Unit]

  def link_TemplateSignature_templateSignature_references_parameter_TemplateParameter
  (from: UMLTemplateSignature[Uml],
   to: Seq[UMLTemplateParameter[Uml]]): Try[Unit]

  def link_TemplateSignature_ownedTemplateSignature_references_template_TemplateableElement
  (from: UMLTemplateSignature[Uml],
   to: Option[UMLTemplateableElement[Uml]]): Try[Unit]

  // TemplateableElement

  def link_TemplateableElement_template_composes_ownedTemplateSignature_TemplateSignature
  (from: UMLTemplateableElement[Uml],
   to: Option[UMLTemplateSignature[Uml]]): Try[Unit]

  def link_TemplateableElement_boundElement_composes_templateBinding_TemplateBinding
  (from: UMLTemplateableElement[Uml],
   to: Set[UMLTemplateBinding[Uml]]): Try[Unit]

  // TestIdentityAction

  def link_TestIdentityAction_testIdentityAction_composes_first_InputPin
  (from: UMLTestIdentityAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def link_TestIdentityAction_testIdentityAction_composes_result_OutputPin
  (from: UMLTestIdentityAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  def link_TestIdentityAction_testIdentityAction_composes_second_InputPin
  (from: UMLTestIdentityAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // TimeConstraint

  def link_TimeConstraint_timeConstraint_composes_specification_TimeInterval
  (from: UMLTimeConstraint[Uml],
   to: Option[UMLTimeInterval[Uml]]): Try[Unit]

  def set_TimeConstraint_firstEvent
  (e: UMLTimeConstraint[Uml], firstEvent: Option[Boolean]): Try[Unit]

  // TimeEvent

  def link_TimeEvent_timeEvent_composes_when_TimeExpression
  (from: UMLTimeEvent[Uml],
   to: Option[UMLTimeExpression[Uml]]): Try[Unit]

  def set_TimeEvent_isRelative
  (e: UMLTimeEvent[Uml], isRelative: Boolean): Try[Unit]

  // TimeExpression

  def link_TimeExpression_timeExpression_composes_expr_ValueSpecification
  (from: UMLTimeExpression[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  def link_TimeExpression_timeExpression_references_observation_Observation
  (from: UMLTimeExpression[Uml],
   to: Set[UMLObservation[Uml]]): Try[Unit]

  // TimeInterval

  def link_TimeInterval_timeInterval_references_max_TimeExpression
  (from: UMLTimeInterval[Uml],
   to: Option[UMLTimeExpression[Uml]]): Try[Unit]

  def link_TimeInterval_timeInterval_references_min_TimeExpression
  (from: UMLTimeInterval[Uml],
   to: Option[UMLTimeExpression[Uml]]): Try[Unit]

  // TimeObservation

  def link_TimeObservation_timeObservation_references_event_NamedElement
  (from: UMLTimeObservation[Uml],
   to: Option[UMLNamedElement[Uml]]): Try[Unit]

  def set_TimeObservation_firstEvent
  (e: UMLTimeObservation[Uml], firstEvent: Boolean): Try[Unit]

  // Transition

  def link_Transition_transition_references_container_Region
  (from: UMLTransition[Uml],
   to: Option[UMLRegion[Uml]]): Try[Unit]

  def link_Transition_transition_composes_effect_Behavior
  (from: UMLTransition[Uml],
   to: Option[UMLBehavior[Uml]]): Try[Unit]

  def link_Transition_transition_composes_guard_Constraint
  (from: UMLTransition[Uml],
   to: Option[UMLConstraint[Uml]]): Try[Unit]

  def link_Transition_transition_references_redefinedTransition_Transition
  (from: UMLTransition[Uml],
   to: Option[UMLTransition[Uml]]): Try[Unit]

  def link_Transition_transition_composes_trigger_Trigger
  (from: UMLTransition[Uml],
   to: Set[UMLTrigger[Uml]]): Try[Unit]

  def set_Transition_kind
  (e: UMLTransition[Uml], kind: UMLTransitionKind.Value): Try[Unit]

  // Trigger

  def link_Trigger_trigger_references_event_Event
  (from: UMLTrigger[Uml],
   to: Option[UMLEvent[Uml]]): Try[Unit]

  def link_Trigger_trigger_references_port_Port
  (from: UMLTrigger[Uml],
   to: Set[UMLPort[Uml]]): Try[Unit]

  // Type


  // TypedElement

  def link_TypedElement_typedElement_references_type_Type
  (from: UMLTypedElement[Uml],
   to: Option[UMLType[Uml]]): Try[Unit]

  // UnmarshallAction

  def link_UnmarshallAction_unmarshallAction_composes_object_InputPin
  (from: UMLUnmarshallAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  def link_UnmarshallAction_unmarshallAction_composes_result_OutputPin
  (from: UMLUnmarshallAction[Uml],
   to: Seq[UMLOutputPin[Uml]]): Try[Unit]

  def link_UnmarshallAction_unmarshallAction_references_unmarshallType_Classifier
  (from: UMLUnmarshallAction[Uml],
   to: Option[UMLClassifier[Uml]]): Try[Unit]

  // Usage


  // UseCase

  def link_UseCase_extension_composes_extend_Extend
  (from: UMLUseCase[Uml],
   to: Set[UMLExtend[Uml]]): Try[Unit]

  def link_UseCase_useCase_composes_extensionPoint_ExtensionPoint
  (from: UMLUseCase[Uml],
   to: Set[UMLExtensionPoint[Uml]]): Try[Unit]

  def link_UseCase_includingCase_composes_include_Include
  (from: UMLUseCase[Uml],
   to: Set[UMLInclude[Uml]]): Try[Unit]

  def link_UseCase_useCase_references_subject_Classifier
  (from: UMLUseCase[Uml],
   to: Set[UMLClassifier[Uml]]): Try[Unit]

  // ValuePin

  def link_ValuePin_valuePin_composes_value_ValueSpecification
  (from: UMLValuePin[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  // ValueSpecification


  // ValueSpecificationAction

  def link_ValueSpecificationAction_valueSpecificationAction_composes_result_OutputPin
  (from: UMLValueSpecificationAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  def link_ValueSpecificationAction_valueSpecificationAction_composes_value_ValueSpecification
  (from: UMLValueSpecificationAction[Uml],
   to: Option[UMLValueSpecification[Uml]]): Try[Unit]

  // Variable

  def link_Variable_variable_references_activityScope_Activity
  (from: UMLVariable[Uml],
   to: Option[UMLActivity[Uml]]): Try[Unit]

  def link_Variable_variable_references_scope_StructuredActivityNode
  (from: UMLVariable[Uml],
   to: Option[UMLStructuredActivityNode[Uml]]): Try[Unit]

  // VariableAction

  def link_VariableAction_variableAction_references_variable_Variable
  (from: UMLVariableAction[Uml],
   to: Option[UMLVariable[Uml]]): Try[Unit]

  // Vertex

  def link_Vertex_subvertex_references_container_Region
  (from: UMLVertex[Uml],
   to: Option[UMLRegion[Uml]]): Try[Unit]

  // WriteLinkAction


  // WriteStructuralFeatureAction

  def link_WriteStructuralFeatureAction_writeStructuralFeatureAction_composes_result_OutputPin
  (from: UMLWriteStructuralFeatureAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Try[Unit]

  def link_WriteStructuralFeatureAction_writeStructuralFeatureAction_composes_value_InputPin
  (from: UMLWriteStructuralFeatureAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // WriteVariableAction

  def link_WriteVariableAction_writeVariableAction_composes_value_InputPin
  (from: UMLWriteVariableAction[Uml],
   to: Option[UMLInputPin[Uml]]): Try[Unit]

  // Start of user code for additional features
  // End of user code
}
