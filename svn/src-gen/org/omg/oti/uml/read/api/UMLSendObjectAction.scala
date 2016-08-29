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
import org.omg.oti.uml.read.operations.UMLSendObjectActionOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A SendObjectAction is an InvocationAction that transmits an input object to the target object, which is handled as a request message by the target object. The requestor continues execution immediately after the object is sent out and cannot receive reply values.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLSendObjectAction[Uml <: UML]
  extends UMLInvocationAction[Uml]
  with UMLSendObjectActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The target object to which the object is sent.
    *
    * <!-- Start of user code doc for target -->
    * <!-- End of user code doc for target -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.target_sendObjectAction
    */
  def target: Option[UMLInputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      sendObjectAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLSendObjectAction
    *
    * <!-- Start of user code doc for sendObjectAction_metaAttributes -->
    * <!-- End of user code doc for sendObjectAction_metaAttributes -->
    */
  def sendObjectAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     invocationAction_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    sendObjectAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLSendObjectAction
    *
    * <!-- Start of user code doc for sendObjectAction_compositeMetaProperties -->
    * <!-- End of user code doc for sendObjectAction_compositeMetaProperties -->
    */
  def sendObjectAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      invocationAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](SendObjectAction_request,
      	SendObjectAction_target))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    sendObjectAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLSendObjectAction
    *
    * <!-- Start of user code doc for sendObjectAction_referenceMetaProperties -->
    * <!-- End of user code doc for sendObjectAction_referenceMetaProperties -->
    */
  def sendObjectAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      invocationAction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    sendObjectAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLSendObjectAction
    *
    * <!-- Start of user code doc for sendObjectAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for sendObjectAction_forwardReferencesFromMetamodelAssociations -->
    */
  def sendObjectAction_forwardReferencesFromMetamodelAssociations: Elements =
    invocationAction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLSendObjectAction
