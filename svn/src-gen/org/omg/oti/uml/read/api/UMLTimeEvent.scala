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
import org.omg.oti.uml.read.operations.UMLTimeEventOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A TimeEvent is an Event that occurs at a specific point in time.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTimeEvent[Uml <: UML]
  extends UMLEvent[Uml]
  with UMLTimeEventOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies whether the TimeEvent is specified as an absolute or relative time.
    *
    * <!-- Start of user code doc for isRelative -->
    * <!-- End of user code doc for isRelative -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isRelative: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      timeEvent_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLTimeEvent
    *
    * <!-- Start of user code doc for timeEvent_metaAttributes -->
    * <!-- End of user code doc for timeEvent_metaAttributes -->
    */
  def timeEvent_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     event_metaAttributes,
     Seq[MetaAttributeFunction](TimeEvent_isRelative))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    timeEvent_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLTimeEvent
    *
    * <!-- Start of user code doc for timeEvent_compositeMetaProperties -->
    * <!-- End of user code doc for timeEvent_compositeMetaProperties -->
    */
  def timeEvent_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      event_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](TimeEvent_when))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    timeEvent_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLTimeEvent
    *
    * <!-- Start of user code doc for timeEvent_referenceMetaProperties -->
    * <!-- End of user code doc for timeEvent_referenceMetaProperties -->
    */
  def timeEvent_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      event_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    timeEvent_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLTimeEvent
    *
    * <!-- Start of user code doc for timeEvent_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for timeEvent_forwardReferencesFromMetamodelAssociations -->
    */
  def timeEvent_forwardReferencesFromMetamodelAssociations: Elements =
    event_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLTimeEvent
