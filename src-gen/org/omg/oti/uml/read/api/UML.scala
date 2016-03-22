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

/**
 * The UML 2.5 metamodel
 *
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 * @contentDiagram
 */
trait UML {
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Abstraction metaclass.
   * @template
   */
	type Abstraction <: Dependency
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 AcceptCallAction metaclass.
   * @template
   */
	type AcceptCallAction <: AcceptEventAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 AcceptEventAction metaclass.
   * @template
   */
	type AcceptEventAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Action metaclass.
   * @template
   */
	type Action <: ExecutableNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ActionExecutionSpecification metaclass.
   * @template
   */
	type ActionExecutionSpecification <: ExecutionSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ActionInputPin metaclass.
   * @template
   */
	type ActionInputPin <: InputPin
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Activity metaclass.
   * @template
   */
	type Activity <: Behavior
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ActivityEdge metaclass.
   * @template
   */
	type ActivityEdge <: RedefinableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ActivityFinalNode metaclass.
   * @template
   */
	type ActivityFinalNode <: FinalNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ActivityGroup metaclass.
   * @template
   */
	type ActivityGroup <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ActivityNode metaclass.
   * @template
   */
	type ActivityNode <: RedefinableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ActivityParameterNode metaclass.
   * @template
   */
	type ActivityParameterNode <: ObjectNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ActivityPartition metaclass.
   * @template
   */
	type ActivityPartition <: ActivityGroup
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Actor metaclass.
   * @template
   */
	type Actor <: BehavioredClassifier
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 AddStructuralFeatureValueAction metaclass.
   * @template
   */
	type AddStructuralFeatureValueAction <: WriteStructuralFeatureAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 AddVariableValueAction metaclass.
   * @template
   */
	type AddVariableValueAction <: WriteVariableAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 AnyReceiveEvent metaclass.
   * @template
   */
	type AnyReceiveEvent <: MessageEvent
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Artifact metaclass.
   * @template
   */
	type Artifact <: Classifier with DeployedArtifact
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Association metaclass.
   * @template
   */
	type Association <: Classifier with Relationship
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 AssociationClass metaclass.
   * @template
   */
	type AssociationClass <: Association with Class
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Behavior metaclass.
   * @template
   */
	type Behavior <: Class
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 BehaviorExecutionSpecification metaclass.
   * @template
   */
	type BehaviorExecutionSpecification <: ExecutionSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 BehavioralFeature metaclass.
   * @template
   */
	type BehavioralFeature <: Feature with Namespace
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 BehavioredClassifier metaclass.
   * @template
   */
	type BehavioredClassifier <: Classifier
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 BroadcastSignalAction metaclass.
   * @template
   */
	type BroadcastSignalAction <: InvocationAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 CallAction metaclass.
   * @template
   */
	type CallAction <: InvocationAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 CallBehaviorAction metaclass.
   * @template
   */
	type CallBehaviorAction <: CallAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 CallEvent metaclass.
   * @template
   */
	type CallEvent <: MessageEvent
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 CallOperationAction metaclass.
   * @template
   */
	type CallOperationAction <: CallAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 CentralBufferNode metaclass.
   * @template
   */
	type CentralBufferNode <: ObjectNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ChangeEvent metaclass.
   * @template
   */
	type ChangeEvent <: Event
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Class metaclass.
   * @template
   */
	type Class <: BehavioredClassifier with EncapsulatedClassifier
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Classifier metaclass.
   * @template
   */
	type Classifier <: Namespace with RedefinableElement with TemplateableElement with Type
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ClassifierTemplateParameter metaclass.
   * @template
   */
	type ClassifierTemplateParameter <: TemplateParameter
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Clause metaclass.
   * @template
   */
	type Clause <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ClearAssociationAction metaclass.
   * @template
   */
	type ClearAssociationAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ClearStructuralFeatureAction metaclass.
   * @template
   */
	type ClearStructuralFeatureAction <: StructuralFeatureAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ClearVariableAction metaclass.
   * @template
   */
	type ClearVariableAction <: VariableAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Collaboration metaclass.
   * @template
   */
	type Collaboration <: BehavioredClassifier with StructuredClassifier
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 CollaborationUse metaclass.
   * @template
   */
	type CollaborationUse <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 CombinedFragment metaclass.
   * @template
   */
	type CombinedFragment <: InteractionFragment
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Comment metaclass.
   * @template
   */
	type Comment <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 CommunicationPath metaclass.
   * @template
   */
	type CommunicationPath <: Association
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Component metaclass.
   * @template
   */
	type Component <: Class
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ComponentRealization metaclass.
   * @template
   */
	type ComponentRealization <: Realization
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ConditionalNode metaclass.
   * @template
   */
	type ConditionalNode <: StructuredActivityNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ConnectableElement metaclass.
   * @template
   */
	type ConnectableElement <: ParameterableElement with TypedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ConnectableElementTemplateParameter metaclass.
   * @template
   */
	type ConnectableElementTemplateParameter <: TemplateParameter
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ConnectionPointReference metaclass.
   * @template
   */
	type ConnectionPointReference <: Vertex
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Connector metaclass.
   * @template
   */
	type Connector <: Feature
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ConnectorEnd metaclass.
   * @template
   */
	type ConnectorEnd <: MultiplicityElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ConsiderIgnoreFragment metaclass.
   * @template
   */
	type ConsiderIgnoreFragment <: CombinedFragment
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Constraint metaclass.
   * @template
   */
	type Constraint <: PackageableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Continuation metaclass.
   * @template
   */
	type Continuation <: InteractionFragment
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ControlFlow metaclass.
   * @template
   */
	type ControlFlow <: ActivityEdge
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ControlNode metaclass.
   * @template
   */
	type ControlNode <: ActivityNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 CreateLinkAction metaclass.
   * @template
   */
	type CreateLinkAction <: WriteLinkAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 CreateLinkObjectAction metaclass.
   * @template
   */
	type CreateLinkObjectAction <: CreateLinkAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 CreateObjectAction metaclass.
   * @template
   */
	type CreateObjectAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DataStoreNode metaclass.
   * @template
   */
	type DataStoreNode <: CentralBufferNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DataType metaclass.
   * @template
   */
	type DataType <: Classifier
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DecisionNode metaclass.
   * @template
   */
	type DecisionNode <: ControlNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Dependency metaclass.
   * @template
   */
	type Dependency <: DirectedRelationship with PackageableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DeployedArtifact metaclass.
   * @template
   */
	type DeployedArtifact <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Deployment metaclass.
   * @template
   */
	type Deployment <: Dependency
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DeploymentSpecification metaclass.
   * @template
   */
	type DeploymentSpecification <: Artifact
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DeploymentTarget metaclass.
   * @template
   */
	type DeploymentTarget <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DestroyLinkAction metaclass.
   * @template
   */
	type DestroyLinkAction <: WriteLinkAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DestroyObjectAction metaclass.
   * @template
   */
	type DestroyObjectAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DestructionOccurrenceSpecification metaclass.
   * @template
   */
	type DestructionOccurrenceSpecification <: MessageOccurrenceSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Device metaclass.
   * @template
   */
	type Device <: Node
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DirectedRelationship metaclass.
   * @template
   */
	type DirectedRelationship <: Relationship
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Duration metaclass.
   * @template
   */
	type Duration <: ValueSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DurationConstraint metaclass.
   * @template
   */
	type DurationConstraint <: IntervalConstraint
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DurationInterval metaclass.
   * @template
   */
	type DurationInterval <: Interval
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 DurationObservation metaclass.
   * @template
   */
	type DurationObservation <: Observation
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Element metaclass.
   * @template
   */
	type Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ElementImport metaclass.
   * @template
   */
	type ElementImport <: DirectedRelationship
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 EncapsulatedClassifier metaclass.
   * @template
   */
	type EncapsulatedClassifier <: StructuredClassifier
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Enumeration metaclass.
   * @template
   */
	type Enumeration <: DataType
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 EnumerationLiteral metaclass.
   * @template
   */
	type EnumerationLiteral <: InstanceSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Event metaclass.
   * @template
   */
	type Event <: PackageableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ExceptionHandler metaclass.
   * @template
   */
	type ExceptionHandler <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ExecutableNode metaclass.
   * @template
   */
	type ExecutableNode <: ActivityNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ExecutionEnvironment metaclass.
   * @template
   */
	type ExecutionEnvironment <: Node
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ExecutionOccurrenceSpecification metaclass.
   * @template
   */
	type ExecutionOccurrenceSpecification <: OccurrenceSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ExecutionSpecification metaclass.
   * @template
   */
	type ExecutionSpecification <: InteractionFragment
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ExpansionNode metaclass.
   * @template
   */
	type ExpansionNode <: ObjectNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ExpansionRegion metaclass.
   * @template
   */
	type ExpansionRegion <: StructuredActivityNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Expression metaclass.
   * @template
   */
	type Expression <: ValueSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Extend metaclass.
   * @template
   */
	type Extend <: DirectedRelationship with NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Extension metaclass.
   * @template
   */
	type Extension <: Association
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ExtensionEnd metaclass.
   * @template
   */
	type ExtensionEnd <: Property
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ExtensionPoint metaclass.
   * @template
   */
	type ExtensionPoint <: RedefinableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Feature metaclass.
   * @template
   */
	type Feature <: RedefinableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 FinalNode metaclass.
   * @template
   */
	type FinalNode <: ControlNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 FinalState metaclass.
   * @template
   */
	type FinalState <: State
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 FlowFinalNode metaclass.
   * @template
   */
	type FlowFinalNode <: FinalNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ForkNode metaclass.
   * @template
   */
	type ForkNode <: ControlNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 FunctionBehavior metaclass.
   * @template
   */
	type FunctionBehavior <: OpaqueBehavior
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Gate metaclass.
   * @template
   */
	type Gate <: MessageEnd
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 GeneralOrdering metaclass.
   * @template
   */
	type GeneralOrdering <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Generalization metaclass.
   * @template
   */
	type Generalization <: DirectedRelationship
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 GeneralizationSet metaclass.
   * @template
   */
	type GeneralizationSet <: PackageableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Image metaclass.
   * @template
   */
	type Image <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Include metaclass.
   * @template
   */
	type Include <: DirectedRelationship with NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InformationFlow metaclass.
   * @template
   */
	type InformationFlow <: DirectedRelationship with PackageableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InformationItem metaclass.
   * @template
   */
	type InformationItem <: Classifier
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InitialNode metaclass.
   * @template
   */
	type InitialNode <: ControlNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InputPin metaclass.
   * @template
   */
	type InputPin <: Pin
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InstanceSpecification metaclass.
   * @template
   */
	type InstanceSpecification <: DeployedArtifact with DeploymentTarget with PackageableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InstanceValue metaclass.
   * @template
   */
	type InstanceValue <: ValueSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Interaction metaclass.
   * @template
   */
	type Interaction <: Behavior with InteractionFragment
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InteractionConstraint metaclass.
   * @template
   */
	type InteractionConstraint <: Constraint
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InteractionFragment metaclass.
   * @template
   */
	type InteractionFragment <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InteractionOperand metaclass.
   * @template
   */
	type InteractionOperand <: InteractionFragment with Namespace
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InteractionUse metaclass.
   * @template
   */
	type InteractionUse <: InteractionFragment
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Interface metaclass.
   * @template
   */
	type Interface <: Classifier
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InterfaceRealization metaclass.
   * @template
   */
	type InterfaceRealization <: Realization
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InterruptibleActivityRegion metaclass.
   * @template
   */
	type InterruptibleActivityRegion <: ActivityGroup
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Interval metaclass.
   * @template
   */
	type Interval <: ValueSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 IntervalConstraint metaclass.
   * @template
   */
	type IntervalConstraint <: Constraint
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 InvocationAction metaclass.
   * @template
   */
	type InvocationAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 JoinNode metaclass.
   * @template
   */
	type JoinNode <: ControlNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Lifeline metaclass.
   * @template
   */
	type Lifeline <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 LinkAction metaclass.
   * @template
   */
	type LinkAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 LinkEndCreationData metaclass.
   * @template
   */
	type LinkEndCreationData <: LinkEndData
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 LinkEndData metaclass.
   * @template
   */
	type LinkEndData <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 LinkEndDestructionData metaclass.
   * @template
   */
	type LinkEndDestructionData <: LinkEndData
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 LiteralBoolean metaclass.
   * @template
   */
	type LiteralBoolean <: LiteralSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 LiteralInteger metaclass.
   * @template
   */
	type LiteralInteger <: LiteralSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 LiteralNull metaclass.
   * @template
   */
	type LiteralNull <: LiteralSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 LiteralReal metaclass.
   * @template
   */
	type LiteralReal <: LiteralSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 LiteralSpecification metaclass.
   * @template
   */
	type LiteralSpecification <: ValueSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 LiteralString metaclass.
   * @template
   */
	type LiteralString <: LiteralSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 LiteralUnlimitedNatural metaclass.
   * @template
   */
	type LiteralUnlimitedNatural <: LiteralSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 LoopNode metaclass.
   * @template
   */
	type LoopNode <: StructuredActivityNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Manifestation metaclass.
   * @template
   */
	type Manifestation <: Abstraction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 MergeNode metaclass.
   * @template
   */
	type MergeNode <: ControlNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Message metaclass.
   * @template
   */
	type Message <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 MessageEnd metaclass.
   * @template
   */
	type MessageEnd <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 MessageEvent metaclass.
   * @template
   */
	type MessageEvent <: Event
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 MessageOccurrenceSpecification metaclass.
   * @template
   */
	type MessageOccurrenceSpecification <: MessageEnd with OccurrenceSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Model metaclass.
   * @template
   */
	type Model <: Package
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 MultiplicityElement metaclass.
   * @template
   */
	type MultiplicityElement <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 NamedElement metaclass.
   * @template
   */
	type NamedElement <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Namespace metaclass.
   * @template
   */
	type Namespace <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Node metaclass.
   * @template
   */
	type Node <: Class with DeploymentTarget
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ObjectFlow metaclass.
   * @template
   */
	type ObjectFlow <: ActivityEdge
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ObjectNode metaclass.
   * @template
   */
	type ObjectNode <: ActivityNode with TypedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Observation metaclass.
   * @template
   */
	type Observation <: PackageableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 OccurrenceSpecification metaclass.
   * @template
   */
	type OccurrenceSpecification <: InteractionFragment
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 OpaqueAction metaclass.
   * @template
   */
	type OpaqueAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 OpaqueBehavior metaclass.
   * @template
   */
	type OpaqueBehavior <: Behavior
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 OpaqueExpression metaclass.
   * @template
   */
	type OpaqueExpression <: ValueSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Operation metaclass.
   * @template
   */
	type Operation <: BehavioralFeature with ParameterableElement with TemplateableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 OperationTemplateParameter metaclass.
   * @template
   */
	type OperationTemplateParameter <: TemplateParameter
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 OutputPin metaclass.
   * @template
   */
	type OutputPin <: Pin
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Package metaclass.
   * @template
   */
	type Package <: Namespace with PackageableElement with TemplateableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 PackageImport metaclass.
   * @template
   */
	type PackageImport <: DirectedRelationship
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 PackageMerge metaclass.
   * @template
   */
	type PackageMerge <: DirectedRelationship
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 PackageableElement metaclass.
   * @template
   */
	type PackageableElement <: NamedElement with ParameterableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Parameter metaclass.
   * @template
   */
	type Parameter <: ConnectableElement with MultiplicityElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ParameterSet metaclass.
   * @template
   */
	type ParameterSet <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ParameterableElement metaclass.
   * @template
   */
	type ParameterableElement <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 PartDecomposition metaclass.
   * @template
   */
	type PartDecomposition <: InteractionUse
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Pin metaclass.
   * @template
   */
	type Pin <: MultiplicityElement with ObjectNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Port metaclass.
   * @template
   */
	type Port <: Property
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 PrimitiveType metaclass.
   * @template
   */
	type PrimitiveType <: DataType
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Profile metaclass.
   * @template
   */
	type Profile <: Package
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ProfileApplication metaclass.
   * @template
   */
	type ProfileApplication <: DirectedRelationship
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Property metaclass.
   * @template
   */
	type Property <: ConnectableElement with DeploymentTarget with StructuralFeature
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ProtocolConformance metaclass.
   * @template
   */
	type ProtocolConformance <: DirectedRelationship
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ProtocolStateMachine metaclass.
   * @template
   */
	type ProtocolStateMachine <: StateMachine
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ProtocolTransition metaclass.
   * @template
   */
	type ProtocolTransition <: Transition
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Pseudostate metaclass.
   * @template
   */
	type Pseudostate <: Vertex
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 QualifierValue metaclass.
   * @template
   */
	type QualifierValue <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 RaiseExceptionAction metaclass.
   * @template
   */
	type RaiseExceptionAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ReadExtentAction metaclass.
   * @template
   */
	type ReadExtentAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ReadIsClassifiedObjectAction metaclass.
   * @template
   */
	type ReadIsClassifiedObjectAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ReadLinkAction metaclass.
   * @template
   */
	type ReadLinkAction <: LinkAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ReadLinkObjectEndAction metaclass.
   * @template
   */
	type ReadLinkObjectEndAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ReadLinkObjectEndQualifierAction metaclass.
   * @template
   */
	type ReadLinkObjectEndQualifierAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ReadSelfAction metaclass.
   * @template
   */
	type ReadSelfAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ReadStructuralFeatureAction metaclass.
   * @template
   */
	type ReadStructuralFeatureAction <: StructuralFeatureAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ReadVariableAction metaclass.
   * @template
   */
	type ReadVariableAction <: VariableAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Realization metaclass.
   * @template
   */
	type Realization <: Abstraction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Reception metaclass.
   * @template
   */
	type Reception <: BehavioralFeature
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ReclassifyObjectAction metaclass.
   * @template
   */
	type ReclassifyObjectAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 RedefinableElement metaclass.
   * @template
   */
	type RedefinableElement <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 RedefinableTemplateSignature metaclass.
   * @template
   */
	type RedefinableTemplateSignature <: RedefinableElement with TemplateSignature
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ReduceAction metaclass.
   * @template
   */
	type ReduceAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Region metaclass.
   * @template
   */
	type Region <: Namespace with RedefinableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Relationship metaclass.
   * @template
   */
	type Relationship <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 RemoveStructuralFeatureValueAction metaclass.
   * @template
   */
	type RemoveStructuralFeatureValueAction <: WriteStructuralFeatureAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 RemoveVariableValueAction metaclass.
   * @template
   */
	type RemoveVariableValueAction <: WriteVariableAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ReplyAction metaclass.
   * @template
   */
	type ReplyAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 SendObjectAction metaclass.
   * @template
   */
	type SendObjectAction <: InvocationAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 SendSignalAction metaclass.
   * @template
   */
	type SendSignalAction <: InvocationAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 SequenceNode metaclass.
   * @template
   */
	type SequenceNode <: StructuredActivityNode
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Signal metaclass.
   * @template
   */
	type Signal <: Classifier
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 SignalEvent metaclass.
   * @template
   */
	type SignalEvent <: MessageEvent
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Slot metaclass.
   * @template
   */
	type Slot <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 StartClassifierBehaviorAction metaclass.
   * @template
   */
	type StartClassifierBehaviorAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 StartObjectBehaviorAction metaclass.
   * @template
   */
	type StartObjectBehaviorAction <: CallAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 State metaclass.
   * @template
   */
	type State <: Namespace with RedefinableElement with Vertex
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 StateInvariant metaclass.
   * @template
   */
	type StateInvariant <: InteractionFragment
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 StateMachine metaclass.
   * @template
   */
	type StateMachine <: Behavior
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Stereotype metaclass.
   * @template
   */
	type Stereotype <: Class
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 StringExpression metaclass.
   * @template
   */
	type StringExpression <: Expression with TemplateableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 StructuralFeature metaclass.
   * @template
   */
	type StructuralFeature <: Feature with MultiplicityElement with TypedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 StructuralFeatureAction metaclass.
   * @template
   */
	type StructuralFeatureAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 StructuredActivityNode metaclass.
   * @template
   */
	type StructuredActivityNode <: Action with ActivityGroup with Namespace
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 StructuredClassifier metaclass.
   * @template
   */
	type StructuredClassifier <: Classifier
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Substitution metaclass.
   * @template
   */
	type Substitution <: Realization
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 TemplateBinding metaclass.
   * @template
   */
	type TemplateBinding <: DirectedRelationship
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 TemplateParameter metaclass.
   * @template
   */
	type TemplateParameter <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 TemplateParameterSubstitution metaclass.
   * @template
   */
	type TemplateParameterSubstitution <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 TemplateSignature metaclass.
   * @template
   */
	type TemplateSignature <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 TemplateableElement metaclass.
   * @template
   */
	type TemplateableElement <: Element
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 TestIdentityAction metaclass.
   * @template
   */
	type TestIdentityAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 TimeConstraint metaclass.
   * @template
   */
	type TimeConstraint <: IntervalConstraint
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 TimeEvent metaclass.
   * @template
   */
	type TimeEvent <: Event
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 TimeExpression metaclass.
   * @template
   */
	type TimeExpression <: ValueSpecification
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 TimeInterval metaclass.
   * @template
   */
	type TimeInterval <: Interval
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 TimeObservation metaclass.
   * @template
   */
	type TimeObservation <: Observation
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Transition metaclass.
   * @template
   */
	type Transition <: Namespace with RedefinableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Trigger metaclass.
   * @template
   */
	type Trigger <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Type metaclass.
   * @template
   */
	type Type <: PackageableElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 TypedElement metaclass.
   * @template
   */
	type TypedElement <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 UnmarshallAction metaclass.
   * @template
   */
	type UnmarshallAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Usage metaclass.
   * @template
   */
	type Usage <: Dependency
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 UseCase metaclass.
   * @template
   */
	type UseCase <: BehavioredClassifier
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ValuePin metaclass.
   * @template
   */
	type ValuePin <: InputPin
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ValueSpecification metaclass.
   * @template
   */
	type ValueSpecification <: PackageableElement with TypedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 ValueSpecificationAction metaclass.
   * @template
   */
	type ValueSpecificationAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Variable metaclass.
   * @template
   */
	type Variable <: ConnectableElement with MultiplicityElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 VariableAction metaclass.
   * @template
   */
	type VariableAction <: Action
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 Vertex metaclass.
   * @template
   */
	type Vertex <: NamedElement
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 WriteLinkAction metaclass.
   * @template
   */
	type WriteLinkAction <: LinkAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 WriteStructuralFeatureAction metaclass.
   * @template
   */
	type WriteStructuralFeatureAction <: StructuralFeatureAction
  /**
   * The tool-specific Java type that corresponds to the OMG UML 2.5 WriteVariableAction metaclass.
   * @template
   */
	type WriteVariableAction <: VariableAction

	// Start of user code for additional types

	/**
	 * A type corresponding to the tool-specific mechanism used for managing an inter-related
	 * set of UML model documents (serializable or built-in)
	 */
	type DocumentSetAggregate
	
   /**
    * A type for specifying the "url" from where an OTI Canonical XMI document should be loaded. 
    * This type is intentionally opaque so that a tool-specific OTI adaptation 
    * can include additional information according to the need of the tool being adapted.
    */
   type LoadURL
    // End of user code
}
