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
import org.omg.oti.uml.read.operations.UMLCallActionOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * CallAction is an abstract class for Actions that invoke a Behavior with given argument values and (if the invocation is synchronous) receive reply values.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCallAction[Uml <: UML]
  extends UMLInvocationAction[Uml]
  with UMLCallActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * If true, the call is synchronous and the caller waits for completion of the invoked Behavior. If false, the call is asynchronous and the caller proceeds immediately and cannot receive return values.
    *
    * <!-- Start of user code doc for isSynchronous -->
    * <!-- End of user code doc for isSynchronous -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isSynchronous: Boolean

  /**
    * The OutputPins on which the reply values from the invocation are placed (if the call is synchronous).
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_callAction
    */
  def result: Seq[UMLOutputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      callAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLCallAction
    *
    * <!-- Start of user code doc for callAction_metaAttributes -->
    * <!-- End of user code doc for callAction_metaAttributes -->
    */
  def callAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     invocationAction_metaAttributes,
     Seq[MetaAttributeFunction](CallAction_isSynchronous))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    callAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLCallAction
    *
    * <!-- Start of user code doc for callAction_compositeMetaProperties -->
    * <!-- End of user code doc for callAction_compositeMetaProperties -->
    */
  def callAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      invocationAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](CallAction_result))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    callAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLCallAction
    *
    * <!-- Start of user code doc for callAction_referenceMetaProperties -->
    * <!-- End of user code doc for callAction_referenceMetaProperties -->
    */
  def callAction_referenceMetaProperties: MetaPropertyFunctions = 
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
    callAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLCallAction
    *
    * <!-- Start of user code doc for callAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for callAction_forwardReferencesFromMetamodelAssociations -->
    */
  def callAction_forwardReferencesFromMetamodelAssociations: Elements =
    invocationAction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLCallAction
