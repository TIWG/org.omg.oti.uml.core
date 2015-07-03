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
 * 1) creating a link instance of a composite association
 * 2) deleting a link instance of a composite association
 * 3) creating a link instance of a reference association
 * 4) deleting a link instance of a reference association
 * 5) setting the value of a DataType metaclass property
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
 *    to: <metaclass2>): Try[Unit]
 *
 * For (2)
 * unlink_<metaclass1>_<end1>_composes_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2>): Try[Unit]
 *
 * For (3)
 * link_<metaclass1>_<end1>_references_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2>): Try[Unit]
 *
 * For (4)
 * unlink_<metaclass1>_<end1>_references_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2>): Try[Unit]
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

  def link_OpaqueExpression_abstraction_composes_mapping_Abstraction
  (from: UMLOpaqueExpression[Uml],
   to: UMLAbstraction[Uml]): Try[Unit]

  def unlink_OpaqueExpression_abstraction_composes_mapping_Abstraction
  (from: UMLOpaqueExpression[Uml],
   to: UMLAbstraction[Uml]): Try[Unit]


  // AcceptCallAction

  def link_OutputPin_acceptCallAction_composes_returnInformation_AcceptCallAction
  (from: UMLOutputPin[Uml],
   to: UMLAcceptCallAction[Uml]): Try[Unit]

  def unlink_OutputPin_acceptCallAction_composes_returnInformation_AcceptCallAction
  (from: UMLOutputPin[Uml],
   to: UMLAcceptCallAction[Uml]): Try[Unit]


  // AcceptEventAction

  def link_OutputPin_acceptEventAction_composes_result_AcceptEventAction
  (from: UMLOutputPin[Uml],
   to: UMLAcceptEventAction[Uml]): Try[Unit]

  def unlink_OutputPin_acceptEventAction_composes_result_AcceptEventAction
  (from: UMLOutputPin[Uml],
   to: UMLAcceptEventAction[Uml]): Try[Unit]

  def link_Trigger_acceptEventAction_composes_trigger_AcceptEventAction
  (from: UMLTrigger[Uml],
   to: UMLAcceptEventAction[Uml]): Try[Unit]

  def unlink_Trigger_acceptEventAction_composes_trigger_AcceptEventAction
  (from: UMLTrigger[Uml],
   to: UMLAcceptEventAction[Uml]): Try[Unit]

  def set_AcceptEventAction_isUnmarshall
  (e: UMLAcceptEventAction[Uml], isUnmarshall: Boolean): Try[Unit]


  // Action

  def link_Constraint_action_composes_localPostcondition_Action
  (from: UMLConstraint[Uml],
   to: UMLAction[Uml]): Try[Unit]

  def unlink_Constraint_action_composes_localPostcondition_Action
  (from: UMLConstraint[Uml],
   to: UMLAction[Uml]): Try[Unit]

  def link_Constraint_action_composes_localPrecondition_Action
  (from: UMLConstraint[Uml],
   to: UMLAction[Uml]): Try[Unit]

  def unlink_Constraint_action_composes_localPrecondition_Action
  (from: UMLConstraint[Uml],
   to: UMLAction[Uml]): Try[Unit]

  def set_Action_isLocallyReentrant
  (e: UMLAction[Uml], isLocallyReentrant: Boolean): Try[Unit]


  // ActionExecutionSpecification

  def link_Action_actionExecutionSpecification_references_action_ActionExecutionSpecification
  (from: UMLAction[Uml],
   to: UMLActionExecutionSpecification[Uml]): Try[Unit]

  def unlink_Action_actionExecutionSpecification_references_action_ActionExecutionSpecification
  (from: UMLAction[Uml],
   to: UMLActionExecutionSpecification[Uml]): Try[Unit]


  // ActionInputPin

  def link_Action_actionInputPin_composes_fromAction_ActionInputPin
  (from: UMLAction[Uml],
   to: UMLActionInputPin[Uml]): Try[Unit]

  def unlink_Action_actionInputPin_composes_fromAction_ActionInputPin
  (from: UMLAction[Uml],
   to: UMLActionInputPin[Uml]): Try[Unit]


  // Activity

  def link_ActivityEdge_activity_composes_edge_Activity
  (from: UMLActivityEdge[Uml],
   to: UMLActivity[Uml]): Try[Unit]

  def unlink_ActivityEdge_activity_composes_edge_Activity
  (from: UMLActivityEdge[Uml],
   to: UMLActivity[Uml]): Try[Unit]

  def link_ActivityGroup_inActivity_composes_group_Activity
  (from: UMLActivityGroup[Uml],
   to: UMLActivity[Uml]): Try[Unit]

  def unlink_ActivityGroup_inActivity_composes_group_Activity
  (from: UMLActivityGroup[Uml],
   to: UMLActivity[Uml]): Try[Unit]

  def link_ActivityNode_activity_composes_node_Activity
  (from: UMLActivityNode[Uml],
   to: UMLActivity[Uml]): Try[Unit]

  def unlink_ActivityNode_activity_composes_node_Activity
  (from: UMLActivityNode[Uml],
   to: UMLActivity[Uml]): Try[Unit]

  def link_ActivityPartition_activity_references_partition_Activity
  (from: UMLActivityPartition[Uml],
   to: UMLActivity[Uml]): Try[Unit]

  def unlink_ActivityPartition_activity_references_partition_Activity
  (from: UMLActivityPartition[Uml],
   to: UMLActivity[Uml]): Try[Unit]

  def link_StructuredActivityNode_activity_composes_structuredNode_Activity
  (from: UMLStructuredActivityNode[Uml],
   to: UMLActivity[Uml]): Try[Unit]

  def unlink_StructuredActivityNode_activity_composes_structuredNode_Activity
  (from: UMLStructuredActivityNode[Uml],
   to: UMLActivity[Uml]): Try[Unit]

  def link_Variable_activityScope_composes_variable_Activity
  (from: UMLVariable[Uml],
   to: UMLActivity[Uml]): Try[Unit]

  def unlink_Variable_activityScope_composes_variable_Activity
  (from: UMLVariable[Uml],
   to: UMLActivity[Uml]): Try[Unit]

  def set_Activity_isReadOnly
  (e: UMLActivity[Uml], isReadOnly: Boolean): Try[Unit]

  def set_Activity_isSingleExecution
  (e: UMLActivity[Uml], isSingleExecution: Boolean): Try[Unit]


  // ActivityEdge

  def link_Activity_edge_references_activity_ActivityEdge
  (from: UMLActivity[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def unlink_Activity_edge_references_activity_ActivityEdge
  (from: UMLActivity[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def link_ValueSpecification_activityEdge_composes_guard_ActivityEdge
  (from: UMLValueSpecification[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def unlink_ValueSpecification_activityEdge_composes_guard_ActivityEdge
  (from: UMLValueSpecification[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def link_ActivityPartition_edge_references_inPartition_ActivityEdge
  (from: UMLActivityPartition[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def unlink_ActivityPartition_edge_references_inPartition_ActivityEdge
  (from: UMLActivityPartition[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def link_StructuredActivityNode_edge_references_inStructuredNode_ActivityEdge
  (from: UMLStructuredActivityNode[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def unlink_StructuredActivityNode_edge_references_inStructuredNode_ActivityEdge
  (from: UMLStructuredActivityNode[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def link_InterruptibleActivityRegion_interruptingEdge_references_interrupts_ActivityEdge
  (from: UMLInterruptibleActivityRegion[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def unlink_InterruptibleActivityRegion_interruptingEdge_references_interrupts_ActivityEdge
  (from: UMLInterruptibleActivityRegion[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def link_ActivityEdge_activityEdge_references_redefinedEdge_ActivityEdge
  (from: UMLActivityEdge[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def unlink_ActivityEdge_activityEdge_references_redefinedEdge_ActivityEdge
  (from: UMLActivityEdge[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def link_ActivityNode_outgoing_references_source_ActivityEdge
  (from: UMLActivityNode[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def unlink_ActivityNode_outgoing_references_source_ActivityEdge
  (from: UMLActivityNode[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def link_ActivityNode_incoming_references_target_ActivityEdge
  (from: UMLActivityNode[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def unlink_ActivityNode_incoming_references_target_ActivityEdge
  (from: UMLActivityNode[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def link_ValueSpecification_activityEdge_composes_weight_ActivityEdge
  (from: UMLValueSpecification[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]

  def unlink_ValueSpecification_activityEdge_composes_weight_ActivityEdge
  (from: UMLValueSpecification[Uml],
   to: UMLActivityEdge[Uml]): Try[Unit]


  // ActivityFinalNode



  // ActivityGroup

  def link_Activity_group_references_inActivity_ActivityGroup
  (from: UMLActivity[Uml],
   to: UMLActivityGroup[Uml]): Try[Unit]

  def unlink_Activity_group_references_inActivity_ActivityGroup
  (from: UMLActivity[Uml],
   to: UMLActivityGroup[Uml]): Try[Unit]


  // ActivityNode

  def link_Activity_node_references_activity_ActivityNode
  (from: UMLActivity[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def unlink_Activity_node_references_activity_ActivityNode
  (from: UMLActivity[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def link_InterruptibleActivityRegion_node_references_inInterruptibleRegion_ActivityNode
  (from: UMLInterruptibleActivityRegion[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def unlink_InterruptibleActivityRegion_node_references_inInterruptibleRegion_ActivityNode
  (from: UMLInterruptibleActivityRegion[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def link_ActivityPartition_node_references_inPartition_ActivityNode
  (from: UMLActivityPartition[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def unlink_ActivityPartition_node_references_inPartition_ActivityNode
  (from: UMLActivityPartition[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def link_StructuredActivityNode_node_references_inStructuredNode_ActivityNode
  (from: UMLStructuredActivityNode[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def unlink_StructuredActivityNode_node_references_inStructuredNode_ActivityNode
  (from: UMLStructuredActivityNode[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def link_ActivityEdge_target_references_incoming_ActivityNode
  (from: UMLActivityEdge[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def unlink_ActivityEdge_target_references_incoming_ActivityNode
  (from: UMLActivityEdge[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def link_ActivityEdge_source_references_outgoing_ActivityNode
  (from: UMLActivityEdge[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def unlink_ActivityEdge_source_references_outgoing_ActivityNode
  (from: UMLActivityEdge[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def link_ActivityNode_activityNode_references_redefinedNode_ActivityNode
  (from: UMLActivityNode[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]

  def unlink_ActivityNode_activityNode_references_redefinedNode_ActivityNode
  (from: UMLActivityNode[Uml],
   to: UMLActivityNode[Uml]): Try[Unit]


  // ActivityParameterNode

  def link_Parameter_activityParameterNode_references_parameter_ActivityParameterNode
  (from: UMLParameter[Uml],
   to: UMLActivityParameterNode[Uml]): Try[Unit]

  def unlink_Parameter_activityParameterNode_references_parameter_ActivityParameterNode
  (from: UMLParameter[Uml],
   to: UMLActivityParameterNode[Uml]): Try[Unit]


  // ActivityPartition

  def link_ActivityEdge_inPartition_references_edge_ActivityPartition
  (from: UMLActivityEdge[Uml],
   to: UMLActivityPartition[Uml]): Try[Unit]

  def unlink_ActivityEdge_inPartition_references_edge_ActivityPartition
  (from: UMLActivityEdge[Uml],
   to: UMLActivityPartition[Uml]): Try[Unit]

  def link_ActivityNode_inPartition_references_node_ActivityPartition
  (from: UMLActivityNode[Uml],
   to: UMLActivityPartition[Uml]): Try[Unit]

  def unlink_ActivityNode_inPartition_references_node_ActivityPartition
  (from: UMLActivityNode[Uml],
   to: UMLActivityPartition[Uml]): Try[Unit]

  def link_Element_activityPartition_references_represents_ActivityPartition
  (from: UMLElement[Uml],
   to: UMLActivityPartition[Uml]): Try[Unit]

  def unlink_Element_activityPartition_references_represents_ActivityPartition
  (from: UMLElement[Uml],
   to: UMLActivityPartition[Uml]): Try[Unit]

  def link_ActivityPartition_superPartition_composes_subpartition_ActivityPartition
  (from: UMLActivityPartition[Uml],
   to: UMLActivityPartition[Uml]): Try[Unit]

  def unlink_ActivityPartition_superPartition_composes_subpartition_ActivityPartition
  (from: UMLActivityPartition[Uml],
   to: UMLActivityPartition[Uml]): Try[Unit]

  def link_ActivityPartition_subpartition_references_superPartition_ActivityPartition
  (from: UMLActivityPartition[Uml],
   to: UMLActivityPartition[Uml]): Try[Unit]

  def unlink_ActivityPartition_subpartition_references_superPartition_ActivityPartition
  (from: UMLActivityPartition[Uml],
   to: UMLActivityPartition[Uml]): Try[Unit]

  def set_ActivityPartition_isDimension
  (e: UMLActivityPartition[Uml], isDimension: Boolean): Try[Unit]

  def set_ActivityPartition_isExternal
  (e: UMLActivityPartition[Uml], isExternal: Boolean): Try[Unit]


  // Actor



  // AddStructuralFeatureValueAction

  def link_InputPin_addStructuralFeatureValueAction_composes_insertAt_AddStructuralFeatureValueAction
  (from: UMLInputPin[Uml],
   to: UMLAddStructuralFeatureValueAction[Uml]): Try[Unit]

  def unlink_InputPin_addStructuralFeatureValueAction_composes_insertAt_AddStructuralFeatureValueAction
  (from: UMLInputPin[Uml],
   to: UMLAddStructuralFeatureValueAction[Uml]): Try[Unit]

  def set_AddStructuralFeatureValueAction_isReplaceAll
  (e: UMLAddStructuralFeatureValueAction[Uml], isReplaceAll: Boolean): Try[Unit]


  // AddVariableValueAction

  def link_InputPin_addVariableValueAction_composes_insertAt_AddVariableValueAction
  (from: UMLInputPin[Uml],
   to: UMLAddVariableValueAction[Uml]): Try[Unit]

  def unlink_InputPin_addVariableValueAction_composes_insertAt_AddVariableValueAction
  (from: UMLInputPin[Uml],
   to: UMLAddVariableValueAction[Uml]): Try[Unit]

  def set_AddVariableValueAction_isReplaceAll
  (e: UMLAddVariableValueAction[Uml], isReplaceAll: Boolean): Try[Unit]


  // AnyReceiveEvent



  // Artifact

  def link_Manifestation_artifact_composes_manifestation_Artifact
  (from: UMLManifestation[Uml],
   to: UMLArtifact[Uml]): Try[Unit]

  def unlink_Manifestation_artifact_composes_manifestation_Artifact
  (from: UMLManifestation[Uml],
   to: UMLArtifact[Uml]): Try[Unit]

  def link_Artifact_artifact_composes_nestedArtifact_Artifact
  (from: UMLArtifact[Uml],
   to: UMLArtifact[Uml]): Try[Unit]

  def unlink_Artifact_artifact_composes_nestedArtifact_Artifact
  (from: UMLArtifact[Uml],
   to: UMLArtifact[Uml]): Try[Unit]

  def link_Property_artifact_composes_ownedAttribute_Artifact
  (from: UMLProperty[Uml],
   to: UMLArtifact[Uml]): Try[Unit]

  def unlink_Property_artifact_composes_ownedAttribute_Artifact
  (from: UMLProperty[Uml],
   to: UMLArtifact[Uml]): Try[Unit]

  def link_Operation_artifact_composes_ownedOperation_Artifact
  (from: UMLOperation[Uml],
   to: UMLArtifact[Uml]): Try[Unit]

  def unlink_Operation_artifact_composes_ownedOperation_Artifact
  (from: UMLOperation[Uml],
   to: UMLArtifact[Uml]): Try[Unit]

  def set_Artifact_fileName
  (e: UMLArtifact[Uml], fileName: Option[String]): Try[Unit]


  // Association

  def link_Property_association_references_memberEnd_Association
  (from: UMLProperty[Uml],
   to: UMLAssociation[Uml]): Try[Unit]

  def unlink_Property_association_references_memberEnd_Association
  (from: UMLProperty[Uml],
   to: UMLAssociation[Uml]): Try[Unit]

  def link_Property_association_references_navigableOwnedEnd_Association
  (from: UMLProperty[Uml],
   to: UMLAssociation[Uml]): Try[Unit]

  def unlink_Property_association_references_navigableOwnedEnd_Association
  (from: UMLProperty[Uml],
   to: UMLAssociation[Uml]): Try[Unit]

  def link_Property_owningAssociation_composes_ownedEnd_Association
  (from: UMLProperty[Uml],
   to: UMLAssociation[Uml]): Try[Unit]

  def unlink_Property_owningAssociation_composes_ownedEnd_Association
  (from: UMLProperty[Uml],
   to: UMLAssociation[Uml]): Try[Unit]

  def set_Association_isDerived
  (e: UMLAssociation[Uml], isDerived: Boolean): Try[Unit]


  // AssociationClass



  // Behavior

  def link_Parameter_behavior_composes_ownedParameter_Behavior
  (from: UMLParameter[Uml],
   to: UMLBehavior[Uml]): Try[Unit]

  def unlink_Parameter_behavior_composes_ownedParameter_Behavior
  (from: UMLParameter[Uml],
   to: UMLBehavior[Uml]): Try[Unit]

  def link_ParameterSet_behavior_composes_ownedParameterSet_Behavior
  (from: UMLParameterSet[Uml],
   to: UMLBehavior[Uml]): Try[Unit]

  def unlink_ParameterSet_behavior_composes_ownedParameterSet_Behavior
  (from: UMLParameterSet[Uml],
   to: UMLBehavior[Uml]): Try[Unit]

  def link_Constraint_behavior_composes_postcondition_Behavior
  (from: UMLConstraint[Uml],
   to: UMLBehavior[Uml]): Try[Unit]

  def unlink_Constraint_behavior_composes_postcondition_Behavior
  (from: UMLConstraint[Uml],
   to: UMLBehavior[Uml]): Try[Unit]

  def link_Constraint_behavior_composes_precondition_Behavior
  (from: UMLConstraint[Uml],
   to: UMLBehavior[Uml]): Try[Unit]

  def unlink_Constraint_behavior_composes_precondition_Behavior
  (from: UMLConstraint[Uml],
   to: UMLBehavior[Uml]): Try[Unit]

  def link_Behavior_behavior_references_redefinedBehavior_Behavior
  (from: UMLBehavior[Uml],
   to: UMLBehavior[Uml]): Try[Unit]

  def unlink_Behavior_behavior_references_redefinedBehavior_Behavior
  (from: UMLBehavior[Uml],
   to: UMLBehavior[Uml]): Try[Unit]

  def link_BehavioralFeature_method_references_specification_Behavior
  (from: UMLBehavioralFeature[Uml],
   to: UMLBehavior[Uml]): Try[Unit]

  def unlink_BehavioralFeature_method_references_specification_Behavior
  (from: UMLBehavioralFeature[Uml],
   to: UMLBehavior[Uml]): Try[Unit]

  def set_Behavior_isReentrant
  (e: UMLBehavior[Uml], isReentrant: Boolean): Try[Unit]


  // BehaviorExecutionSpecification

  def link_Behavior_behaviorExecutionSpecification_references_behavior_BehaviorExecutionSpecification
  (from: UMLBehavior[Uml],
   to: UMLBehaviorExecutionSpecification[Uml]): Try[Unit]

  def unlink_Behavior_behaviorExecutionSpecification_references_behavior_BehaviorExecutionSpecification
  (from: UMLBehavior[Uml],
   to: UMLBehaviorExecutionSpecification[Uml]): Try[Unit]


  // BehavioralFeature

  def link_Behavior_specification_references_method_BehavioralFeature
  (from: UMLBehavior[Uml],
   to: UMLBehavioralFeature[Uml]): Try[Unit]

  def unlink_Behavior_specification_references_method_BehavioralFeature
  (from: UMLBehavior[Uml],
   to: UMLBehavioralFeature[Uml]): Try[Unit]

  def link_Parameter_ownerFormalParam_composes_ownedParameter_BehavioralFeature
  (from: UMLParameter[Uml],
   to: UMLBehavioralFeature[Uml]): Try[Unit]

  def unlink_Parameter_ownerFormalParam_composes_ownedParameter_BehavioralFeature
  (from: UMLParameter[Uml],
   to: UMLBehavioralFeature[Uml]): Try[Unit]

  def link_ParameterSet_behavioralFeature_composes_ownedParameterSet_BehavioralFeature
  (from: UMLParameterSet[Uml],
   to: UMLBehavioralFeature[Uml]): Try[Unit]

  def unlink_ParameterSet_behavioralFeature_composes_ownedParameterSet_BehavioralFeature
  (from: UMLParameterSet[Uml],
   to: UMLBehavioralFeature[Uml]): Try[Unit]

  def link_Type_behavioralFeature_references_raisedException_BehavioralFeature
  (from: UMLType[Uml],
   to: UMLBehavioralFeature[Uml]): Try[Unit]

  def unlink_Type_behavioralFeature_references_raisedException_BehavioralFeature
  (from: UMLType[Uml],
   to: UMLBehavioralFeature[Uml]): Try[Unit]

  def set_BehavioralFeature_concurrency
  (e: UMLBehavioralFeature[Uml], concurrency: UMLCallConcurrencyKind.Value): Try[Unit]

  def set_BehavioralFeature_isAbstract
  (e: UMLBehavioralFeature[Uml], isAbstract: Boolean): Try[Unit]


  // BehavioredClassifier

  def link_Behavior_behavioredClassifier_references_classifierBehavior_BehavioredClassifier
  (from: UMLBehavior[Uml],
   to: UMLBehavioredClassifier[Uml]): Try[Unit]

  def unlink_Behavior_behavioredClassifier_references_classifierBehavior_BehavioredClassifier
  (from: UMLBehavior[Uml],
   to: UMLBehavioredClassifier[Uml]): Try[Unit]

  def link_InterfaceRealization_implementingClassifier_composes_interfaceRealization_BehavioredClassifier
  (from: UMLInterfaceRealization[Uml],
   to: UMLBehavioredClassifier[Uml]): Try[Unit]

  def unlink_InterfaceRealization_implementingClassifier_composes_interfaceRealization_BehavioredClassifier
  (from: UMLInterfaceRealization[Uml],
   to: UMLBehavioredClassifier[Uml]): Try[Unit]

  def link_Behavior_behavioredClassifier_composes_ownedBehavior_BehavioredClassifier
  (from: UMLBehavior[Uml],
   to: UMLBehavioredClassifier[Uml]): Try[Unit]

  def unlink_Behavior_behavioredClassifier_composes_ownedBehavior_BehavioredClassifier
  (from: UMLBehavior[Uml],
   to: UMLBehavioredClassifier[Uml]): Try[Unit]


  // BroadcastSignalAction

  def link_Signal_broadcastSignalAction_references_signal_BroadcastSignalAction
  (from: UMLSignal[Uml],
   to: UMLBroadcastSignalAction[Uml]): Try[Unit]

  def unlink_Signal_broadcastSignalAction_references_signal_BroadcastSignalAction
  (from: UMLSignal[Uml],
   to: UMLBroadcastSignalAction[Uml]): Try[Unit]


  // CallAction

  def link_OutputPin_callAction_composes_result_CallAction
  (from: UMLOutputPin[Uml],
   to: UMLCallAction[Uml]): Try[Unit]

  def unlink_OutputPin_callAction_composes_result_CallAction
  (from: UMLOutputPin[Uml],
   to: UMLCallAction[Uml]): Try[Unit]

  def set_CallAction_isSynchronous
  (e: UMLCallAction[Uml], isSynchronous: Boolean): Try[Unit]


  // CallBehaviorAction

  def link_Behavior_callBehaviorAction_references_behavior_CallBehaviorAction
  (from: UMLBehavior[Uml],
   to: UMLCallBehaviorAction[Uml]): Try[Unit]

  def unlink_Behavior_callBehaviorAction_references_behavior_CallBehaviorAction
  (from: UMLBehavior[Uml],
   to: UMLCallBehaviorAction[Uml]): Try[Unit]


  // CallEvent

  def link_Operation_callEvent_references_operation_CallEvent
  (from: UMLOperation[Uml],
   to: UMLCallEvent[Uml]): Try[Unit]

  def unlink_Operation_callEvent_references_operation_CallEvent
  (from: UMLOperation[Uml],
   to: UMLCallEvent[Uml]): Try[Unit]


  // CallOperationAction

  def link_Operation_callOperationAction_references_operation_CallOperationAction
  (from: UMLOperation[Uml],
   to: UMLCallOperationAction[Uml]): Try[Unit]

  def unlink_Operation_callOperationAction_references_operation_CallOperationAction
  (from: UMLOperation[Uml],
   to: UMLCallOperationAction[Uml]): Try[Unit]

  def link_InputPin_callOperationAction_composes_target_CallOperationAction
  (from: UMLInputPin[Uml],
   to: UMLCallOperationAction[Uml]): Try[Unit]

  def unlink_InputPin_callOperationAction_composes_target_CallOperationAction
  (from: UMLInputPin[Uml],
   to: UMLCallOperationAction[Uml]): Try[Unit]


  // CentralBufferNode



  // ChangeEvent

  def link_ValueSpecification_changeEvent_composes_changeExpression_ChangeEvent
  (from: UMLValueSpecification[Uml],
   to: UMLChangeEvent[Uml]): Try[Unit]

  def unlink_ValueSpecification_changeEvent_composes_changeExpression_ChangeEvent
  (from: UMLValueSpecification[Uml],
   to: UMLChangeEvent[Uml]): Try[Unit]


  // Class

  def link_Classifier_nestingClass_composes_nestedClassifier_Class
  (from: UMLClassifier[Uml],
   to: UMLClass[Uml]): Try[Unit]

  def unlink_Classifier_nestingClass_composes_nestedClassifier_Class
  (from: UMLClassifier[Uml],
   to: UMLClass[Uml]): Try[Unit]

  def link_Property_class_composes_ownedAttribute_Class
  (from: UMLProperty[Uml],
   to: UMLClass[Uml]): Try[Unit]

  def unlink_Property_class_composes_ownedAttribute_Class
  (from: UMLProperty[Uml],
   to: UMLClass[Uml]): Try[Unit]

  def link_Operation_class_composes_ownedOperation_Class
  (from: UMLOperation[Uml],
   to: UMLClass[Uml]): Try[Unit]

  def unlink_Operation_class_composes_ownedOperation_Class
  (from: UMLOperation[Uml],
   to: UMLClass[Uml]): Try[Unit]

  def link_Reception_class_composes_ownedReception_Class
  (from: UMLReception[Uml],
   to: UMLClass[Uml]): Try[Unit]

  def unlink_Reception_class_composes_ownedReception_Class
  (from: UMLReception[Uml],
   to: UMLClass[Uml]): Try[Unit]

  def set_Class_isAbstract
  (e: UMLClass[Uml], isAbstract: Boolean): Try[Unit]

  def set_Class_isActive
  (e: UMLClass[Uml], isActive: Boolean): Try[Unit]


  // Classifier

  def link_CollaborationUse_classifier_composes_collaborationUse_Classifier
  (from: UMLCollaborationUse[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def unlink_CollaborationUse_classifier_composes_collaborationUse_Classifier
  (from: UMLCollaborationUse[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def link_Generalization_specific_composes_generalization_Classifier
  (from: UMLGeneralization[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def unlink_Generalization_specific_composes_generalization_Classifier
  (from: UMLGeneralization[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def link_RedefinableTemplateSignature_classifier_composes_ownedTemplateSignature_Classifier
  (from: UMLRedefinableTemplateSignature[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def unlink_RedefinableTemplateSignature_classifier_composes_ownedTemplateSignature_Classifier
  (from: UMLRedefinableTemplateSignature[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def link_UseCase_classifier_composes_ownedUseCase_Classifier
  (from: UMLUseCase[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def unlink_UseCase_classifier_composes_ownedUseCase_Classifier
  (from: UMLUseCase[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def link_GeneralizationSet_powertype_references_powertypeExtent_Classifier
  (from: UMLGeneralizationSet[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def unlink_GeneralizationSet_powertype_references_powertypeExtent_Classifier
  (from: UMLGeneralizationSet[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def link_Classifier_classifier_references_redefinedClassifier_Classifier
  (from: UMLClassifier[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def unlink_Classifier_classifier_references_redefinedClassifier_Classifier
  (from: UMLClassifier[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def link_CollaborationUse_classifier_references_representation_Classifier
  (from: UMLCollaborationUse[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def unlink_CollaborationUse_classifier_references_representation_Classifier
  (from: UMLCollaborationUse[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def link_Substitution_substitutingClassifier_composes_substitution_Classifier
  (from: UMLSubstitution[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def unlink_Substitution_substitutingClassifier_composes_substitution_Classifier
  (from: UMLSubstitution[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def link_ClassifierTemplateParameter_parameteredElement_references_templateParameter_Classifier
  (from: UMLClassifierTemplateParameter[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def unlink_ClassifierTemplateParameter_parameteredElement_references_templateParameter_Classifier
  (from: UMLClassifierTemplateParameter[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def link_UseCase_subject_references_useCase_Classifier
  (from: UMLUseCase[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def unlink_UseCase_subject_references_useCase_Classifier
  (from: UMLUseCase[Uml],
   to: UMLClassifier[Uml]): Try[Unit]

  def set_Classifier_isAbstract
  (e: UMLClassifier[Uml], isAbstract: Boolean): Try[Unit]

  def set_Classifier_isFinalSpecialization
  (e: UMLClassifier[Uml], isFinalSpecialization: Boolean): Try[Unit]


  // ClassifierTemplateParameter

  def link_Classifier_classifierTemplateParameter_references_constrainingClassifier_ClassifierTemplateParameter
  (from: UMLClassifier[Uml],
   to: UMLClassifierTemplateParameter[Uml]): Try[Unit]

  def unlink_Classifier_classifierTemplateParameter_references_constrainingClassifier_ClassifierTemplateParameter
  (from: UMLClassifier[Uml],
   to: UMLClassifierTemplateParameter[Uml]): Try[Unit]

  def link_Classifier_templateParameter_references_parameteredElement_ClassifierTemplateParameter
  (from: UMLClassifier[Uml],
   to: UMLClassifierTemplateParameter[Uml]): Try[Unit]

  def unlink_Classifier_templateParameter_references_parameteredElement_ClassifierTemplateParameter
  (from: UMLClassifier[Uml],
   to: UMLClassifierTemplateParameter[Uml]): Try[Unit]

  def set_ClassifierTemplateParameter_allowSubstitutable
  (e: UMLClassifierTemplateParameter[Uml], allowSubstitutable: Boolean): Try[Unit]


  // Clause

  def link_ExecutableNode_clause_references_body_Clause
  (from: UMLExecutableNode[Uml],
   to: UMLClause[Uml]): Try[Unit]

  def unlink_ExecutableNode_clause_references_body_Clause
  (from: UMLExecutableNode[Uml],
   to: UMLClause[Uml]): Try[Unit]

  def link_OutputPin_clause_references_bodyOutput_Clause
  (from: UMLOutputPin[Uml],
   to: UMLClause[Uml]): Try[Unit]

  def unlink_OutputPin_clause_references_bodyOutput_Clause
  (from: UMLOutputPin[Uml],
   to: UMLClause[Uml]): Try[Unit]

  def link_OutputPin_clause_references_decider_Clause
  (from: UMLOutputPin[Uml],
   to: UMLClause[Uml]): Try[Unit]

  def unlink_OutputPin_clause_references_decider_Clause
  (from: UMLOutputPin[Uml],
   to: UMLClause[Uml]): Try[Unit]

  def link_Clause_successorClause_references_predecessorClause_Clause
  (from: UMLClause[Uml],
   to: UMLClause[Uml]): Try[Unit]

  def unlink_Clause_successorClause_references_predecessorClause_Clause
  (from: UMLClause[Uml],
   to: UMLClause[Uml]): Try[Unit]

  def link_Clause_predecessorClause_references_successorClause_Clause
  (from: UMLClause[Uml],
   to: UMLClause[Uml]): Try[Unit]

  def unlink_Clause_predecessorClause_references_successorClause_Clause
  (from: UMLClause[Uml],
   to: UMLClause[Uml]): Try[Unit]

  def link_ExecutableNode_clause_references_test_Clause
  (from: UMLExecutableNode[Uml],
   to: UMLClause[Uml]): Try[Unit]

  def unlink_ExecutableNode_clause_references_test_Clause
  (from: UMLExecutableNode[Uml],
   to: UMLClause[Uml]): Try[Unit]


  // ClearAssociationAction

  def link_Association_clearAssociationAction_references_association_ClearAssociationAction
  (from: UMLAssociation[Uml],
   to: UMLClearAssociationAction[Uml]): Try[Unit]

  def unlink_Association_clearAssociationAction_references_association_ClearAssociationAction
  (from: UMLAssociation[Uml],
   to: UMLClearAssociationAction[Uml]): Try[Unit]

  def link_InputPin_clearAssociationAction_composes_object_ClearAssociationAction
  (from: UMLInputPin[Uml],
   to: UMLClearAssociationAction[Uml]): Try[Unit]

  def unlink_InputPin_clearAssociationAction_composes_object_ClearAssociationAction
  (from: UMLInputPin[Uml],
   to: UMLClearAssociationAction[Uml]): Try[Unit]


  // ClearStructuralFeatureAction

  def link_OutputPin_clearStructuralFeatureAction_composes_result_ClearStructuralFeatureAction
  (from: UMLOutputPin[Uml],
   to: UMLClearStructuralFeatureAction[Uml]): Try[Unit]

  def unlink_OutputPin_clearStructuralFeatureAction_composes_result_ClearStructuralFeatureAction
  (from: UMLOutputPin[Uml],
   to: UMLClearStructuralFeatureAction[Uml]): Try[Unit]


  // ClearVariableAction



  // Collaboration

  def link_ConnectableElement_collaboration_references_collaborationRole_Collaboration
  (from: UMLConnectableElement[Uml],
   to: UMLCollaboration[Uml]): Try[Unit]

  def unlink_ConnectableElement_collaboration_references_collaborationRole_Collaboration
  (from: UMLConnectableElement[Uml],
   to: UMLCollaboration[Uml]): Try[Unit]


  // CollaborationUse

  def link_Dependency_collaborationUse_composes_roleBinding_CollaborationUse
  (from: UMLDependency[Uml],
   to: UMLCollaborationUse[Uml]): Try[Unit]

  def unlink_Dependency_collaborationUse_composes_roleBinding_CollaborationUse
  (from: UMLDependency[Uml],
   to: UMLCollaborationUse[Uml]): Try[Unit]

  def link_Collaboration_collaborationUse_references_type_CollaborationUse
  (from: UMLCollaboration[Uml],
   to: UMLCollaborationUse[Uml]): Try[Unit]

  def unlink_Collaboration_collaborationUse_references_type_CollaborationUse
  (from: UMLCollaboration[Uml],
   to: UMLCollaborationUse[Uml]): Try[Unit]


  // CombinedFragment

  def link_Gate_combinedFragment_composes_cfragmentGate_CombinedFragment
  (from: UMLGate[Uml],
   to: UMLCombinedFragment[Uml]): Try[Unit]

  def unlink_Gate_combinedFragment_composes_cfragmentGate_CombinedFragment
  (from: UMLGate[Uml],
   to: UMLCombinedFragment[Uml]): Try[Unit]

  def link_InteractionOperand_combinedFragment_composes_operand_CombinedFragment
  (from: UMLInteractionOperand[Uml],
   to: UMLCombinedFragment[Uml]): Try[Unit]

  def unlink_InteractionOperand_combinedFragment_composes_operand_CombinedFragment
  (from: UMLInteractionOperand[Uml],
   to: UMLCombinedFragment[Uml]): Try[Unit]

  def set_CombinedFragment_interactionOperator
  (e: UMLCombinedFragment[Uml], interactionOperator: UMLInteractionOperatorKind.Value): Try[Unit]


  // Comment

  def link_Element_comment_references_annotatedElement_Comment
  (from: UMLElement[Uml],
   to: UMLComment[Uml]): Try[Unit]

  def unlink_Element_comment_references_annotatedElement_Comment
  (from: UMLElement[Uml],
   to: UMLComment[Uml]): Try[Unit]

  def set_Comment_body
  (e: UMLComment[Uml], body: Option[String]): Try[Unit]


  // CommunicationPath



  // Component

  def link_PackageableElement_component_composes_packagedElement_Component
  (from: UMLPackageableElement[Uml],
   to: UMLComponent[Uml]): Try[Unit]

  def unlink_PackageableElement_component_composes_packagedElement_Component
  (from: UMLPackageableElement[Uml],
   to: UMLComponent[Uml]): Try[Unit]

  def link_ComponentRealization_abstraction_composes_realization_Component
  (from: UMLComponentRealization[Uml],
   to: UMLComponent[Uml]): Try[Unit]

  def unlink_ComponentRealization_abstraction_composes_realization_Component
  (from: UMLComponentRealization[Uml],
   to: UMLComponent[Uml]): Try[Unit]

  def set_Component_isIndirectlyInstantiated
  (e: UMLComponent[Uml], isIndirectlyInstantiated: Boolean): Try[Unit]


  // ComponentRealization

  def link_Component_realization_references_abstraction_ComponentRealization
  (from: UMLComponent[Uml],
   to: UMLComponentRealization[Uml]): Try[Unit]

  def unlink_Component_realization_references_abstraction_ComponentRealization
  (from: UMLComponent[Uml],
   to: UMLComponentRealization[Uml]): Try[Unit]

  def link_Classifier_componentRealization_references_realizingClassifier_ComponentRealization
  (from: UMLClassifier[Uml],
   to: UMLComponentRealization[Uml]): Try[Unit]

  def unlink_Classifier_componentRealization_references_realizingClassifier_ComponentRealization
  (from: UMLClassifier[Uml],
   to: UMLComponentRealization[Uml]): Try[Unit]


  // ConditionalNode

  def link_Clause_conditionalNode_composes_clause_ConditionalNode
  (from: UMLClause[Uml],
   to: UMLConditionalNode[Uml]): Try[Unit]

  def unlink_Clause_conditionalNode_composes_clause_ConditionalNode
  (from: UMLClause[Uml],
   to: UMLConditionalNode[Uml]): Try[Unit]

  def link_OutputPin_conditionalNode_composes_result_ConditionalNode
  (from: UMLOutputPin[Uml],
   to: UMLConditionalNode[Uml]): Try[Unit]

  def unlink_OutputPin_conditionalNode_composes_result_ConditionalNode
  (from: UMLOutputPin[Uml],
   to: UMLConditionalNode[Uml]): Try[Unit]

  def set_ConditionalNode_isAssured
  (e: UMLConditionalNode[Uml], isAssured: Boolean): Try[Unit]

  def set_ConditionalNode_isDeterminate
  (e: UMLConditionalNode[Uml], isDeterminate: Boolean): Try[Unit]


  // ConnectableElement

  def link_ConnectableElementTemplateParameter_parameteredElement_references_templateParameter_ConnectableElement
  (from: UMLConnectableElementTemplateParameter[Uml],
   to: UMLConnectableElement[Uml]): Try[Unit]

  def unlink_ConnectableElementTemplateParameter_parameteredElement_references_templateParameter_ConnectableElement
  (from: UMLConnectableElementTemplateParameter[Uml],
   to: UMLConnectableElement[Uml]): Try[Unit]


  // ConnectableElementTemplateParameter

  def link_ConnectableElement_templateParameter_references_parameteredElement_ConnectableElementTemplateParameter
  (from: UMLConnectableElement[Uml],
   to: UMLConnectableElementTemplateParameter[Uml]): Try[Unit]

  def unlink_ConnectableElement_templateParameter_references_parameteredElement_ConnectableElementTemplateParameter
  (from: UMLConnectableElement[Uml],
   to: UMLConnectableElementTemplateParameter[Uml]): Try[Unit]


  // ConnectionPointReference

  def link_Pseudostate_connectionPointReference_references_entry_ConnectionPointReference
  (from: UMLPseudostate[Uml],
   to: UMLConnectionPointReference[Uml]): Try[Unit]

  def unlink_Pseudostate_connectionPointReference_references_entry_ConnectionPointReference
  (from: UMLPseudostate[Uml],
   to: UMLConnectionPointReference[Uml]): Try[Unit]

  def link_Pseudostate_connectionPointReference_references_exit_ConnectionPointReference
  (from: UMLPseudostate[Uml],
   to: UMLConnectionPointReference[Uml]): Try[Unit]

  def unlink_Pseudostate_connectionPointReference_references_exit_ConnectionPointReference
  (from: UMLPseudostate[Uml],
   to: UMLConnectionPointReference[Uml]): Try[Unit]

  def link_State_connection_references_state_ConnectionPointReference
  (from: UMLState[Uml],
   to: UMLConnectionPointReference[Uml]): Try[Unit]

  def unlink_State_connection_references_state_ConnectionPointReference
  (from: UMLState[Uml],
   to: UMLConnectionPointReference[Uml]): Try[Unit]


  // Connector

  def link_Behavior_connector_references_contract_Connector
  (from: UMLBehavior[Uml],
   to: UMLConnector[Uml]): Try[Unit]

  def unlink_Behavior_connector_references_contract_Connector
  (from: UMLBehavior[Uml],
   to: UMLConnector[Uml]): Try[Unit]

  def link_ConnectorEnd_connector_composes_end_Connector
  (from: UMLConnectorEnd[Uml],
   to: UMLConnector[Uml]): Try[Unit]

  def unlink_ConnectorEnd_connector_composes_end_Connector
  (from: UMLConnectorEnd[Uml],
   to: UMLConnector[Uml]): Try[Unit]

  def link_Connector_connector_references_redefinedConnector_Connector
  (from: UMLConnector[Uml],
   to: UMLConnector[Uml]): Try[Unit]

  def unlink_Connector_connector_references_redefinedConnector_Connector
  (from: UMLConnector[Uml],
   to: UMLConnector[Uml]): Try[Unit]

  def link_Association_connector_references_type_Connector
  (from: UMLAssociation[Uml],
   to: UMLConnector[Uml]): Try[Unit]

  def unlink_Association_connector_references_type_Connector
  (from: UMLAssociation[Uml],
   to: UMLConnector[Uml]): Try[Unit]

  def set_Connector_kind
  (e: UMLConnector[Uml], kind: UMLConnectorKind.Value): Try[Unit]


  // ConnectorEnd

  def link_Property_connectorEnd_references_partWithPort_ConnectorEnd
  (from: UMLProperty[Uml],
   to: UMLConnectorEnd[Uml]): Try[Unit]

  def unlink_Property_connectorEnd_references_partWithPort_ConnectorEnd
  (from: UMLProperty[Uml],
   to: UMLConnectorEnd[Uml]): Try[Unit]


  // ConsiderIgnoreFragment

  def link_NamedElement_considerIgnoreFragment_references_message_ConsiderIgnoreFragment
  (from: UMLNamedElement[Uml],
   to: UMLConsiderIgnoreFragment[Uml]): Try[Unit]

  def unlink_NamedElement_considerIgnoreFragment_references_message_ConsiderIgnoreFragment
  (from: UMLNamedElement[Uml],
   to: UMLConsiderIgnoreFragment[Uml]): Try[Unit]


  // Constraint

  def link_Element_constraint_references_constrainedElement_Constraint
  (from: UMLElement[Uml],
   to: UMLConstraint[Uml]): Try[Unit]

  def unlink_Element_constraint_references_constrainedElement_Constraint
  (from: UMLElement[Uml],
   to: UMLConstraint[Uml]): Try[Unit]

  def link_Namespace_ownedRule_references_context_Constraint
  (from: UMLNamespace[Uml],
   to: UMLConstraint[Uml]): Try[Unit]

  def unlink_Namespace_ownedRule_references_context_Constraint
  (from: UMLNamespace[Uml],
   to: UMLConstraint[Uml]): Try[Unit]

  def link_ValueSpecification_owningConstraint_composes_specification_Constraint
  (from: UMLValueSpecification[Uml],
   to: UMLConstraint[Uml]): Try[Unit]

  def unlink_ValueSpecification_owningConstraint_composes_specification_Constraint
  (from: UMLValueSpecification[Uml],
   to: UMLConstraint[Uml]): Try[Unit]


  // Continuation


  def set_Continuation_setting
  (e: UMLContinuation[Uml], setting: Boolean): Try[Unit]


  // ControlFlow



  // ControlNode



  // CreateLinkAction

  def link_LinkEndCreationData_createLinkAction_composes_endData_CreateLinkAction
  (from: UMLLinkEndCreationData[Uml],
   to: UMLCreateLinkAction[Uml]): Try[Unit]

  def unlink_LinkEndCreationData_createLinkAction_composes_endData_CreateLinkAction
  (from: UMLLinkEndCreationData[Uml],
   to: UMLCreateLinkAction[Uml]): Try[Unit]


  // CreateLinkObjectAction

  def link_OutputPin_createLinkObjectAction_composes_result_CreateLinkObjectAction
  (from: UMLOutputPin[Uml],
   to: UMLCreateLinkObjectAction[Uml]): Try[Unit]

  def unlink_OutputPin_createLinkObjectAction_composes_result_CreateLinkObjectAction
  (from: UMLOutputPin[Uml],
   to: UMLCreateLinkObjectAction[Uml]): Try[Unit]


  // CreateObjectAction

  def link_Classifier_createObjectAction_references_classifier_CreateObjectAction
  (from: UMLClassifier[Uml],
   to: UMLCreateObjectAction[Uml]): Try[Unit]

  def unlink_Classifier_createObjectAction_references_classifier_CreateObjectAction
  (from: UMLClassifier[Uml],
   to: UMLCreateObjectAction[Uml]): Try[Unit]

  def link_OutputPin_createObjectAction_composes_result_CreateObjectAction
  (from: UMLOutputPin[Uml],
   to: UMLCreateObjectAction[Uml]): Try[Unit]

  def unlink_OutputPin_createObjectAction_composes_result_CreateObjectAction
  (from: UMLOutputPin[Uml],
   to: UMLCreateObjectAction[Uml]): Try[Unit]


  // DataStoreNode



  // DataType

  def link_Property_datatype_composes_ownedAttribute_DataType
  (from: UMLProperty[Uml],
   to: UMLDataType[Uml]): Try[Unit]

  def unlink_Property_datatype_composes_ownedAttribute_DataType
  (from: UMLProperty[Uml],
   to: UMLDataType[Uml]): Try[Unit]

  def link_Operation_datatype_composes_ownedOperation_DataType
  (from: UMLOperation[Uml],
   to: UMLDataType[Uml]): Try[Unit]

  def unlink_Operation_datatype_composes_ownedOperation_DataType
  (from: UMLOperation[Uml],
   to: UMLDataType[Uml]): Try[Unit]


  // DecisionNode

  def link_Behavior_decisionNode_references_decisionInput_DecisionNode
  (from: UMLBehavior[Uml],
   to: UMLDecisionNode[Uml]): Try[Unit]

  def unlink_Behavior_decisionNode_references_decisionInput_DecisionNode
  (from: UMLBehavior[Uml],
   to: UMLDecisionNode[Uml]): Try[Unit]

  def link_ObjectFlow_decisionNode_references_decisionInputFlow_DecisionNode
  (from: UMLObjectFlow[Uml],
   to: UMLDecisionNode[Uml]): Try[Unit]

  def unlink_ObjectFlow_decisionNode_references_decisionInputFlow_DecisionNode
  (from: UMLObjectFlow[Uml],
   to: UMLDecisionNode[Uml]): Try[Unit]


  // Dependency

  def link_NamedElement_supplierDependency_references_supplier_Dependency
  (from: UMLNamedElement[Uml],
   to: UMLDependency[Uml]): Try[Unit]

  def unlink_NamedElement_supplierDependency_references_supplier_Dependency
  (from: UMLNamedElement[Uml],
   to: UMLDependency[Uml]): Try[Unit]


  // DeployedArtifact



  // Deployment

  def link_DeploymentSpecification_deployment_composes_configuration_Deployment
  (from: UMLDeploymentSpecification[Uml],
   to: UMLDeployment[Uml]): Try[Unit]

  def unlink_DeploymentSpecification_deployment_composes_configuration_Deployment
  (from: UMLDeploymentSpecification[Uml],
   to: UMLDeployment[Uml]): Try[Unit]

  def link_DeployedArtifact_deploymentForArtifact_references_deployedArtifact_Deployment
  (from: UMLDeployedArtifact[Uml],
   to: UMLDeployment[Uml]): Try[Unit]

  def unlink_DeployedArtifact_deploymentForArtifact_references_deployedArtifact_Deployment
  (from: UMLDeployedArtifact[Uml],
   to: UMLDeployment[Uml]): Try[Unit]

  def link_DeploymentTarget_deployment_references_location_Deployment
  (from: UMLDeploymentTarget[Uml],
   to: UMLDeployment[Uml]): Try[Unit]

  def unlink_DeploymentTarget_deployment_references_location_Deployment
  (from: UMLDeploymentTarget[Uml],
   to: UMLDeployment[Uml]): Try[Unit]


  // DeploymentSpecification

  def link_Deployment_configuration_references_deployment_DeploymentSpecification
  (from: UMLDeployment[Uml],
   to: UMLDeploymentSpecification[Uml]): Try[Unit]

  def unlink_Deployment_configuration_references_deployment_DeploymentSpecification
  (from: UMLDeployment[Uml],
   to: UMLDeploymentSpecification[Uml]): Try[Unit]

  def set_DeploymentSpecification_deploymentLocation
  (e: UMLDeploymentSpecification[Uml], deploymentLocation: Option[String]): Try[Unit]

  def set_DeploymentSpecification_executionLocation
  (e: UMLDeploymentSpecification[Uml], executionLocation: Option[String]): Try[Unit]


  // DeploymentTarget

  def link_Deployment_location_composes_deployment_DeploymentTarget
  (from: UMLDeployment[Uml],
   to: UMLDeploymentTarget[Uml]): Try[Unit]

  def unlink_Deployment_location_composes_deployment_DeploymentTarget
  (from: UMLDeployment[Uml],
   to: UMLDeploymentTarget[Uml]): Try[Unit]


  // DestroyLinkAction

  def link_LinkEndDestructionData_destroyLinkAction_composes_endData_DestroyLinkAction
  (from: UMLLinkEndDestructionData[Uml],
   to: UMLDestroyLinkAction[Uml]): Try[Unit]

  def unlink_LinkEndDestructionData_destroyLinkAction_composes_endData_DestroyLinkAction
  (from: UMLLinkEndDestructionData[Uml],
   to: UMLDestroyLinkAction[Uml]): Try[Unit]


  // DestroyObjectAction

  def link_InputPin_destroyObjectAction_composes_target_DestroyObjectAction
  (from: UMLInputPin[Uml],
   to: UMLDestroyObjectAction[Uml]): Try[Unit]

  def unlink_InputPin_destroyObjectAction_composes_target_DestroyObjectAction
  (from: UMLInputPin[Uml],
   to: UMLDestroyObjectAction[Uml]): Try[Unit]

  def set_DestroyObjectAction_isDestroyLinks
  (e: UMLDestroyObjectAction[Uml], isDestroyLinks: Boolean): Try[Unit]

  def set_DestroyObjectAction_isDestroyOwnedObjects
  (e: UMLDestroyObjectAction[Uml], isDestroyOwnedObjects: Boolean): Try[Unit]


  // DestructionOccurrenceSpecification



  // Device



  // DirectedRelationship



  // Duration

  def link_ValueSpecification_duration_composes_expr_Duration
  (from: UMLValueSpecification[Uml],
   to: UMLDuration[Uml]): Try[Unit]

  def unlink_ValueSpecification_duration_composes_expr_Duration
  (from: UMLValueSpecification[Uml],
   to: UMLDuration[Uml]): Try[Unit]

  def link_Observation_duration_references_observation_Duration
  (from: UMLObservation[Uml],
   to: UMLDuration[Uml]): Try[Unit]

  def unlink_Observation_duration_references_observation_Duration
  (from: UMLObservation[Uml],
   to: UMLDuration[Uml]): Try[Unit]


  // DurationConstraint

  def link_DurationInterval_durationConstraint_composes_specification_DurationConstraint
  (from: UMLDurationInterval[Uml],
   to: UMLDurationConstraint[Uml]): Try[Unit]

  def unlink_DurationInterval_durationConstraint_composes_specification_DurationConstraint
  (from: UMLDurationInterval[Uml],
   to: UMLDurationConstraint[Uml]): Try[Unit]

  def set_DurationConstraint_firstEvent
  (e: UMLDurationConstraint[Uml], firstEvent: Set[Boolean]): Try[Unit]


  // DurationInterval

  def link_Duration_durationInterval_references_max_DurationInterval
  (from: UMLDuration[Uml],
   to: UMLDurationInterval[Uml]): Try[Unit]

  def unlink_Duration_durationInterval_references_max_DurationInterval
  (from: UMLDuration[Uml],
   to: UMLDurationInterval[Uml]): Try[Unit]

  def link_Duration_durationInterval_references_min_DurationInterval
  (from: UMLDuration[Uml],
   to: UMLDurationInterval[Uml]): Try[Unit]

  def unlink_Duration_durationInterval_references_min_DurationInterval
  (from: UMLDuration[Uml],
   to: UMLDurationInterval[Uml]): Try[Unit]


  // DurationObservation

  def link_NamedElement_durationObservation_references_event_DurationObservation
  (from: UMLNamedElement[Uml],
   to: UMLDurationObservation[Uml]): Try[Unit]

  def unlink_NamedElement_durationObservation_references_event_DurationObservation
  (from: UMLNamedElement[Uml],
   to: UMLDurationObservation[Uml]): Try[Unit]

  def set_DurationObservation_firstEvent
  (e: UMLDurationObservation[Uml], firstEvent: Seq[Boolean]): Try[Unit]


  // Element

  def link_Comment_owningElement_composes_ownedComment_Element
  (from: UMLComment[Uml],
   to: UMLElement[Uml]): Try[Unit]

  def unlink_Comment_owningElement_composes_ownedComment_Element
  (from: UMLComment[Uml],
   to: UMLElement[Uml]): Try[Unit]


  // ElementImport

  def link_PackageableElement_import_references_importedElement_ElementImport
  (from: UMLPackageableElement[Uml],
   to: UMLElementImport[Uml]): Try[Unit]

  def unlink_PackageableElement_import_references_importedElement_ElementImport
  (from: UMLPackageableElement[Uml],
   to: UMLElementImport[Uml]): Try[Unit]

  def link_Namespace_elementImport_references_importingNamespace_ElementImport
  (from: UMLNamespace[Uml],
   to: UMLElementImport[Uml]): Try[Unit]

  def unlink_Namespace_elementImport_references_importingNamespace_ElementImport
  (from: UMLNamespace[Uml],
   to: UMLElementImport[Uml]): Try[Unit]

  def set_ElementImport_alias
  (e: UMLElementImport[Uml], alias: Option[String]): Try[Unit]

  def set_ElementImport_visibility
  (e: UMLElementImport[Uml], visibility: UMLVisibilityKind.Value): Try[Unit]


  // EncapsulatedClassifier



  // Enumeration

  def link_EnumerationLiteral_enumeration_composes_ownedLiteral_Enumeration
  (from: UMLEnumerationLiteral[Uml],
   to: UMLEnumeration[Uml]): Try[Unit]

  def unlink_EnumerationLiteral_enumeration_composes_ownedLiteral_Enumeration
  (from: UMLEnumerationLiteral[Uml],
   to: UMLEnumeration[Uml]): Try[Unit]


  // EnumerationLiteral

  def link_Enumeration_ownedLiteral_references_enumeration_EnumerationLiteral
  (from: UMLEnumeration[Uml],
   to: UMLEnumerationLiteral[Uml]): Try[Unit]

  def unlink_Enumeration_ownedLiteral_references_enumeration_EnumerationLiteral
  (from: UMLEnumeration[Uml],
   to: UMLEnumerationLiteral[Uml]): Try[Unit]


  // Event



  // ExceptionHandler

  def link_ObjectNode_exceptionHandler_references_exceptionInput_ExceptionHandler
  (from: UMLObjectNode[Uml],
   to: UMLExceptionHandler[Uml]): Try[Unit]

  def unlink_ObjectNode_exceptionHandler_references_exceptionInput_ExceptionHandler
  (from: UMLObjectNode[Uml],
   to: UMLExceptionHandler[Uml]): Try[Unit]

  def link_Classifier_exceptionHandler_references_exceptionType_ExceptionHandler
  (from: UMLClassifier[Uml],
   to: UMLExceptionHandler[Uml]): Try[Unit]

  def unlink_Classifier_exceptionHandler_references_exceptionType_ExceptionHandler
  (from: UMLClassifier[Uml],
   to: UMLExceptionHandler[Uml]): Try[Unit]

  def link_ExecutableNode_exceptionHandler_references_handlerBody_ExceptionHandler
  (from: UMLExecutableNode[Uml],
   to: UMLExceptionHandler[Uml]): Try[Unit]

  def unlink_ExecutableNode_exceptionHandler_references_handlerBody_ExceptionHandler
  (from: UMLExecutableNode[Uml],
   to: UMLExceptionHandler[Uml]): Try[Unit]

  def link_ExecutableNode_handler_references_protectedNode_ExceptionHandler
  (from: UMLExecutableNode[Uml],
   to: UMLExceptionHandler[Uml]): Try[Unit]

  def unlink_ExecutableNode_handler_references_protectedNode_ExceptionHandler
  (from: UMLExecutableNode[Uml],
   to: UMLExceptionHandler[Uml]): Try[Unit]


  // ExecutableNode

  def link_ExceptionHandler_protectedNode_composes_handler_ExecutableNode
  (from: UMLExceptionHandler[Uml],
   to: UMLExecutableNode[Uml]): Try[Unit]

  def unlink_ExceptionHandler_protectedNode_composes_handler_ExecutableNode
  (from: UMLExceptionHandler[Uml],
   to: UMLExecutableNode[Uml]): Try[Unit]


  // ExecutionEnvironment



  // ExecutionOccurrenceSpecification

  def link_ExecutionSpecification_executionOccurrenceSpecification_references_execution_ExecutionOccurrenceSpecification
  (from: UMLExecutionSpecification[Uml],
   to: UMLExecutionOccurrenceSpecification[Uml]): Try[Unit]

  def unlink_ExecutionSpecification_executionOccurrenceSpecification_references_execution_ExecutionOccurrenceSpecification
  (from: UMLExecutionSpecification[Uml],
   to: UMLExecutionOccurrenceSpecification[Uml]): Try[Unit]


  // ExecutionSpecification

  def link_OccurrenceSpecification_executionSpecification_references_finish_ExecutionSpecification
  (from: UMLOccurrenceSpecification[Uml],
   to: UMLExecutionSpecification[Uml]): Try[Unit]

  def unlink_OccurrenceSpecification_executionSpecification_references_finish_ExecutionSpecification
  (from: UMLOccurrenceSpecification[Uml],
   to: UMLExecutionSpecification[Uml]): Try[Unit]

  def link_OccurrenceSpecification_executionSpecification_references_start_ExecutionSpecification
  (from: UMLOccurrenceSpecification[Uml],
   to: UMLExecutionSpecification[Uml]): Try[Unit]

  def unlink_OccurrenceSpecification_executionSpecification_references_start_ExecutionSpecification
  (from: UMLOccurrenceSpecification[Uml],
   to: UMLExecutionSpecification[Uml]): Try[Unit]


  // ExpansionNode

  def link_ExpansionRegion_inputElement_references_regionAsInput_ExpansionNode
  (from: UMLExpansionRegion[Uml],
   to: UMLExpansionNode[Uml]): Try[Unit]

  def unlink_ExpansionRegion_inputElement_references_regionAsInput_ExpansionNode
  (from: UMLExpansionRegion[Uml],
   to: UMLExpansionNode[Uml]): Try[Unit]

  def link_ExpansionRegion_outputElement_references_regionAsOutput_ExpansionNode
  (from: UMLExpansionRegion[Uml],
   to: UMLExpansionNode[Uml]): Try[Unit]

  def unlink_ExpansionRegion_outputElement_references_regionAsOutput_ExpansionNode
  (from: UMLExpansionRegion[Uml],
   to: UMLExpansionNode[Uml]): Try[Unit]


  // ExpansionRegion

  def link_ExpansionNode_regionAsInput_references_inputElement_ExpansionRegion
  (from: UMLExpansionNode[Uml],
   to: UMLExpansionRegion[Uml]): Try[Unit]

  def unlink_ExpansionNode_regionAsInput_references_inputElement_ExpansionRegion
  (from: UMLExpansionNode[Uml],
   to: UMLExpansionRegion[Uml]): Try[Unit]

  def link_ExpansionNode_regionAsOutput_references_outputElement_ExpansionRegion
  (from: UMLExpansionNode[Uml],
   to: UMLExpansionRegion[Uml]): Try[Unit]

  def unlink_ExpansionNode_regionAsOutput_references_outputElement_ExpansionRegion
  (from: UMLExpansionNode[Uml],
   to: UMLExpansionRegion[Uml]): Try[Unit]

  def set_ExpansionRegion_mode
  (e: UMLExpansionRegion[Uml], mode: UMLExpansionKind.Value): Try[Unit]


  // Expression

  def link_ValueSpecification_expression_composes_operand_Expression
  (from: UMLValueSpecification[Uml],
   to: UMLExpression[Uml]): Try[Unit]

  def unlink_ValueSpecification_expression_composes_operand_Expression
  (from: UMLValueSpecification[Uml],
   to: UMLExpression[Uml]): Try[Unit]

  def set_Expression_symbol
  (e: UMLExpression[Uml], symbol: Option[String]): Try[Unit]


  // Extend

  def link_Constraint_extend_composes_condition_Extend
  (from: UMLConstraint[Uml],
   to: UMLExtend[Uml]): Try[Unit]

  def unlink_Constraint_extend_composes_condition_Extend
  (from: UMLConstraint[Uml],
   to: UMLExtend[Uml]): Try[Unit]

  def link_UseCase_extend_references_extendedCase_Extend
  (from: UMLUseCase[Uml],
   to: UMLExtend[Uml]): Try[Unit]

  def unlink_UseCase_extend_references_extendedCase_Extend
  (from: UMLUseCase[Uml],
   to: UMLExtend[Uml]): Try[Unit]

  def link_UseCase_extend_references_extension_Extend
  (from: UMLUseCase[Uml],
   to: UMLExtend[Uml]): Try[Unit]

  def unlink_UseCase_extend_references_extension_Extend
  (from: UMLUseCase[Uml],
   to: UMLExtend[Uml]): Try[Unit]

  def link_ExtensionPoint_extension_references_extensionLocation_Extend
  (from: UMLExtensionPoint[Uml],
   to: UMLExtend[Uml]): Try[Unit]

  def unlink_ExtensionPoint_extension_references_extensionLocation_Extend
  (from: UMLExtensionPoint[Uml],
   to: UMLExtend[Uml]): Try[Unit]


  // Extension

  def link_ExtensionEnd_extension_composes_ownedEnd_Extension
  (from: UMLExtensionEnd[Uml],
   to: UMLExtension[Uml]): Try[Unit]

  def unlink_ExtensionEnd_extension_composes_ownedEnd_Extension
  (from: UMLExtensionEnd[Uml],
   to: UMLExtension[Uml]): Try[Unit]

  def set_Extension_isRequired
  (e: UMLExtension[Uml], isRequired: Boolean): Try[Unit]


  // ExtensionEnd

  def link_Stereotype_extensionEnd_references_type_ExtensionEnd
  (from: UMLStereotype[Uml],
   to: UMLExtensionEnd[Uml]): Try[Unit]

  def unlink_Stereotype_extensionEnd_references_type_ExtensionEnd
  (from: UMLStereotype[Uml],
   to: UMLExtensionEnd[Uml]): Try[Unit]

  def set_ExtensionEnd_lower
  (e: UMLExtensionEnd[Uml], lower: Integer): Try[Unit]


  // ExtensionPoint

  def link_UseCase_extensionPoint_references_useCase_ExtensionPoint
  (from: UMLUseCase[Uml],
   to: UMLExtensionPoint[Uml]): Try[Unit]

  def unlink_UseCase_extensionPoint_references_useCase_ExtensionPoint
  (from: UMLUseCase[Uml],
   to: UMLExtensionPoint[Uml]): Try[Unit]


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

  def link_OccurrenceSpecification_toBefore_references_after_GeneralOrdering
  (from: UMLOccurrenceSpecification[Uml],
   to: UMLGeneralOrdering[Uml]): Try[Unit]

  def unlink_OccurrenceSpecification_toBefore_references_after_GeneralOrdering
  (from: UMLOccurrenceSpecification[Uml],
   to: UMLGeneralOrdering[Uml]): Try[Unit]

  def link_OccurrenceSpecification_toAfter_references_before_GeneralOrdering
  (from: UMLOccurrenceSpecification[Uml],
   to: UMLGeneralOrdering[Uml]): Try[Unit]

  def unlink_OccurrenceSpecification_toAfter_references_before_GeneralOrdering
  (from: UMLOccurrenceSpecification[Uml],
   to: UMLGeneralOrdering[Uml]): Try[Unit]


  // Generalization

  def link_Classifier_generalization_references_general_Generalization
  (from: UMLClassifier[Uml],
   to: UMLGeneralization[Uml]): Try[Unit]

  def unlink_Classifier_generalization_references_general_Generalization
  (from: UMLClassifier[Uml],
   to: UMLGeneralization[Uml]): Try[Unit]

  def link_GeneralizationSet_generalization_references_generalizationSet_Generalization
  (from: UMLGeneralizationSet[Uml],
   to: UMLGeneralization[Uml]): Try[Unit]

  def unlink_GeneralizationSet_generalization_references_generalizationSet_Generalization
  (from: UMLGeneralizationSet[Uml],
   to: UMLGeneralization[Uml]): Try[Unit]

  def link_Classifier_generalization_references_specific_Generalization
  (from: UMLClassifier[Uml],
   to: UMLGeneralization[Uml]): Try[Unit]

  def unlink_Classifier_generalization_references_specific_Generalization
  (from: UMLClassifier[Uml],
   to: UMLGeneralization[Uml]): Try[Unit]

  def set_Generalization_isSubstitutable
  (e: UMLGeneralization[Uml], isSubstitutable: Option[Boolean]): Try[Unit]


  // GeneralizationSet

  def link_Generalization_generalizationSet_references_generalization_GeneralizationSet
  (from: UMLGeneralization[Uml],
   to: UMLGeneralizationSet[Uml]): Try[Unit]

  def unlink_Generalization_generalizationSet_references_generalization_GeneralizationSet
  (from: UMLGeneralization[Uml],
   to: UMLGeneralizationSet[Uml]): Try[Unit]

  def link_Classifier_powertypeExtent_references_powertype_GeneralizationSet
  (from: UMLClassifier[Uml],
   to: UMLGeneralizationSet[Uml]): Try[Unit]

  def unlink_Classifier_powertypeExtent_references_powertype_GeneralizationSet
  (from: UMLClassifier[Uml],
   to: UMLGeneralizationSet[Uml]): Try[Unit]

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

  def link_UseCase_include_references_addition_Include
  (from: UMLUseCase[Uml],
   to: UMLInclude[Uml]): Try[Unit]

  def unlink_UseCase_include_references_addition_Include
  (from: UMLUseCase[Uml],
   to: UMLInclude[Uml]): Try[Unit]

  def link_UseCase_include_references_includingCase_Include
  (from: UMLUseCase[Uml],
   to: UMLInclude[Uml]): Try[Unit]

  def unlink_UseCase_include_references_includingCase_Include
  (from: UMLUseCase[Uml],
   to: UMLInclude[Uml]): Try[Unit]


  // InformationFlow

  def link_Classifier_conveyingFlow_references_conveyed_InformationFlow
  (from: UMLClassifier[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def unlink_Classifier_conveyingFlow_references_conveyed_InformationFlow
  (from: UMLClassifier[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def link_NamedElement_informationFlow_references_informationSource_InformationFlow
  (from: UMLNamedElement[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def unlink_NamedElement_informationFlow_references_informationSource_InformationFlow
  (from: UMLNamedElement[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def link_NamedElement_informationFlow_references_informationTarget_InformationFlow
  (from: UMLNamedElement[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def unlink_NamedElement_informationFlow_references_informationTarget_InformationFlow
  (from: UMLNamedElement[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def link_Relationship_abstraction_references_realization_InformationFlow
  (from: UMLRelationship[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def unlink_Relationship_abstraction_references_realization_InformationFlow
  (from: UMLRelationship[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def link_ActivityEdge_informationFlow_references_realizingActivityEdge_InformationFlow
  (from: UMLActivityEdge[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def unlink_ActivityEdge_informationFlow_references_realizingActivityEdge_InformationFlow
  (from: UMLActivityEdge[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def link_Connector_informationFlow_references_realizingConnector_InformationFlow
  (from: UMLConnector[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def unlink_Connector_informationFlow_references_realizingConnector_InformationFlow
  (from: UMLConnector[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def link_Message_informationFlow_references_realizingMessage_InformationFlow
  (from: UMLMessage[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]

  def unlink_Message_informationFlow_references_realizingMessage_InformationFlow
  (from: UMLMessage[Uml],
   to: UMLInformationFlow[Uml]): Try[Unit]


  // InformationItem

  def link_Classifier_representation_references_represented_InformationItem
  (from: UMLClassifier[Uml],
   to: UMLInformationItem[Uml]): Try[Unit]

  def unlink_Classifier_representation_references_represented_InformationItem
  (from: UMLClassifier[Uml],
   to: UMLInformationItem[Uml]): Try[Unit]


  // InitialNode



  // InputPin



  // InstanceSpecification

  def link_Classifier_instanceSpecification_references_classifier_InstanceSpecification
  (from: UMLClassifier[Uml],
   to: UMLInstanceSpecification[Uml]): Try[Unit]

  def unlink_Classifier_instanceSpecification_references_classifier_InstanceSpecification
  (from: UMLClassifier[Uml],
   to: UMLInstanceSpecification[Uml]): Try[Unit]

  def link_Slot_owningInstance_composes_slot_InstanceSpecification
  (from: UMLSlot[Uml],
   to: UMLInstanceSpecification[Uml]): Try[Unit]

  def unlink_Slot_owningInstance_composes_slot_InstanceSpecification
  (from: UMLSlot[Uml],
   to: UMLInstanceSpecification[Uml]): Try[Unit]

  def link_ValueSpecification_owningInstanceSpec_composes_specification_InstanceSpecification
  (from: UMLValueSpecification[Uml],
   to: UMLInstanceSpecification[Uml]): Try[Unit]

  def unlink_ValueSpecification_owningInstanceSpec_composes_specification_InstanceSpecification
  (from: UMLValueSpecification[Uml],
   to: UMLInstanceSpecification[Uml]): Try[Unit]


  // InstanceValue

  def link_InstanceSpecification_instanceValue_references_instance_InstanceValue
  (from: UMLInstanceSpecification[Uml],
   to: UMLInstanceValue[Uml]): Try[Unit]

  def unlink_InstanceSpecification_instanceValue_references_instance_InstanceValue
  (from: UMLInstanceSpecification[Uml],
   to: UMLInstanceValue[Uml]): Try[Unit]


  // Interaction

  def link_Action_interaction_composes_action_Interaction
  (from: UMLAction[Uml],
   to: UMLInteraction[Uml]): Try[Unit]

  def unlink_Action_interaction_composes_action_Interaction
  (from: UMLAction[Uml],
   to: UMLInteraction[Uml]): Try[Unit]

  def link_Gate_interaction_composes_formalGate_Interaction
  (from: UMLGate[Uml],
   to: UMLInteraction[Uml]): Try[Unit]

  def unlink_Gate_interaction_composes_formalGate_Interaction
  (from: UMLGate[Uml],
   to: UMLInteraction[Uml]): Try[Unit]

  def link_InteractionFragment_enclosingInteraction_composes_fragment_Interaction
  (from: UMLInteractionFragment[Uml],
   to: UMLInteraction[Uml]): Try[Unit]

  def unlink_InteractionFragment_enclosingInteraction_composes_fragment_Interaction
  (from: UMLInteractionFragment[Uml],
   to: UMLInteraction[Uml]): Try[Unit]

  def link_Lifeline_interaction_composes_lifeline_Interaction
  (from: UMLLifeline[Uml],
   to: UMLInteraction[Uml]): Try[Unit]

  def unlink_Lifeline_interaction_composes_lifeline_Interaction
  (from: UMLLifeline[Uml],
   to: UMLInteraction[Uml]): Try[Unit]

  def link_Message_interaction_composes_message_Interaction
  (from: UMLMessage[Uml],
   to: UMLInteraction[Uml]): Try[Unit]

  def unlink_Message_interaction_composes_message_Interaction
  (from: UMLMessage[Uml],
   to: UMLInteraction[Uml]): Try[Unit]


  // InteractionConstraint

  def link_ValueSpecification_interactionConstraint_composes_maxint_InteractionConstraint
  (from: UMLValueSpecification[Uml],
   to: UMLInteractionConstraint[Uml]): Try[Unit]

  def unlink_ValueSpecification_interactionConstraint_composes_maxint_InteractionConstraint
  (from: UMLValueSpecification[Uml],
   to: UMLInteractionConstraint[Uml]): Try[Unit]

  def link_ValueSpecification_interactionConstraint_composes_minint_InteractionConstraint
  (from: UMLValueSpecification[Uml],
   to: UMLInteractionConstraint[Uml]): Try[Unit]

  def unlink_ValueSpecification_interactionConstraint_composes_minint_InteractionConstraint
  (from: UMLValueSpecification[Uml],
   to: UMLInteractionConstraint[Uml]): Try[Unit]


  // InteractionFragment

  def link_Lifeline_coveredBy_references_covered_InteractionFragment
  (from: UMLLifeline[Uml],
   to: UMLInteractionFragment[Uml]): Try[Unit]

  def unlink_Lifeline_coveredBy_references_covered_InteractionFragment
  (from: UMLLifeline[Uml],
   to: UMLInteractionFragment[Uml]): Try[Unit]

  def link_Interaction_fragment_references_enclosingInteraction_InteractionFragment
  (from: UMLInteraction[Uml],
   to: UMLInteractionFragment[Uml]): Try[Unit]

  def unlink_Interaction_fragment_references_enclosingInteraction_InteractionFragment
  (from: UMLInteraction[Uml],
   to: UMLInteractionFragment[Uml]): Try[Unit]

  def link_InteractionOperand_fragment_references_enclosingOperand_InteractionFragment
  (from: UMLInteractionOperand[Uml],
   to: UMLInteractionFragment[Uml]): Try[Unit]

  def unlink_InteractionOperand_fragment_references_enclosingOperand_InteractionFragment
  (from: UMLInteractionOperand[Uml],
   to: UMLInteractionFragment[Uml]): Try[Unit]

  def link_GeneralOrdering_interactionFragment_composes_generalOrdering_InteractionFragment
  (from: UMLGeneralOrdering[Uml],
   to: UMLInteractionFragment[Uml]): Try[Unit]

  def unlink_GeneralOrdering_interactionFragment_composes_generalOrdering_InteractionFragment
  (from: UMLGeneralOrdering[Uml],
   to: UMLInteractionFragment[Uml]): Try[Unit]


  // InteractionOperand

  def link_InteractionFragment_enclosingOperand_composes_fragment_InteractionOperand
  (from: UMLInteractionFragment[Uml],
   to: UMLInteractionOperand[Uml]): Try[Unit]

  def unlink_InteractionFragment_enclosingOperand_composes_fragment_InteractionOperand
  (from: UMLInteractionFragment[Uml],
   to: UMLInteractionOperand[Uml]): Try[Unit]

  def link_InteractionConstraint_interactionOperand_composes_guard_InteractionOperand
  (from: UMLInteractionConstraint[Uml],
   to: UMLInteractionOperand[Uml]): Try[Unit]

  def unlink_InteractionConstraint_interactionOperand_composes_guard_InteractionOperand
  (from: UMLInteractionConstraint[Uml],
   to: UMLInteractionOperand[Uml]): Try[Unit]


  // InteractionUse

  def link_Gate_interactionUse_composes_actualGate_InteractionUse
  (from: UMLGate[Uml],
   to: UMLInteractionUse[Uml]): Try[Unit]

  def unlink_Gate_interactionUse_composes_actualGate_InteractionUse
  (from: UMLGate[Uml],
   to: UMLInteractionUse[Uml]): Try[Unit]

  def link_ValueSpecification_interactionUse_composes_argument_InteractionUse
  (from: UMLValueSpecification[Uml],
   to: UMLInteractionUse[Uml]): Try[Unit]

  def unlink_ValueSpecification_interactionUse_composes_argument_InteractionUse
  (from: UMLValueSpecification[Uml],
   to: UMLInteractionUse[Uml]): Try[Unit]

  def link_Interaction_interactionUse_references_refersTo_InteractionUse
  (from: UMLInteraction[Uml],
   to: UMLInteractionUse[Uml]): Try[Unit]

  def unlink_Interaction_interactionUse_references_refersTo_InteractionUse
  (from: UMLInteraction[Uml],
   to: UMLInteractionUse[Uml]): Try[Unit]

  def link_ValueSpecification_interactionUse_composes_returnValue_InteractionUse
  (from: UMLValueSpecification[Uml],
   to: UMLInteractionUse[Uml]): Try[Unit]

  def unlink_ValueSpecification_interactionUse_composes_returnValue_InteractionUse
  (from: UMLValueSpecification[Uml],
   to: UMLInteractionUse[Uml]): Try[Unit]

  def link_Property_interactionUse_references_returnValueRecipient_InteractionUse
  (from: UMLProperty[Uml],
   to: UMLInteractionUse[Uml]): Try[Unit]

  def unlink_Property_interactionUse_references_returnValueRecipient_InteractionUse
  (from: UMLProperty[Uml],
   to: UMLInteractionUse[Uml]): Try[Unit]


  // Interface

  def link_Classifier_interface_composes_nestedClassifier_Interface
  (from: UMLClassifier[Uml],
   to: UMLInterface[Uml]): Try[Unit]

  def unlink_Classifier_interface_composes_nestedClassifier_Interface
  (from: UMLClassifier[Uml],
   to: UMLInterface[Uml]): Try[Unit]

  def link_Property_interface_composes_ownedAttribute_Interface
  (from: UMLProperty[Uml],
   to: UMLInterface[Uml]): Try[Unit]

  def unlink_Property_interface_composes_ownedAttribute_Interface
  (from: UMLProperty[Uml],
   to: UMLInterface[Uml]): Try[Unit]

  def link_Operation_interface_composes_ownedOperation_Interface
  (from: UMLOperation[Uml],
   to: UMLInterface[Uml]): Try[Unit]

  def unlink_Operation_interface_composes_ownedOperation_Interface
  (from: UMLOperation[Uml],
   to: UMLInterface[Uml]): Try[Unit]

  def link_Reception_interface_composes_ownedReception_Interface
  (from: UMLReception[Uml],
   to: UMLInterface[Uml]): Try[Unit]

  def unlink_Reception_interface_composes_ownedReception_Interface
  (from: UMLReception[Uml],
   to: UMLInterface[Uml]): Try[Unit]

  def link_ProtocolStateMachine_interface_composes_protocol_Interface
  (from: UMLProtocolStateMachine[Uml],
   to: UMLInterface[Uml]): Try[Unit]

  def unlink_ProtocolStateMachine_interface_composes_protocol_Interface
  (from: UMLProtocolStateMachine[Uml],
   to: UMLInterface[Uml]): Try[Unit]

  def link_Interface_interface_references_redefinedInterface_Interface
  (from: UMLInterface[Uml],
   to: UMLInterface[Uml]): Try[Unit]

  def unlink_Interface_interface_references_redefinedInterface_Interface
  (from: UMLInterface[Uml],
   to: UMLInterface[Uml]): Try[Unit]


  // InterfaceRealization

  def link_Interface_interfaceRealization_references_contract_InterfaceRealization
  (from: UMLInterface[Uml],
   to: UMLInterfaceRealization[Uml]): Try[Unit]

  def unlink_Interface_interfaceRealization_references_contract_InterfaceRealization
  (from: UMLInterface[Uml],
   to: UMLInterfaceRealization[Uml]): Try[Unit]

  def link_BehavioredClassifier_interfaceRealization_references_implementingClassifier_InterfaceRealization
  (from: UMLBehavioredClassifier[Uml],
   to: UMLInterfaceRealization[Uml]): Try[Unit]

  def unlink_BehavioredClassifier_interfaceRealization_references_implementingClassifier_InterfaceRealization
  (from: UMLBehavioredClassifier[Uml],
   to: UMLInterfaceRealization[Uml]): Try[Unit]


  // InterruptibleActivityRegion

  def link_ActivityEdge_interrupts_references_interruptingEdge_InterruptibleActivityRegion
  (from: UMLActivityEdge[Uml],
   to: UMLInterruptibleActivityRegion[Uml]): Try[Unit]

  def unlink_ActivityEdge_interrupts_references_interruptingEdge_InterruptibleActivityRegion
  (from: UMLActivityEdge[Uml],
   to: UMLInterruptibleActivityRegion[Uml]): Try[Unit]

  def link_ActivityNode_inInterruptibleRegion_references_node_InterruptibleActivityRegion
  (from: UMLActivityNode[Uml],
   to: UMLInterruptibleActivityRegion[Uml]): Try[Unit]

  def unlink_ActivityNode_inInterruptibleRegion_references_node_InterruptibleActivityRegion
  (from: UMLActivityNode[Uml],
   to: UMLInterruptibleActivityRegion[Uml]): Try[Unit]


  // Interval

  def link_ValueSpecification_interval_references_max_Interval
  (from: UMLValueSpecification[Uml],
   to: UMLInterval[Uml]): Try[Unit]

  def unlink_ValueSpecification_interval_references_max_Interval
  (from: UMLValueSpecification[Uml],
   to: UMLInterval[Uml]): Try[Unit]

  def link_ValueSpecification_interval_references_min_Interval
  (from: UMLValueSpecification[Uml],
   to: UMLInterval[Uml]): Try[Unit]

  def unlink_ValueSpecification_interval_references_min_Interval
  (from: UMLValueSpecification[Uml],
   to: UMLInterval[Uml]): Try[Unit]


  // IntervalConstraint

  def link_Interval_intervalConstraint_composes_specification_IntervalConstraint
  (from: UMLInterval[Uml],
   to: UMLIntervalConstraint[Uml]): Try[Unit]

  def unlink_Interval_intervalConstraint_composes_specification_IntervalConstraint
  (from: UMLInterval[Uml],
   to: UMLIntervalConstraint[Uml]): Try[Unit]


  // InvocationAction

  def link_InputPin_invocationAction_composes_argument_InvocationAction
  (from: UMLInputPin[Uml],
   to: UMLInvocationAction[Uml]): Try[Unit]

  def unlink_InputPin_invocationAction_composes_argument_InvocationAction
  (from: UMLInputPin[Uml],
   to: UMLInvocationAction[Uml]): Try[Unit]

  def link_Port_invocationAction_references_onPort_InvocationAction
  (from: UMLPort[Uml],
   to: UMLInvocationAction[Uml]): Try[Unit]

  def unlink_Port_invocationAction_references_onPort_InvocationAction
  (from: UMLPort[Uml],
   to: UMLInvocationAction[Uml]): Try[Unit]


  // JoinNode

  def link_ValueSpecification_joinNode_composes_joinSpec_JoinNode
  (from: UMLValueSpecification[Uml],
   to: UMLJoinNode[Uml]): Try[Unit]

  def unlink_ValueSpecification_joinNode_composes_joinSpec_JoinNode
  (from: UMLValueSpecification[Uml],
   to: UMLJoinNode[Uml]): Try[Unit]

  def set_JoinNode_isCombineDuplicate
  (e: UMLJoinNode[Uml], isCombineDuplicate: Boolean): Try[Unit]


  // Lifeline

  def link_InteractionFragment_covered_references_coveredBy_Lifeline
  (from: UMLInteractionFragment[Uml],
   to: UMLLifeline[Uml]): Try[Unit]

  def unlink_InteractionFragment_covered_references_coveredBy_Lifeline
  (from: UMLInteractionFragment[Uml],
   to: UMLLifeline[Uml]): Try[Unit]

  def link_PartDecomposition_lifeline_references_decomposedAs_Lifeline
  (from: UMLPartDecomposition[Uml],
   to: UMLLifeline[Uml]): Try[Unit]

  def unlink_PartDecomposition_lifeline_references_decomposedAs_Lifeline
  (from: UMLPartDecomposition[Uml],
   to: UMLLifeline[Uml]): Try[Unit]

  def link_Interaction_lifeline_references_interaction_Lifeline
  (from: UMLInteraction[Uml],
   to: UMLLifeline[Uml]): Try[Unit]

  def unlink_Interaction_lifeline_references_interaction_Lifeline
  (from: UMLInteraction[Uml],
   to: UMLLifeline[Uml]): Try[Unit]

  def link_ConnectableElement_lifeline_references_represents_Lifeline
  (from: UMLConnectableElement[Uml],
   to: UMLLifeline[Uml]): Try[Unit]

  def unlink_ConnectableElement_lifeline_references_represents_Lifeline
  (from: UMLConnectableElement[Uml],
   to: UMLLifeline[Uml]): Try[Unit]

  def link_ValueSpecification_lifeline_composes_selector_Lifeline
  (from: UMLValueSpecification[Uml],
   to: UMLLifeline[Uml]): Try[Unit]

  def unlink_ValueSpecification_lifeline_composes_selector_Lifeline
  (from: UMLValueSpecification[Uml],
   to: UMLLifeline[Uml]): Try[Unit]


  // LinkAction

  def link_LinkEndData_linkAction_composes_endData_LinkAction
  (from: UMLLinkEndData[Uml],
   to: UMLLinkAction[Uml]): Try[Unit]

  def unlink_LinkEndData_linkAction_composes_endData_LinkAction
  (from: UMLLinkEndData[Uml],
   to: UMLLinkAction[Uml]): Try[Unit]

  def link_InputPin_linkAction_composes_inputValue_LinkAction
  (from: UMLInputPin[Uml],
   to: UMLLinkAction[Uml]): Try[Unit]

  def unlink_InputPin_linkAction_composes_inputValue_LinkAction
  (from: UMLInputPin[Uml],
   to: UMLLinkAction[Uml]): Try[Unit]


  // LinkEndCreationData

  def link_InputPin_linkEndCreationData_references_insertAt_LinkEndCreationData
  (from: UMLInputPin[Uml],
   to: UMLLinkEndCreationData[Uml]): Try[Unit]

  def unlink_InputPin_linkEndCreationData_references_insertAt_LinkEndCreationData
  (from: UMLInputPin[Uml],
   to: UMLLinkEndCreationData[Uml]): Try[Unit]

  def set_LinkEndCreationData_isReplaceAll
  (e: UMLLinkEndCreationData[Uml], isReplaceAll: Boolean): Try[Unit]


  // LinkEndData

  def link_Property_linkEndData_references_end_LinkEndData
  (from: UMLProperty[Uml],
   to: UMLLinkEndData[Uml]): Try[Unit]

  def unlink_Property_linkEndData_references_end_LinkEndData
  (from: UMLProperty[Uml],
   to: UMLLinkEndData[Uml]): Try[Unit]

  def link_QualifierValue_linkEndData_composes_qualifier_LinkEndData
  (from: UMLQualifierValue[Uml],
   to: UMLLinkEndData[Uml]): Try[Unit]

  def unlink_QualifierValue_linkEndData_composes_qualifier_LinkEndData
  (from: UMLQualifierValue[Uml],
   to: UMLLinkEndData[Uml]): Try[Unit]

  def link_InputPin_linkEndData_references_value_LinkEndData
  (from: UMLInputPin[Uml],
   to: UMLLinkEndData[Uml]): Try[Unit]

  def unlink_InputPin_linkEndData_references_value_LinkEndData
  (from: UMLInputPin[Uml],
   to: UMLLinkEndData[Uml]): Try[Unit]


  // LinkEndDestructionData

  def link_InputPin_linkEndDestructionData_references_destroyAt_LinkEndDestructionData
  (from: UMLInputPin[Uml],
   to: UMLLinkEndDestructionData[Uml]): Try[Unit]

  def unlink_InputPin_linkEndDestructionData_references_destroyAt_LinkEndDestructionData
  (from: UMLInputPin[Uml],
   to: UMLLinkEndDestructionData[Uml]): Try[Unit]

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

  def link_OutputPin_loopNode_references_bodyOutput_LoopNode
  (from: UMLOutputPin[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def unlink_OutputPin_loopNode_references_bodyOutput_LoopNode
  (from: UMLOutputPin[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def link_ExecutableNode_loopNode_references_bodyPart_LoopNode
  (from: UMLExecutableNode[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def unlink_ExecutableNode_loopNode_references_bodyPart_LoopNode
  (from: UMLExecutableNode[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def link_OutputPin_loopNode_references_decider_LoopNode
  (from: UMLOutputPin[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def unlink_OutputPin_loopNode_references_decider_LoopNode
  (from: UMLOutputPin[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def link_OutputPin_loopNode_composes_loopVariable_LoopNode
  (from: UMLOutputPin[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def unlink_OutputPin_loopNode_composes_loopVariable_LoopNode
  (from: UMLOutputPin[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def link_InputPin_loopNode_composes_loopVariableInput_LoopNode
  (from: UMLInputPin[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def unlink_InputPin_loopNode_composes_loopVariableInput_LoopNode
  (from: UMLInputPin[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def link_OutputPin_loopNode_composes_result_LoopNode
  (from: UMLOutputPin[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def unlink_OutputPin_loopNode_composes_result_LoopNode
  (from: UMLOutputPin[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def link_ExecutableNode_loopNode_references_setupPart_LoopNode
  (from: UMLExecutableNode[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def unlink_ExecutableNode_loopNode_references_setupPart_LoopNode
  (from: UMLExecutableNode[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def link_ExecutableNode_loopNode_references_test_LoopNode
  (from: UMLExecutableNode[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def unlink_ExecutableNode_loopNode_references_test_LoopNode
  (from: UMLExecutableNode[Uml],
   to: UMLLoopNode[Uml]): Try[Unit]

  def set_LoopNode_isTestedFirst
  (e: UMLLoopNode[Uml], isTestedFirst: Boolean): Try[Unit]


  // Manifestation

  def link_PackageableElement_manifestation_references_utilizedElement_Manifestation
  (from: UMLPackageableElement[Uml],
   to: UMLManifestation[Uml]): Try[Unit]

  def unlink_PackageableElement_manifestation_references_utilizedElement_Manifestation
  (from: UMLPackageableElement[Uml],
   to: UMLManifestation[Uml]): Try[Unit]


  // MergeNode



  // Message

  def link_ValueSpecification_message_composes_argument_Message
  (from: UMLValueSpecification[Uml],
   to: UMLMessage[Uml]): Try[Unit]

  def unlink_ValueSpecification_message_composes_argument_Message
  (from: UMLValueSpecification[Uml],
   to: UMLMessage[Uml]): Try[Unit]

  def link_Connector_message_references_connector_Message
  (from: UMLConnector[Uml],
   to: UMLMessage[Uml]): Try[Unit]

  def unlink_Connector_message_references_connector_Message
  (from: UMLConnector[Uml],
   to: UMLMessage[Uml]): Try[Unit]

  def link_Interaction_message_references_interaction_Message
  (from: UMLInteraction[Uml],
   to: UMLMessage[Uml]): Try[Unit]

  def unlink_Interaction_message_references_interaction_Message
  (from: UMLInteraction[Uml],
   to: UMLMessage[Uml]): Try[Unit]

  def link_MessageEnd_endMessage_references_receiveEvent_Message
  (from: UMLMessageEnd[Uml],
   to: UMLMessage[Uml]): Try[Unit]

  def unlink_MessageEnd_endMessage_references_receiveEvent_Message
  (from: UMLMessageEnd[Uml],
   to: UMLMessage[Uml]): Try[Unit]

  def link_MessageEnd_endMessage_references_sendEvent_Message
  (from: UMLMessageEnd[Uml],
   to: UMLMessage[Uml]): Try[Unit]

  def unlink_MessageEnd_endMessage_references_sendEvent_Message
  (from: UMLMessageEnd[Uml],
   to: UMLMessage[Uml]): Try[Unit]

  def link_NamedElement_message_references_signature_Message
  (from: UMLNamedElement[Uml],
   to: UMLMessage[Uml]): Try[Unit]

  def unlink_NamedElement_message_references_signature_Message
  (from: UMLNamedElement[Uml],
   to: UMLMessage[Uml]): Try[Unit]

  def set_Message_messageKind
  (e: UMLMessage[Uml], messageKind: UMLMessageKind.Value): Try[Unit]

  def set_Message_messageSort
  (e: UMLMessage[Uml], messageSort: UMLMessageSort.Value): Try[Unit]


  // MessageEnd

  def link_Message_messageEnd_references_message_MessageEnd
  (from: UMLMessage[Uml],
   to: UMLMessageEnd[Uml]): Try[Unit]

  def unlink_Message_messageEnd_references_message_MessageEnd
  (from: UMLMessage[Uml],
   to: UMLMessageEnd[Uml]): Try[Unit]


  // MessageEvent



  // MessageOccurrenceSpecification



  // Model


  def set_Model_viewpoint
  (e: UMLModel[Uml], viewpoint: Option[String]): Try[Unit]


  // MultiplicityElement

  def link_ValueSpecification_owningLower_composes_lowerValue_MultiplicityElement
  (from: UMLValueSpecification[Uml],
   to: UMLMultiplicityElement[Uml]): Try[Unit]

  def unlink_ValueSpecification_owningLower_composes_lowerValue_MultiplicityElement
  (from: UMLValueSpecification[Uml],
   to: UMLMultiplicityElement[Uml]): Try[Unit]

  def link_ValueSpecification_owningUpper_composes_upperValue_MultiplicityElement
  (from: UMLValueSpecification[Uml],
   to: UMLMultiplicityElement[Uml]): Try[Unit]

  def unlink_ValueSpecification_owningUpper_composes_upperValue_MultiplicityElement
  (from: UMLValueSpecification[Uml],
   to: UMLMultiplicityElement[Uml]): Try[Unit]

  def set_MultiplicityElement_isOrdered
  (e: UMLMultiplicityElement[Uml], isOrdered: Boolean): Try[Unit]

  def set_MultiplicityElement_isUnique
  (e: UMLMultiplicityElement[Uml], isUnique: Boolean): Try[Unit]

  def set_MultiplicityElement_lower
  (e: UMLMultiplicityElement[Uml], lower: Integer): Try[Unit]

  def set_MultiplicityElement_upper
  (e: UMLMultiplicityElement[Uml], upper: Integer): Try[Unit]


  // NamedElement

  def link_StringExpression_namedElement_composes_nameExpression_NamedElement
  (from: UMLStringExpression[Uml],
   to: UMLNamedElement[Uml]): Try[Unit]

  def unlink_StringExpression_namedElement_composes_nameExpression_NamedElement
  (from: UMLStringExpression[Uml],
   to: UMLNamedElement[Uml]): Try[Unit]

  def set_NamedElement_name
  (e: UMLNamedElement[Uml], name: Option[String]): Try[Unit]

  def set_NamedElement_qualifiedName
  (e: UMLNamedElement[Uml], qualifiedName: Option[String]): Try[Unit]

  def set_NamedElement_visibility
  (e: UMLNamedElement[Uml], visibility: Option[UMLVisibilityKind.Value]): Try[Unit]


  // Namespace

  def link_ElementImport_importingNamespace_composes_elementImport_Namespace
  (from: UMLElementImport[Uml],
   to: UMLNamespace[Uml]): Try[Unit]

  def unlink_ElementImport_importingNamespace_composes_elementImport_Namespace
  (from: UMLElementImport[Uml],
   to: UMLNamespace[Uml]): Try[Unit]

  def link_Constraint_context_composes_ownedRule_Namespace
  (from: UMLConstraint[Uml],
   to: UMLNamespace[Uml]): Try[Unit]

  def unlink_Constraint_context_composes_ownedRule_Namespace
  (from: UMLConstraint[Uml],
   to: UMLNamespace[Uml]): Try[Unit]

  def link_PackageImport_importingNamespace_composes_packageImport_Namespace
  (from: UMLPackageImport[Uml],
   to: UMLNamespace[Uml]): Try[Unit]

  def unlink_PackageImport_importingNamespace_composes_packageImport_Namespace
  (from: UMLPackageImport[Uml],
   to: UMLNamespace[Uml]): Try[Unit]


  // Node

  def link_Node_node_composes_nestedNode_Node
  (from: UMLNode[Uml],
   to: UMLNode[Uml]): Try[Unit]

  def unlink_Node_node_composes_nestedNode_Node
  (from: UMLNode[Uml],
   to: UMLNode[Uml]): Try[Unit]


  // ObjectFlow

  def link_Behavior_objectFlow_references_selection_ObjectFlow
  (from: UMLBehavior[Uml],
   to: UMLObjectFlow[Uml]): Try[Unit]

  def unlink_Behavior_objectFlow_references_selection_ObjectFlow
  (from: UMLBehavior[Uml],
   to: UMLObjectFlow[Uml]): Try[Unit]

  def link_Behavior_objectFlow_references_transformation_ObjectFlow
  (from: UMLBehavior[Uml],
   to: UMLObjectFlow[Uml]): Try[Unit]

  def unlink_Behavior_objectFlow_references_transformation_ObjectFlow
  (from: UMLBehavior[Uml],
   to: UMLObjectFlow[Uml]): Try[Unit]

  def set_ObjectFlow_isMulticast
  (e: UMLObjectFlow[Uml], isMulticast: Boolean): Try[Unit]

  def set_ObjectFlow_isMultireceive
  (e: UMLObjectFlow[Uml], isMultireceive: Boolean): Try[Unit]


  // ObjectNode

  def link_State_objectNode_references_inState_ObjectNode
  (from: UMLState[Uml],
   to: UMLObjectNode[Uml]): Try[Unit]

  def unlink_State_objectNode_references_inState_ObjectNode
  (from: UMLState[Uml],
   to: UMLObjectNode[Uml]): Try[Unit]

  def link_Behavior_objectNode_references_selection_ObjectNode
  (from: UMLBehavior[Uml],
   to: UMLObjectNode[Uml]): Try[Unit]

  def unlink_Behavior_objectNode_references_selection_ObjectNode
  (from: UMLBehavior[Uml],
   to: UMLObjectNode[Uml]): Try[Unit]

  def link_ValueSpecification_objectNode_composes_upperBound_ObjectNode
  (from: UMLValueSpecification[Uml],
   to: UMLObjectNode[Uml]): Try[Unit]

  def unlink_ValueSpecification_objectNode_composes_upperBound_ObjectNode
  (from: UMLValueSpecification[Uml],
   to: UMLObjectNode[Uml]): Try[Unit]

  def set_ObjectNode_isControlType
  (e: UMLObjectNode[Uml], isControlType: Boolean): Try[Unit]

  def set_ObjectNode_ordering
  (e: UMLObjectNode[Uml], ordering: UMLObjectNodeOrderingKind.Value): Try[Unit]


  // Observation



  // OccurrenceSpecification

  def link_Lifeline_events_references_covered_OccurrenceSpecification
  (from: UMLLifeline[Uml],
   to: UMLOccurrenceSpecification[Uml]): Try[Unit]

  def unlink_Lifeline_events_references_covered_OccurrenceSpecification
  (from: UMLLifeline[Uml],
   to: UMLOccurrenceSpecification[Uml]): Try[Unit]

  def link_GeneralOrdering_before_references_toAfter_OccurrenceSpecification
  (from: UMLGeneralOrdering[Uml],
   to: UMLOccurrenceSpecification[Uml]): Try[Unit]

  def unlink_GeneralOrdering_before_references_toAfter_OccurrenceSpecification
  (from: UMLGeneralOrdering[Uml],
   to: UMLOccurrenceSpecification[Uml]): Try[Unit]

  def link_GeneralOrdering_after_references_toBefore_OccurrenceSpecification
  (from: UMLGeneralOrdering[Uml],
   to: UMLOccurrenceSpecification[Uml]): Try[Unit]

  def unlink_GeneralOrdering_after_references_toBefore_OccurrenceSpecification
  (from: UMLGeneralOrdering[Uml],
   to: UMLOccurrenceSpecification[Uml]): Try[Unit]


  // OpaqueAction

  def link_InputPin_opaqueAction_composes_inputValue_OpaqueAction
  (from: UMLInputPin[Uml],
   to: UMLOpaqueAction[Uml]): Try[Unit]

  def unlink_InputPin_opaqueAction_composes_inputValue_OpaqueAction
  (from: UMLInputPin[Uml],
   to: UMLOpaqueAction[Uml]): Try[Unit]

  def link_OutputPin_opaqueAction_composes_outputValue_OpaqueAction
  (from: UMLOutputPin[Uml],
   to: UMLOpaqueAction[Uml]): Try[Unit]

  def unlink_OutputPin_opaqueAction_composes_outputValue_OpaqueAction
  (from: UMLOutputPin[Uml],
   to: UMLOpaqueAction[Uml]): Try[Unit]

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

  def link_Behavior_opaqueExpression_references_behavior_OpaqueExpression
  (from: UMLBehavior[Uml],
   to: UMLOpaqueExpression[Uml]): Try[Unit]

  def unlink_Behavior_opaqueExpression_references_behavior_OpaqueExpression
  (from: UMLBehavior[Uml],
   to: UMLOpaqueExpression[Uml]): Try[Unit]

  def set_OpaqueExpression_body
  (e: UMLOpaqueExpression[Uml], body: Seq[String]): Try[Unit]

  def set_OpaqueExpression_language
  (e: UMLOpaqueExpression[Uml], language: Seq[String]): Try[Unit]


  // Operation

  def link_Constraint_bodyContext_composes_bodyCondition_Operation
  (from: UMLConstraint[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def unlink_Constraint_bodyContext_composes_bodyCondition_Operation
  (from: UMLConstraint[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def link_Class_ownedOperation_references_class_Operation
  (from: UMLClass[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def unlink_Class_ownedOperation_references_class_Operation
  (from: UMLClass[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def link_DataType_ownedOperation_references_datatype_Operation
  (from: UMLDataType[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def unlink_DataType_ownedOperation_references_datatype_Operation
  (from: UMLDataType[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def link_Interface_ownedOperation_references_interface_Operation
  (from: UMLInterface[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def unlink_Interface_ownedOperation_references_interface_Operation
  (from: UMLInterface[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def link_Parameter_operation_composes_ownedParameter_Operation
  (from: UMLParameter[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def unlink_Parameter_operation_composes_ownedParameter_Operation
  (from: UMLParameter[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def link_Constraint_postContext_composes_postcondition_Operation
  (from: UMLConstraint[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def unlink_Constraint_postContext_composes_postcondition_Operation
  (from: UMLConstraint[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def link_Constraint_preContext_composes_precondition_Operation
  (from: UMLConstraint[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def unlink_Constraint_preContext_composes_precondition_Operation
  (from: UMLConstraint[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def link_Type_operation_references_raisedException_Operation
  (from: UMLType[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def unlink_Type_operation_references_raisedException_Operation
  (from: UMLType[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def link_Operation_operation_references_redefinedOperation_Operation
  (from: UMLOperation[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def unlink_Operation_operation_references_redefinedOperation_Operation
  (from: UMLOperation[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def link_OperationTemplateParameter_parameteredElement_references_templateParameter_Operation
  (from: UMLOperationTemplateParameter[Uml],
   to: UMLOperation[Uml]): Try[Unit]

  def unlink_OperationTemplateParameter_parameteredElement_references_templateParameter_Operation
  (from: UMLOperationTemplateParameter[Uml],
   to: UMLOperation[Uml]): Try[Unit]

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

  def link_Operation_templateParameter_references_parameteredElement_OperationTemplateParameter
  (from: UMLOperation[Uml],
   to: UMLOperationTemplateParameter[Uml]): Try[Unit]

  def unlink_Operation_templateParameter_references_parameteredElement_OperationTemplateParameter
  (from: UMLOperation[Uml],
   to: UMLOperationTemplateParameter[Uml]): Try[Unit]


  // OutputPin



  // Package

  def link_PackageMerge_receivingPackage_composes_packageMerge_Package
  (from: UMLPackageMerge[Uml],
   to: UMLPackage[Uml]): Try[Unit]

  def unlink_PackageMerge_receivingPackage_composes_packageMerge_Package
  (from: UMLPackageMerge[Uml],
   to: UMLPackage[Uml]): Try[Unit]

  def link_PackageableElement_owningPackage_composes_packagedElement_Package
  (from: UMLPackageableElement[Uml],
   to: UMLPackage[Uml]): Try[Unit]

  def unlink_PackageableElement_owningPackage_composes_packagedElement_Package
  (from: UMLPackageableElement[Uml],
   to: UMLPackage[Uml]): Try[Unit]

  def link_ProfileApplication_applyingPackage_composes_profileApplication_Package
  (from: UMLProfileApplication[Uml],
   to: UMLPackage[Uml]): Try[Unit]

  def unlink_ProfileApplication_applyingPackage_composes_profileApplication_Package
  (from: UMLProfileApplication[Uml],
   to: UMLPackage[Uml]): Try[Unit]

  def set_Package_URI
  (e: UMLPackage[Uml], URI: Option[String]): Try[Unit]


  // PackageImport

  def link_Package_packageImport_references_importedPackage_PackageImport
  (from: UMLPackage[Uml],
   to: UMLPackageImport[Uml]): Try[Unit]

  def unlink_Package_packageImport_references_importedPackage_PackageImport
  (from: UMLPackage[Uml],
   to: UMLPackageImport[Uml]): Try[Unit]

  def link_Namespace_packageImport_references_importingNamespace_PackageImport
  (from: UMLNamespace[Uml],
   to: UMLPackageImport[Uml]): Try[Unit]

  def unlink_Namespace_packageImport_references_importingNamespace_PackageImport
  (from: UMLNamespace[Uml],
   to: UMLPackageImport[Uml]): Try[Unit]

  def set_PackageImport_visibility
  (e: UMLPackageImport[Uml], visibility: UMLVisibilityKind.Value): Try[Unit]


  // PackageMerge

  def link_Package_packageMerge_references_mergedPackage_PackageMerge
  (from: UMLPackage[Uml],
   to: UMLPackageMerge[Uml]): Try[Unit]

  def unlink_Package_packageMerge_references_mergedPackage_PackageMerge
  (from: UMLPackage[Uml],
   to: UMLPackageMerge[Uml]): Try[Unit]

  def link_Package_packageMerge_references_receivingPackage_PackageMerge
  (from: UMLPackage[Uml],
   to: UMLPackageMerge[Uml]): Try[Unit]

  def unlink_Package_packageMerge_references_receivingPackage_PackageMerge
  (from: UMLPackage[Uml],
   to: UMLPackageMerge[Uml]): Try[Unit]


  // PackageableElement


  def set_PackageableElement_visibility
  (e: UMLPackageableElement[Uml], visibility: Option[UMLVisibilityKind.Value]): Try[Unit]


  // Parameter

  def link_ValueSpecification_owningParameter_composes_defaultValue_Parameter
  (from: UMLValueSpecification[Uml],
   to: UMLParameter[Uml]): Try[Unit]

  def unlink_ValueSpecification_owningParameter_composes_defaultValue_Parameter
  (from: UMLValueSpecification[Uml],
   to: UMLParameter[Uml]): Try[Unit]

  def link_Operation_ownedParameter_references_operation_Parameter
  (from: UMLOperation[Uml],
   to: UMLParameter[Uml]): Try[Unit]

  def unlink_Operation_ownedParameter_references_operation_Parameter
  (from: UMLOperation[Uml],
   to: UMLParameter[Uml]): Try[Unit]

  def link_ParameterSet_parameter_references_parameterSet_Parameter
  (from: UMLParameterSet[Uml],
   to: UMLParameter[Uml]): Try[Unit]

  def unlink_ParameterSet_parameter_references_parameterSet_Parameter
  (from: UMLParameterSet[Uml],
   to: UMLParameter[Uml]): Try[Unit]

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

  def link_Constraint_parameterSet_composes_condition_ParameterSet
  (from: UMLConstraint[Uml],
   to: UMLParameterSet[Uml]): Try[Unit]

  def unlink_Constraint_parameterSet_composes_condition_ParameterSet
  (from: UMLConstraint[Uml],
   to: UMLParameterSet[Uml]): Try[Unit]

  def link_Parameter_parameterSet_references_parameter_ParameterSet
  (from: UMLParameter[Uml],
   to: UMLParameterSet[Uml]): Try[Unit]

  def unlink_Parameter_parameterSet_references_parameter_ParameterSet
  (from: UMLParameter[Uml],
   to: UMLParameterSet[Uml]): Try[Unit]


  // ParameterableElement

  def link_TemplateParameter_ownedParameteredElement_references_owningTemplateParameter_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: UMLParameterableElement[Uml]): Try[Unit]

  def unlink_TemplateParameter_ownedParameteredElement_references_owningTemplateParameter_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: UMLParameterableElement[Uml]): Try[Unit]

  def link_TemplateParameter_parameteredElement_references_templateParameter_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: UMLParameterableElement[Uml]): Try[Unit]

  def unlink_TemplateParameter_parameteredElement_references_templateParameter_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: UMLParameterableElement[Uml]): Try[Unit]


  // PartDecomposition



  // Pin


  def set_Pin_isControl
  (e: UMLPin[Uml], isControl: Boolean): Try[Unit]


  // Port

  def link_ProtocolStateMachine_port_references_protocol_Port
  (from: UMLProtocolStateMachine[Uml],
   to: UMLPort[Uml]): Try[Unit]

  def unlink_ProtocolStateMachine_port_references_protocol_Port
  (from: UMLProtocolStateMachine[Uml],
   to: UMLPort[Uml]): Try[Unit]

  def link_Port_port_references_redefinedPort_Port
  (from: UMLPort[Uml],
   to: UMLPort[Uml]): Try[Unit]

  def unlink_Port_port_references_redefinedPort_Port
  (from: UMLPort[Uml],
   to: UMLPort[Uml]): Try[Unit]

  def set_Port_isBehavior
  (e: UMLPort[Uml], isBehavior: Boolean): Try[Unit]

  def set_Port_isConjugated
  (e: UMLPort[Uml], isConjugated: Boolean): Try[Unit]

  def set_Port_isService
  (e: UMLPort[Uml], isService: Boolean): Try[Unit]


  // PrimitiveType



  // Profile

  def link_ElementImport_profile_composes_metaclassReference_Profile
  (from: UMLElementImport[Uml],
   to: UMLProfile[Uml]): Try[Unit]

  def unlink_ElementImport_profile_composes_metaclassReference_Profile
  (from: UMLElementImport[Uml],
   to: UMLProfile[Uml]): Try[Unit]

  def link_PackageImport_profile_composes_metamodelReference_Profile
  (from: UMLPackageImport[Uml],
   to: UMLProfile[Uml]): Try[Unit]

  def unlink_PackageImport_profile_composes_metamodelReference_Profile
  (from: UMLPackageImport[Uml],
   to: UMLProfile[Uml]): Try[Unit]


  // ProfileApplication

  def link_Profile_profileApplication_references_appliedProfile_ProfileApplication
  (from: UMLProfile[Uml],
   to: UMLProfileApplication[Uml]): Try[Unit]

  def unlink_Profile_profileApplication_references_appliedProfile_ProfileApplication
  (from: UMLProfile[Uml],
   to: UMLProfileApplication[Uml]): Try[Unit]

  def link_Package_profileApplication_references_applyingPackage_ProfileApplication
  (from: UMLPackage[Uml],
   to: UMLProfileApplication[Uml]): Try[Unit]

  def unlink_Package_profileApplication_references_applyingPackage_ProfileApplication
  (from: UMLPackage[Uml],
   to: UMLProfileApplication[Uml]): Try[Unit]

  def set_ProfileApplication_isStrict
  (e: UMLProfileApplication[Uml], isStrict: Boolean): Try[Unit]


  // Property

  def link_Association_memberEnd_references_association_Property
  (from: UMLAssociation[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def unlink_Association_memberEnd_references_association_Property
  (from: UMLAssociation[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def link_Property_qualifier_references_associationEnd_Property
  (from: UMLProperty[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def unlink_Property_qualifier_references_associationEnd_Property
  (from: UMLProperty[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def link_Class_ownedAttribute_references_class_Property
  (from: UMLClass[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def unlink_Class_ownedAttribute_references_class_Property
  (from: UMLClass[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def link_DataType_ownedAttribute_references_datatype_Property
  (from: UMLDataType[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def unlink_DataType_ownedAttribute_references_datatype_Property
  (from: UMLDataType[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def link_ValueSpecification_owningProperty_composes_defaultValue_Property
  (from: UMLValueSpecification[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def unlink_ValueSpecification_owningProperty_composes_defaultValue_Property
  (from: UMLValueSpecification[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def link_Interface_ownedAttribute_references_interface_Property
  (from: UMLInterface[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def unlink_Interface_ownedAttribute_references_interface_Property
  (from: UMLInterface[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def link_Association_ownedEnd_references_owningAssociation_Property
  (from: UMLAssociation[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def unlink_Association_ownedEnd_references_owningAssociation_Property
  (from: UMLAssociation[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def link_Property_associationEnd_composes_qualifier_Property
  (from: UMLProperty[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def unlink_Property_associationEnd_composes_qualifier_Property
  (from: UMLProperty[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def link_Property_property_references_redefinedProperty_Property
  (from: UMLProperty[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def unlink_Property_property_references_redefinedProperty_Property
  (from: UMLProperty[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def link_Property_property_references_subsettedProperty_Property
  (from: UMLProperty[Uml],
   to: UMLProperty[Uml]): Try[Unit]

  def unlink_Property_property_references_subsettedProperty_Property
  (from: UMLProperty[Uml],
   to: UMLProperty[Uml]): Try[Unit]

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

  def link_ProtocolStateMachine_protocolConformance_references_generalMachine_ProtocolConformance
  (from: UMLProtocolStateMachine[Uml],
   to: UMLProtocolConformance[Uml]): Try[Unit]

  def unlink_ProtocolStateMachine_protocolConformance_references_generalMachine_ProtocolConformance
  (from: UMLProtocolStateMachine[Uml],
   to: UMLProtocolConformance[Uml]): Try[Unit]

  def link_ProtocolStateMachine_conformance_references_specificMachine_ProtocolConformance
  (from: UMLProtocolStateMachine[Uml],
   to: UMLProtocolConformance[Uml]): Try[Unit]

  def unlink_ProtocolStateMachine_conformance_references_specificMachine_ProtocolConformance
  (from: UMLProtocolStateMachine[Uml],
   to: UMLProtocolConformance[Uml]): Try[Unit]


  // ProtocolStateMachine

  def link_ProtocolConformance_specificMachine_composes_conformance_ProtocolStateMachine
  (from: UMLProtocolConformance[Uml],
   to: UMLProtocolStateMachine[Uml]): Try[Unit]

  def unlink_ProtocolConformance_specificMachine_composes_conformance_ProtocolStateMachine
  (from: UMLProtocolConformance[Uml],
   to: UMLProtocolStateMachine[Uml]): Try[Unit]


  // ProtocolTransition

  def link_Constraint_owningTransition_composes_postCondition_ProtocolTransition
  (from: UMLConstraint[Uml],
   to: UMLProtocolTransition[Uml]): Try[Unit]

  def unlink_Constraint_owningTransition_composes_postCondition_ProtocolTransition
  (from: UMLConstraint[Uml],
   to: UMLProtocolTransition[Uml]): Try[Unit]

  def link_Constraint_protocolTransition_composes_preCondition_ProtocolTransition
  (from: UMLConstraint[Uml],
   to: UMLProtocolTransition[Uml]): Try[Unit]

  def unlink_Constraint_protocolTransition_composes_preCondition_ProtocolTransition
  (from: UMLConstraint[Uml],
   to: UMLProtocolTransition[Uml]): Try[Unit]


  // Pseudostate

  def link_State_connectionPoint_references_state_Pseudostate
  (from: UMLState[Uml],
   to: UMLPseudostate[Uml]): Try[Unit]

  def unlink_State_connectionPoint_references_state_Pseudostate
  (from: UMLState[Uml],
   to: UMLPseudostate[Uml]): Try[Unit]

  def link_StateMachine_connectionPoint_references_stateMachine_Pseudostate
  (from: UMLStateMachine[Uml],
   to: UMLPseudostate[Uml]): Try[Unit]

  def unlink_StateMachine_connectionPoint_references_stateMachine_Pseudostate
  (from: UMLStateMachine[Uml],
   to: UMLPseudostate[Uml]): Try[Unit]

  def set_Pseudostate_kind
  (e: UMLPseudostate[Uml], kind: UMLPseudostateKind.Value): Try[Unit]


  // QualifierValue

  def link_Property_qualifierValue_references_qualifier_QualifierValue
  (from: UMLProperty[Uml],
   to: UMLQualifierValue[Uml]): Try[Unit]

  def unlink_Property_qualifierValue_references_qualifier_QualifierValue
  (from: UMLProperty[Uml],
   to: UMLQualifierValue[Uml]): Try[Unit]

  def link_InputPin_qualifierValue_references_value_QualifierValue
  (from: UMLInputPin[Uml],
   to: UMLQualifierValue[Uml]): Try[Unit]

  def unlink_InputPin_qualifierValue_references_value_QualifierValue
  (from: UMLInputPin[Uml],
   to: UMLQualifierValue[Uml]): Try[Unit]


  // RaiseExceptionAction

  def link_InputPin_raiseExceptionAction_composes_exception_RaiseExceptionAction
  (from: UMLInputPin[Uml],
   to: UMLRaiseExceptionAction[Uml]): Try[Unit]

  def unlink_InputPin_raiseExceptionAction_composes_exception_RaiseExceptionAction
  (from: UMLInputPin[Uml],
   to: UMLRaiseExceptionAction[Uml]): Try[Unit]


  // ReadExtentAction

  def link_Classifier_readExtentAction_references_classifier_ReadExtentAction
  (from: UMLClassifier[Uml],
   to: UMLReadExtentAction[Uml]): Try[Unit]

  def unlink_Classifier_readExtentAction_references_classifier_ReadExtentAction
  (from: UMLClassifier[Uml],
   to: UMLReadExtentAction[Uml]): Try[Unit]

  def link_OutputPin_readExtentAction_composes_result_ReadExtentAction
  (from: UMLOutputPin[Uml],
   to: UMLReadExtentAction[Uml]): Try[Unit]

  def unlink_OutputPin_readExtentAction_composes_result_ReadExtentAction
  (from: UMLOutputPin[Uml],
   to: UMLReadExtentAction[Uml]): Try[Unit]


  // ReadIsClassifiedObjectAction

  def link_Classifier_readIsClassifiedObjectAction_references_classifier_ReadIsClassifiedObjectAction
  (from: UMLClassifier[Uml],
   to: UMLReadIsClassifiedObjectAction[Uml]): Try[Unit]

  def unlink_Classifier_readIsClassifiedObjectAction_references_classifier_ReadIsClassifiedObjectAction
  (from: UMLClassifier[Uml],
   to: UMLReadIsClassifiedObjectAction[Uml]): Try[Unit]

  def link_InputPin_readIsClassifiedObjectAction_composes_object_ReadIsClassifiedObjectAction
  (from: UMLInputPin[Uml],
   to: UMLReadIsClassifiedObjectAction[Uml]): Try[Unit]

  def unlink_InputPin_readIsClassifiedObjectAction_composes_object_ReadIsClassifiedObjectAction
  (from: UMLInputPin[Uml],
   to: UMLReadIsClassifiedObjectAction[Uml]): Try[Unit]

  def link_OutputPin_readIsClassifiedObjectAction_composes_result_ReadIsClassifiedObjectAction
  (from: UMLOutputPin[Uml],
   to: UMLReadIsClassifiedObjectAction[Uml]): Try[Unit]

  def unlink_OutputPin_readIsClassifiedObjectAction_composes_result_ReadIsClassifiedObjectAction
  (from: UMLOutputPin[Uml],
   to: UMLReadIsClassifiedObjectAction[Uml]): Try[Unit]

  def set_ReadIsClassifiedObjectAction_isDirect
  (e: UMLReadIsClassifiedObjectAction[Uml], isDirect: Boolean): Try[Unit]


  // ReadLinkAction

  def link_OutputPin_readLinkAction_composes_result_ReadLinkAction
  (from: UMLOutputPin[Uml],
   to: UMLReadLinkAction[Uml]): Try[Unit]

  def unlink_OutputPin_readLinkAction_composes_result_ReadLinkAction
  (from: UMLOutputPin[Uml],
   to: UMLReadLinkAction[Uml]): Try[Unit]


  // ReadLinkObjectEndAction

  def link_Property_readLinkObjectEndAction_references_end_ReadLinkObjectEndAction
  (from: UMLProperty[Uml],
   to: UMLReadLinkObjectEndAction[Uml]): Try[Unit]

  def unlink_Property_readLinkObjectEndAction_references_end_ReadLinkObjectEndAction
  (from: UMLProperty[Uml],
   to: UMLReadLinkObjectEndAction[Uml]): Try[Unit]

  def link_InputPin_readLinkObjectEndAction_composes_object_ReadLinkObjectEndAction
  (from: UMLInputPin[Uml],
   to: UMLReadLinkObjectEndAction[Uml]): Try[Unit]

  def unlink_InputPin_readLinkObjectEndAction_composes_object_ReadLinkObjectEndAction
  (from: UMLInputPin[Uml],
   to: UMLReadLinkObjectEndAction[Uml]): Try[Unit]

  def link_OutputPin_readLinkObjectEndAction_composes_result_ReadLinkObjectEndAction
  (from: UMLOutputPin[Uml],
   to: UMLReadLinkObjectEndAction[Uml]): Try[Unit]

  def unlink_OutputPin_readLinkObjectEndAction_composes_result_ReadLinkObjectEndAction
  (from: UMLOutputPin[Uml],
   to: UMLReadLinkObjectEndAction[Uml]): Try[Unit]


  // ReadLinkObjectEndQualifierAction

  def link_InputPin_readLinkObjectEndQualifierAction_composes_object_ReadLinkObjectEndQualifierAction
  (from: UMLInputPin[Uml],
   to: UMLReadLinkObjectEndQualifierAction[Uml]): Try[Unit]

  def unlink_InputPin_readLinkObjectEndQualifierAction_composes_object_ReadLinkObjectEndQualifierAction
  (from: UMLInputPin[Uml],
   to: UMLReadLinkObjectEndQualifierAction[Uml]): Try[Unit]

  def link_Property_readLinkObjectEndQualifierAction_references_qualifier_ReadLinkObjectEndQualifierAction
  (from: UMLProperty[Uml],
   to: UMLReadLinkObjectEndQualifierAction[Uml]): Try[Unit]

  def unlink_Property_readLinkObjectEndQualifierAction_references_qualifier_ReadLinkObjectEndQualifierAction
  (from: UMLProperty[Uml],
   to: UMLReadLinkObjectEndQualifierAction[Uml]): Try[Unit]

  def link_OutputPin_readLinkObjectEndQualifierAction_composes_result_ReadLinkObjectEndQualifierAction
  (from: UMLOutputPin[Uml],
   to: UMLReadLinkObjectEndQualifierAction[Uml]): Try[Unit]

  def unlink_OutputPin_readLinkObjectEndQualifierAction_composes_result_ReadLinkObjectEndQualifierAction
  (from: UMLOutputPin[Uml],
   to: UMLReadLinkObjectEndQualifierAction[Uml]): Try[Unit]


  // ReadSelfAction

  def link_OutputPin_readSelfAction_composes_result_ReadSelfAction
  (from: UMLOutputPin[Uml],
   to: UMLReadSelfAction[Uml]): Try[Unit]

  def unlink_OutputPin_readSelfAction_composes_result_ReadSelfAction
  (from: UMLOutputPin[Uml],
   to: UMLReadSelfAction[Uml]): Try[Unit]


  // ReadStructuralFeatureAction

  def link_OutputPin_readStructuralFeatureAction_composes_result_ReadStructuralFeatureAction
  (from: UMLOutputPin[Uml],
   to: UMLReadStructuralFeatureAction[Uml]): Try[Unit]

  def unlink_OutputPin_readStructuralFeatureAction_composes_result_ReadStructuralFeatureAction
  (from: UMLOutputPin[Uml],
   to: UMLReadStructuralFeatureAction[Uml]): Try[Unit]


  // ReadVariableAction

  def link_OutputPin_readVariableAction_composes_result_ReadVariableAction
  (from: UMLOutputPin[Uml],
   to: UMLReadVariableAction[Uml]): Try[Unit]

  def unlink_OutputPin_readVariableAction_composes_result_ReadVariableAction
  (from: UMLOutputPin[Uml],
   to: UMLReadVariableAction[Uml]): Try[Unit]


  // Realization



  // Reception

  def link_Signal_reception_references_signal_Reception
  (from: UMLSignal[Uml],
   to: UMLReception[Uml]): Try[Unit]

  def unlink_Signal_reception_references_signal_Reception
  (from: UMLSignal[Uml],
   to: UMLReception[Uml]): Try[Unit]


  // ReclassifyObjectAction

  def link_Classifier_reclassifyObjectAction_references_newClassifier_ReclassifyObjectAction
  (from: UMLClassifier[Uml],
   to: UMLReclassifyObjectAction[Uml]): Try[Unit]

  def unlink_Classifier_reclassifyObjectAction_references_newClassifier_ReclassifyObjectAction
  (from: UMLClassifier[Uml],
   to: UMLReclassifyObjectAction[Uml]): Try[Unit]

  def link_InputPin_reclassifyObjectAction_composes_object_ReclassifyObjectAction
  (from: UMLInputPin[Uml],
   to: UMLReclassifyObjectAction[Uml]): Try[Unit]

  def unlink_InputPin_reclassifyObjectAction_composes_object_ReclassifyObjectAction
  (from: UMLInputPin[Uml],
   to: UMLReclassifyObjectAction[Uml]): Try[Unit]

  def link_Classifier_reclassifyObjectAction_references_oldClassifier_ReclassifyObjectAction
  (from: UMLClassifier[Uml],
   to: UMLReclassifyObjectAction[Uml]): Try[Unit]

  def unlink_Classifier_reclassifyObjectAction_references_oldClassifier_ReclassifyObjectAction
  (from: UMLClassifier[Uml],
   to: UMLReclassifyObjectAction[Uml]): Try[Unit]

  def set_ReclassifyObjectAction_isReplaceAll
  (e: UMLReclassifyObjectAction[Uml], isReplaceAll: Boolean): Try[Unit]


  // RedefinableElement


  def set_RedefinableElement_isLeaf
  (e: UMLRedefinableElement[Uml], isLeaf: Boolean): Try[Unit]


  // RedefinableTemplateSignature

  def link_Classifier_ownedTemplateSignature_references_classifier_RedefinableTemplateSignature
  (from: UMLClassifier[Uml],
   to: UMLRedefinableTemplateSignature[Uml]): Try[Unit]

  def unlink_Classifier_ownedTemplateSignature_references_classifier_RedefinableTemplateSignature
  (from: UMLClassifier[Uml],
   to: UMLRedefinableTemplateSignature[Uml]): Try[Unit]

  def link_RedefinableTemplateSignature_redefinableTemplateSignature_references_extendedSignature_RedefinableTemplateSignature
  (from: UMLRedefinableTemplateSignature[Uml],
   to: UMLRedefinableTemplateSignature[Uml]): Try[Unit]

  def unlink_RedefinableTemplateSignature_redefinableTemplateSignature_references_extendedSignature_RedefinableTemplateSignature
  (from: UMLRedefinableTemplateSignature[Uml],
   to: UMLRedefinableTemplateSignature[Uml]): Try[Unit]


  // ReduceAction

  def link_InputPin_reduceAction_composes_collection_ReduceAction
  (from: UMLInputPin[Uml],
   to: UMLReduceAction[Uml]): Try[Unit]

  def unlink_InputPin_reduceAction_composes_collection_ReduceAction
  (from: UMLInputPin[Uml],
   to: UMLReduceAction[Uml]): Try[Unit]

  def link_Behavior_reduceAction_references_reducer_ReduceAction
  (from: UMLBehavior[Uml],
   to: UMLReduceAction[Uml]): Try[Unit]

  def unlink_Behavior_reduceAction_references_reducer_ReduceAction
  (from: UMLBehavior[Uml],
   to: UMLReduceAction[Uml]): Try[Unit]

  def link_OutputPin_reduceAction_composes_result_ReduceAction
  (from: UMLOutputPin[Uml],
   to: UMLReduceAction[Uml]): Try[Unit]

  def unlink_OutputPin_reduceAction_composes_result_ReduceAction
  (from: UMLOutputPin[Uml],
   to: UMLReduceAction[Uml]): Try[Unit]

  def set_ReduceAction_isOrdered
  (e: UMLReduceAction[Uml], isOrdered: Boolean): Try[Unit]


  // Region

  def link_Region_region_references_extendedRegion_Region
  (from: UMLRegion[Uml],
   to: UMLRegion[Uml]): Try[Unit]

  def unlink_Region_region_references_extendedRegion_Region
  (from: UMLRegion[Uml],
   to: UMLRegion[Uml]): Try[Unit]

  def link_State_region_references_state_Region
  (from: UMLState[Uml],
   to: UMLRegion[Uml]): Try[Unit]

  def unlink_State_region_references_state_Region
  (from: UMLState[Uml],
   to: UMLRegion[Uml]): Try[Unit]

  def link_StateMachine_region_references_stateMachine_Region
  (from: UMLStateMachine[Uml],
   to: UMLRegion[Uml]): Try[Unit]

  def unlink_StateMachine_region_references_stateMachine_Region
  (from: UMLStateMachine[Uml],
   to: UMLRegion[Uml]): Try[Unit]

  def link_Vertex_container_composes_subvertex_Region
  (from: UMLVertex[Uml],
   to: UMLRegion[Uml]): Try[Unit]

  def unlink_Vertex_container_composes_subvertex_Region
  (from: UMLVertex[Uml],
   to: UMLRegion[Uml]): Try[Unit]

  def link_Transition_container_composes_transition_Region
  (from: UMLTransition[Uml],
   to: UMLRegion[Uml]): Try[Unit]

  def unlink_Transition_container_composes_transition_Region
  (from: UMLTransition[Uml],
   to: UMLRegion[Uml]): Try[Unit]


  // Relationship



  // RemoveStructuralFeatureValueAction

  def link_InputPin_removeStructuralFeatureValueAction_composes_removeAt_RemoveStructuralFeatureValueAction
  (from: UMLInputPin[Uml],
   to: UMLRemoveStructuralFeatureValueAction[Uml]): Try[Unit]

  def unlink_InputPin_removeStructuralFeatureValueAction_composes_removeAt_RemoveStructuralFeatureValueAction
  (from: UMLInputPin[Uml],
   to: UMLRemoveStructuralFeatureValueAction[Uml]): Try[Unit]

  def set_RemoveStructuralFeatureValueAction_isRemoveDuplicates
  (e: UMLRemoveStructuralFeatureValueAction[Uml], isRemoveDuplicates: Boolean): Try[Unit]


  // RemoveVariableValueAction

  def link_InputPin_removeVariableValueAction_composes_removeAt_RemoveVariableValueAction
  (from: UMLInputPin[Uml],
   to: UMLRemoveVariableValueAction[Uml]): Try[Unit]

  def unlink_InputPin_removeVariableValueAction_composes_removeAt_RemoveVariableValueAction
  (from: UMLInputPin[Uml],
   to: UMLRemoveVariableValueAction[Uml]): Try[Unit]

  def set_RemoveVariableValueAction_isRemoveDuplicates
  (e: UMLRemoveVariableValueAction[Uml], isRemoveDuplicates: Boolean): Try[Unit]


  // ReplyAction

  def link_Trigger_replyAction_references_replyToCall_ReplyAction
  (from: UMLTrigger[Uml],
   to: UMLReplyAction[Uml]): Try[Unit]

  def unlink_Trigger_replyAction_references_replyToCall_ReplyAction
  (from: UMLTrigger[Uml],
   to: UMLReplyAction[Uml]): Try[Unit]

  def link_InputPin_replyAction_composes_replyValue_ReplyAction
  (from: UMLInputPin[Uml],
   to: UMLReplyAction[Uml]): Try[Unit]

  def unlink_InputPin_replyAction_composes_replyValue_ReplyAction
  (from: UMLInputPin[Uml],
   to: UMLReplyAction[Uml]): Try[Unit]

  def link_InputPin_replyAction_composes_returnInformation_ReplyAction
  (from: UMLInputPin[Uml],
   to: UMLReplyAction[Uml]): Try[Unit]

  def unlink_InputPin_replyAction_composes_returnInformation_ReplyAction
  (from: UMLInputPin[Uml],
   to: UMLReplyAction[Uml]): Try[Unit]


  // SendObjectAction

  def link_InputPin_sendObjectAction_composes_request_SendObjectAction
  (from: UMLInputPin[Uml],
   to: UMLSendObjectAction[Uml]): Try[Unit]

  def unlink_InputPin_sendObjectAction_composes_request_SendObjectAction
  (from: UMLInputPin[Uml],
   to: UMLSendObjectAction[Uml]): Try[Unit]

  def link_InputPin_sendObjectAction_composes_target_SendObjectAction
  (from: UMLInputPin[Uml],
   to: UMLSendObjectAction[Uml]): Try[Unit]

  def unlink_InputPin_sendObjectAction_composes_target_SendObjectAction
  (from: UMLInputPin[Uml],
   to: UMLSendObjectAction[Uml]): Try[Unit]


  // SendSignalAction

  def link_Signal_sendSignalAction_references_signal_SendSignalAction
  (from: UMLSignal[Uml],
   to: UMLSendSignalAction[Uml]): Try[Unit]

  def unlink_Signal_sendSignalAction_references_signal_SendSignalAction
  (from: UMLSignal[Uml],
   to: UMLSendSignalAction[Uml]): Try[Unit]

  def link_InputPin_sendSignalAction_composes_target_SendSignalAction
  (from: UMLInputPin[Uml],
   to: UMLSendSignalAction[Uml]): Try[Unit]

  def unlink_InputPin_sendSignalAction_composes_target_SendSignalAction
  (from: UMLInputPin[Uml],
   to: UMLSendSignalAction[Uml]): Try[Unit]


  // SequenceNode

  def link_ExecutableNode_sequenceNode_composes_executableNode_SequenceNode
  (from: UMLExecutableNode[Uml],
   to: UMLSequenceNode[Uml]): Try[Unit]

  def unlink_ExecutableNode_sequenceNode_composes_executableNode_SequenceNode
  (from: UMLExecutableNode[Uml],
   to: UMLSequenceNode[Uml]): Try[Unit]


  // Signal

  def link_Property_owningSignal_composes_ownedAttribute_Signal
  (from: UMLProperty[Uml],
   to: UMLSignal[Uml]): Try[Unit]

  def unlink_Property_owningSignal_composes_ownedAttribute_Signal
  (from: UMLProperty[Uml],
   to: UMLSignal[Uml]): Try[Unit]


  // SignalEvent

  def link_Signal_signalEvent_references_signal_SignalEvent
  (from: UMLSignal[Uml],
   to: UMLSignalEvent[Uml]): Try[Unit]

  def unlink_Signal_signalEvent_references_signal_SignalEvent
  (from: UMLSignal[Uml],
   to: UMLSignalEvent[Uml]): Try[Unit]


  // Slot

  def link_StructuralFeature_slot_references_definingFeature_Slot
  (from: UMLStructuralFeature[Uml],
   to: UMLSlot[Uml]): Try[Unit]

  def unlink_StructuralFeature_slot_references_definingFeature_Slot
  (from: UMLStructuralFeature[Uml],
   to: UMLSlot[Uml]): Try[Unit]

  def link_InstanceSpecification_slot_references_owningInstance_Slot
  (from: UMLInstanceSpecification[Uml],
   to: UMLSlot[Uml]): Try[Unit]

  def unlink_InstanceSpecification_slot_references_owningInstance_Slot
  (from: UMLInstanceSpecification[Uml],
   to: UMLSlot[Uml]): Try[Unit]

  def link_ValueSpecification_owningSlot_composes_value_Slot
  (from: UMLValueSpecification[Uml],
   to: UMLSlot[Uml]): Try[Unit]

  def unlink_ValueSpecification_owningSlot_composes_value_Slot
  (from: UMLValueSpecification[Uml],
   to: UMLSlot[Uml]): Try[Unit]


  // StartClassifierBehaviorAction

  def link_InputPin_startClassifierBehaviorAction_composes_object_StartClassifierBehaviorAction
  (from: UMLInputPin[Uml],
   to: UMLStartClassifierBehaviorAction[Uml]): Try[Unit]

  def unlink_InputPin_startClassifierBehaviorAction_composes_object_StartClassifierBehaviorAction
  (from: UMLInputPin[Uml],
   to: UMLStartClassifierBehaviorAction[Uml]): Try[Unit]


  // StartObjectBehaviorAction

  def link_InputPin_startObjectBehaviorAction_composes_object_StartObjectBehaviorAction
  (from: UMLInputPin[Uml],
   to: UMLStartObjectBehaviorAction[Uml]): Try[Unit]

  def unlink_InputPin_startObjectBehaviorAction_composes_object_StartObjectBehaviorAction
  (from: UMLInputPin[Uml],
   to: UMLStartObjectBehaviorAction[Uml]): Try[Unit]


  // State

  def link_ConnectionPointReference_state_composes_connection_State
  (from: UMLConnectionPointReference[Uml],
   to: UMLState[Uml]): Try[Unit]

  def unlink_ConnectionPointReference_state_composes_connection_State
  (from: UMLConnectionPointReference[Uml],
   to: UMLState[Uml]): Try[Unit]

  def link_Pseudostate_state_composes_connectionPoint_State
  (from: UMLPseudostate[Uml],
   to: UMLState[Uml]): Try[Unit]

  def unlink_Pseudostate_state_composes_connectionPoint_State
  (from: UMLPseudostate[Uml],
   to: UMLState[Uml]): Try[Unit]

  def link_Trigger_state_composes_deferrableTrigger_State
  (from: UMLTrigger[Uml],
   to: UMLState[Uml]): Try[Unit]

  def unlink_Trigger_state_composes_deferrableTrigger_State
  (from: UMLTrigger[Uml],
   to: UMLState[Uml]): Try[Unit]

  def link_Behavior_state_composes_doActivity_State
  (from: UMLBehavior[Uml],
   to: UMLState[Uml]): Try[Unit]

  def unlink_Behavior_state_composes_doActivity_State
  (from: UMLBehavior[Uml],
   to: UMLState[Uml]): Try[Unit]

  def link_Behavior_state_composes_entry_State
  (from: UMLBehavior[Uml],
   to: UMLState[Uml]): Try[Unit]

  def unlink_Behavior_state_composes_entry_State
  (from: UMLBehavior[Uml],
   to: UMLState[Uml]): Try[Unit]

  def link_Behavior_state_composes_exit_State
  (from: UMLBehavior[Uml],
   to: UMLState[Uml]): Try[Unit]

  def unlink_Behavior_state_composes_exit_State
  (from: UMLBehavior[Uml],
   to: UMLState[Uml]): Try[Unit]

  def link_State_state_references_redefinedState_State
  (from: UMLState[Uml],
   to: UMLState[Uml]): Try[Unit]

  def unlink_State_state_references_redefinedState_State
  (from: UMLState[Uml],
   to: UMLState[Uml]): Try[Unit]

  def link_Region_state_composes_region_State
  (from: UMLRegion[Uml],
   to: UMLState[Uml]): Try[Unit]

  def unlink_Region_state_composes_region_State
  (from: UMLRegion[Uml],
   to: UMLState[Uml]): Try[Unit]

  def link_Constraint_owningState_composes_stateInvariant_State
  (from: UMLConstraint[Uml],
   to: UMLState[Uml]): Try[Unit]

  def unlink_Constraint_owningState_composes_stateInvariant_State
  (from: UMLConstraint[Uml],
   to: UMLState[Uml]): Try[Unit]

  def link_StateMachine_submachineState_references_submachine_State
  (from: UMLStateMachine[Uml],
   to: UMLState[Uml]): Try[Unit]

  def unlink_StateMachine_submachineState_references_submachine_State
  (from: UMLStateMachine[Uml],
   to: UMLState[Uml]): Try[Unit]

  def set_State_isComposite
  (e: UMLState[Uml], isComposite: Boolean): Try[Unit]

  def set_State_isOrthogonal
  (e: UMLState[Uml], isOrthogonal: Boolean): Try[Unit]

  def set_State_isSimple
  (e: UMLState[Uml], isSimple: Boolean): Try[Unit]

  def set_State_isSubmachineState
  (e: UMLState[Uml], isSubmachineState: Boolean): Try[Unit]


  // StateInvariant

  def link_Lifeline_stateInvariant_references_covered_StateInvariant
  (from: UMLLifeline[Uml],
   to: UMLStateInvariant[Uml]): Try[Unit]

  def unlink_Lifeline_stateInvariant_references_covered_StateInvariant
  (from: UMLLifeline[Uml],
   to: UMLStateInvariant[Uml]): Try[Unit]

  def link_Constraint_stateInvariant_composes_invariant_StateInvariant
  (from: UMLConstraint[Uml],
   to: UMLStateInvariant[Uml]): Try[Unit]

  def unlink_Constraint_stateInvariant_composes_invariant_StateInvariant
  (from: UMLConstraint[Uml],
   to: UMLStateInvariant[Uml]): Try[Unit]


  // StateMachine

  def link_Pseudostate_stateMachine_composes_connectionPoint_StateMachine
  (from: UMLPseudostate[Uml],
   to: UMLStateMachine[Uml]): Try[Unit]

  def unlink_Pseudostate_stateMachine_composes_connectionPoint_StateMachine
  (from: UMLPseudostate[Uml],
   to: UMLStateMachine[Uml]): Try[Unit]

  def link_StateMachine_stateMachine_references_extendedStateMachine_StateMachine
  (from: UMLStateMachine[Uml],
   to: UMLStateMachine[Uml]): Try[Unit]

  def unlink_StateMachine_stateMachine_references_extendedStateMachine_StateMachine
  (from: UMLStateMachine[Uml],
   to: UMLStateMachine[Uml]): Try[Unit]

  def link_Region_stateMachine_composes_region_StateMachine
  (from: UMLRegion[Uml],
   to: UMLStateMachine[Uml]): Try[Unit]

  def unlink_Region_stateMachine_composes_region_StateMachine
  (from: UMLRegion[Uml],
   to: UMLStateMachine[Uml]): Try[Unit]

  def link_State_submachine_references_submachineState_StateMachine
  (from: UMLState[Uml],
   to: UMLStateMachine[Uml]): Try[Unit]

  def unlink_State_submachine_references_submachineState_StateMachine
  (from: UMLState[Uml],
   to: UMLStateMachine[Uml]): Try[Unit]


  // Stereotype

  def link_Image_stereotype_composes_icon_Stereotype
  (from: UMLImage[Uml],
   to: UMLStereotype[Uml]): Try[Unit]

  def unlink_Image_stereotype_composes_icon_Stereotype
  (from: UMLImage[Uml],
   to: UMLStereotype[Uml]): Try[Unit]


  // StringExpression

  def link_StringExpression_subExpression_references_owningExpression_StringExpression
  (from: UMLStringExpression[Uml],
   to: UMLStringExpression[Uml]): Try[Unit]

  def unlink_StringExpression_subExpression_references_owningExpression_StringExpression
  (from: UMLStringExpression[Uml],
   to: UMLStringExpression[Uml]): Try[Unit]

  def link_StringExpression_owningExpression_composes_subExpression_StringExpression
  (from: UMLStringExpression[Uml],
   to: UMLStringExpression[Uml]): Try[Unit]

  def unlink_StringExpression_owningExpression_composes_subExpression_StringExpression
  (from: UMLStringExpression[Uml],
   to: UMLStringExpression[Uml]): Try[Unit]


  // StructuralFeature


  def set_StructuralFeature_isReadOnly
  (e: UMLStructuralFeature[Uml], isReadOnly: Boolean): Try[Unit]


  // StructuralFeatureAction

  def link_InputPin_structuralFeatureAction_composes_object_StructuralFeatureAction
  (from: UMLInputPin[Uml],
   to: UMLStructuralFeatureAction[Uml]): Try[Unit]

  def unlink_InputPin_structuralFeatureAction_composes_object_StructuralFeatureAction
  (from: UMLInputPin[Uml],
   to: UMLStructuralFeatureAction[Uml]): Try[Unit]

  def link_StructuralFeature_structuralFeatureAction_references_structuralFeature_StructuralFeatureAction
  (from: UMLStructuralFeature[Uml],
   to: UMLStructuralFeatureAction[Uml]): Try[Unit]

  def unlink_StructuralFeature_structuralFeatureAction_references_structuralFeature_StructuralFeatureAction
  (from: UMLStructuralFeature[Uml],
   to: UMLStructuralFeatureAction[Uml]): Try[Unit]


  // StructuredActivityNode

  def link_Activity_structuredNode_references_activity_StructuredActivityNode
  (from: UMLActivity[Uml],
   to: UMLStructuredActivityNode[Uml]): Try[Unit]

  def unlink_Activity_structuredNode_references_activity_StructuredActivityNode
  (from: UMLActivity[Uml],
   to: UMLStructuredActivityNode[Uml]): Try[Unit]

  def link_ActivityEdge_inStructuredNode_composes_edge_StructuredActivityNode
  (from: UMLActivityEdge[Uml],
   to: UMLStructuredActivityNode[Uml]): Try[Unit]

  def unlink_ActivityEdge_inStructuredNode_composes_edge_StructuredActivityNode
  (from: UMLActivityEdge[Uml],
   to: UMLStructuredActivityNode[Uml]): Try[Unit]

  def link_ActivityNode_inStructuredNode_composes_node_StructuredActivityNode
  (from: UMLActivityNode[Uml],
   to: UMLStructuredActivityNode[Uml]): Try[Unit]

  def unlink_ActivityNode_inStructuredNode_composes_node_StructuredActivityNode
  (from: UMLActivityNode[Uml],
   to: UMLStructuredActivityNode[Uml]): Try[Unit]

  def link_InputPin_structuredActivityNode_composes_structuredNodeInput_StructuredActivityNode
  (from: UMLInputPin[Uml],
   to: UMLStructuredActivityNode[Uml]): Try[Unit]

  def unlink_InputPin_structuredActivityNode_composes_structuredNodeInput_StructuredActivityNode
  (from: UMLInputPin[Uml],
   to: UMLStructuredActivityNode[Uml]): Try[Unit]

  def link_OutputPin_structuredActivityNode_composes_structuredNodeOutput_StructuredActivityNode
  (from: UMLOutputPin[Uml],
   to: UMLStructuredActivityNode[Uml]): Try[Unit]

  def unlink_OutputPin_structuredActivityNode_composes_structuredNodeOutput_StructuredActivityNode
  (from: UMLOutputPin[Uml],
   to: UMLStructuredActivityNode[Uml]): Try[Unit]

  def link_Variable_scope_composes_variable_StructuredActivityNode
  (from: UMLVariable[Uml],
   to: UMLStructuredActivityNode[Uml]): Try[Unit]

  def unlink_Variable_scope_composes_variable_StructuredActivityNode
  (from: UMLVariable[Uml],
   to: UMLStructuredActivityNode[Uml]): Try[Unit]

  def set_StructuredActivityNode_mustIsolate
  (e: UMLStructuredActivityNode[Uml], mustIsolate: Boolean): Try[Unit]


  // StructuredClassifier

  def link_Property_structuredClassifier_composes_ownedAttribute_StructuredClassifier
  (from: UMLProperty[Uml],
   to: UMLStructuredClassifier[Uml]): Try[Unit]

  def unlink_Property_structuredClassifier_composes_ownedAttribute_StructuredClassifier
  (from: UMLProperty[Uml],
   to: UMLStructuredClassifier[Uml]): Try[Unit]

  def link_Connector_structuredClassifier_composes_ownedConnector_StructuredClassifier
  (from: UMLConnector[Uml],
   to: UMLStructuredClassifier[Uml]): Try[Unit]

  def unlink_Connector_structuredClassifier_composes_ownedConnector_StructuredClassifier
  (from: UMLConnector[Uml],
   to: UMLStructuredClassifier[Uml]): Try[Unit]


  // Substitution

  def link_Classifier_substitution_references_contract_Substitution
  (from: UMLClassifier[Uml],
   to: UMLSubstitution[Uml]): Try[Unit]

  def unlink_Classifier_substitution_references_contract_Substitution
  (from: UMLClassifier[Uml],
   to: UMLSubstitution[Uml]): Try[Unit]

  def link_Classifier_substitution_references_substitutingClassifier_Substitution
  (from: UMLClassifier[Uml],
   to: UMLSubstitution[Uml]): Try[Unit]

  def unlink_Classifier_substitution_references_substitutingClassifier_Substitution
  (from: UMLClassifier[Uml],
   to: UMLSubstitution[Uml]): Try[Unit]


  // TemplateBinding

  def link_TemplateableElement_templateBinding_references_boundElement_TemplateBinding
  (from: UMLTemplateableElement[Uml],
   to: UMLTemplateBinding[Uml]): Try[Unit]

  def unlink_TemplateableElement_templateBinding_references_boundElement_TemplateBinding
  (from: UMLTemplateableElement[Uml],
   to: UMLTemplateBinding[Uml]): Try[Unit]

  def link_TemplateParameterSubstitution_templateBinding_composes_parameterSubstitution_TemplateBinding
  (from: UMLTemplateParameterSubstitution[Uml],
   to: UMLTemplateBinding[Uml]): Try[Unit]

  def unlink_TemplateParameterSubstitution_templateBinding_composes_parameterSubstitution_TemplateBinding
  (from: UMLTemplateParameterSubstitution[Uml],
   to: UMLTemplateBinding[Uml]): Try[Unit]

  def link_TemplateSignature_templateBinding_references_signature_TemplateBinding
  (from: UMLTemplateSignature[Uml],
   to: UMLTemplateBinding[Uml]): Try[Unit]

  def unlink_TemplateSignature_templateBinding_references_signature_TemplateBinding
  (from: UMLTemplateSignature[Uml],
   to: UMLTemplateBinding[Uml]): Try[Unit]


  // TemplateParameter

  def link_ParameterableElement_templateParameter_references_default_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: UMLTemplateParameter[Uml]): Try[Unit]

  def unlink_ParameterableElement_templateParameter_references_default_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: UMLTemplateParameter[Uml]): Try[Unit]

  def link_ParameterableElement_templateParameter_composes_ownedDefault_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: UMLTemplateParameter[Uml]): Try[Unit]

  def unlink_ParameterableElement_templateParameter_composes_ownedDefault_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: UMLTemplateParameter[Uml]): Try[Unit]

  def link_ParameterableElement_owningTemplateParameter_composes_ownedParameteredElement_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: UMLTemplateParameter[Uml]): Try[Unit]

  def unlink_ParameterableElement_owningTemplateParameter_composes_ownedParameteredElement_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: UMLTemplateParameter[Uml]): Try[Unit]

  def link_ParameterableElement_templateParameter_references_parameteredElement_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: UMLTemplateParameter[Uml]): Try[Unit]

  def unlink_ParameterableElement_templateParameter_references_parameteredElement_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: UMLTemplateParameter[Uml]): Try[Unit]

  def link_TemplateSignature_ownedParameter_references_signature_TemplateParameter
  (from: UMLTemplateSignature[Uml],
   to: UMLTemplateParameter[Uml]): Try[Unit]

  def unlink_TemplateSignature_ownedParameter_references_signature_TemplateParameter
  (from: UMLTemplateSignature[Uml],
   to: UMLTemplateParameter[Uml]): Try[Unit]


  // TemplateParameterSubstitution

  def link_ParameterableElement_templateParameterSubstitution_references_actual_TemplateParameterSubstitution
  (from: UMLParameterableElement[Uml],
   to: UMLTemplateParameterSubstitution[Uml]): Try[Unit]

  def unlink_ParameterableElement_templateParameterSubstitution_references_actual_TemplateParameterSubstitution
  (from: UMLParameterableElement[Uml],
   to: UMLTemplateParameterSubstitution[Uml]): Try[Unit]

  def link_TemplateParameter_templateParameterSubstitution_references_formal_TemplateParameterSubstitution
  (from: UMLTemplateParameter[Uml],
   to: UMLTemplateParameterSubstitution[Uml]): Try[Unit]

  def unlink_TemplateParameter_templateParameterSubstitution_references_formal_TemplateParameterSubstitution
  (from: UMLTemplateParameter[Uml],
   to: UMLTemplateParameterSubstitution[Uml]): Try[Unit]

  def link_ParameterableElement_owningTemplateParameterSubstitution_composes_ownedActual_TemplateParameterSubstitution
  (from: UMLParameterableElement[Uml],
   to: UMLTemplateParameterSubstitution[Uml]): Try[Unit]

  def unlink_ParameterableElement_owningTemplateParameterSubstitution_composes_ownedActual_TemplateParameterSubstitution
  (from: UMLParameterableElement[Uml],
   to: UMLTemplateParameterSubstitution[Uml]): Try[Unit]

  def link_TemplateBinding_parameterSubstitution_references_templateBinding_TemplateParameterSubstitution
  (from: UMLTemplateBinding[Uml],
   to: UMLTemplateParameterSubstitution[Uml]): Try[Unit]

  def unlink_TemplateBinding_parameterSubstitution_references_templateBinding_TemplateParameterSubstitution
  (from: UMLTemplateBinding[Uml],
   to: UMLTemplateParameterSubstitution[Uml]): Try[Unit]


  // TemplateSignature

  def link_TemplateParameter_signature_composes_ownedParameter_TemplateSignature
  (from: UMLTemplateParameter[Uml],
   to: UMLTemplateSignature[Uml]): Try[Unit]

  def unlink_TemplateParameter_signature_composes_ownedParameter_TemplateSignature
  (from: UMLTemplateParameter[Uml],
   to: UMLTemplateSignature[Uml]): Try[Unit]

  def link_TemplateParameter_templateSignature_references_parameter_TemplateSignature
  (from: UMLTemplateParameter[Uml],
   to: UMLTemplateSignature[Uml]): Try[Unit]

  def unlink_TemplateParameter_templateSignature_references_parameter_TemplateSignature
  (from: UMLTemplateParameter[Uml],
   to: UMLTemplateSignature[Uml]): Try[Unit]

  def link_TemplateableElement_ownedTemplateSignature_references_template_TemplateSignature
  (from: UMLTemplateableElement[Uml],
   to: UMLTemplateSignature[Uml]): Try[Unit]

  def unlink_TemplateableElement_ownedTemplateSignature_references_template_TemplateSignature
  (from: UMLTemplateableElement[Uml],
   to: UMLTemplateSignature[Uml]): Try[Unit]


  // TemplateableElement

  def link_TemplateSignature_template_composes_ownedTemplateSignature_TemplateableElement
  (from: UMLTemplateSignature[Uml],
   to: UMLTemplateableElement[Uml]): Try[Unit]

  def unlink_TemplateSignature_template_composes_ownedTemplateSignature_TemplateableElement
  (from: UMLTemplateSignature[Uml],
   to: UMLTemplateableElement[Uml]): Try[Unit]

  def link_TemplateBinding_boundElement_composes_templateBinding_TemplateableElement
  (from: UMLTemplateBinding[Uml],
   to: UMLTemplateableElement[Uml]): Try[Unit]

  def unlink_TemplateBinding_boundElement_composes_templateBinding_TemplateableElement
  (from: UMLTemplateBinding[Uml],
   to: UMLTemplateableElement[Uml]): Try[Unit]


  // TestIdentityAction

  def link_InputPin_testIdentityAction_composes_first_TestIdentityAction
  (from: UMLInputPin[Uml],
   to: UMLTestIdentityAction[Uml]): Try[Unit]

  def unlink_InputPin_testIdentityAction_composes_first_TestIdentityAction
  (from: UMLInputPin[Uml],
   to: UMLTestIdentityAction[Uml]): Try[Unit]

  def link_OutputPin_testIdentityAction_composes_result_TestIdentityAction
  (from: UMLOutputPin[Uml],
   to: UMLTestIdentityAction[Uml]): Try[Unit]

  def unlink_OutputPin_testIdentityAction_composes_result_TestIdentityAction
  (from: UMLOutputPin[Uml],
   to: UMLTestIdentityAction[Uml]): Try[Unit]

  def link_InputPin_testIdentityAction_composes_second_TestIdentityAction
  (from: UMLInputPin[Uml],
   to: UMLTestIdentityAction[Uml]): Try[Unit]

  def unlink_InputPin_testIdentityAction_composes_second_TestIdentityAction
  (from: UMLInputPin[Uml],
   to: UMLTestIdentityAction[Uml]): Try[Unit]


  // TimeConstraint

  def link_TimeInterval_timeConstraint_composes_specification_TimeConstraint
  (from: UMLTimeInterval[Uml],
   to: UMLTimeConstraint[Uml]): Try[Unit]

  def unlink_TimeInterval_timeConstraint_composes_specification_TimeConstraint
  (from: UMLTimeInterval[Uml],
   to: UMLTimeConstraint[Uml]): Try[Unit]

  def set_TimeConstraint_firstEvent
  (e: UMLTimeConstraint[Uml], firstEvent: Option[Boolean]): Try[Unit]


  // TimeEvent

  def link_TimeExpression_timeEvent_composes_when_TimeEvent
  (from: UMLTimeExpression[Uml],
   to: UMLTimeEvent[Uml]): Try[Unit]

  def unlink_TimeExpression_timeEvent_composes_when_TimeEvent
  (from: UMLTimeExpression[Uml],
   to: UMLTimeEvent[Uml]): Try[Unit]

  def set_TimeEvent_isRelative
  (e: UMLTimeEvent[Uml], isRelative: Boolean): Try[Unit]


  // TimeExpression

  def link_ValueSpecification_timeExpression_composes_expr_TimeExpression
  (from: UMLValueSpecification[Uml],
   to: UMLTimeExpression[Uml]): Try[Unit]

  def unlink_ValueSpecification_timeExpression_composes_expr_TimeExpression
  (from: UMLValueSpecification[Uml],
   to: UMLTimeExpression[Uml]): Try[Unit]

  def link_Observation_timeExpression_references_observation_TimeExpression
  (from: UMLObservation[Uml],
   to: UMLTimeExpression[Uml]): Try[Unit]

  def unlink_Observation_timeExpression_references_observation_TimeExpression
  (from: UMLObservation[Uml],
   to: UMLTimeExpression[Uml]): Try[Unit]


  // TimeInterval

  def link_TimeExpression_timeInterval_references_max_TimeInterval
  (from: UMLTimeExpression[Uml],
   to: UMLTimeInterval[Uml]): Try[Unit]

  def unlink_TimeExpression_timeInterval_references_max_TimeInterval
  (from: UMLTimeExpression[Uml],
   to: UMLTimeInterval[Uml]): Try[Unit]

  def link_TimeExpression_timeInterval_references_min_TimeInterval
  (from: UMLTimeExpression[Uml],
   to: UMLTimeInterval[Uml]): Try[Unit]

  def unlink_TimeExpression_timeInterval_references_min_TimeInterval
  (from: UMLTimeExpression[Uml],
   to: UMLTimeInterval[Uml]): Try[Unit]


  // TimeObservation

  def link_NamedElement_timeObservation_references_event_TimeObservation
  (from: UMLNamedElement[Uml],
   to: UMLTimeObservation[Uml]): Try[Unit]

  def unlink_NamedElement_timeObservation_references_event_TimeObservation
  (from: UMLNamedElement[Uml],
   to: UMLTimeObservation[Uml]): Try[Unit]

  def set_TimeObservation_firstEvent
  (e: UMLTimeObservation[Uml], firstEvent: Boolean): Try[Unit]


  // Transition

  def link_Region_transition_references_container_Transition
  (from: UMLRegion[Uml],
   to: UMLTransition[Uml]): Try[Unit]

  def unlink_Region_transition_references_container_Transition
  (from: UMLRegion[Uml],
   to: UMLTransition[Uml]): Try[Unit]

  def link_Behavior_transition_composes_effect_Transition
  (from: UMLBehavior[Uml],
   to: UMLTransition[Uml]): Try[Unit]

  def unlink_Behavior_transition_composes_effect_Transition
  (from: UMLBehavior[Uml],
   to: UMLTransition[Uml]): Try[Unit]

  def link_Constraint_transition_composes_guard_Transition
  (from: UMLConstraint[Uml],
   to: UMLTransition[Uml]): Try[Unit]

  def unlink_Constraint_transition_composes_guard_Transition
  (from: UMLConstraint[Uml],
   to: UMLTransition[Uml]): Try[Unit]

  def link_Transition_transition_references_redefinedTransition_Transition
  (from: UMLTransition[Uml],
   to: UMLTransition[Uml]): Try[Unit]

  def unlink_Transition_transition_references_redefinedTransition_Transition
  (from: UMLTransition[Uml],
   to: UMLTransition[Uml]): Try[Unit]

  def link_Trigger_transition_composes_trigger_Transition
  (from: UMLTrigger[Uml],
   to: UMLTransition[Uml]): Try[Unit]

  def unlink_Trigger_transition_composes_trigger_Transition
  (from: UMLTrigger[Uml],
   to: UMLTransition[Uml]): Try[Unit]

  def set_Transition_kind
  (e: UMLTransition[Uml], kind: UMLTransitionKind.Value): Try[Unit]


  // Trigger

  def link_Event_trigger_references_event_Trigger
  (from: UMLEvent[Uml],
   to: UMLTrigger[Uml]): Try[Unit]

  def unlink_Event_trigger_references_event_Trigger
  (from: UMLEvent[Uml],
   to: UMLTrigger[Uml]): Try[Unit]

  def link_Port_trigger_references_port_Trigger
  (from: UMLPort[Uml],
   to: UMLTrigger[Uml]): Try[Unit]

  def unlink_Port_trigger_references_port_Trigger
  (from: UMLPort[Uml],
   to: UMLTrigger[Uml]): Try[Unit]


  // Type



  // TypedElement

  def link_Type_typedElement_references_type_TypedElement
  (from: UMLType[Uml],
   to: UMLTypedElement[Uml]): Try[Unit]

  def unlink_Type_typedElement_references_type_TypedElement
  (from: UMLType[Uml],
   to: UMLTypedElement[Uml]): Try[Unit]


  // UnmarshallAction

  def link_InputPin_unmarshallAction_composes_object_UnmarshallAction
  (from: UMLInputPin[Uml],
   to: UMLUnmarshallAction[Uml]): Try[Unit]

  def unlink_InputPin_unmarshallAction_composes_object_UnmarshallAction
  (from: UMLInputPin[Uml],
   to: UMLUnmarshallAction[Uml]): Try[Unit]

  def link_OutputPin_unmarshallAction_composes_result_UnmarshallAction
  (from: UMLOutputPin[Uml],
   to: UMLUnmarshallAction[Uml]): Try[Unit]

  def unlink_OutputPin_unmarshallAction_composes_result_UnmarshallAction
  (from: UMLOutputPin[Uml],
   to: UMLUnmarshallAction[Uml]): Try[Unit]

  def link_Classifier_unmarshallAction_references_unmarshallType_UnmarshallAction
  (from: UMLClassifier[Uml],
   to: UMLUnmarshallAction[Uml]): Try[Unit]

  def unlink_Classifier_unmarshallAction_references_unmarshallType_UnmarshallAction
  (from: UMLClassifier[Uml],
   to: UMLUnmarshallAction[Uml]): Try[Unit]


  // Usage



  // UseCase

  def link_Extend_extension_composes_extend_UseCase
  (from: UMLExtend[Uml],
   to: UMLUseCase[Uml]): Try[Unit]

  def unlink_Extend_extension_composes_extend_UseCase
  (from: UMLExtend[Uml],
   to: UMLUseCase[Uml]): Try[Unit]

  def link_ExtensionPoint_useCase_composes_extensionPoint_UseCase
  (from: UMLExtensionPoint[Uml],
   to: UMLUseCase[Uml]): Try[Unit]

  def unlink_ExtensionPoint_useCase_composes_extensionPoint_UseCase
  (from: UMLExtensionPoint[Uml],
   to: UMLUseCase[Uml]): Try[Unit]

  def link_Include_includingCase_composes_include_UseCase
  (from: UMLInclude[Uml],
   to: UMLUseCase[Uml]): Try[Unit]

  def unlink_Include_includingCase_composes_include_UseCase
  (from: UMLInclude[Uml],
   to: UMLUseCase[Uml]): Try[Unit]

  def link_Classifier_useCase_references_subject_UseCase
  (from: UMLClassifier[Uml],
   to: UMLUseCase[Uml]): Try[Unit]

  def unlink_Classifier_useCase_references_subject_UseCase
  (from: UMLClassifier[Uml],
   to: UMLUseCase[Uml]): Try[Unit]


  // ValuePin

  def link_ValueSpecification_valuePin_composes_value_ValuePin
  (from: UMLValueSpecification[Uml],
   to: UMLValuePin[Uml]): Try[Unit]

  def unlink_ValueSpecification_valuePin_composes_value_ValuePin
  (from: UMLValueSpecification[Uml],
   to: UMLValuePin[Uml]): Try[Unit]


  // ValueSpecification



  // ValueSpecificationAction

  def link_OutputPin_valueSpecificationAction_composes_result_ValueSpecificationAction
  (from: UMLOutputPin[Uml],
   to: UMLValueSpecificationAction[Uml]): Try[Unit]

  def unlink_OutputPin_valueSpecificationAction_composes_result_ValueSpecificationAction
  (from: UMLOutputPin[Uml],
   to: UMLValueSpecificationAction[Uml]): Try[Unit]

  def link_ValueSpecification_valueSpecificationAction_composes_value_ValueSpecificationAction
  (from: UMLValueSpecification[Uml],
   to: UMLValueSpecificationAction[Uml]): Try[Unit]

  def unlink_ValueSpecification_valueSpecificationAction_composes_value_ValueSpecificationAction
  (from: UMLValueSpecification[Uml],
   to: UMLValueSpecificationAction[Uml]): Try[Unit]


  // Variable

  def link_Activity_variable_references_activityScope_Variable
  (from: UMLActivity[Uml],
   to: UMLVariable[Uml]): Try[Unit]

  def unlink_Activity_variable_references_activityScope_Variable
  (from: UMLActivity[Uml],
   to: UMLVariable[Uml]): Try[Unit]

  def link_StructuredActivityNode_variable_references_scope_Variable
  (from: UMLStructuredActivityNode[Uml],
   to: UMLVariable[Uml]): Try[Unit]

  def unlink_StructuredActivityNode_variable_references_scope_Variable
  (from: UMLStructuredActivityNode[Uml],
   to: UMLVariable[Uml]): Try[Unit]


  // VariableAction

  def link_Variable_variableAction_references_variable_VariableAction
  (from: UMLVariable[Uml],
   to: UMLVariableAction[Uml]): Try[Unit]

  def unlink_Variable_variableAction_references_variable_VariableAction
  (from: UMLVariable[Uml],
   to: UMLVariableAction[Uml]): Try[Unit]


  // Vertex

  def link_Region_subvertex_references_container_Vertex
  (from: UMLRegion[Uml],
   to: UMLVertex[Uml]): Try[Unit]

  def unlink_Region_subvertex_references_container_Vertex
  (from: UMLRegion[Uml],
   to: UMLVertex[Uml]): Try[Unit]


  // WriteLinkAction



  // WriteStructuralFeatureAction

  def link_OutputPin_writeStructuralFeatureAction_composes_result_WriteStructuralFeatureAction
  (from: UMLOutputPin[Uml],
   to: UMLWriteStructuralFeatureAction[Uml]): Try[Unit]

  def unlink_OutputPin_writeStructuralFeatureAction_composes_result_WriteStructuralFeatureAction
  (from: UMLOutputPin[Uml],
   to: UMLWriteStructuralFeatureAction[Uml]): Try[Unit]

  def link_InputPin_writeStructuralFeatureAction_composes_value_WriteStructuralFeatureAction
  (from: UMLInputPin[Uml],
   to: UMLWriteStructuralFeatureAction[Uml]): Try[Unit]

  def unlink_InputPin_writeStructuralFeatureAction_composes_value_WriteStructuralFeatureAction
  (from: UMLInputPin[Uml],
   to: UMLWriteStructuralFeatureAction[Uml]): Try[Unit]


  // WriteVariableAction

  def link_InputPin_writeVariableAction_composes_value_WriteVariableAction
  (from: UMLInputPin[Uml],
   to: UMLWriteVariableAction[Uml]): Try[Unit]

  def unlink_InputPin_writeVariableAction_composes_value_WriteVariableAction
  (from: UMLInputPin[Uml],
   to: UMLWriteVariableAction[Uml]): Try[Unit]

	// Start of user code for additional features
	// End of user code
}
