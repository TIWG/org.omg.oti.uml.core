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
import org.omg.oti.uml.read.operations.UMLCallOperationActionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A CallOperationAction is a CallAction that transmits an Operation call request to the target object, where it may cause the invocation of associated Behavior. The argument values of the CallOperationAction are passed on the input Parameters of the Operation. If call is synchronous, the execution of the CallOperationAction waits until the execution of the invoked Operation completes and the values of output Parameters of the Operation are placed on the result OutputPins. If the call is asynchronous, the CallOperationAction completes immediately and no results values can be provided.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCallOperationAction[Uml <: UML]
  extends UMLCallAction[Uml]
  with UMLCallOperationActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Operation being invoked.
    *
    * <!-- Start of user code doc for operation -->
    * <!-- End of user code doc for operation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.operation_callOperationAction
    */
  def operation: Option[UMLOperation[Uml]]

  /**
    * The InputPin that provides the target object to which the Operation call request is sent.
    *
    * <!-- Start of user code doc for target -->
    * <!-- End of user code doc for target -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.target_callOperationAction
    */
  def target: Option[UMLInputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      callOperationAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLCallOperationAction
    *
    * <!-- Start of user code doc for callOperationAction_metaAttributes -->
    * <!-- End of user code doc for callOperationAction_metaAttributes -->
    */
  def callOperationAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     callAction_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    callOperationAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLCallOperationAction
    *
    * <!-- Start of user code doc for callOperationAction_compositeMetaProperties -->
    * <!-- End of user code doc for callOperationAction_compositeMetaProperties -->
    */
  def callOperationAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      callAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](CallOperationAction_target))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    callOperationAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLCallOperationAction
    *
    * <!-- Start of user code doc for callOperationAction_referenceMetaProperties -->
    * <!-- End of user code doc for callOperationAction_referenceMetaProperties -->
    */
  def callOperationAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      callAction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](CallOperationAction_operation))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    callOperationAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLCallOperationAction
    *
    * <!-- Start of user code doc for callOperationAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for callOperationAction_forwardReferencesFromMetamodelAssociations -->
    */
  def callOperationAction_forwardReferencesFromMetamodelAssociations: Elements =
    callAction_forwardReferencesFromMetamodelAssociations ++
    operation

  // Start of user code for additional features
  // End of user code
} //UMLCallOperationAction
