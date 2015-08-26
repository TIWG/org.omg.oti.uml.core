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
import scala.util.Try
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

  val reflectiveFactoryLookup: Map[String, (UMLFactory[Uml] => Try[_ <: UMLElement[Uml]])] =
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

  def createUMLAbstraction: Try[UMLAbstraction[Uml]]

  def createUMLAcceptCallAction: Try[UMLAcceptCallAction[Uml]]

  def createUMLAcceptEventAction: Try[UMLAcceptEventAction[Uml]]

  def createUMLActionExecutionSpecification: Try[UMLActionExecutionSpecification[Uml]]

  def createUMLActionInputPin: Try[UMLActionInputPin[Uml]]

  def createUMLActivity: Try[UMLActivity[Uml]]

  def createUMLActivityFinalNode: Try[UMLActivityFinalNode[Uml]]

  def createUMLActivityParameterNode: Try[UMLActivityParameterNode[Uml]]

  def createUMLActivityPartition: Try[UMLActivityPartition[Uml]]

  def createUMLActor: Try[UMLActor[Uml]]

  def createUMLAddStructuralFeatureValueAction: Try[UMLAddStructuralFeatureValueAction[Uml]]

  def createUMLAddVariableValueAction: Try[UMLAddVariableValueAction[Uml]]

  def createUMLAnyReceiveEvent: Try[UMLAnyReceiveEvent[Uml]]

  def createUMLArtifact: Try[UMLArtifact[Uml]]

  def createUMLAssociation: Try[UMLAssociation[Uml]]

  def createUMLAssociationClass: Try[UMLAssociationClass[Uml]]

  def createUMLBehaviorExecutionSpecification: Try[UMLBehaviorExecutionSpecification[Uml]]

  def createUMLBroadcastSignalAction: Try[UMLBroadcastSignalAction[Uml]]

  def createUMLCallBehaviorAction: Try[UMLCallBehaviorAction[Uml]]

  def createUMLCallEvent: Try[UMLCallEvent[Uml]]

  def createUMLCallOperationAction: Try[UMLCallOperationAction[Uml]]

  def createUMLCentralBufferNode: Try[UMLCentralBufferNode[Uml]]

  def createUMLChangeEvent: Try[UMLChangeEvent[Uml]]

  def createUMLClass: Try[UMLClass[Uml]]

  def createUMLClassifierTemplateParameter: Try[UMLClassifierTemplateParameter[Uml]]

  def createUMLClause: Try[UMLClause[Uml]]

  def createUMLClearAssociationAction: Try[UMLClearAssociationAction[Uml]]

  def createUMLClearStructuralFeatureAction: Try[UMLClearStructuralFeatureAction[Uml]]

  def createUMLClearVariableAction: Try[UMLClearVariableAction[Uml]]

  def createUMLCollaboration: Try[UMLCollaboration[Uml]]

  def createUMLCollaborationUse: Try[UMLCollaborationUse[Uml]]

  def createUMLCombinedFragment: Try[UMLCombinedFragment[Uml]]

  def createUMLComment: Try[UMLComment[Uml]]

  def createUMLCommunicationPath: Try[UMLCommunicationPath[Uml]]

  def createUMLComponent: Try[UMLComponent[Uml]]

  def createUMLComponentRealization: Try[UMLComponentRealization[Uml]]

  def createUMLConditionalNode: Try[UMLConditionalNode[Uml]]

  def createUMLConnectableElementTemplateParameter: Try[UMLConnectableElementTemplateParameter[Uml]]

  def createUMLConnectionPointReference: Try[UMLConnectionPointReference[Uml]]

  def createUMLConnector: Try[UMLConnector[Uml]]

  def createUMLConnectorEnd: Try[UMLConnectorEnd[Uml]]

  def createUMLConsiderIgnoreFragment: Try[UMLConsiderIgnoreFragment[Uml]]

  def createUMLConstraint: Try[UMLConstraint[Uml]]

  def createUMLContinuation: Try[UMLContinuation[Uml]]

  def createUMLControlFlow: Try[UMLControlFlow[Uml]]

  def createUMLCreateLinkAction: Try[UMLCreateLinkAction[Uml]]

  def createUMLCreateLinkObjectAction: Try[UMLCreateLinkObjectAction[Uml]]

  def createUMLCreateObjectAction: Try[UMLCreateObjectAction[Uml]]

  def createUMLDataStoreNode: Try[UMLDataStoreNode[Uml]]

  def createUMLDataType: Try[UMLDataType[Uml]]

  def createUMLDecisionNode: Try[UMLDecisionNode[Uml]]

  def createUMLDependency: Try[UMLDependency[Uml]]

  def createUMLDeployment: Try[UMLDeployment[Uml]]

  def createUMLDeploymentSpecification: Try[UMLDeploymentSpecification[Uml]]

  def createUMLDestroyLinkAction: Try[UMLDestroyLinkAction[Uml]]

  def createUMLDestroyObjectAction: Try[UMLDestroyObjectAction[Uml]]

  def createUMLDestructionOccurrenceSpecification: Try[UMLDestructionOccurrenceSpecification[Uml]]

  def createUMLDevice: Try[UMLDevice[Uml]]

  def createUMLDuration: Try[UMLDuration[Uml]]

  def createUMLDurationConstraint: Try[UMLDurationConstraint[Uml]]

  def createUMLDurationInterval: Try[UMLDurationInterval[Uml]]

  def createUMLDurationObservation: Try[UMLDurationObservation[Uml]]

  def createUMLElementImport: Try[UMLElementImport[Uml]]

  def createUMLEnumeration: Try[UMLEnumeration[Uml]]

  def createUMLEnumerationLiteral: Try[UMLEnumerationLiteral[Uml]]

  def createUMLExceptionHandler: Try[UMLExceptionHandler[Uml]]

  def createUMLExecutionEnvironment: Try[UMLExecutionEnvironment[Uml]]

  def createUMLExecutionOccurrenceSpecification: Try[UMLExecutionOccurrenceSpecification[Uml]]

  def createUMLExpansionNode: Try[UMLExpansionNode[Uml]]

  def createUMLExpansionRegion: Try[UMLExpansionRegion[Uml]]

  def createUMLExpression: Try[UMLExpression[Uml]]

  def createUMLExtend: Try[UMLExtend[Uml]]

  def createUMLExtension: Try[UMLExtension[Uml]]

  def createUMLExtensionEnd: Try[UMLExtensionEnd[Uml]]

  def createUMLExtensionPoint: Try[UMLExtensionPoint[Uml]]

  def createUMLFinalState: Try[UMLFinalState[Uml]]

  def createUMLFlowFinalNode: Try[UMLFlowFinalNode[Uml]]

  def createUMLForkNode: Try[UMLForkNode[Uml]]

  def createUMLFunctionBehavior: Try[UMLFunctionBehavior[Uml]]

  def createUMLGate: Try[UMLGate[Uml]]

  def createUMLGeneralOrdering: Try[UMLGeneralOrdering[Uml]]

  def createUMLGeneralization: Try[UMLGeneralization[Uml]]

  def createUMLGeneralizationSet: Try[UMLGeneralizationSet[Uml]]

  def createUMLImage: Try[UMLImage[Uml]]

  def createUMLInclude: Try[UMLInclude[Uml]]

  def createUMLInformationFlow: Try[UMLInformationFlow[Uml]]

  def createUMLInformationItem: Try[UMLInformationItem[Uml]]

  def createUMLInitialNode: Try[UMLInitialNode[Uml]]

  def createUMLInputPin: Try[UMLInputPin[Uml]]

  def createUMLInstanceSpecification: Try[UMLInstanceSpecification[Uml]]

  def createUMLInstanceValue: Try[UMLInstanceValue[Uml]]

  def createUMLInteraction: Try[UMLInteraction[Uml]]

  def createUMLInteractionConstraint: Try[UMLInteractionConstraint[Uml]]

  def createUMLInteractionOperand: Try[UMLInteractionOperand[Uml]]

  def createUMLInteractionUse: Try[UMLInteractionUse[Uml]]

  def createUMLInterface: Try[UMLInterface[Uml]]

  def createUMLInterfaceRealization: Try[UMLInterfaceRealization[Uml]]

  def createUMLInterruptibleActivityRegion: Try[UMLInterruptibleActivityRegion[Uml]]

  def createUMLInterval: Try[UMLInterval[Uml]]

  def createUMLIntervalConstraint: Try[UMLIntervalConstraint[Uml]]

  def createUMLJoinNode: Try[UMLJoinNode[Uml]]

  def createUMLLifeline: Try[UMLLifeline[Uml]]

  def createUMLLinkEndCreationData: Try[UMLLinkEndCreationData[Uml]]

  def createUMLLinkEndData: Try[UMLLinkEndData[Uml]]

  def createUMLLinkEndDestructionData: Try[UMLLinkEndDestructionData[Uml]]

  def createUMLLiteralBoolean: Try[UMLLiteralBoolean[Uml]]

  def createUMLLiteralInteger: Try[UMLLiteralInteger[Uml]]

  def createUMLLiteralNull: Try[UMLLiteralNull[Uml]]

  def createUMLLiteralReal: Try[UMLLiteralReal[Uml]]

  def createUMLLiteralString: Try[UMLLiteralString[Uml]]

  def createUMLLiteralUnlimitedNatural: Try[UMLLiteralUnlimitedNatural[Uml]]

  def createUMLLoopNode: Try[UMLLoopNode[Uml]]

  def createUMLManifestation: Try[UMLManifestation[Uml]]

  def createUMLMergeNode: Try[UMLMergeNode[Uml]]

  def createUMLMessage: Try[UMLMessage[Uml]]

  def createUMLMessageOccurrenceSpecification: Try[UMLMessageOccurrenceSpecification[Uml]]

  def createUMLModel: Try[UMLModel[Uml]]

  def createUMLNode: Try[UMLNode[Uml]]

  def createUMLObjectFlow: Try[UMLObjectFlow[Uml]]

  def createUMLOccurrenceSpecification: Try[UMLOccurrenceSpecification[Uml]]

  def createUMLOpaqueAction: Try[UMLOpaqueAction[Uml]]

  def createUMLOpaqueBehavior: Try[UMLOpaqueBehavior[Uml]]

  def createUMLOpaqueExpression: Try[UMLOpaqueExpression[Uml]]

  def createUMLOperation: Try[UMLOperation[Uml]]

  def createUMLOperationTemplateParameter: Try[UMLOperationTemplateParameter[Uml]]

  def createUMLOutputPin: Try[UMLOutputPin[Uml]]

  def createUMLPackage: Try[UMLPackage[Uml]]

  def createUMLPackageImport: Try[UMLPackageImport[Uml]]

  def createUMLPackageMerge: Try[UMLPackageMerge[Uml]]

  def createUMLParameter: Try[UMLParameter[Uml]]

  def createUMLParameterSet: Try[UMLParameterSet[Uml]]

  def createUMLPartDecomposition: Try[UMLPartDecomposition[Uml]]

  def createUMLPort: Try[UMLPort[Uml]]

  def createUMLPrimitiveType: Try[UMLPrimitiveType[Uml]]

  def createUMLProfile: Try[UMLProfile[Uml]]

  def createUMLProfileApplication: Try[UMLProfileApplication[Uml]]

  def createUMLProperty: Try[UMLProperty[Uml]]

  def createUMLProtocolConformance: Try[UMLProtocolConformance[Uml]]

  def createUMLProtocolStateMachine: Try[UMLProtocolStateMachine[Uml]]

  def createUMLProtocolTransition: Try[UMLProtocolTransition[Uml]]

  def createUMLPseudostate: Try[UMLPseudostate[Uml]]

  def createUMLQualifierValue: Try[UMLQualifierValue[Uml]]

  def createUMLRaiseExceptionAction: Try[UMLRaiseExceptionAction[Uml]]

  def createUMLReadExtentAction: Try[UMLReadExtentAction[Uml]]

  def createUMLReadIsClassifiedObjectAction: Try[UMLReadIsClassifiedObjectAction[Uml]]

  def createUMLReadLinkAction: Try[UMLReadLinkAction[Uml]]

  def createUMLReadLinkObjectEndAction: Try[UMLReadLinkObjectEndAction[Uml]]

  def createUMLReadLinkObjectEndQualifierAction: Try[UMLReadLinkObjectEndQualifierAction[Uml]]

  def createUMLReadSelfAction: Try[UMLReadSelfAction[Uml]]

  def createUMLReadStructuralFeatureAction: Try[UMLReadStructuralFeatureAction[Uml]]

  def createUMLReadVariableAction: Try[UMLReadVariableAction[Uml]]

  def createUMLRealization: Try[UMLRealization[Uml]]

  def createUMLReception: Try[UMLReception[Uml]]

  def createUMLReclassifyObjectAction: Try[UMLReclassifyObjectAction[Uml]]

  def createUMLRedefinableTemplateSignature: Try[UMLRedefinableTemplateSignature[Uml]]

  def createUMLReduceAction: Try[UMLReduceAction[Uml]]

  def createUMLRegion: Try[UMLRegion[Uml]]

  def createUMLRemoveStructuralFeatureValueAction: Try[UMLRemoveStructuralFeatureValueAction[Uml]]

  def createUMLRemoveVariableValueAction: Try[UMLRemoveVariableValueAction[Uml]]

  def createUMLReplyAction: Try[UMLReplyAction[Uml]]

  def createUMLSendObjectAction: Try[UMLSendObjectAction[Uml]]

  def createUMLSendSignalAction: Try[UMLSendSignalAction[Uml]]

  def createUMLSequenceNode: Try[UMLSequenceNode[Uml]]

  def createUMLSignal: Try[UMLSignal[Uml]]

  def createUMLSignalEvent: Try[UMLSignalEvent[Uml]]

  def createUMLSlot: Try[UMLSlot[Uml]]

  def createUMLStartClassifierBehaviorAction: Try[UMLStartClassifierBehaviorAction[Uml]]

  def createUMLStartObjectBehaviorAction: Try[UMLStartObjectBehaviorAction[Uml]]

  def createUMLState: Try[UMLState[Uml]]

  def createUMLStateInvariant: Try[UMLStateInvariant[Uml]]

  def createUMLStateMachine: Try[UMLStateMachine[Uml]]

  def createUMLStereotype: Try[UMLStereotype[Uml]]

  def createUMLStringExpression: Try[UMLStringExpression[Uml]]

  def createUMLStructuredActivityNode: Try[UMLStructuredActivityNode[Uml]]

  def createUMLSubstitution: Try[UMLSubstitution[Uml]]

  def createUMLTemplateBinding: Try[UMLTemplateBinding[Uml]]

  def createUMLTemplateParameter: Try[UMLTemplateParameter[Uml]]

  def createUMLTemplateParameterSubstitution: Try[UMLTemplateParameterSubstitution[Uml]]

  def createUMLTemplateSignature: Try[UMLTemplateSignature[Uml]]

  def createUMLTestIdentityAction: Try[UMLTestIdentityAction[Uml]]

  def createUMLTimeConstraint: Try[UMLTimeConstraint[Uml]]

  def createUMLTimeEvent: Try[UMLTimeEvent[Uml]]

  def createUMLTimeExpression: Try[UMLTimeExpression[Uml]]

  def createUMLTimeInterval: Try[UMLTimeInterval[Uml]]

  def createUMLTimeObservation: Try[UMLTimeObservation[Uml]]

  def createUMLTransition: Try[UMLTransition[Uml]]

  def createUMLTrigger: Try[UMLTrigger[Uml]]

  def createUMLUnmarshallAction: Try[UMLUnmarshallAction[Uml]]

  def createUMLUsage: Try[UMLUsage[Uml]]

  def createUMLUseCase: Try[UMLUseCase[Uml]]

  def createUMLValuePin: Try[UMLValuePin[Uml]]

  def createUMLValueSpecificationAction: Try[UMLValueSpecificationAction[Uml]]

  def createUMLVariable: Try[UMLVariable[Uml]]

	// Start of user code for additional features
	// End of user code
}
