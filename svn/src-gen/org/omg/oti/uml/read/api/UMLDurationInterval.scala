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
import org.omg.oti.uml.read.operations.UMLDurationIntervalOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A DurationInterval defines the range between two Durations.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDurationInterval[Uml <: UML]
  extends UMLInterval[Uml]
  with UMLDurationIntervalOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Refers to the Duration denoting the maximum value of the range.
    *
    * <!-- Start of user code doc for max -->
    * <!-- End of user code doc for max -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDuration.max_durationInterval
    */
  override def max: Option[UMLDuration[Uml]]

  /**
    * Refers to the Duration denoting the minimum value of the range.
    *
    * <!-- Start of user code doc for min -->
    * <!-- End of user code doc for min -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDuration.min_durationInterval
    */
  override def min: Option[UMLDuration[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      durationInterval_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDurationInterval
    *
    * <!-- Start of user code doc for durationInterval_metaAttributes -->
    * <!-- End of user code doc for durationInterval_metaAttributes -->
    */
  def durationInterval_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     interval_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    durationInterval_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDurationInterval
    *
    * <!-- Start of user code doc for durationInterval_compositeMetaProperties -->
    * <!-- End of user code doc for durationInterval_compositeMetaProperties -->
    */
  def durationInterval_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interval_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    durationInterval_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDurationInterval
    *
    * <!-- Start of user code doc for durationInterval_referenceMetaProperties -->
    * <!-- End of user code doc for durationInterval_referenceMetaProperties -->
    */
  def durationInterval_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interval_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](DurationInterval_max,
      	DurationInterval_min))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    durationInterval_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDurationInterval
    *
    * <!-- Start of user code doc for durationInterval_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for durationInterval_forwardReferencesFromMetamodelAssociations -->
    */
  def durationInterval_forwardReferencesFromMetamodelAssociations: Elements =
    interval_forwardReferencesFromMetamodelAssociations ++
    max ++
    min

  // Start of user code for additional features
  // End of user code
} //UMLDurationInterval
