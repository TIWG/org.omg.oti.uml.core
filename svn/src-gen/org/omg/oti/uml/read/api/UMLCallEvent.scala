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
import org.omg.oti.uml.read.operations.UMLCallEventOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A CallEvent models the receipt by an object of a message invoking a call of an Operation.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCallEvent[Uml <: UML]
  extends UMLMessageEvent[Uml]
  with UMLCallEventOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Designates the Operation whose invocation raised the CalEvent.
    *
    * <!-- Start of user code doc for operation -->
    * <!-- End of user code doc for operation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.operation_callEvent
    */
  def operation: Option[UMLOperation[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      callEvent_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLCallEvent
    *
    * <!-- Start of user code doc for callEvent_metaAttributes -->
    * <!-- End of user code doc for callEvent_metaAttributes -->
    */
  def callEvent_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     messageEvent_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    callEvent_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLCallEvent
    *
    * <!-- Start of user code doc for callEvent_compositeMetaProperties -->
    * <!-- End of user code doc for callEvent_compositeMetaProperties -->
    */
  def callEvent_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      messageEvent_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    callEvent_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLCallEvent
    *
    * <!-- Start of user code doc for callEvent_referenceMetaProperties -->
    * <!-- End of user code doc for callEvent_referenceMetaProperties -->
    */
  def callEvent_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      messageEvent_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](CallEvent_operation))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    callEvent_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLCallEvent
    *
    * <!-- Start of user code doc for callEvent_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for callEvent_forwardReferencesFromMetamodelAssociations -->
    */
  def callEvent_forwardReferencesFromMetamodelAssociations: Elements =
    messageEvent_forwardReferencesFromMetamodelAssociations ++
    operation

  // Start of user code for additional features
  // End of user code
} //UMLCallEvent
