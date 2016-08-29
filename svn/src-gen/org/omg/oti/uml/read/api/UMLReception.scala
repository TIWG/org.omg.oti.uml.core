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
import org.omg.oti.uml.read.operations.UMLReceptionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A Reception is a declaration stating that a Classifier is prepared to react to the receipt of a Signal.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReception[Uml <: UML]
  extends UMLBehavioralFeature[Uml]
  with UMLReceptionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Signal that this Reception handles.
    *
    * <!-- Start of user code doc for signal -->
    * <!-- End of user code doc for signal -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSignal.signal_reception
    */
  def signal: Option[UMLSignal[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      reception_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLReception
    *
    * <!-- Start of user code doc for reception_metaAttributes -->
    * <!-- End of user code doc for reception_metaAttributes -->
    */
  def reception_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     behavioralFeature_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    reception_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLReception
    *
    * <!-- Start of user code doc for reception_compositeMetaProperties -->
    * <!-- End of user code doc for reception_compositeMetaProperties -->
    */
  def reception_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavioralFeature_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    reception_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLReception
    *
    * <!-- Start of user code doc for reception_referenceMetaProperties -->
    * <!-- End of user code doc for reception_referenceMetaProperties -->
    */
  def reception_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavioralFeature_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Reception_signal))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    reception_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLReception
    *
    * <!-- Start of user code doc for reception_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for reception_forwardReferencesFromMetamodelAssociations -->
    */
  def reception_forwardReferencesFromMetamodelAssociations: Elements =
    behavioralFeature_forwardReferencesFromMetamodelAssociations ++
    signal

  // Start of user code for additional features
  // End of user code
} //UMLReception
