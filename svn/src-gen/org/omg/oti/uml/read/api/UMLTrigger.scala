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
import org.omg.oti.uml.read.operations.UMLTriggerOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Trigger specifies a specific point  at which an Event occurrence may trigger an effect in a Behavior. A Trigger may be qualified by the Port on which the Event occurred.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTrigger[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLTriggerOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Event that detected by the Trigger.
    *
    * <!-- Start of user code doc for event -->
    * <!-- End of user code doc for event -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLEvent.event_trigger
    */
  def event: Option[UMLEvent[Uml]]

  /**
    * A optional Port of through which the given effect is detected.
    *
    * <!-- Start of user code doc for port -->
    * <!-- End of user code doc for port -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPort.port_trigger
    */
  def port: Set[UMLPort[Uml]]

  /**
    * <!-- Start of user code doc for replyToCall_replyAction -->
    * <!-- End of user code doc for replyToCall_replyAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReplyAction.replyToCall
    */
  def replyToCall_replyAction: Option[UMLReplyAction[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      trigger_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLTrigger
    *
    * <!-- Start of user code doc for trigger_metaAttributes -->
    * <!-- End of user code doc for trigger_metaAttributes -->
    */
  def trigger_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namedElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    trigger_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLTrigger
    *
    * <!-- Start of user code doc for trigger_compositeMetaProperties -->
    * <!-- End of user code doc for trigger_compositeMetaProperties -->
    */
  def trigger_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    trigger_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLTrigger
    *
    * <!-- Start of user code doc for trigger_referenceMetaProperties -->
    * <!-- End of user code doc for trigger_referenceMetaProperties -->
    */
  def trigger_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Trigger_event,
      	Trigger_port))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    trigger_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLTrigger
    *
    * <!-- Start of user code doc for trigger_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for trigger_forwardReferencesFromMetamodelAssociations -->
    */
  def trigger_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    event ++
    port

  // Start of user code for additional features
  // End of user code
} //UMLTrigger
