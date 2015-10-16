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

import org.omg.oti.uml.read.api._
import scala.{Option,Unit}
import scala.collection.immutable.Set
// Start of user code for imports
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

  implicit def enrichAbstraction[Uml <: UML]
  (domain: UMLAbstraction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AbstractionUpdater[Uml](domain)

  // AcceptCallAction

  implicit def enrichAcceptCallAction[Uml <: UML]
  (domain: UMLAcceptCallAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AcceptCallActionUpdater[Uml](domain)

  // AcceptEventAction

  implicit def enrichAcceptEventAction[Uml <: UML]
  (domain: UMLAcceptEventAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AcceptEventActionUpdater[Uml](domain)

  // Action

  implicit def enrichAction[Uml <: UML]
  (domain: UMLAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActionUpdater[Uml](domain)

  // ActionExecutionSpecification

  implicit def enrichActionExecutionSpecification[Uml <: UML]
  (domain: UMLActionExecutionSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActionExecutionSpecificationUpdater[Uml](domain)

  // ActionInputPin

  implicit def enrichActionInputPin[Uml <: UML]
  (domain: UMLActionInputPin[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActionInputPinUpdater[Uml](domain)

  // Activity

  implicit def enrichActivity[Uml <: UML]
  (domain: UMLActivity[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityUpdater[Uml](domain)

  // ActivityEdge

  implicit def enrichActivityEdge[Uml <: UML]
  (domain: UMLActivityEdge[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityEdgeUpdater[Uml](domain)

  // ActivityFinalNode

  implicit def enrichActivityFinalNode[Uml <: UML]
  (domain: UMLActivityFinalNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityFinalNodeUpdater[Uml](domain)

  // ActivityGroup

  implicit def enrichActivityGroup[Uml <: UML]
  (domain: UMLActivityGroup[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityGroupUpdater[Uml](domain)

  // ActivityNode

  implicit def enrichActivityNode[Uml <: UML]
  (domain: UMLActivityNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityNodeUpdater[Uml](domain)

  // ActivityParameterNode

  implicit def enrichActivityParameterNode[Uml <: UML]
  (domain: UMLActivityParameterNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityParameterNodeUpdater[Uml](domain)

  // ActivityPartition

  implicit def enrichActivityPartition[Uml <: UML]
  (domain: UMLActivityPartition[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActivityPartitionUpdater[Uml](domain)

  // Actor

  implicit def enrichActor[Uml <: UML]
  (domain: UMLActor[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ActorUpdater[Uml](domain)

  // AddStructuralFeatureValueAction

  implicit def enrichAddStructuralFeatureValueAction[Uml <: UML]
  (domain: UMLAddStructuralFeatureValueAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AddStructuralFeatureValueActionUpdater[Uml](domain)

  // AddVariableValueAction

  implicit def enrichAddVariableValueAction[Uml <: UML]
  (domain: UMLAddVariableValueAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AddVariableValueActionUpdater[Uml](domain)

  // AnyReceiveEvent

  implicit def enrichAnyReceiveEvent[Uml <: UML]
  (domain: UMLAnyReceiveEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AnyReceiveEventUpdater[Uml](domain)

  // Artifact

  implicit def enrichArtifact[Uml <: UML]
  (domain: UMLArtifact[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ArtifactUpdater[Uml](domain)

  // Association

  implicit def enrichAssociation[Uml <: UML]
  (domain: UMLAssociation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AssociationUpdater[Uml](domain)

  // AssociationClass

  implicit def enrichAssociationClass[Uml <: UML]
  (domain: UMLAssociationClass[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new AssociationClassUpdater[Uml](domain)

  // Behavior

  implicit def enrichBehavior[Uml <: UML]
  (domain: UMLBehavior[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new BehaviorUpdater[Uml](domain)

  // BehaviorExecutionSpecification

  implicit def enrichBehaviorExecutionSpecification[Uml <: UML]
  (domain: UMLBehaviorExecutionSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new BehaviorExecutionSpecificationUpdater[Uml](domain)

  // BehavioralFeature

  implicit def enrichBehavioralFeature[Uml <: UML]
  (domain: UMLBehavioralFeature[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new BehavioralFeatureUpdater[Uml](domain)

  // BehavioredClassifier

  implicit def enrichBehavioredClassifier[Uml <: UML]
  (domain: UMLBehavioredClassifier[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new BehavioredClassifierUpdater[Uml](domain)

  // BroadcastSignalAction

  implicit def enrichBroadcastSignalAction[Uml <: UML]
  (domain: UMLBroadcastSignalAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new BroadcastSignalActionUpdater[Uml](domain)

  // CallAction

  implicit def enrichCallAction[Uml <: UML]
  (domain: UMLCallAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CallActionUpdater[Uml](domain)

  // CallBehaviorAction

  implicit def enrichCallBehaviorAction[Uml <: UML]
  (domain: UMLCallBehaviorAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CallBehaviorActionUpdater[Uml](domain)

  // CallEvent

  implicit def enrichCallEvent[Uml <: UML]
  (domain: UMLCallEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CallEventUpdater[Uml](domain)

  // CallOperationAction

  implicit def enrichCallOperationAction[Uml <: UML]
  (domain: UMLCallOperationAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CallOperationActionUpdater[Uml](domain)

  // CentralBufferNode

  implicit def enrichCentralBufferNode[Uml <: UML]
  (domain: UMLCentralBufferNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CentralBufferNodeUpdater[Uml](domain)

  // ChangeEvent

  implicit def enrichChangeEvent[Uml <: UML]
  (domain: UMLChangeEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ChangeEventUpdater[Uml](domain)

  // Class

  implicit def enrichClass[Uml <: UML]
  (domain: UMLClass[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClassUpdater[Uml](domain)

  // Classifier

  implicit def enrichClassifier[Uml <: UML]
  (domain: UMLClassifier[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClassifierUpdater[Uml](domain)

  // ClassifierTemplateParameter

  implicit def enrichClassifierTemplateParameter[Uml <: UML]
  (domain: UMLClassifierTemplateParameter[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClassifierTemplateParameterUpdater[Uml](domain)

  // Clause

  implicit def enrichClause[Uml <: UML]
  (domain: UMLClause[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClauseUpdater[Uml](domain)

  // ClearAssociationAction

  implicit def enrichClearAssociationAction[Uml <: UML]
  (domain: UMLClearAssociationAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClearAssociationActionUpdater[Uml](domain)

  // ClearStructuralFeatureAction

  implicit def enrichClearStructuralFeatureAction[Uml <: UML]
  (domain: UMLClearStructuralFeatureAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClearStructuralFeatureActionUpdater[Uml](domain)

  // ClearVariableAction

  implicit def enrichClearVariableAction[Uml <: UML]
  (domain: UMLClearVariableAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ClearVariableActionUpdater[Uml](domain)

  // Collaboration

  implicit def enrichCollaboration[Uml <: UML]
  (domain: UMLCollaboration[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CollaborationUpdater[Uml](domain)

  // CollaborationUse

  implicit def enrichCollaborationUse[Uml <: UML]
  (domain: UMLCollaborationUse[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CollaborationUseUpdater[Uml](domain)

  // CombinedFragment

  implicit def enrichCombinedFragment[Uml <: UML]
  (domain: UMLCombinedFragment[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CombinedFragmentUpdater[Uml](domain)

  // Comment

  implicit def enrichComment[Uml <: UML]
  (domain: UMLComment[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CommentUpdater[Uml](domain)

  // CommunicationPath

  implicit def enrichCommunicationPath[Uml <: UML]
  (domain: UMLCommunicationPath[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CommunicationPathUpdater[Uml](domain)

  // Component

  implicit def enrichComponent[Uml <: UML]
  (domain: UMLComponent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ComponentUpdater[Uml](domain)

  // ComponentRealization

  implicit def enrichComponentRealization[Uml <: UML]
  (domain: UMLComponentRealization[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ComponentRealizationUpdater[Uml](domain)

  // ConditionalNode

  implicit def enrichConditionalNode[Uml <: UML]
  (domain: UMLConditionalNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConditionalNodeUpdater[Uml](domain)

  // ConnectableElement

  implicit def enrichConnectableElement[Uml <: UML]
  (domain: UMLConnectableElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConnectableElementUpdater[Uml](domain)

  // ConnectableElementTemplateParameter

  implicit def enrichConnectableElementTemplateParameter[Uml <: UML]
  (domain: UMLConnectableElementTemplateParameter[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConnectableElementTemplateParameterUpdater[Uml](domain)

  // ConnectionPointReference

  implicit def enrichConnectionPointReference[Uml <: UML]
  (domain: UMLConnectionPointReference[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConnectionPointReferenceUpdater[Uml](domain)

  // Connector

  implicit def enrichConnector[Uml <: UML]
  (domain: UMLConnector[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConnectorUpdater[Uml](domain)

  // ConnectorEnd

  implicit def enrichConnectorEnd[Uml <: UML]
  (domain: UMLConnectorEnd[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConnectorEndUpdater[Uml](domain)

  // ConsiderIgnoreFragment

  implicit def enrichConsiderIgnoreFragment[Uml <: UML]
  (domain: UMLConsiderIgnoreFragment[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConsiderIgnoreFragmentUpdater[Uml](domain)

  // Constraint

  implicit def enrichConstraint[Uml <: UML]
  (domain: UMLConstraint[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ConstraintUpdater[Uml](domain)

  // Continuation

  implicit def enrichContinuation[Uml <: UML]
  (domain: UMLContinuation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ContinuationUpdater[Uml](domain)

  // ControlFlow

  implicit def enrichControlFlow[Uml <: UML]
  (domain: UMLControlFlow[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ControlFlowUpdater[Uml](domain)

  // ControlNode

  implicit def enrichControlNode[Uml <: UML]
  (domain: UMLControlNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ControlNodeUpdater[Uml](domain)

  // CreateLinkAction

  implicit def enrichCreateLinkAction[Uml <: UML]
  (domain: UMLCreateLinkAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CreateLinkActionUpdater[Uml](domain)

  // CreateLinkObjectAction

  implicit def enrichCreateLinkObjectAction[Uml <: UML]
  (domain: UMLCreateLinkObjectAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CreateLinkObjectActionUpdater[Uml](domain)

  // CreateObjectAction

  implicit def enrichCreateObjectAction[Uml <: UML]
  (domain: UMLCreateObjectAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new CreateObjectActionUpdater[Uml](domain)

  // DataStoreNode

  implicit def enrichDataStoreNode[Uml <: UML]
  (domain: UMLDataStoreNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DataStoreNodeUpdater[Uml](domain)

  // DataType

  implicit def enrichDataType[Uml <: UML]
  (domain: UMLDataType[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DataTypeUpdater[Uml](domain)

  // DecisionNode

  implicit def enrichDecisionNode[Uml <: UML]
  (domain: UMLDecisionNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DecisionNodeUpdater[Uml](domain)

  // Dependency

  implicit def enrichDependency[Uml <: UML]
  (domain: UMLDependency[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DependencyUpdater[Uml](domain)

  // DeployedArtifact

  implicit def enrichDeployedArtifact[Uml <: UML]
  (domain: UMLDeployedArtifact[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DeployedArtifactUpdater[Uml](domain)

  // Deployment

  implicit def enrichDeployment[Uml <: UML]
  (domain: UMLDeployment[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DeploymentUpdater[Uml](domain)

  // DeploymentSpecification

  implicit def enrichDeploymentSpecification[Uml <: UML]
  (domain: UMLDeploymentSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DeploymentSpecificationUpdater[Uml](domain)

  // DeploymentTarget

  implicit def enrichDeploymentTarget[Uml <: UML]
  (domain: UMLDeploymentTarget[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DeploymentTargetUpdater[Uml](domain)

  // DestroyLinkAction

  implicit def enrichDestroyLinkAction[Uml <: UML]
  (domain: UMLDestroyLinkAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DestroyLinkActionUpdater[Uml](domain)

  // DestroyObjectAction

  implicit def enrichDestroyObjectAction[Uml <: UML]
  (domain: UMLDestroyObjectAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DestroyObjectActionUpdater[Uml](domain)

  // DestructionOccurrenceSpecification

  implicit def enrichDestructionOccurrenceSpecification[Uml <: UML]
  (domain: UMLDestructionOccurrenceSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DestructionOccurrenceSpecificationUpdater[Uml](domain)

  // Device

  implicit def enrichDevice[Uml <: UML]
  (domain: UMLDevice[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DeviceUpdater[Uml](domain)

  // DirectedRelationship

  implicit def enrichDirectedRelationship[Uml <: UML]
  (domain: UMLDirectedRelationship[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DirectedRelationshipUpdater[Uml](domain)

  // Duration

  implicit def enrichDuration[Uml <: UML]
  (domain: UMLDuration[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DurationUpdater[Uml](domain)

  // DurationConstraint

  implicit def enrichDurationConstraint[Uml <: UML]
  (domain: UMLDurationConstraint[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DurationConstraintUpdater[Uml](domain)

  // DurationInterval

  implicit def enrichDurationInterval[Uml <: UML]
  (domain: UMLDurationInterval[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DurationIntervalUpdater[Uml](domain)

  // DurationObservation

  implicit def enrichDurationObservation[Uml <: UML]
  (domain: UMLDurationObservation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new DurationObservationUpdater[Uml](domain)

  // Element

  implicit def enrichElement[Uml <: UML]
  (domain: UMLElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ElementUpdater[Uml](domain)

  // ElementImport

  implicit def enrichElementImport[Uml <: UML]
  (domain: UMLElementImport[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ElementImportUpdater[Uml](domain)

  // EncapsulatedClassifier

  implicit def enrichEncapsulatedClassifier[Uml <: UML]
  (domain: UMLEncapsulatedClassifier[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new EncapsulatedClassifierUpdater[Uml](domain)

  // Enumeration

  implicit def enrichEnumeration[Uml <: UML]
  (domain: UMLEnumeration[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new EnumerationUpdater[Uml](domain)

  // EnumerationLiteral

  implicit def enrichEnumerationLiteral[Uml <: UML]
  (domain: UMLEnumerationLiteral[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new EnumerationLiteralUpdater[Uml](domain)

  // Event

  implicit def enrichEvent[Uml <: UML]
  (domain: UMLEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new EventUpdater[Uml](domain)

  // ExceptionHandler

  implicit def enrichExceptionHandler[Uml <: UML]
  (domain: UMLExceptionHandler[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExceptionHandlerUpdater[Uml](domain)

  // ExecutableNode

  implicit def enrichExecutableNode[Uml <: UML]
  (domain: UMLExecutableNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExecutableNodeUpdater[Uml](domain)

  // ExecutionEnvironment

  implicit def enrichExecutionEnvironment[Uml <: UML]
  (domain: UMLExecutionEnvironment[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExecutionEnvironmentUpdater[Uml](domain)

  // ExecutionOccurrenceSpecification

  implicit def enrichExecutionOccurrenceSpecification[Uml <: UML]
  (domain: UMLExecutionOccurrenceSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExecutionOccurrenceSpecificationUpdater[Uml](domain)

  // ExecutionSpecification

  implicit def enrichExecutionSpecification[Uml <: UML]
  (domain: UMLExecutionSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExecutionSpecificationUpdater[Uml](domain)

  // ExpansionNode

  implicit def enrichExpansionNode[Uml <: UML]
  (domain: UMLExpansionNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExpansionNodeUpdater[Uml](domain)

  // ExpansionRegion

  implicit def enrichExpansionRegion[Uml <: UML]
  (domain: UMLExpansionRegion[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExpansionRegionUpdater[Uml](domain)

  // Expression

  implicit def enrichExpression[Uml <: UML]
  (domain: UMLExpression[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExpressionUpdater[Uml](domain)

  // Extend

  implicit def enrichExtend[Uml <: UML]
  (domain: UMLExtend[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExtendUpdater[Uml](domain)

  // Extension

  implicit def enrichExtension[Uml <: UML]
  (domain: UMLExtension[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExtensionUpdater[Uml](domain)

  // ExtensionEnd

  implicit def enrichExtensionEnd[Uml <: UML]
  (domain: UMLExtensionEnd[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExtensionEndUpdater[Uml](domain)

  // ExtensionPoint

  implicit def enrichExtensionPoint[Uml <: UML]
  (domain: UMLExtensionPoint[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ExtensionPointUpdater[Uml](domain)

  // Feature

  implicit def enrichFeature[Uml <: UML]
  (domain: UMLFeature[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new FeatureUpdater[Uml](domain)

  // FinalNode

  implicit def enrichFinalNode[Uml <: UML]
  (domain: UMLFinalNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new FinalNodeUpdater[Uml](domain)

  // FinalState

  implicit def enrichFinalState[Uml <: UML]
  (domain: UMLFinalState[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new FinalStateUpdater[Uml](domain)

  // FlowFinalNode

  implicit def enrichFlowFinalNode[Uml <: UML]
  (domain: UMLFlowFinalNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new FlowFinalNodeUpdater[Uml](domain)

  // ForkNode

  implicit def enrichForkNode[Uml <: UML]
  (domain: UMLForkNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ForkNodeUpdater[Uml](domain)

  // FunctionBehavior

  implicit def enrichFunctionBehavior[Uml <: UML]
  (domain: UMLFunctionBehavior[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new FunctionBehaviorUpdater[Uml](domain)

  // Gate

  implicit def enrichGate[Uml <: UML]
  (domain: UMLGate[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new GateUpdater[Uml](domain)

  // GeneralOrdering

  implicit def enrichGeneralOrdering[Uml <: UML]
  (domain: UMLGeneralOrdering[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new GeneralOrderingUpdater[Uml](domain)

  // Generalization

  implicit def enrichGeneralization[Uml <: UML]
  (domain: UMLGeneralization[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new GeneralizationUpdater[Uml](domain)

  // GeneralizationSet

  implicit def enrichGeneralizationSet[Uml <: UML]
  (domain: UMLGeneralizationSet[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new GeneralizationSetUpdater[Uml](domain)

  // Image

  implicit def enrichImage[Uml <: UML]
  (domain: UMLImage[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ImageUpdater[Uml](domain)

  // Include

  implicit def enrichInclude[Uml <: UML]
  (domain: UMLInclude[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new IncludeUpdater[Uml](domain)

  // InformationFlow

  implicit def enrichInformationFlow[Uml <: UML]
  (domain: UMLInformationFlow[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InformationFlowUpdater[Uml](domain)

  // InformationItem

  implicit def enrichInformationItem[Uml <: UML]
  (domain: UMLInformationItem[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InformationItemUpdater[Uml](domain)

  // InitialNode

  implicit def enrichInitialNode[Uml <: UML]
  (domain: UMLInitialNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InitialNodeUpdater[Uml](domain)

  // InputPin

  implicit def enrichInputPin[Uml <: UML]
  (domain: UMLInputPin[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InputPinUpdater[Uml](domain)

  // InstanceSpecification

  implicit def enrichInstanceSpecification[Uml <: UML]
  (domain: UMLInstanceSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InstanceSpecificationUpdater[Uml](domain)

  // InstanceValue

  implicit def enrichInstanceValue[Uml <: UML]
  (domain: UMLInstanceValue[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InstanceValueUpdater[Uml](domain)

  // Interaction

  implicit def enrichInteraction[Uml <: UML]
  (domain: UMLInteraction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InteractionUpdater[Uml](domain)

  // InteractionConstraint

  implicit def enrichInteractionConstraint[Uml <: UML]
  (domain: UMLInteractionConstraint[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InteractionConstraintUpdater[Uml](domain)

  // InteractionFragment

  implicit def enrichInteractionFragment[Uml <: UML]
  (domain: UMLInteractionFragment[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InteractionFragmentUpdater[Uml](domain)

  // InteractionOperand

  implicit def enrichInteractionOperand[Uml <: UML]
  (domain: UMLInteractionOperand[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InteractionOperandUpdater[Uml](domain)

  // InteractionUse

  implicit def enrichInteractionUse[Uml <: UML]
  (domain: UMLInteractionUse[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InteractionUseUpdater[Uml](domain)

  // Interface

  implicit def enrichInterface[Uml <: UML]
  (domain: UMLInterface[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InterfaceUpdater[Uml](domain)

  // InterfaceRealization

  implicit def enrichInterfaceRealization[Uml <: UML]
  (domain: UMLInterfaceRealization[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InterfaceRealizationUpdater[Uml](domain)

  // InterruptibleActivityRegion

  implicit def enrichInterruptibleActivityRegion[Uml <: UML]
  (domain: UMLInterruptibleActivityRegion[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InterruptibleActivityRegionUpdater[Uml](domain)

  // Interval

  implicit def enrichInterval[Uml <: UML]
  (domain: UMLInterval[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new IntervalUpdater[Uml](domain)

  // IntervalConstraint

  implicit def enrichIntervalConstraint[Uml <: UML]
  (domain: UMLIntervalConstraint[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new IntervalConstraintUpdater[Uml](domain)

  // InvocationAction

  implicit def enrichInvocationAction[Uml <: UML]
  (domain: UMLInvocationAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new InvocationActionUpdater[Uml](domain)

  // JoinNode

  implicit def enrichJoinNode[Uml <: UML]
  (domain: UMLJoinNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new JoinNodeUpdater[Uml](domain)

  // Lifeline

  implicit def enrichLifeline[Uml <: UML]
  (domain: UMLLifeline[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LifelineUpdater[Uml](domain)

  // LinkAction

  implicit def enrichLinkAction[Uml <: UML]
  (domain: UMLLinkAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LinkActionUpdater[Uml](domain)

  // LinkEndCreationData

  implicit def enrichLinkEndCreationData[Uml <: UML]
  (domain: UMLLinkEndCreationData[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LinkEndCreationDataUpdater[Uml](domain)

  // LinkEndData

  implicit def enrichLinkEndData[Uml <: UML]
  (domain: UMLLinkEndData[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LinkEndDataUpdater[Uml](domain)

  // LinkEndDestructionData

  implicit def enrichLinkEndDestructionData[Uml <: UML]
  (domain: UMLLinkEndDestructionData[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LinkEndDestructionDataUpdater[Uml](domain)

  // LiteralBoolean

  implicit def enrichLiteralBoolean[Uml <: UML]
  (domain: UMLLiteralBoolean[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralBooleanUpdater[Uml](domain)

  // LiteralInteger

  implicit def enrichLiteralInteger[Uml <: UML]
  (domain: UMLLiteralInteger[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralIntegerUpdater[Uml](domain)

  // LiteralNull

  implicit def enrichLiteralNull[Uml <: UML]
  (domain: UMLLiteralNull[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralNullUpdater[Uml](domain)

  // LiteralReal

  implicit def enrichLiteralReal[Uml <: UML]
  (domain: UMLLiteralReal[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralRealUpdater[Uml](domain)

  // LiteralSpecification

  implicit def enrichLiteralSpecification[Uml <: UML]
  (domain: UMLLiteralSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralSpecificationUpdater[Uml](domain)

  // LiteralString

  implicit def enrichLiteralString[Uml <: UML]
  (domain: UMLLiteralString[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralStringUpdater[Uml](domain)

  // LiteralUnlimitedNatural

  implicit def enrichLiteralUnlimitedNatural[Uml <: UML]
  (domain: UMLLiteralUnlimitedNatural[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LiteralUnlimitedNaturalUpdater[Uml](domain)

  // LoopNode

  implicit def enrichLoopNode[Uml <: UML]
  (domain: UMLLoopNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new LoopNodeUpdater[Uml](domain)

  // Manifestation

  implicit def enrichManifestation[Uml <: UML]
  (domain: UMLManifestation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ManifestationUpdater[Uml](domain)

  // MergeNode

  implicit def enrichMergeNode[Uml <: UML]
  (domain: UMLMergeNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new MergeNodeUpdater[Uml](domain)

  // Message

  implicit def enrichMessage[Uml <: UML]
  (domain: UMLMessage[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new MessageUpdater[Uml](domain)

  // MessageEnd

  implicit def enrichMessageEnd[Uml <: UML]
  (domain: UMLMessageEnd[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new MessageEndUpdater[Uml](domain)

  // MessageEvent

  implicit def enrichMessageEvent[Uml <: UML]
  (domain: UMLMessageEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new MessageEventUpdater[Uml](domain)

  // MessageOccurrenceSpecification

  implicit def enrichMessageOccurrenceSpecification[Uml <: UML]
  (domain: UMLMessageOccurrenceSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new MessageOccurrenceSpecificationUpdater[Uml](domain)

  // Model

  implicit def enrichModel[Uml <: UML]
  (domain: UMLModel[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ModelUpdater[Uml](domain)

  // MultiplicityElement

  implicit def enrichMultiplicityElement[Uml <: UML]
  (domain: UMLMultiplicityElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new MultiplicityElementUpdater[Uml](domain)

  // NamedElement

  implicit def enrichNamedElement[Uml <: UML]
  (domain: UMLNamedElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new NamedElementUpdater[Uml](domain)

  // Namespace

  implicit def enrichNamespace[Uml <: UML]
  (domain: UMLNamespace[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new NamespaceUpdater[Uml](domain)

  // Node

  implicit def enrichNode[Uml <: UML]
  (domain: UMLNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new NodeUpdater[Uml](domain)

  // ObjectFlow

  implicit def enrichObjectFlow[Uml <: UML]
  (domain: UMLObjectFlow[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ObjectFlowUpdater[Uml](domain)

  // ObjectNode

  implicit def enrichObjectNode[Uml <: UML]
  (domain: UMLObjectNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ObjectNodeUpdater[Uml](domain)

  // Observation

  implicit def enrichObservation[Uml <: UML]
  (domain: UMLObservation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ObservationUpdater[Uml](domain)

  // OccurrenceSpecification

  implicit def enrichOccurrenceSpecification[Uml <: UML]
  (domain: UMLOccurrenceSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OccurrenceSpecificationUpdater[Uml](domain)

  // OpaqueAction

  implicit def enrichOpaqueAction[Uml <: UML]
  (domain: UMLOpaqueAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OpaqueActionUpdater[Uml](domain)

  // OpaqueBehavior

  implicit def enrichOpaqueBehavior[Uml <: UML]
  (domain: UMLOpaqueBehavior[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OpaqueBehaviorUpdater[Uml](domain)

  // OpaqueExpression

  implicit def enrichOpaqueExpression[Uml <: UML]
  (domain: UMLOpaqueExpression[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OpaqueExpressionUpdater[Uml](domain)

  // Operation

  implicit def enrichOperation[Uml <: UML]
  (domain: UMLOperation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OperationUpdater[Uml](domain)

  // OperationTemplateParameter

  implicit def enrichOperationTemplateParameter[Uml <: UML]
  (domain: UMLOperationTemplateParameter[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OperationTemplateParameterUpdater[Uml](domain)

  // OutputPin

  implicit def enrichOutputPin[Uml <: UML]
  (domain: UMLOutputPin[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new OutputPinUpdater[Uml](domain)

  // Package

  implicit def enrichPackage[Uml <: UML]
  (domain: UMLPackage[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PackageUpdater[Uml](domain)

  // PackageImport

  implicit def enrichPackageImport[Uml <: UML]
  (domain: UMLPackageImport[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PackageImportUpdater[Uml](domain)

  // PackageMerge

  implicit def enrichPackageMerge[Uml <: UML]
  (domain: UMLPackageMerge[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PackageMergeUpdater[Uml](domain)

  // PackageableElement

  implicit def enrichPackageableElement[Uml <: UML]
  (domain: UMLPackageableElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PackageableElementUpdater[Uml](domain)

  // Parameter

  implicit def enrichParameter[Uml <: UML]
  (domain: UMLParameter[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ParameterUpdater[Uml](domain)

  // ParameterSet

  implicit def enrichParameterSet[Uml <: UML]
  (domain: UMLParameterSet[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ParameterSetUpdater[Uml](domain)

  // ParameterableElement

  implicit def enrichParameterableElement[Uml <: UML]
  (domain: UMLParameterableElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ParameterableElementUpdater[Uml](domain)

  // PartDecomposition

  implicit def enrichPartDecomposition[Uml <: UML]
  (domain: UMLPartDecomposition[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PartDecompositionUpdater[Uml](domain)

  // Pin

  implicit def enrichPin[Uml <: UML]
  (domain: UMLPin[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PinUpdater[Uml](domain)

  // Port

  implicit def enrichPort[Uml <: UML]
  (domain: UMLPort[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PortUpdater[Uml](domain)

  // PrimitiveType

  implicit def enrichPrimitiveType[Uml <: UML]
  (domain: UMLPrimitiveType[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PrimitiveTypeUpdater[Uml](domain)

  // Profile

  implicit def enrichProfile[Uml <: UML]
  (domain: UMLProfile[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ProfileUpdater[Uml](domain)

  // ProfileApplication

  implicit def enrichProfileApplication[Uml <: UML]
  (domain: UMLProfileApplication[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ProfileApplicationUpdater[Uml](domain)

  // Property

  implicit def enrichProperty[Uml <: UML]
  (domain: UMLProperty[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PropertyUpdater[Uml](domain)

  // ProtocolConformance

  implicit def enrichProtocolConformance[Uml <: UML]
  (domain: UMLProtocolConformance[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ProtocolConformanceUpdater[Uml](domain)

  // ProtocolStateMachine

  implicit def enrichProtocolStateMachine[Uml <: UML]
  (domain: UMLProtocolStateMachine[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ProtocolStateMachineUpdater[Uml](domain)

  // ProtocolTransition

  implicit def enrichProtocolTransition[Uml <: UML]
  (domain: UMLProtocolTransition[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ProtocolTransitionUpdater[Uml](domain)

  // Pseudostate

  implicit def enrichPseudostate[Uml <: UML]
  (domain: UMLPseudostate[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new PseudostateUpdater[Uml](domain)

  // QualifierValue

  implicit def enrichQualifierValue[Uml <: UML]
  (domain: UMLQualifierValue[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new QualifierValueUpdater[Uml](domain)

  // RaiseExceptionAction

  implicit def enrichRaiseExceptionAction[Uml <: UML]
  (domain: UMLRaiseExceptionAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RaiseExceptionActionUpdater[Uml](domain)

  // ReadExtentAction

  implicit def enrichReadExtentAction[Uml <: UML]
  (domain: UMLReadExtentAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadExtentActionUpdater[Uml](domain)

  // ReadIsClassifiedObjectAction

  implicit def enrichReadIsClassifiedObjectAction[Uml <: UML]
  (domain: UMLReadIsClassifiedObjectAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadIsClassifiedObjectActionUpdater[Uml](domain)

  // ReadLinkAction

  implicit def enrichReadLinkAction[Uml <: UML]
  (domain: UMLReadLinkAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadLinkActionUpdater[Uml](domain)

  // ReadLinkObjectEndAction

  implicit def enrichReadLinkObjectEndAction[Uml <: UML]
  (domain: UMLReadLinkObjectEndAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadLinkObjectEndActionUpdater[Uml](domain)

  // ReadLinkObjectEndQualifierAction

  implicit def enrichReadLinkObjectEndQualifierAction[Uml <: UML]
  (domain: UMLReadLinkObjectEndQualifierAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadLinkObjectEndQualifierActionUpdater[Uml](domain)

  // ReadSelfAction

  implicit def enrichReadSelfAction[Uml <: UML]
  (domain: UMLReadSelfAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadSelfActionUpdater[Uml](domain)

  // ReadStructuralFeatureAction

  implicit def enrichReadStructuralFeatureAction[Uml <: UML]
  (domain: UMLReadStructuralFeatureAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadStructuralFeatureActionUpdater[Uml](domain)

  // ReadVariableAction

  implicit def enrichReadVariableAction[Uml <: UML]
  (domain: UMLReadVariableAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReadVariableActionUpdater[Uml](domain)

  // Realization

  implicit def enrichRealization[Uml <: UML]
  (domain: UMLRealization[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RealizationUpdater[Uml](domain)

  // Reception

  implicit def enrichReception[Uml <: UML]
  (domain: UMLReception[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReceptionUpdater[Uml](domain)

  // ReclassifyObjectAction

  implicit def enrichReclassifyObjectAction[Uml <: UML]
  (domain: UMLReclassifyObjectAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReclassifyObjectActionUpdater[Uml](domain)

  // RedefinableElement

  implicit def enrichRedefinableElement[Uml <: UML]
  (domain: UMLRedefinableElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RedefinableElementUpdater[Uml](domain)

  // RedefinableTemplateSignature

  implicit def enrichRedefinableTemplateSignature[Uml <: UML]
  (domain: UMLRedefinableTemplateSignature[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RedefinableTemplateSignatureUpdater[Uml](domain)

  // ReduceAction

  implicit def enrichReduceAction[Uml <: UML]
  (domain: UMLReduceAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReduceActionUpdater[Uml](domain)

  // Region

  implicit def enrichRegion[Uml <: UML]
  (domain: UMLRegion[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RegionUpdater[Uml](domain)

  // Relationship

  implicit def enrichRelationship[Uml <: UML]
  (domain: UMLRelationship[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RelationshipUpdater[Uml](domain)

  // RemoveStructuralFeatureValueAction

  implicit def enrichRemoveStructuralFeatureValueAction[Uml <: UML]
  (domain: UMLRemoveStructuralFeatureValueAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RemoveStructuralFeatureValueActionUpdater[Uml](domain)

  // RemoveVariableValueAction

  implicit def enrichRemoveVariableValueAction[Uml <: UML]
  (domain: UMLRemoveVariableValueAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new RemoveVariableValueActionUpdater[Uml](domain)

  // ReplyAction

  implicit def enrichReplyAction[Uml <: UML]
  (domain: UMLReplyAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ReplyActionUpdater[Uml](domain)

  // SendObjectAction

  implicit def enrichSendObjectAction[Uml <: UML]
  (domain: UMLSendObjectAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SendObjectActionUpdater[Uml](domain)

  // SendSignalAction

  implicit def enrichSendSignalAction[Uml <: UML]
  (domain: UMLSendSignalAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SendSignalActionUpdater[Uml](domain)

  // SequenceNode

  implicit def enrichSequenceNode[Uml <: UML]
  (domain: UMLSequenceNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SequenceNodeUpdater[Uml](domain)

  // Signal

  implicit def enrichSignal[Uml <: UML]
  (domain: UMLSignal[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SignalUpdater[Uml](domain)

  // SignalEvent

  implicit def enrichSignalEvent[Uml <: UML]
  (domain: UMLSignalEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SignalEventUpdater[Uml](domain)

  // Slot

  implicit def enrichSlot[Uml <: UML]
  (domain: UMLSlot[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SlotUpdater[Uml](domain)

  // StartClassifierBehaviorAction

  implicit def enrichStartClassifierBehaviorAction[Uml <: UML]
  (domain: UMLStartClassifierBehaviorAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StartClassifierBehaviorActionUpdater[Uml](domain)

  // StartObjectBehaviorAction

  implicit def enrichStartObjectBehaviorAction[Uml <: UML]
  (domain: UMLStartObjectBehaviorAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StartObjectBehaviorActionUpdater[Uml](domain)

  // State

  implicit def enrichState[Uml <: UML]
  (domain: UMLState[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StateUpdater[Uml](domain)

  // StateInvariant

  implicit def enrichStateInvariant[Uml <: UML]
  (domain: UMLStateInvariant[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StateInvariantUpdater[Uml](domain)

  // StateMachine

  implicit def enrichStateMachine[Uml <: UML]
  (domain: UMLStateMachine[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StateMachineUpdater[Uml](domain)

  // Stereotype

  implicit def enrichStereotype[Uml <: UML]
  (domain: UMLStereotype[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StereotypeUpdater[Uml](domain)

  // StringExpression

  implicit def enrichStringExpression[Uml <: UML]
  (domain: UMLStringExpression[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StringExpressionUpdater[Uml](domain)

  // StructuralFeature

  implicit def enrichStructuralFeature[Uml <: UML]
  (domain: UMLStructuralFeature[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StructuralFeatureUpdater[Uml](domain)

  // StructuralFeatureAction

  implicit def enrichStructuralFeatureAction[Uml <: UML]
  (domain: UMLStructuralFeatureAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StructuralFeatureActionUpdater[Uml](domain)

  // StructuredActivityNode

  implicit def enrichStructuredActivityNode[Uml <: UML]
  (domain: UMLStructuredActivityNode[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StructuredActivityNodeUpdater[Uml](domain)

  // StructuredClassifier

  implicit def enrichStructuredClassifier[Uml <: UML]
  (domain: UMLStructuredClassifier[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new StructuredClassifierUpdater[Uml](domain)

  // Substitution

  implicit def enrichSubstitution[Uml <: UML]
  (domain: UMLSubstitution[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new SubstitutionUpdater[Uml](domain)

  // TemplateBinding

  implicit def enrichTemplateBinding[Uml <: UML]
  (domain: UMLTemplateBinding[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TemplateBindingUpdater[Uml](domain)

  // TemplateParameter

  implicit def enrichTemplateParameter[Uml <: UML]
  (domain: UMLTemplateParameter[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TemplateParameterUpdater[Uml](domain)

  // TemplateParameterSubstitution

  implicit def enrichTemplateParameterSubstitution[Uml <: UML]
  (domain: UMLTemplateParameterSubstitution[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TemplateParameterSubstitutionUpdater[Uml](domain)

  // TemplateSignature

  implicit def enrichTemplateSignature[Uml <: UML]
  (domain: UMLTemplateSignature[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TemplateSignatureUpdater[Uml](domain)

  // TemplateableElement

  implicit def enrichTemplateableElement[Uml <: UML]
  (domain: UMLTemplateableElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TemplateableElementUpdater[Uml](domain)

  // TestIdentityAction

  implicit def enrichTestIdentityAction[Uml <: UML]
  (domain: UMLTestIdentityAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TestIdentityActionUpdater[Uml](domain)

  // TimeConstraint

  implicit def enrichTimeConstraint[Uml <: UML]
  (domain: UMLTimeConstraint[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TimeConstraintUpdater[Uml](domain)

  // TimeEvent

  implicit def enrichTimeEvent[Uml <: UML]
  (domain: UMLTimeEvent[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TimeEventUpdater[Uml](domain)

  // TimeExpression

  implicit def enrichTimeExpression[Uml <: UML]
  (domain: UMLTimeExpression[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TimeExpressionUpdater[Uml](domain)

  // TimeInterval

  implicit def enrichTimeInterval[Uml <: UML]
  (domain: UMLTimeInterval[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TimeIntervalUpdater[Uml](domain)

  // TimeObservation

  implicit def enrichTimeObservation[Uml <: UML]
  (domain: UMLTimeObservation[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TimeObservationUpdater[Uml](domain)

  // Transition

  implicit def enrichTransition[Uml <: UML]
  (domain: UMLTransition[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TransitionUpdater[Uml](domain)

  // Trigger

  implicit def enrichTrigger[Uml <: UML]
  (domain: UMLTrigger[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TriggerUpdater[Uml](domain)

  // Type

  implicit def enrichType[Uml <: UML]
  (domain: UMLType[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TypeUpdater[Uml](domain)

  // TypedElement

  implicit def enrichTypedElement[Uml <: UML]
  (domain: UMLTypedElement[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new TypedElementUpdater[Uml](domain)

  // UnmarshallAction

  implicit def enrichUnmarshallAction[Uml <: UML]
  (domain: UMLUnmarshallAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new UnmarshallActionUpdater[Uml](domain)

  // Usage

  implicit def enrichUsage[Uml <: UML]
  (domain: UMLUsage[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new UsageUpdater[Uml](domain)

  // UseCase

  implicit def enrichUseCase[Uml <: UML]
  (domain: UMLUseCase[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new UseCaseUpdater[Uml](domain)

  // ValuePin

  implicit def enrichValuePin[Uml <: UML]
  (domain: UMLValuePin[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ValuePinUpdater[Uml](domain)

  // ValueSpecification

  implicit def enrichValueSpecification[Uml <: UML]
  (domain: UMLValueSpecification[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ValueSpecificationUpdater[Uml](domain)

  // ValueSpecificationAction

  implicit def enrichValueSpecificationAction[Uml <: UML]
  (domain: UMLValueSpecificationAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new ValueSpecificationActionUpdater[Uml](domain)

  // Variable

  implicit def enrichVariable[Uml <: UML]
  (domain: UMLVariable[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new VariableUpdater[Uml](domain)

  // VariableAction

  implicit def enrichVariableAction[Uml <: UML]
  (domain: UMLVariableAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new VariableActionUpdater[Uml](domain)

  // Vertex

  implicit def enrichVertex[Uml <: UML]
  (domain: UMLVertex[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new VertexUpdater[Uml](domain)

  // WriteLinkAction

  implicit def enrichWriteLinkAction[Uml <: UML]
  (domain: UMLWriteLinkAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new WriteLinkActionUpdater[Uml](domain)

  // WriteStructuralFeatureAction

  implicit def enrichWriteStructuralFeatureAction[Uml <: UML]
  (domain: UMLWriteStructuralFeatureAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new WriteStructuralFeatureActionUpdater[Uml](domain)

  // WriteVariableAction

  implicit def enrichWriteVariableAction[Uml <: UML]
  (domain: UMLWriteVariableAction[Uml])
  (implicit umlU: UMLUpdate[Uml]) =
    new WriteVariableActionUpdater[Uml](domain)

}
