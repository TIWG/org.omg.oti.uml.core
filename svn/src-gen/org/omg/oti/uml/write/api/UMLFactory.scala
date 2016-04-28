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

  val reflectiveFactoryLookup: Map[String, (UMLFactory[Uml] => \/[Set[java.lang.Throwable], _ <: UMLElement[Uml]])] =
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
      "Diagram" -> (f => f.createUMLDiagram),
      "Duration" -> (f => f.createUMLDuration),
      "DurationConstraint" -> (f => f.createUMLDurationConstraint),
      "DurationInterval" -> (f => f.createUMLDurationInterval),
      "DurationObservation" -> (f => f.createUMLDurationObservation),
      "ElementImport" -> (f => f.createUMLElementImport),
      "ElementValue" -> (f => f.createUMLElementValue),
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

  def createUMLAbstraction: \/[Set[java.lang.Throwable],UMLAbstraction[Uml]]

  def createUMLAcceptCallAction: \/[Set[java.lang.Throwable],UMLAcceptCallAction[Uml]]

  def createUMLAcceptEventAction: \/[Set[java.lang.Throwable],UMLAcceptEventAction[Uml]]

  def createUMLActionExecutionSpecification: \/[Set[java.lang.Throwable],UMLActionExecutionSpecification[Uml]]

  def createUMLActionInputPin: \/[Set[java.lang.Throwable],UMLActionInputPin[Uml]]

  def createUMLActivity: \/[Set[java.lang.Throwable],UMLActivity[Uml]]

  def createUMLActivityFinalNode: \/[Set[java.lang.Throwable],UMLActivityFinalNode[Uml]]

  def createUMLActivityParameterNode: \/[Set[java.lang.Throwable],UMLActivityParameterNode[Uml]]

  def createUMLActivityPartition: \/[Set[java.lang.Throwable],UMLActivityPartition[Uml]]

  def createUMLActor: \/[Set[java.lang.Throwable],UMLActor[Uml]]

  def createUMLAddStructuralFeatureValueAction: \/[Set[java.lang.Throwable],UMLAddStructuralFeatureValueAction[Uml]]

  def createUMLAddVariableValueAction: \/[Set[java.lang.Throwable],UMLAddVariableValueAction[Uml]]

  def createUMLAnyReceiveEvent: \/[Set[java.lang.Throwable],UMLAnyReceiveEvent[Uml]]

  def createUMLArtifact: \/[Set[java.lang.Throwable],UMLArtifact[Uml]]

  def createUMLAssociation: \/[Set[java.lang.Throwable],UMLAssociation[Uml]]

  def createUMLAssociationClass: \/[Set[java.lang.Throwable],UMLAssociationClass[Uml]]

  def createUMLBehaviorExecutionSpecification: \/[Set[java.lang.Throwable],UMLBehaviorExecutionSpecification[Uml]]

  def createUMLBroadcastSignalAction: \/[Set[java.lang.Throwable],UMLBroadcastSignalAction[Uml]]

  def createUMLCallBehaviorAction: \/[Set[java.lang.Throwable],UMLCallBehaviorAction[Uml]]

  def createUMLCallEvent: \/[Set[java.lang.Throwable],UMLCallEvent[Uml]]

  def createUMLCallOperationAction: \/[Set[java.lang.Throwable],UMLCallOperationAction[Uml]]

  def createUMLCentralBufferNode: \/[Set[java.lang.Throwable],UMLCentralBufferNode[Uml]]

  def createUMLChangeEvent: \/[Set[java.lang.Throwable],UMLChangeEvent[Uml]]

  def createUMLClass: \/[Set[java.lang.Throwable],UMLClass[Uml]]

  def createUMLClassifierTemplateParameter: \/[Set[java.lang.Throwable],UMLClassifierTemplateParameter[Uml]]

  def createUMLClause: \/[Set[java.lang.Throwable],UMLClause[Uml]]

  def createUMLClearAssociationAction: \/[Set[java.lang.Throwable],UMLClearAssociationAction[Uml]]

  def createUMLClearStructuralFeatureAction: \/[Set[java.lang.Throwable],UMLClearStructuralFeatureAction[Uml]]

  def createUMLClearVariableAction: \/[Set[java.lang.Throwable],UMLClearVariableAction[Uml]]

  def createUMLCollaboration: \/[Set[java.lang.Throwable],UMLCollaboration[Uml]]

  def createUMLCollaborationUse: \/[Set[java.lang.Throwable],UMLCollaborationUse[Uml]]

  def createUMLCombinedFragment: \/[Set[java.lang.Throwable],UMLCombinedFragment[Uml]]

  def createUMLComment: \/[Set[java.lang.Throwable],UMLComment[Uml]]

  def createUMLCommunicationPath: \/[Set[java.lang.Throwable],UMLCommunicationPath[Uml]]

  def createUMLComponent: \/[Set[java.lang.Throwable],UMLComponent[Uml]]

  def createUMLComponentRealization: \/[Set[java.lang.Throwable],UMLComponentRealization[Uml]]

  def createUMLConditionalNode: \/[Set[java.lang.Throwable],UMLConditionalNode[Uml]]

  def createUMLConnectableElementTemplateParameter: \/[Set[java.lang.Throwable],UMLConnectableElementTemplateParameter[Uml]]

  def createUMLConnectionPointReference: \/[Set[java.lang.Throwable],UMLConnectionPointReference[Uml]]

  def createUMLConnector: \/[Set[java.lang.Throwable],UMLConnector[Uml]]

  def createUMLConnectorEnd: \/[Set[java.lang.Throwable],UMLConnectorEnd[Uml]]

  def createUMLConsiderIgnoreFragment: \/[Set[java.lang.Throwable],UMLConsiderIgnoreFragment[Uml]]

  def createUMLConstraint: \/[Set[java.lang.Throwable],UMLConstraint[Uml]]

  def createUMLContinuation: \/[Set[java.lang.Throwable],UMLContinuation[Uml]]

  def createUMLControlFlow: \/[Set[java.lang.Throwable],UMLControlFlow[Uml]]

  def createUMLCreateLinkAction: \/[Set[java.lang.Throwable],UMLCreateLinkAction[Uml]]

  def createUMLCreateLinkObjectAction: \/[Set[java.lang.Throwable],UMLCreateLinkObjectAction[Uml]]

  def createUMLCreateObjectAction: \/[Set[java.lang.Throwable],UMLCreateObjectAction[Uml]]

  def createUMLDataStoreNode: \/[Set[java.lang.Throwable],UMLDataStoreNode[Uml]]

  def createUMLDataType: \/[Set[java.lang.Throwable],UMLDataType[Uml]]

  def createUMLDecisionNode: \/[Set[java.lang.Throwable],UMLDecisionNode[Uml]]

  def createUMLDependency: \/[Set[java.lang.Throwable],UMLDependency[Uml]]

  def createUMLDeployment: \/[Set[java.lang.Throwable],UMLDeployment[Uml]]

  def createUMLDeploymentSpecification: \/[Set[java.lang.Throwable],UMLDeploymentSpecification[Uml]]

  def createUMLDestroyLinkAction: \/[Set[java.lang.Throwable],UMLDestroyLinkAction[Uml]]

  def createUMLDestroyObjectAction: \/[Set[java.lang.Throwable],UMLDestroyObjectAction[Uml]]

  def createUMLDestructionOccurrenceSpecification: \/[Set[java.lang.Throwable],UMLDestructionOccurrenceSpecification[Uml]]

  def createUMLDevice: \/[Set[java.lang.Throwable],UMLDevice[Uml]]

  def createUMLDiagram: \/[Set[java.lang.Throwable],UMLDiagram[Uml]]

  def createUMLDuration: \/[Set[java.lang.Throwable],UMLDuration[Uml]]

  def createUMLDurationConstraint: \/[Set[java.lang.Throwable],UMLDurationConstraint[Uml]]

  def createUMLDurationInterval: \/[Set[java.lang.Throwable],UMLDurationInterval[Uml]]

  def createUMLDurationObservation: \/[Set[java.lang.Throwable],UMLDurationObservation[Uml]]

  def createUMLElementImport: \/[Set[java.lang.Throwable],UMLElementImport[Uml]]

  def createUMLElementValue: \/[Set[java.lang.Throwable],UMLElementValue[Uml]]

  def createUMLEnumeration: \/[Set[java.lang.Throwable],UMLEnumeration[Uml]]

  def createUMLEnumerationLiteral: \/[Set[java.lang.Throwable],UMLEnumerationLiteral[Uml]]

  def createUMLExceptionHandler: \/[Set[java.lang.Throwable],UMLExceptionHandler[Uml]]

  def createUMLExecutionEnvironment: \/[Set[java.lang.Throwable],UMLExecutionEnvironment[Uml]]

  def createUMLExecutionOccurrenceSpecification: \/[Set[java.lang.Throwable],UMLExecutionOccurrenceSpecification[Uml]]

  def createUMLExpansionNode: \/[Set[java.lang.Throwable],UMLExpansionNode[Uml]]

  def createUMLExpansionRegion: \/[Set[java.lang.Throwable],UMLExpansionRegion[Uml]]

  def createUMLExpression: \/[Set[java.lang.Throwable],UMLExpression[Uml]]

  def createUMLExtend: \/[Set[java.lang.Throwable],UMLExtend[Uml]]

  def createUMLExtension: \/[Set[java.lang.Throwable],UMLExtension[Uml]]

  def createUMLExtensionEnd: \/[Set[java.lang.Throwable],UMLExtensionEnd[Uml]]

  def createUMLExtensionPoint: \/[Set[java.lang.Throwable],UMLExtensionPoint[Uml]]

  def createUMLFinalState: \/[Set[java.lang.Throwable],UMLFinalState[Uml]]

  def createUMLFlowFinalNode: \/[Set[java.lang.Throwable],UMLFlowFinalNode[Uml]]

  def createUMLForkNode: \/[Set[java.lang.Throwable],UMLForkNode[Uml]]

  def createUMLFunctionBehavior: \/[Set[java.lang.Throwable],UMLFunctionBehavior[Uml]]

  def createUMLGate: \/[Set[java.lang.Throwable],UMLGate[Uml]]

  def createUMLGeneralOrdering: \/[Set[java.lang.Throwable],UMLGeneralOrdering[Uml]]

  def createUMLGeneralization: \/[Set[java.lang.Throwable],UMLGeneralization[Uml]]

  def createUMLGeneralizationSet: \/[Set[java.lang.Throwable],UMLGeneralizationSet[Uml]]

  def createUMLImage: \/[Set[java.lang.Throwable],UMLImage[Uml]]

  def createUMLInclude: \/[Set[java.lang.Throwable],UMLInclude[Uml]]

  def createUMLInformationFlow: \/[Set[java.lang.Throwable],UMLInformationFlow[Uml]]

  def createUMLInformationItem: \/[Set[java.lang.Throwable],UMLInformationItem[Uml]]

  def createUMLInitialNode: \/[Set[java.lang.Throwable],UMLInitialNode[Uml]]

  def createUMLInputPin: \/[Set[java.lang.Throwable],UMLInputPin[Uml]]

  def createUMLInstanceSpecification: \/[Set[java.lang.Throwable],UMLInstanceSpecification[Uml]]

  def createUMLInstanceValue: \/[Set[java.lang.Throwable],UMLInstanceValue[Uml]]

  def createUMLInteraction: \/[Set[java.lang.Throwable],UMLInteraction[Uml]]

  def createUMLInteractionConstraint: \/[Set[java.lang.Throwable],UMLInteractionConstraint[Uml]]

  def createUMLInteractionOperand: \/[Set[java.lang.Throwable],UMLInteractionOperand[Uml]]

  def createUMLInteractionUse: \/[Set[java.lang.Throwable],UMLInteractionUse[Uml]]

  def createUMLInterface: \/[Set[java.lang.Throwable],UMLInterface[Uml]]

  def createUMLInterfaceRealization: \/[Set[java.lang.Throwable],UMLInterfaceRealization[Uml]]

  def createUMLInterruptibleActivityRegion: \/[Set[java.lang.Throwable],UMLInterruptibleActivityRegion[Uml]]

  def createUMLInterval: \/[Set[java.lang.Throwable],UMLInterval[Uml]]

  def createUMLIntervalConstraint: \/[Set[java.lang.Throwable],UMLIntervalConstraint[Uml]]

  def createUMLJoinNode: \/[Set[java.lang.Throwable],UMLJoinNode[Uml]]

  def createUMLLifeline: \/[Set[java.lang.Throwable],UMLLifeline[Uml]]

  def createUMLLinkEndCreationData: \/[Set[java.lang.Throwable],UMLLinkEndCreationData[Uml]]

  def createUMLLinkEndData: \/[Set[java.lang.Throwable],UMLLinkEndData[Uml]]

  def createUMLLinkEndDestructionData: \/[Set[java.lang.Throwable],UMLLinkEndDestructionData[Uml]]

  def createUMLLiteralBoolean: \/[Set[java.lang.Throwable],UMLLiteralBoolean[Uml]]

  def createUMLLiteralInteger: \/[Set[java.lang.Throwable],UMLLiteralInteger[Uml]]

  def createUMLLiteralNull: \/[Set[java.lang.Throwable],UMLLiteralNull[Uml]]

  def createUMLLiteralReal: \/[Set[java.lang.Throwable],UMLLiteralReal[Uml]]

  def createUMLLiteralString: \/[Set[java.lang.Throwable],UMLLiteralString[Uml]]

  def createUMLLiteralUnlimitedNatural: \/[Set[java.lang.Throwable],UMLLiteralUnlimitedNatural[Uml]]

  def createUMLLoopNode: \/[Set[java.lang.Throwable],UMLLoopNode[Uml]]

  def createUMLManifestation: \/[Set[java.lang.Throwable],UMLManifestation[Uml]]

  def createUMLMergeNode: \/[Set[java.lang.Throwable],UMLMergeNode[Uml]]

  def createUMLMessage: \/[Set[java.lang.Throwable],UMLMessage[Uml]]

  def createUMLMessageOccurrenceSpecification: \/[Set[java.lang.Throwable],UMLMessageOccurrenceSpecification[Uml]]

  def createUMLModel: \/[Set[java.lang.Throwable],UMLModel[Uml]]

  def createUMLNode: \/[Set[java.lang.Throwable],UMLNode[Uml]]

  def createUMLObjectFlow: \/[Set[java.lang.Throwable],UMLObjectFlow[Uml]]

  def createUMLOccurrenceSpecification: \/[Set[java.lang.Throwable],UMLOccurrenceSpecification[Uml]]

  def createUMLOpaqueAction: \/[Set[java.lang.Throwable],UMLOpaqueAction[Uml]]

  def createUMLOpaqueBehavior: \/[Set[java.lang.Throwable],UMLOpaqueBehavior[Uml]]

  def createUMLOpaqueExpression: \/[Set[java.lang.Throwable],UMLOpaqueExpression[Uml]]

  def createUMLOperation: \/[Set[java.lang.Throwable],UMLOperation[Uml]]

  def createUMLOperationTemplateParameter: \/[Set[java.lang.Throwable],UMLOperationTemplateParameter[Uml]]

  def createUMLOutputPin: \/[Set[java.lang.Throwable],UMLOutputPin[Uml]]

  def createUMLPackage: \/[Set[java.lang.Throwable],UMLPackage[Uml]]

  def createUMLPackageImport: \/[Set[java.lang.Throwable],UMLPackageImport[Uml]]

  def createUMLPackageMerge: \/[Set[java.lang.Throwable],UMLPackageMerge[Uml]]

  def createUMLParameter: \/[Set[java.lang.Throwable],UMLParameter[Uml]]

  def createUMLParameterSet: \/[Set[java.lang.Throwable],UMLParameterSet[Uml]]

  def createUMLPartDecomposition: \/[Set[java.lang.Throwable],UMLPartDecomposition[Uml]]

  def createUMLPort: \/[Set[java.lang.Throwable],UMLPort[Uml]]

  def createUMLPrimitiveType: \/[Set[java.lang.Throwable],UMLPrimitiveType[Uml]]

  def createUMLProfile: \/[Set[java.lang.Throwable],UMLProfile[Uml]]

  def createUMLProfileApplication: \/[Set[java.lang.Throwable],UMLProfileApplication[Uml]]

  def createUMLProperty: \/[Set[java.lang.Throwable],UMLProperty[Uml]]

  def createUMLProtocolConformance: \/[Set[java.lang.Throwable],UMLProtocolConformance[Uml]]

  def createUMLProtocolStateMachine: \/[Set[java.lang.Throwable],UMLProtocolStateMachine[Uml]]

  def createUMLProtocolTransition: \/[Set[java.lang.Throwable],UMLProtocolTransition[Uml]]

  def createUMLPseudostate: \/[Set[java.lang.Throwable],UMLPseudostate[Uml]]

  def createUMLQualifierValue: \/[Set[java.lang.Throwable],UMLQualifierValue[Uml]]

  def createUMLRaiseExceptionAction: \/[Set[java.lang.Throwable],UMLRaiseExceptionAction[Uml]]

  def createUMLReadExtentAction: \/[Set[java.lang.Throwable],UMLReadExtentAction[Uml]]

  def createUMLReadIsClassifiedObjectAction: \/[Set[java.lang.Throwable],UMLReadIsClassifiedObjectAction[Uml]]

  def createUMLReadLinkAction: \/[Set[java.lang.Throwable],UMLReadLinkAction[Uml]]

  def createUMLReadLinkObjectEndAction: \/[Set[java.lang.Throwable],UMLReadLinkObjectEndAction[Uml]]

  def createUMLReadLinkObjectEndQualifierAction: \/[Set[java.lang.Throwable],UMLReadLinkObjectEndQualifierAction[Uml]]

  def createUMLReadSelfAction: \/[Set[java.lang.Throwable],UMLReadSelfAction[Uml]]

  def createUMLReadStructuralFeatureAction: \/[Set[java.lang.Throwable],UMLReadStructuralFeatureAction[Uml]]

  def createUMLReadVariableAction: \/[Set[java.lang.Throwable],UMLReadVariableAction[Uml]]

  def createUMLRealization: \/[Set[java.lang.Throwable],UMLRealization[Uml]]

  def createUMLReception: \/[Set[java.lang.Throwable],UMLReception[Uml]]

  def createUMLReclassifyObjectAction: \/[Set[java.lang.Throwable],UMLReclassifyObjectAction[Uml]]

  def createUMLRedefinableTemplateSignature: \/[Set[java.lang.Throwable],UMLRedefinableTemplateSignature[Uml]]

  def createUMLReduceAction: \/[Set[java.lang.Throwable],UMLReduceAction[Uml]]

  def createUMLRegion: \/[Set[java.lang.Throwable],UMLRegion[Uml]]

  def createUMLRemoveStructuralFeatureValueAction: \/[Set[java.lang.Throwable],UMLRemoveStructuralFeatureValueAction[Uml]]

  def createUMLRemoveVariableValueAction: \/[Set[java.lang.Throwable],UMLRemoveVariableValueAction[Uml]]

  def createUMLReplyAction: \/[Set[java.lang.Throwable],UMLReplyAction[Uml]]

  def createUMLSendObjectAction: \/[Set[java.lang.Throwable],UMLSendObjectAction[Uml]]

  def createUMLSendSignalAction: \/[Set[java.lang.Throwable],UMLSendSignalAction[Uml]]

  def createUMLSequenceNode: \/[Set[java.lang.Throwable],UMLSequenceNode[Uml]]

  def createUMLSignal: \/[Set[java.lang.Throwable],UMLSignal[Uml]]

  def createUMLSignalEvent: \/[Set[java.lang.Throwable],UMLSignalEvent[Uml]]

  def createUMLSlot: \/[Set[java.lang.Throwable],UMLSlot[Uml]]

  def createUMLStartClassifierBehaviorAction: \/[Set[java.lang.Throwable],UMLStartClassifierBehaviorAction[Uml]]

  def createUMLStartObjectBehaviorAction: \/[Set[java.lang.Throwable],UMLStartObjectBehaviorAction[Uml]]

  def createUMLState: \/[Set[java.lang.Throwable],UMLState[Uml]]

  def createUMLStateInvariant: \/[Set[java.lang.Throwable],UMLStateInvariant[Uml]]

  def createUMLStateMachine: \/[Set[java.lang.Throwable],UMLStateMachine[Uml]]

  def createUMLStereotype: \/[Set[java.lang.Throwable],UMLStereotype[Uml]]

  def createUMLStringExpression: \/[Set[java.lang.Throwable],UMLStringExpression[Uml]]

  def createUMLStructuredActivityNode: \/[Set[java.lang.Throwable],UMLStructuredActivityNode[Uml]]

  def createUMLSubstitution: \/[Set[java.lang.Throwable],UMLSubstitution[Uml]]

  def createUMLTemplateBinding: \/[Set[java.lang.Throwable],UMLTemplateBinding[Uml]]

  def createUMLTemplateParameter: \/[Set[java.lang.Throwable],UMLTemplateParameter[Uml]]

  def createUMLTemplateParameterSubstitution: \/[Set[java.lang.Throwable],UMLTemplateParameterSubstitution[Uml]]

  def createUMLTemplateSignature: \/[Set[java.lang.Throwable],UMLTemplateSignature[Uml]]

  def createUMLTestIdentityAction: \/[Set[java.lang.Throwable],UMLTestIdentityAction[Uml]]

  def createUMLTimeConstraint: \/[Set[java.lang.Throwable],UMLTimeConstraint[Uml]]

  def createUMLTimeEvent: \/[Set[java.lang.Throwable],UMLTimeEvent[Uml]]

  def createUMLTimeExpression: \/[Set[java.lang.Throwable],UMLTimeExpression[Uml]]

  def createUMLTimeInterval: \/[Set[java.lang.Throwable],UMLTimeInterval[Uml]]

  def createUMLTimeObservation: \/[Set[java.lang.Throwable],UMLTimeObservation[Uml]]

  def createUMLTransition: \/[Set[java.lang.Throwable],UMLTransition[Uml]]

  def createUMLTrigger: \/[Set[java.lang.Throwable],UMLTrigger[Uml]]

  def createUMLUnmarshallAction: \/[Set[java.lang.Throwable],UMLUnmarshallAction[Uml]]

  def createUMLUsage: \/[Set[java.lang.Throwable],UMLUsage[Uml]]

  def createUMLUseCase: \/[Set[java.lang.Throwable],UMLUseCase[Uml]]

  def createUMLValuePin: \/[Set[java.lang.Throwable],UMLValuePin[Uml]]

  def createUMLValueSpecificationAction: \/[Set[java.lang.Throwable],UMLValueSpecificationAction[Uml]]

  def createUMLVariable: \/[Set[java.lang.Throwable],UMLVariable[Uml]]

  // Start of user code for additional features
  val reflectivePackageFactoryLookup
  : Map[String, (UMLFactory[Uml] => \/[Set[java.lang.Throwable], _ <: UMLPackage[Uml]])] =
    Map(
      "Package" -> (f => f.createUMLPackage),
      "Model" -> (f => f.createUMLModel),
      "Profile" -> (f => f.createUMLProfile))
  // End of user code
}
