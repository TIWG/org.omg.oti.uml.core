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
import org.omg.oti.uml.read.operations.UMLAcceptEventActionOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An AcceptEventAction is an Action that waits for the occurrence of one or more specific Events.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAcceptEventAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLAcceptEventActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Indicates whether there is a single OutputPin for a SignalEvent occurrence, or multiple OutputPins for attribute values of the instance of the Signal associated with a SignalEvent occurrence.
    *
    * <!-- Start of user code doc for isUnmarshall -->
    * <!-- End of user code doc for isUnmarshall -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isUnmarshall: Boolean

  /**
    * OutputPins holding the values received from an Event occurrence.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_acceptEventAction
    */
  def result: Seq[UMLOutputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      acceptEventAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLAcceptEventAction
    *
    * <!-- Start of user code doc for acceptEventAction_metaAttributes -->
    * <!-- End of user code doc for acceptEventAction_metaAttributes -->
    */
  def acceptEventAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     Seq[MetaAttributeFunction](AcceptEventAction_isUnmarshall))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    acceptEventAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLAcceptEventAction
    *
    * <!-- Start of user code doc for acceptEventAction_compositeMetaProperties -->
    * <!-- End of user code doc for acceptEventAction_compositeMetaProperties -->
    */
  def acceptEventAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](AcceptEventAction_result,
      	AcceptEventAction_trigger))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    acceptEventAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLAcceptEventAction
    *
    * <!-- Start of user code doc for acceptEventAction_referenceMetaProperties -->
    * <!-- End of user code doc for acceptEventAction_referenceMetaProperties -->
    */
  def acceptEventAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    acceptEventAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLAcceptEventAction
    *
    * <!-- Start of user code doc for acceptEventAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for acceptEventAction_forwardReferencesFromMetamodelAssociations -->
    */
  def acceptEventAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLAcceptEventAction
