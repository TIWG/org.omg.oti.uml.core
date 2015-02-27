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
package org.omg.oti.operations

import org.omg.oti._
import org.eclipse.emf.ecore.EStructuralFeature
import scala.reflect.runtime.universe._
import scala.reflect.{ classTag, ClassTag }
import scala.language.implicitConversions
import scala.language.higherKinds
import scala.util.Try

class EarlyInit[T: TypeTag] {
  val mirror = runtimeMirror( this.getClass.getClassLoader )
  val reflection = mirror.reflect( this )

  System.out.println( "EarlyInit (start)" )

  typeTag[T]
    .tpe
    .members
    .filter( _.isModule )
    .foreach( m => {
      System.out.println( "EarlyInit: " + m.name )
      reflection.reflectModule( m.asModule ).instance
    } )

  System.out.println( "EarlyInit (done)" )

}

trait UMLOps[Uml <: UML] { self =>

  type Element2IDHashMap = scala.collection.mutable.HashMap[UMLElement[Uml], Try[String]]

  type Element2IDRule = PartialFunction[UMLElement[Uml], Try[String]]
  type ContainedElement2IDRule = PartialFunction[( UMLElement[Uml], String, EStructuralFeature, UMLElement[Uml] ), Try[String]]

  class FilterableUMLOption[U]( o: Option[U] ) {

    def selectByKindOf[V <: UMLElement[Uml]]( pf: PartialFunction[U, V] ): Option[V] =
      o.flatMap { u => if ( pf.isDefinedAt( u ) ) Some( pf( u ) ) else None }

  }

  implicit def filterable[U]( o: Option[U] ) = new FilterableUMLOption( o )

  class FilterableUMLIterator[U]( it: Iterator[U] ) {

    def selectByKindOf[V <: UMLElement[Uml]]( pf: PartialFunction[U, V] ): Iterable[V] =
      ( it.flatMap { u => if ( pf.isDefinedAt( u ) ) Some( pf( u ) ) else None } ).toIterable

  }

  implicit def filterable[U]( it: Iterator[U] ) = new FilterableUMLIterator( it )

  class FilterableUMLIterable[U]( it: Iterable[U] ) {

    def selectByKindOf[V <: UMLElement[Uml]]( pf: PartialFunction[U, V] ): Iterable[V] =
      it.flatMap { u => if ( pf.isDefinedAt( u ) ) Some( pf( u ) ) else None }

  }

  implicit def filterable[U]( it: Iterable[U] ) = new FilterableUMLIterable( it )

  class FilterableUMLSeq[U]( s: Seq[U] ) {

    def selectByKindOf[V <: UMLElement[Uml]]( pf: PartialFunction[U, V] ): Seq[V] =
      s.flatMap { u => if ( pf.isDefinedAt( u ) ) Some( pf( u ) ) else None }

  }

  implicit def filterable[U]( s: Seq[U] ) = new FilterableUMLSeq( s )

  class FilterableUMLSet[U]( s: Set[U] ) {

    def selectByKindOf[V <: UMLElement[Uml]]( pf: PartialFunction[U, V] ): Set[V] =
      s.flatMap { u => if ( pf.isDefinedAt( u ) ) Some( pf( u ) ) else None }

  }

  implicit def filterable[U]( s: Set[U] ) = new FilterableUMLSet( s )

  class FilterableUMLStream[U]( s: Stream[U] ) {

    def selectByKindOf[V <: UMLElement[Uml]]( pf: PartialFunction[U, V] ): Stream[V] =
      s.flatMap { u => if ( pf.isDefinedAt( u ) ) Some( pf( u ) ) else None }

  }

  implicit def filterable[U]( s: Stream[U] ) = new FilterableUMLStream( s )

  val cache = scala.collection.mutable.WeakHashMap[Uml#Element, UMLElement[Uml]]()

  def cacheLookupOrUpdate( e: Uml#Element ): UMLElement[Uml]

  def cacheLookupOrUpdateAs[U <: Uml#Element: ClassTag, V <: UMLElement[Uml]: ClassTag]( e: U )( implicit uTag: ClassTag[U], vTag: ClassTag[V] ): V = {
    if ( e == null ) null.asInstanceOf[V]
    else {
      val v = cacheLookupOrUpdate( e )
      val rv = vTag.runtimeClass
      require( rv.isInstance( v ), s"lookup of ${e.xmiType.head}: ${e.id} got: ${v.xmiType.head}: ${v.id}, not a ${rv.getName}" )
      v.asInstanceOf[V]
    }
  }

  def illegalElementException[E <: UMLElement[Uml]]( message: String, e: E ) =
    IllegalElementException[Uml, E]( message, Iterable( e ) )

  def illegalElementException[E <: UMLElement[Uml]]( message: String, e: Iterable[E] ) =
    IllegalElementException[Uml, E]( message, e )

  /**
   * OTI::SpecificationRoot stereotype
   */
  val OTI_SPECIFICATION_ROOT_S: Option[Uml#Stereotype]

  /**
   * OTI::SpecificationRoot::packageURI property
   */
  val OTI_SPECIFICATION_ROOT_packageURI: Option[Uml#Property]

  /**
   * OTI::ID stereotype
   */
  val OTI_ID_S: Option[Uml#Stereotype]

  /**
   * OTI::ID stereotype
   */
  val OTI_ID_uuid: Option[Uml#Property]

  val SLOT_VALUE: EStructuralFeature

  def closure[U, V <: U]( x: U, relation: U => Iterable[V] ): Set[V] = {

    case class RelationClosureVisitor(
      result: scala.collection.mutable.Set[V],
      visit: scala.collection.mutable.Buffer[V],
      visited: scala.collection.mutable.Set[V] )

    val visitor = RelationClosureVisitor( scala.collection.mutable.Set[V](), relation( x ).toBuffer, scala.collection.mutable.Set[V]() )
    while ( visitor.visit.nonEmpty ) {
      val y = visitor.visit.remove( 0 )
      visitor.visited += y
      visitor.result += y
      relation( y ) foreach ( yi => {
        visitor.result += yi
        if ( !visitor.visited.contains( yi ) ) { visitor.visit += yi }
      } )
    }
    visitor.result.toSet

  }

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

  implicit def umlAbstraction( e: Uml#Abstraction ): UMLAbstraction[Uml]
  implicit def umlAbstraction( c: Iterable[Uml#Abstraction] ): Iterable[UMLAbstraction[Uml]] = for { e <- c } yield umlAbstraction( e )
  implicit def umlAbstraction( c: Seq[Uml#Abstraction] ): Seq[UMLAbstraction[Uml]] = for { e <- c } yield umlAbstraction( e )
  implicit def umlAbstraction( c: Set[Uml#Abstraction] ): Set[UMLAbstraction[Uml]] = for { e <- c } yield umlAbstraction( e )

  implicit def umlAcceptCallAction( e: Uml#AcceptCallAction ): UMLAcceptCallAction[Uml]
  implicit def umlAcceptCallAction( c: Iterable[Uml#AcceptCallAction] ): Iterable[UMLAcceptCallAction[Uml]] = for { e <- c } yield umlAcceptCallAction( e )
  implicit def umlAcceptCallAction( c: Seq[Uml#AcceptCallAction] ): Seq[UMLAcceptCallAction[Uml]] = for { e <- c } yield umlAcceptCallAction( e )
  implicit def umlAcceptCallAction( c: Set[Uml#AcceptCallAction] ): Set[UMLAcceptCallAction[Uml]] = for { e <- c } yield umlAcceptCallAction( e )

  implicit def umlAcceptEventAction( e: Uml#AcceptEventAction ): UMLAcceptEventAction[Uml]
  implicit def umlAcceptEventAction( c: Iterable[Uml#AcceptEventAction] ): Iterable[UMLAcceptEventAction[Uml]] = for { e <- c } yield umlAcceptEventAction( e )
  implicit def umlAcceptEventAction( c: Seq[Uml#AcceptEventAction] ): Seq[UMLAcceptEventAction[Uml]] = for { e <- c } yield umlAcceptEventAction( e )
  implicit def umlAcceptEventAction( c: Set[Uml#AcceptEventAction] ): Set[UMLAcceptEventAction[Uml]] = for { e <- c } yield umlAcceptEventAction( e )

  implicit def umlAction( e: Uml#Action ): UMLAction[Uml]
  implicit def umlAction( c: Iterable[Uml#Action] ): Iterable[UMLAction[Uml]] = for { e <- c } yield umlAction( e )
  implicit def umlAction( c: Seq[Uml#Action] ): Seq[UMLAction[Uml]] = for { e <- c } yield umlAction( e )
  implicit def umlAction( c: Set[Uml#Action] ): Set[UMLAction[Uml]] = for { e <- c } yield umlAction( e )

  implicit def umlActionExecutionSpecification( e: Uml#ActionExecutionSpecification ): UMLActionExecutionSpecification[Uml]
  implicit def umlActionExecutionSpecification( c: Iterable[Uml#ActionExecutionSpecification] ): Iterable[UMLActionExecutionSpecification[Uml]] = for { e <- c } yield umlActionExecutionSpecification( e )
  implicit def umlActionExecutionSpecification( c: Seq[Uml#ActionExecutionSpecification] ): Seq[UMLActionExecutionSpecification[Uml]] = for { e <- c } yield umlActionExecutionSpecification( e )
  implicit def umlActionExecutionSpecification( c: Set[Uml#ActionExecutionSpecification] ): Set[UMLActionExecutionSpecification[Uml]] = for { e <- c } yield umlActionExecutionSpecification( e )

  implicit def umlActionInputPin( e: Uml#ActionInputPin ): UMLActionInputPin[Uml]
  implicit def umlActionInputPin( c: Iterable[Uml#ActionInputPin] ): Iterable[UMLActionInputPin[Uml]] = for { e <- c } yield umlActionInputPin( e )
  implicit def umlActionInputPin( c: Seq[Uml#ActionInputPin] ): Seq[UMLActionInputPin[Uml]] = for { e <- c } yield umlActionInputPin( e )
  implicit def umlActionInputPin( c: Set[Uml#ActionInputPin] ): Set[UMLActionInputPin[Uml]] = for { e <- c } yield umlActionInputPin( e )

  implicit def umlActivity( e: Uml#Activity ): UMLActivity[Uml]
  implicit def umlActivity( c: Iterable[Uml#Activity] ): Iterable[UMLActivity[Uml]] = for { e <- c } yield umlActivity( e )
  implicit def umlActivity( c: Seq[Uml#Activity] ): Seq[UMLActivity[Uml]] = for { e <- c } yield umlActivity( e )
  implicit def umlActivity( c: Set[Uml#Activity] ): Set[UMLActivity[Uml]] = for { e <- c } yield umlActivity( e )

  implicit def umlActivityEdge( e: Uml#ActivityEdge ): UMLActivityEdge[Uml]
  implicit def umlActivityEdge( c: Iterable[Uml#ActivityEdge] ): Iterable[UMLActivityEdge[Uml]] = for { e <- c } yield umlActivityEdge( e )
  implicit def umlActivityEdge( c: Seq[Uml#ActivityEdge] ): Seq[UMLActivityEdge[Uml]] = for { e <- c } yield umlActivityEdge( e )
  implicit def umlActivityEdge( c: Set[Uml#ActivityEdge] ): Set[UMLActivityEdge[Uml]] = for { e <- c } yield umlActivityEdge( e )

  implicit def umlActivityFinalNode( e: Uml#ActivityFinalNode ): UMLActivityFinalNode[Uml]
  implicit def umlActivityFinalNode( c: Iterable[Uml#ActivityFinalNode] ): Iterable[UMLActivityFinalNode[Uml]] = for { e <- c } yield umlActivityFinalNode( e )
  implicit def umlActivityFinalNode( c: Seq[Uml#ActivityFinalNode] ): Seq[UMLActivityFinalNode[Uml]] = for { e <- c } yield umlActivityFinalNode( e )
  implicit def umlActivityFinalNode( c: Set[Uml#ActivityFinalNode] ): Set[UMLActivityFinalNode[Uml]] = for { e <- c } yield umlActivityFinalNode( e )

  implicit def umlActivityGroup( e: Uml#ActivityGroup ): UMLActivityGroup[Uml]
  implicit def umlActivityGroup( c: Iterable[Uml#ActivityGroup] ): Iterable[UMLActivityGroup[Uml]] = for { e <- c } yield umlActivityGroup( e )
  implicit def umlActivityGroup( c: Seq[Uml#ActivityGroup] ): Seq[UMLActivityGroup[Uml]] = for { e <- c } yield umlActivityGroup( e )
  implicit def umlActivityGroup( c: Set[Uml#ActivityGroup] ): Set[UMLActivityGroup[Uml]] = for { e <- c } yield umlActivityGroup( e )

  implicit def umlActivityNode( e: Uml#ActivityNode ): UMLActivityNode[Uml]
  implicit def umlActivityNode( c: Iterable[Uml#ActivityNode] ): Iterable[UMLActivityNode[Uml]] = for { e <- c } yield umlActivityNode( e )
  implicit def umlActivityNode( c: Seq[Uml#ActivityNode] ): Seq[UMLActivityNode[Uml]] = for { e <- c } yield umlActivityNode( e )
  implicit def umlActivityNode( c: Set[Uml#ActivityNode] ): Set[UMLActivityNode[Uml]] = for { e <- c } yield umlActivityNode( e )

  implicit def umlActivityParameterNode( e: Uml#ActivityParameterNode ): UMLActivityParameterNode[Uml]
  implicit def umlActivityParameterNode( c: Iterable[Uml#ActivityParameterNode] ): Iterable[UMLActivityParameterNode[Uml]] = for { e <- c } yield umlActivityParameterNode( e )
  implicit def umlActivityParameterNode( c: Seq[Uml#ActivityParameterNode] ): Seq[UMLActivityParameterNode[Uml]] = for { e <- c } yield umlActivityParameterNode( e )
  implicit def umlActivityParameterNode( c: Set[Uml#ActivityParameterNode] ): Set[UMLActivityParameterNode[Uml]] = for { e <- c } yield umlActivityParameterNode( e )

  implicit def umlActivityPartition( e: Uml#ActivityPartition ): UMLActivityPartition[Uml]
  implicit def umlActivityPartition( c: Iterable[Uml#ActivityPartition] ): Iterable[UMLActivityPartition[Uml]] = for { e <- c } yield umlActivityPartition( e )
  implicit def umlActivityPartition( c: Seq[Uml#ActivityPartition] ): Seq[UMLActivityPartition[Uml]] = for { e <- c } yield umlActivityPartition( e )
  implicit def umlActivityPartition( c: Set[Uml#ActivityPartition] ): Set[UMLActivityPartition[Uml]] = for { e <- c } yield umlActivityPartition( e )

  implicit def umlActor( e: Uml#Actor ): UMLActor[Uml]
  implicit def umlActor( c: Iterable[Uml#Actor] ): Iterable[UMLActor[Uml]] = for { e <- c } yield umlActor( e )
  implicit def umlActor( c: Seq[Uml#Actor] ): Seq[UMLActor[Uml]] = for { e <- c } yield umlActor( e )
  implicit def umlActor( c: Set[Uml#Actor] ): Set[UMLActor[Uml]] = for { e <- c } yield umlActor( e )

  implicit def umlAddStructuralFeatureValueAction( e: Uml#AddStructuralFeatureValueAction ): UMLAddStructuralFeatureValueAction[Uml]
  implicit def umlAddStructuralFeatureValueAction( c: Iterable[Uml#AddStructuralFeatureValueAction] ): Iterable[UMLAddStructuralFeatureValueAction[Uml]] = for { e <- c } yield umlAddStructuralFeatureValueAction( e )
  implicit def umlAddStructuralFeatureValueAction( c: Seq[Uml#AddStructuralFeatureValueAction] ): Seq[UMLAddStructuralFeatureValueAction[Uml]] = for { e <- c } yield umlAddStructuralFeatureValueAction( e )
  implicit def umlAddStructuralFeatureValueAction( c: Set[Uml#AddStructuralFeatureValueAction] ): Set[UMLAddStructuralFeatureValueAction[Uml]] = for { e <- c } yield umlAddStructuralFeatureValueAction( e )

  implicit def umlAddVariableValueAction( e: Uml#AddVariableValueAction ): UMLAddVariableValueAction[Uml]
  implicit def umlAddVariableValueAction( c: Iterable[Uml#AddVariableValueAction] ): Iterable[UMLAddVariableValueAction[Uml]] = for { e <- c } yield umlAddVariableValueAction( e )
  implicit def umlAddVariableValueAction( c: Seq[Uml#AddVariableValueAction] ): Seq[UMLAddVariableValueAction[Uml]] = for { e <- c } yield umlAddVariableValueAction( e )
  implicit def umlAddVariableValueAction( c: Set[Uml#AddVariableValueAction] ): Set[UMLAddVariableValueAction[Uml]] = for { e <- c } yield umlAddVariableValueAction( e )

  implicit def umlAnyReceiveEvent( e: Uml#AnyReceiveEvent ): UMLAnyReceiveEvent[Uml]
  implicit def umlAnyReceiveEvent( c: Iterable[Uml#AnyReceiveEvent] ): Iterable[UMLAnyReceiveEvent[Uml]] = for { e <- c } yield umlAnyReceiveEvent( e )
  implicit def umlAnyReceiveEvent( c: Seq[Uml#AnyReceiveEvent] ): Seq[UMLAnyReceiveEvent[Uml]] = for { e <- c } yield umlAnyReceiveEvent( e )
  implicit def umlAnyReceiveEvent( c: Set[Uml#AnyReceiveEvent] ): Set[UMLAnyReceiveEvent[Uml]] = for { e <- c } yield umlAnyReceiveEvent( e )

  implicit def umlArtifact( e: Uml#Artifact ): UMLArtifact[Uml]
  implicit def umlArtifact( c: Iterable[Uml#Artifact] ): Iterable[UMLArtifact[Uml]] = for { e <- c } yield umlArtifact( e )
  implicit def umlArtifact( c: Seq[Uml#Artifact] ): Seq[UMLArtifact[Uml]] = for { e <- c } yield umlArtifact( e )
  implicit def umlArtifact( c: Set[Uml#Artifact] ): Set[UMLArtifact[Uml]] = for { e <- c } yield umlArtifact( e )

  implicit def umlAssociation( e: Uml#Association ): UMLAssociation[Uml]
  implicit def umlAssociation( c: Iterable[Uml#Association] ): Iterable[UMLAssociation[Uml]] = for { e <- c } yield umlAssociation( e )
  implicit def umlAssociation( c: Seq[Uml#Association] ): Seq[UMLAssociation[Uml]] = for { e <- c } yield umlAssociation( e )
  implicit def umlAssociation( c: Set[Uml#Association] ): Set[UMLAssociation[Uml]] = for { e <- c } yield umlAssociation( e )

  implicit def umlAssociationClass( e: Uml#AssociationClass ): UMLAssociationClass[Uml]
  implicit def umlAssociationClass( c: Iterable[Uml#AssociationClass] ): Iterable[UMLAssociationClass[Uml]] = for { e <- c } yield umlAssociationClass( e )
  implicit def umlAssociationClass( c: Seq[Uml#AssociationClass] ): Seq[UMLAssociationClass[Uml]] = for { e <- c } yield umlAssociationClass( e )
  implicit def umlAssociationClass( c: Set[Uml#AssociationClass] ): Set[UMLAssociationClass[Uml]] = for { e <- c } yield umlAssociationClass( e )

  implicit def umlBehavior( e: Uml#Behavior ): UMLBehavior[Uml]
  implicit def umlBehavior( c: Iterable[Uml#Behavior] ): Iterable[UMLBehavior[Uml]] = for { e <- c } yield umlBehavior( e )
  implicit def umlBehavior( c: Seq[Uml#Behavior] ): Seq[UMLBehavior[Uml]] = for { e <- c } yield umlBehavior( e )
  implicit def umlBehavior( c: Set[Uml#Behavior] ): Set[UMLBehavior[Uml]] = for { e <- c } yield umlBehavior( e )

  implicit def umlBehaviorExecutionSpecification( e: Uml#BehaviorExecutionSpecification ): UMLBehaviorExecutionSpecification[Uml]
  implicit def umlBehaviorExecutionSpecification( c: Iterable[Uml#BehaviorExecutionSpecification] ): Iterable[UMLBehaviorExecutionSpecification[Uml]] = for { e <- c } yield umlBehaviorExecutionSpecification( e )
  implicit def umlBehaviorExecutionSpecification( c: Seq[Uml#BehaviorExecutionSpecification] ): Seq[UMLBehaviorExecutionSpecification[Uml]] = for { e <- c } yield umlBehaviorExecutionSpecification( e )
  implicit def umlBehaviorExecutionSpecification( c: Set[Uml#BehaviorExecutionSpecification] ): Set[UMLBehaviorExecutionSpecification[Uml]] = for { e <- c } yield umlBehaviorExecutionSpecification( e )

  implicit def umlBehavioralFeature( e: Uml#BehavioralFeature ): UMLBehavioralFeature[Uml]
  implicit def umlBehavioralFeature( c: Iterable[Uml#BehavioralFeature] ): Iterable[UMLBehavioralFeature[Uml]] = for { e <- c } yield umlBehavioralFeature( e )
  implicit def umlBehavioralFeature( c: Seq[Uml#BehavioralFeature] ): Seq[UMLBehavioralFeature[Uml]] = for { e <- c } yield umlBehavioralFeature( e )
  implicit def umlBehavioralFeature( c: Set[Uml#BehavioralFeature] ): Set[UMLBehavioralFeature[Uml]] = for { e <- c } yield umlBehavioralFeature( e )

  implicit def umlBehavioredClassifier( e: Uml#BehavioredClassifier ): UMLBehavioredClassifier[Uml]
  implicit def umlBehavioredClassifier( c: Iterable[Uml#BehavioredClassifier] ): Iterable[UMLBehavioredClassifier[Uml]] = for { e <- c } yield umlBehavioredClassifier( e )
  implicit def umlBehavioredClassifier( c: Seq[Uml#BehavioredClassifier] ): Seq[UMLBehavioredClassifier[Uml]] = for { e <- c } yield umlBehavioredClassifier( e )
  implicit def umlBehavioredClassifier( c: Set[Uml#BehavioredClassifier] ): Set[UMLBehavioredClassifier[Uml]] = for { e <- c } yield umlBehavioredClassifier( e )

  implicit def umlBroadcastSignalAction( e: Uml#BroadcastSignalAction ): UMLBroadcastSignalAction[Uml]
  implicit def umlBroadcastSignalAction( c: Iterable[Uml#BroadcastSignalAction] ): Iterable[UMLBroadcastSignalAction[Uml]] = for { e <- c } yield umlBroadcastSignalAction( e )
  implicit def umlBroadcastSignalAction( c: Seq[Uml#BroadcastSignalAction] ): Seq[UMLBroadcastSignalAction[Uml]] = for { e <- c } yield umlBroadcastSignalAction( e )
  implicit def umlBroadcastSignalAction( c: Set[Uml#BroadcastSignalAction] ): Set[UMLBroadcastSignalAction[Uml]] = for { e <- c } yield umlBroadcastSignalAction( e )

  implicit def umlCallAction( e: Uml#CallAction ): UMLCallAction[Uml]
  implicit def umlCallAction( c: Iterable[Uml#CallAction] ): Iterable[UMLCallAction[Uml]] = for { e <- c } yield umlCallAction( e )
  implicit def umlCallAction( c: Seq[Uml#CallAction] ): Seq[UMLCallAction[Uml]] = for { e <- c } yield umlCallAction( e )
  implicit def umlCallAction( c: Set[Uml#CallAction] ): Set[UMLCallAction[Uml]] = for { e <- c } yield umlCallAction( e )

  implicit def umlCallBehaviorAction( e: Uml#CallBehaviorAction ): UMLCallBehaviorAction[Uml]
  implicit def umlCallBehaviorAction( c: Iterable[Uml#CallBehaviorAction] ): Iterable[UMLCallBehaviorAction[Uml]] = for { e <- c } yield umlCallBehaviorAction( e )
  implicit def umlCallBehaviorAction( c: Seq[Uml#CallBehaviorAction] ): Seq[UMLCallBehaviorAction[Uml]] = for { e <- c } yield umlCallBehaviorAction( e )
  implicit def umlCallBehaviorAction( c: Set[Uml#CallBehaviorAction] ): Set[UMLCallBehaviorAction[Uml]] = for { e <- c } yield umlCallBehaviorAction( e )

  implicit def umlCallEvent( e: Uml#CallEvent ): UMLCallEvent[Uml]
  implicit def umlCallEvent( c: Iterable[Uml#CallEvent] ): Iterable[UMLCallEvent[Uml]] = for { e <- c } yield umlCallEvent( e )
  implicit def umlCallEvent( c: Seq[Uml#CallEvent] ): Seq[UMLCallEvent[Uml]] = for { e <- c } yield umlCallEvent( e )
  implicit def umlCallEvent( c: Set[Uml#CallEvent] ): Set[UMLCallEvent[Uml]] = for { e <- c } yield umlCallEvent( e )

  implicit def umlCallOperationAction( e: Uml#CallOperationAction ): UMLCallOperationAction[Uml]
  implicit def umlCallOperationAction( c: Iterable[Uml#CallOperationAction] ): Iterable[UMLCallOperationAction[Uml]] = for { e <- c } yield umlCallOperationAction( e )
  implicit def umlCallOperationAction( c: Seq[Uml#CallOperationAction] ): Seq[UMLCallOperationAction[Uml]] = for { e <- c } yield umlCallOperationAction( e )
  implicit def umlCallOperationAction( c: Set[Uml#CallOperationAction] ): Set[UMLCallOperationAction[Uml]] = for { e <- c } yield umlCallOperationAction( e )

  implicit def umlCentralBufferNode( e: Uml#CentralBufferNode ): UMLCentralBufferNode[Uml]
  implicit def umlCentralBufferNode( c: Iterable[Uml#CentralBufferNode] ): Iterable[UMLCentralBufferNode[Uml]] = for { e <- c } yield umlCentralBufferNode( e )
  implicit def umlCentralBufferNode( c: Seq[Uml#CentralBufferNode] ): Seq[UMLCentralBufferNode[Uml]] = for { e <- c } yield umlCentralBufferNode( e )
  implicit def umlCentralBufferNode( c: Set[Uml#CentralBufferNode] ): Set[UMLCentralBufferNode[Uml]] = for { e <- c } yield umlCentralBufferNode( e )

  implicit def umlChangeEvent( e: Uml#ChangeEvent ): UMLChangeEvent[Uml]
  implicit def umlChangeEvent( c: Iterable[Uml#ChangeEvent] ): Iterable[UMLChangeEvent[Uml]] = for { e <- c } yield umlChangeEvent( e )
  implicit def umlChangeEvent( c: Seq[Uml#ChangeEvent] ): Seq[UMLChangeEvent[Uml]] = for { e <- c } yield umlChangeEvent( e )
  implicit def umlChangeEvent( c: Set[Uml#ChangeEvent] ): Set[UMLChangeEvent[Uml]] = for { e <- c } yield umlChangeEvent( e )

  implicit def umlClass( e: Uml#Class ): UMLClass[Uml]
  implicit def umlClass( c: Iterable[Uml#Class] ): Iterable[UMLClass[Uml]] = for { e <- c } yield umlClass( e )
  implicit def umlClass( c: Seq[Uml#Class] ): Seq[UMLClass[Uml]] = for { e <- c } yield umlClass( e )
  implicit def umlClass( c: Set[Uml#Class] ): Set[UMLClass[Uml]] = for { e <- c } yield umlClass( e )

  implicit def umlClassifier( e: Uml#Classifier ): UMLClassifier[Uml]
  implicit def umlClassifier( c: Iterable[Uml#Classifier] ): Iterable[UMLClassifier[Uml]] = for { e <- c } yield umlClassifier( e )
  implicit def umlClassifier( c: Seq[Uml#Classifier] ): Seq[UMLClassifier[Uml]] = for { e <- c } yield umlClassifier( e )
  implicit def umlClassifier( c: Set[Uml#Classifier] ): Set[UMLClassifier[Uml]] = for { e <- c } yield umlClassifier( e )

  implicit def umlClassifierTemplateParameter( e: Uml#ClassifierTemplateParameter ): UMLClassifierTemplateParameter[Uml]
  implicit def umlClassifierTemplateParameter( c: Iterable[Uml#ClassifierTemplateParameter] ): Iterable[UMLClassifierTemplateParameter[Uml]] = for { e <- c } yield umlClassifierTemplateParameter( e )
  implicit def umlClassifierTemplateParameter( c: Seq[Uml#ClassifierTemplateParameter] ): Seq[UMLClassifierTemplateParameter[Uml]] = for { e <- c } yield umlClassifierTemplateParameter( e )
  implicit def umlClassifierTemplateParameter( c: Set[Uml#ClassifierTemplateParameter] ): Set[UMLClassifierTemplateParameter[Uml]] = for { e <- c } yield umlClassifierTemplateParameter( e )

  implicit def umlClause( e: Uml#Clause ): UMLClause[Uml]
  implicit def umlClause( c: Iterable[Uml#Clause] ): Iterable[UMLClause[Uml]] = for { e <- c } yield umlClause( e )
  implicit def umlClause( c: Seq[Uml#Clause] ): Seq[UMLClause[Uml]] = for { e <- c } yield umlClause( e )
  implicit def umlClause( c: Set[Uml#Clause] ): Set[UMLClause[Uml]] = for { e <- c } yield umlClause( e )

  implicit def umlClearAssociationAction( e: Uml#ClearAssociationAction ): UMLClearAssociationAction[Uml]
  implicit def umlClearAssociationAction( c: Iterable[Uml#ClearAssociationAction] ): Iterable[UMLClearAssociationAction[Uml]] = for { e <- c } yield umlClearAssociationAction( e )
  implicit def umlClearAssociationAction( c: Seq[Uml#ClearAssociationAction] ): Seq[UMLClearAssociationAction[Uml]] = for { e <- c } yield umlClearAssociationAction( e )
  implicit def umlClearAssociationAction( c: Set[Uml#ClearAssociationAction] ): Set[UMLClearAssociationAction[Uml]] = for { e <- c } yield umlClearAssociationAction( e )

  implicit def umlClearStructuralFeatureAction( e: Uml#ClearStructuralFeatureAction ): UMLClearStructuralFeatureAction[Uml]
  implicit def umlClearStructuralFeatureAction( c: Iterable[Uml#ClearStructuralFeatureAction] ): Iterable[UMLClearStructuralFeatureAction[Uml]] = for { e <- c } yield umlClearStructuralFeatureAction( e )
  implicit def umlClearStructuralFeatureAction( c: Seq[Uml#ClearStructuralFeatureAction] ): Seq[UMLClearStructuralFeatureAction[Uml]] = for { e <- c } yield umlClearStructuralFeatureAction( e )
  implicit def umlClearStructuralFeatureAction( c: Set[Uml#ClearStructuralFeatureAction] ): Set[UMLClearStructuralFeatureAction[Uml]] = for { e <- c } yield umlClearStructuralFeatureAction( e )

  implicit def umlClearVariableAction( e: Uml#ClearVariableAction ): UMLClearVariableAction[Uml]
  implicit def umlClearVariableAction( c: Iterable[Uml#ClearVariableAction] ): Iterable[UMLClearVariableAction[Uml]] = for { e <- c } yield umlClearVariableAction( e )
  implicit def umlClearVariableAction( c: Seq[Uml#ClearVariableAction] ): Seq[UMLClearVariableAction[Uml]] = for { e <- c } yield umlClearVariableAction( e )
  implicit def umlClearVariableAction( c: Set[Uml#ClearVariableAction] ): Set[UMLClearVariableAction[Uml]] = for { e <- c } yield umlClearVariableAction( e )

  implicit def umlCollaboration( e: Uml#Collaboration ): UMLCollaboration[Uml]
  implicit def umlCollaboration( c: Iterable[Uml#Collaboration] ): Iterable[UMLCollaboration[Uml]] = for { e <- c } yield umlCollaboration( e )
  implicit def umlCollaboration( c: Seq[Uml#Collaboration] ): Seq[UMLCollaboration[Uml]] = for { e <- c } yield umlCollaboration( e )
  implicit def umlCollaboration( c: Set[Uml#Collaboration] ): Set[UMLCollaboration[Uml]] = for { e <- c } yield umlCollaboration( e )

  implicit def umlCollaborationUse( e: Uml#CollaborationUse ): UMLCollaborationUse[Uml]
  implicit def umlCollaborationUse( c: Iterable[Uml#CollaborationUse] ): Iterable[UMLCollaborationUse[Uml]] = for { e <- c } yield umlCollaborationUse( e )
  implicit def umlCollaborationUse( c: Seq[Uml#CollaborationUse] ): Seq[UMLCollaborationUse[Uml]] = for { e <- c } yield umlCollaborationUse( e )
  implicit def umlCollaborationUse( c: Set[Uml#CollaborationUse] ): Set[UMLCollaborationUse[Uml]] = for { e <- c } yield umlCollaborationUse( e )

  implicit def umlCombinedFragment( e: Uml#CombinedFragment ): UMLCombinedFragment[Uml]
  implicit def umlCombinedFragment( c: Iterable[Uml#CombinedFragment] ): Iterable[UMLCombinedFragment[Uml]] = for { e <- c } yield umlCombinedFragment( e )
  implicit def umlCombinedFragment( c: Seq[Uml#CombinedFragment] ): Seq[UMLCombinedFragment[Uml]] = for { e <- c } yield umlCombinedFragment( e )
  implicit def umlCombinedFragment( c: Set[Uml#CombinedFragment] ): Set[UMLCombinedFragment[Uml]] = for { e <- c } yield umlCombinedFragment( e )

  implicit def umlComment( e: Uml#Comment ): UMLComment[Uml]
  implicit def umlComment( c: Iterable[Uml#Comment] ): Iterable[UMLComment[Uml]] = for { e <- c } yield umlComment( e )
  implicit def umlComment( c: Seq[Uml#Comment] ): Seq[UMLComment[Uml]] = for { e <- c } yield umlComment( e )
  implicit def umlComment( c: Set[Uml#Comment] ): Set[UMLComment[Uml]] = for { e <- c } yield umlComment( e )

  implicit def umlCommunicationPath( e: Uml#CommunicationPath ): UMLCommunicationPath[Uml]
  implicit def umlCommunicationPath( c: Iterable[Uml#CommunicationPath] ): Iterable[UMLCommunicationPath[Uml]] = for { e <- c } yield umlCommunicationPath( e )
  implicit def umlCommunicationPath( c: Seq[Uml#CommunicationPath] ): Seq[UMLCommunicationPath[Uml]] = for { e <- c } yield umlCommunicationPath( e )
  implicit def umlCommunicationPath( c: Set[Uml#CommunicationPath] ): Set[UMLCommunicationPath[Uml]] = for { e <- c } yield umlCommunicationPath( e )

  implicit def umlComponent( e: Uml#Component ): UMLComponent[Uml]
  implicit def umlComponent( c: Iterable[Uml#Component] ): Iterable[UMLComponent[Uml]] = for { e <- c } yield umlComponent( e )
  implicit def umlComponent( c: Seq[Uml#Component] ): Seq[UMLComponent[Uml]] = for { e <- c } yield umlComponent( e )
  implicit def umlComponent( c: Set[Uml#Component] ): Set[UMLComponent[Uml]] = for { e <- c } yield umlComponent( e )

  implicit def umlComponentRealization( e: Uml#ComponentRealization ): UMLComponentRealization[Uml]
  implicit def umlComponentRealization( c: Iterable[Uml#ComponentRealization] ): Iterable[UMLComponentRealization[Uml]] = for { e <- c } yield umlComponentRealization( e )
  implicit def umlComponentRealization( c: Seq[Uml#ComponentRealization] ): Seq[UMLComponentRealization[Uml]] = for { e <- c } yield umlComponentRealization( e )
  implicit def umlComponentRealization( c: Set[Uml#ComponentRealization] ): Set[UMLComponentRealization[Uml]] = for { e <- c } yield umlComponentRealization( e )

  implicit def umlConditionalNode( e: Uml#ConditionalNode ): UMLConditionalNode[Uml]
  implicit def umlConditionalNode( c: Iterable[Uml#ConditionalNode] ): Iterable[UMLConditionalNode[Uml]] = for { e <- c } yield umlConditionalNode( e )
  implicit def umlConditionalNode( c: Seq[Uml#ConditionalNode] ): Seq[UMLConditionalNode[Uml]] = for { e <- c } yield umlConditionalNode( e )
  implicit def umlConditionalNode( c: Set[Uml#ConditionalNode] ): Set[UMLConditionalNode[Uml]] = for { e <- c } yield umlConditionalNode( e )

  implicit def umlConnectableElement( e: Uml#ConnectableElement ): UMLConnectableElement[Uml]
  implicit def umlConnectableElement( c: Iterable[Uml#ConnectableElement] ): Iterable[UMLConnectableElement[Uml]] = for { e <- c } yield umlConnectableElement( e )
  implicit def umlConnectableElement( c: Seq[Uml#ConnectableElement] ): Seq[UMLConnectableElement[Uml]] = for { e <- c } yield umlConnectableElement( e )
  implicit def umlConnectableElement( c: Set[Uml#ConnectableElement] ): Set[UMLConnectableElement[Uml]] = for { e <- c } yield umlConnectableElement( e )

  implicit def umlConnectableElementTemplateParameter( e: Uml#ConnectableElementTemplateParameter ): UMLConnectableElementTemplateParameter[Uml]
  implicit def umlConnectableElementTemplateParameter( c: Iterable[Uml#ConnectableElementTemplateParameter] ): Iterable[UMLConnectableElementTemplateParameter[Uml]] = for { e <- c } yield umlConnectableElementTemplateParameter( e )
  implicit def umlConnectableElementTemplateParameter( c: Seq[Uml#ConnectableElementTemplateParameter] ): Seq[UMLConnectableElementTemplateParameter[Uml]] = for { e <- c } yield umlConnectableElementTemplateParameter( e )
  implicit def umlConnectableElementTemplateParameter( c: Set[Uml#ConnectableElementTemplateParameter] ): Set[UMLConnectableElementTemplateParameter[Uml]] = for { e <- c } yield umlConnectableElementTemplateParameter( e )

  implicit def umlConnectionPointReference( e: Uml#ConnectionPointReference ): UMLConnectionPointReference[Uml]
  implicit def umlConnectionPointReference( c: Iterable[Uml#ConnectionPointReference] ): Iterable[UMLConnectionPointReference[Uml]] = for { e <- c } yield umlConnectionPointReference( e )
  implicit def umlConnectionPointReference( c: Seq[Uml#ConnectionPointReference] ): Seq[UMLConnectionPointReference[Uml]] = for { e <- c } yield umlConnectionPointReference( e )
  implicit def umlConnectionPointReference( c: Set[Uml#ConnectionPointReference] ): Set[UMLConnectionPointReference[Uml]] = for { e <- c } yield umlConnectionPointReference( e )

  implicit def umlConnector( e: Uml#Connector ): UMLConnector[Uml]
  implicit def umlConnector( c: Iterable[Uml#Connector] ): Iterable[UMLConnector[Uml]] = for { e <- c } yield umlConnector( e )
  implicit def umlConnector( c: Seq[Uml#Connector] ): Seq[UMLConnector[Uml]] = for { e <- c } yield umlConnector( e )
  implicit def umlConnector( c: Set[Uml#Connector] ): Set[UMLConnector[Uml]] = for { e <- c } yield umlConnector( e )

  implicit def umlConnectorEnd( e: Uml#ConnectorEnd ): UMLConnectorEnd[Uml]
  implicit def umlConnectorEnd( c: Iterable[Uml#ConnectorEnd] ): Iterable[UMLConnectorEnd[Uml]] = for { e <- c } yield umlConnectorEnd( e )
  implicit def umlConnectorEnd( c: Seq[Uml#ConnectorEnd] ): Seq[UMLConnectorEnd[Uml]] = for { e <- c } yield umlConnectorEnd( e )
  implicit def umlConnectorEnd( c: Set[Uml#ConnectorEnd] ): Set[UMLConnectorEnd[Uml]] = for { e <- c } yield umlConnectorEnd( e )

  implicit def umlConsiderIgnoreFragment( e: Uml#ConsiderIgnoreFragment ): UMLConsiderIgnoreFragment[Uml]
  implicit def umlConsiderIgnoreFragment( c: Iterable[Uml#ConsiderIgnoreFragment] ): Iterable[UMLConsiderIgnoreFragment[Uml]] = for { e <- c } yield umlConsiderIgnoreFragment( e )
  implicit def umlConsiderIgnoreFragment( c: Seq[Uml#ConsiderIgnoreFragment] ): Seq[UMLConsiderIgnoreFragment[Uml]] = for { e <- c } yield umlConsiderIgnoreFragment( e )
  implicit def umlConsiderIgnoreFragment( c: Set[Uml#ConsiderIgnoreFragment] ): Set[UMLConsiderIgnoreFragment[Uml]] = for { e <- c } yield umlConsiderIgnoreFragment( e )

  implicit def umlConstraint( e: Uml#Constraint ): UMLConstraint[Uml]
  implicit def umlConstraint( c: Iterable[Uml#Constraint] ): Iterable[UMLConstraint[Uml]] = for { e <- c } yield umlConstraint( e )
  implicit def umlConstraint( c: Seq[Uml#Constraint] ): Seq[UMLConstraint[Uml]] = for { e <- c } yield umlConstraint( e )
  implicit def umlConstraint( c: Set[Uml#Constraint] ): Set[UMLConstraint[Uml]] = for { e <- c } yield umlConstraint( e )

  implicit def umlContinuation( e: Uml#Continuation ): UMLContinuation[Uml]
  implicit def umlContinuation( c: Iterable[Uml#Continuation] ): Iterable[UMLContinuation[Uml]] = for { e <- c } yield umlContinuation( e )
  implicit def umlContinuation( c: Seq[Uml#Continuation] ): Seq[UMLContinuation[Uml]] = for { e <- c } yield umlContinuation( e )
  implicit def umlContinuation( c: Set[Uml#Continuation] ): Set[UMLContinuation[Uml]] = for { e <- c } yield umlContinuation( e )

  implicit def umlControlFlow( e: Uml#ControlFlow ): UMLControlFlow[Uml]
  implicit def umlControlFlow( c: Iterable[Uml#ControlFlow] ): Iterable[UMLControlFlow[Uml]] = for { e <- c } yield umlControlFlow( e )
  implicit def umlControlFlow( c: Seq[Uml#ControlFlow] ): Seq[UMLControlFlow[Uml]] = for { e <- c } yield umlControlFlow( e )
  implicit def umlControlFlow( c: Set[Uml#ControlFlow] ): Set[UMLControlFlow[Uml]] = for { e <- c } yield umlControlFlow( e )

  implicit def umlControlNode( e: Uml#ControlNode ): UMLControlNode[Uml]
  implicit def umlControlNode( c: Iterable[Uml#ControlNode] ): Iterable[UMLControlNode[Uml]] = for { e <- c } yield umlControlNode( e )
  implicit def umlControlNode( c: Seq[Uml#ControlNode] ): Seq[UMLControlNode[Uml]] = for { e <- c } yield umlControlNode( e )
  implicit def umlControlNode( c: Set[Uml#ControlNode] ): Set[UMLControlNode[Uml]] = for { e <- c } yield umlControlNode( e )

  implicit def umlCreateLinkAction( e: Uml#CreateLinkAction ): UMLCreateLinkAction[Uml]
  implicit def umlCreateLinkAction( c: Iterable[Uml#CreateLinkAction] ): Iterable[UMLCreateLinkAction[Uml]] = for { e <- c } yield umlCreateLinkAction( e )
  implicit def umlCreateLinkAction( c: Seq[Uml#CreateLinkAction] ): Seq[UMLCreateLinkAction[Uml]] = for { e <- c } yield umlCreateLinkAction( e )
  implicit def umlCreateLinkAction( c: Set[Uml#CreateLinkAction] ): Set[UMLCreateLinkAction[Uml]] = for { e <- c } yield umlCreateLinkAction( e )

  implicit def umlCreateLinkObjectAction( e: Uml#CreateLinkObjectAction ): UMLCreateLinkObjectAction[Uml]
  implicit def umlCreateLinkObjectAction( c: Iterable[Uml#CreateLinkObjectAction] ): Iterable[UMLCreateLinkObjectAction[Uml]] = for { e <- c } yield umlCreateLinkObjectAction( e )
  implicit def umlCreateLinkObjectAction( c: Seq[Uml#CreateLinkObjectAction] ): Seq[UMLCreateLinkObjectAction[Uml]] = for { e <- c } yield umlCreateLinkObjectAction( e )
  implicit def umlCreateLinkObjectAction( c: Set[Uml#CreateLinkObjectAction] ): Set[UMLCreateLinkObjectAction[Uml]] = for { e <- c } yield umlCreateLinkObjectAction( e )

  implicit def umlCreateObjectAction( e: Uml#CreateObjectAction ): UMLCreateObjectAction[Uml]
  implicit def umlCreateObjectAction( c: Iterable[Uml#CreateObjectAction] ): Iterable[UMLCreateObjectAction[Uml]] = for { e <- c } yield umlCreateObjectAction( e )
  implicit def umlCreateObjectAction( c: Seq[Uml#CreateObjectAction] ): Seq[UMLCreateObjectAction[Uml]] = for { e <- c } yield umlCreateObjectAction( e )
  implicit def umlCreateObjectAction( c: Set[Uml#CreateObjectAction] ): Set[UMLCreateObjectAction[Uml]] = for { e <- c } yield umlCreateObjectAction( e )

  implicit def umlDataStoreNode( e: Uml#DataStoreNode ): UMLDataStoreNode[Uml]
  implicit def umlDataStoreNode( c: Iterable[Uml#DataStoreNode] ): Iterable[UMLDataStoreNode[Uml]] = for { e <- c } yield umlDataStoreNode( e )
  implicit def umlDataStoreNode( c: Seq[Uml#DataStoreNode] ): Seq[UMLDataStoreNode[Uml]] = for { e <- c } yield umlDataStoreNode( e )
  implicit def umlDataStoreNode( c: Set[Uml#DataStoreNode] ): Set[UMLDataStoreNode[Uml]] = for { e <- c } yield umlDataStoreNode( e )

  implicit def umlDataType( e: Uml#DataType ): UMLDataType[Uml]
  implicit def umlDataType( c: Iterable[Uml#DataType] ): Iterable[UMLDataType[Uml]] = for { e <- c } yield umlDataType( e )
  implicit def umlDataType( c: Seq[Uml#DataType] ): Seq[UMLDataType[Uml]] = for { e <- c } yield umlDataType( e )
  implicit def umlDataType( c: Set[Uml#DataType] ): Set[UMLDataType[Uml]] = for { e <- c } yield umlDataType( e )

  implicit def umlDecisionNode( e: Uml#DecisionNode ): UMLDecisionNode[Uml]
  implicit def umlDecisionNode( c: Iterable[Uml#DecisionNode] ): Iterable[UMLDecisionNode[Uml]] = for { e <- c } yield umlDecisionNode( e )
  implicit def umlDecisionNode( c: Seq[Uml#DecisionNode] ): Seq[UMLDecisionNode[Uml]] = for { e <- c } yield umlDecisionNode( e )
  implicit def umlDecisionNode( c: Set[Uml#DecisionNode] ): Set[UMLDecisionNode[Uml]] = for { e <- c } yield umlDecisionNode( e )

  implicit def umlDependency( e: Uml#Dependency ): UMLDependency[Uml]
  implicit def umlDependency( c: Iterable[Uml#Dependency] ): Iterable[UMLDependency[Uml]] = for { e <- c } yield umlDependency( e )
  implicit def umlDependency( c: Seq[Uml#Dependency] ): Seq[UMLDependency[Uml]] = for { e <- c } yield umlDependency( e )
  implicit def umlDependency( c: Set[Uml#Dependency] ): Set[UMLDependency[Uml]] = for { e <- c } yield umlDependency( e )

  implicit def umlDeployedArtifact( e: Uml#DeployedArtifact ): UMLDeployedArtifact[Uml]
  implicit def umlDeployedArtifact( c: Iterable[Uml#DeployedArtifact] ): Iterable[UMLDeployedArtifact[Uml]] = for { e <- c } yield umlDeployedArtifact( e )
  implicit def umlDeployedArtifact( c: Seq[Uml#DeployedArtifact] ): Seq[UMLDeployedArtifact[Uml]] = for { e <- c } yield umlDeployedArtifact( e )
  implicit def umlDeployedArtifact( c: Set[Uml#DeployedArtifact] ): Set[UMLDeployedArtifact[Uml]] = for { e <- c } yield umlDeployedArtifact( e )

  implicit def umlDeployment( e: Uml#Deployment ): UMLDeployment[Uml]
  implicit def umlDeployment( c: Iterable[Uml#Deployment] ): Iterable[UMLDeployment[Uml]] = for { e <- c } yield umlDeployment( e )
  implicit def umlDeployment( c: Seq[Uml#Deployment] ): Seq[UMLDeployment[Uml]] = for { e <- c } yield umlDeployment( e )
  implicit def umlDeployment( c: Set[Uml#Deployment] ): Set[UMLDeployment[Uml]] = for { e <- c } yield umlDeployment( e )

  implicit def umlDeploymentSpecification( e: Uml#DeploymentSpecification ): UMLDeploymentSpecification[Uml]
  implicit def umlDeploymentSpecification( c: Iterable[Uml#DeploymentSpecification] ): Iterable[UMLDeploymentSpecification[Uml]] = for { e <- c } yield umlDeploymentSpecification( e )
  implicit def umlDeploymentSpecification( c: Seq[Uml#DeploymentSpecification] ): Seq[UMLDeploymentSpecification[Uml]] = for { e <- c } yield umlDeploymentSpecification( e )
  implicit def umlDeploymentSpecification( c: Set[Uml#DeploymentSpecification] ): Set[UMLDeploymentSpecification[Uml]] = for { e <- c } yield umlDeploymentSpecification( e )

  implicit def umlDeploymentTarget( e: Uml#DeploymentTarget ): UMLDeploymentTarget[Uml]
  implicit def umlDeploymentTarget( c: Iterable[Uml#DeploymentTarget] ): Iterable[UMLDeploymentTarget[Uml]] = for { e <- c } yield umlDeploymentTarget( e )
  implicit def umlDeploymentTarget( c: Seq[Uml#DeploymentTarget] ): Seq[UMLDeploymentTarget[Uml]] = for { e <- c } yield umlDeploymentTarget( e )
  implicit def umlDeploymentTarget( c: Set[Uml#DeploymentTarget] ): Set[UMLDeploymentTarget[Uml]] = for { e <- c } yield umlDeploymentTarget( e )

  implicit def umlDestroyLinkAction( e: Uml#DestroyLinkAction ): UMLDestroyLinkAction[Uml]
  implicit def umlDestroyLinkAction( c: Iterable[Uml#DestroyLinkAction] ): Iterable[UMLDestroyLinkAction[Uml]] = for { e <- c } yield umlDestroyLinkAction( e )
  implicit def umlDestroyLinkAction( c: Seq[Uml#DestroyLinkAction] ): Seq[UMLDestroyLinkAction[Uml]] = for { e <- c } yield umlDestroyLinkAction( e )
  implicit def umlDestroyLinkAction( c: Set[Uml#DestroyLinkAction] ): Set[UMLDestroyLinkAction[Uml]] = for { e <- c } yield umlDestroyLinkAction( e )

  implicit def umlDestroyObjectAction( e: Uml#DestroyObjectAction ): UMLDestroyObjectAction[Uml]
  implicit def umlDestroyObjectAction( c: Iterable[Uml#DestroyObjectAction] ): Iterable[UMLDestroyObjectAction[Uml]] = for { e <- c } yield umlDestroyObjectAction( e )
  implicit def umlDestroyObjectAction( c: Seq[Uml#DestroyObjectAction] ): Seq[UMLDestroyObjectAction[Uml]] = for { e <- c } yield umlDestroyObjectAction( e )
  implicit def umlDestroyObjectAction( c: Set[Uml#DestroyObjectAction] ): Set[UMLDestroyObjectAction[Uml]] = for { e <- c } yield umlDestroyObjectAction( e )

  implicit def umlDestructionOccurrenceSpecification( e: Uml#DestructionOccurrenceSpecification ): UMLDestructionOccurrenceSpecification[Uml]
  implicit def umlDestructionOccurrenceSpecification( c: Iterable[Uml#DestructionOccurrenceSpecification] ): Iterable[UMLDestructionOccurrenceSpecification[Uml]] = for { e <- c } yield umlDestructionOccurrenceSpecification( e )
  implicit def umlDestructionOccurrenceSpecification( c: Seq[Uml#DestructionOccurrenceSpecification] ): Seq[UMLDestructionOccurrenceSpecification[Uml]] = for { e <- c } yield umlDestructionOccurrenceSpecification( e )
  implicit def umlDestructionOccurrenceSpecification( c: Set[Uml#DestructionOccurrenceSpecification] ): Set[UMLDestructionOccurrenceSpecification[Uml]] = for { e <- c } yield umlDestructionOccurrenceSpecification( e )

  implicit def umlDevice( e: Uml#Device ): UMLDevice[Uml]
  implicit def umlDevice( c: Iterable[Uml#Device] ): Iterable[UMLDevice[Uml]] = for { e <- c } yield umlDevice( e )
  implicit def umlDevice( c: Seq[Uml#Device] ): Seq[UMLDevice[Uml]] = for { e <- c } yield umlDevice( e )
  implicit def umlDevice( c: Set[Uml#Device] ): Set[UMLDevice[Uml]] = for { e <- c } yield umlDevice( e )

  implicit def umlDirectedRelationship( e: Uml#DirectedRelationship ): UMLDirectedRelationship[Uml]
  implicit def umlDirectedRelationship( c: Iterable[Uml#DirectedRelationship] ): Iterable[UMLDirectedRelationship[Uml]] = for { e <- c } yield umlDirectedRelationship( e )
  implicit def umlDirectedRelationship( c: Seq[Uml#DirectedRelationship] ): Seq[UMLDirectedRelationship[Uml]] = for { e <- c } yield umlDirectedRelationship( e )
  implicit def umlDirectedRelationship( c: Set[Uml#DirectedRelationship] ): Set[UMLDirectedRelationship[Uml]] = for { e <- c } yield umlDirectedRelationship( e )

  implicit def umlDuration( e: Uml#Duration ): UMLDuration[Uml]
  implicit def umlDuration( c: Iterable[Uml#Duration] ): Iterable[UMLDuration[Uml]] = for { e <- c } yield umlDuration( e )
  implicit def umlDuration( c: Seq[Uml#Duration] ): Seq[UMLDuration[Uml]] = for { e <- c } yield umlDuration( e )
  implicit def umlDuration( c: Set[Uml#Duration] ): Set[UMLDuration[Uml]] = for { e <- c } yield umlDuration( e )

  implicit def umlDurationConstraint( e: Uml#DurationConstraint ): UMLDurationConstraint[Uml]
  implicit def umlDurationConstraint( c: Iterable[Uml#DurationConstraint] ): Iterable[UMLDurationConstraint[Uml]] = for { e <- c } yield umlDurationConstraint( e )
  implicit def umlDurationConstraint( c: Seq[Uml#DurationConstraint] ): Seq[UMLDurationConstraint[Uml]] = for { e <- c } yield umlDurationConstraint( e )
  implicit def umlDurationConstraint( c: Set[Uml#DurationConstraint] ): Set[UMLDurationConstraint[Uml]] = for { e <- c } yield umlDurationConstraint( e )

  implicit def umlDurationInterval( e: Uml#DurationInterval ): UMLDurationInterval[Uml]
  implicit def umlDurationInterval( c: Iterable[Uml#DurationInterval] ): Iterable[UMLDurationInterval[Uml]] = for { e <- c } yield umlDurationInterval( e )
  implicit def umlDurationInterval( c: Seq[Uml#DurationInterval] ): Seq[UMLDurationInterval[Uml]] = for { e <- c } yield umlDurationInterval( e )
  implicit def umlDurationInterval( c: Set[Uml#DurationInterval] ): Set[UMLDurationInterval[Uml]] = for { e <- c } yield umlDurationInterval( e )

  implicit def umlDurationObservation( e: Uml#DurationObservation ): UMLDurationObservation[Uml]
  implicit def umlDurationObservation( c: Iterable[Uml#DurationObservation] ): Iterable[UMLDurationObservation[Uml]] = for { e <- c } yield umlDurationObservation( e )
  implicit def umlDurationObservation( c: Seq[Uml#DurationObservation] ): Seq[UMLDurationObservation[Uml]] = for { e <- c } yield umlDurationObservation( e )
  implicit def umlDurationObservation( c: Set[Uml#DurationObservation] ): Set[UMLDurationObservation[Uml]] = for { e <- c } yield umlDurationObservation( e )

  implicit def umlElement( e: Uml#Element ): UMLElement[Uml]
  implicit def umlElement( c: Iterable[Uml#Element] ): Iterable[UMLElement[Uml]] = for { e <- c } yield umlElement( e )
  implicit def umlElement( c: Seq[Uml#Element] ): Seq[UMLElement[Uml]] = for { e <- c } yield umlElement( e )
  implicit def umlElement( c: Set[Uml#Element] ): Set[UMLElement[Uml]] = for { e <- c } yield umlElement( e )

  implicit def umlElementImport( e: Uml#ElementImport ): UMLElementImport[Uml]
  implicit def umlElementImport( c: Iterable[Uml#ElementImport] ): Iterable[UMLElementImport[Uml]] = for { e <- c } yield umlElementImport( e )
  implicit def umlElementImport( c: Seq[Uml#ElementImport] ): Seq[UMLElementImport[Uml]] = for { e <- c } yield umlElementImport( e )
  implicit def umlElementImport( c: Set[Uml#ElementImport] ): Set[UMLElementImport[Uml]] = for { e <- c } yield umlElementImport( e )

  implicit def umlEncapsulatedClassifier( e: Uml#EncapsulatedClassifier ): UMLEncapsulatedClassifier[Uml]
  implicit def umlEncapsulatedClassifier( c: Iterable[Uml#EncapsulatedClassifier] ): Iterable[UMLEncapsulatedClassifier[Uml]] = for { e <- c } yield umlEncapsulatedClassifier( e )
  implicit def umlEncapsulatedClassifier( c: Seq[Uml#EncapsulatedClassifier] ): Seq[UMLEncapsulatedClassifier[Uml]] = for { e <- c } yield umlEncapsulatedClassifier( e )
  implicit def umlEncapsulatedClassifier( c: Set[Uml#EncapsulatedClassifier] ): Set[UMLEncapsulatedClassifier[Uml]] = for { e <- c } yield umlEncapsulatedClassifier( e )

  implicit def umlEnumeration( e: Uml#Enumeration ): UMLEnumeration[Uml]
  implicit def umlEnumeration( c: Iterable[Uml#Enumeration] ): Iterable[UMLEnumeration[Uml]] = for { e <- c } yield umlEnumeration( e )
  implicit def umlEnumeration( c: Seq[Uml#Enumeration] ): Seq[UMLEnumeration[Uml]] = for { e <- c } yield umlEnumeration( e )
  implicit def umlEnumeration( c: Set[Uml#Enumeration] ): Set[UMLEnumeration[Uml]] = for { e <- c } yield umlEnumeration( e )

  implicit def umlEnumerationLiteral( e: Uml#EnumerationLiteral ): UMLEnumerationLiteral[Uml]
  implicit def umlEnumerationLiteral( c: Iterable[Uml#EnumerationLiteral] ): Iterable[UMLEnumerationLiteral[Uml]] = for { e <- c } yield umlEnumerationLiteral( e )
  implicit def umlEnumerationLiteral( c: Seq[Uml#EnumerationLiteral] ): Seq[UMLEnumerationLiteral[Uml]] = for { e <- c } yield umlEnumerationLiteral( e )
  implicit def umlEnumerationLiteral( c: Set[Uml#EnumerationLiteral] ): Set[UMLEnumerationLiteral[Uml]] = for { e <- c } yield umlEnumerationLiteral( e )

  implicit def umlEvent( e: Uml#Event ): UMLEvent[Uml]
  implicit def umlEvent( c: Iterable[Uml#Event] ): Iterable[UMLEvent[Uml]] = for { e <- c } yield umlEvent( e )
  implicit def umlEvent( c: Seq[Uml#Event] ): Seq[UMLEvent[Uml]] = for { e <- c } yield umlEvent( e )
  implicit def umlEvent( c: Set[Uml#Event] ): Set[UMLEvent[Uml]] = for { e <- c } yield umlEvent( e )

  implicit def umlExceptionHandler( e: Uml#ExceptionHandler ): UMLExceptionHandler[Uml]
  implicit def umlExceptionHandler( c: Iterable[Uml#ExceptionHandler] ): Iterable[UMLExceptionHandler[Uml]] = for { e <- c } yield umlExceptionHandler( e )
  implicit def umlExceptionHandler( c: Seq[Uml#ExceptionHandler] ): Seq[UMLExceptionHandler[Uml]] = for { e <- c } yield umlExceptionHandler( e )
  implicit def umlExceptionHandler( c: Set[Uml#ExceptionHandler] ): Set[UMLExceptionHandler[Uml]] = for { e <- c } yield umlExceptionHandler( e )

  implicit def umlExecutableNode( e: Uml#ExecutableNode ): UMLExecutableNode[Uml]
  implicit def umlExecutableNode( c: Iterable[Uml#ExecutableNode] ): Iterable[UMLExecutableNode[Uml]] = for { e <- c } yield umlExecutableNode( e )
  implicit def umlExecutableNode( c: Seq[Uml#ExecutableNode] ): Seq[UMLExecutableNode[Uml]] = for { e <- c } yield umlExecutableNode( e )
  implicit def umlExecutableNode( c: Set[Uml#ExecutableNode] ): Set[UMLExecutableNode[Uml]] = for { e <- c } yield umlExecutableNode( e )

  implicit def umlExecutionEnvironment( e: Uml#ExecutionEnvironment ): UMLExecutionEnvironment[Uml]
  implicit def umlExecutionEnvironment( c: Iterable[Uml#ExecutionEnvironment] ): Iterable[UMLExecutionEnvironment[Uml]] = for { e <- c } yield umlExecutionEnvironment( e )
  implicit def umlExecutionEnvironment( c: Seq[Uml#ExecutionEnvironment] ): Seq[UMLExecutionEnvironment[Uml]] = for { e <- c } yield umlExecutionEnvironment( e )
  implicit def umlExecutionEnvironment( c: Set[Uml#ExecutionEnvironment] ): Set[UMLExecutionEnvironment[Uml]] = for { e <- c } yield umlExecutionEnvironment( e )

  implicit def umlExecutionOccurrenceSpecification( e: Uml#ExecutionOccurrenceSpecification ): UMLExecutionOccurrenceSpecification[Uml]
  implicit def umlExecutionOccurrenceSpecification( c: Iterable[Uml#ExecutionOccurrenceSpecification] ): Iterable[UMLExecutionOccurrenceSpecification[Uml]] = for { e <- c } yield umlExecutionOccurrenceSpecification( e )
  implicit def umlExecutionOccurrenceSpecification( c: Seq[Uml#ExecutionOccurrenceSpecification] ): Seq[UMLExecutionOccurrenceSpecification[Uml]] = for { e <- c } yield umlExecutionOccurrenceSpecification( e )
  implicit def umlExecutionOccurrenceSpecification( c: Set[Uml#ExecutionOccurrenceSpecification] ): Set[UMLExecutionOccurrenceSpecification[Uml]] = for { e <- c } yield umlExecutionOccurrenceSpecification( e )

  implicit def umlExecutionSpecification( e: Uml#ExecutionSpecification ): UMLExecutionSpecification[Uml]
  implicit def umlExecutionSpecification( c: Iterable[Uml#ExecutionSpecification] ): Iterable[UMLExecutionSpecification[Uml]] = for { e <- c } yield umlExecutionSpecification( e )
  implicit def umlExecutionSpecification( c: Seq[Uml#ExecutionSpecification] ): Seq[UMLExecutionSpecification[Uml]] = for { e <- c } yield umlExecutionSpecification( e )
  implicit def umlExecutionSpecification( c: Set[Uml#ExecutionSpecification] ): Set[UMLExecutionSpecification[Uml]] = for { e <- c } yield umlExecutionSpecification( e )

  implicit def umlExpansionNode( e: Uml#ExpansionNode ): UMLExpansionNode[Uml]
  implicit def umlExpansionNode( c: Iterable[Uml#ExpansionNode] ): Iterable[UMLExpansionNode[Uml]] = for { e <- c } yield umlExpansionNode( e )
  implicit def umlExpansionNode( c: Seq[Uml#ExpansionNode] ): Seq[UMLExpansionNode[Uml]] = for { e <- c } yield umlExpansionNode( e )
  implicit def umlExpansionNode( c: Set[Uml#ExpansionNode] ): Set[UMLExpansionNode[Uml]] = for { e <- c } yield umlExpansionNode( e )

  implicit def umlExpansionRegion( e: Uml#ExpansionRegion ): UMLExpansionRegion[Uml]
  implicit def umlExpansionRegion( c: Iterable[Uml#ExpansionRegion] ): Iterable[UMLExpansionRegion[Uml]] = for { e <- c } yield umlExpansionRegion( e )
  implicit def umlExpansionRegion( c: Seq[Uml#ExpansionRegion] ): Seq[UMLExpansionRegion[Uml]] = for { e <- c } yield umlExpansionRegion( e )
  implicit def umlExpansionRegion( c: Set[Uml#ExpansionRegion] ): Set[UMLExpansionRegion[Uml]] = for { e <- c } yield umlExpansionRegion( e )

  implicit def umlExpression( e: Uml#Expression ): UMLExpression[Uml]
  implicit def umlExpression( c: Iterable[Uml#Expression] ): Iterable[UMLExpression[Uml]] = for { e <- c } yield umlExpression( e )
  implicit def umlExpression( c: Seq[Uml#Expression] ): Seq[UMLExpression[Uml]] = for { e <- c } yield umlExpression( e )
  implicit def umlExpression( c: Set[Uml#Expression] ): Set[UMLExpression[Uml]] = for { e <- c } yield umlExpression( e )

  implicit def umlExtend( e: Uml#Extend ): UMLExtend[Uml]
  implicit def umlExtend( c: Iterable[Uml#Extend] ): Iterable[UMLExtend[Uml]] = for { e <- c } yield umlExtend( e )
  implicit def umlExtend( c: Seq[Uml#Extend] ): Seq[UMLExtend[Uml]] = for { e <- c } yield umlExtend( e )
  implicit def umlExtend( c: Set[Uml#Extend] ): Set[UMLExtend[Uml]] = for { e <- c } yield umlExtend( e )

  implicit def umlExtension( e: Uml#Extension ): UMLExtension[Uml]
  implicit def umlExtension( c: Iterable[Uml#Extension] ): Iterable[UMLExtension[Uml]] = for { e <- c } yield umlExtension( e )
  implicit def umlExtension( c: Seq[Uml#Extension] ): Seq[UMLExtension[Uml]] = for { e <- c } yield umlExtension( e )
  implicit def umlExtension( c: Set[Uml#Extension] ): Set[UMLExtension[Uml]] = for { e <- c } yield umlExtension( e )

  implicit def umlExtensionEnd( e: Uml#ExtensionEnd ): UMLExtensionEnd[Uml]
  implicit def umlExtensionEnd( c: Iterable[Uml#ExtensionEnd] ): Iterable[UMLExtensionEnd[Uml]] = for { e <- c } yield umlExtensionEnd( e )
  implicit def umlExtensionEnd( c: Seq[Uml#ExtensionEnd] ): Seq[UMLExtensionEnd[Uml]] = for { e <- c } yield umlExtensionEnd( e )
  implicit def umlExtensionEnd( c: Set[Uml#ExtensionEnd] ): Set[UMLExtensionEnd[Uml]] = for { e <- c } yield umlExtensionEnd( e )

  implicit def umlExtensionPoint( e: Uml#ExtensionPoint ): UMLExtensionPoint[Uml]
  implicit def umlExtensionPoint( c: Iterable[Uml#ExtensionPoint] ): Iterable[UMLExtensionPoint[Uml]] = for { e <- c } yield umlExtensionPoint( e )
  implicit def umlExtensionPoint( c: Seq[Uml#ExtensionPoint] ): Seq[UMLExtensionPoint[Uml]] = for { e <- c } yield umlExtensionPoint( e )
  implicit def umlExtensionPoint( c: Set[Uml#ExtensionPoint] ): Set[UMLExtensionPoint[Uml]] = for { e <- c } yield umlExtensionPoint( e )

  implicit def umlFeature( e: Uml#Feature ): UMLFeature[Uml]
  implicit def umlFeature( c: Iterable[Uml#Feature] ): Iterable[UMLFeature[Uml]] = for { e <- c } yield umlFeature( e )
  implicit def umlFeature( c: Seq[Uml#Feature] ): Seq[UMLFeature[Uml]] = for { e <- c } yield umlFeature( e )
  implicit def umlFeature( c: Set[Uml#Feature] ): Set[UMLFeature[Uml]] = for { e <- c } yield umlFeature( e )

  implicit def umlFinalNode( e: Uml#FinalNode ): UMLFinalNode[Uml]
  implicit def umlFinalNode( c: Iterable[Uml#FinalNode] ): Iterable[UMLFinalNode[Uml]] = for { e <- c } yield umlFinalNode( e )
  implicit def umlFinalNode( c: Seq[Uml#FinalNode] ): Seq[UMLFinalNode[Uml]] = for { e <- c } yield umlFinalNode( e )
  implicit def umlFinalNode( c: Set[Uml#FinalNode] ): Set[UMLFinalNode[Uml]] = for { e <- c } yield umlFinalNode( e )

  implicit def umlFinalState( e: Uml#FinalState ): UMLFinalState[Uml]
  implicit def umlFinalState( c: Iterable[Uml#FinalState] ): Iterable[UMLFinalState[Uml]] = for { e <- c } yield umlFinalState( e )
  implicit def umlFinalState( c: Seq[Uml#FinalState] ): Seq[UMLFinalState[Uml]] = for { e <- c } yield umlFinalState( e )
  implicit def umlFinalState( c: Set[Uml#FinalState] ): Set[UMLFinalState[Uml]] = for { e <- c } yield umlFinalState( e )

  implicit def umlFlowFinalNode( e: Uml#FlowFinalNode ): UMLFlowFinalNode[Uml]
  implicit def umlFlowFinalNode( c: Iterable[Uml#FlowFinalNode] ): Iterable[UMLFlowFinalNode[Uml]] = for { e <- c } yield umlFlowFinalNode( e )
  implicit def umlFlowFinalNode( c: Seq[Uml#FlowFinalNode] ): Seq[UMLFlowFinalNode[Uml]] = for { e <- c } yield umlFlowFinalNode( e )
  implicit def umlFlowFinalNode( c: Set[Uml#FlowFinalNode] ): Set[UMLFlowFinalNode[Uml]] = for { e <- c } yield umlFlowFinalNode( e )

  implicit def umlForkNode( e: Uml#ForkNode ): UMLForkNode[Uml]
  implicit def umlForkNode( c: Iterable[Uml#ForkNode] ): Iterable[UMLForkNode[Uml]] = for { e <- c } yield umlForkNode( e )
  implicit def umlForkNode( c: Seq[Uml#ForkNode] ): Seq[UMLForkNode[Uml]] = for { e <- c } yield umlForkNode( e )
  implicit def umlForkNode( c: Set[Uml#ForkNode] ): Set[UMLForkNode[Uml]] = for { e <- c } yield umlForkNode( e )

  implicit def umlFunctionBehavior( e: Uml#FunctionBehavior ): UMLFunctionBehavior[Uml]
  implicit def umlFunctionBehavior( c: Iterable[Uml#FunctionBehavior] ): Iterable[UMLFunctionBehavior[Uml]] = for { e <- c } yield umlFunctionBehavior( e )
  implicit def umlFunctionBehavior( c: Seq[Uml#FunctionBehavior] ): Seq[UMLFunctionBehavior[Uml]] = for { e <- c } yield umlFunctionBehavior( e )
  implicit def umlFunctionBehavior( c: Set[Uml#FunctionBehavior] ): Set[UMLFunctionBehavior[Uml]] = for { e <- c } yield umlFunctionBehavior( e )

  implicit def umlGate( e: Uml#Gate ): UMLGate[Uml]
  implicit def umlGate( c: Iterable[Uml#Gate] ): Iterable[UMLGate[Uml]] = for { e <- c } yield umlGate( e )
  implicit def umlGate( c: Seq[Uml#Gate] ): Seq[UMLGate[Uml]] = for { e <- c } yield umlGate( e )
  implicit def umlGate( c: Set[Uml#Gate] ): Set[UMLGate[Uml]] = for { e <- c } yield umlGate( e )

  implicit def umlGeneralOrdering( e: Uml#GeneralOrdering ): UMLGeneralOrdering[Uml]
  implicit def umlGeneralOrdering( c: Iterable[Uml#GeneralOrdering] ): Iterable[UMLGeneralOrdering[Uml]] = for { e <- c } yield umlGeneralOrdering( e )
  implicit def umlGeneralOrdering( c: Seq[Uml#GeneralOrdering] ): Seq[UMLGeneralOrdering[Uml]] = for { e <- c } yield umlGeneralOrdering( e )
  implicit def umlGeneralOrdering( c: Set[Uml#GeneralOrdering] ): Set[UMLGeneralOrdering[Uml]] = for { e <- c } yield umlGeneralOrdering( e )

  implicit def umlGeneralization( e: Uml#Generalization ): UMLGeneralization[Uml]
  implicit def umlGeneralization( c: Iterable[Uml#Generalization] ): Iterable[UMLGeneralization[Uml]] = for { e <- c } yield umlGeneralization( e )
  implicit def umlGeneralization( c: Seq[Uml#Generalization] ): Seq[UMLGeneralization[Uml]] = for { e <- c } yield umlGeneralization( e )
  implicit def umlGeneralization( c: Set[Uml#Generalization] ): Set[UMLGeneralization[Uml]] = for { e <- c } yield umlGeneralization( e )

  implicit def umlGeneralizationSet( e: Uml#GeneralizationSet ): UMLGeneralizationSet[Uml]
  implicit def umlGeneralizationSet( c: Iterable[Uml#GeneralizationSet] ): Iterable[UMLGeneralizationSet[Uml]] = for { e <- c } yield umlGeneralizationSet( e )
  implicit def umlGeneralizationSet( c: Seq[Uml#GeneralizationSet] ): Seq[UMLGeneralizationSet[Uml]] = for { e <- c } yield umlGeneralizationSet( e )
  implicit def umlGeneralizationSet( c: Set[Uml#GeneralizationSet] ): Set[UMLGeneralizationSet[Uml]] = for { e <- c } yield umlGeneralizationSet( e )

  implicit def umlImage( e: Uml#Image ): UMLImage[Uml]
  implicit def umlImage( c: Iterable[Uml#Image] ): Iterable[UMLImage[Uml]] = for { e <- c } yield umlImage( e )
  implicit def umlImage( c: Seq[Uml#Image] ): Seq[UMLImage[Uml]] = for { e <- c } yield umlImage( e )
  implicit def umlImage( c: Set[Uml#Image] ): Set[UMLImage[Uml]] = for { e <- c } yield umlImage( e )

  implicit def umlInclude( e: Uml#Include ): UMLInclude[Uml]
  implicit def umlInclude( c: Iterable[Uml#Include] ): Iterable[UMLInclude[Uml]] = for { e <- c } yield umlInclude( e )
  implicit def umlInclude( c: Seq[Uml#Include] ): Seq[UMLInclude[Uml]] = for { e <- c } yield umlInclude( e )
  implicit def umlInclude( c: Set[Uml#Include] ): Set[UMLInclude[Uml]] = for { e <- c } yield umlInclude( e )

  implicit def umlInformationFlow( e: Uml#InformationFlow ): UMLInformationFlow[Uml]
  implicit def umlInformationFlow( c: Iterable[Uml#InformationFlow] ): Iterable[UMLInformationFlow[Uml]] = for { e <- c } yield umlInformationFlow( e )
  implicit def umlInformationFlow( c: Seq[Uml#InformationFlow] ): Seq[UMLInformationFlow[Uml]] = for { e <- c } yield umlInformationFlow( e )
  implicit def umlInformationFlow( c: Set[Uml#InformationFlow] ): Set[UMLInformationFlow[Uml]] = for { e <- c } yield umlInformationFlow( e )

  implicit def umlInformationItem( e: Uml#InformationItem ): UMLInformationItem[Uml]
  implicit def umlInformationItem( c: Iterable[Uml#InformationItem] ): Iterable[UMLInformationItem[Uml]] = for { e <- c } yield umlInformationItem( e )
  implicit def umlInformationItem( c: Seq[Uml#InformationItem] ): Seq[UMLInformationItem[Uml]] = for { e <- c } yield umlInformationItem( e )
  implicit def umlInformationItem( c: Set[Uml#InformationItem] ): Set[UMLInformationItem[Uml]] = for { e <- c } yield umlInformationItem( e )

  implicit def umlInitialNode( e: Uml#InitialNode ): UMLInitialNode[Uml]
  implicit def umlInitialNode( c: Iterable[Uml#InitialNode] ): Iterable[UMLInitialNode[Uml]] = for { e <- c } yield umlInitialNode( e )
  implicit def umlInitialNode( c: Seq[Uml#InitialNode] ): Seq[UMLInitialNode[Uml]] = for { e <- c } yield umlInitialNode( e )
  implicit def umlInitialNode( c: Set[Uml#InitialNode] ): Set[UMLInitialNode[Uml]] = for { e <- c } yield umlInitialNode( e )

  implicit def umlInputPin( e: Uml#InputPin ): UMLInputPin[Uml]
  implicit def umlInputPin( c: Iterable[Uml#InputPin] ): Iterable[UMLInputPin[Uml]] = for { e <- c } yield umlInputPin( e )
  implicit def umlInputPin( c: Seq[Uml#InputPin] ): Seq[UMLInputPin[Uml]] = for { e <- c } yield umlInputPin( e )
  implicit def umlInputPin( c: Set[Uml#InputPin] ): Set[UMLInputPin[Uml]] = for { e <- c } yield umlInputPin( e )

  implicit def umlInstanceSpecification( e: Uml#InstanceSpecification ): UMLInstanceSpecification[Uml]
  implicit def umlInstanceSpecification( c: Iterable[Uml#InstanceSpecification] ): Iterable[UMLInstanceSpecification[Uml]] = for { e <- c } yield umlInstanceSpecification( e )
  implicit def umlInstanceSpecification( c: Seq[Uml#InstanceSpecification] ): Seq[UMLInstanceSpecification[Uml]] = for { e <- c } yield umlInstanceSpecification( e )
  implicit def umlInstanceSpecification( c: Set[Uml#InstanceSpecification] ): Set[UMLInstanceSpecification[Uml]] = for { e <- c } yield umlInstanceSpecification( e )

  implicit def umlInstanceValue( e: Uml#InstanceValue ): UMLInstanceValue[Uml]
  implicit def umlInstanceValue( c: Iterable[Uml#InstanceValue] ): Iterable[UMLInstanceValue[Uml]] = for { e <- c } yield umlInstanceValue( e )
  implicit def umlInstanceValue( c: Seq[Uml#InstanceValue] ): Seq[UMLInstanceValue[Uml]] = for { e <- c } yield umlInstanceValue( e )
  implicit def umlInstanceValue( c: Set[Uml#InstanceValue] ): Set[UMLInstanceValue[Uml]] = for { e <- c } yield umlInstanceValue( e )

  implicit def umlInteraction( e: Uml#Interaction ): UMLInteraction[Uml]
  implicit def umlInteraction( c: Iterable[Uml#Interaction] ): Iterable[UMLInteraction[Uml]] = for { e <- c } yield umlInteraction( e )
  implicit def umlInteraction( c: Seq[Uml#Interaction] ): Seq[UMLInteraction[Uml]] = for { e <- c } yield umlInteraction( e )
  implicit def umlInteraction( c: Set[Uml#Interaction] ): Set[UMLInteraction[Uml]] = for { e <- c } yield umlInteraction( e )

  implicit def umlInteractionConstraint( e: Uml#InteractionConstraint ): UMLInteractionConstraint[Uml]
  implicit def umlInteractionConstraint( c: Iterable[Uml#InteractionConstraint] ): Iterable[UMLInteractionConstraint[Uml]] = for { e <- c } yield umlInteractionConstraint( e )
  implicit def umlInteractionConstraint( c: Seq[Uml#InteractionConstraint] ): Seq[UMLInteractionConstraint[Uml]] = for { e <- c } yield umlInteractionConstraint( e )
  implicit def umlInteractionConstraint( c: Set[Uml#InteractionConstraint] ): Set[UMLInteractionConstraint[Uml]] = for { e <- c } yield umlInteractionConstraint( e )

  implicit def umlInteractionFragment( e: Uml#InteractionFragment ): UMLInteractionFragment[Uml]
  implicit def umlInteractionFragment( c: Iterable[Uml#InteractionFragment] ): Iterable[UMLInteractionFragment[Uml]] = for { e <- c } yield umlInteractionFragment( e )
  implicit def umlInteractionFragment( c: Seq[Uml#InteractionFragment] ): Seq[UMLInteractionFragment[Uml]] = for { e <- c } yield umlInteractionFragment( e )
  implicit def umlInteractionFragment( c: Set[Uml#InteractionFragment] ): Set[UMLInteractionFragment[Uml]] = for { e <- c } yield umlInteractionFragment( e )

  implicit def umlInteractionOperand( e: Uml#InteractionOperand ): UMLInteractionOperand[Uml]
  implicit def umlInteractionOperand( c: Iterable[Uml#InteractionOperand] ): Iterable[UMLInteractionOperand[Uml]] = for { e <- c } yield umlInteractionOperand( e )
  implicit def umlInteractionOperand( c: Seq[Uml#InteractionOperand] ): Seq[UMLInteractionOperand[Uml]] = for { e <- c } yield umlInteractionOperand( e )
  implicit def umlInteractionOperand( c: Set[Uml#InteractionOperand] ): Set[UMLInteractionOperand[Uml]] = for { e <- c } yield umlInteractionOperand( e )

  implicit def umlInteractionUse( e: Uml#InteractionUse ): UMLInteractionUse[Uml]
  implicit def umlInteractionUse( c: Iterable[Uml#InteractionUse] ): Iterable[UMLInteractionUse[Uml]] = for { e <- c } yield umlInteractionUse( e )
  implicit def umlInteractionUse( c: Seq[Uml#InteractionUse] ): Seq[UMLInteractionUse[Uml]] = for { e <- c } yield umlInteractionUse( e )
  implicit def umlInteractionUse( c: Set[Uml#InteractionUse] ): Set[UMLInteractionUse[Uml]] = for { e <- c } yield umlInteractionUse( e )

  implicit def umlInterface( e: Uml#Interface ): UMLInterface[Uml]
  implicit def umlInterface( c: Iterable[Uml#Interface] ): Iterable[UMLInterface[Uml]] = for { e <- c } yield umlInterface( e )
  implicit def umlInterface( c: Seq[Uml#Interface] ): Seq[UMLInterface[Uml]] = for { e <- c } yield umlInterface( e )
  implicit def umlInterface( c: Set[Uml#Interface] ): Set[UMLInterface[Uml]] = for { e <- c } yield umlInterface( e )

  implicit def umlInterfaceRealization( e: Uml#InterfaceRealization ): UMLInterfaceRealization[Uml]
  implicit def umlInterfaceRealization( c: Iterable[Uml#InterfaceRealization] ): Iterable[UMLInterfaceRealization[Uml]] = for { e <- c } yield umlInterfaceRealization( e )
  implicit def umlInterfaceRealization( c: Seq[Uml#InterfaceRealization] ): Seq[UMLInterfaceRealization[Uml]] = for { e <- c } yield umlInterfaceRealization( e )
  implicit def umlInterfaceRealization( c: Set[Uml#InterfaceRealization] ): Set[UMLInterfaceRealization[Uml]] = for { e <- c } yield umlInterfaceRealization( e )

  implicit def umlInterruptibleActivityRegion( e: Uml#InterruptibleActivityRegion ): UMLInterruptibleActivityRegion[Uml]
  implicit def umlInterruptibleActivityRegion( c: Iterable[Uml#InterruptibleActivityRegion] ): Iterable[UMLInterruptibleActivityRegion[Uml]] = for { e <- c } yield umlInterruptibleActivityRegion( e )
  implicit def umlInterruptibleActivityRegion( c: Seq[Uml#InterruptibleActivityRegion] ): Seq[UMLInterruptibleActivityRegion[Uml]] = for { e <- c } yield umlInterruptibleActivityRegion( e )
  implicit def umlInterruptibleActivityRegion( c: Set[Uml#InterruptibleActivityRegion] ): Set[UMLInterruptibleActivityRegion[Uml]] = for { e <- c } yield umlInterruptibleActivityRegion( e )

  implicit def umlInterval( e: Uml#Interval ): UMLInterval[Uml]
  implicit def umlInterval( c: Iterable[Uml#Interval] ): Iterable[UMLInterval[Uml]] = for { e <- c } yield umlInterval( e )
  implicit def umlInterval( c: Seq[Uml#Interval] ): Seq[UMLInterval[Uml]] = for { e <- c } yield umlInterval( e )
  implicit def umlInterval( c: Set[Uml#Interval] ): Set[UMLInterval[Uml]] = for { e <- c } yield umlInterval( e )

  implicit def umlIntervalConstraint( e: Uml#IntervalConstraint ): UMLIntervalConstraint[Uml]
  implicit def umlIntervalConstraint( c: Iterable[Uml#IntervalConstraint] ): Iterable[UMLIntervalConstraint[Uml]] = for { e <- c } yield umlIntervalConstraint( e )
  implicit def umlIntervalConstraint( c: Seq[Uml#IntervalConstraint] ): Seq[UMLIntervalConstraint[Uml]] = for { e <- c } yield umlIntervalConstraint( e )
  implicit def umlIntervalConstraint( c: Set[Uml#IntervalConstraint] ): Set[UMLIntervalConstraint[Uml]] = for { e <- c } yield umlIntervalConstraint( e )

  implicit def umlInvocationAction( e: Uml#InvocationAction ): UMLInvocationAction[Uml]
  implicit def umlInvocationAction( c: Iterable[Uml#InvocationAction] ): Iterable[UMLInvocationAction[Uml]] = for { e <- c } yield umlInvocationAction( e )
  implicit def umlInvocationAction( c: Seq[Uml#InvocationAction] ): Seq[UMLInvocationAction[Uml]] = for { e <- c } yield umlInvocationAction( e )
  implicit def umlInvocationAction( c: Set[Uml#InvocationAction] ): Set[UMLInvocationAction[Uml]] = for { e <- c } yield umlInvocationAction( e )

  implicit def umlJoinNode( e: Uml#JoinNode ): UMLJoinNode[Uml]
  implicit def umlJoinNode( c: Iterable[Uml#JoinNode] ): Iterable[UMLJoinNode[Uml]] = for { e <- c } yield umlJoinNode( e )
  implicit def umlJoinNode( c: Seq[Uml#JoinNode] ): Seq[UMLJoinNode[Uml]] = for { e <- c } yield umlJoinNode( e )
  implicit def umlJoinNode( c: Set[Uml#JoinNode] ): Set[UMLJoinNode[Uml]] = for { e <- c } yield umlJoinNode( e )

  implicit def umlLifeline( e: Uml#Lifeline ): UMLLifeline[Uml]
  implicit def umlLifeline( c: Iterable[Uml#Lifeline] ): Iterable[UMLLifeline[Uml]] = for { e <- c } yield umlLifeline( e )
  implicit def umlLifeline( c: Seq[Uml#Lifeline] ): Seq[UMLLifeline[Uml]] = for { e <- c } yield umlLifeline( e )
  implicit def umlLifeline( c: Set[Uml#Lifeline] ): Set[UMLLifeline[Uml]] = for { e <- c } yield umlLifeline( e )

  implicit def umlLinkAction( e: Uml#LinkAction ): UMLLinkAction[Uml]
  implicit def umlLinkAction( c: Iterable[Uml#LinkAction] ): Iterable[UMLLinkAction[Uml]] = for { e <- c } yield umlLinkAction( e )
  implicit def umlLinkAction( c: Seq[Uml#LinkAction] ): Seq[UMLLinkAction[Uml]] = for { e <- c } yield umlLinkAction( e )
  implicit def umlLinkAction( c: Set[Uml#LinkAction] ): Set[UMLLinkAction[Uml]] = for { e <- c } yield umlLinkAction( e )

  implicit def umlLinkEndCreationData( e: Uml#LinkEndCreationData ): UMLLinkEndCreationData[Uml]
  implicit def umlLinkEndCreationData( c: Iterable[Uml#LinkEndCreationData] ): Iterable[UMLLinkEndCreationData[Uml]] = for { e <- c } yield umlLinkEndCreationData( e )
  implicit def umlLinkEndCreationData( c: Seq[Uml#LinkEndCreationData] ): Seq[UMLLinkEndCreationData[Uml]] = for { e <- c } yield umlLinkEndCreationData( e )
  implicit def umlLinkEndCreationData( c: Set[Uml#LinkEndCreationData] ): Set[UMLLinkEndCreationData[Uml]] = for { e <- c } yield umlLinkEndCreationData( e )

  implicit def umlLinkEndData( e: Uml#LinkEndData ): UMLLinkEndData[Uml]
  implicit def umlLinkEndData( c: Iterable[Uml#LinkEndData] ): Iterable[UMLLinkEndData[Uml]] = for { e <- c } yield umlLinkEndData( e )
  implicit def umlLinkEndData( c: Seq[Uml#LinkEndData] ): Seq[UMLLinkEndData[Uml]] = for { e <- c } yield umlLinkEndData( e )
  implicit def umlLinkEndData( c: Set[Uml#LinkEndData] ): Set[UMLLinkEndData[Uml]] = for { e <- c } yield umlLinkEndData( e )

  implicit def umlLinkEndDestructionData( e: Uml#LinkEndDestructionData ): UMLLinkEndDestructionData[Uml]
  implicit def umlLinkEndDestructionData( c: Iterable[Uml#LinkEndDestructionData] ): Iterable[UMLLinkEndDestructionData[Uml]] = for { e <- c } yield umlLinkEndDestructionData( e )
  implicit def umlLinkEndDestructionData( c: Seq[Uml#LinkEndDestructionData] ): Seq[UMLLinkEndDestructionData[Uml]] = for { e <- c } yield umlLinkEndDestructionData( e )
  implicit def umlLinkEndDestructionData( c: Set[Uml#LinkEndDestructionData] ): Set[UMLLinkEndDestructionData[Uml]] = for { e <- c } yield umlLinkEndDestructionData( e )

  implicit def umlLiteralBoolean( e: Uml#LiteralBoolean ): UMLLiteralBoolean[Uml]
  implicit def umlLiteralBoolean( c: Iterable[Uml#LiteralBoolean] ): Iterable[UMLLiteralBoolean[Uml]] = for { e <- c } yield umlLiteralBoolean( e )
  implicit def umlLiteralBoolean( c: Seq[Uml#LiteralBoolean] ): Seq[UMLLiteralBoolean[Uml]] = for { e <- c } yield umlLiteralBoolean( e )
  implicit def umlLiteralBoolean( c: Set[Uml#LiteralBoolean] ): Set[UMLLiteralBoolean[Uml]] = for { e <- c } yield umlLiteralBoolean( e )

  implicit def umlLiteralInteger( e: Uml#LiteralInteger ): UMLLiteralInteger[Uml]
  implicit def umlLiteralInteger( c: Iterable[Uml#LiteralInteger] ): Iterable[UMLLiteralInteger[Uml]] = for { e <- c } yield umlLiteralInteger( e )
  implicit def umlLiteralInteger( c: Seq[Uml#LiteralInteger] ): Seq[UMLLiteralInteger[Uml]] = for { e <- c } yield umlLiteralInteger( e )
  implicit def umlLiteralInteger( c: Set[Uml#LiteralInteger] ): Set[UMLLiteralInteger[Uml]] = for { e <- c } yield umlLiteralInteger( e )

  implicit def umlLiteralNull( e: Uml#LiteralNull ): UMLLiteralNull[Uml]
  implicit def umlLiteralNull( c: Iterable[Uml#LiteralNull] ): Iterable[UMLLiteralNull[Uml]] = for { e <- c } yield umlLiteralNull( e )
  implicit def umlLiteralNull( c: Seq[Uml#LiteralNull] ): Seq[UMLLiteralNull[Uml]] = for { e <- c } yield umlLiteralNull( e )
  implicit def umlLiteralNull( c: Set[Uml#LiteralNull] ): Set[UMLLiteralNull[Uml]] = for { e <- c } yield umlLiteralNull( e )

  implicit def umlLiteralReal( e: Uml#LiteralReal ): UMLLiteralReal[Uml]
  implicit def umlLiteralReal( c: Iterable[Uml#LiteralReal] ): Iterable[UMLLiteralReal[Uml]] = for { e <- c } yield umlLiteralReal( e )
  implicit def umlLiteralReal( c: Seq[Uml#LiteralReal] ): Seq[UMLLiteralReal[Uml]] = for { e <- c } yield umlLiteralReal( e )
  implicit def umlLiteralReal( c: Set[Uml#LiteralReal] ): Set[UMLLiteralReal[Uml]] = for { e <- c } yield umlLiteralReal( e )

  implicit def umlLiteralSpecification( e: Uml#LiteralSpecification ): UMLLiteralSpecification[Uml]
  implicit def umlLiteralSpecification( c: Iterable[Uml#LiteralSpecification] ): Iterable[UMLLiteralSpecification[Uml]] = for { e <- c } yield umlLiteralSpecification( e )
  implicit def umlLiteralSpecification( c: Seq[Uml#LiteralSpecification] ): Seq[UMLLiteralSpecification[Uml]] = for { e <- c } yield umlLiteralSpecification( e )
  implicit def umlLiteralSpecification( c: Set[Uml#LiteralSpecification] ): Set[UMLLiteralSpecification[Uml]] = for { e <- c } yield umlLiteralSpecification( e )

  implicit def umlLiteralString( e: Uml#LiteralString ): UMLLiteralString[Uml]
  implicit def umlLiteralString( c: Iterable[Uml#LiteralString] ): Iterable[UMLLiteralString[Uml]] = for { e <- c } yield umlLiteralString( e )
  implicit def umlLiteralString( c: Seq[Uml#LiteralString] ): Seq[UMLLiteralString[Uml]] = for { e <- c } yield umlLiteralString( e )
  implicit def umlLiteralString( c: Set[Uml#LiteralString] ): Set[UMLLiteralString[Uml]] = for { e <- c } yield umlLiteralString( e )

  implicit def umlLiteralUnlimitedNatural( e: Uml#LiteralUnlimitedNatural ): UMLLiteralUnlimitedNatural[Uml]
  implicit def umlLiteralUnlimitedNatural( c: Iterable[Uml#LiteralUnlimitedNatural] ): Iterable[UMLLiteralUnlimitedNatural[Uml]] = for { e <- c } yield umlLiteralUnlimitedNatural( e )
  implicit def umlLiteralUnlimitedNatural( c: Seq[Uml#LiteralUnlimitedNatural] ): Seq[UMLLiteralUnlimitedNatural[Uml]] = for { e <- c } yield umlLiteralUnlimitedNatural( e )
  implicit def umlLiteralUnlimitedNatural( c: Set[Uml#LiteralUnlimitedNatural] ): Set[UMLLiteralUnlimitedNatural[Uml]] = for { e <- c } yield umlLiteralUnlimitedNatural( e )

  implicit def umlLoopNode( e: Uml#LoopNode ): UMLLoopNode[Uml]
  implicit def umlLoopNode( c: Iterable[Uml#LoopNode] ): Iterable[UMLLoopNode[Uml]] = for { e <- c } yield umlLoopNode( e )
  implicit def umlLoopNode( c: Seq[Uml#LoopNode] ): Seq[UMLLoopNode[Uml]] = for { e <- c } yield umlLoopNode( e )
  implicit def umlLoopNode( c: Set[Uml#LoopNode] ): Set[UMLLoopNode[Uml]] = for { e <- c } yield umlLoopNode( e )

  implicit def umlManifestation( e: Uml#Manifestation ): UMLManifestation[Uml]
  implicit def umlManifestation( c: Iterable[Uml#Manifestation] ): Iterable[UMLManifestation[Uml]] = for { e <- c } yield umlManifestation( e )
  implicit def umlManifestation( c: Seq[Uml#Manifestation] ): Seq[UMLManifestation[Uml]] = for { e <- c } yield umlManifestation( e )
  implicit def umlManifestation( c: Set[Uml#Manifestation] ): Set[UMLManifestation[Uml]] = for { e <- c } yield umlManifestation( e )

  implicit def umlMergeNode( e: Uml#MergeNode ): UMLMergeNode[Uml]
  implicit def umlMergeNode( c: Iterable[Uml#MergeNode] ): Iterable[UMLMergeNode[Uml]] = for { e <- c } yield umlMergeNode( e )
  implicit def umlMergeNode( c: Seq[Uml#MergeNode] ): Seq[UMLMergeNode[Uml]] = for { e <- c } yield umlMergeNode( e )
  implicit def umlMergeNode( c: Set[Uml#MergeNode] ): Set[UMLMergeNode[Uml]] = for { e <- c } yield umlMergeNode( e )

  implicit def umlMessage( e: Uml#Message ): UMLMessage[Uml]
  implicit def umlMessage( c: Iterable[Uml#Message] ): Iterable[UMLMessage[Uml]] = for { e <- c } yield umlMessage( e )
  implicit def umlMessage( c: Seq[Uml#Message] ): Seq[UMLMessage[Uml]] = for { e <- c } yield umlMessage( e )
  implicit def umlMessage( c: Set[Uml#Message] ): Set[UMLMessage[Uml]] = for { e <- c } yield umlMessage( e )

  implicit def umlMessageEnd( e: Uml#MessageEnd ): UMLMessageEnd[Uml]
  implicit def umlMessageEnd( c: Iterable[Uml#MessageEnd] ): Iterable[UMLMessageEnd[Uml]] = for { e <- c } yield umlMessageEnd( e )
  implicit def umlMessageEnd( c: Seq[Uml#MessageEnd] ): Seq[UMLMessageEnd[Uml]] = for { e <- c } yield umlMessageEnd( e )
  implicit def umlMessageEnd( c: Set[Uml#MessageEnd] ): Set[UMLMessageEnd[Uml]] = for { e <- c } yield umlMessageEnd( e )

  implicit def umlMessageEvent( e: Uml#MessageEvent ): UMLMessageEvent[Uml]
  implicit def umlMessageEvent( c: Iterable[Uml#MessageEvent] ): Iterable[UMLMessageEvent[Uml]] = for { e <- c } yield umlMessageEvent( e )
  implicit def umlMessageEvent( c: Seq[Uml#MessageEvent] ): Seq[UMLMessageEvent[Uml]] = for { e <- c } yield umlMessageEvent( e )
  implicit def umlMessageEvent( c: Set[Uml#MessageEvent] ): Set[UMLMessageEvent[Uml]] = for { e <- c } yield umlMessageEvent( e )

  implicit def umlMessageOccurrenceSpecification( e: Uml#MessageOccurrenceSpecification ): UMLMessageOccurrenceSpecification[Uml]
  implicit def umlMessageOccurrenceSpecification( c: Iterable[Uml#MessageOccurrenceSpecification] ): Iterable[UMLMessageOccurrenceSpecification[Uml]] = for { e <- c } yield umlMessageOccurrenceSpecification( e )
  implicit def umlMessageOccurrenceSpecification( c: Seq[Uml#MessageOccurrenceSpecification] ): Seq[UMLMessageOccurrenceSpecification[Uml]] = for { e <- c } yield umlMessageOccurrenceSpecification( e )
  implicit def umlMessageOccurrenceSpecification( c: Set[Uml#MessageOccurrenceSpecification] ): Set[UMLMessageOccurrenceSpecification[Uml]] = for { e <- c } yield umlMessageOccurrenceSpecification( e )

  implicit def umlModel( e: Uml#Model ): UMLModel[Uml]
  implicit def umlModel( c: Iterable[Uml#Model] ): Iterable[UMLModel[Uml]] = for { e <- c } yield umlModel( e )
  implicit def umlModel( c: Seq[Uml#Model] ): Seq[UMLModel[Uml]] = for { e <- c } yield umlModel( e )
  implicit def umlModel( c: Set[Uml#Model] ): Set[UMLModel[Uml]] = for { e <- c } yield umlModel( e )

  implicit def umlMultiplicityElement( e: Uml#MultiplicityElement ): UMLMultiplicityElement[Uml]
  implicit def umlMultiplicityElement( c: Iterable[Uml#MultiplicityElement] ): Iterable[UMLMultiplicityElement[Uml]] = for { e <- c } yield umlMultiplicityElement( e )
  implicit def umlMultiplicityElement( c: Seq[Uml#MultiplicityElement] ): Seq[UMLMultiplicityElement[Uml]] = for { e <- c } yield umlMultiplicityElement( e )
  implicit def umlMultiplicityElement( c: Set[Uml#MultiplicityElement] ): Set[UMLMultiplicityElement[Uml]] = for { e <- c } yield umlMultiplicityElement( e )

  implicit def umlNamedElement( e: Uml#NamedElement ): UMLNamedElement[Uml]
  implicit def umlNamedElement( c: Iterable[Uml#NamedElement] ): Iterable[UMLNamedElement[Uml]] = for { e <- c } yield umlNamedElement( e )
  implicit def umlNamedElement( c: Seq[Uml#NamedElement] ): Seq[UMLNamedElement[Uml]] = for { e <- c } yield umlNamedElement( e )
  implicit def umlNamedElement( c: Set[Uml#NamedElement] ): Set[UMLNamedElement[Uml]] = for { e <- c } yield umlNamedElement( e )

  implicit def umlNamespace( e: Uml#Namespace ): UMLNamespace[Uml]
  implicit def umlNamespace( c: Iterable[Uml#Namespace] ): Iterable[UMLNamespace[Uml]] = for { e <- c } yield umlNamespace( e )
  implicit def umlNamespace( c: Seq[Uml#Namespace] ): Seq[UMLNamespace[Uml]] = for { e <- c } yield umlNamespace( e )
  implicit def umlNamespace( c: Set[Uml#Namespace] ): Set[UMLNamespace[Uml]] = for { e <- c } yield umlNamespace( e )

  implicit def umlNode( e: Uml#Node ): UMLNode[Uml]
  implicit def umlNode( c: Iterable[Uml#Node] ): Iterable[UMLNode[Uml]] = for { e <- c } yield umlNode( e )
  implicit def umlNode( c: Seq[Uml#Node] ): Seq[UMLNode[Uml]] = for { e <- c } yield umlNode( e )
  implicit def umlNode( c: Set[Uml#Node] ): Set[UMLNode[Uml]] = for { e <- c } yield umlNode( e )

  implicit def umlObjectFlow( e: Uml#ObjectFlow ): UMLObjectFlow[Uml]
  implicit def umlObjectFlow( c: Iterable[Uml#ObjectFlow] ): Iterable[UMLObjectFlow[Uml]] = for { e <- c } yield umlObjectFlow( e )
  implicit def umlObjectFlow( c: Seq[Uml#ObjectFlow] ): Seq[UMLObjectFlow[Uml]] = for { e <- c } yield umlObjectFlow( e )
  implicit def umlObjectFlow( c: Set[Uml#ObjectFlow] ): Set[UMLObjectFlow[Uml]] = for { e <- c } yield umlObjectFlow( e )

  implicit def umlObjectNode( e: Uml#ObjectNode ): UMLObjectNode[Uml]
  implicit def umlObjectNode( c: Iterable[Uml#ObjectNode] ): Iterable[UMLObjectNode[Uml]] = for { e <- c } yield umlObjectNode( e )
  implicit def umlObjectNode( c: Seq[Uml#ObjectNode] ): Seq[UMLObjectNode[Uml]] = for { e <- c } yield umlObjectNode( e )
  implicit def umlObjectNode( c: Set[Uml#ObjectNode] ): Set[UMLObjectNode[Uml]] = for { e <- c } yield umlObjectNode( e )

  implicit def umlObservation( e: Uml#Observation ): UMLObservation[Uml]
  implicit def umlObservation( c: Iterable[Uml#Observation] ): Iterable[UMLObservation[Uml]] = for { e <- c } yield umlObservation( e )
  implicit def umlObservation( c: Seq[Uml#Observation] ): Seq[UMLObservation[Uml]] = for { e <- c } yield umlObservation( e )
  implicit def umlObservation( c: Set[Uml#Observation] ): Set[UMLObservation[Uml]] = for { e <- c } yield umlObservation( e )

  implicit def umlOccurrenceSpecification( e: Uml#OccurrenceSpecification ): UMLOccurrenceSpecification[Uml]
  implicit def umlOccurrenceSpecification( c: Iterable[Uml#OccurrenceSpecification] ): Iterable[UMLOccurrenceSpecification[Uml]] = for { e <- c } yield umlOccurrenceSpecification( e )
  implicit def umlOccurrenceSpecification( c: Seq[Uml#OccurrenceSpecification] ): Seq[UMLOccurrenceSpecification[Uml]] = for { e <- c } yield umlOccurrenceSpecification( e )
  implicit def umlOccurrenceSpecification( c: Set[Uml#OccurrenceSpecification] ): Set[UMLOccurrenceSpecification[Uml]] = for { e <- c } yield umlOccurrenceSpecification( e )

  implicit def umlOpaqueAction( e: Uml#OpaqueAction ): UMLOpaqueAction[Uml]
  implicit def umlOpaqueAction( c: Iterable[Uml#OpaqueAction] ): Iterable[UMLOpaqueAction[Uml]] = for { e <- c } yield umlOpaqueAction( e )
  implicit def umlOpaqueAction( c: Seq[Uml#OpaqueAction] ): Seq[UMLOpaqueAction[Uml]] = for { e <- c } yield umlOpaqueAction( e )
  implicit def umlOpaqueAction( c: Set[Uml#OpaqueAction] ): Set[UMLOpaqueAction[Uml]] = for { e <- c } yield umlOpaqueAction( e )

  implicit def umlOpaqueBehavior( e: Uml#OpaqueBehavior ): UMLOpaqueBehavior[Uml]
  implicit def umlOpaqueBehavior( c: Iterable[Uml#OpaqueBehavior] ): Iterable[UMLOpaqueBehavior[Uml]] = for { e <- c } yield umlOpaqueBehavior( e )
  implicit def umlOpaqueBehavior( c: Seq[Uml#OpaqueBehavior] ): Seq[UMLOpaqueBehavior[Uml]] = for { e <- c } yield umlOpaqueBehavior( e )
  implicit def umlOpaqueBehavior( c: Set[Uml#OpaqueBehavior] ): Set[UMLOpaqueBehavior[Uml]] = for { e <- c } yield umlOpaqueBehavior( e )

  implicit def umlOpaqueExpression( e: Uml#OpaqueExpression ): UMLOpaqueExpression[Uml]
  implicit def umlOpaqueExpression( c: Iterable[Uml#OpaqueExpression] ): Iterable[UMLOpaqueExpression[Uml]] = for { e <- c } yield umlOpaqueExpression( e )
  implicit def umlOpaqueExpression( c: Seq[Uml#OpaqueExpression] ): Seq[UMLOpaqueExpression[Uml]] = for { e <- c } yield umlOpaqueExpression( e )
  implicit def umlOpaqueExpression( c: Set[Uml#OpaqueExpression] ): Set[UMLOpaqueExpression[Uml]] = for { e <- c } yield umlOpaqueExpression( e )

  implicit def umlOperation( e: Uml#Operation ): UMLOperation[Uml]
  implicit def umlOperation( c: Iterable[Uml#Operation] ): Iterable[UMLOperation[Uml]] = for { e <- c } yield umlOperation( e )
  implicit def umlOperation( c: Seq[Uml#Operation] ): Seq[UMLOperation[Uml]] = for { e <- c } yield umlOperation( e )
  implicit def umlOperation( c: Set[Uml#Operation] ): Set[UMLOperation[Uml]] = for { e <- c } yield umlOperation( e )

  implicit def umlOperationTemplateParameter( e: Uml#OperationTemplateParameter ): UMLOperationTemplateParameter[Uml]
  implicit def umlOperationTemplateParameter( c: Iterable[Uml#OperationTemplateParameter] ): Iterable[UMLOperationTemplateParameter[Uml]] = for { e <- c } yield umlOperationTemplateParameter( e )
  implicit def umlOperationTemplateParameter( c: Seq[Uml#OperationTemplateParameter] ): Seq[UMLOperationTemplateParameter[Uml]] = for { e <- c } yield umlOperationTemplateParameter( e )
  implicit def umlOperationTemplateParameter( c: Set[Uml#OperationTemplateParameter] ): Set[UMLOperationTemplateParameter[Uml]] = for { e <- c } yield umlOperationTemplateParameter( e )

  implicit def umlOutputPin( e: Uml#OutputPin ): UMLOutputPin[Uml]
  implicit def umlOutputPin( c: Iterable[Uml#OutputPin] ): Iterable[UMLOutputPin[Uml]] = for { e <- c } yield umlOutputPin( e )
  implicit def umlOutputPin( c: Seq[Uml#OutputPin] ): Seq[UMLOutputPin[Uml]] = for { e <- c } yield umlOutputPin( e )
  implicit def umlOutputPin( c: Set[Uml#OutputPin] ): Set[UMLOutputPin[Uml]] = for { e <- c } yield umlOutputPin( e )

  implicit def umlPackage( e: Uml#Package ): UMLPackage[Uml]
  implicit def umlPackage( c: Iterable[Uml#Package] ): Iterable[UMLPackage[Uml]] = for { e <- c } yield umlPackage( e )
  implicit def umlPackage( c: Seq[Uml#Package] ): Seq[UMLPackage[Uml]] = for { e <- c } yield umlPackage( e )
  implicit def umlPackage( c: Set[Uml#Package] ): Set[UMLPackage[Uml]] = for { e <- c } yield umlPackage( e )

  implicit def umlPackageImport( e: Uml#PackageImport ): UMLPackageImport[Uml]
  implicit def umlPackageImport( c: Iterable[Uml#PackageImport] ): Iterable[UMLPackageImport[Uml]] = for { e <- c } yield umlPackageImport( e )
  implicit def umlPackageImport( c: Seq[Uml#PackageImport] ): Seq[UMLPackageImport[Uml]] = for { e <- c } yield umlPackageImport( e )
  implicit def umlPackageImport( c: Set[Uml#PackageImport] ): Set[UMLPackageImport[Uml]] = for { e <- c } yield umlPackageImport( e )

  implicit def umlPackageMerge( e: Uml#PackageMerge ): UMLPackageMerge[Uml]
  implicit def umlPackageMerge( c: Iterable[Uml#PackageMerge] ): Iterable[UMLPackageMerge[Uml]] = for { e <- c } yield umlPackageMerge( e )
  implicit def umlPackageMerge( c: Seq[Uml#PackageMerge] ): Seq[UMLPackageMerge[Uml]] = for { e <- c } yield umlPackageMerge( e )
  implicit def umlPackageMerge( c: Set[Uml#PackageMerge] ): Set[UMLPackageMerge[Uml]] = for { e <- c } yield umlPackageMerge( e )

  implicit def umlPackageableElement( e: Uml#PackageableElement ): UMLPackageableElement[Uml]
  implicit def umlPackageableElement( c: Iterable[Uml#PackageableElement] ): Iterable[UMLPackageableElement[Uml]] = for { e <- c } yield umlPackageableElement( e )
  implicit def umlPackageableElement( c: Seq[Uml#PackageableElement] ): Seq[UMLPackageableElement[Uml]] = for { e <- c } yield umlPackageableElement( e )
  implicit def umlPackageableElement( c: Set[Uml#PackageableElement] ): Set[UMLPackageableElement[Uml]] = for { e <- c } yield umlPackageableElement( e )

  implicit def umlParameter( e: Uml#Parameter ): UMLParameter[Uml]
  implicit def umlParameter( c: Iterable[Uml#Parameter] ): Iterable[UMLParameter[Uml]] = for { e <- c } yield umlParameter( e )
  implicit def umlParameter( c: Seq[Uml#Parameter] ): Seq[UMLParameter[Uml]] = for { e <- c } yield umlParameter( e )
  implicit def umlParameter( c: Set[Uml#Parameter] ): Set[UMLParameter[Uml]] = for { e <- c } yield umlParameter( e )

  implicit def umlParameterSet( e: Uml#ParameterSet ): UMLParameterSet[Uml]
  implicit def umlParameterSet( c: Iterable[Uml#ParameterSet] ): Iterable[UMLParameterSet[Uml]] = for { e <- c } yield umlParameterSet( e )
  implicit def umlParameterSet( c: Seq[Uml#ParameterSet] ): Seq[UMLParameterSet[Uml]] = for { e <- c } yield umlParameterSet( e )
  implicit def umlParameterSet( c: Set[Uml#ParameterSet] ): Set[UMLParameterSet[Uml]] = for { e <- c } yield umlParameterSet( e )

  implicit def umlParameterableElement( e: Uml#ParameterableElement ): UMLParameterableElement[Uml]
  implicit def umlParameterableElement( c: Iterable[Uml#ParameterableElement] ): Iterable[UMLParameterableElement[Uml]] = for { e <- c } yield umlParameterableElement( e )
  implicit def umlParameterableElement( c: Seq[Uml#ParameterableElement] ): Seq[UMLParameterableElement[Uml]] = for { e <- c } yield umlParameterableElement( e )
  implicit def umlParameterableElement( c: Set[Uml#ParameterableElement] ): Set[UMLParameterableElement[Uml]] = for { e <- c } yield umlParameterableElement( e )

  implicit def umlPartDecomposition( e: Uml#PartDecomposition ): UMLPartDecomposition[Uml]
  implicit def umlPartDecomposition( c: Iterable[Uml#PartDecomposition] ): Iterable[UMLPartDecomposition[Uml]] = for { e <- c } yield umlPartDecomposition( e )
  implicit def umlPartDecomposition( c: Seq[Uml#PartDecomposition] ): Seq[UMLPartDecomposition[Uml]] = for { e <- c } yield umlPartDecomposition( e )
  implicit def umlPartDecomposition( c: Set[Uml#PartDecomposition] ): Set[UMLPartDecomposition[Uml]] = for { e <- c } yield umlPartDecomposition( e )

  implicit def umlPin( e: Uml#Pin ): UMLPin[Uml]
  implicit def umlPin( c: Iterable[Uml#Pin] ): Iterable[UMLPin[Uml]] = for { e <- c } yield umlPin( e )
  implicit def umlPin( c: Seq[Uml#Pin] ): Seq[UMLPin[Uml]] = for { e <- c } yield umlPin( e )
  implicit def umlPin( c: Set[Uml#Pin] ): Set[UMLPin[Uml]] = for { e <- c } yield umlPin( e )

  implicit def umlPort( e: Uml#Port ): UMLPort[Uml]
  implicit def umlPort( c: Iterable[Uml#Port] ): Iterable[UMLPort[Uml]] = for { e <- c } yield umlPort( e )
  implicit def umlPort( c: Seq[Uml#Port] ): Seq[UMLPort[Uml]] = for { e <- c } yield umlPort( e )
  implicit def umlPort( c: Set[Uml#Port] ): Set[UMLPort[Uml]] = for { e <- c } yield umlPort( e )

  implicit def umlPrimitiveType( e: Uml#PrimitiveType ): UMLPrimitiveType[Uml]
  implicit def umlPrimitiveType( c: Iterable[Uml#PrimitiveType] ): Iterable[UMLPrimitiveType[Uml]] = for { e <- c } yield umlPrimitiveType( e )
  implicit def umlPrimitiveType( c: Seq[Uml#PrimitiveType] ): Seq[UMLPrimitiveType[Uml]] = for { e <- c } yield umlPrimitiveType( e )
  implicit def umlPrimitiveType( c: Set[Uml#PrimitiveType] ): Set[UMLPrimitiveType[Uml]] = for { e <- c } yield umlPrimitiveType( e )

  implicit def umlProfile( e: Uml#Profile ): UMLProfile[Uml]
  implicit def umlProfile( c: Iterable[Uml#Profile] ): Iterable[UMLProfile[Uml]] = for { e <- c } yield umlProfile( e )
  implicit def umlProfile( c: Seq[Uml#Profile] ): Seq[UMLProfile[Uml]] = for { e <- c } yield umlProfile( e )
  implicit def umlProfile( c: Set[Uml#Profile] ): Set[UMLProfile[Uml]] = for { e <- c } yield umlProfile( e )

  implicit def umlProfileApplication( e: Uml#ProfileApplication ): UMLProfileApplication[Uml]
  implicit def umlProfileApplication( c: Iterable[Uml#ProfileApplication] ): Iterable[UMLProfileApplication[Uml]] = for { e <- c } yield umlProfileApplication( e )
  implicit def umlProfileApplication( c: Seq[Uml#ProfileApplication] ): Seq[UMLProfileApplication[Uml]] = for { e <- c } yield umlProfileApplication( e )
  implicit def umlProfileApplication( c: Set[Uml#ProfileApplication] ): Set[UMLProfileApplication[Uml]] = for { e <- c } yield umlProfileApplication( e )

  implicit def umlProperty( e: Uml#Property ): UMLProperty[Uml]
  implicit def umlProperty( c: Iterable[Uml#Property] ): Iterable[UMLProperty[Uml]] = for { e <- c } yield umlProperty( e )
  implicit def umlProperty( c: Seq[Uml#Property] ): Seq[UMLProperty[Uml]] = for { e <- c } yield umlProperty( e )
  implicit def umlProperty( c: Set[Uml#Property] ): Set[UMLProperty[Uml]] = for { e <- c } yield umlProperty( e )

  implicit def umlProtocolConformance( e: Uml#ProtocolConformance ): UMLProtocolConformance[Uml]
  implicit def umlProtocolConformance( c: Iterable[Uml#ProtocolConformance] ): Iterable[UMLProtocolConformance[Uml]] = for { e <- c } yield umlProtocolConformance( e )
  implicit def umlProtocolConformance( c: Seq[Uml#ProtocolConformance] ): Seq[UMLProtocolConformance[Uml]] = for { e <- c } yield umlProtocolConformance( e )
  implicit def umlProtocolConformance( c: Set[Uml#ProtocolConformance] ): Set[UMLProtocolConformance[Uml]] = for { e <- c } yield umlProtocolConformance( e )

  implicit def umlProtocolStateMachine( e: Uml#ProtocolStateMachine ): UMLProtocolStateMachine[Uml]
  implicit def umlProtocolStateMachine( c: Iterable[Uml#ProtocolStateMachine] ): Iterable[UMLProtocolStateMachine[Uml]] = for { e <- c } yield umlProtocolStateMachine( e )
  implicit def umlProtocolStateMachine( c: Seq[Uml#ProtocolStateMachine] ): Seq[UMLProtocolStateMachine[Uml]] = for { e <- c } yield umlProtocolStateMachine( e )
  implicit def umlProtocolStateMachine( c: Set[Uml#ProtocolStateMachine] ): Set[UMLProtocolStateMachine[Uml]] = for { e <- c } yield umlProtocolStateMachine( e )

  implicit def umlProtocolTransition( e: Uml#ProtocolTransition ): UMLProtocolTransition[Uml]
  implicit def umlProtocolTransition( c: Iterable[Uml#ProtocolTransition] ): Iterable[UMLProtocolTransition[Uml]] = for { e <- c } yield umlProtocolTransition( e )
  implicit def umlProtocolTransition( c: Seq[Uml#ProtocolTransition] ): Seq[UMLProtocolTransition[Uml]] = for { e <- c } yield umlProtocolTransition( e )
  implicit def umlProtocolTransition( c: Set[Uml#ProtocolTransition] ): Set[UMLProtocolTransition[Uml]] = for { e <- c } yield umlProtocolTransition( e )

  implicit def umlPseudostate( e: Uml#Pseudostate ): UMLPseudostate[Uml]
  implicit def umlPseudostate( c: Iterable[Uml#Pseudostate] ): Iterable[UMLPseudostate[Uml]] = for { e <- c } yield umlPseudostate( e )
  implicit def umlPseudostate( c: Seq[Uml#Pseudostate] ): Seq[UMLPseudostate[Uml]] = for { e <- c } yield umlPseudostate( e )
  implicit def umlPseudostate( c: Set[Uml#Pseudostate] ): Set[UMLPseudostate[Uml]] = for { e <- c } yield umlPseudostate( e )

  implicit def umlQualifierValue( e: Uml#QualifierValue ): UMLQualifierValue[Uml]
  implicit def umlQualifierValue( c: Iterable[Uml#QualifierValue] ): Iterable[UMLQualifierValue[Uml]] = for { e <- c } yield umlQualifierValue( e )
  implicit def umlQualifierValue( c: Seq[Uml#QualifierValue] ): Seq[UMLQualifierValue[Uml]] = for { e <- c } yield umlQualifierValue( e )
  implicit def umlQualifierValue( c: Set[Uml#QualifierValue] ): Set[UMLQualifierValue[Uml]] = for { e <- c } yield umlQualifierValue( e )

  implicit def umlRaiseExceptionAction( e: Uml#RaiseExceptionAction ): UMLRaiseExceptionAction[Uml]
  implicit def umlRaiseExceptionAction( c: Iterable[Uml#RaiseExceptionAction] ): Iterable[UMLRaiseExceptionAction[Uml]] = for { e <- c } yield umlRaiseExceptionAction( e )
  implicit def umlRaiseExceptionAction( c: Seq[Uml#RaiseExceptionAction] ): Seq[UMLRaiseExceptionAction[Uml]] = for { e <- c } yield umlRaiseExceptionAction( e )
  implicit def umlRaiseExceptionAction( c: Set[Uml#RaiseExceptionAction] ): Set[UMLRaiseExceptionAction[Uml]] = for { e <- c } yield umlRaiseExceptionAction( e )

  implicit def umlReadExtentAction( e: Uml#ReadExtentAction ): UMLReadExtentAction[Uml]
  implicit def umlReadExtentAction( c: Iterable[Uml#ReadExtentAction] ): Iterable[UMLReadExtentAction[Uml]] = for { e <- c } yield umlReadExtentAction( e )
  implicit def umlReadExtentAction( c: Seq[Uml#ReadExtentAction] ): Seq[UMLReadExtentAction[Uml]] = for { e <- c } yield umlReadExtentAction( e )
  implicit def umlReadExtentAction( c: Set[Uml#ReadExtentAction] ): Set[UMLReadExtentAction[Uml]] = for { e <- c } yield umlReadExtentAction( e )

  implicit def umlReadIsClassifiedObjectAction( e: Uml#ReadIsClassifiedObjectAction ): UMLReadIsClassifiedObjectAction[Uml]
  implicit def umlReadIsClassifiedObjectAction( c: Iterable[Uml#ReadIsClassifiedObjectAction] ): Iterable[UMLReadIsClassifiedObjectAction[Uml]] = for { e <- c } yield umlReadIsClassifiedObjectAction( e )
  implicit def umlReadIsClassifiedObjectAction( c: Seq[Uml#ReadIsClassifiedObjectAction] ): Seq[UMLReadIsClassifiedObjectAction[Uml]] = for { e <- c } yield umlReadIsClassifiedObjectAction( e )
  implicit def umlReadIsClassifiedObjectAction( c: Set[Uml#ReadIsClassifiedObjectAction] ): Set[UMLReadIsClassifiedObjectAction[Uml]] = for { e <- c } yield umlReadIsClassifiedObjectAction( e )

  implicit def umlReadLinkAction( e: Uml#ReadLinkAction ): UMLReadLinkAction[Uml]
  implicit def umlReadLinkAction( c: Iterable[Uml#ReadLinkAction] ): Iterable[UMLReadLinkAction[Uml]] = for { e <- c } yield umlReadLinkAction( e )
  implicit def umlReadLinkAction( c: Seq[Uml#ReadLinkAction] ): Seq[UMLReadLinkAction[Uml]] = for { e <- c } yield umlReadLinkAction( e )
  implicit def umlReadLinkAction( c: Set[Uml#ReadLinkAction] ): Set[UMLReadLinkAction[Uml]] = for { e <- c } yield umlReadLinkAction( e )

  implicit def umlReadLinkObjectEndAction( e: Uml#ReadLinkObjectEndAction ): UMLReadLinkObjectEndAction[Uml]
  implicit def umlReadLinkObjectEndAction( c: Iterable[Uml#ReadLinkObjectEndAction] ): Iterable[UMLReadLinkObjectEndAction[Uml]] = for { e <- c } yield umlReadLinkObjectEndAction( e )
  implicit def umlReadLinkObjectEndAction( c: Seq[Uml#ReadLinkObjectEndAction] ): Seq[UMLReadLinkObjectEndAction[Uml]] = for { e <- c } yield umlReadLinkObjectEndAction( e )
  implicit def umlReadLinkObjectEndAction( c: Set[Uml#ReadLinkObjectEndAction] ): Set[UMLReadLinkObjectEndAction[Uml]] = for { e <- c } yield umlReadLinkObjectEndAction( e )

  implicit def umlReadLinkObjectEndQualifierAction( e: Uml#ReadLinkObjectEndQualifierAction ): UMLReadLinkObjectEndQualifierAction[Uml]
  implicit def umlReadLinkObjectEndQualifierAction( c: Iterable[Uml#ReadLinkObjectEndQualifierAction] ): Iterable[UMLReadLinkObjectEndQualifierAction[Uml]] = for { e <- c } yield umlReadLinkObjectEndQualifierAction( e )
  implicit def umlReadLinkObjectEndQualifierAction( c: Seq[Uml#ReadLinkObjectEndQualifierAction] ): Seq[UMLReadLinkObjectEndQualifierAction[Uml]] = for { e <- c } yield umlReadLinkObjectEndQualifierAction( e )
  implicit def umlReadLinkObjectEndQualifierAction( c: Set[Uml#ReadLinkObjectEndQualifierAction] ): Set[UMLReadLinkObjectEndQualifierAction[Uml]] = for { e <- c } yield umlReadLinkObjectEndQualifierAction( e )

  implicit def umlReadSelfAction( e: Uml#ReadSelfAction ): UMLReadSelfAction[Uml]
  implicit def umlReadSelfAction( c: Iterable[Uml#ReadSelfAction] ): Iterable[UMLReadSelfAction[Uml]] = for { e <- c } yield umlReadSelfAction( e )
  implicit def umlReadSelfAction( c: Seq[Uml#ReadSelfAction] ): Seq[UMLReadSelfAction[Uml]] = for { e <- c } yield umlReadSelfAction( e )
  implicit def umlReadSelfAction( c: Set[Uml#ReadSelfAction] ): Set[UMLReadSelfAction[Uml]] = for { e <- c } yield umlReadSelfAction( e )

  implicit def umlReadStructuralFeatureAction( e: Uml#ReadStructuralFeatureAction ): UMLReadStructuralFeatureAction[Uml]
  implicit def umlReadStructuralFeatureAction( c: Iterable[Uml#ReadStructuralFeatureAction] ): Iterable[UMLReadStructuralFeatureAction[Uml]] = for { e <- c } yield umlReadStructuralFeatureAction( e )
  implicit def umlReadStructuralFeatureAction( c: Seq[Uml#ReadStructuralFeatureAction] ): Seq[UMLReadStructuralFeatureAction[Uml]] = for { e <- c } yield umlReadStructuralFeatureAction( e )
  implicit def umlReadStructuralFeatureAction( c: Set[Uml#ReadStructuralFeatureAction] ): Set[UMLReadStructuralFeatureAction[Uml]] = for { e <- c } yield umlReadStructuralFeatureAction( e )

  implicit def umlReadVariableAction( e: Uml#ReadVariableAction ): UMLReadVariableAction[Uml]
  implicit def umlReadVariableAction( c: Iterable[Uml#ReadVariableAction] ): Iterable[UMLReadVariableAction[Uml]] = for { e <- c } yield umlReadVariableAction( e )
  implicit def umlReadVariableAction( c: Seq[Uml#ReadVariableAction] ): Seq[UMLReadVariableAction[Uml]] = for { e <- c } yield umlReadVariableAction( e )
  implicit def umlReadVariableAction( c: Set[Uml#ReadVariableAction] ): Set[UMLReadVariableAction[Uml]] = for { e <- c } yield umlReadVariableAction( e )

  implicit def umlRealization( e: Uml#Realization ): UMLRealization[Uml]
  implicit def umlRealization( c: Iterable[Uml#Realization] ): Iterable[UMLRealization[Uml]] = for { e <- c } yield umlRealization( e )
  implicit def umlRealization( c: Seq[Uml#Realization] ): Seq[UMLRealization[Uml]] = for { e <- c } yield umlRealization( e )
  implicit def umlRealization( c: Set[Uml#Realization] ): Set[UMLRealization[Uml]] = for { e <- c } yield umlRealization( e )

  implicit def umlReception( e: Uml#Reception ): UMLReception[Uml]
  implicit def umlReception( c: Iterable[Uml#Reception] ): Iterable[UMLReception[Uml]] = for { e <- c } yield umlReception( e )
  implicit def umlReception( c: Seq[Uml#Reception] ): Seq[UMLReception[Uml]] = for { e <- c } yield umlReception( e )
  implicit def umlReception( c: Set[Uml#Reception] ): Set[UMLReception[Uml]] = for { e <- c } yield umlReception( e )

  implicit def umlReclassifyObjectAction( e: Uml#ReclassifyObjectAction ): UMLReclassifyObjectAction[Uml]
  implicit def umlReclassifyObjectAction( c: Iterable[Uml#ReclassifyObjectAction] ): Iterable[UMLReclassifyObjectAction[Uml]] = for { e <- c } yield umlReclassifyObjectAction( e )
  implicit def umlReclassifyObjectAction( c: Seq[Uml#ReclassifyObjectAction] ): Seq[UMLReclassifyObjectAction[Uml]] = for { e <- c } yield umlReclassifyObjectAction( e )
  implicit def umlReclassifyObjectAction( c: Set[Uml#ReclassifyObjectAction] ): Set[UMLReclassifyObjectAction[Uml]] = for { e <- c } yield umlReclassifyObjectAction( e )

  implicit def umlRedefinableElement( e: Uml#RedefinableElement ): UMLRedefinableElement[Uml]
  implicit def umlRedefinableElement( c: Iterable[Uml#RedefinableElement] ): Iterable[UMLRedefinableElement[Uml]] = for { e <- c } yield umlRedefinableElement( e )
  implicit def umlRedefinableElement( c: Seq[Uml#RedefinableElement] ): Seq[UMLRedefinableElement[Uml]] = for { e <- c } yield umlRedefinableElement( e )
  implicit def umlRedefinableElement( c: Set[Uml#RedefinableElement] ): Set[UMLRedefinableElement[Uml]] = for { e <- c } yield umlRedefinableElement( e )

  implicit def umlRedefinableTemplateSignature( e: Uml#RedefinableTemplateSignature ): UMLRedefinableTemplateSignature[Uml]
  implicit def umlRedefinableTemplateSignature( c: Iterable[Uml#RedefinableTemplateSignature] ): Iterable[UMLRedefinableTemplateSignature[Uml]] = for { e <- c } yield umlRedefinableTemplateSignature( e )
  implicit def umlRedefinableTemplateSignature( c: Seq[Uml#RedefinableTemplateSignature] ): Seq[UMLRedefinableTemplateSignature[Uml]] = for { e <- c } yield umlRedefinableTemplateSignature( e )
  implicit def umlRedefinableTemplateSignature( c: Set[Uml#RedefinableTemplateSignature] ): Set[UMLRedefinableTemplateSignature[Uml]] = for { e <- c } yield umlRedefinableTemplateSignature( e )

  implicit def umlReduceAction( e: Uml#ReduceAction ): UMLReduceAction[Uml]
  implicit def umlReduceAction( c: Iterable[Uml#ReduceAction] ): Iterable[UMLReduceAction[Uml]] = for { e <- c } yield umlReduceAction( e )
  implicit def umlReduceAction( c: Seq[Uml#ReduceAction] ): Seq[UMLReduceAction[Uml]] = for { e <- c } yield umlReduceAction( e )
  implicit def umlReduceAction( c: Set[Uml#ReduceAction] ): Set[UMLReduceAction[Uml]] = for { e <- c } yield umlReduceAction( e )

  implicit def umlRegion( e: Uml#Region ): UMLRegion[Uml]
  implicit def umlRegion( c: Iterable[Uml#Region] ): Iterable[UMLRegion[Uml]] = for { e <- c } yield umlRegion( e )
  implicit def umlRegion( c: Seq[Uml#Region] ): Seq[UMLRegion[Uml]] = for { e <- c } yield umlRegion( e )
  implicit def umlRegion( c: Set[Uml#Region] ): Set[UMLRegion[Uml]] = for { e <- c } yield umlRegion( e )

  implicit def umlRelationship( e: Uml#Relationship ): UMLRelationship[Uml]
  implicit def umlRelationship( c: Iterable[Uml#Relationship] ): Iterable[UMLRelationship[Uml]] = for { e <- c } yield umlRelationship( e )
  implicit def umlRelationship( c: Seq[Uml#Relationship] ): Seq[UMLRelationship[Uml]] = for { e <- c } yield umlRelationship( e )
  implicit def umlRelationship( c: Set[Uml#Relationship] ): Set[UMLRelationship[Uml]] = for { e <- c } yield umlRelationship( e )

  implicit def umlRemoveStructuralFeatureValueAction( e: Uml#RemoveStructuralFeatureValueAction ): UMLRemoveStructuralFeatureValueAction[Uml]
  implicit def umlRemoveStructuralFeatureValueAction( c: Iterable[Uml#RemoveStructuralFeatureValueAction] ): Iterable[UMLRemoveStructuralFeatureValueAction[Uml]] = for { e <- c } yield umlRemoveStructuralFeatureValueAction( e )
  implicit def umlRemoveStructuralFeatureValueAction( c: Seq[Uml#RemoveStructuralFeatureValueAction] ): Seq[UMLRemoveStructuralFeatureValueAction[Uml]] = for { e <- c } yield umlRemoveStructuralFeatureValueAction( e )
  implicit def umlRemoveStructuralFeatureValueAction( c: Set[Uml#RemoveStructuralFeatureValueAction] ): Set[UMLRemoveStructuralFeatureValueAction[Uml]] = for { e <- c } yield umlRemoveStructuralFeatureValueAction( e )

  implicit def umlRemoveVariableValueAction( e: Uml#RemoveVariableValueAction ): UMLRemoveVariableValueAction[Uml]
  implicit def umlRemoveVariableValueAction( c: Iterable[Uml#RemoveVariableValueAction] ): Iterable[UMLRemoveVariableValueAction[Uml]] = for { e <- c } yield umlRemoveVariableValueAction( e )
  implicit def umlRemoveVariableValueAction( c: Seq[Uml#RemoveVariableValueAction] ): Seq[UMLRemoveVariableValueAction[Uml]] = for { e <- c } yield umlRemoveVariableValueAction( e )
  implicit def umlRemoveVariableValueAction( c: Set[Uml#RemoveVariableValueAction] ): Set[UMLRemoveVariableValueAction[Uml]] = for { e <- c } yield umlRemoveVariableValueAction( e )

  implicit def umlReplyAction( e: Uml#ReplyAction ): UMLReplyAction[Uml]
  implicit def umlReplyAction( c: Iterable[Uml#ReplyAction] ): Iterable[UMLReplyAction[Uml]] = for { e <- c } yield umlReplyAction( e )
  implicit def umlReplyAction( c: Seq[Uml#ReplyAction] ): Seq[UMLReplyAction[Uml]] = for { e <- c } yield umlReplyAction( e )
  implicit def umlReplyAction( c: Set[Uml#ReplyAction] ): Set[UMLReplyAction[Uml]] = for { e <- c } yield umlReplyAction( e )

  implicit def umlSendObjectAction( e: Uml#SendObjectAction ): UMLSendObjectAction[Uml]
  implicit def umlSendObjectAction( c: Iterable[Uml#SendObjectAction] ): Iterable[UMLSendObjectAction[Uml]] = for { e <- c } yield umlSendObjectAction( e )
  implicit def umlSendObjectAction( c: Seq[Uml#SendObjectAction] ): Seq[UMLSendObjectAction[Uml]] = for { e <- c } yield umlSendObjectAction( e )
  implicit def umlSendObjectAction( c: Set[Uml#SendObjectAction] ): Set[UMLSendObjectAction[Uml]] = for { e <- c } yield umlSendObjectAction( e )

  implicit def umlSendSignalAction( e: Uml#SendSignalAction ): UMLSendSignalAction[Uml]
  implicit def umlSendSignalAction( c: Iterable[Uml#SendSignalAction] ): Iterable[UMLSendSignalAction[Uml]] = for { e <- c } yield umlSendSignalAction( e )
  implicit def umlSendSignalAction( c: Seq[Uml#SendSignalAction] ): Seq[UMLSendSignalAction[Uml]] = for { e <- c } yield umlSendSignalAction( e )
  implicit def umlSendSignalAction( c: Set[Uml#SendSignalAction] ): Set[UMLSendSignalAction[Uml]] = for { e <- c } yield umlSendSignalAction( e )

  implicit def umlSequenceNode( e: Uml#SequenceNode ): UMLSequenceNode[Uml]
  implicit def umlSequenceNode( c: Iterable[Uml#SequenceNode] ): Iterable[UMLSequenceNode[Uml]] = for { e <- c } yield umlSequenceNode( e )
  implicit def umlSequenceNode( c: Seq[Uml#SequenceNode] ): Seq[UMLSequenceNode[Uml]] = for { e <- c } yield umlSequenceNode( e )
  implicit def umlSequenceNode( c: Set[Uml#SequenceNode] ): Set[UMLSequenceNode[Uml]] = for { e <- c } yield umlSequenceNode( e )

  implicit def umlSignal( e: Uml#Signal ): UMLSignal[Uml]
  implicit def umlSignal( c: Iterable[Uml#Signal] ): Iterable[UMLSignal[Uml]] = for { e <- c } yield umlSignal( e )
  implicit def umlSignal( c: Seq[Uml#Signal] ): Seq[UMLSignal[Uml]] = for { e <- c } yield umlSignal( e )
  implicit def umlSignal( c: Set[Uml#Signal] ): Set[UMLSignal[Uml]] = for { e <- c } yield umlSignal( e )

  implicit def umlSignalEvent( e: Uml#SignalEvent ): UMLSignalEvent[Uml]
  implicit def umlSignalEvent( c: Iterable[Uml#SignalEvent] ): Iterable[UMLSignalEvent[Uml]] = for { e <- c } yield umlSignalEvent( e )
  implicit def umlSignalEvent( c: Seq[Uml#SignalEvent] ): Seq[UMLSignalEvent[Uml]] = for { e <- c } yield umlSignalEvent( e )
  implicit def umlSignalEvent( c: Set[Uml#SignalEvent] ): Set[UMLSignalEvent[Uml]] = for { e <- c } yield umlSignalEvent( e )

  implicit def umlSlot( e: Uml#Slot ): UMLSlot[Uml]
  implicit def umlSlot( c: Iterable[Uml#Slot] ): Iterable[UMLSlot[Uml]] = for { e <- c } yield umlSlot( e )
  implicit def umlSlot( c: Seq[Uml#Slot] ): Seq[UMLSlot[Uml]] = for { e <- c } yield umlSlot( e )
  implicit def umlSlot( c: Set[Uml#Slot] ): Set[UMLSlot[Uml]] = for { e <- c } yield umlSlot( e )

  implicit def umlStartClassifierBehaviorAction( e: Uml#StartClassifierBehaviorAction ): UMLStartClassifierBehaviorAction[Uml]
  implicit def umlStartClassifierBehaviorAction( c: Iterable[Uml#StartClassifierBehaviorAction] ): Iterable[UMLStartClassifierBehaviorAction[Uml]] = for { e <- c } yield umlStartClassifierBehaviorAction( e )
  implicit def umlStartClassifierBehaviorAction( c: Seq[Uml#StartClassifierBehaviorAction] ): Seq[UMLStartClassifierBehaviorAction[Uml]] = for { e <- c } yield umlStartClassifierBehaviorAction( e )
  implicit def umlStartClassifierBehaviorAction( c: Set[Uml#StartClassifierBehaviorAction] ): Set[UMLStartClassifierBehaviorAction[Uml]] = for { e <- c } yield umlStartClassifierBehaviorAction( e )

  implicit def umlStartObjectBehaviorAction( e: Uml#StartObjectBehaviorAction ): UMLStartObjectBehaviorAction[Uml]
  implicit def umlStartObjectBehaviorAction( c: Iterable[Uml#StartObjectBehaviorAction] ): Iterable[UMLStartObjectBehaviorAction[Uml]] = for { e <- c } yield umlStartObjectBehaviorAction( e )
  implicit def umlStartObjectBehaviorAction( c: Seq[Uml#StartObjectBehaviorAction] ): Seq[UMLStartObjectBehaviorAction[Uml]] = for { e <- c } yield umlStartObjectBehaviorAction( e )
  implicit def umlStartObjectBehaviorAction( c: Set[Uml#StartObjectBehaviorAction] ): Set[UMLStartObjectBehaviorAction[Uml]] = for { e <- c } yield umlStartObjectBehaviorAction( e )

  implicit def umlState( e: Uml#State ): UMLState[Uml]
  implicit def umlState( c: Iterable[Uml#State] ): Iterable[UMLState[Uml]] = for { e <- c } yield umlState( e )
  implicit def umlState( c: Seq[Uml#State] ): Seq[UMLState[Uml]] = for { e <- c } yield umlState( e )
  implicit def umlState( c: Set[Uml#State] ): Set[UMLState[Uml]] = for { e <- c } yield umlState( e )

  implicit def umlStateInvariant( e: Uml#StateInvariant ): UMLStateInvariant[Uml]
  implicit def umlStateInvariant( c: Iterable[Uml#StateInvariant] ): Iterable[UMLStateInvariant[Uml]] = for { e <- c } yield umlStateInvariant( e )
  implicit def umlStateInvariant( c: Seq[Uml#StateInvariant] ): Seq[UMLStateInvariant[Uml]] = for { e <- c } yield umlStateInvariant( e )
  implicit def umlStateInvariant( c: Set[Uml#StateInvariant] ): Set[UMLStateInvariant[Uml]] = for { e <- c } yield umlStateInvariant( e )

  implicit def umlStateMachine( e: Uml#StateMachine ): UMLStateMachine[Uml]
  implicit def umlStateMachine( c: Iterable[Uml#StateMachine] ): Iterable[UMLStateMachine[Uml]] = for { e <- c } yield umlStateMachine( e )
  implicit def umlStateMachine( c: Seq[Uml#StateMachine] ): Seq[UMLStateMachine[Uml]] = for { e <- c } yield umlStateMachine( e )
  implicit def umlStateMachine( c: Set[Uml#StateMachine] ): Set[UMLStateMachine[Uml]] = for { e <- c } yield umlStateMachine( e )

  implicit def umlStereotype( e: Uml#Stereotype ): UMLStereotype[Uml]
  implicit def umlStereotype( c: Iterable[Uml#Stereotype] ): Iterable[UMLStereotype[Uml]] = for { e <- c } yield umlStereotype( e )
  implicit def umlStereotype( c: Seq[Uml#Stereotype] ): Seq[UMLStereotype[Uml]] = for { e <- c } yield umlStereotype( e )
  implicit def umlStereotype( c: Set[Uml#Stereotype] ): Set[UMLStereotype[Uml]] = for { e <- c } yield umlStereotype( e )

  implicit def umlStringExpression( e: Uml#StringExpression ): UMLStringExpression[Uml]
  implicit def umlStringExpression( c: Iterable[Uml#StringExpression] ): Iterable[UMLStringExpression[Uml]] = for { e <- c } yield umlStringExpression( e )
  implicit def umlStringExpression( c: Seq[Uml#StringExpression] ): Seq[UMLStringExpression[Uml]] = for { e <- c } yield umlStringExpression( e )
  implicit def umlStringExpression( c: Set[Uml#StringExpression] ): Set[UMLStringExpression[Uml]] = for { e <- c } yield umlStringExpression( e )

  implicit def umlStructuralFeature( e: Uml#StructuralFeature ): UMLStructuralFeature[Uml]
  implicit def umlStructuralFeature( c: Iterable[Uml#StructuralFeature] ): Iterable[UMLStructuralFeature[Uml]] = for { e <- c } yield umlStructuralFeature( e )
  implicit def umlStructuralFeature( c: Seq[Uml#StructuralFeature] ): Seq[UMLStructuralFeature[Uml]] = for { e <- c } yield umlStructuralFeature( e )
  implicit def umlStructuralFeature( c: Set[Uml#StructuralFeature] ): Set[UMLStructuralFeature[Uml]] = for { e <- c } yield umlStructuralFeature( e )

  implicit def umlStructuralFeatureAction( e: Uml#StructuralFeatureAction ): UMLStructuralFeatureAction[Uml]
  implicit def umlStructuralFeatureAction( c: Iterable[Uml#StructuralFeatureAction] ): Iterable[UMLStructuralFeatureAction[Uml]] = for { e <- c } yield umlStructuralFeatureAction( e )
  implicit def umlStructuralFeatureAction( c: Seq[Uml#StructuralFeatureAction] ): Seq[UMLStructuralFeatureAction[Uml]] = for { e <- c } yield umlStructuralFeatureAction( e )
  implicit def umlStructuralFeatureAction( c: Set[Uml#StructuralFeatureAction] ): Set[UMLStructuralFeatureAction[Uml]] = for { e <- c } yield umlStructuralFeatureAction( e )

  implicit def umlStructuredActivityNode( e: Uml#StructuredActivityNode ): UMLStructuredActivityNode[Uml]
  implicit def umlStructuredActivityNode( c: Iterable[Uml#StructuredActivityNode] ): Iterable[UMLStructuredActivityNode[Uml]] = for { e <- c } yield umlStructuredActivityNode( e )
  implicit def umlStructuredActivityNode( c: Seq[Uml#StructuredActivityNode] ): Seq[UMLStructuredActivityNode[Uml]] = for { e <- c } yield umlStructuredActivityNode( e )
  implicit def umlStructuredActivityNode( c: Set[Uml#StructuredActivityNode] ): Set[UMLStructuredActivityNode[Uml]] = for { e <- c } yield umlStructuredActivityNode( e )

  implicit def umlStructuredClassifier( e: Uml#StructuredClassifier ): UMLStructuredClassifier[Uml]
  implicit def umlStructuredClassifier( c: Iterable[Uml#StructuredClassifier] ): Iterable[UMLStructuredClassifier[Uml]] = for { e <- c } yield umlStructuredClassifier( e )
  implicit def umlStructuredClassifier( c: Seq[Uml#StructuredClassifier] ): Seq[UMLStructuredClassifier[Uml]] = for { e <- c } yield umlStructuredClassifier( e )
  implicit def umlStructuredClassifier( c: Set[Uml#StructuredClassifier] ): Set[UMLStructuredClassifier[Uml]] = for { e <- c } yield umlStructuredClassifier( e )

  implicit def umlSubstitution( e: Uml#Substitution ): UMLSubstitution[Uml]
  implicit def umlSubstitution( c: Iterable[Uml#Substitution] ): Iterable[UMLSubstitution[Uml]] = for { e <- c } yield umlSubstitution( e )
  implicit def umlSubstitution( c: Seq[Uml#Substitution] ): Seq[UMLSubstitution[Uml]] = for { e <- c } yield umlSubstitution( e )
  implicit def umlSubstitution( c: Set[Uml#Substitution] ): Set[UMLSubstitution[Uml]] = for { e <- c } yield umlSubstitution( e )

  implicit def umlTemplateBinding( e: Uml#TemplateBinding ): UMLTemplateBinding[Uml]
  implicit def umlTemplateBinding( c: Iterable[Uml#TemplateBinding] ): Iterable[UMLTemplateBinding[Uml]] = for { e <- c } yield umlTemplateBinding( e )
  implicit def umlTemplateBinding( c: Seq[Uml#TemplateBinding] ): Seq[UMLTemplateBinding[Uml]] = for { e <- c } yield umlTemplateBinding( e )
  implicit def umlTemplateBinding( c: Set[Uml#TemplateBinding] ): Set[UMLTemplateBinding[Uml]] = for { e <- c } yield umlTemplateBinding( e )

  implicit def umlTemplateParameter( e: Uml#TemplateParameter ): UMLTemplateParameter[Uml]
  implicit def umlTemplateParameter( c: Iterable[Uml#TemplateParameter] ): Iterable[UMLTemplateParameter[Uml]] = for { e <- c } yield umlTemplateParameter( e )
  implicit def umlTemplateParameter( c: Seq[Uml#TemplateParameter] ): Seq[UMLTemplateParameter[Uml]] = for { e <- c } yield umlTemplateParameter( e )
  implicit def umlTemplateParameter( c: Set[Uml#TemplateParameter] ): Set[UMLTemplateParameter[Uml]] = for { e <- c } yield umlTemplateParameter( e )

  implicit def umlTemplateParameterSubstitution( e: Uml#TemplateParameterSubstitution ): UMLTemplateParameterSubstitution[Uml]
  implicit def umlTemplateParameterSubstitution( c: Iterable[Uml#TemplateParameterSubstitution] ): Iterable[UMLTemplateParameterSubstitution[Uml]] = for { e <- c } yield umlTemplateParameterSubstitution( e )
  implicit def umlTemplateParameterSubstitution( c: Seq[Uml#TemplateParameterSubstitution] ): Seq[UMLTemplateParameterSubstitution[Uml]] = for { e <- c } yield umlTemplateParameterSubstitution( e )
  implicit def umlTemplateParameterSubstitution( c: Set[Uml#TemplateParameterSubstitution] ): Set[UMLTemplateParameterSubstitution[Uml]] = for { e <- c } yield umlTemplateParameterSubstitution( e )

  implicit def umlTemplateSignature( e: Uml#TemplateSignature ): UMLTemplateSignature[Uml]
  implicit def umlTemplateSignature( c: Iterable[Uml#TemplateSignature] ): Iterable[UMLTemplateSignature[Uml]] = for { e <- c } yield umlTemplateSignature( e )
  implicit def umlTemplateSignature( c: Seq[Uml#TemplateSignature] ): Seq[UMLTemplateSignature[Uml]] = for { e <- c } yield umlTemplateSignature( e )
  implicit def umlTemplateSignature( c: Set[Uml#TemplateSignature] ): Set[UMLTemplateSignature[Uml]] = for { e <- c } yield umlTemplateSignature( e )

  implicit def umlTemplateableElement( e: Uml#TemplateableElement ): UMLTemplateableElement[Uml]
  implicit def umlTemplateableElement( c: Iterable[Uml#TemplateableElement] ): Iterable[UMLTemplateableElement[Uml]] = for { e <- c } yield umlTemplateableElement( e )
  implicit def umlTemplateableElement( c: Seq[Uml#TemplateableElement] ): Seq[UMLTemplateableElement[Uml]] = for { e <- c } yield umlTemplateableElement( e )
  implicit def umlTemplateableElement( c: Set[Uml#TemplateableElement] ): Set[UMLTemplateableElement[Uml]] = for { e <- c } yield umlTemplateableElement( e )

  implicit def umlTestIdentityAction( e: Uml#TestIdentityAction ): UMLTestIdentityAction[Uml]
  implicit def umlTestIdentityAction( c: Iterable[Uml#TestIdentityAction] ): Iterable[UMLTestIdentityAction[Uml]] = for { e <- c } yield umlTestIdentityAction( e )
  implicit def umlTestIdentityAction( c: Seq[Uml#TestIdentityAction] ): Seq[UMLTestIdentityAction[Uml]] = for { e <- c } yield umlTestIdentityAction( e )
  implicit def umlTestIdentityAction( c: Set[Uml#TestIdentityAction] ): Set[UMLTestIdentityAction[Uml]] = for { e <- c } yield umlTestIdentityAction( e )

  implicit def umlTimeConstraint( e: Uml#TimeConstraint ): UMLTimeConstraint[Uml]
  implicit def umlTimeConstraint( c: Iterable[Uml#TimeConstraint] ): Iterable[UMLTimeConstraint[Uml]] = for { e <- c } yield umlTimeConstraint( e )
  implicit def umlTimeConstraint( c: Seq[Uml#TimeConstraint] ): Seq[UMLTimeConstraint[Uml]] = for { e <- c } yield umlTimeConstraint( e )
  implicit def umlTimeConstraint( c: Set[Uml#TimeConstraint] ): Set[UMLTimeConstraint[Uml]] = for { e <- c } yield umlTimeConstraint( e )

  implicit def umlTimeEvent( e: Uml#TimeEvent ): UMLTimeEvent[Uml]
  implicit def umlTimeEvent( c: Iterable[Uml#TimeEvent] ): Iterable[UMLTimeEvent[Uml]] = for { e <- c } yield umlTimeEvent( e )
  implicit def umlTimeEvent( c: Seq[Uml#TimeEvent] ): Seq[UMLTimeEvent[Uml]] = for { e <- c } yield umlTimeEvent( e )
  implicit def umlTimeEvent( c: Set[Uml#TimeEvent] ): Set[UMLTimeEvent[Uml]] = for { e <- c } yield umlTimeEvent( e )

  implicit def umlTimeExpression( e: Uml#TimeExpression ): UMLTimeExpression[Uml]
  implicit def umlTimeExpression( c: Iterable[Uml#TimeExpression] ): Iterable[UMLTimeExpression[Uml]] = for { e <- c } yield umlTimeExpression( e )
  implicit def umlTimeExpression( c: Seq[Uml#TimeExpression] ): Seq[UMLTimeExpression[Uml]] = for { e <- c } yield umlTimeExpression( e )
  implicit def umlTimeExpression( c: Set[Uml#TimeExpression] ): Set[UMLTimeExpression[Uml]] = for { e <- c } yield umlTimeExpression( e )

  implicit def umlTimeInterval( e: Uml#TimeInterval ): UMLTimeInterval[Uml]
  implicit def umlTimeInterval( c: Iterable[Uml#TimeInterval] ): Iterable[UMLTimeInterval[Uml]] = for { e <- c } yield umlTimeInterval( e )
  implicit def umlTimeInterval( c: Seq[Uml#TimeInterval] ): Seq[UMLTimeInterval[Uml]] = for { e <- c } yield umlTimeInterval( e )
  implicit def umlTimeInterval( c: Set[Uml#TimeInterval] ): Set[UMLTimeInterval[Uml]] = for { e <- c } yield umlTimeInterval( e )

  implicit def umlTimeObservation( e: Uml#TimeObservation ): UMLTimeObservation[Uml]
  implicit def umlTimeObservation( c: Iterable[Uml#TimeObservation] ): Iterable[UMLTimeObservation[Uml]] = for { e <- c } yield umlTimeObservation( e )
  implicit def umlTimeObservation( c: Seq[Uml#TimeObservation] ): Seq[UMLTimeObservation[Uml]] = for { e <- c } yield umlTimeObservation( e )
  implicit def umlTimeObservation( c: Set[Uml#TimeObservation] ): Set[UMLTimeObservation[Uml]] = for { e <- c } yield umlTimeObservation( e )

  implicit def umlTransition( e: Uml#Transition ): UMLTransition[Uml]
  implicit def umlTransition( c: Iterable[Uml#Transition] ): Iterable[UMLTransition[Uml]] = for { e <- c } yield umlTransition( e )
  implicit def umlTransition( c: Seq[Uml#Transition] ): Seq[UMLTransition[Uml]] = for { e <- c } yield umlTransition( e )
  implicit def umlTransition( c: Set[Uml#Transition] ): Set[UMLTransition[Uml]] = for { e <- c } yield umlTransition( e )

  implicit def umlTrigger( e: Uml#Trigger ): UMLTrigger[Uml]
  implicit def umlTrigger( c: Iterable[Uml#Trigger] ): Iterable[UMLTrigger[Uml]] = for { e <- c } yield umlTrigger( e )
  implicit def umlTrigger( c: Seq[Uml#Trigger] ): Seq[UMLTrigger[Uml]] = for { e <- c } yield umlTrigger( e )
  implicit def umlTrigger( c: Set[Uml#Trigger] ): Set[UMLTrigger[Uml]] = for { e <- c } yield umlTrigger( e )

  implicit def umlType( e: Uml#Type ): UMLType[Uml]
  implicit def umlType( c: Iterable[Uml#Type] ): Iterable[UMLType[Uml]] = for { e <- c } yield umlType( e )
  implicit def umlType( c: Seq[Uml#Type] ): Seq[UMLType[Uml]] = for { e <- c } yield umlType( e )
  implicit def umlType( c: Set[Uml#Type] ): Set[UMLType[Uml]] = for { e <- c } yield umlType( e )

  implicit def umlTypedElement( e: Uml#TypedElement ): UMLTypedElement[Uml]
  implicit def umlTypedElement( c: Iterable[Uml#TypedElement] ): Iterable[UMLTypedElement[Uml]] = for { e <- c } yield umlTypedElement( e )
  implicit def umlTypedElement( c: Seq[Uml#TypedElement] ): Seq[UMLTypedElement[Uml]] = for { e <- c } yield umlTypedElement( e )
  implicit def umlTypedElement( c: Set[Uml#TypedElement] ): Set[UMLTypedElement[Uml]] = for { e <- c } yield umlTypedElement( e )

  implicit def umlUnmarshallAction( e: Uml#UnmarshallAction ): UMLUnmarshallAction[Uml]
  implicit def umlUnmarshallAction( c: Iterable[Uml#UnmarshallAction] ): Iterable[UMLUnmarshallAction[Uml]] = for { e <- c } yield umlUnmarshallAction( e )
  implicit def umlUnmarshallAction( c: Seq[Uml#UnmarshallAction] ): Seq[UMLUnmarshallAction[Uml]] = for { e <- c } yield umlUnmarshallAction( e )
  implicit def umlUnmarshallAction( c: Set[Uml#UnmarshallAction] ): Set[UMLUnmarshallAction[Uml]] = for { e <- c } yield umlUnmarshallAction( e )

  implicit def umlUsage( e: Uml#Usage ): UMLUsage[Uml]
  implicit def umlUsage( c: Iterable[Uml#Usage] ): Iterable[UMLUsage[Uml]] = for { e <- c } yield umlUsage( e )
  implicit def umlUsage( c: Seq[Uml#Usage] ): Seq[UMLUsage[Uml]] = for { e <- c } yield umlUsage( e )
  implicit def umlUsage( c: Set[Uml#Usage] ): Set[UMLUsage[Uml]] = for { e <- c } yield umlUsage( e )

  implicit def umlUseCase( e: Uml#UseCase ): UMLUseCase[Uml]
  implicit def umlUseCase( c: Iterable[Uml#UseCase] ): Iterable[UMLUseCase[Uml]] = for { e <- c } yield umlUseCase( e )
  implicit def umlUseCase( c: Seq[Uml#UseCase] ): Seq[UMLUseCase[Uml]] = for { e <- c } yield umlUseCase( e )
  implicit def umlUseCase( c: Set[Uml#UseCase] ): Set[UMLUseCase[Uml]] = for { e <- c } yield umlUseCase( e )

  implicit def umlValuePin( e: Uml#ValuePin ): UMLValuePin[Uml]
  implicit def umlValuePin( c: Iterable[Uml#ValuePin] ): Iterable[UMLValuePin[Uml]] = for { e <- c } yield umlValuePin( e )
  implicit def umlValuePin( c: Seq[Uml#ValuePin] ): Seq[UMLValuePin[Uml]] = for { e <- c } yield umlValuePin( e )
  implicit def umlValuePin( c: Set[Uml#ValuePin] ): Set[UMLValuePin[Uml]] = for { e <- c } yield umlValuePin( e )

  implicit def umlValueSpecification( e: Uml#ValueSpecification ): UMLValueSpecification[Uml]
  implicit def umlValueSpecification( c: Iterable[Uml#ValueSpecification] ): Iterable[UMLValueSpecification[Uml]] = for { e <- c } yield umlValueSpecification( e )
  implicit def umlValueSpecification( c: Seq[Uml#ValueSpecification] ): Seq[UMLValueSpecification[Uml]] = for { e <- c } yield umlValueSpecification( e )
  implicit def umlValueSpecification( c: Set[Uml#ValueSpecification] ): Set[UMLValueSpecification[Uml]] = for { e <- c } yield umlValueSpecification( e )

  implicit def umlValueSpecificationAction( e: Uml#ValueSpecificationAction ): UMLValueSpecificationAction[Uml]
  implicit def umlValueSpecificationAction( c: Iterable[Uml#ValueSpecificationAction] ): Iterable[UMLValueSpecificationAction[Uml]] = for { e <- c } yield umlValueSpecificationAction( e )
  implicit def umlValueSpecificationAction( c: Seq[Uml#ValueSpecificationAction] ): Seq[UMLValueSpecificationAction[Uml]] = for { e <- c } yield umlValueSpecificationAction( e )
  implicit def umlValueSpecificationAction( c: Set[Uml#ValueSpecificationAction] ): Set[UMLValueSpecificationAction[Uml]] = for { e <- c } yield umlValueSpecificationAction( e )

  implicit def umlVariable( e: Uml#Variable ): UMLVariable[Uml]
  implicit def umlVariable( c: Iterable[Uml#Variable] ): Iterable[UMLVariable[Uml]] = for { e <- c } yield umlVariable( e )
  implicit def umlVariable( c: Seq[Uml#Variable] ): Seq[UMLVariable[Uml]] = for { e <- c } yield umlVariable( e )
  implicit def umlVariable( c: Set[Uml#Variable] ): Set[UMLVariable[Uml]] = for { e <- c } yield umlVariable( e )

  implicit def umlVariableAction( e: Uml#VariableAction ): UMLVariableAction[Uml]
  implicit def umlVariableAction( c: Iterable[Uml#VariableAction] ): Iterable[UMLVariableAction[Uml]] = for { e <- c } yield umlVariableAction( e )
  implicit def umlVariableAction( c: Seq[Uml#VariableAction] ): Seq[UMLVariableAction[Uml]] = for { e <- c } yield umlVariableAction( e )
  implicit def umlVariableAction( c: Set[Uml#VariableAction] ): Set[UMLVariableAction[Uml]] = for { e <- c } yield umlVariableAction( e )

  implicit def umlVertex( e: Uml#Vertex ): UMLVertex[Uml]
  implicit def umlVertex( c: Iterable[Uml#Vertex] ): Iterable[UMLVertex[Uml]] = for { e <- c } yield umlVertex( e )
  implicit def umlVertex( c: Seq[Uml#Vertex] ): Seq[UMLVertex[Uml]] = for { e <- c } yield umlVertex( e )
  implicit def umlVertex( c: Set[Uml#Vertex] ): Set[UMLVertex[Uml]] = for { e <- c } yield umlVertex( e )

  implicit def umlWriteLinkAction( e: Uml#WriteLinkAction ): UMLWriteLinkAction[Uml]
  implicit def umlWriteLinkAction( c: Iterable[Uml#WriteLinkAction] ): Iterable[UMLWriteLinkAction[Uml]] = for { e <- c } yield umlWriteLinkAction( e )
  implicit def umlWriteLinkAction( c: Seq[Uml#WriteLinkAction] ): Seq[UMLWriteLinkAction[Uml]] = for { e <- c } yield umlWriteLinkAction( e )
  implicit def umlWriteLinkAction( c: Set[Uml#WriteLinkAction] ): Set[UMLWriteLinkAction[Uml]] = for { e <- c } yield umlWriteLinkAction( e )

  implicit def umlWriteStructuralFeatureAction( e: Uml#WriteStructuralFeatureAction ): UMLWriteStructuralFeatureAction[Uml]
  implicit def umlWriteStructuralFeatureAction( c: Iterable[Uml#WriteStructuralFeatureAction] ): Iterable[UMLWriteStructuralFeatureAction[Uml]] = for { e <- c } yield umlWriteStructuralFeatureAction( e )
  implicit def umlWriteStructuralFeatureAction( c: Seq[Uml#WriteStructuralFeatureAction] ): Seq[UMLWriteStructuralFeatureAction[Uml]] = for { e <- c } yield umlWriteStructuralFeatureAction( e )
  implicit def umlWriteStructuralFeatureAction( c: Set[Uml#WriteStructuralFeatureAction] ): Set[UMLWriteStructuralFeatureAction[Uml]] = for { e <- c } yield umlWriteStructuralFeatureAction( e )

  implicit def umlWriteVariableAction( e: Uml#WriteVariableAction ): UMLWriteVariableAction[Uml]
  implicit def umlWriteVariableAction( c: Iterable[Uml#WriteVariableAction] ): Iterable[UMLWriteVariableAction[Uml]] = for { e <- c } yield umlWriteVariableAction( e )
  implicit def umlWriteVariableAction( c: Seq[Uml#WriteVariableAction] ): Seq[UMLWriteVariableAction[Uml]] = for { e <- c } yield umlWriteVariableAction( e )
  implicit def umlWriteVariableAction( c: Set[Uml#WriteVariableAction] ): Set[UMLWriteVariableAction[Uml]] = for { e <- c } yield umlWriteVariableAction( e )

}
