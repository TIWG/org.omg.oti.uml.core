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

package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLInputPinOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An InputPin is a Pin that holds input values to be consumed by an Action.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInputPin[Uml <: UML]
  extends UMLPin[Uml]
  with UMLInputPinOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * <!-- Start of user code doc for argument_invocationAction -->
    * <!-- End of user code doc for argument_invocationAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInvocationAction.argument
    */
  def argument_invocationAction: Option[UMLInvocationAction[Uml]]

  /**
    * <!-- Start of user code doc for destroyAt_linkEndDestructionData -->
    * <!-- End of user code doc for destroyAt_linkEndDestructionData -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLinkEndDestructionData.destroyAt
    */
  def destroyAt_linkEndDestructionData: Option[UMLLinkEndDestructionData[Uml]]

  /**
    * <!-- Start of user code doc for first_testIdentityAction -->
    * <!-- End of user code doc for first_testIdentityAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTestIdentityAction.first
    */
  def first_testIdentityAction: Option[UMLTestIdentityAction[Uml]]

  /**
    * <!-- Start of user code doc for input_action -->
    * <!-- End of user code doc for input_action -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAction.input
    */
  def input_action: Option[UMLAction[Uml]]

  /**
    * <!-- Start of user code doc for insertAt_linkEndCreationData -->
    * <!-- End of user code doc for insertAt_linkEndCreationData -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLinkEndCreationData.insertAt
    */
  def insertAt_linkEndCreationData: Option[UMLLinkEndCreationData[Uml]]

  /**
    * <!-- Start of user code doc for object_structuralFeatureAction -->
    * <!-- End of user code doc for object_structuralFeatureAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuralFeatureAction._object
    */
  def object_structuralFeatureAction: Option[UMLStructuralFeatureAction[Uml]]

  /**
    * <!-- Start of user code doc for replyValue_replyAction -->
    * <!-- End of user code doc for replyValue_replyAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReplyAction.replyValue
    */
  def replyValue_replyAction: Option[UMLReplyAction[Uml]]

  /**
    * <!-- Start of user code doc for returnInformation_replyAction -->
    * <!-- End of user code doc for returnInformation_replyAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReplyAction.returnInformation
    */
  def returnInformation_replyAction: Option[UMLReplyAction[Uml]]

  /**
    * <!-- Start of user code doc for second_testIdentityAction -->
    * <!-- End of user code doc for second_testIdentityAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTestIdentityAction.second
    */
  def second_testIdentityAction: Option[UMLTestIdentityAction[Uml]]

  /**
    * <!-- Start of user code doc for target_sendObjectAction -->
    * <!-- End of user code doc for target_sendObjectAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSendObjectAction.target
    */
  def target_sendObjectAction: Option[UMLSendObjectAction[Uml]]

  /**
    * <!-- Start of user code doc for value_linkEndData -->
    * <!-- End of user code doc for value_linkEndData -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLinkEndData.value
    */
  def value_linkEndData: Option[UMLLinkEndData[Uml]]

  /**
    * <!-- Start of user code doc for value_qualifierValue -->
    * <!-- End of user code doc for value_qualifierValue -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLQualifierValue.value
    */
  def value_qualifierValue: Option[UMLQualifierValue[Uml]]

  /**
    * <!-- Start of user code doc for value_writeStructuralFeatureAction -->
    * <!-- End of user code doc for value_writeStructuralFeatureAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLWriteStructuralFeatureAction.value
    */
  def value_writeStructuralFeatureAction: Option[UMLWriteStructuralFeatureAction[Uml]]

  /**
    * <!-- Start of user code doc for value_writeVariableAction -->
    * <!-- End of user code doc for value_writeVariableAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLWriteVariableAction.value
    */
  def value_writeVariableAction: Option[UMLWriteVariableAction[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      inputPin_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInputPin
    *
    * <!-- Start of user code doc for inputPin_metaAttributes -->
    * <!-- End of user code doc for inputPin_metaAttributes -->
    */
  def inputPin_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     pin_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    inputPin_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInputPin
    *
    * <!-- Start of user code doc for inputPin_compositeMetaProperties -->
    * <!-- End of user code doc for inputPin_compositeMetaProperties -->
    */
  def inputPin_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      pin_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    inputPin_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInputPin
    *
    * <!-- Start of user code doc for inputPin_referenceMetaProperties -->
    * <!-- End of user code doc for inputPin_referenceMetaProperties -->
    */
  def inputPin_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      pin_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    inputPin_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInputPin
    *
    * <!-- Start of user code doc for inputPin_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for inputPin_forwardReferencesFromMetamodelAssociations -->
    */
  def inputPin_forwardReferencesFromMetamodelAssociations: Elements =
    pin_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLInputPin
