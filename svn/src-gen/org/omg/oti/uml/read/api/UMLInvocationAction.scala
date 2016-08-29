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
import org.omg.oti.uml.read.operations.UMLInvocationActionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * InvocationAction is an abstract class for the various actions that request Behavior invocation.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInvocationAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLInvocationActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The InputPins that provide the argument values passed in the invocation request.
    *
    * <!-- Start of user code doc for argument -->
    * <!-- End of user code doc for argument -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.argument_invocationAction
    */
  def argument: Seq[UMLInputPin[Uml]]

  /**
    * For CallOperationActions, SendSignalActions, and SendObjectActions, an optional Port of the target object through which the invocation request is sent.
    *
    * <!-- Start of user code doc for onPort -->
    * <!-- End of user code doc for onPort -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPort.onPort_invocationAction
    */
  def onPort: Option[UMLPort[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      invocationAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInvocationAction
    *
    * <!-- Start of user code doc for invocationAction_metaAttributes -->
    * <!-- End of user code doc for invocationAction_metaAttributes -->
    */
  def invocationAction_metaAttributes: MetaAttributeFunctions = 
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
    invocationAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInvocationAction
    *
    * <!-- Start of user code doc for invocationAction_compositeMetaProperties -->
    * <!-- End of user code doc for invocationAction_compositeMetaProperties -->
    */
  def invocationAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](InvocationAction_argument))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    invocationAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInvocationAction
    *
    * <!-- Start of user code doc for invocationAction_referenceMetaProperties -->
    * <!-- End of user code doc for invocationAction_referenceMetaProperties -->
    */
  def invocationAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](InvocationAction_onPort))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    invocationAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInvocationAction
    *
    * <!-- Start of user code doc for invocationAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for invocationAction_forwardReferencesFromMetamodelAssociations -->
    */
  def invocationAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    onPort

  // Start of user code for additional features
  // End of user code
} //UMLInvocationAction
