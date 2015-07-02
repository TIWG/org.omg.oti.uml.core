package org.omg.oti.uml.write.api

import org.omg.oti.uml.read.api._

trait UMLFactory[Uml <: UML] {

  def createUMLAbstraction: UMLAbstraction[Uml]

  def createUMLAcceptCallAction: UMLAcceptCallAction[Uml]

  def createUMLAcceptEventAction: UMLAcceptEventAction[Uml]

  def createUMLAction: UMLAction[Uml]

  def createUMLActionExecutionSpecification: UMLActionExecutionSpecification[Uml]

  def createUMLActionInputPin: UMLActionInputPin[Uml]

  def createUMLActivity: UMLActivity[Uml]

  def createUMLActivityEdge: UMLActivityEdge[Uml]

  def createUMLActivityFinalNode: UMLActivityFinalNode[Uml]

  def createUMLActivityGroup: UMLActivityGroup[Uml]

  def createUMLActivityNode: UMLActivityNode[Uml]

  def createUMLActivityParameterNode: UMLActivityParameterNode[Uml]

  def createUMLActivityPartition: UMLActivityPartition[Uml]

  def createUMLActor: UMLActor[Uml]

  def createUMLAddStructuralFeatureValueAction: UMLAddStructuralFeatureValueAction[Uml]

  def createUMLAddVariableValueAction: UMLAddVariableValueAction[Uml]

  def createUMLAnyReceiveEvent: UMLAnyReceiveEvent[Uml]

  def createUMLArtifact: UMLArtifact[Uml]

  def createUMLAssociation: UMLAssociation[Uml]

  def createUMLAssociationClass: UMLAssociationClass[Uml]

  def createUMLBehavior: UMLBehavior[Uml]

  def createUMLBehaviorExecutionSpecification: UMLBehaviorExecutionSpecification[Uml]

  def createUMLBehavioralFeature: UMLBehavioralFeature[Uml]

  def createUMLBehavioredClassifier: UMLBehavioredClassifier[Uml]

  def createUMLBroadcastSignalAction: UMLBroadcastSignalAction[Uml]

  def createUMLCallAction: UMLCallAction[Uml]

  def createUMLCallBehaviorAction: UMLCallBehaviorAction[Uml]

  def createUMLCallEvent: UMLCallEvent[Uml]

  def createUMLCallOperationAction: UMLCallOperationAction[Uml]

  def createUMLCentralBufferNode: UMLCentralBufferNode[Uml]

  def createUMLChangeEvent: UMLChangeEvent[Uml]

  def createUMLClass: UMLClass[Uml]

  def createUMLClassifier: UMLClassifier[Uml]

  def createUMLClassifierTemplateParameter: UMLClassifierTemplateParameter[Uml]

  def createUMLClause: UMLClause[Uml]

  def createUMLClearAssociationAction: UMLClearAssociationAction[Uml]

  def createUMLClearStructuralFeatureAction: UMLClearStructuralFeatureAction[Uml]

  def createUMLClearVariableAction: UMLClearVariableAction[Uml]

  def createUMLCollaboration: UMLCollaboration[Uml]

  def createUMLCollaborationUse: UMLCollaborationUse[Uml]

  def createUMLCombinedFragment: UMLCombinedFragment[Uml]

  def createUMLComment: UMLComment[Uml]

  def createUMLCommunicationPath: UMLCommunicationPath[Uml]

  def createUMLComponent: UMLComponent[Uml]

  def createUMLComponentRealization: UMLComponentRealization[Uml]

  def createUMLConditionalNode: UMLConditionalNode[Uml]

  def createUMLConnectableElement: UMLConnectableElement[Uml]

  def createUMLConnectableElementTemplateParameter: UMLConnectableElementTemplateParameter[Uml]

  def createUMLConnectionPointReference: UMLConnectionPointReference[Uml]

  def createUMLConnector: UMLConnector[Uml]

  def createUMLConnectorEnd: UMLConnectorEnd[Uml]

  def createUMLConsiderIgnoreFragment: UMLConsiderIgnoreFragment[Uml]

  def createUMLConstraint: UMLConstraint[Uml]

  def createUMLContinuation: UMLContinuation[Uml]

  def createUMLControlFlow: UMLControlFlow[Uml]

  def createUMLControlNode: UMLControlNode[Uml]

  def createUMLCreateLinkAction: UMLCreateLinkAction[Uml]

  def createUMLCreateLinkObjectAction: UMLCreateLinkObjectAction[Uml]

  def createUMLCreateObjectAction: UMLCreateObjectAction[Uml]

  def createUMLDataStoreNode: UMLDataStoreNode[Uml]

  def createUMLDataType: UMLDataType[Uml]

  def createUMLDecisionNode: UMLDecisionNode[Uml]

  def createUMLDependency: UMLDependency[Uml]

  def createUMLDeployedArtifact: UMLDeployedArtifact[Uml]

  def createUMLDeployment: UMLDeployment[Uml]

  def createUMLDeploymentSpecification: UMLDeploymentSpecification[Uml]

  def createUMLDeploymentTarget: UMLDeploymentTarget[Uml]

  def createUMLDestroyLinkAction: UMLDestroyLinkAction[Uml]

  def createUMLDestroyObjectAction: UMLDestroyObjectAction[Uml]

  def createUMLDestructionOccurrenceSpecification: UMLDestructionOccurrenceSpecification[Uml]

  def createUMLDevice: UMLDevice[Uml]

  def createUMLDirectedRelationship: UMLDirectedRelationship[Uml]

  def createUMLDuration: UMLDuration[Uml]

  def createUMLDurationConstraint: UMLDurationConstraint[Uml]

  def createUMLDurationInterval: UMLDurationInterval[Uml]

  def createUMLDurationObservation: UMLDurationObservation[Uml]

  def createUMLElement: UMLElement[Uml]

  def createUMLElementImport: UMLElementImport[Uml]

  def createUMLEncapsulatedClassifier: UMLEncapsulatedClassifier[Uml]

  def createUMLEnumeration: UMLEnumeration[Uml]

  def createUMLEnumerationLiteral: UMLEnumerationLiteral[Uml]

  def createUMLEvent: UMLEvent[Uml]

  def createUMLExceptionHandler: UMLExceptionHandler[Uml]

  def createUMLExecutableNode: UMLExecutableNode[Uml]

  def createUMLExecutionEnvironment: UMLExecutionEnvironment[Uml]

  def createUMLExecutionOccurrenceSpecification: UMLExecutionOccurrenceSpecification[Uml]

  def createUMLExecutionSpecification: UMLExecutionSpecification[Uml]

  def createUMLExpansionNode: UMLExpansionNode[Uml]

  def createUMLExpansionRegion: UMLExpansionRegion[Uml]

  def createUMLExpression: UMLExpression[Uml]

  def createUMLExtend: UMLExtend[Uml]

  def createUMLExtension: UMLExtension[Uml]

  def createUMLExtensionEnd: UMLExtensionEnd[Uml]

  def createUMLExtensionPoint: UMLExtensionPoint[Uml]

  def createUMLFeature: UMLFeature[Uml]

  def createUMLFinalNode: UMLFinalNode[Uml]

  def createUMLFinalState: UMLFinalState[Uml]

  def createUMLFlowFinalNode: UMLFlowFinalNode[Uml]

  def createUMLForkNode: UMLForkNode[Uml]

  def createUMLFunctionBehavior: UMLFunctionBehavior[Uml]

  def createUMLGate: UMLGate[Uml]

  def createUMLGeneralOrdering: UMLGeneralOrdering[Uml]

  def createUMLGeneralization: UMLGeneralization[Uml]

  def createUMLGeneralizationSet: UMLGeneralizationSet[Uml]

  def createUMLImage: UMLImage[Uml]

  def createUMLInclude: UMLInclude[Uml]

  def createUMLInformationFlow: UMLInformationFlow[Uml]

  def createUMLInformationItem: UMLInformationItem[Uml]

  def createUMLInitialNode: UMLInitialNode[Uml]

  def createUMLInputPin: UMLInputPin[Uml]

  def createUMLInstanceSpecification: UMLInstanceSpecification[Uml]

  def createUMLInstanceValue: UMLInstanceValue[Uml]

  def createUMLInteraction: UMLInteraction[Uml]

  def createUMLInteractionConstraint: UMLInteractionConstraint[Uml]

  def createUMLInteractionFragment: UMLInteractionFragment[Uml]

  def createUMLInteractionOperand: UMLInteractionOperand[Uml]

  def createUMLInteractionUse: UMLInteractionUse[Uml]

  def createUMLInterface: UMLInterface[Uml]

  def createUMLInterfaceRealization: UMLInterfaceRealization[Uml]

  def createUMLInterruptibleActivityRegion: UMLInterruptibleActivityRegion[Uml]

  def createUMLInterval: UMLInterval[Uml]

  def createUMLIntervalConstraint: UMLIntervalConstraint[Uml]

  def createUMLInvocationAction: UMLInvocationAction[Uml]

  def createUMLJoinNode: UMLJoinNode[Uml]

  def createUMLLifeline: UMLLifeline[Uml]

  def createUMLLinkAction: UMLLinkAction[Uml]

  def createUMLLinkEndCreationData: UMLLinkEndCreationData[Uml]

  def createUMLLinkEndData: UMLLinkEndData[Uml]

  def createUMLLinkEndDestructionData: UMLLinkEndDestructionData[Uml]

  def createUMLLiteralBoolean: UMLLiteralBoolean[Uml]

  def createUMLLiteralInteger: UMLLiteralInteger[Uml]

  def createUMLLiteralNull: UMLLiteralNull[Uml]

  def createUMLLiteralReal: UMLLiteralReal[Uml]

  def createUMLLiteralSpecification: UMLLiteralSpecification[Uml]

  def createUMLLiteralString: UMLLiteralString[Uml]

  def createUMLLiteralUnlimitedNatural: UMLLiteralUnlimitedNatural[Uml]

  def createUMLLoopNode: UMLLoopNode[Uml]

  def createUMLManifestation: UMLManifestation[Uml]

  def createUMLMergeNode: UMLMergeNode[Uml]

  def createUMLMessage: UMLMessage[Uml]

  def createUMLMessageEnd: UMLMessageEnd[Uml]

  def createUMLMessageEvent: UMLMessageEvent[Uml]

  def createUMLMessageOccurrenceSpecification: UMLMessageOccurrenceSpecification[Uml]

  def createUMLModel: UMLModel[Uml]

  def createUMLMultiplicityElement: UMLMultiplicityElement[Uml]

  def createUMLNamedElement: UMLNamedElement[Uml]

  def createUMLNamespace: UMLNamespace[Uml]

  def createUMLNode: UMLNode[Uml]

  def createUMLObjectFlow: UMLObjectFlow[Uml]

  def createUMLObjectNode: UMLObjectNode[Uml]

  def createUMLObservation: UMLObservation[Uml]

  def createUMLOccurrenceSpecification: UMLOccurrenceSpecification[Uml]

  def createUMLOpaqueAction: UMLOpaqueAction[Uml]

  def createUMLOpaqueBehavior: UMLOpaqueBehavior[Uml]

  def createUMLOpaqueExpression: UMLOpaqueExpression[Uml]

  def createUMLOperation: UMLOperation[Uml]

  def createUMLOperationTemplateParameter: UMLOperationTemplateParameter[Uml]

  def createUMLOutputPin: UMLOutputPin[Uml]

  def createUMLPackage: UMLPackage[Uml]

  def createUMLPackageImport: UMLPackageImport[Uml]

  def createUMLPackageMerge: UMLPackageMerge[Uml]

  def createUMLPackageableElement: UMLPackageableElement[Uml]

  def createUMLParameter: UMLParameter[Uml]

  def createUMLParameterSet: UMLParameterSet[Uml]

  def createUMLParameterableElement: UMLParameterableElement[Uml]

  def createUMLPartDecomposition: UMLPartDecomposition[Uml]

  def createUMLPin: UMLPin[Uml]

  def createUMLPort: UMLPort[Uml]

  def createUMLPrimitiveType: UMLPrimitiveType[Uml]

  def createUMLProfile: UMLProfile[Uml]

  def createUMLProfileApplication: UMLProfileApplication[Uml]

  def createUMLProperty: UMLProperty[Uml]

  def createUMLProtocolConformance: UMLProtocolConformance[Uml]

  def createUMLProtocolStateMachine: UMLProtocolStateMachine[Uml]

  def createUMLProtocolTransition: UMLProtocolTransition[Uml]

  def createUMLPseudostate: UMLPseudostate[Uml]

  def createUMLQualifierValue: UMLQualifierValue[Uml]

  def createUMLRaiseExceptionAction: UMLRaiseExceptionAction[Uml]

  def createUMLReadExtentAction: UMLReadExtentAction[Uml]

  def createUMLReadIsClassifiedObjectAction: UMLReadIsClassifiedObjectAction[Uml]

  def createUMLReadLinkAction: UMLReadLinkAction[Uml]

  def createUMLReadLinkObjectEndAction: UMLReadLinkObjectEndAction[Uml]

  def createUMLReadLinkObjectEndQualifierAction: UMLReadLinkObjectEndQualifierAction[Uml]

  def createUMLReadSelfAction: UMLReadSelfAction[Uml]

  def createUMLReadStructuralFeatureAction: UMLReadStructuralFeatureAction[Uml]

  def createUMLReadVariableAction: UMLReadVariableAction[Uml]

  def createUMLRealization: UMLRealization[Uml]

  def createUMLReception: UMLReception[Uml]

  def createUMLReclassifyObjectAction: UMLReclassifyObjectAction[Uml]

  def createUMLRedefinableElement: UMLRedefinableElement[Uml]

  def createUMLRedefinableTemplateSignature: UMLRedefinableTemplateSignature[Uml]

  def createUMLReduceAction: UMLReduceAction[Uml]

  def createUMLRegion: UMLRegion[Uml]

  def createUMLRelationship: UMLRelationship[Uml]

  def createUMLRemoveStructuralFeatureValueAction: UMLRemoveStructuralFeatureValueAction[Uml]

  def createUMLRemoveVariableValueAction: UMLRemoveVariableValueAction[Uml]

  def createUMLReplyAction: UMLReplyAction[Uml]

  def createUMLSendObjectAction: UMLSendObjectAction[Uml]

  def createUMLSendSignalAction: UMLSendSignalAction[Uml]

  def createUMLSequenceNode: UMLSequenceNode[Uml]

  def createUMLSignal: UMLSignal[Uml]

  def createUMLSignalEvent: UMLSignalEvent[Uml]

  def createUMLSlot: UMLSlot[Uml]

  def createUMLStartClassifierBehaviorAction: UMLStartClassifierBehaviorAction[Uml]

  def createUMLStartObjectBehaviorAction: UMLStartObjectBehaviorAction[Uml]

  def createUMLState: UMLState[Uml]

  def createUMLStateInvariant: UMLStateInvariant[Uml]

  def createUMLStateMachine: UMLStateMachine[Uml]

  def createUMLStereotype: UMLStereotype[Uml]

  def createUMLStringExpression: UMLStringExpression[Uml]

  def createUMLStructuralFeature: UMLStructuralFeature[Uml]

  def createUMLStructuralFeatureAction: UMLStructuralFeatureAction[Uml]

  def createUMLStructuredActivityNode: UMLStructuredActivityNode[Uml]

  def createUMLStructuredClassifier: UMLStructuredClassifier[Uml]

  def createUMLSubstitution: UMLSubstitution[Uml]

  def createUMLTemplateBinding: UMLTemplateBinding[Uml]

  def createUMLTemplateParameter: UMLTemplateParameter[Uml]

  def createUMLTemplateParameterSubstitution: UMLTemplateParameterSubstitution[Uml]

  def createUMLTemplateSignature: UMLTemplateSignature[Uml]

  def createUMLTemplateableElement: UMLTemplateableElement[Uml]

  def createUMLTestIdentityAction: UMLTestIdentityAction[Uml]

  def createUMLTimeConstraint: UMLTimeConstraint[Uml]

  def createUMLTimeEvent: UMLTimeEvent[Uml]

  def createUMLTimeExpression: UMLTimeExpression[Uml]

  def createUMLTimeInterval: UMLTimeInterval[Uml]

  def createUMLTimeObservation: UMLTimeObservation[Uml]

  def createUMLTransition: UMLTransition[Uml]

  def createUMLTrigger: UMLTrigger[Uml]

  def createUMLType: UMLType[Uml]

  def createUMLTypedElement: UMLTypedElement[Uml]

  def createUMLUnmarshallAction: UMLUnmarshallAction[Uml]

  def createUMLUsage: UMLUsage[Uml]

  def createUMLUseCase: UMLUseCase[Uml]

  def createUMLValuePin: UMLValuePin[Uml]

  def createUMLValueSpecification: UMLValueSpecification[Uml]

  def createUMLValueSpecificationAction: UMLValueSpecificationAction[Uml]

  def createUMLVariable: UMLVariable[Uml]

  def createUMLVariableAction: UMLVariableAction[Uml]

  def createUMLVertex: UMLVertex[Uml]

  def createUMLWriteLinkAction: UMLWriteLinkAction[Uml]

  def createUMLWriteStructuralFeatureAction: UMLWriteStructuralFeatureAction[Uml]

  def createUMLWriteVariableAction: UMLWriteVariableAction[Uml]

}
