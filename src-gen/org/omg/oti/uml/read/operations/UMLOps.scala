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
package org.omg.oti.uml.read.operations

// Start of user code for imports

import org.omg.oti.uml._
import org.omg.oti.uml.read.api._
import scala.reflect.runtime.universe._
import scala.language.implicitConversions
import scala.reflect.{classTag}
import scala.{annotation,Boolean,Double,Int,Option,None,PartialFunction,Some,Tuple3}
import scala.Option
import scala.Predef.{Set => _,_}
import scala.collection.immutable._
import scala.collection.{Iterable,Iterator}
import scalaz._

import java.lang.Integer
import java.lang.System

// End of user code

// Start of user code for classes
class EarlyInit[T: TypeTag] {
  val mirror = runtimeMirror(this.getClass.getClassLoader)
  val reflection = mirror.reflect(this)

  System.out.println("EarlyInit (start)")

  typeTag[T]
  .tpe
  .members
  .filter(_.isModule)
  .foreach(m => {
    System.out.println("EarlyInit: " + m.name); ()
    reflection.reflectModule(m.asModule).instance; ()
  }); ()

  System.out.println("EarlyInit (done)")

}

/**
 *
  	val Package_URI =
		MetaAttributeStringFunction[Uml, UMLPackage[Uml]](None, "URI",
		_.getEffectiveURI()(None))
 */

// End of user code

/**
 * The UML 2.5 metamodel
 *
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
trait UMLOps[Uml <: UML] { self =>

// Start of user code for ops imports
  import Option._
// End of user code

	implicit val ABSTRACTION: TypeTag[Uml#Abstraction]
	implicit val ACCEPT_CALL_ACTION: TypeTag[Uml#AcceptCallAction]
	implicit val ACCEPT_EVENT_ACTION: TypeTag[Uml#AcceptEventAction]
	implicit val ACTION: TypeTag[Uml#Action]
	implicit val ACTION_EXECUTION_SPECIFICATION: TypeTag[Uml#ActionExecutionSpecification]
	implicit val ACTION_INPUT_PIN: TypeTag[Uml#ActionInputPin]
	implicit val ACTIVITY: TypeTag[Uml#Activity]
	implicit val ACTIVITY_EDGE: TypeTag[Uml#ActivityEdge]
	implicit val ACTIVITY_FINAL_NODE: TypeTag[Uml#ActivityFinalNode]
	implicit val ACTIVITY_GROUP: TypeTag[Uml#ActivityGroup]
	implicit val ACTIVITY_NODE: TypeTag[Uml#ActivityNode]
	implicit val ACTIVITY_PARAMETER_NODE: TypeTag[Uml#ActivityParameterNode]
	implicit val ACTIVITY_PARTITION: TypeTag[Uml#ActivityPartition]
	implicit val ACTOR: TypeTag[Uml#Actor]
	implicit val ADD_STRUCTURAL_FEATURE_VALUE_ACTION: TypeTag[Uml#AddStructuralFeatureValueAction]
	implicit val ADD_VARIABLE_VALUE_ACTION: TypeTag[Uml#AddVariableValueAction]
	implicit val ANY_RECEIVE_EVENT: TypeTag[Uml#AnyReceiveEvent]
	implicit val ARTIFACT: TypeTag[Uml#Artifact]
	implicit val ASSOCIATION: TypeTag[Uml#Association]
	implicit val ASSOCIATION_CLASS: TypeTag[Uml#AssociationClass]
	implicit val BEHAVIOR: TypeTag[Uml#Behavior]
	implicit val BEHAVIOR_EXECUTION_SPECIFICATION: TypeTag[Uml#BehaviorExecutionSpecification]
	implicit val BEHAVIORAL_FEATURE: TypeTag[Uml#BehavioralFeature]
	implicit val BEHAVIORED_CLASSIFIER: TypeTag[Uml#BehavioredClassifier]
	implicit val BROADCAST_SIGNAL_ACTION: TypeTag[Uml#BroadcastSignalAction]
	implicit val CALL_ACTION: TypeTag[Uml#CallAction]
	implicit val CALL_BEHAVIOR_ACTION: TypeTag[Uml#CallBehaviorAction]
	implicit val CALL_EVENT: TypeTag[Uml#CallEvent]
	implicit val CALL_OPERATION_ACTION: TypeTag[Uml#CallOperationAction]
	implicit val CENTRAL_BUFFER_NODE: TypeTag[Uml#CentralBufferNode]
	implicit val CHANGE_EVENT: TypeTag[Uml#ChangeEvent]
	implicit val CLASS: TypeTag[Uml#Class]
	implicit val CLASSIFIER: TypeTag[Uml#Classifier]
	implicit val CLASSIFIER_TEMPLATE_PARAMETER: TypeTag[Uml#ClassifierTemplateParameter]
	implicit val CLAUSE: TypeTag[Uml#Clause]
	implicit val CLEAR_ASSOCIATION_ACTION: TypeTag[Uml#ClearAssociationAction]
	implicit val CLEAR_STRUCTURAL_FEATURE_ACTION: TypeTag[Uml#ClearStructuralFeatureAction]
	implicit val CLEAR_VARIABLE_ACTION: TypeTag[Uml#ClearVariableAction]
	implicit val COLLABORATION: TypeTag[Uml#Collaboration]
	implicit val COLLABORATION_USE: TypeTag[Uml#CollaborationUse]
	implicit val COMBINED_FRAGMENT: TypeTag[Uml#CombinedFragment]
	implicit val COMMENT: TypeTag[Uml#Comment]
	implicit val COMMUNICATION_PATH: TypeTag[Uml#CommunicationPath]
	implicit val COMPONENT: TypeTag[Uml#Component]
	implicit val COMPONENT_REALIZATION: TypeTag[Uml#ComponentRealization]
	implicit val CONDITIONAL_NODE: TypeTag[Uml#ConditionalNode]
	implicit val CONNECTABLE_ELEMENT: TypeTag[Uml#ConnectableElement]
	implicit val CONNECTABLE_ELEMENT_TEMPLATE_PARAMETER: TypeTag[Uml#ConnectableElementTemplateParameter]
	implicit val CONNECTION_POINT_REFERENCE: TypeTag[Uml#ConnectionPointReference]
	implicit val CONNECTOR: TypeTag[Uml#Connector]
	implicit val CONNECTOR_END: TypeTag[Uml#ConnectorEnd]
	implicit val CONSIDER_IGNORE_FRAGMENT: TypeTag[Uml#ConsiderIgnoreFragment]
	implicit val CONSTRAINT: TypeTag[Uml#Constraint]
	implicit val CONTINUATION: TypeTag[Uml#Continuation]
	implicit val CONTROL_FLOW: TypeTag[Uml#ControlFlow]
	implicit val CONTROL_NODE: TypeTag[Uml#ControlNode]
	implicit val CREATE_LINK_ACTION: TypeTag[Uml#CreateLinkAction]
	implicit val CREATE_LINK_OBJECT_ACTION: TypeTag[Uml#CreateLinkObjectAction]
	implicit val CREATE_OBJECT_ACTION: TypeTag[Uml#CreateObjectAction]
	implicit val DATA_STORE_NODE: TypeTag[Uml#DataStoreNode]
	implicit val DATA_TYPE: TypeTag[Uml#DataType]
	implicit val DECISION_NODE: TypeTag[Uml#DecisionNode]
	implicit val DEPENDENCY: TypeTag[Uml#Dependency]
	implicit val DEPLOYED_ARTIFACT: TypeTag[Uml#DeployedArtifact]
	implicit val DEPLOYMENT: TypeTag[Uml#Deployment]
	implicit val DEPLOYMENT_SPECIFICATION: TypeTag[Uml#DeploymentSpecification]
	implicit val DEPLOYMENT_TARGET: TypeTag[Uml#DeploymentTarget]
	implicit val DESTROY_LINK_ACTION: TypeTag[Uml#DestroyLinkAction]
	implicit val DESTROY_OBJECT_ACTION: TypeTag[Uml#DestroyObjectAction]
	implicit val DESTRUCTION_OCCURRENCE_SPECIFICATION: TypeTag[Uml#DestructionOccurrenceSpecification]
	implicit val DEVICE: TypeTag[Uml#Device]
	implicit val DIRECTED_RELATIONSHIP: TypeTag[Uml#DirectedRelationship]
	implicit val DURATION: TypeTag[Uml#Duration]
	implicit val DURATION_CONSTRAINT: TypeTag[Uml#DurationConstraint]
	implicit val DURATION_INTERVAL: TypeTag[Uml#DurationInterval]
	implicit val DURATION_OBSERVATION: TypeTag[Uml#DurationObservation]
	implicit val ELEMENT: TypeTag[Uml#Element]
	implicit val ELEMENT_IMPORT: TypeTag[Uml#ElementImport]
	implicit val ENCAPSULATED_CLASSIFIER: TypeTag[Uml#EncapsulatedClassifier]
	implicit val ENUMERATION: TypeTag[Uml#Enumeration]
	implicit val ENUMERATION_LITERAL: TypeTag[Uml#EnumerationLiteral]
	implicit val EVENT: TypeTag[Uml#Event]
	implicit val EXCEPTION_HANDLER: TypeTag[Uml#ExceptionHandler]
	implicit val EXECUTABLE_NODE: TypeTag[Uml#ExecutableNode]
	implicit val EXECUTION_ENVIRONMENT: TypeTag[Uml#ExecutionEnvironment]
	implicit val EXECUTION_OCCURRENCE_SPECIFICATION: TypeTag[Uml#ExecutionOccurrenceSpecification]
	implicit val EXECUTION_SPECIFICATION: TypeTag[Uml#ExecutionSpecification]
	implicit val EXPANSION_NODE: TypeTag[Uml#ExpansionNode]
	implicit val EXPANSION_REGION: TypeTag[Uml#ExpansionRegion]
	implicit val EXPRESSION: TypeTag[Uml#Expression]
	implicit val EXTEND: TypeTag[Uml#Extend]
	implicit val EXTENSION: TypeTag[Uml#Extension]
	implicit val EXTENSION_END: TypeTag[Uml#ExtensionEnd]
	implicit val EXTENSION_POINT: TypeTag[Uml#ExtensionPoint]
	implicit val FEATURE: TypeTag[Uml#Feature]
	implicit val FINAL_NODE: TypeTag[Uml#FinalNode]
	implicit val FINAL_STATE: TypeTag[Uml#FinalState]
	implicit val FLOW_FINAL_NODE: TypeTag[Uml#FlowFinalNode]
	implicit val FORK_NODE: TypeTag[Uml#ForkNode]
	implicit val FUNCTION_BEHAVIOR: TypeTag[Uml#FunctionBehavior]
	implicit val GATE: TypeTag[Uml#Gate]
	implicit val GENERAL_ORDERING: TypeTag[Uml#GeneralOrdering]
	implicit val GENERALIZATION: TypeTag[Uml#Generalization]
	implicit val GENERALIZATION_SET: TypeTag[Uml#GeneralizationSet]
	implicit val IMAGE: TypeTag[Uml#Image]
	implicit val INCLUDE: TypeTag[Uml#Include]
	implicit val INFORMATION_FLOW: TypeTag[Uml#InformationFlow]
	implicit val INFORMATION_ITEM: TypeTag[Uml#InformationItem]
	implicit val INITIAL_NODE: TypeTag[Uml#InitialNode]
	implicit val INPUT_PIN: TypeTag[Uml#InputPin]
	implicit val INSTANCE_SPECIFICATION: TypeTag[Uml#InstanceSpecification]
	implicit val INSTANCE_VALUE: TypeTag[Uml#InstanceValue]
	implicit val INTERACTION: TypeTag[Uml#Interaction]
	implicit val INTERACTION_CONSTRAINT: TypeTag[Uml#InteractionConstraint]
	implicit val INTERACTION_FRAGMENT: TypeTag[Uml#InteractionFragment]
	implicit val INTERACTION_OPERAND: TypeTag[Uml#InteractionOperand]
	implicit val INTERACTION_USE: TypeTag[Uml#InteractionUse]
	implicit val INTERFACE: TypeTag[Uml#Interface]
	implicit val INTERFACE_REALIZATION: TypeTag[Uml#InterfaceRealization]
	implicit val INTERRUPTIBLE_ACTIVITY_REGION: TypeTag[Uml#InterruptibleActivityRegion]
	implicit val INTERVAL: TypeTag[Uml#Interval]
	implicit val INTERVAL_CONSTRAINT: TypeTag[Uml#IntervalConstraint]
	implicit val INVOCATION_ACTION: TypeTag[Uml#InvocationAction]
	implicit val JOIN_NODE: TypeTag[Uml#JoinNode]
	implicit val LIFELINE: TypeTag[Uml#Lifeline]
	implicit val LINK_ACTION: TypeTag[Uml#LinkAction]
	implicit val LINK_END_CREATION_DATA: TypeTag[Uml#LinkEndCreationData]
	implicit val LINK_END_DATA: TypeTag[Uml#LinkEndData]
	implicit val LINK_END_DESTRUCTION_DATA: TypeTag[Uml#LinkEndDestructionData]
	implicit val LITERAL_BOOLEAN: TypeTag[Uml#LiteralBoolean]
	implicit val LITERAL_INTEGER: TypeTag[Uml#LiteralInteger]
	implicit val LITERAL_NULL: TypeTag[Uml#LiteralNull]
	implicit val LITERAL_REAL: TypeTag[Uml#LiteralReal]
	implicit val LITERAL_SPECIFICATION: TypeTag[Uml#LiteralSpecification]
	implicit val LITERAL_STRING: TypeTag[Uml#LiteralString]
	implicit val LITERAL_UNLIMITED_NATURAL: TypeTag[Uml#LiteralUnlimitedNatural]
	implicit val LOOP_NODE: TypeTag[Uml#LoopNode]
	implicit val MANIFESTATION: TypeTag[Uml#Manifestation]
	implicit val MERGE_NODE: TypeTag[Uml#MergeNode]
	implicit val MESSAGE: TypeTag[Uml#Message]
	implicit val MESSAGE_END: TypeTag[Uml#MessageEnd]
	implicit val MESSAGE_EVENT: TypeTag[Uml#MessageEvent]
	implicit val MESSAGE_OCCURRENCE_SPECIFICATION: TypeTag[Uml#MessageOccurrenceSpecification]
	implicit val MODEL: TypeTag[Uml#Model]
	implicit val MULTIPLICITY_ELEMENT: TypeTag[Uml#MultiplicityElement]
	implicit val NAMED_ELEMENT: TypeTag[Uml#NamedElement]
	implicit val NAMESPACE: TypeTag[Uml#Namespace]
	implicit val NODE: TypeTag[Uml#Node]
	implicit val OBJECT_FLOW: TypeTag[Uml#ObjectFlow]
	implicit val OBJECT_NODE: TypeTag[Uml#ObjectNode]
	implicit val OBSERVATION: TypeTag[Uml#Observation]
	implicit val OCCURRENCE_SPECIFICATION: TypeTag[Uml#OccurrenceSpecification]
	implicit val OPAQUE_ACTION: TypeTag[Uml#OpaqueAction]
	implicit val OPAQUE_BEHAVIOR: TypeTag[Uml#OpaqueBehavior]
	implicit val OPAQUE_EXPRESSION: TypeTag[Uml#OpaqueExpression]
	implicit val OPERATION: TypeTag[Uml#Operation]
	implicit val OPERATION_TEMPLATE_PARAMETER: TypeTag[Uml#OperationTemplateParameter]
	implicit val OUTPUT_PIN: TypeTag[Uml#OutputPin]
	implicit val PACKAGE: TypeTag[Uml#Package]
	implicit val PACKAGE_IMPORT: TypeTag[Uml#PackageImport]
	implicit val PACKAGE_MERGE: TypeTag[Uml#PackageMerge]
	implicit val PACKAGEABLE_ELEMENT: TypeTag[Uml#PackageableElement]
	implicit val PARAMETER: TypeTag[Uml#Parameter]
	implicit val PARAMETER_SET: TypeTag[Uml#ParameterSet]
	implicit val PARAMETERABLE_ELEMENT: TypeTag[Uml#ParameterableElement]
	implicit val PART_DECOMPOSITION: TypeTag[Uml#PartDecomposition]
	implicit val PIN: TypeTag[Uml#Pin]
	implicit val PORT: TypeTag[Uml#Port]
	implicit val PRIMITIVE_TYPE: TypeTag[Uml#PrimitiveType]
	implicit val PROFILE: TypeTag[Uml#Profile]
	implicit val PROFILE_APPLICATION: TypeTag[Uml#ProfileApplication]
	implicit val PROPERTY: TypeTag[Uml#Property]
	implicit val PROTOCOL_CONFORMANCE: TypeTag[Uml#ProtocolConformance]
	implicit val PROTOCOL_STATE_MACHINE: TypeTag[Uml#ProtocolStateMachine]
	implicit val PROTOCOL_TRANSITION: TypeTag[Uml#ProtocolTransition]
	implicit val PSEUDOSTATE: TypeTag[Uml#Pseudostate]
	implicit val QUALIFIER_VALUE: TypeTag[Uml#QualifierValue]
	implicit val RAISE_EXCEPTION_ACTION: TypeTag[Uml#RaiseExceptionAction]
	implicit val READ_EXTENT_ACTION: TypeTag[Uml#ReadExtentAction]
	implicit val READ_IS_CLASSIFIED_OBJECT_ACTION: TypeTag[Uml#ReadIsClassifiedObjectAction]
	implicit val READ_LINK_ACTION: TypeTag[Uml#ReadLinkAction]
	implicit val READ_LINK_OBJECT_END_ACTION: TypeTag[Uml#ReadLinkObjectEndAction]
	implicit val READ_LINK_OBJECT_END_QUALIFIER_ACTION: TypeTag[Uml#ReadLinkObjectEndQualifierAction]
	implicit val READ_SELF_ACTION: TypeTag[Uml#ReadSelfAction]
	implicit val READ_STRUCTURAL_FEATURE_ACTION: TypeTag[Uml#ReadStructuralFeatureAction]
	implicit val READ_VARIABLE_ACTION: TypeTag[Uml#ReadVariableAction]
	implicit val REALIZATION: TypeTag[Uml#Realization]
	implicit val RECEPTION: TypeTag[Uml#Reception]
	implicit val RECLASSIFY_OBJECT_ACTION: TypeTag[Uml#ReclassifyObjectAction]
	implicit val REDEFINABLE_ELEMENT: TypeTag[Uml#RedefinableElement]
	implicit val REDEFINABLE_TEMPLATE_SIGNATURE: TypeTag[Uml#RedefinableTemplateSignature]
	implicit val REDUCE_ACTION: TypeTag[Uml#ReduceAction]
	implicit val REGION: TypeTag[Uml#Region]
	implicit val RELATIONSHIP: TypeTag[Uml#Relationship]
	implicit val REMOVE_STRUCTURAL_FEATURE_VALUE_ACTION: TypeTag[Uml#RemoveStructuralFeatureValueAction]
	implicit val REMOVE_VARIABLE_VALUE_ACTION: TypeTag[Uml#RemoveVariableValueAction]
	implicit val REPLY_ACTION: TypeTag[Uml#ReplyAction]
	implicit val SEND_OBJECT_ACTION: TypeTag[Uml#SendObjectAction]
	implicit val SEND_SIGNAL_ACTION: TypeTag[Uml#SendSignalAction]
	implicit val SEQUENCE_NODE: TypeTag[Uml#SequenceNode]
	implicit val SIGNAL: TypeTag[Uml#Signal]
	implicit val SIGNAL_EVENT: TypeTag[Uml#SignalEvent]
	implicit val SLOT: TypeTag[Uml#Slot]
	implicit val START_CLASSIFIER_BEHAVIOR_ACTION: TypeTag[Uml#StartClassifierBehaviorAction]
	implicit val START_OBJECT_BEHAVIOR_ACTION: TypeTag[Uml#StartObjectBehaviorAction]
	implicit val STATE: TypeTag[Uml#State]
	implicit val STATE_INVARIANT: TypeTag[Uml#StateInvariant]
	implicit val STATE_MACHINE: TypeTag[Uml#StateMachine]
	implicit val STEREOTYPE: TypeTag[Uml#Stereotype]
	implicit val STRING_EXPRESSION: TypeTag[Uml#StringExpression]
	implicit val STRUCTURAL_FEATURE: TypeTag[Uml#StructuralFeature]
	implicit val STRUCTURAL_FEATURE_ACTION: TypeTag[Uml#StructuralFeatureAction]
	implicit val STRUCTURED_ACTIVITY_NODE: TypeTag[Uml#StructuredActivityNode]
	implicit val STRUCTURED_CLASSIFIER: TypeTag[Uml#StructuredClassifier]
	implicit val SUBSTITUTION: TypeTag[Uml#Substitution]
	implicit val TEMPLATE_BINDING: TypeTag[Uml#TemplateBinding]
	implicit val TEMPLATE_PARAMETER: TypeTag[Uml#TemplateParameter]
	implicit val TEMPLATE_PARAMETER_SUBSTITUTION: TypeTag[Uml#TemplateParameterSubstitution]
	implicit val TEMPLATE_SIGNATURE: TypeTag[Uml#TemplateSignature]
	implicit val TEMPLATEABLE_ELEMENT: TypeTag[Uml#TemplateableElement]
	implicit val TEST_IDENTITY_ACTION: TypeTag[Uml#TestIdentityAction]
	implicit val TIME_CONSTRAINT: TypeTag[Uml#TimeConstraint]
	implicit val TIME_EVENT: TypeTag[Uml#TimeEvent]
	implicit val TIME_EXPRESSION: TypeTag[Uml#TimeExpression]
	implicit val TIME_INTERVAL: TypeTag[Uml#TimeInterval]
	implicit val TIME_OBSERVATION: TypeTag[Uml#TimeObservation]
	implicit val TRANSITION: TypeTag[Uml#Transition]
	implicit val TRIGGER: TypeTag[Uml#Trigger]
	implicit val TYPE: TypeTag[Uml#Type]
	implicit val TYPED_ELEMENT: TypeTag[Uml#TypedElement]
	implicit val UNMARSHALL_ACTION: TypeTag[Uml#UnmarshallAction]
	implicit val USAGE: TypeTag[Uml#Usage]
	implicit val USE_CASE: TypeTag[Uml#UseCase]
	implicit val VALUE_PIN: TypeTag[Uml#ValuePin]
	implicit val VALUE_SPECIFICATION: TypeTag[Uml#ValueSpecification]
	implicit val VALUE_SPECIFICATION_ACTION: TypeTag[Uml#ValueSpecificationAction]
	implicit val VARIABLE: TypeTag[Uml#Variable]
	implicit val VARIABLE_ACTION: TypeTag[Uml#VariableAction]
	implicit val VERTEX: TypeTag[Uml#Vertex]
	implicit val WRITE_LINK_ACTION: TypeTag[Uml#WriteLinkAction]
	implicit val WRITE_STRUCTURAL_FEATURE_ACTION: TypeTag[Uml#WriteStructuralFeatureAction]
	implicit val WRITE_VARIABLE_ACTION: TypeTag[Uml#WriteVariableAction]

	implicit def umlAbstraction(e: Uml#Abstraction): UMLAbstraction[Uml]
	implicit def umlAbstraction(c: Iterable[Uml#Abstraction]): Iterable[UMLAbstraction[Uml]] = for {e <- c} yield umlAbstraction(e)
	implicit def umlAbstraction(c: Seq[Uml#Abstraction]): Seq[UMLAbstraction[Uml]] = for {e <- c} yield umlAbstraction(e)
	implicit def umlAbstraction(c: Set[Uml#Abstraction]): Set[UMLAbstraction[Uml]] = for {e <- c} yield umlAbstraction(e)

	implicit def umlAcceptCallAction(e: Uml#AcceptCallAction): UMLAcceptCallAction[Uml]
	implicit def umlAcceptCallAction(c: Iterable[Uml#AcceptCallAction]): Iterable[UMLAcceptCallAction[Uml]] = for {e <- c} yield umlAcceptCallAction(e)
	implicit def umlAcceptCallAction(c: Seq[Uml#AcceptCallAction]): Seq[UMLAcceptCallAction[Uml]] = for {e <- c} yield umlAcceptCallAction(e)
	implicit def umlAcceptCallAction(c: Set[Uml#AcceptCallAction]): Set[UMLAcceptCallAction[Uml]] = for {e <- c} yield umlAcceptCallAction(e)

	implicit def umlAcceptEventAction(e: Uml#AcceptEventAction): UMLAcceptEventAction[Uml]
	implicit def umlAcceptEventAction(c: Iterable[Uml#AcceptEventAction]): Iterable[UMLAcceptEventAction[Uml]] = for {e <- c} yield umlAcceptEventAction(e)
	implicit def umlAcceptEventAction(c: Seq[Uml#AcceptEventAction]): Seq[UMLAcceptEventAction[Uml]] = for {e <- c} yield umlAcceptEventAction(e)
	implicit def umlAcceptEventAction(c: Set[Uml#AcceptEventAction]): Set[UMLAcceptEventAction[Uml]] = for {e <- c} yield umlAcceptEventAction(e)

	implicit def umlAction(e: Uml#Action): UMLAction[Uml]
	implicit def umlAction(c: Iterable[Uml#Action]): Iterable[UMLAction[Uml]] = for {e <- c} yield umlAction(e)
	implicit def umlAction(c: Seq[Uml#Action]): Seq[UMLAction[Uml]] = for {e <- c} yield umlAction(e)
	implicit def umlAction(c: Set[Uml#Action]): Set[UMLAction[Uml]] = for {e <- c} yield umlAction(e)

	implicit def umlActionExecutionSpecification(e: Uml#ActionExecutionSpecification): UMLActionExecutionSpecification[Uml]
	implicit def umlActionExecutionSpecification(c: Iterable[Uml#ActionExecutionSpecification]): Iterable[UMLActionExecutionSpecification[Uml]] = for {e <- c} yield umlActionExecutionSpecification(e)
	implicit def umlActionExecutionSpecification(c: Seq[Uml#ActionExecutionSpecification]): Seq[UMLActionExecutionSpecification[Uml]] = for {e <- c} yield umlActionExecutionSpecification(e)
	implicit def umlActionExecutionSpecification(c: Set[Uml#ActionExecutionSpecification]): Set[UMLActionExecutionSpecification[Uml]] = for {e <- c} yield umlActionExecutionSpecification(e)

	implicit def umlActionInputPin(e: Uml#ActionInputPin): UMLActionInputPin[Uml]
	implicit def umlActionInputPin(c: Iterable[Uml#ActionInputPin]): Iterable[UMLActionInputPin[Uml]] = for {e <- c} yield umlActionInputPin(e)
	implicit def umlActionInputPin(c: Seq[Uml#ActionInputPin]): Seq[UMLActionInputPin[Uml]] = for {e <- c} yield umlActionInputPin(e)
	implicit def umlActionInputPin(c: Set[Uml#ActionInputPin]): Set[UMLActionInputPin[Uml]] = for {e <- c} yield umlActionInputPin(e)

	implicit def umlActivity(e: Uml#Activity): UMLActivity[Uml]
	implicit def umlActivity(c: Iterable[Uml#Activity]): Iterable[UMLActivity[Uml]] = for {e <- c} yield umlActivity(e)
	implicit def umlActivity(c: Seq[Uml#Activity]): Seq[UMLActivity[Uml]] = for {e <- c} yield umlActivity(e)
	implicit def umlActivity(c: Set[Uml#Activity]): Set[UMLActivity[Uml]] = for {e <- c} yield umlActivity(e)

	implicit def umlActivityEdge(e: Uml#ActivityEdge): UMLActivityEdge[Uml]
	implicit def umlActivityEdge(c: Iterable[Uml#ActivityEdge]): Iterable[UMLActivityEdge[Uml]] = for {e <- c} yield umlActivityEdge(e)
	implicit def umlActivityEdge(c: Seq[Uml#ActivityEdge]): Seq[UMLActivityEdge[Uml]] = for {e <- c} yield umlActivityEdge(e)
	implicit def umlActivityEdge(c: Set[Uml#ActivityEdge]): Set[UMLActivityEdge[Uml]] = for {e <- c} yield umlActivityEdge(e)

	implicit def umlActivityFinalNode(e: Uml#ActivityFinalNode): UMLActivityFinalNode[Uml]
	implicit def umlActivityFinalNode(c: Iterable[Uml#ActivityFinalNode]): Iterable[UMLActivityFinalNode[Uml]] = for {e <- c} yield umlActivityFinalNode(e)
	implicit def umlActivityFinalNode(c: Seq[Uml#ActivityFinalNode]): Seq[UMLActivityFinalNode[Uml]] = for {e <- c} yield umlActivityFinalNode(e)
	implicit def umlActivityFinalNode(c: Set[Uml#ActivityFinalNode]): Set[UMLActivityFinalNode[Uml]] = for {e <- c} yield umlActivityFinalNode(e)

	implicit def umlActivityGroup(e: Uml#ActivityGroup): UMLActivityGroup[Uml]
	implicit def umlActivityGroup(c: Iterable[Uml#ActivityGroup]): Iterable[UMLActivityGroup[Uml]] = for {e <- c} yield umlActivityGroup(e)
	implicit def umlActivityGroup(c: Seq[Uml#ActivityGroup]): Seq[UMLActivityGroup[Uml]] = for {e <- c} yield umlActivityGroup(e)
	implicit def umlActivityGroup(c: Set[Uml#ActivityGroup]): Set[UMLActivityGroup[Uml]] = for {e <- c} yield umlActivityGroup(e)

	implicit def umlActivityNode(e: Uml#ActivityNode): UMLActivityNode[Uml]
	implicit def umlActivityNode(c: Iterable[Uml#ActivityNode]): Iterable[UMLActivityNode[Uml]] = for {e <- c} yield umlActivityNode(e)
	implicit def umlActivityNode(c: Seq[Uml#ActivityNode]): Seq[UMLActivityNode[Uml]] = for {e <- c} yield umlActivityNode(e)
	implicit def umlActivityNode(c: Set[Uml#ActivityNode]): Set[UMLActivityNode[Uml]] = for {e <- c} yield umlActivityNode(e)

	implicit def umlActivityParameterNode(e: Uml#ActivityParameterNode): UMLActivityParameterNode[Uml]
	implicit def umlActivityParameterNode(c: Iterable[Uml#ActivityParameterNode]): Iterable[UMLActivityParameterNode[Uml]] = for {e <- c} yield umlActivityParameterNode(e)
	implicit def umlActivityParameterNode(c: Seq[Uml#ActivityParameterNode]): Seq[UMLActivityParameterNode[Uml]] = for {e <- c} yield umlActivityParameterNode(e)
	implicit def umlActivityParameterNode(c: Set[Uml#ActivityParameterNode]): Set[UMLActivityParameterNode[Uml]] = for {e <- c} yield umlActivityParameterNode(e)

	implicit def umlActivityPartition(e: Uml#ActivityPartition): UMLActivityPartition[Uml]
	implicit def umlActivityPartition(c: Iterable[Uml#ActivityPartition]): Iterable[UMLActivityPartition[Uml]] = for {e <- c} yield umlActivityPartition(e)
	implicit def umlActivityPartition(c: Seq[Uml#ActivityPartition]): Seq[UMLActivityPartition[Uml]] = for {e <- c} yield umlActivityPartition(e)
	implicit def umlActivityPartition(c: Set[Uml#ActivityPartition]): Set[UMLActivityPartition[Uml]] = for {e <- c} yield umlActivityPartition(e)

	implicit def umlActor(e: Uml#Actor): UMLActor[Uml]
	implicit def umlActor(c: Iterable[Uml#Actor]): Iterable[UMLActor[Uml]] = for {e <- c} yield umlActor(e)
	implicit def umlActor(c: Seq[Uml#Actor]): Seq[UMLActor[Uml]] = for {e <- c} yield umlActor(e)
	implicit def umlActor(c: Set[Uml#Actor]): Set[UMLActor[Uml]] = for {e <- c} yield umlActor(e)

	implicit def umlAddStructuralFeatureValueAction(e: Uml#AddStructuralFeatureValueAction): UMLAddStructuralFeatureValueAction[Uml]
	implicit def umlAddStructuralFeatureValueAction(c: Iterable[Uml#AddStructuralFeatureValueAction]): Iterable[UMLAddStructuralFeatureValueAction[Uml]] = for {e <- c} yield umlAddStructuralFeatureValueAction(e)
	implicit def umlAddStructuralFeatureValueAction(c: Seq[Uml#AddStructuralFeatureValueAction]): Seq[UMLAddStructuralFeatureValueAction[Uml]] = for {e <- c} yield umlAddStructuralFeatureValueAction(e)
	implicit def umlAddStructuralFeatureValueAction(c: Set[Uml#AddStructuralFeatureValueAction]): Set[UMLAddStructuralFeatureValueAction[Uml]] = for {e <- c} yield umlAddStructuralFeatureValueAction(e)

	implicit def umlAddVariableValueAction(e: Uml#AddVariableValueAction): UMLAddVariableValueAction[Uml]
	implicit def umlAddVariableValueAction(c: Iterable[Uml#AddVariableValueAction]): Iterable[UMLAddVariableValueAction[Uml]] = for {e <- c} yield umlAddVariableValueAction(e)
	implicit def umlAddVariableValueAction(c: Seq[Uml#AddVariableValueAction]): Seq[UMLAddVariableValueAction[Uml]] = for {e <- c} yield umlAddVariableValueAction(e)
	implicit def umlAddVariableValueAction(c: Set[Uml#AddVariableValueAction]): Set[UMLAddVariableValueAction[Uml]] = for {e <- c} yield umlAddVariableValueAction(e)

	implicit def umlAnyReceiveEvent(e: Uml#AnyReceiveEvent): UMLAnyReceiveEvent[Uml]
	implicit def umlAnyReceiveEvent(c: Iterable[Uml#AnyReceiveEvent]): Iterable[UMLAnyReceiveEvent[Uml]] = for {e <- c} yield umlAnyReceiveEvent(e)
	implicit def umlAnyReceiveEvent(c: Seq[Uml#AnyReceiveEvent]): Seq[UMLAnyReceiveEvent[Uml]] = for {e <- c} yield umlAnyReceiveEvent(e)
	implicit def umlAnyReceiveEvent(c: Set[Uml#AnyReceiveEvent]): Set[UMLAnyReceiveEvent[Uml]] = for {e <- c} yield umlAnyReceiveEvent(e)

	implicit def umlArtifact(e: Uml#Artifact): UMLArtifact[Uml]
	implicit def umlArtifact(c: Iterable[Uml#Artifact]): Iterable[UMLArtifact[Uml]] = for {e <- c} yield umlArtifact(e)
	implicit def umlArtifact(c: Seq[Uml#Artifact]): Seq[UMLArtifact[Uml]] = for {e <- c} yield umlArtifact(e)
	implicit def umlArtifact(c: Set[Uml#Artifact]): Set[UMLArtifact[Uml]] = for {e <- c} yield umlArtifact(e)

	implicit def umlAssociation(e: Uml#Association): UMLAssociation[Uml]
	implicit def umlAssociation(c: Iterable[Uml#Association]): Iterable[UMLAssociation[Uml]] = for {e <- c} yield umlAssociation(e)
	implicit def umlAssociation(c: Seq[Uml#Association]): Seq[UMLAssociation[Uml]] = for {e <- c} yield umlAssociation(e)
	implicit def umlAssociation(c: Set[Uml#Association]): Set[UMLAssociation[Uml]] = for {e <- c} yield umlAssociation(e)

	implicit def umlAssociationClass(e: Uml#AssociationClass): UMLAssociationClass[Uml]
	implicit def umlAssociationClass(c: Iterable[Uml#AssociationClass]): Iterable[UMLAssociationClass[Uml]] = for {e <- c} yield umlAssociationClass(e)
	implicit def umlAssociationClass(c: Seq[Uml#AssociationClass]): Seq[UMLAssociationClass[Uml]] = for {e <- c} yield umlAssociationClass(e)
	implicit def umlAssociationClass(c: Set[Uml#AssociationClass]): Set[UMLAssociationClass[Uml]] = for {e <- c} yield umlAssociationClass(e)

	implicit def umlBehavior(e: Uml#Behavior): UMLBehavior[Uml]
	implicit def umlBehavior(c: Iterable[Uml#Behavior]): Iterable[UMLBehavior[Uml]] = for {e <- c} yield umlBehavior(e)
	implicit def umlBehavior(c: Seq[Uml#Behavior]): Seq[UMLBehavior[Uml]] = for {e <- c} yield umlBehavior(e)
	implicit def umlBehavior(c: Set[Uml#Behavior]): Set[UMLBehavior[Uml]] = for {e <- c} yield umlBehavior(e)

	implicit def umlBehaviorExecutionSpecification(e: Uml#BehaviorExecutionSpecification): UMLBehaviorExecutionSpecification[Uml]
	implicit def umlBehaviorExecutionSpecification(c: Iterable[Uml#BehaviorExecutionSpecification]): Iterable[UMLBehaviorExecutionSpecification[Uml]] = for {e <- c} yield umlBehaviorExecutionSpecification(e)
	implicit def umlBehaviorExecutionSpecification(c: Seq[Uml#BehaviorExecutionSpecification]): Seq[UMLBehaviorExecutionSpecification[Uml]] = for {e <- c} yield umlBehaviorExecutionSpecification(e)
	implicit def umlBehaviorExecutionSpecification(c: Set[Uml#BehaviorExecutionSpecification]): Set[UMLBehaviorExecutionSpecification[Uml]] = for {e <- c} yield umlBehaviorExecutionSpecification(e)

	implicit def umlBehavioralFeature(e: Uml#BehavioralFeature): UMLBehavioralFeature[Uml]
	implicit def umlBehavioralFeature(c: Iterable[Uml#BehavioralFeature]): Iterable[UMLBehavioralFeature[Uml]] = for {e <- c} yield umlBehavioralFeature(e)
	implicit def umlBehavioralFeature(c: Seq[Uml#BehavioralFeature]): Seq[UMLBehavioralFeature[Uml]] = for {e <- c} yield umlBehavioralFeature(e)
	implicit def umlBehavioralFeature(c: Set[Uml#BehavioralFeature]): Set[UMLBehavioralFeature[Uml]] = for {e <- c} yield umlBehavioralFeature(e)

	implicit def umlBehavioredClassifier(e: Uml#BehavioredClassifier): UMLBehavioredClassifier[Uml]
	implicit def umlBehavioredClassifier(c: Iterable[Uml#BehavioredClassifier]): Iterable[UMLBehavioredClassifier[Uml]] = for {e <- c} yield umlBehavioredClassifier(e)
	implicit def umlBehavioredClassifier(c: Seq[Uml#BehavioredClassifier]): Seq[UMLBehavioredClassifier[Uml]] = for {e <- c} yield umlBehavioredClassifier(e)
	implicit def umlBehavioredClassifier(c: Set[Uml#BehavioredClassifier]): Set[UMLBehavioredClassifier[Uml]] = for {e <- c} yield umlBehavioredClassifier(e)

	implicit def umlBroadcastSignalAction(e: Uml#BroadcastSignalAction): UMLBroadcastSignalAction[Uml]
	implicit def umlBroadcastSignalAction(c: Iterable[Uml#BroadcastSignalAction]): Iterable[UMLBroadcastSignalAction[Uml]] = for {e <- c} yield umlBroadcastSignalAction(e)
	implicit def umlBroadcastSignalAction(c: Seq[Uml#BroadcastSignalAction]): Seq[UMLBroadcastSignalAction[Uml]] = for {e <- c} yield umlBroadcastSignalAction(e)
	implicit def umlBroadcastSignalAction(c: Set[Uml#BroadcastSignalAction]): Set[UMLBroadcastSignalAction[Uml]] = for {e <- c} yield umlBroadcastSignalAction(e)

	implicit def umlCallAction(e: Uml#CallAction): UMLCallAction[Uml]
	implicit def umlCallAction(c: Iterable[Uml#CallAction]): Iterable[UMLCallAction[Uml]] = for {e <- c} yield umlCallAction(e)
	implicit def umlCallAction(c: Seq[Uml#CallAction]): Seq[UMLCallAction[Uml]] = for {e <- c} yield umlCallAction(e)
	implicit def umlCallAction(c: Set[Uml#CallAction]): Set[UMLCallAction[Uml]] = for {e <- c} yield umlCallAction(e)

	implicit def umlCallBehaviorAction(e: Uml#CallBehaviorAction): UMLCallBehaviorAction[Uml]
	implicit def umlCallBehaviorAction(c: Iterable[Uml#CallBehaviorAction]): Iterable[UMLCallBehaviorAction[Uml]] = for {e <- c} yield umlCallBehaviorAction(e)
	implicit def umlCallBehaviorAction(c: Seq[Uml#CallBehaviorAction]): Seq[UMLCallBehaviorAction[Uml]] = for {e <- c} yield umlCallBehaviorAction(e)
	implicit def umlCallBehaviorAction(c: Set[Uml#CallBehaviorAction]): Set[UMLCallBehaviorAction[Uml]] = for {e <- c} yield umlCallBehaviorAction(e)

	implicit def umlCallEvent(e: Uml#CallEvent): UMLCallEvent[Uml]
	implicit def umlCallEvent(c: Iterable[Uml#CallEvent]): Iterable[UMLCallEvent[Uml]] = for {e <- c} yield umlCallEvent(e)
	implicit def umlCallEvent(c: Seq[Uml#CallEvent]): Seq[UMLCallEvent[Uml]] = for {e <- c} yield umlCallEvent(e)
	implicit def umlCallEvent(c: Set[Uml#CallEvent]): Set[UMLCallEvent[Uml]] = for {e <- c} yield umlCallEvent(e)

	implicit def umlCallOperationAction(e: Uml#CallOperationAction): UMLCallOperationAction[Uml]
	implicit def umlCallOperationAction(c: Iterable[Uml#CallOperationAction]): Iterable[UMLCallOperationAction[Uml]] = for {e <- c} yield umlCallOperationAction(e)
	implicit def umlCallOperationAction(c: Seq[Uml#CallOperationAction]): Seq[UMLCallOperationAction[Uml]] = for {e <- c} yield umlCallOperationAction(e)
	implicit def umlCallOperationAction(c: Set[Uml#CallOperationAction]): Set[UMLCallOperationAction[Uml]] = for {e <- c} yield umlCallOperationAction(e)

	implicit def umlCentralBufferNode(e: Uml#CentralBufferNode): UMLCentralBufferNode[Uml]
	implicit def umlCentralBufferNode(c: Iterable[Uml#CentralBufferNode]): Iterable[UMLCentralBufferNode[Uml]] = for {e <- c} yield umlCentralBufferNode(e)
	implicit def umlCentralBufferNode(c: Seq[Uml#CentralBufferNode]): Seq[UMLCentralBufferNode[Uml]] = for {e <- c} yield umlCentralBufferNode(e)
	implicit def umlCentralBufferNode(c: Set[Uml#CentralBufferNode]): Set[UMLCentralBufferNode[Uml]] = for {e <- c} yield umlCentralBufferNode(e)

	implicit def umlChangeEvent(e: Uml#ChangeEvent): UMLChangeEvent[Uml]
	implicit def umlChangeEvent(c: Iterable[Uml#ChangeEvent]): Iterable[UMLChangeEvent[Uml]] = for {e <- c} yield umlChangeEvent(e)
	implicit def umlChangeEvent(c: Seq[Uml#ChangeEvent]): Seq[UMLChangeEvent[Uml]] = for {e <- c} yield umlChangeEvent(e)
	implicit def umlChangeEvent(c: Set[Uml#ChangeEvent]): Set[UMLChangeEvent[Uml]] = for {e <- c} yield umlChangeEvent(e)

	implicit def umlClass(e: Uml#Class): UMLClass[Uml]
	implicit def umlClass(c: Iterable[Uml#Class]): Iterable[UMLClass[Uml]] = for {e <- c} yield umlClass(e)
	implicit def umlClass(c: Seq[Uml#Class]): Seq[UMLClass[Uml]] = for {e <- c} yield umlClass(e)
	implicit def umlClass(c: Set[Uml#Class]): Set[UMLClass[Uml]] = for {e <- c} yield umlClass(e)

	implicit def umlClassifier(e: Uml#Classifier): UMLClassifier[Uml]
	implicit def umlClassifier(c: Iterable[Uml#Classifier]): Iterable[UMLClassifier[Uml]] = for {e <- c} yield umlClassifier(e)
	implicit def umlClassifier(c: Seq[Uml#Classifier]): Seq[UMLClassifier[Uml]] = for {e <- c} yield umlClassifier(e)
	implicit def umlClassifier(c: Set[Uml#Classifier]): Set[UMLClassifier[Uml]] = for {e <- c} yield umlClassifier(e)

	implicit def umlClassifierTemplateParameter(e: Uml#ClassifierTemplateParameter): UMLClassifierTemplateParameter[Uml]
	implicit def umlClassifierTemplateParameter(c: Iterable[Uml#ClassifierTemplateParameter]): Iterable[UMLClassifierTemplateParameter[Uml]] = for {e <- c} yield umlClassifierTemplateParameter(e)
	implicit def umlClassifierTemplateParameter(c: Seq[Uml#ClassifierTemplateParameter]): Seq[UMLClassifierTemplateParameter[Uml]] = for {e <- c} yield umlClassifierTemplateParameter(e)
	implicit def umlClassifierTemplateParameter(c: Set[Uml#ClassifierTemplateParameter]): Set[UMLClassifierTemplateParameter[Uml]] = for {e <- c} yield umlClassifierTemplateParameter(e)

	implicit def umlClause(e: Uml#Clause): UMLClause[Uml]
	implicit def umlClause(c: Iterable[Uml#Clause]): Iterable[UMLClause[Uml]] = for {e <- c} yield umlClause(e)
	implicit def umlClause(c: Seq[Uml#Clause]): Seq[UMLClause[Uml]] = for {e <- c} yield umlClause(e)
	implicit def umlClause(c: Set[Uml#Clause]): Set[UMLClause[Uml]] = for {e <- c} yield umlClause(e)

	implicit def umlClearAssociationAction(e: Uml#ClearAssociationAction): UMLClearAssociationAction[Uml]
	implicit def umlClearAssociationAction(c: Iterable[Uml#ClearAssociationAction]): Iterable[UMLClearAssociationAction[Uml]] = for {e <- c} yield umlClearAssociationAction(e)
	implicit def umlClearAssociationAction(c: Seq[Uml#ClearAssociationAction]): Seq[UMLClearAssociationAction[Uml]] = for {e <- c} yield umlClearAssociationAction(e)
	implicit def umlClearAssociationAction(c: Set[Uml#ClearAssociationAction]): Set[UMLClearAssociationAction[Uml]] = for {e <- c} yield umlClearAssociationAction(e)

	implicit def umlClearStructuralFeatureAction(e: Uml#ClearStructuralFeatureAction): UMLClearStructuralFeatureAction[Uml]
	implicit def umlClearStructuralFeatureAction(c: Iterable[Uml#ClearStructuralFeatureAction]): Iterable[UMLClearStructuralFeatureAction[Uml]] = for {e <- c} yield umlClearStructuralFeatureAction(e)
	implicit def umlClearStructuralFeatureAction(c: Seq[Uml#ClearStructuralFeatureAction]): Seq[UMLClearStructuralFeatureAction[Uml]] = for {e <- c} yield umlClearStructuralFeatureAction(e)
	implicit def umlClearStructuralFeatureAction(c: Set[Uml#ClearStructuralFeatureAction]): Set[UMLClearStructuralFeatureAction[Uml]] = for {e <- c} yield umlClearStructuralFeatureAction(e)

	implicit def umlClearVariableAction(e: Uml#ClearVariableAction): UMLClearVariableAction[Uml]
	implicit def umlClearVariableAction(c: Iterable[Uml#ClearVariableAction]): Iterable[UMLClearVariableAction[Uml]] = for {e <- c} yield umlClearVariableAction(e)
	implicit def umlClearVariableAction(c: Seq[Uml#ClearVariableAction]): Seq[UMLClearVariableAction[Uml]] = for {e <- c} yield umlClearVariableAction(e)
	implicit def umlClearVariableAction(c: Set[Uml#ClearVariableAction]): Set[UMLClearVariableAction[Uml]] = for {e <- c} yield umlClearVariableAction(e)

	implicit def umlCollaboration(e: Uml#Collaboration): UMLCollaboration[Uml]
	implicit def umlCollaboration(c: Iterable[Uml#Collaboration]): Iterable[UMLCollaboration[Uml]] = for {e <- c} yield umlCollaboration(e)
	implicit def umlCollaboration(c: Seq[Uml#Collaboration]): Seq[UMLCollaboration[Uml]] = for {e <- c} yield umlCollaboration(e)
	implicit def umlCollaboration(c: Set[Uml#Collaboration]): Set[UMLCollaboration[Uml]] = for {e <- c} yield umlCollaboration(e)

	implicit def umlCollaborationUse(e: Uml#CollaborationUse): UMLCollaborationUse[Uml]
	implicit def umlCollaborationUse(c: Iterable[Uml#CollaborationUse]): Iterable[UMLCollaborationUse[Uml]] = for {e <- c} yield umlCollaborationUse(e)
	implicit def umlCollaborationUse(c: Seq[Uml#CollaborationUse]): Seq[UMLCollaborationUse[Uml]] = for {e <- c} yield umlCollaborationUse(e)
	implicit def umlCollaborationUse(c: Set[Uml#CollaborationUse]): Set[UMLCollaborationUse[Uml]] = for {e <- c} yield umlCollaborationUse(e)

	implicit def umlCombinedFragment(e: Uml#CombinedFragment): UMLCombinedFragment[Uml]
	implicit def umlCombinedFragment(c: Iterable[Uml#CombinedFragment]): Iterable[UMLCombinedFragment[Uml]] = for {e <- c} yield umlCombinedFragment(e)
	implicit def umlCombinedFragment(c: Seq[Uml#CombinedFragment]): Seq[UMLCombinedFragment[Uml]] = for {e <- c} yield umlCombinedFragment(e)
	implicit def umlCombinedFragment(c: Set[Uml#CombinedFragment]): Set[UMLCombinedFragment[Uml]] = for {e <- c} yield umlCombinedFragment(e)

	implicit def umlComment(e: Uml#Comment): UMLComment[Uml]
	implicit def umlComment(c: Iterable[Uml#Comment]): Iterable[UMLComment[Uml]] = for {e <- c} yield umlComment(e)
	implicit def umlComment(c: Seq[Uml#Comment]): Seq[UMLComment[Uml]] = for {e <- c} yield umlComment(e)
	implicit def umlComment(c: Set[Uml#Comment]): Set[UMLComment[Uml]] = for {e <- c} yield umlComment(e)

	implicit def umlCommunicationPath(e: Uml#CommunicationPath): UMLCommunicationPath[Uml]
	implicit def umlCommunicationPath(c: Iterable[Uml#CommunicationPath]): Iterable[UMLCommunicationPath[Uml]] = for {e <- c} yield umlCommunicationPath(e)
	implicit def umlCommunicationPath(c: Seq[Uml#CommunicationPath]): Seq[UMLCommunicationPath[Uml]] = for {e <- c} yield umlCommunicationPath(e)
	implicit def umlCommunicationPath(c: Set[Uml#CommunicationPath]): Set[UMLCommunicationPath[Uml]] = for {e <- c} yield umlCommunicationPath(e)

	implicit def umlComponent(e: Uml#Component): UMLComponent[Uml]
	implicit def umlComponent(c: Iterable[Uml#Component]): Iterable[UMLComponent[Uml]] = for {e <- c} yield umlComponent(e)
	implicit def umlComponent(c: Seq[Uml#Component]): Seq[UMLComponent[Uml]] = for {e <- c} yield umlComponent(e)
	implicit def umlComponent(c: Set[Uml#Component]): Set[UMLComponent[Uml]] = for {e <- c} yield umlComponent(e)

	implicit def umlComponentRealization(e: Uml#ComponentRealization): UMLComponentRealization[Uml]
	implicit def umlComponentRealization(c: Iterable[Uml#ComponentRealization]): Iterable[UMLComponentRealization[Uml]] = for {e <- c} yield umlComponentRealization(e)
	implicit def umlComponentRealization(c: Seq[Uml#ComponentRealization]): Seq[UMLComponentRealization[Uml]] = for {e <- c} yield umlComponentRealization(e)
	implicit def umlComponentRealization(c: Set[Uml#ComponentRealization]): Set[UMLComponentRealization[Uml]] = for {e <- c} yield umlComponentRealization(e)

	implicit def umlConditionalNode(e: Uml#ConditionalNode): UMLConditionalNode[Uml]
	implicit def umlConditionalNode(c: Iterable[Uml#ConditionalNode]): Iterable[UMLConditionalNode[Uml]] = for {e <- c} yield umlConditionalNode(e)
	implicit def umlConditionalNode(c: Seq[Uml#ConditionalNode]): Seq[UMLConditionalNode[Uml]] = for {e <- c} yield umlConditionalNode(e)
	implicit def umlConditionalNode(c: Set[Uml#ConditionalNode]): Set[UMLConditionalNode[Uml]] = for {e <- c} yield umlConditionalNode(e)

	implicit def umlConnectableElement(e: Uml#ConnectableElement): UMLConnectableElement[Uml]
	implicit def umlConnectableElement(c: Iterable[Uml#ConnectableElement]): Iterable[UMLConnectableElement[Uml]] = for {e <- c} yield umlConnectableElement(e)
	implicit def umlConnectableElement(c: Seq[Uml#ConnectableElement]): Seq[UMLConnectableElement[Uml]] = for {e <- c} yield umlConnectableElement(e)
	implicit def umlConnectableElement(c: Set[Uml#ConnectableElement]): Set[UMLConnectableElement[Uml]] = for {e <- c} yield umlConnectableElement(e)

	implicit def umlConnectableElementTemplateParameter(e: Uml#ConnectableElementTemplateParameter): UMLConnectableElementTemplateParameter[Uml]
	implicit def umlConnectableElementTemplateParameter(c: Iterable[Uml#ConnectableElementTemplateParameter]): Iterable[UMLConnectableElementTemplateParameter[Uml]] = for {e <- c} yield umlConnectableElementTemplateParameter(e)
	implicit def umlConnectableElementTemplateParameter(c: Seq[Uml#ConnectableElementTemplateParameter]): Seq[UMLConnectableElementTemplateParameter[Uml]] = for {e <- c} yield umlConnectableElementTemplateParameter(e)
	implicit def umlConnectableElementTemplateParameter(c: Set[Uml#ConnectableElementTemplateParameter]): Set[UMLConnectableElementTemplateParameter[Uml]] = for {e <- c} yield umlConnectableElementTemplateParameter(e)

	implicit def umlConnectionPointReference(e: Uml#ConnectionPointReference): UMLConnectionPointReference[Uml]
	implicit def umlConnectionPointReference(c: Iterable[Uml#ConnectionPointReference]): Iterable[UMLConnectionPointReference[Uml]] = for {e <- c} yield umlConnectionPointReference(e)
	implicit def umlConnectionPointReference(c: Seq[Uml#ConnectionPointReference]): Seq[UMLConnectionPointReference[Uml]] = for {e <- c} yield umlConnectionPointReference(e)
	implicit def umlConnectionPointReference(c: Set[Uml#ConnectionPointReference]): Set[UMLConnectionPointReference[Uml]] = for {e <- c} yield umlConnectionPointReference(e)

	implicit def umlConnector(e: Uml#Connector): UMLConnector[Uml]
	implicit def umlConnector(c: Iterable[Uml#Connector]): Iterable[UMLConnector[Uml]] = for {e <- c} yield umlConnector(e)
	implicit def umlConnector(c: Seq[Uml#Connector]): Seq[UMLConnector[Uml]] = for {e <- c} yield umlConnector(e)
	implicit def umlConnector(c: Set[Uml#Connector]): Set[UMLConnector[Uml]] = for {e <- c} yield umlConnector(e)

	implicit def umlConnectorEnd(e: Uml#ConnectorEnd): UMLConnectorEnd[Uml]
	implicit def umlConnectorEnd(c: Iterable[Uml#ConnectorEnd]): Iterable[UMLConnectorEnd[Uml]] = for {e <- c} yield umlConnectorEnd(e)
	implicit def umlConnectorEnd(c: Seq[Uml#ConnectorEnd]): Seq[UMLConnectorEnd[Uml]] = for {e <- c} yield umlConnectorEnd(e)
	implicit def umlConnectorEnd(c: Set[Uml#ConnectorEnd]): Set[UMLConnectorEnd[Uml]] = for {e <- c} yield umlConnectorEnd(e)

	implicit def umlConsiderIgnoreFragment(e: Uml#ConsiderIgnoreFragment): UMLConsiderIgnoreFragment[Uml]
	implicit def umlConsiderIgnoreFragment(c: Iterable[Uml#ConsiderIgnoreFragment]): Iterable[UMLConsiderIgnoreFragment[Uml]] = for {e <- c} yield umlConsiderIgnoreFragment(e)
	implicit def umlConsiderIgnoreFragment(c: Seq[Uml#ConsiderIgnoreFragment]): Seq[UMLConsiderIgnoreFragment[Uml]] = for {e <- c} yield umlConsiderIgnoreFragment(e)
	implicit def umlConsiderIgnoreFragment(c: Set[Uml#ConsiderIgnoreFragment]): Set[UMLConsiderIgnoreFragment[Uml]] = for {e <- c} yield umlConsiderIgnoreFragment(e)

	implicit def umlConstraint(e: Uml#Constraint): UMLConstraint[Uml]
	implicit def umlConstraint(c: Iterable[Uml#Constraint]): Iterable[UMLConstraint[Uml]] = for {e <- c} yield umlConstraint(e)
	implicit def umlConstraint(c: Seq[Uml#Constraint]): Seq[UMLConstraint[Uml]] = for {e <- c} yield umlConstraint(e)
	implicit def umlConstraint(c: Set[Uml#Constraint]): Set[UMLConstraint[Uml]] = for {e <- c} yield umlConstraint(e)

	implicit def umlContinuation(e: Uml#Continuation): UMLContinuation[Uml]
	implicit def umlContinuation(c: Iterable[Uml#Continuation]): Iterable[UMLContinuation[Uml]] = for {e <- c} yield umlContinuation(e)
	implicit def umlContinuation(c: Seq[Uml#Continuation]): Seq[UMLContinuation[Uml]] = for {e <- c} yield umlContinuation(e)
	implicit def umlContinuation(c: Set[Uml#Continuation]): Set[UMLContinuation[Uml]] = for {e <- c} yield umlContinuation(e)

	implicit def umlControlFlow(e: Uml#ControlFlow): UMLControlFlow[Uml]
	implicit def umlControlFlow(c: Iterable[Uml#ControlFlow]): Iterable[UMLControlFlow[Uml]] = for {e <- c} yield umlControlFlow(e)
	implicit def umlControlFlow(c: Seq[Uml#ControlFlow]): Seq[UMLControlFlow[Uml]] = for {e <- c} yield umlControlFlow(e)
	implicit def umlControlFlow(c: Set[Uml#ControlFlow]): Set[UMLControlFlow[Uml]] = for {e <- c} yield umlControlFlow(e)

	implicit def umlControlNode(e: Uml#ControlNode): UMLControlNode[Uml]
	implicit def umlControlNode(c: Iterable[Uml#ControlNode]): Iterable[UMLControlNode[Uml]] = for {e <- c} yield umlControlNode(e)
	implicit def umlControlNode(c: Seq[Uml#ControlNode]): Seq[UMLControlNode[Uml]] = for {e <- c} yield umlControlNode(e)
	implicit def umlControlNode(c: Set[Uml#ControlNode]): Set[UMLControlNode[Uml]] = for {e <- c} yield umlControlNode(e)

	implicit def umlCreateLinkAction(e: Uml#CreateLinkAction): UMLCreateLinkAction[Uml]
	implicit def umlCreateLinkAction(c: Iterable[Uml#CreateLinkAction]): Iterable[UMLCreateLinkAction[Uml]] = for {e <- c} yield umlCreateLinkAction(e)
	implicit def umlCreateLinkAction(c: Seq[Uml#CreateLinkAction]): Seq[UMLCreateLinkAction[Uml]] = for {e <- c} yield umlCreateLinkAction(e)
	implicit def umlCreateLinkAction(c: Set[Uml#CreateLinkAction]): Set[UMLCreateLinkAction[Uml]] = for {e <- c} yield umlCreateLinkAction(e)

	implicit def umlCreateLinkObjectAction(e: Uml#CreateLinkObjectAction): UMLCreateLinkObjectAction[Uml]
	implicit def umlCreateLinkObjectAction(c: Iterable[Uml#CreateLinkObjectAction]): Iterable[UMLCreateLinkObjectAction[Uml]] = for {e <- c} yield umlCreateLinkObjectAction(e)
	implicit def umlCreateLinkObjectAction(c: Seq[Uml#CreateLinkObjectAction]): Seq[UMLCreateLinkObjectAction[Uml]] = for {e <- c} yield umlCreateLinkObjectAction(e)
	implicit def umlCreateLinkObjectAction(c: Set[Uml#CreateLinkObjectAction]): Set[UMLCreateLinkObjectAction[Uml]] = for {e <- c} yield umlCreateLinkObjectAction(e)

	implicit def umlCreateObjectAction(e: Uml#CreateObjectAction): UMLCreateObjectAction[Uml]
	implicit def umlCreateObjectAction(c: Iterable[Uml#CreateObjectAction]): Iterable[UMLCreateObjectAction[Uml]] = for {e <- c} yield umlCreateObjectAction(e)
	implicit def umlCreateObjectAction(c: Seq[Uml#CreateObjectAction]): Seq[UMLCreateObjectAction[Uml]] = for {e <- c} yield umlCreateObjectAction(e)
	implicit def umlCreateObjectAction(c: Set[Uml#CreateObjectAction]): Set[UMLCreateObjectAction[Uml]] = for {e <- c} yield umlCreateObjectAction(e)

	implicit def umlDataStoreNode(e: Uml#DataStoreNode): UMLDataStoreNode[Uml]
	implicit def umlDataStoreNode(c: Iterable[Uml#DataStoreNode]): Iterable[UMLDataStoreNode[Uml]] = for {e <- c} yield umlDataStoreNode(e)
	implicit def umlDataStoreNode(c: Seq[Uml#DataStoreNode]): Seq[UMLDataStoreNode[Uml]] = for {e <- c} yield umlDataStoreNode(e)
	implicit def umlDataStoreNode(c: Set[Uml#DataStoreNode]): Set[UMLDataStoreNode[Uml]] = for {e <- c} yield umlDataStoreNode(e)

	implicit def umlDataType(e: Uml#DataType): UMLDataType[Uml]
	implicit def umlDataType(c: Iterable[Uml#DataType]): Iterable[UMLDataType[Uml]] = for {e <- c} yield umlDataType(e)
	implicit def umlDataType(c: Seq[Uml#DataType]): Seq[UMLDataType[Uml]] = for {e <- c} yield umlDataType(e)
	implicit def umlDataType(c: Set[Uml#DataType]): Set[UMLDataType[Uml]] = for {e <- c} yield umlDataType(e)

	implicit def umlDecisionNode(e: Uml#DecisionNode): UMLDecisionNode[Uml]
	implicit def umlDecisionNode(c: Iterable[Uml#DecisionNode]): Iterable[UMLDecisionNode[Uml]] = for {e <- c} yield umlDecisionNode(e)
	implicit def umlDecisionNode(c: Seq[Uml#DecisionNode]): Seq[UMLDecisionNode[Uml]] = for {e <- c} yield umlDecisionNode(e)
	implicit def umlDecisionNode(c: Set[Uml#DecisionNode]): Set[UMLDecisionNode[Uml]] = for {e <- c} yield umlDecisionNode(e)

	implicit def umlDependency(e: Uml#Dependency): UMLDependency[Uml]
	implicit def umlDependency(c: Iterable[Uml#Dependency]): Iterable[UMLDependency[Uml]] = for {e <- c} yield umlDependency(e)
	implicit def umlDependency(c: Seq[Uml#Dependency]): Seq[UMLDependency[Uml]] = for {e <- c} yield umlDependency(e)
	implicit def umlDependency(c: Set[Uml#Dependency]): Set[UMLDependency[Uml]] = for {e <- c} yield umlDependency(e)

	implicit def umlDeployedArtifact(e: Uml#DeployedArtifact): UMLDeployedArtifact[Uml]
	implicit def umlDeployedArtifact(c: Iterable[Uml#DeployedArtifact]): Iterable[UMLDeployedArtifact[Uml]] = for {e <- c} yield umlDeployedArtifact(e)
	implicit def umlDeployedArtifact(c: Seq[Uml#DeployedArtifact]): Seq[UMLDeployedArtifact[Uml]] = for {e <- c} yield umlDeployedArtifact(e)
	implicit def umlDeployedArtifact(c: Set[Uml#DeployedArtifact]): Set[UMLDeployedArtifact[Uml]] = for {e <- c} yield umlDeployedArtifact(e)

	implicit def umlDeployment(e: Uml#Deployment): UMLDeployment[Uml]
	implicit def umlDeployment(c: Iterable[Uml#Deployment]): Iterable[UMLDeployment[Uml]] = for {e <- c} yield umlDeployment(e)
	implicit def umlDeployment(c: Seq[Uml#Deployment]): Seq[UMLDeployment[Uml]] = for {e <- c} yield umlDeployment(e)
	implicit def umlDeployment(c: Set[Uml#Deployment]): Set[UMLDeployment[Uml]] = for {e <- c} yield umlDeployment(e)

	implicit def umlDeploymentSpecification(e: Uml#DeploymentSpecification): UMLDeploymentSpecification[Uml]
	implicit def umlDeploymentSpecification(c: Iterable[Uml#DeploymentSpecification]): Iterable[UMLDeploymentSpecification[Uml]] = for {e <- c} yield umlDeploymentSpecification(e)
	implicit def umlDeploymentSpecification(c: Seq[Uml#DeploymentSpecification]): Seq[UMLDeploymentSpecification[Uml]] = for {e <- c} yield umlDeploymentSpecification(e)
	implicit def umlDeploymentSpecification(c: Set[Uml#DeploymentSpecification]): Set[UMLDeploymentSpecification[Uml]] = for {e <- c} yield umlDeploymentSpecification(e)

	implicit def umlDeploymentTarget(e: Uml#DeploymentTarget): UMLDeploymentTarget[Uml]
	implicit def umlDeploymentTarget(c: Iterable[Uml#DeploymentTarget]): Iterable[UMLDeploymentTarget[Uml]] = for {e <- c} yield umlDeploymentTarget(e)
	implicit def umlDeploymentTarget(c: Seq[Uml#DeploymentTarget]): Seq[UMLDeploymentTarget[Uml]] = for {e <- c} yield umlDeploymentTarget(e)
	implicit def umlDeploymentTarget(c: Set[Uml#DeploymentTarget]): Set[UMLDeploymentTarget[Uml]] = for {e <- c} yield umlDeploymentTarget(e)

	implicit def umlDestroyLinkAction(e: Uml#DestroyLinkAction): UMLDestroyLinkAction[Uml]
	implicit def umlDestroyLinkAction(c: Iterable[Uml#DestroyLinkAction]): Iterable[UMLDestroyLinkAction[Uml]] = for {e <- c} yield umlDestroyLinkAction(e)
	implicit def umlDestroyLinkAction(c: Seq[Uml#DestroyLinkAction]): Seq[UMLDestroyLinkAction[Uml]] = for {e <- c} yield umlDestroyLinkAction(e)
	implicit def umlDestroyLinkAction(c: Set[Uml#DestroyLinkAction]): Set[UMLDestroyLinkAction[Uml]] = for {e <- c} yield umlDestroyLinkAction(e)

	implicit def umlDestroyObjectAction(e: Uml#DestroyObjectAction): UMLDestroyObjectAction[Uml]
	implicit def umlDestroyObjectAction(c: Iterable[Uml#DestroyObjectAction]): Iterable[UMLDestroyObjectAction[Uml]] = for {e <- c} yield umlDestroyObjectAction(e)
	implicit def umlDestroyObjectAction(c: Seq[Uml#DestroyObjectAction]): Seq[UMLDestroyObjectAction[Uml]] = for {e <- c} yield umlDestroyObjectAction(e)
	implicit def umlDestroyObjectAction(c: Set[Uml#DestroyObjectAction]): Set[UMLDestroyObjectAction[Uml]] = for {e <- c} yield umlDestroyObjectAction(e)

	implicit def umlDestructionOccurrenceSpecification(e: Uml#DestructionOccurrenceSpecification): UMLDestructionOccurrenceSpecification[Uml]
	implicit def umlDestructionOccurrenceSpecification(c: Iterable[Uml#DestructionOccurrenceSpecification]): Iterable[UMLDestructionOccurrenceSpecification[Uml]] = for {e <- c} yield umlDestructionOccurrenceSpecification(e)
	implicit def umlDestructionOccurrenceSpecification(c: Seq[Uml#DestructionOccurrenceSpecification]): Seq[UMLDestructionOccurrenceSpecification[Uml]] = for {e <- c} yield umlDestructionOccurrenceSpecification(e)
	implicit def umlDestructionOccurrenceSpecification(c: Set[Uml#DestructionOccurrenceSpecification]): Set[UMLDestructionOccurrenceSpecification[Uml]] = for {e <- c} yield umlDestructionOccurrenceSpecification(e)

	implicit def umlDevice(e: Uml#Device): UMLDevice[Uml]
	implicit def umlDevice(c: Iterable[Uml#Device]): Iterable[UMLDevice[Uml]] = for {e <- c} yield umlDevice(e)
	implicit def umlDevice(c: Seq[Uml#Device]): Seq[UMLDevice[Uml]] = for {e <- c} yield umlDevice(e)
	implicit def umlDevice(c: Set[Uml#Device]): Set[UMLDevice[Uml]] = for {e <- c} yield umlDevice(e)

	implicit def umlDirectedRelationship(e: Uml#DirectedRelationship): UMLDirectedRelationship[Uml]
	implicit def umlDirectedRelationship(c: Iterable[Uml#DirectedRelationship]): Iterable[UMLDirectedRelationship[Uml]] = for {e <- c} yield umlDirectedRelationship(e)
	implicit def umlDirectedRelationship(c: Seq[Uml#DirectedRelationship]): Seq[UMLDirectedRelationship[Uml]] = for {e <- c} yield umlDirectedRelationship(e)
	implicit def umlDirectedRelationship(c: Set[Uml#DirectedRelationship]): Set[UMLDirectedRelationship[Uml]] = for {e <- c} yield umlDirectedRelationship(e)

	implicit def umlDuration(e: Uml#Duration): UMLDuration[Uml]
	implicit def umlDuration(c: Iterable[Uml#Duration]): Iterable[UMLDuration[Uml]] = for {e <- c} yield umlDuration(e)
	implicit def umlDuration(c: Seq[Uml#Duration]): Seq[UMLDuration[Uml]] = for {e <- c} yield umlDuration(e)
	implicit def umlDuration(c: Set[Uml#Duration]): Set[UMLDuration[Uml]] = for {e <- c} yield umlDuration(e)

	implicit def umlDurationConstraint(e: Uml#DurationConstraint): UMLDurationConstraint[Uml]
	implicit def umlDurationConstraint(c: Iterable[Uml#DurationConstraint]): Iterable[UMLDurationConstraint[Uml]] = for {e <- c} yield umlDurationConstraint(e)
	implicit def umlDurationConstraint(c: Seq[Uml#DurationConstraint]): Seq[UMLDurationConstraint[Uml]] = for {e <- c} yield umlDurationConstraint(e)
	implicit def umlDurationConstraint(c: Set[Uml#DurationConstraint]): Set[UMLDurationConstraint[Uml]] = for {e <- c} yield umlDurationConstraint(e)

	implicit def umlDurationInterval(e: Uml#DurationInterval): UMLDurationInterval[Uml]
	implicit def umlDurationInterval(c: Iterable[Uml#DurationInterval]): Iterable[UMLDurationInterval[Uml]] = for {e <- c} yield umlDurationInterval(e)
	implicit def umlDurationInterval(c: Seq[Uml#DurationInterval]): Seq[UMLDurationInterval[Uml]] = for {e <- c} yield umlDurationInterval(e)
	implicit def umlDurationInterval(c: Set[Uml#DurationInterval]): Set[UMLDurationInterval[Uml]] = for {e <- c} yield umlDurationInterval(e)

	implicit def umlDurationObservation(e: Uml#DurationObservation): UMLDurationObservation[Uml]
	implicit def umlDurationObservation(c: Iterable[Uml#DurationObservation]): Iterable[UMLDurationObservation[Uml]] = for {e <- c} yield umlDurationObservation(e)
	implicit def umlDurationObservation(c: Seq[Uml#DurationObservation]): Seq[UMLDurationObservation[Uml]] = for {e <- c} yield umlDurationObservation(e)
	implicit def umlDurationObservation(c: Set[Uml#DurationObservation]): Set[UMLDurationObservation[Uml]] = for {e <- c} yield umlDurationObservation(e)

	implicit def umlElement(e: Uml#Element): UMLElement[Uml]
	implicit def umlElement(c: Iterable[Uml#Element]): Iterable[UMLElement[Uml]] = for {e <- c} yield umlElement(e)
	implicit def umlElement(c: Seq[Uml#Element]): Seq[UMLElement[Uml]] = for {e <- c} yield umlElement(e)
	implicit def umlElement(c: Set[Uml#Element]): Set[UMLElement[Uml]] = for {e <- c} yield umlElement(e)

	implicit def umlElementImport(e: Uml#ElementImport): UMLElementImport[Uml]
	implicit def umlElementImport(c: Iterable[Uml#ElementImport]): Iterable[UMLElementImport[Uml]] = for {e <- c} yield umlElementImport(e)
	implicit def umlElementImport(c: Seq[Uml#ElementImport]): Seq[UMLElementImport[Uml]] = for {e <- c} yield umlElementImport(e)
	implicit def umlElementImport(c: Set[Uml#ElementImport]): Set[UMLElementImport[Uml]] = for {e <- c} yield umlElementImport(e)

	implicit def umlEncapsulatedClassifier(e: Uml#EncapsulatedClassifier): UMLEncapsulatedClassifier[Uml]
	implicit def umlEncapsulatedClassifier(c: Iterable[Uml#EncapsulatedClassifier]): Iterable[UMLEncapsulatedClassifier[Uml]] = for {e <- c} yield umlEncapsulatedClassifier(e)
	implicit def umlEncapsulatedClassifier(c: Seq[Uml#EncapsulatedClassifier]): Seq[UMLEncapsulatedClassifier[Uml]] = for {e <- c} yield umlEncapsulatedClassifier(e)
	implicit def umlEncapsulatedClassifier(c: Set[Uml#EncapsulatedClassifier]): Set[UMLEncapsulatedClassifier[Uml]] = for {e <- c} yield umlEncapsulatedClassifier(e)

	implicit def umlEnumeration(e: Uml#Enumeration): UMLEnumeration[Uml]
	implicit def umlEnumeration(c: Iterable[Uml#Enumeration]): Iterable[UMLEnumeration[Uml]] = for {e <- c} yield umlEnumeration(e)
	implicit def umlEnumeration(c: Seq[Uml#Enumeration]): Seq[UMLEnumeration[Uml]] = for {e <- c} yield umlEnumeration(e)
	implicit def umlEnumeration(c: Set[Uml#Enumeration]): Set[UMLEnumeration[Uml]] = for {e <- c} yield umlEnumeration(e)

	implicit def umlEnumerationLiteral(e: Uml#EnumerationLiteral): UMLEnumerationLiteral[Uml]
	implicit def umlEnumerationLiteral(c: Iterable[Uml#EnumerationLiteral]): Iterable[UMLEnumerationLiteral[Uml]] = for {e <- c} yield umlEnumerationLiteral(e)
	implicit def umlEnumerationLiteral(c: Seq[Uml#EnumerationLiteral]): Seq[UMLEnumerationLiteral[Uml]] = for {e <- c} yield umlEnumerationLiteral(e)
	implicit def umlEnumerationLiteral(c: Set[Uml#EnumerationLiteral]): Set[UMLEnumerationLiteral[Uml]] = for {e <- c} yield umlEnumerationLiteral(e)

	implicit def umlEvent(e: Uml#Event): UMLEvent[Uml]
	implicit def umlEvent(c: Iterable[Uml#Event]): Iterable[UMLEvent[Uml]] = for {e <- c} yield umlEvent(e)
	implicit def umlEvent(c: Seq[Uml#Event]): Seq[UMLEvent[Uml]] = for {e <- c} yield umlEvent(e)
	implicit def umlEvent(c: Set[Uml#Event]): Set[UMLEvent[Uml]] = for {e <- c} yield umlEvent(e)

	implicit def umlExceptionHandler(e: Uml#ExceptionHandler): UMLExceptionHandler[Uml]
	implicit def umlExceptionHandler(c: Iterable[Uml#ExceptionHandler]): Iterable[UMLExceptionHandler[Uml]] = for {e <- c} yield umlExceptionHandler(e)
	implicit def umlExceptionHandler(c: Seq[Uml#ExceptionHandler]): Seq[UMLExceptionHandler[Uml]] = for {e <- c} yield umlExceptionHandler(e)
	implicit def umlExceptionHandler(c: Set[Uml#ExceptionHandler]): Set[UMLExceptionHandler[Uml]] = for {e <- c} yield umlExceptionHandler(e)

	implicit def umlExecutableNode(e: Uml#ExecutableNode): UMLExecutableNode[Uml]
	implicit def umlExecutableNode(c: Iterable[Uml#ExecutableNode]): Iterable[UMLExecutableNode[Uml]] = for {e <- c} yield umlExecutableNode(e)
	implicit def umlExecutableNode(c: Seq[Uml#ExecutableNode]): Seq[UMLExecutableNode[Uml]] = for {e <- c} yield umlExecutableNode(e)
	implicit def umlExecutableNode(c: Set[Uml#ExecutableNode]): Set[UMLExecutableNode[Uml]] = for {e <- c} yield umlExecutableNode(e)

	implicit def umlExecutionEnvironment(e: Uml#ExecutionEnvironment): UMLExecutionEnvironment[Uml]
	implicit def umlExecutionEnvironment(c: Iterable[Uml#ExecutionEnvironment]): Iterable[UMLExecutionEnvironment[Uml]] = for {e <- c} yield umlExecutionEnvironment(e)
	implicit def umlExecutionEnvironment(c: Seq[Uml#ExecutionEnvironment]): Seq[UMLExecutionEnvironment[Uml]] = for {e <- c} yield umlExecutionEnvironment(e)
	implicit def umlExecutionEnvironment(c: Set[Uml#ExecutionEnvironment]): Set[UMLExecutionEnvironment[Uml]] = for {e <- c} yield umlExecutionEnvironment(e)

	implicit def umlExecutionOccurrenceSpecification(e: Uml#ExecutionOccurrenceSpecification): UMLExecutionOccurrenceSpecification[Uml]
	implicit def umlExecutionOccurrenceSpecification(c: Iterable[Uml#ExecutionOccurrenceSpecification]): Iterable[UMLExecutionOccurrenceSpecification[Uml]] = for {e <- c} yield umlExecutionOccurrenceSpecification(e)
	implicit def umlExecutionOccurrenceSpecification(c: Seq[Uml#ExecutionOccurrenceSpecification]): Seq[UMLExecutionOccurrenceSpecification[Uml]] = for {e <- c} yield umlExecutionOccurrenceSpecification(e)
	implicit def umlExecutionOccurrenceSpecification(c: Set[Uml#ExecutionOccurrenceSpecification]): Set[UMLExecutionOccurrenceSpecification[Uml]] = for {e <- c} yield umlExecutionOccurrenceSpecification(e)

	implicit def umlExecutionSpecification(e: Uml#ExecutionSpecification): UMLExecutionSpecification[Uml]
	implicit def umlExecutionSpecification(c: Iterable[Uml#ExecutionSpecification]): Iterable[UMLExecutionSpecification[Uml]] = for {e <- c} yield umlExecutionSpecification(e)
	implicit def umlExecutionSpecification(c: Seq[Uml#ExecutionSpecification]): Seq[UMLExecutionSpecification[Uml]] = for {e <- c} yield umlExecutionSpecification(e)
	implicit def umlExecutionSpecification(c: Set[Uml#ExecutionSpecification]): Set[UMLExecutionSpecification[Uml]] = for {e <- c} yield umlExecutionSpecification(e)

	implicit def umlExpansionNode(e: Uml#ExpansionNode): UMLExpansionNode[Uml]
	implicit def umlExpansionNode(c: Iterable[Uml#ExpansionNode]): Iterable[UMLExpansionNode[Uml]] = for {e <- c} yield umlExpansionNode(e)
	implicit def umlExpansionNode(c: Seq[Uml#ExpansionNode]): Seq[UMLExpansionNode[Uml]] = for {e <- c} yield umlExpansionNode(e)
	implicit def umlExpansionNode(c: Set[Uml#ExpansionNode]): Set[UMLExpansionNode[Uml]] = for {e <- c} yield umlExpansionNode(e)

	implicit def umlExpansionRegion(e: Uml#ExpansionRegion): UMLExpansionRegion[Uml]
	implicit def umlExpansionRegion(c: Iterable[Uml#ExpansionRegion]): Iterable[UMLExpansionRegion[Uml]] = for {e <- c} yield umlExpansionRegion(e)
	implicit def umlExpansionRegion(c: Seq[Uml#ExpansionRegion]): Seq[UMLExpansionRegion[Uml]] = for {e <- c} yield umlExpansionRegion(e)
	implicit def umlExpansionRegion(c: Set[Uml#ExpansionRegion]): Set[UMLExpansionRegion[Uml]] = for {e <- c} yield umlExpansionRegion(e)

	implicit def umlExpression(e: Uml#Expression): UMLExpression[Uml]
	implicit def umlExpression(c: Iterable[Uml#Expression]): Iterable[UMLExpression[Uml]] = for {e <- c} yield umlExpression(e)
	implicit def umlExpression(c: Seq[Uml#Expression]): Seq[UMLExpression[Uml]] = for {e <- c} yield umlExpression(e)
	implicit def umlExpression(c: Set[Uml#Expression]): Set[UMLExpression[Uml]] = for {e <- c} yield umlExpression(e)

	implicit def umlExtend(e: Uml#Extend): UMLExtend[Uml]
	implicit def umlExtend(c: Iterable[Uml#Extend]): Iterable[UMLExtend[Uml]] = for {e <- c} yield umlExtend(e)
	implicit def umlExtend(c: Seq[Uml#Extend]): Seq[UMLExtend[Uml]] = for {e <- c} yield umlExtend(e)
	implicit def umlExtend(c: Set[Uml#Extend]): Set[UMLExtend[Uml]] = for {e <- c} yield umlExtend(e)

	implicit def umlExtension(e: Uml#Extension): UMLExtension[Uml]
	implicit def umlExtension(c: Iterable[Uml#Extension]): Iterable[UMLExtension[Uml]] = for {e <- c} yield umlExtension(e)
	implicit def umlExtension(c: Seq[Uml#Extension]): Seq[UMLExtension[Uml]] = for {e <- c} yield umlExtension(e)
	implicit def umlExtension(c: Set[Uml#Extension]): Set[UMLExtension[Uml]] = for {e <- c} yield umlExtension(e)

	implicit def umlExtensionEnd(e: Uml#ExtensionEnd): UMLExtensionEnd[Uml]
	implicit def umlExtensionEnd(c: Iterable[Uml#ExtensionEnd]): Iterable[UMLExtensionEnd[Uml]] = for {e <- c} yield umlExtensionEnd(e)
	implicit def umlExtensionEnd(c: Seq[Uml#ExtensionEnd]): Seq[UMLExtensionEnd[Uml]] = for {e <- c} yield umlExtensionEnd(e)
	implicit def umlExtensionEnd(c: Set[Uml#ExtensionEnd]): Set[UMLExtensionEnd[Uml]] = for {e <- c} yield umlExtensionEnd(e)

	implicit def umlExtensionPoint(e: Uml#ExtensionPoint): UMLExtensionPoint[Uml]
	implicit def umlExtensionPoint(c: Iterable[Uml#ExtensionPoint]): Iterable[UMLExtensionPoint[Uml]] = for {e <- c} yield umlExtensionPoint(e)
	implicit def umlExtensionPoint(c: Seq[Uml#ExtensionPoint]): Seq[UMLExtensionPoint[Uml]] = for {e <- c} yield umlExtensionPoint(e)
	implicit def umlExtensionPoint(c: Set[Uml#ExtensionPoint]): Set[UMLExtensionPoint[Uml]] = for {e <- c} yield umlExtensionPoint(e)

	implicit def umlFeature(e: Uml#Feature): UMLFeature[Uml]
	implicit def umlFeature(c: Iterable[Uml#Feature]): Iterable[UMLFeature[Uml]] = for {e <- c} yield umlFeature(e)
	implicit def umlFeature(c: Seq[Uml#Feature]): Seq[UMLFeature[Uml]] = for {e <- c} yield umlFeature(e)
	implicit def umlFeature(c: Set[Uml#Feature]): Set[UMLFeature[Uml]] = for {e <- c} yield umlFeature(e)

	implicit def umlFinalNode(e: Uml#FinalNode): UMLFinalNode[Uml]
	implicit def umlFinalNode(c: Iterable[Uml#FinalNode]): Iterable[UMLFinalNode[Uml]] = for {e <- c} yield umlFinalNode(e)
	implicit def umlFinalNode(c: Seq[Uml#FinalNode]): Seq[UMLFinalNode[Uml]] = for {e <- c} yield umlFinalNode(e)
	implicit def umlFinalNode(c: Set[Uml#FinalNode]): Set[UMLFinalNode[Uml]] = for {e <- c} yield umlFinalNode(e)

	implicit def umlFinalState(e: Uml#FinalState): UMLFinalState[Uml]
	implicit def umlFinalState(c: Iterable[Uml#FinalState]): Iterable[UMLFinalState[Uml]] = for {e <- c} yield umlFinalState(e)
	implicit def umlFinalState(c: Seq[Uml#FinalState]): Seq[UMLFinalState[Uml]] = for {e <- c} yield umlFinalState(e)
	implicit def umlFinalState(c: Set[Uml#FinalState]): Set[UMLFinalState[Uml]] = for {e <- c} yield umlFinalState(e)

	implicit def umlFlowFinalNode(e: Uml#FlowFinalNode): UMLFlowFinalNode[Uml]
	implicit def umlFlowFinalNode(c: Iterable[Uml#FlowFinalNode]): Iterable[UMLFlowFinalNode[Uml]] = for {e <- c} yield umlFlowFinalNode(e)
	implicit def umlFlowFinalNode(c: Seq[Uml#FlowFinalNode]): Seq[UMLFlowFinalNode[Uml]] = for {e <- c} yield umlFlowFinalNode(e)
	implicit def umlFlowFinalNode(c: Set[Uml#FlowFinalNode]): Set[UMLFlowFinalNode[Uml]] = for {e <- c} yield umlFlowFinalNode(e)

	implicit def umlForkNode(e: Uml#ForkNode): UMLForkNode[Uml]
	implicit def umlForkNode(c: Iterable[Uml#ForkNode]): Iterable[UMLForkNode[Uml]] = for {e <- c} yield umlForkNode(e)
	implicit def umlForkNode(c: Seq[Uml#ForkNode]): Seq[UMLForkNode[Uml]] = for {e <- c} yield umlForkNode(e)
	implicit def umlForkNode(c: Set[Uml#ForkNode]): Set[UMLForkNode[Uml]] = for {e <- c} yield umlForkNode(e)

	implicit def umlFunctionBehavior(e: Uml#FunctionBehavior): UMLFunctionBehavior[Uml]
	implicit def umlFunctionBehavior(c: Iterable[Uml#FunctionBehavior]): Iterable[UMLFunctionBehavior[Uml]] = for {e <- c} yield umlFunctionBehavior(e)
	implicit def umlFunctionBehavior(c: Seq[Uml#FunctionBehavior]): Seq[UMLFunctionBehavior[Uml]] = for {e <- c} yield umlFunctionBehavior(e)
	implicit def umlFunctionBehavior(c: Set[Uml#FunctionBehavior]): Set[UMLFunctionBehavior[Uml]] = for {e <- c} yield umlFunctionBehavior(e)

	implicit def umlGate(e: Uml#Gate): UMLGate[Uml]
	implicit def umlGate(c: Iterable[Uml#Gate]): Iterable[UMLGate[Uml]] = for {e <- c} yield umlGate(e)
	implicit def umlGate(c: Seq[Uml#Gate]): Seq[UMLGate[Uml]] = for {e <- c} yield umlGate(e)
	implicit def umlGate(c: Set[Uml#Gate]): Set[UMLGate[Uml]] = for {e <- c} yield umlGate(e)

	implicit def umlGeneralOrdering(e: Uml#GeneralOrdering): UMLGeneralOrdering[Uml]
	implicit def umlGeneralOrdering(c: Iterable[Uml#GeneralOrdering]): Iterable[UMLGeneralOrdering[Uml]] = for {e <- c} yield umlGeneralOrdering(e)
	implicit def umlGeneralOrdering(c: Seq[Uml#GeneralOrdering]): Seq[UMLGeneralOrdering[Uml]] = for {e <- c} yield umlGeneralOrdering(e)
	implicit def umlGeneralOrdering(c: Set[Uml#GeneralOrdering]): Set[UMLGeneralOrdering[Uml]] = for {e <- c} yield umlGeneralOrdering(e)

	implicit def umlGeneralization(e: Uml#Generalization): UMLGeneralization[Uml]
	implicit def umlGeneralization(c: Iterable[Uml#Generalization]): Iterable[UMLGeneralization[Uml]] = for {e <- c} yield umlGeneralization(e)
	implicit def umlGeneralization(c: Seq[Uml#Generalization]): Seq[UMLGeneralization[Uml]] = for {e <- c} yield umlGeneralization(e)
	implicit def umlGeneralization(c: Set[Uml#Generalization]): Set[UMLGeneralization[Uml]] = for {e <- c} yield umlGeneralization(e)

	implicit def umlGeneralizationSet(e: Uml#GeneralizationSet): UMLGeneralizationSet[Uml]
	implicit def umlGeneralizationSet(c: Iterable[Uml#GeneralizationSet]): Iterable[UMLGeneralizationSet[Uml]] = for {e <- c} yield umlGeneralizationSet(e)
	implicit def umlGeneralizationSet(c: Seq[Uml#GeneralizationSet]): Seq[UMLGeneralizationSet[Uml]] = for {e <- c} yield umlGeneralizationSet(e)
	implicit def umlGeneralizationSet(c: Set[Uml#GeneralizationSet]): Set[UMLGeneralizationSet[Uml]] = for {e <- c} yield umlGeneralizationSet(e)

	implicit def umlImage(e: Uml#Image): UMLImage[Uml]
	implicit def umlImage(c: Iterable[Uml#Image]): Iterable[UMLImage[Uml]] = for {e <- c} yield umlImage(e)
	implicit def umlImage(c: Seq[Uml#Image]): Seq[UMLImage[Uml]] = for {e <- c} yield umlImage(e)
	implicit def umlImage(c: Set[Uml#Image]): Set[UMLImage[Uml]] = for {e <- c} yield umlImage(e)

	implicit def umlInclude(e: Uml#Include): UMLInclude[Uml]
	implicit def umlInclude(c: Iterable[Uml#Include]): Iterable[UMLInclude[Uml]] = for {e <- c} yield umlInclude(e)
	implicit def umlInclude(c: Seq[Uml#Include]): Seq[UMLInclude[Uml]] = for {e <- c} yield umlInclude(e)
	implicit def umlInclude(c: Set[Uml#Include]): Set[UMLInclude[Uml]] = for {e <- c} yield umlInclude(e)

	implicit def umlInformationFlow(e: Uml#InformationFlow): UMLInformationFlow[Uml]
	implicit def umlInformationFlow(c: Iterable[Uml#InformationFlow]): Iterable[UMLInformationFlow[Uml]] = for {e <- c} yield umlInformationFlow(e)
	implicit def umlInformationFlow(c: Seq[Uml#InformationFlow]): Seq[UMLInformationFlow[Uml]] = for {e <- c} yield umlInformationFlow(e)
	implicit def umlInformationFlow(c: Set[Uml#InformationFlow]): Set[UMLInformationFlow[Uml]] = for {e <- c} yield umlInformationFlow(e)

	implicit def umlInformationItem(e: Uml#InformationItem): UMLInformationItem[Uml]
	implicit def umlInformationItem(c: Iterable[Uml#InformationItem]): Iterable[UMLInformationItem[Uml]] = for {e <- c} yield umlInformationItem(e)
	implicit def umlInformationItem(c: Seq[Uml#InformationItem]): Seq[UMLInformationItem[Uml]] = for {e <- c} yield umlInformationItem(e)
	implicit def umlInformationItem(c: Set[Uml#InformationItem]): Set[UMLInformationItem[Uml]] = for {e <- c} yield umlInformationItem(e)

	implicit def umlInitialNode(e: Uml#InitialNode): UMLInitialNode[Uml]
	implicit def umlInitialNode(c: Iterable[Uml#InitialNode]): Iterable[UMLInitialNode[Uml]] = for {e <- c} yield umlInitialNode(e)
	implicit def umlInitialNode(c: Seq[Uml#InitialNode]): Seq[UMLInitialNode[Uml]] = for {e <- c} yield umlInitialNode(e)
	implicit def umlInitialNode(c: Set[Uml#InitialNode]): Set[UMLInitialNode[Uml]] = for {e <- c} yield umlInitialNode(e)

	implicit def umlInputPin(e: Uml#InputPin): UMLInputPin[Uml]
	implicit def umlInputPin(c: Iterable[Uml#InputPin]): Iterable[UMLInputPin[Uml]] = for {e <- c} yield umlInputPin(e)
	implicit def umlInputPin(c: Seq[Uml#InputPin]): Seq[UMLInputPin[Uml]] = for {e <- c} yield umlInputPin(e)
	implicit def umlInputPin(c: Set[Uml#InputPin]): Set[UMLInputPin[Uml]] = for {e <- c} yield umlInputPin(e)

	implicit def umlInstanceSpecification(e: Uml#InstanceSpecification): UMLInstanceSpecification[Uml]
	implicit def umlInstanceSpecification(c: Iterable[Uml#InstanceSpecification]): Iterable[UMLInstanceSpecification[Uml]] = for {e <- c} yield umlInstanceSpecification(e)
	implicit def umlInstanceSpecification(c: Seq[Uml#InstanceSpecification]): Seq[UMLInstanceSpecification[Uml]] = for {e <- c} yield umlInstanceSpecification(e)
	implicit def umlInstanceSpecification(c: Set[Uml#InstanceSpecification]): Set[UMLInstanceSpecification[Uml]] = for {e <- c} yield umlInstanceSpecification(e)

	implicit def umlInstanceValue(e: Uml#InstanceValue): UMLInstanceValue[Uml]
	implicit def umlInstanceValue(c: Iterable[Uml#InstanceValue]): Iterable[UMLInstanceValue[Uml]] = for {e <- c} yield umlInstanceValue(e)
	implicit def umlInstanceValue(c: Seq[Uml#InstanceValue]): Seq[UMLInstanceValue[Uml]] = for {e <- c} yield umlInstanceValue(e)
	implicit def umlInstanceValue(c: Set[Uml#InstanceValue]): Set[UMLInstanceValue[Uml]] = for {e <- c} yield umlInstanceValue(e)

	implicit def umlInteraction(e: Uml#Interaction): UMLInteraction[Uml]
	implicit def umlInteraction(c: Iterable[Uml#Interaction]): Iterable[UMLInteraction[Uml]] = for {e <- c} yield umlInteraction(e)
	implicit def umlInteraction(c: Seq[Uml#Interaction]): Seq[UMLInteraction[Uml]] = for {e <- c} yield umlInteraction(e)
	implicit def umlInteraction(c: Set[Uml#Interaction]): Set[UMLInteraction[Uml]] = for {e <- c} yield umlInteraction(e)

	implicit def umlInteractionConstraint(e: Uml#InteractionConstraint): UMLInteractionConstraint[Uml]
	implicit def umlInteractionConstraint(c: Iterable[Uml#InteractionConstraint]): Iterable[UMLInteractionConstraint[Uml]] = for {e <- c} yield umlInteractionConstraint(e)
	implicit def umlInteractionConstraint(c: Seq[Uml#InteractionConstraint]): Seq[UMLInteractionConstraint[Uml]] = for {e <- c} yield umlInteractionConstraint(e)
	implicit def umlInteractionConstraint(c: Set[Uml#InteractionConstraint]): Set[UMLInteractionConstraint[Uml]] = for {e <- c} yield umlInteractionConstraint(e)

	implicit def umlInteractionFragment(e: Uml#InteractionFragment): UMLInteractionFragment[Uml]
	implicit def umlInteractionFragment(c: Iterable[Uml#InteractionFragment]): Iterable[UMLInteractionFragment[Uml]] = for {e <- c} yield umlInteractionFragment(e)
	implicit def umlInteractionFragment(c: Seq[Uml#InteractionFragment]): Seq[UMLInteractionFragment[Uml]] = for {e <- c} yield umlInteractionFragment(e)
	implicit def umlInteractionFragment(c: Set[Uml#InteractionFragment]): Set[UMLInteractionFragment[Uml]] = for {e <- c} yield umlInteractionFragment(e)

	implicit def umlInteractionOperand(e: Uml#InteractionOperand): UMLInteractionOperand[Uml]
	implicit def umlInteractionOperand(c: Iterable[Uml#InteractionOperand]): Iterable[UMLInteractionOperand[Uml]] = for {e <- c} yield umlInteractionOperand(e)
	implicit def umlInteractionOperand(c: Seq[Uml#InteractionOperand]): Seq[UMLInteractionOperand[Uml]] = for {e <- c} yield umlInteractionOperand(e)
	implicit def umlInteractionOperand(c: Set[Uml#InteractionOperand]): Set[UMLInteractionOperand[Uml]] = for {e <- c} yield umlInteractionOperand(e)

	implicit def umlInteractionUse(e: Uml#InteractionUse): UMLInteractionUse[Uml]
	implicit def umlInteractionUse(c: Iterable[Uml#InteractionUse]): Iterable[UMLInteractionUse[Uml]] = for {e <- c} yield umlInteractionUse(e)
	implicit def umlInteractionUse(c: Seq[Uml#InteractionUse]): Seq[UMLInteractionUse[Uml]] = for {e <- c} yield umlInteractionUse(e)
	implicit def umlInteractionUse(c: Set[Uml#InteractionUse]): Set[UMLInteractionUse[Uml]] = for {e <- c} yield umlInteractionUse(e)

	implicit def umlInterface(e: Uml#Interface): UMLInterface[Uml]
	implicit def umlInterface(c: Iterable[Uml#Interface]): Iterable[UMLInterface[Uml]] = for {e <- c} yield umlInterface(e)
	implicit def umlInterface(c: Seq[Uml#Interface]): Seq[UMLInterface[Uml]] = for {e <- c} yield umlInterface(e)
	implicit def umlInterface(c: Set[Uml#Interface]): Set[UMLInterface[Uml]] = for {e <- c} yield umlInterface(e)

	implicit def umlInterfaceRealization(e: Uml#InterfaceRealization): UMLInterfaceRealization[Uml]
	implicit def umlInterfaceRealization(c: Iterable[Uml#InterfaceRealization]): Iterable[UMLInterfaceRealization[Uml]] = for {e <- c} yield umlInterfaceRealization(e)
	implicit def umlInterfaceRealization(c: Seq[Uml#InterfaceRealization]): Seq[UMLInterfaceRealization[Uml]] = for {e <- c} yield umlInterfaceRealization(e)
	implicit def umlInterfaceRealization(c: Set[Uml#InterfaceRealization]): Set[UMLInterfaceRealization[Uml]] = for {e <- c} yield umlInterfaceRealization(e)

	implicit def umlInterruptibleActivityRegion(e: Uml#InterruptibleActivityRegion): UMLInterruptibleActivityRegion[Uml]
	implicit def umlInterruptibleActivityRegion(c: Iterable[Uml#InterruptibleActivityRegion]): Iterable[UMLInterruptibleActivityRegion[Uml]] = for {e <- c} yield umlInterruptibleActivityRegion(e)
	implicit def umlInterruptibleActivityRegion(c: Seq[Uml#InterruptibleActivityRegion]): Seq[UMLInterruptibleActivityRegion[Uml]] = for {e <- c} yield umlInterruptibleActivityRegion(e)
	implicit def umlInterruptibleActivityRegion(c: Set[Uml#InterruptibleActivityRegion]): Set[UMLInterruptibleActivityRegion[Uml]] = for {e <- c} yield umlInterruptibleActivityRegion(e)

	implicit def umlInterval(e: Uml#Interval): UMLInterval[Uml]
	implicit def umlInterval(c: Iterable[Uml#Interval]): Iterable[UMLInterval[Uml]] = for {e <- c} yield umlInterval(e)
	implicit def umlInterval(c: Seq[Uml#Interval]): Seq[UMLInterval[Uml]] = for {e <- c} yield umlInterval(e)
	implicit def umlInterval(c: Set[Uml#Interval]): Set[UMLInterval[Uml]] = for {e <- c} yield umlInterval(e)

	implicit def umlIntervalConstraint(e: Uml#IntervalConstraint): UMLIntervalConstraint[Uml]
	implicit def umlIntervalConstraint(c: Iterable[Uml#IntervalConstraint]): Iterable[UMLIntervalConstraint[Uml]] = for {e <- c} yield umlIntervalConstraint(e)
	implicit def umlIntervalConstraint(c: Seq[Uml#IntervalConstraint]): Seq[UMLIntervalConstraint[Uml]] = for {e <- c} yield umlIntervalConstraint(e)
	implicit def umlIntervalConstraint(c: Set[Uml#IntervalConstraint]): Set[UMLIntervalConstraint[Uml]] = for {e <- c} yield umlIntervalConstraint(e)

	implicit def umlInvocationAction(e: Uml#InvocationAction): UMLInvocationAction[Uml]
	implicit def umlInvocationAction(c: Iterable[Uml#InvocationAction]): Iterable[UMLInvocationAction[Uml]] = for {e <- c} yield umlInvocationAction(e)
	implicit def umlInvocationAction(c: Seq[Uml#InvocationAction]): Seq[UMLInvocationAction[Uml]] = for {e <- c} yield umlInvocationAction(e)
	implicit def umlInvocationAction(c: Set[Uml#InvocationAction]): Set[UMLInvocationAction[Uml]] = for {e <- c} yield umlInvocationAction(e)

	implicit def umlJoinNode(e: Uml#JoinNode): UMLJoinNode[Uml]
	implicit def umlJoinNode(c: Iterable[Uml#JoinNode]): Iterable[UMLJoinNode[Uml]] = for {e <- c} yield umlJoinNode(e)
	implicit def umlJoinNode(c: Seq[Uml#JoinNode]): Seq[UMLJoinNode[Uml]] = for {e <- c} yield umlJoinNode(e)
	implicit def umlJoinNode(c: Set[Uml#JoinNode]): Set[UMLJoinNode[Uml]] = for {e <- c} yield umlJoinNode(e)

	implicit def umlLifeline(e: Uml#Lifeline): UMLLifeline[Uml]
	implicit def umlLifeline(c: Iterable[Uml#Lifeline]): Iterable[UMLLifeline[Uml]] = for {e <- c} yield umlLifeline(e)
	implicit def umlLifeline(c: Seq[Uml#Lifeline]): Seq[UMLLifeline[Uml]] = for {e <- c} yield umlLifeline(e)
	implicit def umlLifeline(c: Set[Uml#Lifeline]): Set[UMLLifeline[Uml]] = for {e <- c} yield umlLifeline(e)

	implicit def umlLinkAction(e: Uml#LinkAction): UMLLinkAction[Uml]
	implicit def umlLinkAction(c: Iterable[Uml#LinkAction]): Iterable[UMLLinkAction[Uml]] = for {e <- c} yield umlLinkAction(e)
	implicit def umlLinkAction(c: Seq[Uml#LinkAction]): Seq[UMLLinkAction[Uml]] = for {e <- c} yield umlLinkAction(e)
	implicit def umlLinkAction(c: Set[Uml#LinkAction]): Set[UMLLinkAction[Uml]] = for {e <- c} yield umlLinkAction(e)

	implicit def umlLinkEndCreationData(e: Uml#LinkEndCreationData): UMLLinkEndCreationData[Uml]
	implicit def umlLinkEndCreationData(c: Iterable[Uml#LinkEndCreationData]): Iterable[UMLLinkEndCreationData[Uml]] = for {e <- c} yield umlLinkEndCreationData(e)
	implicit def umlLinkEndCreationData(c: Seq[Uml#LinkEndCreationData]): Seq[UMLLinkEndCreationData[Uml]] = for {e <- c} yield umlLinkEndCreationData(e)
	implicit def umlLinkEndCreationData(c: Set[Uml#LinkEndCreationData]): Set[UMLLinkEndCreationData[Uml]] = for {e <- c} yield umlLinkEndCreationData(e)

	implicit def umlLinkEndData(e: Uml#LinkEndData): UMLLinkEndData[Uml]
	implicit def umlLinkEndData(c: Iterable[Uml#LinkEndData]): Iterable[UMLLinkEndData[Uml]] = for {e <- c} yield umlLinkEndData(e)
	implicit def umlLinkEndData(c: Seq[Uml#LinkEndData]): Seq[UMLLinkEndData[Uml]] = for {e <- c} yield umlLinkEndData(e)
	implicit def umlLinkEndData(c: Set[Uml#LinkEndData]): Set[UMLLinkEndData[Uml]] = for {e <- c} yield umlLinkEndData(e)

	implicit def umlLinkEndDestructionData(e: Uml#LinkEndDestructionData): UMLLinkEndDestructionData[Uml]
	implicit def umlLinkEndDestructionData(c: Iterable[Uml#LinkEndDestructionData]): Iterable[UMLLinkEndDestructionData[Uml]] = for {e <- c} yield umlLinkEndDestructionData(e)
	implicit def umlLinkEndDestructionData(c: Seq[Uml#LinkEndDestructionData]): Seq[UMLLinkEndDestructionData[Uml]] = for {e <- c} yield umlLinkEndDestructionData(e)
	implicit def umlLinkEndDestructionData(c: Set[Uml#LinkEndDestructionData]): Set[UMLLinkEndDestructionData[Uml]] = for {e <- c} yield umlLinkEndDestructionData(e)

	implicit def umlLiteralBoolean(e: Uml#LiteralBoolean): UMLLiteralBoolean[Uml]
	implicit def umlLiteralBoolean(c: Iterable[Uml#LiteralBoolean]): Iterable[UMLLiteralBoolean[Uml]] = for {e <- c} yield umlLiteralBoolean(e)
	implicit def umlLiteralBoolean(c: Seq[Uml#LiteralBoolean]): Seq[UMLLiteralBoolean[Uml]] = for {e <- c} yield umlLiteralBoolean(e)
	implicit def umlLiteralBoolean(c: Set[Uml#LiteralBoolean]): Set[UMLLiteralBoolean[Uml]] = for {e <- c} yield umlLiteralBoolean(e)

	implicit def umlLiteralInteger(e: Uml#LiteralInteger): UMLLiteralInteger[Uml]
	implicit def umlLiteralInteger(c: Iterable[Uml#LiteralInteger]): Iterable[UMLLiteralInteger[Uml]] = for {e <- c} yield umlLiteralInteger(e)
	implicit def umlLiteralInteger(c: Seq[Uml#LiteralInteger]): Seq[UMLLiteralInteger[Uml]] = for {e <- c} yield umlLiteralInteger(e)
	implicit def umlLiteralInteger(c: Set[Uml#LiteralInteger]): Set[UMLLiteralInteger[Uml]] = for {e <- c} yield umlLiteralInteger(e)

	implicit def umlLiteralNull(e: Uml#LiteralNull): UMLLiteralNull[Uml]
	implicit def umlLiteralNull(c: Iterable[Uml#LiteralNull]): Iterable[UMLLiteralNull[Uml]] = for {e <- c} yield umlLiteralNull(e)
	implicit def umlLiteralNull(c: Seq[Uml#LiteralNull]): Seq[UMLLiteralNull[Uml]] = for {e <- c} yield umlLiteralNull(e)
	implicit def umlLiteralNull(c: Set[Uml#LiteralNull]): Set[UMLLiteralNull[Uml]] = for {e <- c} yield umlLiteralNull(e)

	implicit def umlLiteralReal(e: Uml#LiteralReal): UMLLiteralReal[Uml]
	implicit def umlLiteralReal(c: Iterable[Uml#LiteralReal]): Iterable[UMLLiteralReal[Uml]] = for {e <- c} yield umlLiteralReal(e)
	implicit def umlLiteralReal(c: Seq[Uml#LiteralReal]): Seq[UMLLiteralReal[Uml]] = for {e <- c} yield umlLiteralReal(e)
	implicit def umlLiteralReal(c: Set[Uml#LiteralReal]): Set[UMLLiteralReal[Uml]] = for {e <- c} yield umlLiteralReal(e)

	implicit def umlLiteralSpecification(e: Uml#LiteralSpecification): UMLLiteralSpecification[Uml]
	implicit def umlLiteralSpecification(c: Iterable[Uml#LiteralSpecification]): Iterable[UMLLiteralSpecification[Uml]] = for {e <- c} yield umlLiteralSpecification(e)
	implicit def umlLiteralSpecification(c: Seq[Uml#LiteralSpecification]): Seq[UMLLiteralSpecification[Uml]] = for {e <- c} yield umlLiteralSpecification(e)
	implicit def umlLiteralSpecification(c: Set[Uml#LiteralSpecification]): Set[UMLLiteralSpecification[Uml]] = for {e <- c} yield umlLiteralSpecification(e)

	implicit def umlLiteralString(e: Uml#LiteralString): UMLLiteralString[Uml]
	implicit def umlLiteralString(c: Iterable[Uml#LiteralString]): Iterable[UMLLiteralString[Uml]] = for {e <- c} yield umlLiteralString(e)
	implicit def umlLiteralString(c: Seq[Uml#LiteralString]): Seq[UMLLiteralString[Uml]] = for {e <- c} yield umlLiteralString(e)
	implicit def umlLiteralString(c: Set[Uml#LiteralString]): Set[UMLLiteralString[Uml]] = for {e <- c} yield umlLiteralString(e)

	implicit def umlLiteralUnlimitedNatural(e: Uml#LiteralUnlimitedNatural): UMLLiteralUnlimitedNatural[Uml]
	implicit def umlLiteralUnlimitedNatural(c: Iterable[Uml#LiteralUnlimitedNatural]): Iterable[UMLLiteralUnlimitedNatural[Uml]] = for {e <- c} yield umlLiteralUnlimitedNatural(e)
	implicit def umlLiteralUnlimitedNatural(c: Seq[Uml#LiteralUnlimitedNatural]): Seq[UMLLiteralUnlimitedNatural[Uml]] = for {e <- c} yield umlLiteralUnlimitedNatural(e)
	implicit def umlLiteralUnlimitedNatural(c: Set[Uml#LiteralUnlimitedNatural]): Set[UMLLiteralUnlimitedNatural[Uml]] = for {e <- c} yield umlLiteralUnlimitedNatural(e)

	implicit def umlLoopNode(e: Uml#LoopNode): UMLLoopNode[Uml]
	implicit def umlLoopNode(c: Iterable[Uml#LoopNode]): Iterable[UMLLoopNode[Uml]] = for {e <- c} yield umlLoopNode(e)
	implicit def umlLoopNode(c: Seq[Uml#LoopNode]): Seq[UMLLoopNode[Uml]] = for {e <- c} yield umlLoopNode(e)
	implicit def umlLoopNode(c: Set[Uml#LoopNode]): Set[UMLLoopNode[Uml]] = for {e <- c} yield umlLoopNode(e)

	implicit def umlManifestation(e: Uml#Manifestation): UMLManifestation[Uml]
	implicit def umlManifestation(c: Iterable[Uml#Manifestation]): Iterable[UMLManifestation[Uml]] = for {e <- c} yield umlManifestation(e)
	implicit def umlManifestation(c: Seq[Uml#Manifestation]): Seq[UMLManifestation[Uml]] = for {e <- c} yield umlManifestation(e)
	implicit def umlManifestation(c: Set[Uml#Manifestation]): Set[UMLManifestation[Uml]] = for {e <- c} yield umlManifestation(e)

	implicit def umlMergeNode(e: Uml#MergeNode): UMLMergeNode[Uml]
	implicit def umlMergeNode(c: Iterable[Uml#MergeNode]): Iterable[UMLMergeNode[Uml]] = for {e <- c} yield umlMergeNode(e)
	implicit def umlMergeNode(c: Seq[Uml#MergeNode]): Seq[UMLMergeNode[Uml]] = for {e <- c} yield umlMergeNode(e)
	implicit def umlMergeNode(c: Set[Uml#MergeNode]): Set[UMLMergeNode[Uml]] = for {e <- c} yield umlMergeNode(e)

	implicit def umlMessage(e: Uml#Message): UMLMessage[Uml]
	implicit def umlMessage(c: Iterable[Uml#Message]): Iterable[UMLMessage[Uml]] = for {e <- c} yield umlMessage(e)
	implicit def umlMessage(c: Seq[Uml#Message]): Seq[UMLMessage[Uml]] = for {e <- c} yield umlMessage(e)
	implicit def umlMessage(c: Set[Uml#Message]): Set[UMLMessage[Uml]] = for {e <- c} yield umlMessage(e)

	implicit def umlMessageEnd(e: Uml#MessageEnd): UMLMessageEnd[Uml]
	implicit def umlMessageEnd(c: Iterable[Uml#MessageEnd]): Iterable[UMLMessageEnd[Uml]] = for {e <- c} yield umlMessageEnd(e)
	implicit def umlMessageEnd(c: Seq[Uml#MessageEnd]): Seq[UMLMessageEnd[Uml]] = for {e <- c} yield umlMessageEnd(e)
	implicit def umlMessageEnd(c: Set[Uml#MessageEnd]): Set[UMLMessageEnd[Uml]] = for {e <- c} yield umlMessageEnd(e)

	implicit def umlMessageEvent(e: Uml#MessageEvent): UMLMessageEvent[Uml]
	implicit def umlMessageEvent(c: Iterable[Uml#MessageEvent]): Iterable[UMLMessageEvent[Uml]] = for {e <- c} yield umlMessageEvent(e)
	implicit def umlMessageEvent(c: Seq[Uml#MessageEvent]): Seq[UMLMessageEvent[Uml]] = for {e <- c} yield umlMessageEvent(e)
	implicit def umlMessageEvent(c: Set[Uml#MessageEvent]): Set[UMLMessageEvent[Uml]] = for {e <- c} yield umlMessageEvent(e)

	implicit def umlMessageOccurrenceSpecification(e: Uml#MessageOccurrenceSpecification): UMLMessageOccurrenceSpecification[Uml]
	implicit def umlMessageOccurrenceSpecification(c: Iterable[Uml#MessageOccurrenceSpecification]): Iterable[UMLMessageOccurrenceSpecification[Uml]] = for {e <- c} yield umlMessageOccurrenceSpecification(e)
	implicit def umlMessageOccurrenceSpecification(c: Seq[Uml#MessageOccurrenceSpecification]): Seq[UMLMessageOccurrenceSpecification[Uml]] = for {e <- c} yield umlMessageOccurrenceSpecification(e)
	implicit def umlMessageOccurrenceSpecification(c: Set[Uml#MessageOccurrenceSpecification]): Set[UMLMessageOccurrenceSpecification[Uml]] = for {e <- c} yield umlMessageOccurrenceSpecification(e)

	implicit def umlModel(e: Uml#Model): UMLModel[Uml]
	implicit def umlModel(c: Iterable[Uml#Model]): Iterable[UMLModel[Uml]] = for {e <- c} yield umlModel(e)
	implicit def umlModel(c: Seq[Uml#Model]): Seq[UMLModel[Uml]] = for {e <- c} yield umlModel(e)
	implicit def umlModel(c: Set[Uml#Model]): Set[UMLModel[Uml]] = for {e <- c} yield umlModel(e)

	implicit def umlMultiplicityElement(e: Uml#MultiplicityElement): UMLMultiplicityElement[Uml]
	implicit def umlMultiplicityElement(c: Iterable[Uml#MultiplicityElement]): Iterable[UMLMultiplicityElement[Uml]] = for {e <- c} yield umlMultiplicityElement(e)
	implicit def umlMultiplicityElement(c: Seq[Uml#MultiplicityElement]): Seq[UMLMultiplicityElement[Uml]] = for {e <- c} yield umlMultiplicityElement(e)
	implicit def umlMultiplicityElement(c: Set[Uml#MultiplicityElement]): Set[UMLMultiplicityElement[Uml]] = for {e <- c} yield umlMultiplicityElement(e)

	implicit def umlNamedElement(e: Uml#NamedElement): UMLNamedElement[Uml]
	implicit def umlNamedElement(c: Iterable[Uml#NamedElement]): Iterable[UMLNamedElement[Uml]] = for {e <- c} yield umlNamedElement(e)
	implicit def umlNamedElement(c: Seq[Uml#NamedElement]): Seq[UMLNamedElement[Uml]] = for {e <- c} yield umlNamedElement(e)
	implicit def umlNamedElement(c: Set[Uml#NamedElement]): Set[UMLNamedElement[Uml]] = for {e <- c} yield umlNamedElement(e)

	implicit def umlNamespace(e: Uml#Namespace): UMLNamespace[Uml]
	implicit def umlNamespace(c: Iterable[Uml#Namespace]): Iterable[UMLNamespace[Uml]] = for {e <- c} yield umlNamespace(e)
	implicit def umlNamespace(c: Seq[Uml#Namespace]): Seq[UMLNamespace[Uml]] = for {e <- c} yield umlNamespace(e)
	implicit def umlNamespace(c: Set[Uml#Namespace]): Set[UMLNamespace[Uml]] = for {e <- c} yield umlNamespace(e)

	implicit def umlNode(e: Uml#Node): UMLNode[Uml]
	implicit def umlNode(c: Iterable[Uml#Node]): Iterable[UMLNode[Uml]] = for {e <- c} yield umlNode(e)
	implicit def umlNode(c: Seq[Uml#Node]): Seq[UMLNode[Uml]] = for {e <- c} yield umlNode(e)
	implicit def umlNode(c: Set[Uml#Node]): Set[UMLNode[Uml]] = for {e <- c} yield umlNode(e)

	implicit def umlObjectFlow(e: Uml#ObjectFlow): UMLObjectFlow[Uml]
	implicit def umlObjectFlow(c: Iterable[Uml#ObjectFlow]): Iterable[UMLObjectFlow[Uml]] = for {e <- c} yield umlObjectFlow(e)
	implicit def umlObjectFlow(c: Seq[Uml#ObjectFlow]): Seq[UMLObjectFlow[Uml]] = for {e <- c} yield umlObjectFlow(e)
	implicit def umlObjectFlow(c: Set[Uml#ObjectFlow]): Set[UMLObjectFlow[Uml]] = for {e <- c} yield umlObjectFlow(e)

	implicit def umlObjectNode(e: Uml#ObjectNode): UMLObjectNode[Uml]
	implicit def umlObjectNode(c: Iterable[Uml#ObjectNode]): Iterable[UMLObjectNode[Uml]] = for {e <- c} yield umlObjectNode(e)
	implicit def umlObjectNode(c: Seq[Uml#ObjectNode]): Seq[UMLObjectNode[Uml]] = for {e <- c} yield umlObjectNode(e)
	implicit def umlObjectNode(c: Set[Uml#ObjectNode]): Set[UMLObjectNode[Uml]] = for {e <- c} yield umlObjectNode(e)

	implicit def umlObservation(e: Uml#Observation): UMLObservation[Uml]
	implicit def umlObservation(c: Iterable[Uml#Observation]): Iterable[UMLObservation[Uml]] = for {e <- c} yield umlObservation(e)
	implicit def umlObservation(c: Seq[Uml#Observation]): Seq[UMLObservation[Uml]] = for {e <- c} yield umlObservation(e)
	implicit def umlObservation(c: Set[Uml#Observation]): Set[UMLObservation[Uml]] = for {e <- c} yield umlObservation(e)

	implicit def umlOccurrenceSpecification(e: Uml#OccurrenceSpecification): UMLOccurrenceSpecification[Uml]
	implicit def umlOccurrenceSpecification(c: Iterable[Uml#OccurrenceSpecification]): Iterable[UMLOccurrenceSpecification[Uml]] = for {e <- c} yield umlOccurrenceSpecification(e)
	implicit def umlOccurrenceSpecification(c: Seq[Uml#OccurrenceSpecification]): Seq[UMLOccurrenceSpecification[Uml]] = for {e <- c} yield umlOccurrenceSpecification(e)
	implicit def umlOccurrenceSpecification(c: Set[Uml#OccurrenceSpecification]): Set[UMLOccurrenceSpecification[Uml]] = for {e <- c} yield umlOccurrenceSpecification(e)

	implicit def umlOpaqueAction(e: Uml#OpaqueAction): UMLOpaqueAction[Uml]
	implicit def umlOpaqueAction(c: Iterable[Uml#OpaqueAction]): Iterable[UMLOpaqueAction[Uml]] = for {e <- c} yield umlOpaqueAction(e)
	implicit def umlOpaqueAction(c: Seq[Uml#OpaqueAction]): Seq[UMLOpaqueAction[Uml]] = for {e <- c} yield umlOpaqueAction(e)
	implicit def umlOpaqueAction(c: Set[Uml#OpaqueAction]): Set[UMLOpaqueAction[Uml]] = for {e <- c} yield umlOpaqueAction(e)

	implicit def umlOpaqueBehavior(e: Uml#OpaqueBehavior): UMLOpaqueBehavior[Uml]
	implicit def umlOpaqueBehavior(c: Iterable[Uml#OpaqueBehavior]): Iterable[UMLOpaqueBehavior[Uml]] = for {e <- c} yield umlOpaqueBehavior(e)
	implicit def umlOpaqueBehavior(c: Seq[Uml#OpaqueBehavior]): Seq[UMLOpaqueBehavior[Uml]] = for {e <- c} yield umlOpaqueBehavior(e)
	implicit def umlOpaqueBehavior(c: Set[Uml#OpaqueBehavior]): Set[UMLOpaqueBehavior[Uml]] = for {e <- c} yield umlOpaqueBehavior(e)

	implicit def umlOpaqueExpression(e: Uml#OpaqueExpression): UMLOpaqueExpression[Uml]
	implicit def umlOpaqueExpression(c: Iterable[Uml#OpaqueExpression]): Iterable[UMLOpaqueExpression[Uml]] = for {e <- c} yield umlOpaqueExpression(e)
	implicit def umlOpaqueExpression(c: Seq[Uml#OpaqueExpression]): Seq[UMLOpaqueExpression[Uml]] = for {e <- c} yield umlOpaqueExpression(e)
	implicit def umlOpaqueExpression(c: Set[Uml#OpaqueExpression]): Set[UMLOpaqueExpression[Uml]] = for {e <- c} yield umlOpaqueExpression(e)

	implicit def umlOperation(e: Uml#Operation): UMLOperation[Uml]
	implicit def umlOperation(c: Iterable[Uml#Operation]): Iterable[UMLOperation[Uml]] = for {e <- c} yield umlOperation(e)
	implicit def umlOperation(c: Seq[Uml#Operation]): Seq[UMLOperation[Uml]] = for {e <- c} yield umlOperation(e)
	implicit def umlOperation(c: Set[Uml#Operation]): Set[UMLOperation[Uml]] = for {e <- c} yield umlOperation(e)

	implicit def umlOperationTemplateParameter(e: Uml#OperationTemplateParameter): UMLOperationTemplateParameter[Uml]
	implicit def umlOperationTemplateParameter(c: Iterable[Uml#OperationTemplateParameter]): Iterable[UMLOperationTemplateParameter[Uml]] = for {e <- c} yield umlOperationTemplateParameter(e)
	implicit def umlOperationTemplateParameter(c: Seq[Uml#OperationTemplateParameter]): Seq[UMLOperationTemplateParameter[Uml]] = for {e <- c} yield umlOperationTemplateParameter(e)
	implicit def umlOperationTemplateParameter(c: Set[Uml#OperationTemplateParameter]): Set[UMLOperationTemplateParameter[Uml]] = for {e <- c} yield umlOperationTemplateParameter(e)

	implicit def umlOutputPin(e: Uml#OutputPin): UMLOutputPin[Uml]
	implicit def umlOutputPin(c: Iterable[Uml#OutputPin]): Iterable[UMLOutputPin[Uml]] = for {e <- c} yield umlOutputPin(e)
	implicit def umlOutputPin(c: Seq[Uml#OutputPin]): Seq[UMLOutputPin[Uml]] = for {e <- c} yield umlOutputPin(e)
	implicit def umlOutputPin(c: Set[Uml#OutputPin]): Set[UMLOutputPin[Uml]] = for {e <- c} yield umlOutputPin(e)

	implicit def umlPackage(e: Uml#Package): UMLPackage[Uml]
	implicit def umlPackage(c: Iterable[Uml#Package]): Iterable[UMLPackage[Uml]] = for {e <- c} yield umlPackage(e)
	implicit def umlPackage(c: Seq[Uml#Package]): Seq[UMLPackage[Uml]] = for {e <- c} yield umlPackage(e)
	implicit def umlPackage(c: Set[Uml#Package]): Set[UMLPackage[Uml]] = for {e <- c} yield umlPackage(e)

	implicit def umlPackageImport(e: Uml#PackageImport): UMLPackageImport[Uml]
	implicit def umlPackageImport(c: Iterable[Uml#PackageImport]): Iterable[UMLPackageImport[Uml]] = for {e <- c} yield umlPackageImport(e)
	implicit def umlPackageImport(c: Seq[Uml#PackageImport]): Seq[UMLPackageImport[Uml]] = for {e <- c} yield umlPackageImport(e)
	implicit def umlPackageImport(c: Set[Uml#PackageImport]): Set[UMLPackageImport[Uml]] = for {e <- c} yield umlPackageImport(e)

	implicit def umlPackageMerge(e: Uml#PackageMerge): UMLPackageMerge[Uml]
	implicit def umlPackageMerge(c: Iterable[Uml#PackageMerge]): Iterable[UMLPackageMerge[Uml]] = for {e <- c} yield umlPackageMerge(e)
	implicit def umlPackageMerge(c: Seq[Uml#PackageMerge]): Seq[UMLPackageMerge[Uml]] = for {e <- c} yield umlPackageMerge(e)
	implicit def umlPackageMerge(c: Set[Uml#PackageMerge]): Set[UMLPackageMerge[Uml]] = for {e <- c} yield umlPackageMerge(e)

	implicit def umlPackageableElement(e: Uml#PackageableElement): UMLPackageableElement[Uml]
	implicit def umlPackageableElement(c: Iterable[Uml#PackageableElement]): Iterable[UMLPackageableElement[Uml]] = for {e <- c} yield umlPackageableElement(e)
	implicit def umlPackageableElement(c: Seq[Uml#PackageableElement]): Seq[UMLPackageableElement[Uml]] = for {e <- c} yield umlPackageableElement(e)
	implicit def umlPackageableElement(c: Set[Uml#PackageableElement]): Set[UMLPackageableElement[Uml]] = for {e <- c} yield umlPackageableElement(e)

	implicit def umlParameter(e: Uml#Parameter): UMLParameter[Uml]
	implicit def umlParameter(c: Iterable[Uml#Parameter]): Iterable[UMLParameter[Uml]] = for {e <- c} yield umlParameter(e)
	implicit def umlParameter(c: Seq[Uml#Parameter]): Seq[UMLParameter[Uml]] = for {e <- c} yield umlParameter(e)
	implicit def umlParameter(c: Set[Uml#Parameter]): Set[UMLParameter[Uml]] = for {e <- c} yield umlParameter(e)

	implicit def umlParameterSet(e: Uml#ParameterSet): UMLParameterSet[Uml]
	implicit def umlParameterSet(c: Iterable[Uml#ParameterSet]): Iterable[UMLParameterSet[Uml]] = for {e <- c} yield umlParameterSet(e)
	implicit def umlParameterSet(c: Seq[Uml#ParameterSet]): Seq[UMLParameterSet[Uml]] = for {e <- c} yield umlParameterSet(e)
	implicit def umlParameterSet(c: Set[Uml#ParameterSet]): Set[UMLParameterSet[Uml]] = for {e <- c} yield umlParameterSet(e)

	implicit def umlParameterableElement(e: Uml#ParameterableElement): UMLParameterableElement[Uml]
	implicit def umlParameterableElement(c: Iterable[Uml#ParameterableElement]): Iterable[UMLParameterableElement[Uml]] = for {e <- c} yield umlParameterableElement(e)
	implicit def umlParameterableElement(c: Seq[Uml#ParameterableElement]): Seq[UMLParameterableElement[Uml]] = for {e <- c} yield umlParameterableElement(e)
	implicit def umlParameterableElement(c: Set[Uml#ParameterableElement]): Set[UMLParameterableElement[Uml]] = for {e <- c} yield umlParameterableElement(e)

	implicit def umlPartDecomposition(e: Uml#PartDecomposition): UMLPartDecomposition[Uml]
	implicit def umlPartDecomposition(c: Iterable[Uml#PartDecomposition]): Iterable[UMLPartDecomposition[Uml]] = for {e <- c} yield umlPartDecomposition(e)
	implicit def umlPartDecomposition(c: Seq[Uml#PartDecomposition]): Seq[UMLPartDecomposition[Uml]] = for {e <- c} yield umlPartDecomposition(e)
	implicit def umlPartDecomposition(c: Set[Uml#PartDecomposition]): Set[UMLPartDecomposition[Uml]] = for {e <- c} yield umlPartDecomposition(e)

	implicit def umlPin(e: Uml#Pin): UMLPin[Uml]
	implicit def umlPin(c: Iterable[Uml#Pin]): Iterable[UMLPin[Uml]] = for {e <- c} yield umlPin(e)
	implicit def umlPin(c: Seq[Uml#Pin]): Seq[UMLPin[Uml]] = for {e <- c} yield umlPin(e)
	implicit def umlPin(c: Set[Uml#Pin]): Set[UMLPin[Uml]] = for {e <- c} yield umlPin(e)

	implicit def umlPort(e: Uml#Port): UMLPort[Uml]
	implicit def umlPort(c: Iterable[Uml#Port]): Iterable[UMLPort[Uml]] = for {e <- c} yield umlPort(e)
	implicit def umlPort(c: Seq[Uml#Port]): Seq[UMLPort[Uml]] = for {e <- c} yield umlPort(e)
	implicit def umlPort(c: Set[Uml#Port]): Set[UMLPort[Uml]] = for {e <- c} yield umlPort(e)

	implicit def umlPrimitiveType(e: Uml#PrimitiveType): UMLPrimitiveType[Uml]
	implicit def umlPrimitiveType(c: Iterable[Uml#PrimitiveType]): Iterable[UMLPrimitiveType[Uml]] = for {e <- c} yield umlPrimitiveType(e)
	implicit def umlPrimitiveType(c: Seq[Uml#PrimitiveType]): Seq[UMLPrimitiveType[Uml]] = for {e <- c} yield umlPrimitiveType(e)
	implicit def umlPrimitiveType(c: Set[Uml#PrimitiveType]): Set[UMLPrimitiveType[Uml]] = for {e <- c} yield umlPrimitiveType(e)

	implicit def umlProfile(e: Uml#Profile): UMLProfile[Uml]
	implicit def umlProfile(c: Iterable[Uml#Profile]): Iterable[UMLProfile[Uml]] = for {e <- c} yield umlProfile(e)
	implicit def umlProfile(c: Seq[Uml#Profile]): Seq[UMLProfile[Uml]] = for {e <- c} yield umlProfile(e)
	implicit def umlProfile(c: Set[Uml#Profile]): Set[UMLProfile[Uml]] = for {e <- c} yield umlProfile(e)

	implicit def umlProfileApplication(e: Uml#ProfileApplication): UMLProfileApplication[Uml]
	implicit def umlProfileApplication(c: Iterable[Uml#ProfileApplication]): Iterable[UMLProfileApplication[Uml]] = for {e <- c} yield umlProfileApplication(e)
	implicit def umlProfileApplication(c: Seq[Uml#ProfileApplication]): Seq[UMLProfileApplication[Uml]] = for {e <- c} yield umlProfileApplication(e)
	implicit def umlProfileApplication(c: Set[Uml#ProfileApplication]): Set[UMLProfileApplication[Uml]] = for {e <- c} yield umlProfileApplication(e)

	implicit def umlProperty(e: Uml#Property): UMLProperty[Uml]
	implicit def umlProperty(c: Iterable[Uml#Property]): Iterable[UMLProperty[Uml]] = for {e <- c} yield umlProperty(e)
	implicit def umlProperty(c: Seq[Uml#Property]): Seq[UMLProperty[Uml]] = for {e <- c} yield umlProperty(e)
	implicit def umlProperty(c: Set[Uml#Property]): Set[UMLProperty[Uml]] = for {e <- c} yield umlProperty(e)

	implicit def umlProtocolConformance(e: Uml#ProtocolConformance): UMLProtocolConformance[Uml]
	implicit def umlProtocolConformance(c: Iterable[Uml#ProtocolConformance]): Iterable[UMLProtocolConformance[Uml]] = for {e <- c} yield umlProtocolConformance(e)
	implicit def umlProtocolConformance(c: Seq[Uml#ProtocolConformance]): Seq[UMLProtocolConformance[Uml]] = for {e <- c} yield umlProtocolConformance(e)
	implicit def umlProtocolConformance(c: Set[Uml#ProtocolConformance]): Set[UMLProtocolConformance[Uml]] = for {e <- c} yield umlProtocolConformance(e)

	implicit def umlProtocolStateMachine(e: Uml#ProtocolStateMachine): UMLProtocolStateMachine[Uml]
	implicit def umlProtocolStateMachine(c: Iterable[Uml#ProtocolStateMachine]): Iterable[UMLProtocolStateMachine[Uml]] = for {e <- c} yield umlProtocolStateMachine(e)
	implicit def umlProtocolStateMachine(c: Seq[Uml#ProtocolStateMachine]): Seq[UMLProtocolStateMachine[Uml]] = for {e <- c} yield umlProtocolStateMachine(e)
	implicit def umlProtocolStateMachine(c: Set[Uml#ProtocolStateMachine]): Set[UMLProtocolStateMachine[Uml]] = for {e <- c} yield umlProtocolStateMachine(e)

	implicit def umlProtocolTransition(e: Uml#ProtocolTransition): UMLProtocolTransition[Uml]
	implicit def umlProtocolTransition(c: Iterable[Uml#ProtocolTransition]): Iterable[UMLProtocolTransition[Uml]] = for {e <- c} yield umlProtocolTransition(e)
	implicit def umlProtocolTransition(c: Seq[Uml#ProtocolTransition]): Seq[UMLProtocolTransition[Uml]] = for {e <- c} yield umlProtocolTransition(e)
	implicit def umlProtocolTransition(c: Set[Uml#ProtocolTransition]): Set[UMLProtocolTransition[Uml]] = for {e <- c} yield umlProtocolTransition(e)

	implicit def umlPseudostate(e: Uml#Pseudostate): UMLPseudostate[Uml]
	implicit def umlPseudostate(c: Iterable[Uml#Pseudostate]): Iterable[UMLPseudostate[Uml]] = for {e <- c} yield umlPseudostate(e)
	implicit def umlPseudostate(c: Seq[Uml#Pseudostate]): Seq[UMLPseudostate[Uml]] = for {e <- c} yield umlPseudostate(e)
	implicit def umlPseudostate(c: Set[Uml#Pseudostate]): Set[UMLPseudostate[Uml]] = for {e <- c} yield umlPseudostate(e)

	implicit def umlQualifierValue(e: Uml#QualifierValue): UMLQualifierValue[Uml]
	implicit def umlQualifierValue(c: Iterable[Uml#QualifierValue]): Iterable[UMLQualifierValue[Uml]] = for {e <- c} yield umlQualifierValue(e)
	implicit def umlQualifierValue(c: Seq[Uml#QualifierValue]): Seq[UMLQualifierValue[Uml]] = for {e <- c} yield umlQualifierValue(e)
	implicit def umlQualifierValue(c: Set[Uml#QualifierValue]): Set[UMLQualifierValue[Uml]] = for {e <- c} yield umlQualifierValue(e)

	implicit def umlRaiseExceptionAction(e: Uml#RaiseExceptionAction): UMLRaiseExceptionAction[Uml]
	implicit def umlRaiseExceptionAction(c: Iterable[Uml#RaiseExceptionAction]): Iterable[UMLRaiseExceptionAction[Uml]] = for {e <- c} yield umlRaiseExceptionAction(e)
	implicit def umlRaiseExceptionAction(c: Seq[Uml#RaiseExceptionAction]): Seq[UMLRaiseExceptionAction[Uml]] = for {e <- c} yield umlRaiseExceptionAction(e)
	implicit def umlRaiseExceptionAction(c: Set[Uml#RaiseExceptionAction]): Set[UMLRaiseExceptionAction[Uml]] = for {e <- c} yield umlRaiseExceptionAction(e)

	implicit def umlReadExtentAction(e: Uml#ReadExtentAction): UMLReadExtentAction[Uml]
	implicit def umlReadExtentAction(c: Iterable[Uml#ReadExtentAction]): Iterable[UMLReadExtentAction[Uml]] = for {e <- c} yield umlReadExtentAction(e)
	implicit def umlReadExtentAction(c: Seq[Uml#ReadExtentAction]): Seq[UMLReadExtentAction[Uml]] = for {e <- c} yield umlReadExtentAction(e)
	implicit def umlReadExtentAction(c: Set[Uml#ReadExtentAction]): Set[UMLReadExtentAction[Uml]] = for {e <- c} yield umlReadExtentAction(e)

	implicit def umlReadIsClassifiedObjectAction(e: Uml#ReadIsClassifiedObjectAction): UMLReadIsClassifiedObjectAction[Uml]
	implicit def umlReadIsClassifiedObjectAction(c: Iterable[Uml#ReadIsClassifiedObjectAction]): Iterable[UMLReadIsClassifiedObjectAction[Uml]] = for {e <- c} yield umlReadIsClassifiedObjectAction(e)
	implicit def umlReadIsClassifiedObjectAction(c: Seq[Uml#ReadIsClassifiedObjectAction]): Seq[UMLReadIsClassifiedObjectAction[Uml]] = for {e <- c} yield umlReadIsClassifiedObjectAction(e)
	implicit def umlReadIsClassifiedObjectAction(c: Set[Uml#ReadIsClassifiedObjectAction]): Set[UMLReadIsClassifiedObjectAction[Uml]] = for {e <- c} yield umlReadIsClassifiedObjectAction(e)

	implicit def umlReadLinkAction(e: Uml#ReadLinkAction): UMLReadLinkAction[Uml]
	implicit def umlReadLinkAction(c: Iterable[Uml#ReadLinkAction]): Iterable[UMLReadLinkAction[Uml]] = for {e <- c} yield umlReadLinkAction(e)
	implicit def umlReadLinkAction(c: Seq[Uml#ReadLinkAction]): Seq[UMLReadLinkAction[Uml]] = for {e <- c} yield umlReadLinkAction(e)
	implicit def umlReadLinkAction(c: Set[Uml#ReadLinkAction]): Set[UMLReadLinkAction[Uml]] = for {e <- c} yield umlReadLinkAction(e)

	implicit def umlReadLinkObjectEndAction(e: Uml#ReadLinkObjectEndAction): UMLReadLinkObjectEndAction[Uml]
	implicit def umlReadLinkObjectEndAction(c: Iterable[Uml#ReadLinkObjectEndAction]): Iterable[UMLReadLinkObjectEndAction[Uml]] = for {e <- c} yield umlReadLinkObjectEndAction(e)
	implicit def umlReadLinkObjectEndAction(c: Seq[Uml#ReadLinkObjectEndAction]): Seq[UMLReadLinkObjectEndAction[Uml]] = for {e <- c} yield umlReadLinkObjectEndAction(e)
	implicit def umlReadLinkObjectEndAction(c: Set[Uml#ReadLinkObjectEndAction]): Set[UMLReadLinkObjectEndAction[Uml]] = for {e <- c} yield umlReadLinkObjectEndAction(e)

	implicit def umlReadLinkObjectEndQualifierAction(e: Uml#ReadLinkObjectEndQualifierAction): UMLReadLinkObjectEndQualifierAction[Uml]
	implicit def umlReadLinkObjectEndQualifierAction(c: Iterable[Uml#ReadLinkObjectEndQualifierAction]): Iterable[UMLReadLinkObjectEndQualifierAction[Uml]] = for {e <- c} yield umlReadLinkObjectEndQualifierAction(e)
	implicit def umlReadLinkObjectEndQualifierAction(c: Seq[Uml#ReadLinkObjectEndQualifierAction]): Seq[UMLReadLinkObjectEndQualifierAction[Uml]] = for {e <- c} yield umlReadLinkObjectEndQualifierAction(e)
	implicit def umlReadLinkObjectEndQualifierAction(c: Set[Uml#ReadLinkObjectEndQualifierAction]): Set[UMLReadLinkObjectEndQualifierAction[Uml]] = for {e <- c} yield umlReadLinkObjectEndQualifierAction(e)

	implicit def umlReadSelfAction(e: Uml#ReadSelfAction): UMLReadSelfAction[Uml]
	implicit def umlReadSelfAction(c: Iterable[Uml#ReadSelfAction]): Iterable[UMLReadSelfAction[Uml]] = for {e <- c} yield umlReadSelfAction(e)
	implicit def umlReadSelfAction(c: Seq[Uml#ReadSelfAction]): Seq[UMLReadSelfAction[Uml]] = for {e <- c} yield umlReadSelfAction(e)
	implicit def umlReadSelfAction(c: Set[Uml#ReadSelfAction]): Set[UMLReadSelfAction[Uml]] = for {e <- c} yield umlReadSelfAction(e)

	implicit def umlReadStructuralFeatureAction(e: Uml#ReadStructuralFeatureAction): UMLReadStructuralFeatureAction[Uml]
	implicit def umlReadStructuralFeatureAction(c: Iterable[Uml#ReadStructuralFeatureAction]): Iterable[UMLReadStructuralFeatureAction[Uml]] = for {e <- c} yield umlReadStructuralFeatureAction(e)
	implicit def umlReadStructuralFeatureAction(c: Seq[Uml#ReadStructuralFeatureAction]): Seq[UMLReadStructuralFeatureAction[Uml]] = for {e <- c} yield umlReadStructuralFeatureAction(e)
	implicit def umlReadStructuralFeatureAction(c: Set[Uml#ReadStructuralFeatureAction]): Set[UMLReadStructuralFeatureAction[Uml]] = for {e <- c} yield umlReadStructuralFeatureAction(e)

	implicit def umlReadVariableAction(e: Uml#ReadVariableAction): UMLReadVariableAction[Uml]
	implicit def umlReadVariableAction(c: Iterable[Uml#ReadVariableAction]): Iterable[UMLReadVariableAction[Uml]] = for {e <- c} yield umlReadVariableAction(e)
	implicit def umlReadVariableAction(c: Seq[Uml#ReadVariableAction]): Seq[UMLReadVariableAction[Uml]] = for {e <- c} yield umlReadVariableAction(e)
	implicit def umlReadVariableAction(c: Set[Uml#ReadVariableAction]): Set[UMLReadVariableAction[Uml]] = for {e <- c} yield umlReadVariableAction(e)

	implicit def umlRealization(e: Uml#Realization): UMLRealization[Uml]
	implicit def umlRealization(c: Iterable[Uml#Realization]): Iterable[UMLRealization[Uml]] = for {e <- c} yield umlRealization(e)
	implicit def umlRealization(c: Seq[Uml#Realization]): Seq[UMLRealization[Uml]] = for {e <- c} yield umlRealization(e)
	implicit def umlRealization(c: Set[Uml#Realization]): Set[UMLRealization[Uml]] = for {e <- c} yield umlRealization(e)

	implicit def umlReception(e: Uml#Reception): UMLReception[Uml]
	implicit def umlReception(c: Iterable[Uml#Reception]): Iterable[UMLReception[Uml]] = for {e <- c} yield umlReception(e)
	implicit def umlReception(c: Seq[Uml#Reception]): Seq[UMLReception[Uml]] = for {e <- c} yield umlReception(e)
	implicit def umlReception(c: Set[Uml#Reception]): Set[UMLReception[Uml]] = for {e <- c} yield umlReception(e)

	implicit def umlReclassifyObjectAction(e: Uml#ReclassifyObjectAction): UMLReclassifyObjectAction[Uml]
	implicit def umlReclassifyObjectAction(c: Iterable[Uml#ReclassifyObjectAction]): Iterable[UMLReclassifyObjectAction[Uml]] = for {e <- c} yield umlReclassifyObjectAction(e)
	implicit def umlReclassifyObjectAction(c: Seq[Uml#ReclassifyObjectAction]): Seq[UMLReclassifyObjectAction[Uml]] = for {e <- c} yield umlReclassifyObjectAction(e)
	implicit def umlReclassifyObjectAction(c: Set[Uml#ReclassifyObjectAction]): Set[UMLReclassifyObjectAction[Uml]] = for {e <- c} yield umlReclassifyObjectAction(e)

	implicit def umlRedefinableElement(e: Uml#RedefinableElement): UMLRedefinableElement[Uml]
	implicit def umlRedefinableElement(c: Iterable[Uml#RedefinableElement]): Iterable[UMLRedefinableElement[Uml]] = for {e <- c} yield umlRedefinableElement(e)
	implicit def umlRedefinableElement(c: Seq[Uml#RedefinableElement]): Seq[UMLRedefinableElement[Uml]] = for {e <- c} yield umlRedefinableElement(e)
	implicit def umlRedefinableElement(c: Set[Uml#RedefinableElement]): Set[UMLRedefinableElement[Uml]] = for {e <- c} yield umlRedefinableElement(e)

	implicit def umlRedefinableTemplateSignature(e: Uml#RedefinableTemplateSignature): UMLRedefinableTemplateSignature[Uml]
	implicit def umlRedefinableTemplateSignature(c: Iterable[Uml#RedefinableTemplateSignature]): Iterable[UMLRedefinableTemplateSignature[Uml]] = for {e <- c} yield umlRedefinableTemplateSignature(e)
	implicit def umlRedefinableTemplateSignature(c: Seq[Uml#RedefinableTemplateSignature]): Seq[UMLRedefinableTemplateSignature[Uml]] = for {e <- c} yield umlRedefinableTemplateSignature(e)
	implicit def umlRedefinableTemplateSignature(c: Set[Uml#RedefinableTemplateSignature]): Set[UMLRedefinableTemplateSignature[Uml]] = for {e <- c} yield umlRedefinableTemplateSignature(e)

	implicit def umlReduceAction(e: Uml#ReduceAction): UMLReduceAction[Uml]
	implicit def umlReduceAction(c: Iterable[Uml#ReduceAction]): Iterable[UMLReduceAction[Uml]] = for {e <- c} yield umlReduceAction(e)
	implicit def umlReduceAction(c: Seq[Uml#ReduceAction]): Seq[UMLReduceAction[Uml]] = for {e <- c} yield umlReduceAction(e)
	implicit def umlReduceAction(c: Set[Uml#ReduceAction]): Set[UMLReduceAction[Uml]] = for {e <- c} yield umlReduceAction(e)

	implicit def umlRegion(e: Uml#Region): UMLRegion[Uml]
	implicit def umlRegion(c: Iterable[Uml#Region]): Iterable[UMLRegion[Uml]] = for {e <- c} yield umlRegion(e)
	implicit def umlRegion(c: Seq[Uml#Region]): Seq[UMLRegion[Uml]] = for {e <- c} yield umlRegion(e)
	implicit def umlRegion(c: Set[Uml#Region]): Set[UMLRegion[Uml]] = for {e <- c} yield umlRegion(e)

	implicit def umlRelationship(e: Uml#Relationship): UMLRelationship[Uml]
	implicit def umlRelationship(c: Iterable[Uml#Relationship]): Iterable[UMLRelationship[Uml]] = for {e <- c} yield umlRelationship(e)
	implicit def umlRelationship(c: Seq[Uml#Relationship]): Seq[UMLRelationship[Uml]] = for {e <- c} yield umlRelationship(e)
	implicit def umlRelationship(c: Set[Uml#Relationship]): Set[UMLRelationship[Uml]] = for {e <- c} yield umlRelationship(e)

	implicit def umlRemoveStructuralFeatureValueAction(e: Uml#RemoveStructuralFeatureValueAction): UMLRemoveStructuralFeatureValueAction[Uml]
	implicit def umlRemoveStructuralFeatureValueAction(c: Iterable[Uml#RemoveStructuralFeatureValueAction]): Iterable[UMLRemoveStructuralFeatureValueAction[Uml]] = for {e <- c} yield umlRemoveStructuralFeatureValueAction(e)
	implicit def umlRemoveStructuralFeatureValueAction(c: Seq[Uml#RemoveStructuralFeatureValueAction]): Seq[UMLRemoveStructuralFeatureValueAction[Uml]] = for {e <- c} yield umlRemoveStructuralFeatureValueAction(e)
	implicit def umlRemoveStructuralFeatureValueAction(c: Set[Uml#RemoveStructuralFeatureValueAction]): Set[UMLRemoveStructuralFeatureValueAction[Uml]] = for {e <- c} yield umlRemoveStructuralFeatureValueAction(e)

	implicit def umlRemoveVariableValueAction(e: Uml#RemoveVariableValueAction): UMLRemoveVariableValueAction[Uml]
	implicit def umlRemoveVariableValueAction(c: Iterable[Uml#RemoveVariableValueAction]): Iterable[UMLRemoveVariableValueAction[Uml]] = for {e <- c} yield umlRemoveVariableValueAction(e)
	implicit def umlRemoveVariableValueAction(c: Seq[Uml#RemoveVariableValueAction]): Seq[UMLRemoveVariableValueAction[Uml]] = for {e <- c} yield umlRemoveVariableValueAction(e)
	implicit def umlRemoveVariableValueAction(c: Set[Uml#RemoveVariableValueAction]): Set[UMLRemoveVariableValueAction[Uml]] = for {e <- c} yield umlRemoveVariableValueAction(e)

	implicit def umlReplyAction(e: Uml#ReplyAction): UMLReplyAction[Uml]
	implicit def umlReplyAction(c: Iterable[Uml#ReplyAction]): Iterable[UMLReplyAction[Uml]] = for {e <- c} yield umlReplyAction(e)
	implicit def umlReplyAction(c: Seq[Uml#ReplyAction]): Seq[UMLReplyAction[Uml]] = for {e <- c} yield umlReplyAction(e)
	implicit def umlReplyAction(c: Set[Uml#ReplyAction]): Set[UMLReplyAction[Uml]] = for {e <- c} yield umlReplyAction(e)

	implicit def umlSendObjectAction(e: Uml#SendObjectAction): UMLSendObjectAction[Uml]
	implicit def umlSendObjectAction(c: Iterable[Uml#SendObjectAction]): Iterable[UMLSendObjectAction[Uml]] = for {e <- c} yield umlSendObjectAction(e)
	implicit def umlSendObjectAction(c: Seq[Uml#SendObjectAction]): Seq[UMLSendObjectAction[Uml]] = for {e <- c} yield umlSendObjectAction(e)
	implicit def umlSendObjectAction(c: Set[Uml#SendObjectAction]): Set[UMLSendObjectAction[Uml]] = for {e <- c} yield umlSendObjectAction(e)

	implicit def umlSendSignalAction(e: Uml#SendSignalAction): UMLSendSignalAction[Uml]
	implicit def umlSendSignalAction(c: Iterable[Uml#SendSignalAction]): Iterable[UMLSendSignalAction[Uml]] = for {e <- c} yield umlSendSignalAction(e)
	implicit def umlSendSignalAction(c: Seq[Uml#SendSignalAction]): Seq[UMLSendSignalAction[Uml]] = for {e <- c} yield umlSendSignalAction(e)
	implicit def umlSendSignalAction(c: Set[Uml#SendSignalAction]): Set[UMLSendSignalAction[Uml]] = for {e <- c} yield umlSendSignalAction(e)

	implicit def umlSequenceNode(e: Uml#SequenceNode): UMLSequenceNode[Uml]
	implicit def umlSequenceNode(c: Iterable[Uml#SequenceNode]): Iterable[UMLSequenceNode[Uml]] = for {e <- c} yield umlSequenceNode(e)
	implicit def umlSequenceNode(c: Seq[Uml#SequenceNode]): Seq[UMLSequenceNode[Uml]] = for {e <- c} yield umlSequenceNode(e)
	implicit def umlSequenceNode(c: Set[Uml#SequenceNode]): Set[UMLSequenceNode[Uml]] = for {e <- c} yield umlSequenceNode(e)

	implicit def umlSignal(e: Uml#Signal): UMLSignal[Uml]
	implicit def umlSignal(c: Iterable[Uml#Signal]): Iterable[UMLSignal[Uml]] = for {e <- c} yield umlSignal(e)
	implicit def umlSignal(c: Seq[Uml#Signal]): Seq[UMLSignal[Uml]] = for {e <- c} yield umlSignal(e)
	implicit def umlSignal(c: Set[Uml#Signal]): Set[UMLSignal[Uml]] = for {e <- c} yield umlSignal(e)

	implicit def umlSignalEvent(e: Uml#SignalEvent): UMLSignalEvent[Uml]
	implicit def umlSignalEvent(c: Iterable[Uml#SignalEvent]): Iterable[UMLSignalEvent[Uml]] = for {e <- c} yield umlSignalEvent(e)
	implicit def umlSignalEvent(c: Seq[Uml#SignalEvent]): Seq[UMLSignalEvent[Uml]] = for {e <- c} yield umlSignalEvent(e)
	implicit def umlSignalEvent(c: Set[Uml#SignalEvent]): Set[UMLSignalEvent[Uml]] = for {e <- c} yield umlSignalEvent(e)

	implicit def umlSlot(e: Uml#Slot): UMLSlot[Uml]
	implicit def umlSlot(c: Iterable[Uml#Slot]): Iterable[UMLSlot[Uml]] = for {e <- c} yield umlSlot(e)
	implicit def umlSlot(c: Seq[Uml#Slot]): Seq[UMLSlot[Uml]] = for {e <- c} yield umlSlot(e)
	implicit def umlSlot(c: Set[Uml#Slot]): Set[UMLSlot[Uml]] = for {e <- c} yield umlSlot(e)

	implicit def umlStartClassifierBehaviorAction(e: Uml#StartClassifierBehaviorAction): UMLStartClassifierBehaviorAction[Uml]
	implicit def umlStartClassifierBehaviorAction(c: Iterable[Uml#StartClassifierBehaviorAction]): Iterable[UMLStartClassifierBehaviorAction[Uml]] = for {e <- c} yield umlStartClassifierBehaviorAction(e)
	implicit def umlStartClassifierBehaviorAction(c: Seq[Uml#StartClassifierBehaviorAction]): Seq[UMLStartClassifierBehaviorAction[Uml]] = for {e <- c} yield umlStartClassifierBehaviorAction(e)
	implicit def umlStartClassifierBehaviorAction(c: Set[Uml#StartClassifierBehaviorAction]): Set[UMLStartClassifierBehaviorAction[Uml]] = for {e <- c} yield umlStartClassifierBehaviorAction(e)

	implicit def umlStartObjectBehaviorAction(e: Uml#StartObjectBehaviorAction): UMLStartObjectBehaviorAction[Uml]
	implicit def umlStartObjectBehaviorAction(c: Iterable[Uml#StartObjectBehaviorAction]): Iterable[UMLStartObjectBehaviorAction[Uml]] = for {e <- c} yield umlStartObjectBehaviorAction(e)
	implicit def umlStartObjectBehaviorAction(c: Seq[Uml#StartObjectBehaviorAction]): Seq[UMLStartObjectBehaviorAction[Uml]] = for {e <- c} yield umlStartObjectBehaviorAction(e)
	implicit def umlStartObjectBehaviorAction(c: Set[Uml#StartObjectBehaviorAction]): Set[UMLStartObjectBehaviorAction[Uml]] = for {e <- c} yield umlStartObjectBehaviorAction(e)

	implicit def umlState(e: Uml#State): UMLState[Uml]
	implicit def umlState(c: Iterable[Uml#State]): Iterable[UMLState[Uml]] = for {e <- c} yield umlState(e)
	implicit def umlState(c: Seq[Uml#State]): Seq[UMLState[Uml]] = for {e <- c} yield umlState(e)
	implicit def umlState(c: Set[Uml#State]): Set[UMLState[Uml]] = for {e <- c} yield umlState(e)

	implicit def umlStateInvariant(e: Uml#StateInvariant): UMLStateInvariant[Uml]
	implicit def umlStateInvariant(c: Iterable[Uml#StateInvariant]): Iterable[UMLStateInvariant[Uml]] = for {e <- c} yield umlStateInvariant(e)
	implicit def umlStateInvariant(c: Seq[Uml#StateInvariant]): Seq[UMLStateInvariant[Uml]] = for {e <- c} yield umlStateInvariant(e)
	implicit def umlStateInvariant(c: Set[Uml#StateInvariant]): Set[UMLStateInvariant[Uml]] = for {e <- c} yield umlStateInvariant(e)

	implicit def umlStateMachine(e: Uml#StateMachine): UMLStateMachine[Uml]
	implicit def umlStateMachine(c: Iterable[Uml#StateMachine]): Iterable[UMLStateMachine[Uml]] = for {e <- c} yield umlStateMachine(e)
	implicit def umlStateMachine(c: Seq[Uml#StateMachine]): Seq[UMLStateMachine[Uml]] = for {e <- c} yield umlStateMachine(e)
	implicit def umlStateMachine(c: Set[Uml#StateMachine]): Set[UMLStateMachine[Uml]] = for {e <- c} yield umlStateMachine(e)

	implicit def umlStereotype(e: Uml#Stereotype): UMLStereotype[Uml]
	implicit def umlStereotype(c: Iterable[Uml#Stereotype]): Iterable[UMLStereotype[Uml]] = for {e <- c} yield umlStereotype(e)
	implicit def umlStereotype(c: Seq[Uml#Stereotype]): Seq[UMLStereotype[Uml]] = for {e <- c} yield umlStereotype(e)
	implicit def umlStereotype(c: Set[Uml#Stereotype]): Set[UMLStereotype[Uml]] = for {e <- c} yield umlStereotype(e)

	implicit def umlStringExpression(e: Uml#StringExpression): UMLStringExpression[Uml]
	implicit def umlStringExpression(c: Iterable[Uml#StringExpression]): Iterable[UMLStringExpression[Uml]] = for {e <- c} yield umlStringExpression(e)
	implicit def umlStringExpression(c: Seq[Uml#StringExpression]): Seq[UMLStringExpression[Uml]] = for {e <- c} yield umlStringExpression(e)
	implicit def umlStringExpression(c: Set[Uml#StringExpression]): Set[UMLStringExpression[Uml]] = for {e <- c} yield umlStringExpression(e)

	implicit def umlStructuralFeature(e: Uml#StructuralFeature): UMLStructuralFeature[Uml]
	implicit def umlStructuralFeature(c: Iterable[Uml#StructuralFeature]): Iterable[UMLStructuralFeature[Uml]] = for {e <- c} yield umlStructuralFeature(e)
	implicit def umlStructuralFeature(c: Seq[Uml#StructuralFeature]): Seq[UMLStructuralFeature[Uml]] = for {e <- c} yield umlStructuralFeature(e)
	implicit def umlStructuralFeature(c: Set[Uml#StructuralFeature]): Set[UMLStructuralFeature[Uml]] = for {e <- c} yield umlStructuralFeature(e)

	implicit def umlStructuralFeatureAction(e: Uml#StructuralFeatureAction): UMLStructuralFeatureAction[Uml]
	implicit def umlStructuralFeatureAction(c: Iterable[Uml#StructuralFeatureAction]): Iterable[UMLStructuralFeatureAction[Uml]] = for {e <- c} yield umlStructuralFeatureAction(e)
	implicit def umlStructuralFeatureAction(c: Seq[Uml#StructuralFeatureAction]): Seq[UMLStructuralFeatureAction[Uml]] = for {e <- c} yield umlStructuralFeatureAction(e)
	implicit def umlStructuralFeatureAction(c: Set[Uml#StructuralFeatureAction]): Set[UMLStructuralFeatureAction[Uml]] = for {e <- c} yield umlStructuralFeatureAction(e)

	implicit def umlStructuredActivityNode(e: Uml#StructuredActivityNode): UMLStructuredActivityNode[Uml]
	implicit def umlStructuredActivityNode(c: Iterable[Uml#StructuredActivityNode]): Iterable[UMLStructuredActivityNode[Uml]] = for {e <- c} yield umlStructuredActivityNode(e)
	implicit def umlStructuredActivityNode(c: Seq[Uml#StructuredActivityNode]): Seq[UMLStructuredActivityNode[Uml]] = for {e <- c} yield umlStructuredActivityNode(e)
	implicit def umlStructuredActivityNode(c: Set[Uml#StructuredActivityNode]): Set[UMLStructuredActivityNode[Uml]] = for {e <- c} yield umlStructuredActivityNode(e)

	implicit def umlStructuredClassifier(e: Uml#StructuredClassifier): UMLStructuredClassifier[Uml]
	implicit def umlStructuredClassifier(c: Iterable[Uml#StructuredClassifier]): Iterable[UMLStructuredClassifier[Uml]] = for {e <- c} yield umlStructuredClassifier(e)
	implicit def umlStructuredClassifier(c: Seq[Uml#StructuredClassifier]): Seq[UMLStructuredClassifier[Uml]] = for {e <- c} yield umlStructuredClassifier(e)
	implicit def umlStructuredClassifier(c: Set[Uml#StructuredClassifier]): Set[UMLStructuredClassifier[Uml]] = for {e <- c} yield umlStructuredClassifier(e)

	implicit def umlSubstitution(e: Uml#Substitution): UMLSubstitution[Uml]
	implicit def umlSubstitution(c: Iterable[Uml#Substitution]): Iterable[UMLSubstitution[Uml]] = for {e <- c} yield umlSubstitution(e)
	implicit def umlSubstitution(c: Seq[Uml#Substitution]): Seq[UMLSubstitution[Uml]] = for {e <- c} yield umlSubstitution(e)
	implicit def umlSubstitution(c: Set[Uml#Substitution]): Set[UMLSubstitution[Uml]] = for {e <- c} yield umlSubstitution(e)

	implicit def umlTemplateBinding(e: Uml#TemplateBinding): UMLTemplateBinding[Uml]
	implicit def umlTemplateBinding(c: Iterable[Uml#TemplateBinding]): Iterable[UMLTemplateBinding[Uml]] = for {e <- c} yield umlTemplateBinding(e)
	implicit def umlTemplateBinding(c: Seq[Uml#TemplateBinding]): Seq[UMLTemplateBinding[Uml]] = for {e <- c} yield umlTemplateBinding(e)
	implicit def umlTemplateBinding(c: Set[Uml#TemplateBinding]): Set[UMLTemplateBinding[Uml]] = for {e <- c} yield umlTemplateBinding(e)

	implicit def umlTemplateParameter(e: Uml#TemplateParameter): UMLTemplateParameter[Uml]
	implicit def umlTemplateParameter(c: Iterable[Uml#TemplateParameter]): Iterable[UMLTemplateParameter[Uml]] = for {e <- c} yield umlTemplateParameter(e)
	implicit def umlTemplateParameter(c: Seq[Uml#TemplateParameter]): Seq[UMLTemplateParameter[Uml]] = for {e <- c} yield umlTemplateParameter(e)
	implicit def umlTemplateParameter(c: Set[Uml#TemplateParameter]): Set[UMLTemplateParameter[Uml]] = for {e <- c} yield umlTemplateParameter(e)

	implicit def umlTemplateParameterSubstitution(e: Uml#TemplateParameterSubstitution): UMLTemplateParameterSubstitution[Uml]
	implicit def umlTemplateParameterSubstitution(c: Iterable[Uml#TemplateParameterSubstitution]): Iterable[UMLTemplateParameterSubstitution[Uml]] = for {e <- c} yield umlTemplateParameterSubstitution(e)
	implicit def umlTemplateParameterSubstitution(c: Seq[Uml#TemplateParameterSubstitution]): Seq[UMLTemplateParameterSubstitution[Uml]] = for {e <- c} yield umlTemplateParameterSubstitution(e)
	implicit def umlTemplateParameterSubstitution(c: Set[Uml#TemplateParameterSubstitution]): Set[UMLTemplateParameterSubstitution[Uml]] = for {e <- c} yield umlTemplateParameterSubstitution(e)

	implicit def umlTemplateSignature(e: Uml#TemplateSignature): UMLTemplateSignature[Uml]
	implicit def umlTemplateSignature(c: Iterable[Uml#TemplateSignature]): Iterable[UMLTemplateSignature[Uml]] = for {e <- c} yield umlTemplateSignature(e)
	implicit def umlTemplateSignature(c: Seq[Uml#TemplateSignature]): Seq[UMLTemplateSignature[Uml]] = for {e <- c} yield umlTemplateSignature(e)
	implicit def umlTemplateSignature(c: Set[Uml#TemplateSignature]): Set[UMLTemplateSignature[Uml]] = for {e <- c} yield umlTemplateSignature(e)

	implicit def umlTemplateableElement(e: Uml#TemplateableElement): UMLTemplateableElement[Uml]
	implicit def umlTemplateableElement(c: Iterable[Uml#TemplateableElement]): Iterable[UMLTemplateableElement[Uml]] = for {e <- c} yield umlTemplateableElement(e)
	implicit def umlTemplateableElement(c: Seq[Uml#TemplateableElement]): Seq[UMLTemplateableElement[Uml]] = for {e <- c} yield umlTemplateableElement(e)
	implicit def umlTemplateableElement(c: Set[Uml#TemplateableElement]): Set[UMLTemplateableElement[Uml]] = for {e <- c} yield umlTemplateableElement(e)

	implicit def umlTestIdentityAction(e: Uml#TestIdentityAction): UMLTestIdentityAction[Uml]
	implicit def umlTestIdentityAction(c: Iterable[Uml#TestIdentityAction]): Iterable[UMLTestIdentityAction[Uml]] = for {e <- c} yield umlTestIdentityAction(e)
	implicit def umlTestIdentityAction(c: Seq[Uml#TestIdentityAction]): Seq[UMLTestIdentityAction[Uml]] = for {e <- c} yield umlTestIdentityAction(e)
	implicit def umlTestIdentityAction(c: Set[Uml#TestIdentityAction]): Set[UMLTestIdentityAction[Uml]] = for {e <- c} yield umlTestIdentityAction(e)

	implicit def umlTimeConstraint(e: Uml#TimeConstraint): UMLTimeConstraint[Uml]
	implicit def umlTimeConstraint(c: Iterable[Uml#TimeConstraint]): Iterable[UMLTimeConstraint[Uml]] = for {e <- c} yield umlTimeConstraint(e)
	implicit def umlTimeConstraint(c: Seq[Uml#TimeConstraint]): Seq[UMLTimeConstraint[Uml]] = for {e <- c} yield umlTimeConstraint(e)
	implicit def umlTimeConstraint(c: Set[Uml#TimeConstraint]): Set[UMLTimeConstraint[Uml]] = for {e <- c} yield umlTimeConstraint(e)

	implicit def umlTimeEvent(e: Uml#TimeEvent): UMLTimeEvent[Uml]
	implicit def umlTimeEvent(c: Iterable[Uml#TimeEvent]): Iterable[UMLTimeEvent[Uml]] = for {e <- c} yield umlTimeEvent(e)
	implicit def umlTimeEvent(c: Seq[Uml#TimeEvent]): Seq[UMLTimeEvent[Uml]] = for {e <- c} yield umlTimeEvent(e)
	implicit def umlTimeEvent(c: Set[Uml#TimeEvent]): Set[UMLTimeEvent[Uml]] = for {e <- c} yield umlTimeEvent(e)

	implicit def umlTimeExpression(e: Uml#TimeExpression): UMLTimeExpression[Uml]
	implicit def umlTimeExpression(c: Iterable[Uml#TimeExpression]): Iterable[UMLTimeExpression[Uml]] = for {e <- c} yield umlTimeExpression(e)
	implicit def umlTimeExpression(c: Seq[Uml#TimeExpression]): Seq[UMLTimeExpression[Uml]] = for {e <- c} yield umlTimeExpression(e)
	implicit def umlTimeExpression(c: Set[Uml#TimeExpression]): Set[UMLTimeExpression[Uml]] = for {e <- c} yield umlTimeExpression(e)

	implicit def umlTimeInterval(e: Uml#TimeInterval): UMLTimeInterval[Uml]
	implicit def umlTimeInterval(c: Iterable[Uml#TimeInterval]): Iterable[UMLTimeInterval[Uml]] = for {e <- c} yield umlTimeInterval(e)
	implicit def umlTimeInterval(c: Seq[Uml#TimeInterval]): Seq[UMLTimeInterval[Uml]] = for {e <- c} yield umlTimeInterval(e)
	implicit def umlTimeInterval(c: Set[Uml#TimeInterval]): Set[UMLTimeInterval[Uml]] = for {e <- c} yield umlTimeInterval(e)

	implicit def umlTimeObservation(e: Uml#TimeObservation): UMLTimeObservation[Uml]
	implicit def umlTimeObservation(c: Iterable[Uml#TimeObservation]): Iterable[UMLTimeObservation[Uml]] = for {e <- c} yield umlTimeObservation(e)
	implicit def umlTimeObservation(c: Seq[Uml#TimeObservation]): Seq[UMLTimeObservation[Uml]] = for {e <- c} yield umlTimeObservation(e)
	implicit def umlTimeObservation(c: Set[Uml#TimeObservation]): Set[UMLTimeObservation[Uml]] = for {e <- c} yield umlTimeObservation(e)

	implicit def umlTransition(e: Uml#Transition): UMLTransition[Uml]
	implicit def umlTransition(c: Iterable[Uml#Transition]): Iterable[UMLTransition[Uml]] = for {e <- c} yield umlTransition(e)
	implicit def umlTransition(c: Seq[Uml#Transition]): Seq[UMLTransition[Uml]] = for {e <- c} yield umlTransition(e)
	implicit def umlTransition(c: Set[Uml#Transition]): Set[UMLTransition[Uml]] = for {e <- c} yield umlTransition(e)

	implicit def umlTrigger(e: Uml#Trigger): UMLTrigger[Uml]
	implicit def umlTrigger(c: Iterable[Uml#Trigger]): Iterable[UMLTrigger[Uml]] = for {e <- c} yield umlTrigger(e)
	implicit def umlTrigger(c: Seq[Uml#Trigger]): Seq[UMLTrigger[Uml]] = for {e <- c} yield umlTrigger(e)
	implicit def umlTrigger(c: Set[Uml#Trigger]): Set[UMLTrigger[Uml]] = for {e <- c} yield umlTrigger(e)

	implicit def umlType(e: Uml#Type): UMLType[Uml]
	implicit def umlType(c: Iterable[Uml#Type]): Iterable[UMLType[Uml]] = for {e <- c} yield umlType(e)
	implicit def umlType(c: Seq[Uml#Type]): Seq[UMLType[Uml]] = for {e <- c} yield umlType(e)
	implicit def umlType(c: Set[Uml#Type]): Set[UMLType[Uml]] = for {e <- c} yield umlType(e)

	implicit def umlTypedElement(e: Uml#TypedElement): UMLTypedElement[Uml]
	implicit def umlTypedElement(c: Iterable[Uml#TypedElement]): Iterable[UMLTypedElement[Uml]] = for {e <- c} yield umlTypedElement(e)
	implicit def umlTypedElement(c: Seq[Uml#TypedElement]): Seq[UMLTypedElement[Uml]] = for {e <- c} yield umlTypedElement(e)
	implicit def umlTypedElement(c: Set[Uml#TypedElement]): Set[UMLTypedElement[Uml]] = for {e <- c} yield umlTypedElement(e)

	implicit def umlUnmarshallAction(e: Uml#UnmarshallAction): UMLUnmarshallAction[Uml]
	implicit def umlUnmarshallAction(c: Iterable[Uml#UnmarshallAction]): Iterable[UMLUnmarshallAction[Uml]] = for {e <- c} yield umlUnmarshallAction(e)
	implicit def umlUnmarshallAction(c: Seq[Uml#UnmarshallAction]): Seq[UMLUnmarshallAction[Uml]] = for {e <- c} yield umlUnmarshallAction(e)
	implicit def umlUnmarshallAction(c: Set[Uml#UnmarshallAction]): Set[UMLUnmarshallAction[Uml]] = for {e <- c} yield umlUnmarshallAction(e)

	implicit def umlUsage(e: Uml#Usage): UMLUsage[Uml]
	implicit def umlUsage(c: Iterable[Uml#Usage]): Iterable[UMLUsage[Uml]] = for {e <- c} yield umlUsage(e)
	implicit def umlUsage(c: Seq[Uml#Usage]): Seq[UMLUsage[Uml]] = for {e <- c} yield umlUsage(e)
	implicit def umlUsage(c: Set[Uml#Usage]): Set[UMLUsage[Uml]] = for {e <- c} yield umlUsage(e)

	implicit def umlUseCase(e: Uml#UseCase): UMLUseCase[Uml]
	implicit def umlUseCase(c: Iterable[Uml#UseCase]): Iterable[UMLUseCase[Uml]] = for {e <- c} yield umlUseCase(e)
	implicit def umlUseCase(c: Seq[Uml#UseCase]): Seq[UMLUseCase[Uml]] = for {e <- c} yield umlUseCase(e)
	implicit def umlUseCase(c: Set[Uml#UseCase]): Set[UMLUseCase[Uml]] = for {e <- c} yield umlUseCase(e)

	implicit def umlValuePin(e: Uml#ValuePin): UMLValuePin[Uml]
	implicit def umlValuePin(c: Iterable[Uml#ValuePin]): Iterable[UMLValuePin[Uml]] = for {e <- c} yield umlValuePin(e)
	implicit def umlValuePin(c: Seq[Uml#ValuePin]): Seq[UMLValuePin[Uml]] = for {e <- c} yield umlValuePin(e)
	implicit def umlValuePin(c: Set[Uml#ValuePin]): Set[UMLValuePin[Uml]] = for {e <- c} yield umlValuePin(e)

	implicit def umlValueSpecification(e: Uml#ValueSpecification): UMLValueSpecification[Uml]
	implicit def umlValueSpecification(c: Iterable[Uml#ValueSpecification]): Iterable[UMLValueSpecification[Uml]] = for {e <- c} yield umlValueSpecification(e)
	implicit def umlValueSpecification(c: Seq[Uml#ValueSpecification]): Seq[UMLValueSpecification[Uml]] = for {e <- c} yield umlValueSpecification(e)
	implicit def umlValueSpecification(c: Set[Uml#ValueSpecification]): Set[UMLValueSpecification[Uml]] = for {e <- c} yield umlValueSpecification(e)

	implicit def umlValueSpecificationAction(e: Uml#ValueSpecificationAction): UMLValueSpecificationAction[Uml]
	implicit def umlValueSpecificationAction(c: Iterable[Uml#ValueSpecificationAction]): Iterable[UMLValueSpecificationAction[Uml]] = for {e <- c} yield umlValueSpecificationAction(e)
	implicit def umlValueSpecificationAction(c: Seq[Uml#ValueSpecificationAction]): Seq[UMLValueSpecificationAction[Uml]] = for {e <- c} yield umlValueSpecificationAction(e)
	implicit def umlValueSpecificationAction(c: Set[Uml#ValueSpecificationAction]): Set[UMLValueSpecificationAction[Uml]] = for {e <- c} yield umlValueSpecificationAction(e)

	implicit def umlVariable(e: Uml#Variable): UMLVariable[Uml]
	implicit def umlVariable(c: Iterable[Uml#Variable]): Iterable[UMLVariable[Uml]] = for {e <- c} yield umlVariable(e)
	implicit def umlVariable(c: Seq[Uml#Variable]): Seq[UMLVariable[Uml]] = for {e <- c} yield umlVariable(e)
	implicit def umlVariable(c: Set[Uml#Variable]): Set[UMLVariable[Uml]] = for {e <- c} yield umlVariable(e)

	implicit def umlVariableAction(e: Uml#VariableAction): UMLVariableAction[Uml]
	implicit def umlVariableAction(c: Iterable[Uml#VariableAction]): Iterable[UMLVariableAction[Uml]] = for {e <- c} yield umlVariableAction(e)
	implicit def umlVariableAction(c: Seq[Uml#VariableAction]): Seq[UMLVariableAction[Uml]] = for {e <- c} yield umlVariableAction(e)
	implicit def umlVariableAction(c: Set[Uml#VariableAction]): Set[UMLVariableAction[Uml]] = for {e <- c} yield umlVariableAction(e)

	implicit def umlVertex(e: Uml#Vertex): UMLVertex[Uml]
	implicit def umlVertex(c: Iterable[Uml#Vertex]): Iterable[UMLVertex[Uml]] = for {e <- c} yield umlVertex(e)
	implicit def umlVertex(c: Seq[Uml#Vertex]): Seq[UMLVertex[Uml]] = for {e <- c} yield umlVertex(e)
	implicit def umlVertex(c: Set[Uml#Vertex]): Set[UMLVertex[Uml]] = for {e <- c} yield umlVertex(e)

	implicit def umlWriteLinkAction(e: Uml#WriteLinkAction): UMLWriteLinkAction[Uml]
	implicit def umlWriteLinkAction(c: Iterable[Uml#WriteLinkAction]): Iterable[UMLWriteLinkAction[Uml]] = for {e <- c} yield umlWriteLinkAction(e)
	implicit def umlWriteLinkAction(c: Seq[Uml#WriteLinkAction]): Seq[UMLWriteLinkAction[Uml]] = for {e <- c} yield umlWriteLinkAction(e)
	implicit def umlWriteLinkAction(c: Set[Uml#WriteLinkAction]): Set[UMLWriteLinkAction[Uml]] = for {e <- c} yield umlWriteLinkAction(e)

	implicit def umlWriteStructuralFeatureAction(e: Uml#WriteStructuralFeatureAction): UMLWriteStructuralFeatureAction[Uml]
	implicit def umlWriteStructuralFeatureAction(c: Iterable[Uml#WriteStructuralFeatureAction]): Iterable[UMLWriteStructuralFeatureAction[Uml]] = for {e <- c} yield umlWriteStructuralFeatureAction(e)
	implicit def umlWriteStructuralFeatureAction(c: Seq[Uml#WriteStructuralFeatureAction]): Seq[UMLWriteStructuralFeatureAction[Uml]] = for {e <- c} yield umlWriteStructuralFeatureAction(e)
	implicit def umlWriteStructuralFeatureAction(c: Set[Uml#WriteStructuralFeatureAction]): Set[UMLWriteStructuralFeatureAction[Uml]] = for {e <- c} yield umlWriteStructuralFeatureAction(e)

	implicit def umlWriteVariableAction(e: Uml#WriteVariableAction): UMLWriteVariableAction[Uml]
	implicit def umlWriteVariableAction(c: Iterable[Uml#WriteVariableAction]): Iterable[UMLWriteVariableAction[Uml]] = for {e <- c} yield umlWriteVariableAction(e)
	implicit def umlWriteVariableAction(c: Seq[Uml#WriteVariableAction]): Seq[UMLWriteVariableAction[Uml]] = for {e <- c} yield umlWriteVariableAction(e)
	implicit def umlWriteVariableAction(c: Set[Uml#WriteVariableAction]): Set[UMLWriteVariableAction[Uml]] = for {e <- c} yield umlWriteVariableAction(e)

	val Abstraction_mapping =
		MetaPropertyReference[Uml, UMLAbstraction[Uml], UMLOpaqueExpression[Uml]](
		"mapping", _.mapping, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val AcceptCallAction_returnInformation =
		MetaPropertyReference[Uml, UMLAcceptCallAction[Uml], UMLOutputPin[Uml]](
		"returnInformation", _.returnInformation, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val AcceptEventAction_isUnmarshall =
		MetaAttributeBooleanFunction[Uml, UMLAcceptEventAction[Uml]](None, "isUnmarshall",
		(x) => booleanToIterable(x.isUnmarshall, false))

	val AcceptEventAction_result =
		MetaPropertyCollection[Uml, UMLAcceptEventAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val AcceptEventAction_trigger =
		MetaPropertyCollection[Uml, UMLAcceptEventAction[Uml], UMLTrigger[Uml]](
		"trigger", _.trigger, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Action_isLocallyReentrant =
		MetaAttributeBooleanFunction[Uml, UMLAction[Uml]](None, "isLocallyReentrant",
		(x) => booleanToIterable(x.isLocallyReentrant, false))

	val Action_localPostcondition =
		MetaPropertyCollection[Uml, UMLAction[Uml], UMLConstraint[Uml]](
		"localPostcondition", _.localPostcondition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Action_localPrecondition =
		MetaPropertyCollection[Uml, UMLAction[Uml], UMLConstraint[Uml]](
		"localPrecondition", _.localPrecondition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ActionExecutionSpecification_action =
		MetaPropertyReference[Uml, UMLActionExecutionSpecification[Uml], UMLAction[Uml]](
		"action", _.action, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActionInputPin_fromAction =
		MetaPropertyReference[Uml, UMLActionInputPin[Uml], UMLAction[Uml]](
		"fromAction", _.fromAction, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Activity_edge =
		MetaPropertyCollection[Uml, UMLActivity[Uml], UMLActivityEdge[Uml]](
		"edge", _.edge, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Activity_group =
		MetaPropertyCollection[Uml, UMLActivity[Uml], UMLActivityGroup[Uml]](
		"group", _.group, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Activity_isReadOnly =
		MetaAttributeBooleanFunction[Uml, UMLActivity[Uml]](None, "isReadOnly",
		(x) => booleanToIterable(x.isReadOnly, false))

	val Activity_isSingleExecution =
		MetaAttributeBooleanFunction[Uml, UMLActivity[Uml]](None, "isSingleExecution",
		(x) => booleanToIterable(x.isSingleExecution, false))

	val Activity_node =
		MetaPropertyCollection[Uml, UMLActivity[Uml], UMLActivityNode[Uml]](
		"node", _.node, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Activity_partition =
		MetaPropertyCollection[Uml, UMLActivity[Uml], UMLActivityPartition[Uml]](
		"partition", _.partition, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Activity_structuredNode =
		MetaPropertyCollection[Uml, UMLActivity[Uml], UMLStructuredActivityNode[Uml]](
		"structuredNode", _.structuredNode, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Activity_variable =
		MetaPropertyCollection[Uml, UMLActivity[Uml], UMLVariable[Uml]](
		"variable", _.variable, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ActivityEdge_guard =
		MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLValueSpecification[Uml]](
		"guard", _.guard, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ActivityEdge_inPartition =
		MetaPropertyCollection[Uml, UMLActivityEdge[Uml], UMLActivityPartition[Uml]](
		"inPartition", _.inPartition, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityEdge_interrupts =
		MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLInterruptibleActivityRegion[Uml]](
		"interrupts", _.interrupts, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityEdge_redefinedEdge =
		MetaPropertyCollection[Uml, UMLActivityEdge[Uml], UMLActivityEdge[Uml]](
		"redefinedEdge", _.redefinedEdge, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityEdge_source =
		MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLActivityNode[Uml]](
		"source", _.source, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityEdge_target =
		MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLActivityNode[Uml]](
		"target", _.target, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityEdge_weight =
		MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLValueSpecification[Uml]](
		"weight", _.weight, isComposite=true, isUnique=true, isOrdered=false,
		Set())


	val ActivityNode_inInterruptibleRegion =
		MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLInterruptibleActivityRegion[Uml]](
		"inInterruptibleRegion", _.inInterruptibleRegion, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityNode_inPartition =
		MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLActivityPartition[Uml]](
		"inPartition", _.inPartition, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityNode_incoming =
		MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLActivityEdge[Uml]](
		"incoming", _.incoming, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityNode_outgoing =
		MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLActivityEdge[Uml]](
		"outgoing", _.outgoing, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityNode_redefinedNode =
		MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLActivityNode[Uml]](
		"redefinedNode", _.redefinedNode, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityParameterNode_parameter =
		MetaPropertyReference[Uml, UMLActivityParameterNode[Uml], UMLParameter[Uml]](
		"parameter", _.parameter, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityPartition_edge =
		MetaPropertyCollection[Uml, UMLActivityPartition[Uml], UMLActivityEdge[Uml]](
		"edge", _.edge, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityPartition_isDimension =
		MetaAttributeBooleanFunction[Uml, UMLActivityPartition[Uml]](None, "isDimension",
		(x) => booleanToIterable(x.isDimension, false))

	val ActivityPartition_isExternal =
		MetaAttributeBooleanFunction[Uml, UMLActivityPartition[Uml]](None, "isExternal",
		(x) => booleanToIterable(x.isExternal, false))

	val ActivityPartition_node =
		MetaPropertyCollection[Uml, UMLActivityPartition[Uml], UMLActivityNode[Uml]](
		"node", _.node, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityPartition_represents =
		MetaPropertyReference[Uml, UMLActivityPartition[Uml], UMLElement[Uml]](
		"represents", _.represents, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ActivityPartition_subpartition =
		MetaPropertyCollection[Uml, UMLActivityPartition[Uml], UMLActivityPartition[Uml]](
		"subpartition", _.subpartition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val AddStructuralFeatureValueAction_insertAt =
		MetaPropertyReference[Uml, UMLAddStructuralFeatureValueAction[Uml], UMLInputPin[Uml]](
		"insertAt", _.insertAt, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val AddStructuralFeatureValueAction_isReplaceAll =
		MetaAttributeBooleanFunction[Uml, UMLAddStructuralFeatureValueAction[Uml]](None, "isReplaceAll",
		(x) => booleanToIterable(x.isReplaceAll, false))

	val AddVariableValueAction_insertAt =
		MetaPropertyReference[Uml, UMLAddVariableValueAction[Uml], UMLInputPin[Uml]](
		"insertAt", _.insertAt, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val AddVariableValueAction_isReplaceAll =
		MetaAttributeBooleanFunction[Uml, UMLAddVariableValueAction[Uml]](None, "isReplaceAll",
		(x) => booleanToIterable(x.isReplaceAll, false))

	val Artifact_fileName =
		new MetaAttributeStringFunction[Uml, UMLArtifact[Uml]](OptionConstructor(), None, "fileName",
		(x: UMLArtifact[Uml]) => x.fileName)

	val Artifact_manifestation =
		MetaPropertyCollection[Uml, UMLArtifact[Uml], UMLManifestation[Uml]](
		"manifestation", _.manifestation, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Artifact_nestedArtifact =
		MetaPropertyCollection[Uml, UMLArtifact[Uml], UMLArtifact[Uml]](
		"nestedArtifact", _.nestedArtifact, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Artifact_ownedAttribute =
		MetaPropertyCollection[Uml, UMLArtifact[Uml], UMLProperty[Uml]](
		"ownedAttribute", _.ownedAttribute, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Artifact_ownedOperation =
		MetaPropertyCollection[Uml, UMLArtifact[Uml], UMLOperation[Uml]](
		"ownedOperation", _.ownedOperation, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Association_isDerived =
		MetaAttributeBooleanFunction[Uml, UMLAssociation[Uml]](None, "isDerived",
		(x) => booleanToIterable(x.isDerived, false))

	val Association_memberEnd =
		MetaPropertyCollection[Uml, UMLAssociation[Uml], UMLProperty[Uml]](
		"memberEnd", _.memberEnd, isComposite=false, isUnique=true, isOrdered=true,
		Set())

	val Association_navigableOwnedEnd =
		MetaPropertyCollection[Uml, UMLAssociation[Uml], UMLProperty[Uml]](
		"navigableOwnedEnd", _.navigableOwnedEnd, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Association_ownedEnd =
		MetaPropertyCollection[Uml, UMLAssociation[Uml], UMLProperty[Uml]](
		"ownedEnd", _.ownedEnd, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Behavior_isReentrant =
		MetaAttributeBooleanFunction[Uml, UMLBehavior[Uml]](None, "isReentrant",
		(x) => booleanToIterable(x.isReentrant, true))

	val Behavior_ownedParameter =
		MetaPropertyCollection[Uml, UMLBehavior[Uml], UMLParameter[Uml]](
		"ownedParameter", _.ownedParameter, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Behavior_ownedParameterSet =
		MetaPropertyCollection[Uml, UMLBehavior[Uml], UMLParameterSet[Uml]](
		"ownedParameterSet", _.ownedParameterSet, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Behavior_postcondition =
		MetaPropertyCollection[Uml, UMLBehavior[Uml], UMLConstraint[Uml]](
		"postcondition", _.postcondition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Behavior_precondition =
		MetaPropertyCollection[Uml, UMLBehavior[Uml], UMLConstraint[Uml]](
		"precondition", _.precondition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Behavior_redefinedBehavior =
		MetaPropertyCollection[Uml, UMLBehavior[Uml], UMLBehavior[Uml]](
		"redefinedBehavior", _.redefinedBehavior, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Behavior_specification =
		MetaPropertyReference[Uml, UMLBehavior[Uml], UMLBehavioralFeature[Uml]](
		"specification", _.specification, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val BehaviorExecutionSpecification_behavior =
		MetaPropertyReference[Uml, UMLBehaviorExecutionSpecification[Uml], UMLBehavior[Uml]](
		"behavior", _.behavior, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val BehavioralFeature_concurrency =
		new MetaAttributeEnumerationFunction[Uml, UMLBehavioralFeature[Uml], UMLCallConcurrencyKind.Value, UMLCallConcurrencyKind.ValueSet](
		OptionConstructor(), None, "concurrency",
		(x: UMLBehavioralFeature[Uml]) => x.concurrency, UMLCallConcurrencyKind.values)

	val BehavioralFeature_isAbstract =
		MetaAttributeBooleanFunction[Uml, UMLBehavioralFeature[Uml]](None, "isAbstract",
		(x) => booleanToIterable(x.isAbstract, false))

	val BehavioralFeature_method =
		MetaPropertyCollection[Uml, UMLBehavioralFeature[Uml], UMLBehavior[Uml]](
		"method", _.method, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val BehavioralFeature_ownedParameter =
		MetaPropertyCollection[Uml, UMLBehavioralFeature[Uml], UMLParameter[Uml]](
		"ownedParameter", _.ownedParameter, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val BehavioralFeature_ownedParameterSet =
		MetaPropertyCollection[Uml, UMLBehavioralFeature[Uml], UMLParameterSet[Uml]](
		"ownedParameterSet", _.ownedParameterSet, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val BehavioralFeature_raisedException =
		MetaPropertyCollection[Uml, UMLBehavioralFeature[Uml], UMLType[Uml]](
		"raisedException", _.raisedException, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val BehavioredClassifier_classifierBehavior =
		MetaPropertyReference[Uml, UMLBehavioredClassifier[Uml], UMLBehavior[Uml]](
		"classifierBehavior", _.classifierBehavior, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val BehavioredClassifier_interfaceRealization =
		MetaPropertyCollection[Uml, UMLBehavioredClassifier[Uml], UMLInterfaceRealization[Uml]](
		"interfaceRealization", _.interfaceRealization, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val BehavioredClassifier_ownedBehavior =
		MetaPropertyCollection[Uml, UMLBehavioredClassifier[Uml], UMLBehavior[Uml]](
		"ownedBehavior", _.ownedBehavior, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val BroadcastSignalAction_signal =
		MetaPropertyReference[Uml, UMLBroadcastSignalAction[Uml], UMLSignal[Uml]](
		"signal", _.signal, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val CallAction_isSynchronous =
		MetaAttributeBooleanFunction[Uml, UMLCallAction[Uml]](None, "isSynchronous",
		(x) => booleanToIterable(x.isSynchronous, true))

	val CallAction_result =
		MetaPropertyCollection[Uml, UMLCallAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val CallBehaviorAction_behavior =
		MetaPropertyReference[Uml, UMLCallBehaviorAction[Uml], UMLBehavior[Uml]](
		"behavior", _.behavior, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val CallEvent_operation =
		MetaPropertyReference[Uml, UMLCallEvent[Uml], UMLOperation[Uml]](
		"operation", _.operation, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val CallOperationAction_operation =
		MetaPropertyReference[Uml, UMLCallOperationAction[Uml], UMLOperation[Uml]](
		"operation", _.operation, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val CallOperationAction_target =
		MetaPropertyReference[Uml, UMLCallOperationAction[Uml], UMLInputPin[Uml]](
		"target", _.target, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ChangeEvent_changeExpression =
		MetaPropertyReference[Uml, UMLChangeEvent[Uml], UMLValueSpecification[Uml]](
		"changeExpression", _.changeExpression, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Class_isAbstract =
		MetaAttributeBooleanFunction[Uml, UMLClass[Uml]](None, "isAbstract",
		(x) => booleanToIterable(x.isAbstract, false))

	val Class_isActive =
		MetaAttributeBooleanFunction[Uml, UMLClass[Uml]](None, "isActive",
		(x) => booleanToIterable(x.isActive, false))

	val Class_nestedClassifier =
		MetaPropertyCollection[Uml, UMLClass[Uml], UMLClassifier[Uml]](
		"nestedClassifier", _.nestedClassifier, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Class_ownedAttribute =
		MetaPropertyCollection[Uml, UMLClass[Uml], UMLProperty[Uml]](
		"ownedAttribute", _.ownedAttribute, isComposite=true, isUnique=true, isOrdered=true,
		Set(StructuredClassifier_ownedAttribute))

	val Class_ownedOperation =
		MetaPropertyCollection[Uml, UMLClass[Uml], UMLOperation[Uml]](
		"ownedOperation", _.ownedOperation, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Class_ownedReception =
		MetaPropertyCollection[Uml, UMLClass[Uml], UMLReception[Uml]](
		"ownedReception", _.ownedReception, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Classifier_collaborationUse =
		MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLCollaborationUse[Uml]](
		"collaborationUse", _.collaborationUse, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Classifier_generalization =
		MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLGeneralization[Uml]](
		"generalization", _.generalization, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Classifier_isAbstract =
		MetaAttributeBooleanFunction[Uml, UMLClassifier[Uml]](None, "isAbstract",
		(x) => booleanToIterable(x.isAbstract, false))

	val Classifier_isFinalSpecialization =
		MetaAttributeBooleanFunction[Uml, UMLClassifier[Uml]](None, "isFinalSpecialization",
		(x) => booleanToIterable(x.isFinalSpecialization, false))

	val Classifier_ownedTemplateSignature =
		MetaPropertyReference[Uml, UMLClassifier[Uml], UMLRedefinableTemplateSignature[Uml]](
		"ownedTemplateSignature", _.ownedTemplateSignature, isComposite=true, isUnique=true, isOrdered=false,
		Set(TemplateableElement_ownedTemplateSignature))

	val Classifier_ownedUseCase =
		MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLUseCase[Uml]](
		"ownedUseCase", _.ownedUseCase, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Classifier_powertypeExtent =
		MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLGeneralizationSet[Uml]](
		"powertypeExtent", _.powertypeExtent, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Classifier_redefinedClassifier =
		MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLClassifier[Uml]](
		"redefinedClassifier", _.redefinedClassifier, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Classifier_representation =
		MetaPropertyReference[Uml, UMLClassifier[Uml], UMLCollaborationUse[Uml]](
		"representation", _.representation, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Classifier_substitution =
		MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLSubstitution[Uml]](
		"substitution", _.substitution, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Classifier_templateParameter =
		MetaPropertyReference[Uml, UMLClassifier[Uml], UMLClassifierTemplateParameter[Uml]](
		"templateParameter", _.templateParameter, isComposite=false, isUnique=true, isOrdered=false,
		Set(ParameterableElement_templateParameter))

	val Classifier_useCase =
		MetaPropertyCollection[Uml, UMLClassifier[Uml], UMLUseCase[Uml]](
		"useCase", _.useCase, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ClassifierTemplateParameter_allowSubstitutable =
		MetaAttributeBooleanFunction[Uml, UMLClassifierTemplateParameter[Uml]](None, "allowSubstitutable",
		(x) => booleanToIterable(x.allowSubstitutable, true))

	val ClassifierTemplateParameter_constrainingClassifier =
		MetaPropertyCollection[Uml, UMLClassifierTemplateParameter[Uml], UMLClassifier[Uml]](
		"constrainingClassifier", _.constrainingClassifier, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ClassifierTemplateParameter_parameteredElement =
		MetaPropertyReference[Uml, UMLClassifierTemplateParameter[Uml], UMLClassifier[Uml]](
		"parameteredElement", _.parameteredElement, isComposite=false, isUnique=true, isOrdered=false,
		Set(TemplateParameter_parameteredElement))

	val Clause_body =
		MetaPropertyCollection[Uml, UMLClause[Uml], UMLExecutableNode[Uml]](
		"body", _.body, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Clause_bodyOutput =
		MetaPropertyCollection[Uml, UMLClause[Uml], UMLOutputPin[Uml]](
		"bodyOutput", _.bodyOutput, isComposite=false, isUnique=true, isOrdered=true,
		Set())

	val Clause_decider =
		MetaPropertyReference[Uml, UMLClause[Uml], UMLOutputPin[Uml]](
		"decider", _.decider, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Clause_predecessorClause =
		MetaPropertyCollection[Uml, UMLClause[Uml], UMLClause[Uml]](
		"predecessorClause", _.predecessorClause, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Clause_successorClause =
		MetaPropertyCollection[Uml, UMLClause[Uml], UMLClause[Uml]](
		"successorClause", _.successorClause, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Clause_test =
		MetaPropertyCollection[Uml, UMLClause[Uml], UMLExecutableNode[Uml]](
		"test", _.test, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ClearAssociationAction_association =
		MetaPropertyReference[Uml, UMLClearAssociationAction[Uml], UMLAssociation[Uml]](
		"association", _.association, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ClearAssociationAction_object =
		MetaPropertyReference[Uml, UMLClearAssociationAction[Uml], UMLInputPin[Uml]](
		"object", _._object, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ClearStructuralFeatureAction_result =
		MetaPropertyReference[Uml, UMLClearStructuralFeatureAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Collaboration_collaborationRole =
		MetaPropertyCollection[Uml, UMLCollaboration[Uml], UMLConnectableElement[Uml]](
		"collaborationRole", _.collaborationRole, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val CollaborationUse_roleBinding =
		MetaPropertyCollection[Uml, UMLCollaborationUse[Uml], UMLDependency[Uml]](
		"roleBinding", _.roleBinding, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val CollaborationUse_type =
		MetaPropertyReference[Uml, UMLCollaborationUse[Uml], UMLCollaboration[Uml]](
		"type", _._type, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val CombinedFragment_cfragmentGate =
		MetaPropertyCollection[Uml, UMLCombinedFragment[Uml], UMLGate[Uml]](
		"cfragmentGate", _.cfragmentGate, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val CombinedFragment_interactionOperator =
		new MetaAttributeEnumerationFunction[Uml, UMLCombinedFragment[Uml], UMLInteractionOperatorKind.Value, UMLInteractionOperatorKind.ValueSet](
		OptionConstructor(), None, "interactionOperator",
		(x: UMLCombinedFragment[Uml]) => x.interactionOperator, UMLInteractionOperatorKind.values)

	val CombinedFragment_operand =
		MetaPropertyCollection[Uml, UMLCombinedFragment[Uml], UMLInteractionOperand[Uml]](
		"operand", _.operand, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Comment_annotatedElement =
		MetaPropertyCollection[Uml, UMLComment[Uml], UMLElement[Uml]](
		"annotatedElement", _.annotatedElement, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Comment_body =
		new MetaAttributeStringFunction[Uml, UMLComment[Uml]](OptionConstructor(), None, "body",
		(x: UMLComment[Uml]) => x.body)

	val Component_isIndirectlyInstantiated =
		MetaAttributeBooleanFunction[Uml, UMLComponent[Uml]](None, "isIndirectlyInstantiated",
		(x) => booleanToIterable(x.isIndirectlyInstantiated, true))

	val Component_packagedElement =
		MetaPropertyCollection[Uml, UMLComponent[Uml], UMLPackageableElement[Uml]](
		"packagedElement", _.packagedElement, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Component_realization =
		MetaPropertyCollection[Uml, UMLComponent[Uml], UMLComponentRealization[Uml]](
		"realization", _.realization, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ComponentRealization_realizingClassifier =
		MetaPropertyCollection[Uml, UMLComponentRealization[Uml], UMLClassifier[Uml]](
		"realizingClassifier", _.realizingClassifier, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ConditionalNode_clause =
		MetaPropertyCollection[Uml, UMLConditionalNode[Uml], UMLClause[Uml]](
		"clause", _.clause, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ConditionalNode_isAssured =
		MetaAttributeBooleanFunction[Uml, UMLConditionalNode[Uml]](None, "isAssured",
		(x) => booleanToIterable(x.isAssured, false))

	val ConditionalNode_isDeterminate =
		MetaAttributeBooleanFunction[Uml, UMLConditionalNode[Uml]](None, "isDeterminate",
		(x) => booleanToIterable(x.isDeterminate, false))

	val ConditionalNode_result =
		MetaPropertyCollection[Uml, UMLConditionalNode[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=true,
		Set(StructuredActivityNode_structuredNodeOutput))

	val ConnectableElement_templateParameter =
		MetaPropertyReference[Uml, UMLConnectableElement[Uml], UMLConnectableElementTemplateParameter[Uml]](
		"templateParameter", _.templateParameter, isComposite=false, isUnique=true, isOrdered=false,
		Set(ParameterableElement_templateParameter))

	val ConnectableElementTemplateParameter_parameteredElement =
		MetaPropertyReference[Uml, UMLConnectableElementTemplateParameter[Uml], UMLConnectableElement[Uml]](
		"parameteredElement", _.parameteredElement, isComposite=false, isUnique=true, isOrdered=false,
		Set(TemplateParameter_parameteredElement))

	val ConnectionPointReference_entry =
		MetaPropertyCollection[Uml, UMLConnectionPointReference[Uml], UMLPseudostate[Uml]](
		"entry", _.entry, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ConnectionPointReference_exit =
		MetaPropertyCollection[Uml, UMLConnectionPointReference[Uml], UMLPseudostate[Uml]](
		"exit", _.exit, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Connector_contract =
		MetaPropertyCollection[Uml, UMLConnector[Uml], UMLBehavior[Uml]](
		"contract", _.contract, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Connector_end =
		MetaPropertyCollection[Uml, UMLConnector[Uml], UMLConnectorEnd[Uml]](
		"end", _.end, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Connector_redefinedConnector =
		MetaPropertyCollection[Uml, UMLConnector[Uml], UMLConnector[Uml]](
		"redefinedConnector", _.redefinedConnector, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Connector_type =
		MetaPropertyReference[Uml, UMLConnector[Uml], UMLAssociation[Uml]](
		"type", _._type, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ConnectorEnd_partWithPort =
		MetaPropertyReference[Uml, UMLConnectorEnd[Uml], UMLProperty[Uml]](
		"partWithPort", _.partWithPort, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ConnectorEnd_role =
		MetaPropertyReference[Uml, UMLConnectorEnd[Uml], UMLConnectableElement[Uml]](
		"role", _.role, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ConsiderIgnoreFragment_message =
		MetaPropertyCollection[Uml, UMLConsiderIgnoreFragment[Uml], UMLNamedElement[Uml]](
		"message", _.message, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Constraint_constrainedElement =
		MetaPropertyCollection[Uml, UMLConstraint[Uml], UMLElement[Uml]](
		"constrainedElement", _.constrainedElement, isComposite=false, isUnique=true, isOrdered=true,
		Set())

	val Constraint_specification =
		MetaPropertyReference[Uml, UMLConstraint[Uml], UMLValueSpecification[Uml]](
		"specification", _.specification, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Continuation_setting =
		MetaAttributeBooleanFunction[Uml, UMLContinuation[Uml]](None, "setting",
		(x) => booleanToIterable(x.setting, true))

	val CreateLinkAction_endData =
		MetaPropertyCollection[Uml, UMLCreateLinkAction[Uml], UMLLinkEndCreationData[Uml]](
		"endData", _.endData, isComposite=true, isUnique=true, isOrdered=false,
		Set(LinkAction_endData))

	val CreateLinkObjectAction_result =
		MetaPropertyReference[Uml, UMLCreateLinkObjectAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val CreateObjectAction_classifier =
		MetaPropertyReference[Uml, UMLCreateObjectAction[Uml], UMLClassifier[Uml]](
		"classifier", _.classifier, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val CreateObjectAction_result =
		MetaPropertyReference[Uml, UMLCreateObjectAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val DataType_ownedAttribute =
		MetaPropertyCollection[Uml, UMLDataType[Uml], UMLProperty[Uml]](
		"ownedAttribute", _.ownedAttribute, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val DataType_ownedOperation =
		MetaPropertyCollection[Uml, UMLDataType[Uml], UMLOperation[Uml]](
		"ownedOperation", _.ownedOperation, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val DecisionNode_decisionInput =
		MetaPropertyReference[Uml, UMLDecisionNode[Uml], UMLBehavior[Uml]](
		"decisionInput", _.decisionInput, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val DecisionNode_decisionInputFlow =
		MetaPropertyReference[Uml, UMLDecisionNode[Uml], UMLObjectFlow[Uml]](
		"decisionInputFlow", _.decisionInputFlow, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Dependency_client =
		MetaPropertyCollection[Uml, UMLDependency[Uml], UMLNamedElement[Uml]](
		"client", _.client, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Dependency_supplier =
		MetaPropertyCollection[Uml, UMLDependency[Uml], UMLNamedElement[Uml]](
		"supplier", _.supplier, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Deployment_configuration =
		MetaPropertyCollection[Uml, UMLDeployment[Uml], UMLDeploymentSpecification[Uml]](
		"configuration", _.configuration, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Deployment_deployedArtifact =
		MetaPropertyCollection[Uml, UMLDeployment[Uml], UMLDeployedArtifact[Uml]](
		"deployedArtifact", _.deployedArtifact, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val DeploymentSpecification_deploymentLocation =
		new MetaAttributeStringFunction[Uml, UMLDeploymentSpecification[Uml]](OptionConstructor(), None, "deploymentLocation",
		(x: UMLDeploymentSpecification[Uml]) => x.deploymentLocation)

	val DeploymentSpecification_executionLocation =
		new MetaAttributeStringFunction[Uml, UMLDeploymentSpecification[Uml]](OptionConstructor(), None, "executionLocation",
		(x: UMLDeploymentSpecification[Uml]) => x.executionLocation)

	val DeploymentTarget_deployment =
		MetaPropertyCollection[Uml, UMLDeploymentTarget[Uml], UMLDeployment[Uml]](
		"deployment", _.deployment, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val DestroyLinkAction_endData =
		MetaPropertyCollection[Uml, UMLDestroyLinkAction[Uml], UMLLinkEndDestructionData[Uml]](
		"endData", _.endData, isComposite=true, isUnique=true, isOrdered=false,
		Set(LinkAction_endData))

	val DestroyObjectAction_isDestroyLinks =
		MetaAttributeBooleanFunction[Uml, UMLDestroyObjectAction[Uml]](None, "isDestroyLinks",
		(x) => booleanToIterable(x.isDestroyLinks, false))

	val DestroyObjectAction_isDestroyOwnedObjects =
		MetaAttributeBooleanFunction[Uml, UMLDestroyObjectAction[Uml]](None, "isDestroyOwnedObjects",
		(x) => booleanToIterable(x.isDestroyOwnedObjects, false))

	val DestroyObjectAction_target =
		MetaPropertyReference[Uml, UMLDestroyObjectAction[Uml], UMLInputPin[Uml]](
		"target", _.target, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Duration_expr =
		MetaPropertyReference[Uml, UMLDuration[Uml], UMLValueSpecification[Uml]](
		"expr", _.expr, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Duration_observation =
		MetaPropertyCollection[Uml, UMLDuration[Uml], UMLObservation[Uml]](
		"observation", _.observation, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val DurationConstraint_firstEvent =
		new MetaAttributeBooleanFunction[Uml, UMLDurationConstraint[Uml]](IterableConstructor(), None, "firstEvent",
		(x: UMLDurationConstraint[Uml]) => x.firstEvent)

	val DurationConstraint_specification =
		MetaPropertyReference[Uml, UMLDurationConstraint[Uml], UMLDurationInterval[Uml]](
		"specification", _.specification, isComposite=true, isUnique=true, isOrdered=false,
		Set(IntervalConstraint_specification))

	val DurationInterval_max =
		MetaPropertyReference[Uml, UMLDurationInterval[Uml], UMLDuration[Uml]](
		"max", _.max, isComposite=false, isUnique=true, isOrdered=false,
		Set(Interval_max))

	val DurationInterval_min =
		MetaPropertyReference[Uml, UMLDurationInterval[Uml], UMLDuration[Uml]](
		"min", _.min, isComposite=false, isUnique=true, isOrdered=false,
		Set(Interval_min))

	val DurationObservation_event =
		MetaPropertyCollection[Uml, UMLDurationObservation[Uml], UMLNamedElement[Uml]](
		"event", _.event, isComposite=false, isUnique=true, isOrdered=true,
		Set())

	val DurationObservation_firstEvent =
		new MetaAttributeBooleanFunction[Uml, UMLDurationObservation[Uml]](IterableConstructor(), None, "firstEvent",
		(x: UMLDurationObservation[Uml]) => x.firstEvent)

	val Element_ownedComment =
		MetaPropertyCollection[Uml, UMLElement[Uml], UMLComment[Uml]](
		"ownedComment", _.ownedComment, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ElementImport_alias =
		new MetaAttributeStringFunction[Uml, UMLElementImport[Uml]](OptionConstructor(), None, "alias",
		(x: UMLElementImport[Uml]) => x.alias)

	val ElementImport_importedElement =
		MetaPropertyReference[Uml, UMLElementImport[Uml], UMLPackageableElement[Uml]](
		"importedElement", _.importedElement, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ElementImport_visibility =
		new MetaAttributeEnumerationFunction[Uml, UMLElementImport[Uml], UMLVisibilityKind.Value, UMLVisibilityKind.ValueSet](
		OptionConstructor(), None, "visibility",
		(x: UMLElementImport[Uml]) => x.visibility, UMLVisibilityKind.values)

	val Enumeration_ownedLiteral =
		MetaPropertyCollection[Uml, UMLEnumeration[Uml], UMLEnumerationLiteral[Uml]](
		"ownedLiteral", _.ownedLiteral, isComposite=true, isUnique=true, isOrdered=true,
		Set())


	val ExceptionHandler_exceptionInput =
		MetaPropertyReference[Uml, UMLExceptionHandler[Uml], UMLObjectNode[Uml]](
		"exceptionInput", _.exceptionInput, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ExceptionHandler_exceptionType =
		MetaPropertyCollection[Uml, UMLExceptionHandler[Uml], UMLClassifier[Uml]](
		"exceptionType", _.exceptionType, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ExceptionHandler_handlerBody =
		MetaPropertyReference[Uml, UMLExceptionHandler[Uml], UMLExecutableNode[Uml]](
		"handlerBody", _.handlerBody, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ExecutableNode_handler =
		MetaPropertyCollection[Uml, UMLExecutableNode[Uml], UMLExceptionHandler[Uml]](
		"handler", _.handler, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ExecutionOccurrenceSpecification_execution =
		MetaPropertyReference[Uml, UMLExecutionOccurrenceSpecification[Uml], UMLExecutionSpecification[Uml]](
		"execution", _.execution, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ExecutionSpecification_finish =
		MetaPropertyReference[Uml, UMLExecutionSpecification[Uml], UMLOccurrenceSpecification[Uml]](
		"finish", _.finish, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ExecutionSpecification_start =
		MetaPropertyReference[Uml, UMLExecutionSpecification[Uml], UMLOccurrenceSpecification[Uml]](
		"start", _.start, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ExpansionNode_regionAsInput =
		MetaPropertyReference[Uml, UMLExpansionNode[Uml], UMLExpansionRegion[Uml]](
		"regionAsInput", _.regionAsInput, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ExpansionNode_regionAsOutput =
		MetaPropertyReference[Uml, UMLExpansionNode[Uml], UMLExpansionRegion[Uml]](
		"regionAsOutput", _.regionAsOutput, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ExpansionRegion_inputElement =
		MetaPropertyCollection[Uml, UMLExpansionRegion[Uml], UMLExpansionNode[Uml]](
		"inputElement", _.inputElement, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ExpansionRegion_mode =
		new MetaAttributeEnumerationFunction[Uml, UMLExpansionRegion[Uml], UMLExpansionKind.Value, UMLExpansionKind.ValueSet](
		OptionConstructor(), None, "mode",
		(x: UMLExpansionRegion[Uml]) => x.mode, UMLExpansionKind.values)

	val ExpansionRegion_outputElement =
		MetaPropertyCollection[Uml, UMLExpansionRegion[Uml], UMLExpansionNode[Uml]](
		"outputElement", _.outputElement, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Expression_operand =
		MetaPropertyCollection[Uml, UMLExpression[Uml], UMLValueSpecification[Uml]](
		"operand", _.operand, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Expression_symbol =
		new MetaAttributeStringFunction[Uml, UMLExpression[Uml]](OptionConstructor(), None, "symbol",
		(x: UMLExpression[Uml]) => x.symbol)

	val Extend_condition =
		MetaPropertyReference[Uml, UMLExtend[Uml], UMLConstraint[Uml]](
		"condition", _.condition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Extend_extendedCase =
		MetaPropertyReference[Uml, UMLExtend[Uml], UMLUseCase[Uml]](
		"extendedCase", _.extendedCase, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Extend_extensionLocation =
		MetaPropertyCollection[Uml, UMLExtend[Uml], UMLExtensionPoint[Uml]](
		"extensionLocation", _.extensionLocation, isComposite=false, isUnique=true, isOrdered=true,
		Set())

	val Extension_ownedEnd =
		MetaPropertyCollection[Uml, UMLExtension[Uml], UMLExtensionEnd[Uml]](
		"ownedEnd", _.ownedEnd, isComposite=true, isUnique=true, isOrdered=false,
		Set(Association_ownedEnd))

	val ExtensionEnd_type =
		MetaPropertyReference[Uml, UMLExtensionEnd[Uml], UMLStereotype[Uml]](
		"type", _._type, isComposite=false, isUnique=true, isOrdered=false,
		Set(TypedElement_type))


	val Feature_isStatic =
		MetaAttributeBooleanFunction[Uml, UMLFeature[Uml]](None, "isStatic",
		(x) => booleanToIterable(x.isStatic, false))

	val GeneralOrdering_after =
		MetaPropertyReference[Uml, UMLGeneralOrdering[Uml], UMLOccurrenceSpecification[Uml]](
		"after", _.after, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val GeneralOrdering_before =
		MetaPropertyReference[Uml, UMLGeneralOrdering[Uml], UMLOccurrenceSpecification[Uml]](
		"before", _.before, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Generalization_general =
		MetaPropertyReference[Uml, UMLGeneralization[Uml], UMLClassifier[Uml]](
		"general", _.general, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Generalization_generalizationSet =
		MetaPropertyCollection[Uml, UMLGeneralization[Uml], UMLGeneralizationSet[Uml]](
		"generalizationSet", _.generalizationSet, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Generalization_isSubstitutable =
		MetaAttributeBooleanFunction[Uml, UMLGeneralization[Uml]](None, "isSubstitutable",
		(x) => booleanToIterable(x.isSubstitutable.getOrElse(true), true))

	val GeneralizationSet_generalization =
		MetaPropertyCollection[Uml, UMLGeneralizationSet[Uml], UMLGeneralization[Uml]](
		"generalization", _.generalization, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val GeneralizationSet_isCovering =
		MetaAttributeBooleanFunction[Uml, UMLGeneralizationSet[Uml]](None, "isCovering",
		(x) => booleanToIterable(x.isCovering, false))

	val GeneralizationSet_isDisjoint =
		MetaAttributeBooleanFunction[Uml, UMLGeneralizationSet[Uml]](None, "isDisjoint",
		(x) => booleanToIterable(x.isDisjoint, false))

	val GeneralizationSet_powertype =
		MetaPropertyReference[Uml, UMLGeneralizationSet[Uml], UMLClassifier[Uml]](
		"powertype", _.powertype, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Image_content =
		new MetaAttributeStringFunction[Uml, UMLImage[Uml]](OptionConstructor(), None, "content",
		(x: UMLImage[Uml]) => x.content)

	val Image_format =
		new MetaAttributeStringFunction[Uml, UMLImage[Uml]](OptionConstructor(), None, "format",
		(x: UMLImage[Uml]) => x.format)

	val Image_location =
		new MetaAttributeStringFunction[Uml, UMLImage[Uml]](OptionConstructor(), None, "location",
		(x: UMLImage[Uml]) => x.location)

	val Include_addition =
		MetaPropertyReference[Uml, UMLInclude[Uml], UMLUseCase[Uml]](
		"addition", _.addition, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InformationFlow_conveyed =
		MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLClassifier[Uml]](
		"conveyed", _.conveyed, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InformationFlow_informationSource =
		MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLNamedElement[Uml]](
		"informationSource", _.informationSource, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InformationFlow_informationTarget =
		MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLNamedElement[Uml]](
		"informationTarget", _.informationTarget, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InformationFlow_realization =
		MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLRelationship[Uml]](
		"realization", _.realization, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InformationFlow_realizingActivityEdge =
		MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLActivityEdge[Uml]](
		"realizingActivityEdge", _.realizingActivityEdge, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InformationFlow_realizingConnector =
		MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLConnector[Uml]](
		"realizingConnector", _.realizingConnector, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InformationFlow_realizingMessage =
		MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLMessage[Uml]](
		"realizingMessage", _.realizingMessage, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InformationItem_represented =
		MetaPropertyCollection[Uml, UMLInformationItem[Uml], UMLClassifier[Uml]](
		"represented", _.represented, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InstanceSpecification_classifier =
		MetaPropertyCollection[Uml, UMLInstanceSpecification[Uml], UMLClassifier[Uml]](
		"classifier", _.classifier, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InstanceSpecification_slot =
		MetaPropertyCollection[Uml, UMLInstanceSpecification[Uml], UMLSlot[Uml]](
		"slot", _.slot, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val InstanceSpecification_specification =
		MetaPropertyReference[Uml, UMLInstanceSpecification[Uml], UMLValueSpecification[Uml]](
		"specification", _.specification, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val InstanceValue_instance =
		MetaPropertyReference[Uml, UMLInstanceValue[Uml], UMLInstanceSpecification[Uml]](
		"instance", _.instance, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Interaction_action =
		MetaPropertyCollection[Uml, UMLInteraction[Uml], UMLAction[Uml]](
		"action", _.action, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Interaction_formalGate =
		MetaPropertyCollection[Uml, UMLInteraction[Uml], UMLGate[Uml]](
		"formalGate", _.formalGate, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Interaction_fragment =
		MetaPropertyCollection[Uml, UMLInteraction[Uml], UMLInteractionFragment[Uml]](
		"fragment", _.fragment, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Interaction_lifeline =
		MetaPropertyCollection[Uml, UMLInteraction[Uml], UMLLifeline[Uml]](
		"lifeline", _.lifeline, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Interaction_message =
		MetaPropertyCollection[Uml, UMLInteraction[Uml], UMLMessage[Uml]](
		"message", _.message, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val InteractionConstraint_maxint =
		MetaPropertyReference[Uml, UMLInteractionConstraint[Uml], UMLValueSpecification[Uml]](
		"maxint", _.maxint, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val InteractionConstraint_minint =
		MetaPropertyReference[Uml, UMLInteractionConstraint[Uml], UMLValueSpecification[Uml]](
		"minint", _.minint, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val InteractionFragment_covered =
		MetaPropertyCollection[Uml, UMLInteractionFragment[Uml], UMLLifeline[Uml]](
		"covered", _.covered, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InteractionFragment_generalOrdering =
		MetaPropertyCollection[Uml, UMLInteractionFragment[Uml], UMLGeneralOrdering[Uml]](
		"generalOrdering", _.generalOrdering, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val InteractionOperand_fragment =
		MetaPropertyCollection[Uml, UMLInteractionOperand[Uml], UMLInteractionFragment[Uml]](
		"fragment", _.fragment, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val InteractionOperand_guard =
		MetaPropertyReference[Uml, UMLInteractionOperand[Uml], UMLInteractionConstraint[Uml]](
		"guard", _.guard, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val InteractionUse_actualGate =
		MetaPropertyCollection[Uml, UMLInteractionUse[Uml], UMLGate[Uml]](
		"actualGate", _.actualGate, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val InteractionUse_argument =
		MetaPropertyCollection[Uml, UMLInteractionUse[Uml], UMLValueSpecification[Uml]](
		"argument", _.argument, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val InteractionUse_refersTo =
		MetaPropertyReference[Uml, UMLInteractionUse[Uml], UMLInteraction[Uml]](
		"refersTo", _.refersTo, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InteractionUse_returnValue =
		MetaPropertyReference[Uml, UMLInteractionUse[Uml], UMLValueSpecification[Uml]](
		"returnValue", _.returnValue, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val InteractionUse_returnValueRecipient =
		MetaPropertyReference[Uml, UMLInteractionUse[Uml], UMLProperty[Uml]](
		"returnValueRecipient", _.returnValueRecipient, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Interface_nestedClassifier =
		MetaPropertyCollection[Uml, UMLInterface[Uml], UMLClassifier[Uml]](
		"nestedClassifier", _.nestedClassifier, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Interface_ownedAttribute =
		MetaPropertyCollection[Uml, UMLInterface[Uml], UMLProperty[Uml]](
		"ownedAttribute", _.ownedAttribute, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Interface_ownedOperation =
		MetaPropertyCollection[Uml, UMLInterface[Uml], UMLOperation[Uml]](
		"ownedOperation", _.ownedOperation, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Interface_ownedReception =
		MetaPropertyCollection[Uml, UMLInterface[Uml], UMLReception[Uml]](
		"ownedReception", _.ownedReception, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Interface_protocol =
		MetaPropertyReference[Uml, UMLInterface[Uml], UMLProtocolStateMachine[Uml]](
		"protocol", _.protocol, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Interface_redefinedInterface =
		MetaPropertyCollection[Uml, UMLInterface[Uml], UMLInterface[Uml]](
		"redefinedInterface", _.redefinedInterface, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InterfaceRealization_contract =
		MetaPropertyReference[Uml, UMLInterfaceRealization[Uml], UMLInterface[Uml]](
		"contract", _.contract, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InterruptibleActivityRegion_interruptingEdge =
		MetaPropertyCollection[Uml, UMLInterruptibleActivityRegion[Uml], UMLActivityEdge[Uml]](
		"interruptingEdge", _.interruptingEdge, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val InterruptibleActivityRegion_node =
		MetaPropertyCollection[Uml, UMLInterruptibleActivityRegion[Uml], UMLActivityNode[Uml]](
		"node", _.node, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Interval_max =
		MetaPropertyReference[Uml, UMLInterval[Uml], UMLValueSpecification[Uml]](
		"max", _.max, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Interval_min =
		MetaPropertyReference[Uml, UMLInterval[Uml], UMLValueSpecification[Uml]](
		"min", _.min, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val IntervalConstraint_specification =
		MetaPropertyReference[Uml, UMLIntervalConstraint[Uml], UMLInterval[Uml]](
		"specification", _.specification, isComposite=true, isUnique=true, isOrdered=false,
		Set(Constraint_specification))

	val InvocationAction_argument =
		MetaPropertyCollection[Uml, UMLInvocationAction[Uml], UMLInputPin[Uml]](
		"argument", _.argument, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val InvocationAction_onPort =
		MetaPropertyReference[Uml, UMLInvocationAction[Uml], UMLPort[Uml]](
		"onPort", _.onPort, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val JoinNode_isCombineDuplicate =
		MetaAttributeBooleanFunction[Uml, UMLJoinNode[Uml]](None, "isCombineDuplicate",
		(x) => booleanToIterable(x.isCombineDuplicate, true))

	val JoinNode_joinSpec =
		MetaPropertyReference[Uml, UMLJoinNode[Uml], UMLValueSpecification[Uml]](
		"joinSpec", _.joinSpec, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Lifeline_coveredBy =
		MetaPropertyCollection[Uml, UMLLifeline[Uml], UMLInteractionFragment[Uml]](
		"coveredBy", _.coveredBy, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Lifeline_decomposedAs =
		MetaPropertyReference[Uml, UMLLifeline[Uml], UMLPartDecomposition[Uml]](
		"decomposedAs", _.decomposedAs, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Lifeline_represents =
		MetaPropertyReference[Uml, UMLLifeline[Uml], UMLConnectableElement[Uml]](
		"represents", _.represents, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Lifeline_selector =
		MetaPropertyReference[Uml, UMLLifeline[Uml], UMLValueSpecification[Uml]](
		"selector", _.selector, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val LinkAction_endData =
		MetaPropertyCollection[Uml, UMLLinkAction[Uml], UMLLinkEndData[Uml]](
		"endData", _.endData, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val LinkAction_inputValue =
		MetaPropertyCollection[Uml, UMLLinkAction[Uml], UMLInputPin[Uml]](
		"inputValue", _.inputValue, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val LinkEndCreationData_insertAt =
		MetaPropertyReference[Uml, UMLLinkEndCreationData[Uml], UMLInputPin[Uml]](
		"insertAt", _.insertAt, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val LinkEndCreationData_isReplaceAll =
		MetaAttributeBooleanFunction[Uml, UMLLinkEndCreationData[Uml]](None, "isReplaceAll",
		(x) => booleanToIterable(x.isReplaceAll, false))

	val LinkEndData_end =
		MetaPropertyReference[Uml, UMLLinkEndData[Uml], UMLProperty[Uml]](
		"end", _.end, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val LinkEndData_qualifier =
		MetaPropertyCollection[Uml, UMLLinkEndData[Uml], UMLQualifierValue[Uml]](
		"qualifier", _.qualifier, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val LinkEndData_value =
		MetaPropertyReference[Uml, UMLLinkEndData[Uml], UMLInputPin[Uml]](
		"value", _.value, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val LinkEndDestructionData_destroyAt =
		MetaPropertyReference[Uml, UMLLinkEndDestructionData[Uml], UMLInputPin[Uml]](
		"destroyAt", _.destroyAt, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val LinkEndDestructionData_isDestroyDuplicates =
		MetaAttributeBooleanFunction[Uml, UMLLinkEndDestructionData[Uml]](None, "isDestroyDuplicates",
		(x) => booleanToIterable(x.isDestroyDuplicates, false))

	val LiteralBoolean_value =
		MetaAttributeBooleanFunction[Uml, UMLLiteralBoolean[Uml]](None, "value",
		(x) => booleanToIterable(x.value, false))

	val LiteralInteger_value =
		MetaAttributeIntegerFunction[Uml, UMLLiteralInteger[Uml]](None, "value",
		(x) => integerToIterable(x.value, 0))

	val LiteralReal_value =
		MetaAttributeRealFunction[Uml, UMLLiteralReal[Uml]](None, "value",
		(x) => realToIterable(x.value, 0.0))

	val LiteralString_value =
		new MetaAttributeStringFunction[Uml, UMLLiteralString[Uml]](OptionConstructor(), None, "value",
		(x: UMLLiteralString[Uml]) => x.value)

	val LiteralUnlimitedNatural_value =
		MetaAttributeUnlimitedNaturalFunction[Uml, UMLLiteralUnlimitedNatural[Uml]](None, "value",
		(x) => unlimitedNaturalToIterable(x.value, 0))

	val LoopNode_bodyOutput =
		MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLOutputPin[Uml]](
		"bodyOutput", _.bodyOutput, isComposite=false, isUnique=true, isOrdered=true,
		Set())

	val LoopNode_bodyPart =
		MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLExecutableNode[Uml]](
		"bodyPart", _.bodyPart, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val LoopNode_decider =
		MetaPropertyReference[Uml, UMLLoopNode[Uml], UMLOutputPin[Uml]](
		"decider", _.decider, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val LoopNode_isTestedFirst =
		MetaAttributeBooleanFunction[Uml, UMLLoopNode[Uml]](None, "isTestedFirst",
		(x) => booleanToIterable(x.isTestedFirst, false))

	val LoopNode_loopVariable =
		MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLOutputPin[Uml]](
		"loopVariable", _.loopVariable, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val LoopNode_loopVariableInput =
		MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLInputPin[Uml]](
		"loopVariableInput", _.loopVariableInput, isComposite=true, isUnique=true, isOrdered=true,
		Set(StructuredActivityNode_structuredNodeInput))

	val LoopNode_result =
		MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=true,
		Set(StructuredActivityNode_structuredNodeOutput))

	val LoopNode_setupPart =
		MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLExecutableNode[Uml]](
		"setupPart", _.setupPart, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val LoopNode_test =
		MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLExecutableNode[Uml]](
		"test", _.test, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Manifestation_utilizedElement =
		MetaPropertyReference[Uml, UMLManifestation[Uml], UMLPackageableElement[Uml]](
		"utilizedElement", _.utilizedElement, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Message_argument =
		MetaPropertyCollection[Uml, UMLMessage[Uml], UMLValueSpecification[Uml]](
		"argument", _.argument, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Message_connector =
		MetaPropertyReference[Uml, UMLMessage[Uml], UMLConnector[Uml]](
		"connector", _.connector, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Message_messageSort =
		new MetaAttributeEnumerationFunction[Uml, UMLMessage[Uml], UMLMessageSort.Value, UMLMessageSort.ValueSet](
		OptionConstructor(), None, "messageSort",
		(x: UMLMessage[Uml]) => x.messageSort, UMLMessageSort.values)

	val Message_receiveEvent =
		MetaPropertyReference[Uml, UMLMessage[Uml], UMLMessageEnd[Uml]](
		"receiveEvent", _.receiveEvent, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Message_sendEvent =
		MetaPropertyReference[Uml, UMLMessage[Uml], UMLMessageEnd[Uml]](
		"sendEvent", _.sendEvent, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Message_signature =
		MetaPropertyReference[Uml, UMLMessage[Uml], UMLNamedElement[Uml]](
		"signature", _.signature, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val MessageEnd_message =
		MetaPropertyReference[Uml, UMLMessageEnd[Uml], UMLMessage[Uml]](
		"message", _.message, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Model_viewpoint =
		new MetaAttributeStringFunction[Uml, UMLModel[Uml]](OptionConstructor(), None, "viewpoint",
		(x: UMLModel[Uml]) => x.viewpoint)

	val MultiplicityElement_isOrdered =
		MetaAttributeBooleanFunction[Uml, UMLMultiplicityElement[Uml]](None, "isOrdered",
		(x) => booleanToIterable(x.isOrdered, false))

	val MultiplicityElement_isUnique =
		MetaAttributeBooleanFunction[Uml, UMLMultiplicityElement[Uml]](None, "isUnique",
		(x) => booleanToIterable(x.isUnique, true))

	val MultiplicityElement_lowerValue =
		MetaPropertyReference[Uml, UMLMultiplicityElement[Uml], UMLValueSpecification[Uml]](
		"lowerValue", _.lowerValue, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val MultiplicityElement_upperValue =
		MetaPropertyReference[Uml, UMLMultiplicityElement[Uml], UMLValueSpecification[Uml]](
		"upperValue", _.upperValue, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val NamedElement_name =
		new MetaAttributeStringFunction[Uml, UMLNamedElement[Uml]](OptionConstructor(), None, "name",
		(x: UMLNamedElement[Uml]) => x.name)

	val NamedElement_nameExpression =
		MetaPropertyReference[Uml, UMLNamedElement[Uml], UMLStringExpression[Uml]](
		"nameExpression", _.nameExpression, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val NamedElement_visibility =
		new MetaAttributeEnumerationFunction[Uml, UMLNamedElement[Uml], UMLVisibilityKind.Value, UMLVisibilityKind.ValueSet](
		OptionConstructor(), None, "visibility",
		(x: UMLNamedElement[Uml]) => x.visibility, UMLVisibilityKind.values)

	val Namespace_elementImport =
		MetaPropertyCollection[Uml, UMLNamespace[Uml], UMLElementImport[Uml]](
		"elementImport", _.elementImport, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Namespace_ownedRule =
		MetaPropertyCollection[Uml, UMLNamespace[Uml], UMLConstraint[Uml]](
		"ownedRule", _.ownedRule, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Namespace_packageImport =
		MetaPropertyCollection[Uml, UMLNamespace[Uml], UMLPackageImport[Uml]](
		"packageImport", _.packageImport, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Node_nestedNode =
		MetaPropertyCollection[Uml, UMLNode[Uml], UMLNode[Uml]](
		"nestedNode", _.nestedNode, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ObjectFlow_isMulticast =
		MetaAttributeBooleanFunction[Uml, UMLObjectFlow[Uml]](None, "isMulticast",
		(x) => booleanToIterable(x.isMulticast, false))

	val ObjectFlow_isMultireceive =
		MetaAttributeBooleanFunction[Uml, UMLObjectFlow[Uml]](None, "isMultireceive",
		(x) => booleanToIterable(x.isMultireceive, false))

	val ObjectFlow_selection =
		MetaPropertyReference[Uml, UMLObjectFlow[Uml], UMLBehavior[Uml]](
		"selection", _.selection, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ObjectFlow_transformation =
		MetaPropertyReference[Uml, UMLObjectFlow[Uml], UMLBehavior[Uml]](
		"transformation", _.transformation, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ObjectNode_inState =
		MetaPropertyCollection[Uml, UMLObjectNode[Uml], UMLState[Uml]](
		"inState", _.inState, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ObjectNode_isControlType =
		MetaAttributeBooleanFunction[Uml, UMLObjectNode[Uml]](None, "isControlType",
		(x) => booleanToIterable(x.isControlType, false))

	val ObjectNode_ordering =
		new MetaAttributeEnumerationFunction[Uml, UMLObjectNode[Uml], UMLObjectNodeOrderingKind.Value, UMLObjectNodeOrderingKind.ValueSet](
		OptionConstructor(), None, "ordering",
		(x: UMLObjectNode[Uml]) => x.ordering, UMLObjectNodeOrderingKind.values)

	val ObjectNode_selection =
		MetaPropertyReference[Uml, UMLObjectNode[Uml], UMLBehavior[Uml]](
		"selection", _.selection, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ObjectNode_upperBound =
		MetaPropertyReference[Uml, UMLObjectNode[Uml], UMLValueSpecification[Uml]](
		"upperBound", _.upperBound, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val OccurrenceSpecification_covered =
		MetaPropertyCollection[Uml, UMLOccurrenceSpecification[Uml], UMLLifeline[Uml]](
		"covered", _.covered, isComposite=false, isUnique=true, isOrdered=false,
		Set(InteractionFragment_covered))

	val OccurrenceSpecification_toAfter =
		MetaPropertyCollection[Uml, UMLOccurrenceSpecification[Uml], UMLGeneralOrdering[Uml]](
		"toAfter", _.toAfter, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val OccurrenceSpecification_toBefore =
		MetaPropertyCollection[Uml, UMLOccurrenceSpecification[Uml], UMLGeneralOrdering[Uml]](
		"toBefore", _.toBefore, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val OpaqueAction_body =
		new MetaAttributeStringFunction[Uml, UMLOpaqueAction[Uml]](IterableConstructor(), None, "body",
		(x: UMLOpaqueAction[Uml]) => x.body)

	val OpaqueAction_inputValue =
		MetaPropertyCollection[Uml, UMLOpaqueAction[Uml], UMLInputPin[Uml]](
		"inputValue", _.inputValue, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val OpaqueAction_language =
		new MetaAttributeStringFunction[Uml, UMLOpaqueAction[Uml]](IterableConstructor(), None, "language",
		(x: UMLOpaqueAction[Uml]) => x.language)

	val OpaqueAction_outputValue =
		MetaPropertyCollection[Uml, UMLOpaqueAction[Uml], UMLOutputPin[Uml]](
		"outputValue", _.outputValue, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val OpaqueBehavior_body =
		new MetaAttributeStringFunction[Uml, UMLOpaqueBehavior[Uml]](IterableConstructor(), None, "body",
		(x: UMLOpaqueBehavior[Uml]) => x.body)

	val OpaqueBehavior_language =
		new MetaAttributeStringFunction[Uml, UMLOpaqueBehavior[Uml]](IterableConstructor(), None, "language",
		(x: UMLOpaqueBehavior[Uml]) => x.language)

	val OpaqueExpression_behavior =
		MetaPropertyReference[Uml, UMLOpaqueExpression[Uml], UMLBehavior[Uml]](
		"behavior", _.behavior, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val OpaqueExpression_body =
		new MetaAttributeStringFunction[Uml, UMLOpaqueExpression[Uml]](IterableConstructor(), None, "body",
		(x: UMLOpaqueExpression[Uml]) => x.body)

	val OpaqueExpression_language =
		new MetaAttributeStringFunction[Uml, UMLOpaqueExpression[Uml]](IterableConstructor(), None, "language",
		(x: UMLOpaqueExpression[Uml]) => x.language)

	val Operation_bodyCondition =
		MetaPropertyReference[Uml, UMLOperation[Uml], UMLConstraint[Uml]](
		"bodyCondition", _.bodyCondition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Operation_isQuery =
		MetaAttributeBooleanFunction[Uml, UMLOperation[Uml]](None, "isQuery",
		(x) => booleanToIterable(x.isQuery, false))

	val Operation_ownedParameter =
		MetaPropertyCollection[Uml, UMLOperation[Uml], UMLParameter[Uml]](
		"ownedParameter", _.ownedParameter, isComposite=true, isUnique=true, isOrdered=true,
		Set(BehavioralFeature_ownedParameter))

	val Operation_postcondition =
		MetaPropertyCollection[Uml, UMLOperation[Uml], UMLConstraint[Uml]](
		"postcondition", _.postcondition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Operation_precondition =
		MetaPropertyCollection[Uml, UMLOperation[Uml], UMLConstraint[Uml]](
		"precondition", _.precondition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Operation_raisedException =
		MetaPropertyCollection[Uml, UMLOperation[Uml], UMLType[Uml]](
		"raisedException", _.raisedException, isComposite=false, isUnique=true, isOrdered=false,
		Set(BehavioralFeature_raisedException))

	val Operation_redefinedOperation =
		MetaPropertyCollection[Uml, UMLOperation[Uml], UMLOperation[Uml]](
		"redefinedOperation", _.redefinedOperation, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Operation_templateParameter =
		MetaPropertyReference[Uml, UMLOperation[Uml], UMLOperationTemplateParameter[Uml]](
		"templateParameter", _.templateParameter, isComposite=false, isUnique=true, isOrdered=false,
		Set(ParameterableElement_templateParameter))

	val OperationTemplateParameter_parameteredElement =
		MetaPropertyReference[Uml, UMLOperationTemplateParameter[Uml], UMLOperation[Uml]](
		"parameteredElement", _.parameteredElement, isComposite=false, isUnique=true, isOrdered=false,
		Set(TemplateParameter_parameteredElement))

	val Package_URI =
		MetaAttributeStringFunction[Uml, UMLPackage[Uml]](None, "URI",
		_.getEffectiveURI()(None).map(_.toIterable))

	val Package_packageMerge =
		MetaPropertyCollection[Uml, UMLPackage[Uml], UMLPackageMerge[Uml]](
		"packageMerge", _.packageMerge, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Package_packagedElement =
		MetaPropertyCollection[Uml, UMLPackage[Uml], UMLPackageableElement[Uml]](
		"packagedElement", _.packagedElement, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Package_profileApplication =
		MetaPropertyCollection[Uml, UMLPackage[Uml], UMLProfileApplication[Uml]](
		"profileApplication", _.profileApplication, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val PackageImport_importedPackage =
		MetaPropertyReference[Uml, UMLPackageImport[Uml], UMLPackage[Uml]](
		"importedPackage", _.importedPackage, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val PackageImport_visibility =
		new MetaAttributeEnumerationFunction[Uml, UMLPackageImport[Uml], UMLVisibilityKind.Value, UMLVisibilityKind.ValueSet](
		OptionConstructor(), None, "visibility",
		(x: UMLPackageImport[Uml]) => x.visibility, UMLVisibilityKind.values)

	val PackageMerge_mergedPackage =
		MetaPropertyReference[Uml, UMLPackageMerge[Uml], UMLPackage[Uml]](
		"mergedPackage", _.mergedPackage, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val PackageableElement_visibility =
		new MetaAttributeEnumerationFunction[Uml, UMLPackageableElement[Uml], UMLVisibilityKind.Value, UMLVisibilityKind.ValueSet](
		OptionConstructor(), None, "visibility",
		(x: UMLPackageableElement[Uml]) => x.visibility, UMLVisibilityKind.values)

	val Parameter_defaultValue =
		MetaPropertyReference[Uml, UMLParameter[Uml], UMLValueSpecification[Uml]](
		"defaultValue", _.defaultValue, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Parameter_direction =
		new MetaAttributeEnumerationFunction[Uml, UMLParameter[Uml], UMLParameterDirectionKind.Value, UMLParameterDirectionKind.ValueSet](
		OptionConstructor(), None, "direction",
		(x: UMLParameter[Uml]) => x.direction, UMLParameterDirectionKind.values)

	val Parameter_effect =
		new MetaAttributeEnumerationFunction[Uml, UMLParameter[Uml], UMLParameterEffectKind.Value, UMLParameterEffectKind.ValueSet](
		OptionConstructor(), None, "effect",
		(x: UMLParameter[Uml]) => x.effect, UMLParameterEffectKind.values)

	val Parameter_isException =
		MetaAttributeBooleanFunction[Uml, UMLParameter[Uml]](None, "isException",
		(x) => booleanToIterable(x.isException, false))

	val Parameter_isStream =
		MetaAttributeBooleanFunction[Uml, UMLParameter[Uml]](None, "isStream",
		(x) => booleanToIterable(x.isStream, false))

	val Parameter_parameterSet =
		MetaPropertyCollection[Uml, UMLParameter[Uml], UMLParameterSet[Uml]](
		"parameterSet", _.parameterSet, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ParameterSet_condition =
		MetaPropertyCollection[Uml, UMLParameterSet[Uml], UMLConstraint[Uml]](
		"condition", _.condition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ParameterSet_parameter =
		MetaPropertyCollection[Uml, UMLParameterSet[Uml], UMLParameter[Uml]](
		"parameter", _.parameter, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ParameterableElement_templateParameter =
		MetaPropertyReference[Uml, UMLParameterableElement[Uml], UMLTemplateParameter[Uml]](
		"templateParameter", _.templateParameter, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Pin_isControl =
		MetaAttributeBooleanFunction[Uml, UMLPin[Uml]](None, "isControl",
		(x) => booleanToIterable(x.isControl, false))

	val Port_isBehavior =
		MetaAttributeBooleanFunction[Uml, UMLPort[Uml]](None, "isBehavior",
		(x) => booleanToIterable(x.isBehavior, false))

	val Port_isConjugated =
		MetaAttributeBooleanFunction[Uml, UMLPort[Uml]](None, "isConjugated",
		(x) => booleanToIterable(x.isConjugated, false))

	val Port_isService =
		MetaAttributeBooleanFunction[Uml, UMLPort[Uml]](None, "isService",
		(x) => booleanToIterable(x.isService, true))

	val Port_protocol =
		MetaPropertyReference[Uml, UMLPort[Uml], UMLProtocolStateMachine[Uml]](
		"protocol", _.protocol, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Port_redefinedPort =
		MetaPropertyCollection[Uml, UMLPort[Uml], UMLPort[Uml]](
		"redefinedPort", _.redefinedPort, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Profile_metaclassReference =
		MetaPropertyCollection[Uml, UMLProfile[Uml], UMLElementImport[Uml]](
		"metaclassReference", _.metaclassReference, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Profile_metamodelReference =
		MetaPropertyCollection[Uml, UMLProfile[Uml], UMLPackageImport[Uml]](
		"metamodelReference", _.metamodelReference, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ProfileApplication_appliedProfile =
		MetaPropertyReference[Uml, UMLProfileApplication[Uml], UMLProfile[Uml]](
		"appliedProfile", _.appliedProfile, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ProfileApplication_isStrict =
		MetaAttributeBooleanFunction[Uml, UMLProfileApplication[Uml]](None, "isStrict",
		(x) => booleanToIterable(x.isStrict, false))

	val Property_aggregation =
		new MetaAttributeEnumerationFunction[Uml, UMLProperty[Uml], UMLAggregationKind.Value, UMLAggregationKind.ValueSet](
		OptionConstructor(), None, "aggregation",
		(x: UMLProperty[Uml]) => x.aggregation, UMLAggregationKind.values)

	val Property_association =
		MetaPropertyReference[Uml, UMLProperty[Uml], UMLAssociation[Uml]](
		"association", _.association, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Property_defaultValue =
		MetaPropertyReference[Uml, UMLProperty[Uml], UMLValueSpecification[Uml]](
		"defaultValue", _.defaultValue, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Property_isDerived =
		MetaAttributeBooleanFunction[Uml, UMLProperty[Uml]](None, "isDerived",
		(x) => booleanToIterable(x.isDerived, false))

	val Property_isDerivedUnion =
		MetaAttributeBooleanFunction[Uml, UMLProperty[Uml]](None, "isDerivedUnion",
		(x) => booleanToIterable(x.isDerivedUnion, false))

	val Property_isID =
		MetaAttributeBooleanFunction[Uml, UMLProperty[Uml]](None, "isID",
		(x) => booleanToIterable(x.isID, false))

	val Property_qualifier =
		MetaPropertyCollection[Uml, UMLProperty[Uml], UMLProperty[Uml]](
		"qualifier", _.qualifier, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val Property_redefinedProperty =
		MetaPropertyCollection[Uml, UMLProperty[Uml], UMLProperty[Uml]](
		"redefinedProperty", _.redefinedProperty, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Property_subsettedProperty =
		MetaPropertyCollection[Uml, UMLProperty[Uml], UMLProperty[Uml]](
		"subsettedProperty", _.subsettedProperty, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ProtocolConformance_generalMachine =
		MetaPropertyReference[Uml, UMLProtocolConformance[Uml], UMLProtocolStateMachine[Uml]](
		"generalMachine", _.generalMachine, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ProtocolStateMachine_conformance =
		MetaPropertyCollection[Uml, UMLProtocolStateMachine[Uml], UMLProtocolConformance[Uml]](
		"conformance", _.conformance, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ProtocolTransition_postCondition =
		MetaPropertyReference[Uml, UMLProtocolTransition[Uml], UMLConstraint[Uml]](
		"postCondition", _.postCondition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ProtocolTransition_preCondition =
		MetaPropertyReference[Uml, UMLProtocolTransition[Uml], UMLConstraint[Uml]](
		"preCondition", _.preCondition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Pseudostate_kind =
		new MetaAttributeEnumerationFunction[Uml, UMLPseudostate[Uml], UMLPseudostateKind.Value, UMLPseudostateKind.ValueSet](
		OptionConstructor(), None, "kind",
		(x: UMLPseudostate[Uml]) => x.kind, UMLPseudostateKind.values)

	val QualifierValue_qualifier =
		MetaPropertyReference[Uml, UMLQualifierValue[Uml], UMLProperty[Uml]](
		"qualifier", _.qualifier, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val QualifierValue_value =
		MetaPropertyReference[Uml, UMLQualifierValue[Uml], UMLInputPin[Uml]](
		"value", _.value, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val RaiseExceptionAction_exception =
		MetaPropertyReference[Uml, UMLRaiseExceptionAction[Uml], UMLInputPin[Uml]](
		"exception", _.exception, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReadExtentAction_classifier =
		MetaPropertyReference[Uml, UMLReadExtentAction[Uml], UMLClassifier[Uml]](
		"classifier", _.classifier, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ReadExtentAction_result =
		MetaPropertyReference[Uml, UMLReadExtentAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReadIsClassifiedObjectAction_classifier =
		MetaPropertyReference[Uml, UMLReadIsClassifiedObjectAction[Uml], UMLClassifier[Uml]](
		"classifier", _.classifier, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ReadIsClassifiedObjectAction_isDirect =
		MetaAttributeBooleanFunction[Uml, UMLReadIsClassifiedObjectAction[Uml]](None, "isDirect",
		(x) => booleanToIterable(x.isDirect, false))

	val ReadIsClassifiedObjectAction_object =
		MetaPropertyReference[Uml, UMLReadIsClassifiedObjectAction[Uml], UMLInputPin[Uml]](
		"object", _._object, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReadIsClassifiedObjectAction_result =
		MetaPropertyReference[Uml, UMLReadIsClassifiedObjectAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReadLinkAction_result =
		MetaPropertyReference[Uml, UMLReadLinkAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReadLinkObjectEndAction_end =
		MetaPropertyReference[Uml, UMLReadLinkObjectEndAction[Uml], UMLProperty[Uml]](
		"end", _.end, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ReadLinkObjectEndAction_object =
		MetaPropertyReference[Uml, UMLReadLinkObjectEndAction[Uml], UMLInputPin[Uml]](
		"object", _._object, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReadLinkObjectEndAction_result =
		MetaPropertyReference[Uml, UMLReadLinkObjectEndAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReadLinkObjectEndQualifierAction_object =
		MetaPropertyReference[Uml, UMLReadLinkObjectEndQualifierAction[Uml], UMLInputPin[Uml]](
		"object", _._object, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReadLinkObjectEndQualifierAction_qualifier =
		MetaPropertyReference[Uml, UMLReadLinkObjectEndQualifierAction[Uml], UMLProperty[Uml]](
		"qualifier", _.qualifier, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ReadLinkObjectEndQualifierAction_result =
		MetaPropertyReference[Uml, UMLReadLinkObjectEndQualifierAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReadSelfAction_result =
		MetaPropertyReference[Uml, UMLReadSelfAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReadStructuralFeatureAction_result =
		MetaPropertyReference[Uml, UMLReadStructuralFeatureAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReadVariableAction_result =
		MetaPropertyReference[Uml, UMLReadVariableAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Reception_signal =
		MetaPropertyReference[Uml, UMLReception[Uml], UMLSignal[Uml]](
		"signal", _.signal, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ReclassifyObjectAction_isReplaceAll =
		MetaAttributeBooleanFunction[Uml, UMLReclassifyObjectAction[Uml]](None, "isReplaceAll",
		(x) => booleanToIterable(x.isReplaceAll, false))

	val ReclassifyObjectAction_newClassifier =
		MetaPropertyCollection[Uml, UMLReclassifyObjectAction[Uml], UMLClassifier[Uml]](
		"newClassifier", _.newClassifier, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ReclassifyObjectAction_object =
		MetaPropertyReference[Uml, UMLReclassifyObjectAction[Uml], UMLInputPin[Uml]](
		"object", _._object, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReclassifyObjectAction_oldClassifier =
		MetaPropertyCollection[Uml, UMLReclassifyObjectAction[Uml], UMLClassifier[Uml]](
		"oldClassifier", _.oldClassifier, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val RedefinableElement_isLeaf =
		MetaAttributeBooleanFunction[Uml, UMLRedefinableElement[Uml]](None, "isLeaf",
		(x) => booleanToIterable(x.isLeaf, false))

	val RedefinableTemplateSignature_extendedSignature =
		MetaPropertyCollection[Uml, UMLRedefinableTemplateSignature[Uml], UMLRedefinableTemplateSignature[Uml]](
		"extendedSignature", _.extendedSignature, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ReduceAction_collection =
		MetaPropertyReference[Uml, UMLReduceAction[Uml], UMLInputPin[Uml]](
		"collection", _.collection, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReduceAction_isOrdered =
		MetaAttributeBooleanFunction[Uml, UMLReduceAction[Uml]](None, "isOrdered",
		(x) => booleanToIterable(x.isOrdered, false))

	val ReduceAction_reducer =
		MetaPropertyReference[Uml, UMLReduceAction[Uml], UMLBehavior[Uml]](
		"reducer", _.reducer, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ReduceAction_result =
		MetaPropertyReference[Uml, UMLReduceAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Region_extendedRegion =
		MetaPropertyReference[Uml, UMLRegion[Uml], UMLRegion[Uml]](
		"extendedRegion", _.extendedRegion, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Region_subvertex =
		MetaPropertyCollection[Uml, UMLRegion[Uml], UMLVertex[Uml]](
		"subvertex", _.subvertex, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Region_transition =
		MetaPropertyCollection[Uml, UMLRegion[Uml], UMLTransition[Uml]](
		"transition", _.transition, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val RemoveStructuralFeatureValueAction_isRemoveDuplicates =
		MetaAttributeBooleanFunction[Uml, UMLRemoveStructuralFeatureValueAction[Uml]](None, "isRemoveDuplicates",
		(x) => booleanToIterable(x.isRemoveDuplicates, false))

	val RemoveStructuralFeatureValueAction_removeAt =
		MetaPropertyReference[Uml, UMLRemoveStructuralFeatureValueAction[Uml], UMLInputPin[Uml]](
		"removeAt", _.removeAt, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val RemoveVariableValueAction_isRemoveDuplicates =
		MetaAttributeBooleanFunction[Uml, UMLRemoveVariableValueAction[Uml]](None, "isRemoveDuplicates",
		(x) => booleanToIterable(x.isRemoveDuplicates, false))

	val RemoveVariableValueAction_removeAt =
		MetaPropertyReference[Uml, UMLRemoveVariableValueAction[Uml], UMLInputPin[Uml]](
		"removeAt", _.removeAt, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ReplyAction_replyToCall =
		MetaPropertyReference[Uml, UMLReplyAction[Uml], UMLTrigger[Uml]](
		"replyToCall", _.replyToCall, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ReplyAction_replyValue =
		MetaPropertyCollection[Uml, UMLReplyAction[Uml], UMLInputPin[Uml]](
		"replyValue", _.replyValue, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val ReplyAction_returnInformation =
		MetaPropertyReference[Uml, UMLReplyAction[Uml], UMLInputPin[Uml]](
		"returnInformation", _.returnInformation, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val SendObjectAction_request =
		MetaPropertyReference[Uml, UMLSendObjectAction[Uml], UMLInputPin[Uml]](
		"request", _.request, isComposite=true, isUnique=true, isOrdered=false,
		Set(InvocationAction_argument))

	val SendObjectAction_target =
		MetaPropertyReference[Uml, UMLSendObjectAction[Uml], UMLInputPin[Uml]](
		"target", _.target, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val SendSignalAction_signal =
		MetaPropertyReference[Uml, UMLSendSignalAction[Uml], UMLSignal[Uml]](
		"signal", _.signal, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val SendSignalAction_target =
		MetaPropertyReference[Uml, UMLSendSignalAction[Uml], UMLInputPin[Uml]](
		"target", _.target, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val SequenceNode_executableNode =
		MetaPropertyCollection[Uml, UMLSequenceNode[Uml], UMLExecutableNode[Uml]](
		"executableNode", _.executableNode, isComposite=true, isUnique=true, isOrdered=true,
		Set(StructuredActivityNode_node))

	val Signal_ownedAttribute =
		MetaPropertyCollection[Uml, UMLSignal[Uml], UMLProperty[Uml]](
		"ownedAttribute", _.ownedAttribute, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val SignalEvent_signal =
		MetaPropertyReference[Uml, UMLSignalEvent[Uml], UMLSignal[Uml]](
		"signal", _.signal, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Slot_definingFeature =
		MetaPropertyReference[Uml, UMLSlot[Uml], UMLStructuralFeature[Uml]](
		"definingFeature", _.definingFeature, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Slot_value =
		MetaPropertyCollection[Uml, UMLSlot[Uml], UMLValueSpecification[Uml]](
		"value", _.value, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val StartClassifierBehaviorAction_object =
		MetaPropertyReference[Uml, UMLStartClassifierBehaviorAction[Uml], UMLInputPin[Uml]](
		"object", _._object, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val StartObjectBehaviorAction_object =
		MetaPropertyReference[Uml, UMLStartObjectBehaviorAction[Uml], UMLInputPin[Uml]](
		"object", _._object, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val State_connection =
		MetaPropertyCollection[Uml, UMLState[Uml], UMLConnectionPointReference[Uml]](
		"connection", _.connection, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val State_connectionPoint =
		MetaPropertyCollection[Uml, UMLState[Uml], UMLPseudostate[Uml]](
		"connectionPoint", _.connectionPoint, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val State_deferrableTrigger =
		MetaPropertyCollection[Uml, UMLState[Uml], UMLTrigger[Uml]](
		"deferrableTrigger", _.deferrableTrigger, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val State_doActivity =
		MetaPropertyReference[Uml, UMLState[Uml], UMLBehavior[Uml]](
		"doActivity", _.doActivity, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val State_entry =
		MetaPropertyReference[Uml, UMLState[Uml], UMLBehavior[Uml]](
		"entry", _.entry, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val State_exit =
		MetaPropertyReference[Uml, UMLState[Uml], UMLBehavior[Uml]](
		"exit", _.exit, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val State_redefinedState =
		MetaPropertyReference[Uml, UMLState[Uml], UMLState[Uml]](
		"redefinedState", _.redefinedState, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val State_region =
		MetaPropertyCollection[Uml, UMLState[Uml], UMLRegion[Uml]](
		"region", _.region, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val State_stateInvariant =
		MetaPropertyReference[Uml, UMLState[Uml], UMLConstraint[Uml]](
		"stateInvariant", _.stateInvariant, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val State_submachine =
		MetaPropertyReference[Uml, UMLState[Uml], UMLStateMachine[Uml]](
		"submachine", _.submachine, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val StateInvariant_covered =
		MetaPropertyCollection[Uml, UMLStateInvariant[Uml], UMLLifeline[Uml]](
		"covered", _.covered, isComposite=false, isUnique=true, isOrdered=false,
		Set(InteractionFragment_covered))

	val StateInvariant_invariant =
		MetaPropertyReference[Uml, UMLStateInvariant[Uml], UMLConstraint[Uml]](
		"invariant", _.invariant, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val StateMachine_connectionPoint =
		MetaPropertyCollection[Uml, UMLStateMachine[Uml], UMLPseudostate[Uml]](
		"connectionPoint", _.connectionPoint, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val StateMachine_extendedStateMachine =
		MetaPropertyCollection[Uml, UMLStateMachine[Uml], UMLStateMachine[Uml]](
		"extendedStateMachine", _.extendedStateMachine, isComposite=false, isUnique=true, isOrdered=false,
		Set(Behavior_redefinedBehavior))

	val StateMachine_region =
		MetaPropertyCollection[Uml, UMLStateMachine[Uml], UMLRegion[Uml]](
		"region", _.region, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val StateMachine_submachineState =
		MetaPropertyCollection[Uml, UMLStateMachine[Uml], UMLState[Uml]](
		"submachineState", _.submachineState, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Stereotype_icon =
		MetaPropertyCollection[Uml, UMLStereotype[Uml], UMLImage[Uml]](
		"icon", _.icon, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val StringExpression_subExpression =
		MetaPropertyCollection[Uml, UMLStringExpression[Uml], UMLStringExpression[Uml]](
		"subExpression", _.subExpression, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val StructuralFeature_isReadOnly =
		MetaAttributeBooleanFunction[Uml, UMLStructuralFeature[Uml]](None, "isReadOnly",
		(x) => booleanToIterable(x.isReadOnly, false))

	val StructuralFeatureAction_object =
		MetaPropertyReference[Uml, UMLStructuralFeatureAction[Uml], UMLInputPin[Uml]](
		"object", _._object, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val StructuralFeatureAction_structuralFeature =
		MetaPropertyReference[Uml, UMLStructuralFeatureAction[Uml], UMLStructuralFeature[Uml]](
		"structuralFeature", _.structuralFeature, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val StructuredActivityNode_edge =
		MetaPropertyCollection[Uml, UMLStructuredActivityNode[Uml], UMLActivityEdge[Uml]](
		"edge", _.edge, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val StructuredActivityNode_mustIsolate =
		MetaAttributeBooleanFunction[Uml, UMLStructuredActivityNode[Uml]](None, "mustIsolate",
		(x) => booleanToIterable(x.mustIsolate, false))

	val StructuredActivityNode_node =
		MetaPropertyCollection[Uml, UMLStructuredActivityNode[Uml], UMLActivityNode[Uml]](
		"node", _.node, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val StructuredActivityNode_structuredNodeInput =
		MetaPropertyCollection[Uml, UMLStructuredActivityNode[Uml], UMLInputPin[Uml]](
		"structuredNodeInput", _.structuredNodeInput, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val StructuredActivityNode_structuredNodeOutput =
		MetaPropertyCollection[Uml, UMLStructuredActivityNode[Uml], UMLOutputPin[Uml]](
		"structuredNodeOutput", _.structuredNodeOutput, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val StructuredActivityNode_variable =
		MetaPropertyCollection[Uml, UMLStructuredActivityNode[Uml], UMLVariable[Uml]](
		"variable", _.variable, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val StructuredClassifier_ownedAttribute =
		MetaPropertyCollection[Uml, UMLStructuredClassifier[Uml], UMLProperty[Uml]](
		"ownedAttribute", _.ownedAttribute, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val StructuredClassifier_ownedConnector =
		MetaPropertyCollection[Uml, UMLStructuredClassifier[Uml], UMLConnector[Uml]](
		"ownedConnector", _.ownedConnector, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Substitution_contract =
		MetaPropertyReference[Uml, UMLSubstitution[Uml], UMLClassifier[Uml]](
		"contract", _.contract, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val TemplateBinding_parameterSubstitution =
		MetaPropertyCollection[Uml, UMLTemplateBinding[Uml], UMLTemplateParameterSubstitution[Uml]](
		"parameterSubstitution", _.parameterSubstitution, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val TemplateBinding_signature =
		MetaPropertyReference[Uml, UMLTemplateBinding[Uml], UMLTemplateSignature[Uml]](
		"signature", _.signature, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val TemplateParameter_default =
		MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLParameterableElement[Uml]](
		"default", _.default, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val TemplateParameter_ownedDefault =
		MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLParameterableElement[Uml]](
		"ownedDefault", _.ownedDefault, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val TemplateParameter_ownedParameteredElement =
		MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLParameterableElement[Uml]](
		"ownedParameteredElement", _.ownedParameteredElement, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val TemplateParameter_parameteredElement =
		MetaPropertyReference[Uml, UMLTemplateParameter[Uml], UMLParameterableElement[Uml]](
		"parameteredElement", _.parameteredElement, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val TemplateParameterSubstitution_actual =
		MetaPropertyReference[Uml, UMLTemplateParameterSubstitution[Uml], UMLParameterableElement[Uml]](
		"actual", _.actual, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val TemplateParameterSubstitution_formal =
		MetaPropertyReference[Uml, UMLTemplateParameterSubstitution[Uml], UMLTemplateParameter[Uml]](
		"formal", _.formal, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val TemplateParameterSubstitution_ownedActual =
		MetaPropertyReference[Uml, UMLTemplateParameterSubstitution[Uml], UMLParameterableElement[Uml]](
		"ownedActual", _.ownedActual, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val TemplateSignature_ownedParameter =
		MetaPropertyCollection[Uml, UMLTemplateSignature[Uml], UMLTemplateParameter[Uml]](
		"ownedParameter", _.ownedParameter, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val TemplateSignature_parameter =
		MetaPropertyCollection[Uml, UMLTemplateSignature[Uml], UMLTemplateParameter[Uml]](
		"parameter", _.parameter, isComposite=false, isUnique=true, isOrdered=true,
		Set())

	val TemplateableElement_ownedTemplateSignature =
		MetaPropertyReference[Uml, UMLTemplateableElement[Uml], UMLTemplateSignature[Uml]](
		"ownedTemplateSignature", _.ownedTemplateSignature, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val TemplateableElement_templateBinding =
		MetaPropertyCollection[Uml, UMLTemplateableElement[Uml], UMLTemplateBinding[Uml]](
		"templateBinding", _.templateBinding, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val TestIdentityAction_first =
		MetaPropertyReference[Uml, UMLTestIdentityAction[Uml], UMLInputPin[Uml]](
		"first", _.first, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val TestIdentityAction_result =
		MetaPropertyReference[Uml, UMLTestIdentityAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val TestIdentityAction_second =
		MetaPropertyReference[Uml, UMLTestIdentityAction[Uml], UMLInputPin[Uml]](
		"second", _.second, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val TimeConstraint_firstEvent =
		MetaAttributeBooleanFunction[Uml, UMLTimeConstraint[Uml]](None, "firstEvent",
		(x) => booleanToIterable(x.firstEvent.getOrElse(true), true))

	val TimeConstraint_specification =
		MetaPropertyReference[Uml, UMLTimeConstraint[Uml], UMLTimeInterval[Uml]](
		"specification", _.specification, isComposite=true, isUnique=true, isOrdered=false,
		Set(IntervalConstraint_specification))

	val TimeEvent_isRelative =
		MetaAttributeBooleanFunction[Uml, UMLTimeEvent[Uml]](None, "isRelative",
		(x) => booleanToIterable(x.isRelative, false))

	val TimeEvent_when =
		MetaPropertyReference[Uml, UMLTimeEvent[Uml], UMLTimeExpression[Uml]](
		"when", _.when, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val TimeExpression_expr =
		MetaPropertyReference[Uml, UMLTimeExpression[Uml], UMLValueSpecification[Uml]](
		"expr", _.expr, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val TimeExpression_observation =
		MetaPropertyCollection[Uml, UMLTimeExpression[Uml], UMLObservation[Uml]](
		"observation", _.observation, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val TimeInterval_max =
		MetaPropertyReference[Uml, UMLTimeInterval[Uml], UMLTimeExpression[Uml]](
		"max", _.max, isComposite=false, isUnique=true, isOrdered=false,
		Set(Interval_max))

	val TimeInterval_min =
		MetaPropertyReference[Uml, UMLTimeInterval[Uml], UMLTimeExpression[Uml]](
		"min", _.min, isComposite=false, isUnique=true, isOrdered=false,
		Set(Interval_min))

	val TimeObservation_event =
		MetaPropertyReference[Uml, UMLTimeObservation[Uml], UMLNamedElement[Uml]](
		"event", _.event, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val TimeObservation_firstEvent =
		MetaAttributeBooleanFunction[Uml, UMLTimeObservation[Uml]](None, "firstEvent",
		(x) => booleanToIterable(x.firstEvent, true))

	val Transition_effect =
		MetaPropertyReference[Uml, UMLTransition[Uml], UMLBehavior[Uml]](
		"effect", _.effect, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Transition_guard =
		MetaPropertyReference[Uml, UMLTransition[Uml], UMLConstraint[Uml]](
		"guard", _.guard, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Transition_kind =
		new MetaAttributeEnumerationFunction[Uml, UMLTransition[Uml], UMLTransitionKind.Value, UMLTransitionKind.ValueSet](
		OptionConstructor(), None, "kind",
		(x: UMLTransition[Uml]) => x.kind, UMLTransitionKind.values)

	val Transition_redefinedTransition =
		MetaPropertyReference[Uml, UMLTransition[Uml], UMLTransition[Uml]](
		"redefinedTransition", _.redefinedTransition, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Transition_source =
		MetaPropertyReference[Uml, UMLTransition[Uml], UMLVertex[Uml]](
		"source", _.source, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Transition_target =
		MetaPropertyReference[Uml, UMLTransition[Uml], UMLVertex[Uml]](
		"target", _.target, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Transition_trigger =
		MetaPropertyCollection[Uml, UMLTransition[Uml], UMLTrigger[Uml]](
		"trigger", _.trigger, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val Trigger_event =
		MetaPropertyReference[Uml, UMLTrigger[Uml], UMLEvent[Uml]](
		"event", _.event, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val Trigger_port =
		MetaPropertyCollection[Uml, UMLTrigger[Uml], UMLPort[Uml]](
		"port", _.port, isComposite=false, isUnique=true, isOrdered=false,
		Set())


	val TypedElement_type =
		MetaPropertyReference[Uml, UMLTypedElement[Uml], UMLType[Uml]](
		"type", _._type, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val UnmarshallAction_object =
		MetaPropertyReference[Uml, UMLUnmarshallAction[Uml], UMLInputPin[Uml]](
		"object", _._object, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val UnmarshallAction_result =
		MetaPropertyCollection[Uml, UMLUnmarshallAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=true,
		Set())

	val UnmarshallAction_unmarshallType =
		MetaPropertyReference[Uml, UMLUnmarshallAction[Uml], UMLClassifier[Uml]](
		"unmarshallType", _.unmarshallType, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val UseCase_extend =
		MetaPropertyCollection[Uml, UMLUseCase[Uml], UMLExtend[Uml]](
		"extend", _.extend, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val UseCase_extensionPoint =
		MetaPropertyCollection[Uml, UMLUseCase[Uml], UMLExtensionPoint[Uml]](
		"extensionPoint", _.extensionPoint, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val UseCase_include =
		MetaPropertyCollection[Uml, UMLUseCase[Uml], UMLInclude[Uml]](
		"include", _.include, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val UseCase_subject =
		MetaPropertyCollection[Uml, UMLUseCase[Uml], UMLClassifier[Uml]](
		"subject", _.subject, isComposite=false, isUnique=true, isOrdered=false,
		Set())

	val ValuePin_value =
		MetaPropertyReference[Uml, UMLValuePin[Uml], UMLValueSpecification[Uml]](
		"value", _.value, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ValueSpecificationAction_result =
		MetaPropertyReference[Uml, UMLValueSpecificationAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val ValueSpecificationAction_value =
		MetaPropertyReference[Uml, UMLValueSpecificationAction[Uml], UMLValueSpecification[Uml]](
		"value", _.value, isComposite=true, isUnique=true, isOrdered=false,
		Set())


	val VariableAction_variable =
		MetaPropertyReference[Uml, UMLVariableAction[Uml], UMLVariable[Uml]](
		"variable", _.variable, isComposite=false, isUnique=true, isOrdered=false,
		Set())


	val WriteStructuralFeatureAction_result =
		MetaPropertyReference[Uml, UMLWriteStructuralFeatureAction[Uml], UMLOutputPin[Uml]](
		"result", _.result, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val WriteStructuralFeatureAction_value =
		MetaPropertyReference[Uml, UMLWriteStructuralFeatureAction[Uml], UMLInputPin[Uml]](
		"value", _.value, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	val WriteVariableAction_value =
		MetaPropertyReference[Uml, UMLWriteVariableAction[Uml], UMLInputPin[Uml]](
		"value", _.value, isComposite=true, isUnique=true, isOrdered=false,
		Set())

	// Start of user code for additional features

  /**
   * Functionally equivalent to the following OCL query:
   * <metaclass>.allInstances()->select(e | scope <> null implies e->closure(owner)->union(e)->includes(scope))
   *
   * @param metaclassName The name of an OMG UML metaclass
   * @param scope An OTI UML element scoping the result of the instances of the OTI UML metaclasses to look for,
   *              or None for a global query
   * @param umlTag The Scala type information about the OTI UML adaptation trait: Uml
   * @param typ The Scala type information about the OTI UML metaclass adapter
   * @param opsTag The Scala type information about the OTI UML Operations type
   * @tparam T The OTI UML metaclass adapter corresponding to the OMG UML metaclass name
   * @return The OTI UML metaclass adapter instances to look for globally or within the ownership scope of some element
   */
  def allInstances[T <: UMLElement[Uml]]
  (metaclassName: String, scope: Option[UMLElement[Uml]])
  (implicit umlTag: TypeTag[Uml], typ: TypeTag[T], opsTag: TypeTag[UMLOps[Uml]])
  : Option[Set[T]] = {

    val mcInfo =
      umlTag.tpe.members
      .find { m => m.isType && m.name.decodedName.toString == metaclassName }
      .map(_.asType)
      .flatMap {
                 case s if s.isAliasType => Some(s.toType.dealias)
                 case _                  => None
               }

    mcInfo match {
      case Some(mcTyp) =>
        val convName = "uml" + metaclassName
        val cs = opsTag.tpe.members
                 .filter { s =>
                   s.isImplicit && s.isMethod && s.name.decodedName.toString == convName
                         }
                 .map(_.asMethod)
                 .flatMap { m =>
                   m.paramLists match {
                     case args :: Nil =>
                       args match {
                         case arg :: Nil =>
                           val argType = arg.info
                           if (argType.typeArgs.isEmpty &&
                             mcTyp.typeSymbol.name == argType.typeSymbol.name)
                             Some((m, mcTyp, m.returnType))
                           else None
                         case _          =>
                           None
                       }
                     case _           =>
                       None
                   }
                          }
                 .headOption

        cs match {
          case Some(Tuple3(m, umlMCTyp, umlOTITyp)) =>
            allInstances[T](umlMCTyp, m.asMethod, umlOTITyp, scope)
          case None                                 =>
            None
        }

      case None =>
        None
    }

  }

  /**
   * Abstract method to be implemented in a tool-specific OTI adapter.
   *
   * @param metaclassType The Scala runtime reflection type information about a tool-specific UML metaclass
   * @param metaclass2umlOTI The Scala runtime reflection method information about the OTI adapter
   *                         for converting an instance of a tool-specific UML metaclasse to
   *                         the corresponding tool-specific OTI UML adapter instance
   * @param umlOTIType The Scala runtime reflection type information about a tool-specific OTI UML metaclass adapter
   * @param scope An OTI UML element scoping the result of the instances of the OTI UML metaclasses to look for,
   *              or None for a global query
   * @param umlTag The Scala type information about the OTI UML adaptation trait: Uml
   * @param typ The Scala type information about the OTI UML metaclass adapter
   * @tparam T The OTI UML metaclass adapter type that is the OTI adapter for the tool-specific `metaclassType`
   * @return The OTI UML metaclass adapter instances to look for globally or within the ownership scope of some element
   */
  protected def allInstances[T <: UMLElement[Uml]]
  (metaclassType: scala.reflect.runtime.universe.Type,
   metaclass2umlOTI: scala.reflect.runtime.universe.MethodSymbol,
   umlOTIType: scala.reflect.runtime.universe.Type,
   scope: Option[UMLElement[Uml]])
  (implicit umlTag: TypeTag[Uml], typ: TypeTag[T])
  : Option[Set[T]]

  val UML_PRIMITIVE_TYPES_BOOLEAN: UMLPrimitiveType[Uml]

  val UML_PRIMITIVE_TYPES_INTEGER: UMLPrimitiveType[Uml]

  val UML_PRIMITIVE_TYPES_UNLIMITED_NATURAL: UMLPrimitiveType[Uml]

  val UML_PRIMITIVE_TYPES_REAL: UMLPrimitiveType[Uml]

  val UML_PRIMITIVE_TYPES_STRING: UMLPrimitiveType[Uml]

  type Element2IDHashMap = scala.collection.mutable.HashMap[UMLElement[Uml],  \/[NonEmptyList[UMLError.UException], String]]

  type Element2IDRule = PartialFunction[
    UMLElement[Uml],
    \/[NonEmptyList[UMLError.UException], String]]

  type ContainedElement2IDRule = PartialFunction[
    (UMLElement[Uml], String, UMLElement[Uml]#MetaPropertyEvaluator, UMLElement[Uml]),
    \/[NonEmptyList[UMLError.UException], String]]

  class FilterableUMLOption[U](o: Option[U]) {

    def selectByKindOf[V <: UMLElement[Uml]](pf: PartialFunction[U, V]): Option[V] =
      o.flatMap { u => if (pf.isDefinedAt(u)) Some(pf(u)) else None }

  }

  implicit def filterable[U](o: Option[U]): FilterableUMLOption[U] = new FilterableUMLOption(o)

  class FilterableUMLIterable[U](it: Iterable[U]) {

    def selectByKindOf[V <: UMLElement[Uml]](pf: PartialFunction[U, V]): Iterable[V] =
      it.flatMap { u => if (pf.isDefinedAt(u)) Some(pf(u)) else None }

  }

  implicit def filterable[U](it: Iterable[U]): FilterableUMLIterable[U] = new FilterableUMLIterable(it)

  class FilterableUMLSeq[U](s: Seq[U]) {

    def selectByKindOf[V <: UMLElement[Uml]](pf: PartialFunction[U, V]): Seq[V] =
      s.flatMap { u => if (pf.isDefinedAt(u)) Some(pf(u)) else None }

  }

  implicit def filterable[U](s: Seq[U]): FilterableUMLSeq[U] = new FilterableUMLSeq(s)

  class FilterableUMLSet[U](s: Set[U]) {

    def selectByKindOf[V <: UMLElement[Uml]](pf: PartialFunction[U, V]): Set[V] =
      s.flatMap { u => if (pf.isDefinedAt(u)) Some(pf(u)) else None }

  }

  implicit def filterable[U](s: Set[U]): FilterableUMLSet[U] = new FilterableUMLSet(s)

  class FilterableUMLStream[U](s: Stream[U]) {

    def selectByKindOf[V <: UMLElement[Uml]](pf: PartialFunction[U, V]): Stream[V] =
      s.flatMap { u => if (pf.isDefinedAt(u)) Some(pf(u)) else None }

  }

  implicit def filterable[U](s: Stream[U]): FilterableUMLStream[U] = new FilterableUMLStream(s)

  val cache = scala.collection.mutable.WeakHashMap[Uml#Element, UMLElement[Uml]]()

  def cacheLookupOrUpdate(e: Uml#Element): UMLElement[Uml]

	/**
	 * The OMG Tool-neutral Interchange API for OMG UML 2.5 compliant modeling tools.
	 * The tool-specific OTI adapter must provide the corresponding tool-specific OTI profile.
	 */
	val OTI_PROFILE
  : NonEmptyList[UMLError.UException] \/ UMLProfile[Uml]

  /**
   * OTI::SpecificationRoot stereotype
   *
   * An OTI::SpecificationRoot-stereotyped package indicates that
   * the package corresponds to a published artifact from a specification.
   * The kind of artifact is specified via the `artifactKind` tag property.
   */
  val OTI_SPECIFICATION_ROOT_S
  : NonEmptyList[UMLError.UException] \/ UMLStereotype[Uml]

  /**
   * OTI::SpecificationRoot::packageURI property
   *
   * If specified, overrides the Package::URI on the package.
   * When serializing an OTI::SpecificationRoot-stereotyped package,
   * the Package::URI of the serialized package will be the value
   * of the OTI::SpecificationRoot::packageURI, if specified,
   * or that of Package::URI. It is an error if both are unspecified.
   */
  val OTI_SPECIFICATION_ROOT_packageURI
  : NonEmptyList[UMLError.UException] \/ UMLProperty[Uml]

  /**
   * OTI::SpecificationRoot::documentURL property
   *
   * When serializing an OTI::SpecificationRoot-stereotyped package,
   * the package will be serialized as a document at the
   * OTI::SpecificationRoot::documentURL
   */
  val OTI_SPECIFICATION_ROOT_documentURL
  : NonEmptyList[UMLError.UException] \/ UMLProperty[Uml]

  /**
   * OTI::SpecificationRoot::nsPrefix property
   *
   * The namespace prefix used for the serialization of an OTI::SpecificationRoot-stereotyped
   * package
   */
  val OTI_SPECIFICATION_ROOT_nsPrefix
  : NonEmptyList[UMLError.UException] \/ UMLProperty[Uml]

  /**
   * OTI::SpecificationRoot::uuidPrefix property
   *
   * The prefix added to the xmi:id to produce the xmi:uuid
   * of every element in an OTI::SpecificationRoot-stereotyped
   * package
   */
  val OTI_SPECIFICATION_ROOT_uuidPrefix
  : NonEmptyList[UMLError.UException] \/ UMLProperty[Uml]

  /**
   * OTI::SpecificationRoot::artifactKind property
   * a 2x2 matrix describing what an OTI::SpecificationRoot-stereotyped
   * package is a model of:
   * - Specified vs. Implemented
   * - Metamodel, Profile, Model Library
   */
  val OTI_SPECIFICATION_ROOT_artifactKind
  : NonEmptyList[UMLError.UException] \/ UMLProperty[Uml]

  /**
   * OTI::SpecificationRootCharacterization stereotype
   *
   * An OTI::SpecificationRootCharacterization-stereotyped comment annotating a single package
   * indicates that the annotated package corresponds to a published artifact from a specification.
   * The kind of artifact is specified via the `artifactKind` tag property.
   */
  val OTI_SPECIFICATION_ROOT_CHARACTERIZATION_S
  : NonEmptyList[UMLError.UException] \/ UMLStereotype[Uml]

  /**
   * OTI::SpecificationRootCharacterization::packageURI property
   *
   * If specified, overrides the Package::URI on the annotated package.
   * When serializing an the annotated package by an OTI::SpecificationRootCharacterization-stereotyped comment,
   * the Package::URI of the serialized annotated package will be the value
   * of the OTI::SpecificationRootCharacterization::packageURI, if specified,
   * or that of Package::URI. It is an error if both are unspecified.
   */
  val OTI_SPECIFICATION_ROOT_CHARACTERIZATION_packageURI
  : NonEmptyList[UMLError.UException] \/ UMLProperty[Uml]

  /**
   * OTI::SpecificationRootCharacterization::documentURL property
   *
   * When serializing a package annotated by an OTI::SpecificationRootCharacterization-stereotyped comment,
   * the annotated package will be serialized as a document at the
   * OTI::SpecificationRootCharacterization::documentURL
   */
  val OTI_SPECIFICATION_ROOT_CHARACTERIZATION_documentURL
  : NonEmptyList[UMLError.UException] \/ UMLProperty[Uml]

  /**
   * OTI::SpecificationRootCharacterization::nsPrefix property
   *
   * The namespace prefix used for the serialization of a package annotated
   * by an OTI::SpecificationRootCharacterization-stereotyped comment
   */
  val OTI_SPECIFICATION_ROOT_CHARACTERIZATION_nsPrefix
  : NonEmptyList[UMLError.UException] \/ UMLProperty[Uml]

  /**
   * OTI::SpecificationRootCharacterization::uuidPrefix property
   *
   * The prefix added to the xmi:id to produce the xmi:uuid
   * of every element in the scope of a package annotated
   * by an OTI::SpecificationRootCharacterization-stereotyped comment
   */
  val OTI_SPECIFICATION_ROOT_CHARACTERIZATION_uuidPrefix
  : NonEmptyList[UMLError.UException] \/ UMLProperty[Uml]

  /**
   * OTI::SpecificationRootCharacterization::artifactKind property
   * a 2x2 matrix describing what the annotated package of an
   * OTI::SpecificationRootCharacterization-stereotyped comment is a model of:
   * - Specified vs. Implemented
   * - Metamodel, Profile, Model Library
   */
  val OTI_SPECIFICATION_ROOT_CHARACTERIZATION_artifactKind
  : NonEmptyList[UMLError.UException] \/ UMLProperty[Uml]

  /**
   *
   */
  val OTI_ARTIFACT_KIND
  : NonEmptyList[UMLError.UException] \/ UMLEnumeration[Uml]

  val OTI_ARTIFACT_KIND_SPECIFIED_METAMODEL
  : NonEmptyList[UMLError.UException] \/ UMLEnumerationLiteral[Uml]

  val OTI_ARTIFACT_KIND_SPECIFIED_PROFILE
  : NonEmptyList[UMLError.UException] \/ UMLEnumerationLiteral[Uml]

  val OTI_ARTIFACT_KIND_SPECIFIED_MODEL_LIBRARY
  : NonEmptyList[UMLError.UException] \/ UMLEnumerationLiteral[Uml]

  val OTI_ARTIFACT_KIND_IMPLEMENTED_METAMODEL
  : NonEmptyList[UMLError.UException] \/ UMLEnumerationLiteral[Uml]

  val OTI_ARTIFACT_KIND_IMPLEMENTED_PROFILE
  : NonEmptyList[UMLError.UException] \/ UMLEnumerationLiteral[Uml]

  val OTI_ARTIFACT_KIND_IMPLEMENTED_MODEL_LIBRARY
  : NonEmptyList[UMLError.UException] \/ UMLEnumerationLiteral[Uml]

  /**
   * OTI::Identity stereotype
   *
   * If applied to an element within an OTI::SpecificationRoot-stereotyped
   * containing package, allows overriding xmi:ID generation,
   * xmi:UUID generation or both
   */
  val OTI_IDENTITY_S
  : NonEmptyList[UMLError.UException] \/ UMLStereotype[Uml]

  /**
   * OTI::Identity::xmiID property
   *
   * If specified on an element, use the value as xmi:ID
   * Instead of generating one
   */
  val OTI_IDENTITY_xmiID
  : NonEmptyList[UMLError.UException] \/ UMLProperty[Uml]

  /**
   * OTI::Identity::xmiUUID property
   *
   * If specified on an element, use the value as xmi:UUID
   * Instead of generating one based on the uuid prefix
   * of the OTI::SpecificationRoot-stereotyped
   * containing package and the element's xmi:ID
   */
  val OTI_IDENTITY_xmiUUID
  : NonEmptyList[UMLError.UException] \/ UMLProperty[Uml]

  def closure[U, V <: U](x: U, relation: U => Iterable[V]): Set[V] = {

    case class RelationClosureVisitor
    (result: scala.collection.mutable.Set[V],
     visit: scala.collection.mutable.Buffer[V],
     visited: scala.collection.mutable.Set[V])

    val visitor = RelationClosureVisitor(
      scala.collection.mutable.Set[V](),
      relation(x).toBuffer,
      scala.collection.mutable.Set[V]())

    while (visitor.visit.nonEmpty) {
      val y = visitor.visit.remove(0)
      visitor.visited += y
      visitor.result += y
      relation(y) foreach (yi => {
        visitor.result += yi
        if (!visitor.visited.contains(yi)) {
          visitor.visit += yi
        }
      })
    }

    visitor.result.toSet
  }

  /**
   * Corresponds to OCL's type1.conformsTo(type2)
   */
  def conformsTo(type1: Option[UMLType[Uml]], type2: Option[UMLType[Uml]]): Boolean =
    (type1, type2) match {
      case (None, None)         => false
      case (None, Some(_))      => false
      case (Some(_), None)      => false
      case (Some(t1), Some(t2)) => conformsTo(t1, t2)
    }

  def conformsTo(type1: UMLType[Uml], type2: UMLType[Uml]): Boolean =
    type1.conformsTo(Some(type2))

  // End of user code
}
