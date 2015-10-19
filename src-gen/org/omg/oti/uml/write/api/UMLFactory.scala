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

  val reflectiveFactoryLookup: Map[String, (UMLFactory[Uml] => \/[NonEmptyList[java.lang.Throwable], _ <: UMLElement[Uml]])] =
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

  def createUMLAbstraction: \/[NonEmptyList[java.lang.Throwable],UMLAbstraction[Uml]]

  def createUMLAcceptCallAction: \/[NonEmptyList[java.lang.Throwable],UMLAcceptCallAction[Uml]]

  def createUMLAcceptEventAction: \/[NonEmptyList[java.lang.Throwable],UMLAcceptEventAction[Uml]]

  def createUMLActionExecutionSpecification: \/[NonEmptyList[java.lang.Throwable],UMLActionExecutionSpecification[Uml]]

  def createUMLActionInputPin: \/[NonEmptyList[java.lang.Throwable],UMLActionInputPin[Uml]]

  def createUMLActivity: \/[NonEmptyList[java.lang.Throwable],UMLActivity[Uml]]

  def createUMLActivityFinalNode: \/[NonEmptyList[java.lang.Throwable],UMLActivityFinalNode[Uml]]

  def createUMLActivityParameterNode: \/[NonEmptyList[java.lang.Throwable],UMLActivityParameterNode[Uml]]

  def createUMLActivityPartition: \/[NonEmptyList[java.lang.Throwable],UMLActivityPartition[Uml]]

  def createUMLActor: \/[NonEmptyList[java.lang.Throwable],UMLActor[Uml]]

  def createUMLAddStructuralFeatureValueAction: \/[NonEmptyList[java.lang.Throwable],UMLAddStructuralFeatureValueAction[Uml]]

  def createUMLAddVariableValueAction: \/[NonEmptyList[java.lang.Throwable],UMLAddVariableValueAction[Uml]]

  def createUMLAnyReceiveEvent: \/[NonEmptyList[java.lang.Throwable],UMLAnyReceiveEvent[Uml]]

  def createUMLArtifact: \/[NonEmptyList[java.lang.Throwable],UMLArtifact[Uml]]

  def createUMLAssociation: \/[NonEmptyList[java.lang.Throwable],UMLAssociation[Uml]]

  def createUMLAssociationClass: \/[NonEmptyList[java.lang.Throwable],UMLAssociationClass[Uml]]

  def createUMLBehaviorExecutionSpecification: \/[NonEmptyList[java.lang.Throwable],UMLBehaviorExecutionSpecification[Uml]]

  def createUMLBroadcastSignalAction: \/[NonEmptyList[java.lang.Throwable],UMLBroadcastSignalAction[Uml]]

  def createUMLCallBehaviorAction: \/[NonEmptyList[java.lang.Throwable],UMLCallBehaviorAction[Uml]]

  def createUMLCallEvent: \/[NonEmptyList[java.lang.Throwable],UMLCallEvent[Uml]]

  def createUMLCallOperationAction: \/[NonEmptyList[java.lang.Throwable],UMLCallOperationAction[Uml]]

  def createUMLCentralBufferNode: \/[NonEmptyList[java.lang.Throwable],UMLCentralBufferNode[Uml]]

  def createUMLChangeEvent: \/[NonEmptyList[java.lang.Throwable],UMLChangeEvent[Uml]]

  def createUMLClass: \/[NonEmptyList[java.lang.Throwable],UMLClass[Uml]]

  def createUMLClassifierTemplateParameter: \/[NonEmptyList[java.lang.Throwable],UMLClassifierTemplateParameter[Uml]]

  def createUMLClause: \/[NonEmptyList[java.lang.Throwable],UMLClause[Uml]]

  def createUMLClearAssociationAction: \/[NonEmptyList[java.lang.Throwable],UMLClearAssociationAction[Uml]]

  def createUMLClearStructuralFeatureAction: \/[NonEmptyList[java.lang.Throwable],UMLClearStructuralFeatureAction[Uml]]

  def createUMLClearVariableAction: \/[NonEmptyList[java.lang.Throwable],UMLClearVariableAction[Uml]]

  def createUMLCollaboration: \/[NonEmptyList[java.lang.Throwable],UMLCollaboration[Uml]]

  def createUMLCollaborationUse: \/[NonEmptyList[java.lang.Throwable],UMLCollaborationUse[Uml]]

  def createUMLCombinedFragment: \/[NonEmptyList[java.lang.Throwable],UMLCombinedFragment[Uml]]

  def createUMLComment: \/[NonEmptyList[java.lang.Throwable],UMLComment[Uml]]

  def createUMLCommunicationPath: \/[NonEmptyList[java.lang.Throwable],UMLCommunicationPath[Uml]]

  def createUMLComponent: \/[NonEmptyList[java.lang.Throwable],UMLComponent[Uml]]

  def createUMLComponentRealization: \/[NonEmptyList[java.lang.Throwable],UMLComponentRealization[Uml]]

  def createUMLConditionalNode: \/[NonEmptyList[java.lang.Throwable],UMLConditionalNode[Uml]]

  def createUMLConnectableElementTemplateParameter: \/[NonEmptyList[java.lang.Throwable],UMLConnectableElementTemplateParameter[Uml]]

  def createUMLConnectionPointReference: \/[NonEmptyList[java.lang.Throwable],UMLConnectionPointReference[Uml]]

  def createUMLConnector: \/[NonEmptyList[java.lang.Throwable],UMLConnector[Uml]]

  def createUMLConnectorEnd: \/[NonEmptyList[java.lang.Throwable],UMLConnectorEnd[Uml]]

  def createUMLConsiderIgnoreFragment: \/[NonEmptyList[java.lang.Throwable],UMLConsiderIgnoreFragment[Uml]]

  def createUMLConstraint: \/[NonEmptyList[java.lang.Throwable],UMLConstraint[Uml]]

  def createUMLContinuation: \/[NonEmptyList[java.lang.Throwable],UMLContinuation[Uml]]

  def createUMLControlFlow: \/[NonEmptyList[java.lang.Throwable],UMLControlFlow[Uml]]

  def createUMLCreateLinkAction: \/[NonEmptyList[java.lang.Throwable],UMLCreateLinkAction[Uml]]

  def createUMLCreateLinkObjectAction: \/[NonEmptyList[java.lang.Throwable],UMLCreateLinkObjectAction[Uml]]

  def createUMLCreateObjectAction: \/[NonEmptyList[java.lang.Throwable],UMLCreateObjectAction[Uml]]

  def createUMLDataStoreNode: \/[NonEmptyList[java.lang.Throwable],UMLDataStoreNode[Uml]]

  def createUMLDataType: \/[NonEmptyList[java.lang.Throwable],UMLDataType[Uml]]

  def createUMLDecisionNode: \/[NonEmptyList[java.lang.Throwable],UMLDecisionNode[Uml]]

  def createUMLDependency: \/[NonEmptyList[java.lang.Throwable],UMLDependency[Uml]]

  def createUMLDeployment: \/[NonEmptyList[java.lang.Throwable],UMLDeployment[Uml]]

  def createUMLDeploymentSpecification: \/[NonEmptyList[java.lang.Throwable],UMLDeploymentSpecification[Uml]]

  def createUMLDestroyLinkAction: \/[NonEmptyList[java.lang.Throwable],UMLDestroyLinkAction[Uml]]

  def createUMLDestroyObjectAction: \/[NonEmptyList[java.lang.Throwable],UMLDestroyObjectAction[Uml]]

  def createUMLDestructionOccurrenceSpecification: \/[NonEmptyList[java.lang.Throwable],UMLDestructionOccurrenceSpecification[Uml]]

  def createUMLDevice: \/[NonEmptyList[java.lang.Throwable],UMLDevice[Uml]]

  def createUMLDuration: \/[NonEmptyList[java.lang.Throwable],UMLDuration[Uml]]

  def createUMLDurationConstraint: \/[NonEmptyList[java.lang.Throwable],UMLDurationConstraint[Uml]]

  def createUMLDurationInterval: \/[NonEmptyList[java.lang.Throwable],UMLDurationInterval[Uml]]

  def createUMLDurationObservation: \/[NonEmptyList[java.lang.Throwable],UMLDurationObservation[Uml]]

  def createUMLElementImport: \/[NonEmptyList[java.lang.Throwable],UMLElementImport[Uml]]

  def createUMLEnumeration: \/[NonEmptyList[java.lang.Throwable],UMLEnumeration[Uml]]

  def createUMLEnumerationLiteral: \/[NonEmptyList[java.lang.Throwable],UMLEnumerationLiteral[Uml]]

  def createUMLExceptionHandler: \/[NonEmptyList[java.lang.Throwable],UMLExceptionHandler[Uml]]

  def createUMLExecutionEnvironment: \/[NonEmptyList[java.lang.Throwable],UMLExecutionEnvironment[Uml]]

  def createUMLExecutionOccurrenceSpecification: \/[NonEmptyList[java.lang.Throwable],UMLExecutionOccurrenceSpecification[Uml]]

  def createUMLExpansionNode: \/[NonEmptyList[java.lang.Throwable],UMLExpansionNode[Uml]]

  def createUMLExpansionRegion: \/[NonEmptyList[java.lang.Throwable],UMLExpansionRegion[Uml]]

  def createUMLExpression: \/[NonEmptyList[java.lang.Throwable],UMLExpression[Uml]]

  def createUMLExtend: \/[NonEmptyList[java.lang.Throwable],UMLExtend[Uml]]

  def createUMLExtension: \/[NonEmptyList[java.lang.Throwable],UMLExtension[Uml]]

  def createUMLExtensionEnd: \/[NonEmptyList[java.lang.Throwable],UMLExtensionEnd[Uml]]

  def createUMLExtensionPoint: \/[NonEmptyList[java.lang.Throwable],UMLExtensionPoint[Uml]]

  def createUMLFinalState: \/[NonEmptyList[java.lang.Throwable],UMLFinalState[Uml]]

  def createUMLFlowFinalNode: \/[NonEmptyList[java.lang.Throwable],UMLFlowFinalNode[Uml]]

  def createUMLForkNode: \/[NonEmptyList[java.lang.Throwable],UMLForkNode[Uml]]

  def createUMLFunctionBehavior: \/[NonEmptyList[java.lang.Throwable],UMLFunctionBehavior[Uml]]

  def createUMLGate: \/[NonEmptyList[java.lang.Throwable],UMLGate[Uml]]

  def createUMLGeneralOrdering: \/[NonEmptyList[java.lang.Throwable],UMLGeneralOrdering[Uml]]

  def createUMLGeneralization: \/[NonEmptyList[java.lang.Throwable],UMLGeneralization[Uml]]

  def createUMLGeneralizationSet: \/[NonEmptyList[java.lang.Throwable],UMLGeneralizationSet[Uml]]

  def createUMLImage: \/[NonEmptyList[java.lang.Throwable],UMLImage[Uml]]

  def createUMLInclude: \/[NonEmptyList[java.lang.Throwable],UMLInclude[Uml]]

  def createUMLInformationFlow: \/[NonEmptyList[java.lang.Throwable],UMLInformationFlow[Uml]]

  def createUMLInformationItem: \/[NonEmptyList[java.lang.Throwable],UMLInformationItem[Uml]]

  def createUMLInitialNode: \/[NonEmptyList[java.lang.Throwable],UMLInitialNode[Uml]]

  def createUMLInputPin: \/[NonEmptyList[java.lang.Throwable],UMLInputPin[Uml]]

  def createUMLInstanceSpecification: \/[NonEmptyList[java.lang.Throwable],UMLInstanceSpecification[Uml]]

  def createUMLInstanceValue: \/[NonEmptyList[java.lang.Throwable],UMLInstanceValue[Uml]]

  def createUMLInteraction: \/[NonEmptyList[java.lang.Throwable],UMLInteraction[Uml]]

  def createUMLInteractionConstraint: \/[NonEmptyList[java.lang.Throwable],UMLInteractionConstraint[Uml]]

  def createUMLInteractionOperand: \/[NonEmptyList[java.lang.Throwable],UMLInteractionOperand[Uml]]

  def createUMLInteractionUse: \/[NonEmptyList[java.lang.Throwable],UMLInteractionUse[Uml]]

  def createUMLInterface: \/[NonEmptyList[java.lang.Throwable],UMLInterface[Uml]]

  def createUMLInterfaceRealization: \/[NonEmptyList[java.lang.Throwable],UMLInterfaceRealization[Uml]]

  def createUMLInterruptibleActivityRegion: \/[NonEmptyList[java.lang.Throwable],UMLInterruptibleActivityRegion[Uml]]

  def createUMLInterval: \/[NonEmptyList[java.lang.Throwable],UMLInterval[Uml]]

  def createUMLIntervalConstraint: \/[NonEmptyList[java.lang.Throwable],UMLIntervalConstraint[Uml]]

  def createUMLJoinNode: \/[NonEmptyList[java.lang.Throwable],UMLJoinNode[Uml]]

  def createUMLLifeline: \/[NonEmptyList[java.lang.Throwable],UMLLifeline[Uml]]

  def createUMLLinkEndCreationData: \/[NonEmptyList[java.lang.Throwable],UMLLinkEndCreationData[Uml]]

  def createUMLLinkEndData: \/[NonEmptyList[java.lang.Throwable],UMLLinkEndData[Uml]]

  def createUMLLinkEndDestructionData: \/[NonEmptyList[java.lang.Throwable],UMLLinkEndDestructionData[Uml]]

  def createUMLLiteralBoolean: \/[NonEmptyList[java.lang.Throwable],UMLLiteralBoolean[Uml]]

  def createUMLLiteralInteger: \/[NonEmptyList[java.lang.Throwable],UMLLiteralInteger[Uml]]

  def createUMLLiteralNull: \/[NonEmptyList[java.lang.Throwable],UMLLiteralNull[Uml]]

  def createUMLLiteralReal: \/[NonEmptyList[java.lang.Throwable],UMLLiteralReal[Uml]]

  def createUMLLiteralString: \/[NonEmptyList[java.lang.Throwable],UMLLiteralString[Uml]]

  def createUMLLiteralUnlimitedNatural: \/[NonEmptyList[java.lang.Throwable],UMLLiteralUnlimitedNatural[Uml]]

  def createUMLLoopNode: \/[NonEmptyList[java.lang.Throwable],UMLLoopNode[Uml]]

  def createUMLManifestation: \/[NonEmptyList[java.lang.Throwable],UMLManifestation[Uml]]

  def createUMLMergeNode: \/[NonEmptyList[java.lang.Throwable],UMLMergeNode[Uml]]

  def createUMLMessage: \/[NonEmptyList[java.lang.Throwable],UMLMessage[Uml]]

  def createUMLMessageOccurrenceSpecification: \/[NonEmptyList[java.lang.Throwable],UMLMessageOccurrenceSpecification[Uml]]

  def createUMLModel: \/[NonEmptyList[java.lang.Throwable],UMLModel[Uml]]

  def createUMLNode: \/[NonEmptyList[java.lang.Throwable],UMLNode[Uml]]

  def createUMLObjectFlow: \/[NonEmptyList[java.lang.Throwable],UMLObjectFlow[Uml]]

  def createUMLOccurrenceSpecification: \/[NonEmptyList[java.lang.Throwable],UMLOccurrenceSpecification[Uml]]

  def createUMLOpaqueAction: \/[NonEmptyList[java.lang.Throwable],UMLOpaqueAction[Uml]]

  def createUMLOpaqueBehavior: \/[NonEmptyList[java.lang.Throwable],UMLOpaqueBehavior[Uml]]

  def createUMLOpaqueExpression: \/[NonEmptyList[java.lang.Throwable],UMLOpaqueExpression[Uml]]

  def createUMLOperation: \/[NonEmptyList[java.lang.Throwable],UMLOperation[Uml]]

  def createUMLOperationTemplateParameter: \/[NonEmptyList[java.lang.Throwable],UMLOperationTemplateParameter[Uml]]

  def createUMLOutputPin: \/[NonEmptyList[java.lang.Throwable],UMLOutputPin[Uml]]

  def createUMLPackage: \/[NonEmptyList[java.lang.Throwable],UMLPackage[Uml]]

  def createUMLPackageImport: \/[NonEmptyList[java.lang.Throwable],UMLPackageImport[Uml]]

  def createUMLPackageMerge: \/[NonEmptyList[java.lang.Throwable],UMLPackageMerge[Uml]]

  def createUMLParameter: \/[NonEmptyList[java.lang.Throwable],UMLParameter[Uml]]

  def createUMLParameterSet: \/[NonEmptyList[java.lang.Throwable],UMLParameterSet[Uml]]

  def createUMLPartDecomposition: \/[NonEmptyList[java.lang.Throwable],UMLPartDecomposition[Uml]]

  def createUMLPort: \/[NonEmptyList[java.lang.Throwable],UMLPort[Uml]]

  def createUMLPrimitiveType: \/[NonEmptyList[java.lang.Throwable],UMLPrimitiveType[Uml]]

  def createUMLProfile: \/[NonEmptyList[java.lang.Throwable],UMLProfile[Uml]]

  def createUMLProfileApplication: \/[NonEmptyList[java.lang.Throwable],UMLProfileApplication[Uml]]

  def createUMLProperty: \/[NonEmptyList[java.lang.Throwable],UMLProperty[Uml]]

  def createUMLProtocolConformance: \/[NonEmptyList[java.lang.Throwable],UMLProtocolConformance[Uml]]

  def createUMLProtocolStateMachine: \/[NonEmptyList[java.lang.Throwable],UMLProtocolStateMachine[Uml]]

  def createUMLProtocolTransition: \/[NonEmptyList[java.lang.Throwable],UMLProtocolTransition[Uml]]

  def createUMLPseudostate: \/[NonEmptyList[java.lang.Throwable],UMLPseudostate[Uml]]

  def createUMLQualifierValue: \/[NonEmptyList[java.lang.Throwable],UMLQualifierValue[Uml]]

  def createUMLRaiseExceptionAction: \/[NonEmptyList[java.lang.Throwable],UMLRaiseExceptionAction[Uml]]

  def createUMLReadExtentAction: \/[NonEmptyList[java.lang.Throwable],UMLReadExtentAction[Uml]]

  def createUMLReadIsClassifiedObjectAction: \/[NonEmptyList[java.lang.Throwable],UMLReadIsClassifiedObjectAction[Uml]]

  def createUMLReadLinkAction: \/[NonEmptyList[java.lang.Throwable],UMLReadLinkAction[Uml]]

  def createUMLReadLinkObjectEndAction: \/[NonEmptyList[java.lang.Throwable],UMLReadLinkObjectEndAction[Uml]]

  def createUMLReadLinkObjectEndQualifierAction: \/[NonEmptyList[java.lang.Throwable],UMLReadLinkObjectEndQualifierAction[Uml]]

  def createUMLReadSelfAction: \/[NonEmptyList[java.lang.Throwable],UMLReadSelfAction[Uml]]

  def createUMLReadStructuralFeatureAction: \/[NonEmptyList[java.lang.Throwable],UMLReadStructuralFeatureAction[Uml]]

  def createUMLReadVariableAction: \/[NonEmptyList[java.lang.Throwable],UMLReadVariableAction[Uml]]

  def createUMLRealization: \/[NonEmptyList[java.lang.Throwable],UMLRealization[Uml]]

  def createUMLReception: \/[NonEmptyList[java.lang.Throwable],UMLReception[Uml]]

  def createUMLReclassifyObjectAction: \/[NonEmptyList[java.lang.Throwable],UMLReclassifyObjectAction[Uml]]

  def createUMLRedefinableTemplateSignature: \/[NonEmptyList[java.lang.Throwable],UMLRedefinableTemplateSignature[Uml]]

  def createUMLReduceAction: \/[NonEmptyList[java.lang.Throwable],UMLReduceAction[Uml]]

  def createUMLRegion: \/[NonEmptyList[java.lang.Throwable],UMLRegion[Uml]]

  def createUMLRemoveStructuralFeatureValueAction: \/[NonEmptyList[java.lang.Throwable],UMLRemoveStructuralFeatureValueAction[Uml]]

  def createUMLRemoveVariableValueAction: \/[NonEmptyList[java.lang.Throwable],UMLRemoveVariableValueAction[Uml]]

  def createUMLReplyAction: \/[NonEmptyList[java.lang.Throwable],UMLReplyAction[Uml]]

  def createUMLSendObjectAction: \/[NonEmptyList[java.lang.Throwable],UMLSendObjectAction[Uml]]

  def createUMLSendSignalAction: \/[NonEmptyList[java.lang.Throwable],UMLSendSignalAction[Uml]]

  def createUMLSequenceNode: \/[NonEmptyList[java.lang.Throwable],UMLSequenceNode[Uml]]

  def createUMLSignal: \/[NonEmptyList[java.lang.Throwable],UMLSignal[Uml]]

  def createUMLSignalEvent: \/[NonEmptyList[java.lang.Throwable],UMLSignalEvent[Uml]]

  def createUMLSlot: \/[NonEmptyList[java.lang.Throwable],UMLSlot[Uml]]

  def createUMLStartClassifierBehaviorAction: \/[NonEmptyList[java.lang.Throwable],UMLStartClassifierBehaviorAction[Uml]]

  def createUMLStartObjectBehaviorAction: \/[NonEmptyList[java.lang.Throwable],UMLStartObjectBehaviorAction[Uml]]

  def createUMLState: \/[NonEmptyList[java.lang.Throwable],UMLState[Uml]]

  def createUMLStateInvariant: \/[NonEmptyList[java.lang.Throwable],UMLStateInvariant[Uml]]

  def createUMLStateMachine: \/[NonEmptyList[java.lang.Throwable],UMLStateMachine[Uml]]

  def createUMLStereotype: \/[NonEmptyList[java.lang.Throwable],UMLStereotype[Uml]]

  def createUMLStringExpression: \/[NonEmptyList[java.lang.Throwable],UMLStringExpression[Uml]]

  def createUMLStructuredActivityNode: \/[NonEmptyList[java.lang.Throwable],UMLStructuredActivityNode[Uml]]

  def createUMLSubstitution: \/[NonEmptyList[java.lang.Throwable],UMLSubstitution[Uml]]

  def createUMLTemplateBinding: \/[NonEmptyList[java.lang.Throwable],UMLTemplateBinding[Uml]]

  def createUMLTemplateParameter: \/[NonEmptyList[java.lang.Throwable],UMLTemplateParameter[Uml]]

  def createUMLTemplateParameterSubstitution: \/[NonEmptyList[java.lang.Throwable],UMLTemplateParameterSubstitution[Uml]]

  def createUMLTemplateSignature: \/[NonEmptyList[java.lang.Throwable],UMLTemplateSignature[Uml]]

  def createUMLTestIdentityAction: \/[NonEmptyList[java.lang.Throwable],UMLTestIdentityAction[Uml]]

  def createUMLTimeConstraint: \/[NonEmptyList[java.lang.Throwable],UMLTimeConstraint[Uml]]

  def createUMLTimeEvent: \/[NonEmptyList[java.lang.Throwable],UMLTimeEvent[Uml]]

  def createUMLTimeExpression: \/[NonEmptyList[java.lang.Throwable],UMLTimeExpression[Uml]]

  def createUMLTimeInterval: \/[NonEmptyList[java.lang.Throwable],UMLTimeInterval[Uml]]

  def createUMLTimeObservation: \/[NonEmptyList[java.lang.Throwable],UMLTimeObservation[Uml]]

  def createUMLTransition: \/[NonEmptyList[java.lang.Throwable],UMLTransition[Uml]]

  def createUMLTrigger: \/[NonEmptyList[java.lang.Throwable],UMLTrigger[Uml]]

  def createUMLUnmarshallAction: \/[NonEmptyList[java.lang.Throwable],UMLUnmarshallAction[Uml]]

  def createUMLUsage: \/[NonEmptyList[java.lang.Throwable],UMLUsage[Uml]]

  def createUMLUseCase: \/[NonEmptyList[java.lang.Throwable],UMLUseCase[Uml]]

  def createUMLValuePin: \/[NonEmptyList[java.lang.Throwable],UMLValuePin[Uml]]

  def createUMLValueSpecificationAction: \/[NonEmptyList[java.lang.Throwable],UMLValueSpecificationAction[Uml]]

  def createUMLVariable: \/[NonEmptyList[java.lang.Throwable],UMLVariable[Uml]]

	// Start of user code for additional features

  val reflectivePackageFactoryLookup
  : Map[String, (UMLFactory[Uml] => \/[NonEmptyList[java.lang.Throwable], _ <: UMLPackage[Uml]])] =
    Map(
      "Package" -> (f => f.createUMLPackage),
      "Model" -> (f => f.createUMLModel),
      "Profile" -> (f => f.createUMLProfile))

	// End of user code
}
