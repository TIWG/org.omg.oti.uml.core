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
import org.omg.oti.uml.UMLError
import org.omg.oti.uml.read.api._

import scala.Predef._
import scala.collection.immutable.Map
import scalaz._
// End of user code

/**
 * UML Factory
 *
 * <!-- Start of user code documentation -->
 * For the OTI xmi:ID & xmi:UUID ID generation algorithm to work properly, 
 * it is important that new elements be properly "owned" in the scope of a SerializableDocument.
 * That is, a new element is either:
 * - a root of a SerializableDocument (ie., a Package, a Profile or a Model)
 * - an element that, right after being created, is added as an owned element of some other element that is in scope of a SerializableDocument
 *   (that is, by calling one of the owner's links_<assoc>_<metaclass1>_<end1>_compose_<end2>_<metaclass2> methods
 * <!-- End of user code documentation -->
 */
trait UMLFactory[Uml <: UML] {

  val reflectiveFactoryLookup: Map[String, (UMLFactory[Uml] => \/[NonEmptyList[UMLError.UException], _ <: UMLElement[Uml]])] =
    Map(
      "Abstraction" -> (f => f.createUMLAbstraction),
      "AcceptCallAction" -> (f => f.createUMLAcceptCallAction),
      "AcceptEventAction" -> (f => f.createUMLAcceptEventAction),
      "ActionExecutionSpecification" -> (f => f.createUMLActionExecutionSpecification),
      "ActionInputPin" -> (f => f.createUMLActionInputPin),
      "Activity" -> (f => f.createUMLActivity),
      "ActivityFinalNode" -> (f => f.createUMLActivityFinalNode),
      "ActivityParameterNode" -> (f => f.createUMLActivityParameterNode),
      "ActivityPartition" -> (f => f.createUMLActivityPartition),
      "Actor" -> (f => f.createUMLActor),
      "AddStructuralFeatureValueAction" -> (f => f.createUMLAddStructuralFeatureValueAction),
      "AddVariableValueAction" -> (f => f.createUMLAddVariableValueAction),
      "AnyReceiveEvent" -> (f => f.createUMLAnyReceiveEvent),
      "Artifact" -> (f => f.createUMLArtifact),
      "Association" -> (f => f.createUMLAssociation),
      "AssociationClass" -> (f => f.createUMLAssociationClass),
      "BehaviorExecutionSpecification" -> (f => f.createUMLBehaviorExecutionSpecification),
      "BroadcastSignalAction" -> (f => f.createUMLBroadcastSignalAction),
      "CallBehaviorAction" -> (f => f.createUMLCallBehaviorAction),
      "CallEvent" -> (f => f.createUMLCallEvent),
      "CallOperationAction" -> (f => f.createUMLCallOperationAction),
      "CentralBufferNode" -> (f => f.createUMLCentralBufferNode),
      "ChangeEvent" -> (f => f.createUMLChangeEvent),
      "Class" -> (f => f.createUMLClass),
      "ClassifierTemplateParameter" -> (f => f.createUMLClassifierTemplateParameter),
      "Clause" -> (f => f.createUMLClause),
      "ClearAssociationAction" -> (f => f.createUMLClearAssociationAction),
      "ClearStructuralFeatureAction" -> (f => f.createUMLClearStructuralFeatureAction),
      "ClearVariableAction" -> (f => f.createUMLClearVariableAction),
      "Collaboration" -> (f => f.createUMLCollaboration),
      "CollaborationUse" -> (f => f.createUMLCollaborationUse),
      "CombinedFragment" -> (f => f.createUMLCombinedFragment),
      "Comment" -> (f => f.createUMLComment),
      "CommunicationPath" -> (f => f.createUMLCommunicationPath),
      "Component" -> (f => f.createUMLComponent),
      "ComponentRealization" -> (f => f.createUMLComponentRealization),
      "ConditionalNode" -> (f => f.createUMLConditionalNode),
      "ConnectableElementTemplateParameter" -> (f => f.createUMLConnectableElementTemplateParameter),
      "ConnectionPointReference" -> (f => f.createUMLConnectionPointReference),
      "Connector" -> (f => f.createUMLConnector),
      "ConnectorEnd" -> (f => f.createUMLConnectorEnd),
      "ConsiderIgnoreFragment" -> (f => f.createUMLConsiderIgnoreFragment),
      "Constraint" -> (f => f.createUMLConstraint),
      "Continuation" -> (f => f.createUMLContinuation),
      "ControlFlow" -> (f => f.createUMLControlFlow),
      "CreateLinkAction" -> (f => f.createUMLCreateLinkAction),
      "CreateLinkObjectAction" -> (f => f.createUMLCreateLinkObjectAction),
      "CreateObjectAction" -> (f => f.createUMLCreateObjectAction),
      "DataStoreNode" -> (f => f.createUMLDataStoreNode),
      "DataType" -> (f => f.createUMLDataType),
      "DecisionNode" -> (f => f.createUMLDecisionNode),
      "Dependency" -> (f => f.createUMLDependency),
      "Deployment" -> (f => f.createUMLDeployment),
      "DeploymentSpecification" -> (f => f.createUMLDeploymentSpecification),
      "DestroyLinkAction" -> (f => f.createUMLDestroyLinkAction),
      "DestroyObjectAction" -> (f => f.createUMLDestroyObjectAction),
      "DestructionOccurrenceSpecification" -> (f => f.createUMLDestructionOccurrenceSpecification),
      "Device" -> (f => f.createUMLDevice),
      "Duration" -> (f => f.createUMLDuration),
      "DurationConstraint" -> (f => f.createUMLDurationConstraint),
      "DurationInterval" -> (f => f.createUMLDurationInterval),
      "DurationObservation" -> (f => f.createUMLDurationObservation),
      "ElementImport" -> (f => f.createUMLElementImport),
      "Enumeration" -> (f => f.createUMLEnumeration),
      "EnumerationLiteral" -> (f => f.createUMLEnumerationLiteral),
      "ExceptionHandler" -> (f => f.createUMLExceptionHandler),
      "ExecutionEnvironment" -> (f => f.createUMLExecutionEnvironment),
      "ExecutionOccurrenceSpecification" -> (f => f.createUMLExecutionOccurrenceSpecification),
      "ExpansionNode" -> (f => f.createUMLExpansionNode),
      "ExpansionRegion" -> (f => f.createUMLExpansionRegion),
      "Expression" -> (f => f.createUMLExpression),
      "Extend" -> (f => f.createUMLExtend),
      "Extension" -> (f => f.createUMLExtension),
      "ExtensionEnd" -> (f => f.createUMLExtensionEnd),
      "ExtensionPoint" -> (f => f.createUMLExtensionPoint),
      "FinalState" -> (f => f.createUMLFinalState),
      "FlowFinalNode" -> (f => f.createUMLFlowFinalNode),
      "ForkNode" -> (f => f.createUMLForkNode),
      "FunctionBehavior" -> (f => f.createUMLFunctionBehavior),
      "Gate" -> (f => f.createUMLGate),
      "GeneralOrdering" -> (f => f.createUMLGeneralOrdering),
      "Generalization" -> (f => f.createUMLGeneralization),
      "GeneralizationSet" -> (f => f.createUMLGeneralizationSet),
      "Image" -> (f => f.createUMLImage),
      "Include" -> (f => f.createUMLInclude),
      "InformationFlow" -> (f => f.createUMLInformationFlow),
      "InformationItem" -> (f => f.createUMLInformationItem),
      "InitialNode" -> (f => f.createUMLInitialNode),
      "InputPin" -> (f => f.createUMLInputPin),
      "InstanceSpecification" -> (f => f.createUMLInstanceSpecification),
      "InstanceValue" -> (f => f.createUMLInstanceValue),
      "Interaction" -> (f => f.createUMLInteraction),
      "InteractionConstraint" -> (f => f.createUMLInteractionConstraint),
      "InteractionOperand" -> (f => f.createUMLInteractionOperand),
      "InteractionUse" -> (f => f.createUMLInteractionUse),
      "Interface" -> (f => f.createUMLInterface),
      "InterfaceRealization" -> (f => f.createUMLInterfaceRealization),
      "InterruptibleActivityRegion" -> (f => f.createUMLInterruptibleActivityRegion),
      "Interval" -> (f => f.createUMLInterval),
      "IntervalConstraint" -> (f => f.createUMLIntervalConstraint),
      "JoinNode" -> (f => f.createUMLJoinNode),
      "Lifeline" -> (f => f.createUMLLifeline),
      "LinkEndCreationData" -> (f => f.createUMLLinkEndCreationData),
      "LinkEndData" -> (f => f.createUMLLinkEndData),
      "LinkEndDestructionData" -> (f => f.createUMLLinkEndDestructionData),
      "LiteralBoolean" -> (f => f.createUMLLiteralBoolean),
      "LiteralInteger" -> (f => f.createUMLLiteralInteger),
      "LiteralNull" -> (f => f.createUMLLiteralNull),
      "LiteralReal" -> (f => f.createUMLLiteralReal),
      "LiteralString" -> (f => f.createUMLLiteralString),
      "LiteralUnlimitedNatural" -> (f => f.createUMLLiteralUnlimitedNatural),
      "LoopNode" -> (f => f.createUMLLoopNode),
      "Manifestation" -> (f => f.createUMLManifestation),
      "MergeNode" -> (f => f.createUMLMergeNode),
      "Message" -> (f => f.createUMLMessage),
      "MessageOccurrenceSpecification" -> (f => f.createUMLMessageOccurrenceSpecification),
      "Model" -> (f => f.createUMLModel),
      "Node" -> (f => f.createUMLNode),
      "ObjectFlow" -> (f => f.createUMLObjectFlow),
      "OccurrenceSpecification" -> (f => f.createUMLOccurrenceSpecification),
      "OpaqueAction" -> (f => f.createUMLOpaqueAction),
      "OpaqueBehavior" -> (f => f.createUMLOpaqueBehavior),
      "OpaqueExpression" -> (f => f.createUMLOpaqueExpression),
      "Operation" -> (f => f.createUMLOperation),
      "OperationTemplateParameter" -> (f => f.createUMLOperationTemplateParameter),
      "OutputPin" -> (f => f.createUMLOutputPin),
      "Package" -> (f => f.createUMLPackage),
      "PackageImport" -> (f => f.createUMLPackageImport),
      "PackageMerge" -> (f => f.createUMLPackageMerge),
      "Parameter" -> (f => f.createUMLParameter),
      "ParameterSet" -> (f => f.createUMLParameterSet),
      "PartDecomposition" -> (f => f.createUMLPartDecomposition),
      "Port" -> (f => f.createUMLPort),
      "PrimitiveType" -> (f => f.createUMLPrimitiveType),
      "Profile" -> (f => f.createUMLProfile),
      "ProfileApplication" -> (f => f.createUMLProfileApplication),
      "Property" -> (f => f.createUMLProperty),
      "ProtocolConformance" -> (f => f.createUMLProtocolConformance),
      "ProtocolStateMachine" -> (f => f.createUMLProtocolStateMachine),
      "ProtocolTransition" -> (f => f.createUMLProtocolTransition),
      "Pseudostate" -> (f => f.createUMLPseudostate),
      "QualifierValue" -> (f => f.createUMLQualifierValue),
      "RaiseExceptionAction" -> (f => f.createUMLRaiseExceptionAction),
      "ReadExtentAction" -> (f => f.createUMLReadExtentAction),
      "ReadIsClassifiedObjectAction" -> (f => f.createUMLReadIsClassifiedObjectAction),
      "ReadLinkAction" -> (f => f.createUMLReadLinkAction),
      "ReadLinkObjectEndAction" -> (f => f.createUMLReadLinkObjectEndAction),
      "ReadLinkObjectEndQualifierAction" -> (f => f.createUMLReadLinkObjectEndQualifierAction),
      "ReadSelfAction" -> (f => f.createUMLReadSelfAction),
      "ReadStructuralFeatureAction" -> (f => f.createUMLReadStructuralFeatureAction),
      "ReadVariableAction" -> (f => f.createUMLReadVariableAction),
      "Realization" -> (f => f.createUMLRealization),
      "Reception" -> (f => f.createUMLReception),
      "ReclassifyObjectAction" -> (f => f.createUMLReclassifyObjectAction),
      "RedefinableTemplateSignature" -> (f => f.createUMLRedefinableTemplateSignature),
      "ReduceAction" -> (f => f.createUMLReduceAction),
      "Region" -> (f => f.createUMLRegion),
      "RemoveStructuralFeatureValueAction" -> (f => f.createUMLRemoveStructuralFeatureValueAction),
      "RemoveVariableValueAction" -> (f => f.createUMLRemoveVariableValueAction),
      "ReplyAction" -> (f => f.createUMLReplyAction),
      "SendObjectAction" -> (f => f.createUMLSendObjectAction),
      "SendSignalAction" -> (f => f.createUMLSendSignalAction),
      "SequenceNode" -> (f => f.createUMLSequenceNode),
      "Signal" -> (f => f.createUMLSignal),
      "SignalEvent" -> (f => f.createUMLSignalEvent),
      "Slot" -> (f => f.createUMLSlot),
      "StartClassifierBehaviorAction" -> (f => f.createUMLStartClassifierBehaviorAction),
      "StartObjectBehaviorAction" -> (f => f.createUMLStartObjectBehaviorAction),
      "State" -> (f => f.createUMLState),
      "StateInvariant" -> (f => f.createUMLStateInvariant),
      "StateMachine" -> (f => f.createUMLStateMachine),
      "Stereotype" -> (f => f.createUMLStereotype),
      "StringExpression" -> (f => f.createUMLStringExpression),
      "StructuredActivityNode" -> (f => f.createUMLStructuredActivityNode),
      "Substitution" -> (f => f.createUMLSubstitution),
      "TemplateBinding" -> (f => f.createUMLTemplateBinding),
      "TemplateParameter" -> (f => f.createUMLTemplateParameter),
      "TemplateParameterSubstitution" -> (f => f.createUMLTemplateParameterSubstitution),
      "TemplateSignature" -> (f => f.createUMLTemplateSignature),
      "TestIdentityAction" -> (f => f.createUMLTestIdentityAction),
      "TimeConstraint" -> (f => f.createUMLTimeConstraint),
      "TimeEvent" -> (f => f.createUMLTimeEvent),
      "TimeExpression" -> (f => f.createUMLTimeExpression),
      "TimeInterval" -> (f => f.createUMLTimeInterval),
      "TimeObservation" -> (f => f.createUMLTimeObservation),
      "Transition" -> (f => f.createUMLTransition),
      "Trigger" -> (f => f.createUMLTrigger),
      "UnmarshallAction" -> (f => f.createUMLUnmarshallAction),
      "Usage" -> (f => f.createUMLUsage),
      "UseCase" -> (f => f.createUMLUseCase),
      "ValuePin" -> (f => f.createUMLValuePin),
      "ValueSpecificationAction" -> (f => f.createUMLValueSpecificationAction),
      "Variable" -> (f => f.createUMLVariable)
    )

  def createUMLAbstraction: \/[NonEmptyList[UMLError.UException],UMLAbstraction[Uml]]

  def createUMLAcceptCallAction: \/[NonEmptyList[UMLError.UException],UMLAcceptCallAction[Uml]]

  def createUMLAcceptEventAction: \/[NonEmptyList[UMLError.UException],UMLAcceptEventAction[Uml]]

  def createUMLActionExecutionSpecification: \/[NonEmptyList[UMLError.UException],UMLActionExecutionSpecification[Uml]]

  def createUMLActionInputPin: \/[NonEmptyList[UMLError.UException],UMLActionInputPin[Uml]]

  def createUMLActivity: \/[NonEmptyList[UMLError.UException],UMLActivity[Uml]]

  def createUMLActivityFinalNode: \/[NonEmptyList[UMLError.UException],UMLActivityFinalNode[Uml]]

  def createUMLActivityParameterNode: \/[NonEmptyList[UMLError.UException],UMLActivityParameterNode[Uml]]

  def createUMLActivityPartition: \/[NonEmptyList[UMLError.UException],UMLActivityPartition[Uml]]

  def createUMLActor: \/[NonEmptyList[UMLError.UException],UMLActor[Uml]]

  def createUMLAddStructuralFeatureValueAction: \/[NonEmptyList[UMLError.UException],UMLAddStructuralFeatureValueAction[Uml]]

  def createUMLAddVariableValueAction: \/[NonEmptyList[UMLError.UException],UMLAddVariableValueAction[Uml]]

  def createUMLAnyReceiveEvent: \/[NonEmptyList[UMLError.UException],UMLAnyReceiveEvent[Uml]]

  def createUMLArtifact: \/[NonEmptyList[UMLError.UException],UMLArtifact[Uml]]

  def createUMLAssociation: \/[NonEmptyList[UMLError.UException],UMLAssociation[Uml]]

  def createUMLAssociationClass: \/[NonEmptyList[UMLError.UException],UMLAssociationClass[Uml]]

  def createUMLBehaviorExecutionSpecification: \/[NonEmptyList[UMLError.UException],UMLBehaviorExecutionSpecification[Uml]]

  def createUMLBroadcastSignalAction: \/[NonEmptyList[UMLError.UException],UMLBroadcastSignalAction[Uml]]

  def createUMLCallBehaviorAction: \/[NonEmptyList[UMLError.UException],UMLCallBehaviorAction[Uml]]

  def createUMLCallEvent: \/[NonEmptyList[UMLError.UException],UMLCallEvent[Uml]]

  def createUMLCallOperationAction: \/[NonEmptyList[UMLError.UException],UMLCallOperationAction[Uml]]

  def createUMLCentralBufferNode: \/[NonEmptyList[UMLError.UException],UMLCentralBufferNode[Uml]]

  def createUMLChangeEvent: \/[NonEmptyList[UMLError.UException],UMLChangeEvent[Uml]]

  def createUMLClass: \/[NonEmptyList[UMLError.UException],UMLClass[Uml]]

  def createUMLClassifierTemplateParameter: \/[NonEmptyList[UMLError.UException],UMLClassifierTemplateParameter[Uml]]

  def createUMLClause: \/[NonEmptyList[UMLError.UException],UMLClause[Uml]]

  def createUMLClearAssociationAction: \/[NonEmptyList[UMLError.UException],UMLClearAssociationAction[Uml]]

  def createUMLClearStructuralFeatureAction: \/[NonEmptyList[UMLError.UException],UMLClearStructuralFeatureAction[Uml]]

  def createUMLClearVariableAction: \/[NonEmptyList[UMLError.UException],UMLClearVariableAction[Uml]]

  def createUMLCollaboration: \/[NonEmptyList[UMLError.UException],UMLCollaboration[Uml]]

  def createUMLCollaborationUse: \/[NonEmptyList[UMLError.UException],UMLCollaborationUse[Uml]]

  def createUMLCombinedFragment: \/[NonEmptyList[UMLError.UException],UMLCombinedFragment[Uml]]

  def createUMLComment: \/[NonEmptyList[UMLError.UException],UMLComment[Uml]]

  def createUMLCommunicationPath: \/[NonEmptyList[UMLError.UException],UMLCommunicationPath[Uml]]

  def createUMLComponent: \/[NonEmptyList[UMLError.UException],UMLComponent[Uml]]

  def createUMLComponentRealization: \/[NonEmptyList[UMLError.UException],UMLComponentRealization[Uml]]

  def createUMLConditionalNode: \/[NonEmptyList[UMLError.UException],UMLConditionalNode[Uml]]

  def createUMLConnectableElementTemplateParameter: \/[NonEmptyList[UMLError.UException],UMLConnectableElementTemplateParameter[Uml]]

  def createUMLConnectionPointReference: \/[NonEmptyList[UMLError.UException],UMLConnectionPointReference[Uml]]

  def createUMLConnector: \/[NonEmptyList[UMLError.UException],UMLConnector[Uml]]

  def createUMLConnectorEnd: \/[NonEmptyList[UMLError.UException],UMLConnectorEnd[Uml]]

  def createUMLConsiderIgnoreFragment: \/[NonEmptyList[UMLError.UException],UMLConsiderIgnoreFragment[Uml]]

  def createUMLConstraint: \/[NonEmptyList[UMLError.UException],UMLConstraint[Uml]]

  def createUMLContinuation: \/[NonEmptyList[UMLError.UException],UMLContinuation[Uml]]

  def createUMLControlFlow: \/[NonEmptyList[UMLError.UException],UMLControlFlow[Uml]]

  def createUMLCreateLinkAction: \/[NonEmptyList[UMLError.UException],UMLCreateLinkAction[Uml]]

  def createUMLCreateLinkObjectAction: \/[NonEmptyList[UMLError.UException],UMLCreateLinkObjectAction[Uml]]

  def createUMLCreateObjectAction: \/[NonEmptyList[UMLError.UException],UMLCreateObjectAction[Uml]]

  def createUMLDataStoreNode: \/[NonEmptyList[UMLError.UException],UMLDataStoreNode[Uml]]

  def createUMLDataType: \/[NonEmptyList[UMLError.UException],UMLDataType[Uml]]

  def createUMLDecisionNode: \/[NonEmptyList[UMLError.UException],UMLDecisionNode[Uml]]

  def createUMLDependency: \/[NonEmptyList[UMLError.UException],UMLDependency[Uml]]

  def createUMLDeployment: \/[NonEmptyList[UMLError.UException],UMLDeployment[Uml]]

  def createUMLDeploymentSpecification: \/[NonEmptyList[UMLError.UException],UMLDeploymentSpecification[Uml]]

  def createUMLDestroyLinkAction: \/[NonEmptyList[UMLError.UException],UMLDestroyLinkAction[Uml]]

  def createUMLDestroyObjectAction: \/[NonEmptyList[UMLError.UException],UMLDestroyObjectAction[Uml]]

  def createUMLDestructionOccurrenceSpecification: \/[NonEmptyList[UMLError.UException],UMLDestructionOccurrenceSpecification[Uml]]

  def createUMLDevice: \/[NonEmptyList[UMLError.UException],UMLDevice[Uml]]

  def createUMLDuration: \/[NonEmptyList[UMLError.UException],UMLDuration[Uml]]

  def createUMLDurationConstraint: \/[NonEmptyList[UMLError.UException],UMLDurationConstraint[Uml]]

  def createUMLDurationInterval: \/[NonEmptyList[UMLError.UException],UMLDurationInterval[Uml]]

  def createUMLDurationObservation: \/[NonEmptyList[UMLError.UException],UMLDurationObservation[Uml]]

  def createUMLElementImport: \/[NonEmptyList[UMLError.UException],UMLElementImport[Uml]]

  def createUMLEnumeration: \/[NonEmptyList[UMLError.UException],UMLEnumeration[Uml]]

  def createUMLEnumerationLiteral: \/[NonEmptyList[UMLError.UException],UMLEnumerationLiteral[Uml]]

  def createUMLExceptionHandler: \/[NonEmptyList[UMLError.UException],UMLExceptionHandler[Uml]]

  def createUMLExecutionEnvironment: \/[NonEmptyList[UMLError.UException],UMLExecutionEnvironment[Uml]]

  def createUMLExecutionOccurrenceSpecification: \/[NonEmptyList[UMLError.UException],UMLExecutionOccurrenceSpecification[Uml]]

  def createUMLExpansionNode: \/[NonEmptyList[UMLError.UException],UMLExpansionNode[Uml]]

  def createUMLExpansionRegion: \/[NonEmptyList[UMLError.UException],UMLExpansionRegion[Uml]]

  def createUMLExpression: \/[NonEmptyList[UMLError.UException],UMLExpression[Uml]]

  def createUMLExtend: \/[NonEmptyList[UMLError.UException],UMLExtend[Uml]]

  def createUMLExtension: \/[NonEmptyList[UMLError.UException],UMLExtension[Uml]]

  def createUMLExtensionEnd: \/[NonEmptyList[UMLError.UException],UMLExtensionEnd[Uml]]

  def createUMLExtensionPoint: \/[NonEmptyList[UMLError.UException],UMLExtensionPoint[Uml]]

  def createUMLFinalState: \/[NonEmptyList[UMLError.UException],UMLFinalState[Uml]]

  def createUMLFlowFinalNode: \/[NonEmptyList[UMLError.UException],UMLFlowFinalNode[Uml]]

  def createUMLForkNode: \/[NonEmptyList[UMLError.UException],UMLForkNode[Uml]]

  def createUMLFunctionBehavior: \/[NonEmptyList[UMLError.UException],UMLFunctionBehavior[Uml]]

  def createUMLGate: \/[NonEmptyList[UMLError.UException],UMLGate[Uml]]

  def createUMLGeneralOrdering: \/[NonEmptyList[UMLError.UException],UMLGeneralOrdering[Uml]]

  def createUMLGeneralization: \/[NonEmptyList[UMLError.UException],UMLGeneralization[Uml]]

  def createUMLGeneralizationSet: \/[NonEmptyList[UMLError.UException],UMLGeneralizationSet[Uml]]

  def createUMLImage: \/[NonEmptyList[UMLError.UException],UMLImage[Uml]]

  def createUMLInclude: \/[NonEmptyList[UMLError.UException],UMLInclude[Uml]]

  def createUMLInformationFlow: \/[NonEmptyList[UMLError.UException],UMLInformationFlow[Uml]]

  def createUMLInformationItem: \/[NonEmptyList[UMLError.UException],UMLInformationItem[Uml]]

  def createUMLInitialNode: \/[NonEmptyList[UMLError.UException],UMLInitialNode[Uml]]

  def createUMLInputPin: \/[NonEmptyList[UMLError.UException],UMLInputPin[Uml]]

  def createUMLInstanceSpecification: \/[NonEmptyList[UMLError.UException],UMLInstanceSpecification[Uml]]

  def createUMLInstanceValue: \/[NonEmptyList[UMLError.UException],UMLInstanceValue[Uml]]

  def createUMLInteraction: \/[NonEmptyList[UMLError.UException],UMLInteraction[Uml]]

  def createUMLInteractionConstraint: \/[NonEmptyList[UMLError.UException],UMLInteractionConstraint[Uml]]

  def createUMLInteractionOperand: \/[NonEmptyList[UMLError.UException],UMLInteractionOperand[Uml]]

  def createUMLInteractionUse: \/[NonEmptyList[UMLError.UException],UMLInteractionUse[Uml]]

  def createUMLInterface: \/[NonEmptyList[UMLError.UException],UMLInterface[Uml]]

  def createUMLInterfaceRealization: \/[NonEmptyList[UMLError.UException],UMLInterfaceRealization[Uml]]

  def createUMLInterruptibleActivityRegion: \/[NonEmptyList[UMLError.UException],UMLInterruptibleActivityRegion[Uml]]

  def createUMLInterval: \/[NonEmptyList[UMLError.UException],UMLInterval[Uml]]

  def createUMLIntervalConstraint: \/[NonEmptyList[UMLError.UException],UMLIntervalConstraint[Uml]]

  def createUMLJoinNode: \/[NonEmptyList[UMLError.UException],UMLJoinNode[Uml]]

  def createUMLLifeline: \/[NonEmptyList[UMLError.UException],UMLLifeline[Uml]]

  def createUMLLinkEndCreationData: \/[NonEmptyList[UMLError.UException],UMLLinkEndCreationData[Uml]]

  def createUMLLinkEndData: \/[NonEmptyList[UMLError.UException],UMLLinkEndData[Uml]]

  def createUMLLinkEndDestructionData: \/[NonEmptyList[UMLError.UException],UMLLinkEndDestructionData[Uml]]

  def createUMLLiteralBoolean: \/[NonEmptyList[UMLError.UException],UMLLiteralBoolean[Uml]]

  def createUMLLiteralInteger: \/[NonEmptyList[UMLError.UException],UMLLiteralInteger[Uml]]

  def createUMLLiteralNull: \/[NonEmptyList[UMLError.UException],UMLLiteralNull[Uml]]

  def createUMLLiteralReal: \/[NonEmptyList[UMLError.UException],UMLLiteralReal[Uml]]

  def createUMLLiteralString: \/[NonEmptyList[UMLError.UException],UMLLiteralString[Uml]]

  def createUMLLiteralUnlimitedNatural: \/[NonEmptyList[UMLError.UException],UMLLiteralUnlimitedNatural[Uml]]

  def createUMLLoopNode: \/[NonEmptyList[UMLError.UException],UMLLoopNode[Uml]]

  def createUMLManifestation: \/[NonEmptyList[UMLError.UException],UMLManifestation[Uml]]

  def createUMLMergeNode: \/[NonEmptyList[UMLError.UException],UMLMergeNode[Uml]]

  def createUMLMessage: \/[NonEmptyList[UMLError.UException],UMLMessage[Uml]]

  def createUMLMessageOccurrenceSpecification: \/[NonEmptyList[UMLError.UException],UMLMessageOccurrenceSpecification[Uml]]

  def createUMLModel: \/[NonEmptyList[UMLError.UException],UMLModel[Uml]]

  def createUMLNode: \/[NonEmptyList[UMLError.UException],UMLNode[Uml]]

  def createUMLObjectFlow: \/[NonEmptyList[UMLError.UException],UMLObjectFlow[Uml]]

  def createUMLOccurrenceSpecification: \/[NonEmptyList[UMLError.UException],UMLOccurrenceSpecification[Uml]]

  def createUMLOpaqueAction: \/[NonEmptyList[UMLError.UException],UMLOpaqueAction[Uml]]

  def createUMLOpaqueBehavior: \/[NonEmptyList[UMLError.UException],UMLOpaqueBehavior[Uml]]

  def createUMLOpaqueExpression: \/[NonEmptyList[UMLError.UException],UMLOpaqueExpression[Uml]]

  def createUMLOperation: \/[NonEmptyList[UMLError.UException],UMLOperation[Uml]]

  def createUMLOperationTemplateParameter: \/[NonEmptyList[UMLError.UException],UMLOperationTemplateParameter[Uml]]

  def createUMLOutputPin: \/[NonEmptyList[UMLError.UException],UMLOutputPin[Uml]]

  def createUMLPackage: \/[NonEmptyList[UMLError.UException],UMLPackage[Uml]]

  def createUMLPackageImport: \/[NonEmptyList[UMLError.UException],UMLPackageImport[Uml]]

  def createUMLPackageMerge: \/[NonEmptyList[UMLError.UException],UMLPackageMerge[Uml]]

  def createUMLParameter: \/[NonEmptyList[UMLError.UException],UMLParameter[Uml]]

  def createUMLParameterSet: \/[NonEmptyList[UMLError.UException],UMLParameterSet[Uml]]

  def createUMLPartDecomposition: \/[NonEmptyList[UMLError.UException],UMLPartDecomposition[Uml]]

  def createUMLPort: \/[NonEmptyList[UMLError.UException],UMLPort[Uml]]

  def createUMLPrimitiveType: \/[NonEmptyList[UMLError.UException],UMLPrimitiveType[Uml]]

  def createUMLProfile: \/[NonEmptyList[UMLError.UException],UMLProfile[Uml]]

  def createUMLProfileApplication: \/[NonEmptyList[UMLError.UException],UMLProfileApplication[Uml]]

  def createUMLProperty: \/[NonEmptyList[UMLError.UException],UMLProperty[Uml]]

  def createUMLProtocolConformance: \/[NonEmptyList[UMLError.UException],UMLProtocolConformance[Uml]]

  def createUMLProtocolStateMachine: \/[NonEmptyList[UMLError.UException],UMLProtocolStateMachine[Uml]]

  def createUMLProtocolTransition: \/[NonEmptyList[UMLError.UException],UMLProtocolTransition[Uml]]

  def createUMLPseudostate: \/[NonEmptyList[UMLError.UException],UMLPseudostate[Uml]]

  def createUMLQualifierValue: \/[NonEmptyList[UMLError.UException],UMLQualifierValue[Uml]]

  def createUMLRaiseExceptionAction: \/[NonEmptyList[UMLError.UException],UMLRaiseExceptionAction[Uml]]

  def createUMLReadExtentAction: \/[NonEmptyList[UMLError.UException],UMLReadExtentAction[Uml]]

  def createUMLReadIsClassifiedObjectAction: \/[NonEmptyList[UMLError.UException],UMLReadIsClassifiedObjectAction[Uml]]

  def createUMLReadLinkAction: \/[NonEmptyList[UMLError.UException],UMLReadLinkAction[Uml]]

  def createUMLReadLinkObjectEndAction: \/[NonEmptyList[UMLError.UException],UMLReadLinkObjectEndAction[Uml]]

  def createUMLReadLinkObjectEndQualifierAction: \/[NonEmptyList[UMLError.UException],UMLReadLinkObjectEndQualifierAction[Uml]]

  def createUMLReadSelfAction: \/[NonEmptyList[UMLError.UException],UMLReadSelfAction[Uml]]

  def createUMLReadStructuralFeatureAction: \/[NonEmptyList[UMLError.UException],UMLReadStructuralFeatureAction[Uml]]

  def createUMLReadVariableAction: \/[NonEmptyList[UMLError.UException],UMLReadVariableAction[Uml]]

  def createUMLRealization: \/[NonEmptyList[UMLError.UException],UMLRealization[Uml]]

  def createUMLReception: \/[NonEmptyList[UMLError.UException],UMLReception[Uml]]

  def createUMLReclassifyObjectAction: \/[NonEmptyList[UMLError.UException],UMLReclassifyObjectAction[Uml]]

  def createUMLRedefinableTemplateSignature: \/[NonEmptyList[UMLError.UException],UMLRedefinableTemplateSignature[Uml]]

  def createUMLReduceAction: \/[NonEmptyList[UMLError.UException],UMLReduceAction[Uml]]

  def createUMLRegion: \/[NonEmptyList[UMLError.UException],UMLRegion[Uml]]

  def createUMLRemoveStructuralFeatureValueAction: \/[NonEmptyList[UMLError.UException],UMLRemoveStructuralFeatureValueAction[Uml]]

  def createUMLRemoveVariableValueAction: \/[NonEmptyList[UMLError.UException],UMLRemoveVariableValueAction[Uml]]

  def createUMLReplyAction: \/[NonEmptyList[UMLError.UException],UMLReplyAction[Uml]]

  def createUMLSendObjectAction: \/[NonEmptyList[UMLError.UException],UMLSendObjectAction[Uml]]

  def createUMLSendSignalAction: \/[NonEmptyList[UMLError.UException],UMLSendSignalAction[Uml]]

  def createUMLSequenceNode: \/[NonEmptyList[UMLError.UException],UMLSequenceNode[Uml]]

  def createUMLSignal: \/[NonEmptyList[UMLError.UException],UMLSignal[Uml]]

  def createUMLSignalEvent: \/[NonEmptyList[UMLError.UException],UMLSignalEvent[Uml]]

  def createUMLSlot: \/[NonEmptyList[UMLError.UException],UMLSlot[Uml]]

  def createUMLStartClassifierBehaviorAction: \/[NonEmptyList[UMLError.UException],UMLStartClassifierBehaviorAction[Uml]]

  def createUMLStartObjectBehaviorAction: \/[NonEmptyList[UMLError.UException],UMLStartObjectBehaviorAction[Uml]]

  def createUMLState: \/[NonEmptyList[UMLError.UException],UMLState[Uml]]

  def createUMLStateInvariant: \/[NonEmptyList[UMLError.UException],UMLStateInvariant[Uml]]

  def createUMLStateMachine: \/[NonEmptyList[UMLError.UException],UMLStateMachine[Uml]]

  def createUMLStereotype: \/[NonEmptyList[UMLError.UException],UMLStereotype[Uml]]

  def createUMLStringExpression: \/[NonEmptyList[UMLError.UException],UMLStringExpression[Uml]]

  def createUMLStructuredActivityNode: \/[NonEmptyList[UMLError.UException],UMLStructuredActivityNode[Uml]]

  def createUMLSubstitution: \/[NonEmptyList[UMLError.UException],UMLSubstitution[Uml]]

  def createUMLTemplateBinding: \/[NonEmptyList[UMLError.UException],UMLTemplateBinding[Uml]]

  def createUMLTemplateParameter: \/[NonEmptyList[UMLError.UException],UMLTemplateParameter[Uml]]

  def createUMLTemplateParameterSubstitution: \/[NonEmptyList[UMLError.UException],UMLTemplateParameterSubstitution[Uml]]

  def createUMLTemplateSignature: \/[NonEmptyList[UMLError.UException],UMLTemplateSignature[Uml]]

  def createUMLTestIdentityAction: \/[NonEmptyList[UMLError.UException],UMLTestIdentityAction[Uml]]

  def createUMLTimeConstraint: \/[NonEmptyList[UMLError.UException],UMLTimeConstraint[Uml]]

  def createUMLTimeEvent: \/[NonEmptyList[UMLError.UException],UMLTimeEvent[Uml]]

  def createUMLTimeExpression: \/[NonEmptyList[UMLError.UException],UMLTimeExpression[Uml]]

  def createUMLTimeInterval: \/[NonEmptyList[UMLError.UException],UMLTimeInterval[Uml]]

  def createUMLTimeObservation: \/[NonEmptyList[UMLError.UException],UMLTimeObservation[Uml]]

  def createUMLTransition: \/[NonEmptyList[UMLError.UException],UMLTransition[Uml]]

  def createUMLTrigger: \/[NonEmptyList[UMLError.UException],UMLTrigger[Uml]]

  def createUMLUnmarshallAction: \/[NonEmptyList[UMLError.UException],UMLUnmarshallAction[Uml]]

  def createUMLUsage: \/[NonEmptyList[UMLError.UException],UMLUsage[Uml]]

  def createUMLUseCase: \/[NonEmptyList[UMLError.UException],UMLUseCase[Uml]]

  def createUMLValuePin: \/[NonEmptyList[UMLError.UException],UMLValuePin[Uml]]

  def createUMLValueSpecificationAction: \/[NonEmptyList[UMLError.UException],UMLValueSpecificationAction[Uml]]

  def createUMLVariable: \/[NonEmptyList[UMLError.UException],UMLVariable[Uml]]

	// Start of user code for additional features

  val reflectivePackageFactoryLookup
  : Map[String, (UMLFactory[Uml] => \/[NonEmptyList[UMLError.UException], _ <: UMLPackage[Uml]])] =
    Map(
      "Package" -> (f => f.createUMLPackage),
      "Model" -> (f => f.createUMLModel),
      "Profile" -> (f => f.createUMLProfile))

	// End of user code
}
