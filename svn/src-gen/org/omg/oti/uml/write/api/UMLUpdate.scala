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
   to: Option[UMLOpaqueExpression[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_AcceptCallAction_acceptCallAction_compose_returnInformation_OutputPin
  (from: UMLAcceptCallAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_AcceptEventAction_acceptEventAction_compose_result_OutputPin
  (from: UMLAcceptEventAction[Uml],
   to: Seq[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_AcceptEventAction_acceptEventAction_compose_trigger_Trigger
  (from: UMLAcceptEventAction[Uml],
   to: Set[UMLTrigger[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Action_action_compose_localPostcondition_Constraint
  (from: UMLAction[Uml],
   to: Set[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Action_action_compose_localPrecondition_Constraint
  (from: UMLAction[Uml],
   to: Set[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActionExecutionSpecification_actionExecutionSpecification_reference_action_Action
  (from: UMLActionExecutionSpecification[Uml],
   to: Option[UMLAction[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActionInputPin_actionInputPin_compose_fromAction_Action
  (from: UMLActionInputPin[Uml],
   to: Option[UMLAction[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Activity_activity_compose_edge_ActivityEdge
  (from: UMLActivity[Uml],
   to: Set[UMLActivityEdge[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Activity_inActivity_compose_group_ActivityGroup
  (from: UMLActivity[Uml],
   to: Set[UMLActivityGroup[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Activity_activity_compose_node_ActivityNode
  (from: UMLActivity[Uml],
   to: Set[UMLActivityNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Activity_activity_reference_partition_ActivityPartition
  (from: UMLActivity[Uml],
   to: Set[UMLActivityPartition[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Activity_activity_compose_structuredNode_StructuredActivityNode
  (from: UMLActivity[Uml],
   to: Set[UMLStructuredActivityNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Activity_activityScope_compose_variable_Variable
  (from: UMLActivity[Uml],
   to: Set[UMLVariable[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityEdge_activityEdge_compose_guard_ValueSpecification
  (from: UMLActivityEdge[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityEdge_edge_reference_inPartition_ActivityPartition
  (from: UMLActivityEdge[Uml],
   to: Set[UMLActivityPartition[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityEdge_interruptingEdge_reference_interrupts_InterruptibleActivityRegion
  (from: UMLActivityEdge[Uml],
   to: Option[UMLInterruptibleActivityRegion[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityEdge_activityEdge_reference_redefinedEdge_ActivityEdge
  (from: UMLActivityEdge[Uml],
   to: Set[UMLActivityEdge[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityEdge_outgoing_reference_source_ActivityNode
  (from: UMLActivityEdge[Uml],
   to: Option[UMLActivityNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityEdge_incoming_reference_target_ActivityNode
  (from: UMLActivityEdge[Uml],
   to: Option[UMLActivityNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityEdge_activityEdge_compose_weight_ValueSpecification
  (from: UMLActivityEdge[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion
  (from: UMLActivityNode[Uml],
   to: Set[UMLInterruptibleActivityRegion[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityNode_node_reference_inPartition_ActivityPartition
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityPartition[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityNode_target_reference_incoming_ActivityEdge
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityEdge[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityNode_source_reference_outgoing_ActivityEdge
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityEdge[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityParameterNode_activityParameterNode_reference_parameter_Parameter
  (from: UMLActivityParameterNode[Uml],
   to: Option[UMLParameter[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityPartition_inPartition_reference_edge_ActivityEdge
  (from: UMLActivityPartition[Uml],
   to: Set[UMLActivityEdge[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityPartition_inPartition_reference_node_ActivityNode
  (from: UMLActivityPartition[Uml],
   to: Set[UMLActivityNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityPartition_activityPartition_reference_represents_Element
  (from: UMLActivityPartition[Uml],
   to: Option[UMLElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ActivityPartition_superPartition_compose_subpartition_ActivityPartition
  (from: UMLActivityPartition[Uml],
   to: Set[UMLActivityPartition[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_AddStructuralFeatureValueAction_addStructuralFeatureValueAction_compose_insertAt_InputPin
  (from: UMLAddStructuralFeatureValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_AddVariableValueAction_addVariableValueAction_compose_insertAt_InputPin
  (from: UMLAddVariableValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Artifact_artifact_compose_manifestation_Manifestation
  (from: UMLArtifact[Uml],
   to: Set[UMLManifestation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Artifact_artifact_compose_nestedArtifact_Artifact
  (from: UMLArtifact[Uml],
   to: Set[UMLArtifact[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Artifact_artifact_compose_ownedAttribute_Property
  (from: UMLArtifact[Uml],
   to: Seq[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Artifact_artifact_compose_ownedOperation_Operation
  (from: UMLArtifact[Uml],
   to: Seq[UMLOperation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Association_association_reference_memberEnd_Property
  (from: UMLAssociation[Uml],
   to: Seq[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Association_association_reference_navigableOwnedEnd_Property
  (from: UMLAssociation[Uml],
   to: Set[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Association_owningAssociation_compose_ownedEnd_Property
  (from: UMLAssociation[Uml],
   to: Iterable[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Behavior_behavior_compose_ownedParameter_Parameter
  (from: UMLBehavior[Uml],
   to: Seq[UMLParameter[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Behavior_behavior_compose_ownedParameterSet_ParameterSet
  (from: UMLBehavior[Uml],
   to: Set[UMLParameterSet[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Behavior_behavior_compose_postcondition_Constraint
  (from: UMLBehavior[Uml],
   to: Set[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Behavior_behavior_compose_precondition_Constraint
  (from: UMLBehavior[Uml],
   to: Set[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Behavior_behavior_reference_redefinedBehavior_Behavior
  (from: UMLBehavior[Uml],
   to: Set[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Behavior_method_reference_specification_BehavioralFeature
  (from: UMLBehavior[Uml],
   to: Option[UMLBehavioralFeature[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_BehaviorExecutionSpecification_behaviorExecutionSpecification_reference_behavior_Behavior
  (from: UMLBehaviorExecutionSpecification[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_BehavioralFeature_specification_reference_method_Behavior
  (from: UMLBehavioralFeature[Uml],
   to: Set[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_BehavioralFeature_ownerFormalParam_compose_ownedParameter_Parameter
  (from: UMLBehavioralFeature[Uml],
   to: Seq[UMLParameter[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_BehavioralFeature_behavioralFeature_compose_ownedParameterSet_ParameterSet
  (from: UMLBehavioralFeature[Uml],
   to: Set[UMLParameterSet[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_BehavioralFeature_behavioralFeature_reference_raisedException_Type
  (from: UMLBehavioralFeature[Uml],
   to: Set[UMLType[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior
  (from: UMLBehavioredClassifier[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization
  (from: UMLBehavioredClassifier[Uml],
   to: Set[UMLInterfaceRealization[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior
  (from: UMLBehavioredClassifier[Uml],
   to: Set[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_BroadcastSignalAction_broadcastSignalAction_reference_signal_Signal
  (from: UMLBroadcastSignalAction[Uml],
   to: Option[UMLSignal[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CallAction_callAction_compose_result_OutputPin
  (from: UMLCallAction[Uml],
   to: Seq[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CallBehaviorAction_callBehaviorAction_reference_behavior_Behavior
  (from: UMLCallBehaviorAction[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CallEvent_callEvent_reference_operation_Operation
  (from: UMLCallEvent[Uml],
   to: Option[UMLOperation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CallOperationAction_callOperationAction_reference_operation_Operation
  (from: UMLCallOperationAction[Uml],
   to: Option[UMLOperation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CallOperationAction_callOperationAction_compose_target_InputPin
  (from: UMLCallOperationAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ChangeEvent_changeEvent_compose_changeExpression_ValueSpecification
  (from: UMLChangeEvent[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Class_nestingClass_compose_nestedClassifier_Classifier
  (from: UMLClass[Uml],
   to: Seq[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Class_class_compose_ownedAttribute_Property
  (from: UMLClass[Uml],
   to: Seq[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Class_class_compose_ownedOperation_Operation
  (from: UMLClass[Uml],
   to: Seq[UMLOperation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Class_class_compose_ownedReception_Reception
  (from: UMLClass[Uml],
   to: Set[UMLReception[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Classifier_classifier_compose_collaborationUse_CollaborationUse
  (from: UMLClassifier[Uml],
   to: Set[UMLCollaborationUse[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Classifier_specific_compose_generalization_Generalization
  (from: UMLClassifier[Uml],
   to: Set[UMLGeneralization[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature
  (from: UMLClassifier[Uml],
   to: Option[UMLRedefinableTemplateSignature[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Classifier_classifier_compose_ownedUseCase_UseCase
  (from: UMLClassifier[Uml],
   to: Set[UMLUseCase[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet
  (from: UMLClassifier[Uml],
   to: Set[UMLGeneralizationSet[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Classifier_classifier_reference_redefinedClassifier_Classifier
  (from: UMLClassifier[Uml],
   to: Set[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Classifier_classifier_reference_representation_CollaborationUse
  (from: UMLClassifier[Uml],
   to: Option[UMLCollaborationUse[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Classifier_substitutingClassifier_compose_substitution_Substitution
  (from: UMLClassifier[Uml],
   to: Set[UMLSubstitution[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter
  (from: UMLClassifier[Uml],
   to: Option[UMLClassifierTemplateParameter[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Classifier_subject_reference_useCase_UseCase
  (from: UMLClassifier[Uml],
   to: Set[UMLUseCase[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ClassifierTemplateParameter_classifierTemplateParameter_reference_constrainingClassifier_Classifier
  (from: UMLClassifierTemplateParameter[Uml],
   to: Set[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ClassifierTemplateParameter_templateParameter_reference_parameteredElement_Classifier
  (from: UMLClassifierTemplateParameter[Uml],
   to: Option[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Clause_clause_reference_body_ExecutableNode
  (from: UMLClause[Uml],
   to: Set[UMLExecutableNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Clause_clause_reference_bodyOutput_OutputPin
  (from: UMLClause[Uml],
   to: Seq[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Clause_clause_reference_decider_OutputPin
  (from: UMLClause[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Clause_successorClause_reference_predecessorClause_Clause
  (from: UMLClause[Uml],
   to: Set[UMLClause[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Clause_predecessorClause_reference_successorClause_Clause
  (from: UMLClause[Uml],
   to: Set[UMLClause[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Clause_clause_reference_test_ExecutableNode
  (from: UMLClause[Uml],
   to: Set[UMLExecutableNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ClearAssociationAction_clearAssociationAction_reference_association_Association
  (from: UMLClearAssociationAction[Uml],
   to: Option[UMLAssociation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ClearAssociationAction_clearAssociationAction_compose_object_InputPin
  (from: UMLClearAssociationAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ClearStructuralFeatureAction_clearStructuralFeatureAction_compose_result_OutputPin
  (from: UMLClearStructuralFeatureAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Collaboration_collaboration_reference_collaborationRole_ConnectableElement
  (from: UMLCollaboration[Uml],
   to: Set[UMLConnectableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CollaborationUse_collaborationUse_compose_roleBinding_Dependency
  (from: UMLCollaborationUse[Uml],
   to: Set[UMLDependency[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CollaborationUse_collaborationUse_reference_type_Collaboration
  (from: UMLCollaborationUse[Uml],
   to: Option[UMLCollaboration[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CombinedFragment_combinedFragment_compose_cfragmentGate_Gate
  (from: UMLCombinedFragment[Uml],
   to: Set[UMLGate[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CombinedFragment_combinedFragment_compose_operand_InteractionOperand
  (from: UMLCombinedFragment[Uml],
   to: Seq[UMLInteractionOperand[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Comment_comment_reference_annotatedElement_Element
  (from: UMLComment[Uml],
   to: Set[UMLElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Component_component_compose_packagedElement_PackageableElement
  (from: UMLComponent[Uml],
   to: Set[UMLPackageableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Component_abstraction_compose_realization_ComponentRealization
  (from: UMLComponent[Uml],
   to: Set[UMLComponentRealization[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ComponentRealization_componentRealization_reference_realizingClassifier_Classifier
  (from: UMLComponentRealization[Uml],
   to: Set[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ConditionalNode_conditionalNode_compose_clause_Clause
  (from: UMLConditionalNode[Uml],
   to: Set[UMLClause[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ConditionalNode_conditionalNode_compose_result_OutputPin
  (from: UMLConditionalNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter
  (from: UMLConnectableElement[Uml],
   to: Option[UMLConnectableElementTemplateParameter[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ConnectableElementTemplateParameter_templateParameter_reference_parameteredElement_ConnectableElement
  (from: UMLConnectableElementTemplateParameter[Uml],
   to: Option[UMLConnectableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ConnectionPointReference_connectionPointReference_reference_entry_Pseudostate
  (from: UMLConnectionPointReference[Uml],
   to: Set[UMLPseudostate[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ConnectionPointReference_connectionPointReference_reference_exit_Pseudostate
  (from: UMLConnectionPointReference[Uml],
   to: Set[UMLPseudostate[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Connector_connector_reference_contract_Behavior
  (from: UMLConnector[Uml],
   to: Set[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Connector_connector_compose_end_ConnectorEnd
  (from: UMLConnector[Uml],
   to: Seq[UMLConnectorEnd[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Connector_connector_reference_redefinedConnector_Connector
  (from: UMLConnector[Uml],
   to: Set[UMLConnector[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Connector_connector_reference_type_Association
  (from: UMLConnector[Uml],
   to: Option[UMLAssociation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ConnectorEnd_connectorEnd_reference_partWithPort_Property
  (from: UMLConnectorEnd[Uml],
   to: Option[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ConnectorEnd_end_reference_role_ConnectableElement
  (from: UMLConnectorEnd[Uml],
   to: Option[UMLConnectableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ConsiderIgnoreFragment_considerIgnoreFragment_reference_message_NamedElement
  (from: UMLConsiderIgnoreFragment[Uml],
   to: Set[UMLNamedElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Constraint_constraint_reference_constrainedElement_Element
  (from: UMLConstraint[Uml],
   to: Seq[UMLElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Constraint_owningConstraint_compose_specification_ValueSpecification
  (from: UMLConstraint[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CreateLinkAction_createLinkAction_compose_endData_LinkEndCreationData
  (from: UMLCreateLinkAction[Uml],
   to: Iterable[UMLLinkEndCreationData[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CreateLinkObjectAction_createLinkObjectAction_compose_result_OutputPin
  (from: UMLCreateLinkObjectAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CreateObjectAction_createObjectAction_reference_classifier_Classifier
  (from: UMLCreateObjectAction[Uml],
   to: Option[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_CreateObjectAction_createObjectAction_compose_result_OutputPin
  (from: UMLCreateObjectAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_DataType_datatype_compose_ownedAttribute_Property
  (from: UMLDataType[Uml],
   to: Seq[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_DataType_datatype_compose_ownedOperation_Operation
  (from: UMLDataType[Uml],
   to: Seq[UMLOperation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_DecisionNode_decisionNode_reference_decisionInput_Behavior
  (from: UMLDecisionNode[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_DecisionNode_decisionNode_reference_decisionInputFlow_ObjectFlow
  (from: UMLDecisionNode[Uml],
   to: Option[UMLObjectFlow[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Dependency_clientDependency_reference_client_NamedElement
  (from: UMLDependency[Uml],
   to: Set[UMLNamedElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Dependency_supplierDependency_reference_supplier_NamedElement
  (from: UMLDependency[Uml],
   to: Set[UMLNamedElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Deployment_deployment_compose_configuration_DeploymentSpecification
  (from: UMLDeployment[Uml],
   to: Set[UMLDeploymentSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Deployment_deploymentForArtifact_reference_deployedArtifact_DeployedArtifact
  (from: UMLDeployment[Uml],
   to: Set[UMLDeployedArtifact[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_DeploymentTarget_location_compose_deployment_Deployment
  (from: UMLDeploymentTarget[Uml],
   to: Set[UMLDeployment[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_DestroyLinkAction_destroyLinkAction_compose_endData_LinkEndDestructionData
  (from: UMLDestroyLinkAction[Uml],
   to: Iterable[UMLLinkEndDestructionData[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_DestroyObjectAction_destroyObjectAction_compose_target_InputPin
  (from: UMLDestroyObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Diagram_diagram_reference_context_Element
  (from: UMLDiagram[Uml],
   to: Option[UMLElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Duration_duration_compose_expr_ValueSpecification
  (from: UMLDuration[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Duration_duration_reference_observation_Observation
  (from: UMLDuration[Uml],
   to: Set[UMLObservation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_DurationConstraint_durationConstraint_compose_specification_DurationInterval
  (from: UMLDurationConstraint[Uml],
   to: Option[UMLDurationInterval[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_DurationInterval_durationInterval_reference_max_Duration
  (from: UMLDurationInterval[Uml],
   to: Option[UMLDuration[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_DurationInterval_durationInterval_reference_min_Duration
  (from: UMLDurationInterval[Uml],
   to: Option[UMLDuration[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_DurationObservation_durationObservation_reference_event_NamedElement
  (from: UMLDurationObservation[Uml],
   to: Seq[UMLNamedElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Element_owningElement_compose_ownedComment_Comment
  (from: UMLElement[Uml],
   to: Set[UMLComment[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ElementImport_import_reference_importedElement_PackageableElement
  (from: UMLElementImport[Uml],
   to: Option[UMLPackageableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ElementValue_elementValue_reference_element_Element
  (from: UMLElementValue[Uml],
   to: Option[UMLElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Enumeration_enumeration_compose_ownedLiteral_EnumerationLiteral
  (from: UMLEnumeration[Uml],
   to: Seq[UMLEnumerationLiteral[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ExceptionHandler_exceptionHandler_reference_exceptionInput_ObjectNode
  (from: UMLExceptionHandler[Uml],
   to: Option[UMLObjectNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ExceptionHandler_exceptionHandler_reference_exceptionType_Classifier
  (from: UMLExceptionHandler[Uml],
   to: Set[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ExceptionHandler_exceptionHandler_reference_handlerBody_ExecutableNode
  (from: UMLExceptionHandler[Uml],
   to: Option[UMLExecutableNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler
  (from: UMLExecutableNode[Uml],
   to: Set[UMLExceptionHandler[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ExecutionOccurrenceSpecification_executionOccurrenceSpecification_reference_execution_ExecutionSpecification
  (from: UMLExecutionOccurrenceSpecification[Uml],
   to: Option[UMLExecutionSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ExecutionSpecification_executionSpecification_reference_finish_OccurrenceSpecification
  (from: UMLExecutionSpecification[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ExecutionSpecification_executionSpecification_reference_start_OccurrenceSpecification
  (from: UMLExecutionSpecification[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ExpansionNode_inputElement_reference_regionAsInput_ExpansionRegion
  (from: UMLExpansionNode[Uml],
   to: Option[UMLExpansionRegion[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ExpansionNode_outputElement_reference_regionAsOutput_ExpansionRegion
  (from: UMLExpansionNode[Uml],
   to: Option[UMLExpansionRegion[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ExpansionRegion_regionAsInput_reference_inputElement_ExpansionNode
  (from: UMLExpansionRegion[Uml],
   to: Set[UMLExpansionNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ExpansionRegion_regionAsOutput_reference_outputElement_ExpansionNode
  (from: UMLExpansionRegion[Uml],
   to: Set[UMLExpansionNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Expression_expression_compose_operand_ValueSpecification
  (from: UMLExpression[Uml],
   to: Seq[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Extend_extend_compose_condition_Constraint
  (from: UMLExtend[Uml],
   to: Option[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Extend_extend_reference_extendedCase_UseCase
  (from: UMLExtend[Uml],
   to: Option[UMLUseCase[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Extend_extension_reference_extensionLocation_ExtensionPoint
  (from: UMLExtend[Uml],
   to: Seq[UMLExtensionPoint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Extension_extension_compose_ownedEnd_ExtensionEnd
  (from: UMLExtension[Uml],
   to: Iterable[UMLExtensionEnd[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ExtensionEnd_extensionEnd_reference_type_Stereotype
  (from: UMLExtensionEnd[Uml],
   to: Option[UMLStereotype[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_GeneralOrdering_toBefore_reference_after_OccurrenceSpecification
  (from: UMLGeneralOrdering[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_GeneralOrdering_toAfter_reference_before_OccurrenceSpecification
  (from: UMLGeneralOrdering[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Generalization_generalization_reference_general_Classifier
  (from: UMLGeneralization[Uml],
   to: Option[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Generalization_generalization_reference_generalizationSet_GeneralizationSet
  (from: UMLGeneralization[Uml],
   to: Set[UMLGeneralizationSet[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_GeneralizationSet_generalizationSet_reference_generalization_Generalization
  (from: UMLGeneralizationSet[Uml],
   to: Set[UMLGeneralization[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_GeneralizationSet_powertypeExtent_reference_powertype_Classifier
  (from: UMLGeneralizationSet[Uml],
   to: Option[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Include_include_reference_addition_UseCase
  (from: UMLInclude[Uml],
   to: Option[UMLUseCase[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InformationFlow_conveyingFlow_reference_conveyed_Classifier
  (from: UMLInformationFlow[Uml],
   to: Set[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InformationFlow_informationFlow_reference_informationSource_NamedElement
  (from: UMLInformationFlow[Uml],
   to: Set[UMLNamedElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InformationFlow_informationFlow_reference_informationTarget_NamedElement
  (from: UMLInformationFlow[Uml],
   to: Set[UMLNamedElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InformationFlow_abstraction_reference_realization_Relationship
  (from: UMLInformationFlow[Uml],
   to: Set[UMLRelationship[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InformationFlow_informationFlow_reference_realizingActivityEdge_ActivityEdge
  (from: UMLInformationFlow[Uml],
   to: Set[UMLActivityEdge[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InformationFlow_informationFlow_reference_realizingConnector_Connector
  (from: UMLInformationFlow[Uml],
   to: Set[UMLConnector[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InformationFlow_informationFlow_reference_realizingMessage_Message
  (from: UMLInformationFlow[Uml],
   to: Set[UMLMessage[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InformationItem_representation_reference_represented_Classifier
  (from: UMLInformationItem[Uml],
   to: Set[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InstanceSpecification_instanceSpecification_reference_classifier_Classifier
  (from: UMLInstanceSpecification[Uml],
   to: Iterable[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InstanceSpecification_owningInstance_compose_slot_Slot
  (from: UMLInstanceSpecification[Uml],
   to: Set[UMLSlot[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InstanceSpecification_owningInstanceSpec_compose_specification_ValueSpecification
  (from: UMLInstanceSpecification[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InstanceValue_instanceValue_reference_instance_InstanceSpecification
  (from: UMLInstanceValue[Uml],
   to: Option[UMLInstanceSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interaction_interaction_compose_action_Action
  (from: UMLInteraction[Uml],
   to: Set[UMLAction[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interaction_interaction_compose_formalGate_Gate
  (from: UMLInteraction[Uml],
   to: Set[UMLGate[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interaction_enclosingInteraction_compose_fragment_InteractionFragment
  (from: UMLInteraction[Uml],
   to: Seq[UMLInteractionFragment[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interaction_interaction_compose_lifeline_Lifeline
  (from: UMLInteraction[Uml],
   to: Set[UMLLifeline[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interaction_interaction_compose_message_Message
  (from: UMLInteraction[Uml],
   to: Set[UMLMessage[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InteractionConstraint_interactionConstraint_compose_maxint_ValueSpecification
  (from: UMLInteractionConstraint[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InteractionConstraint_interactionConstraint_compose_minint_ValueSpecification
  (from: UMLInteractionConstraint[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InteractionFragment_coveredBy_reference_covered_Lifeline
  (from: UMLInteractionFragment[Uml],
   to: Iterable[UMLLifeline[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering
  (from: UMLInteractionFragment[Uml],
   to: Set[UMLGeneralOrdering[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InteractionOperand_enclosingOperand_compose_fragment_InteractionFragment
  (from: UMLInteractionOperand[Uml],
   to: Seq[UMLInteractionFragment[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InteractionOperand_interactionOperand_compose_guard_InteractionConstraint
  (from: UMLInteractionOperand[Uml],
   to: Option[UMLInteractionConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InteractionUse_interactionUse_compose_actualGate_Gate
  (from: UMLInteractionUse[Uml],
   to: Set[UMLGate[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InteractionUse_interactionUse_compose_argument_ValueSpecification
  (from: UMLInteractionUse[Uml],
   to: Seq[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InteractionUse_interactionUse_reference_refersTo_Interaction
  (from: UMLInteractionUse[Uml],
   to: Option[UMLInteraction[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InteractionUse_interactionUse_compose_returnValue_ValueSpecification
  (from: UMLInteractionUse[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InteractionUse_interactionUse_reference_returnValueRecipient_Property
  (from: UMLInteractionUse[Uml],
   to: Option[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interface_interface_compose_nestedClassifier_Classifier
  (from: UMLInterface[Uml],
   to: Seq[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interface_interface_compose_ownedAttribute_Property
  (from: UMLInterface[Uml],
   to: Seq[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interface_interface_compose_ownedOperation_Operation
  (from: UMLInterface[Uml],
   to: Seq[UMLOperation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interface_interface_compose_ownedReception_Reception
  (from: UMLInterface[Uml],
   to: Set[UMLReception[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interface_interface_compose_protocol_ProtocolStateMachine
  (from: UMLInterface[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interface_interface_reference_redefinedInterface_Interface
  (from: UMLInterface[Uml],
   to: Set[UMLInterface[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InterfaceRealization_interfaceRealization_reference_contract_Interface
  (from: UMLInterfaceRealization[Uml],
   to: Option[UMLInterface[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InterruptibleActivityRegion_interrupts_reference_interruptingEdge_ActivityEdge
  (from: UMLInterruptibleActivityRegion[Uml],
   to: Set[UMLActivityEdge[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InterruptibleActivityRegion_inInterruptibleRegion_reference_node_ActivityNode
  (from: UMLInterruptibleActivityRegion[Uml],
   to: Set[UMLActivityNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interval_interval_reference_max_ValueSpecification
  (from: UMLInterval[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Interval_interval_reference_min_ValueSpecification
  (from: UMLInterval[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_IntervalConstraint_intervalConstraint_compose_specification_Interval
  (from: UMLIntervalConstraint[Uml],
   to: Option[UMLInterval[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InvocationAction_invocationAction_compose_argument_InputPin
  (from: UMLInvocationAction[Uml],
   to: Seq[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_InvocationAction_invocationAction_reference_onPort_Port
  (from: UMLInvocationAction[Uml],
   to: Option[UMLPort[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_JoinNode_joinNode_compose_joinSpec_ValueSpecification
  (from: UMLJoinNode[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Lifeline_covered_reference_coveredBy_InteractionFragment
  (from: UMLLifeline[Uml],
   to: Set[UMLInteractionFragment[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Lifeline_lifeline_reference_decomposedAs_PartDecomposition
  (from: UMLLifeline[Uml],
   to: Option[UMLPartDecomposition[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Lifeline_lifeline_reference_represents_ConnectableElement
  (from: UMLLifeline[Uml],
   to: Option[UMLConnectableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Lifeline_lifeline_compose_selector_ValueSpecification
  (from: UMLLifeline[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LinkAction_linkAction_compose_endData_LinkEndData
  (from: UMLLinkAction[Uml],
   to: Iterable[UMLLinkEndData[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LinkAction_linkAction_compose_inputValue_InputPin
  (from: UMLLinkAction[Uml],
   to: Set[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LinkEndCreationData_linkEndCreationData_reference_insertAt_InputPin
  (from: UMLLinkEndCreationData[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LinkEndData_linkEndData_reference_end_Property
  (from: UMLLinkEndData[Uml],
   to: Option[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LinkEndData_linkEndData_compose_qualifier_QualifierValue
  (from: UMLLinkEndData[Uml],
   to: Set[UMLQualifierValue[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LinkEndData_linkEndData_reference_value_InputPin
  (from: UMLLinkEndData[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LinkEndDestructionData_linkEndDestructionData_reference_destroyAt_InputPin
  (from: UMLLinkEndDestructionData[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LoopNode_loopNode_reference_bodyOutput_OutputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LoopNode_loopNode_reference_bodyPart_ExecutableNode
  (from: UMLLoopNode[Uml],
   to: Set[UMLExecutableNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LoopNode_loopNode_reference_decider_OutputPin
  (from: UMLLoopNode[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LoopNode_loopNode_compose_loopVariable_OutputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LoopNode_loopNode_compose_loopVariableInput_InputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LoopNode_loopNode_compose_result_OutputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LoopNode_loopNode_reference_setupPart_ExecutableNode
  (from: UMLLoopNode[Uml],
   to: Set[UMLExecutableNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_LoopNode_loopNode_reference_test_ExecutableNode
  (from: UMLLoopNode[Uml],
   to: Set[UMLExecutableNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Manifestation_manifestation_reference_utilizedElement_PackageableElement
  (from: UMLManifestation[Uml],
   to: Option[UMLPackageableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Message_message_compose_argument_ValueSpecification
  (from: UMLMessage[Uml],
   to: Seq[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Message_message_reference_connector_Connector
  (from: UMLMessage[Uml],
   to: Option[UMLConnector[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Message_endMessage_reference_receiveEvent_MessageEnd
  (from: UMLMessage[Uml],
   to: Option[UMLMessageEnd[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Message_endMessage_reference_sendEvent_MessageEnd
  (from: UMLMessage[Uml],
   to: Option[UMLMessageEnd[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Message_message_reference_signature_NamedElement
  (from: UMLMessage[Uml],
   to: Option[UMLNamedElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_MessageEnd_messageEnd_reference_message_Message
  (from: UMLMessageEnd[Uml],
   to: Option[UMLMessage[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification
  (from: UMLMultiplicityElement[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification
  (from: UMLMultiplicityElement[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_NamedElement_namedElement_compose_nameExpression_StringExpression
  (from: UMLNamedElement[Uml],
   to: Option[UMLStringExpression[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Namespace_importingNamespace_compose_elementImport_ElementImport
  (from: UMLNamespace[Uml],
   to: Set[UMLElementImport[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Namespace_diagramOwner_compose_ownedDiagram_Diagram
  (from: UMLNamespace[Uml],
   to: Set[UMLDiagram[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Namespace_context_compose_ownedRule_Constraint
  (from: UMLNamespace[Uml],
   to: Set[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Namespace_importingNamespace_compose_packageImport_PackageImport
  (from: UMLNamespace[Uml],
   to: Set[UMLPackageImport[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Node_node_compose_nestedNode_Node
  (from: UMLNode[Uml],
   to: Set[UMLNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ObjectFlow_objectFlow_reference_selection_Behavior
  (from: UMLObjectFlow[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ObjectFlow_objectFlow_reference_transformation_Behavior
  (from: UMLObjectFlow[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ObjectNode_objectNode_reference_inState_State
  (from: UMLObjectNode[Uml],
   to: Set[UMLState[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ObjectNode_objectNode_reference_selection_Behavior
  (from: UMLObjectNode[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ObjectNode_objectNode_compose_upperBound_ValueSpecification
  (from: UMLObjectNode[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_OccurrenceSpecification_events_reference_covered_Lifeline
  (from: UMLOccurrenceSpecification[Uml],
   to: Iterable[UMLLifeline[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_OccurrenceSpecification_before_reference_toAfter_GeneralOrdering
  (from: UMLOccurrenceSpecification[Uml],
   to: Set[UMLGeneralOrdering[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_OccurrenceSpecification_after_reference_toBefore_GeneralOrdering
  (from: UMLOccurrenceSpecification[Uml],
   to: Set[UMLGeneralOrdering[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_OpaqueAction_opaqueAction_compose_inputValue_InputPin
  (from: UMLOpaqueAction[Uml],
   to: Set[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_OpaqueAction_opaqueAction_compose_outputValue_OutputPin
  (from: UMLOpaqueAction[Uml],
   to: Set[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_OpaqueExpression_opaqueExpression_reference_behavior_Behavior
  (from: UMLOpaqueExpression[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Operation_bodyContext_compose_bodyCondition_Constraint
  (from: UMLOperation[Uml],
   to: Option[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Operation_operation_compose_ownedParameter_Parameter
  (from: UMLOperation[Uml],
   to: Seq[UMLParameter[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Operation_postContext_compose_postcondition_Constraint
  (from: UMLOperation[Uml],
   to: Set[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Operation_preContext_compose_precondition_Constraint
  (from: UMLOperation[Uml],
   to: Set[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Operation_operation_reference_raisedException_Type
  (from: UMLOperation[Uml],
   to: Set[UMLType[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Operation_operation_reference_redefinedOperation_Operation
  (from: UMLOperation[Uml],
   to: Set[UMLOperation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Operation_parameteredElement_reference_templateParameter_OperationTemplateParameter
  (from: UMLOperation[Uml],
   to: Option[UMLOperationTemplateParameter[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_OperationTemplateParameter_templateParameter_reference_parameteredElement_Operation
  (from: UMLOperationTemplateParameter[Uml],
   to: Option[UMLOperation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Package_receivingPackage_compose_packageMerge_PackageMerge
  (from: UMLPackage[Uml],
   to: Set[UMLPackageMerge[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Package_owningPackage_compose_packagedElement_PackageableElement
  (from: UMLPackage[Uml],
   to: Set[UMLPackageableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Package_applyingPackage_compose_profileApplication_ProfileApplication
  (from: UMLPackage[Uml],
   to: Set[UMLProfileApplication[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_PackageImport_packageImport_reference_importedPackage_Package
  (from: UMLPackageImport[Uml],
   to: Option[UMLPackage[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_PackageMerge_packageMerge_reference_mergedPackage_Package
  (from: UMLPackageMerge[Uml],
   to: Option[UMLPackage[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Parameter_owningParameter_compose_defaultValue_ValueSpecification
  (from: UMLParameter[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Parameter_parameter_reference_parameterSet_ParameterSet
  (from: UMLParameter[Uml],
   to: Set[UMLParameterSet[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ParameterSet_parameterSet_compose_condition_Constraint
  (from: UMLParameterSet[Uml],
   to: Set[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ParameterSet_parameterSet_reference_parameter_Parameter
  (from: UMLParameterSet[Uml],
   to: Set[UMLParameter[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: Option[UMLTemplateParameter[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Port_port_reference_protocol_ProtocolStateMachine
  (from: UMLPort[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Port_port_reference_redefinedPort_Port
  (from: UMLPort[Uml],
   to: Set[UMLPort[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Profile_profile_compose_metaclassReference_ElementImport
  (from: UMLProfile[Uml],
   to: Set[UMLElementImport[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Profile_profile_compose_metamodelReference_PackageImport
  (from: UMLProfile[Uml],
   to: Set[UMLPackageImport[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ProfileApplication_profileApplication_reference_appliedProfile_Profile
  (from: UMLProfileApplication[Uml],
   to: Option[UMLProfile[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Property_memberEnd_reference_association_Association
  (from: UMLProperty[Uml],
   to: Option[UMLAssociation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Property_owningProperty_compose_defaultValue_ValueSpecification
  (from: UMLProperty[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Property_associationEnd_compose_qualifier_Property
  (from: UMLProperty[Uml],
   to: Seq[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Property_property_reference_redefinedProperty_Property
  (from: UMLProperty[Uml],
   to: Set[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Property_property_reference_subsettedProperty_Property
  (from: UMLProperty[Uml],
   to: Set[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ProtocolConformance_protocolConformance_reference_generalMachine_ProtocolStateMachine
  (from: UMLProtocolConformance[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ProtocolStateMachine_specificMachine_compose_conformance_ProtocolConformance
  (from: UMLProtocolStateMachine[Uml],
   to: Set[UMLProtocolConformance[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ProtocolTransition_owningTransition_compose_postCondition_Constraint
  (from: UMLProtocolTransition[Uml],
   to: Option[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ProtocolTransition_protocolTransition_compose_preCondition_Constraint
  (from: UMLProtocolTransition[Uml],
   to: Option[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_QualifierValue_qualifierValue_reference_qualifier_Property
  (from: UMLQualifierValue[Uml],
   to: Option[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_QualifierValue_qualifierValue_reference_value_InputPin
  (from: UMLQualifierValue[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_RaiseExceptionAction_raiseExceptionAction_compose_exception_InputPin
  (from: UMLRaiseExceptionAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadExtentAction_readExtentAction_reference_classifier_Classifier
  (from: UMLReadExtentAction[Uml],
   to: Option[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadExtentAction_readExtentAction_compose_result_OutputPin
  (from: UMLReadExtentAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_reference_classifier_Classifier
  (from: UMLReadIsClassifiedObjectAction[Uml],
   to: Option[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_object_InputPin
  (from: UMLReadIsClassifiedObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_result_OutputPin
  (from: UMLReadIsClassifiedObjectAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadLinkAction_readLinkAction_compose_result_OutputPin
  (from: UMLReadLinkAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadLinkObjectEndAction_readLinkObjectEndAction_reference_end_Property
  (from: UMLReadLinkObjectEndAction[Uml],
   to: Option[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_object_InputPin
  (from: UMLReadLinkObjectEndAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_result_OutputPin
  (from: UMLReadLinkObjectEndAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_object_InputPin
  (from: UMLReadLinkObjectEndQualifierAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_reference_qualifier_Property
  (from: UMLReadLinkObjectEndQualifierAction[Uml],
   to: Option[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_result_OutputPin
  (from: UMLReadLinkObjectEndQualifierAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadSelfAction_readSelfAction_compose_result_OutputPin
  (from: UMLReadSelfAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadStructuralFeatureAction_readStructuralFeatureAction_compose_result_OutputPin
  (from: UMLReadStructuralFeatureAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReadVariableAction_readVariableAction_compose_result_OutputPin
  (from: UMLReadVariableAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Reception_reception_reference_signal_Signal
  (from: UMLReception[Uml],
   to: Option[UMLSignal[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReclassifyObjectAction_reclassifyObjectAction_reference_newClassifier_Classifier
  (from: UMLReclassifyObjectAction[Uml],
   to: Set[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReclassifyObjectAction_reclassifyObjectAction_compose_object_InputPin
  (from: UMLReclassifyObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReclassifyObjectAction_reclassifyObjectAction_reference_oldClassifier_Classifier
  (from: UMLReclassifyObjectAction[Uml],
   to: Set[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_RedefinableTemplateSignature_redefinableTemplateSignature_reference_extendedSignature_RedefinableTemplateSignature
  (from: UMLRedefinableTemplateSignature[Uml],
   to: Set[UMLRedefinableTemplateSignature[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReduceAction_reduceAction_compose_collection_InputPin
  (from: UMLReduceAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReduceAction_reduceAction_reference_reducer_Behavior
  (from: UMLReduceAction[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReduceAction_reduceAction_compose_result_OutputPin
  (from: UMLReduceAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Region_region_reference_extendedRegion_Region
  (from: UMLRegion[Uml],
   to: Option[UMLRegion[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Region_container_compose_subvertex_Vertex
  (from: UMLRegion[Uml],
   to: Set[UMLVertex[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Region_container_compose_transition_Transition
  (from: UMLRegion[Uml],
   to: Set[UMLTransition[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_compose_removeAt_InputPin
  (from: UMLRemoveStructuralFeatureValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_RemoveVariableValueAction_removeVariableValueAction_compose_removeAt_InputPin
  (from: UMLRemoveVariableValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReplyAction_replyAction_reference_replyToCall_Trigger
  (from: UMLReplyAction[Uml],
   to: Option[UMLTrigger[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReplyAction_replyAction_compose_replyValue_InputPin
  (from: UMLReplyAction[Uml],
   to: Seq[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ReplyAction_replyAction_compose_returnInformation_InputPin
  (from: UMLReplyAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_SendObjectAction_sendObjectAction_compose_request_InputPin
  (from: UMLSendObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_SendObjectAction_sendObjectAction_compose_target_InputPin
  (from: UMLSendObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_SendSignalAction_sendSignalAction_reference_signal_Signal
  (from: UMLSendSignalAction[Uml],
   to: Option[UMLSignal[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_SendSignalAction_sendSignalAction_compose_target_InputPin
  (from: UMLSendSignalAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_SequenceNode_sequenceNode_compose_executableNode_ExecutableNode
  (from: UMLSequenceNode[Uml],
   to: Seq[UMLExecutableNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Signal_owningSignal_compose_ownedAttribute_Property
  (from: UMLSignal[Uml],
   to: Seq[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_SignalEvent_signalEvent_reference_signal_Signal
  (from: UMLSignalEvent[Uml],
   to: Option[UMLSignal[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Slot_slot_reference_definingFeature_StructuralFeature
  (from: UMLSlot[Uml],
   to: Option[UMLStructuralFeature[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Slot_owningSlot_compose_value_ValueSpecification
  (from: UMLSlot[Uml],
   to: Seq[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StartClassifierBehaviorAction_startClassifierBehaviorAction_compose_object_InputPin
  (from: UMLStartClassifierBehaviorAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StartObjectBehaviorAction_startObjectBehaviorAction_compose_object_InputPin
  (from: UMLStartObjectBehaviorAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_State_state_compose_connection_ConnectionPointReference
  (from: UMLState[Uml],
   to: Set[UMLConnectionPointReference[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_State_state_compose_connectionPoint_Pseudostate
  (from: UMLState[Uml],
   to: Set[UMLPseudostate[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_State_state_compose_deferrableTrigger_Trigger
  (from: UMLState[Uml],
   to: Set[UMLTrigger[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_State_state_compose_doActivity_Behavior
  (from: UMLState[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_State_state_compose_entry_Behavior
  (from: UMLState[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_State_state_compose_exit_Behavior
  (from: UMLState[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_State_state_reference_redefinedState_State
  (from: UMLState[Uml],
   to: Option[UMLState[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_State_state_compose_region_Region
  (from: UMLState[Uml],
   to: Set[UMLRegion[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_State_owningState_compose_stateInvariant_Constraint
  (from: UMLState[Uml],
   to: Option[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_State_submachineState_reference_submachine_StateMachine
  (from: UMLState[Uml],
   to: Option[UMLStateMachine[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StateInvariant_stateInvariant_reference_covered_Lifeline
  (from: UMLStateInvariant[Uml],
   to: Iterable[UMLLifeline[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StateInvariant_stateInvariant_compose_invariant_Constraint
  (from: UMLStateInvariant[Uml],
   to: Option[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StateMachine_stateMachine_compose_connectionPoint_Pseudostate
  (from: UMLStateMachine[Uml],
   to: Set[UMLPseudostate[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StateMachine_stateMachine_reference_extendedStateMachine_StateMachine
  (from: UMLStateMachine[Uml],
   to: Set[UMLStateMachine[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StateMachine_stateMachine_compose_region_Region
  (from: UMLStateMachine[Uml],
   to: Set[UMLRegion[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StateMachine_submachine_reference_submachineState_State
  (from: UMLStateMachine[Uml],
   to: Set[UMLState[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Stereotype_stereotype_compose_icon_Image
  (from: UMLStereotype[Uml],
   to: Set[UMLImage[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StringExpression_owningExpression_compose_subExpression_StringExpression
  (from: UMLStringExpression[Uml],
   to: Seq[UMLStringExpression[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StructuralFeatureAction_structuralFeatureAction_compose_object_InputPin
  (from: UMLStructuralFeatureAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StructuralFeatureAction_structuralFeatureAction_reference_structuralFeature_StructuralFeature
  (from: UMLStructuralFeatureAction[Uml],
   to: Option[UMLStructuralFeature[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLActivityEdge[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLActivityNode[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StructuredActivityNode_scope_compose_variable_Variable
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLVariable[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property
  (from: UMLStructuredClassifier[Uml],
   to: Seq[UMLProperty[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector
  (from: UMLStructuredClassifier[Uml],
   to: Set[UMLConnector[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Substitution_substitution_reference_contract_Classifier
  (from: UMLSubstitution[Uml],
   to: Option[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateBinding_templateBinding_compose_parameterSubstitution_TemplateParameterSubstitution
  (from: UMLTemplateBinding[Uml],
   to: Set[UMLTemplateParameterSubstitution[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateBinding_templateBinding_reference_signature_TemplateSignature
  (from: UMLTemplateBinding[Uml],
   to: Option[UMLTemplateSignature[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateParameter_templateParameter_reference_default_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateParameter_templateParameter_compose_ownedDefault_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateParameter_owningTemplateParameter_compose_ownedParameteredElement_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateParameter_templateParameter_reference_parameteredElement_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateParameterSubstitution_templateParameterSubstitution_reference_actual_ParameterableElement
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLParameterableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateParameterSubstitution_templateParameterSubstitution_reference_formal_TemplateParameter
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLTemplateParameter[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateParameterSubstitution_owningTemplateParameterSubstitution_compose_ownedActual_ParameterableElement
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLParameterableElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateSignature_signature_compose_ownedParameter_TemplateParameter
  (from: UMLTemplateSignature[Uml],
   to: Seq[UMLTemplateParameter[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateSignature_templateSignature_reference_parameter_TemplateParameter
  (from: UMLTemplateSignature[Uml],
   to: Seq[UMLTemplateParameter[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature
  (from: UMLTemplateableElement[Uml],
   to: Option[UMLTemplateSignature[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding
  (from: UMLTemplateableElement[Uml],
   to: Set[UMLTemplateBinding[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TestIdentityAction_testIdentityAction_compose_first_InputPin
  (from: UMLTestIdentityAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TestIdentityAction_testIdentityAction_compose_result_OutputPin
  (from: UMLTestIdentityAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TestIdentityAction_testIdentityAction_compose_second_InputPin
  (from: UMLTestIdentityAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TimeConstraint_timeConstraint_compose_specification_TimeInterval
  (from: UMLTimeConstraint[Uml],
   to: Option[UMLTimeInterval[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TimeEvent_timeEvent_compose_when_TimeExpression
  (from: UMLTimeEvent[Uml],
   to: Option[UMLTimeExpression[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TimeExpression_timeExpression_compose_expr_ValueSpecification
  (from: UMLTimeExpression[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TimeExpression_timeExpression_reference_observation_Observation
  (from: UMLTimeExpression[Uml],
   to: Set[UMLObservation[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TimeInterval_timeInterval_reference_max_TimeExpression
  (from: UMLTimeInterval[Uml],
   to: Option[UMLTimeExpression[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TimeInterval_timeInterval_reference_min_TimeExpression
  (from: UMLTimeInterval[Uml],
   to: Option[UMLTimeExpression[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TimeObservation_timeObservation_reference_event_NamedElement
  (from: UMLTimeObservation[Uml],
   to: Option[UMLNamedElement[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Transition_transition_compose_effect_Behavior
  (from: UMLTransition[Uml],
   to: Option[UMLBehavior[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Transition_transition_compose_guard_Constraint
  (from: UMLTransition[Uml],
   to: Option[UMLConstraint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Transition_transition_reference_redefinedTransition_Transition
  (from: UMLTransition[Uml],
   to: Option[UMLTransition[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Transition_outgoing_reference_source_Vertex
  (from: UMLTransition[Uml],
   to: Option[UMLVertex[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Transition_incoming_reference_target_Vertex
  (from: UMLTransition[Uml],
   to: Option[UMLVertex[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Transition_transition_compose_trigger_Trigger
  (from: UMLTransition[Uml],
   to: Set[UMLTrigger[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Trigger_trigger_reference_event_Event
  (from: UMLTrigger[Uml],
   to: Option[UMLEvent[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_Trigger_trigger_reference_port_Port
  (from: UMLTrigger[Uml],
   to: Set[UMLPort[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_TypedElement_typedElement_reference_type_Type
  (from: UMLTypedElement[Uml],
   to: Option[UMLType[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_UnmarshallAction_unmarshallAction_compose_object_InputPin
  (from: UMLUnmarshallAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_UnmarshallAction_unmarshallAction_compose_result_OutputPin
  (from: UMLUnmarshallAction[Uml],
   to: Seq[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_UnmarshallAction_unmarshallAction_reference_unmarshallType_Classifier
  (from: UMLUnmarshallAction[Uml],
   to: Option[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_UseCase_extension_compose_extend_Extend
  (from: UMLUseCase[Uml],
   to: Set[UMLExtend[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_UseCase_useCase_compose_extensionPoint_ExtensionPoint
  (from: UMLUseCase[Uml],
   to: Set[UMLExtensionPoint[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_UseCase_includingCase_compose_include_Include
  (from: UMLUseCase[Uml],
   to: Set[UMLInclude[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_UseCase_useCase_reference_subject_Classifier
  (from: UMLUseCase[Uml],
   to: Set[UMLClassifier[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ValuePin_valuePin_compose_value_ValueSpecification
  (from: UMLValuePin[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ValueSpecificationAction_valueSpecificationAction_compose_result_OutputPin
  (from: UMLValueSpecificationAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_ValueSpecificationAction_valueSpecificationAction_compose_value_ValueSpecification
  (from: UMLValueSpecificationAction[Uml],
   to: Option[UMLValueSpecification[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_VariableAction_variableAction_reference_variable_Variable
  (from: UMLVariableAction[Uml],
   to: Option[UMLVariable[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_result_OutputPin
  (from: UMLWriteStructuralFeatureAction[Uml],
   to: Option[UMLOutputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_value_InputPin
  (from: UMLWriteStructuralFeatureAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit

  def links_WriteVariableAction_writeVariableAction_compose_value_InputPin
  (from: UMLWriteVariableAction[Uml],
   to: Option[UMLInputPin[Uml]]): Set[java.lang.Throwable] \/ Unit


  val Abstraction_abstraction_mapping_OpaqueExpression = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Abstraction_abstraction_compose_mapping_OpaqueExpression _,
      ops.Abstraction_mapping)

  val AcceptCallAction_acceptCallAction_returnInformation_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_AcceptCallAction_acceptCallAction_compose_returnInformation_OutputPin _,
      ops.AcceptCallAction_returnInformation)

  val AcceptEventAction_acceptEventAction_result_OutputPin = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_AcceptEventAction_acceptEventAction_compose_result_OutputPin _,
      ops.AcceptEventAction_result)

  val AcceptEventAction_acceptEventAction_trigger_Trigger = 
    AssociationMetaPropertySetUpdateInfo(
      links_AcceptEventAction_acceptEventAction_compose_trigger_Trigger _,
      ops.AcceptEventAction_trigger)

  val Action_action_localPostcondition_Constraint = 
    AssociationMetaPropertySetUpdateInfo(
      links_Action_action_compose_localPostcondition_Constraint _,
      ops.Action_localPostcondition)

  val Action_action_localPrecondition_Constraint = 
    AssociationMetaPropertySetUpdateInfo(
      links_Action_action_compose_localPrecondition_Constraint _,
      ops.Action_localPrecondition)

  val ActionExecutionSpecification_actionExecutionSpecification_action_Action = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ActionExecutionSpecification_actionExecutionSpecification_reference_action_Action _,
      ops.ActionExecutionSpecification_action)

  val ActionInputPin_actionInputPin_fromAction_Action = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ActionInputPin_actionInputPin_compose_fromAction_Action _,
      ops.ActionInputPin_fromAction)

  val Activity_activity_edge_ActivityEdge = 
    AssociationMetaPropertySetUpdateInfo(
      links_Activity_activity_compose_edge_ActivityEdge _,
      ops.Activity_edge)

  val Activity_inActivity_group_ActivityGroup = 
    AssociationMetaPropertySetUpdateInfo(
      links_Activity_inActivity_compose_group_ActivityGroup _,
      ops.Activity_group)

  val Activity_activity_node_ActivityNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_Activity_activity_compose_node_ActivityNode _,
      ops.Activity_node)

  val Activity_activity_partition_ActivityPartition = 
    AssociationMetaPropertySetUpdateInfo(
      links_Activity_activity_reference_partition_ActivityPartition _,
      ops.Activity_partition)

  val Activity_activity_structuredNode_StructuredActivityNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_Activity_activity_compose_structuredNode_StructuredActivityNode _,
      ops.Activity_structuredNode)

  val Activity_activityScope_variable_Variable = 
    AssociationMetaPropertySetUpdateInfo(
      links_Activity_activityScope_compose_variable_Variable _,
      ops.Activity_variable)

  val ActivityEdge_activityEdge_guard_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ActivityEdge_activityEdge_compose_guard_ValueSpecification _,
      ops.ActivityEdge_guard)

  val ActivityEdge_edge_inPartition_ActivityPartition = 
    AssociationMetaPropertySetUpdateInfo(
      links_ActivityEdge_edge_reference_inPartition_ActivityPartition _,
      ops.ActivityEdge_inPartition)

  val ActivityEdge_interruptingEdge_interrupts_InterruptibleActivityRegion = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ActivityEdge_interruptingEdge_reference_interrupts_InterruptibleActivityRegion _,
      ops.ActivityEdge_interrupts)

  val ActivityEdge_activityEdge_redefinedEdge_ActivityEdge = 
    AssociationMetaPropertySetUpdateInfo(
      links_ActivityEdge_activityEdge_reference_redefinedEdge_ActivityEdge _,
      ops.ActivityEdge_redefinedEdge)

  val ActivityEdge_outgoing_source_ActivityNode = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ActivityEdge_outgoing_reference_source_ActivityNode _,
      ops.ActivityEdge_source)

  val ActivityEdge_incoming_target_ActivityNode = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ActivityEdge_incoming_reference_target_ActivityNode _,
      ops.ActivityEdge_target)

  val ActivityEdge_activityEdge_weight_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ActivityEdge_activityEdge_compose_weight_ValueSpecification _,
      ops.ActivityEdge_weight)

  val ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion = 
    AssociationMetaPropertySetUpdateInfo(
      links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
      ops.ActivityNode_inInterruptibleRegion)

  val ActivityNode_node_inPartition_ActivityPartition = 
    AssociationMetaPropertySetUpdateInfo(
      links_ActivityNode_node_reference_inPartition_ActivityPartition _,
      ops.ActivityNode_inPartition)

  val ActivityNode_target_incoming_ActivityEdge = 
    AssociationMetaPropertySetUpdateInfo(
      links_ActivityNode_target_reference_incoming_ActivityEdge _,
      ops.ActivityNode_incoming)

  val ActivityNode_source_outgoing_ActivityEdge = 
    AssociationMetaPropertySetUpdateInfo(
      links_ActivityNode_source_reference_outgoing_ActivityEdge _,
      ops.ActivityNode_outgoing)

  val ActivityNode_activityNode_redefinedNode_ActivityNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
      ops.ActivityNode_redefinedNode)

  val ActivityParameterNode_activityParameterNode_parameter_Parameter = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ActivityParameterNode_activityParameterNode_reference_parameter_Parameter _,
      ops.ActivityParameterNode_parameter)

  val ActivityPartition_inPartition_edge_ActivityEdge = 
    AssociationMetaPropertySetUpdateInfo(
      links_ActivityPartition_inPartition_reference_edge_ActivityEdge _,
      ops.ActivityPartition_edge)

  val ActivityPartition_inPartition_node_ActivityNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_ActivityPartition_inPartition_reference_node_ActivityNode _,
      ops.ActivityPartition_node)

  val ActivityPartition_activityPartition_represents_Element = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ActivityPartition_activityPartition_reference_represents_Element _,
      ops.ActivityPartition_represents)

  val ActivityPartition_superPartition_subpartition_ActivityPartition = 
    AssociationMetaPropertySetUpdateInfo(
      links_ActivityPartition_superPartition_compose_subpartition_ActivityPartition _,
      ops.ActivityPartition_subpartition)

  val AddStructuralFeatureValueAction_addStructuralFeatureValueAction_insertAt_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_AddStructuralFeatureValueAction_addStructuralFeatureValueAction_compose_insertAt_InputPin _,
      ops.AddStructuralFeatureValueAction_insertAt)

  val AddVariableValueAction_addVariableValueAction_insertAt_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_AddVariableValueAction_addVariableValueAction_compose_insertAt_InputPin _,
      ops.AddVariableValueAction_insertAt)

  val Artifact_artifact_manifestation_Manifestation = 
    AssociationMetaPropertySetUpdateInfo(
      links_Artifact_artifact_compose_manifestation_Manifestation _,
      ops.Artifact_manifestation)

  val Artifact_artifact_nestedArtifact_Artifact = 
    AssociationMetaPropertySetUpdateInfo(
      links_Artifact_artifact_compose_nestedArtifact_Artifact _,
      ops.Artifact_nestedArtifact)

  val Artifact_artifact_ownedAttribute_Property = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Artifact_artifact_compose_ownedAttribute_Property _,
      ops.Artifact_ownedAttribute)

  val Artifact_artifact_ownedOperation_Operation = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Artifact_artifact_compose_ownedOperation_Operation _,
      ops.Artifact_ownedOperation)

  val Association_association_memberEnd_Property = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Association_association_reference_memberEnd_Property _,
      ops.Association_memberEnd)

  val Association_association_navigableOwnedEnd_Property = 
    AssociationMetaPropertySetUpdateInfo(
      links_Association_association_reference_navigableOwnedEnd_Property _,
      ops.Association_navigableOwnedEnd)

  val Association_owningAssociation_ownedEnd_Property = 
    AssociationMetaPropertyIterableUpdateInfo(
      links_Association_owningAssociation_compose_ownedEnd_Property _,
      ops.Association_ownedEnd)

  val Behavior_behavior_ownedParameter_Parameter = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Behavior_behavior_compose_ownedParameter_Parameter _,
      ops.Behavior_ownedParameter)

  val Behavior_behavior_ownedParameterSet_ParameterSet = 
    AssociationMetaPropertySetUpdateInfo(
      links_Behavior_behavior_compose_ownedParameterSet_ParameterSet _,
      ops.Behavior_ownedParameterSet)

  val Behavior_behavior_postcondition_Constraint = 
    AssociationMetaPropertySetUpdateInfo(
      links_Behavior_behavior_compose_postcondition_Constraint _,
      ops.Behavior_postcondition)

  val Behavior_behavior_precondition_Constraint = 
    AssociationMetaPropertySetUpdateInfo(
      links_Behavior_behavior_compose_precondition_Constraint _,
      ops.Behavior_precondition)

  val Behavior_behavior_redefinedBehavior_Behavior = 
    AssociationMetaPropertySetUpdateInfo(
      links_Behavior_behavior_reference_redefinedBehavior_Behavior _,
      ops.Behavior_redefinedBehavior)

  val Behavior_method_specification_BehavioralFeature = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Behavior_method_reference_specification_BehavioralFeature _,
      ops.Behavior_specification)

  val BehaviorExecutionSpecification_behaviorExecutionSpecification_behavior_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_BehaviorExecutionSpecification_behaviorExecutionSpecification_reference_behavior_Behavior _,
      ops.BehaviorExecutionSpecification_behavior)

  val BehavioralFeature_specification_method_Behavior = 
    AssociationMetaPropertySetUpdateInfo(
      links_BehavioralFeature_specification_reference_method_Behavior _,
      ops.BehavioralFeature_method)

  val BehavioralFeature_ownerFormalParam_ownedParameter_Parameter = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_BehavioralFeature_ownerFormalParam_compose_ownedParameter_Parameter _,
      ops.BehavioralFeature_ownedParameter)

  val BehavioralFeature_behavioralFeature_ownedParameterSet_ParameterSet = 
    AssociationMetaPropertySetUpdateInfo(
      links_BehavioralFeature_behavioralFeature_compose_ownedParameterSet_ParameterSet _,
      ops.BehavioralFeature_ownedParameterSet)

  val BehavioralFeature_behavioralFeature_raisedException_Type = 
    AssociationMetaPropertySetUpdateInfo(
      links_BehavioralFeature_behavioralFeature_reference_raisedException_Type _,
      ops.BehavioralFeature_raisedException)

  val BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
      ops.BehavioredClassifier_classifierBehavior)

  val BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization = 
    AssociationMetaPropertySetUpdateInfo(
      links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
      ops.BehavioredClassifier_interfaceRealization)

  val BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior = 
    AssociationMetaPropertySetUpdateInfo(
      links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
      ops.BehavioredClassifier_ownedBehavior)

  val BroadcastSignalAction_broadcastSignalAction_signal_Signal = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_BroadcastSignalAction_broadcastSignalAction_reference_signal_Signal _,
      ops.BroadcastSignalAction_signal)

  val CallAction_callAction_result_OutputPin = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_CallAction_callAction_compose_result_OutputPin _,
      ops.CallAction_result)

  val CallBehaviorAction_callBehaviorAction_behavior_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_CallBehaviorAction_callBehaviorAction_reference_behavior_Behavior _,
      ops.CallBehaviorAction_behavior)

  val CallEvent_callEvent_operation_Operation = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_CallEvent_callEvent_reference_operation_Operation _,
      ops.CallEvent_operation)

  val CallOperationAction_callOperationAction_operation_Operation = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_CallOperationAction_callOperationAction_reference_operation_Operation _,
      ops.CallOperationAction_operation)

  val CallOperationAction_callOperationAction_target_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_CallOperationAction_callOperationAction_compose_target_InputPin _,
      ops.CallOperationAction_target)

  val ChangeEvent_changeEvent_changeExpression_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ChangeEvent_changeEvent_compose_changeExpression_ValueSpecification _,
      ops.ChangeEvent_changeExpression)

  val Class_nestingClass_nestedClassifier_Classifier = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Class_nestingClass_compose_nestedClassifier_Classifier _,
      ops.Class_nestedClassifier)

  val Class_class_ownedAttribute_Property = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Class_class_compose_ownedAttribute_Property _,
      ops.Class_ownedAttribute)

  val Class_class_ownedOperation_Operation = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Class_class_compose_ownedOperation_Operation _,
      ops.Class_ownedOperation)

  val Class_class_ownedReception_Reception = 
    AssociationMetaPropertySetUpdateInfo(
      links_Class_class_compose_ownedReception_Reception _,
      ops.Class_ownedReception)

  val Classifier_classifier_collaborationUse_CollaborationUse = 
    AssociationMetaPropertySetUpdateInfo(
      links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
      ops.Classifier_collaborationUse)

  val Classifier_specific_generalization_Generalization = 
    AssociationMetaPropertySetUpdateInfo(
      links_Classifier_specific_compose_generalization_Generalization _,
      ops.Classifier_generalization)

  val Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
      ops.Classifier_ownedTemplateSignature)

  val Classifier_classifier_ownedUseCase_UseCase = 
    AssociationMetaPropertySetUpdateInfo(
      links_Classifier_classifier_compose_ownedUseCase_UseCase _,
      ops.Classifier_ownedUseCase)

  val Classifier_powertype_powertypeExtent_GeneralizationSet = 
    AssociationMetaPropertySetUpdateInfo(
      links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
      ops.Classifier_powertypeExtent)

  val Classifier_classifier_redefinedClassifier_Classifier = 
    AssociationMetaPropertySetUpdateInfo(
      links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
      ops.Classifier_redefinedClassifier)

  val Classifier_classifier_representation_CollaborationUse = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Classifier_classifier_reference_representation_CollaborationUse _,
      ops.Classifier_representation)

  val Classifier_substitutingClassifier_substitution_Substitution = 
    AssociationMetaPropertySetUpdateInfo(
      links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
      ops.Classifier_substitution)

  val Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
      ops.Classifier_templateParameter)

  val Classifier_subject_useCase_UseCase = 
    AssociationMetaPropertySetUpdateInfo(
      links_Classifier_subject_reference_useCase_UseCase _,
      ops.Classifier_useCase)

  val ClassifierTemplateParameter_classifierTemplateParameter_constrainingClassifier_Classifier = 
    AssociationMetaPropertySetUpdateInfo(
      links_ClassifierTemplateParameter_classifierTemplateParameter_reference_constrainingClassifier_Classifier _,
      ops.ClassifierTemplateParameter_constrainingClassifier)

  val ClassifierTemplateParameter_templateParameter_parameteredElement_Classifier = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ClassifierTemplateParameter_templateParameter_reference_parameteredElement_Classifier _,
      ops.ClassifierTemplateParameter_parameteredElement)

  val Clause_clause_body_ExecutableNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_Clause_clause_reference_body_ExecutableNode _,
      ops.Clause_body)

  val Clause_clause_bodyOutput_OutputPin = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Clause_clause_reference_bodyOutput_OutputPin _,
      ops.Clause_bodyOutput)

  val Clause_clause_decider_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Clause_clause_reference_decider_OutputPin _,
      ops.Clause_decider)

  val Clause_successorClause_predecessorClause_Clause = 
    AssociationMetaPropertySetUpdateInfo(
      links_Clause_successorClause_reference_predecessorClause_Clause _,
      ops.Clause_predecessorClause)

  val Clause_predecessorClause_successorClause_Clause = 
    AssociationMetaPropertySetUpdateInfo(
      links_Clause_predecessorClause_reference_successorClause_Clause _,
      ops.Clause_successorClause)

  val Clause_clause_test_ExecutableNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_Clause_clause_reference_test_ExecutableNode _,
      ops.Clause_test)

  val ClearAssociationAction_clearAssociationAction_association_Association = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ClearAssociationAction_clearAssociationAction_reference_association_Association _,
      ops.ClearAssociationAction_association)

  val ClearAssociationAction_clearAssociationAction_object_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ClearAssociationAction_clearAssociationAction_compose_object_InputPin _,
      ops.ClearAssociationAction_object)

  val ClearStructuralFeatureAction_clearStructuralFeatureAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ClearStructuralFeatureAction_clearStructuralFeatureAction_compose_result_OutputPin _,
      ops.ClearStructuralFeatureAction_result)

  val Collaboration_collaboration_collaborationRole_ConnectableElement = 
    AssociationMetaPropertySetUpdateInfo(
      links_Collaboration_collaboration_reference_collaborationRole_ConnectableElement _,
      ops.Collaboration_collaborationRole)

  val CollaborationUse_collaborationUse_roleBinding_Dependency = 
    AssociationMetaPropertySetUpdateInfo(
      links_CollaborationUse_collaborationUse_compose_roleBinding_Dependency _,
      ops.CollaborationUse_roleBinding)

  val CollaborationUse_collaborationUse_type_Collaboration = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_CollaborationUse_collaborationUse_reference_type_Collaboration _,
      ops.CollaborationUse_type)

  val CombinedFragment_combinedFragment_cfragmentGate_Gate = 
    AssociationMetaPropertySetUpdateInfo(
      links_CombinedFragment_combinedFragment_compose_cfragmentGate_Gate _,
      ops.CombinedFragment_cfragmentGate)

  val CombinedFragment_combinedFragment_operand_InteractionOperand = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_CombinedFragment_combinedFragment_compose_operand_InteractionOperand _,
      ops.CombinedFragment_operand)

  val Comment_comment_annotatedElement_Element = 
    AssociationMetaPropertySetUpdateInfo(
      links_Comment_comment_reference_annotatedElement_Element _,
      ops.Comment_annotatedElement)

  val Component_component_packagedElement_PackageableElement = 
    AssociationMetaPropertySetUpdateInfo(
      links_Component_component_compose_packagedElement_PackageableElement _,
      ops.Component_packagedElement)

  val Component_abstraction_realization_ComponentRealization = 
    AssociationMetaPropertySetUpdateInfo(
      links_Component_abstraction_compose_realization_ComponentRealization _,
      ops.Component_realization)

  val ComponentRealization_componentRealization_realizingClassifier_Classifier = 
    AssociationMetaPropertySetUpdateInfo(
      links_ComponentRealization_componentRealization_reference_realizingClassifier_Classifier _,
      ops.ComponentRealization_realizingClassifier)

  val ConditionalNode_conditionalNode_clause_Clause = 
    AssociationMetaPropertySetUpdateInfo(
      links_ConditionalNode_conditionalNode_compose_clause_Clause _,
      ops.ConditionalNode_clause)

  val ConditionalNode_conditionalNode_result_OutputPin = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_ConditionalNode_conditionalNode_compose_result_OutputPin _,
      ops.ConditionalNode_result)

  val ConnectableElement_parameteredElement_templateParameter_ConnectableElementTemplateParameter = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter _,
      ops.ConnectableElement_templateParameter)

  val ConnectableElementTemplateParameter_templateParameter_parameteredElement_ConnectableElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ConnectableElementTemplateParameter_templateParameter_reference_parameteredElement_ConnectableElement _,
      ops.ConnectableElementTemplateParameter_parameteredElement)

  val ConnectionPointReference_connectionPointReference_entry_Pseudostate = 
    AssociationMetaPropertySetUpdateInfo(
      links_ConnectionPointReference_connectionPointReference_reference_entry_Pseudostate _,
      ops.ConnectionPointReference_entry)

  val ConnectionPointReference_connectionPointReference_exit_Pseudostate = 
    AssociationMetaPropertySetUpdateInfo(
      links_ConnectionPointReference_connectionPointReference_reference_exit_Pseudostate _,
      ops.ConnectionPointReference_exit)

  val Connector_connector_contract_Behavior = 
    AssociationMetaPropertySetUpdateInfo(
      links_Connector_connector_reference_contract_Behavior _,
      ops.Connector_contract)

  val Connector_connector_end_ConnectorEnd = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Connector_connector_compose_end_ConnectorEnd _,
      ops.Connector_end)

  val Connector_connector_redefinedConnector_Connector = 
    AssociationMetaPropertySetUpdateInfo(
      links_Connector_connector_reference_redefinedConnector_Connector _,
      ops.Connector_redefinedConnector)

  val Connector_connector_type_Association = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Connector_connector_reference_type_Association _,
      ops.Connector_type)

  val ConnectorEnd_connectorEnd_partWithPort_Property = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ConnectorEnd_connectorEnd_reference_partWithPort_Property _,
      ops.ConnectorEnd_partWithPort)

  val ConnectorEnd_end_role_ConnectableElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ConnectorEnd_end_reference_role_ConnectableElement _,
      ops.ConnectorEnd_role)

  val ConsiderIgnoreFragment_considerIgnoreFragment_message_NamedElement = 
    AssociationMetaPropertySetUpdateInfo(
      links_ConsiderIgnoreFragment_considerIgnoreFragment_reference_message_NamedElement _,
      ops.ConsiderIgnoreFragment_message)

  val Constraint_constraint_constrainedElement_Element = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Constraint_constraint_reference_constrainedElement_Element _,
      ops.Constraint_constrainedElement)

  val Constraint_owningConstraint_specification_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Constraint_owningConstraint_compose_specification_ValueSpecification _,
      ops.Constraint_specification)

  val CreateLinkAction_createLinkAction_endData_LinkEndCreationData = 
    AssociationMetaPropertyIterableUpdateInfo(
      links_CreateLinkAction_createLinkAction_compose_endData_LinkEndCreationData _,
      ops.CreateLinkAction_endData)

  val CreateLinkObjectAction_createLinkObjectAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_CreateLinkObjectAction_createLinkObjectAction_compose_result_OutputPin _,
      ops.CreateLinkObjectAction_result)

  val CreateObjectAction_createObjectAction_classifier_Classifier = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_CreateObjectAction_createObjectAction_reference_classifier_Classifier _,
      ops.CreateObjectAction_classifier)

  val CreateObjectAction_createObjectAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_CreateObjectAction_createObjectAction_compose_result_OutputPin _,
      ops.CreateObjectAction_result)

  val DataType_datatype_ownedAttribute_Property = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_DataType_datatype_compose_ownedAttribute_Property _,
      ops.DataType_ownedAttribute)

  val DataType_datatype_ownedOperation_Operation = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_DataType_datatype_compose_ownedOperation_Operation _,
      ops.DataType_ownedOperation)

  val DecisionNode_decisionNode_decisionInput_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_DecisionNode_decisionNode_reference_decisionInput_Behavior _,
      ops.DecisionNode_decisionInput)

  val DecisionNode_decisionNode_decisionInputFlow_ObjectFlow = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_DecisionNode_decisionNode_reference_decisionInputFlow_ObjectFlow _,
      ops.DecisionNode_decisionInputFlow)

  val Dependency_clientDependency_client_NamedElement = 
    AssociationMetaPropertySetUpdateInfo(
      links_Dependency_clientDependency_reference_client_NamedElement _,
      ops.Dependency_client)

  val Dependency_supplierDependency_supplier_NamedElement = 
    AssociationMetaPropertySetUpdateInfo(
      links_Dependency_supplierDependency_reference_supplier_NamedElement _,
      ops.Dependency_supplier)

  val Deployment_deployment_configuration_DeploymentSpecification = 
    AssociationMetaPropertySetUpdateInfo(
      links_Deployment_deployment_compose_configuration_DeploymentSpecification _,
      ops.Deployment_configuration)

  val Deployment_deploymentForArtifact_deployedArtifact_DeployedArtifact = 
    AssociationMetaPropertySetUpdateInfo(
      links_Deployment_deploymentForArtifact_reference_deployedArtifact_DeployedArtifact _,
      ops.Deployment_deployedArtifact)

  val DeploymentTarget_location_deployment_Deployment = 
    AssociationMetaPropertySetUpdateInfo(
      links_DeploymentTarget_location_compose_deployment_Deployment _,
      ops.DeploymentTarget_deployment)

  val DestroyLinkAction_destroyLinkAction_endData_LinkEndDestructionData = 
    AssociationMetaPropertyIterableUpdateInfo(
      links_DestroyLinkAction_destroyLinkAction_compose_endData_LinkEndDestructionData _,
      ops.DestroyLinkAction_endData)

  val DestroyObjectAction_destroyObjectAction_target_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_DestroyObjectAction_destroyObjectAction_compose_target_InputPin _,
      ops.DestroyObjectAction_target)

  val Diagram_diagram_context_Element = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Diagram_diagram_reference_context_Element _,
      ops.Diagram_context)

  val Duration_duration_expr_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Duration_duration_compose_expr_ValueSpecification _,
      ops.Duration_expr)

  val Duration_duration_observation_Observation = 
    AssociationMetaPropertySetUpdateInfo(
      links_Duration_duration_reference_observation_Observation _,
      ops.Duration_observation)

  val DurationConstraint_durationConstraint_specification_DurationInterval = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_DurationConstraint_durationConstraint_compose_specification_DurationInterval _,
      ops.DurationConstraint_specification)

  val DurationInterval_durationInterval_max_Duration = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_DurationInterval_durationInterval_reference_max_Duration _,
      ops.DurationInterval_max)

  val DurationInterval_durationInterval_min_Duration = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_DurationInterval_durationInterval_reference_min_Duration _,
      ops.DurationInterval_min)

  val DurationObservation_durationObservation_event_NamedElement = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_DurationObservation_durationObservation_reference_event_NamedElement _,
      ops.DurationObservation_event)

  val Element_owningElement_ownedComment_Comment = 
    AssociationMetaPropertySetUpdateInfo(
      links_Element_owningElement_compose_ownedComment_Comment _,
      ops.Element_ownedComment)

  val ElementImport_import_importedElement_PackageableElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ElementImport_import_reference_importedElement_PackageableElement _,
      ops.ElementImport_importedElement)

  val ElementValue_elementValue_element_Element = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ElementValue_elementValue_reference_element_Element _,
      ops.ElementValue_element)

  val Enumeration_enumeration_ownedLiteral_EnumerationLiteral = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Enumeration_enumeration_compose_ownedLiteral_EnumerationLiteral _,
      ops.Enumeration_ownedLiteral)

  val ExceptionHandler_exceptionHandler_exceptionInput_ObjectNode = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ExceptionHandler_exceptionHandler_reference_exceptionInput_ObjectNode _,
      ops.ExceptionHandler_exceptionInput)

  val ExceptionHandler_exceptionHandler_exceptionType_Classifier = 
    AssociationMetaPropertySetUpdateInfo(
      links_ExceptionHandler_exceptionHandler_reference_exceptionType_Classifier _,
      ops.ExceptionHandler_exceptionType)

  val ExceptionHandler_exceptionHandler_handlerBody_ExecutableNode = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ExceptionHandler_exceptionHandler_reference_handlerBody_ExecutableNode _,
      ops.ExceptionHandler_handlerBody)

  val ExecutableNode_protectedNode_handler_ExceptionHandler = 
    AssociationMetaPropertySetUpdateInfo(
      links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
      ops.ExecutableNode_handler)

  val ExecutionOccurrenceSpecification_executionOccurrenceSpecification_execution_ExecutionSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ExecutionOccurrenceSpecification_executionOccurrenceSpecification_reference_execution_ExecutionSpecification _,
      ops.ExecutionOccurrenceSpecification_execution)

  val ExecutionSpecification_executionSpecification_finish_OccurrenceSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ExecutionSpecification_executionSpecification_reference_finish_OccurrenceSpecification _,
      ops.ExecutionSpecification_finish)

  val ExecutionSpecification_executionSpecification_start_OccurrenceSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ExecutionSpecification_executionSpecification_reference_start_OccurrenceSpecification _,
      ops.ExecutionSpecification_start)

  val ExpansionNode_inputElement_regionAsInput_ExpansionRegion = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ExpansionNode_inputElement_reference_regionAsInput_ExpansionRegion _,
      ops.ExpansionNode_regionAsInput)

  val ExpansionNode_outputElement_regionAsOutput_ExpansionRegion = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ExpansionNode_outputElement_reference_regionAsOutput_ExpansionRegion _,
      ops.ExpansionNode_regionAsOutput)

  val ExpansionRegion_regionAsInput_inputElement_ExpansionNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_ExpansionRegion_regionAsInput_reference_inputElement_ExpansionNode _,
      ops.ExpansionRegion_inputElement)

  val ExpansionRegion_regionAsOutput_outputElement_ExpansionNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_ExpansionRegion_regionAsOutput_reference_outputElement_ExpansionNode _,
      ops.ExpansionRegion_outputElement)

  val Expression_expression_operand_ValueSpecification = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Expression_expression_compose_operand_ValueSpecification _,
      ops.Expression_operand)

  val Extend_extend_condition_Constraint = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Extend_extend_compose_condition_Constraint _,
      ops.Extend_condition)

  val Extend_extend_extendedCase_UseCase = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Extend_extend_reference_extendedCase_UseCase _,
      ops.Extend_extendedCase)

  val Extend_extension_extensionLocation_ExtensionPoint = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Extend_extension_reference_extensionLocation_ExtensionPoint _,
      ops.Extend_extensionLocation)

  val Extension_extension_ownedEnd_ExtensionEnd = 
    AssociationMetaPropertyIterableUpdateInfo(
      links_Extension_extension_compose_ownedEnd_ExtensionEnd _,
      ops.Extension_ownedEnd)

  val ExtensionEnd_extensionEnd_type_Stereotype = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ExtensionEnd_extensionEnd_reference_type_Stereotype _,
      ops.ExtensionEnd_type)

  val GeneralOrdering_toBefore_after_OccurrenceSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_GeneralOrdering_toBefore_reference_after_OccurrenceSpecification _,
      ops.GeneralOrdering_after)

  val GeneralOrdering_toAfter_before_OccurrenceSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_GeneralOrdering_toAfter_reference_before_OccurrenceSpecification _,
      ops.GeneralOrdering_before)

  val Generalization_generalization_general_Classifier = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Generalization_generalization_reference_general_Classifier _,
      ops.Generalization_general)

  val Generalization_generalization_generalizationSet_GeneralizationSet = 
    AssociationMetaPropertySetUpdateInfo(
      links_Generalization_generalization_reference_generalizationSet_GeneralizationSet _,
      ops.Generalization_generalizationSet)

  val GeneralizationSet_generalizationSet_generalization_Generalization = 
    AssociationMetaPropertySetUpdateInfo(
      links_GeneralizationSet_generalizationSet_reference_generalization_Generalization _,
      ops.GeneralizationSet_generalization)

  val GeneralizationSet_powertypeExtent_powertype_Classifier = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_GeneralizationSet_powertypeExtent_reference_powertype_Classifier _,
      ops.GeneralizationSet_powertype)

  val Include_include_addition_UseCase = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Include_include_reference_addition_UseCase _,
      ops.Include_addition)

  val InformationFlow_conveyingFlow_conveyed_Classifier = 
    AssociationMetaPropertySetUpdateInfo(
      links_InformationFlow_conveyingFlow_reference_conveyed_Classifier _,
      ops.InformationFlow_conveyed)

  val InformationFlow_informationFlow_informationSource_NamedElement = 
    AssociationMetaPropertySetUpdateInfo(
      links_InformationFlow_informationFlow_reference_informationSource_NamedElement _,
      ops.InformationFlow_informationSource)

  val InformationFlow_informationFlow_informationTarget_NamedElement = 
    AssociationMetaPropertySetUpdateInfo(
      links_InformationFlow_informationFlow_reference_informationTarget_NamedElement _,
      ops.InformationFlow_informationTarget)

  val InformationFlow_abstraction_realization_Relationship = 
    AssociationMetaPropertySetUpdateInfo(
      links_InformationFlow_abstraction_reference_realization_Relationship _,
      ops.InformationFlow_realization)

  val InformationFlow_informationFlow_realizingActivityEdge_ActivityEdge = 
    AssociationMetaPropertySetUpdateInfo(
      links_InformationFlow_informationFlow_reference_realizingActivityEdge_ActivityEdge _,
      ops.InformationFlow_realizingActivityEdge)

  val InformationFlow_informationFlow_realizingConnector_Connector = 
    AssociationMetaPropertySetUpdateInfo(
      links_InformationFlow_informationFlow_reference_realizingConnector_Connector _,
      ops.InformationFlow_realizingConnector)

  val InformationFlow_informationFlow_realizingMessage_Message = 
    AssociationMetaPropertySetUpdateInfo(
      links_InformationFlow_informationFlow_reference_realizingMessage_Message _,
      ops.InformationFlow_realizingMessage)

  val InformationItem_representation_represented_Classifier = 
    AssociationMetaPropertySetUpdateInfo(
      links_InformationItem_representation_reference_represented_Classifier _,
      ops.InformationItem_represented)

  val InstanceSpecification_instanceSpecification_classifier_Classifier = 
    AssociationMetaPropertyIterableUpdateInfo(
      links_InstanceSpecification_instanceSpecification_reference_classifier_Classifier _,
      ops.InstanceSpecification_classifier)

  val InstanceSpecification_owningInstance_slot_Slot = 
    AssociationMetaPropertySetUpdateInfo(
      links_InstanceSpecification_owningInstance_compose_slot_Slot _,
      ops.InstanceSpecification_slot)

  val InstanceSpecification_owningInstanceSpec_specification_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_InstanceSpecification_owningInstanceSpec_compose_specification_ValueSpecification _,
      ops.InstanceSpecification_specification)

  val InstanceValue_instanceValue_instance_InstanceSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_InstanceValue_instanceValue_reference_instance_InstanceSpecification _,
      ops.InstanceValue_instance)

  val Interaction_interaction_action_Action = 
    AssociationMetaPropertySetUpdateInfo(
      links_Interaction_interaction_compose_action_Action _,
      ops.Interaction_action)

  val Interaction_interaction_formalGate_Gate = 
    AssociationMetaPropertySetUpdateInfo(
      links_Interaction_interaction_compose_formalGate_Gate _,
      ops.Interaction_formalGate)

  val Interaction_enclosingInteraction_fragment_InteractionFragment = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Interaction_enclosingInteraction_compose_fragment_InteractionFragment _,
      ops.Interaction_fragment)

  val Interaction_interaction_lifeline_Lifeline = 
    AssociationMetaPropertySetUpdateInfo(
      links_Interaction_interaction_compose_lifeline_Lifeline _,
      ops.Interaction_lifeline)

  val Interaction_interaction_message_Message = 
    AssociationMetaPropertySetUpdateInfo(
      links_Interaction_interaction_compose_message_Message _,
      ops.Interaction_message)

  val InteractionConstraint_interactionConstraint_maxint_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_InteractionConstraint_interactionConstraint_compose_maxint_ValueSpecification _,
      ops.InteractionConstraint_maxint)

  val InteractionConstraint_interactionConstraint_minint_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_InteractionConstraint_interactionConstraint_compose_minint_ValueSpecification _,
      ops.InteractionConstraint_minint)

  val InteractionFragment_coveredBy_covered_Lifeline = 
    AssociationMetaPropertyIterableUpdateInfo(
      links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
      ops.InteractionFragment_covered)

  val InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering = 
    AssociationMetaPropertySetUpdateInfo(
      links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
      ops.InteractionFragment_generalOrdering)

  val InteractionOperand_enclosingOperand_fragment_InteractionFragment = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_InteractionOperand_enclosingOperand_compose_fragment_InteractionFragment _,
      ops.InteractionOperand_fragment)

  val InteractionOperand_interactionOperand_guard_InteractionConstraint = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_InteractionOperand_interactionOperand_compose_guard_InteractionConstraint _,
      ops.InteractionOperand_guard)

  val InteractionUse_interactionUse_actualGate_Gate = 
    AssociationMetaPropertySetUpdateInfo(
      links_InteractionUse_interactionUse_compose_actualGate_Gate _,
      ops.InteractionUse_actualGate)

  val InteractionUse_interactionUse_argument_ValueSpecification = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_InteractionUse_interactionUse_compose_argument_ValueSpecification _,
      ops.InteractionUse_argument)

  val InteractionUse_interactionUse_refersTo_Interaction = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_InteractionUse_interactionUse_reference_refersTo_Interaction _,
      ops.InteractionUse_refersTo)

  val InteractionUse_interactionUse_returnValue_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_InteractionUse_interactionUse_compose_returnValue_ValueSpecification _,
      ops.InteractionUse_returnValue)

  val InteractionUse_interactionUse_returnValueRecipient_Property = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_InteractionUse_interactionUse_reference_returnValueRecipient_Property _,
      ops.InteractionUse_returnValueRecipient)

  val Interface_interface_nestedClassifier_Classifier = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Interface_interface_compose_nestedClassifier_Classifier _,
      ops.Interface_nestedClassifier)

  val Interface_interface_ownedAttribute_Property = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Interface_interface_compose_ownedAttribute_Property _,
      ops.Interface_ownedAttribute)

  val Interface_interface_ownedOperation_Operation = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Interface_interface_compose_ownedOperation_Operation _,
      ops.Interface_ownedOperation)

  val Interface_interface_ownedReception_Reception = 
    AssociationMetaPropertySetUpdateInfo(
      links_Interface_interface_compose_ownedReception_Reception _,
      ops.Interface_ownedReception)

  val Interface_interface_protocol_ProtocolStateMachine = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Interface_interface_compose_protocol_ProtocolStateMachine _,
      ops.Interface_protocol)

  val Interface_interface_redefinedInterface_Interface = 
    AssociationMetaPropertySetUpdateInfo(
      links_Interface_interface_reference_redefinedInterface_Interface _,
      ops.Interface_redefinedInterface)

  val InterfaceRealization_interfaceRealization_contract_Interface = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_InterfaceRealization_interfaceRealization_reference_contract_Interface _,
      ops.InterfaceRealization_contract)

  val InterruptibleActivityRegion_interrupts_interruptingEdge_ActivityEdge = 
    AssociationMetaPropertySetUpdateInfo(
      links_InterruptibleActivityRegion_interrupts_reference_interruptingEdge_ActivityEdge _,
      ops.InterruptibleActivityRegion_interruptingEdge)

  val InterruptibleActivityRegion_inInterruptibleRegion_node_ActivityNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_InterruptibleActivityRegion_inInterruptibleRegion_reference_node_ActivityNode _,
      ops.InterruptibleActivityRegion_node)

  val Interval_interval_max_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Interval_interval_reference_max_ValueSpecification _,
      ops.Interval_max)

  val Interval_interval_min_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Interval_interval_reference_min_ValueSpecification _,
      ops.Interval_min)

  val IntervalConstraint_intervalConstraint_specification_Interval = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_IntervalConstraint_intervalConstraint_compose_specification_Interval _,
      ops.IntervalConstraint_specification)

  val InvocationAction_invocationAction_argument_InputPin = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_InvocationAction_invocationAction_compose_argument_InputPin _,
      ops.InvocationAction_argument)

  val InvocationAction_invocationAction_onPort_Port = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_InvocationAction_invocationAction_reference_onPort_Port _,
      ops.InvocationAction_onPort)

  val JoinNode_joinNode_joinSpec_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_JoinNode_joinNode_compose_joinSpec_ValueSpecification _,
      ops.JoinNode_joinSpec)

  val Lifeline_covered_coveredBy_InteractionFragment = 
    AssociationMetaPropertySetUpdateInfo(
      links_Lifeline_covered_reference_coveredBy_InteractionFragment _,
      ops.Lifeline_coveredBy)

  val Lifeline_lifeline_decomposedAs_PartDecomposition = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Lifeline_lifeline_reference_decomposedAs_PartDecomposition _,
      ops.Lifeline_decomposedAs)

  val Lifeline_lifeline_represents_ConnectableElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Lifeline_lifeline_reference_represents_ConnectableElement _,
      ops.Lifeline_represents)

  val Lifeline_lifeline_selector_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Lifeline_lifeline_compose_selector_ValueSpecification _,
      ops.Lifeline_selector)

  val LinkAction_linkAction_endData_LinkEndData = 
    AssociationMetaPropertyIterableUpdateInfo(
      links_LinkAction_linkAction_compose_endData_LinkEndData _,
      ops.LinkAction_endData)

  val LinkAction_linkAction_inputValue_InputPin = 
    AssociationMetaPropertySetUpdateInfo(
      links_LinkAction_linkAction_compose_inputValue_InputPin _,
      ops.LinkAction_inputValue)

  val LinkEndCreationData_linkEndCreationData_insertAt_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_LinkEndCreationData_linkEndCreationData_reference_insertAt_InputPin _,
      ops.LinkEndCreationData_insertAt)

  val LinkEndData_linkEndData_end_Property = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_LinkEndData_linkEndData_reference_end_Property _,
      ops.LinkEndData_end)

  val LinkEndData_linkEndData_qualifier_QualifierValue = 
    AssociationMetaPropertySetUpdateInfo(
      links_LinkEndData_linkEndData_compose_qualifier_QualifierValue _,
      ops.LinkEndData_qualifier)

  val LinkEndData_linkEndData_value_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_LinkEndData_linkEndData_reference_value_InputPin _,
      ops.LinkEndData_value)

  val LinkEndDestructionData_linkEndDestructionData_destroyAt_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_LinkEndDestructionData_linkEndDestructionData_reference_destroyAt_InputPin _,
      ops.LinkEndDestructionData_destroyAt)

  val LoopNode_loopNode_bodyOutput_OutputPin = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_LoopNode_loopNode_reference_bodyOutput_OutputPin _,
      ops.LoopNode_bodyOutput)

  val LoopNode_loopNode_bodyPart_ExecutableNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_LoopNode_loopNode_reference_bodyPart_ExecutableNode _,
      ops.LoopNode_bodyPart)

  val LoopNode_loopNode_decider_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_LoopNode_loopNode_reference_decider_OutputPin _,
      ops.LoopNode_decider)

  val LoopNode_loopNode_loopVariable_OutputPin = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_LoopNode_loopNode_compose_loopVariable_OutputPin _,
      ops.LoopNode_loopVariable)

  val LoopNode_loopNode_loopVariableInput_InputPin = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_LoopNode_loopNode_compose_loopVariableInput_InputPin _,
      ops.LoopNode_loopVariableInput)

  val LoopNode_loopNode_result_OutputPin = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_LoopNode_loopNode_compose_result_OutputPin _,
      ops.LoopNode_result)

  val LoopNode_loopNode_setupPart_ExecutableNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_LoopNode_loopNode_reference_setupPart_ExecutableNode _,
      ops.LoopNode_setupPart)

  val LoopNode_loopNode_test_ExecutableNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_LoopNode_loopNode_reference_test_ExecutableNode _,
      ops.LoopNode_test)

  val Manifestation_manifestation_utilizedElement_PackageableElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Manifestation_manifestation_reference_utilizedElement_PackageableElement _,
      ops.Manifestation_utilizedElement)

  val Message_message_argument_ValueSpecification = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Message_message_compose_argument_ValueSpecification _,
      ops.Message_argument)

  val Message_message_connector_Connector = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Message_message_reference_connector_Connector _,
      ops.Message_connector)

  val Message_endMessage_receiveEvent_MessageEnd = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Message_endMessage_reference_receiveEvent_MessageEnd _,
      ops.Message_receiveEvent)

  val Message_endMessage_sendEvent_MessageEnd = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Message_endMessage_reference_sendEvent_MessageEnd _,
      ops.Message_sendEvent)

  val Message_message_signature_NamedElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Message_message_reference_signature_NamedElement _,
      ops.Message_signature)

  val MessageEnd_messageEnd_message_Message = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_MessageEnd_messageEnd_reference_message_Message _,
      ops.MessageEnd_message)

  val MultiplicityElement_owningLower_lowerValue_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
      ops.MultiplicityElement_lowerValue)

  val MultiplicityElement_owningUpper_upperValue_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
      ops.MultiplicityElement_upperValue)

  val NamedElement_namedElement_nameExpression_StringExpression = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
      ops.NamedElement_nameExpression)

  val Namespace_importingNamespace_elementImport_ElementImport = 
    AssociationMetaPropertySetUpdateInfo(
      links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
      ops.Namespace_elementImport)

  val Namespace_diagramOwner_ownedDiagram_Diagram = 
    AssociationMetaPropertySetUpdateInfo(
      links_Namespace_diagramOwner_compose_ownedDiagram_Diagram _,
      ops.Namespace_ownedDiagram)

  val Namespace_context_ownedRule_Constraint = 
    AssociationMetaPropertySetUpdateInfo(
      links_Namespace_context_compose_ownedRule_Constraint _,
      ops.Namespace_ownedRule)

  val Namespace_importingNamespace_packageImport_PackageImport = 
    AssociationMetaPropertySetUpdateInfo(
      links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
      ops.Namespace_packageImport)

  val Node_node_nestedNode_Node = 
    AssociationMetaPropertySetUpdateInfo(
      links_Node_node_compose_nestedNode_Node _,
      ops.Node_nestedNode)

  val ObjectFlow_objectFlow_selection_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ObjectFlow_objectFlow_reference_selection_Behavior _,
      ops.ObjectFlow_selection)

  val ObjectFlow_objectFlow_transformation_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ObjectFlow_objectFlow_reference_transformation_Behavior _,
      ops.ObjectFlow_transformation)

  val ObjectNode_objectNode_inState_State = 
    AssociationMetaPropertySetUpdateInfo(
      links_ObjectNode_objectNode_reference_inState_State _,
      ops.ObjectNode_inState)

  val ObjectNode_objectNode_selection_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ObjectNode_objectNode_reference_selection_Behavior _,
      ops.ObjectNode_selection)

  val ObjectNode_objectNode_upperBound_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ObjectNode_objectNode_compose_upperBound_ValueSpecification _,
      ops.ObjectNode_upperBound)

  val OccurrenceSpecification_events_covered_Lifeline = 
    AssociationMetaPropertyIterableUpdateInfo(
      links_OccurrenceSpecification_events_reference_covered_Lifeline _,
      ops.OccurrenceSpecification_covered)

  val OccurrenceSpecification_before_toAfter_GeneralOrdering = 
    AssociationMetaPropertySetUpdateInfo(
      links_OccurrenceSpecification_before_reference_toAfter_GeneralOrdering _,
      ops.OccurrenceSpecification_toAfter)

  val OccurrenceSpecification_after_toBefore_GeneralOrdering = 
    AssociationMetaPropertySetUpdateInfo(
      links_OccurrenceSpecification_after_reference_toBefore_GeneralOrdering _,
      ops.OccurrenceSpecification_toBefore)

  val OpaqueAction_opaqueAction_inputValue_InputPin = 
    AssociationMetaPropertySetUpdateInfo(
      links_OpaqueAction_opaqueAction_compose_inputValue_InputPin _,
      ops.OpaqueAction_inputValue)

  val OpaqueAction_opaqueAction_outputValue_OutputPin = 
    AssociationMetaPropertySetUpdateInfo(
      links_OpaqueAction_opaqueAction_compose_outputValue_OutputPin _,
      ops.OpaqueAction_outputValue)

  val OpaqueExpression_opaqueExpression_behavior_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_OpaqueExpression_opaqueExpression_reference_behavior_Behavior _,
      ops.OpaqueExpression_behavior)

  val Operation_bodyContext_bodyCondition_Constraint = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Operation_bodyContext_compose_bodyCondition_Constraint _,
      ops.Operation_bodyCondition)

  val Operation_operation_ownedParameter_Parameter = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Operation_operation_compose_ownedParameter_Parameter _,
      ops.Operation_ownedParameter)

  val Operation_postContext_postcondition_Constraint = 
    AssociationMetaPropertySetUpdateInfo(
      links_Operation_postContext_compose_postcondition_Constraint _,
      ops.Operation_postcondition)

  val Operation_preContext_precondition_Constraint = 
    AssociationMetaPropertySetUpdateInfo(
      links_Operation_preContext_compose_precondition_Constraint _,
      ops.Operation_precondition)

  val Operation_operation_raisedException_Type = 
    AssociationMetaPropertySetUpdateInfo(
      links_Operation_operation_reference_raisedException_Type _,
      ops.Operation_raisedException)

  val Operation_operation_redefinedOperation_Operation = 
    AssociationMetaPropertySetUpdateInfo(
      links_Operation_operation_reference_redefinedOperation_Operation _,
      ops.Operation_redefinedOperation)

  val Operation_parameteredElement_templateParameter_OperationTemplateParameter = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Operation_parameteredElement_reference_templateParameter_OperationTemplateParameter _,
      ops.Operation_templateParameter)

  val OperationTemplateParameter_templateParameter_parameteredElement_Operation = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_OperationTemplateParameter_templateParameter_reference_parameteredElement_Operation _,
      ops.OperationTemplateParameter_parameteredElement)

  val Package_receivingPackage_packageMerge_PackageMerge = 
    AssociationMetaPropertySetUpdateInfo(
      links_Package_receivingPackage_compose_packageMerge_PackageMerge _,
      ops.Package_packageMerge)

  val Package_owningPackage_packagedElement_PackageableElement = 
    AssociationMetaPropertySetUpdateInfo(
      links_Package_owningPackage_compose_packagedElement_PackageableElement _,
      ops.Package_packagedElement)

  val Package_applyingPackage_profileApplication_ProfileApplication = 
    AssociationMetaPropertySetUpdateInfo(
      links_Package_applyingPackage_compose_profileApplication_ProfileApplication _,
      ops.Package_profileApplication)

  val PackageImport_packageImport_importedPackage_Package = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_PackageImport_packageImport_reference_importedPackage_Package _,
      ops.PackageImport_importedPackage)

  val PackageMerge_packageMerge_mergedPackage_Package = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_PackageMerge_packageMerge_reference_mergedPackage_Package _,
      ops.PackageMerge_mergedPackage)

  val Parameter_owningParameter_defaultValue_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Parameter_owningParameter_compose_defaultValue_ValueSpecification _,
      ops.Parameter_defaultValue)

  val Parameter_parameter_parameterSet_ParameterSet = 
    AssociationMetaPropertySetUpdateInfo(
      links_Parameter_parameter_reference_parameterSet_ParameterSet _,
      ops.Parameter_parameterSet)

  val ParameterSet_parameterSet_condition_Constraint = 
    AssociationMetaPropertySetUpdateInfo(
      links_ParameterSet_parameterSet_compose_condition_Constraint _,
      ops.ParameterSet_condition)

  val ParameterSet_parameterSet_parameter_Parameter = 
    AssociationMetaPropertySetUpdateInfo(
      links_ParameterSet_parameterSet_reference_parameter_Parameter _,
      ops.ParameterSet_parameter)

  val ParameterableElement_parameteredElement_templateParameter_TemplateParameter = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
      ops.ParameterableElement_templateParameter)

  val Port_port_protocol_ProtocolStateMachine = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Port_port_reference_protocol_ProtocolStateMachine _,
      ops.Port_protocol)

  val Port_port_redefinedPort_Port = 
    AssociationMetaPropertySetUpdateInfo(
      links_Port_port_reference_redefinedPort_Port _,
      ops.Port_redefinedPort)

  val Profile_profile_metaclassReference_ElementImport = 
    AssociationMetaPropertySetUpdateInfo(
      links_Profile_profile_compose_metaclassReference_ElementImport _,
      ops.Profile_metaclassReference)

  val Profile_profile_metamodelReference_PackageImport = 
    AssociationMetaPropertySetUpdateInfo(
      links_Profile_profile_compose_metamodelReference_PackageImport _,
      ops.Profile_metamodelReference)

  val ProfileApplication_profileApplication_appliedProfile_Profile = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ProfileApplication_profileApplication_reference_appliedProfile_Profile _,
      ops.ProfileApplication_appliedProfile)

  val Property_memberEnd_association_Association = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Property_memberEnd_reference_association_Association _,
      ops.Property_association)

  val Property_owningProperty_defaultValue_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Property_owningProperty_compose_defaultValue_ValueSpecification _,
      ops.Property_defaultValue)

  val Property_associationEnd_qualifier_Property = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Property_associationEnd_compose_qualifier_Property _,
      ops.Property_qualifier)

  val Property_property_redefinedProperty_Property = 
    AssociationMetaPropertySetUpdateInfo(
      links_Property_property_reference_redefinedProperty_Property _,
      ops.Property_redefinedProperty)

  val Property_property_subsettedProperty_Property = 
    AssociationMetaPropertySetUpdateInfo(
      links_Property_property_reference_subsettedProperty_Property _,
      ops.Property_subsettedProperty)

  val ProtocolConformance_protocolConformance_generalMachine_ProtocolStateMachine = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ProtocolConformance_protocolConformance_reference_generalMachine_ProtocolStateMachine _,
      ops.ProtocolConformance_generalMachine)

  val ProtocolStateMachine_specificMachine_conformance_ProtocolConformance = 
    AssociationMetaPropertySetUpdateInfo(
      links_ProtocolStateMachine_specificMachine_compose_conformance_ProtocolConformance _,
      ops.ProtocolStateMachine_conformance)

  val ProtocolTransition_owningTransition_postCondition_Constraint = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ProtocolTransition_owningTransition_compose_postCondition_Constraint _,
      ops.ProtocolTransition_postCondition)

  val ProtocolTransition_protocolTransition_preCondition_Constraint = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ProtocolTransition_protocolTransition_compose_preCondition_Constraint _,
      ops.ProtocolTransition_preCondition)

  val QualifierValue_qualifierValue_qualifier_Property = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_QualifierValue_qualifierValue_reference_qualifier_Property _,
      ops.QualifierValue_qualifier)

  val QualifierValue_qualifierValue_value_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_QualifierValue_qualifierValue_reference_value_InputPin _,
      ops.QualifierValue_value)

  val RaiseExceptionAction_raiseExceptionAction_exception_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_RaiseExceptionAction_raiseExceptionAction_compose_exception_InputPin _,
      ops.RaiseExceptionAction_exception)

  val ReadExtentAction_readExtentAction_classifier_Classifier = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadExtentAction_readExtentAction_reference_classifier_Classifier _,
      ops.ReadExtentAction_classifier)

  val ReadExtentAction_readExtentAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadExtentAction_readExtentAction_compose_result_OutputPin _,
      ops.ReadExtentAction_result)

  val ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_classifier_Classifier = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_reference_classifier_Classifier _,
      ops.ReadIsClassifiedObjectAction_classifier)

  val ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_object_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_object_InputPin _,
      ops.ReadIsClassifiedObjectAction_object)

  val ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_result_OutputPin _,
      ops.ReadIsClassifiedObjectAction_result)

  val ReadLinkAction_readLinkAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadLinkAction_readLinkAction_compose_result_OutputPin _,
      ops.ReadLinkAction_result)

  val ReadLinkObjectEndAction_readLinkObjectEndAction_end_Property = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadLinkObjectEndAction_readLinkObjectEndAction_reference_end_Property _,
      ops.ReadLinkObjectEndAction_end)

  val ReadLinkObjectEndAction_readLinkObjectEndAction_object_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_object_InputPin _,
      ops.ReadLinkObjectEndAction_object)

  val ReadLinkObjectEndAction_readLinkObjectEndAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_result_OutputPin _,
      ops.ReadLinkObjectEndAction_result)

  val ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_object_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_object_InputPin _,
      ops.ReadLinkObjectEndQualifierAction_object)

  val ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_qualifier_Property = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_reference_qualifier_Property _,
      ops.ReadLinkObjectEndQualifierAction_qualifier)

  val ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_result_OutputPin _,
      ops.ReadLinkObjectEndQualifierAction_result)

  val ReadSelfAction_readSelfAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadSelfAction_readSelfAction_compose_result_OutputPin _,
      ops.ReadSelfAction_result)

  val ReadStructuralFeatureAction_readStructuralFeatureAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadStructuralFeatureAction_readStructuralFeatureAction_compose_result_OutputPin _,
      ops.ReadStructuralFeatureAction_result)

  val ReadVariableAction_readVariableAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReadVariableAction_readVariableAction_compose_result_OutputPin _,
      ops.ReadVariableAction_result)

  val Reception_reception_signal_Signal = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Reception_reception_reference_signal_Signal _,
      ops.Reception_signal)

  val ReclassifyObjectAction_reclassifyObjectAction_newClassifier_Classifier = 
    AssociationMetaPropertySetUpdateInfo(
      links_ReclassifyObjectAction_reclassifyObjectAction_reference_newClassifier_Classifier _,
      ops.ReclassifyObjectAction_newClassifier)

  val ReclassifyObjectAction_reclassifyObjectAction_object_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReclassifyObjectAction_reclassifyObjectAction_compose_object_InputPin _,
      ops.ReclassifyObjectAction_object)

  val ReclassifyObjectAction_reclassifyObjectAction_oldClassifier_Classifier = 
    AssociationMetaPropertySetUpdateInfo(
      links_ReclassifyObjectAction_reclassifyObjectAction_reference_oldClassifier_Classifier _,
      ops.ReclassifyObjectAction_oldClassifier)

  val RedefinableTemplateSignature_redefinableTemplateSignature_extendedSignature_RedefinableTemplateSignature = 
    AssociationMetaPropertySetUpdateInfo(
      links_RedefinableTemplateSignature_redefinableTemplateSignature_reference_extendedSignature_RedefinableTemplateSignature _,
      ops.RedefinableTemplateSignature_extendedSignature)

  val ReduceAction_reduceAction_collection_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReduceAction_reduceAction_compose_collection_InputPin _,
      ops.ReduceAction_collection)

  val ReduceAction_reduceAction_reducer_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReduceAction_reduceAction_reference_reducer_Behavior _,
      ops.ReduceAction_reducer)

  val ReduceAction_reduceAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReduceAction_reduceAction_compose_result_OutputPin _,
      ops.ReduceAction_result)

  val Region_region_extendedRegion_Region = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Region_region_reference_extendedRegion_Region _,
      ops.Region_extendedRegion)

  val Region_container_subvertex_Vertex = 
    AssociationMetaPropertySetUpdateInfo(
      links_Region_container_compose_subvertex_Vertex _,
      ops.Region_subvertex)

  val Region_container_transition_Transition = 
    AssociationMetaPropertySetUpdateInfo(
      links_Region_container_compose_transition_Transition _,
      ops.Region_transition)

  val RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_removeAt_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_compose_removeAt_InputPin _,
      ops.RemoveStructuralFeatureValueAction_removeAt)

  val RemoveVariableValueAction_removeVariableValueAction_removeAt_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_RemoveVariableValueAction_removeVariableValueAction_compose_removeAt_InputPin _,
      ops.RemoveVariableValueAction_removeAt)

  val ReplyAction_replyAction_replyToCall_Trigger = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReplyAction_replyAction_reference_replyToCall_Trigger _,
      ops.ReplyAction_replyToCall)

  val ReplyAction_replyAction_replyValue_InputPin = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_ReplyAction_replyAction_compose_replyValue_InputPin _,
      ops.ReplyAction_replyValue)

  val ReplyAction_replyAction_returnInformation_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ReplyAction_replyAction_compose_returnInformation_InputPin _,
      ops.ReplyAction_returnInformation)

  val SendObjectAction_sendObjectAction_request_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_SendObjectAction_sendObjectAction_compose_request_InputPin _,
      ops.SendObjectAction_request)

  val SendObjectAction_sendObjectAction_target_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_SendObjectAction_sendObjectAction_compose_target_InputPin _,
      ops.SendObjectAction_target)

  val SendSignalAction_sendSignalAction_signal_Signal = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_SendSignalAction_sendSignalAction_reference_signal_Signal _,
      ops.SendSignalAction_signal)

  val SendSignalAction_sendSignalAction_target_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_SendSignalAction_sendSignalAction_compose_target_InputPin _,
      ops.SendSignalAction_target)

  val SequenceNode_sequenceNode_executableNode_ExecutableNode = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_SequenceNode_sequenceNode_compose_executableNode_ExecutableNode _,
      ops.SequenceNode_executableNode)

  val Signal_owningSignal_ownedAttribute_Property = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Signal_owningSignal_compose_ownedAttribute_Property _,
      ops.Signal_ownedAttribute)

  val SignalEvent_signalEvent_signal_Signal = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_SignalEvent_signalEvent_reference_signal_Signal _,
      ops.SignalEvent_signal)

  val Slot_slot_definingFeature_StructuralFeature = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Slot_slot_reference_definingFeature_StructuralFeature _,
      ops.Slot_definingFeature)

  val Slot_owningSlot_value_ValueSpecification = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_Slot_owningSlot_compose_value_ValueSpecification _,
      ops.Slot_value)

  val StartClassifierBehaviorAction_startClassifierBehaviorAction_object_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_StartClassifierBehaviorAction_startClassifierBehaviorAction_compose_object_InputPin _,
      ops.StartClassifierBehaviorAction_object)

  val StartObjectBehaviorAction_startObjectBehaviorAction_object_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_StartObjectBehaviorAction_startObjectBehaviorAction_compose_object_InputPin _,
      ops.StartObjectBehaviorAction_object)

  val State_state_connection_ConnectionPointReference = 
    AssociationMetaPropertySetUpdateInfo(
      links_State_state_compose_connection_ConnectionPointReference _,
      ops.State_connection)

  val State_state_connectionPoint_Pseudostate = 
    AssociationMetaPropertySetUpdateInfo(
      links_State_state_compose_connectionPoint_Pseudostate _,
      ops.State_connectionPoint)

  val State_state_deferrableTrigger_Trigger = 
    AssociationMetaPropertySetUpdateInfo(
      links_State_state_compose_deferrableTrigger_Trigger _,
      ops.State_deferrableTrigger)

  val State_state_doActivity_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_State_state_compose_doActivity_Behavior _,
      ops.State_doActivity)

  val State_state_entry_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_State_state_compose_entry_Behavior _,
      ops.State_entry)

  val State_state_exit_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_State_state_compose_exit_Behavior _,
      ops.State_exit)

  val State_state_redefinedState_State = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_State_state_reference_redefinedState_State _,
      ops.State_redefinedState)

  val State_state_region_Region = 
    AssociationMetaPropertySetUpdateInfo(
      links_State_state_compose_region_Region _,
      ops.State_region)

  val State_owningState_stateInvariant_Constraint = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_State_owningState_compose_stateInvariant_Constraint _,
      ops.State_stateInvariant)

  val State_submachineState_submachine_StateMachine = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_State_submachineState_reference_submachine_StateMachine _,
      ops.State_submachine)

  val StateInvariant_stateInvariant_covered_Lifeline = 
    AssociationMetaPropertyIterableUpdateInfo(
      links_StateInvariant_stateInvariant_reference_covered_Lifeline _,
      ops.StateInvariant_covered)

  val StateInvariant_stateInvariant_invariant_Constraint = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_StateInvariant_stateInvariant_compose_invariant_Constraint _,
      ops.StateInvariant_invariant)

  val StateMachine_stateMachine_connectionPoint_Pseudostate = 
    AssociationMetaPropertySetUpdateInfo(
      links_StateMachine_stateMachine_compose_connectionPoint_Pseudostate _,
      ops.StateMachine_connectionPoint)

  val StateMachine_stateMachine_extendedStateMachine_StateMachine = 
    AssociationMetaPropertySetUpdateInfo(
      links_StateMachine_stateMachine_reference_extendedStateMachine_StateMachine _,
      ops.StateMachine_extendedStateMachine)

  val StateMachine_stateMachine_region_Region = 
    AssociationMetaPropertySetUpdateInfo(
      links_StateMachine_stateMachine_compose_region_Region _,
      ops.StateMachine_region)

  val StateMachine_submachine_submachineState_State = 
    AssociationMetaPropertySetUpdateInfo(
      links_StateMachine_submachine_reference_submachineState_State _,
      ops.StateMachine_submachineState)

  val Stereotype_stereotype_icon_Image = 
    AssociationMetaPropertySetUpdateInfo(
      links_Stereotype_stereotype_compose_icon_Image _,
      ops.Stereotype_icon)

  val StringExpression_owningExpression_subExpression_StringExpression = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_StringExpression_owningExpression_compose_subExpression_StringExpression _,
      ops.StringExpression_subExpression)

  val StructuralFeatureAction_structuralFeatureAction_object_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_StructuralFeatureAction_structuralFeatureAction_compose_object_InputPin _,
      ops.StructuralFeatureAction_object)

  val StructuralFeatureAction_structuralFeatureAction_structuralFeature_StructuralFeature = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_StructuralFeatureAction_structuralFeatureAction_reference_structuralFeature_StructuralFeature _,
      ops.StructuralFeatureAction_structuralFeature)

  val StructuredActivityNode_inStructuredNode_edge_ActivityEdge = 
    AssociationMetaPropertySetUpdateInfo(
      links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge _,
      ops.StructuredActivityNode_edge)

  val StructuredActivityNode_inStructuredNode_node_ActivityNode = 
    AssociationMetaPropertySetUpdateInfo(
      links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode _,
      ops.StructuredActivityNode_node)

  val StructuredActivityNode_structuredActivityNode_structuredNodeInput_InputPin = 
    AssociationMetaPropertySetUpdateInfo(
      links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin _,
      ops.StructuredActivityNode_structuredNodeInput)

  val StructuredActivityNode_structuredActivityNode_structuredNodeOutput_OutputPin = 
    AssociationMetaPropertySetUpdateInfo(
      links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin _,
      ops.StructuredActivityNode_structuredNodeOutput)

  val StructuredActivityNode_scope_variable_Variable = 
    AssociationMetaPropertySetUpdateInfo(
      links_StructuredActivityNode_scope_compose_variable_Variable _,
      ops.StructuredActivityNode_variable)

  val StructuredClassifier_structuredClassifier_ownedAttribute_Property = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
      ops.StructuredClassifier_ownedAttribute)

  val StructuredClassifier_structuredClassifier_ownedConnector_Connector = 
    AssociationMetaPropertySetUpdateInfo(
      links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
      ops.StructuredClassifier_ownedConnector)

  val Substitution_substitution_contract_Classifier = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Substitution_substitution_reference_contract_Classifier _,
      ops.Substitution_contract)

  val TemplateBinding_templateBinding_parameterSubstitution_TemplateParameterSubstitution = 
    AssociationMetaPropertySetUpdateInfo(
      links_TemplateBinding_templateBinding_compose_parameterSubstitution_TemplateParameterSubstitution _,
      ops.TemplateBinding_parameterSubstitution)

  val TemplateBinding_templateBinding_signature_TemplateSignature = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TemplateBinding_templateBinding_reference_signature_TemplateSignature _,
      ops.TemplateBinding_signature)

  val TemplateParameter_templateParameter_default_ParameterableElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TemplateParameter_templateParameter_reference_default_ParameterableElement _,
      ops.TemplateParameter_default)

  val TemplateParameter_templateParameter_ownedDefault_ParameterableElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TemplateParameter_templateParameter_compose_ownedDefault_ParameterableElement _,
      ops.TemplateParameter_ownedDefault)

  val TemplateParameter_owningTemplateParameter_ownedParameteredElement_ParameterableElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TemplateParameter_owningTemplateParameter_compose_ownedParameteredElement_ParameterableElement _,
      ops.TemplateParameter_ownedParameteredElement)

  val TemplateParameter_templateParameter_parameteredElement_ParameterableElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TemplateParameter_templateParameter_reference_parameteredElement_ParameterableElement _,
      ops.TemplateParameter_parameteredElement)

  val TemplateParameterSubstitution_templateParameterSubstitution_actual_ParameterableElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TemplateParameterSubstitution_templateParameterSubstitution_reference_actual_ParameterableElement _,
      ops.TemplateParameterSubstitution_actual)

  val TemplateParameterSubstitution_templateParameterSubstitution_formal_TemplateParameter = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TemplateParameterSubstitution_templateParameterSubstitution_reference_formal_TemplateParameter _,
      ops.TemplateParameterSubstitution_formal)

  val TemplateParameterSubstitution_owningTemplateParameterSubstitution_ownedActual_ParameterableElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TemplateParameterSubstitution_owningTemplateParameterSubstitution_compose_ownedActual_ParameterableElement _,
      ops.TemplateParameterSubstitution_ownedActual)

  val TemplateSignature_signature_ownedParameter_TemplateParameter = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_TemplateSignature_signature_compose_ownedParameter_TemplateParameter _,
      ops.TemplateSignature_ownedParameter)

  val TemplateSignature_templateSignature_parameter_TemplateParameter = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_TemplateSignature_templateSignature_reference_parameter_TemplateParameter _,
      ops.TemplateSignature_parameter)

  val TemplateableElement_template_ownedTemplateSignature_TemplateSignature = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
      ops.TemplateableElement_ownedTemplateSignature)

  val TemplateableElement_boundElement_templateBinding_TemplateBinding = 
    AssociationMetaPropertySetUpdateInfo(
      links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
      ops.TemplateableElement_templateBinding)

  val TestIdentityAction_testIdentityAction_first_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TestIdentityAction_testIdentityAction_compose_first_InputPin _,
      ops.TestIdentityAction_first)

  val TestIdentityAction_testIdentityAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TestIdentityAction_testIdentityAction_compose_result_OutputPin _,
      ops.TestIdentityAction_result)

  val TestIdentityAction_testIdentityAction_second_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TestIdentityAction_testIdentityAction_compose_second_InputPin _,
      ops.TestIdentityAction_second)

  val TimeConstraint_timeConstraint_specification_TimeInterval = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TimeConstraint_timeConstraint_compose_specification_TimeInterval _,
      ops.TimeConstraint_specification)

  val TimeEvent_timeEvent_when_TimeExpression = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TimeEvent_timeEvent_compose_when_TimeExpression _,
      ops.TimeEvent_when)

  val TimeExpression_timeExpression_expr_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TimeExpression_timeExpression_compose_expr_ValueSpecification _,
      ops.TimeExpression_expr)

  val TimeExpression_timeExpression_observation_Observation = 
    AssociationMetaPropertySetUpdateInfo(
      links_TimeExpression_timeExpression_reference_observation_Observation _,
      ops.TimeExpression_observation)

  val TimeInterval_timeInterval_max_TimeExpression = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TimeInterval_timeInterval_reference_max_TimeExpression _,
      ops.TimeInterval_max)

  val TimeInterval_timeInterval_min_TimeExpression = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TimeInterval_timeInterval_reference_min_TimeExpression _,
      ops.TimeInterval_min)

  val TimeObservation_timeObservation_event_NamedElement = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TimeObservation_timeObservation_reference_event_NamedElement _,
      ops.TimeObservation_event)

  val Transition_transition_effect_Behavior = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Transition_transition_compose_effect_Behavior _,
      ops.Transition_effect)

  val Transition_transition_guard_Constraint = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Transition_transition_compose_guard_Constraint _,
      ops.Transition_guard)

  val Transition_transition_redefinedTransition_Transition = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Transition_transition_reference_redefinedTransition_Transition _,
      ops.Transition_redefinedTransition)

  val Transition_outgoing_source_Vertex = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Transition_outgoing_reference_source_Vertex _,
      ops.Transition_source)

  val Transition_incoming_target_Vertex = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Transition_incoming_reference_target_Vertex _,
      ops.Transition_target)

  val Transition_transition_trigger_Trigger = 
    AssociationMetaPropertySetUpdateInfo(
      links_Transition_transition_compose_trigger_Trigger _,
      ops.Transition_trigger)

  val Trigger_trigger_event_Event = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_Trigger_trigger_reference_event_Event _,
      ops.Trigger_event)

  val Trigger_trigger_port_Port = 
    AssociationMetaPropertySetUpdateInfo(
      links_Trigger_trigger_reference_port_Port _,
      ops.Trigger_port)

  val TypedElement_typedElement_type_Type = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_TypedElement_typedElement_reference_type_Type _,
      ops.TypedElement_type)

  val UnmarshallAction_unmarshallAction_object_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_UnmarshallAction_unmarshallAction_compose_object_InputPin _,
      ops.UnmarshallAction_object)

  val UnmarshallAction_unmarshallAction_result_OutputPin = 
    AssociationMetaPropertySequenceUpdateInfo(
      links_UnmarshallAction_unmarshallAction_compose_result_OutputPin _,
      ops.UnmarshallAction_result)

  val UnmarshallAction_unmarshallAction_unmarshallType_Classifier = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_UnmarshallAction_unmarshallAction_reference_unmarshallType_Classifier _,
      ops.UnmarshallAction_unmarshallType)

  val UseCase_extension_extend_Extend = 
    AssociationMetaPropertySetUpdateInfo(
      links_UseCase_extension_compose_extend_Extend _,
      ops.UseCase_extend)

  val UseCase_useCase_extensionPoint_ExtensionPoint = 
    AssociationMetaPropertySetUpdateInfo(
      links_UseCase_useCase_compose_extensionPoint_ExtensionPoint _,
      ops.UseCase_extensionPoint)

  val UseCase_includingCase_include_Include = 
    AssociationMetaPropertySetUpdateInfo(
      links_UseCase_includingCase_compose_include_Include _,
      ops.UseCase_include)

  val UseCase_useCase_subject_Classifier = 
    AssociationMetaPropertySetUpdateInfo(
      links_UseCase_useCase_reference_subject_Classifier _,
      ops.UseCase_subject)

  val ValuePin_valuePin_value_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ValuePin_valuePin_compose_value_ValueSpecification _,
      ops.ValuePin_value)

  val ValueSpecificationAction_valueSpecificationAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ValueSpecificationAction_valueSpecificationAction_compose_result_OutputPin _,
      ops.ValueSpecificationAction_result)

  val ValueSpecificationAction_valueSpecificationAction_value_ValueSpecification = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_ValueSpecificationAction_valueSpecificationAction_compose_value_ValueSpecification _,
      ops.ValueSpecificationAction_value)

  val VariableAction_variableAction_variable_Variable = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_VariableAction_variableAction_reference_variable_Variable _,
      ops.VariableAction_variable)

  val WriteStructuralFeatureAction_writeStructuralFeatureAction_result_OutputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_result_OutputPin _,
      ops.WriteStructuralFeatureAction_result)

  val WriteStructuralFeatureAction_writeStructuralFeatureAction_value_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_value_InputPin _,
      ops.WriteStructuralFeatureAction_value)

  val WriteVariableAction_writeVariableAction_value_InputPin = 
    AssociationMetaPropertyOptionUpdateInfo(
      links_WriteVariableAction_writeVariableAction_compose_value_InputPin _,
      ops.WriteVariableAction_value)


  def set_AcceptEventAction_isUnmarshall
  (e: UMLAcceptEventAction[Uml], isUnmarshall: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Action_isLocallyReentrant
  (e: UMLAction[Uml], isLocallyReentrant: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Activity_isReadOnly
  (e: UMLActivity[Uml], isReadOnly: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Activity_isSingleExecution
  (e: UMLActivity[Uml], isSingleExecution: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_ActivityPartition_isDimension
  (e: UMLActivityPartition[Uml], isDimension: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_ActivityPartition_isExternal
  (e: UMLActivityPartition[Uml], isExternal: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_AddStructuralFeatureValueAction_isReplaceAll
  (e: UMLAddStructuralFeatureValueAction[Uml], isReplaceAll: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_AddVariableValueAction_isReplaceAll
  (e: UMLAddVariableValueAction[Uml], isReplaceAll: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Artifact_fileName
  (e: UMLArtifact[Uml], fileName: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_Association_isDerived
  (e: UMLAssociation[Uml], isDerived: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Behavior_isReentrant
  (e: UMLBehavior[Uml], isReentrant: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_BehavioralFeature_concurrency
  (e: UMLBehavioralFeature[Uml], concurrency: Option[UMLCallConcurrencyKind.Value]): Set[java.lang.Throwable] \/ Unit

  def set_BehavioralFeature_isAbstract
  (e: UMLBehavioralFeature[Uml], isAbstract: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_CallAction_isSynchronous
  (e: UMLCallAction[Uml], isSynchronous: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Class_isAbstract
  (e: UMLClass[Uml], isAbstract: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Class_isActive
  (e: UMLClass[Uml], isActive: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Classifier_isAbstract
  (e: UMLClassifier[Uml], isAbstract: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Classifier_isFinalSpecialization
  (e: UMLClassifier[Uml], isFinalSpecialization: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_ClassifierTemplateParameter_allowSubstitutable
  (e: UMLClassifierTemplateParameter[Uml], allowSubstitutable: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_CombinedFragment_interactionOperator
  (e: UMLCombinedFragment[Uml], interactionOperator: Option[UMLInteractionOperatorKind.Value]): Set[java.lang.Throwable] \/ Unit

  def set_Comment_body
  (e: UMLComment[Uml], body: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_Component_isIndirectlyInstantiated
  (e: UMLComponent[Uml], isIndirectlyInstantiated: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_ConditionalNode_isAssured
  (e: UMLConditionalNode[Uml], isAssured: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_ConditionalNode_isDeterminate
  (e: UMLConditionalNode[Uml], isDeterminate: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Continuation_setting
  (e: UMLContinuation[Uml], setting: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_DeploymentSpecification_deploymentLocation
  (e: UMLDeploymentSpecification[Uml], deploymentLocation: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_DeploymentSpecification_executionLocation
  (e: UMLDeploymentSpecification[Uml], executionLocation: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_DestroyObjectAction_isDestroyLinks
  (e: UMLDestroyObjectAction[Uml], isDestroyLinks: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_DestroyObjectAction_isDestroyOwnedObjects
  (e: UMLDestroyObjectAction[Uml], isDestroyOwnedObjects: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_DurationConstraint_firstEvent
  (e: UMLDurationConstraint[Uml], firstEvent: Set[Boolean]): Set[java.lang.Throwable] \/ Unit

  def set_DurationObservation_firstEvent
  (e: UMLDurationObservation[Uml], firstEvent: Seq[Boolean]): Set[java.lang.Throwable] \/ Unit

  def set_ElementImport_alias
  (e: UMLElementImport[Uml], alias: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_ElementImport_visibility
  (e: UMLElementImport[Uml], visibility: Option[UMLVisibilityKind.Value]): Set[java.lang.Throwable] \/ Unit

  def set_ExpansionRegion_mode
  (e: UMLExpansionRegion[Uml], mode: Option[UMLExpansionKind.Value]): Set[java.lang.Throwable] \/ Unit

  def set_Expression_symbol
  (e: UMLExpression[Uml], symbol: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_Feature_isStatic
  (e: UMLFeature[Uml], isStatic: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Generalization_isSubstitutable
  (e: UMLGeneralization[Uml], isSubstitutable: Option[Boolean]): Set[java.lang.Throwable] \/ Unit

  def set_GeneralizationSet_isCovering
  (e: UMLGeneralizationSet[Uml], isCovering: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_GeneralizationSet_isDisjoint
  (e: UMLGeneralizationSet[Uml], isDisjoint: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Image_content
  (e: UMLImage[Uml], content: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_Image_format
  (e: UMLImage[Uml], format: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_Image_location
  (e: UMLImage[Uml], location: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_JoinNode_isCombineDuplicate
  (e: UMLJoinNode[Uml], isCombineDuplicate: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_LinkEndCreationData_isReplaceAll
  (e: UMLLinkEndCreationData[Uml], isReplaceAll: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_LinkEndDestructionData_isDestroyDuplicates
  (e: UMLLinkEndDestructionData[Uml], isDestroyDuplicates: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_LiteralBoolean_value
  (e: UMLLiteralBoolean[Uml], value: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_LiteralInteger_value
  (e: UMLLiteralInteger[Uml], value: Integer): Set[java.lang.Throwable] \/ Unit

  def set_LiteralReal_value
  (e: UMLLiteralReal[Uml], value: Double): Set[java.lang.Throwable] \/ Unit

  def set_LiteralString_value
  (e: UMLLiteralString[Uml], value: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_LiteralUnlimitedNatural_value
  (e: UMLLiteralUnlimitedNatural[Uml], value: String): Set[java.lang.Throwable] \/ Unit

  def set_LoopNode_isTestedFirst
  (e: UMLLoopNode[Uml], isTestedFirst: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Message_messageSort
  (e: UMLMessage[Uml], messageSort: Option[UMLMessageSort.Value]): Set[java.lang.Throwable] \/ Unit

  def set_Model_viewpoint
  (e: UMLModel[Uml], viewpoint: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_MultiplicityElement_isOrdered
  (e: UMLMultiplicityElement[Uml], isOrdered: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_MultiplicityElement_isUnique
  (e: UMLMultiplicityElement[Uml], isUnique: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_NamedElement_name
  (e: UMLNamedElement[Uml], name: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_NamedElement_visibility
  (e: UMLNamedElement[Uml], visibility: Option[UMLVisibilityKind.Value]): Set[java.lang.Throwable] \/ Unit

  def set_ObjectFlow_isMulticast
  (e: UMLObjectFlow[Uml], isMulticast: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_ObjectFlow_isMultireceive
  (e: UMLObjectFlow[Uml], isMultireceive: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_ObjectNode_isControlType
  (e: UMLObjectNode[Uml], isControlType: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_ObjectNode_ordering
  (e: UMLObjectNode[Uml], ordering: Option[UMLObjectNodeOrderingKind.Value]): Set[java.lang.Throwable] \/ Unit

  def set_OpaqueAction_body
  (e: UMLOpaqueAction[Uml], body: Seq[String]): Set[java.lang.Throwable] \/ Unit

  def set_OpaqueAction_language
  (e: UMLOpaqueAction[Uml], language: Seq[String]): Set[java.lang.Throwable] \/ Unit

  def set_OpaqueBehavior_body
  (e: UMLOpaqueBehavior[Uml], body: Seq[String]): Set[java.lang.Throwable] \/ Unit

  def set_OpaqueBehavior_language
  (e: UMLOpaqueBehavior[Uml], language: Seq[String]): Set[java.lang.Throwable] \/ Unit

  def set_OpaqueExpression_body
  (e: UMLOpaqueExpression[Uml], body: Seq[String]): Set[java.lang.Throwable] \/ Unit

  def set_OpaqueExpression_language
  (e: UMLOpaqueExpression[Uml], language: Seq[String]): Set[java.lang.Throwable] \/ Unit

  def set_Operation_isQuery
  (e: UMLOperation[Uml], isQuery: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Package_URI
  (e: UMLPackage[Uml], URI: Option[String]): Set[java.lang.Throwable] \/ Unit

  def set_PackageImport_visibility
  (e: UMLPackageImport[Uml], visibility: Option[UMLVisibilityKind.Value]): Set[java.lang.Throwable] \/ Unit

  def set_PackageableElement_visibility
  (e: UMLPackageableElement[Uml], visibility: Option[UMLVisibilityKind.Value]): Set[java.lang.Throwable] \/ Unit

  def set_Parameter_direction
  (e: UMLParameter[Uml], direction: Option[UMLParameterDirectionKind.Value]): Set[java.lang.Throwable] \/ Unit

  def set_Parameter_effect
  (e: UMLParameter[Uml], effect: Option[UMLParameterEffectKind.Value]): Set[java.lang.Throwable] \/ Unit

  def set_Parameter_isException
  (e: UMLParameter[Uml], isException: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Parameter_isStream
  (e: UMLParameter[Uml], isStream: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Pin_isControl
  (e: UMLPin[Uml], isControl: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Port_isBehavior
  (e: UMLPort[Uml], isBehavior: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Port_isConjugated
  (e: UMLPort[Uml], isConjugated: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Port_isService
  (e: UMLPort[Uml], isService: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_ProfileApplication_isStrict
  (e: UMLProfileApplication[Uml], isStrict: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Property_aggregation
  (e: UMLProperty[Uml], aggregation: Option[UMLAggregationKind.Value]): Set[java.lang.Throwable] \/ Unit

  def set_Property_isDerived
  (e: UMLProperty[Uml], isDerived: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Property_isDerivedUnion
  (e: UMLProperty[Uml], isDerivedUnion: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Property_isID
  (e: UMLProperty[Uml], isID: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Pseudostate_kind
  (e: UMLPseudostate[Uml], kind: Option[UMLPseudostateKind.Value]): Set[java.lang.Throwable] \/ Unit

  def set_ReadIsClassifiedObjectAction_isDirect
  (e: UMLReadIsClassifiedObjectAction[Uml], isDirect: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_ReclassifyObjectAction_isReplaceAll
  (e: UMLReclassifyObjectAction[Uml], isReplaceAll: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_RedefinableElement_isLeaf
  (e: UMLRedefinableElement[Uml], isLeaf: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_ReduceAction_isOrdered
  (e: UMLReduceAction[Uml], isOrdered: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_RemoveStructuralFeatureValueAction_isRemoveDuplicates
  (e: UMLRemoveStructuralFeatureValueAction[Uml], isRemoveDuplicates: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_RemoveVariableValueAction_isRemoveDuplicates
  (e: UMLRemoveVariableValueAction[Uml], isRemoveDuplicates: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_StructuralFeature_isReadOnly
  (e: UMLStructuralFeature[Uml], isReadOnly: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_StructuredActivityNode_mustIsolate
  (e: UMLStructuredActivityNode[Uml], mustIsolate: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_TimeConstraint_firstEvent
  (e: UMLTimeConstraint[Uml], firstEvent: Option[Boolean]): Set[java.lang.Throwable] \/ Unit

  def set_TimeEvent_isRelative
  (e: UMLTimeEvent[Uml], isRelative: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_TimeObservation_firstEvent
  (e: UMLTimeObservation[Uml], firstEvent: Boolean): Set[java.lang.Throwable] \/ Unit

  def set_Transition_kind
  (e: UMLTransition[Uml], kind: Option[UMLTransitionKind.Value]): Set[java.lang.Throwable] \/ Unit

  val AssociationMetaPropertyOption2LinksUpdate
  : Seq[AssociationMetaPropertyOptionUpdater]
  = Seq() :+
    Abstraction_abstraction_mapping_OpaqueExpression :+
    AcceptCallAction_acceptCallAction_returnInformation_OutputPin :+
    ActionExecutionSpecification_actionExecutionSpecification_action_Action :+
    ActionInputPin_actionInputPin_fromAction_Action :+
    ActivityEdge_activityEdge_guard_ValueSpecification :+
    ActivityEdge_interruptingEdge_interrupts_InterruptibleActivityRegion :+
    ActivityEdge_outgoing_source_ActivityNode :+
    ActivityEdge_incoming_target_ActivityNode :+
    ActivityEdge_activityEdge_weight_ValueSpecification :+
    ActivityParameterNode_activityParameterNode_parameter_Parameter :+
    ActivityPartition_activityPartition_represents_Element :+
    AddStructuralFeatureValueAction_addStructuralFeatureValueAction_insertAt_InputPin :+
    AddVariableValueAction_addVariableValueAction_insertAt_InputPin :+
    Behavior_method_specification_BehavioralFeature :+
    BehaviorExecutionSpecification_behaviorExecutionSpecification_behavior_Behavior :+
    BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior :+
    BroadcastSignalAction_broadcastSignalAction_signal_Signal :+
    CallBehaviorAction_callBehaviorAction_behavior_Behavior :+
    CallEvent_callEvent_operation_Operation :+
    CallOperationAction_callOperationAction_operation_Operation :+
    CallOperationAction_callOperationAction_target_InputPin :+
    ChangeEvent_changeEvent_changeExpression_ValueSpecification :+
    Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature :+
    Classifier_classifier_representation_CollaborationUse :+
    Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter :+
    ClassifierTemplateParameter_templateParameter_parameteredElement_Classifier :+
    Clause_clause_decider_OutputPin :+
    ClearAssociationAction_clearAssociationAction_association_Association :+
    ClearAssociationAction_clearAssociationAction_object_InputPin :+
    ClearStructuralFeatureAction_clearStructuralFeatureAction_result_OutputPin :+
    CollaborationUse_collaborationUse_type_Collaboration :+
    ConnectableElement_parameteredElement_templateParameter_ConnectableElementTemplateParameter :+
    ConnectableElementTemplateParameter_templateParameter_parameteredElement_ConnectableElement :+
    Connector_connector_type_Association :+
    ConnectorEnd_connectorEnd_partWithPort_Property :+
    ConnectorEnd_end_role_ConnectableElement :+
    Constraint_owningConstraint_specification_ValueSpecification :+
    CreateLinkObjectAction_createLinkObjectAction_result_OutputPin :+
    CreateObjectAction_createObjectAction_classifier_Classifier :+
    CreateObjectAction_createObjectAction_result_OutputPin :+
    DecisionNode_decisionNode_decisionInput_Behavior :+
    DecisionNode_decisionNode_decisionInputFlow_ObjectFlow :+
    DestroyObjectAction_destroyObjectAction_target_InputPin :+
    Diagram_diagram_context_Element :+
    Duration_duration_expr_ValueSpecification :+
    DurationConstraint_durationConstraint_specification_DurationInterval :+
    DurationInterval_durationInterval_max_Duration :+
    DurationInterval_durationInterval_min_Duration :+
    ElementImport_import_importedElement_PackageableElement :+
    ElementValue_elementValue_element_Element :+
    ExceptionHandler_exceptionHandler_exceptionInput_ObjectNode :+
    ExceptionHandler_exceptionHandler_handlerBody_ExecutableNode :+
    ExecutionOccurrenceSpecification_executionOccurrenceSpecification_execution_ExecutionSpecification :+
    ExecutionSpecification_executionSpecification_finish_OccurrenceSpecification :+
    ExecutionSpecification_executionSpecification_start_OccurrenceSpecification :+
    ExpansionNode_inputElement_regionAsInput_ExpansionRegion :+
    ExpansionNode_outputElement_regionAsOutput_ExpansionRegion :+
    Extend_extend_condition_Constraint :+
    Extend_extend_extendedCase_UseCase :+
    ExtensionEnd_extensionEnd_type_Stereotype :+
    GeneralOrdering_toBefore_after_OccurrenceSpecification :+
    GeneralOrdering_toAfter_before_OccurrenceSpecification :+
    Generalization_generalization_general_Classifier :+
    GeneralizationSet_powertypeExtent_powertype_Classifier :+
    Include_include_addition_UseCase :+
    InstanceSpecification_owningInstanceSpec_specification_ValueSpecification :+
    InstanceValue_instanceValue_instance_InstanceSpecification :+
    InteractionConstraint_interactionConstraint_maxint_ValueSpecification :+
    InteractionConstraint_interactionConstraint_minint_ValueSpecification :+
    InteractionOperand_interactionOperand_guard_InteractionConstraint :+
    InteractionUse_interactionUse_refersTo_Interaction :+
    InteractionUse_interactionUse_returnValue_ValueSpecification :+
    InteractionUse_interactionUse_returnValueRecipient_Property :+
    Interface_interface_protocol_ProtocolStateMachine :+
    InterfaceRealization_interfaceRealization_contract_Interface :+
    Interval_interval_max_ValueSpecification :+
    Interval_interval_min_ValueSpecification :+
    IntervalConstraint_intervalConstraint_specification_Interval :+
    InvocationAction_invocationAction_onPort_Port :+
    JoinNode_joinNode_joinSpec_ValueSpecification :+
    Lifeline_lifeline_decomposedAs_PartDecomposition :+
    Lifeline_lifeline_represents_ConnectableElement :+
    Lifeline_lifeline_selector_ValueSpecification :+
    LinkEndCreationData_linkEndCreationData_insertAt_InputPin :+
    LinkEndData_linkEndData_end_Property :+
    LinkEndData_linkEndData_value_InputPin :+
    LinkEndDestructionData_linkEndDestructionData_destroyAt_InputPin :+
    LoopNode_loopNode_decider_OutputPin :+
    Manifestation_manifestation_utilizedElement_PackageableElement :+
    Message_message_connector_Connector :+
    Message_endMessage_receiveEvent_MessageEnd :+
    Message_endMessage_sendEvent_MessageEnd :+
    Message_message_signature_NamedElement :+
    MessageEnd_messageEnd_message_Message :+
    MultiplicityElement_owningLower_lowerValue_ValueSpecification :+
    MultiplicityElement_owningUpper_upperValue_ValueSpecification :+
    NamedElement_namedElement_nameExpression_StringExpression :+
    ObjectFlow_objectFlow_selection_Behavior :+
    ObjectFlow_objectFlow_transformation_Behavior :+
    ObjectNode_objectNode_selection_Behavior :+
    ObjectNode_objectNode_upperBound_ValueSpecification :+
    OpaqueExpression_opaqueExpression_behavior_Behavior :+
    Operation_bodyContext_bodyCondition_Constraint :+
    Operation_parameteredElement_templateParameter_OperationTemplateParameter :+
    OperationTemplateParameter_templateParameter_parameteredElement_Operation :+
    PackageImport_packageImport_importedPackage_Package :+
    PackageMerge_packageMerge_mergedPackage_Package :+
    Parameter_owningParameter_defaultValue_ValueSpecification :+
    ParameterableElement_parameteredElement_templateParameter_TemplateParameter :+
    Port_port_protocol_ProtocolStateMachine :+
    ProfileApplication_profileApplication_appliedProfile_Profile :+
    Property_memberEnd_association_Association :+
    Property_owningProperty_defaultValue_ValueSpecification :+
    ProtocolConformance_protocolConformance_generalMachine_ProtocolStateMachine :+
    ProtocolTransition_owningTransition_postCondition_Constraint :+
    ProtocolTransition_protocolTransition_preCondition_Constraint :+
    QualifierValue_qualifierValue_qualifier_Property :+
    QualifierValue_qualifierValue_value_InputPin :+
    RaiseExceptionAction_raiseExceptionAction_exception_InputPin :+
    ReadExtentAction_readExtentAction_classifier_Classifier :+
    ReadExtentAction_readExtentAction_result_OutputPin :+
    ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_classifier_Classifier :+
    ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_object_InputPin :+
    ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_result_OutputPin :+
    ReadLinkAction_readLinkAction_result_OutputPin :+
    ReadLinkObjectEndAction_readLinkObjectEndAction_end_Property :+
    ReadLinkObjectEndAction_readLinkObjectEndAction_object_InputPin :+
    ReadLinkObjectEndAction_readLinkObjectEndAction_result_OutputPin :+
    ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_object_InputPin :+
    ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_qualifier_Property :+
    ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_result_OutputPin :+
    ReadSelfAction_readSelfAction_result_OutputPin :+
    ReadStructuralFeatureAction_readStructuralFeatureAction_result_OutputPin :+
    ReadVariableAction_readVariableAction_result_OutputPin :+
    Reception_reception_signal_Signal :+
    ReclassifyObjectAction_reclassifyObjectAction_object_InputPin :+
    ReduceAction_reduceAction_collection_InputPin :+
    ReduceAction_reduceAction_reducer_Behavior :+
    ReduceAction_reduceAction_result_OutputPin :+
    Region_region_extendedRegion_Region :+
    RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_removeAt_InputPin :+
    RemoveVariableValueAction_removeVariableValueAction_removeAt_InputPin :+
    ReplyAction_replyAction_replyToCall_Trigger :+
    ReplyAction_replyAction_returnInformation_InputPin :+
    SendObjectAction_sendObjectAction_request_InputPin :+
    SendObjectAction_sendObjectAction_target_InputPin :+
    SendSignalAction_sendSignalAction_signal_Signal :+
    SendSignalAction_sendSignalAction_target_InputPin :+
    SignalEvent_signalEvent_signal_Signal :+
    Slot_slot_definingFeature_StructuralFeature :+
    StartClassifierBehaviorAction_startClassifierBehaviorAction_object_InputPin :+
    StartObjectBehaviorAction_startObjectBehaviorAction_object_InputPin :+
    State_state_doActivity_Behavior :+
    State_state_entry_Behavior :+
    State_state_exit_Behavior :+
    State_state_redefinedState_State :+
    State_owningState_stateInvariant_Constraint :+
    State_submachineState_submachine_StateMachine :+
    StateInvariant_stateInvariant_invariant_Constraint :+
    StructuralFeatureAction_structuralFeatureAction_object_InputPin :+
    StructuralFeatureAction_structuralFeatureAction_structuralFeature_StructuralFeature :+
    Substitution_substitution_contract_Classifier :+
    TemplateBinding_templateBinding_signature_TemplateSignature :+
    TemplateParameter_templateParameter_default_ParameterableElement :+
    TemplateParameter_templateParameter_ownedDefault_ParameterableElement :+
    TemplateParameter_owningTemplateParameter_ownedParameteredElement_ParameterableElement :+
    TemplateParameter_templateParameter_parameteredElement_ParameterableElement :+
    TemplateParameterSubstitution_templateParameterSubstitution_actual_ParameterableElement :+
    TemplateParameterSubstitution_templateParameterSubstitution_formal_TemplateParameter :+
    TemplateParameterSubstitution_owningTemplateParameterSubstitution_ownedActual_ParameterableElement :+
    TemplateableElement_template_ownedTemplateSignature_TemplateSignature :+
    TestIdentityAction_testIdentityAction_first_InputPin :+
    TestIdentityAction_testIdentityAction_result_OutputPin :+
    TestIdentityAction_testIdentityAction_second_InputPin :+
    TimeConstraint_timeConstraint_specification_TimeInterval :+
    TimeEvent_timeEvent_when_TimeExpression :+
    TimeExpression_timeExpression_expr_ValueSpecification :+
    TimeInterval_timeInterval_max_TimeExpression :+
    TimeInterval_timeInterval_min_TimeExpression :+
    TimeObservation_timeObservation_event_NamedElement :+
    Transition_transition_effect_Behavior :+
    Transition_transition_guard_Constraint :+
    Transition_transition_redefinedTransition_Transition :+
    Transition_outgoing_source_Vertex :+
    Transition_incoming_target_Vertex :+
    Trigger_trigger_event_Event :+
    TypedElement_typedElement_type_Type :+
    UnmarshallAction_unmarshallAction_object_InputPin :+
    UnmarshallAction_unmarshallAction_unmarshallType_Classifier :+
    ValuePin_valuePin_value_ValueSpecification :+
    ValueSpecificationAction_valueSpecificationAction_result_OutputPin :+
    ValueSpecificationAction_valueSpecificationAction_value_ValueSpecification :+
    VariableAction_variableAction_variable_Variable :+
    WriteStructuralFeatureAction_writeStructuralFeatureAction_result_OutputPin :+
    WriteStructuralFeatureAction_writeStructuralFeatureAction_value_InputPin :+
    WriteVariableAction_writeVariableAction_value_InputPin
  val AssociationMetaPropertyIterable2LinksUpdate
  : Seq[AssociationMetaPropertyIterableUpdater]
  = Seq() :+
      Association_owningAssociation_ownedEnd_Property :+
      CreateLinkAction_createLinkAction_endData_LinkEndCreationData :+
      DestroyLinkAction_destroyLinkAction_endData_LinkEndDestructionData :+
      Extension_extension_ownedEnd_ExtensionEnd :+
      InstanceSpecification_instanceSpecification_classifier_Classifier :+
      InteractionFragment_coveredBy_covered_Lifeline :+
      LinkAction_linkAction_endData_LinkEndData :+
      OccurrenceSpecification_events_covered_Lifeline :+
      StateInvariant_stateInvariant_covered_Lifeline
  val AssociationMetaPropertySequence2LinksUpdate
  : Seq[AssociationMetaPropertySequenceUpdater]
  = Seq() :+
      AcceptEventAction_acceptEventAction_result_OutputPin :+
      Artifact_artifact_ownedAttribute_Property :+
      Artifact_artifact_ownedOperation_Operation :+
      Association_association_memberEnd_Property :+
      Behavior_behavior_ownedParameter_Parameter :+
      BehavioralFeature_ownerFormalParam_ownedParameter_Parameter :+
      CallAction_callAction_result_OutputPin :+
      Class_nestingClass_nestedClassifier_Classifier :+
      Class_class_ownedAttribute_Property :+
      Class_class_ownedOperation_Operation :+
      Clause_clause_bodyOutput_OutputPin :+
      CombinedFragment_combinedFragment_operand_InteractionOperand :+
      ConditionalNode_conditionalNode_result_OutputPin :+
      Connector_connector_end_ConnectorEnd :+
      Constraint_constraint_constrainedElement_Element :+
      DataType_datatype_ownedAttribute_Property :+
      DataType_datatype_ownedOperation_Operation :+
      DurationObservation_durationObservation_event_NamedElement :+
      Enumeration_enumeration_ownedLiteral_EnumerationLiteral :+
      Expression_expression_operand_ValueSpecification :+
      Extend_extension_extensionLocation_ExtensionPoint :+
      Interaction_enclosingInteraction_fragment_InteractionFragment :+
      InteractionOperand_enclosingOperand_fragment_InteractionFragment :+
      InteractionUse_interactionUse_argument_ValueSpecification :+
      Interface_interface_nestedClassifier_Classifier :+
      Interface_interface_ownedAttribute_Property :+
      Interface_interface_ownedOperation_Operation :+
      InvocationAction_invocationAction_argument_InputPin :+
      LoopNode_loopNode_bodyOutput_OutputPin :+
      LoopNode_loopNode_loopVariable_OutputPin :+
      LoopNode_loopNode_loopVariableInput_InputPin :+
      LoopNode_loopNode_result_OutputPin :+
      Message_message_argument_ValueSpecification :+
      Operation_operation_ownedParameter_Parameter :+
      Property_associationEnd_qualifier_Property :+
      ReplyAction_replyAction_replyValue_InputPin :+
      SequenceNode_sequenceNode_executableNode_ExecutableNode :+
      Signal_owningSignal_ownedAttribute_Property :+
      Slot_owningSlot_value_ValueSpecification :+
      StringExpression_owningExpression_subExpression_StringExpression :+
      StructuredClassifier_structuredClassifier_ownedAttribute_Property :+
      TemplateSignature_signature_ownedParameter_TemplateParameter :+
      TemplateSignature_templateSignature_parameter_TemplateParameter :+
      UnmarshallAction_unmarshallAction_result_OutputPin
  val AssociationMetaPropertySet2LinksUpdate
  : Seq[AssociationMetaPropertySetUpdater]
  = Seq() :+
      AcceptEventAction_acceptEventAction_trigger_Trigger :+
      Action_action_localPostcondition_Constraint :+
      Action_action_localPrecondition_Constraint :+
      Activity_activity_edge_ActivityEdge :+
      Activity_inActivity_group_ActivityGroup :+
      Activity_activity_node_ActivityNode :+
      Activity_activity_partition_ActivityPartition :+
      Activity_activity_structuredNode_StructuredActivityNode :+
      Activity_activityScope_variable_Variable :+
      ActivityEdge_edge_inPartition_ActivityPartition :+
      ActivityEdge_activityEdge_redefinedEdge_ActivityEdge :+
      ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion :+
      ActivityNode_node_inPartition_ActivityPartition :+
      ActivityNode_target_incoming_ActivityEdge :+
      ActivityNode_source_outgoing_ActivityEdge :+
      ActivityNode_activityNode_redefinedNode_ActivityNode :+
      ActivityPartition_inPartition_edge_ActivityEdge :+
      ActivityPartition_inPartition_node_ActivityNode :+
      ActivityPartition_superPartition_subpartition_ActivityPartition :+
      Artifact_artifact_manifestation_Manifestation :+
      Artifact_artifact_nestedArtifact_Artifact :+
      Association_association_navigableOwnedEnd_Property :+
      Behavior_behavior_ownedParameterSet_ParameterSet :+
      Behavior_behavior_postcondition_Constraint :+
      Behavior_behavior_precondition_Constraint :+
      Behavior_behavior_redefinedBehavior_Behavior :+
      BehavioralFeature_specification_method_Behavior :+
      BehavioralFeature_behavioralFeature_ownedParameterSet_ParameterSet :+
      BehavioralFeature_behavioralFeature_raisedException_Type :+
      BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization :+
      BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior :+
      Class_class_ownedReception_Reception :+
      Classifier_classifier_collaborationUse_CollaborationUse :+
      Classifier_specific_generalization_Generalization :+
      Classifier_classifier_ownedUseCase_UseCase :+
      Classifier_powertype_powertypeExtent_GeneralizationSet :+
      Classifier_classifier_redefinedClassifier_Classifier :+
      Classifier_substitutingClassifier_substitution_Substitution :+
      Classifier_subject_useCase_UseCase :+
      ClassifierTemplateParameter_classifierTemplateParameter_constrainingClassifier_Classifier :+
      Clause_clause_body_ExecutableNode :+
      Clause_successorClause_predecessorClause_Clause :+
      Clause_predecessorClause_successorClause_Clause :+
      Clause_clause_test_ExecutableNode :+
      Collaboration_collaboration_collaborationRole_ConnectableElement :+
      CollaborationUse_collaborationUse_roleBinding_Dependency :+
      CombinedFragment_combinedFragment_cfragmentGate_Gate :+
      Comment_comment_annotatedElement_Element :+
      Component_component_packagedElement_PackageableElement :+
      Component_abstraction_realization_ComponentRealization :+
      ComponentRealization_componentRealization_realizingClassifier_Classifier :+
      ConditionalNode_conditionalNode_clause_Clause :+
      ConnectionPointReference_connectionPointReference_entry_Pseudostate :+
      ConnectionPointReference_connectionPointReference_exit_Pseudostate :+
      Connector_connector_contract_Behavior :+
      Connector_connector_redefinedConnector_Connector :+
      ConsiderIgnoreFragment_considerIgnoreFragment_message_NamedElement :+
      Dependency_clientDependency_client_NamedElement :+
      Dependency_supplierDependency_supplier_NamedElement :+
      Deployment_deployment_configuration_DeploymentSpecification :+
      Deployment_deploymentForArtifact_deployedArtifact_DeployedArtifact :+
      DeploymentTarget_location_deployment_Deployment :+
      Duration_duration_observation_Observation :+
      Element_owningElement_ownedComment_Comment :+
      ExceptionHandler_exceptionHandler_exceptionType_Classifier :+
      ExecutableNode_protectedNode_handler_ExceptionHandler :+
      ExpansionRegion_regionAsInput_inputElement_ExpansionNode :+
      ExpansionRegion_regionAsOutput_outputElement_ExpansionNode :+
      Generalization_generalization_generalizationSet_GeneralizationSet :+
      GeneralizationSet_generalizationSet_generalization_Generalization :+
      InformationFlow_conveyingFlow_conveyed_Classifier :+
      InformationFlow_informationFlow_informationSource_NamedElement :+
      InformationFlow_informationFlow_informationTarget_NamedElement :+
      InformationFlow_abstraction_realization_Relationship :+
      InformationFlow_informationFlow_realizingActivityEdge_ActivityEdge :+
      InformationFlow_informationFlow_realizingConnector_Connector :+
      InformationFlow_informationFlow_realizingMessage_Message :+
      InformationItem_representation_represented_Classifier :+
      InstanceSpecification_owningInstance_slot_Slot :+
      Interaction_interaction_action_Action :+
      Interaction_interaction_formalGate_Gate :+
      Interaction_interaction_lifeline_Lifeline :+
      Interaction_interaction_message_Message :+
      InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering :+
      InteractionUse_interactionUse_actualGate_Gate :+
      Interface_interface_ownedReception_Reception :+
      Interface_interface_redefinedInterface_Interface :+
      InterruptibleActivityRegion_interrupts_interruptingEdge_ActivityEdge :+
      InterruptibleActivityRegion_inInterruptibleRegion_node_ActivityNode :+
      Lifeline_covered_coveredBy_InteractionFragment :+
      LinkAction_linkAction_inputValue_InputPin :+
      LinkEndData_linkEndData_qualifier_QualifierValue :+
      LoopNode_loopNode_bodyPart_ExecutableNode :+
      LoopNode_loopNode_setupPart_ExecutableNode :+
      LoopNode_loopNode_test_ExecutableNode :+
      Namespace_importingNamespace_elementImport_ElementImport :+
      Namespace_diagramOwner_ownedDiagram_Diagram :+
      Namespace_context_ownedRule_Constraint :+
      Namespace_importingNamespace_packageImport_PackageImport :+
      Node_node_nestedNode_Node :+
      ObjectNode_objectNode_inState_State :+
      OccurrenceSpecification_before_toAfter_GeneralOrdering :+
      OccurrenceSpecification_after_toBefore_GeneralOrdering :+
      OpaqueAction_opaqueAction_inputValue_InputPin :+
      OpaqueAction_opaqueAction_outputValue_OutputPin :+
      Operation_postContext_postcondition_Constraint :+
      Operation_preContext_precondition_Constraint :+
      Operation_operation_raisedException_Type :+
      Operation_operation_redefinedOperation_Operation :+
      Package_receivingPackage_packageMerge_PackageMerge :+
      Package_owningPackage_packagedElement_PackageableElement :+
      Package_applyingPackage_profileApplication_ProfileApplication :+
      Parameter_parameter_parameterSet_ParameterSet :+
      ParameterSet_parameterSet_condition_Constraint :+
      ParameterSet_parameterSet_parameter_Parameter :+
      Port_port_redefinedPort_Port :+
      Profile_profile_metaclassReference_ElementImport :+
      Profile_profile_metamodelReference_PackageImport :+
      Property_property_redefinedProperty_Property :+
      Property_property_subsettedProperty_Property :+
      ProtocolStateMachine_specificMachine_conformance_ProtocolConformance :+
      ReclassifyObjectAction_reclassifyObjectAction_newClassifier_Classifier :+
      ReclassifyObjectAction_reclassifyObjectAction_oldClassifier_Classifier :+
      RedefinableTemplateSignature_redefinableTemplateSignature_extendedSignature_RedefinableTemplateSignature :+
      Region_container_subvertex_Vertex :+
      Region_container_transition_Transition :+
      State_state_connection_ConnectionPointReference :+
      State_state_connectionPoint_Pseudostate :+
      State_state_deferrableTrigger_Trigger :+
      State_state_region_Region :+
      StateMachine_stateMachine_connectionPoint_Pseudostate :+
      StateMachine_stateMachine_extendedStateMachine_StateMachine :+
      StateMachine_stateMachine_region_Region :+
      StateMachine_submachine_submachineState_State :+
      Stereotype_stereotype_icon_Image :+
      StructuredActivityNode_inStructuredNode_edge_ActivityEdge :+
      StructuredActivityNode_inStructuredNode_node_ActivityNode :+
      StructuredActivityNode_structuredActivityNode_structuredNodeInput_InputPin :+
      StructuredActivityNode_structuredActivityNode_structuredNodeOutput_OutputPin :+
      StructuredActivityNode_scope_variable_Variable :+
      StructuredClassifier_structuredClassifier_ownedConnector_Connector :+
      TemplateBinding_templateBinding_parameterSubstitution_TemplateParameterSubstitution :+
      TemplateableElement_boundElement_templateBinding_TemplateBinding :+
      TimeExpression_timeExpression_observation_Observation :+
      Transition_transition_trigger_Trigger :+
      Trigger_trigger_port_Port :+
      UseCase_extension_extend_Extend :+
      UseCase_useCase_extensionPoint_ExtensionPoint :+
      UseCase_includingCase_include_Include :+
      UseCase_useCase_subject_Classifier
  import UMLAttributeUpdater._


  val AcceptEventAction_isUnmarshall =
      MetaScalarAttributeUpdater(
        set_AcceptEventAction_isUnmarshall _,
        ops.AcceptEventAction_isUnmarshall,
        BooleanValueConverter.convert)

  val Action_isLocallyReentrant =
      MetaScalarAttributeUpdater(
        set_Action_isLocallyReentrant _,
        ops.Action_isLocallyReentrant,
        BooleanValueConverter.convert)

  val Activity_isReadOnly =
      MetaScalarAttributeUpdater(
        set_Activity_isReadOnly _,
        ops.Activity_isReadOnly,
        BooleanValueConverter.convert)

  val Activity_isSingleExecution =
      MetaScalarAttributeUpdater(
        set_Activity_isSingleExecution _,
        ops.Activity_isSingleExecution,
        BooleanValueConverter.convert)

  val ActivityPartition_isDimension =
      MetaScalarAttributeUpdater(
        set_ActivityPartition_isDimension _,
        ops.ActivityPartition_isDimension,
        BooleanValueConverter.convert)

  val ActivityPartition_isExternal =
      MetaScalarAttributeUpdater(
        set_ActivityPartition_isExternal _,
        ops.ActivityPartition_isExternal,
        BooleanValueConverter.convert)

  val AddStructuralFeatureValueAction_isReplaceAll =
      MetaScalarAttributeUpdater(
        set_AddStructuralFeatureValueAction_isReplaceAll _,
        ops.AddStructuralFeatureValueAction_isReplaceAll,
        BooleanValueConverter.convert)

  val AddVariableValueAction_isReplaceAll =
      MetaScalarAttributeUpdater(
        set_AddVariableValueAction_isReplaceAll _,
        ops.AddVariableValueAction_isReplaceAll,
        BooleanValueConverter.convert)

  val Association_isDerived =
      MetaScalarAttributeUpdater(
        set_Association_isDerived _,
        ops.Association_isDerived,
        BooleanValueConverter.convert)

  val Behavior_isReentrant =
      MetaScalarAttributeUpdater(
        set_Behavior_isReentrant _,
        ops.Behavior_isReentrant,
        BooleanValueConverter.convert)

  val BehavioralFeature_isAbstract =
      MetaScalarAttributeUpdater(
        set_BehavioralFeature_isAbstract _,
        ops.BehavioralFeature_isAbstract,
        BooleanValueConverter.convert)

  val CallAction_isSynchronous =
      MetaScalarAttributeUpdater(
        set_CallAction_isSynchronous _,
        ops.CallAction_isSynchronous,
        BooleanValueConverter.convert)

  val Class_isAbstract =
      MetaScalarAttributeUpdater(
        set_Class_isAbstract _,
        ops.Class_isAbstract,
        BooleanValueConverter.convert)

  val Class_isActive =
      MetaScalarAttributeUpdater(
        set_Class_isActive _,
        ops.Class_isActive,
        BooleanValueConverter.convert)

  val Classifier_isAbstract =
      MetaScalarAttributeUpdater(
        set_Classifier_isAbstract _,
        ops.Classifier_isAbstract,
        BooleanValueConverter.convert)

  val Classifier_isFinalSpecialization =
      MetaScalarAttributeUpdater(
        set_Classifier_isFinalSpecialization _,
        ops.Classifier_isFinalSpecialization,
        BooleanValueConverter.convert)

  val ClassifierTemplateParameter_allowSubstitutable =
      MetaScalarAttributeUpdater(
        set_ClassifierTemplateParameter_allowSubstitutable _,
        ops.ClassifierTemplateParameter_allowSubstitutable,
        BooleanValueConverter.convert)

  val Component_isIndirectlyInstantiated =
      MetaScalarAttributeUpdater(
        set_Component_isIndirectlyInstantiated _,
        ops.Component_isIndirectlyInstantiated,
        BooleanValueConverter.convert)

  val ConditionalNode_isAssured =
      MetaScalarAttributeUpdater(
        set_ConditionalNode_isAssured _,
        ops.ConditionalNode_isAssured,
        BooleanValueConverter.convert)

  val ConditionalNode_isDeterminate =
      MetaScalarAttributeUpdater(
        set_ConditionalNode_isDeterminate _,
        ops.ConditionalNode_isDeterminate,
        BooleanValueConverter.convert)

  val Continuation_setting =
      MetaScalarAttributeUpdater(
        set_Continuation_setting _,
        ops.Continuation_setting,
        BooleanValueConverter.convert)

  val DestroyObjectAction_isDestroyLinks =
      MetaScalarAttributeUpdater(
        set_DestroyObjectAction_isDestroyLinks _,
        ops.DestroyObjectAction_isDestroyLinks,
        BooleanValueConverter.convert)

  val DestroyObjectAction_isDestroyOwnedObjects =
      MetaScalarAttributeUpdater(
        set_DestroyObjectAction_isDestroyOwnedObjects _,
        ops.DestroyObjectAction_isDestroyOwnedObjects,
        BooleanValueConverter.convert)

  val Feature_isStatic =
      MetaScalarAttributeUpdater(
        set_Feature_isStatic _,
        ops.Feature_isStatic,
        BooleanValueConverter.convert)

  val GeneralizationSet_isCovering =
      MetaScalarAttributeUpdater(
        set_GeneralizationSet_isCovering _,
        ops.GeneralizationSet_isCovering,
        BooleanValueConverter.convert)

  val GeneralizationSet_isDisjoint =
      MetaScalarAttributeUpdater(
        set_GeneralizationSet_isDisjoint _,
        ops.GeneralizationSet_isDisjoint,
        BooleanValueConverter.convert)

  val JoinNode_isCombineDuplicate =
      MetaScalarAttributeUpdater(
        set_JoinNode_isCombineDuplicate _,
        ops.JoinNode_isCombineDuplicate,
        BooleanValueConverter.convert)

  val LinkEndCreationData_isReplaceAll =
      MetaScalarAttributeUpdater(
        set_LinkEndCreationData_isReplaceAll _,
        ops.LinkEndCreationData_isReplaceAll,
        BooleanValueConverter.convert)

  val LinkEndDestructionData_isDestroyDuplicates =
      MetaScalarAttributeUpdater(
        set_LinkEndDestructionData_isDestroyDuplicates _,
        ops.LinkEndDestructionData_isDestroyDuplicates,
        BooleanValueConverter.convert)

  val LiteralBoolean_value =
      MetaScalarAttributeUpdater(
        set_LiteralBoolean_value _,
        ops.LiteralBoolean_value,
        BooleanValueConverter.convert)

  val LiteralInteger_value =
      MetaScalarAttributeUpdater(
        set_LiteralInteger_value _,
        ops.LiteralInteger_value,
        IntegerValueConverter.convert)

  val LiteralReal_value =
      MetaScalarAttributeUpdater(
        set_LiteralReal_value _,
        ops.LiteralReal_value,
        DoubleValueConverter.convert)

  val LiteralUnlimitedNatural_value =
      MetaScalarAttributeUpdater(
        set_LiteralUnlimitedNatural_value _,
        ops.LiteralUnlimitedNatural_value,
        StringValueConverter.convert)

  val LoopNode_isTestedFirst =
      MetaScalarAttributeUpdater(
        set_LoopNode_isTestedFirst _,
        ops.LoopNode_isTestedFirst,
        BooleanValueConverter.convert)

  val MultiplicityElement_isOrdered =
      MetaScalarAttributeUpdater(
        set_MultiplicityElement_isOrdered _,
        ops.MultiplicityElement_isOrdered,
        BooleanValueConverter.convert)

  val MultiplicityElement_isUnique =
      MetaScalarAttributeUpdater(
        set_MultiplicityElement_isUnique _,
        ops.MultiplicityElement_isUnique,
        BooleanValueConverter.convert)

  val ObjectFlow_isMulticast =
      MetaScalarAttributeUpdater(
        set_ObjectFlow_isMulticast _,
        ops.ObjectFlow_isMulticast,
        BooleanValueConverter.convert)

  val ObjectFlow_isMultireceive =
      MetaScalarAttributeUpdater(
        set_ObjectFlow_isMultireceive _,
        ops.ObjectFlow_isMultireceive,
        BooleanValueConverter.convert)

  val ObjectNode_isControlType =
      MetaScalarAttributeUpdater(
        set_ObjectNode_isControlType _,
        ops.ObjectNode_isControlType,
        BooleanValueConverter.convert)

  val Operation_isQuery =
      MetaScalarAttributeUpdater(
        set_Operation_isQuery _,
        ops.Operation_isQuery,
        BooleanValueConverter.convert)

  val Parameter_isException =
      MetaScalarAttributeUpdater(
        set_Parameter_isException _,
        ops.Parameter_isException,
        BooleanValueConverter.convert)

  val Parameter_isStream =
      MetaScalarAttributeUpdater(
        set_Parameter_isStream _,
        ops.Parameter_isStream,
        BooleanValueConverter.convert)

  val Pin_isControl =
      MetaScalarAttributeUpdater(
        set_Pin_isControl _,
        ops.Pin_isControl,
        BooleanValueConverter.convert)

  val Port_isBehavior =
      MetaScalarAttributeUpdater(
        set_Port_isBehavior _,
        ops.Port_isBehavior,
        BooleanValueConverter.convert)

  val Port_isConjugated =
      MetaScalarAttributeUpdater(
        set_Port_isConjugated _,
        ops.Port_isConjugated,
        BooleanValueConverter.convert)

  val Port_isService =
      MetaScalarAttributeUpdater(
        set_Port_isService _,
        ops.Port_isService,
        BooleanValueConverter.convert)

  val ProfileApplication_isStrict =
      MetaScalarAttributeUpdater(
        set_ProfileApplication_isStrict _,
        ops.ProfileApplication_isStrict,
        BooleanValueConverter.convert)

  val Property_isDerived =
      MetaScalarAttributeUpdater(
        set_Property_isDerived _,
        ops.Property_isDerived,
        BooleanValueConverter.convert)

  val Property_isDerivedUnion =
      MetaScalarAttributeUpdater(
        set_Property_isDerivedUnion _,
        ops.Property_isDerivedUnion,
        BooleanValueConverter.convert)

  val Property_isID =
      MetaScalarAttributeUpdater(
        set_Property_isID _,
        ops.Property_isID,
        BooleanValueConverter.convert)

  val ReadIsClassifiedObjectAction_isDirect =
      MetaScalarAttributeUpdater(
        set_ReadIsClassifiedObjectAction_isDirect _,
        ops.ReadIsClassifiedObjectAction_isDirect,
        BooleanValueConverter.convert)

  val ReclassifyObjectAction_isReplaceAll =
      MetaScalarAttributeUpdater(
        set_ReclassifyObjectAction_isReplaceAll _,
        ops.ReclassifyObjectAction_isReplaceAll,
        BooleanValueConverter.convert)

  val RedefinableElement_isLeaf =
      MetaScalarAttributeUpdater(
        set_RedefinableElement_isLeaf _,
        ops.RedefinableElement_isLeaf,
        BooleanValueConverter.convert)

  val ReduceAction_isOrdered =
      MetaScalarAttributeUpdater(
        set_ReduceAction_isOrdered _,
        ops.ReduceAction_isOrdered,
        BooleanValueConverter.convert)

  val RemoveStructuralFeatureValueAction_isRemoveDuplicates =
      MetaScalarAttributeUpdater(
        set_RemoveStructuralFeatureValueAction_isRemoveDuplicates _,
        ops.RemoveStructuralFeatureValueAction_isRemoveDuplicates,
        BooleanValueConverter.convert)

  val RemoveVariableValueAction_isRemoveDuplicates =
      MetaScalarAttributeUpdater(
        set_RemoveVariableValueAction_isRemoveDuplicates _,
        ops.RemoveVariableValueAction_isRemoveDuplicates,
        BooleanValueConverter.convert)

  val StructuralFeature_isReadOnly =
      MetaScalarAttributeUpdater(
        set_StructuralFeature_isReadOnly _,
        ops.StructuralFeature_isReadOnly,
        BooleanValueConverter.convert)

  val StructuredActivityNode_mustIsolate =
      MetaScalarAttributeUpdater(
        set_StructuredActivityNode_mustIsolate _,
        ops.StructuredActivityNode_mustIsolate,
        BooleanValueConverter.convert)

  val TimeEvent_isRelative =
      MetaScalarAttributeUpdater(
        set_TimeEvent_isRelative _,
        ops.TimeEvent_isRelative,
        BooleanValueConverter.convert)

  val TimeObservation_firstEvent =
      MetaScalarAttributeUpdater(
        set_TimeObservation_firstEvent _,
        ops.TimeObservation_firstEvent,
        BooleanValueConverter.convert)

  val MetaPropertyScalarAttributeUpdate
  : Seq[MetaScalarAttributeUpdate]
  = Seq() :+
      AcceptEventAction_isUnmarshall :+
      Action_isLocallyReentrant :+
      Activity_isReadOnly :+
      Activity_isSingleExecution :+
      ActivityPartition_isDimension :+
      ActivityPartition_isExternal :+
      AddStructuralFeatureValueAction_isReplaceAll :+
      AddVariableValueAction_isReplaceAll :+
      Association_isDerived :+
      Behavior_isReentrant :+
      BehavioralFeature_isAbstract :+
      CallAction_isSynchronous :+
      Class_isAbstract :+
      Class_isActive :+
      Classifier_isAbstract :+
      Classifier_isFinalSpecialization :+
      ClassifierTemplateParameter_allowSubstitutable :+
      Component_isIndirectlyInstantiated :+
      ConditionalNode_isAssured :+
      ConditionalNode_isDeterminate :+
      Continuation_setting :+
      DestroyObjectAction_isDestroyLinks :+
      DestroyObjectAction_isDestroyOwnedObjects :+
      Feature_isStatic :+
      GeneralizationSet_isCovering :+
      GeneralizationSet_isDisjoint :+
      JoinNode_isCombineDuplicate :+
      LinkEndCreationData_isReplaceAll :+
      LinkEndDestructionData_isDestroyDuplicates :+
      LiteralBoolean_value :+
      LiteralInteger_value :+
      LiteralReal_value :+
      LiteralUnlimitedNatural_value :+
      LoopNode_isTestedFirst :+
      MultiplicityElement_isOrdered :+
      MultiplicityElement_isUnique :+
      ObjectFlow_isMulticast :+
      ObjectFlow_isMultireceive :+
      ObjectNode_isControlType :+
      Operation_isQuery :+
      Parameter_isException :+
      Parameter_isStream :+
      Pin_isControl :+
      Port_isBehavior :+
      Port_isConjugated :+
      Port_isService :+
      ProfileApplication_isStrict :+
      Property_isDerived :+
      Property_isDerivedUnion :+
      Property_isID :+
      ReadIsClassifiedObjectAction_isDirect :+
      ReclassifyObjectAction_isReplaceAll :+
      RedefinableElement_isLeaf :+
      ReduceAction_isOrdered :+
      RemoveStructuralFeatureValueAction_isRemoveDuplicates :+
      RemoveVariableValueAction_isRemoveDuplicates :+
      StructuralFeature_isReadOnly :+
      StructuredActivityNode_mustIsolate :+
      TimeEvent_isRelative :+
      TimeObservation_firstEvent

  val BehavioralFeature_concurrency =
      MetaEnumerationAttributeUpdater(
        set_BehavioralFeature_concurrency _,
        ops.BehavioralFeature_concurrency,
        UMLCallConcurrencyKind.values)

  val CombinedFragment_interactionOperator =
      MetaEnumerationAttributeUpdater(
        set_CombinedFragment_interactionOperator _,
        ops.CombinedFragment_interactionOperator,
        UMLInteractionOperatorKind.values)

  val ElementImport_visibility =
      MetaEnumerationAttributeUpdater(
        set_ElementImport_visibility _,
        ops.ElementImport_visibility,
        UMLVisibilityKind.values)

  val ExpansionRegion_mode =
      MetaEnumerationAttributeUpdater(
        set_ExpansionRegion_mode _,
        ops.ExpansionRegion_mode,
        UMLExpansionKind.values)

  val Message_messageSort =
      MetaEnumerationAttributeUpdater(
        set_Message_messageSort _,
        ops.Message_messageSort,
        UMLMessageSort.values)

  val NamedElement_visibility =
      MetaEnumerationAttributeUpdater(
        set_NamedElement_visibility _,
        ops.NamedElement_visibility,
        UMLVisibilityKind.values)

  val ObjectNode_ordering =
      MetaEnumerationAttributeUpdater(
        set_ObjectNode_ordering _,
        ops.ObjectNode_ordering,
        UMLObjectNodeOrderingKind.values)

  val PackageImport_visibility =
      MetaEnumerationAttributeUpdater(
        set_PackageImport_visibility _,
        ops.PackageImport_visibility,
        UMLVisibilityKind.values)

  val PackageableElement_visibility =
      MetaEnumerationAttributeUpdater(
        set_PackageableElement_visibility _,
        ops.PackageableElement_visibility,
        UMLVisibilityKind.values)

  val Parameter_direction =
      MetaEnumerationAttributeUpdater(
        set_Parameter_direction _,
        ops.Parameter_direction,
        UMLParameterDirectionKind.values)

  val Parameter_effect =
      MetaEnumerationAttributeUpdater(
        set_Parameter_effect _,
        ops.Parameter_effect,
        UMLParameterEffectKind.values)

  val Property_aggregation =
      MetaEnumerationAttributeUpdater(
        set_Property_aggregation _,
        ops.Property_aggregation,
        UMLAggregationKind.values)

  val Pseudostate_kind =
      MetaEnumerationAttributeUpdater(
        set_Pseudostate_kind _,
        ops.Pseudostate_kind,
        UMLPseudostateKind.values)

  val Transition_kind =
      MetaEnumerationAttributeUpdater(
        set_Transition_kind _,
        ops.Transition_kind,
        UMLTransitionKind.values)

  val MetaPropertyEnumerationAttributeUpdate
  : Seq[MetaEnumerationAttributeUpdate]
  = Seq() :+
      BehavioralFeature_concurrency :+
      CombinedFragment_interactionOperator :+
      ElementImport_visibility :+
      ExpansionRegion_mode :+
      Message_messageSort :+
      NamedElement_visibility :+
      ObjectNode_ordering :+
      PackageImport_visibility :+
      PackageableElement_visibility :+
      Parameter_direction :+
      Parameter_effect :+
      Property_aggregation :+
      Pseudostate_kind :+
      Transition_kind

  val Artifact_fileName =
      MetaOptionAttributeUpdater(
        set_Artifact_fileName _,
        ops.Artifact_fileName,
        StringValueConverter.convert)

  val Comment_body =
      MetaOptionAttributeUpdater(
        set_Comment_body _,
        ops.Comment_body,
        StringValueConverter.convert)

  val DeploymentSpecification_deploymentLocation =
      MetaOptionAttributeUpdater(
        set_DeploymentSpecification_deploymentLocation _,
        ops.DeploymentSpecification_deploymentLocation,
        StringValueConverter.convert)

  val DeploymentSpecification_executionLocation =
      MetaOptionAttributeUpdater(
        set_DeploymentSpecification_executionLocation _,
        ops.DeploymentSpecification_executionLocation,
        StringValueConverter.convert)

  val ElementImport_alias =
      MetaOptionAttributeUpdater(
        set_ElementImport_alias _,
        ops.ElementImport_alias,
        StringValueConverter.convert)

  val Expression_symbol =
      MetaOptionAttributeUpdater(
        set_Expression_symbol _,
        ops.Expression_symbol,
        StringValueConverter.convert)

  val Generalization_isSubstitutable =
      MetaOptionAttributeUpdater(
        set_Generalization_isSubstitutable _,
        ops.Generalization_isSubstitutable,
        BooleanValueConverter.convert)

  val Image_content =
      MetaOptionAttributeUpdater(
        set_Image_content _,
        ops.Image_content,
        StringValueConverter.convert)

  val Image_format =
      MetaOptionAttributeUpdater(
        set_Image_format _,
        ops.Image_format,
        StringValueConverter.convert)

  val Image_location =
      MetaOptionAttributeUpdater(
        set_Image_location _,
        ops.Image_location,
        StringValueConverter.convert)

  val LiteralString_value =
      MetaOptionAttributeUpdater(
        set_LiteralString_value _,
        ops.LiteralString_value,
        StringValueConverter.convert)

  val Model_viewpoint =
      MetaOptionAttributeUpdater(
        set_Model_viewpoint _,
        ops.Model_viewpoint,
        StringValueConverter.convert)

  val NamedElement_name =
      MetaOptionAttributeUpdater(
        set_NamedElement_name _,
        ops.NamedElement_name,
        StringValueConverter.convert)

  val Package_URI =
      MetaOptionAttributeUpdater(
        set_Package_URI _,
        ops.Package_URI,
        StringValueConverter.convert)

  val TimeConstraint_firstEvent =
      MetaOptionAttributeUpdater(
        set_TimeConstraint_firstEvent _,
        ops.TimeConstraint_firstEvent,
        BooleanValueConverter.convert)

  val MetaPropertyOptionAttributeUpdate
  : Seq[MetaOptionAttributeUpdate]
  = Seq() :+
      Artifact_fileName :+
      Comment_body :+
      DeploymentSpecification_deploymentLocation :+
      DeploymentSpecification_executionLocation :+
      ElementImport_alias :+
      Expression_symbol :+
      Generalization_isSubstitutable :+
      Image_content :+
      Image_format :+
      Image_location :+
      LiteralString_value :+
      Model_viewpoint :+
      NamedElement_name :+
      Package_URI :+
      TimeConstraint_firstEvent

  val MetaPropertyIterableAttributeUpdate
  : Seq[MetaIterableAttributeUpdate]
  = Seq()

   val DurationObservation_firstEvent =
     MetaSeqAttributeUpdater(
        set_DurationObservation_firstEvent _,
        ops.DurationObservation_firstEvent,
        BooleanValueConverter.convert)

   val OpaqueAction_body =
     MetaSeqAttributeUpdater(
        set_OpaqueAction_body _,
        ops.OpaqueAction_body,
        StringValueConverter.convert)

   val OpaqueAction_language =
     MetaSeqAttributeUpdater(
        set_OpaqueAction_language _,
        ops.OpaqueAction_language,
        StringValueConverter.convert)

   val OpaqueBehavior_body =
     MetaSeqAttributeUpdater(
        set_OpaqueBehavior_body _,
        ops.OpaqueBehavior_body,
        StringValueConverter.convert)

   val OpaqueBehavior_language =
     MetaSeqAttributeUpdater(
        set_OpaqueBehavior_language _,
        ops.OpaqueBehavior_language,
        StringValueConverter.convert)

   val OpaqueExpression_body =
     MetaSeqAttributeUpdater(
        set_OpaqueExpression_body _,
        ops.OpaqueExpression_body,
        StringValueConverter.convert)

   val OpaqueExpression_language =
     MetaSeqAttributeUpdater(
        set_OpaqueExpression_language _,
        ops.OpaqueExpression_language,
        StringValueConverter.convert)

  val MetaPropertySeqAttributeUpdate
  : Seq[MetaSeqAttributeUpdate]
  = Seq() :+
      DurationObservation_firstEvent :+
      OpaqueAction_body :+
      OpaqueAction_language :+
      OpaqueBehavior_body :+
      OpaqueBehavior_language :+
      OpaqueExpression_body :+
      OpaqueExpression_language

  val DurationConstraint_firstEvent =
      MetaSetAttributeUpdater(
        set_DurationConstraint_firstEvent _,
        ops.DurationConstraint_firstEvent,
        BooleanValueConverter.convert)

  val MetaPropertySetAttributeUpdate
  : Seq[MetaSetAttributeUpdate]
  = Seq() :+
      DurationConstraint_firstEvent
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
    ("Diagram" -> metaclass_attribute_updater_table_Diagram) +
    ("Duration" -> metaclass_attribute_updater_table_Duration) +
    ("DurationConstraint" -> metaclass_attribute_updater_table_DurationConstraint) +
    ("DurationInterval" -> metaclass_attribute_updater_table_DurationInterval) +
    ("DurationObservation" -> metaclass_attribute_updater_table_DurationObservation) +
    ("ElementImport" -> metaclass_attribute_updater_table_ElementImport) +
    ("ElementValue" -> metaclass_attribute_updater_table_ElementValue) +
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
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_AcceptCallAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isUnmarshall" -> AcceptEventAction_isUnmarshall )

  lazy val metaclass_attribute_updater_table_AcceptEventAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isUnmarshall" -> AcceptEventAction_isUnmarshall )

  lazy val metaclass_attribute_updater_table_ActionExecutionSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_ActionInputPin
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isControlType" -> ObjectNode_isControlType ) :+
        ( "ordering" -> ObjectNode_ordering ) :+
        ( "isOrdered" -> MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MultiplicityElement_isUnique ) :+
        ( "isControl" -> Pin_isControl )

  lazy val metaclass_attribute_updater_table_Activity
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive ) :+
        ( "isReentrant" -> Behavior_isReentrant ) :+
        ( "isReadOnly" -> Activity_isReadOnly ) :+
        ( "isSingleExecution" -> Activity_isSingleExecution )

  lazy val metaclass_attribute_updater_table_ActivityFinalNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_ActivityParameterNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isControlType" -> ObjectNode_isControlType ) :+
        ( "ordering" -> ObjectNode_ordering )

  lazy val metaclass_attribute_updater_table_ActivityPartition
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isDimension" -> ActivityPartition_isDimension ) :+
        ( "isExternal" -> ActivityPartition_isExternal )

  lazy val metaclass_attribute_updater_table_Actor
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_AddStructuralFeatureValueAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isReplaceAll" -> AddStructuralFeatureValueAction_isReplaceAll )

  lazy val metaclass_attribute_updater_table_AddVariableValueAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isReplaceAll" -> AddVariableValueAction_isReplaceAll )

  lazy val metaclass_attribute_updater_table_AnyReceiveEvent
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Artifact
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "fileName" -> Artifact_fileName )

  lazy val metaclass_attribute_updater_table_Association
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isDerived" -> Association_isDerived )

  lazy val metaclass_attribute_updater_table_AssociationClass
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive ) :+
        ( "isDerived" -> Association_isDerived )

  lazy val metaclass_attribute_updater_table_BehaviorExecutionSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_BroadcastSignalAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_CallBehaviorAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isSynchronous" -> CallAction_isSynchronous )

  lazy val metaclass_attribute_updater_table_CallEvent
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_CallOperationAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isSynchronous" -> CallAction_isSynchronous )

  lazy val metaclass_attribute_updater_table_CentralBufferNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isControlType" -> ObjectNode_isControlType ) :+
        ( "ordering" -> ObjectNode_ordering )

  lazy val metaclass_attribute_updater_table_ChangeEvent
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Class
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive )

  lazy val metaclass_attribute_updater_table_ClassifierTemplateParameter
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "allowSubstitutable" -> ClassifierTemplateParameter_allowSubstitutable )

  lazy val metaclass_attribute_updater_table_Clause
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_ClearAssociationAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ClearStructuralFeatureAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ClearVariableAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_Collaboration
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_CollaborationUse
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_CombinedFragment
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "interactionOperator" -> CombinedFragment_interactionOperator )

  lazy val metaclass_attribute_updater_table_Comment
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "body" -> Comment_body )

  lazy val metaclass_attribute_updater_table_CommunicationPath
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isDerived" -> Association_isDerived )

  lazy val metaclass_attribute_updater_table_Component
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive ) :+
        ( "isIndirectlyInstantiated" -> Component_isIndirectlyInstantiated )

  lazy val metaclass_attribute_updater_table_ComponentRealization
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_ConditionalNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "mustIsolate" -> StructuredActivityNode_mustIsolate ) :+
        ( "isAssured" -> ConditionalNode_isAssured ) :+
        ( "isDeterminate" -> ConditionalNode_isDeterminate )

  lazy val metaclass_attribute_updater_table_ConnectableElementTemplateParameter
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_ConnectionPointReference
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Connector
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isStatic" -> Feature_isStatic )

  lazy val metaclass_attribute_updater_table_ConnectorEnd
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "isOrdered" -> MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MultiplicityElement_isUnique )

  lazy val metaclass_attribute_updater_table_ConsiderIgnoreFragment
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "interactionOperator" -> CombinedFragment_interactionOperator )

  lazy val metaclass_attribute_updater_table_Constraint
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Continuation
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "setting" -> Continuation_setting )

  lazy val metaclass_attribute_updater_table_ControlFlow
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_CreateLinkAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_CreateLinkObjectAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_CreateObjectAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_DataStoreNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isControlType" -> ObjectNode_isControlType ) :+
        ( "ordering" -> ObjectNode_ordering )

  lazy val metaclass_attribute_updater_table_DataType
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_DecisionNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_Dependency
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Deployment
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_DeploymentSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "fileName" -> Artifact_fileName ) :+
        ( "deploymentLocation" -> DeploymentSpecification_deploymentLocation ) :+
        ( "executionLocation" -> DeploymentSpecification_executionLocation )

  lazy val metaclass_attribute_updater_table_DestroyLinkAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_DestroyObjectAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isDestroyLinks" -> DestroyObjectAction_isDestroyLinks ) :+
        ( "isDestroyOwnedObjects" -> DestroyObjectAction_isDestroyOwnedObjects )

  lazy val metaclass_attribute_updater_table_DestructionOccurrenceSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Device
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive )

  lazy val metaclass_attribute_updater_table_Diagram
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Duration
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_DurationConstraint
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "firstEvent" -> DurationConstraint_firstEvent )

  lazy val metaclass_attribute_updater_table_DurationInterval
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_DurationObservation
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "firstEvent" -> DurationObservation_firstEvent )

  lazy val metaclass_attribute_updater_table_ElementImport
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "alias" -> ElementImport_alias ) :+
        ( "visibility" -> ElementImport_visibility )

  lazy val metaclass_attribute_updater_table_ElementValue
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Enumeration
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_EnumerationLiteral
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_ExceptionHandler
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_ExecutionEnvironment
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive )

  lazy val metaclass_attribute_updater_table_ExecutionOccurrenceSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_ExpansionNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isControlType" -> ObjectNode_isControlType ) :+
        ( "ordering" -> ObjectNode_ordering )

  lazy val metaclass_attribute_updater_table_ExpansionRegion
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "mustIsolate" -> StructuredActivityNode_mustIsolate ) :+
        ( "mode" -> ExpansionRegion_mode )

  lazy val metaclass_attribute_updater_table_Expression
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "symbol" -> Expression_symbol )

  lazy val metaclass_attribute_updater_table_Extend
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Extension
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isDerived" -> Association_isDerived )

  lazy val metaclass_attribute_updater_table_ExtensionEnd
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isOrdered" -> MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MultiplicityElement_isUnique ) :+
        ( "isStatic" -> Feature_isStatic ) :+
        ( "isReadOnly" -> StructuralFeature_isReadOnly ) :+
        ( "aggregation" -> Property_aggregation ) :+
        ( "isDerived" -> Property_isDerived ) :+
        ( "isDerivedUnion" -> Property_isDerivedUnion ) :+
        ( "isID" -> Property_isID )

  lazy val metaclass_attribute_updater_table_ExtensionPoint
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_FinalState
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_FlowFinalNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_ForkNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_FunctionBehavior
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive ) :+
        ( "isReentrant" -> Behavior_isReentrant ) :+
        ( "body" -> OpaqueBehavior_body ) :+
        ( "language" -> OpaqueBehavior_language )

  lazy val metaclass_attribute_updater_table_Gate
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_GeneralOrdering
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Generalization
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "isSubstitutable" -> Generalization_isSubstitutable )

  lazy val metaclass_attribute_updater_table_GeneralizationSet
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isCovering" -> GeneralizationSet_isCovering ) :+
        ( "isDisjoint" -> GeneralizationSet_isDisjoint )

  lazy val metaclass_attribute_updater_table_Image
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "content" -> Image_content ) :+
        ( "format" -> Image_format ) :+
        ( "location" -> Image_location )

  lazy val metaclass_attribute_updater_table_Include
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_InformationFlow
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_InformationItem
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_InitialNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_InputPin
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isControlType" -> ObjectNode_isControlType ) :+
        ( "ordering" -> ObjectNode_ordering ) :+
        ( "isOrdered" -> MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MultiplicityElement_isUnique ) :+
        ( "isControl" -> Pin_isControl )

  lazy val metaclass_attribute_updater_table_InstanceSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_InstanceValue
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Interaction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive ) :+
        ( "isReentrant" -> Behavior_isReentrant )

  lazy val metaclass_attribute_updater_table_InteractionConstraint
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_InteractionOperand
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_InteractionUse
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Interface
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_InterfaceRealization
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_InterruptibleActivityRegion
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Interval
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_IntervalConstraint
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_JoinNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isCombineDuplicate" -> JoinNode_isCombineDuplicate )

  lazy val metaclass_attribute_updater_table_Lifeline
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_LinkEndCreationData
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "isReplaceAll" -> LinkEndCreationData_isReplaceAll )

  lazy val metaclass_attribute_updater_table_LinkEndData
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_LinkEndDestructionData
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "isDestroyDuplicates" -> LinkEndDestructionData_isDestroyDuplicates )

  lazy val metaclass_attribute_updater_table_LiteralBoolean
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "value" -> LiteralBoolean_value )

  lazy val metaclass_attribute_updater_table_LiteralInteger
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "value" -> LiteralInteger_value )

  lazy val metaclass_attribute_updater_table_LiteralNull
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_LiteralReal
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "value" -> LiteralReal_value )

  lazy val metaclass_attribute_updater_table_LiteralString
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "value" -> LiteralString_value )

  lazy val metaclass_attribute_updater_table_LiteralUnlimitedNatural
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "value" -> LiteralUnlimitedNatural_value )

  lazy val metaclass_attribute_updater_table_LoopNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "mustIsolate" -> StructuredActivityNode_mustIsolate ) :+
        ( "isTestedFirst" -> LoopNode_isTestedFirst )

  lazy val metaclass_attribute_updater_table_Manifestation
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_MergeNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_Message
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "messageSort" -> Message_messageSort )

  lazy val metaclass_attribute_updater_table_MessageOccurrenceSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Model
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "URI" -> Package_URI ) :+
        ( "viewpoint" -> Model_viewpoint )

  lazy val metaclass_attribute_updater_table_Node
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive )

  lazy val metaclass_attribute_updater_table_ObjectFlow
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isMulticast" -> ObjectFlow_isMulticast ) :+
        ( "isMultireceive" -> ObjectFlow_isMultireceive )

  lazy val metaclass_attribute_updater_table_OccurrenceSpecification
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_OpaqueAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "body" -> OpaqueAction_body ) :+
        ( "language" -> OpaqueAction_language )

  lazy val metaclass_attribute_updater_table_OpaqueBehavior
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive ) :+
        ( "isReentrant" -> Behavior_isReentrant ) :+
        ( "body" -> OpaqueBehavior_body ) :+
        ( "language" -> OpaqueBehavior_language )

  lazy val metaclass_attribute_updater_table_OpaqueExpression
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "body" -> OpaqueExpression_body ) :+
        ( "language" -> OpaqueExpression_language )

  lazy val metaclass_attribute_updater_table_Operation
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isStatic" -> Feature_isStatic ) :+
        ( "concurrency" -> BehavioralFeature_concurrency ) :+
        ( "isAbstract" -> BehavioralFeature_isAbstract ) :+
        ( "isQuery" -> Operation_isQuery )

  lazy val metaclass_attribute_updater_table_OperationTemplateParameter
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_OutputPin
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isControlType" -> ObjectNode_isControlType ) :+
        ( "ordering" -> ObjectNode_ordering ) :+
        ( "isOrdered" -> MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MultiplicityElement_isUnique ) :+
        ( "isControl" -> Pin_isControl )

  lazy val metaclass_attribute_updater_table_Package
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "URI" -> Package_URI )

  lazy val metaclass_attribute_updater_table_PackageImport
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "visibility" -> PackageImport_visibility )

  lazy val metaclass_attribute_updater_table_PackageMerge
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_Parameter
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isOrdered" -> MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MultiplicityElement_isUnique ) :+
        ( "direction" -> Parameter_direction ) :+
        ( "effect" -> Parameter_effect ) :+
        ( "isException" -> Parameter_isException ) :+
        ( "isStream" -> Parameter_isStream )

  lazy val metaclass_attribute_updater_table_ParameterSet
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_PartDecomposition
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_Port
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isOrdered" -> MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MultiplicityElement_isUnique ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isStatic" -> Feature_isStatic ) :+
        ( "isReadOnly" -> StructuralFeature_isReadOnly ) :+
        ( "aggregation" -> Property_aggregation ) :+
        ( "isDerived" -> Property_isDerived ) :+
        ( "isDerivedUnion" -> Property_isDerivedUnion ) :+
        ( "isID" -> Property_isID ) :+
        ( "isBehavior" -> Port_isBehavior ) :+
        ( "isConjugated" -> Port_isConjugated ) :+
        ( "isService" -> Port_isService )

  lazy val metaclass_attribute_updater_table_PrimitiveType
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_Profile
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "URI" -> Package_URI )

  lazy val metaclass_attribute_updater_table_ProfileApplication
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "isStrict" -> ProfileApplication_isStrict )

  lazy val metaclass_attribute_updater_table_Property
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isOrdered" -> MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MultiplicityElement_isUnique ) :+
        ( "isStatic" -> Feature_isStatic ) :+
        ( "isReadOnly" -> StructuralFeature_isReadOnly ) :+
        ( "aggregation" -> Property_aggregation ) :+
        ( "isDerived" -> Property_isDerived ) :+
        ( "isDerivedUnion" -> Property_isDerivedUnion ) :+
        ( "isID" -> Property_isID )

  lazy val metaclass_attribute_updater_table_ProtocolConformance
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_ProtocolStateMachine
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive ) :+
        ( "isReentrant" -> Behavior_isReentrant )

  lazy val metaclass_attribute_updater_table_ProtocolTransition
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "kind" -> Transition_kind )

  lazy val metaclass_attribute_updater_table_Pseudostate
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "kind" -> Pseudostate_kind )

  lazy val metaclass_attribute_updater_table_QualifierValue
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_RaiseExceptionAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadExtentAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadIsClassifiedObjectAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isDirect" -> ReadIsClassifiedObjectAction_isDirect )

  lazy val metaclass_attribute_updater_table_ReadLinkAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadLinkObjectEndAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadLinkObjectEndQualifierAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadSelfAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadStructuralFeatureAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_ReadVariableAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_Realization
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Reception
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isStatic" -> Feature_isStatic ) :+
        ( "concurrency" -> BehavioralFeature_concurrency ) :+
        ( "isAbstract" -> BehavioralFeature_isAbstract )

  lazy val metaclass_attribute_updater_table_ReclassifyObjectAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isReplaceAll" -> ReclassifyObjectAction_isReplaceAll )

  lazy val metaclass_attribute_updater_table_RedefinableTemplateSignature
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_ReduceAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isOrdered" -> ReduceAction_isOrdered )

  lazy val metaclass_attribute_updater_table_Region
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_RemoveStructuralFeatureValueAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isRemoveDuplicates" -> RemoveStructuralFeatureValueAction_isRemoveDuplicates )

  lazy val metaclass_attribute_updater_table_RemoveVariableValueAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isRemoveDuplicates" -> RemoveVariableValueAction_isRemoveDuplicates )

  lazy val metaclass_attribute_updater_table_ReplyAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_SendObjectAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_SendSignalAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_SequenceNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "mustIsolate" -> StructuredActivityNode_mustIsolate )

  lazy val metaclass_attribute_updater_table_Signal
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_SignalEvent
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_Slot
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]()

  lazy val metaclass_attribute_updater_table_StartClassifierBehaviorAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_StartObjectBehaviorAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "isSynchronous" -> CallAction_isSynchronous )

  lazy val metaclass_attribute_updater_table_State
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf )

  lazy val metaclass_attribute_updater_table_StateInvariant
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_StateMachine
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive ) :+
        ( "isReentrant" -> Behavior_isReentrant )

  lazy val metaclass_attribute_updater_table_Stereotype
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization ) :+
        ( "isAbstract" -> Class_isAbstract ) :+
        ( "isActive" -> Class_isActive )

  lazy val metaclass_attribute_updater_table_StringExpression
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "symbol" -> Expression_symbol )

  lazy val metaclass_attribute_updater_table_StructuredActivityNode
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant ) :+
        ( "mustIsolate" -> StructuredActivityNode_mustIsolate )

  lazy val metaclass_attribute_updater_table_Substitution
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

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
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_TimeConstraint
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "firstEvent" -> TimeConstraint_firstEvent )

  lazy val metaclass_attribute_updater_table_TimeEvent
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isRelative" -> TimeEvent_isRelative )

  lazy val metaclass_attribute_updater_table_TimeExpression
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_TimeInterval
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_TimeObservation
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "firstEvent" -> TimeObservation_firstEvent )

  lazy val metaclass_attribute_updater_table_Transition
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "kind" -> Transition_kind )

  lazy val metaclass_attribute_updater_table_Trigger
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility )

  lazy val metaclass_attribute_updater_table_UnmarshallAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_Usage
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility )

  lazy val metaclass_attribute_updater_table_UseCase
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> PackageableElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isAbstract" -> Classifier_isAbstract ) :+
        ( "isFinalSpecialization" -> Classifier_isFinalSpecialization )

  lazy val metaclass_attribute_updater_table_ValuePin
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isControlType" -> ObjectNode_isControlType ) :+
        ( "ordering" -> ObjectNode_ordering ) :+
        ( "isOrdered" -> MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MultiplicityElement_isUnique ) :+
        ( "isControl" -> Pin_isControl )

  lazy val metaclass_attribute_updater_table_ValueSpecificationAction
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isLeaf" -> RedefinableElement_isLeaf ) :+
        ( "isLocallyReentrant" -> Action_isLocallyReentrant )

  lazy val metaclass_attribute_updater_table_Variable
  : Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]
  = Seq[(String, MetaAttributeUpdate[_ <: UMLElement[Uml]])]() :+
        ( "name" -> NamedElement_name ) :+
        ( "visibility" -> NamedElement_visibility ) :+
        ( "isOrdered" -> MultiplicityElement_isOrdered ) :+
        ( "isUnique" -> MultiplicityElement_isUnique )

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
    ("Diagram" -> metaclass_composite_updater_table_Diagram) +
    ("Duration" -> metaclass_composite_updater_table_Duration) +
    ("DurationConstraint" -> metaclass_composite_updater_table_DurationConstraint) +
    ("DurationInterval" -> metaclass_composite_updater_table_DurationInterval) +
    ("DurationObservation" -> metaclass_composite_updater_table_DurationObservation) +
    ("ElementImport" -> metaclass_composite_updater_table_ElementImport) +
    ("ElementValue" -> metaclass_composite_updater_table_ElementValue) +
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
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "mapping" -> Abstraction_abstraction_mapping_OpaqueExpression )

  // All parents: {AcceptCallAction, AcceptEventAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_AcceptCallAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "result" -> AcceptEventAction_acceptEventAction_result_OutputPin ) :+
    ( "trigger" -> AcceptEventAction_acceptEventAction_trigger_Trigger ) :+
    ( "returnInformation" -> AcceptCallAction_acceptCallAction_returnInformation_OutputPin )

  // All parents: {AcceptEventAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_AcceptEventAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "result" -> AcceptEventAction_acceptEventAction_result_OutputPin ) :+
    ( "trigger" -> AcceptEventAction_acceptEventAction_trigger_Trigger )

  // All parents: {ActionExecutionSpecification, ExecutionSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ActionExecutionSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering )

  // All parents: {ActionInputPin, InputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ActionInputPin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "upperBound" -> ObjectNode_objectNode_upperBound_ValueSpecification ) :+
    ( "lowerValue" -> MultiplicityElement_owningLower_lowerValue_ValueSpecification ) :+
    ( "upperValue" -> MultiplicityElement_owningUpper_upperValue_ValueSpecification ) :+
    ( "fromAction" -> ActionInputPin_actionInputPin_fromAction_Action )

  // All parents: {Activity, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Activity
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception ) :+
    ( "ownedParameter" -> Behavior_behavior_ownedParameter_Parameter ) :+
    ( "ownedParameterSet" -> Behavior_behavior_ownedParameterSet_ParameterSet ) :+
    ( "edge" -> Activity_activity_edge_ActivityEdge ) :+
    ( "group" -> Activity_inActivity_group_ActivityGroup ) :+
    ( "node" -> Activity_activity_node_ActivityNode ) :+
    ( "variable" -> Activity_activityScope_variable_Variable )

  // All parents: {ActivityFinalNode, FinalNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ActivityFinalNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {ActivityParameterNode, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ActivityParameterNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "upperBound" -> ObjectNode_objectNode_upperBound_ValueSpecification )

  // All parents: {ActivityPartition, ActivityGroup, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ActivityPartition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "subpartition" -> ActivityPartition_superPartition_subpartition_ActivityPartition )

  // All parents: {Actor, BehavioredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Actor
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior )

  // All parents: {AddStructuralFeatureValueAction, WriteStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_AddStructuralFeatureValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "object" -> StructuralFeatureAction_structuralFeatureAction_object_InputPin ) :+
    ( "result" -> WriteStructuralFeatureAction_writeStructuralFeatureAction_result_OutputPin ) :+
    ( "value" -> WriteStructuralFeatureAction_writeStructuralFeatureAction_value_InputPin ) :+
    ( "insertAt" -> AddStructuralFeatureValueAction_addStructuralFeatureValueAction_insertAt_InputPin )

  // All parents: {AddVariableValueAction, WriteVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_AddVariableValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "value" -> WriteVariableAction_writeVariableAction_value_InputPin ) :+
    ( "insertAt" -> AddVariableValueAction_addVariableValueAction_insertAt_InputPin )

  // All parents: {AnyReceiveEvent, MessageEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_AnyReceiveEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Artifact, Classifier, DeployedArtifact, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Artifact
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "manifestation" -> Artifact_artifact_manifestation_Manifestation ) :+
    ( "nestedArtifact" -> Artifact_artifact_nestedArtifact_Artifact ) :+
    ( "ownedAttribute" -> Artifact_artifact_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Artifact_artifact_ownedOperation_Operation )

  // All parents: {Association, Classifier, Relationship, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Association
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedEnd" -> Association_owningAssociation_ownedEnd_Property )

  // All parents: {AssociationClass, Association, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, Relationship, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_AssociationClass
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception ) :+
    ( "ownedEnd" -> Association_owningAssociation_ownedEnd_Property )

  // All parents: {BehaviorExecutionSpecification, ExecutionSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_BehaviorExecutionSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering )

  // All parents: {BroadcastSignalAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_BroadcastSignalAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "argument" -> InvocationAction_invocationAction_argument_InputPin )

  // All parents: {CallBehaviorAction, CallAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CallBehaviorAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "argument" -> InvocationAction_invocationAction_argument_InputPin ) :+
    ( "result" -> CallAction_callAction_result_OutputPin )

  // All parents: {CallEvent, MessageEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_CallEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {CallOperationAction, CallAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CallOperationAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "argument" -> InvocationAction_invocationAction_argument_InputPin ) :+
    ( "result" -> CallAction_callAction_result_OutputPin ) :+
    ( "target" -> CallOperationAction_callOperationAction_target_InputPin )

  // All parents: {CentralBufferNode, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CentralBufferNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "upperBound" -> ObjectNode_objectNode_upperBound_ValueSpecification )

  // All parents: {ChangeEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_ChangeEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "changeExpression" -> ChangeEvent_changeEvent_changeExpression_ValueSpecification )

  // All parents: {Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Class
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception )

  // All parents: {ClassifierTemplateParameter, TemplateParameter, Element}
  lazy val metaclass_composite_updater_table_ClassifierTemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "ownedDefault" -> TemplateParameter_templateParameter_ownedDefault_ParameterableElement ) :+
    ( "ownedParameteredElement" -> TemplateParameter_owningTemplateParameter_ownedParameteredElement_ParameterableElement )

  // All parents: {Clause, Element}
  lazy val metaclass_composite_updater_table_Clause
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment )

  // All parents: {ClearAssociationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ClearAssociationAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "object" -> ClearAssociationAction_clearAssociationAction_object_InputPin )

  // All parents: {ClearStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ClearStructuralFeatureAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "object" -> StructuralFeatureAction_structuralFeatureAction_object_InputPin ) :+
    ( "result" -> ClearStructuralFeatureAction_clearStructuralFeatureAction_result_OutputPin )

  // All parents: {ClearVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ClearVariableAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint )

  // All parents: {Collaboration, BehavioredClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Collaboration
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior )

  // All parents: {CollaborationUse, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CollaborationUse
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "roleBinding" -> CollaborationUse_collaborationUse_roleBinding_Dependency )

  // All parents: {CombinedFragment, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CombinedFragment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering ) :+
    ( "cfragmentGate" -> CombinedFragment_combinedFragment_cfragmentGate_Gate ) :+
    ( "operand" -> CombinedFragment_combinedFragment_operand_InteractionOperand )

  // All parents: {Comment, Element}
  lazy val metaclass_composite_updater_table_Comment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment )

  // All parents: {CommunicationPath, Association, Classifier, Relationship, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_CommunicationPath
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedEnd" -> Association_owningAssociation_ownedEnd_Property )

  // All parents: {Component, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Component
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception ) :+
    ( "packagedElement" -> Component_component_packagedElement_PackageableElement ) :+
    ( "realization" -> Component_abstraction_realization_ComponentRealization )

  // All parents: {ComponentRealization, Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_ComponentRealization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "mapping" -> Abstraction_abstraction_mapping_OpaqueExpression )

  // All parents: {ConditionalNode, StructuredActivityNode, Action, ActivityGroup, ExecutableNode, Namespace, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ConditionalNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "edge" -> StructuredActivityNode_inStructuredNode_edge_ActivityEdge ) :+
    ( "node" -> StructuredActivityNode_inStructuredNode_node_ActivityNode ) :+
    ( "structuredNodeInput" -> StructuredActivityNode_structuredActivityNode_structuredNodeInput_InputPin ) :+
    ( "structuredNodeOutput" -> StructuredActivityNode_structuredActivityNode_structuredNodeOutput_OutputPin ) :+
    ( "variable" -> StructuredActivityNode_scope_variable_Variable ) :+
    ( "clause" -> ConditionalNode_conditionalNode_clause_Clause ) :+
    ( "result" -> ConditionalNode_conditionalNode_result_OutputPin )

  // All parents: {ConnectableElementTemplateParameter, TemplateParameter, Element}
  lazy val metaclass_composite_updater_table_ConnectableElementTemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "ownedDefault" -> TemplateParameter_templateParameter_ownedDefault_ParameterableElement ) :+
    ( "ownedParameteredElement" -> TemplateParameter_owningTemplateParameter_ownedParameteredElement_ParameterableElement )

  // All parents: {ConnectionPointReference, Vertex, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ConnectionPointReference
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Connector, Feature, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Connector
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "end" -> Connector_connector_end_ConnectorEnd )

  // All parents: {ConnectorEnd, MultiplicityElement, Element}
  lazy val metaclass_composite_updater_table_ConnectorEnd
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "lowerValue" -> MultiplicityElement_owningLower_lowerValue_ValueSpecification ) :+
    ( "upperValue" -> MultiplicityElement_owningUpper_upperValue_ValueSpecification )

  // All parents: {ConsiderIgnoreFragment, CombinedFragment, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ConsiderIgnoreFragment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering ) :+
    ( "cfragmentGate" -> CombinedFragment_combinedFragment_cfragmentGate_Gate ) :+
    ( "operand" -> CombinedFragment_combinedFragment_operand_InteractionOperand )

  // All parents: {Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Constraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "specification" -> Constraint_owningConstraint_specification_ValueSpecification )

  // All parents: {Continuation, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Continuation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering )

  // All parents: {ControlFlow, ActivityEdge, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ControlFlow
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "guard" -> ActivityEdge_activityEdge_guard_ValueSpecification ) :+
    ( "weight" -> ActivityEdge_activityEdge_weight_ValueSpecification )

  // All parents: {CreateLinkAction, WriteLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CreateLinkAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "endData" -> LinkAction_linkAction_endData_LinkEndData ) :+
    ( "inputValue" -> LinkAction_linkAction_inputValue_InputPin ) :+
    ( "endData" -> CreateLinkAction_createLinkAction_endData_LinkEndCreationData )

  // All parents: {CreateLinkObjectAction, CreateLinkAction, WriteLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CreateLinkObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "endData" -> LinkAction_linkAction_endData_LinkEndData ) :+
    ( "inputValue" -> LinkAction_linkAction_inputValue_InputPin ) :+
    ( "endData" -> CreateLinkAction_createLinkAction_endData_LinkEndCreationData ) :+
    ( "result" -> CreateLinkObjectAction_createLinkObjectAction_result_OutputPin )

  // All parents: {CreateObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_CreateObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "result" -> CreateObjectAction_createObjectAction_result_OutputPin )

  // All parents: {DataStoreNode, CentralBufferNode, ObjectNode, ActivityNode, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_DataStoreNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "upperBound" -> ObjectNode_objectNode_upperBound_ValueSpecification )

  // All parents: {DataType, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_DataType
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> DataType_datatype_ownedAttribute_Property ) :+
    ( "ownedOperation" -> DataType_datatype_ownedOperation_Operation )

  // All parents: {DecisionNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_DecisionNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Dependency, DirectedRelationship, PackageableElement, Relationship, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Dependency
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Deployment, Dependency, DirectedRelationship, PackageableElement, Relationship, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Deployment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "configuration" -> Deployment_deployment_configuration_DeploymentSpecification )

  // All parents: {DeploymentSpecification, Artifact, Classifier, Namespace, DeployedArtifact, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_DeploymentSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "manifestation" -> Artifact_artifact_manifestation_Manifestation ) :+
    ( "nestedArtifact" -> Artifact_artifact_nestedArtifact_Artifact ) :+
    ( "ownedAttribute" -> Artifact_artifact_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Artifact_artifact_ownedOperation_Operation )

  // All parents: {DestroyLinkAction, WriteLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_DestroyLinkAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "endData" -> LinkAction_linkAction_endData_LinkEndData ) :+
    ( "inputValue" -> LinkAction_linkAction_inputValue_InputPin ) :+
    ( "endData" -> DestroyLinkAction_destroyLinkAction_endData_LinkEndDestructionData )

  // All parents: {DestroyObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_DestroyObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "target" -> DestroyObjectAction_destroyObjectAction_target_InputPin )

  // All parents: {DestructionOccurrenceSpecification, MessageOccurrenceSpecification, MessageEnd, OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_DestructionOccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering )

  // All parents: {Device, Node, Class, BehavioredClassifier, DeploymentTarget, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Device
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "deployment" -> DeploymentTarget_location_deployment_Deployment ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception ) :+
    ( "nestedNode" -> Node_node_nestedNode_Node )

  // All parents: {Diagram, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Diagram
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Duration, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Duration
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "expr" -> Duration_duration_expr_ValueSpecification )

  // All parents: {DurationConstraint, IntervalConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_DurationConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "specification" -> Constraint_owningConstraint_specification_ValueSpecification ) :+
    ( "specification" -> IntervalConstraint_intervalConstraint_specification_Interval ) :+
    ( "specification" -> DurationConstraint_durationConstraint_specification_DurationInterval )

  // All parents: {DurationInterval, Interval, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_DurationInterval
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {DurationObservation, Observation, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_DurationObservation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {ElementImport, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_ElementImport
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment )

  // All parents: {ElementValue, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_ElementValue
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Enumeration, DataType, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Enumeration
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> DataType_datatype_ownedAttribute_Property ) :+
    ( "ownedOperation" -> DataType_datatype_ownedOperation_Operation ) :+
    ( "ownedLiteral" -> Enumeration_enumeration_ownedLiteral_EnumerationLiteral )

  // All parents: {EnumerationLiteral, InstanceSpecification, DeployedArtifact, DeploymentTarget, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_EnumerationLiteral
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "deployment" -> DeploymentTarget_location_deployment_Deployment ) :+
    ( "slot" -> InstanceSpecification_owningInstance_slot_Slot ) :+
    ( "specification" -> InstanceSpecification_owningInstanceSpec_specification_ValueSpecification )

  // All parents: {ExceptionHandler, Element}
  lazy val metaclass_composite_updater_table_ExceptionHandler
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment )

  // All parents: {ExecutionEnvironment, Node, Class, BehavioredClassifier, DeploymentTarget, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_ExecutionEnvironment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "deployment" -> DeploymentTarget_location_deployment_Deployment ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception ) :+
    ( "nestedNode" -> Node_node_nestedNode_Node )

  // All parents: {ExecutionOccurrenceSpecification, OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ExecutionOccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering )

  // All parents: {ExpansionNode, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ExpansionNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "upperBound" -> ObjectNode_objectNode_upperBound_ValueSpecification )

  // All parents: {ExpansionRegion, StructuredActivityNode, Action, ExecutableNode, ActivityGroup, ActivityNode, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ExpansionRegion
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "edge" -> StructuredActivityNode_inStructuredNode_edge_ActivityEdge ) :+
    ( "node" -> StructuredActivityNode_inStructuredNode_node_ActivityNode ) :+
    ( "structuredNodeInput" -> StructuredActivityNode_structuredActivityNode_structuredNodeInput_InputPin ) :+
    ( "structuredNodeOutput" -> StructuredActivityNode_structuredActivityNode_structuredNodeOutput_OutputPin ) :+
    ( "variable" -> StructuredActivityNode_scope_variable_Variable )

  // All parents: {Expression, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Expression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "operand" -> Expression_expression_operand_ValueSpecification )

  // All parents: {Extend, DirectedRelationship, Relationship, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Extend
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "condition" -> Extend_extend_condition_Constraint )

  // All parents: {Extension, Association, Classifier, Relationship, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Extension
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedEnd" -> Association_owningAssociation_ownedEnd_Property ) :+
    ( "ownedEnd" -> Extension_extension_ownedEnd_ExtensionEnd )

  // All parents: {ExtensionEnd, Property, ConnectableElement, DeploymentTarget, ParameterableElement, StructuralFeature, Feature, MultiplicityElement, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ExtensionEnd
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "lowerValue" -> MultiplicityElement_owningLower_lowerValue_ValueSpecification ) :+
    ( "upperValue" -> MultiplicityElement_owningUpper_upperValue_ValueSpecification ) :+
    ( "deployment" -> DeploymentTarget_location_deployment_Deployment ) :+
    ( "defaultValue" -> Property_owningProperty_defaultValue_ValueSpecification ) :+
    ( "qualifier" -> Property_associationEnd_qualifier_Property )

  // All parents: {ExtensionPoint, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ExtensionPoint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {FinalState, State, Namespace, RedefinableElement, Vertex, NamedElement, Element}
  lazy val metaclass_composite_updater_table_FinalState
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "connection" -> State_state_connection_ConnectionPointReference ) :+
    ( "connectionPoint" -> State_state_connectionPoint_Pseudostate ) :+
    ( "deferrableTrigger" -> State_state_deferrableTrigger_Trigger ) :+
    ( "doActivity" -> State_state_doActivity_Behavior ) :+
    ( "entry" -> State_state_entry_Behavior ) :+
    ( "exit" -> State_state_exit_Behavior ) :+
    ( "region" -> State_state_region_Region )

  // All parents: {FlowFinalNode, FinalNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_FlowFinalNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {ForkNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ForkNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {FunctionBehavior, OpaqueBehavior, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_FunctionBehavior
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception ) :+
    ( "ownedParameter" -> Behavior_behavior_ownedParameter_Parameter ) :+
    ( "ownedParameterSet" -> Behavior_behavior_ownedParameterSet_ParameterSet )

  // All parents: {Gate, MessageEnd, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Gate
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {GeneralOrdering, NamedElement, Element}
  lazy val metaclass_composite_updater_table_GeneralOrdering
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Generalization, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_Generalization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment )

  // All parents: {GeneralizationSet, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_GeneralizationSet
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Image, Element}
  lazy val metaclass_composite_updater_table_Image
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment )

  // All parents: {Include, DirectedRelationship, NamedElement, Relationship, Element}
  lazy val metaclass_composite_updater_table_Include
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {InformationFlow, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_InformationFlow
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {InformationItem, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_InformationItem
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution )

  // All parents: {InitialNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_InitialNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {InputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_InputPin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "upperBound" -> ObjectNode_objectNode_upperBound_ValueSpecification ) :+
    ( "lowerValue" -> MultiplicityElement_owningLower_lowerValue_ValueSpecification ) :+
    ( "upperValue" -> MultiplicityElement_owningUpper_upperValue_ValueSpecification )

  // All parents: {InstanceSpecification, DeployedArtifact, DeploymentTarget, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_InstanceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "deployment" -> DeploymentTarget_location_deployment_Deployment ) :+
    ( "slot" -> InstanceSpecification_owningInstance_slot_Slot ) :+
    ( "specification" -> InstanceSpecification_owningInstanceSpec_specification_ValueSpecification )

  // All parents: {InstanceValue, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_InstanceValue
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Interaction, Behavior, Class, InteractionFragment, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Interaction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception ) :+
    ( "ownedParameter" -> Behavior_behavior_ownedParameter_Parameter ) :+
    ( "ownedParameterSet" -> Behavior_behavior_ownedParameterSet_ParameterSet ) :+
    ( "action" -> Interaction_interaction_action_Action ) :+
    ( "formalGate" -> Interaction_interaction_formalGate_Gate ) :+
    ( "fragment" -> Interaction_enclosingInteraction_fragment_InteractionFragment ) :+
    ( "lifeline" -> Interaction_interaction_lifeline_Lifeline ) :+
    ( "message" -> Interaction_interaction_message_Message )

  // All parents: {InteractionConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_InteractionConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "specification" -> Constraint_owningConstraint_specification_ValueSpecification ) :+
    ( "maxint" -> InteractionConstraint_interactionConstraint_maxint_ValueSpecification ) :+
    ( "minint" -> InteractionConstraint_interactionConstraint_minint_ValueSpecification )

  // All parents: {InteractionOperand, InteractionFragment, Namespace, NamedElement, Element}
  lazy val metaclass_composite_updater_table_InteractionOperand
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering ) :+
    ( "fragment" -> InteractionOperand_enclosingOperand_fragment_InteractionFragment ) :+
    ( "guard" -> InteractionOperand_interactionOperand_guard_InteractionConstraint )

  // All parents: {InteractionUse, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_InteractionUse
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering ) :+
    ( "actualGate" -> InteractionUse_interactionUse_actualGate_Gate ) :+
    ( "argument" -> InteractionUse_interactionUse_argument_ValueSpecification ) :+
    ( "returnValue" -> InteractionUse_interactionUse_returnValue_ValueSpecification )

  // All parents: {Interface, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Interface
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "nestedClassifier" -> Interface_interface_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Interface_interface_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Interface_interface_ownedOperation_Operation ) :+
    ( "ownedReception" -> Interface_interface_ownedReception_Reception ) :+
    ( "protocol" -> Interface_interface_protocol_ProtocolStateMachine )

  // All parents: {InterfaceRealization, Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_InterfaceRealization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "mapping" -> Abstraction_abstraction_mapping_OpaqueExpression )

  // All parents: {InterruptibleActivityRegion, ActivityGroup, NamedElement, Element}
  lazy val metaclass_composite_updater_table_InterruptibleActivityRegion
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Interval, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Interval
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {IntervalConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_IntervalConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "specification" -> Constraint_owningConstraint_specification_ValueSpecification ) :+
    ( "specification" -> IntervalConstraint_intervalConstraint_specification_Interval )

  // All parents: {JoinNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_JoinNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "joinSpec" -> JoinNode_joinNode_joinSpec_ValueSpecification )

  // All parents: {Lifeline, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Lifeline
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "selector" -> Lifeline_lifeline_selector_ValueSpecification )

  // All parents: {LinkEndCreationData, LinkEndData, Element}
  lazy val metaclass_composite_updater_table_LinkEndCreationData
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "qualifier" -> LinkEndData_linkEndData_qualifier_QualifierValue )

  // All parents: {LinkEndData, Element}
  lazy val metaclass_composite_updater_table_LinkEndData
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "qualifier" -> LinkEndData_linkEndData_qualifier_QualifierValue )

  // All parents: {LinkEndDestructionData, LinkEndData, Element}
  lazy val metaclass_composite_updater_table_LinkEndDestructionData
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "qualifier" -> LinkEndData_linkEndData_qualifier_QualifierValue )

  // All parents: {LiteralBoolean, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_LiteralBoolean
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {LiteralInteger, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_LiteralInteger
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {LiteralNull, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_LiteralNull
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {LiteralReal, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_LiteralReal
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {LiteralString, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_LiteralString
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {LiteralUnlimitedNatural, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_LiteralUnlimitedNatural
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {LoopNode, StructuredActivityNode, Action, ExecutableNode, ActivityGroup, ActivityNode, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_LoopNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "edge" -> StructuredActivityNode_inStructuredNode_edge_ActivityEdge ) :+
    ( "node" -> StructuredActivityNode_inStructuredNode_node_ActivityNode ) :+
    ( "structuredNodeInput" -> StructuredActivityNode_structuredActivityNode_structuredNodeInput_InputPin ) :+
    ( "structuredNodeOutput" -> StructuredActivityNode_structuredActivityNode_structuredNodeOutput_OutputPin ) :+
    ( "variable" -> StructuredActivityNode_scope_variable_Variable ) :+
    ( "loopVariable" -> LoopNode_loopNode_loopVariable_OutputPin ) :+
    ( "loopVariableInput" -> LoopNode_loopNode_loopVariableInput_InputPin ) :+
    ( "result" -> LoopNode_loopNode_result_OutputPin )

  // All parents: {Manifestation, Abstraction, Dependency, DirectedRelationship, PackageableElement, Relationship, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Manifestation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "mapping" -> Abstraction_abstraction_mapping_OpaqueExpression )

  // All parents: {MergeNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_MergeNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Message, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Message
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "argument" -> Message_message_argument_ValueSpecification )

  // All parents: {MessageOccurrenceSpecification, MessageEnd, OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_MessageOccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering )

  // All parents: {Model, Package, Namespace, PackageableElement, NamedElement, TemplateableElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Model
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "packageMerge" -> Package_receivingPackage_packageMerge_PackageMerge ) :+
    ( "packagedElement" -> Package_owningPackage_packagedElement_PackageableElement ) :+
    ( "profileApplication" -> Package_applyingPackage_profileApplication_ProfileApplication )

  // All parents: {Node, Class, DeploymentTarget, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Node
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "deployment" -> DeploymentTarget_location_deployment_Deployment ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception ) :+
    ( "nestedNode" -> Node_node_nestedNode_Node )

  // All parents: {ObjectFlow, ActivityEdge, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ObjectFlow
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "guard" -> ActivityEdge_activityEdge_guard_ValueSpecification ) :+
    ( "weight" -> ActivityEdge_activityEdge_weight_ValueSpecification )

  // All parents: {OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_OccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering )

  // All parents: {OpaqueAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_OpaqueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "inputValue" -> OpaqueAction_opaqueAction_inputValue_InputPin ) :+
    ( "outputValue" -> OpaqueAction_opaqueAction_outputValue_OutputPin )

  // All parents: {OpaqueBehavior, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_OpaqueBehavior
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception ) :+
    ( "ownedParameter" -> Behavior_behavior_ownedParameter_Parameter ) :+
    ( "ownedParameterSet" -> Behavior_behavior_ownedParameterSet_ParameterSet )

  // All parents: {OpaqueExpression, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_OpaqueExpression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Operation, BehavioralFeature, Feature, ParameterableElement, RedefinableElement, Namespace, TemplateableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Operation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "ownedParameter" -> BehavioralFeature_ownerFormalParam_ownedParameter_Parameter ) :+
    ( "ownedParameterSet" -> BehavioralFeature_behavioralFeature_ownedParameterSet_ParameterSet ) :+
    ( "ownedParameter" -> Operation_operation_ownedParameter_Parameter )

  // All parents: {OperationTemplateParameter, TemplateParameter, Element}
  lazy val metaclass_composite_updater_table_OperationTemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "ownedDefault" -> TemplateParameter_templateParameter_ownedDefault_ParameterableElement ) :+
    ( "ownedParameteredElement" -> TemplateParameter_owningTemplateParameter_ownedParameteredElement_ParameterableElement )

  // All parents: {OutputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_OutputPin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "upperBound" -> ObjectNode_objectNode_upperBound_ValueSpecification ) :+
    ( "lowerValue" -> MultiplicityElement_owningLower_lowerValue_ValueSpecification ) :+
    ( "upperValue" -> MultiplicityElement_owningUpper_upperValue_ValueSpecification )

  // All parents: {Package, Namespace, PackageableElement, NamedElement, TemplateableElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Package
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "packageMerge" -> Package_receivingPackage_packageMerge_PackageMerge ) :+
    ( "packagedElement" -> Package_owningPackage_packagedElement_PackageableElement ) :+
    ( "profileApplication" -> Package_applyingPackage_profileApplication_ProfileApplication )

  // All parents: {PackageImport, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_PackageImport
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment )

  // All parents: {PackageMerge, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_PackageMerge
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment )

  // All parents: {Parameter, ConnectableElement, ParameterableElement, MultiplicityElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Parameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "lowerValue" -> MultiplicityElement_owningLower_lowerValue_ValueSpecification ) :+
    ( "upperValue" -> MultiplicityElement_owningUpper_upperValue_ValueSpecification ) :+
    ( "defaultValue" -> Parameter_owningParameter_defaultValue_ValueSpecification )

  // All parents: {ParameterSet, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ParameterSet
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "condition" -> ParameterSet_parameterSet_condition_Constraint )

  // All parents: {PartDecomposition, InteractionUse, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_PartDecomposition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering ) :+
    ( "actualGate" -> InteractionUse_interactionUse_actualGate_Gate ) :+
    ( "argument" -> InteractionUse_interactionUse_argument_ValueSpecification ) :+
    ( "returnValue" -> InteractionUse_interactionUse_returnValue_ValueSpecification )

  // All parents: {Port, Property, ConnectableElement, DeploymentTarget, ParameterableElement, StructuralFeature, Feature, RedefinableElement, MultiplicityElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Port
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "lowerValue" -> MultiplicityElement_owningLower_lowerValue_ValueSpecification ) :+
    ( "upperValue" -> MultiplicityElement_owningUpper_upperValue_ValueSpecification ) :+
    ( "deployment" -> DeploymentTarget_location_deployment_Deployment ) :+
    ( "defaultValue" -> Property_owningProperty_defaultValue_ValueSpecification ) :+
    ( "qualifier" -> Property_associationEnd_qualifier_Property )

  // All parents: {PrimitiveType, DataType, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_PrimitiveType
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> DataType_datatype_ownedAttribute_Property ) :+
    ( "ownedOperation" -> DataType_datatype_ownedOperation_Operation )

  // All parents: {Profile, Package, Namespace, PackageableElement, NamedElement, TemplateableElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Profile
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "packageMerge" -> Package_receivingPackage_packageMerge_PackageMerge ) :+
    ( "packagedElement" -> Package_owningPackage_packagedElement_PackageableElement ) :+
    ( "profileApplication" -> Package_applyingPackage_profileApplication_ProfileApplication )

  // All parents: {ProfileApplication, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_ProfileApplication
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment )

  // All parents: {Property, ConnectableElement, ParameterableElement, DeploymentTarget, StructuralFeature, Feature, MultiplicityElement, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Property
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "lowerValue" -> MultiplicityElement_owningLower_lowerValue_ValueSpecification ) :+
    ( "upperValue" -> MultiplicityElement_owningUpper_upperValue_ValueSpecification ) :+
    ( "deployment" -> DeploymentTarget_location_deployment_Deployment ) :+
    ( "defaultValue" -> Property_owningProperty_defaultValue_ValueSpecification ) :+
    ( "qualifier" -> Property_associationEnd_qualifier_Property )

  // All parents: {ProtocolConformance, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_ProtocolConformance
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment )

  // All parents: {ProtocolStateMachine, StateMachine, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_ProtocolStateMachine
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception ) :+
    ( "ownedParameter" -> Behavior_behavior_ownedParameter_Parameter ) :+
    ( "ownedParameterSet" -> Behavior_behavior_ownedParameterSet_ParameterSet ) :+
    ( "connectionPoint" -> StateMachine_stateMachine_connectionPoint_Pseudostate ) :+
    ( "region" -> StateMachine_stateMachine_region_Region ) :+
    ( "conformance" -> ProtocolStateMachine_specificMachine_conformance_ProtocolConformance )

  // All parents: {ProtocolTransition, Transition, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ProtocolTransition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "effect" -> Transition_transition_effect_Behavior ) :+
    ( "trigger" -> Transition_transition_trigger_Trigger ) :+
    ( "preCondition" -> ProtocolTransition_protocolTransition_preCondition_Constraint )

  // All parents: {Pseudostate, Vertex, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Pseudostate
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {QualifierValue, Element}
  lazy val metaclass_composite_updater_table_QualifierValue
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment )

  // All parents: {RaiseExceptionAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_RaiseExceptionAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "exception" -> RaiseExceptionAction_raiseExceptionAction_exception_InputPin )

  // All parents: {ReadExtentAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadExtentAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "result" -> ReadExtentAction_readExtentAction_result_OutputPin )

  // All parents: {ReadIsClassifiedObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadIsClassifiedObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "object" -> ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_object_InputPin ) :+
    ( "result" -> ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_result_OutputPin )

  // All parents: {ReadLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadLinkAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "endData" -> LinkAction_linkAction_endData_LinkEndData ) :+
    ( "inputValue" -> LinkAction_linkAction_inputValue_InputPin ) :+
    ( "result" -> ReadLinkAction_readLinkAction_result_OutputPin )

  // All parents: {ReadLinkObjectEndAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadLinkObjectEndAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "object" -> ReadLinkObjectEndAction_readLinkObjectEndAction_object_InputPin ) :+
    ( "result" -> ReadLinkObjectEndAction_readLinkObjectEndAction_result_OutputPin )

  // All parents: {ReadLinkObjectEndQualifierAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadLinkObjectEndQualifierAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "object" -> ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_object_InputPin ) :+
    ( "result" -> ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_result_OutputPin )

  // All parents: {ReadSelfAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadSelfAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "result" -> ReadSelfAction_readSelfAction_result_OutputPin )

  // All parents: {ReadStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadStructuralFeatureAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "object" -> StructuralFeatureAction_structuralFeatureAction_object_InputPin ) :+
    ( "result" -> ReadStructuralFeatureAction_readStructuralFeatureAction_result_OutputPin )

  // All parents: {ReadVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReadVariableAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "result" -> ReadVariableAction_readVariableAction_result_OutputPin )

  // All parents: {Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Realization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "mapping" -> Abstraction_abstraction_mapping_OpaqueExpression )

  // All parents: {Reception, BehavioralFeature, Feature, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Reception
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "ownedParameter" -> BehavioralFeature_ownerFormalParam_ownedParameter_Parameter ) :+
    ( "ownedParameterSet" -> BehavioralFeature_behavioralFeature_ownedParameterSet_ParameterSet )

  // All parents: {ReclassifyObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReclassifyObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "object" -> ReclassifyObjectAction_reclassifyObjectAction_object_InputPin )

  // All parents: {RedefinableTemplateSignature, RedefinableElement, TemplateSignature, NamedElement, Element}
  lazy val metaclass_composite_updater_table_RedefinableTemplateSignature
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedParameter" -> TemplateSignature_signature_ownedParameter_TemplateParameter )

  // All parents: {ReduceAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReduceAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "collection" -> ReduceAction_reduceAction_collection_InputPin ) :+
    ( "result" -> ReduceAction_reduceAction_result_OutputPin )

  // All parents: {Region, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Region
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "subvertex" -> Region_container_subvertex_Vertex ) :+
    ( "transition" -> Region_container_transition_Transition )

  // All parents: {RemoveStructuralFeatureValueAction, WriteStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_RemoveStructuralFeatureValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "object" -> StructuralFeatureAction_structuralFeatureAction_object_InputPin ) :+
    ( "result" -> WriteStructuralFeatureAction_writeStructuralFeatureAction_result_OutputPin ) :+
    ( "value" -> WriteStructuralFeatureAction_writeStructuralFeatureAction_value_InputPin ) :+
    ( "removeAt" -> RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_removeAt_InputPin )

  // All parents: {RemoveVariableValueAction, WriteVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_RemoveVariableValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "value" -> WriteVariableAction_writeVariableAction_value_InputPin ) :+
    ( "removeAt" -> RemoveVariableValueAction_removeVariableValueAction_removeAt_InputPin )

  // All parents: {ReplyAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ReplyAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "replyValue" -> ReplyAction_replyAction_replyValue_InputPin ) :+
    ( "returnInformation" -> ReplyAction_replyAction_returnInformation_InputPin )

  // All parents: {SendObjectAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_SendObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "argument" -> InvocationAction_invocationAction_argument_InputPin ) :+
    ( "request" -> SendObjectAction_sendObjectAction_request_InputPin ) :+
    ( "target" -> SendObjectAction_sendObjectAction_target_InputPin )

  // All parents: {SendSignalAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_SendSignalAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "argument" -> InvocationAction_invocationAction_argument_InputPin ) :+
    ( "target" -> SendSignalAction_sendSignalAction_target_InputPin )

  // All parents: {SequenceNode, StructuredActivityNode, Action, ExecutableNode, ActivityGroup, ActivityNode, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_SequenceNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "edge" -> StructuredActivityNode_inStructuredNode_edge_ActivityEdge ) :+
    ( "node" -> StructuredActivityNode_inStructuredNode_node_ActivityNode ) :+
    ( "structuredNodeInput" -> StructuredActivityNode_structuredActivityNode_structuredNodeInput_InputPin ) :+
    ( "structuredNodeOutput" -> StructuredActivityNode_structuredActivityNode_structuredNodeOutput_OutputPin ) :+
    ( "variable" -> StructuredActivityNode_scope_variable_Variable ) :+
    ( "executableNode" -> SequenceNode_sequenceNode_executableNode_ExecutableNode )

  // All parents: {Signal, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Signal
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> Signal_owningSignal_ownedAttribute_Property )

  // All parents: {SignalEvent, MessageEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_SignalEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Slot, Element}
  lazy val metaclass_composite_updater_table_Slot
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "value" -> Slot_owningSlot_value_ValueSpecification )

  // All parents: {StartClassifierBehaviorAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_StartClassifierBehaviorAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "object" -> StartClassifierBehaviorAction_startClassifierBehaviorAction_object_InputPin )

  // All parents: {StartObjectBehaviorAction, CallAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_StartObjectBehaviorAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "argument" -> InvocationAction_invocationAction_argument_InputPin ) :+
    ( "result" -> CallAction_callAction_result_OutputPin ) :+
    ( "object" -> StartObjectBehaviorAction_startObjectBehaviorAction_object_InputPin )

  // All parents: {State, Namespace, RedefinableElement, Vertex, NamedElement, Element}
  lazy val metaclass_composite_updater_table_State
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "connection" -> State_state_connection_ConnectionPointReference ) :+
    ( "connectionPoint" -> State_state_connectionPoint_Pseudostate ) :+
    ( "deferrableTrigger" -> State_state_deferrableTrigger_Trigger ) :+
    ( "doActivity" -> State_state_doActivity_Behavior ) :+
    ( "entry" -> State_state_entry_Behavior ) :+
    ( "exit" -> State_state_exit_Behavior ) :+
    ( "region" -> State_state_region_Region )

  // All parents: {StateInvariant, InteractionFragment, NamedElement, Element}
  lazy val metaclass_composite_updater_table_StateInvariant
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "generalOrdering" -> InteractionFragment_interactionFragment_generalOrdering_GeneralOrdering ) :+
    ( "invariant" -> StateInvariant_stateInvariant_invariant_Constraint )

  // All parents: {StateMachine, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_StateMachine
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception ) :+
    ( "ownedParameter" -> Behavior_behavior_ownedParameter_Parameter ) :+
    ( "ownedParameterSet" -> Behavior_behavior_ownedParameterSet_ParameterSet ) :+
    ( "connectionPoint" -> StateMachine_stateMachine_connectionPoint_Pseudostate ) :+
    ( "region" -> StateMachine_stateMachine_region_Region )

  // All parents: {Stereotype, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Stereotype
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "ownedAttribute" -> StructuredClassifier_structuredClassifier_ownedAttribute_Property ) :+
    ( "ownedConnector" -> StructuredClassifier_structuredClassifier_ownedConnector_Connector ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "nestedClassifier" -> Class_nestingClass_nestedClassifier_Classifier ) :+
    ( "ownedAttribute" -> Class_class_ownedAttribute_Property ) :+
    ( "ownedOperation" -> Class_class_ownedOperation_Operation ) :+
    ( "ownedReception" -> Class_class_ownedReception_Reception ) :+
    ( "icon" -> Stereotype_stereotype_icon_Image )

  // All parents: {StringExpression, Expression, ValueSpecification, TemplateableElement, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_StringExpression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "operand" -> Expression_expression_operand_ValueSpecification ) :+
    ( "subExpression" -> StringExpression_owningExpression_subExpression_StringExpression )

  // All parents: {StructuredActivityNode, Action, ExecutableNode, ActivityGroup, ActivityNode, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_StructuredActivityNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "edge" -> StructuredActivityNode_inStructuredNode_edge_ActivityEdge ) :+
    ( "node" -> StructuredActivityNode_inStructuredNode_node_ActivityNode ) :+
    ( "structuredNodeInput" -> StructuredActivityNode_structuredActivityNode_structuredNodeInput_InputPin ) :+
    ( "structuredNodeOutput" -> StructuredActivityNode_structuredActivityNode_structuredNodeOutput_OutputPin ) :+
    ( "variable" -> StructuredActivityNode_scope_variable_Variable )

  // All parents: {Substitution, Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Substitution
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "mapping" -> Abstraction_abstraction_mapping_OpaqueExpression )

  // All parents: {TemplateBinding, DirectedRelationship, Relationship, Element}
  lazy val metaclass_composite_updater_table_TemplateBinding
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "parameterSubstitution" -> TemplateBinding_templateBinding_parameterSubstitution_TemplateParameterSubstitution )

  // All parents: {TemplateParameter, Element}
  lazy val metaclass_composite_updater_table_TemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "ownedDefault" -> TemplateParameter_templateParameter_ownedDefault_ParameterableElement ) :+
    ( "ownedParameteredElement" -> TemplateParameter_owningTemplateParameter_ownedParameteredElement_ParameterableElement )

  // All parents: {TemplateParameterSubstitution, Element}
  lazy val metaclass_composite_updater_table_TemplateParameterSubstitution
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "ownedActual" -> TemplateParameterSubstitution_owningTemplateParameterSubstitution_ownedActual_ParameterableElement )

  // All parents: {TemplateSignature, Element}
  lazy val metaclass_composite_updater_table_TemplateSignature
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "ownedParameter" -> TemplateSignature_signature_ownedParameter_TemplateParameter )

  // All parents: {TestIdentityAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_TestIdentityAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "first" -> TestIdentityAction_testIdentityAction_first_InputPin ) :+
    ( "result" -> TestIdentityAction_testIdentityAction_result_OutputPin ) :+
    ( "second" -> TestIdentityAction_testIdentityAction_second_InputPin )

  // All parents: {TimeConstraint, IntervalConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_TimeConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "specification" -> Constraint_owningConstraint_specification_ValueSpecification ) :+
    ( "specification" -> IntervalConstraint_intervalConstraint_specification_Interval ) :+
    ( "specification" -> TimeConstraint_timeConstraint_specification_TimeInterval )

  // All parents: {TimeEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_TimeEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "when" -> TimeEvent_timeEvent_when_TimeExpression )

  // All parents: {TimeExpression, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_TimeExpression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "expr" -> TimeExpression_timeExpression_expr_ValueSpecification )

  // All parents: {TimeInterval, Interval, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_TimeInterval
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {TimeObservation, Observation, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_TimeObservation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {Transition, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Transition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "effect" -> Transition_transition_effect_Behavior ) :+
    ( "trigger" -> Transition_transition_trigger_Trigger )

  // All parents: {Trigger, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Trigger
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {UnmarshallAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_UnmarshallAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "object" -> UnmarshallAction_unmarshallAction_object_InputPin ) :+
    ( "result" -> UnmarshallAction_unmarshallAction_result_OutputPin )

  // All parents: {Usage, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_Usage
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression )

  // All parents: {UseCase, BehavioredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_composite_updater_table_UseCase
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "ownedTemplateSignature" -> TemplateableElement_template_ownedTemplateSignature_TemplateSignature ) :+
    ( "templateBinding" -> TemplateableElement_boundElement_templateBinding_TemplateBinding ) :+
    ( "elementImport" -> Namespace_importingNamespace_elementImport_ElementImport ) :+
    ( "ownedDiagram" -> Namespace_diagramOwner_ownedDiagram_Diagram ) :+
    ( "ownedRule" -> Namespace_context_ownedRule_Constraint ) :+
    ( "packageImport" -> Namespace_importingNamespace_packageImport_PackageImport ) :+
    ( "collaborationUse" -> Classifier_classifier_collaborationUse_CollaborationUse ) :+
    ( "generalization" -> Classifier_specific_generalization_Generalization ) :+
    ( "ownedTemplateSignature" -> Classifier_classifier_ownedTemplateSignature_RedefinableTemplateSignature ) :+
    ( "ownedUseCase" -> Classifier_classifier_ownedUseCase_UseCase ) :+
    ( "substitution" -> Classifier_substitutingClassifier_substitution_Substitution ) :+
    ( "interfaceRealization" -> BehavioredClassifier_implementingClassifier_interfaceRealization_InterfaceRealization ) :+
    ( "ownedBehavior" -> BehavioredClassifier_behavioredClassifier_ownedBehavior_Behavior ) :+
    ( "extend" -> UseCase_extension_extend_Extend ) :+
    ( "extensionPoint" -> UseCase_useCase_extensionPoint_ExtensionPoint ) :+
    ( "include" -> UseCase_includingCase_include_Include )

  // All parents: {ValuePin, InputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ValuePin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "upperBound" -> ObjectNode_objectNode_upperBound_ValueSpecification ) :+
    ( "lowerValue" -> MultiplicityElement_owningLower_lowerValue_ValueSpecification ) :+
    ( "upperValue" -> MultiplicityElement_owningUpper_upperValue_ValueSpecification ) :+
    ( "value" -> ValuePin_valuePin_value_ValueSpecification )

  // All parents: {ValueSpecificationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_ValueSpecificationAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "handler" -> ExecutableNode_protectedNode_handler_ExceptionHandler ) :+
    ( "localPostcondition" -> Action_action_localPostcondition_Constraint ) :+
    ( "localPrecondition" -> Action_action_localPrecondition_Constraint ) :+
    ( "result" -> ValueSpecificationAction_valueSpecificationAction_result_OutputPin ) :+
    ( "value" -> ValueSpecificationAction_valueSpecificationAction_value_ValueSpecification )

  // All parents: {Variable, ConnectableElement, MultiplicityElement, ParameterableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_composite_updater_table_Variable
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "ownedComment" -> Element_owningElement_ownedComment_Comment ) :+
    ( "nameExpression" -> NamedElement_namedElement_nameExpression_StringExpression ) :+
    ( "lowerValue" -> MultiplicityElement_owningLower_lowerValue_ValueSpecification ) :+
    ( "upperValue" -> MultiplicityElement_owningUpper_upperValue_ValueSpecification )

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
   ("Diagram" -> metaclass_reference_updater_table_Diagram) +
   ("Duration" -> metaclass_reference_updater_table_Duration) +
   ("DurationConstraint" -> metaclass_reference_updater_table_DurationConstraint) +
   ("DurationInterval" -> metaclass_reference_updater_table_DurationInterval) +
   ("DurationObservation" -> metaclass_reference_updater_table_DurationObservation) +
   ("ElementImport" -> metaclass_reference_updater_table_ElementImport) +
   ("ElementValue" -> metaclass_reference_updater_table_ElementValue) +
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
    ( "client" -> Dependency_clientDependency_client_NamedElement ) :+
    ( "supplier" -> Dependency_supplierDependency_supplier_NamedElement ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {AcceptCallAction, AcceptEventAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_AcceptCallAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {AcceptEventAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_AcceptEventAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ActionExecutionSpecification, ExecutionSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ActionExecutionSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "action" -> ActionExecutionSpecification_actionExecutionSpecification_action_Action ) :+
    ( "finish" -> ExecutionSpecification_executionSpecification_finish_OccurrenceSpecification ) :+
    ( "start" -> ExecutionSpecification_executionSpecification_start_OccurrenceSpecification ) :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {ActionInputPin, InputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ActionInputPin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inState" -> ObjectNode_objectNode_inState_State ) :+
    ( "selection" -> ObjectNode_objectNode_selection_Behavior ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // All parents: {Activity, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Activity
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "partition" -> Activity_activity_partition_ActivityPartition ) :+
    ( "structuredNode" -> Activity_activity_structuredNode_StructuredActivityNode ) :+
    ( "postcondition" -> Behavior_behavior_postcondition_Constraint ) :+
    ( "precondition" -> Behavior_behavior_precondition_Constraint ) :+
    ( "redefinedBehavior" -> Behavior_behavior_redefinedBehavior_Behavior ) :+
    ( "specification" -> Behavior_method_specification_BehavioralFeature ) :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {ActivityFinalNode, FinalNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ActivityFinalNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ActivityParameterNode, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ActivityParameterNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "parameter" -> ActivityParameterNode_activityParameterNode_parameter_Parameter ) :+
    ( "inState" -> ObjectNode_objectNode_inState_State ) :+
    ( "selection" -> ObjectNode_objectNode_selection_Behavior ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // All parents: {ActivityPartition, ActivityGroup, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ActivityPartition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "edge" -> ActivityPartition_inPartition_edge_ActivityEdge ) :+
    ( "node" -> ActivityPartition_inPartition_node_ActivityNode ) :+
    ( "represents" -> ActivityPartition_activityPartition_represents_Element )

  // All parents: {Actor, BehavioredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Actor
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {AddStructuralFeatureValueAction, WriteStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_AddStructuralFeatureValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "structuralFeature" -> StructuralFeatureAction_structuralFeatureAction_structuralFeature_StructuralFeature ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {AddVariableValueAction, WriteVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_AddVariableValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "variable" -> VariableAction_variableAction_variable_Variable ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {AnyReceiveEvent, MessageEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_AnyReceiveEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Artifact, Classifier, DeployedArtifact, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Artifact
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Association, Classifier, Relationship, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Association
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "memberEnd" -> Association_association_memberEnd_Property ) :+
    ( "navigableOwnedEnd" -> Association_association_navigableOwnedEnd_Property ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {AssociationClass, Association, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, Relationship, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_AssociationClass
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "memberEnd" -> Association_association_memberEnd_Property ) :+
    ( "navigableOwnedEnd" -> Association_association_navigableOwnedEnd_Property ) :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {BehaviorExecutionSpecification, ExecutionSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_BehaviorExecutionSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "behavior" -> BehaviorExecutionSpecification_behaviorExecutionSpecification_behavior_Behavior ) :+
    ( "finish" -> ExecutionSpecification_executionSpecification_finish_OccurrenceSpecification ) :+
    ( "start" -> ExecutionSpecification_executionSpecification_start_OccurrenceSpecification ) :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {BroadcastSignalAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_BroadcastSignalAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "signal" -> BroadcastSignalAction_broadcastSignalAction_signal_Signal ) :+
    ( "onPort" -> InvocationAction_invocationAction_onPort_Port ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {CallBehaviorAction, CallAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CallBehaviorAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "behavior" -> CallBehaviorAction_callBehaviorAction_behavior_Behavior ) :+
    ( "onPort" -> InvocationAction_invocationAction_onPort_Port ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {CallEvent, MessageEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_CallEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "operation" -> CallEvent_callEvent_operation_Operation ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {CallOperationAction, CallAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CallOperationAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "operation" -> CallOperationAction_callOperationAction_operation_Operation ) :+
    ( "onPort" -> InvocationAction_invocationAction_onPort_Port ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {CentralBufferNode, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CentralBufferNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inState" -> ObjectNode_objectNode_inState_State ) :+
    ( "selection" -> ObjectNode_objectNode_selection_Behavior ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // All parents: {ChangeEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_ChangeEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Class
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {ClassifierTemplateParameter, TemplateParameter, Element}
  lazy val metaclass_reference_updater_table_ClassifierTemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "constrainingClassifier" -> ClassifierTemplateParameter_classifierTemplateParameter_constrainingClassifier_Classifier ) :+
    ( "parameteredElement" -> ClassifierTemplateParameter_templateParameter_parameteredElement_Classifier ) :+
    ( "default" -> TemplateParameter_templateParameter_default_ParameterableElement ) :+
    ( "parameteredElement" -> TemplateParameter_templateParameter_parameteredElement_ParameterableElement )

  // All parents: {Clause, Element}
  lazy val metaclass_reference_updater_table_Clause
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "body" -> Clause_clause_body_ExecutableNode ) :+
    ( "bodyOutput" -> Clause_clause_bodyOutput_OutputPin ) :+
    ( "decider" -> Clause_clause_decider_OutputPin ) :+
    ( "predecessorClause" -> Clause_successorClause_predecessorClause_Clause ) :+
    ( "successorClause" -> Clause_predecessorClause_successorClause_Clause ) :+
    ( "test" -> Clause_clause_test_ExecutableNode )

  // All parents: {ClearAssociationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ClearAssociationAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "association" -> ClearAssociationAction_clearAssociationAction_association_Association ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ClearStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ClearStructuralFeatureAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "structuralFeature" -> StructuralFeatureAction_structuralFeatureAction_structuralFeature_StructuralFeature ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ClearVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ClearVariableAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "variable" -> VariableAction_variableAction_variable_Variable ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {Collaboration, BehavioredClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Collaboration
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "collaborationRole" -> Collaboration_collaboration_collaborationRole_ConnectableElement ) :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {CollaborationUse, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CollaborationUse
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "type" -> CollaborationUse_collaborationUse_type_Collaboration )

  // All parents: {CombinedFragment, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CombinedFragment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {Comment, Element}
  lazy val metaclass_reference_updater_table_Comment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "annotatedElement" -> Comment_comment_annotatedElement_Element )

  // All parents: {CommunicationPath, Association, Classifier, Relationship, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_CommunicationPath
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "memberEnd" -> Association_association_memberEnd_Property ) :+
    ( "navigableOwnedEnd" -> Association_association_navigableOwnedEnd_Property ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Component, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Component
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {ComponentRealization, Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_ComponentRealization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "realizingClassifier" -> ComponentRealization_componentRealization_realizingClassifier_Classifier ) :+
    ( "client" -> Dependency_clientDependency_client_NamedElement ) :+
    ( "supplier" -> Dependency_supplierDependency_supplier_NamedElement ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {ConditionalNode, StructuredActivityNode, Action, ActivityGroup, ExecutableNode, Namespace, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ConditionalNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ConnectableElementTemplateParameter, TemplateParameter, Element}
  lazy val metaclass_reference_updater_table_ConnectableElementTemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "parameteredElement" -> ConnectableElementTemplateParameter_templateParameter_parameteredElement_ConnectableElement ) :+
    ( "default" -> TemplateParameter_templateParameter_default_ParameterableElement ) :+
    ( "parameteredElement" -> TemplateParameter_templateParameter_parameteredElement_ParameterableElement )

  // All parents: {ConnectionPointReference, Vertex, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ConnectionPointReference
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "entry" -> ConnectionPointReference_connectionPointReference_entry_Pseudostate ) :+
    ( "exit" -> ConnectionPointReference_connectionPointReference_exit_Pseudostate )

  // All parents: {Connector, Feature, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Connector
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "contract" -> Connector_connector_contract_Behavior ) :+
    ( "redefinedConnector" -> Connector_connector_redefinedConnector_Connector ) :+
    ( "type" -> Connector_connector_type_Association )

  // All parents: {ConnectorEnd, MultiplicityElement, Element}
  lazy val metaclass_reference_updater_table_ConnectorEnd
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "partWithPort" -> ConnectorEnd_connectorEnd_partWithPort_Property ) :+
    ( "role" -> ConnectorEnd_end_role_ConnectableElement )

  // All parents: {ConsiderIgnoreFragment, CombinedFragment, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ConsiderIgnoreFragment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "message" -> ConsiderIgnoreFragment_considerIgnoreFragment_message_NamedElement ) :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Constraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "constrainedElement" -> Constraint_constraint_constrainedElement_Element ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Continuation, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Continuation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {ControlFlow, ActivityEdge, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ControlFlow
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inPartition" -> ActivityEdge_edge_inPartition_ActivityPartition ) :+
    ( "interrupts" -> ActivityEdge_interruptingEdge_interrupts_InterruptibleActivityRegion ) :+
    ( "redefinedEdge" -> ActivityEdge_activityEdge_redefinedEdge_ActivityEdge ) :+
    ( "source" -> ActivityEdge_outgoing_source_ActivityNode ) :+
    ( "target" -> ActivityEdge_incoming_target_ActivityNode )

  // All parents: {CreateLinkAction, WriteLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CreateLinkAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {CreateLinkObjectAction, CreateLinkAction, WriteLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CreateLinkObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {CreateObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_CreateObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "classifier" -> CreateObjectAction_createObjectAction_classifier_Classifier ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {DataStoreNode, CentralBufferNode, ObjectNode, ActivityNode, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_DataStoreNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inState" -> ObjectNode_objectNode_inState_State ) :+
    ( "selection" -> ObjectNode_objectNode_selection_Behavior ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // All parents: {DataType, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_DataType
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {DecisionNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_DecisionNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "decisionInput" -> DecisionNode_decisionNode_decisionInput_Behavior ) :+
    ( "decisionInputFlow" -> DecisionNode_decisionNode_decisionInputFlow_ObjectFlow ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {Dependency, DirectedRelationship, PackageableElement, Relationship, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Dependency
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "client" -> Dependency_clientDependency_client_NamedElement ) :+
    ( "supplier" -> Dependency_supplierDependency_supplier_NamedElement ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Deployment, Dependency, DirectedRelationship, PackageableElement, Relationship, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Deployment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "deployedArtifact" -> Deployment_deploymentForArtifact_deployedArtifact_DeployedArtifact ) :+
    ( "client" -> Dependency_clientDependency_client_NamedElement ) :+
    ( "supplier" -> Dependency_supplierDependency_supplier_NamedElement ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {DeploymentSpecification, Artifact, Classifier, Namespace, DeployedArtifact, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_DeploymentSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {DestroyLinkAction, WriteLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_DestroyLinkAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {DestroyObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_DestroyObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {DestructionOccurrenceSpecification, MessageOccurrenceSpecification, MessageEnd, OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_DestructionOccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "message" -> MessageEnd_messageEnd_message_Message ) :+
    ( "covered" -> OccurrenceSpecification_events_covered_Lifeline ) :+
    ( "toAfter" -> OccurrenceSpecification_before_toAfter_GeneralOrdering ) :+
    ( "toBefore" -> OccurrenceSpecification_after_toBefore_GeneralOrdering ) :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {Device, Node, Class, BehavioredClassifier, DeploymentTarget, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Device
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Diagram, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Diagram
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "context" -> Diagram_diagram_context_Element )

  // All parents: {Duration, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Duration
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "observation" -> Duration_duration_observation_Observation ) :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {DurationConstraint, IntervalConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_DurationConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "constrainedElement" -> Constraint_constraint_constrainedElement_Element ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {DurationInterval, Interval, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_DurationInterval
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "max" -> DurationInterval_durationInterval_max_Duration ) :+
    ( "min" -> DurationInterval_durationInterval_min_Duration ) :+
    ( "max" -> Interval_interval_max_ValueSpecification ) :+
    ( "min" -> Interval_interval_min_ValueSpecification ) :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {DurationObservation, Observation, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_DurationObservation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "event" -> DurationObservation_durationObservation_event_NamedElement ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {ElementImport, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_ElementImport
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "importedElement" -> ElementImport_import_importedElement_PackageableElement )

  // All parents: {ElementValue, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_ElementValue
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "element" -> ElementValue_elementValue_element_Element ) :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Enumeration, DataType, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Enumeration
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {EnumerationLiteral, InstanceSpecification, DeployedArtifact, DeploymentTarget, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_EnumerationLiteral
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "classifier" -> InstanceSpecification_instanceSpecification_classifier_Classifier ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {ExceptionHandler, Element}
  lazy val metaclass_reference_updater_table_ExceptionHandler
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "exceptionInput" -> ExceptionHandler_exceptionHandler_exceptionInput_ObjectNode ) :+
    ( "exceptionType" -> ExceptionHandler_exceptionHandler_exceptionType_Classifier ) :+
    ( "handlerBody" -> ExceptionHandler_exceptionHandler_handlerBody_ExecutableNode )

  // All parents: {ExecutionEnvironment, Node, Class, BehavioredClassifier, DeploymentTarget, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_ExecutionEnvironment
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {ExecutionOccurrenceSpecification, OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ExecutionOccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "execution" -> ExecutionOccurrenceSpecification_executionOccurrenceSpecification_execution_ExecutionSpecification ) :+
    ( "covered" -> OccurrenceSpecification_events_covered_Lifeline ) :+
    ( "toAfter" -> OccurrenceSpecification_before_toAfter_GeneralOrdering ) :+
    ( "toBefore" -> OccurrenceSpecification_after_toBefore_GeneralOrdering ) :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {ExpansionNode, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ExpansionNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "regionAsInput" -> ExpansionNode_inputElement_regionAsInput_ExpansionRegion ) :+
    ( "regionAsOutput" -> ExpansionNode_outputElement_regionAsOutput_ExpansionRegion ) :+
    ( "inState" -> ObjectNode_objectNode_inState_State ) :+
    ( "selection" -> ObjectNode_objectNode_selection_Behavior ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // All parents: {ExpansionRegion, StructuredActivityNode, Action, ExecutableNode, ActivityGroup, ActivityNode, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ExpansionRegion
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inputElement" -> ExpansionRegion_regionAsInput_inputElement_ExpansionNode ) :+
    ( "outputElement" -> ExpansionRegion_regionAsOutput_outputElement_ExpansionNode ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {Expression, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Expression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Extend, DirectedRelationship, Relationship, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Extend
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "extendedCase" -> Extend_extend_extendedCase_UseCase ) :+
    ( "extensionLocation" -> Extend_extension_extensionLocation_ExtensionPoint )

  // All parents: {Extension, Association, Classifier, Relationship, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Extension
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "memberEnd" -> Association_association_memberEnd_Property ) :+
    ( "navigableOwnedEnd" -> Association_association_navigableOwnedEnd_Property ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {ExtensionEnd, Property, ConnectableElement, DeploymentTarget, ParameterableElement, StructuralFeature, Feature, MultiplicityElement, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ExtensionEnd
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "type" -> ExtensionEnd_extensionEnd_type_Stereotype ) :+
    ( "association" -> Property_memberEnd_association_Association ) :+
    ( "redefinedProperty" -> Property_property_redefinedProperty_Property ) :+
    ( "subsettedProperty" -> Property_property_subsettedProperty_Property ) :+
    ( "templateParameter" -> ConnectableElement_parameteredElement_templateParameter_ConnectableElementTemplateParameter ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // All parents: {ExtensionPoint, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ExtensionPoint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]()

  // All parents: {FinalState, State, Namespace, RedefinableElement, Vertex, NamedElement, Element}
  lazy val metaclass_reference_updater_table_FinalState
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "redefinedState" -> State_state_redefinedState_State ) :+
    ( "stateInvariant" -> State_owningState_stateInvariant_Constraint ) :+
    ( "submachine" -> State_submachineState_submachine_StateMachine )

  // All parents: {FlowFinalNode, FinalNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_FlowFinalNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ForkNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ForkNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {FunctionBehavior, OpaqueBehavior, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_FunctionBehavior
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "postcondition" -> Behavior_behavior_postcondition_Constraint ) :+
    ( "precondition" -> Behavior_behavior_precondition_Constraint ) :+
    ( "redefinedBehavior" -> Behavior_behavior_redefinedBehavior_Behavior ) :+
    ( "specification" -> Behavior_method_specification_BehavioralFeature ) :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Gate, MessageEnd, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Gate
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "message" -> MessageEnd_messageEnd_message_Message )

  // All parents: {GeneralOrdering, NamedElement, Element}
  lazy val metaclass_reference_updater_table_GeneralOrdering
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "after" -> GeneralOrdering_toBefore_after_OccurrenceSpecification ) :+
    ( "before" -> GeneralOrdering_toAfter_before_OccurrenceSpecification )

  // All parents: {Generalization, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_Generalization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "general" -> Generalization_generalization_general_Classifier ) :+
    ( "generalizationSet" -> Generalization_generalization_generalizationSet_GeneralizationSet )

  // All parents: {GeneralizationSet, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_GeneralizationSet
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "generalization" -> GeneralizationSet_generalizationSet_generalization_Generalization ) :+
    ( "powertype" -> GeneralizationSet_powertypeExtent_powertype_Classifier ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Image, Element}
  lazy val metaclass_reference_updater_table_Image
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]()

  // All parents: {Include, DirectedRelationship, NamedElement, Relationship, Element}
  lazy val metaclass_reference_updater_table_Include
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "addition" -> Include_include_addition_UseCase )

  // All parents: {InformationFlow, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_InformationFlow
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "conveyed" -> InformationFlow_conveyingFlow_conveyed_Classifier ) :+
    ( "informationSource" -> InformationFlow_informationFlow_informationSource_NamedElement ) :+
    ( "informationTarget" -> InformationFlow_informationFlow_informationTarget_NamedElement ) :+
    ( "realization" -> InformationFlow_abstraction_realization_Relationship ) :+
    ( "realizingActivityEdge" -> InformationFlow_informationFlow_realizingActivityEdge_ActivityEdge ) :+
    ( "realizingConnector" -> InformationFlow_informationFlow_realizingConnector_Connector ) :+
    ( "realizingMessage" -> InformationFlow_informationFlow_realizingMessage_Message ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {InformationItem, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_InformationItem
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "represented" -> InformationItem_representation_represented_Classifier ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {InitialNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_InitialNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {InputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_InputPin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inState" -> ObjectNode_objectNode_inState_State ) :+
    ( "selection" -> ObjectNode_objectNode_selection_Behavior ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // All parents: {InstanceSpecification, DeployedArtifact, DeploymentTarget, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_InstanceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "classifier" -> InstanceSpecification_instanceSpecification_classifier_Classifier ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {InstanceValue, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_InstanceValue
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "instance" -> InstanceValue_instanceValue_instance_InstanceSpecification ) :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Interaction, Behavior, Class, InteractionFragment, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Interaction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "postcondition" -> Behavior_behavior_postcondition_Constraint ) :+
    ( "precondition" -> Behavior_behavior_precondition_Constraint ) :+
    ( "redefinedBehavior" -> Behavior_behavior_redefinedBehavior_Behavior ) :+
    ( "specification" -> Behavior_method_specification_BehavioralFeature ) :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline ) :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {InteractionConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_InteractionConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "constrainedElement" -> Constraint_constraint_constrainedElement_Element ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {InteractionOperand, InteractionFragment, Namespace, NamedElement, Element}
  lazy val metaclass_reference_updater_table_InteractionOperand
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {InteractionUse, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_InteractionUse
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "refersTo" -> InteractionUse_interactionUse_refersTo_Interaction ) :+
    ( "returnValueRecipient" -> InteractionUse_interactionUse_returnValueRecipient_Property ) :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {Interface, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Interface
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "redefinedInterface" -> Interface_interface_redefinedInterface_Interface ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {InterfaceRealization, Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_InterfaceRealization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "contract" -> InterfaceRealization_interfaceRealization_contract_Interface ) :+
    ( "client" -> Dependency_clientDependency_client_NamedElement ) :+
    ( "supplier" -> Dependency_supplierDependency_supplier_NamedElement ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {InterruptibleActivityRegion, ActivityGroup, NamedElement, Element}
  lazy val metaclass_reference_updater_table_InterruptibleActivityRegion
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "interruptingEdge" -> InterruptibleActivityRegion_interrupts_interruptingEdge_ActivityEdge ) :+
    ( "node" -> InterruptibleActivityRegion_inInterruptibleRegion_node_ActivityNode )

  // All parents: {Interval, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Interval
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "max" -> Interval_interval_max_ValueSpecification ) :+
    ( "min" -> Interval_interval_min_ValueSpecification ) :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {IntervalConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_IntervalConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "constrainedElement" -> Constraint_constraint_constrainedElement_Element ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {JoinNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_JoinNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {Lifeline, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Lifeline
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "coveredBy" -> Lifeline_covered_coveredBy_InteractionFragment ) :+
    ( "decomposedAs" -> Lifeline_lifeline_decomposedAs_PartDecomposition ) :+
    ( "represents" -> Lifeline_lifeline_represents_ConnectableElement )

  // All parents: {LinkEndCreationData, LinkEndData, Element}
  lazy val metaclass_reference_updater_table_LinkEndCreationData
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "insertAt" -> LinkEndCreationData_linkEndCreationData_insertAt_InputPin ) :+
    ( "end" -> LinkEndData_linkEndData_end_Property ) :+
    ( "value" -> LinkEndData_linkEndData_value_InputPin )

  // All parents: {LinkEndData, Element}
  lazy val metaclass_reference_updater_table_LinkEndData
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "end" -> LinkEndData_linkEndData_end_Property ) :+
    ( "value" -> LinkEndData_linkEndData_value_InputPin )

  // All parents: {LinkEndDestructionData, LinkEndData, Element}
  lazy val metaclass_reference_updater_table_LinkEndDestructionData
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "destroyAt" -> LinkEndDestructionData_linkEndDestructionData_destroyAt_InputPin ) :+
    ( "end" -> LinkEndData_linkEndData_end_Property ) :+
    ( "value" -> LinkEndData_linkEndData_value_InputPin )

  // All parents: {LiteralBoolean, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_LiteralBoolean
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {LiteralInteger, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_LiteralInteger
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {LiteralNull, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_LiteralNull
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {LiteralReal, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_LiteralReal
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {LiteralString, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_LiteralString
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {LiteralUnlimitedNatural, LiteralSpecification, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_LiteralUnlimitedNatural
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {LoopNode, StructuredActivityNode, Action, ExecutableNode, ActivityGroup, ActivityNode, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_LoopNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "bodyOutput" -> LoopNode_loopNode_bodyOutput_OutputPin ) :+
    ( "bodyPart" -> LoopNode_loopNode_bodyPart_ExecutableNode ) :+
    ( "decider" -> LoopNode_loopNode_decider_OutputPin ) :+
    ( "setupPart" -> LoopNode_loopNode_setupPart_ExecutableNode ) :+
    ( "test" -> LoopNode_loopNode_test_ExecutableNode ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {Manifestation, Abstraction, Dependency, DirectedRelationship, PackageableElement, Relationship, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Manifestation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "utilizedElement" -> Manifestation_manifestation_utilizedElement_PackageableElement ) :+
    ( "client" -> Dependency_clientDependency_client_NamedElement ) :+
    ( "supplier" -> Dependency_supplierDependency_supplier_NamedElement ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {MergeNode, ControlNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_MergeNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {Message, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Message
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "connector" -> Message_message_connector_Connector ) :+
    ( "receiveEvent" -> Message_endMessage_receiveEvent_MessageEnd ) :+
    ( "sendEvent" -> Message_endMessage_sendEvent_MessageEnd ) :+
    ( "signature" -> Message_message_signature_NamedElement )

  // All parents: {MessageOccurrenceSpecification, MessageEnd, OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_MessageOccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "message" -> MessageEnd_messageEnd_message_Message ) :+
    ( "covered" -> OccurrenceSpecification_events_covered_Lifeline ) :+
    ( "toAfter" -> OccurrenceSpecification_before_toAfter_GeneralOrdering ) :+
    ( "toBefore" -> OccurrenceSpecification_after_toBefore_GeneralOrdering ) :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {Model, Package, Namespace, PackageableElement, NamedElement, TemplateableElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Model
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Node, Class, DeploymentTarget, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Node
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {ObjectFlow, ActivityEdge, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ObjectFlow
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "selection" -> ObjectFlow_objectFlow_selection_Behavior ) :+
    ( "transformation" -> ObjectFlow_objectFlow_transformation_Behavior ) :+
    ( "inPartition" -> ActivityEdge_edge_inPartition_ActivityPartition ) :+
    ( "interrupts" -> ActivityEdge_interruptingEdge_interrupts_InterruptibleActivityRegion ) :+
    ( "redefinedEdge" -> ActivityEdge_activityEdge_redefinedEdge_ActivityEdge ) :+
    ( "source" -> ActivityEdge_outgoing_source_ActivityNode ) :+
    ( "target" -> ActivityEdge_incoming_target_ActivityNode )

  // All parents: {OccurrenceSpecification, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_OccurrenceSpecification
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "covered" -> OccurrenceSpecification_events_covered_Lifeline ) :+
    ( "toAfter" -> OccurrenceSpecification_before_toAfter_GeneralOrdering ) :+
    ( "toBefore" -> OccurrenceSpecification_after_toBefore_GeneralOrdering ) :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {OpaqueAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_OpaqueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {OpaqueBehavior, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_OpaqueBehavior
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "postcondition" -> Behavior_behavior_postcondition_Constraint ) :+
    ( "precondition" -> Behavior_behavior_precondition_Constraint ) :+
    ( "redefinedBehavior" -> Behavior_behavior_redefinedBehavior_Behavior ) :+
    ( "specification" -> Behavior_method_specification_BehavioralFeature ) :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {OpaqueExpression, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_OpaqueExpression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "behavior" -> OpaqueExpression_opaqueExpression_behavior_Behavior ) :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Operation, BehavioralFeature, Feature, ParameterableElement, RedefinableElement, Namespace, TemplateableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Operation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "bodyCondition" -> Operation_bodyContext_bodyCondition_Constraint ) :+
    ( "postcondition" -> Operation_postContext_postcondition_Constraint ) :+
    ( "precondition" -> Operation_preContext_precondition_Constraint ) :+
    ( "raisedException" -> Operation_operation_raisedException_Type ) :+
    ( "redefinedOperation" -> Operation_operation_redefinedOperation_Operation ) :+
    ( "templateParameter" -> Operation_parameteredElement_templateParameter_OperationTemplateParameter ) :+
    ( "method" -> BehavioralFeature_specification_method_Behavior ) :+
    ( "raisedException" -> BehavioralFeature_behavioralFeature_raisedException_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {OperationTemplateParameter, TemplateParameter, Element}
  lazy val metaclass_reference_updater_table_OperationTemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "parameteredElement" -> OperationTemplateParameter_templateParameter_parameteredElement_Operation ) :+
    ( "default" -> TemplateParameter_templateParameter_default_ParameterableElement ) :+
    ( "parameteredElement" -> TemplateParameter_templateParameter_parameteredElement_ParameterableElement )

  // All parents: {OutputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_OutputPin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inState" -> ObjectNode_objectNode_inState_State ) :+
    ( "selection" -> ObjectNode_objectNode_selection_Behavior ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // All parents: {Package, Namespace, PackageableElement, NamedElement, TemplateableElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Package
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {PackageImport, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_PackageImport
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "importedPackage" -> PackageImport_packageImport_importedPackage_Package )

  // All parents: {PackageMerge, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_PackageMerge
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "mergedPackage" -> PackageMerge_packageMerge_mergedPackage_Package )

  // All parents: {Parameter, ConnectableElement, ParameterableElement, MultiplicityElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Parameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "parameterSet" -> Parameter_parameter_parameterSet_ParameterSet ) :+
    ( "templateParameter" -> ConnectableElement_parameteredElement_templateParameter_ConnectableElementTemplateParameter ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // All parents: {ParameterSet, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ParameterSet
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "parameter" -> ParameterSet_parameterSet_parameter_Parameter )

  // All parents: {PartDecomposition, InteractionUse, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_PartDecomposition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "refersTo" -> InteractionUse_interactionUse_refersTo_Interaction ) :+
    ( "returnValueRecipient" -> InteractionUse_interactionUse_returnValueRecipient_Property ) :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {Port, Property, ConnectableElement, DeploymentTarget, ParameterableElement, StructuralFeature, Feature, RedefinableElement, MultiplicityElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Port
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "protocol" -> Port_port_protocol_ProtocolStateMachine ) :+
    ( "redefinedPort" -> Port_port_redefinedPort_Port ) :+
    ( "association" -> Property_memberEnd_association_Association ) :+
    ( "redefinedProperty" -> Property_property_redefinedProperty_Property ) :+
    ( "subsettedProperty" -> Property_property_subsettedProperty_Property ) :+
    ( "templateParameter" -> ConnectableElement_parameteredElement_templateParameter_ConnectableElementTemplateParameter ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // All parents: {PrimitiveType, DataType, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_PrimitiveType
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Profile, Package, Namespace, PackageableElement, NamedElement, TemplateableElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Profile
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "metaclassReference" -> Profile_profile_metaclassReference_ElementImport ) :+
    ( "metamodelReference" -> Profile_profile_metamodelReference_PackageImport ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {ProfileApplication, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_ProfileApplication
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "appliedProfile" -> ProfileApplication_profileApplication_appliedProfile_Profile )

  // All parents: {Property, ConnectableElement, ParameterableElement, DeploymentTarget, StructuralFeature, Feature, MultiplicityElement, RedefinableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Property
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "association" -> Property_memberEnd_association_Association ) :+
    ( "redefinedProperty" -> Property_property_redefinedProperty_Property ) :+
    ( "subsettedProperty" -> Property_property_subsettedProperty_Property ) :+
    ( "templateParameter" -> ConnectableElement_parameteredElement_templateParameter_ConnectableElementTemplateParameter ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // All parents: {ProtocolConformance, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_ProtocolConformance
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "generalMachine" -> ProtocolConformance_protocolConformance_generalMachine_ProtocolStateMachine )

  // All parents: {ProtocolStateMachine, StateMachine, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_ProtocolStateMachine
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "extendedStateMachine" -> StateMachine_stateMachine_extendedStateMachine_StateMachine ) :+
    ( "submachineState" -> StateMachine_submachine_submachineState_State ) :+
    ( "postcondition" -> Behavior_behavior_postcondition_Constraint ) :+
    ( "precondition" -> Behavior_behavior_precondition_Constraint ) :+
    ( "redefinedBehavior" -> Behavior_behavior_redefinedBehavior_Behavior ) :+
    ( "specification" -> Behavior_method_specification_BehavioralFeature ) :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {ProtocolTransition, Transition, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ProtocolTransition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "postCondition" -> ProtocolTransition_owningTransition_postCondition_Constraint ) :+
    ( "guard" -> Transition_transition_guard_Constraint ) :+
    ( "redefinedTransition" -> Transition_transition_redefinedTransition_Transition ) :+
    ( "source" -> Transition_outgoing_source_Vertex ) :+
    ( "target" -> Transition_incoming_target_Vertex )

  // All parents: {Pseudostate, Vertex, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Pseudostate
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]()

  // All parents: {QualifierValue, Element}
  lazy val metaclass_reference_updater_table_QualifierValue
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "qualifier" -> QualifierValue_qualifierValue_qualifier_Property ) :+
    ( "value" -> QualifierValue_qualifierValue_value_InputPin )

  // All parents: {RaiseExceptionAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_RaiseExceptionAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ReadExtentAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadExtentAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "classifier" -> ReadExtentAction_readExtentAction_classifier_Classifier ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ReadIsClassifiedObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadIsClassifiedObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "classifier" -> ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_classifier_Classifier ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ReadLinkAction, LinkAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadLinkAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ReadLinkObjectEndAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadLinkObjectEndAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "end" -> ReadLinkObjectEndAction_readLinkObjectEndAction_end_Property ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ReadLinkObjectEndQualifierAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadLinkObjectEndQualifierAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "qualifier" -> ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_qualifier_Property ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ReadSelfAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadSelfAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ReadStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadStructuralFeatureAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "structuralFeature" -> StructuralFeatureAction_structuralFeatureAction_structuralFeature_StructuralFeature ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ReadVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReadVariableAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "variable" -> VariableAction_variableAction_variable_Variable ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Realization
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "client" -> Dependency_clientDependency_client_NamedElement ) :+
    ( "supplier" -> Dependency_supplierDependency_supplier_NamedElement ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Reception, BehavioralFeature, Feature, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Reception
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "signal" -> Reception_reception_signal_Signal ) :+
    ( "method" -> BehavioralFeature_specification_method_Behavior ) :+
    ( "raisedException" -> BehavioralFeature_behavioralFeature_raisedException_Type )

  // All parents: {ReclassifyObjectAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReclassifyObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "newClassifier" -> ReclassifyObjectAction_reclassifyObjectAction_newClassifier_Classifier ) :+
    ( "oldClassifier" -> ReclassifyObjectAction_reclassifyObjectAction_oldClassifier_Classifier ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {RedefinableTemplateSignature, RedefinableElement, TemplateSignature, NamedElement, Element}
  lazy val metaclass_reference_updater_table_RedefinableTemplateSignature
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "extendedSignature" -> RedefinableTemplateSignature_redefinableTemplateSignature_extendedSignature_RedefinableTemplateSignature ) :+
    ( "parameter" -> TemplateSignature_templateSignature_parameter_TemplateParameter )

  // All parents: {ReduceAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReduceAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "reducer" -> ReduceAction_reduceAction_reducer_Behavior ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {Region, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Region
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "extendedRegion" -> Region_region_extendedRegion_Region )

  // All parents: {RemoveStructuralFeatureValueAction, WriteStructuralFeatureAction, StructuralFeatureAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_RemoveStructuralFeatureValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "structuralFeature" -> StructuralFeatureAction_structuralFeatureAction_structuralFeature_StructuralFeature ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {RemoveVariableValueAction, WriteVariableAction, VariableAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_RemoveVariableValueAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "variable" -> VariableAction_variableAction_variable_Variable ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {ReplyAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ReplyAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "replyToCall" -> ReplyAction_replyAction_replyToCall_Trigger ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {SendObjectAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_SendObjectAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "onPort" -> InvocationAction_invocationAction_onPort_Port ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {SendSignalAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_SendSignalAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "signal" -> SendSignalAction_sendSignalAction_signal_Signal ) :+
    ( "onPort" -> InvocationAction_invocationAction_onPort_Port ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {SequenceNode, StructuredActivityNode, Action, ExecutableNode, ActivityGroup, ActivityNode, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_SequenceNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {Signal, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Signal
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {SignalEvent, MessageEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_SignalEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "signal" -> SignalEvent_signalEvent_signal_Signal ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Slot, Element}
  lazy val metaclass_reference_updater_table_Slot
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "definingFeature" -> Slot_slot_definingFeature_StructuralFeature )

  // All parents: {StartClassifierBehaviorAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_StartClassifierBehaviorAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {StartObjectBehaviorAction, CallAction, InvocationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_StartObjectBehaviorAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "onPort" -> InvocationAction_invocationAction_onPort_Port ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {State, Namespace, RedefinableElement, Vertex, NamedElement, Element}
  lazy val metaclass_reference_updater_table_State
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "redefinedState" -> State_state_redefinedState_State ) :+
    ( "stateInvariant" -> State_owningState_stateInvariant_Constraint ) :+
    ( "submachine" -> State_submachineState_submachine_StateMachine )

  // All parents: {StateInvariant, InteractionFragment, NamedElement, Element}
  lazy val metaclass_reference_updater_table_StateInvariant
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "covered" -> StateInvariant_stateInvariant_covered_Lifeline ) :+
    ( "covered" -> InteractionFragment_coveredBy_covered_Lifeline )

  // All parents: {StateMachine, Behavior, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_StateMachine
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "extendedStateMachine" -> StateMachine_stateMachine_extendedStateMachine_StateMachine ) :+
    ( "submachineState" -> StateMachine_submachine_submachineState_State ) :+
    ( "postcondition" -> Behavior_behavior_postcondition_Constraint ) :+
    ( "precondition" -> Behavior_behavior_precondition_Constraint ) :+
    ( "redefinedBehavior" -> Behavior_behavior_redefinedBehavior_Behavior ) :+
    ( "specification" -> Behavior_method_specification_BehavioralFeature ) :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Stereotype, Class, BehavioredClassifier, EncapsulatedClassifier, StructuredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Stereotype
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {StringExpression, Expression, ValueSpecification, TemplateableElement, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_StringExpression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {StructuredActivityNode, Action, ExecutableNode, ActivityGroup, ActivityNode, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_StructuredActivityNode
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {Substitution, Realization, Abstraction, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Substitution
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "contract" -> Substitution_substitution_contract_Classifier ) :+
    ( "client" -> Dependency_clientDependency_client_NamedElement ) :+
    ( "supplier" -> Dependency_supplierDependency_supplier_NamedElement ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {TemplateBinding, DirectedRelationship, Relationship, Element}
  lazy val metaclass_reference_updater_table_TemplateBinding
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "signature" -> TemplateBinding_templateBinding_signature_TemplateSignature )

  // All parents: {TemplateParameter, Element}
  lazy val metaclass_reference_updater_table_TemplateParameter
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "default" -> TemplateParameter_templateParameter_default_ParameterableElement ) :+
    ( "parameteredElement" -> TemplateParameter_templateParameter_parameteredElement_ParameterableElement )

  // All parents: {TemplateParameterSubstitution, Element}
  lazy val metaclass_reference_updater_table_TemplateParameterSubstitution
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "actual" -> TemplateParameterSubstitution_templateParameterSubstitution_actual_ParameterableElement ) :+
    ( "formal" -> TemplateParameterSubstitution_templateParameterSubstitution_formal_TemplateParameter )

  // All parents: {TemplateSignature, Element}
  lazy val metaclass_reference_updater_table_TemplateSignature
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "parameter" -> TemplateSignature_templateSignature_parameter_TemplateParameter )

  // All parents: {TestIdentityAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_TestIdentityAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {TimeConstraint, IntervalConstraint, Constraint, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_TimeConstraint
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "constrainedElement" -> Constraint_constraint_constrainedElement_Element ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {TimeEvent, Event, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_TimeEvent
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {TimeExpression, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_TimeExpression
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "observation" -> TimeExpression_timeExpression_observation_Observation ) :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {TimeInterval, Interval, ValueSpecification, PackageableElement, TypedElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_TimeInterval
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "max" -> TimeInterval_timeInterval_max_TimeExpression ) :+
    ( "min" -> TimeInterval_timeInterval_min_TimeExpression ) :+
    ( "max" -> Interval_interval_max_ValueSpecification ) :+
    ( "min" -> Interval_interval_min_ValueSpecification ) :+
    ( "type" -> TypedElement_typedElement_type_Type ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {TimeObservation, Observation, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_TimeObservation
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "event" -> TimeObservation_timeObservation_event_NamedElement ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {Transition, Namespace, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Transition
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "guard" -> Transition_transition_guard_Constraint ) :+
    ( "redefinedTransition" -> Transition_transition_redefinedTransition_Transition ) :+
    ( "source" -> Transition_outgoing_source_Vertex ) :+
    ( "target" -> Transition_incoming_target_Vertex )

  // All parents: {Trigger, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Trigger
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "event" -> Trigger_trigger_event_Event ) :+
    ( "port" -> Trigger_trigger_port_Port )

  // All parents: {UnmarshallAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_UnmarshallAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "unmarshallType" -> UnmarshallAction_unmarshallAction_unmarshallType_Classifier ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {Usage, Dependency, DirectedRelationship, Relationship, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_Usage
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "client" -> Dependency_clientDependency_client_NamedElement ) :+
    ( "supplier" -> Dependency_supplierDependency_supplier_NamedElement ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {UseCase, BehavioredClassifier, Classifier, Namespace, RedefinableElement, TemplateableElement, Type, PackageableElement, NamedElement, ParameterableElement, Element}
  lazy val metaclass_reference_updater_table_UseCase
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "subject" -> UseCase_useCase_subject_Classifier ) :+
    ( "classifierBehavior" -> BehavioredClassifier_behavioredClassifier_classifierBehavior_Behavior ) :+
    ( "powertypeExtent" -> Classifier_powertype_powertypeExtent_GeneralizationSet ) :+
    ( "redefinedClassifier" -> Classifier_classifier_redefinedClassifier_Classifier ) :+
    ( "representation" -> Classifier_classifier_representation_CollaborationUse ) :+
    ( "templateParameter" -> Classifier_parameteredElement_templateParameter_ClassifierTemplateParameter ) :+
    ( "useCase" -> Classifier_subject_useCase_UseCase ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter )

  // All parents: {ValuePin, InputPin, Pin, MultiplicityElement, ObjectNode, ActivityNode, TypedElement, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ValuePin
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inState" -> ObjectNode_objectNode_inState_State ) :+
    ( "selection" -> ObjectNode_objectNode_selection_Behavior ) :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // All parents: {ValueSpecificationAction, Action, ExecutableNode, ActivityNode, RedefinableElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_ValueSpecificationAction
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "inInterruptibleRegion" -> ActivityNode_node_inInterruptibleRegion_InterruptibleActivityRegion ) :+
    ( "inPartition" -> ActivityNode_node_inPartition_ActivityPartition ) :+
    ( "incoming" -> ActivityNode_target_incoming_ActivityEdge ) :+
    ( "outgoing" -> ActivityNode_source_outgoing_ActivityEdge ) :+
    ( "redefinedNode" -> ActivityNode_activityNode_redefinedNode_ActivityNode )

  // All parents: {Variable, ConnectableElement, MultiplicityElement, ParameterableElement, TypedElement, NamedElement, Element}
  lazy val metaclass_reference_updater_table_Variable
  : Seq[(String, AssociationMetaPropertyUpdater)]
  = Seq[(String, AssociationMetaPropertyUpdater)]() :+
    ( "templateParameter" -> ConnectableElement_parameteredElement_templateParameter_ConnectableElementTemplateParameter ) :+
    ( "templateParameter" -> ParameterableElement_parameteredElement_templateParameter_TemplateParameter ) :+
    ( "type" -> TypedElement_typedElement_type_Type )

  // Start of user code for additional features
  // End of user code
}
