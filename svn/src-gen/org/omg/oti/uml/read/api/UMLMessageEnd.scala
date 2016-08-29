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
import org.omg.oti.uml.read.operations.UMLMessageEndOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * MessageEnd is an abstract specialization of NamedElement that represents what can occur at the end of a Message.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLMessageEnd[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLMessageEndOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * References a Message.
    *
    * <!-- Start of user code doc for message -->
    * <!-- End of user code doc for message -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLMessage.message_messageEnd
    */
  def message: Option[UMLMessage[Uml]]

  /**
    * <!-- Start of user code doc for receiveEvent_endMessage -->
    * <!-- End of user code doc for receiveEvent_endMessage -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLMessage.receiveEvent
    */
  def receiveEvent_endMessage: Option[UMLMessage[Uml]]

  /**
    * <!-- Start of user code doc for sendEvent_endMessage -->
    * <!-- End of user code doc for sendEvent_endMessage -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLMessage.sendEvent
    */
  def sendEvent_endMessage: Option[UMLMessage[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      messageEnd_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLMessageEnd
    *
    * <!-- Start of user code doc for messageEnd_metaAttributes -->
    * <!-- End of user code doc for messageEnd_metaAttributes -->
    */
  def messageEnd_metaAttributes: MetaAttributeFunctions = 
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
    messageEnd_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLMessageEnd
    *
    * <!-- Start of user code doc for messageEnd_compositeMetaProperties -->
    * <!-- End of user code doc for messageEnd_compositeMetaProperties -->
    */
  def messageEnd_compositeMetaProperties: MetaPropertyFunctions = 
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
    messageEnd_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLMessageEnd
    *
    * <!-- Start of user code doc for messageEnd_referenceMetaProperties -->
    * <!-- End of user code doc for messageEnd_referenceMetaProperties -->
    */
  def messageEnd_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](MessageEnd_message))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    messageEnd_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLMessageEnd
    *
    * <!-- Start of user code doc for messageEnd_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for messageEnd_forwardReferencesFromMetamodelAssociations -->
    */
  def messageEnd_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    message

  // Start of user code for additional features
  // End of user code
} //UMLMessageEnd
