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
import org.omg.oti.uml.read.operations.UMLDestructionOccurrenceSpecificationOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A DestructionOccurenceSpecification models the destruction of an object.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDestructionOccurrenceSpecification[Uml <: UML]
  extends UMLMessageOccurrenceSpecification[Uml]
  with UMLDestructionOccurrenceSpecificationOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      destructionOccurrenceSpecification_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDestructionOccurrenceSpecification
    *
    * <!-- Start of user code doc for destructionOccurrenceSpecification_metaAttributes -->
    * <!-- End of user code doc for destructionOccurrenceSpecification_metaAttributes -->
    */
  def destructionOccurrenceSpecification_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     messageOccurrenceSpecification_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    destructionOccurrenceSpecification_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDestructionOccurrenceSpecification
    *
    * <!-- Start of user code doc for destructionOccurrenceSpecification_compositeMetaProperties -->
    * <!-- End of user code doc for destructionOccurrenceSpecification_compositeMetaProperties -->
    */
  def destructionOccurrenceSpecification_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      messageOccurrenceSpecification_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    destructionOccurrenceSpecification_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDestructionOccurrenceSpecification
    *
    * <!-- Start of user code doc for destructionOccurrenceSpecification_referenceMetaProperties -->
    * <!-- End of user code doc for destructionOccurrenceSpecification_referenceMetaProperties -->
    */
  def destructionOccurrenceSpecification_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      messageOccurrenceSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    destructionOccurrenceSpecification_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDestructionOccurrenceSpecification
    *
    * <!-- Start of user code doc for destructionOccurrenceSpecification_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for destructionOccurrenceSpecification_forwardReferencesFromMetamodelAssociations -->
    */
  def destructionOccurrenceSpecification_forwardReferencesFromMetamodelAssociations: Elements =
    messageOccurrenceSpecification_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLDestructionOccurrenceSpecification
