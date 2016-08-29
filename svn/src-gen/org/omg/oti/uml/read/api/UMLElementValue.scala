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
import org.omg.oti.uml.read.operations.UMLElementValueOps
import scala.collection.immutable._
import scala.Option
// End of user code


/**
  * 
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLElementValue[Uml <: UML]
  extends UMLValueSpecification[Uml]
  with UMLElementValueOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * <!-- Start of user code doc for element -->
    * <!-- End of user code doc for element -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElement.element_elementValue
    */
  def element: Option[UMLElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      elementValue_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLElementValue
    *
    * <!-- Start of user code doc for elementValue_metaAttributes -->
    * <!-- End of user code doc for elementValue_metaAttributes -->
    */
  def elementValue_metaAttributes: MetaAttributeFunctions = 
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
    elementValue_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLElementValue
    *
    * <!-- Start of user code doc for elementValue_compositeMetaProperties -->
    * <!-- End of user code doc for elementValue_compositeMetaProperties -->
    */
  def elementValue_compositeMetaProperties: MetaPropertyFunctions = 
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
    elementValue_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLElementValue
    *
    * <!-- Start of user code doc for elementValue_referenceMetaProperties -->
    * <!-- End of user code doc for elementValue_referenceMetaProperties -->
    */
  def elementValue_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      valueSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ElementValue_element))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    elementValue_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLElementValue
    *
    * <!-- Start of user code doc for elementValue_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for elementValue_forwardReferencesFromMetamodelAssociations -->
    */
  def elementValue_forwardReferencesFromMetamodelAssociations: Elements =
    valueSpecification_forwardReferencesFromMetamodelAssociations ++
    element

  // Start of user code for additional features
  // End of user code
} //UMLElementValue
