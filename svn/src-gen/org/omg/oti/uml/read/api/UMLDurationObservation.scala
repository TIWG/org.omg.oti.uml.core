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
import org.omg.oti.uml.read.operations.UMLDurationObservationOps

import scala.Boolean
import scala.collection.immutable.Seq
// End of user code


/**
  * A DurationObservation is a reference to a duration during an execution. It points out the NamedElement(s) in the model to observe and whether the observations are when this NamedElement is entered or when it is exited.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDurationObservation[Uml <: UML]
  extends UMLObservation[Uml]
  with UMLDurationObservationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The DurationObservation is determined as the duration between the entering or exiting of a single event Element during execution, or the entering/exiting of one event Element and the entering/exiting of a second.
    *
    * <!-- Start of user code doc for event -->
    * <!-- End of user code doc for event -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="1..2"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamedElement.event_durationObservation
    */
  def event: Seq[UMLNamedElement[Uml]]

  /**
    * The value of firstEvent[i] is related to event[i] (where i is 1 or 2). If firstEvent[i] is true, then the corresponding observation event is the first time instant the execution enters event[i]. If firstEvent[i] is false, then the corresponding observation event is the time instant the execution exits event[i].
    *
    * <!-- Start of user code doc for firstEvent -->
    * <!-- End of user code doc for firstEvent -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..2"
    */
  def firstEvent: Seq[Boolean]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      durationObservation_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDurationObservation
    *
    * <!-- Start of user code doc for durationObservation_metaAttributes -->
    * <!-- End of user code doc for durationObservation_metaAttributes -->
    */
  def durationObservation_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     observation_metaAttributes,
     Seq[MetaAttributeFunction](DurationObservation_firstEvent))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    durationObservation_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDurationObservation
    *
    * <!-- Start of user code doc for durationObservation_compositeMetaProperties -->
    * <!-- End of user code doc for durationObservation_compositeMetaProperties -->
    */
  def durationObservation_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      observation_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    durationObservation_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDurationObservation
    *
    * <!-- Start of user code doc for durationObservation_referenceMetaProperties -->
    * <!-- End of user code doc for durationObservation_referenceMetaProperties -->
    */
  def durationObservation_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      observation_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](DurationObservation_event))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    durationObservation_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDurationObservation
    *
    * <!-- Start of user code doc for durationObservation_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for durationObservation_forwardReferencesFromMetamodelAssociations -->
    */
  def durationObservation_forwardReferencesFromMetamodelAssociations: Elements =
    observation_forwardReferencesFromMetamodelAssociations ++
    event

  // Start of user code for additional features
  // End of user code
} //UMLDurationObservation
