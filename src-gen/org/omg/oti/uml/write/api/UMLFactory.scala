package org.omg.oti.uml.write.api

import org.omg.oti.uml.read.api._
import scala.util.Try

trait UMLFactory[Uml <: UML] {

  def createUMLAbstraction: Try[UMLAbstraction[Uml]]

  def createUMLAcceptCallAction: Try[UMLAcceptCallAction[Uml]]

  def createUMLAcceptEventAction: Try[UMLAcceptEventAction[Uml]]

  def createUMLAction: Try[UMLAction[Uml]]

  def createUMLActionExecutionSpecification: Try[UMLActionExecutionSpecification[Uml]]

  def createUMLActionInputPin: Try[UMLActionInputPin[Uml]]

  def createUMLActivity: Try[UMLActivity[Uml]]

  def createUMLActivityEdge: Try[UMLActivityEdge[Uml]]

  def createUMLActivityFinalNode: Try[UMLActivityFinalNode[Uml]]

  def createUMLActivityGroup: Try[UMLActivityGroup[Uml]]

  def createUMLActivityNode: Try[UMLActivityNode[Uml]]

  def createUMLActivityParameterNode: Try[UMLActivityParameterNode[Uml]]

  def createUMLActivityPartition: Try[UMLActivityPartition[Uml]]

  def createUMLActor: Try[UMLActor[Uml]]

  def createUMLAddStructuralFeatureValueAction: Try[UMLAddStructuralFeatureValueAction[Uml]]

  def createUMLAddVariableValueAction: Try[UMLAddVariableValueAction[Uml]]

  def createUMLAnyReceiveEvent: Try[UMLAnyReceiveEvent[Uml]]

  def createUMLArtifact: Try[UMLArtifact[Uml]]

  def createUMLAssociation: Try[UMLAssociation[Uml]]

  def createUMLAssociationClass: Try[UMLAssociationClass[Uml]]

  def createUMLBehavior: Try[UMLBehavior[Uml]]

  def createUMLBehaviorExecutionSpecification: Try[UMLBehaviorExecutionSpecification[Uml]]

  def createUMLBehavioralFeature: Try[UMLBehavioralFeature[Uml]]

  def createUMLBehavioredClassifier: Try[UMLBehavioredClassifier[Uml]]

  def createUMLBroadcastSignalAction: Try[UMLBroadcastSignalAction[Uml]]

  def createUMLCallAction: Try[UMLCallAction[Uml]]

  def createUMLCallBehaviorAction: Try[UMLCallBehaviorAction[Uml]]

  def createUMLCallEvent: Try[UMLCallEvent[Uml]]

  def createUMLCallOperationAction: Try[UMLCallOperationAction[Uml]]

  def createUMLCentralBufferNode: Try[UMLCentralBufferNode[Uml]]

  def createUMLChangeEvent: Try[UMLChangeEvent[Uml]]

  def createUMLClass: Try[UMLClass[Uml]]

  def createUMLClassifier: Try[UMLClassifier[Uml]]

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

  def createUMLConnectableElement: Try[UMLConnectableElement[Uml]]

  def createUMLConnectableElementTemplateParameter: Try[UMLConnectableElementTemplateParameter[Uml]]

  def createUMLConnectionPointReference: Try[UMLConnectionPointReference[Uml]]

  def createUMLConnector: Try[UMLConnector[Uml]]

  def createUMLConnectorEnd: Try[UMLConnectorEnd[Uml]]

  def createUMLConsiderIgnoreFragment: Try[UMLConsiderIgnoreFragment[Uml]]

  def createUMLConstraint: Try[UMLConstraint[Uml]]

  def createUMLContinuation: Try[UMLContinuation[Uml]]

  def createUMLControlFlow: Try[UMLControlFlow[Uml]]

  def createUMLControlNode: Try[UMLControlNode[Uml]]

  def createUMLCreateLinkAction: Try[UMLCreateLinkAction[Uml]]

  def createUMLCreateLinkObjectAction: Try[UMLCreateLinkObjectAction[Uml]]

  def createUMLCreateObjectAction: Try[UMLCreateObjectAction[Uml]]

  def createUMLDataStoreNode: Try[UMLDataStoreNode[Uml]]

  def createUMLDataType: Try[UMLDataType[Uml]]

  def createUMLDecisionNode: Try[UMLDecisionNode[Uml]]

  def createUMLDependency: Try[UMLDependency[Uml]]

  def createUMLDeployedArtifact: Try[UMLDeployedArtifact[Uml]]

  def createUMLDeployment: Try[UMLDeployment[Uml]]

  def createUMLDeploymentSpecification: Try[UMLDeploymentSpecification[Uml]]

  def createUMLDeploymentTarget: Try[UMLDeploymentTarget[Uml]]

  def createUMLDestroyLinkAction: Try[UMLDestroyLinkAction[Uml]]

  def createUMLDestroyObjectAction: Try[UMLDestroyObjectAction[Uml]]

  def createUMLDestructionOccurrenceSpecification: Try[UMLDestructionOccurrenceSpecification[Uml]]

  def createUMLDevice: Try[UMLDevice[Uml]]

  def createUMLDirectedRelationship: Try[UMLDirectedRelationship[Uml]]

  def createUMLDuration: Try[UMLDuration[Uml]]

  def createUMLDurationConstraint: Try[UMLDurationConstraint[Uml]]

  def createUMLDurationInterval: Try[UMLDurationInterval[Uml]]

  def createUMLDurationObservation: Try[UMLDurationObservation[Uml]]

  def createUMLElement: Try[UMLElement[Uml]]

  def createUMLElementImport: Try[UMLElementImport[Uml]]

  def createUMLEncapsulatedClassifier: Try[UMLEncapsulatedClassifier[Uml]]

  def createUMLEnumeration: Try[UMLEnumeration[Uml]]

  def createUMLEnumerationLiteral: Try[UMLEnumerationLiteral[Uml]]

  def createUMLEvent: Try[UMLEvent[Uml]]

  def createUMLExceptionHandler: Try[UMLExceptionHandler[Uml]]

  def createUMLExecutableNode: Try[UMLExecutableNode[Uml]]

  def createUMLExecutionEnvironment: Try[UMLExecutionEnvironment[Uml]]

  def createUMLExecutionOccurrenceSpecification: Try[UMLExecutionOccurrenceSpecification[Uml]]

  def createUMLExecutionSpecification: Try[UMLExecutionSpecification[Uml]]

  def createUMLExpansionNode: Try[UMLExpansionNode[Uml]]

  def createUMLExpansionRegion: Try[UMLExpansionRegion[Uml]]

  def createUMLExpression: Try[UMLExpression[Uml]]

  def createUMLExtend: Try[UMLExtend[Uml]]

  def createUMLExtension: Try[UMLExtension[Uml]]

  def createUMLExtensionEnd: Try[UMLExtensionEnd[Uml]]

  def createUMLExtensionPoint: Try[UMLExtensionPoint[Uml]]

  def createUMLFeature: Try[UMLFeature[Uml]]

  def createUMLFinalNode: Try[UMLFinalNode[Uml]]

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

  def createUMLInteractionFragment: Try[UMLInteractionFragment[Uml]]

  def createUMLInteractionOperand: Try[UMLInteractionOperand[Uml]]

  def createUMLInteractionUse: Try[UMLInteractionUse[Uml]]

  def createUMLInterface: Try[UMLInterface[Uml]]

  def createUMLInterfaceRealization: Try[UMLInterfaceRealization[Uml]]

  def createUMLInterruptibleActivityRegion: Try[UMLInterruptibleActivityRegion[Uml]]

  def createUMLInterval: Try[UMLInterval[Uml]]

  def createUMLIntervalConstraint: Try[UMLIntervalConstraint[Uml]]

  def createUMLInvocationAction: Try[UMLInvocationAction[Uml]]

  def createUMLJoinNode: Try[UMLJoinNode[Uml]]

  def createUMLLifeline: Try[UMLLifeline[Uml]]

  def createUMLLinkAction: Try[UMLLinkAction[Uml]]

  def createUMLLinkEndCreationData: Try[UMLLinkEndCreationData[Uml]]

  def createUMLLinkEndData: Try[UMLLinkEndData[Uml]]

  def createUMLLinkEndDestructionData: Try[UMLLinkEndDestructionData[Uml]]

  def createUMLLiteralBoolean: Try[UMLLiteralBoolean[Uml]]

  def createUMLLiteralInteger: Try[UMLLiteralInteger[Uml]]

  def createUMLLiteralNull: Try[UMLLiteralNull[Uml]]

  def createUMLLiteralReal: Try[UMLLiteralReal[Uml]]

  def createUMLLiteralSpecification: Try[UMLLiteralSpecification[Uml]]

  def createUMLLiteralString: Try[UMLLiteralString[Uml]]

  def createUMLLiteralUnlimitedNatural: Try[UMLLiteralUnlimitedNatural[Uml]]

  def createUMLLoopNode: Try[UMLLoopNode[Uml]]

  def createUMLManifestation: Try[UMLManifestation[Uml]]

  def createUMLMergeNode: Try[UMLMergeNode[Uml]]

  def createUMLMessage: Try[UMLMessage[Uml]]

  def createUMLMessageEnd: Try[UMLMessageEnd[Uml]]

  def createUMLMessageEvent: Try[UMLMessageEvent[Uml]]

  def createUMLMessageOccurrenceSpecification: Try[UMLMessageOccurrenceSpecification[Uml]]

  def createUMLModel: Try[UMLModel[Uml]]

  def createUMLMultiplicityElement: Try[UMLMultiplicityElement[Uml]]

  def createUMLNamedElement: Try[UMLNamedElement[Uml]]

  def createUMLNamespace: Try[UMLNamespace[Uml]]

  def createUMLNode: Try[UMLNode[Uml]]

  def createUMLObjectFlow: Try[UMLObjectFlow[Uml]]

  def createUMLObjectNode: Try[UMLObjectNode[Uml]]

  def createUMLObservation: Try[UMLObservation[Uml]]

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

  def createUMLPackageableElement: Try[UMLPackageableElement[Uml]]

  def createUMLParameter: Try[UMLParameter[Uml]]

  def createUMLParameterSet: Try[UMLParameterSet[Uml]]

  def createUMLParameterableElement: Try[UMLParameterableElement[Uml]]

  def createUMLPartDecomposition: Try[UMLPartDecomposition[Uml]]

  def createUMLPin: Try[UMLPin[Uml]]

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

  def createUMLRedefinableElement: Try[UMLRedefinableElement[Uml]]

  def createUMLRedefinableTemplateSignature: Try[UMLRedefinableTemplateSignature[Uml]]

  def createUMLReduceAction: Try[UMLReduceAction[Uml]]

  def createUMLRegion: Try[UMLRegion[Uml]]

  def createUMLRelationship: Try[UMLRelationship[Uml]]

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

  def createUMLStructuralFeature: Try[UMLStructuralFeature[Uml]]

  def createUMLStructuralFeatureAction: Try[UMLStructuralFeatureAction[Uml]]

  def createUMLStructuredActivityNode: Try[UMLStructuredActivityNode[Uml]]

  def createUMLStructuredClassifier: Try[UMLStructuredClassifier[Uml]]

  def createUMLSubstitution: Try[UMLSubstitution[Uml]]

  def createUMLTemplateBinding: Try[UMLTemplateBinding[Uml]]

  def createUMLTemplateParameter: Try[UMLTemplateParameter[Uml]]

  def createUMLTemplateParameterSubstitution: Try[UMLTemplateParameterSubstitution[Uml]]

  def createUMLTemplateSignature: Try[UMLTemplateSignature[Uml]]

  def createUMLTemplateableElement: Try[UMLTemplateableElement[Uml]]

  def createUMLTestIdentityAction: Try[UMLTestIdentityAction[Uml]]

  def createUMLTimeConstraint: Try[UMLTimeConstraint[Uml]]

  def createUMLTimeEvent: Try[UMLTimeEvent[Uml]]

  def createUMLTimeExpression: Try[UMLTimeExpression[Uml]]

  def createUMLTimeInterval: Try[UMLTimeInterval[Uml]]

  def createUMLTimeObservation: Try[UMLTimeObservation[Uml]]

  def createUMLTransition: Try[UMLTransition[Uml]]

  def createUMLTrigger: Try[UMLTrigger[Uml]]

  def createUMLType: Try[UMLType[Uml]]

  def createUMLTypedElement: Try[UMLTypedElement[Uml]]

  def createUMLUnmarshallAction: Try[UMLUnmarshallAction[Uml]]

  def createUMLUsage: Try[UMLUsage[Uml]]

  def createUMLUseCase: Try[UMLUseCase[Uml]]

  def createUMLValuePin: Try[UMLValuePin[Uml]]

  def createUMLValueSpecification: Try[UMLValueSpecification[Uml]]

  def createUMLValueSpecificationAction: Try[UMLValueSpecificationAction[Uml]]

  def createUMLVariable: Try[UMLVariable[Uml]]

  def createUMLVariableAction: Try[UMLVariableAction[Uml]]

  def createUMLVertex: Try[UMLVertex[Uml]]

  def createUMLWriteLinkAction: Try[UMLWriteLinkAction[Uml]]

  def createUMLWriteStructuralFeatureAction: Try[UMLWriteStructuralFeatureAction[Uml]]

  def createUMLWriteVariableAction: Try[UMLWriteVariableAction[Uml]]

}
