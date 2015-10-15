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

import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps
// Start of user code for imports
import org.omg.oti.uml._

import scala.{Boolean,Double,Enumeration,Option,None,Some,StringContext,Unit}
import scala.Predef.String
import scala.collection.immutable._
import scala.collection.Iterable
import scala.language.implicitConversions
import scala.language.existentials
import scala.reflect._
import scalaz._, Scalaz._

import java.lang.IllegalArgumentException
import java.lang.Integer
// End of user code

/**
 * There are 5 kinds of update methods:
 * 1) creating/deleting link instances of a composite association
 * 2) creating/deleting link instances of a reference association
 * 3) setting/clearing the value of a DataType metaclass property
 *
 * Unfortunately, the names of UML associations is not necessarily consistent with that of the association ends.
 * Differences include:
 * - ordering (e.g., an association from end1 to end2 is sometimes named A_end1_end2 or A_end2_end1)
 * - redefinitions (e.g., there would be name conflicts if the association were to be named according to
 *   the names of its member ends so the association name is different)
 *
 * To avoid these problems and make the API more "litterate", the naming scheme is:
 *
 * For (1)
 * links_<metaclass1>_<end1>_compose_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2TypeOrCollection>): \/[NonEmptyList[UMLError.UException], Unit]
 *
 * For (3)
 * links_<metaclass1>_<end1>_reference_<end2>_<metaclass2>
 *   (from: <metaclass1>,
 *    to: <metaclass2TypeOrCollection>): \/[NonEmptyList[UMLError.UException], Unit]
 *
 * This is done for all non-derived, non-abstract associations whose member ends have each an upper bound > 0
 *
 * The rationale for this association API is to provide flexibility in adapting the OTI UML API
 * to existing implementations of OMG UML 2.5. Even though the OMG defined UML 2.5 as a CMOF metamodel,
 * the UML specification does not explicitly require that a compliant implementation provides API-level
 * support for link-related operations defined in MOF 2.5 (see section 15, CMOF Abstract Semantics).
 * 
 * MOF 2.5 is inconsistent about the semantics of link instances of CMOF metamodel associations.
 *
 * 13.2 (Link) Semantics states:
 * When a Link is created, it is not inserted into any Extent.
 * When one or more ends of the Association are ordered, links carry ordering information in addition to their end values.
 * 
 * The first point contradicts the operations defined for a CMOF Extent (13.7):
 * 
 * linksOfType(type : Association, includesSubtypes : Boolean) : Link[0..*]
 * This returns those links in the extent that are instances of the supplied Association, 
 * or of any of its subclasses if includesSubtypes is true.
 * 
 * The second point (carrying ordering information) is not reflected in the CMOF abstract syntax (section 13)
 * or in the CMOF abstract semantics (section 15)
 *
 * On a practical level, several implementations of OMG UML 2.5 do not expose link instances of their UML 2.5 metamodel.
 * In fact, implementations that use the Eclipse EMF framework (e.g., Eclipse, MagicDraw) typically 
 * do not have Associations either because Associations are not explicitly supported in Eclipse EMF ecore metamodels. 
 * That is, such implementations effectively treat UML as an EMOF metamodel and instead encode the semantics
 * of CMOF associations as part of the API for managing Class-owned association end properties.
 * 
 * set_<metaclass>_<dataProperty>
 *   (e: <metaclass>, value: <dataPropertyTypeOrCollection>): \/[NonEmptyList[UMLError.UException], Unit]
 */
trait UMLUpdate[Uml <: UML] {

  implicit val ops: UMLOps[Uml]

  def links_Abstraction_abstraction_compose_mapping_OpaqueExpression
  (from: UMLAbstraction[Uml],
   to: Option[UMLOpaqueExpression[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_AcceptCallAction_acceptCallAction_compose_returnInformation_OutputPin
  (from: UMLAcceptCallAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_AcceptEventAction_acceptEventAction_compose_result_OutputPin
  (from: UMLAcceptEventAction[Uml],
   to: Seq[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_AcceptEventAction_acceptEventAction_compose_trigger_Trigger
  (from: UMLAcceptEventAction[Uml],
   to: Set[UMLTrigger[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_AcceptEventAction_isUnmarshall
  (e: UMLAcceptEventAction[Uml], isUnmarshall: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Action_action_compose_localPostcondition_Constraint
  (from: UMLAction[Uml],
   to: Set[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Action_action_compose_localPrecondition_Constraint
  (from: UMLAction[Uml],
   to: Set[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Action_isLocallyReentrant
  (e: UMLAction[Uml], isLocallyReentrant: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ActionExecutionSpecification_actionExecutionSpecification_reference_action_Action
  (from: UMLActionExecutionSpecification[Uml],
   to: Option[UMLAction[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ActionInputPin_actionInputPin_compose_fromAction_Action
  (from: UMLActionInputPin[Uml],
   to: Option[UMLAction[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Activity_activity_compose_edge_ActivityEdge
  (from: UMLActivity[Uml],
   to: Set[UMLActivityEdge[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Activity_inActivity_compose_group_ActivityGroup
  (from: UMLActivity[Uml],
   to: Set[UMLActivityGroup[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Activity_activity_compose_node_ActivityNode
  (from: UMLActivity[Uml],
   to: Set[UMLActivityNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Activity_activity_reference_partition_ActivityPartition
  (from: UMLActivity[Uml],
   to: Set[UMLActivityPartition[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Activity_activity_compose_structuredNode_StructuredActivityNode
  (from: UMLActivity[Uml],
   to: Set[UMLStructuredActivityNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Activity_activityScope_compose_variable_Variable
  (from: UMLActivity[Uml],
   to: Set[UMLVariable[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Activity_isReadOnly
  (e: UMLActivity[Uml], isReadOnly: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Activity_isSingleExecution
  (e: UMLActivity[Uml], isSingleExecution: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ActivityEdge_activityEdge_compose_guard_ValueSpecification
  (from: UMLActivityEdge[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityEdge_edge_reference_inPartition_ActivityPartition
  (from: UMLActivityEdge[Uml],
   to: Set[UMLActivityPartition[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityEdge_interruptingEdge_reference_interrupts_InterruptibleActivityRegion
  (from: UMLActivityEdge[Uml],
   to: Option[UMLInterruptibleActivityRegion[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityEdge_activityEdge_reference_redefinedEdge_ActivityEdge
  (from: UMLActivityEdge[Uml],
   to: Set[UMLActivityEdge[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityEdge_outgoing_reference_source_ActivityNode
  (from: UMLActivityEdge[Uml],
   to: Option[UMLActivityNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityEdge_incoming_reference_target_ActivityNode
  (from: UMLActivityEdge[Uml],
   to: Option[UMLActivityNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityEdge_activityEdge_compose_weight_ValueSpecification
  (from: UMLActivityEdge[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]



  def links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion
  (from: UMLActivityNode[Uml],
   to: Set[UMLInterruptibleActivityRegion[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityNode_node_reference_inPartition_ActivityPartition
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityPartition[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityNode_target_reference_incoming_ActivityEdge
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityEdge[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityNode_source_reference_outgoing_ActivityEdge
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityEdge[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode
  (from: UMLActivityNode[Uml],
   to: Set[UMLActivityNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ActivityParameterNode_activityParameterNode_reference_parameter_Parameter
  (from: UMLActivityParameterNode[Uml],
   to: Option[UMLParameter[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ActivityPartition_inPartition_reference_edge_ActivityEdge
  (from: UMLActivityPartition[Uml],
   to: Set[UMLActivityEdge[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityPartition_inPartition_reference_node_ActivityNode
  (from: UMLActivityPartition[Uml],
   to: Set[UMLActivityNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityPartition_activityPartition_reference_represents_Element
  (from: UMLActivityPartition[Uml],
   to: Option[UMLElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ActivityPartition_superPartition_compose_subpartition_ActivityPartition
  (from: UMLActivityPartition[Uml],
   to: Set[UMLActivityPartition[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_ActivityPartition_isDimension
  (e: UMLActivityPartition[Uml], isDimension: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_ActivityPartition_isExternal
  (e: UMLActivityPartition[Uml], isExternal: Boolean): \/[NonEmptyList[UMLError.UException], Unit]


  def links_AddStructuralFeatureValueAction_addStructuralFeatureValueAction_compose_insertAt_InputPin
  (from: UMLAddStructuralFeatureValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_AddStructuralFeatureValueAction_isReplaceAll
  (e: UMLAddStructuralFeatureValueAction[Uml], isReplaceAll: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_AddVariableValueAction_addVariableValueAction_compose_insertAt_InputPin
  (from: UMLAddVariableValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_AddVariableValueAction_isReplaceAll
  (e: UMLAddVariableValueAction[Uml], isReplaceAll: Boolean): \/[NonEmptyList[UMLError.UException], Unit]


  def links_Artifact_artifact_compose_manifestation_Manifestation
  (from: UMLArtifact[Uml],
   to: Set[UMLManifestation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Artifact_artifact_compose_nestedArtifact_Artifact
  (from: UMLArtifact[Uml],
   to: Set[UMLArtifact[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Artifact_artifact_compose_ownedAttribute_Property
  (from: UMLArtifact[Uml],
   to: Seq[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Artifact_artifact_compose_ownedOperation_Operation
  (from: UMLArtifact[Uml],
   to: Seq[UMLOperation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Artifact_fileName
  (e: UMLArtifact[Uml], fileName: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Association_association_reference_memberEnd_Property
  (from: UMLAssociation[Uml],
   to: Seq[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Association_association_reference_navigableOwnedEnd_Property
  (from: UMLAssociation[Uml],
   to: Set[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Association_owningAssociation_compose_ownedEnd_Property
  (from: UMLAssociation[Uml],
   to: Iterable[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Association_isDerived
  (e: UMLAssociation[Uml], isDerived: Boolean): \/[NonEmptyList[UMLError.UException], Unit]


  def links_Behavior_behavior_compose_ownedParameter_Parameter
  (from: UMLBehavior[Uml],
   to: Seq[UMLParameter[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Behavior_behavior_compose_ownedParameterSet_ParameterSet
  (from: UMLBehavior[Uml],
   to: Set[UMLParameterSet[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Behavior_behavior_compose_postcondition_Constraint
  (from: UMLBehavior[Uml],
   to: Set[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Behavior_behavior_compose_precondition_Constraint
  (from: UMLBehavior[Uml],
   to: Set[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Behavior_behavior_reference_redefinedBehavior_Behavior
  (from: UMLBehavior[Uml],
   to: Set[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Behavior_method_reference_specification_BehavioralFeature
  (from: UMLBehavior[Uml],
   to: Option[UMLBehavioralFeature[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Behavior_isReentrant
  (e: UMLBehavior[Uml], isReentrant: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_BehaviorExecutionSpecification_behaviorExecutionSpecification_reference_behavior_Behavior
  (from: UMLBehaviorExecutionSpecification[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_BehavioralFeature_specification_reference_method_Behavior
  (from: UMLBehavioralFeature[Uml],
   to: Set[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_BehavioralFeature_ownerFormalParam_compose_ownedParameter_Parameter
  (from: UMLBehavioralFeature[Uml],
   to: Seq[UMLParameter[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_BehavioralFeature_behavioralFeature_compose_ownedParameterSet_ParameterSet
  (from: UMLBehavioralFeature[Uml],
   to: Set[UMLParameterSet[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_BehavioralFeature_behavioralFeature_reference_raisedException_Type
  (from: UMLBehavioralFeature[Uml],
   to: Set[UMLType[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_BehavioralFeature_concurrency
  (e: UMLBehavioralFeature[Uml], concurrency: Option[UMLCallConcurrencyKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_BehavioralFeature_isAbstract
  (e: UMLBehavioralFeature[Uml], isAbstract: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior
  (from: UMLBehavioredClassifier[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization
  (from: UMLBehavioredClassifier[Uml],
   to: Set[UMLInterfaceRealization[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior
  (from: UMLBehavioredClassifier[Uml],
   to: Set[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_BroadcastSignalAction_broadcastSignalAction_reference_signal_Signal
  (from: UMLBroadcastSignalAction[Uml],
   to: Option[UMLSignal[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_CallAction_callAction_compose_result_OutputPin
  (from: UMLCallAction[Uml],
   to: Seq[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_CallAction_isSynchronous
  (e: UMLCallAction[Uml], isSynchronous: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_CallBehaviorAction_callBehaviorAction_reference_behavior_Behavior
  (from: UMLCallBehaviorAction[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_CallEvent_callEvent_reference_operation_Operation
  (from: UMLCallEvent[Uml],
   to: Option[UMLOperation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_CallOperationAction_callOperationAction_reference_operation_Operation
  (from: UMLCallOperationAction[Uml],
   to: Option[UMLOperation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_CallOperationAction_callOperationAction_compose_target_InputPin
  (from: UMLCallOperationAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_ChangeEvent_changeEvent_compose_changeExpression_ValueSpecification
  (from: UMLChangeEvent[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Class_nestingClass_compose_nestedClassifier_Classifier
  (from: UMLClass[Uml],
   to: Seq[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Class_class_compose_ownedAttribute_Property
  (from: UMLClass[Uml],
   to: Seq[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Class_class_compose_ownedOperation_Operation
  (from: UMLClass[Uml],
   to: Seq[UMLOperation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Class_class_compose_ownedReception_Reception
  (from: UMLClass[Uml],
   to: Set[UMLReception[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Class_isAbstract
  (e: UMLClass[Uml], isAbstract: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Class_isActive
  (e: UMLClass[Uml], isActive: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Classifier_classifier_compose_collaborationUse_CollaborationUse
  (from: UMLClassifier[Uml],
   to: Set[UMLCollaborationUse[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Classifier_specific_compose_generalization_Generalization
  (from: UMLClassifier[Uml],
   to: Set[UMLGeneralization[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature
  (from: UMLClassifier[Uml],
   to: Option[UMLRedefinableTemplateSignature[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Classifier_classifier_compose_ownedUseCase_UseCase
  (from: UMLClassifier[Uml],
   to: Set[UMLUseCase[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet
  (from: UMLClassifier[Uml],
   to: Set[UMLGeneralizationSet[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Classifier_classifier_reference_redefinedClassifier_Classifier
  (from: UMLClassifier[Uml],
   to: Set[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Classifier_classifier_reference_representation_CollaborationUse
  (from: UMLClassifier[Uml],
   to: Option[UMLCollaborationUse[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Classifier_substitutingClassifier_compose_substitution_Substitution
  (from: UMLClassifier[Uml],
   to: Set[UMLSubstitution[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter
  (from: UMLClassifier[Uml],
   to: Option[UMLClassifierTemplateParameter[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Classifier_subject_reference_useCase_UseCase
  (from: UMLClassifier[Uml],
   to: Set[UMLUseCase[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Classifier_isAbstract
  (e: UMLClassifier[Uml], isAbstract: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Classifier_isFinalSpecialization
  (e: UMLClassifier[Uml], isFinalSpecialization: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ClassifierTemplateParameter_classifierTemplateParameter_reference_constrainingClassifier_Classifier
  (from: UMLClassifierTemplateParameter[Uml],
   to: Set[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ClassifierTemplateParameter_templateParameter_reference_parameteredElement_Classifier
  (from: UMLClassifierTemplateParameter[Uml],
   to: Option[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_ClassifierTemplateParameter_allowSubstitutable
  (e: UMLClassifierTemplateParameter[Uml], allowSubstitutable: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Clause_clause_reference_body_ExecutableNode
  (from: UMLClause[Uml],
   to: Set[UMLExecutableNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Clause_clause_reference_bodyOutput_OutputPin
  (from: UMLClause[Uml],
   to: Seq[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Clause_clause_reference_decider_OutputPin
  (from: UMLClause[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Clause_successorClause_reference_predecessorClause_Clause
  (from: UMLClause[Uml],
   to: Set[UMLClause[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Clause_predecessorClause_reference_successorClause_Clause
  (from: UMLClause[Uml],
   to: Set[UMLClause[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Clause_clause_reference_test_ExecutableNode
  (from: UMLClause[Uml],
   to: Set[UMLExecutableNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ClearAssociationAction_clearAssociationAction_reference_association_Association
  (from: UMLClearAssociationAction[Uml],
   to: Option[UMLAssociation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ClearAssociationAction_clearAssociationAction_compose_object_InputPin
  (from: UMLClearAssociationAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ClearStructuralFeatureAction_clearStructuralFeatureAction_compose_result_OutputPin
  (from: UMLClearStructuralFeatureAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_Collaboration_collaboration_reference_collaborationRole_ConnectableElement
  (from: UMLCollaboration[Uml],
   to: Set[UMLConnectableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_CollaborationUse_collaborationUse_compose_roleBinding_Dependency
  (from: UMLCollaborationUse[Uml],
   to: Set[UMLDependency[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_CollaborationUse_collaborationUse_reference_type_Collaboration
  (from: UMLCollaborationUse[Uml],
   to: Option[UMLCollaboration[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_CombinedFragment_combinedFragment_compose_cfragmentGate_Gate
  (from: UMLCombinedFragment[Uml],
   to: Set[UMLGate[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_CombinedFragment_combinedFragment_compose_operand_InteractionOperand
  (from: UMLCombinedFragment[Uml],
   to: Seq[UMLInteractionOperand[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_CombinedFragment_interactionOperator
  (e: UMLCombinedFragment[Uml], interactionOperator: Option[UMLInteractionOperatorKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Comment_comment_reference_annotatedElement_Element
  (from: UMLComment[Uml],
   to: Set[UMLElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Comment_body
  (e: UMLComment[Uml], body: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_Component_component_compose_packagedElement_PackageableElement
  (from: UMLComponent[Uml],
   to: Set[UMLPackageableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Component_abstraction_compose_realization_ComponentRealization
  (from: UMLComponent[Uml],
   to: Set[UMLComponentRealization[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Component_isIndirectlyInstantiated
  (e: UMLComponent[Uml], isIndirectlyInstantiated: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ComponentRealization_componentRealization_reference_realizingClassifier_Classifier
  (from: UMLComponentRealization[Uml],
   to: Set[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ConditionalNode_conditionalNode_compose_clause_Clause
  (from: UMLConditionalNode[Uml],
   to: Set[UMLClause[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ConditionalNode_conditionalNode_compose_result_OutputPin
  (from: UMLConditionalNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_ConditionalNode_isAssured
  (e: UMLConditionalNode[Uml], isAssured: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_ConditionalNode_isDeterminate
  (e: UMLConditionalNode[Uml], isDeterminate: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter
  (from: UMLConnectableElement[Uml],
   to: Option[UMLConnectableElementTemplateParameter[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ConnectableElementTemplateParameter_templateParameter_reference_parameteredElement_ConnectableElement
  (from: UMLConnectableElementTemplateParameter[Uml],
   to: Option[UMLConnectableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ConnectionPointReference_connectionPointReference_reference_entry_Pseudostate
  (from: UMLConnectionPointReference[Uml],
   to: Set[UMLPseudostate[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ConnectionPointReference_connectionPointReference_reference_exit_Pseudostate
  (from: UMLConnectionPointReference[Uml],
   to: Set[UMLPseudostate[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Connector_connector_reference_contract_Behavior
  (from: UMLConnector[Uml],
   to: Set[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Connector_connector_compose_end_ConnectorEnd
  (from: UMLConnector[Uml],
   to: Seq[UMLConnectorEnd[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Connector_connector_reference_redefinedConnector_Connector
  (from: UMLConnector[Uml],
   to: Set[UMLConnector[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Connector_connector_reference_type_Association
  (from: UMLConnector[Uml],
   to: Option[UMLAssociation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ConnectorEnd_connectorEnd_reference_partWithPort_Property
  (from: UMLConnectorEnd[Uml],
   to: Option[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ConsiderIgnoreFragment_considerIgnoreFragment_reference_message_NamedElement
  (from: UMLConsiderIgnoreFragment[Uml],
   to: Set[UMLNamedElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Constraint_constraint_reference_constrainedElement_Element
  (from: UMLConstraint[Uml],
   to: Seq[UMLElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Constraint_owningConstraint_compose_specification_ValueSpecification
  (from: UMLConstraint[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Continuation_setting
  (e: UMLContinuation[Uml], setting: Boolean): \/[NonEmptyList[UMLError.UException], Unit]



  def links_CreateLinkAction_createLinkAction_compose_endData_LinkEndCreationData
  (from: UMLCreateLinkAction[Uml],
   to: Iterable[UMLLinkEndCreationData[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_CreateLinkObjectAction_createLinkObjectAction_compose_result_OutputPin
  (from: UMLCreateLinkObjectAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_CreateObjectAction_createObjectAction_reference_classifier_Classifier
  (from: UMLCreateObjectAction[Uml],
   to: Option[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_CreateObjectAction_createObjectAction_compose_result_OutputPin
  (from: UMLCreateObjectAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_DataType_datatype_compose_ownedAttribute_Property
  (from: UMLDataType[Uml],
   to: Seq[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_DataType_datatype_compose_ownedOperation_Operation
  (from: UMLDataType[Uml],
   to: Seq[UMLOperation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_DecisionNode_decisionNode_reference_decisionInput_Behavior
  (from: UMLDecisionNode[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_DecisionNode_decisionNode_reference_decisionInputFlow_ObjectFlow
  (from: UMLDecisionNode[Uml],
   to: Option[UMLObjectFlow[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Dependency_supplierDependency_reference_supplier_NamedElement
  (from: UMLDependency[Uml],
   to: Set[UMLNamedElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_Deployment_deployment_compose_configuration_DeploymentSpecification
  (from: UMLDeployment[Uml],
   to: Set[UMLDeploymentSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Deployment_deploymentForArtifact_reference_deployedArtifact_DeployedArtifact
  (from: UMLDeployment[Uml],
   to: Set[UMLDeployedArtifact[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_DeploymentSpecification_deploymentLocation
  (e: UMLDeploymentSpecification[Uml], deploymentLocation: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_DeploymentSpecification_executionLocation
  (e: UMLDeploymentSpecification[Uml], executionLocation: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_DeploymentTarget_location_compose_deployment_Deployment
  (from: UMLDeploymentTarget[Uml],
   to: Set[UMLDeployment[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_DestroyLinkAction_destroyLinkAction_compose_endData_LinkEndDestructionData
  (from: UMLDestroyLinkAction[Uml],
   to: Iterable[UMLLinkEndDestructionData[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_DestroyObjectAction_destroyObjectAction_compose_target_InputPin
  (from: UMLDestroyObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_DestroyObjectAction_isDestroyLinks
  (e: UMLDestroyObjectAction[Uml], isDestroyLinks: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_DestroyObjectAction_isDestroyOwnedObjects
  (e: UMLDestroyObjectAction[Uml], isDestroyOwnedObjects: Boolean): \/[NonEmptyList[UMLError.UException], Unit]




  def links_Duration_duration_compose_expr_ValueSpecification
  (from: UMLDuration[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Duration_duration_reference_observation_Observation
  (from: UMLDuration[Uml],
   to: Set[UMLObservation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_DurationConstraint_durationConstraint_compose_specification_DurationInterval
  (from: UMLDurationConstraint[Uml],
   to: Option[UMLDurationInterval[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_DurationConstraint_firstEvent
  (e: UMLDurationConstraint[Uml], firstEvent: Set[Boolean]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_DurationInterval_durationInterval_reference_max_Duration
  (from: UMLDurationInterval[Uml],
   to: Option[UMLDuration[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_DurationInterval_durationInterval_reference_min_Duration
  (from: UMLDurationInterval[Uml],
   to: Option[UMLDuration[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_DurationObservation_durationObservation_reference_event_NamedElement
  (from: UMLDurationObservation[Uml],
   to: Seq[UMLNamedElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_DurationObservation_firstEvent
  (e: UMLDurationObservation[Uml], firstEvent: Seq[Boolean]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Element_owningElement_compose_ownedComment_Comment
  (from: UMLElement[Uml],
   to: Set[UMLComment[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ElementImport_import_reference_importedElement_PackageableElement
  (from: UMLElementImport[Uml],
   to: Option[UMLPackageableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_ElementImport_alias
  (e: UMLElementImport[Uml], alias: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_ElementImport_visibility
  (e: UMLElementImport[Uml], visibility: Option[UMLVisibilityKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_Enumeration_enumeration_compose_ownedLiteral_EnumerationLiteral
  (from: UMLEnumeration[Uml],
   to: Seq[UMLEnumerationLiteral[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]



  def links_ExceptionHandler_exceptionHandler_reference_exceptionInput_ObjectNode
  (from: UMLExceptionHandler[Uml],
   to: Option[UMLObjectNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ExceptionHandler_exceptionHandler_reference_exceptionType_Classifier
  (from: UMLExceptionHandler[Uml],
   to: Set[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ExceptionHandler_exceptionHandler_reference_handlerBody_ExecutableNode
  (from: UMLExceptionHandler[Uml],
   to: Option[UMLExecutableNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler
  (from: UMLExecutableNode[Uml],
   to: Set[UMLExceptionHandler[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_ExecutionOccurrenceSpecification_executionOccurrenceSpecification_reference_execution_ExecutionSpecification
  (from: UMLExecutionOccurrenceSpecification[Uml],
   to: Option[UMLExecutionSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ExecutionSpecification_executionSpecification_reference_finish_OccurrenceSpecification
  (from: UMLExecutionSpecification[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ExecutionSpecification_executionSpecification_reference_start_OccurrenceSpecification
  (from: UMLExecutionSpecification[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ExpansionNode_inputElement_reference_regionAsInput_ExpansionRegion
  (from: UMLExpansionNode[Uml],
   to: Option[UMLExpansionRegion[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ExpansionNode_outputElement_reference_regionAsOutput_ExpansionRegion
  (from: UMLExpansionNode[Uml],
   to: Option[UMLExpansionRegion[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ExpansionRegion_regionAsInput_reference_inputElement_ExpansionNode
  (from: UMLExpansionRegion[Uml],
   to: Set[UMLExpansionNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ExpansionRegion_regionAsOutput_reference_outputElement_ExpansionNode
  (from: UMLExpansionRegion[Uml],
   to: Set[UMLExpansionNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_ExpansionRegion_mode
  (e: UMLExpansionRegion[Uml], mode: Option[UMLExpansionKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Expression_expression_compose_operand_ValueSpecification
  (from: UMLExpression[Uml],
   to: Seq[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Expression_symbol
  (e: UMLExpression[Uml], symbol: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Extend_extend_compose_condition_Constraint
  (from: UMLExtend[Uml],
   to: Option[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Extend_extend_reference_extendedCase_UseCase
  (from: UMLExtend[Uml],
   to: Option[UMLUseCase[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Extend_extension_reference_extensionLocation_ExtensionPoint
  (from: UMLExtend[Uml],
   to: Seq[UMLExtensionPoint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Extension_extension_compose_ownedEnd_ExtensionEnd
  (from: UMLExtension[Uml],
   to: Iterable[UMLExtensionEnd[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ExtensionEnd_extensionEnd_reference_type_Stereotype
  (from: UMLExtensionEnd[Uml],
   to: Option[UMLStereotype[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def set_Feature_isStatic
  (e: UMLFeature[Uml], isStatic: Boolean): \/[NonEmptyList[UMLError.UException], Unit]







  def links_GeneralOrdering_toBefore_reference_after_OccurrenceSpecification
  (from: UMLGeneralOrdering[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_GeneralOrdering_toAfter_reference_before_OccurrenceSpecification
  (from: UMLGeneralOrdering[Uml],
   to: Option[UMLOccurrenceSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Generalization_generalization_reference_general_Classifier
  (from: UMLGeneralization[Uml],
   to: Option[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Generalization_generalization_reference_generalizationSet_GeneralizationSet
  (from: UMLGeneralization[Uml],
   to: Set[UMLGeneralizationSet[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Generalization_isSubstitutable
  (e: UMLGeneralization[Uml], isSubstitutable: Option[Boolean]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_GeneralizationSet_generalizationSet_reference_generalization_Generalization
  (from: UMLGeneralizationSet[Uml],
   to: Set[UMLGeneralization[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_GeneralizationSet_powertypeExtent_reference_powertype_Classifier
  (from: UMLGeneralizationSet[Uml],
   to: Option[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_GeneralizationSet_isCovering
  (e: UMLGeneralizationSet[Uml], isCovering: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_GeneralizationSet_isDisjoint
  (e: UMLGeneralizationSet[Uml], isDisjoint: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Image_content
  (e: UMLImage[Uml], content: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Image_format
  (e: UMLImage[Uml], format: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Image_location
  (e: UMLImage[Uml], location: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Include_include_reference_addition_UseCase
  (from: UMLInclude[Uml],
   to: Option[UMLUseCase[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_InformationFlow_conveyingFlow_reference_conveyed_Classifier
  (from: UMLInformationFlow[Uml],
   to: Set[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InformationFlow_informationFlow_reference_informationSource_NamedElement
  (from: UMLInformationFlow[Uml],
   to: Set[UMLNamedElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InformationFlow_informationFlow_reference_informationTarget_NamedElement
  (from: UMLInformationFlow[Uml],
   to: Set[UMLNamedElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InformationFlow_abstraction_reference_realization_Relationship
  (from: UMLInformationFlow[Uml],
   to: Set[UMLRelationship[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InformationFlow_informationFlow_reference_realizingActivityEdge_ActivityEdge
  (from: UMLInformationFlow[Uml],
   to: Set[UMLActivityEdge[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InformationFlow_informationFlow_reference_realizingConnector_Connector
  (from: UMLInformationFlow[Uml],
   to: Set[UMLConnector[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InformationFlow_informationFlow_reference_realizingMessage_Message
  (from: UMLInformationFlow[Uml],
   to: Set[UMLMessage[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_InformationItem_representation_reference_represented_Classifier
  (from: UMLInformationItem[Uml],
   to: Set[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]



  def links_InstanceSpecification_instanceSpecification_reference_classifier_Classifier
  (from: UMLInstanceSpecification[Uml],
   to: Iterable[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InstanceSpecification_owningInstance_compose_slot_Slot
  (from: UMLInstanceSpecification[Uml],
   to: Set[UMLSlot[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InstanceSpecification_owningInstanceSpec_compose_specification_ValueSpecification
  (from: UMLInstanceSpecification[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_InstanceValue_instanceValue_reference_instance_InstanceSpecification
  (from: UMLInstanceValue[Uml],
   to: Option[UMLInstanceSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Interaction_interaction_compose_action_Action
  (from: UMLInteraction[Uml],
   to: Set[UMLAction[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Interaction_interaction_compose_formalGate_Gate
  (from: UMLInteraction[Uml],
   to: Set[UMLGate[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Interaction_enclosingInteraction_compose_fragment_InteractionFragment
  (from: UMLInteraction[Uml],
   to: Seq[UMLInteractionFragment[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Interaction_interaction_compose_lifeline_Lifeline
  (from: UMLInteraction[Uml],
   to: Set[UMLLifeline[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Interaction_interaction_compose_message_Message
  (from: UMLInteraction[Uml],
   to: Set[UMLMessage[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_InteractionConstraint_interactionConstraint_compose_maxint_ValueSpecification
  (from: UMLInteractionConstraint[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InteractionConstraint_interactionConstraint_compose_minint_ValueSpecification
  (from: UMLInteractionConstraint[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_InteractionFragment_coveredBy_reference_covered_Lifeline
  (from: UMLInteractionFragment[Uml],
   to: Iterable[UMLLifeline[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering
  (from: UMLInteractionFragment[Uml],
   to: Set[UMLGeneralOrdering[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_InteractionOperand_enclosingOperand_compose_fragment_InteractionFragment
  (from: UMLInteractionOperand[Uml],
   to: Seq[UMLInteractionFragment[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InteractionOperand_interactionOperand_compose_guard_InteractionConstraint
  (from: UMLInteractionOperand[Uml],
   to: Option[UMLInteractionConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_InteractionUse_interactionUse_compose_actualGate_Gate
  (from: UMLInteractionUse[Uml],
   to: Set[UMLGate[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InteractionUse_interactionUse_compose_argument_ValueSpecification
  (from: UMLInteractionUse[Uml],
   to: Seq[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InteractionUse_interactionUse_reference_refersTo_Interaction
  (from: UMLInteractionUse[Uml],
   to: Option[UMLInteraction[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InteractionUse_interactionUse_compose_returnValue_ValueSpecification
  (from: UMLInteractionUse[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InteractionUse_interactionUse_reference_returnValueRecipient_Property
  (from: UMLInteractionUse[Uml],
   to: Option[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Interface_interface_compose_nestedClassifier_Classifier
  (from: UMLInterface[Uml],
   to: Seq[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Interface_interface_compose_ownedAttribute_Property
  (from: UMLInterface[Uml],
   to: Seq[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Interface_interface_compose_ownedOperation_Operation
  (from: UMLInterface[Uml],
   to: Seq[UMLOperation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Interface_interface_compose_ownedReception_Reception
  (from: UMLInterface[Uml],
   to: Set[UMLReception[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Interface_interface_compose_protocol_ProtocolStateMachine
  (from: UMLInterface[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Interface_interface_reference_redefinedInterface_Interface
  (from: UMLInterface[Uml],
   to: Set[UMLInterface[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_InterfaceRealization_interfaceRealization_reference_contract_Interface
  (from: UMLInterfaceRealization[Uml],
   to: Option[UMLInterface[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_InterruptibleActivityRegion_interrupts_reference_interruptingEdge_ActivityEdge
  (from: UMLInterruptibleActivityRegion[Uml],
   to: Set[UMLActivityEdge[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InterruptibleActivityRegion_inInterruptibleRegion_reference_node_ActivityNode
  (from: UMLInterruptibleActivityRegion[Uml],
   to: Set[UMLActivityNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Interval_interval_reference_max_ValueSpecification
  (from: UMLInterval[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Interval_interval_reference_min_ValueSpecification
  (from: UMLInterval[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_IntervalConstraint_intervalConstraint_compose_specification_Interval
  (from: UMLIntervalConstraint[Uml],
   to: Option[UMLInterval[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_InvocationAction_invocationAction_compose_argument_InputPin
  (from: UMLInvocationAction[Uml],
   to: Seq[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_InvocationAction_invocationAction_reference_onPort_Port
  (from: UMLInvocationAction[Uml],
   to: Option[UMLPort[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_JoinNode_joinNode_compose_joinSpec_ValueSpecification
  (from: UMLJoinNode[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_JoinNode_isCombineDuplicate
  (e: UMLJoinNode[Uml], isCombineDuplicate: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Lifeline_covered_reference_coveredBy_InteractionFragment
  (from: UMLLifeline[Uml],
   to: Set[UMLInteractionFragment[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Lifeline_lifeline_reference_decomposedAs_PartDecomposition
  (from: UMLLifeline[Uml],
   to: Option[UMLPartDecomposition[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Lifeline_lifeline_reference_represents_ConnectableElement
  (from: UMLLifeline[Uml],
   to: Option[UMLConnectableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Lifeline_lifeline_compose_selector_ValueSpecification
  (from: UMLLifeline[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_LinkAction_linkAction_compose_endData_LinkEndData
  (from: UMLLinkAction[Uml],
   to: Iterable[UMLLinkEndData[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_LinkAction_linkAction_compose_inputValue_InputPin
  (from: UMLLinkAction[Uml],
   to: Set[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_LinkEndCreationData_linkEndCreationData_reference_insertAt_InputPin
  (from: UMLLinkEndCreationData[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_LinkEndCreationData_isReplaceAll
  (e: UMLLinkEndCreationData[Uml], isReplaceAll: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_LinkEndData_linkEndData_reference_end_Property
  (from: UMLLinkEndData[Uml],
   to: Option[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_LinkEndData_linkEndData_compose_qualifier_QualifierValue
  (from: UMLLinkEndData[Uml],
   to: Set[UMLQualifierValue[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_LinkEndData_linkEndData_reference_value_InputPin
  (from: UMLLinkEndData[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_LinkEndDestructionData_linkEndDestructionData_reference_destroyAt_InputPin
  (from: UMLLinkEndDestructionData[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_LinkEndDestructionData_isDestroyDuplicates
  (e: UMLLinkEndDestructionData[Uml], isDestroyDuplicates: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_LiteralBoolean_value
  (e: UMLLiteralBoolean[Uml], value: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_LiteralInteger_value
  (e: UMLLiteralInteger[Uml], value: Integer): \/[NonEmptyList[UMLError.UException], Unit]


  def set_LiteralReal_value
  (e: UMLLiteralReal[Uml], value: Double): \/[NonEmptyList[UMLError.UException], Unit]


  def set_LiteralString_value
  (e: UMLLiteralString[Uml], value: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_LiteralUnlimitedNatural_value
  (e: UMLLiteralUnlimitedNatural[Uml], value: String): \/[NonEmptyList[UMLError.UException], Unit]

  def links_LoopNode_loopNode_reference_bodyOutput_OutputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_LoopNode_loopNode_reference_bodyPart_ExecutableNode
  (from: UMLLoopNode[Uml],
   to: Set[UMLExecutableNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_LoopNode_loopNode_reference_decider_OutputPin
  (from: UMLLoopNode[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_LoopNode_loopNode_compose_loopVariable_OutputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_LoopNode_loopNode_compose_loopVariableInput_InputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_LoopNode_loopNode_compose_result_OutputPin
  (from: UMLLoopNode[Uml],
   to: Seq[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_LoopNode_loopNode_reference_setupPart_ExecutableNode
  (from: UMLLoopNode[Uml],
   to: Set[UMLExecutableNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_LoopNode_loopNode_reference_test_ExecutableNode
  (from: UMLLoopNode[Uml],
   to: Set[UMLExecutableNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_LoopNode_isTestedFirst
  (e: UMLLoopNode[Uml], isTestedFirst: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Manifestation_manifestation_reference_utilizedElement_PackageableElement
  (from: UMLManifestation[Uml],
   to: Option[UMLPackageableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_Message_message_compose_argument_ValueSpecification
  (from: UMLMessage[Uml],
   to: Seq[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Message_message_reference_connector_Connector
  (from: UMLMessage[Uml],
   to: Option[UMLConnector[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Message_endMessage_reference_receiveEvent_MessageEnd
  (from: UMLMessage[Uml],
   to: Option[UMLMessageEnd[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Message_endMessage_reference_sendEvent_MessageEnd
  (from: UMLMessage[Uml],
   to: Option[UMLMessageEnd[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Message_message_reference_signature_NamedElement
  (from: UMLMessage[Uml],
   to: Option[UMLNamedElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Message_messageSort
  (e: UMLMessage[Uml], messageSort: Option[UMLMessageSort.Value]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_MessageEnd_messageEnd_reference_message_Message
  (from: UMLMessageEnd[Uml],
   to: Option[UMLMessage[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]



  def set_Model_viewpoint
  (e: UMLModel[Uml], viewpoint: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification
  (from: UMLMultiplicityElement[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification
  (from: UMLMultiplicityElement[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_MultiplicityElement_isOrdered
  (e: UMLMultiplicityElement[Uml], isOrdered: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_MultiplicityElement_isUnique
  (e: UMLMultiplicityElement[Uml], isUnique: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_NamedElement_namedElement_compose_nameExpression_StringExpression
  (from: UMLNamedElement[Uml],
   to: Option[UMLStringExpression[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_NamedElement_name
  (e: UMLNamedElement[Uml], name: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_NamedElement_visibility
  (e: UMLNamedElement[Uml], visibility: Option[UMLVisibilityKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Namespace_importingNamespace_compose_elementImport_ElementImport
  (from: UMLNamespace[Uml],
   to: Set[UMLElementImport[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Namespace_context_compose_ownedRule_Constraint
  (from: UMLNamespace[Uml],
   to: Set[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Namespace_importingNamespace_compose_packageImport_PackageImport
  (from: UMLNamespace[Uml],
   to: Set[UMLPackageImport[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Node_node_compose_nestedNode_Node
  (from: UMLNode[Uml],
   to: Set[UMLNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ObjectFlow_objectFlow_reference_selection_Behavior
  (from: UMLObjectFlow[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ObjectFlow_objectFlow_reference_transformation_Behavior
  (from: UMLObjectFlow[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_ObjectFlow_isMulticast
  (e: UMLObjectFlow[Uml], isMulticast: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_ObjectFlow_isMultireceive
  (e: UMLObjectFlow[Uml], isMultireceive: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ObjectNode_objectNode_reference_inState_State
  (from: UMLObjectNode[Uml],
   to: Set[UMLState[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ObjectNode_objectNode_reference_selection_Behavior
  (from: UMLObjectNode[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ObjectNode_objectNode_compose_upperBound_ValueSpecification
  (from: UMLObjectNode[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_ObjectNode_isControlType
  (e: UMLObjectNode[Uml], isControlType: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_ObjectNode_ordering
  (e: UMLObjectNode[Uml], ordering: Option[UMLObjectNodeOrderingKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_OccurrenceSpecification_events_reference_covered_Lifeline
  (from: UMLOccurrenceSpecification[Uml],
   to: Iterable[UMLLifeline[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_OccurrenceSpecification_before_reference_toAfter_GeneralOrdering
  (from: UMLOccurrenceSpecification[Uml],
   to: Set[UMLGeneralOrdering[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_OccurrenceSpecification_after_reference_toBefore_GeneralOrdering
  (from: UMLOccurrenceSpecification[Uml],
   to: Set[UMLGeneralOrdering[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_OpaqueAction_opaqueAction_compose_inputValue_InputPin
  (from: UMLOpaqueAction[Uml],
   to: Set[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_OpaqueAction_opaqueAction_compose_outputValue_OutputPin
  (from: UMLOpaqueAction[Uml],
   to: Set[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_OpaqueAction_body
  (e: UMLOpaqueAction[Uml], body: Seq[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_OpaqueAction_language
  (e: UMLOpaqueAction[Uml], language: Seq[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_OpaqueBehavior_body
  (e: UMLOpaqueBehavior[Uml], body: Seq[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_OpaqueBehavior_language
  (e: UMLOpaqueBehavior[Uml], language: Seq[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_OpaqueExpression_opaqueExpression_reference_behavior_Behavior
  (from: UMLOpaqueExpression[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_OpaqueExpression_body
  (e: UMLOpaqueExpression[Uml], body: Seq[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_OpaqueExpression_language
  (e: UMLOpaqueExpression[Uml], language: Seq[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Operation_bodyContext_compose_bodyCondition_Constraint
  (from: UMLOperation[Uml],
   to: Option[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Operation_operation_compose_ownedParameter_Parameter
  (from: UMLOperation[Uml],
   to: Seq[UMLParameter[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Operation_postContext_compose_postcondition_Constraint
  (from: UMLOperation[Uml],
   to: Set[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Operation_preContext_compose_precondition_Constraint
  (from: UMLOperation[Uml],
   to: Set[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Operation_operation_reference_raisedException_Type
  (from: UMLOperation[Uml],
   to: Set[UMLType[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Operation_operation_reference_redefinedOperation_Operation
  (from: UMLOperation[Uml],
   to: Set[UMLOperation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Operation_parameteredElement_reference_templateParameter_OperationTemplateParameter
  (from: UMLOperation[Uml],
   to: Option[UMLOperationTemplateParameter[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Operation_isQuery
  (e: UMLOperation[Uml], isQuery: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_OperationTemplateParameter_templateParameter_reference_parameteredElement_Operation
  (from: UMLOperationTemplateParameter[Uml],
   to: Option[UMLOperation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_Package_receivingPackage_compose_packageMerge_PackageMerge
  (from: UMLPackage[Uml],
   to: Set[UMLPackageMerge[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Package_owningPackage_compose_packagedElement_PackageableElement
  (from: UMLPackage[Uml],
   to: Set[UMLPackageableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Package_applyingPackage_compose_profileApplication_ProfileApplication
  (from: UMLPackage[Uml],
   to: Set[UMLProfileApplication[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Package_URI
  (e: UMLPackage[Uml], URI: Option[String]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_PackageImport_packageImport_reference_importedPackage_Package
  (from: UMLPackageImport[Uml],
   to: Option[UMLPackage[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_PackageImport_visibility
  (e: UMLPackageImport[Uml], visibility: Option[UMLVisibilityKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_PackageMerge_packageMerge_reference_mergedPackage_Package
  (from: UMLPackageMerge[Uml],
   to: Option[UMLPackage[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_PackageableElement_visibility
  (e: UMLPackageableElement[Uml], visibility: Option[UMLVisibilityKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Parameter_owningParameter_compose_defaultValue_ValueSpecification
  (from: UMLParameter[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Parameter_parameter_reference_parameterSet_ParameterSet
  (from: UMLParameter[Uml],
   to: Set[UMLParameterSet[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Parameter_direction
  (e: UMLParameter[Uml], direction: Option[UMLParameterDirectionKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Parameter_effect
  (e: UMLParameter[Uml], effect: Option[UMLParameterEffectKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Parameter_isException
  (e: UMLParameter[Uml], isException: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Parameter_isStream
  (e: UMLParameter[Uml], isStream: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ParameterSet_parameterSet_compose_condition_Constraint
  (from: UMLParameterSet[Uml],
   to: Set[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ParameterSet_parameterSet_reference_parameter_Parameter
  (from: UMLParameterSet[Uml],
   to: Set[UMLParameter[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter
  (from: UMLParameterableElement[Uml],
   to: Option[UMLTemplateParameter[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def set_Pin_isControl
  (e: UMLPin[Uml], isControl: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Port_port_reference_protocol_ProtocolStateMachine
  (from: UMLPort[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Port_port_reference_redefinedPort_Port
  (from: UMLPort[Uml],
   to: Set[UMLPort[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Port_isBehavior
  (e: UMLPort[Uml], isBehavior: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Port_isConjugated
  (e: UMLPort[Uml], isConjugated: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Port_isService
  (e: UMLPort[Uml], isService: Boolean): \/[NonEmptyList[UMLError.UException], Unit]


  def links_Profile_profile_compose_metaclassReference_ElementImport
  (from: UMLProfile[Uml],
   to: Set[UMLElementImport[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Profile_profile_compose_metamodelReference_PackageImport
  (from: UMLProfile[Uml],
   to: Set[UMLPackageImport[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ProfileApplication_profileApplication_reference_appliedProfile_Profile
  (from: UMLProfileApplication[Uml],
   to: Option[UMLProfile[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_ProfileApplication_isStrict
  (e: UMLProfileApplication[Uml], isStrict: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Property_memberEnd_reference_association_Association
  (from: UMLProperty[Uml],
   to: Option[UMLAssociation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Property_owningProperty_compose_defaultValue_ValueSpecification
  (from: UMLProperty[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Property_associationEnd_compose_qualifier_Property
  (from: UMLProperty[Uml],
   to: Seq[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Property_property_reference_redefinedProperty_Property
  (from: UMLProperty[Uml],
   to: Set[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Property_property_reference_subsettedProperty_Property
  (from: UMLProperty[Uml],
   to: Set[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Property_aggregation
  (e: UMLProperty[Uml], aggregation: Option[UMLAggregationKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Property_isDerived
  (e: UMLProperty[Uml], isDerived: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Property_isDerivedUnion
  (e: UMLProperty[Uml], isDerivedUnion: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Property_isID
  (e: UMLProperty[Uml], isID: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ProtocolConformance_protocolConformance_reference_generalMachine_ProtocolStateMachine
  (from: UMLProtocolConformance[Uml],
   to: Option[UMLProtocolStateMachine[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ProtocolStateMachine_specificMachine_compose_conformance_ProtocolConformance
  (from: UMLProtocolStateMachine[Uml],
   to: Set[UMLProtocolConformance[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ProtocolTransition_owningTransition_compose_postCondition_Constraint
  (from: UMLProtocolTransition[Uml],
   to: Option[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ProtocolTransition_protocolTransition_compose_preCondition_Constraint
  (from: UMLProtocolTransition[Uml],
   to: Option[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_Pseudostate_kind
  (e: UMLPseudostate[Uml], kind: Option[UMLPseudostateKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_QualifierValue_qualifierValue_reference_qualifier_Property
  (from: UMLQualifierValue[Uml],
   to: Option[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_QualifierValue_qualifierValue_reference_value_InputPin
  (from: UMLQualifierValue[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_RaiseExceptionAction_raiseExceptionAction_compose_exception_InputPin
  (from: UMLRaiseExceptionAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ReadExtentAction_readExtentAction_reference_classifier_Classifier
  (from: UMLReadExtentAction[Uml],
   to: Option[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReadExtentAction_readExtentAction_compose_result_OutputPin
  (from: UMLReadExtentAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_reference_classifier_Classifier
  (from: UMLReadIsClassifiedObjectAction[Uml],
   to: Option[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_object_InputPin
  (from: UMLReadIsClassifiedObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_result_OutputPin
  (from: UMLReadIsClassifiedObjectAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_ReadIsClassifiedObjectAction_isDirect
  (e: UMLReadIsClassifiedObjectAction[Uml], isDirect: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ReadLinkAction_readLinkAction_compose_result_OutputPin
  (from: UMLReadLinkAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ReadLinkObjectEndAction_readLinkObjectEndAction_reference_end_Property
  (from: UMLReadLinkObjectEndAction[Uml],
   to: Option[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_object_InputPin
  (from: UMLReadLinkObjectEndAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_result_OutputPin
  (from: UMLReadLinkObjectEndAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_object_InputPin
  (from: UMLReadLinkObjectEndQualifierAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_reference_qualifier_Property
  (from: UMLReadLinkObjectEndQualifierAction[Uml],
   to: Option[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_result_OutputPin
  (from: UMLReadLinkObjectEndQualifierAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ReadSelfAction_readSelfAction_compose_result_OutputPin
  (from: UMLReadSelfAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ReadStructuralFeatureAction_readStructuralFeatureAction_compose_result_OutputPin
  (from: UMLReadStructuralFeatureAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ReadVariableAction_readVariableAction_compose_result_OutputPin
  (from: UMLReadVariableAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_Reception_reception_reference_signal_Signal
  (from: UMLReception[Uml],
   to: Option[UMLSignal[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ReclassifyObjectAction_reclassifyObjectAction_reference_newClassifier_Classifier
  (from: UMLReclassifyObjectAction[Uml],
   to: Set[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReclassifyObjectAction_reclassifyObjectAction_compose_object_InputPin
  (from: UMLReclassifyObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReclassifyObjectAction_reclassifyObjectAction_reference_oldClassifier_Classifier
  (from: UMLReclassifyObjectAction[Uml],
   to: Set[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_ReclassifyObjectAction_isReplaceAll
  (e: UMLReclassifyObjectAction[Uml], isReplaceAll: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def set_RedefinableElement_isLeaf
  (e: UMLRedefinableElement[Uml], isLeaf: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_RedefinableTemplateSignature_redefinableTemplateSignature_reference_extendedSignature_RedefinableTemplateSignature
  (from: UMLRedefinableTemplateSignature[Uml],
   to: Set[UMLRedefinableTemplateSignature[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ReduceAction_reduceAction_compose_collection_InputPin
  (from: UMLReduceAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReduceAction_reduceAction_reference_reducer_Behavior
  (from: UMLReduceAction[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReduceAction_reduceAction_compose_result_OutputPin
  (from: UMLReduceAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_ReduceAction_isOrdered
  (e: UMLReduceAction[Uml], isOrdered: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Region_region_reference_extendedRegion_Region
  (from: UMLRegion[Uml],
   to: Option[UMLRegion[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Region_container_compose_subvertex_Vertex
  (from: UMLRegion[Uml],
   to: Set[UMLVertex[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Region_container_compose_transition_Transition
  (from: UMLRegion[Uml],
   to: Set[UMLTransition[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_compose_removeAt_InputPin
  (from: UMLRemoveStructuralFeatureValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_RemoveStructuralFeatureValueAction_isRemoveDuplicates
  (e: UMLRemoveStructuralFeatureValueAction[Uml], isRemoveDuplicates: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_RemoveVariableValueAction_removeVariableValueAction_compose_removeAt_InputPin
  (from: UMLRemoveVariableValueAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_RemoveVariableValueAction_isRemoveDuplicates
  (e: UMLRemoveVariableValueAction[Uml], isRemoveDuplicates: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ReplyAction_replyAction_reference_replyToCall_Trigger
  (from: UMLReplyAction[Uml],
   to: Option[UMLTrigger[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReplyAction_replyAction_compose_replyValue_InputPin
  (from: UMLReplyAction[Uml],
   to: Seq[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ReplyAction_replyAction_compose_returnInformation_InputPin
  (from: UMLReplyAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_SendObjectAction_sendObjectAction_compose_request_InputPin
  (from: UMLSendObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_SendObjectAction_sendObjectAction_compose_target_InputPin
  (from: UMLSendObjectAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_SendSignalAction_sendSignalAction_reference_signal_Signal
  (from: UMLSendSignalAction[Uml],
   to: Option[UMLSignal[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_SendSignalAction_sendSignalAction_compose_target_InputPin
  (from: UMLSendSignalAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_SequenceNode_sequenceNode_compose_executableNode_ExecutableNode
  (from: UMLSequenceNode[Uml],
   to: Seq[UMLExecutableNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Signal_owningSignal_compose_ownedAttribute_Property
  (from: UMLSignal[Uml],
   to: Seq[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_SignalEvent_signalEvent_reference_signal_Signal
  (from: UMLSignalEvent[Uml],
   to: Option[UMLSignal[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Slot_slot_reference_definingFeature_StructuralFeature
  (from: UMLSlot[Uml],
   to: Option[UMLStructuralFeature[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Slot_owningSlot_compose_value_ValueSpecification
  (from: UMLSlot[Uml],
   to: Seq[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_StartClassifierBehaviorAction_startClassifierBehaviorAction_compose_object_InputPin
  (from: UMLStartClassifierBehaviorAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_StartObjectBehaviorAction_startObjectBehaviorAction_compose_object_InputPin
  (from: UMLStartObjectBehaviorAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_State_state_compose_connection_ConnectionPointReference
  (from: UMLState[Uml],
   to: Set[UMLConnectionPointReference[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_State_state_compose_connectionPoint_Pseudostate
  (from: UMLState[Uml],
   to: Set[UMLPseudostate[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_State_state_compose_deferrableTrigger_Trigger
  (from: UMLState[Uml],
   to: Set[UMLTrigger[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_State_state_compose_doActivity_Behavior
  (from: UMLState[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_State_state_compose_entry_Behavior
  (from: UMLState[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_State_state_compose_exit_Behavior
  (from: UMLState[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_State_state_reference_redefinedState_State
  (from: UMLState[Uml],
   to: Option[UMLState[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_State_state_compose_region_Region
  (from: UMLState[Uml],
   to: Set[UMLRegion[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_State_owningState_compose_stateInvariant_Constraint
  (from: UMLState[Uml],
   to: Option[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_State_submachineState_reference_submachine_StateMachine
  (from: UMLState[Uml],
   to: Option[UMLStateMachine[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_StateInvariant_stateInvariant_reference_covered_Lifeline
  (from: UMLStateInvariant[Uml],
   to: Iterable[UMLLifeline[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_StateInvariant_stateInvariant_compose_invariant_Constraint
  (from: UMLStateInvariant[Uml],
   to: Option[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_StateMachine_stateMachine_compose_connectionPoint_Pseudostate
  (from: UMLStateMachine[Uml],
   to: Set[UMLPseudostate[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_StateMachine_stateMachine_reference_extendedStateMachine_StateMachine
  (from: UMLStateMachine[Uml],
   to: Set[UMLStateMachine[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_StateMachine_stateMachine_compose_region_Region
  (from: UMLStateMachine[Uml],
   to: Set[UMLRegion[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_StateMachine_submachine_reference_submachineState_State
  (from: UMLStateMachine[Uml],
   to: Set[UMLState[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Stereotype_stereotype_compose_icon_Image
  (from: UMLStereotype[Uml],
   to: Set[UMLImage[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_StringExpression_owningExpression_compose_subExpression_StringExpression
  (from: UMLStringExpression[Uml],
   to: Seq[UMLStringExpression[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def set_StructuralFeature_isReadOnly
  (e: UMLStructuralFeature[Uml], isReadOnly: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_StructuralFeatureAction_structuralFeatureAction_compose_object_InputPin
  (from: UMLStructuralFeatureAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_StructuralFeatureAction_structuralFeatureAction_reference_structuralFeature_StructuralFeature
  (from: UMLStructuralFeatureAction[Uml],
   to: Option[UMLStructuralFeature[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLActivityEdge[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLActivityNode[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_StructuredActivityNode_scope_compose_variable_Variable
  (from: UMLStructuredActivityNode[Uml],
   to: Set[UMLVariable[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_StructuredActivityNode_mustIsolate
  (e: UMLStructuredActivityNode[Uml], mustIsolate: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property
  (from: UMLStructuredClassifier[Uml],
   to: Seq[UMLProperty[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector
  (from: UMLStructuredClassifier[Uml],
   to: Set[UMLConnector[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Substitution_substitution_reference_contract_Classifier
  (from: UMLSubstitution[Uml],
   to: Option[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_TemplateBinding_templateBinding_compose_parameterSubstitution_TemplateParameterSubstitution
  (from: UMLTemplateBinding[Uml],
   to: Set[UMLTemplateParameterSubstitution[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_TemplateBinding_templateBinding_reference_signature_TemplateSignature
  (from: UMLTemplateBinding[Uml],
   to: Option[UMLTemplateSignature[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_TemplateParameter_templateParameter_reference_default_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_TemplateParameter_templateParameter_compose_ownedDefault_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_TemplateParameter_owningTemplateParameter_compose_ownedParameteredElement_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_TemplateParameter_templateParameter_reference_parameteredElement_ParameterableElement
  (from: UMLTemplateParameter[Uml],
   to: Option[UMLParameterableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_TemplateParameterSubstitution_templateParameterSubstitution_reference_actual_ParameterableElement
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLParameterableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_TemplateParameterSubstitution_templateParameterSubstitution_reference_formal_TemplateParameter
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLTemplateParameter[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_TemplateParameterSubstitution_owningTemplateParameterSubstitution_compose_ownedActual_ParameterableElement
  (from: UMLTemplateParameterSubstitution[Uml],
   to: Option[UMLParameterableElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_TemplateSignature_signature_compose_ownedParameter_TemplateParameter
  (from: UMLTemplateSignature[Uml],
   to: Seq[UMLTemplateParameter[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_TemplateSignature_templateSignature_reference_parameter_TemplateParameter
  (from: UMLTemplateSignature[Uml],
   to: Seq[UMLTemplateParameter[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature
  (from: UMLTemplateableElement[Uml],
   to: Option[UMLTemplateSignature[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding
  (from: UMLTemplateableElement[Uml],
   to: Set[UMLTemplateBinding[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_TestIdentityAction_testIdentityAction_compose_first_InputPin
  (from: UMLTestIdentityAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_TestIdentityAction_testIdentityAction_compose_result_OutputPin
  (from: UMLTestIdentityAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_TestIdentityAction_testIdentityAction_compose_second_InputPin
  (from: UMLTestIdentityAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_TimeConstraint_timeConstraint_compose_specification_TimeInterval
  (from: UMLTimeConstraint[Uml],
   to: Option[UMLTimeInterval[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_TimeConstraint_firstEvent
  (e: UMLTimeConstraint[Uml], firstEvent: Option[Boolean]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_TimeEvent_timeEvent_compose_when_TimeExpression
  (from: UMLTimeEvent[Uml],
   to: Option[UMLTimeExpression[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_TimeEvent_isRelative
  (e: UMLTimeEvent[Uml], isRelative: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_TimeExpression_timeExpression_compose_expr_ValueSpecification
  (from: UMLTimeExpression[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_TimeExpression_timeExpression_reference_observation_Observation
  (from: UMLTimeExpression[Uml],
   to: Set[UMLObservation[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_TimeInterval_timeInterval_reference_max_TimeExpression
  (from: UMLTimeInterval[Uml],
   to: Option[UMLTimeExpression[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_TimeInterval_timeInterval_reference_min_TimeExpression
  (from: UMLTimeInterval[Uml],
   to: Option[UMLTimeExpression[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_TimeObservation_timeObservation_reference_event_NamedElement
  (from: UMLTimeObservation[Uml],
   to: Option[UMLNamedElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_TimeObservation_firstEvent
  (e: UMLTimeObservation[Uml], firstEvent: Boolean): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Transition_transition_compose_effect_Behavior
  (from: UMLTransition[Uml],
   to: Option[UMLBehavior[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Transition_transition_compose_guard_Constraint
  (from: UMLTransition[Uml],
   to: Option[UMLConstraint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Transition_transition_reference_redefinedTransition_Transition
  (from: UMLTransition[Uml],
   to: Option[UMLTransition[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Transition_transition_compose_trigger_Trigger
  (from: UMLTransition[Uml],
   to: Set[UMLTrigger[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def set_Transition_kind
  (e: UMLTransition[Uml], kind: Option[UMLTransitionKind.Value]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_Trigger_trigger_reference_event_Event
  (from: UMLTrigger[Uml],
   to: Option[UMLEvent[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_Trigger_trigger_reference_port_Port
  (from: UMLTrigger[Uml],
   to: Set[UMLPort[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_TypedElement_typedElement_reference_type_Type
  (from: UMLTypedElement[Uml],
   to: Option[UMLType[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_UnmarshallAction_unmarshallAction_compose_object_InputPin
  (from: UMLUnmarshallAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_UnmarshallAction_unmarshallAction_compose_result_OutputPin
  (from: UMLUnmarshallAction[Uml],
   to: Seq[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_UnmarshallAction_unmarshallAction_reference_unmarshallType_Classifier
  (from: UMLUnmarshallAction[Uml],
   to: Option[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_UseCase_extension_compose_extend_Extend
  (from: UMLUseCase[Uml],
   to: Set[UMLExtend[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_UseCase_useCase_compose_extensionPoint_ExtensionPoint
  (from: UMLUseCase[Uml],
   to: Set[UMLExtensionPoint[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_UseCase_includingCase_compose_include_Include
  (from: UMLUseCase[Uml],
   to: Set[UMLInclude[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_UseCase_useCase_reference_subject_Classifier
  (from: UMLUseCase[Uml],
   to: Set[UMLClassifier[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_ValuePin_valuePin_compose_value_ValueSpecification
  (from: UMLValuePin[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_ValueSpecificationAction_valueSpecificationAction_compose_result_OutputPin
  (from: UMLValueSpecificationAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_ValueSpecificationAction_valueSpecificationAction_compose_value_ValueSpecification
  (from: UMLValueSpecificationAction[Uml],
   to: Option[UMLValueSpecification[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]


  def links_VariableAction_variableAction_reference_variable_Variable
  (from: UMLVariableAction[Uml],
   to: Option[UMLVariable[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]



  def links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_result_OutputPin
  (from: UMLWriteStructuralFeatureAction[Uml],
   to: Option[UMLOutputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  def links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_value_InputPin
  (from: UMLWriteStructuralFeatureAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  def links_WriteVariableAction_writeVariableAction_compose_value_InputPin
  (from: UMLWriteVariableAction[Uml],
   to: Option[UMLInputPin[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]

  // was: MetaPropertyReference2LinksUpdate: Seq of CompositeReferenceUpdater
  val AssociationMetaPropertyOption2LinksUpdate
  : Seq[AssociationMetaPropertyOptionUpdater]
  = Seq() :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Abstraction_abstraction_compose_mapping_OpaqueExpression _,
        ops.Abstraction_mapping) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_AcceptCallAction_acceptCallAction_compose_returnInformation_OutputPin _,
        ops.AcceptCallAction_returnInformation) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActionExecutionSpecification_actionExecutionSpecification_reference_action_Action _,
        ops.ActionExecutionSpecification_action) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActionInputPin_actionInputPin_compose_fromAction_Action _,
        ops.ActionInputPin_fromAction) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityEdge_activityEdge_compose_guard_ValueSpecification _,
        ops.ActivityEdge_guard) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityEdge_interruptingEdge_reference_interrupts_InterruptibleActivityRegion _,
        ops.ActivityEdge_interrupts) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityEdge_outgoing_reference_source_ActivityNode _,
        ops.ActivityEdge_source) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityEdge_incoming_reference_target_ActivityNode _,
        ops.ActivityEdge_target) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityEdge_activityEdge_compose_weight_ValueSpecification _,
        ops.ActivityEdge_weight) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityParameterNode_activityParameterNode_reference_parameter_Parameter _,
        ops.ActivityParameterNode_parameter) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ActivityPartition_activityPartition_reference_represents_Element _,
        ops.ActivityPartition_represents) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_AddStructuralFeatureValueAction_addStructuralFeatureValueAction_compose_insertAt_InputPin _,
        ops.AddStructuralFeatureValueAction_insertAt) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_AddVariableValueAction_addVariableValueAction_compose_insertAt_InputPin _,
        ops.AddVariableValueAction_insertAt) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Behavior_method_reference_specification_BehavioralFeature _,
        ops.Behavior_specification) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_BehaviorExecutionSpecification_behaviorExecutionSpecification_reference_behavior_Behavior _,
        ops.BehaviorExecutionSpecification_behavior) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_BehavioredClassifier_behavioredClassifier_reference_classifierBehavior_Behavior _,
        ops.BehavioredClassifier_classifierBehavior) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_BroadcastSignalAction_broadcastSignalAction_reference_signal_Signal _,
        ops.BroadcastSignalAction_signal) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CallBehaviorAction_callBehaviorAction_reference_behavior_Behavior _,
        ops.CallBehaviorAction_behavior) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CallEvent_callEvent_reference_operation_Operation _,
        ops.CallEvent_operation) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CallOperationAction_callOperationAction_reference_operation_Operation _,
        ops.CallOperationAction_operation) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CallOperationAction_callOperationAction_compose_target_InputPin _,
        ops.CallOperationAction_target) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ChangeEvent_changeEvent_compose_changeExpression_ValueSpecification _,
        ops.ChangeEvent_changeExpression) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Classifier_classifier_compose_ownedTemplateSignature_RedefinableTemplateSignature _,
        ops.Classifier_ownedTemplateSignature) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Classifier_classifier_reference_representation_CollaborationUse _,
        ops.Classifier_representation) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Classifier_parameteredElement_reference_templateParameter_ClassifierTemplateParameter _,
        ops.Classifier_templateParameter) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ClassifierTemplateParameter_templateParameter_reference_parameteredElement_Classifier _,
        ops.ClassifierTemplateParameter_parameteredElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Clause_clause_reference_decider_OutputPin _,
        ops.Clause_decider) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ClearAssociationAction_clearAssociationAction_reference_association_Association _,
        ops.ClearAssociationAction_association) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ClearAssociationAction_clearAssociationAction_compose_object_InputPin _,
        ops.ClearAssociationAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ClearStructuralFeatureAction_clearStructuralFeatureAction_compose_result_OutputPin _,
        ops.ClearStructuralFeatureAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CollaborationUse_collaborationUse_reference_type_Collaboration _,
        ops.CollaborationUse_type) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ConnectableElement_parameteredElement_reference_templateParameter_ConnectableElementTemplateParameter _,
        ops.ConnectableElement_templateParameter) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ConnectableElementTemplateParameter_templateParameter_reference_parameteredElement_ConnectableElement _,
        ops.ConnectableElementTemplateParameter_parameteredElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Connector_connector_reference_type_Association _,
        ops.Connector_type) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ConnectorEnd_connectorEnd_reference_partWithPort_Property _,
        ops.ConnectorEnd_partWithPort) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Constraint_owningConstraint_compose_specification_ValueSpecification _,
        ops.Constraint_specification) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CreateLinkObjectAction_createLinkObjectAction_compose_result_OutputPin _,
        ops.CreateLinkObjectAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CreateObjectAction_createObjectAction_reference_classifier_Classifier _,
        ops.CreateObjectAction_classifier) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_CreateObjectAction_createObjectAction_compose_result_OutputPin _,
        ops.CreateObjectAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_DecisionNode_decisionNode_reference_decisionInput_Behavior _,
        ops.DecisionNode_decisionInput) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_DecisionNode_decisionNode_reference_decisionInputFlow_ObjectFlow _,
        ops.DecisionNode_decisionInputFlow) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_DestroyObjectAction_destroyObjectAction_compose_target_InputPin _,
        ops.DestroyObjectAction_target) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Duration_duration_compose_expr_ValueSpecification _,
        ops.Duration_expr) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_DurationConstraint_durationConstraint_compose_specification_DurationInterval _,
        ops.DurationConstraint_specification) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_DurationInterval_durationInterval_reference_max_Duration _,
        ops.DurationInterval_max) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_DurationInterval_durationInterval_reference_min_Duration _,
        ops.DurationInterval_min) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ElementImport_import_reference_importedElement_PackageableElement _,
        ops.ElementImport_importedElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExceptionHandler_exceptionHandler_reference_exceptionInput_ObjectNode _,
        ops.ExceptionHandler_exceptionInput) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExceptionHandler_exceptionHandler_reference_handlerBody_ExecutableNode _,
        ops.ExceptionHandler_handlerBody) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExecutionOccurrenceSpecification_executionOccurrenceSpecification_reference_execution_ExecutionSpecification _,
        ops.ExecutionOccurrenceSpecification_execution) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExecutionSpecification_executionSpecification_reference_finish_OccurrenceSpecification _,
        ops.ExecutionSpecification_finish) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExecutionSpecification_executionSpecification_reference_start_OccurrenceSpecification _,
        ops.ExecutionSpecification_start) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExpansionNode_inputElement_reference_regionAsInput_ExpansionRegion _,
        ops.ExpansionNode_regionAsInput) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExpansionNode_outputElement_reference_regionAsOutput_ExpansionRegion _,
        ops.ExpansionNode_regionAsOutput) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Extend_extend_compose_condition_Constraint _,
        ops.Extend_condition) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Extend_extend_reference_extendedCase_UseCase _,
        ops.Extend_extendedCase) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ExtensionEnd_extensionEnd_reference_type_Stereotype _,
        ops.ExtensionEnd_type) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_GeneralOrdering_toBefore_reference_after_OccurrenceSpecification _,
        ops.GeneralOrdering_after) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_GeneralOrdering_toAfter_reference_before_OccurrenceSpecification _,
        ops.GeneralOrdering_before) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Generalization_generalization_reference_general_Classifier _,
        ops.Generalization_general) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_GeneralizationSet_powertypeExtent_reference_powertype_Classifier _,
        ops.GeneralizationSet_powertype) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Include_include_reference_addition_UseCase _,
        ops.Include_addition) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InstanceSpecification_owningInstanceSpec_compose_specification_ValueSpecification _,
        ops.InstanceSpecification_specification) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InstanceValue_instanceValue_reference_instance_InstanceSpecification _,
        ops.InstanceValue_instance) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InteractionConstraint_interactionConstraint_compose_maxint_ValueSpecification _,
        ops.InteractionConstraint_maxint) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InteractionConstraint_interactionConstraint_compose_minint_ValueSpecification _,
        ops.InteractionConstraint_minint) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InteractionOperand_interactionOperand_compose_guard_InteractionConstraint _,
        ops.InteractionOperand_guard) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InteractionUse_interactionUse_reference_refersTo_Interaction _,
        ops.InteractionUse_refersTo) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InteractionUse_interactionUse_compose_returnValue_ValueSpecification _,
        ops.InteractionUse_returnValue) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InteractionUse_interactionUse_reference_returnValueRecipient_Property _,
        ops.InteractionUse_returnValueRecipient) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Interface_interface_compose_protocol_ProtocolStateMachine _,
        ops.Interface_protocol) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InterfaceRealization_interfaceRealization_reference_contract_Interface _,
        ops.InterfaceRealization_contract) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Interval_interval_reference_max_ValueSpecification _,
        ops.Interval_max) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Interval_interval_reference_min_ValueSpecification _,
        ops.Interval_min) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_IntervalConstraint_intervalConstraint_compose_specification_Interval _,
        ops.IntervalConstraint_specification) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_InvocationAction_invocationAction_reference_onPort_Port _,
        ops.InvocationAction_onPort) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_JoinNode_joinNode_compose_joinSpec_ValueSpecification _,
        ops.JoinNode_joinSpec) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Lifeline_lifeline_reference_decomposedAs_PartDecomposition _,
        ops.Lifeline_decomposedAs) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Lifeline_lifeline_reference_represents_ConnectableElement _,
        ops.Lifeline_represents) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Lifeline_lifeline_compose_selector_ValueSpecification _,
        ops.Lifeline_selector) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_LinkEndCreationData_linkEndCreationData_reference_insertAt_InputPin _,
        ops.LinkEndCreationData_insertAt) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_LinkEndData_linkEndData_reference_end_Property _,
        ops.LinkEndData_end) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_LinkEndData_linkEndData_reference_value_InputPin _,
        ops.LinkEndData_value) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_LinkEndDestructionData_linkEndDestructionData_reference_destroyAt_InputPin _,
        ops.LinkEndDestructionData_destroyAt) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_LoopNode_loopNode_reference_decider_OutputPin _,
        ops.LoopNode_decider) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Manifestation_manifestation_reference_utilizedElement_PackageableElement _,
        ops.Manifestation_utilizedElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Message_message_reference_connector_Connector _,
        ops.Message_connector) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Message_endMessage_reference_receiveEvent_MessageEnd _,
        ops.Message_receiveEvent) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Message_endMessage_reference_sendEvent_MessageEnd _,
        ops.Message_sendEvent) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Message_message_reference_signature_NamedElement _,
        ops.Message_signature) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_MessageEnd_messageEnd_reference_message_Message _,
        ops.MessageEnd_message) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_MultiplicityElement_owningLower_compose_lowerValue_ValueSpecification _,
        ops.MultiplicityElement_lowerValue) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_MultiplicityElement_owningUpper_compose_upperValue_ValueSpecification _,
        ops.MultiplicityElement_upperValue) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_NamedElement_namedElement_compose_nameExpression_StringExpression _,
        ops.NamedElement_nameExpression) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ObjectFlow_objectFlow_reference_selection_Behavior _,
        ops.ObjectFlow_selection) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ObjectFlow_objectFlow_reference_transformation_Behavior _,
        ops.ObjectFlow_transformation) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ObjectNode_objectNode_reference_selection_Behavior _,
        ops.ObjectNode_selection) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ObjectNode_objectNode_compose_upperBound_ValueSpecification _,
        ops.ObjectNode_upperBound) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_OpaqueExpression_opaqueExpression_reference_behavior_Behavior _,
        ops.OpaqueExpression_behavior) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Operation_bodyContext_compose_bodyCondition_Constraint _,
        ops.Operation_bodyCondition) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Operation_parameteredElement_reference_templateParameter_OperationTemplateParameter _,
        ops.Operation_templateParameter) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_OperationTemplateParameter_templateParameter_reference_parameteredElement_Operation _,
        ops.OperationTemplateParameter_parameteredElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_PackageImport_packageImport_reference_importedPackage_Package _,
        ops.PackageImport_importedPackage) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_PackageMerge_packageMerge_reference_mergedPackage_Package _,
        ops.PackageMerge_mergedPackage) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Parameter_owningParameter_compose_defaultValue_ValueSpecification _,
        ops.Parameter_defaultValue) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ParameterableElement_parameteredElement_reference_templateParameter_TemplateParameter _,
        ops.ParameterableElement_templateParameter) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Port_port_reference_protocol_ProtocolStateMachine _,
        ops.Port_protocol) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ProfileApplication_profileApplication_reference_appliedProfile_Profile _,
        ops.ProfileApplication_appliedProfile) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Property_memberEnd_reference_association_Association _,
        ops.Property_association) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Property_owningProperty_compose_defaultValue_ValueSpecification _,
        ops.Property_defaultValue) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ProtocolConformance_protocolConformance_reference_generalMachine_ProtocolStateMachine _,
        ops.ProtocolConformance_generalMachine) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ProtocolTransition_owningTransition_compose_postCondition_Constraint _,
        ops.ProtocolTransition_postCondition) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ProtocolTransition_protocolTransition_compose_preCondition_Constraint _,
        ops.ProtocolTransition_preCondition) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_QualifierValue_qualifierValue_reference_qualifier_Property _,
        ops.QualifierValue_qualifier) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_QualifierValue_qualifierValue_reference_value_InputPin _,
        ops.QualifierValue_value) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_RaiseExceptionAction_raiseExceptionAction_compose_exception_InputPin _,
        ops.RaiseExceptionAction_exception) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadExtentAction_readExtentAction_reference_classifier_Classifier _,
        ops.ReadExtentAction_classifier) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadExtentAction_readExtentAction_compose_result_OutputPin _,
        ops.ReadExtentAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_reference_classifier_Classifier _,
        ops.ReadIsClassifiedObjectAction_classifier) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_object_InputPin _,
        ops.ReadIsClassifiedObjectAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_result_OutputPin _,
        ops.ReadIsClassifiedObjectAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkAction_readLinkAction_compose_result_OutputPin _,
        ops.ReadLinkAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkObjectEndAction_readLinkObjectEndAction_reference_end_Property _,
        ops.ReadLinkObjectEndAction_end) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_object_InputPin _,
        ops.ReadLinkObjectEndAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkObjectEndAction_readLinkObjectEndAction_compose_result_OutputPin _,
        ops.ReadLinkObjectEndAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_object_InputPin _,
        ops.ReadLinkObjectEndQualifierAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_reference_qualifier_Property _,
        ops.ReadLinkObjectEndQualifierAction_qualifier) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadLinkObjectEndQualifierAction_readLinkObjectEndQualifierAction_compose_result_OutputPin _,
        ops.ReadLinkObjectEndQualifierAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadSelfAction_readSelfAction_compose_result_OutputPin _,
        ops.ReadSelfAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadStructuralFeatureAction_readStructuralFeatureAction_compose_result_OutputPin _,
        ops.ReadStructuralFeatureAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReadVariableAction_readVariableAction_compose_result_OutputPin _,
        ops.ReadVariableAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Reception_reception_reference_signal_Signal _,
        ops.Reception_signal) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReclassifyObjectAction_reclassifyObjectAction_compose_object_InputPin _,
        ops.ReclassifyObjectAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReduceAction_reduceAction_compose_collection_InputPin _,
        ops.ReduceAction_collection) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReduceAction_reduceAction_reference_reducer_Behavior _,
        ops.ReduceAction_reducer) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReduceAction_reduceAction_compose_result_OutputPin _,
        ops.ReduceAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Region_region_reference_extendedRegion_Region _,
        ops.Region_extendedRegion) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_RemoveStructuralFeatureValueAction_removeStructuralFeatureValueAction_compose_removeAt_InputPin _,
        ops.RemoveStructuralFeatureValueAction_removeAt) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_RemoveVariableValueAction_removeVariableValueAction_compose_removeAt_InputPin _,
        ops.RemoveVariableValueAction_removeAt) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReplyAction_replyAction_reference_replyToCall_Trigger _,
        ops.ReplyAction_replyToCall) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ReplyAction_replyAction_compose_returnInformation_InputPin _,
        ops.ReplyAction_returnInformation) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_SendObjectAction_sendObjectAction_compose_request_InputPin _,
        ops.SendObjectAction_request) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_SendObjectAction_sendObjectAction_compose_target_InputPin _,
        ops.SendObjectAction_target) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_SendSignalAction_sendSignalAction_reference_signal_Signal _,
        ops.SendSignalAction_signal) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_SendSignalAction_sendSignalAction_compose_target_InputPin _,
        ops.SendSignalAction_target) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_SignalEvent_signalEvent_reference_signal_Signal _,
        ops.SignalEvent_signal) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Slot_slot_reference_definingFeature_StructuralFeature _,
        ops.Slot_definingFeature) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_StartClassifierBehaviorAction_startClassifierBehaviorAction_compose_object_InputPin _,
        ops.StartClassifierBehaviorAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_StartObjectBehaviorAction_startObjectBehaviorAction_compose_object_InputPin _,
        ops.StartObjectBehaviorAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_State_state_compose_doActivity_Behavior _,
        ops.State_doActivity) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_State_state_compose_entry_Behavior _,
        ops.State_entry) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_State_state_compose_exit_Behavior _,
        ops.State_exit) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_State_state_reference_redefinedState_State _,
        ops.State_redefinedState) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_State_owningState_compose_stateInvariant_Constraint _,
        ops.State_stateInvariant) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_State_submachineState_reference_submachine_StateMachine _,
        ops.State_submachine) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_StateInvariant_stateInvariant_compose_invariant_Constraint _,
        ops.StateInvariant_invariant) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_StructuralFeatureAction_structuralFeatureAction_compose_object_InputPin _,
        ops.StructuralFeatureAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_StructuralFeatureAction_structuralFeatureAction_reference_structuralFeature_StructuralFeature _,
        ops.StructuralFeatureAction_structuralFeature) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Substitution_substitution_reference_contract_Classifier _,
        ops.Substitution_contract) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateBinding_templateBinding_reference_signature_TemplateSignature _,
        ops.TemplateBinding_signature) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameter_templateParameter_reference_default_ParameterableElement _,
        ops.TemplateParameter_default) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameter_templateParameter_compose_ownedDefault_ParameterableElement _,
        ops.TemplateParameter_ownedDefault) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameter_owningTemplateParameter_compose_ownedParameteredElement_ParameterableElement _,
        ops.TemplateParameter_ownedParameteredElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameter_templateParameter_reference_parameteredElement_ParameterableElement _,
        ops.TemplateParameter_parameteredElement) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameterSubstitution_templateParameterSubstitution_reference_actual_ParameterableElement _,
        ops.TemplateParameterSubstitution_actual) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameterSubstitution_templateParameterSubstitution_reference_formal_TemplateParameter _,
        ops.TemplateParameterSubstitution_formal) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateParameterSubstitution_owningTemplateParameterSubstitution_compose_ownedActual_ParameterableElement _,
        ops.TemplateParameterSubstitution_ownedActual) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TemplateableElement_template_compose_ownedTemplateSignature_TemplateSignature _,
        ops.TemplateableElement_ownedTemplateSignature) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TestIdentityAction_testIdentityAction_compose_first_InputPin _,
        ops.TestIdentityAction_first) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TestIdentityAction_testIdentityAction_compose_result_OutputPin _,
        ops.TestIdentityAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TestIdentityAction_testIdentityAction_compose_second_InputPin _,
        ops.TestIdentityAction_second) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TimeConstraint_timeConstraint_compose_specification_TimeInterval _,
        ops.TimeConstraint_specification) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TimeEvent_timeEvent_compose_when_TimeExpression _,
        ops.TimeEvent_when) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TimeExpression_timeExpression_compose_expr_ValueSpecification _,
        ops.TimeExpression_expr) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TimeInterval_timeInterval_reference_max_TimeExpression _,
        ops.TimeInterval_max) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TimeInterval_timeInterval_reference_min_TimeExpression _,
        ops.TimeInterval_min) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TimeObservation_timeObservation_reference_event_NamedElement _,
        ops.TimeObservation_event) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Transition_transition_compose_effect_Behavior _,
        ops.Transition_effect) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Transition_transition_compose_guard_Constraint _,
        ops.Transition_guard) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Transition_transition_reference_redefinedTransition_Transition _,
        ops.Transition_redefinedTransition) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_Trigger_trigger_reference_event_Event _,
        ops.Trigger_event) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_TypedElement_typedElement_reference_type_Type _,
        ops.TypedElement_type) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_UnmarshallAction_unmarshallAction_compose_object_InputPin _,
        ops.UnmarshallAction_object) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_UnmarshallAction_unmarshallAction_reference_unmarshallType_Classifier _,
        ops.UnmarshallAction_unmarshallType) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ValuePin_valuePin_compose_value_ValueSpecification _,
        ops.ValuePin_value) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ValueSpecificationAction_valueSpecificationAction_compose_result_OutputPin _,
        ops.ValueSpecificationAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_ValueSpecificationAction_valueSpecificationAction_compose_value_ValueSpecification _,
        ops.ValueSpecificationAction_value) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_VariableAction_variableAction_reference_variable_Variable _,
        ops.VariableAction_variable) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_result_OutputPin _,
        ops.WriteStructuralFeatureAction_result) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_WriteStructuralFeatureAction_writeStructuralFeatureAction_compose_value_InputPin _,
        ops.WriteStructuralFeatureAction_value) :+
    AssociationMetaPropertyOptionUpdateInfo(
        links_WriteVariableAction_writeVariableAction_compose_value_InputPin _,
        ops.WriteVariableAction_value)
  // was: MetaPropertyIterable2LinksUpdate
  val AssociationMetaPropertyIterable2LinksUpdate
  : Seq[AssociationMetaPropertyIterableUpdater]
  = Seq() :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_Association_owningAssociation_compose_ownedEnd_Property _,
        ops.Association_ownedEnd) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_CreateLinkAction_createLinkAction_compose_endData_LinkEndCreationData _,
        ops.CreateLinkAction_endData) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_DestroyLinkAction_destroyLinkAction_compose_endData_LinkEndDestructionData _,
        ops.DestroyLinkAction_endData) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_Extension_extension_compose_ownedEnd_ExtensionEnd _,
        ops.Extension_ownedEnd) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_InstanceSpecification_instanceSpecification_reference_classifier_Classifier _,
        ops.InstanceSpecification_classifier) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_InteractionFragment_coveredBy_reference_covered_Lifeline _,
        ops.InteractionFragment_covered) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_LinkAction_linkAction_compose_endData_LinkEndData _,
        ops.LinkAction_endData) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_OccurrenceSpecification_events_reference_covered_Lifeline _,
        ops.OccurrenceSpecification_covered) :+
      AssociationMetaPropertyIterableUpdateInfo(
        links_StateInvariant_stateInvariant_reference_covered_Lifeline _,
        ops.StateInvariant_covered)
  // was: MetaPropertySequence2LinksUpdate
  val AssociationMetaPropertySequence2LinksUpdate
  : Seq[AssociationMetaPropertySequenceUpdater]
  = Seq() :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_AcceptEventAction_acceptEventAction_compose_result_OutputPin _,
        ops.AcceptEventAction_result) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Artifact_artifact_compose_ownedAttribute_Property _,
        ops.Artifact_ownedAttribute) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Artifact_artifact_compose_ownedOperation_Operation _,
        ops.Artifact_ownedOperation) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Association_association_reference_memberEnd_Property _,
        ops.Association_memberEnd) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Behavior_behavior_compose_ownedParameter_Parameter _,
        ops.Behavior_ownedParameter) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_BehavioralFeature_ownerFormalParam_compose_ownedParameter_Parameter _,
        ops.BehavioralFeature_ownedParameter) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_CallAction_callAction_compose_result_OutputPin _,
        ops.CallAction_result) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Class_nestingClass_compose_nestedClassifier_Classifier _,
        ops.Class_nestedClassifier) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Class_class_compose_ownedAttribute_Property _,
        ops.Class_ownedAttribute) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Class_class_compose_ownedOperation_Operation _,
        ops.Class_ownedOperation) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Clause_clause_reference_bodyOutput_OutputPin _,
        ops.Clause_bodyOutput) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_CombinedFragment_combinedFragment_compose_operand_InteractionOperand _,
        ops.CombinedFragment_operand) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_ConditionalNode_conditionalNode_compose_result_OutputPin _,
        ops.ConditionalNode_result) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Connector_connector_compose_end_ConnectorEnd _,
        ops.Connector_end) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Constraint_constraint_reference_constrainedElement_Element _,
        ops.Constraint_constrainedElement) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_DataType_datatype_compose_ownedAttribute_Property _,
        ops.DataType_ownedAttribute) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_DataType_datatype_compose_ownedOperation_Operation _,
        ops.DataType_ownedOperation) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_DurationObservation_durationObservation_reference_event_NamedElement _,
        ops.DurationObservation_event) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Enumeration_enumeration_compose_ownedLiteral_EnumerationLiteral _,
        ops.Enumeration_ownedLiteral) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Expression_expression_compose_operand_ValueSpecification _,
        ops.Expression_operand) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Extend_extension_reference_extensionLocation_ExtensionPoint _,
        ops.Extend_extensionLocation) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Interaction_enclosingInteraction_compose_fragment_InteractionFragment _,
        ops.Interaction_fragment) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_InteractionOperand_enclosingOperand_compose_fragment_InteractionFragment _,
        ops.InteractionOperand_fragment) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_InteractionUse_interactionUse_compose_argument_ValueSpecification _,
        ops.InteractionUse_argument) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Interface_interface_compose_nestedClassifier_Classifier _,
        ops.Interface_nestedClassifier) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Interface_interface_compose_ownedAttribute_Property _,
        ops.Interface_ownedAttribute) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Interface_interface_compose_ownedOperation_Operation _,
        ops.Interface_ownedOperation) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_InvocationAction_invocationAction_compose_argument_InputPin _,
        ops.InvocationAction_argument) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_LoopNode_loopNode_reference_bodyOutput_OutputPin _,
        ops.LoopNode_bodyOutput) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_LoopNode_loopNode_compose_loopVariable_OutputPin _,
        ops.LoopNode_loopVariable) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_LoopNode_loopNode_compose_loopVariableInput_InputPin _,
        ops.LoopNode_loopVariableInput) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_LoopNode_loopNode_compose_result_OutputPin _,
        ops.LoopNode_result) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Message_message_compose_argument_ValueSpecification _,
        ops.Message_argument) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Operation_operation_compose_ownedParameter_Parameter _,
        ops.Operation_ownedParameter) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Property_associationEnd_compose_qualifier_Property _,
        ops.Property_qualifier) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_ReplyAction_replyAction_compose_replyValue_InputPin _,
        ops.ReplyAction_replyValue) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_SequenceNode_sequenceNode_compose_executableNode_ExecutableNode _,
        ops.SequenceNode_executableNode) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Signal_owningSignal_compose_ownedAttribute_Property _,
        ops.Signal_ownedAttribute) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_Slot_owningSlot_compose_value_ValueSpecification _,
        ops.Slot_value) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_StringExpression_owningExpression_compose_subExpression_StringExpression _,
        ops.StringExpression_subExpression) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_StructuredClassifier_structuredClassifier_compose_ownedAttribute_Property _,
        ops.StructuredClassifier_ownedAttribute) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_TemplateSignature_signature_compose_ownedParameter_TemplateParameter _,
        ops.TemplateSignature_ownedParameter) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_TemplateSignature_templateSignature_reference_parameter_TemplateParameter _,
        ops.TemplateSignature_parameter) :+
      AssociationMetaPropertySequenceUpdateInfo(
        links_UnmarshallAction_unmarshallAction_compose_result_OutputPin _,
        ops.UnmarshallAction_result)
  // was: MetaPropertySet2LinksUpdate
  val AssociationMetaPropertySet2LinksUpdate
  : Seq[AssociationMetaPropertySetUpdater]
  = Seq() :+
      AssociationMetaPropertySetUpdateInfo(
        links_AcceptEventAction_acceptEventAction_compose_trigger_Trigger _,
        ops.AcceptEventAction_trigger) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Action_action_compose_localPostcondition_Constraint _,
        ops.Action_localPostcondition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Action_action_compose_localPrecondition_Constraint _,
        ops.Action_localPrecondition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Activity_activity_compose_edge_ActivityEdge _,
        ops.Activity_edge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Activity_inActivity_compose_group_ActivityGroup _,
        ops.Activity_group) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Activity_activity_compose_node_ActivityNode _,
        ops.Activity_node) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Activity_activity_reference_partition_ActivityPartition _,
        ops.Activity_partition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Activity_activity_compose_structuredNode_StructuredActivityNode _,
        ops.Activity_structuredNode) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Activity_activityScope_compose_variable_Variable _,
        ops.Activity_variable) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityEdge_edge_reference_inPartition_ActivityPartition _,
        ops.ActivityEdge_inPartition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityEdge_activityEdge_reference_redefinedEdge_ActivityEdge _,
        ops.ActivityEdge_redefinedEdge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityNode_node_reference_inInterruptibleRegion_InterruptibleActivityRegion _,
        ops.ActivityNode_inInterruptibleRegion) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityNode_node_reference_inPartition_ActivityPartition _,
        ops.ActivityNode_inPartition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityNode_target_reference_incoming_ActivityEdge _,
        ops.ActivityNode_incoming) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityNode_source_reference_outgoing_ActivityEdge _,
        ops.ActivityNode_outgoing) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityNode_activityNode_reference_redefinedNode_ActivityNode _,
        ops.ActivityNode_redefinedNode) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityPartition_inPartition_reference_edge_ActivityEdge _,
        ops.ActivityPartition_edge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityPartition_inPartition_reference_node_ActivityNode _,
        ops.ActivityPartition_node) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ActivityPartition_superPartition_compose_subpartition_ActivityPartition _,
        ops.ActivityPartition_subpartition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Artifact_artifact_compose_manifestation_Manifestation _,
        ops.Artifact_manifestation) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Artifact_artifact_compose_nestedArtifact_Artifact _,
        ops.Artifact_nestedArtifact) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Association_association_reference_navigableOwnedEnd_Property _,
        ops.Association_navigableOwnedEnd) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Behavior_behavior_compose_ownedParameterSet_ParameterSet _,
        ops.Behavior_ownedParameterSet) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Behavior_behavior_compose_postcondition_Constraint _,
        ops.Behavior_postcondition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Behavior_behavior_compose_precondition_Constraint _,
        ops.Behavior_precondition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Behavior_behavior_reference_redefinedBehavior_Behavior _,
        ops.Behavior_redefinedBehavior) :+
      AssociationMetaPropertySetUpdateInfo(
        links_BehavioralFeature_specification_reference_method_Behavior _,
        ops.BehavioralFeature_method) :+
      AssociationMetaPropertySetUpdateInfo(
        links_BehavioralFeature_behavioralFeature_compose_ownedParameterSet_ParameterSet _,
        ops.BehavioralFeature_ownedParameterSet) :+
      AssociationMetaPropertySetUpdateInfo(
        links_BehavioralFeature_behavioralFeature_reference_raisedException_Type _,
        ops.BehavioralFeature_raisedException) :+
      AssociationMetaPropertySetUpdateInfo(
        links_BehavioredClassifier_implementingClassifier_compose_interfaceRealization_InterfaceRealization _,
        ops.BehavioredClassifier_interfaceRealization) :+
      AssociationMetaPropertySetUpdateInfo(
        links_BehavioredClassifier_behavioredClassifier_compose_ownedBehavior_Behavior _,
        ops.BehavioredClassifier_ownedBehavior) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Class_class_compose_ownedReception_Reception _,
        ops.Class_ownedReception) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_classifier_compose_collaborationUse_CollaborationUse _,
        ops.Classifier_collaborationUse) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_specific_compose_generalization_Generalization _,
        ops.Classifier_generalization) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_classifier_compose_ownedUseCase_UseCase _,
        ops.Classifier_ownedUseCase) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_powertype_reference_powertypeExtent_GeneralizationSet _,
        ops.Classifier_powertypeExtent) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_classifier_reference_redefinedClassifier_Classifier _,
        ops.Classifier_redefinedClassifier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_substitutingClassifier_compose_substitution_Substitution _,
        ops.Classifier_substitution) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Classifier_subject_reference_useCase_UseCase _,
        ops.Classifier_useCase) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ClassifierTemplateParameter_classifierTemplateParameter_reference_constrainingClassifier_Classifier _,
        ops.ClassifierTemplateParameter_constrainingClassifier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Clause_clause_reference_body_ExecutableNode _,
        ops.Clause_body) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Clause_successorClause_reference_predecessorClause_Clause _,
        ops.Clause_predecessorClause) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Clause_predecessorClause_reference_successorClause_Clause _,
        ops.Clause_successorClause) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Clause_clause_reference_test_ExecutableNode _,
        ops.Clause_test) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Collaboration_collaboration_reference_collaborationRole_ConnectableElement _,
        ops.Collaboration_collaborationRole) :+
      AssociationMetaPropertySetUpdateInfo(
        links_CollaborationUse_collaborationUse_compose_roleBinding_Dependency _,
        ops.CollaborationUse_roleBinding) :+
      AssociationMetaPropertySetUpdateInfo(
        links_CombinedFragment_combinedFragment_compose_cfragmentGate_Gate _,
        ops.CombinedFragment_cfragmentGate) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Comment_comment_reference_annotatedElement_Element _,
        ops.Comment_annotatedElement) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Component_component_compose_packagedElement_PackageableElement _,
        ops.Component_packagedElement) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Component_abstraction_compose_realization_ComponentRealization _,
        ops.Component_realization) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ComponentRealization_componentRealization_reference_realizingClassifier_Classifier _,
        ops.ComponentRealization_realizingClassifier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ConditionalNode_conditionalNode_compose_clause_Clause _,
        ops.ConditionalNode_clause) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ConnectionPointReference_connectionPointReference_reference_entry_Pseudostate _,
        ops.ConnectionPointReference_entry) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ConnectionPointReference_connectionPointReference_reference_exit_Pseudostate _,
        ops.ConnectionPointReference_exit) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Connector_connector_reference_contract_Behavior _,
        ops.Connector_contract) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Connector_connector_reference_redefinedConnector_Connector _,
        ops.Connector_redefinedConnector) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ConsiderIgnoreFragment_considerIgnoreFragment_reference_message_NamedElement _,
        ops.ConsiderIgnoreFragment_message) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Dependency_supplierDependency_reference_supplier_NamedElement _,
        ops.Dependency_supplier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Deployment_deployment_compose_configuration_DeploymentSpecification _,
        ops.Deployment_configuration) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Deployment_deploymentForArtifact_reference_deployedArtifact_DeployedArtifact _,
        ops.Deployment_deployedArtifact) :+
      AssociationMetaPropertySetUpdateInfo(
        links_DeploymentTarget_location_compose_deployment_Deployment _,
        ops.DeploymentTarget_deployment) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Duration_duration_reference_observation_Observation _,
        ops.Duration_observation) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Element_owningElement_compose_ownedComment_Comment _,
        ops.Element_ownedComment) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ExceptionHandler_exceptionHandler_reference_exceptionType_Classifier _,
        ops.ExceptionHandler_exceptionType) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ExecutableNode_protectedNode_compose_handler_ExceptionHandler _,
        ops.ExecutableNode_handler) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ExpansionRegion_regionAsInput_reference_inputElement_ExpansionNode _,
        ops.ExpansionRegion_inputElement) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ExpansionRegion_regionAsOutput_reference_outputElement_ExpansionNode _,
        ops.ExpansionRegion_outputElement) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Generalization_generalization_reference_generalizationSet_GeneralizationSet _,
        ops.Generalization_generalizationSet) :+
      AssociationMetaPropertySetUpdateInfo(
        links_GeneralizationSet_generalizationSet_reference_generalization_Generalization _,
        ops.GeneralizationSet_generalization) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_conveyingFlow_reference_conveyed_Classifier _,
        ops.InformationFlow_conveyed) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_informationFlow_reference_informationSource_NamedElement _,
        ops.InformationFlow_informationSource) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_informationFlow_reference_informationTarget_NamedElement _,
        ops.InformationFlow_informationTarget) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_abstraction_reference_realization_Relationship _,
        ops.InformationFlow_realization) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_informationFlow_reference_realizingActivityEdge_ActivityEdge _,
        ops.InformationFlow_realizingActivityEdge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_informationFlow_reference_realizingConnector_Connector _,
        ops.InformationFlow_realizingConnector) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationFlow_informationFlow_reference_realizingMessage_Message _,
        ops.InformationFlow_realizingMessage) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InformationItem_representation_reference_represented_Classifier _,
        ops.InformationItem_represented) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InstanceSpecification_owningInstance_compose_slot_Slot _,
        ops.InstanceSpecification_slot) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Interaction_interaction_compose_action_Action _,
        ops.Interaction_action) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Interaction_interaction_compose_formalGate_Gate _,
        ops.Interaction_formalGate) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Interaction_interaction_compose_lifeline_Lifeline _,
        ops.Interaction_lifeline) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Interaction_interaction_compose_message_Message _,
        ops.Interaction_message) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InteractionFragment_interactionFragment_compose_generalOrdering_GeneralOrdering _,
        ops.InteractionFragment_generalOrdering) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InteractionUse_interactionUse_compose_actualGate_Gate _,
        ops.InteractionUse_actualGate) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Interface_interface_compose_ownedReception_Reception _,
        ops.Interface_ownedReception) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Interface_interface_reference_redefinedInterface_Interface _,
        ops.Interface_redefinedInterface) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InterruptibleActivityRegion_interrupts_reference_interruptingEdge_ActivityEdge _,
        ops.InterruptibleActivityRegion_interruptingEdge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_InterruptibleActivityRegion_inInterruptibleRegion_reference_node_ActivityNode _,
        ops.InterruptibleActivityRegion_node) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Lifeline_covered_reference_coveredBy_InteractionFragment _,
        ops.Lifeline_coveredBy) :+
      AssociationMetaPropertySetUpdateInfo(
        links_LinkAction_linkAction_compose_inputValue_InputPin _,
        ops.LinkAction_inputValue) :+
      AssociationMetaPropertySetUpdateInfo(
        links_LinkEndData_linkEndData_compose_qualifier_QualifierValue _,
        ops.LinkEndData_qualifier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_LoopNode_loopNode_reference_bodyPart_ExecutableNode _,
        ops.LoopNode_bodyPart) :+
      AssociationMetaPropertySetUpdateInfo(
        links_LoopNode_loopNode_reference_setupPart_ExecutableNode _,
        ops.LoopNode_setupPart) :+
      AssociationMetaPropertySetUpdateInfo(
        links_LoopNode_loopNode_reference_test_ExecutableNode _,
        ops.LoopNode_test) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Namespace_importingNamespace_compose_elementImport_ElementImport _,
        ops.Namespace_elementImport) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Namespace_context_compose_ownedRule_Constraint _,
        ops.Namespace_ownedRule) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Namespace_importingNamespace_compose_packageImport_PackageImport _,
        ops.Namespace_packageImport) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Node_node_compose_nestedNode_Node _,
        ops.Node_nestedNode) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ObjectNode_objectNode_reference_inState_State _,
        ops.ObjectNode_inState) :+
      AssociationMetaPropertySetUpdateInfo(
        links_OccurrenceSpecification_before_reference_toAfter_GeneralOrdering _,
        ops.OccurrenceSpecification_toAfter) :+
      AssociationMetaPropertySetUpdateInfo(
        links_OccurrenceSpecification_after_reference_toBefore_GeneralOrdering _,
        ops.OccurrenceSpecification_toBefore) :+
      AssociationMetaPropertySetUpdateInfo(
        links_OpaqueAction_opaqueAction_compose_inputValue_InputPin _,
        ops.OpaqueAction_inputValue) :+
      AssociationMetaPropertySetUpdateInfo(
        links_OpaqueAction_opaqueAction_compose_outputValue_OutputPin _,
        ops.OpaqueAction_outputValue) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Operation_postContext_compose_postcondition_Constraint _,
        ops.Operation_postcondition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Operation_preContext_compose_precondition_Constraint _,
        ops.Operation_precondition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Operation_operation_reference_raisedException_Type _,
        ops.Operation_raisedException) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Operation_operation_reference_redefinedOperation_Operation _,
        ops.Operation_redefinedOperation) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Package_receivingPackage_compose_packageMerge_PackageMerge _,
        ops.Package_packageMerge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Package_owningPackage_compose_packagedElement_PackageableElement _,
        ops.Package_packagedElement) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Package_applyingPackage_compose_profileApplication_ProfileApplication _,
        ops.Package_profileApplication) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Parameter_parameter_reference_parameterSet_ParameterSet _,
        ops.Parameter_parameterSet) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ParameterSet_parameterSet_compose_condition_Constraint _,
        ops.ParameterSet_condition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ParameterSet_parameterSet_reference_parameter_Parameter _,
        ops.ParameterSet_parameter) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Port_port_reference_redefinedPort_Port _,
        ops.Port_redefinedPort) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Profile_profile_compose_metaclassReference_ElementImport _,
        ops.Profile_metaclassReference) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Profile_profile_compose_metamodelReference_PackageImport _,
        ops.Profile_metamodelReference) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Property_property_reference_redefinedProperty_Property _,
        ops.Property_redefinedProperty) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Property_property_reference_subsettedProperty_Property _,
        ops.Property_subsettedProperty) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ProtocolStateMachine_specificMachine_compose_conformance_ProtocolConformance _,
        ops.ProtocolStateMachine_conformance) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ReclassifyObjectAction_reclassifyObjectAction_reference_newClassifier_Classifier _,
        ops.ReclassifyObjectAction_newClassifier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_ReclassifyObjectAction_reclassifyObjectAction_reference_oldClassifier_Classifier _,
        ops.ReclassifyObjectAction_oldClassifier) :+
      AssociationMetaPropertySetUpdateInfo(
        links_RedefinableTemplateSignature_redefinableTemplateSignature_reference_extendedSignature_RedefinableTemplateSignature _,
        ops.RedefinableTemplateSignature_extendedSignature) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Region_container_compose_subvertex_Vertex _,
        ops.Region_subvertex) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Region_container_compose_transition_Transition _,
        ops.Region_transition) :+
      AssociationMetaPropertySetUpdateInfo(
        links_State_state_compose_connection_ConnectionPointReference _,
        ops.State_connection) :+
      AssociationMetaPropertySetUpdateInfo(
        links_State_state_compose_connectionPoint_Pseudostate _,
        ops.State_connectionPoint) :+
      AssociationMetaPropertySetUpdateInfo(
        links_State_state_compose_deferrableTrigger_Trigger _,
        ops.State_deferrableTrigger) :+
      AssociationMetaPropertySetUpdateInfo(
        links_State_state_compose_region_Region _,
        ops.State_region) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StateMachine_stateMachine_compose_connectionPoint_Pseudostate _,
        ops.StateMachine_connectionPoint) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StateMachine_stateMachine_reference_extendedStateMachine_StateMachine _,
        ops.StateMachine_extendedStateMachine) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StateMachine_stateMachine_compose_region_Region _,
        ops.StateMachine_region) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StateMachine_submachine_reference_submachineState_State _,
        ops.StateMachine_submachineState) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Stereotype_stereotype_compose_icon_Image _,
        ops.Stereotype_icon) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StructuredActivityNode_inStructuredNode_compose_edge_ActivityEdge _,
        ops.StructuredActivityNode_edge) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StructuredActivityNode_inStructuredNode_compose_node_ActivityNode _,
        ops.StructuredActivityNode_node) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeInput_InputPin _,
        ops.StructuredActivityNode_structuredNodeInput) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StructuredActivityNode_structuredActivityNode_compose_structuredNodeOutput_OutputPin _,
        ops.StructuredActivityNode_structuredNodeOutput) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StructuredActivityNode_scope_compose_variable_Variable _,
        ops.StructuredActivityNode_variable) :+
      AssociationMetaPropertySetUpdateInfo(
        links_StructuredClassifier_structuredClassifier_compose_ownedConnector_Connector _,
        ops.StructuredClassifier_ownedConnector) :+
      AssociationMetaPropertySetUpdateInfo(
        links_TemplateBinding_templateBinding_compose_parameterSubstitution_TemplateParameterSubstitution _,
        ops.TemplateBinding_parameterSubstitution) :+
      AssociationMetaPropertySetUpdateInfo(
        links_TemplateableElement_boundElement_compose_templateBinding_TemplateBinding _,
        ops.TemplateableElement_templateBinding) :+
      AssociationMetaPropertySetUpdateInfo(
        links_TimeExpression_timeExpression_reference_observation_Observation _,
        ops.TimeExpression_observation) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Transition_transition_compose_trigger_Trigger _,
        ops.Transition_trigger) :+
      AssociationMetaPropertySetUpdateInfo(
        links_Trigger_trigger_reference_port_Port _,
        ops.Trigger_port) :+
      AssociationMetaPropertySetUpdateInfo(
        links_UseCase_extension_compose_extend_Extend _,
        ops.UseCase_extend) :+
      AssociationMetaPropertySetUpdateInfo(
        links_UseCase_useCase_compose_extensionPoint_ExtensionPoint _,
        ops.UseCase_extensionPoint) :+
      AssociationMetaPropertySetUpdateInfo(
        links_UseCase_includingCase_compose_include_Include _,
        ops.UseCase_include) :+
      AssociationMetaPropertySetUpdateInfo(
        links_UseCase_useCase_reference_subject_Classifier _,
        ops.UseCase_subject)
  val MetaPropertyScalarAttributeUpdate
  : Seq[MetaScalarAttributeUpdate]
  = Seq() :+
      MetaScalarAttributeUpdater(
        set_AcceptEventAction_isUnmarshall _,
        ops.AcceptEventAction_isUnmarshall) :+
      MetaScalarAttributeUpdater(
        set_Action_isLocallyReentrant _,
        ops.Action_isLocallyReentrant) :+
      MetaScalarAttributeUpdater(
        set_Activity_isReadOnly _,
        ops.Activity_isReadOnly) :+
      MetaScalarAttributeUpdater(
        set_Activity_isSingleExecution _,
        ops.Activity_isSingleExecution) :+
      MetaScalarAttributeUpdater(
        set_ActivityPartition_isDimension _,
        ops.ActivityPartition_isDimension) :+
      MetaScalarAttributeUpdater(
        set_ActivityPartition_isExternal _,
        ops.ActivityPartition_isExternal) :+
      MetaScalarAttributeUpdater(
        set_AddStructuralFeatureValueAction_isReplaceAll _,
        ops.AddStructuralFeatureValueAction_isReplaceAll) :+
      MetaScalarAttributeUpdater(
        set_AddVariableValueAction_isReplaceAll _,
        ops.AddVariableValueAction_isReplaceAll) :+
      MetaScalarAttributeUpdater(
        set_Association_isDerived _,
        ops.Association_isDerived) :+
      MetaScalarAttributeUpdater(
        set_Behavior_isReentrant _,
        ops.Behavior_isReentrant) :+
      MetaScalarAttributeUpdater(
        set_BehavioralFeature_isAbstract _,
        ops.BehavioralFeature_isAbstract) :+
      MetaScalarAttributeUpdater(
        set_CallAction_isSynchronous _,
        ops.CallAction_isSynchronous) :+
      MetaScalarAttributeUpdater(
        set_Class_isAbstract _,
        ops.Class_isAbstract) :+
      MetaScalarAttributeUpdater(
        set_Class_isActive _,
        ops.Class_isActive) :+
      MetaScalarAttributeUpdater(
        set_Classifier_isAbstract _,
        ops.Classifier_isAbstract) :+
      MetaScalarAttributeUpdater(
        set_Classifier_isFinalSpecialization _,
        ops.Classifier_isFinalSpecialization) :+
      MetaScalarAttributeUpdater(
        set_ClassifierTemplateParameter_allowSubstitutable _,
        ops.ClassifierTemplateParameter_allowSubstitutable) :+
      MetaScalarAttributeUpdater(
        set_Component_isIndirectlyInstantiated _,
        ops.Component_isIndirectlyInstantiated) :+
      MetaScalarAttributeUpdater(
        set_ConditionalNode_isAssured _,
        ops.ConditionalNode_isAssured) :+
      MetaScalarAttributeUpdater(
        set_ConditionalNode_isDeterminate _,
        ops.ConditionalNode_isDeterminate) :+
      MetaScalarAttributeUpdater(
        set_Continuation_setting _,
        ops.Continuation_setting) :+
      MetaScalarAttributeUpdater(
        set_DestroyObjectAction_isDestroyLinks _,
        ops.DestroyObjectAction_isDestroyLinks) :+
      MetaScalarAttributeUpdater(
        set_DestroyObjectAction_isDestroyOwnedObjects _,
        ops.DestroyObjectAction_isDestroyOwnedObjects) :+
      MetaScalarAttributeUpdater(
        set_Feature_isStatic _,
        ops.Feature_isStatic) :+
      MetaScalarAttributeUpdater(
        set_GeneralizationSet_isCovering _,
        ops.GeneralizationSet_isCovering) :+
      MetaScalarAttributeUpdater(
        set_GeneralizationSet_isDisjoint _,
        ops.GeneralizationSet_isDisjoint) :+
      MetaScalarAttributeUpdater(
        set_JoinNode_isCombineDuplicate _,
        ops.JoinNode_isCombineDuplicate) :+
      MetaScalarAttributeUpdater(
        set_LinkEndCreationData_isReplaceAll _,
        ops.LinkEndCreationData_isReplaceAll) :+
      MetaScalarAttributeUpdater(
        set_LinkEndDestructionData_isDestroyDuplicates _,
        ops.LinkEndDestructionData_isDestroyDuplicates) :+
      MetaScalarAttributeUpdater(
        set_LiteralBoolean_value _,
        ops.LiteralBoolean_value) :+
      MetaScalarAttributeUpdater(
        set_LiteralInteger_value _,
        ops.LiteralInteger_value) :+
      MetaScalarAttributeUpdater(
        set_LiteralReal_value _,
        ops.LiteralReal_value) :+
      MetaScalarAttributeUpdater(
        set_LiteralUnlimitedNatural_value _,
        ops.LiteralUnlimitedNatural_value) :+
      MetaScalarAttributeUpdater(
        set_LoopNode_isTestedFirst _,
        ops.LoopNode_isTestedFirst) :+
      MetaScalarAttributeUpdater(
        set_MultiplicityElement_isOrdered _,
        ops.MultiplicityElement_isOrdered) :+
      MetaScalarAttributeUpdater(
        set_MultiplicityElement_isUnique _,
        ops.MultiplicityElement_isUnique) :+
      MetaScalarAttributeUpdater(
        set_ObjectFlow_isMulticast _,
        ops.ObjectFlow_isMulticast) :+
      MetaScalarAttributeUpdater(
        set_ObjectFlow_isMultireceive _,
        ops.ObjectFlow_isMultireceive) :+
      MetaScalarAttributeUpdater(
        set_ObjectNode_isControlType _,
        ops.ObjectNode_isControlType) :+
      MetaScalarAttributeUpdater(
        set_Operation_isQuery _,
        ops.Operation_isQuery) :+
      MetaScalarAttributeUpdater(
        set_Parameter_isException _,
        ops.Parameter_isException) :+
      MetaScalarAttributeUpdater(
        set_Parameter_isStream _,
        ops.Parameter_isStream) :+
      MetaScalarAttributeUpdater(
        set_Pin_isControl _,
        ops.Pin_isControl) :+
      MetaScalarAttributeUpdater(
        set_Port_isBehavior _,
        ops.Port_isBehavior) :+
      MetaScalarAttributeUpdater(
        set_Port_isConjugated _,
        ops.Port_isConjugated) :+
      MetaScalarAttributeUpdater(
        set_Port_isService _,
        ops.Port_isService) :+
      MetaScalarAttributeUpdater(
        set_ProfileApplication_isStrict _,
        ops.ProfileApplication_isStrict) :+
      MetaScalarAttributeUpdater(
        set_Property_isDerived _,
        ops.Property_isDerived) :+
      MetaScalarAttributeUpdater(
        set_Property_isDerivedUnion _,
        ops.Property_isDerivedUnion) :+
      MetaScalarAttributeUpdater(
        set_Property_isID _,
        ops.Property_isID) :+
      MetaScalarAttributeUpdater(
        set_ReadIsClassifiedObjectAction_isDirect _,
        ops.ReadIsClassifiedObjectAction_isDirect) :+
      MetaScalarAttributeUpdater(
        set_ReclassifyObjectAction_isReplaceAll _,
        ops.ReclassifyObjectAction_isReplaceAll) :+
      MetaScalarAttributeUpdater(
        set_RedefinableElement_isLeaf _,
        ops.RedefinableElement_isLeaf) :+
      MetaScalarAttributeUpdater(
        set_ReduceAction_isOrdered _,
        ops.ReduceAction_isOrdered) :+
      MetaScalarAttributeUpdater(
        set_RemoveStructuralFeatureValueAction_isRemoveDuplicates _,
        ops.RemoveStructuralFeatureValueAction_isRemoveDuplicates) :+
      MetaScalarAttributeUpdater(
        set_RemoveVariableValueAction_isRemoveDuplicates _,
        ops.RemoveVariableValueAction_isRemoveDuplicates) :+
      MetaScalarAttributeUpdater(
        set_StructuralFeature_isReadOnly _,
        ops.StructuralFeature_isReadOnly) :+
      MetaScalarAttributeUpdater(
        set_StructuredActivityNode_mustIsolate _,
        ops.StructuredActivityNode_mustIsolate) :+
      MetaScalarAttributeUpdater(
        set_TimeEvent_isRelative _,
        ops.TimeEvent_isRelative) :+
      MetaScalarAttributeUpdater(
        set_TimeObservation_firstEvent _,
        ops.TimeObservation_firstEvent)
  val MetaPropertyOptionAttributeUpdate
  : Seq[MetaOptionAttributeUpdate]
  = Seq() :+
      MetaOptionAttributeUpdater(
        set_Artifact_fileName _,
        ops.Artifact_fileName) :+
      MetaOptionAttributeUpdater(
        set_BehavioralFeature_concurrency _,
        ops.BehavioralFeature_concurrency) :+
      MetaOptionAttributeUpdater(
        set_CombinedFragment_interactionOperator _,
        ops.CombinedFragment_interactionOperator) :+
      MetaOptionAttributeUpdater(
        set_Comment_body _,
        ops.Comment_body) :+
      MetaOptionAttributeUpdater(
        set_DeploymentSpecification_deploymentLocation _,
        ops.DeploymentSpecification_deploymentLocation) :+
      MetaOptionAttributeUpdater(
        set_DeploymentSpecification_executionLocation _,
        ops.DeploymentSpecification_executionLocation) :+
      MetaOptionAttributeUpdater(
        set_ElementImport_alias _,
        ops.ElementImport_alias) :+
      MetaOptionAttributeUpdater(
        set_ElementImport_visibility _,
        ops.ElementImport_visibility) :+
      MetaOptionAttributeUpdater(
        set_ExpansionRegion_mode _,
        ops.ExpansionRegion_mode) :+
      MetaOptionAttributeUpdater(
        set_Expression_symbol _,
        ops.Expression_symbol) :+
      MetaOptionAttributeUpdater(
        set_Generalization_isSubstitutable _,
        ops.Generalization_isSubstitutable) :+
      MetaOptionAttributeUpdater(
        set_Image_content _,
        ops.Image_content) :+
      MetaOptionAttributeUpdater(
        set_Image_format _,
        ops.Image_format) :+
      MetaOptionAttributeUpdater(
        set_Image_location _,
        ops.Image_location) :+
      MetaOptionAttributeUpdater(
        set_LiteralString_value _,
        ops.LiteralString_value) :+
      MetaOptionAttributeUpdater(
        set_Message_messageSort _,
        ops.Message_messageSort) :+
      MetaOptionAttributeUpdater(
        set_Model_viewpoint _,
        ops.Model_viewpoint) :+
      MetaOptionAttributeUpdater(
        set_NamedElement_name _,
        ops.NamedElement_name) :+
      MetaOptionAttributeUpdater(
        set_NamedElement_visibility _,
        ops.NamedElement_visibility) :+
      MetaOptionAttributeUpdater(
        set_ObjectNode_ordering _,
        ops.ObjectNode_ordering) :+
      MetaOptionAttributeUpdater(
        set_Package_URI _,
        ops.Package_URI) :+
      MetaOptionAttributeUpdater(
        set_PackageImport_visibility _,
        ops.PackageImport_visibility) :+
      MetaOptionAttributeUpdater(
        set_PackageableElement_visibility _,
        ops.PackageableElement_visibility) :+
      MetaOptionAttributeUpdater(
        set_Parameter_direction _,
        ops.Parameter_direction) :+
      MetaOptionAttributeUpdater(
        set_Parameter_effect _,
        ops.Parameter_effect) :+
      MetaOptionAttributeUpdater(
        set_Property_aggregation _,
        ops.Property_aggregation) :+
      MetaOptionAttributeUpdater(
        set_Pseudostate_kind _,
        ops.Pseudostate_kind) :+
      MetaOptionAttributeUpdater(
        set_TimeConstraint_firstEvent _,
        ops.TimeConstraint_firstEvent) :+
      MetaOptionAttributeUpdater(
        set_Transition_kind _,
        ops.Transition_kind)
  val MetaPropertyIterableAttributeUpdate
  : Seq[MetaIterableAttributeUpdate]
  = Seq()
  val MetaPropertySeqAttributeUpdate
  : Seq[MetaSeqAttributeUpdate]
  = Seq() :+
      MetaSeqAttributeUpdater(
        set_DurationObservation_firstEvent _,
        ops.DurationObservation_firstEvent) :+
      MetaSeqAttributeUpdater(
        set_OpaqueAction_body _,
        ops.OpaqueAction_body) :+
      MetaSeqAttributeUpdater(
        set_OpaqueAction_language _,
        ops.OpaqueAction_language) :+
      MetaSeqAttributeUpdater(
        set_OpaqueBehavior_body _,
        ops.OpaqueBehavior_body) :+
      MetaSeqAttributeUpdater(
        set_OpaqueBehavior_language _,
        ops.OpaqueBehavior_language) :+
      MetaSeqAttributeUpdater(
        set_OpaqueExpression_body _,
        ops.OpaqueExpression_body) :+
      MetaSeqAttributeUpdater(
        set_OpaqueExpression_language _,
        ops.OpaqueExpression_language)
  val MetaPropertySetAttributeUpdate
  : Seq[MetaSetAttributeUpdate]
  = Seq() :+
      MetaSetAttributeUpdater(
        set_DurationConstraint_firstEvent _,
        ops.DurationConstraint_firstEvent)
	// Start of user code for additional features

  case class MetaScalarAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, DT) => \/[NonEmptyList[UMLError.UException], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )

  type MetaScalarAttributeUpdate =
  MetaScalarAttributeUpdater[_ <: UMLElement[Uml], _]

  case class MetaEnumerationAttributeUpdater[U <: UMLElement[Uml], DT <: Enumeration#Value, DTSet <: Enumeration#ValueSet]
  ( attributeUpdate: (U, Option[DT]) => \/[NonEmptyList[UMLError.UException], Unit],
    attributeQuery: MetaAttributeEnumerationFunction[Uml, U, DT, DTSet] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )

  type MetaEnumerationAttributeUpdate =
  MetaEnumerationAttributeUpdater[_ <: UMLElement[Uml], _, _]

  case class MetaOptionAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, Option[DT]) => \/[NonEmptyList[UMLError.UException], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )

  type MetaOptionAttributeUpdate =
  MetaOptionAttributeUpdater[_ <: UMLElement[Uml], _]
  
  case class MetaIterableAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, Iterable[DT]) => \/[NonEmptyList[UMLError.UException], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )

  type MetaIterableAttributeUpdate =
  MetaIterableAttributeUpdater[_ <: UMLElement[Uml], _]
  
  case class MetaSetAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, Set[DT]) => \/[NonEmptyList[UMLError.UException], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )

  type MetaSetAttributeUpdate =
  MetaSetAttributeUpdater[_ <: UMLElement[Uml], _]
  
  case class MetaSeqAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, Seq[DT]) => \/[NonEmptyList[UMLError.UException], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )

  type MetaSeqAttributeUpdate =
  MetaSeqAttributeUpdater[_ <: UMLElement[Uml], _]
  
  // was: MetaPropertyCompositeFunctionQuery
  type AssociationMetaPropertyFunctionQuery =
  MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]

  // was: MetaPropertyCompositeReferenceQuery
  type AssociationMetaPropertyReferenceQuery =
  MetaPropertyReference[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]

  // was: CompositeReferenceSingleUpdate
  trait AssociationMetaPropertyUpdater {

    def update1Link(owner: UMLElement[Uml], owned: UMLElement[Uml]): \/[NonEmptyList[UMLError.UException], Unit]
  }

  // was: CompositeReferenceUpdater
  trait AssociationMetaPropertyOptionUpdater extends AssociationMetaPropertyUpdater {
    val links_query: AssociationMetaPropertyReferenceQuery
    def setLinks(owner: UMLElement[Uml], owned: Option[UMLElement[Uml]]): \/[NonEmptyList[UMLError.UException], Unit]
  }

  // was: CompositeReferenceUpdate
  case class AssociationMetaPropertyOptionUpdateInfo[U <: UMLElement[Uml], V <: UMLElement[Uml]]
  ( links_composes: (U, Option[V]) => \/[NonEmptyList[UMLError.UException], Unit],
    override val links_query: AssociationMetaPropertyReferenceQuery )
  ( implicit utag: ClassTag[U], vtag: ClassTag[V])
    extends AssociationMetaPropertyOptionUpdater {

    override def setLinks(owner: UMLElement[Uml], owned: Option[UMLElement[Uml]])
    : \/[NonEmptyList[UMLError.UException], Unit] =
      owner match {
        case u: U =>
          owned.fold[\/[NonEmptyList[UMLError.UException], Unit]]{
            links_composes(u, None)
          }{
            case v: V =>
              links_composes(u, Some(v))
            case _ =>
              NonEmptyList(
                UMLError.illegalElementError[Uml, UMLElement[Uml]](
                  s"setLinks update for $links_query: error type mismatch",
                  Iterable(owner) ++ owned.toIterable)).left
          }
        case _ =>
          NonEmptyList(
            UMLError.illegalElementError[Uml, UMLElement[Uml]](
            s"setLinks update for $links_query: error type mismatch",
            Iterable(owner) ++ owned.toIterable)).left
      }

    override def update1Link(owner: UMLElement[Uml], owned: UMLElement[Uml])
    : \/[NonEmptyList[UMLError.UException], Unit] =
      setLinks(owner, Some(owned))
  }

  // was: MetaPropertyCompositeCollectionQuery
  type AssociationMetaPropertyCollectionQuery =
  MetaPropertyCollection[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]

  // was: CompositeIterableUpdater
  trait AssociationMetaPropertyIterableUpdater extends AssociationMetaPropertyUpdater {
    val links_query: AssociationMetaPropertyCollectionQuery
    def setLinks(owner: UMLElement[Uml], owned: Iterable[UMLElement[Uml]])
    : \/[NonEmptyList[UMLError.UException], Unit]
  }

  // was: CompositeIterableUpdate
  case class AssociationMetaPropertyIterableUpdateInfo[U <: UMLElement[Uml], V <: UMLElement[Uml]]
  ( links_composes: (U, Iterable[V]) => \/[NonEmptyList[UMLError.UException], Unit],
    override val links_query: AssociationMetaPropertyCollectionQuery )
  ( implicit utag: ClassTag[U], vtag: ClassTag[V])
    extends AssociationMetaPropertyIterableUpdater {

    override def setLinks(owner: UMLElement[Uml], owned: Iterable[UMLElement[Uml]])
    : \/[NonEmptyList[UMLError.UException], Unit] =
      (owner, owned) match {
        case (u: U, v: Iterable[V]) =>
          links_composes(u, v)
        case _ =>
          NonEmptyList(
            UMLError.illegalElementError[Uml, UMLElement[Uml]](
            s"setLinks update for $links_query: error type mismatch",
            Iterable(owner) ++ owned.toIterable)).left
      }

    override def update1Link(owner: UMLElement[Uml], owned: UMLElement[Uml])
    : \/[NonEmptyList[UMLError.UException], Unit] =
      links_query.evaluate(owner)
      .flatMap { composed =>
        val updated = if (composed.contains(owned)) composed else composed :+ owned
        setLinks(owner, updated)
      }

  }

  // was: CompositeSequenceUpdater
  trait AssociationMetaPropertySequenceUpdater extends AssociationMetaPropertyUpdater {
    val links_query: AssociationMetaPropertyCollectionQuery
    def setLinks(owner: UMLElement[Uml], owned: Seq[UMLElement[Uml]])
    : \/[NonEmptyList[UMLError.UException], Unit]
  }

  // was: CompositeSequenceUpdate
  case class AssociationMetaPropertySequenceUpdateInfo[U <: UMLElement[Uml], V <: UMLElement[Uml]]
  ( links_composes: (U, Seq[V]) => \/[NonEmptyList[UMLError.UException], Unit],
    override val links_query: AssociationMetaPropertyCollectionQuery )
  ( implicit utag: ClassTag[U], vtag: ClassTag[V])
    extends AssociationMetaPropertySequenceUpdater {

    override def setLinks(owner: UMLElement[Uml], owned: Seq[UMLElement[Uml]])
    : \/[NonEmptyList[UMLError.UException], Unit] =
      (owner, owned) match {
        case (u: U, v: Seq[V]) =>
          links_composes(u, v)
        case _ =>
          NonEmptyList(
            UMLError
          .illegalElementError[Uml, UMLElement[Uml]](
            s"setLinks update for $links_query: error type mismatch",
            Iterable(owner) ++ owned.toIterable)).left
      }

    override def update1Link(owner: UMLElement[Uml], owned: UMLElement[Uml])
    : \/[NonEmptyList[UMLError.UException], Unit] =
      links_query
      .evaluate(owner)
      .flatMap { composed =>
        val updated = if (composed.contains(owned)) composed else composed :+ owned
        setLinks(owner, updated)
      }

  }

  // was: CompositeSetUpdater
  trait AssociationMetaPropertySetUpdater extends AssociationMetaPropertyUpdater {
    val links_query: AssociationMetaPropertyCollectionQuery
    def setLinks(owner: UMLElement[Uml], owned: Iterable[UMLElement[Uml]])
    : \/[NonEmptyList[UMLError.UException], Unit]
  }

  // was: CompositeSetUpdate
  case class AssociationMetaPropertySetUpdateInfo[U <: UMLElement[Uml], V <: UMLElement[Uml]]
  ( links_composes: (U, Set[V]) => \/[NonEmptyList[UMLError.UException], Unit],
    override val links_query: AssociationMetaPropertyCollectionQuery)
  ( implicit utag: ClassTag[U], vtag: ClassTag[V])
    extends AssociationMetaPropertySetUpdater {

    override def setLinks(owner: UMLElement[Uml], owned: Iterable[UMLElement[Uml]])
    : \/[NonEmptyList[UMLError.UException], Unit] =
      (owner, owned) match {
        case (u: U, v: Iterable[V]) =>
          links_composes(u, v.toSet)
        case _ =>
          NonEmptyList(
            UMLError
          .illegalElementError[Uml, UMLElement[Uml]](
            s"setLinks update for $links_query: error type mismatch",
            Iterable(owner) ++ owned.toIterable)).left
      }

    override def update1Link(owner: UMLElement[Uml], owned: UMLElement[Uml])
    : \/[NonEmptyList[UMLError.UException], Unit] =
      links_query
      .evaluate(owner)
      .flatMap { composed =>
        val updated = if (composed.contains(owned)) composed else composed :+ owned
        setLinks(owner, updated)
    }

  }

  // End of user code
}
