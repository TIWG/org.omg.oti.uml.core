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
package org.omg.oti.uml.write

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.implicitConversions
import scala.util.Try
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <a href="../../../../../../index.html" target="_top">Top</a>
 *
 * = OCL/MOF-like update operations for OMG UML 2.5 metamodel properties and associations =
 *
 * <!-- End of user code documentation -->
 */
package object api {

  // Abstraction

  class AbstractionUpdater[Uml <: UML](val domain: UMLAbstraction[Uml]) extends AnyVal {

    def links_Abstraction_abstraction_compose_mapping_OpaqueExpression
    (range: Option[UMLOpaqueExpression[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Abstraction_abstraction_compose_mapping_OpaqueExpression(domain, range)

  }

  implicit def enrichAbstraction[Uml <: UML]
  (domain: UMLAbstraction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AbstractionUpdater[Uml](domain)

  // AcceptCallAction

  class AcceptCallActionUpdater[Uml <: UML](val domain: UMLAcceptCallAction[Uml]) extends AnyVal {

    def links_AcceptCallAction_acceptCallAction_compose_returnInformation_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_AcceptCallAction_acceptCallAction_compose_returnInformation_OutputPin(domain, range)

  }

  implicit def enrichAcceptCallAction[Uml <: UML]
  (domain: UMLAcceptCallAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AcceptCallActionUpdater[Uml](domain)

  // AcceptEventAction

  class AcceptEventActionUpdater[Uml <: UML](val domain: UMLAcceptEventAction[Uml]) extends AnyVal {

    def links_AcceptEventAction_acceptEventAction_compose_result_OutputPin
    (range: Seq[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_AcceptEventAction_acceptEventAction_compose_result_OutputPin(domain, range)

    def links_AcceptEventAction_acceptEventAction_compose_trigger_Trigger
    (range: Set[UMLTrigger[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_AcceptEventAction_acceptEventAction_compose_trigger_Trigger(domain, range)

    def setIsUnmarshall
    (isUnmarshall: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_AcceptEventAction_isUnmarshall(domain, isUnmarshall)

  }

  implicit def enrichAcceptEventAction[Uml <: UML]
  (domain: UMLAcceptEventAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AcceptEventActionUpdater[Uml](domain)

  // Action

  class ActionUpdater[Uml <: UML](val domain: UMLAction[Uml]) extends AnyVal {

    def links_Action_action_compose_localPostcondition_Constraint
    (range: Set[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Action_action_compose_localPostcondition_Constraint(domain, range)

    def links_Action_action_compose_localPrecondition_Constraint
    (range: Set[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Action_action_compose_localPrecondition_Constraint(domain, range)

    def setIsLocallyReentrant
    (isLocallyReentrant: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Action_isLocallyReentrant(domain, isLocallyReentrant)

  }

  implicit def enrichAction[Uml <: UML]
  (domain: UMLAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActionUpdater[Uml](domain)

  // ActionExecutionSpecification

  class ActionExecutionSpecificationUpdater[Uml <: UML](val domain: UMLActionExecutionSpecification[Uml]) extends AnyVal {

    def links_ActionExecutionSpecification_actionExecutionSpecification_reference_action_Action
    (range: Option[UMLAction[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActionExecutionSpecification_actionExecutionSpecification_reference_action_Action(domain, range)

  }

  implicit def enrichActionExecutionSpecification[Uml <: UML]
  (domain: UMLActionExecutionSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActionExecutionSpecificationUpdater[Uml](domain)

  // ActionInputPin

  class ActionInputPinUpdater[Uml <: UML](val domain: UMLActionInputPin[Uml]) extends AnyVal {

    def links_ActionInputPin_actionInputPin_compose_fromAction_Action
    (range: Option[UMLAction[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActionInputPin_actionInputPin_compose_fromAction_Action(domain, range)

  }

  implicit def enrichActionInputPin[Uml <: UML]
  (domain: UMLActionInputPin[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActionInputPinUpdater[Uml](domain)

  // Activity

  class ActivityUpdater[Uml <: UML](val domain: UMLActivity[Uml]) extends AnyVal {

    def links_Activity_activity_compose_edge_ActivityEdge
    (range: Set[UMLActivityEdge[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Activity_activity_compose_edge_ActivityEdge(domain, range)

    def links_Activity_inActivity_compose_group_ActivityGroup
    (range: Set[UMLActivityGroup[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Activity_inActivity_compose_group_ActivityGroup(domain, range)

    def links_Activity_activity_compose_node_ActivityNode
    (range: Set[UMLActivityNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Activity_activity_compose_node_ActivityNode(domain, range)

    def links_Activity_activity_reference_partition_ActivityPartition
    (range: Set[UMLActivityPartition[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Activity_activity_reference_partition_ActivityPartition(domain, range)

    def links_Activity_activity_compose_structuredNode_StructuredActivityNode
    (range: Set[UMLStructuredActivityNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Activity_activity_compose_structuredNode_StructuredActivityNode(domain, range)

    def links_Activity_activityScope_compose_variable_Variable
    (range: Set[UMLVariable[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Activity_activityScope_compose_variable_Variable(domain, range)

    def setIsReadOnly
    (isReadOnly: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Activity_isReadOnly(domain, isReadOnly)

    def setIsSingleExecution
    (isSingleExecution: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Activity_isSingleExecution(domain, isSingleExecution)

  }

  implicit def enrichActivity[Uml <: UML]
  (domain: UMLActivity[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityUpdater[Uml](domain)

  // ActivityEdge

  class ActivityEdgeUpdater[Uml <: UML](val domain: UMLActivityEdge[Uml]) extends AnyVal {

    def links_ActivityEdge_activityEdge_compose_guard_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityEdge_activityEdge_compose_guard_ValueSpecification(domain, range)

    def links_ActivityEdge_edge_reference_inPartition_ActivityPartition
    (range: Set[UMLActivityPartition[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityEdge_edge_reference_inPartition_ActivityPartition(domain, range)

    def links_ActivityEdge_interruptingEdge_reference_interrupts_InterruptibleActivityRegion
    (range: Option[UMLInterruptibleActivityRegion[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityEdge_interruptingEdge_reference_interrupts_InterruptibleActivityRegion(domain, range)

    def links_ActivityEdge_activityEdge_reference_redefinedEdge_ActivityEdge
    (range: Set[UMLActivityEdge[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityEdge_activityEdge_reference_redefinedEdge_ActivityEdge(domain, range)

    def links_ActivityEdge_outgoing_reference_source_ActivityNode
    (range: Option[UMLActivityNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityEdge_outgoing_reference_source_ActivityNode(domain, range)

    def links_ActivityEdge_incoming_reference_target_ActivityNode
    (range: Option[UMLActivityNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityEdge_incoming_reference_target_ActivityNode(domain, range)

    def links_ActivityEdge_activityEdge_compose_weight_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityEdge_activityEdge_compose_weight_ValueSpecification(domain, range)

  }

  implicit def enrichActivityEdge[Uml <: UML]
  (domain: UMLActivityEdge[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityEdgeUpdater[Uml](domain)

  // ActivityFinalNode

  class ActivityFinalNodeUpdater[Uml <: UML](val domain: UMLActivityFinalNode[Uml]) extends AnyVal {


  }

  implicit def enrichActivityFinalNode[Uml <: UML]
  (domain: UMLActivityFinalNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityFinalNodeUpdater[Uml](domain)

  // ActivityGroup

  class ActivityGroupUpdater[Uml <: UML](val domain: UMLActivityGroup[Uml]) extends AnyVal {


  }

  implicit def enrichActivityGroup[Uml <: UML]
  (domain: UMLActivityGroup[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityGroupUpdater[Uml](domain)

  // ActivityNode

  class ActivityNodeUpdater[Uml <: UML](val domain: UMLActivityNode[Uml]) extends AnyVal {

    def links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion
    (range: Set[UMLInterruptibleActivityRegion[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion(domain, range)

    def links_ActivityNode_node_reference_inPartition_ActivityPartition
    (range: Set[UMLActivityPartition[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityNode_node_reference_inPartition_ActivityPartition(domain, range)

    def links_ActivityNode_target_reference_incoming_ActivityEdge
    (range: Set[UMLActivityEdge[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityNode_target_reference_incoming_ActivityEdge(domain, range)

    def links_ActivityNode_source_reference_outgoing_ActivityEdge
    (range: Set[UMLActivityEdge[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityNode_source_reference_outgoing_ActivityEdge(domain, range)

    def links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode
    (range: Set[UMLActivityNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode(domain, range)

  }

  implicit def enrichActivityNode[Uml <: UML]
  (domain: UMLActivityNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityNodeUpdater[Uml](domain)

  // ActivityParameterNode

  class ActivityParameterNodeUpdater[Uml <: UML](val domain: UMLActivityParameterNode[Uml]) extends AnyVal {

    def links_ActivityParameterNode_activityParameterNode_reference_parameter_Parameter
    (range: Option[UMLParameter[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityParameterNode_activityParameterNode_reference_parameter_Parameter(domain, range)

  }

  implicit def enrichActivityParameterNode[Uml <: UML]
  (domain: UMLActivityParameterNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityParameterNodeUpdater[Uml](domain)

  // ActivityPartition

  class ActivityPartitionUpdater[Uml <: UML](val domain: UMLActivityPartition[Uml]) extends AnyVal {

    def links_ActivityPartition_inPartition_reference_edge_ActivityEdge
    (range: Set[UMLActivityEdge[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityPartition_inPartition_reference_edge_ActivityEdge(domain, range)

    def links_ActivityPartition_inPartition_reference_node_ActivityNode
    (range: Set[UMLActivityNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityPartition_inPartition_reference_node_ActivityNode(domain, range)

    def links_ActivityPartition_activityPartition_reference_represents_Element
    (range: Option[UMLElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityPartition_activityPartition_reference_represents_Element(domain, range)

    def links_ActivityPartition_superPartition_compose_subpartition_ActivityPartition
    (range: Set[UMLActivityPartition[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ActivityPartition_superPartition_compose_subpartition_ActivityPartition(domain, range)

    def setIsDimension
    (isDimension: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ActivityPartition_isDimension(domain, isDimension)

    def setIsExternal
    (isExternal: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ActivityPartition_isExternal(domain, isExternal)

  }

  implicit def enrichActivityPartition[Uml <: UML]
  (domain: UMLActivityPartition[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityPartitionUpdater[Uml](domain)

  // Actor

  class ActorUpdater[Uml <: UML](val domain: UMLActor[Uml]) extends AnyVal {


  }

  implicit def enrichActor[Uml <: UML]
  (domain: UMLActor[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActorUpdater[Uml](domain)

  // AddStructuralFeatureValueAction

  class AddStructuralFeatureValueActionUpdater[Uml <: UML](val domain: UMLAddStructuralFeatureValueAction[Uml]) extends AnyVal {

    def links_AddStructuralFeatureValueAction_addStructuralFeatureValueAction_compose_insertAt_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_AddStructuralFeatureValueAction_addStructuralFeatureValueAction_compose_insertAt_InputPin(domain, range)

    def setIsReplaceAll
    (isReplaceAll: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_AddStructuralFeatureValueAction_isReplaceAll(domain, isReplaceAll)

  }

  implicit def enrichAddStructuralFeatureValueAction[Uml <: UML]
  (domain: UMLAddStructuralFeatureValueAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AddStructuralFeatureValueActionUpdater[Uml](domain)

  // AddVariableValueAction

  class AddVariableValueActionUpdater[Uml <: UML](val domain: UMLAddVariableValueAction[Uml]) extends AnyVal {

    def links_AddVariableValueAction_addVariableValueAction_compose_insertAt_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_AddVariableValueAction_addVariableValueAction_compose_insertAt_InputPin(domain, range)

    def setIsReplaceAll
    (isReplaceAll: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_AddVariableValueAction_isReplaceAll(domain, isReplaceAll)

  }

  implicit def enrichAddVariableValueAction[Uml <: UML]
  (domain: UMLAddVariableValueAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AddVariableValueActionUpdater[Uml](domain)

  // AnyReceiveEvent

  class AnyReceiveEventUpdater[Uml <: UML](val domain: UMLAnyReceiveEvent[Uml]) extends AnyVal {


  }

  implicit def enrichAnyReceiveEvent[Uml <: UML]
  (domain: UMLAnyReceiveEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AnyReceiveEventUpdater[Uml](domain)

  // Artifact

  class ArtifactUpdater[Uml <: UML](val domain: UMLArtifact[Uml]) extends AnyVal {

    def links_Artifact_artifact_compose_manifestation_Manifestation
    (range: Set[UMLManifestation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Artifact_artifact_compose_manifestation_Manifestation(domain, range)

    def links_Artifact_artifact_compose_nestedArtifact_Artifact
    (range: Set[UMLArtifact[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Artifact_artifact_compose_nestedArtifact_Artifact(domain, range)

    def links_Artifact_artifact_compose_ownedAttribute_Property
    (range: Seq[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Artifact_artifact_compose_ownedAttribute_Property(domain, range)

    def links_Artifact_artifact_compose_ownedOperation_Operation
    (range: Seq[UMLOperation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Artifact_artifact_compose_ownedOperation_Operation(domain, range)

    def setFileName
    (fileName: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Artifact_fileName(domain, fileName)

  }

  implicit def enrichArtifact[Uml <: UML]
  (domain: UMLArtifact[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ArtifactUpdater[Uml](domain)

  // Association

  class AssociationUpdater[Uml <: UML](val domain: UMLAssociation[Uml]) extends AnyVal {

    def links_Association_association_reference_memberEnd_Property
    (range: Seq[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Association_association_reference_memberEnd_Property(domain, range)

    def links_Association_association_reference_navigableOwnedEnd_Property
    (range: Set[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Association_association_reference_navigableOwnedEnd_Property(domain, range)

    def links_Association_owningAssociation_compose_ownedEnd_Property
    (range: Iterable[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Association_owningAssociation_compose_ownedEnd_Property(domain, range)

    def setIsDerived
    (isDerived: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Association_isDerived(domain, isDerived)

  }

  implicit def enrichAssociation[Uml <: UML]
  (domain: UMLAssociation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AssociationUpdater[Uml](domain)

  // AssociationClass

  class AssociationClassUpdater[Uml <: UML](val domain: UMLAssociationClass[Uml]) extends AnyVal {


  }

  implicit def enrichAssociationClass[Uml <: UML]
  (domain: UMLAssociationClass[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AssociationClassUpdater[Uml](domain)

  // Behavior

  class BehaviorUpdater[Uml <: UML](val domain: UMLBehavior[Uml]) extends AnyVal {

    def links_Behavior_behavior_compose_ownedParameter_Parameter
    (range: Seq[UMLParameter[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Behavior_behavior_compose_ownedParameter_Parameter(domain, range)

    def links_Behavior_behavior_compose_ownedParameterSet_ParameterSet
    (range: Set[UMLParameterSet[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Behavior_behavior_compose_ownedParameterSet_ParameterSet(domain, range)

    def links_Behavior_behavior_compose_postcondition_Constraint
    (range: Set[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Behavior_behavior_compose_postcondition_Constraint(domain, range)

    def links_Behavior_behavior_compose_precondition_Constraint
    (range: Set[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Behavior_behavior_compose_precondition_Constraint(domain, range)

    def links_Behavior_behavior_reference_redefinedBehavior_Behavior
    (range: Set[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Behavior_behavior_reference_redefinedBehavior_Behavior(domain, range)

    def links_Behavior_method_reference_specification_BehavioralFeature
    (range: Option[UMLBehavioralFeature[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Behavior_method_reference_specification_BehavioralFeature(domain, range)

    def setIsReentrant
    (isReentrant: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Behavior_isReentrant(domain, isReentrant)

  }

  implicit def enrichBehavior[Uml <: UML]
  (domain: UMLBehavior[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new BehaviorUpdater[Uml](domain)

  // BehaviorExecutionSpecification

  class BehaviorExecutionSpecificationUpdater[Uml <: UML](val domain: UMLBehaviorExecutionSpecification[Uml]) extends AnyVal {

    def links_BehaviorExecutionSpecification_behaviorExecutionSpecification_reference_behavior_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_BehaviorExecutionSpecification_behaviorExecutionSpecification_reference_behavior_Behavior(domain, range)

  }

  implicit def enrichBehaviorExecutionSpecification[Uml <: UML]
  (domain: UMLBehaviorExecutionSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new BehaviorExecutionSpecificationUpdater[Uml](domain)

  // BehavioralFeature

  class BehavioralFeatureUpdater[Uml <: UML](val domain: UMLBehavioralFeature[Uml]) extends AnyVal {

    def links_BehavioralFeature_specification_reference_method_Behavior
    (range: Set[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_BehavioralFeature_specification_reference_method_Behavior(domain, range)

    def links_BehavioralFeature_ownerFormalParam_compose_ownedParameter_Parameter
    (range: Seq[UMLParameter[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_BehavioralFeature_ownerFormalParam_compose_ownedParameter_Parameter(domain, range)

    def links_BehavioralFeature_behavioralFeature_compose_ownedParameterSet_ParameterSet
    (range: Set[UMLParameterSet[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_BehavioralFeature_behavioralFeature_compose_ownedParameterSet_ParameterSet(domain, range)

    def links_BehavioralFeature_behavioralFeature_reference_raisedException_Type
    (range: Set[UMLType[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_BehavioralFeature_behavioralFeature_reference_raisedException_Type(domain, range)

    def setConcurrency
    (concurrency: UMLCallConcurrencyKind.Value)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_BehavioralFeature_concurrency(domain, concurrency)

    def setIsAbstract
    (isAbstract: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_BehavioralFeature_isAbstract(domain, isAbstract)

  }

  implicit def enrichBehavioralFeature[Uml <: UML]
  (domain: UMLBehavioralFeature[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new BehavioralFeatureUpdater[Uml](domain)

  // BehavioredClassifier

  class BehavioredClassifierUpdater[Uml <: UML](val domain: UMLBehavioredClassifier[Uml]) extends AnyVal {

    def links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior(domain, range)

    def links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization
    (range: Set[UMLInterfaceRealization[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization(domain, range)

    def links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior
    (range: Set[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior(domain, range)

  }

  implicit def enrichBehavioredClassifier[Uml <: UML]
  (domain: UMLBehavioredClassifier[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new BehavioredClassifierUpdater[Uml](domain)

  // BroadcastSignalAction

  class BroadcastSignalActionUpdater[Uml <: UML](val domain: UMLBroadcastSignalAction[Uml]) extends AnyVal {

    def links_BroadcastSignalAction_broadcastSignalAction_reference_signal_Signal
    (range: Option[UMLSignal[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_BroadcastSignalAction_broadcastSignalAction_reference_signal_Signal(domain, range)

  }

  implicit def enrichBroadcastSignalAction[Uml <: UML]
  (domain: UMLBroadcastSignalAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new BroadcastSignalActionUpdater[Uml](domain)

  // CallAction

  class CallActionUpdater[Uml <: UML](val domain: UMLCallAction[Uml]) extends AnyVal {

    def links_CallAction_callAction_compose_result_OutputPin
    (range: Seq[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CallAction_callAction_compose_result_OutputPin(domain, range)

    def setIsSynchronous
    (isSynchronous: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_CallAction_isSynchronous(domain, isSynchronous)

  }

  implicit def enrichCallAction[Uml <: UML]
  (domain: UMLCallAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CallActionUpdater[Uml](domain)

  // CallBehaviorAction

  class CallBehaviorActionUpdater[Uml <: UML](val domain: UMLCallBehaviorAction[Uml]) extends AnyVal {

    def links_CallBehaviorAction_callBehaviorAction_reference_behavior_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CallBehaviorAction_callBehaviorAction_reference_behavior_Behavior(domain, range)

  }

  implicit def enrichCallBehaviorAction[Uml <: UML]
  (domain: UMLCallBehaviorAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CallBehaviorActionUpdater[Uml](domain)

  // CallEvent

  class CallEventUpdater[Uml <: UML](val domain: UMLCallEvent[Uml]) extends AnyVal {

    def links_CallEvent_callEvent_reference_operation_Operation
    (range: Option[UMLOperation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CallEvent_callEvent_reference_operation_Operation(domain, range)

  }

  implicit def enrichCallEvent[Uml <: UML]
  (domain: UMLCallEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CallEventUpdater[Uml](domain)

  // CallOperationAction

  class CallOperationActionUpdater[Uml <: UML](val domain: UMLCallOperationAction[Uml]) extends AnyVal {

    def links_CallOperationAction_callOperationAction_reference_operation_Operation
    (range: Option[UMLOperation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CallOperationAction_callOperationAction_reference_operation_Operation(domain, range)

    def links_CallOperationAction_callOperationAction_compose_target_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CallOperationAction_callOperationAction_compose_target_InputPin(domain, range)

  }

  implicit def enrichCallOperationAction[Uml <: UML]
  (domain: UMLCallOperationAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CallOperationActionUpdater[Uml](domain)

  // CentralBufferNode

  class CentralBufferNodeUpdater[Uml <: UML](val domain: UMLCentralBufferNode[Uml]) extends AnyVal {


  }

  implicit def enrichCentralBufferNode[Uml <: UML]
  (domain: UMLCentralBufferNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CentralBufferNodeUpdater[Uml](domain)

  // ChangeEvent

  class ChangeEventUpdater[Uml <: UML](val domain: UMLChangeEvent[Uml]) extends AnyVal {

    def links_ChangeEvent_changeEvent_compose_changeExpression_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ChangeEvent_changeEvent_compose_changeExpression_ValueSpecification(domain, range)

  }

  implicit def enrichChangeEvent[Uml <: UML]
  (domain: UMLChangeEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ChangeEventUpdater[Uml](domain)

  // Class

  class ClassUpdater[Uml <: UML](val domain: UMLClass[Uml]) extends AnyVal {

    def links_Class_nestingClass_compose_nestedClassifier_Classifier
    (range: Seq[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Class_nestingClass_compose_nestedClassifier_Classifier(domain, range)

    def links_Class_class_compose_ownedAttribute_Property
    (range: Seq[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Class_class_compose_ownedAttribute_Property(domain, range)

    def links_Class_class_compose_ownedOperation_Operation
    (range: Seq[UMLOperation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Class_class_compose_ownedOperation_Operation(domain, range)

    def links_Class_class_compose_ownedReception_Reception
    (range: Set[UMLReception[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Class_class_compose_ownedReception_Reception(domain, range)

    def setIsAbstract
    (isAbstract: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Class_isAbstract(domain, isAbstract)

    def setIsActive
    (isActive: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Class_isActive(domain, isActive)

  }

  implicit def enrichClass[Uml <: UML]
  (domain: UMLClass[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClassUpdater[Uml](domain)

  // Classifier

  class ClassifierUpdater[Uml <: UML](val domain: UMLClassifier[Uml]) extends AnyVal {

    def links_Classifier_classifier_compose_collaborationUse_CollaborationUse
    (range: Set[UMLCollaborationUse[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Classifier_classifier_compose_collaborationUse_CollaborationUse(domain, range)

    def links_Classifier_specific_compose_generalization_Generalization
    (range: Set[UMLGeneralization[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Classifier_specific_compose_generalization_Generalization(domain, range)

    def links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature
    (range: Option[UMLRedefinableTemplateSignature[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature(domain, range)

    def links_Classifier_classifier_compose_ownedUseCase_UseCase
    (range: Set[UMLUseCase[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Classifier_classifier_compose_ownedUseCase_UseCase(domain, range)

    def links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet
    (range: Set[UMLGeneralizationSet[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet(domain, range)

    def links_Classifier_classifier_reference_redefinedClassifier_Classifier
    (range: Set[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Classifier_classifier_reference_redefinedClassifier_Classifier(domain, range)

    def links_Classifier_classifier_reference_representation_CollaborationUse
    (range: Option[UMLCollaborationUse[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Classifier_classifier_reference_representation_CollaborationUse(domain, range)

    def links_Classifier_substitutingClassifier_compose_substitution_Substitution
    (range: Set[UMLSubstitution[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Classifier_substitutingClassifier_compose_substitution_Substitution(domain, range)

    def links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter
    (range: Option[UMLClassifierTemplateParameter[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter(domain, range)

    def links_Classifier_subject_reference_useCase_UseCase
    (range: Set[UMLUseCase[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Classifier_subject_reference_useCase_UseCase(domain, range)

    def setIsAbstract
    (isAbstract: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Classifier_isAbstract(domain, isAbstract)

    def setIsFinalSpecialization
    (isFinalSpecialization: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Classifier_isFinalSpecialization(domain, isFinalSpecialization)

  }

  implicit def enrichClassifier[Uml <: UML]
  (domain: UMLClassifier[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClassifierUpdater[Uml](domain)

  // ClassifierTemplateParameter

  class ClassifierTemplateParameterUpdater[Uml <: UML](val domain: UMLClassifierTemplateParameter[Uml]) extends AnyVal {

    def links_ClassifierTemplateParameter_classifierTemplateParameter_reference_constrainingClassifier_Classifier
    (range: Set[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ClassifierTemplateParameter_classifierTemplateParameter_reference_constrainingClassifier_Classifier(domain, range)

    def links_ClassifierTemplateParameter_templateParameter_reference_parameteredElement_Classifier
    (range: Option[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ClassifierTemplateParameter_templateParameter_reference_parameteredElement_Classifier(domain, range)

    def setAllowSubstitutable
    (allowSubstitutable: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ClassifierTemplateParameter_allowSubstitutable(domain, allowSubstitutable)

  }

  implicit def enrichClassifierTemplateParameter[Uml <: UML]
  (domain: UMLClassifierTemplateParameter[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClassifierTemplateParameterUpdater[Uml](domain)

  // Clause

  class ClauseUpdater[Uml <: UML](val domain: UMLClause[Uml]) extends AnyVal {

    def links_Clause_clause_reference_body_ExecutableNode
    (range: Set[UMLExecutableNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Clause_clause_reference_body_ExecutableNode(domain, range)

    def links_Clause_clause_reference_bodyOutput_OutputPin
    (range: Seq[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Clause_clause_reference_bodyOutput_OutputPin(domain, range)

    def links_Clause_clause_reference_decider_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Clause_clause_reference_decider_OutputPin(domain, range)

    def links_Clause_successorClause_reference_predecessorClause_Clause
    (range: Set[UMLClause[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Clause_successorClause_reference_predecessorClause_Clause(domain, range)

    def links_Clause_predecessorClause_reference_successorClause_Clause
    (range: Set[UMLClause[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Clause_predecessorClause_reference_successorClause_Clause(domain, range)

    def links_Clause_clause_reference_test_ExecutableNode
    (range: Set[UMLExecutableNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Clause_clause_reference_test_ExecutableNode(domain, range)

  }

  implicit def enrichClause[Uml <: UML]
  (domain: UMLClause[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClauseUpdater[Uml](domain)

  // ClearAssociationAction

  class ClearAssociationActionUpdater[Uml <: UML](val domain: UMLClearAssociationAction[Uml]) extends AnyVal {

    def links_ClearAssociationAction_clearAssociationAction_reference_association_Association
    (range: Option[UMLAssociation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ClearAssociationAction_clearAssociationAction_reference_association_Association(domain, range)

    def links_ClearAssociationAction_clearAssociationAction_compose_object_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ClearAssociationAction_clearAssociationAction_compose_object_InputPin(domain, range)

  }

  implicit def enrichClearAssociationAction[Uml <: UML]
  (domain: UMLClearAssociationAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClearAssociationActionUpdater[Uml](domain)

  // ClearStructuralFeatureAction

  class ClearStructuralFeatureActionUpdater[Uml <: UML](val domain: UMLClearStructuralFeatureAction[Uml]) extends AnyVal {

    def links_ClearStructuralFeatureAction_clearStructuralFeatureAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ClearStructuralFeatureAction_clearStructuralFeatureAction_compose_result_OutputPin(domain, range)

  }

  implicit def enrichClearStructuralFeatureAction[Uml <: UML]
  (domain: UMLClearStructuralFeatureAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClearStructuralFeatureActionUpdater[Uml](domain)

  // ClearVariableAction

  class ClearVariableActionUpdater[Uml <: UML](val domain: UMLClearVariableAction[Uml]) extends AnyVal {


  }

  implicit def enrichClearVariableAction[Uml <: UML]
  (domain: UMLClearVariableAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClearVariableActionUpdater[Uml](domain)

  // Collaboration

  class CollaborationUpdater[Uml <: UML](val domain: UMLCollaboration[Uml]) extends AnyVal {

    def links_Collaboration_collaboration_reference_collaborationRole_ConnectableElement
    (range: Set[UMLConnectableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Collaboration_collaboration_reference_collaborationRole_ConnectableElement(domain, range)

  }

  implicit def enrichCollaboration[Uml <: UML]
  (domain: UMLCollaboration[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CollaborationUpdater[Uml](domain)

  // CollaborationUse

  class CollaborationUseUpdater[Uml <: UML](val domain: UMLCollaborationUse[Uml]) extends AnyVal {

    def links_CollaborationUse_collaborationUse_compose_roleBinding_Dependency
    (range: Set[UMLDependency[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CollaborationUse_collaborationUse_compose_roleBinding_Dependency(domain, range)

    def links_CollaborationUse_collaborationUse_reference_type_Collaboration
    (range: Option[UMLCollaboration[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CollaborationUse_collaborationUse_reference_type_Collaboration(domain, range)

  }

  implicit def enrichCollaborationUse[Uml <: UML]
  (domain: UMLCollaborationUse[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CollaborationUseUpdater[Uml](domain)

  // CombinedFragment

  class CombinedFragmentUpdater[Uml <: UML](val domain: UMLCombinedFragment[Uml]) extends AnyVal {

    def links_CombinedFragment_combinedFragment_compose_cfragmentGate_Gate
    (range: Set[UMLGate[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CombinedFragment_combinedFragment_compose_cfragmentGate_Gate(domain, range)

    def links_CombinedFragment_combinedFragment_compose_operand_InteractionOperand
    (range: Seq[UMLInteractionOperand[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CombinedFragment_combinedFragment_compose_operand_InteractionOperand(domain, range)

    def setInteractionOperator
    (interactionOperator: UMLInteractionOperatorKind.Value)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_CombinedFragment_interactionOperator(domain, interactionOperator)

  }

  implicit def enrichCombinedFragment[Uml <: UML]
  (domain: UMLCombinedFragment[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CombinedFragmentUpdater[Uml](domain)

  // Comment

  class CommentUpdater[Uml <: UML](val domain: UMLComment[Uml]) extends AnyVal {

    def links_Comment_comment_reference_annotatedElement_Element
    (range: Set[UMLElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Comment_comment_reference_annotatedElement_Element(domain, range)

    def setBody
    (body: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Comment_body(domain, body)

  }

  implicit def enrichComment[Uml <: UML]
  (domain: UMLComment[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CommentUpdater[Uml](domain)

  // CommunicationPath

  class CommunicationPathUpdater[Uml <: UML](val domain: UMLCommunicationPath[Uml]) extends AnyVal {


  }

  implicit def enrichCommunicationPath[Uml <: UML]
  (domain: UMLCommunicationPath[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CommunicationPathUpdater[Uml](domain)

  // Component

  class ComponentUpdater[Uml <: UML](val domain: UMLComponent[Uml]) extends AnyVal {

    def links_Component_component_compose_packagedElement_PackageableElement
    (range: Set[UMLPackageableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Component_component_compose_packagedElement_PackageableElement(domain, range)

    def links_Component_abstraction_compose_realization_ComponentRealization
    (range: Set[UMLComponentRealization[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Component_abstraction_compose_realization_ComponentRealization(domain, range)

    def setIsIndirectlyInstantiated
    (isIndirectlyInstantiated: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Component_isIndirectlyInstantiated(domain, isIndirectlyInstantiated)

  }

  implicit def enrichComponent[Uml <: UML]
  (domain: UMLComponent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ComponentUpdater[Uml](domain)

  // ComponentRealization

  class ComponentRealizationUpdater[Uml <: UML](val domain: UMLComponentRealization[Uml]) extends AnyVal {

    def links_ComponentRealization_componentRealization_reference_realizingClassifier_Classifier
    (range: Set[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ComponentRealization_componentRealization_reference_realizingClassifier_Classifier(domain, range)

  }

  implicit def enrichComponentRealization[Uml <: UML]
  (domain: UMLComponentRealization[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ComponentRealizationUpdater[Uml](domain)

  // ConditionalNode

  class ConditionalNodeUpdater[Uml <: UML](val domain: UMLConditionalNode[Uml]) extends AnyVal {

    def links_ConditionalNode_conditionalNode_compose_clause_Clause
    (range: Set[UMLClause[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ConditionalNode_conditionalNode_compose_clause_Clause(domain, range)

    def links_ConditionalNode_conditionalNode_compose_result_OutputPin
    (range: Seq[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ConditionalNode_conditionalNode_compose_result_OutputPin(domain, range)

    def setIsAssured
    (isAssured: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ConditionalNode_isAssured(domain, isAssured)

    def setIsDeterminate
    (isDeterminate: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ConditionalNode_isDeterminate(domain, isDeterminate)

  }

  implicit def enrichConditionalNode[Uml <: UML]
  (domain: UMLConditionalNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConditionalNodeUpdater[Uml](domain)

  // ConnectableElement

  class ConnectableElementUpdater[Uml <: UML](val domain: UMLConnectableElement[Uml]) extends AnyVal {

    def links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter
    (range: Option[UMLConnectableElementTemplateParameter[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter(domain, range)

  }

  implicit def enrichConnectableElement[Uml <: UML]
  (domain: UMLConnectableElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConnectableElementUpdater[Uml](domain)

  // ConnectableElementTemplateParameter

  class ConnectableElementTemplateParameterUpdater[Uml <: UML](val domain: UMLConnectableElementTemplateParameter[Uml]) extends AnyVal {

    def links_ConnectableElementTemplateParameter_templateParameter_reference_parameteredElement_ConnectableElement
    (range: Option[UMLConnectableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ConnectableElementTemplateParameter_templateParameter_reference_parameteredElement_ConnectableElement(domain, range)

  }

  implicit def enrichConnectableElementTemplateParameter[Uml <: UML]
  (domain: UMLConnectableElementTemplateParameter[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConnectableElementTemplateParameterUpdater[Uml](domain)

  // ConnectionPointReference

  class ConnectionPointReferenceUpdater[Uml <: UML](val domain: UMLConnectionPointReference[Uml]) extends AnyVal {

    def links_ConnectionPointReference_connectionPointReference_reference_entry_Pseudostate
    (range: Set[UMLPseudostate[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ConnectionPointReference_connectionPointReference_reference_entry_Pseudostate(domain, range)

    def links_ConnectionPointReference_connectionPointReference_reference_exit_Pseudostate
    (range: Set[UMLPseudostate[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ConnectionPointReference_connectionPointReference_reference_exit_Pseudostate(domain, range)

  }

  implicit def enrichConnectionPointReference[Uml <: UML]
  (domain: UMLConnectionPointReference[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConnectionPointReferenceUpdater[Uml](domain)

  // Connector

  class ConnectorUpdater[Uml <: UML](val domain: UMLConnector[Uml]) extends AnyVal {

    def links_Connector_connector_reference_contract_Behavior
    (range: Set[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Connector_connector_reference_contract_Behavior(domain, range)

    def links_Connector_connector_compose_end_ConnectorEnd
    (range: Seq[UMLConnectorEnd[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Connector_connector_compose_end_ConnectorEnd(domain, range)

    def links_Connector_connector_reference_redefinedConnector_Connector
    (range: Set[UMLConnector[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Connector_connector_reference_redefinedConnector_Connector(domain, range)

    def links_Connector_connector_reference_type_Association
    (range: Option[UMLAssociation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Connector_connector_reference_type_Association(domain, range)

  }

  implicit def enrichConnector[Uml <: UML]
  (domain: UMLConnector[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConnectorUpdater[Uml](domain)

  // ConnectorEnd

  class ConnectorEndUpdater[Uml <: UML](val domain: UMLConnectorEnd[Uml]) extends AnyVal {

    def links_ConnectorEnd_connectorEnd_reference_partWithPort_Property
    (range: Option[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ConnectorEnd_connectorEnd_reference_partWithPort_Property(domain, range)

  }

  implicit def enrichConnectorEnd[Uml <: UML]
  (domain: UMLConnectorEnd[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConnectorEndUpdater[Uml](domain)

  // ConsiderIgnoreFragment

  class ConsiderIgnoreFragmentUpdater[Uml <: UML](val domain: UMLConsiderIgnoreFragment[Uml]) extends AnyVal {

    def links_ConsiderIgnoreFragment_considerIgnoreFragment_reference_message_NamedElement
    (range: Set[UMLNamedElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ConsiderIgnoreFragment_considerIgnoreFragment_reference_message_NamedElement(domain, range)

  }

  implicit def enrichConsiderIgnoreFragment[Uml <: UML]
  (domain: UMLConsiderIgnoreFragment[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConsiderIgnoreFragmentUpdater[Uml](domain)

  // Constraint

  class ConstraintUpdater[Uml <: UML](val domain: UMLConstraint[Uml]) extends AnyVal {

    def links_Constraint_constraint_reference_constrainedElement_Element
    (range: Seq[UMLElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Constraint_constraint_reference_constrainedElement_Element(domain, range)

    def links_Constraint_owningConstraint_compose_specification_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Constraint_owningConstraint_compose_specification_ValueSpecification(domain, range)

  }

  implicit def enrichConstraint[Uml <: UML]
  (domain: UMLConstraint[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConstraintUpdater[Uml](domain)

  // Continuation

  class ContinuationUpdater[Uml <: UML](val domain: UMLContinuation[Uml]) extends AnyVal {


    def setSetting
    (setting: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Continuation_setting(domain, setting)

  }

  implicit def enrichContinuation[Uml <: UML]
  (domain: UMLContinuation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ContinuationUpdater[Uml](domain)

  // ControlFlow

  class ControlFlowUpdater[Uml <: UML](val domain: UMLControlFlow[Uml]) extends AnyVal {


  }

  implicit def enrichControlFlow[Uml <: UML]
  (domain: UMLControlFlow[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ControlFlowUpdater[Uml](domain)

  // ControlNode

  class ControlNodeUpdater[Uml <: UML](val domain: UMLControlNode[Uml]) extends AnyVal {


  }

  implicit def enrichControlNode[Uml <: UML]
  (domain: UMLControlNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ControlNodeUpdater[Uml](domain)

  // CreateLinkAction

  class CreateLinkActionUpdater[Uml <: UML](val domain: UMLCreateLinkAction[Uml]) extends AnyVal {

    def links_CreateLinkAction_createLinkAction_compose_endData_LinkEndCreationData
    (range: Iterable[UMLLinkEndCreationData[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CreateLinkAction_createLinkAction_compose_endData_LinkEndCreationData(domain, range)

  }

  implicit def enrichCreateLinkAction[Uml <: UML]
  (domain: UMLCreateLinkAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CreateLinkActionUpdater[Uml](domain)

  // CreateLinkObjectAction

  class CreateLinkObjectActionUpdater[Uml <: UML](val domain: UMLCreateLinkObjectAction[Uml]) extends AnyVal {

    def links_CreateLinkObjectAction_createLinkObjectAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CreateLinkObjectAction_createLinkObjectAction_compose_result_OutputPin(domain, range)

  }

  implicit def enrichCreateLinkObjectAction[Uml <: UML]
  (domain: UMLCreateLinkObjectAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CreateLinkObjectActionUpdater[Uml](domain)

  // CreateObjectAction

  class CreateObjectActionUpdater[Uml <: UML](val domain: UMLCreateObjectAction[Uml]) extends AnyVal {

    def links_CreateObjectAction_createObjectAction_reference_classifier_Classifier
    (range: Option[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CreateObjectAction_createObjectAction_reference_classifier_Classifier(domain, range)

    def links_CreateObjectAction_createObjectAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_CreateObjectAction_createObjectAction_compose_result_OutputPin(domain, range)

  }

  implicit def enrichCreateObjectAction[Uml <: UML]
  (domain: UMLCreateObjectAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CreateObjectActionUpdater[Uml](domain)

  // DataStoreNode

  class DataStoreNodeUpdater[Uml <: UML](val domain: UMLDataStoreNode[Uml]) extends AnyVal {


  }

  implicit def enrichDataStoreNode[Uml <: UML]
  (domain: UMLDataStoreNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DataStoreNodeUpdater[Uml](domain)

  // DataType

  class DataTypeUpdater[Uml <: UML](val domain: UMLDataType[Uml]) extends AnyVal {

    def links_DataType_datatype_compose_ownedAttribute_Property
    (range: Seq[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_DataType_datatype_compose_ownedAttribute_Property(domain, range)

    def links_DataType_datatype_compose_ownedOperation_Operation
    (range: Seq[UMLOperation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_DataType_datatype_compose_ownedOperation_Operation(domain, range)

  }

  implicit def enrichDataType[Uml <: UML]
  (domain: UMLDataType[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DataTypeUpdater[Uml](domain)

  // DecisionNode

  class DecisionNodeUpdater[Uml <: UML](val domain: UMLDecisionNode[Uml]) extends AnyVal {

    def links_DecisionNode_decisionNode_reference_decisionInput_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_DecisionNode_decisionNode_reference_decisionInput_Behavior(domain, range)

    def links_DecisionNode_decisionNode_reference_decisionInputFlow_ObjectFlow
    (range: Option[UMLObjectFlow[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_DecisionNode_decisionNode_reference_decisionInputFlow_ObjectFlow(domain, range)

  }

  implicit def enrichDecisionNode[Uml <: UML]
  (domain: UMLDecisionNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DecisionNodeUpdater[Uml](domain)

  // Dependency

  class DependencyUpdater[Uml <: UML](val domain: UMLDependency[Uml]) extends AnyVal {

    def links_Dependency_supplierDependency_reference_supplier_NamedElement
    (range: Set[UMLNamedElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Dependency_supplierDependency_reference_supplier_NamedElement(domain, range)

  }

  implicit def enrichDependency[Uml <: UML]
  (domain: UMLDependency[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DependencyUpdater[Uml](domain)

  // DeployedArtifact

  class DeployedArtifactUpdater[Uml <: UML](val domain: UMLDeployedArtifact[Uml]) extends AnyVal {


  }

  implicit def enrichDeployedArtifact[Uml <: UML]
  (domain: UMLDeployedArtifact[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DeployedArtifactUpdater[Uml](domain)

  // Deployment

  class DeploymentUpdater[Uml <: UML](val domain: UMLDeployment[Uml]) extends AnyVal {

    def links_Deployment_deployment_compose_configuration_DeploymentSpecification
    (range: Set[UMLDeploymentSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Deployment_deployment_compose_configuration_DeploymentSpecification(domain, range)

    def links_Deployment_deploymentForArtifact_reference_deployedArtifact_DeployedArtifact
    (range: Set[UMLDeployedArtifact[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Deployment_deploymentForArtifact_reference_deployedArtifact_DeployedArtifact(domain, range)

  }

  implicit def enrichDeployment[Uml <: UML]
  (domain: UMLDeployment[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DeploymentUpdater[Uml](domain)

  // DeploymentSpecification

  class DeploymentSpecificationUpdater[Uml <: UML](val domain: UMLDeploymentSpecification[Uml]) extends AnyVal {


    def setDeploymentLocation
    (deploymentLocation: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_DeploymentSpecification_deploymentLocation(domain, deploymentLocation)

    def setExecutionLocation
    (executionLocation: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_DeploymentSpecification_executionLocation(domain, executionLocation)

  }

  implicit def enrichDeploymentSpecification[Uml <: UML]
  (domain: UMLDeploymentSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DeploymentSpecificationUpdater[Uml](domain)

  // DeploymentTarget

  class DeploymentTargetUpdater[Uml <: UML](val domain: UMLDeploymentTarget[Uml]) extends AnyVal {

    def links_DeploymentTarget_location_compose_deployment_Deployment
    (range: Set[UMLDeployment[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_DeploymentTarget_location_compose_deployment_Deployment(domain, range)

  }

  implicit def enrichDeploymentTarget[Uml <: UML]
  (domain: UMLDeploymentTarget[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DeploymentTargetUpdater[Uml](domain)

  // DestroyLinkAction

  class DestroyLinkActionUpdater[Uml <: UML](val domain: UMLDestroyLinkAction[Uml]) extends AnyVal {

    def links_DestroyLinkAction_destroyLinkAction_compose_endData_LinkEndDestructionData
    (range: Iterable[UMLLinkEndDestructionData[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_DestroyLinkAction_destroyLinkAction_compose_endData_LinkEndDestructionData(domain, range)

  }

  implicit def enrichDestroyLinkAction[Uml <: UML]
  (domain: UMLDestroyLinkAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DestroyLinkActionUpdater[Uml](domain)

  // DestroyObjectAction

  class DestroyObjectActionUpdater[Uml <: UML](val domain: UMLDestroyObjectAction[Uml]) extends AnyVal {

    def links_DestroyObjectAction_destroyObjectAction_compose_target_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_DestroyObjectAction_destroyObjectAction_compose_target_InputPin(domain, range)

    def setIsDestroyLinks
    (isDestroyLinks: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_DestroyObjectAction_isDestroyLinks(domain, isDestroyLinks)

    def setIsDestroyOwnedObjects
    (isDestroyOwnedObjects: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_DestroyObjectAction_isDestroyOwnedObjects(domain, isDestroyOwnedObjects)

  }

  implicit def enrichDestroyObjectAction[Uml <: UML]
  (domain: UMLDestroyObjectAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DestroyObjectActionUpdater[Uml](domain)

  // DestructionOccurrenceSpecification

  class DestructionOccurrenceSpecificationUpdater[Uml <: UML](val domain: UMLDestructionOccurrenceSpecification[Uml]) extends AnyVal {


  }

  implicit def enrichDestructionOccurrenceSpecification[Uml <: UML]
  (domain: UMLDestructionOccurrenceSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DestructionOccurrenceSpecificationUpdater[Uml](domain)

  // Device

  class DeviceUpdater[Uml <: UML](val domain: UMLDevice[Uml]) extends AnyVal {


  }

  implicit def enrichDevice[Uml <: UML]
  (domain: UMLDevice[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DeviceUpdater[Uml](domain)

  // DirectedRelationship

  class DirectedRelationshipUpdater[Uml <: UML](val domain: UMLDirectedRelationship[Uml]) extends AnyVal {


  }

  implicit def enrichDirectedRelationship[Uml <: UML]
  (domain: UMLDirectedRelationship[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DirectedRelationshipUpdater[Uml](domain)

  // Duration

  class DurationUpdater[Uml <: UML](val domain: UMLDuration[Uml]) extends AnyVal {

    def links_Duration_duration_compose_expr_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Duration_duration_compose_expr_ValueSpecification(domain, range)

    def links_Duration_duration_reference_observation_Observation
    (range: Set[UMLObservation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Duration_duration_reference_observation_Observation(domain, range)

  }

  implicit def enrichDuration[Uml <: UML]
  (domain: UMLDuration[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DurationUpdater[Uml](domain)

  // DurationConstraint

  class DurationConstraintUpdater[Uml <: UML](val domain: UMLDurationConstraint[Uml]) extends AnyVal {

    def links_DurationConstraint_durationConstraint_compose_specification_DurationInterval
    (range: Option[UMLDurationInterval[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_DurationConstraint_durationConstraint_compose_specification_DurationInterval(domain, range)

    def setFirstEvent
    (firstEvent: Set[Boolean])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_DurationConstraint_firstEvent(domain, firstEvent)

  }

  implicit def enrichDurationConstraint[Uml <: UML]
  (domain: UMLDurationConstraint[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DurationConstraintUpdater[Uml](domain)

  // DurationInterval

  class DurationIntervalUpdater[Uml <: UML](val domain: UMLDurationInterval[Uml]) extends AnyVal {

    def links_DurationInterval_durationInterval_reference_max_Duration
    (range: Option[UMLDuration[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_DurationInterval_durationInterval_reference_max_Duration(domain, range)

    def links_DurationInterval_durationInterval_reference_min_Duration
    (range: Option[UMLDuration[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_DurationInterval_durationInterval_reference_min_Duration(domain, range)

  }

  implicit def enrichDurationInterval[Uml <: UML]
  (domain: UMLDurationInterval[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DurationIntervalUpdater[Uml](domain)

  // DurationObservation

  class DurationObservationUpdater[Uml <: UML](val domain: UMLDurationObservation[Uml]) extends AnyVal {

    def links_DurationObservation_durationObservation_reference_event_NamedElement
    (range: Seq[UMLNamedElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_DurationObservation_durationObservation_reference_event_NamedElement(domain, range)

    def setFirstEvent
    (firstEvent: Seq[Boolean])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_DurationObservation_firstEvent(domain, firstEvent)

  }

  implicit def enrichDurationObservation[Uml <: UML]
  (domain: UMLDurationObservation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DurationObservationUpdater[Uml](domain)

  // Element

  class ElementUpdater[Uml <: UML](val domain: UMLElement[Uml]) extends AnyVal {

    def links_Element_owningElement_compose_ownedComment_Comment
    (range: Set[UMLComment[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Element_owningElement_compose_ownedComment_Comment(domain, range)

  }

  implicit def enrichElement[Uml <: UML]
  (domain: UMLElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ElementUpdater[Uml](domain)

  // ElementImport

  class ElementImportUpdater[Uml <: UML](val domain: UMLElementImport[Uml]) extends AnyVal {

    def links_ElementImport_import_reference_importedElement_PackageableElement
    (range: Option[UMLPackageableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ElementImport_import_reference_importedElement_PackageableElement(domain, range)

    def setAlias
    (alias: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ElementImport_alias(domain, alias)

    def setVisibility
    (visibility: UMLVisibilityKind.Value)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ElementImport_visibility(domain, visibility)

  }

  implicit def enrichElementImport[Uml <: UML]
  (domain: UMLElementImport[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ElementImportUpdater[Uml](domain)

  // EncapsulatedClassifier

  class EncapsulatedClassifierUpdater[Uml <: UML](val domain: UMLEncapsulatedClassifier[Uml]) extends AnyVal {


  }

  implicit def enrichEncapsulatedClassifier[Uml <: UML]
  (domain: UMLEncapsulatedClassifier[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new EncapsulatedClassifierUpdater[Uml](domain)

  // Enumeration

  class EnumerationUpdater[Uml <: UML](val domain: UMLEnumeration[Uml]) extends AnyVal {

    def links_Enumeration_enumeration_compose_ownedLiteral_EnumerationLiteral
    (range: Seq[UMLEnumerationLiteral[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Enumeration_enumeration_compose_ownedLiteral_EnumerationLiteral(domain, range)

  }

  implicit def enrichEnumeration[Uml <: UML]
  (domain: UMLEnumeration[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new EnumerationUpdater[Uml](domain)

  // EnumerationLiteral

  class EnumerationLiteralUpdater[Uml <: UML](val domain: UMLEnumerationLiteral[Uml]) extends AnyVal {


  }

  implicit def enrichEnumerationLiteral[Uml <: UML]
  (domain: UMLEnumerationLiteral[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new EnumerationLiteralUpdater[Uml](domain)

  // Event

  class EventUpdater[Uml <: UML](val domain: UMLEvent[Uml]) extends AnyVal {


  }

  implicit def enrichEvent[Uml <: UML]
  (domain: UMLEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new EventUpdater[Uml](domain)

  // ExceptionHandler

  class ExceptionHandlerUpdater[Uml <: UML](val domain: UMLExceptionHandler[Uml]) extends AnyVal {

    def links_ExceptionHandler_exceptionHandler_reference_exceptionInput_ObjectNode
    (range: Option[UMLObjectNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ExceptionHandler_exceptionHandler_reference_exceptionInput_ObjectNode(domain, range)

    def links_ExceptionHandler_exceptionHandler_reference_exceptionType_Classifier
    (range: Set[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ExceptionHandler_exceptionHandler_reference_exceptionType_Classifier(domain, range)

    def links_ExceptionHandler_exceptionHandler_reference_handlerBody_ExecutableNode
    (range: Option[UMLExecutableNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ExceptionHandler_exceptionHandler_reference_handlerBody_ExecutableNode(domain, range)

  }

  implicit def enrichExceptionHandler[Uml <: UML]
  (domain: UMLExceptionHandler[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExceptionHandlerUpdater[Uml](domain)

  // ExecutableNode

  class ExecutableNodeUpdater[Uml <: UML](val domain: UMLExecutableNode[Uml]) extends AnyVal {

    def links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler
    (range: Set[UMLExceptionHandler[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler(domain, range)

  }

  implicit def enrichExecutableNode[Uml <: UML]
  (domain: UMLExecutableNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExecutableNodeUpdater[Uml](domain)

  // ExecutionEnvironment

  class ExecutionEnvironmentUpdater[Uml <: UML](val domain: UMLExecutionEnvironment[Uml]) extends AnyVal {


  }

  implicit def enrichExecutionEnvironment[Uml <: UML]
  (domain: UMLExecutionEnvironment[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExecutionEnvironmentUpdater[Uml](domain)

  // ExecutionOccurrenceSpecification

  class ExecutionOccurrenceSpecificationUpdater[Uml <: UML](val domain: UMLExecutionOccurrenceSpecification[Uml]) extends AnyVal {

    def links_ExecutionOccurrenceSpecification_executionOccurrenceSpecification_reference_execution_ExecutionSpecification
    (range: Option[UMLExecutionSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ExecutionOccurrenceSpecification_executionOccurrenceSpecification_reference_execution_ExecutionSpecification(domain, range)

  }

  implicit def enrichExecutionOccurrenceSpecification[Uml <: UML]
  (domain: UMLExecutionOccurrenceSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExecutionOccurrenceSpecificationUpdater[Uml](domain)

  // ExecutionSpecification

  class ExecutionSpecificationUpdater[Uml <: UML](val domain: UMLExecutionSpecification[Uml]) extends AnyVal {

    def links_ExecutionSpecification_executionSpecification_reference_finish_OccurrenceSpecification
    (range: Option[UMLOccurrenceSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ExecutionSpecification_executionSpecification_reference_finish_OccurrenceSpecification(domain, range)

    def links_ExecutionSpecification_executionSpecification_reference_start_OccurrenceSpecification
    (range: Option[UMLOccurrenceSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ExecutionSpecification_executionSpecification_reference_start_OccurrenceSpecification(domain, range)

  }

  implicit def enrichExecutionSpecification[Uml <: UML]
  (domain: UMLExecutionSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExecutionSpecificationUpdater[Uml](domain)

  // ExpansionNode

  class ExpansionNodeUpdater[Uml <: UML](val domain: UMLExpansionNode[Uml]) extends AnyVal {

    def links_ExpansionNode_inputElement_reference_regionAsInput_ExpansionRegion
    (range: Option[UMLExpansionRegion[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ExpansionNode_inputElement_reference_regionAsInput_ExpansionRegion(domain, range)

    def links_ExpansionNode_outputElement_reference_regionAsOutput_ExpansionRegion
    (range: Option[UMLExpansionRegion[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ExpansionNode_outputElement_reference_regionAsOutput_ExpansionRegion(domain, range)

  }

  implicit def enrichExpansionNode[Uml <: UML]
  (domain: UMLExpansionNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExpansionNodeUpdater[Uml](domain)

  // ExpansionRegion

  class ExpansionRegionUpdater[Uml <: UML](val domain: UMLExpansionRegion[Uml]) extends AnyVal {

    def links_ExpansionRegion_regionAsInput_reference_inputElement_ExpansionNode
    (range: Set[UMLExpansionNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ExpansionRegion_regionAsInput_reference_inputElement_ExpansionNode(domain, range)

    def links_ExpansionRegion_regionAsOutput_reference_outputElement_ExpansionNode
    (range: Set[UMLExpansionNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ExpansionRegion_regionAsOutput_reference_outputElement_ExpansionNode(domain, range)

    def setMode
    (mode: UMLExpansionKind.Value)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ExpansionRegion_mode(domain, mode)

  }

  implicit def enrichExpansionRegion[Uml <: UML]
  (domain: UMLExpansionRegion[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExpansionRegionUpdater[Uml](domain)

  // Expression

  class ExpressionUpdater[Uml <: UML](val domain: UMLExpression[Uml]) extends AnyVal {

    def links_Expression_expression_compose_operand_ValueSpecification
    (range: Seq[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Expression_expression_compose_operand_ValueSpecification(domain, range)

    def setSymbol
    (symbol: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Expression_symbol(domain, symbol)

  }

  implicit def enrichExpression[Uml <: UML]
  (domain: UMLExpression[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExpressionUpdater[Uml](domain)

  // Extend

  class ExtendUpdater[Uml <: UML](val domain: UMLExtend[Uml]) extends AnyVal {

    def links_Extend_extend_compose_condition_Constraint
    (range: Option[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Extend_extend_compose_condition_Constraint(domain, range)

    def links_Extend_extend_reference_extendedCase_UseCase
    (range: Option[UMLUseCase[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Extend_extend_reference_extendedCase_UseCase(domain, range)

    def links_Extend_extension_reference_extensionLocation_ExtensionPoint
    (range: Seq[UMLExtensionPoint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Extend_extension_reference_extensionLocation_ExtensionPoint(domain, range)

  }

  implicit def enrichExtend[Uml <: UML]
  (domain: UMLExtend[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExtendUpdater[Uml](domain)

  // Extension

  class ExtensionUpdater[Uml <: UML](val domain: UMLExtension[Uml]) extends AnyVal {

    def links_Extension_extension_compose_ownedEnd_ExtensionEnd
    (range: Iterable[UMLExtensionEnd[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Extension_extension_compose_ownedEnd_ExtensionEnd(domain, range)

  }

  implicit def enrichExtension[Uml <: UML]
  (domain: UMLExtension[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExtensionUpdater[Uml](domain)

  // ExtensionEnd

  class ExtensionEndUpdater[Uml <: UML](val domain: UMLExtensionEnd[Uml]) extends AnyVal {

    def links_ExtensionEnd_extensionEnd_reference_type_Stereotype
    (range: Option[UMLStereotype[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ExtensionEnd_extensionEnd_reference_type_Stereotype(domain, range)

  }

  implicit def enrichExtensionEnd[Uml <: UML]
  (domain: UMLExtensionEnd[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExtensionEndUpdater[Uml](domain)

  // ExtensionPoint

  class ExtensionPointUpdater[Uml <: UML](val domain: UMLExtensionPoint[Uml]) extends AnyVal {


  }

  implicit def enrichExtensionPoint[Uml <: UML]
  (domain: UMLExtensionPoint[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExtensionPointUpdater[Uml](domain)

  // Feature

  class FeatureUpdater[Uml <: UML](val domain: UMLFeature[Uml]) extends AnyVal {


    def setIsStatic
    (isStatic: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Feature_isStatic(domain, isStatic)

  }

  implicit def enrichFeature[Uml <: UML]
  (domain: UMLFeature[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new FeatureUpdater[Uml](domain)

  // FinalNode

  class FinalNodeUpdater[Uml <: UML](val domain: UMLFinalNode[Uml]) extends AnyVal {


  }

  implicit def enrichFinalNode[Uml <: UML]
  (domain: UMLFinalNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new FinalNodeUpdater[Uml](domain)

  // FinalState

  class FinalStateUpdater[Uml <: UML](val domain: UMLFinalState[Uml]) extends AnyVal {


  }

  implicit def enrichFinalState[Uml <: UML]
  (domain: UMLFinalState[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new FinalStateUpdater[Uml](domain)

  // FlowFinalNode

  class FlowFinalNodeUpdater[Uml <: UML](val domain: UMLFlowFinalNode[Uml]) extends AnyVal {


  }

  implicit def enrichFlowFinalNode[Uml <: UML]
  (domain: UMLFlowFinalNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new FlowFinalNodeUpdater[Uml](domain)

  // ForkNode

  class ForkNodeUpdater[Uml <: UML](val domain: UMLForkNode[Uml]) extends AnyVal {


  }

  implicit def enrichForkNode[Uml <: UML]
  (domain: UMLForkNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ForkNodeUpdater[Uml](domain)

  // FunctionBehavior

  class FunctionBehaviorUpdater[Uml <: UML](val domain: UMLFunctionBehavior[Uml]) extends AnyVal {


  }

  implicit def enrichFunctionBehavior[Uml <: UML]
  (domain: UMLFunctionBehavior[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new FunctionBehaviorUpdater[Uml](domain)

  // Gate

  class GateUpdater[Uml <: UML](val domain: UMLGate[Uml]) extends AnyVal {


  }

  implicit def enrichGate[Uml <: UML]
  (domain: UMLGate[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new GateUpdater[Uml](domain)

  // GeneralOrdering

  class GeneralOrderingUpdater[Uml <: UML](val domain: UMLGeneralOrdering[Uml]) extends AnyVal {

    def links_GeneralOrdering_toBefore_reference_after_OccurrenceSpecification
    (range: Option[UMLOccurrenceSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_GeneralOrdering_toBefore_reference_after_OccurrenceSpecification(domain, range)

    def links_GeneralOrdering_toAfter_reference_before_OccurrenceSpecification
    (range: Option[UMLOccurrenceSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_GeneralOrdering_toAfter_reference_before_OccurrenceSpecification(domain, range)

  }

  implicit def enrichGeneralOrdering[Uml <: UML]
  (domain: UMLGeneralOrdering[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new GeneralOrderingUpdater[Uml](domain)

  // Generalization

  class GeneralizationUpdater[Uml <: UML](val domain: UMLGeneralization[Uml]) extends AnyVal {

    def links_Generalization_generalization_reference_general_Classifier
    (range: Option[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Generalization_generalization_reference_general_Classifier(domain, range)

    def links_Generalization_generalization_reference_generalizationSet_GeneralizationSet
    (range: Set[UMLGeneralizationSet[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Generalization_generalization_reference_generalizationSet_GeneralizationSet(domain, range)

    def setIsSubstitutable
    (isSubstitutable: Option[Boolean])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Generalization_isSubstitutable(domain, isSubstitutable)

  }

  implicit def enrichGeneralization[Uml <: UML]
  (domain: UMLGeneralization[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new GeneralizationUpdater[Uml](domain)

  // GeneralizationSet

  class GeneralizationSetUpdater[Uml <: UML](val domain: UMLGeneralizationSet[Uml]) extends AnyVal {

    def links_GeneralizationSet_generalizationSet_reference_generalization_Generalization
    (range: Set[UMLGeneralization[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_GeneralizationSet_generalizationSet_reference_generalization_Generalization(domain, range)

    def links_GeneralizationSet_powertypeExtent_reference_powertype_Classifier
    (range: Option[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_GeneralizationSet_powertypeExtent_reference_powertype_Classifier(domain, range)

    def setIsCovering
    (isCovering: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_GeneralizationSet_isCovering(domain, isCovering)

    def setIsDisjoint
    (isDisjoint: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_GeneralizationSet_isDisjoint(domain, isDisjoint)

  }

  implicit def enrichGeneralizationSet[Uml <: UML]
  (domain: UMLGeneralizationSet[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new GeneralizationSetUpdater[Uml](domain)

  // Image

  class ImageUpdater[Uml <: UML](val domain: UMLImage[Uml]) extends AnyVal {


    def setContent
    (content: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Image_content(domain, content)

    def setFormat
    (format: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Image_format(domain, format)

    def setLocation
    (location: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Image_location(domain, location)

  }

  implicit def enrichImage[Uml <: UML]
  (domain: UMLImage[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ImageUpdater[Uml](domain)

  // Include

  class IncludeUpdater[Uml <: UML](val domain: UMLInclude[Uml]) extends AnyVal {

    def links_Include_include_reference_addition_UseCase
    (range: Option[UMLUseCase[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Include_include_reference_addition_UseCase(domain, range)

  }

  implicit def enrichInclude[Uml <: UML]
  (domain: UMLInclude[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new IncludeUpdater[Uml](domain)

  // InformationFlow

  class InformationFlowUpdater[Uml <: UML](val domain: UMLInformationFlow[Uml]) extends AnyVal {

    def links_InformationFlow_conveyingFlow_reference_conveyed_Classifier
    (range: Set[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InformationFlow_conveyingFlow_reference_conveyed_Classifier(domain, range)

    def links_InformationFlow_informationFlow_reference_informationSource_NamedElement
    (range: Set[UMLNamedElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InformationFlow_informationFlow_reference_informationSource_NamedElement(domain, range)

    def links_InformationFlow_informationFlow_reference_informationTarget_NamedElement
    (range: Set[UMLNamedElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InformationFlow_informationFlow_reference_informationTarget_NamedElement(domain, range)

    def links_InformationFlow_abstraction_reference_realization_Relationship
    (range: Set[UMLRelationship[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InformationFlow_abstraction_reference_realization_Relationship(domain, range)

    def links_InformationFlow_informationFlow_reference_realizingActivityEdge_ActivityEdge
    (range: Set[UMLActivityEdge[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InformationFlow_informationFlow_reference_realizingActivityEdge_ActivityEdge(domain, range)

    def links_InformationFlow_informationFlow_reference_realizingConnector_Connector
    (range: Set[UMLConnector[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InformationFlow_informationFlow_reference_realizingConnector_Connector(domain, range)

    def links_InformationFlow_informationFlow_reference_realizingMessage_Message
    (range: Set[UMLMessage[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InformationFlow_informationFlow_reference_realizingMessage_Message(domain, range)

  }

  implicit def enrichInformationFlow[Uml <: UML]
  (domain: UMLInformationFlow[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InformationFlowUpdater[Uml](domain)

  // InformationItem

  class InformationItemUpdater[Uml <: UML](val domain: UMLInformationItem[Uml]) extends AnyVal {

    def links_InformationItem_representation_reference_represented_Classifier
    (range: Set[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InformationItem_representation_reference_represented_Classifier(domain, range)

  }

  implicit def enrichInformationItem[Uml <: UML]
  (domain: UMLInformationItem[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InformationItemUpdater[Uml](domain)

  // InitialNode

  class InitialNodeUpdater[Uml <: UML](val domain: UMLInitialNode[Uml]) extends AnyVal {


  }

  implicit def enrichInitialNode[Uml <: UML]
  (domain: UMLInitialNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InitialNodeUpdater[Uml](domain)

  // InputPin

  class InputPinUpdater[Uml <: UML](val domain: UMLInputPin[Uml]) extends AnyVal {


  }

  implicit def enrichInputPin[Uml <: UML]
  (domain: UMLInputPin[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InputPinUpdater[Uml](domain)

  // InstanceSpecification

  class InstanceSpecificationUpdater[Uml <: UML](val domain: UMLInstanceSpecification[Uml]) extends AnyVal {

    def links_InstanceSpecification_instanceSpecification_reference_classifier_Classifier
    (range: Iterable[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InstanceSpecification_instanceSpecification_reference_classifier_Classifier(domain, range)

    def links_InstanceSpecification_owningInstance_compose_slot_Slot
    (range: Set[UMLSlot[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InstanceSpecification_owningInstance_compose_slot_Slot(domain, range)

    def links_InstanceSpecification_owningInstanceSpec_compose_specification_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InstanceSpecification_owningInstanceSpec_compose_specification_ValueSpecification(domain, range)

  }

  implicit def enrichInstanceSpecification[Uml <: UML]
  (domain: UMLInstanceSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InstanceSpecificationUpdater[Uml](domain)

  // InstanceValue

  class InstanceValueUpdater[Uml <: UML](val domain: UMLInstanceValue[Uml]) extends AnyVal {

    def links_InstanceValue_instanceValue_reference_instance_InstanceSpecification
    (range: Option[UMLInstanceSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InstanceValue_instanceValue_reference_instance_InstanceSpecification(domain, range)

  }

  implicit def enrichInstanceValue[Uml <: UML]
  (domain: UMLInstanceValue[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InstanceValueUpdater[Uml](domain)

  // Interaction

  class InteractionUpdater[Uml <: UML](val domain: UMLInteraction[Uml]) extends AnyVal {

    def links_Interaction_interaction_compose_action_Action
    (range: Set[UMLAction[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interaction_interaction_compose_action_Action(domain, range)

    def links_Interaction_interaction_compose_formalGate_Gate
    (range: Set[UMLGate[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interaction_interaction_compose_formalGate_Gate(domain, range)

    def links_Interaction_enclosingInteraction_compose_fragment_InteractionFragment
    (range: Seq[UMLInteractionFragment[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interaction_enclosingInteraction_compose_fragment_InteractionFragment(domain, range)

    def links_Interaction_interaction_compose_lifeline_Lifeline
    (range: Set[UMLLifeline[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interaction_interaction_compose_lifeline_Lifeline(domain, range)

    def links_Interaction_interaction_compose_message_Message
    (range: Set[UMLMessage[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interaction_interaction_compose_message_Message(domain, range)

  }

  implicit def enrichInteraction[Uml <: UML]
  (domain: UMLInteraction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InteractionUpdater[Uml](domain)

  // InteractionConstraint

  class InteractionConstraintUpdater[Uml <: UML](val domain: UMLInteractionConstraint[Uml]) extends AnyVal {

    def links_InteractionConstraint_interactionConstraint_compose_maxint_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InteractionConstraint_interactionConstraint_compose_maxint_ValueSpecification(domain, range)

    def links_InteractionConstraint_interactionConstraint_compose_minint_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InteractionConstraint_interactionConstraint_compose_minint_ValueSpecification(domain, range)

  }

  implicit def enrichInteractionConstraint[Uml <: UML]
  (domain: UMLInteractionConstraint[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InteractionConstraintUpdater[Uml](domain)

  // InteractionFragment

  class InteractionFragmentUpdater[Uml <: UML](val domain: UMLInteractionFragment[Uml]) extends AnyVal {

    def links_InteractionFragment_coveredBy_reference_covered_Lifeline
    (range: Iterable[UMLLifeline[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InteractionFragment_coveredBy_reference_covered_Lifeline(domain, range)

    def links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering
    (range: Set[UMLGeneralOrdering[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering(domain, range)

  }

  implicit def enrichInteractionFragment[Uml <: UML]
  (domain: UMLInteractionFragment[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InteractionFragmentUpdater[Uml](domain)

  // InteractionOperand

  class InteractionOperandUpdater[Uml <: UML](val domain: UMLInteractionOperand[Uml]) extends AnyVal {

    def links_InteractionOperand_enclosingOperand_compose_fragment_InteractionFragment
    (range: Seq[UMLInteractionFragment[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InteractionOperand_enclosingOperand_compose_fragment_InteractionFragment(domain, range)

    def links_InteractionOperand_interactionOperand_compose_guard_InteractionConstraint
    (range: Option[UMLInteractionConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InteractionOperand_interactionOperand_compose_guard_InteractionConstraint(domain, range)

  }

  implicit def enrichInteractionOperand[Uml <: UML]
  (domain: UMLInteractionOperand[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InteractionOperandUpdater[Uml](domain)

  // InteractionUse

  class InteractionUseUpdater[Uml <: UML](val domain: UMLInteractionUse[Uml]) extends AnyVal {

    def links_InteractionUse_interactionUse_compose_actualGate_Gate
    (range: Set[UMLGate[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InteractionUse_interactionUse_compose_actualGate_Gate(domain, range)

    def links_InteractionUse_interactionUse_compose_argument_ValueSpecification
    (range: Seq[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InteractionUse_interactionUse_compose_argument_ValueSpecification(domain, range)

    def links_InteractionUse_interactionUse_reference_refersTo_Interaction
    (range: Option[UMLInteraction[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InteractionUse_interactionUse_reference_refersTo_Interaction(domain, range)

    def links_InteractionUse_interactionUse_compose_returnValue_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InteractionUse_interactionUse_compose_returnValue_ValueSpecification(domain, range)

    def links_InteractionUse_interactionUse_reference_returnValueRecipient_Property
    (range: Option[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InteractionUse_interactionUse_reference_returnValueRecipient_Property(domain, range)

  }

  implicit def enrichInteractionUse[Uml <: UML]
  (domain: UMLInteractionUse[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InteractionUseUpdater[Uml](domain)

  // Interface

  class InterfaceUpdater[Uml <: UML](val domain: UMLInterface[Uml]) extends AnyVal {

    def links_Interface_interface_compose_nestedClassifier_Classifier
    (range: Seq[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interface_interface_compose_nestedClassifier_Classifier(domain, range)

    def links_Interface_interface_compose_ownedAttribute_Property
    (range: Seq[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interface_interface_compose_ownedAttribute_Property(domain, range)

    def links_Interface_interface_compose_ownedOperation_Operation
    (range: Seq[UMLOperation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interface_interface_compose_ownedOperation_Operation(domain, range)

    def links_Interface_interface_compose_ownedReception_Reception
    (range: Set[UMLReception[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interface_interface_compose_ownedReception_Reception(domain, range)

    def links_Interface_interface_compose_protocol_ProtocolStateMachine
    (range: Option[UMLProtocolStateMachine[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interface_interface_compose_protocol_ProtocolStateMachine(domain, range)

    def links_Interface_interface_reference_redefinedInterface_Interface
    (range: Set[UMLInterface[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interface_interface_reference_redefinedInterface_Interface(domain, range)

  }

  implicit def enrichInterface[Uml <: UML]
  (domain: UMLInterface[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InterfaceUpdater[Uml](domain)

  // InterfaceRealization

  class InterfaceRealizationUpdater[Uml <: UML](val domain: UMLInterfaceRealization[Uml]) extends AnyVal {

    def links_InterfaceRealization_interfaceRealization_reference_contract_Interface
    (range: Option[UMLInterface[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InterfaceRealization_interfaceRealization_reference_contract_Interface(domain, range)

  }

  implicit def enrichInterfaceRealization[Uml <: UML]
  (domain: UMLInterfaceRealization[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InterfaceRealizationUpdater[Uml](domain)

  // InterruptibleActivityRegion

  class InterruptibleActivityRegionUpdater[Uml <: UML](val domain: UMLInterruptibleActivityRegion[Uml]) extends AnyVal {

    def links_InterruptibleActivityRegion_interrupts_reference_interruptingEdge_ActivityEdge
    (range: Set[UMLActivityEdge[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InterruptibleActivityRegion_interrupts_reference_interruptingEdge_ActivityEdge(domain, range)

    def links_InterruptibleActivityRegion_inInterruptibleRegion_reference_node_ActivityNode
    (range: Set[UMLActivityNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InterruptibleActivityRegion_inInterruptibleRegion_reference_node_ActivityNode(domain, range)

  }

  implicit def enrichInterruptibleActivityRegion[Uml <: UML]
  (domain: UMLInterruptibleActivityRegion[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InterruptibleActivityRegionUpdater[Uml](domain)

  // Interval

  class IntervalUpdater[Uml <: UML](val domain: UMLInterval[Uml]) extends AnyVal {

    def links_Interval_interval_reference_max_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interval_interval_reference_max_ValueSpecification(domain, range)

    def links_Interval_interval_reference_min_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Interval_interval_reference_min_ValueSpecification(domain, range)

  }

  implicit def enrichInterval[Uml <: UML]
  (domain: UMLInterval[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new IntervalUpdater[Uml](domain)

  // IntervalConstraint

  class IntervalConstraintUpdater[Uml <: UML](val domain: UMLIntervalConstraint[Uml]) extends AnyVal {

    def links_IntervalConstraint_intervalConstraint_compose_specification_Interval
    (range: Option[UMLInterval[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_IntervalConstraint_intervalConstraint_compose_specification_Interval(domain, range)

  }

  implicit def enrichIntervalConstraint[Uml <: UML]
  (domain: UMLIntervalConstraint[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new IntervalConstraintUpdater[Uml](domain)

  // InvocationAction

  class InvocationActionUpdater[Uml <: UML](val domain: UMLInvocationAction[Uml]) extends AnyVal {

    def links_InvocationAction_invocationAction_compose_argument_InputPin
    (range: Seq[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InvocationAction_invocationAction_compose_argument_InputPin(domain, range)

    def links_InvocationAction_invocationAction_reference_onPort_Port
    (range: Option[UMLPort[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_InvocationAction_invocationAction_reference_onPort_Port(domain, range)

  }

  implicit def enrichInvocationAction[Uml <: UML]
  (domain: UMLInvocationAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InvocationActionUpdater[Uml](domain)

  // JoinNode

  class JoinNodeUpdater[Uml <: UML](val domain: UMLJoinNode[Uml]) extends AnyVal {

    def links_JoinNode_joinNode_compose_joinSpec_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_JoinNode_joinNode_compose_joinSpec_ValueSpecification(domain, range)

    def setIsCombineDuplicate
    (isCombineDuplicate: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_JoinNode_isCombineDuplicate(domain, isCombineDuplicate)

  }

  implicit def enrichJoinNode[Uml <: UML]
  (domain: UMLJoinNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new JoinNodeUpdater[Uml](domain)

  // Lifeline

  class LifelineUpdater[Uml <: UML](val domain: UMLLifeline[Uml]) extends AnyVal {

    def links_Lifeline_covered_reference_coveredBy_InteractionFragment
    (range: Set[UMLInteractionFragment[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Lifeline_covered_reference_coveredBy_InteractionFragment(domain, range)

    def links_Lifeline_lifeline_reference_decomposedAs_PartDecomposition
    (range: Option[UMLPartDecomposition[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Lifeline_lifeline_reference_decomposedAs_PartDecomposition(domain, range)

    def links_Lifeline_lifeline_reference_represents_ConnectableElement
    (range: Option[UMLConnectableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Lifeline_lifeline_reference_represents_ConnectableElement(domain, range)

    def links_Lifeline_lifeline_compose_selector_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Lifeline_lifeline_compose_selector_ValueSpecification(domain, range)

  }

  implicit def enrichLifeline[Uml <: UML]
  (domain: UMLLifeline[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LifelineUpdater[Uml](domain)

  // LinkAction

  class LinkActionUpdater[Uml <: UML](val domain: UMLLinkAction[Uml]) extends AnyVal {

    def links_LinkAction_linkAction_compose_endData_LinkEndData
    (range: Iterable[UMLLinkEndData[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LinkAction_linkAction_compose_endData_LinkEndData(domain, range)

    def links_LinkAction_linkAction_compose_inputValue_InputPin
    (range: Set[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LinkAction_linkAction_compose_inputValue_InputPin(domain, range)

  }

  implicit def enrichLinkAction[Uml <: UML]
  (domain: UMLLinkAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LinkActionUpdater[Uml](domain)

  // LinkEndCreationData

  class LinkEndCreationDataUpdater[Uml <: UML](val domain: UMLLinkEndCreationData[Uml]) extends AnyVal {

    def links_LinkEndCreationData_linkEndCreationData_reference_insertAt_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LinkEndCreationData_linkEndCreationData_reference_insertAt_InputPin(domain, range)

    def setIsReplaceAll
    (isReplaceAll: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_LinkEndCreationData_isReplaceAll(domain, isReplaceAll)

  }

  implicit def enrichLinkEndCreationData[Uml <: UML]
  (domain: UMLLinkEndCreationData[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LinkEndCreationDataUpdater[Uml](domain)

  // LinkEndData

  class LinkEndDataUpdater[Uml <: UML](val domain: UMLLinkEndData[Uml]) extends AnyVal {

    def links_LinkEndData_linkEndData_reference_end_Property
    (range: Option[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LinkEndData_linkEndData_reference_end_Property(domain, range)

    def links_LinkEndData_linkEndData_compose_qualifier_QualifierValue
    (range: Set[UMLQualifierValue[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LinkEndData_linkEndData_compose_qualifier_QualifierValue(domain, range)

    def links_LinkEndData_linkEndData_reference_value_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LinkEndData_linkEndData_reference_value_InputPin(domain, range)

  }

  implicit def enrichLinkEndData[Uml <: UML]
  (domain: UMLLinkEndData[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LinkEndDataUpdater[Uml](domain)

  // LinkEndDestructionData

  class LinkEndDestructionDataUpdater[Uml <: UML](val domain: UMLLinkEndDestructionData[Uml]) extends AnyVal {

    def links_LinkEndDestructionData_linkEndDestructionData_reference_destroyAt_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LinkEndDestructionData_linkEndDestructionData_reference_destroyAt_InputPin(domain, range)

    def setIsDestroyDuplicates
    (isDestroyDuplicates: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_LinkEndDestructionData_isDestroyDuplicates(domain, isDestroyDuplicates)

  }

  implicit def enrichLinkEndDestructionData[Uml <: UML]
  (domain: UMLLinkEndDestructionData[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LinkEndDestructionDataUpdater[Uml](domain)

  // LiteralBoolean

  class LiteralBooleanUpdater[Uml <: UML](val domain: UMLLiteralBoolean[Uml]) extends AnyVal {


    def setValue
    (value: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_LiteralBoolean_value(domain, value)

  }

  implicit def enrichLiteralBoolean[Uml <: UML]
  (domain: UMLLiteralBoolean[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralBooleanUpdater[Uml](domain)

  // LiteralInteger

  class LiteralIntegerUpdater[Uml <: UML](val domain: UMLLiteralInteger[Uml]) extends AnyVal {


    def setValue
    (value: Integer)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_LiteralInteger_value(domain, value)

  }

  implicit def enrichLiteralInteger[Uml <: UML]
  (domain: UMLLiteralInteger[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralIntegerUpdater[Uml](domain)

  // LiteralNull

  class LiteralNullUpdater[Uml <: UML](val domain: UMLLiteralNull[Uml]) extends AnyVal {


  }

  implicit def enrichLiteralNull[Uml <: UML]
  (domain: UMLLiteralNull[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralNullUpdater[Uml](domain)

  // LiteralReal

  class LiteralRealUpdater[Uml <: UML](val domain: UMLLiteralReal[Uml]) extends AnyVal {


    def setValue
    (value: Double)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_LiteralReal_value(domain, value)

  }

  implicit def enrichLiteralReal[Uml <: UML]
  (domain: UMLLiteralReal[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralRealUpdater[Uml](domain)

  // LiteralSpecification

  class LiteralSpecificationUpdater[Uml <: UML](val domain: UMLLiteralSpecification[Uml]) extends AnyVal {


  }

  implicit def enrichLiteralSpecification[Uml <: UML]
  (domain: UMLLiteralSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralSpecificationUpdater[Uml](domain)

  // LiteralString

  class LiteralStringUpdater[Uml <: UML](val domain: UMLLiteralString[Uml]) extends AnyVal {


    def setValue
    (value: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_LiteralString_value(domain, value)

  }

  implicit def enrichLiteralString[Uml <: UML]
  (domain: UMLLiteralString[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralStringUpdater[Uml](domain)

  // LiteralUnlimitedNatural

  class LiteralUnlimitedNaturalUpdater[Uml <: UML](val domain: UMLLiteralUnlimitedNatural[Uml]) extends AnyVal {


    def setValue
    (value: Integer)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_LiteralUnlimitedNatural_value(domain, value)

  }

  implicit def enrichLiteralUnlimitedNatural[Uml <: UML]
  (domain: UMLLiteralUnlimitedNatural[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralUnlimitedNaturalUpdater[Uml](domain)

  // LoopNode

  class LoopNodeUpdater[Uml <: UML](val domain: UMLLoopNode[Uml]) extends AnyVal {

    def links_LoopNode_loopNode_reference_bodyOutput_OutputPin
    (range: Seq[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LoopNode_loopNode_reference_bodyOutput_OutputPin(domain, range)

    def links_LoopNode_loopNode_reference_bodyPart_ExecutableNode
    (range: Set[UMLExecutableNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LoopNode_loopNode_reference_bodyPart_ExecutableNode(domain, range)

    def links_LoopNode_loopNode_reference_decider_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LoopNode_loopNode_reference_decider_OutputPin(domain, range)

    def links_LoopNode_loopNode_compose_loopVariable_OutputPin
    (range: Seq[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LoopNode_loopNode_compose_loopVariable_OutputPin(domain, range)

    def links_LoopNode_loopNode_compose_loopVariableInput_InputPin
    (range: Seq[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LoopNode_loopNode_compose_loopVariableInput_InputPin(domain, range)

    def links_LoopNode_loopNode_compose_result_OutputPin
    (range: Seq[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LoopNode_loopNode_compose_result_OutputPin(domain, range)

    def links_LoopNode_loopNode_reference_setupPart_ExecutableNode
    (range: Set[UMLExecutableNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LoopNode_loopNode_reference_setupPart_ExecutableNode(domain, range)

    def links_LoopNode_loopNode_reference_test_ExecutableNode
    (range: Set[UMLExecutableNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_LoopNode_loopNode_reference_test_ExecutableNode(domain, range)

    def setIsTestedFirst
    (isTestedFirst: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_LoopNode_isTestedFirst(domain, isTestedFirst)

  }

  implicit def enrichLoopNode[Uml <: UML]
  (domain: UMLLoopNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LoopNodeUpdater[Uml](domain)

  // Manifestation

  class ManifestationUpdater[Uml <: UML](val domain: UMLManifestation[Uml]) extends AnyVal {

    def links_Manifestation_manifestation_reference_utilizedElement_PackageableElement
    (range: Option[UMLPackageableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Manifestation_manifestation_reference_utilizedElement_PackageableElement(domain, range)

  }

  implicit def enrichManifestation[Uml <: UML]
  (domain: UMLManifestation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ManifestationUpdater[Uml](domain)

  // MergeNode

  class MergeNodeUpdater[Uml <: UML](val domain: UMLMergeNode[Uml]) extends AnyVal {


  }

  implicit def enrichMergeNode[Uml <: UML]
  (domain: UMLMergeNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new MergeNodeUpdater[Uml](domain)

  // Message

  class MessageUpdater[Uml <: UML](val domain: UMLMessage[Uml]) extends AnyVal {

    def links_Message_message_compose_argument_ValueSpecification
    (range: Seq[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Message_message_compose_argument_ValueSpecification(domain, range)

    def links_Message_message_reference_connector_Connector
    (range: Option[UMLConnector[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Message_message_reference_connector_Connector(domain, range)

    def links_Message_endMessage_reference_receiveEvent_MessageEnd
    (range: Option[UMLMessageEnd[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Message_endMessage_reference_receiveEvent_MessageEnd(domain, range)

    def links_Message_endMessage_reference_sendEvent_MessageEnd
    (range: Option[UMLMessageEnd[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Message_endMessage_reference_sendEvent_MessageEnd(domain, range)

    def links_Message_message_reference_signature_NamedElement
    (range: Option[UMLNamedElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Message_message_reference_signature_NamedElement(domain, range)

    def setMessageSort
    (messageSort: UMLMessageSort.Value)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Message_messageSort(domain, messageSort)

  }

  implicit def enrichMessage[Uml <: UML]
  (domain: UMLMessage[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new MessageUpdater[Uml](domain)

  // MessageEnd

  class MessageEndUpdater[Uml <: UML](val domain: UMLMessageEnd[Uml]) extends AnyVal {

    def links_MessageEnd_messageEnd_reference_message_Message
    (range: Option[UMLMessage[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_MessageEnd_messageEnd_reference_message_Message(domain, range)

  }

  implicit def enrichMessageEnd[Uml <: UML]
  (domain: UMLMessageEnd[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new MessageEndUpdater[Uml](domain)

  // MessageEvent

  class MessageEventUpdater[Uml <: UML](val domain: UMLMessageEvent[Uml]) extends AnyVal {


  }

  implicit def enrichMessageEvent[Uml <: UML]
  (domain: UMLMessageEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new MessageEventUpdater[Uml](domain)

  // MessageOccurrenceSpecification

  class MessageOccurrenceSpecificationUpdater[Uml <: UML](val domain: UMLMessageOccurrenceSpecification[Uml]) extends AnyVal {


  }

  implicit def enrichMessageOccurrenceSpecification[Uml <: UML]
  (domain: UMLMessageOccurrenceSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new MessageOccurrenceSpecificationUpdater[Uml](domain)

  // Model

  class ModelUpdater[Uml <: UML](val domain: UMLModel[Uml]) extends AnyVal {


    def setViewpoint
    (viewpoint: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Model_viewpoint(domain, viewpoint)

  }

  implicit def enrichModel[Uml <: UML]
  (domain: UMLModel[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ModelUpdater[Uml](domain)

  // MultiplicityElement

  class MultiplicityElementUpdater[Uml <: UML](val domain: UMLMultiplicityElement[Uml]) extends AnyVal {

    def links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification(domain, range)

    def links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification(domain, range)

    def setIsOrdered
    (isOrdered: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_MultiplicityElement_isOrdered(domain, isOrdered)

    def setIsUnique
    (isUnique: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_MultiplicityElement_isUnique(domain, isUnique)

  }

  implicit def enrichMultiplicityElement[Uml <: UML]
  (domain: UMLMultiplicityElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new MultiplicityElementUpdater[Uml](domain)

  // NamedElement

  class NamedElementUpdater[Uml <: UML](val domain: UMLNamedElement[Uml]) extends AnyVal {

    def links_NamedElement_namedElement_compose_nameExpression_StringExpression
    (range: Option[UMLStringExpression[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_NamedElement_namedElement_compose_nameExpression_StringExpression(domain, range)

    def setName
    (name: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_NamedElement_name(domain, name)

    def setVisibility
    (visibility: Option[UMLVisibilityKind.Value])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_NamedElement_visibility(domain, visibility)

  }

  implicit def enrichNamedElement[Uml <: UML]
  (domain: UMLNamedElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new NamedElementUpdater[Uml](domain)

  // Namespace

  class NamespaceUpdater[Uml <: UML](val domain: UMLNamespace[Uml]) extends AnyVal {

    def links_Namespace_importingNamespace_compose_elementImport_ElementImport
    (range: Set[UMLElementImport[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Namespace_importingNamespace_compose_elementImport_ElementImport(domain, range)

    def links_Namespace_context_compose_ownedRule_Constraint
    (range: Set[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Namespace_context_compose_ownedRule_Constraint(domain, range)

    def links_Namespace_importingNamespace_compose_packageImport_PackageImport
    (range: Set[UMLPackageImport[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Namespace_importingNamespace_compose_packageImport_PackageImport(domain, range)

  }

  implicit def enrichNamespace[Uml <: UML]
  (domain: UMLNamespace[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new NamespaceUpdater[Uml](domain)

  // Node

  class NodeUpdater[Uml <: UML](val domain: UMLNode[Uml]) extends AnyVal {

    def links_Node_node_compose_nestedNode_Node
    (range: Set[UMLNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Node_node_compose_nestedNode_Node(domain, range)

  }

  implicit def enrichNode[Uml <: UML]
  (domain: UMLNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new NodeUpdater[Uml](domain)

  // ObjectFlow

  class ObjectFlowUpdater[Uml <: UML](val domain: UMLObjectFlow[Uml]) extends AnyVal {

    def links_ObjectFlow_objectFlow_reference_selection_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ObjectFlow_objectFlow_reference_selection_Behavior(domain, range)

    def links_ObjectFlow_objectFlow_reference_transformation_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ObjectFlow_objectFlow_reference_transformation_Behavior(domain, range)

    def setIsMulticast
    (isMulticast: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ObjectFlow_isMulticast(domain, isMulticast)

    def setIsMultireceive
    (isMultireceive: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ObjectFlow_isMultireceive(domain, isMultireceive)

  }

  implicit def enrichObjectFlow[Uml <: UML]
  (domain: UMLObjectFlow[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ObjectFlowUpdater[Uml](domain)

  // ObjectNode

  class ObjectNodeUpdater[Uml <: UML](val domain: UMLObjectNode[Uml]) extends AnyVal {

    def links_ObjectNode_objectNode_reference_inState_State
    (range: Set[UMLState[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ObjectNode_objectNode_reference_inState_State(domain, range)

    def links_ObjectNode_objectNode_reference_selection_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ObjectNode_objectNode_reference_selection_Behavior(domain, range)

    def links_ObjectNode_objectNode_compose_upperBound_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ObjectNode_objectNode_compose_upperBound_ValueSpecification(domain, range)

    def setIsControlType
    (isControlType: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ObjectNode_isControlType(domain, isControlType)

    def setOrdering
    (ordering: UMLObjectNodeOrderingKind.Value)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ObjectNode_ordering(domain, ordering)

  }

  implicit def enrichObjectNode[Uml <: UML]
  (domain: UMLObjectNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ObjectNodeUpdater[Uml](domain)

  // Observation

  class ObservationUpdater[Uml <: UML](val domain: UMLObservation[Uml]) extends AnyVal {


  }

  implicit def enrichObservation[Uml <: UML]
  (domain: UMLObservation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ObservationUpdater[Uml](domain)

  // OccurrenceSpecification

  class OccurrenceSpecificationUpdater[Uml <: UML](val domain: UMLOccurrenceSpecification[Uml]) extends AnyVal {

    def links_OccurrenceSpecification_events_reference_covered_Lifeline
    (range: Iterable[UMLLifeline[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_OccurrenceSpecification_events_reference_covered_Lifeline(domain, range)

    def links_OccurrenceSpecification_before_reference_toAfter_GeneralOrdering
    (range: Set[UMLGeneralOrdering[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_OccurrenceSpecification_before_reference_toAfter_GeneralOrdering(domain, range)

    def links_OccurrenceSpecification_after_reference_toBefore_GeneralOrdering
    (range: Set[UMLGeneralOrdering[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_OccurrenceSpecification_after_reference_toBefore_GeneralOrdering(domain, range)

  }

  implicit def enrichOccurrenceSpecification[Uml <: UML]
  (domain: UMLOccurrenceSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OccurrenceSpecificationUpdater[Uml](domain)

  // OpaqueAction

  class OpaqueActionUpdater[Uml <: UML](val domain: UMLOpaqueAction[Uml]) extends AnyVal {

    def links_OpaqueAction_opaqueAction_compose_inputValue_InputPin
    (range: Set[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_OpaqueAction_opaqueAction_compose_inputValue_InputPin(domain, range)

    def links_OpaqueAction_opaqueAction_compose_outputValue_OutputPin
    (range: Set[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_OpaqueAction_opaqueAction_compose_outputValue_OutputPin(domain, range)

    def setBody
    (body: Seq[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_OpaqueAction_body(domain, body)

    def setLanguage
    (language: Seq[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_OpaqueAction_language(domain, language)

  }

  implicit def enrichOpaqueAction[Uml <: UML]
  (domain: UMLOpaqueAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OpaqueActionUpdater[Uml](domain)

  // OpaqueBehavior

  class OpaqueBehaviorUpdater[Uml <: UML](val domain: UMLOpaqueBehavior[Uml]) extends AnyVal {


    def setBody
    (body: Seq[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_OpaqueBehavior_body(domain, body)

    def setLanguage
    (language: Seq[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_OpaqueBehavior_language(domain, language)

  }

  implicit def enrichOpaqueBehavior[Uml <: UML]
  (domain: UMLOpaqueBehavior[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OpaqueBehaviorUpdater[Uml](domain)

  // OpaqueExpression

  class OpaqueExpressionUpdater[Uml <: UML](val domain: UMLOpaqueExpression[Uml]) extends AnyVal {

    def links_OpaqueExpression_opaqueExpression_reference_behavior_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_OpaqueExpression_opaqueExpression_reference_behavior_Behavior(domain, range)

    def setBody
    (body: Seq[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_OpaqueExpression_body(domain, body)

    def setLanguage
    (language: Seq[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_OpaqueExpression_language(domain, language)

  }

  implicit def enrichOpaqueExpression[Uml <: UML]
  (domain: UMLOpaqueExpression[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OpaqueExpressionUpdater[Uml](domain)

  // Operation

  class OperationUpdater[Uml <: UML](val domain: UMLOperation[Uml]) extends AnyVal {

    def links_Operation_bodyContext_compose_bodyCondition_Constraint
    (range: Option[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Operation_bodyContext_compose_bodyCondition_Constraint(domain, range)

    def links_Operation_operation_compose_ownedParameter_Parameter
    (range: Seq[UMLParameter[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Operation_operation_compose_ownedParameter_Parameter(domain, range)

    def links_Operation_postContext_compose_postcondition_Constraint
    (range: Set[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Operation_postContext_compose_postcondition_Constraint(domain, range)

    def links_Operation_preContext_compose_precondition_Constraint
    (range: Set[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Operation_preContext_compose_precondition_Constraint(domain, range)

    def links_Operation_operation_reference_raisedException_Type
    (range: Set[UMLType[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Operation_operation_reference_raisedException_Type(domain, range)

    def links_Operation_operation_reference_redefinedOperation_Operation
    (range: Set[UMLOperation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Operation_operation_reference_redefinedOperation_Operation(domain, range)

    def links_Operation_parameteredElement_reference_templateParameter_OperationTemplateParameter
    (range: Option[UMLOperationTemplateParameter[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Operation_parameteredElement_reference_templateParameter_OperationTemplateParameter(domain, range)

    def setIsQuery
    (isQuery: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Operation_isQuery(domain, isQuery)

  }

  implicit def enrichOperation[Uml <: UML]
  (domain: UMLOperation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OperationUpdater[Uml](domain)

  // OperationTemplateParameter

  class OperationTemplateParameterUpdater[Uml <: UML](val domain: UMLOperationTemplateParameter[Uml]) extends AnyVal {

    def links_OperationTemplateParameter_templateParameter_reference_parameteredElement_Operation
    (range: Option[UMLOperation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_OperationTemplateParameter_templateParameter_reference_parameteredElement_Operation(domain, range)

  }

  implicit def enrichOperationTemplateParameter[Uml <: UML]
  (domain: UMLOperationTemplateParameter[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OperationTemplateParameterUpdater[Uml](domain)

  // OutputPin

  class OutputPinUpdater[Uml <: UML](val domain: UMLOutputPin[Uml]) extends AnyVal {


  }

  implicit def enrichOutputPin[Uml <: UML]
  (domain: UMLOutputPin[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OutputPinUpdater[Uml](domain)

  // Package

  class PackageUpdater[Uml <: UML](val domain: UMLPackage[Uml]) extends AnyVal {

    def links_Package_receivingPackage_compose_packageMerge_PackageMerge
    (range: Set[UMLPackageMerge[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Package_receivingPackage_compose_packageMerge_PackageMerge(domain, range)

    def links_Package_owningPackage_compose_packagedElement_PackageableElement
    (range: Set[UMLPackageableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Package_owningPackage_compose_packagedElement_PackageableElement(domain, range)

    def links_Package_applyingPackage_compose_profileApplication_ProfileApplication
    (range: Set[UMLProfileApplication[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Package_applyingPackage_compose_profileApplication_ProfileApplication(domain, range)

    def setURI
    (URI: Option[String])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Package_URI(domain, URI)

  }

  implicit def enrichPackage[Uml <: UML]
  (domain: UMLPackage[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PackageUpdater[Uml](domain)

  // PackageImport

  class PackageImportUpdater[Uml <: UML](val domain: UMLPackageImport[Uml]) extends AnyVal {

    def links_PackageImport_packageImport_reference_importedPackage_Package
    (range: Option[UMLPackage[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_PackageImport_packageImport_reference_importedPackage_Package(domain, range)

    def setVisibility
    (visibility: UMLVisibilityKind.Value)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_PackageImport_visibility(domain, visibility)

  }

  implicit def enrichPackageImport[Uml <: UML]
  (domain: UMLPackageImport[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PackageImportUpdater[Uml](domain)

  // PackageMerge

  class PackageMergeUpdater[Uml <: UML](val domain: UMLPackageMerge[Uml]) extends AnyVal {

    def links_PackageMerge_packageMerge_reference_mergedPackage_Package
    (range: Option[UMLPackage[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_PackageMerge_packageMerge_reference_mergedPackage_Package(domain, range)

  }

  implicit def enrichPackageMerge[Uml <: UML]
  (domain: UMLPackageMerge[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PackageMergeUpdater[Uml](domain)

  // PackageableElement

  class PackageableElementUpdater[Uml <: UML](val domain: UMLPackageableElement[Uml]) extends AnyVal {


    def setVisibility
    (visibility: Option[UMLVisibilityKind.Value])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_PackageableElement_visibility(domain, visibility)

  }

  implicit def enrichPackageableElement[Uml <: UML]
  (domain: UMLPackageableElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PackageableElementUpdater[Uml](domain)

  // Parameter

  class ParameterUpdater[Uml <: UML](val domain: UMLParameter[Uml]) extends AnyVal {

    def links_Parameter_owningParameter_compose_defaultValue_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Parameter_owningParameter_compose_defaultValue_ValueSpecification(domain, range)

    def links_Parameter_parameter_reference_parameterSet_ParameterSet
    (range: Set[UMLParameterSet[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Parameter_parameter_reference_parameterSet_ParameterSet(domain, range)

    def setDirection
    (direction: UMLParameterDirectionKind.Value)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Parameter_direction(domain, direction)

    def setEffect
    (effect: Option[UMLParameterEffectKind.Value])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Parameter_effect(domain, effect)

    def setIsException
    (isException: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Parameter_isException(domain, isException)

    def setIsStream
    (isStream: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Parameter_isStream(domain, isStream)

  }

  implicit def enrichParameter[Uml <: UML]
  (domain: UMLParameter[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ParameterUpdater[Uml](domain)

  // ParameterSet

  class ParameterSetUpdater[Uml <: UML](val domain: UMLParameterSet[Uml]) extends AnyVal {

    def links_ParameterSet_parameterSet_compose_condition_Constraint
    (range: Set[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ParameterSet_parameterSet_compose_condition_Constraint(domain, range)

    def links_ParameterSet_parameterSet_reference_parameter_Parameter
    (range: Set[UMLParameter[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ParameterSet_parameterSet_reference_parameter_Parameter(domain, range)

  }

  implicit def enrichParameterSet[Uml <: UML]
  (domain: UMLParameterSet[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ParameterSetUpdater[Uml](domain)

  // ParameterableElement

  class ParameterableElementUpdater[Uml <: UML](val domain: UMLParameterableElement[Uml]) extends AnyVal {

    def links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter
    (range: Option[UMLTemplateParameter[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter(domain, range)

  }

  implicit def enrichParameterableElement[Uml <: UML]
  (domain: UMLParameterableElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ParameterableElementUpdater[Uml](domain)

  // PartDecomposition

  class PartDecompositionUpdater[Uml <: UML](val domain: UMLPartDecomposition[Uml]) extends AnyVal {


  }

  implicit def enrichPartDecomposition[Uml <: UML]
  (domain: UMLPartDecomposition[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PartDecompositionUpdater[Uml](domain)

  // Pin

  class PinUpdater[Uml <: UML](val domain: UMLPin[Uml]) extends AnyVal {


    def setIsControl
    (isControl: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Pin_isControl(domain, isControl)

  }

  implicit def enrichPin[Uml <: UML]
  (domain: UMLPin[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PinUpdater[Uml](domain)

  // Port

  class PortUpdater[Uml <: UML](val domain: UMLPort[Uml]) extends AnyVal {

    def links_Port_port_reference_protocol_ProtocolStateMachine
    (range: Option[UMLProtocolStateMachine[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Port_port_reference_protocol_ProtocolStateMachine(domain, range)

    def links_Port_port_reference_redefinedPort_Port
    (range: Set[UMLPort[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Port_port_reference_redefinedPort_Port(domain, range)

    def setIsBehavior
    (isBehavior: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Port_isBehavior(domain, isBehavior)

    def setIsConjugated
    (isConjugated: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Port_isConjugated(domain, isConjugated)

    def setIsService
    (isService: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Port_isService(domain, isService)

  }

  implicit def enrichPort[Uml <: UML]
  (domain: UMLPort[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PortUpdater[Uml](domain)

  // PrimitiveType

  class PrimitiveTypeUpdater[Uml <: UML](val domain: UMLPrimitiveType[Uml]) extends AnyVal {


  }

  implicit def enrichPrimitiveType[Uml <: UML]
  (domain: UMLPrimitiveType[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PrimitiveTypeUpdater[Uml](domain)

  // Profile

  class ProfileUpdater[Uml <: UML](val domain: UMLProfile[Uml]) extends AnyVal {

    def links_Profile_profile_compose_metaclassReference_ElementImport
    (range: Set[UMLElementImport[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Profile_profile_compose_metaclassReference_ElementImport(domain, range)

    def links_Profile_profile_compose_metamodelReference_PackageImport
    (range: Set[UMLPackageImport[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Profile_profile_compose_metamodelReference_PackageImport(domain, range)

  }

  implicit def enrichProfile[Uml <: UML]
  (domain: UMLProfile[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ProfileUpdater[Uml](domain)

  // ProfileApplication

  class ProfileApplicationUpdater[Uml <: UML](val domain: UMLProfileApplication[Uml]) extends AnyVal {

    def links_ProfileApplication_profileApplication_reference_appliedProfile_Profile
    (range: Option[UMLProfile[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ProfileApplication_profileApplication_reference_appliedProfile_Profile(domain, range)

    def setIsStrict
    (isStrict: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ProfileApplication_isStrict(domain, isStrict)

  }

  implicit def enrichProfileApplication[Uml <: UML]
  (domain: UMLProfileApplication[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ProfileApplicationUpdater[Uml](domain)

  // Property

  class PropertyUpdater[Uml <: UML](val domain: UMLProperty[Uml]) extends AnyVal {

    def links_Property_memberEnd_reference_association_Association
    (range: Option[UMLAssociation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Property_memberEnd_reference_association_Association(domain, range)

    def links_Property_owningProperty_compose_defaultValue_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Property_owningProperty_compose_defaultValue_ValueSpecification(domain, range)

    def links_Property_associationEnd_compose_qualifier_Property
    (range: Seq[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Property_associationEnd_compose_qualifier_Property(domain, range)

    def links_Property_property_reference_redefinedProperty_Property
    (range: Set[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Property_property_reference_redefinedProperty_Property(domain, range)

    def links_Property_property_reference_subsettedProperty_Property
    (range: Set[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Property_property_reference_subsettedProperty_Property(domain, range)

    def setAggregation
    (aggregation: UMLAggregationKind.Value)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Property_aggregation(domain, aggregation)

    def setIsDerived
    (isDerived: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Property_isDerived(domain, isDerived)

    def setIsDerivedUnion
    (isDerivedUnion: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Property_isDerivedUnion(domain, isDerivedUnion)

    def setIsID
    (isID: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Property_isID(domain, isID)

  }

  implicit def enrichProperty[Uml <: UML]
  (domain: UMLProperty[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PropertyUpdater[Uml](domain)

  // ProtocolConformance

  class ProtocolConformanceUpdater[Uml <: UML](val domain: UMLProtocolConformance[Uml]) extends AnyVal {

    def links_ProtocolConformance_protocolConformance_reference_generalMachine_ProtocolStateMachine
    (range: Option[UMLProtocolStateMachine[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ProtocolConformance_protocolConformance_reference_generalMachine_ProtocolStateMachine(domain, range)

  }

  implicit def enrichProtocolConformance[Uml <: UML]
  (domain: UMLProtocolConformance[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ProtocolConformanceUpdater[Uml](domain)

  // ProtocolStateMachine

  class ProtocolStateMachineUpdater[Uml <: UML](val domain: UMLProtocolStateMachine[Uml]) extends AnyVal {

    def links_ProtocolStateMachine_specificMachine_compose_conformance_ProtocolConformance
    (range: Set[UMLProtocolConformance[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ProtocolStateMachine_specificMachine_compose_conformance_ProtocolConformance(domain, range)

  }

  implicit def enrichProtocolStateMachine[Uml <: UML]
  (domain: UMLProtocolStateMachine[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ProtocolStateMachineUpdater[Uml](domain)

  // ProtocolTransition

  class ProtocolTransitionUpdater[Uml <: UML](val domain: UMLProtocolTransition[Uml]) extends AnyVal {

    def links_ProtocolTransition_owningTransition_compose_postCondition_Constraint
    (range: Option[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ProtocolTransition_owningTransition_compose_postCondition_Constraint(domain, range)

    def links_ProtocolTransition_protocolTransition_compose_preCondition_Constraint
    (range: Option[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ProtocolTransition_protocolTransition_compose_preCondition_Constraint(domain, range)

  }

  implicit def enrichProtocolTransition[Uml <: UML]
  (domain: UMLProtocolTransition[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ProtocolTransitionUpdater[Uml](domain)

  // Pseudostate

  class PseudostateUpdater[Uml <: UML](val domain: UMLPseudostate[Uml]) extends AnyVal {


    def setKind
    (kind: UMLPseudostateKind.Value)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Pseudostate_kind(domain, kind)

  }

  implicit def enrichPseudostate[Uml <: UML]
  (domain: UMLPseudostate[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PseudostateUpdater[Uml](domain)

  // QualifierValue

  class QualifierValueUpdater[Uml <: UML](val domain: UMLQualifierValue[Uml]) extends AnyVal {

    def links_QualifierValue_qualifierValue_reference_qualifier_Property
    (range: Option[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_QualifierValue_qualifierValue_reference_qualifier_Property(domain, range)

    def links_QualifierValue_qualifierValue_reference_value_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_QualifierValue_qualifierValue_reference_value_InputPin(domain, range)

  }

  implicit def enrichQualifierValue[Uml <: UML]
  (domain: UMLQualifierValue[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new QualifierValueUpdater[Uml](domain)

  // RaiseExceptionAction

  class RaiseExceptionActionUpdater[Uml <: UML](val domain: UMLRaiseExceptionAction[Uml]) extends AnyVal {

    def links_RaiseExceptionAction_raiseExceptionAction_compose_exception_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_RaiseExceptionAction_raiseExceptionAction_compose_exception_InputPin(domain, range)

  }

  implicit def enrichRaiseExceptionAction[Uml <: UML]
  (domain: UMLRaiseExceptionAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RaiseExceptionActionUpdater[Uml](domain)

  // ReadExtentAction

  class ReadExtentActionUpdater[Uml <: UML](val domain: UMLReadExtentAction[Uml]) extends AnyVal {

    def links_ReadExtentAction_readExtentAction_reference_classifier_Classifier
    (range: Option[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadExtentAction_readExtentAction_reference_classifier_Classifier(domain, range)

    def links_ReadExtentAction_readExtentAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadExtentAction_readExtentAction_compose_result_OutputPin(domain, range)

  }

  implicit def enrichReadExtentAction[Uml <: UML]
  (domain: UMLReadExtentAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadExtentActionUpdater[Uml](domain)

  // ReadIsClassifiedObjectAction

  class ReadIsClassifiedObjectActionUpdater[Uml <: UML](val domain: UMLReadIsClassifiedObjectAction[Uml]) extends AnyVal {

    def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_reference_classifier_Classifier
    (range: Option[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_reference_classifier_Classifier(domain, range)

    def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_object_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_object_InputPin(domain, range)

    def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_result_OutputPin(domain, range)

    def setIsDirect
    (isDirect: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ReadIsClassifiedObjectAction_isDirect(domain, isDirect)

  }

  implicit def enrichReadIsClassifiedObjectAction[Uml <: UML]
  (domain: UMLReadIsClassifiedObjectAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadIsClassifiedObjectActionUpdater[Uml](domain)

  // ReadLinkAction

  class ReadLinkActionUpdater[Uml <: UML](val domain: UMLReadLinkAction[Uml]) extends AnyVal {

    def links_ReadLinkAction_readLinkAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadLinkAction_readLinkAction_compose_result_OutputPin(domain, range)

  }

  implicit def enrichReadLinkAction[Uml <: UML]
  (domain: UMLReadLinkAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadLinkActionUpdater[Uml](domain)

  // ReadLinkObjectEndAction

  class ReadLinkObjectEndActionUpdater[Uml <: UML](val domain: UMLReadLinkObjectEndAction[Uml]) extends AnyVal {

    def links_ReadLinkObjectEndAction_readLinkObjectEndAction_reference_end_Property
    (range: Option[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadLinkObjectEndAction_readLinkObjectEndAction_reference_end_Property(domain, range)

    def links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_object_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_object_InputPin(domain, range)

    def links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_result_OutputPin(domain, range)

  }

  implicit def enrichReadLinkObjectEndAction[Uml <: UML]
  (domain: UMLReadLinkObjectEndAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadLinkObjectEndActionUpdater[Uml](domain)

  // ReadLinkObjectEndQualifierAction

  class ReadLinkObjectEndQualifierActionUpdater[Uml <: UML](val domain: UMLReadLinkObjectEndQualifierAction[Uml]) extends AnyVal {

    def links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_object_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_object_InputPin(domain, range)

    def links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_reference_qualifier_Property
    (range: Option[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_reference_qualifier_Property(domain, range)

    def links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_result_OutputPin(domain, range)

  }

  implicit def enrichReadLinkObjectEndQualifierAction[Uml <: UML]
  (domain: UMLReadLinkObjectEndQualifierAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadLinkObjectEndQualifierActionUpdater[Uml](domain)

  // ReadSelfAction

  class ReadSelfActionUpdater[Uml <: UML](val domain: UMLReadSelfAction[Uml]) extends AnyVal {

    def links_ReadSelfAction_readSelfAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadSelfAction_readSelfAction_compose_result_OutputPin(domain, range)

  }

  implicit def enrichReadSelfAction[Uml <: UML]
  (domain: UMLReadSelfAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadSelfActionUpdater[Uml](domain)

  // ReadStructuralFeatureAction

  class ReadStructuralFeatureActionUpdater[Uml <: UML](val domain: UMLReadStructuralFeatureAction[Uml]) extends AnyVal {

    def links_ReadStructuralFeatureAction_readStructuralFeatureAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadStructuralFeatureAction_readStructuralFeatureAction_compose_result_OutputPin(domain, range)

  }

  implicit def enrichReadStructuralFeatureAction[Uml <: UML]
  (domain: UMLReadStructuralFeatureAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadStructuralFeatureActionUpdater[Uml](domain)

  // ReadVariableAction

  class ReadVariableActionUpdater[Uml <: UML](val domain: UMLReadVariableAction[Uml]) extends AnyVal {

    def links_ReadVariableAction_readVariableAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReadVariableAction_readVariableAction_compose_result_OutputPin(domain, range)

  }

  implicit def enrichReadVariableAction[Uml <: UML]
  (domain: UMLReadVariableAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadVariableActionUpdater[Uml](domain)

  // Realization

  class RealizationUpdater[Uml <: UML](val domain: UMLRealization[Uml]) extends AnyVal {


  }

  implicit def enrichRealization[Uml <: UML]
  (domain: UMLRealization[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RealizationUpdater[Uml](domain)

  // Reception

  class ReceptionUpdater[Uml <: UML](val domain: UMLReception[Uml]) extends AnyVal {

    def links_Reception_reception_reference_signal_Signal
    (range: Option[UMLSignal[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Reception_reception_reference_signal_Signal(domain, range)

  }

  implicit def enrichReception[Uml <: UML]
  (domain: UMLReception[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReceptionUpdater[Uml](domain)

  // ReclassifyObjectAction

  class ReclassifyObjectActionUpdater[Uml <: UML](val domain: UMLReclassifyObjectAction[Uml]) extends AnyVal {

    def links_ReclassifyObjectAction_reclassifyObjectAction_reference_newClassifier_Classifier
    (range: Set[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReclassifyObjectAction_reclassifyObjectAction_reference_newClassifier_Classifier(domain, range)

    def links_ReclassifyObjectAction_reclassifyObjectAction_compose_object_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReclassifyObjectAction_reclassifyObjectAction_compose_object_InputPin(domain, range)

    def links_ReclassifyObjectAction_reclassifyObjectAction_reference_oldClassifier_Classifier
    (range: Set[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReclassifyObjectAction_reclassifyObjectAction_reference_oldClassifier_Classifier(domain, range)

    def setIsReplaceAll
    (isReplaceAll: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ReclassifyObjectAction_isReplaceAll(domain, isReplaceAll)

  }

  implicit def enrichReclassifyObjectAction[Uml <: UML]
  (domain: UMLReclassifyObjectAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReclassifyObjectActionUpdater[Uml](domain)

  // RedefinableElement

  class RedefinableElementUpdater[Uml <: UML](val domain: UMLRedefinableElement[Uml]) extends AnyVal {


    def setIsLeaf
    (isLeaf: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_RedefinableElement_isLeaf(domain, isLeaf)

  }

  implicit def enrichRedefinableElement[Uml <: UML]
  (domain: UMLRedefinableElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RedefinableElementUpdater[Uml](domain)

  // RedefinableTemplateSignature

  class RedefinableTemplateSignatureUpdater[Uml <: UML](val domain: UMLRedefinableTemplateSignature[Uml]) extends AnyVal {

    def links_RedefinableTemplateSignature_redefinableTemplateSignature_reference_extendedSignature_RedefinableTemplateSignature
    (range: Set[UMLRedefinableTemplateSignature[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_RedefinableTemplateSignature_redefinableTemplateSignature_reference_extendedSignature_RedefinableTemplateSignature(domain, range)

  }

  implicit def enrichRedefinableTemplateSignature[Uml <: UML]
  (domain: UMLRedefinableTemplateSignature[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RedefinableTemplateSignatureUpdater[Uml](domain)

  // ReduceAction

  class ReduceActionUpdater[Uml <: UML](val domain: UMLReduceAction[Uml]) extends AnyVal {

    def links_ReduceAction_reduceAction_compose_collection_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReduceAction_reduceAction_compose_collection_InputPin(domain, range)

    def links_ReduceAction_reduceAction_reference_reducer_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReduceAction_reduceAction_reference_reducer_Behavior(domain, range)

    def links_ReduceAction_reduceAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReduceAction_reduceAction_compose_result_OutputPin(domain, range)

    def setIsOrdered
    (isOrdered: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_ReduceAction_isOrdered(domain, isOrdered)

  }

  implicit def enrichReduceAction[Uml <: UML]
  (domain: UMLReduceAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReduceActionUpdater[Uml](domain)

  // Region

  class RegionUpdater[Uml <: UML](val domain: UMLRegion[Uml]) extends AnyVal {

    def links_Region_region_reference_extendedRegion_Region
    (range: Option[UMLRegion[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Region_region_reference_extendedRegion_Region(domain, range)

    def links_Region_container_compose_subvertex_Vertex
    (range: Set[UMLVertex[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Region_container_compose_subvertex_Vertex(domain, range)

    def links_Region_container_compose_transition_Transition
    (range: Set[UMLTransition[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Region_container_compose_transition_Transition(domain, range)

  }

  implicit def enrichRegion[Uml <: UML]
  (domain: UMLRegion[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RegionUpdater[Uml](domain)

  // Relationship

  class RelationshipUpdater[Uml <: UML](val domain: UMLRelationship[Uml]) extends AnyVal {


  }

  implicit def enrichRelationship[Uml <: UML]
  (domain: UMLRelationship[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RelationshipUpdater[Uml](domain)

  // RemoveStructuralFeatureValueAction

  class RemoveStructuralFeatureValueActionUpdater[Uml <: UML](val domain: UMLRemoveStructuralFeatureValueAction[Uml]) extends AnyVal {

    def links_RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_compose_removeAt_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_compose_removeAt_InputPin(domain, range)

    def setIsRemoveDuplicates
    (isRemoveDuplicates: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_RemoveStructuralFeatureValueAction_isRemoveDuplicates(domain, isRemoveDuplicates)

  }

  implicit def enrichRemoveStructuralFeatureValueAction[Uml <: UML]
  (domain: UMLRemoveStructuralFeatureValueAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RemoveStructuralFeatureValueActionUpdater[Uml](domain)

  // RemoveVariableValueAction

  class RemoveVariableValueActionUpdater[Uml <: UML](val domain: UMLRemoveVariableValueAction[Uml]) extends AnyVal {

    def links_RemoveVariableValueAction_removeVariableValueAction_compose_removeAt_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_RemoveVariableValueAction_removeVariableValueAction_compose_removeAt_InputPin(domain, range)

    def setIsRemoveDuplicates
    (isRemoveDuplicates: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_RemoveVariableValueAction_isRemoveDuplicates(domain, isRemoveDuplicates)

  }

  implicit def enrichRemoveVariableValueAction[Uml <: UML]
  (domain: UMLRemoveVariableValueAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RemoveVariableValueActionUpdater[Uml](domain)

  // ReplyAction

  class ReplyActionUpdater[Uml <: UML](val domain: UMLReplyAction[Uml]) extends AnyVal {

    def links_ReplyAction_replyAction_reference_replyToCall_Trigger
    (range: Option[UMLTrigger[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReplyAction_replyAction_reference_replyToCall_Trigger(domain, range)

    def links_ReplyAction_replyAction_compose_replyValue_InputPin
    (range: Seq[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReplyAction_replyAction_compose_replyValue_InputPin(domain, range)

    def links_ReplyAction_replyAction_compose_returnInformation_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ReplyAction_replyAction_compose_returnInformation_InputPin(domain, range)

  }

  implicit def enrichReplyAction[Uml <: UML]
  (domain: UMLReplyAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReplyActionUpdater[Uml](domain)

  // SendObjectAction

  class SendObjectActionUpdater[Uml <: UML](val domain: UMLSendObjectAction[Uml]) extends AnyVal {

    def links_SendObjectAction_sendObjectAction_compose_request_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_SendObjectAction_sendObjectAction_compose_request_InputPin(domain, range)

    def links_SendObjectAction_sendObjectAction_compose_target_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_SendObjectAction_sendObjectAction_compose_target_InputPin(domain, range)

  }

  implicit def enrichSendObjectAction[Uml <: UML]
  (domain: UMLSendObjectAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SendObjectActionUpdater[Uml](domain)

  // SendSignalAction

  class SendSignalActionUpdater[Uml <: UML](val domain: UMLSendSignalAction[Uml]) extends AnyVal {

    def links_SendSignalAction_sendSignalAction_reference_signal_Signal
    (range: Option[UMLSignal[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_SendSignalAction_sendSignalAction_reference_signal_Signal(domain, range)

    def links_SendSignalAction_sendSignalAction_compose_target_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_SendSignalAction_sendSignalAction_compose_target_InputPin(domain, range)

  }

  implicit def enrichSendSignalAction[Uml <: UML]
  (domain: UMLSendSignalAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SendSignalActionUpdater[Uml](domain)

  // SequenceNode

  class SequenceNodeUpdater[Uml <: UML](val domain: UMLSequenceNode[Uml]) extends AnyVal {

    def links_SequenceNode_sequenceNode_compose_executableNode_ExecutableNode
    (range: Seq[UMLExecutableNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_SequenceNode_sequenceNode_compose_executableNode_ExecutableNode(domain, range)

  }

  implicit def enrichSequenceNode[Uml <: UML]
  (domain: UMLSequenceNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SequenceNodeUpdater[Uml](domain)

  // Signal

  class SignalUpdater[Uml <: UML](val domain: UMLSignal[Uml]) extends AnyVal {

    def links_Signal_owningSignal_compose_ownedAttribute_Property
    (range: Seq[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Signal_owningSignal_compose_ownedAttribute_Property(domain, range)

  }

  implicit def enrichSignal[Uml <: UML]
  (domain: UMLSignal[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SignalUpdater[Uml](domain)

  // SignalEvent

  class SignalEventUpdater[Uml <: UML](val domain: UMLSignalEvent[Uml]) extends AnyVal {

    def links_SignalEvent_signalEvent_reference_signal_Signal
    (range: Option[UMLSignal[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_SignalEvent_signalEvent_reference_signal_Signal(domain, range)

  }

  implicit def enrichSignalEvent[Uml <: UML]
  (domain: UMLSignalEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SignalEventUpdater[Uml](domain)

  // Slot

  class SlotUpdater[Uml <: UML](val domain: UMLSlot[Uml]) extends AnyVal {

    def links_Slot_slot_reference_definingFeature_StructuralFeature
    (range: Option[UMLStructuralFeature[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Slot_slot_reference_definingFeature_StructuralFeature(domain, range)

    def links_Slot_owningSlot_compose_value_ValueSpecification
    (range: Seq[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Slot_owningSlot_compose_value_ValueSpecification(domain, range)

  }

  implicit def enrichSlot[Uml <: UML]
  (domain: UMLSlot[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SlotUpdater[Uml](domain)

  // StartClassifierBehaviorAction

  class StartClassifierBehaviorActionUpdater[Uml <: UML](val domain: UMLStartClassifierBehaviorAction[Uml]) extends AnyVal {

    def links_StartClassifierBehaviorAction_startClassifierBehaviorAction_compose_object_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StartClassifierBehaviorAction_startClassifierBehaviorAction_compose_object_InputPin(domain, range)

  }

  implicit def enrichStartClassifierBehaviorAction[Uml <: UML]
  (domain: UMLStartClassifierBehaviorAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StartClassifierBehaviorActionUpdater[Uml](domain)

  // StartObjectBehaviorAction

  class StartObjectBehaviorActionUpdater[Uml <: UML](val domain: UMLStartObjectBehaviorAction[Uml]) extends AnyVal {

    def links_StartObjectBehaviorAction_startObjectBehaviorAction_compose_object_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StartObjectBehaviorAction_startObjectBehaviorAction_compose_object_InputPin(domain, range)

  }

  implicit def enrichStartObjectBehaviorAction[Uml <: UML]
  (domain: UMLStartObjectBehaviorAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StartObjectBehaviorActionUpdater[Uml](domain)

  // State

  class StateUpdater[Uml <: UML](val domain: UMLState[Uml]) extends AnyVal {

    def links_State_state_compose_connection_ConnectionPointReference
    (range: Set[UMLConnectionPointReference[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_State_state_compose_connection_ConnectionPointReference(domain, range)

    def links_State_state_compose_connectionPoint_Pseudostate
    (range: Set[UMLPseudostate[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_State_state_compose_connectionPoint_Pseudostate(domain, range)

    def links_State_state_compose_deferrableTrigger_Trigger
    (range: Set[UMLTrigger[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_State_state_compose_deferrableTrigger_Trigger(domain, range)

    def links_State_state_compose_doActivity_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_State_state_compose_doActivity_Behavior(domain, range)

    def links_State_state_compose_entry_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_State_state_compose_entry_Behavior(domain, range)

    def links_State_state_compose_exit_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_State_state_compose_exit_Behavior(domain, range)

    def links_State_state_reference_redefinedState_State
    (range: Option[UMLState[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_State_state_reference_redefinedState_State(domain, range)

    def links_State_state_compose_region_Region
    (range: Set[UMLRegion[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_State_state_compose_region_Region(domain, range)

    def links_State_owningState_compose_stateInvariant_Constraint
    (range: Option[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_State_owningState_compose_stateInvariant_Constraint(domain, range)

    def links_State_submachineState_reference_submachine_StateMachine
    (range: Option[UMLStateMachine[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_State_submachineState_reference_submachine_StateMachine(domain, range)

  }

  implicit def enrichState[Uml <: UML]
  (domain: UMLState[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StateUpdater[Uml](domain)

  // StateInvariant

  class StateInvariantUpdater[Uml <: UML](val domain: UMLStateInvariant[Uml]) extends AnyVal {

    def links_StateInvariant_stateInvariant_reference_covered_Lifeline
    (range: Iterable[UMLLifeline[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StateInvariant_stateInvariant_reference_covered_Lifeline(domain, range)

    def links_StateInvariant_stateInvariant_compose_invariant_Constraint
    (range: Option[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StateInvariant_stateInvariant_compose_invariant_Constraint(domain, range)

  }

  implicit def enrichStateInvariant[Uml <: UML]
  (domain: UMLStateInvariant[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StateInvariantUpdater[Uml](domain)

  // StateMachine

  class StateMachineUpdater[Uml <: UML](val domain: UMLStateMachine[Uml]) extends AnyVal {

    def links_StateMachine_stateMachine_compose_connectionPoint_Pseudostate
    (range: Set[UMLPseudostate[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StateMachine_stateMachine_compose_connectionPoint_Pseudostate(domain, range)

    def links_StateMachine_stateMachine_reference_extendedStateMachine_StateMachine
    (range: Set[UMLStateMachine[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StateMachine_stateMachine_reference_extendedStateMachine_StateMachine(domain, range)

    def links_StateMachine_stateMachine_compose_region_Region
    (range: Set[UMLRegion[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StateMachine_stateMachine_compose_region_Region(domain, range)

    def links_StateMachine_submachine_reference_submachineState_State
    (range: Set[UMLState[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StateMachine_submachine_reference_submachineState_State(domain, range)

  }

  implicit def enrichStateMachine[Uml <: UML]
  (domain: UMLStateMachine[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StateMachineUpdater[Uml](domain)

  // Stereotype

  class StereotypeUpdater[Uml <: UML](val domain: UMLStereotype[Uml]) extends AnyVal {

    def links_Stereotype_stereotype_compose_icon_Image
    (range: Set[UMLImage[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Stereotype_stereotype_compose_icon_Image(domain, range)

  }

  implicit def enrichStereotype[Uml <: UML]
  (domain: UMLStereotype[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StereotypeUpdater[Uml](domain)

  // StringExpression

  class StringExpressionUpdater[Uml <: UML](val domain: UMLStringExpression[Uml]) extends AnyVal {

    def links_StringExpression_owningExpression_compose_subExpression_StringExpression
    (range: Seq[UMLStringExpression[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StringExpression_owningExpression_compose_subExpression_StringExpression(domain, range)

  }

  implicit def enrichStringExpression[Uml <: UML]
  (domain: UMLStringExpression[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StringExpressionUpdater[Uml](domain)

  // StructuralFeature

  class StructuralFeatureUpdater[Uml <: UML](val domain: UMLStructuralFeature[Uml]) extends AnyVal {


    def setIsReadOnly
    (isReadOnly: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_StructuralFeature_isReadOnly(domain, isReadOnly)

  }

  implicit def enrichStructuralFeature[Uml <: UML]
  (domain: UMLStructuralFeature[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StructuralFeatureUpdater[Uml](domain)

  // StructuralFeatureAction

  class StructuralFeatureActionUpdater[Uml <: UML](val domain: UMLStructuralFeatureAction[Uml]) extends AnyVal {

    def links_StructuralFeatureAction_structuralFeatureAction_compose_object_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StructuralFeatureAction_structuralFeatureAction_compose_object_InputPin(domain, range)

    def links_StructuralFeatureAction_structuralFeatureAction_reference_structuralFeature_StructuralFeature
    (range: Option[UMLStructuralFeature[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StructuralFeatureAction_structuralFeatureAction_reference_structuralFeature_StructuralFeature(domain, range)

  }

  implicit def enrichStructuralFeatureAction[Uml <: UML]
  (domain: UMLStructuralFeatureAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StructuralFeatureActionUpdater[Uml](domain)

  // StructuredActivityNode

  class StructuredActivityNodeUpdater[Uml <: UML](val domain: UMLStructuredActivityNode[Uml]) extends AnyVal {

    def links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge
    (range: Set[UMLActivityEdge[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge(domain, range)

    def links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode
    (range: Set[UMLActivityNode[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode(domain, range)

    def links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin
    (range: Set[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin(domain, range)

    def links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin
    (range: Set[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin(domain, range)

    def links_StructuredActivityNode_scope_compose_variable_Variable
    (range: Set[UMLVariable[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StructuredActivityNode_scope_compose_variable_Variable(domain, range)

    def setMustIsolate
    (mustIsolate: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_StructuredActivityNode_mustIsolate(domain, mustIsolate)

  }

  implicit def enrichStructuredActivityNode[Uml <: UML]
  (domain: UMLStructuredActivityNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StructuredActivityNodeUpdater[Uml](domain)

  // StructuredClassifier

  class StructuredClassifierUpdater[Uml <: UML](val domain: UMLStructuredClassifier[Uml]) extends AnyVal {

    def links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property
    (range: Seq[UMLProperty[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property(domain, range)

    def links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector
    (range: Set[UMLConnector[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector(domain, range)

  }

  implicit def enrichStructuredClassifier[Uml <: UML]
  (domain: UMLStructuredClassifier[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StructuredClassifierUpdater[Uml](domain)

  // Substitution

  class SubstitutionUpdater[Uml <: UML](val domain: UMLSubstitution[Uml]) extends AnyVal {

    def links_Substitution_substitution_reference_contract_Classifier
    (range: Option[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Substitution_substitution_reference_contract_Classifier(domain, range)

  }

  implicit def enrichSubstitution[Uml <: UML]
  (domain: UMLSubstitution[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SubstitutionUpdater[Uml](domain)

  // TemplateBinding

  class TemplateBindingUpdater[Uml <: UML](val domain: UMLTemplateBinding[Uml]) extends AnyVal {

    def links_TemplateBinding_templateBinding_compose_parameterSubstitution_TemplateParameterSubstitution
    (range: Set[UMLTemplateParameterSubstitution[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateBinding_templateBinding_compose_parameterSubstitution_TemplateParameterSubstitution(domain, range)

    def links_TemplateBinding_templateBinding_reference_signature_TemplateSignature
    (range: Option[UMLTemplateSignature[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateBinding_templateBinding_reference_signature_TemplateSignature(domain, range)

  }

  implicit def enrichTemplateBinding[Uml <: UML]
  (domain: UMLTemplateBinding[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TemplateBindingUpdater[Uml](domain)

  // TemplateParameter

  class TemplateParameterUpdater[Uml <: UML](val domain: UMLTemplateParameter[Uml]) extends AnyVal {

    def links_TemplateParameter_templateParameter_reference_default_ParameterableElement
    (range: Option[UMLParameterableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateParameter_templateParameter_reference_default_ParameterableElement(domain, range)

    def links_TemplateParameter_templateParameter_compose_ownedDefault_ParameterableElement
    (range: Option[UMLParameterableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateParameter_templateParameter_compose_ownedDefault_ParameterableElement(domain, range)

    def links_TemplateParameter_owningTemplateParameter_compose_ownedParameteredElement_ParameterableElement
    (range: Option[UMLParameterableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateParameter_owningTemplateParameter_compose_ownedParameteredElement_ParameterableElement(domain, range)

    def links_TemplateParameter_templateParameter_reference_parameteredElement_ParameterableElement
    (range: Option[UMLParameterableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateParameter_templateParameter_reference_parameteredElement_ParameterableElement(domain, range)

  }

  implicit def enrichTemplateParameter[Uml <: UML]
  (domain: UMLTemplateParameter[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TemplateParameterUpdater[Uml](domain)

  // TemplateParameterSubstitution

  class TemplateParameterSubstitutionUpdater[Uml <: UML](val domain: UMLTemplateParameterSubstitution[Uml]) extends AnyVal {

    def links_TemplateParameterSubstitution_templateParameterSubstitution_reference_actual_ParameterableElement
    (range: Option[UMLParameterableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateParameterSubstitution_templateParameterSubstitution_reference_actual_ParameterableElement(domain, range)

    def links_TemplateParameterSubstitution_templateParameterSubstitution_reference_formal_TemplateParameter
    (range: Option[UMLTemplateParameter[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateParameterSubstitution_templateParameterSubstitution_reference_formal_TemplateParameter(domain, range)

    def links_TemplateParameterSubstitution_owningTemplateParameterSubstitution_compose_ownedActual_ParameterableElement
    (range: Option[UMLParameterableElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateParameterSubstitution_owningTemplateParameterSubstitution_compose_ownedActual_ParameterableElement(domain, range)

  }

  implicit def enrichTemplateParameterSubstitution[Uml <: UML]
  (domain: UMLTemplateParameterSubstitution[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TemplateParameterSubstitutionUpdater[Uml](domain)

  // TemplateSignature

  class TemplateSignatureUpdater[Uml <: UML](val domain: UMLTemplateSignature[Uml]) extends AnyVal {

    def links_TemplateSignature_signature_compose_ownedParameter_TemplateParameter
    (range: Seq[UMLTemplateParameter[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateSignature_signature_compose_ownedParameter_TemplateParameter(domain, range)

    def links_TemplateSignature_templateSignature_reference_parameter_TemplateParameter
    (range: Seq[UMLTemplateParameter[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateSignature_templateSignature_reference_parameter_TemplateParameter(domain, range)

  }

  implicit def enrichTemplateSignature[Uml <: UML]
  (domain: UMLTemplateSignature[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TemplateSignatureUpdater[Uml](domain)

  // TemplateableElement

  class TemplateableElementUpdater[Uml <: UML](val domain: UMLTemplateableElement[Uml]) extends AnyVal {

    def links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature
    (range: Option[UMLTemplateSignature[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature(domain, range)

    def links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding
    (range: Set[UMLTemplateBinding[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding(domain, range)

  }

  implicit def enrichTemplateableElement[Uml <: UML]
  (domain: UMLTemplateableElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TemplateableElementUpdater[Uml](domain)

  // TestIdentityAction

  class TestIdentityActionUpdater[Uml <: UML](val domain: UMLTestIdentityAction[Uml]) extends AnyVal {

    def links_TestIdentityAction_testIdentityAction_compose_first_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TestIdentityAction_testIdentityAction_compose_first_InputPin(domain, range)

    def links_TestIdentityAction_testIdentityAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TestIdentityAction_testIdentityAction_compose_result_OutputPin(domain, range)

    def links_TestIdentityAction_testIdentityAction_compose_second_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TestIdentityAction_testIdentityAction_compose_second_InputPin(domain, range)

  }

  implicit def enrichTestIdentityAction[Uml <: UML]
  (domain: UMLTestIdentityAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TestIdentityActionUpdater[Uml](domain)

  // TimeConstraint

  class TimeConstraintUpdater[Uml <: UML](val domain: UMLTimeConstraint[Uml]) extends AnyVal {

    def links_TimeConstraint_timeConstraint_compose_specification_TimeInterval
    (range: Option[UMLTimeInterval[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TimeConstraint_timeConstraint_compose_specification_TimeInterval(domain, range)

    def setFirstEvent
    (firstEvent: Option[Boolean])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_TimeConstraint_firstEvent(domain, firstEvent)

  }

  implicit def enrichTimeConstraint[Uml <: UML]
  (domain: UMLTimeConstraint[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TimeConstraintUpdater[Uml](domain)

  // TimeEvent

  class TimeEventUpdater[Uml <: UML](val domain: UMLTimeEvent[Uml]) extends AnyVal {

    def links_TimeEvent_timeEvent_compose_when_TimeExpression
    (range: Option[UMLTimeExpression[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TimeEvent_timeEvent_compose_when_TimeExpression(domain, range)

    def setIsRelative
    (isRelative: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_TimeEvent_isRelative(domain, isRelative)

  }

  implicit def enrichTimeEvent[Uml <: UML]
  (domain: UMLTimeEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TimeEventUpdater[Uml](domain)

  // TimeExpression

  class TimeExpressionUpdater[Uml <: UML](val domain: UMLTimeExpression[Uml]) extends AnyVal {

    def links_TimeExpression_timeExpression_compose_expr_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TimeExpression_timeExpression_compose_expr_ValueSpecification(domain, range)

    def links_TimeExpression_timeExpression_reference_observation_Observation
    (range: Set[UMLObservation[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TimeExpression_timeExpression_reference_observation_Observation(domain, range)

  }

  implicit def enrichTimeExpression[Uml <: UML]
  (domain: UMLTimeExpression[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TimeExpressionUpdater[Uml](domain)

  // TimeInterval

  class TimeIntervalUpdater[Uml <: UML](val domain: UMLTimeInterval[Uml]) extends AnyVal {

    def links_TimeInterval_timeInterval_reference_max_TimeExpression
    (range: Option[UMLTimeExpression[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TimeInterval_timeInterval_reference_max_TimeExpression(domain, range)

    def links_TimeInterval_timeInterval_reference_min_TimeExpression
    (range: Option[UMLTimeExpression[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TimeInterval_timeInterval_reference_min_TimeExpression(domain, range)

  }

  implicit def enrichTimeInterval[Uml <: UML]
  (domain: UMLTimeInterval[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TimeIntervalUpdater[Uml](domain)

  // TimeObservation

  class TimeObservationUpdater[Uml <: UML](val domain: UMLTimeObservation[Uml]) extends AnyVal {

    def links_TimeObservation_timeObservation_reference_event_NamedElement
    (range: Option[UMLNamedElement[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TimeObservation_timeObservation_reference_event_NamedElement(domain, range)

    def setFirstEvent
    (firstEvent: Boolean)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_TimeObservation_firstEvent(domain, firstEvent)

  }

  implicit def enrichTimeObservation[Uml <: UML]
  (domain: UMLTimeObservation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TimeObservationUpdater[Uml](domain)

  // Transition

  class TransitionUpdater[Uml <: UML](val domain: UMLTransition[Uml]) extends AnyVal {

    def links_Transition_transition_compose_effect_Behavior
    (range: Option[UMLBehavior[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Transition_transition_compose_effect_Behavior(domain, range)

    def links_Transition_transition_compose_guard_Constraint
    (range: Option[UMLConstraint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Transition_transition_compose_guard_Constraint(domain, range)

    def links_Transition_transition_reference_redefinedTransition_Transition
    (range: Option[UMLTransition[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Transition_transition_reference_redefinedTransition_Transition(domain, range)

    def links_Transition_transition_compose_trigger_Trigger
    (range: Set[UMLTrigger[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Transition_transition_compose_trigger_Trigger(domain, range)

    def setKind
    (kind: UMLTransitionKind.Value)
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.set_Transition_kind(domain, kind)

  }

  implicit def enrichTransition[Uml <: UML]
  (domain: UMLTransition[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TransitionUpdater[Uml](domain)

  // Trigger

  class TriggerUpdater[Uml <: UML](val domain: UMLTrigger[Uml]) extends AnyVal {

    def links_Trigger_trigger_reference_event_Event
    (range: Option[UMLEvent[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Trigger_trigger_reference_event_Event(domain, range)

    def links_Trigger_trigger_reference_port_Port
    (range: Set[UMLPort[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_Trigger_trigger_reference_port_Port(domain, range)

  }

  implicit def enrichTrigger[Uml <: UML]
  (domain: UMLTrigger[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TriggerUpdater[Uml](domain)

  // Type

  class TypeUpdater[Uml <: UML](val domain: UMLType[Uml]) extends AnyVal {


  }

  implicit def enrichType[Uml <: UML]
  (domain: UMLType[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TypeUpdater[Uml](domain)

  // TypedElement

  class TypedElementUpdater[Uml <: UML](val domain: UMLTypedElement[Uml]) extends AnyVal {

    def links_TypedElement_typedElement_reference_type_Type
    (range: Option[UMLType[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_TypedElement_typedElement_reference_type_Type(domain, range)

  }

  implicit def enrichTypedElement[Uml <: UML]
  (domain: UMLTypedElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TypedElementUpdater[Uml](domain)

  // UnmarshallAction

  class UnmarshallActionUpdater[Uml <: UML](val domain: UMLUnmarshallAction[Uml]) extends AnyVal {

    def links_UnmarshallAction_unmarshallAction_compose_object_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_UnmarshallAction_unmarshallAction_compose_object_InputPin(domain, range)

    def links_UnmarshallAction_unmarshallAction_compose_result_OutputPin
    (range: Seq[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_UnmarshallAction_unmarshallAction_compose_result_OutputPin(domain, range)

    def links_UnmarshallAction_unmarshallAction_reference_unmarshallType_Classifier
    (range: Option[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_UnmarshallAction_unmarshallAction_reference_unmarshallType_Classifier(domain, range)

  }

  implicit def enrichUnmarshallAction[Uml <: UML]
  (domain: UMLUnmarshallAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new UnmarshallActionUpdater[Uml](domain)

  // Usage

  class UsageUpdater[Uml <: UML](val domain: UMLUsage[Uml]) extends AnyVal {


  }

  implicit def enrichUsage[Uml <: UML]
  (domain: UMLUsage[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new UsageUpdater[Uml](domain)

  // UseCase

  class UseCaseUpdater[Uml <: UML](val domain: UMLUseCase[Uml]) extends AnyVal {

    def links_UseCase_extension_compose_extend_Extend
    (range: Set[UMLExtend[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_UseCase_extension_compose_extend_Extend(domain, range)

    def links_UseCase_useCase_compose_extensionPoint_ExtensionPoint
    (range: Set[UMLExtensionPoint[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_UseCase_useCase_compose_extensionPoint_ExtensionPoint(domain, range)

    def links_UseCase_includingCase_compose_include_Include
    (range: Set[UMLInclude[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_UseCase_includingCase_compose_include_Include(domain, range)

    def links_UseCase_useCase_reference_subject_Classifier
    (range: Set[UMLClassifier[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_UseCase_useCase_reference_subject_Classifier(domain, range)

  }

  implicit def enrichUseCase[Uml <: UML]
  (domain: UMLUseCase[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new UseCaseUpdater[Uml](domain)

  // ValuePin

  class ValuePinUpdater[Uml <: UML](val domain: UMLValuePin[Uml]) extends AnyVal {

    def links_ValuePin_valuePin_compose_value_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ValuePin_valuePin_compose_value_ValueSpecification(domain, range)

  }

  implicit def enrichValuePin[Uml <: UML]
  (domain: UMLValuePin[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ValuePinUpdater[Uml](domain)

  // ValueSpecification

  class ValueSpecificationUpdater[Uml <: UML](val domain: UMLValueSpecification[Uml]) extends AnyVal {


  }

  implicit def enrichValueSpecification[Uml <: UML]
  (domain: UMLValueSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ValueSpecificationUpdater[Uml](domain)

  // ValueSpecificationAction

  class ValueSpecificationActionUpdater[Uml <: UML](val domain: UMLValueSpecificationAction[Uml]) extends AnyVal {

    def links_ValueSpecificationAction_valueSpecificationAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ValueSpecificationAction_valueSpecificationAction_compose_result_OutputPin(domain, range)

    def links_ValueSpecificationAction_valueSpecificationAction_compose_value_ValueSpecification
    (range: Option[UMLValueSpecification[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_ValueSpecificationAction_valueSpecificationAction_compose_value_ValueSpecification(domain, range)

  }

  implicit def enrichValueSpecificationAction[Uml <: UML]
  (domain: UMLValueSpecificationAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ValueSpecificationActionUpdater[Uml](domain)

  // Variable

  class VariableUpdater[Uml <: UML](val domain: UMLVariable[Uml]) extends AnyVal {


  }

  implicit def enrichVariable[Uml <: UML]
  (domain: UMLVariable[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new VariableUpdater[Uml](domain)

  // VariableAction

  class VariableActionUpdater[Uml <: UML](val domain: UMLVariableAction[Uml]) extends AnyVal {

    def links_VariableAction_variableAction_reference_variable_Variable
    (range: Option[UMLVariable[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_VariableAction_variableAction_reference_variable_Variable(domain, range)

  }

  implicit def enrichVariableAction[Uml <: UML]
  (domain: UMLVariableAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new VariableActionUpdater[Uml](domain)

  // Vertex

  class VertexUpdater[Uml <: UML](val domain: UMLVertex[Uml]) extends AnyVal {


  }

  implicit def enrichVertex[Uml <: UML]
  (domain: UMLVertex[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new VertexUpdater[Uml](domain)

  // WriteLinkAction

  class WriteLinkActionUpdater[Uml <: UML](val domain: UMLWriteLinkAction[Uml]) extends AnyVal {


  }

  implicit def enrichWriteLinkAction[Uml <: UML]
  (domain: UMLWriteLinkAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new WriteLinkActionUpdater[Uml](domain)

  // WriteStructuralFeatureAction

  class WriteStructuralFeatureActionUpdater[Uml <: UML](val domain: UMLWriteStructuralFeatureAction[Uml]) extends AnyVal {

    def links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_result_OutputPin
    (range: Option[UMLOutputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_result_OutputPin(domain, range)

    def links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_value_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_value_InputPin(domain, range)

  }

  implicit def enrichWriteStructuralFeatureAction[Uml <: UML]
  (domain: UMLWriteStructuralFeatureAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new WriteStructuralFeatureActionUpdater[Uml](domain)

  // WriteVariableAction

  class WriteVariableActionUpdater[Uml <: UML](val domain: UMLWriteVariableAction[Uml]) extends AnyVal {

    def links_WriteVariableAction_writeVariableAction_compose_value_InputPin
    (range: Option[UMLInputPin[Uml]])
    (implicit umlU: UMLUpdate[Uml])
    : Try[Unit] =
      umlU.links_WriteVariableAction_writeVariableAction_compose_value_InputPin(domain, range)

  }

  implicit def enrichWriteVariableAction[Uml <: UML]
  (domain: UMLWriteVariableAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new WriteVariableActionUpdater[Uml](domain)

}
