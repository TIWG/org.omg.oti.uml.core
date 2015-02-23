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
package org.omg.oti

trait UML {
	type Abstraction <: Dependency
	type AcceptCallAction <: AcceptEventAction
	type AcceptEventAction <: Action
	type Action <: ExecutableNode
	type ActionExecutionSpecification <: ExecutionSpecification
	type ActionInputPin <: InputPin
	type Activity <: Behavior
	type ActivityEdge <: RedefinableElement
	type ActivityFinalNode <: FinalNode
	type ActivityGroup <: NamedElement
	type ActivityNode <: RedefinableElement
	type ActivityParameterNode <: ObjectNode
	type ActivityPartition <: ActivityGroup
	type Actor <: BehavioredClassifier
	type AddStructuralFeatureValueAction <: WriteStructuralFeatureAction
	type AddVariableValueAction <: WriteVariableAction
	type AnyReceiveEvent <: MessageEvent
	type Artifact <: Classifier with DeployedArtifact
	type Association <: Classifier with Relationship
	type AssociationClass <: Association with Class
	type Behavior <: Class
	type BehaviorExecutionSpecification <: ExecutionSpecification
	type BehavioralFeature <: Namespace with Feature
	type BehavioredClassifier <: Classifier
	type BroadcastSignalAction <: InvocationAction
	type CallAction <: InvocationAction
	type CallBehaviorAction <: CallAction
	type CallEvent <: MessageEvent
	type CallOperationAction <: CallAction
	type CentralBufferNode <: ObjectNode
	type ChangeEvent <: Event
	type Class <: EncapsulatedClassifier with BehavioredClassifier
	type Classifier <: Type with TemplateableElement with RedefinableElement with Namespace
	type ClassifierTemplateParameter <: TemplateParameter
	type Clause <: Element
	type ClearAssociationAction <: Action
	type ClearStructuralFeatureAction <: StructuralFeatureAction
	type ClearVariableAction <: VariableAction
	type Collaboration <: StructuredClassifier with BehavioredClassifier
	type CollaborationUse <: NamedElement
	type CombinedFragment <: InteractionFragment
	type Comment <: Element
	type CommunicationPath <: Association
	type Component <: Class
	type ComponentRealization <: Realization
	type ConditionalNode <: StructuredActivityNode
	type ConnectableElement <: TypedElement with ParameterableElement
	type ConnectableElementTemplateParameter <: TemplateParameter
	type ConnectionPointReference <: Vertex
	type Connector <: Feature
	type ConnectorEnd <: MultiplicityElement
	type ConsiderIgnoreFragment <: CombinedFragment
	type Constraint <: PackageableElement
	type Continuation <: InteractionFragment
	type ControlFlow <: ActivityEdge
	type ControlNode <: ActivityNode
	type CreateLinkAction <: WriteLinkAction
	type CreateLinkObjectAction <: CreateLinkAction
	type CreateObjectAction <: Action
	type DataStoreNode <: CentralBufferNode
	type DataType <: Classifier
	type DecisionNode <: ControlNode
	type Dependency <: DirectedRelationship with PackageableElement
	type DeployedArtifact <: NamedElement
	type Deployment <: Dependency
	type DeploymentSpecification <: Artifact
	type DeploymentTarget <: NamedElement
	type DestroyLinkAction <: WriteLinkAction
	type DestroyObjectAction <: Action
	type DestructionOccurrenceSpecification <: MessageOccurrenceSpecification
	type Device <: Node
	type DirectedRelationship <: Relationship
	type Duration <: ValueSpecification
	type DurationConstraint <: IntervalConstraint
	type DurationInterval <: Interval
	type DurationObservation <: Observation
	type Element
	type ElementImport <: DirectedRelationship
	type EncapsulatedClassifier <: StructuredClassifier
	type Enumeration <: DataType
	type EnumerationLiteral <: InstanceSpecification
	type Event <: PackageableElement
	type ExceptionHandler <: Element
	type ExecutableNode <: ActivityNode
	type ExecutionEnvironment <: Node
	type ExecutionOccurrenceSpecification <: OccurrenceSpecification
	type ExecutionSpecification <: InteractionFragment
	type ExpansionNode <: ObjectNode
	type ExpansionRegion <: StructuredActivityNode
	type Expression <: ValueSpecification
	type Extend <: NamedElement with DirectedRelationship
	type Extension <: Association
	type ExtensionEnd <: Property
	type ExtensionPoint <: RedefinableElement
	type Feature <: RedefinableElement
	type FinalNode <: ControlNode
	type FinalState <: State
	type FlowFinalNode <: FinalNode
	type ForkNode <: ControlNode
	type FunctionBehavior <: OpaqueBehavior
	type Gate <: MessageEnd
	type GeneralOrdering <: NamedElement
	type Generalization <: DirectedRelationship
	type GeneralizationSet <: PackageableElement
	type Image <: Element
	type Include <: NamedElement with DirectedRelationship
	type InformationFlow <: DirectedRelationship with PackageableElement
	type InformationItem <: Classifier
	type InitialNode <: ControlNode
	type InputPin <: Pin
	type InstanceSpecification <: DeploymentTarget with DeployedArtifact with PackageableElement
	type InstanceValue <: ValueSpecification
	type Interaction <: InteractionFragment with Behavior
	type InteractionConstraint <: Constraint
	type InteractionFragment <: NamedElement
	type InteractionOperand <: Namespace with InteractionFragment
	type InteractionUse <: InteractionFragment
	type Interface <: Classifier
	type InterfaceRealization <: Realization
	type InterruptibleActivityRegion <: ActivityGroup
	type Interval <: ValueSpecification
	type IntervalConstraint <: Constraint
	type InvocationAction <: Action
	type JoinNode <: ControlNode
	type Lifeline <: NamedElement
	type LinkAction <: Action
	type LinkEndCreationData <: LinkEndData
	type LinkEndData <: Element
	type LinkEndDestructionData <: LinkEndData
	type LiteralBoolean <: LiteralSpecification
	type LiteralInteger <: LiteralSpecification
	type LiteralNull <: LiteralSpecification
	type LiteralReal <: LiteralSpecification
	type LiteralSpecification <: ValueSpecification
	type LiteralString <: LiteralSpecification
	type LiteralUnlimitedNatural <: LiteralSpecification
	type LoopNode <: StructuredActivityNode
	type Manifestation <: Abstraction
	type MergeNode <: ControlNode
	type Message <: NamedElement
	type MessageEnd <: NamedElement
	type MessageEvent <: Event
	type MessageOccurrenceSpecification <: OccurrenceSpecification with MessageEnd
	type Model <: Package
	type MultiplicityElement <: Element
	type NamedElement <: Element
	type Namespace <: NamedElement
	type Node <: DeploymentTarget with Class
	type ObjectFlow <: ActivityEdge
	type ObjectNode <: ActivityNode with TypedElement
	type Observation <: PackageableElement
	type OccurrenceSpecification <: InteractionFragment
	type OpaqueAction <: Action
	type OpaqueBehavior <: Behavior
	type OpaqueExpression <: ValueSpecification
	type Operation <: BehavioralFeature with TemplateableElement with ParameterableElement
	type OperationTemplateParameter <: TemplateParameter
	type OutputPin <: Pin
	type Package <: TemplateableElement with Namespace with PackageableElement
	type PackageImport <: DirectedRelationship
	type PackageMerge <: DirectedRelationship
	type PackageableElement <: NamedElement with ParameterableElement
	type Parameter <: MultiplicityElement with ConnectableElement
	type ParameterSet <: NamedElement
	type ParameterableElement <: Element
	type PartDecomposition <: InteractionUse
	type Pin <: ObjectNode with MultiplicityElement
	type Port <: Property
	type PrimitiveType <: DataType
	type Profile <: Package
	type ProfileApplication <: DirectedRelationship
	type Property <: DeploymentTarget with StructuralFeature with ConnectableElement
	type ProtocolConformance <: DirectedRelationship
	type ProtocolStateMachine <: StateMachine
	type ProtocolTransition <: Transition
	type Pseudostate <: Vertex
	type QualifierValue <: Element
	type RaiseExceptionAction <: Action
	type ReadExtentAction <: Action
	type ReadIsClassifiedObjectAction <: Action
	type ReadLinkAction <: LinkAction
	type ReadLinkObjectEndAction <: Action
	type ReadLinkObjectEndQualifierAction <: Action
	type ReadSelfAction <: Action
	type ReadStructuralFeatureAction <: StructuralFeatureAction
	type ReadVariableAction <: VariableAction
	type Realization <: Abstraction
	type Reception <: BehavioralFeature
	type ReclassifyObjectAction <: Action
	type RedefinableElement <: NamedElement
	type RedefinableTemplateSignature <: RedefinableElement with TemplateSignature
	type ReduceAction <: Action
	type Region <: RedefinableElement with Namespace
	type Relationship <: Element
	type RemoveStructuralFeatureValueAction <: WriteStructuralFeatureAction
	type RemoveVariableValueAction <: WriteVariableAction
	type ReplyAction <: Action
	type SendObjectAction <: InvocationAction
	type SendSignalAction <: InvocationAction
	type SequenceNode <: StructuredActivityNode
	type Signal <: Classifier
	type SignalEvent <: MessageEvent
	type Slot <: Element
	type StartClassifierBehaviorAction <: Action
	type StartObjectBehaviorAction <: CallAction
	type State <: RedefinableElement with Vertex with Namespace
	type StateInvariant <: InteractionFragment
	type StateMachine <: Behavior
	type Stereotype <: Class
	type StringExpression <: Expression with TemplateableElement
	type StructuralFeature <: TypedElement with MultiplicityElement with Feature
	type StructuralFeatureAction <: Action
	type StructuredActivityNode <: ActivityGroup with Namespace with Action
	type StructuredClassifier <: Classifier
	type Substitution <: Realization
	type TemplateBinding <: DirectedRelationship
	type TemplateParameter <: Element
	type TemplateParameterSubstitution <: Element
	type TemplateSignature <: Element
	type TemplateableElement <: Element
	type TestIdentityAction <: Action
	type TimeConstraint <: IntervalConstraint
	type TimeEvent <: Event
	type TimeExpression <: ValueSpecification
	type TimeInterval <: Interval
	type TimeObservation <: Observation
	type Transition <: RedefinableElement with Namespace
	type Trigger <: NamedElement
	type Type <: PackageableElement
	type TypedElement <: NamedElement
	type UnmarshallAction <: Action
	type Usage <: Dependency
	type UseCase <: BehavioredClassifier
	type ValuePin <: InputPin
	type ValueSpecification <: TypedElement with PackageableElement
	type ValueSpecificationAction <: Action
	type Variable <: MultiplicityElement with ConnectableElement
	type VariableAction <: Action
	type Vertex <: NamedElement
	type WriteLinkAction <: LinkAction
	type WriteStructuralFeatureAction <: StructuralFeatureAction
	type WriteVariableAction <: VariableAction
}