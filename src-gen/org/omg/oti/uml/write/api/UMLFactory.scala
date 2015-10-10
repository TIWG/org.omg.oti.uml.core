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

  val reflectiveFactoryLookup: Map[String, (UMLFactory[Uml] => ValidationNel[UMLError[Uml]#UException, _ <: UMLElement[Uml]])] =
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

  def createUMLAbstraction: ValidationNel[UMLError[Uml]#UException,UMLAbstraction[Uml]]

  def createUMLAcceptCallAction: ValidationNel[UMLError[Uml]#UException,UMLAcceptCallAction[Uml]]

  def createUMLAcceptEventAction: ValidationNel[UMLError[Uml]#UException,UMLAcceptEventAction[Uml]]

  def createUMLActionExecutionSpecification: ValidationNel[UMLError[Uml]#UException,UMLActionExecutionSpecification[Uml]]

  def createUMLActionInputPin: ValidationNel[UMLError[Uml]#UException,UMLActionInputPin[Uml]]

  def createUMLActivity: ValidationNel[UMLError[Uml]#UException,UMLActivity[Uml]]

  def createUMLActivityFinalNode: ValidationNel[UMLError[Uml]#UException,UMLActivityFinalNode[Uml]]

  def createUMLActivityParameterNode: ValidationNel[UMLError[Uml]#UException,UMLActivityParameterNode[Uml]]

  def createUMLActivityPartition: ValidationNel[UMLError[Uml]#UException,UMLActivityPartition[Uml]]

  def createUMLActor: ValidationNel[UMLError[Uml]#UException,UMLActor[Uml]]

  def createUMLAddStructuralFeatureValueAction: ValidationNel[UMLError[Uml]#UException,UMLAddStructuralFeatureValueAction[Uml]]

  def createUMLAddVariableValueAction: ValidationNel[UMLError[Uml]#UException,UMLAddVariableValueAction[Uml]]

  def createUMLAnyReceiveEvent: ValidationNel[UMLError[Uml]#UException,UMLAnyReceiveEvent[Uml]]

  def createUMLArtifact: ValidationNel[UMLError[Uml]#UException,UMLArtifact[Uml]]

  def createUMLAssociation: ValidationNel[UMLError[Uml]#UException,UMLAssociation[Uml]]

  def createUMLAssociationClass: ValidationNel[UMLError[Uml]#UException,UMLAssociationClass[Uml]]

  def createUMLBehaviorExecutionSpecification: ValidationNel[UMLError[Uml]#UException,UMLBehaviorExecutionSpecification[Uml]]

  def createUMLBroadcastSignalAction: ValidationNel[UMLError[Uml]#UException,UMLBroadcastSignalAction[Uml]]

  def createUMLCallBehaviorAction: ValidationNel[UMLError[Uml]#UException,UMLCallBehaviorAction[Uml]]

  def createUMLCallEvent: ValidationNel[UMLError[Uml]#UException,UMLCallEvent[Uml]]

  def createUMLCallOperationAction: ValidationNel[UMLError[Uml]#UException,UMLCallOperationAction[Uml]]

  def createUMLCentralBufferNode: ValidationNel[UMLError[Uml]#UException,UMLCentralBufferNode[Uml]]

  def createUMLChangeEvent: ValidationNel[UMLError[Uml]#UException,UMLChangeEvent[Uml]]

  def createUMLClass: ValidationNel[UMLError[Uml]#UException,UMLClass[Uml]]

  def createUMLClassifierTemplateParameter: ValidationNel[UMLError[Uml]#UException,UMLClassifierTemplateParameter[Uml]]

  def createUMLClause: ValidationNel[UMLError[Uml]#UException,UMLClause[Uml]]

  def createUMLClearAssociationAction: ValidationNel[UMLError[Uml]#UException,UMLClearAssociationAction[Uml]]

  def createUMLClearStructuralFeatureAction: ValidationNel[UMLError[Uml]#UException,UMLClearStructuralFeatureAction[Uml]]

  def createUMLClearVariableAction: ValidationNel[UMLError[Uml]#UException,UMLClearVariableAction[Uml]]

  def createUMLCollaboration: ValidationNel[UMLError[Uml]#UException,UMLCollaboration[Uml]]

  def createUMLCollaborationUse: ValidationNel[UMLError[Uml]#UException,UMLCollaborationUse[Uml]]

  def createUMLCombinedFragment: ValidationNel[UMLError[Uml]#UException,UMLCombinedFragment[Uml]]

  def createUMLComment: ValidationNel[UMLError[Uml]#UException,UMLComment[Uml]]

  def createUMLCommunicationPath: ValidationNel[UMLError[Uml]#UException,UMLCommunicationPath[Uml]]

  def createUMLComponent: ValidationNel[UMLError[Uml]#UException,UMLComponent[Uml]]

  def createUMLComponentRealization: ValidationNel[UMLError[Uml]#UException,UMLComponentRealization[Uml]]

  def createUMLConditionalNode: ValidationNel[UMLError[Uml]#UException,UMLConditionalNode[Uml]]

  def createUMLConnectableElementTemplateParameter: ValidationNel[UMLError[Uml]#UException,UMLConnectableElementTemplateParameter[Uml]]

  def createUMLConnectionPointReference: ValidationNel[UMLError[Uml]#UException,UMLConnectionPointReference[Uml]]

  def createUMLConnector: ValidationNel[UMLError[Uml]#UException,UMLConnector[Uml]]

  def createUMLConnectorEnd: ValidationNel[UMLError[Uml]#UException,UMLConnectorEnd[Uml]]

  def createUMLConsiderIgnoreFragment: ValidationNel[UMLError[Uml]#UException,UMLConsiderIgnoreFragment[Uml]]

  def createUMLConstraint: ValidationNel[UMLError[Uml]#UException,UMLConstraint[Uml]]

  def createUMLContinuation: ValidationNel[UMLError[Uml]#UException,UMLContinuation[Uml]]

  def createUMLControlFlow: ValidationNel[UMLError[Uml]#UException,UMLControlFlow[Uml]]

  def createUMLCreateLinkAction: ValidationNel[UMLError[Uml]#UException,UMLCreateLinkAction[Uml]]

  def createUMLCreateLinkObjectAction: ValidationNel[UMLError[Uml]#UException,UMLCreateLinkObjectAction[Uml]]

  def createUMLCreateObjectAction: ValidationNel[UMLError[Uml]#UException,UMLCreateObjectAction[Uml]]

  def createUMLDataStoreNode: ValidationNel[UMLError[Uml]#UException,UMLDataStoreNode[Uml]]

  def createUMLDataType: ValidationNel[UMLError[Uml]#UException,UMLDataType[Uml]]

  def createUMLDecisionNode: ValidationNel[UMLError[Uml]#UException,UMLDecisionNode[Uml]]

  def createUMLDependency: ValidationNel[UMLError[Uml]#UException,UMLDependency[Uml]]

  def createUMLDeployment: ValidationNel[UMLError[Uml]#UException,UMLDeployment[Uml]]

  def createUMLDeploymentSpecification: ValidationNel[UMLError[Uml]#UException,UMLDeploymentSpecification[Uml]]

  def createUMLDestroyLinkAction: ValidationNel[UMLError[Uml]#UException,UMLDestroyLinkAction[Uml]]

  def createUMLDestroyObjectAction: ValidationNel[UMLError[Uml]#UException,UMLDestroyObjectAction[Uml]]

  def createUMLDestructionOccurrenceSpecification: ValidationNel[UMLError[Uml]#UException,UMLDestructionOccurrenceSpecification[Uml]]

  def createUMLDevice: ValidationNel[UMLError[Uml]#UException,UMLDevice[Uml]]

  def createUMLDuration: ValidationNel[UMLError[Uml]#UException,UMLDuration[Uml]]

  def createUMLDurationConstraint: ValidationNel[UMLError[Uml]#UException,UMLDurationConstraint[Uml]]

  def createUMLDurationInterval: ValidationNel[UMLError[Uml]#UException,UMLDurationInterval[Uml]]

  def createUMLDurationObservation: ValidationNel[UMLError[Uml]#UException,UMLDurationObservation[Uml]]

  def createUMLElementImport: ValidationNel[UMLError[Uml]#UException,UMLElementImport[Uml]]

  def createUMLEnumeration: ValidationNel[UMLError[Uml]#UException,UMLEnumeration[Uml]]

  def createUMLEnumerationLiteral: ValidationNel[UMLError[Uml]#UException,UMLEnumerationLiteral[Uml]]

  def createUMLExceptionHandler: ValidationNel[UMLError[Uml]#UException,UMLExceptionHandler[Uml]]

  def createUMLExecutionEnvironment: ValidationNel[UMLError[Uml]#UException,UMLExecutionEnvironment[Uml]]

  def createUMLExecutionOccurrenceSpecification: ValidationNel[UMLError[Uml]#UException,UMLExecutionOccurrenceSpecification[Uml]]

  def createUMLExpansionNode: ValidationNel[UMLError[Uml]#UException,UMLExpansionNode[Uml]]

  def createUMLExpansionRegion: ValidationNel[UMLError[Uml]#UException,UMLExpansionRegion[Uml]]

  def createUMLExpression: ValidationNel[UMLError[Uml]#UException,UMLExpression[Uml]]

  def createUMLExtend: ValidationNel[UMLError[Uml]#UException,UMLExtend[Uml]]

  def createUMLExtension: ValidationNel[UMLError[Uml]#UException,UMLExtension[Uml]]

  def createUMLExtensionEnd: ValidationNel[UMLError[Uml]#UException,UMLExtensionEnd[Uml]]

  def createUMLExtensionPoint: ValidationNel[UMLError[Uml]#UException,UMLExtensionPoint[Uml]]

  def createUMLFinalState: ValidationNel[UMLError[Uml]#UException,UMLFinalState[Uml]]

  def createUMLFlowFinalNode: ValidationNel[UMLError[Uml]#UException,UMLFlowFinalNode[Uml]]

  def createUMLForkNode: ValidationNel[UMLError[Uml]#UException,UMLForkNode[Uml]]

  def createUMLFunctionBehavior: ValidationNel[UMLError[Uml]#UException,UMLFunctionBehavior[Uml]]

  def createUMLGate: ValidationNel[UMLError[Uml]#UException,UMLGate[Uml]]

  def createUMLGeneralOrdering: ValidationNel[UMLError[Uml]#UException,UMLGeneralOrdering[Uml]]

  def createUMLGeneralization: ValidationNel[UMLError[Uml]#UException,UMLGeneralization[Uml]]

  def createUMLGeneralizationSet: ValidationNel[UMLError[Uml]#UException,UMLGeneralizationSet[Uml]]

  def createUMLImage: ValidationNel[UMLError[Uml]#UException,UMLImage[Uml]]

  def createUMLInclude: ValidationNel[UMLError[Uml]#UException,UMLInclude[Uml]]

  def createUMLInformationFlow: ValidationNel[UMLError[Uml]#UException,UMLInformationFlow[Uml]]

  def createUMLInformationItem: ValidationNel[UMLError[Uml]#UException,UMLInformationItem[Uml]]

  def createUMLInitialNode: ValidationNel[UMLError[Uml]#UException,UMLInitialNode[Uml]]

  def createUMLInputPin: ValidationNel[UMLError[Uml]#UException,UMLInputPin[Uml]]

  def createUMLInstanceSpecification: ValidationNel[UMLError[Uml]#UException,UMLInstanceSpecification[Uml]]

  def createUMLInstanceValue: ValidationNel[UMLError[Uml]#UException,UMLInstanceValue[Uml]]

  def createUMLInteraction: ValidationNel[UMLError[Uml]#UException,UMLInteraction[Uml]]

  def createUMLInteractionConstraint: ValidationNel[UMLError[Uml]#UException,UMLInteractionConstraint[Uml]]

  def createUMLInteractionOperand: ValidationNel[UMLError[Uml]#UException,UMLInteractionOperand[Uml]]

  def createUMLInteractionUse: ValidationNel[UMLError[Uml]#UException,UMLInteractionUse[Uml]]

  def createUMLInterface: ValidationNel[UMLError[Uml]#UException,UMLInterface[Uml]]

  def createUMLInterfaceRealization: ValidationNel[UMLError[Uml]#UException,UMLInterfaceRealization[Uml]]

  def createUMLInterruptibleActivityRegion: ValidationNel[UMLError[Uml]#UException,UMLInterruptibleActivityRegion[Uml]]

  def createUMLInterval: ValidationNel[UMLError[Uml]#UException,UMLInterval[Uml]]

  def createUMLIntervalConstraint: ValidationNel[UMLError[Uml]#UException,UMLIntervalConstraint[Uml]]

  def createUMLJoinNode: ValidationNel[UMLError[Uml]#UException,UMLJoinNode[Uml]]

  def createUMLLifeline: ValidationNel[UMLError[Uml]#UException,UMLLifeline[Uml]]

  def createUMLLinkEndCreationData: ValidationNel[UMLError[Uml]#UException,UMLLinkEndCreationData[Uml]]

  def createUMLLinkEndData: ValidationNel[UMLError[Uml]#UException,UMLLinkEndData[Uml]]

  def createUMLLinkEndDestructionData: ValidationNel[UMLError[Uml]#UException,UMLLinkEndDestructionData[Uml]]

  def createUMLLiteralBoolean: ValidationNel[UMLError[Uml]#UException,UMLLiteralBoolean[Uml]]

  def createUMLLiteralInteger: ValidationNel[UMLError[Uml]#UException,UMLLiteralInteger[Uml]]

  def createUMLLiteralNull: ValidationNel[UMLError[Uml]#UException,UMLLiteralNull[Uml]]

  def createUMLLiteralReal: ValidationNel[UMLError[Uml]#UException,UMLLiteralReal[Uml]]

  def createUMLLiteralString: ValidationNel[UMLError[Uml]#UException,UMLLiteralString[Uml]]

  def createUMLLiteralUnlimitedNatural: ValidationNel[UMLError[Uml]#UException,UMLLiteralUnlimitedNatural[Uml]]

  def createUMLLoopNode: ValidationNel[UMLError[Uml]#UException,UMLLoopNode[Uml]]

  def createUMLManifestation: ValidationNel[UMLError[Uml]#UException,UMLManifestation[Uml]]

  def createUMLMergeNode: ValidationNel[UMLError[Uml]#UException,UMLMergeNode[Uml]]

  def createUMLMessage: ValidationNel[UMLError[Uml]#UException,UMLMessage[Uml]]

  def createUMLMessageOccurrenceSpecification: ValidationNel[UMLError[Uml]#UException,UMLMessageOccurrenceSpecification[Uml]]

  def createUMLModel: ValidationNel[UMLError[Uml]#UException,UMLModel[Uml]]

  def createUMLNode: ValidationNel[UMLError[Uml]#UException,UMLNode[Uml]]

  def createUMLObjectFlow: ValidationNel[UMLError[Uml]#UException,UMLObjectFlow[Uml]]

  def createUMLOccurrenceSpecification: ValidationNel[UMLError[Uml]#UException,UMLOccurrenceSpecification[Uml]]

  def createUMLOpaqueAction: ValidationNel[UMLError[Uml]#UException,UMLOpaqueAction[Uml]]

  def createUMLOpaqueBehavior: ValidationNel[UMLError[Uml]#UException,UMLOpaqueBehavior[Uml]]

  def createUMLOpaqueExpression: ValidationNel[UMLError[Uml]#UException,UMLOpaqueExpression[Uml]]

  def createUMLOperation: ValidationNel[UMLError[Uml]#UException,UMLOperation[Uml]]

  def createUMLOperationTemplateParameter: ValidationNel[UMLError[Uml]#UException,UMLOperationTemplateParameter[Uml]]

  def createUMLOutputPin: ValidationNel[UMLError[Uml]#UException,UMLOutputPin[Uml]]

  def createUMLPackage: ValidationNel[UMLError[Uml]#UException,UMLPackage[Uml]]

  def createUMLPackageImport: ValidationNel[UMLError[Uml]#UException,UMLPackageImport[Uml]]

  def createUMLPackageMerge: ValidationNel[UMLError[Uml]#UException,UMLPackageMerge[Uml]]

  def createUMLParameter: ValidationNel[UMLError[Uml]#UException,UMLParameter[Uml]]

  def createUMLParameterSet: ValidationNel[UMLError[Uml]#UException,UMLParameterSet[Uml]]

  def createUMLPartDecomposition: ValidationNel[UMLError[Uml]#UException,UMLPartDecomposition[Uml]]

  def createUMLPort: ValidationNel[UMLError[Uml]#UException,UMLPort[Uml]]

  def createUMLPrimitiveType: ValidationNel[UMLError[Uml]#UException,UMLPrimitiveType[Uml]]

  def createUMLProfile: ValidationNel[UMLError[Uml]#UException,UMLProfile[Uml]]

  def createUMLProfileApplication: ValidationNel[UMLError[Uml]#UException,UMLProfileApplication[Uml]]

  def createUMLProperty: ValidationNel[UMLError[Uml]#UException,UMLProperty[Uml]]

  def createUMLProtocolConformance: ValidationNel[UMLError[Uml]#UException,UMLProtocolConformance[Uml]]

  def createUMLProtocolStateMachine: ValidationNel[UMLError[Uml]#UException,UMLProtocolStateMachine[Uml]]

  def createUMLProtocolTransition: ValidationNel[UMLError[Uml]#UException,UMLProtocolTransition[Uml]]

  def createUMLPseudostate: ValidationNel[UMLError[Uml]#UException,UMLPseudostate[Uml]]

  def createUMLQualifierValue: ValidationNel[UMLError[Uml]#UException,UMLQualifierValue[Uml]]

  def createUMLRaiseExceptionAction: ValidationNel[UMLError[Uml]#UException,UMLRaiseExceptionAction[Uml]]

  def createUMLReadExtentAction: ValidationNel[UMLError[Uml]#UException,UMLReadExtentAction[Uml]]

  def createUMLReadIsClassifiedObjectAction: ValidationNel[UMLError[Uml]#UException,UMLReadIsClassifiedObjectAction[Uml]]

  def createUMLReadLinkAction: ValidationNel[UMLError[Uml]#UException,UMLReadLinkAction[Uml]]

  def createUMLReadLinkObjectEndAction: ValidationNel[UMLError[Uml]#UException,UMLReadLinkObjectEndAction[Uml]]

  def createUMLReadLinkObjectEndQualifierAction: ValidationNel[UMLError[Uml]#UException,UMLReadLinkObjectEndQualifierAction[Uml]]

  def createUMLReadSelfAction: ValidationNel[UMLError[Uml]#UException,UMLReadSelfAction[Uml]]

  def createUMLReadStructuralFeatureAction: ValidationNel[UMLError[Uml]#UException,UMLReadStructuralFeatureAction[Uml]]

  def createUMLReadVariableAction: ValidationNel[UMLError[Uml]#UException,UMLReadVariableAction[Uml]]

  def createUMLRealization: ValidationNel[UMLError[Uml]#UException,UMLRealization[Uml]]

  def createUMLReception: ValidationNel[UMLError[Uml]#UException,UMLReception[Uml]]

  def createUMLReclassifyObjectAction: ValidationNel[UMLError[Uml]#UException,UMLReclassifyObjectAction[Uml]]

  def createUMLRedefinableTemplateSignature: ValidationNel[UMLError[Uml]#UException,UMLRedefinableTemplateSignature[Uml]]

  def createUMLReduceAction: ValidationNel[UMLError[Uml]#UException,UMLReduceAction[Uml]]

  def createUMLRegion: ValidationNel[UMLError[Uml]#UException,UMLRegion[Uml]]

  def createUMLRemoveStructuralFeatureValueAction: ValidationNel[UMLError[Uml]#UException,UMLRemoveStructuralFeatureValueAction[Uml]]

  def createUMLRemoveVariableValueAction: ValidationNel[UMLError[Uml]#UException,UMLRemoveVariableValueAction[Uml]]

  def createUMLReplyAction: ValidationNel[UMLError[Uml]#UException,UMLReplyAction[Uml]]

  def createUMLSendObjectAction: ValidationNel[UMLError[Uml]#UException,UMLSendObjectAction[Uml]]

  def createUMLSendSignalAction: ValidationNel[UMLError[Uml]#UException,UMLSendSignalAction[Uml]]

  def createUMLSequenceNode: ValidationNel[UMLError[Uml]#UException,UMLSequenceNode[Uml]]

  def createUMLSignal: ValidationNel[UMLError[Uml]#UException,UMLSignal[Uml]]

  def createUMLSignalEvent: ValidationNel[UMLError[Uml]#UException,UMLSignalEvent[Uml]]

  def createUMLSlot: ValidationNel[UMLError[Uml]#UException,UMLSlot[Uml]]

  def createUMLStartClassifierBehaviorAction: ValidationNel[UMLError[Uml]#UException,UMLStartClassifierBehaviorAction[Uml]]

  def createUMLStartObjectBehaviorAction: ValidationNel[UMLError[Uml]#UException,UMLStartObjectBehaviorAction[Uml]]

  def createUMLState: ValidationNel[UMLError[Uml]#UException,UMLState[Uml]]

  def createUMLStateInvariant: ValidationNel[UMLError[Uml]#UException,UMLStateInvariant[Uml]]

  def createUMLStateMachine: ValidationNel[UMLError[Uml]#UException,UMLStateMachine[Uml]]

  def createUMLStereotype: ValidationNel[UMLError[Uml]#UException,UMLStereotype[Uml]]

  def createUMLStringExpression: ValidationNel[UMLError[Uml]#UException,UMLStringExpression[Uml]]

  def createUMLStructuredActivityNode: ValidationNel[UMLError[Uml]#UException,UMLStructuredActivityNode[Uml]]

  def createUMLSubstitution: ValidationNel[UMLError[Uml]#UException,UMLSubstitution[Uml]]

  def createUMLTemplateBinding: ValidationNel[UMLError[Uml]#UException,UMLTemplateBinding[Uml]]

  def createUMLTemplateParameter: ValidationNel[UMLError[Uml]#UException,UMLTemplateParameter[Uml]]

  def createUMLTemplateParameterSubstitution: ValidationNel[UMLError[Uml]#UException,UMLTemplateParameterSubstitution[Uml]]

  def createUMLTemplateSignature: ValidationNel[UMLError[Uml]#UException,UMLTemplateSignature[Uml]]

  def createUMLTestIdentityAction: ValidationNel[UMLError[Uml]#UException,UMLTestIdentityAction[Uml]]

  def createUMLTimeConstraint: ValidationNel[UMLError[Uml]#UException,UMLTimeConstraint[Uml]]

  def createUMLTimeEvent: ValidationNel[UMLError[Uml]#UException,UMLTimeEvent[Uml]]

  def createUMLTimeExpression: ValidationNel[UMLError[Uml]#UException,UMLTimeExpression[Uml]]

  def createUMLTimeInterval: ValidationNel[UMLError[Uml]#UException,UMLTimeInterval[Uml]]

  def createUMLTimeObservation: ValidationNel[UMLError[Uml]#UException,UMLTimeObservation[Uml]]

  def createUMLTransition: ValidationNel[UMLError[Uml]#UException,UMLTransition[Uml]]

  def createUMLTrigger: ValidationNel[UMLError[Uml]#UException,UMLTrigger[Uml]]

  def createUMLUnmarshallAction: ValidationNel[UMLError[Uml]#UException,UMLUnmarshallAction[Uml]]

  def createUMLUsage: ValidationNel[UMLError[Uml]#UException,UMLUsage[Uml]]

  def createUMLUseCase: ValidationNel[UMLError[Uml]#UException,UMLUseCase[Uml]]

  def createUMLValuePin: ValidationNel[UMLError[Uml]#UException,UMLValuePin[Uml]]

  def createUMLValueSpecificationAction: ValidationNel[UMLError[Uml]#UException,UMLValueSpecificationAction[Uml]]

  def createUMLVariable: ValidationNel[UMLError[Uml]#UException,UMLVariable[Uml]]

	// Start of user code for additional features

  val reflectivePackageFactoryLookup
  : Map[String, (UMLFactory[Uml] => ValidationNel[UMLError[Uml]#UException, _ <: UMLPackage[Uml]])] =
    Map(
      "Package" -> (f => f.createUMLPackage),
      "Model" -> (f => f.createUMLModel),
      "Profile" -> (f => f.createUMLProfile))

	// End of user code
}
