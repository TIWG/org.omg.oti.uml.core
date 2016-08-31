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
import org.omg.oti.uml.read.operations.UMLEventOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An Event is the specification of some occurrence that may potentially trigger effects by an object.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLEvent[Uml <: UML]
  extends UMLPackageableElement[Uml]
  with UMLEventOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * <!-- Start of user code doc for event_trigger -->
    * <!-- End of user code doc for event_trigger -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTrigger.event
    */
  def event_trigger: Set[UMLTrigger[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      event_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLEvent
    *
    * <!-- Start of user code doc for event_metaAttributes -->
    * <!-- End of user code doc for event_metaAttributes -->
    */
  def event_metaAttributes: MetaAttributeFunctions = 
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
    event_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLEvent
    *
    * <!-- Start of user code doc for event_compositeMetaProperties -->
    * <!-- End of user code doc for event_compositeMetaProperties -->
    */
  def event_compositeMetaProperties: MetaPropertyFunctions = 
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
    event_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLEvent
    *
    * <!-- Start of user code doc for event_referenceMetaProperties -->
    * <!-- End of user code doc for event_referenceMetaProperties -->
    */
  def event_referenceMetaProperties: MetaPropertyFunctions = 
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
    event_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLEvent
    *
    * <!-- Start of user code doc for event_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for event_forwardReferencesFromMetamodelAssociations -->
    */
  def event_forwardReferencesFromMetamodelAssociations: Elements =
    packageableElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLEvent
