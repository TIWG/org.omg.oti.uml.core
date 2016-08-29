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
import org.omg.oti.uml.read.operations.UMLReplyActionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A ReplyAction is an Action that accepts a set of reply values and a value containing return information produced by a previous AcceptCallAction. The ReplyAction returns the values to the caller of the previous call, completing execution of the call.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReplyAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLReplyActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Trigger specifying the Operation whose call is being replied to.
    *
    * <!-- Start of user code doc for replyToCall -->
    * <!-- End of user code doc for replyToCall -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTrigger.replyToCall_replyAction
    */
  def replyToCall: Option[UMLTrigger[Uml]]

  /**
    * A list of InputPins providing the values for the output (inout, out, and return) Parameters of the Operation. These values are returned to the caller.
    *
    * <!-- Start of user code doc for replyValue -->
    * <!-- End of user code doc for replyValue -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.replyValue_replyAction
    */
  def replyValue: Seq[UMLInputPin[Uml]]

  /**
    * An InputPin that holds the return information value produced by an earlier AcceptCallAction.
    *
    * <!-- Start of user code doc for returnInformation -->
    * <!-- End of user code doc for returnInformation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.returnInformation_replyAction
    */
  def returnInformation: Option[UMLInputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      replyAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLReplyAction
    *
    * <!-- Start of user code doc for replyAction_metaAttributes -->
    * <!-- End of user code doc for replyAction_metaAttributes -->
    */
  def replyAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    replyAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLReplyAction
    *
    * <!-- Start of user code doc for replyAction_compositeMetaProperties -->
    * <!-- End of user code doc for replyAction_compositeMetaProperties -->
    */
  def replyAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ReplyAction_replyValue,
      	ReplyAction_returnInformation))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    replyAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLReplyAction
    *
    * <!-- Start of user code doc for replyAction_referenceMetaProperties -->
    * <!-- End of user code doc for replyAction_referenceMetaProperties -->
    */
  def replyAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ReplyAction_replyToCall))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    replyAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLReplyAction
    *
    * <!-- Start of user code doc for replyAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for replyAction_forwardReferencesFromMetamodelAssociations -->
    */
  def replyAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    replyToCall

  // Start of user code for additional features
  // End of user code
} //UMLReplyAction
