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
import org.omg.oti.uml.read.operations.UMLSlotOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A Slot designates that an entity modeled by an InstanceSpecification has a value or values for a specific StructuralFeature.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLSlot[Uml <: UML]
  extends UMLElement[Uml]
  with UMLSlotOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The StructuralFeature that specifies the values that may be held by the Slot.
    *
    * <!-- Start of user code doc for definingFeature -->
    * <!-- End of user code doc for definingFeature -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuralFeature.definingFeature_slot
    */
  def definingFeature: Option[UMLStructuralFeature[Uml]]

  /**
    * The value or values held by the Slot.
    *
    * <!-- Start of user code doc for value -->
    * <!-- End of user code doc for value -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.value_owningSlot
    */
  def value: Seq[UMLValueSpecification[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      slot_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLSlot
    *
    * <!-- Start of user code doc for slot_metaAttributes -->
    * <!-- End of user code doc for slot_metaAttributes -->
    */
  def slot_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     element_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    slot_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLSlot
    *
    * <!-- Start of user code doc for slot_compositeMetaProperties -->
    * <!-- End of user code doc for slot_compositeMetaProperties -->
    */
  def slot_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Slot_value))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    slot_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLSlot
    *
    * <!-- Start of user code doc for slot_referenceMetaProperties -->
    * <!-- End of user code doc for slot_referenceMetaProperties -->
    */
  def slot_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Slot_definingFeature))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    slot_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLSlot
    *
    * <!-- Start of user code doc for slot_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for slot_forwardReferencesFromMetamodelAssociations -->
    */
  def slot_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    definingFeature

  // Start of user code for additional features
  // End of user code
} //UMLSlot
