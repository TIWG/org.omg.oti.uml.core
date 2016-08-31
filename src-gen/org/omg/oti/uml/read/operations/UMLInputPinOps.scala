/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.Boolean
import scala.Option
import scala.Predef.???
// End of user code

/**
  * An InputPin is a Pin that holds input values to be consumed by an Action.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInputPinOps[Uml <: UML] { self: UMLInputPin[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for collection_reduceAction -->
    * <!-- End of user code doc for collection_reduceAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReduceAction.collection
    */
  def collection_reduceAction: Option[UMLReduceAction[Uml]] = input_action.selectByKindOf { case x: UMLReduceAction[Uml] => x }

  /**
    * <!-- Start of user code doc for exception_raiseExceptionAction -->
    * <!-- End of user code doc for exception_raiseExceptionAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRaiseExceptionAction.exception
    */
  def exception_raiseExceptionAction: Option[UMLRaiseExceptionAction[Uml]] = input_action.selectByKindOf { case x: UMLRaiseExceptionAction[Uml] => x }

  /**
    * <!-- Start of user code doc for inputValue_linkAction -->
    * <!-- End of user code doc for inputValue_linkAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLinkAction.inputValue
    */
  def inputValue_linkAction: Option[UMLLinkAction[Uml]] = input_action.selectByKindOf { case x: UMLLinkAction[Uml] => x }

  /**
    * <!-- Start of user code doc for inputValue_opaqueAction -->
    * <!-- End of user code doc for inputValue_opaqueAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOpaqueAction.inputValue
    */
  def inputValue_opaqueAction: Option[UMLOpaqueAction[Uml]] = input_action.selectByKindOf { case x: UMLOpaqueAction[Uml] => x }

  /**
    * <!-- Start of user code doc for insertAt_addStructuralFeatureValueAction -->
    * <!-- End of user code doc for insertAt_addStructuralFeatureValueAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAddStructuralFeatureValueAction.insertAt
    */
  def insertAt_addStructuralFeatureValueAction: Option[UMLAddStructuralFeatureValueAction[Uml]] = input_action.selectByKindOf { case x: UMLAddStructuralFeatureValueAction[Uml] => x }

  /**
    * <!-- Start of user code doc for insertAt_addVariableValueAction -->
    * <!-- End of user code doc for insertAt_addVariableValueAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAddVariableValueAction.insertAt
    */
  def insertAt_addVariableValueAction: Option[UMLAddVariableValueAction[Uml]] = input_action.selectByKindOf { case x: UMLAddVariableValueAction[Uml] => x }

  /**
    * <!-- Start of user code doc for loopVariableInput_loopNode -->
    * <!-- End of user code doc for loopVariableInput_loopNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLoopNode.loopVariableInput
    */
  def loopVariableInput_loopNode: Option[UMLLoopNode[Uml]] = structuredNodeInput_structuredActivityNode.selectByKindOf { case x: UMLLoopNode[Uml] => x }

  /**
    * <!-- Start of user code doc for object_clearAssociationAction -->
    * <!-- End of user code doc for object_clearAssociationAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClearAssociationAction._object
    */
  def object_clearAssociationAction: Option[UMLClearAssociationAction[Uml]] = input_action.selectByKindOf { case x: UMLClearAssociationAction[Uml] => x }

  /**
    * <!-- Start of user code doc for object_readIsClassifiedObjectAction -->
    * <!-- End of user code doc for object_readIsClassifiedObjectAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReadIsClassifiedObjectAction._object
    */
  def object_readIsClassifiedObjectAction: Option[UMLReadIsClassifiedObjectAction[Uml]] = input_action.selectByKindOf { case x: UMLReadIsClassifiedObjectAction[Uml] => x }

  /**
    * <!-- Start of user code doc for object_readLinkObjectEndAction -->
    * <!-- End of user code doc for object_readLinkObjectEndAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReadLinkObjectEndAction._object
    */
  def object_readLinkObjectEndAction: Option[UMLReadLinkObjectEndAction[Uml]] = input_action.selectByKindOf { case x: UMLReadLinkObjectEndAction[Uml] => x }

  /**
    * <!-- Start of user code doc for object_readLinkObjectEndQualifierAction -->
    * <!-- End of user code doc for object_readLinkObjectEndQualifierAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReadLinkObjectEndQualifierAction._object
    */
  def object_readLinkObjectEndQualifierAction: Option[UMLReadLinkObjectEndQualifierAction[Uml]] = input_action.selectByKindOf { case x: UMLReadLinkObjectEndQualifierAction[Uml] => x }

  /**
    * <!-- Start of user code doc for object_reclassifyObjectAction -->
    * <!-- End of user code doc for object_reclassifyObjectAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReclassifyObjectAction._object
    */
  def object_reclassifyObjectAction: Option[UMLReclassifyObjectAction[Uml]] = input_action.selectByKindOf { case x: UMLReclassifyObjectAction[Uml] => x }

  /**
    * <!-- Start of user code doc for object_startClassifierBehaviorAction -->
    * <!-- End of user code doc for object_startClassifierBehaviorAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStartClassifierBehaviorAction._object
    */
  def object_startClassifierBehaviorAction: Option[UMLStartClassifierBehaviorAction[Uml]] = input_action.selectByKindOf { case x: UMLStartClassifierBehaviorAction[Uml] => x }

  /**
    * <!-- Start of user code doc for object_startObjectBehaviorAction -->
    * <!-- End of user code doc for object_startObjectBehaviorAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStartObjectBehaviorAction._object
    */
  def object_startObjectBehaviorAction: Option[UMLStartObjectBehaviorAction[Uml]] = input_action.selectByKindOf { case x: UMLStartObjectBehaviorAction[Uml] => x }

  /**
    * <!-- Start of user code doc for object_unmarshallAction -->
    * <!-- End of user code doc for object_unmarshallAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLUnmarshallAction._object
    */
  def object_unmarshallAction: Option[UMLUnmarshallAction[Uml]] = input_action.selectByKindOf { case x: UMLUnmarshallAction[Uml] => x }

  /**
    * <!-- Start of user code doc for removeAt_removeStructuralFeatureValueAction -->
    * <!-- End of user code doc for removeAt_removeStructuralFeatureValueAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRemoveStructuralFeatureValueAction.removeAt
    */
  def removeAt_removeStructuralFeatureValueAction: Option[UMLRemoveStructuralFeatureValueAction[Uml]] = input_action.selectByKindOf { case x: UMLRemoveStructuralFeatureValueAction[Uml] => x }

  /**
    * <!-- Start of user code doc for removeAt_removeVariableValueAction -->
    * <!-- End of user code doc for removeAt_removeVariableValueAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRemoveVariableValueAction.removeAt
    */
  def removeAt_removeVariableValueAction: Option[UMLRemoveVariableValueAction[Uml]] = input_action.selectByKindOf { case x: UMLRemoveVariableValueAction[Uml] => x }

  /**
    * <!-- Start of user code doc for request_sendObjectAction -->
    * <!-- End of user code doc for request_sendObjectAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSendObjectAction.request
    */
  def request_sendObjectAction: Option[UMLSendObjectAction[Uml]] = argument_invocationAction.selectByKindOf { case x: UMLSendObjectAction[Uml] => x }

  /**
    * <!-- Start of user code doc for structuredNodeInput_structuredActivityNode -->
    * <!-- End of user code doc for structuredNodeInput_structuredActivityNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuredActivityNode.structuredNodeInput
    */
  def structuredNodeInput_structuredActivityNode: Option[UMLStructuredActivityNode[Uml]] = input_action.selectByKindOf { case x: UMLStructuredActivityNode[Uml] => x }

  /**
    * <!-- Start of user code doc for target_callOperationAction -->
    * <!-- End of user code doc for target_callOperationAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLCallOperationAction.target
    */
  def target_callOperationAction: Option[UMLCallOperationAction[Uml]] = input_action.selectByKindOf { case x: UMLCallOperationAction[Uml] => x }

  /**
    * <!-- Start of user code doc for target_destroyObjectAction -->
    * <!-- End of user code doc for target_destroyObjectAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDestroyObjectAction.target
    */
  def target_destroyObjectAction: Option[UMLDestroyObjectAction[Uml]] = input_action.selectByKindOf { case x: UMLDestroyObjectAction[Uml] => x }

  /**
    * <!-- Start of user code doc for target_sendSignalAction -->
    * <!-- End of user code doc for target_sendSignalAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSendSignalAction.target
    */
  def target_sendSignalAction: Option[UMLSendSignalAction[Uml]] = input_action.selectByKindOf { case x: UMLSendSignalAction[Uml] => x }

  /**
    * An InputPin may have outgoing ActivityEdges only when it is owned by a StructuredActivityNode, and these edges must target a node contained (directly or indirectly) in the owning StructuredActivityNode.
    *
    * <!-- Start of user code doc for validate_outgoing_edges_structured_only -->
    * <!-- End of user code doc for validate_outgoing_edges_structured_only -->
    *
    * {{{
    * OCL Body outgoing->notEmpty() implies
    * 	action<>null and
    * 	action.oclIsKindOf(StructuredActivityNode) and
    * 	action.oclAsType(StructuredActivityNode).allOwnedNodes()->includesAll(outgoing.target)
    * }}}
    */
  def validate_outgoing_edges_structured_only: Boolean = {
    // Start of user code for "outgoing_edges_structured_only"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLInputPinOps
