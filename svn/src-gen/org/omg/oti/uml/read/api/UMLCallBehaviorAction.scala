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
import org.omg.oti.uml.read.operations.UMLCallBehaviorActionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A CallBehaviorAction is a CallAction that invokes a Behavior directly. The argument values of the CallBehaviorAction are passed on the input Parameters of the invoked Behavior. If the call is synchronous, the execution of the CallBehaviorAction waits until the execution of the invoked Behavior completes and the values of output Parameters of the Behavior are placed on the result OutputPins. If the call is asynchronous, the CallBehaviorAction completes immediately and no results values can be provided.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCallBehaviorAction[Uml <: UML]
  extends UMLCallAction[Uml]
  with UMLCallBehaviorActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Behavior being invoked.
    *
    * <!-- Start of user code doc for behavior -->
    * <!-- End of user code doc for behavior -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.behavior_callBehaviorAction
    */
  def behavior: Option[UMLBehavior[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      callBehaviorAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLCallBehaviorAction
    *
    * <!-- Start of user code doc for callBehaviorAction_metaAttributes -->
    * <!-- End of user code doc for callBehaviorAction_metaAttributes -->
    */
  def callBehaviorAction_metaAttributes: MetaAttributeFunctions = 
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
    callBehaviorAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLCallBehaviorAction
    *
    * <!-- Start of user code doc for callBehaviorAction_compositeMetaProperties -->
    * <!-- End of user code doc for callBehaviorAction_compositeMetaProperties -->
    */
  def callBehaviorAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      callAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    callBehaviorAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLCallBehaviorAction
    *
    * <!-- Start of user code doc for callBehaviorAction_referenceMetaProperties -->
    * <!-- End of user code doc for callBehaviorAction_referenceMetaProperties -->
    */
  def callBehaviorAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      callAction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](CallBehaviorAction_behavior))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    callBehaviorAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLCallBehaviorAction
    *
    * <!-- Start of user code doc for callBehaviorAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for callBehaviorAction_forwardReferencesFromMetamodelAssociations -->
    */
  def callBehaviorAction_forwardReferencesFromMetamodelAssociations: Elements =
    callAction_forwardReferencesFromMetamodelAssociations ++
    behavior

  // Start of user code for additional features
  // End of user code
} //UMLCallBehaviorAction
