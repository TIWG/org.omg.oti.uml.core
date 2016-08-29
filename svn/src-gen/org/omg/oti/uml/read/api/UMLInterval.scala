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
import org.omg.oti.uml.read.operations.UMLIntervalOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * An Interval defines the range between two ValueSpecifications.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInterval[Uml <: UML]
  extends UMLValueSpecification[Uml]
  with UMLIntervalOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Refers to the ValueSpecification denoting the maximum value of the range.
    *
    * <!-- Start of user code doc for max -->
    * <!-- End of user code doc for max -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.max_interval
    */
  def max: Option[UMLValueSpecification[Uml]]

  /**
    * Refers to the ValueSpecification denoting the minimum value of the range.
    *
    * <!-- Start of user code doc for min -->
    * <!-- End of user code doc for min -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.min_interval
    */
  def min: Option[UMLValueSpecification[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      interval_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInterval
    *
    * <!-- Start of user code doc for interval_metaAttributes -->
    * <!-- End of user code doc for interval_metaAttributes -->
    */
  def interval_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     valueSpecification_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    interval_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInterval
    *
    * <!-- Start of user code doc for interval_compositeMetaProperties -->
    * <!-- End of user code doc for interval_compositeMetaProperties -->
    */
  def interval_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      valueSpecification_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    interval_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInterval
    *
    * <!-- Start of user code doc for interval_referenceMetaProperties -->
    * <!-- End of user code doc for interval_referenceMetaProperties -->
    */
  def interval_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      valueSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Interval_max,
      	Interval_min))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    interval_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInterval
    *
    * <!-- Start of user code doc for interval_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for interval_forwardReferencesFromMetamodelAssociations -->
    */
  def interval_forwardReferencesFromMetamodelAssociations: Elements =
    valueSpecification_forwardReferencesFromMetamodelAssociations ++
    max ++
    min

  // Start of user code for additional features
  // End of user code
} //UMLInterval
