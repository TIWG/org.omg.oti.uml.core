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
import org.omg.oti.uml.read.operations.UMLMessageOccurrenceSpecificationOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A MessageOccurrenceSpecification specifies the occurrence of Message events, such as sending and receiving of Signals or invoking or receiving of Operation calls. A MessageOccurrenceSpecification is a kind of MessageEnd. Messages are generated either by synchronous Operation calls or asynchronous Signal sends. They are received by the execution of corresponding AcceptEventActions.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLMessageOccurrenceSpecification[Uml <: UML]
  extends UMLMessageEnd[Uml]
	with UMLOccurrenceSpecification[Uml]
  with UMLMessageOccurrenceSpecificationOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      messageOccurrenceSpecification_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLMessageOccurrenceSpecification
    *
    * <!-- Start of user code doc for messageOccurrenceSpecification_metaAttributes -->
    * <!-- End of user code doc for messageOccurrenceSpecification_metaAttributes -->
    */
  def messageOccurrenceSpecification_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     messageEnd_metaAttributes,
     occurrenceSpecification_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    messageOccurrenceSpecification_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLMessageOccurrenceSpecification
    *
    * <!-- Start of user code doc for messageOccurrenceSpecification_compositeMetaProperties -->
    * <!-- End of user code doc for messageOccurrenceSpecification_compositeMetaProperties -->
    */
  def messageOccurrenceSpecification_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      messageEnd_compositeMetaProperties,
      occurrenceSpecification_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    messageOccurrenceSpecification_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLMessageOccurrenceSpecification
    *
    * <!-- Start of user code doc for messageOccurrenceSpecification_referenceMetaProperties -->
    * <!-- End of user code doc for messageOccurrenceSpecification_referenceMetaProperties -->
    */
  def messageOccurrenceSpecification_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      messageEnd_referenceMetaProperties,
      occurrenceSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    messageOccurrenceSpecification_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLMessageOccurrenceSpecification
    *
    * <!-- Start of user code doc for messageOccurrenceSpecification_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for messageOccurrenceSpecification_forwardReferencesFromMetamodelAssociations -->
    */
  def messageOccurrenceSpecification_forwardReferencesFromMetamodelAssociations: Elements =
    messageEnd_forwardReferencesFromMetamodelAssociations ++
    occurrenceSpecification_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLMessageOccurrenceSpecification
