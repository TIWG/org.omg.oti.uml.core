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
import org.omg.oti.uml.read.operations.UMLObservationOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * Observation specifies a value determined by observing an event or events that occur relative to other model Elements.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLObservation[Uml <: UML]
  extends UMLPackageableElement[Uml]
  with UMLObservationOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * <!-- Start of user code doc for observation_duration -->
    * <!-- End of user code doc for observation_duration -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDuration.observation
    */
  def observation_duration: Option[UMLDuration[Uml]]

  /**
    * <!-- Start of user code doc for observation_timeExpression -->
    * <!-- End of user code doc for observation_timeExpression -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTimeExpression.observation
    */
  def observation_timeExpression: Option[UMLTimeExpression[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      observation_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLObservation
    *
    * <!-- Start of user code doc for observation_metaAttributes -->
    * <!-- End of user code doc for observation_metaAttributes -->
    */
  def observation_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     packageableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    observation_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLObservation
    *
    * <!-- Start of user code doc for observation_compositeMetaProperties -->
    * <!-- End of user code doc for observation_compositeMetaProperties -->
    */
  def observation_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      packageableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    observation_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLObservation
    *
    * <!-- Start of user code doc for observation_referenceMetaProperties -->
    * <!-- End of user code doc for observation_referenceMetaProperties -->
    */
  def observation_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      packageableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    observation_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLObservation
    *
    * <!-- Start of user code doc for observation_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for observation_forwardReferencesFromMetamodelAssociations -->
    */
  def observation_forwardReferencesFromMetamodelAssociations: Elements =
    packageableElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLObservation
