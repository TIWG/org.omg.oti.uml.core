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
import org.omg.oti.uml.read.operations.UMLLinkEndDataOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * LinkEndData is an Element that identifies on end of a link to be read or written by a LinkAction. As a link (that is not a link object) cannot be passed as a runtime value to or from an Action, it is instead identified by its end objects and qualifier values, if any. A LinkEndData instance provides these values for a single Association end.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLinkEndData[Uml <: UML]
  extends UMLElement[Uml]
  with UMLLinkEndDataOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Association?end?for?which?this?LinkEndData?specifies?values.
    *
    * <!-- Start of user code doc for end -->
    * <!-- End of user code doc for end -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.end_linkEndData
    */
  def end: Option[UMLProperty[Uml]]

  /**
    * The InputPin that provides the specified value for the given end. This InputPin is omitted if the LinkEndData specifies the "open" end for a ReadLinkAction.
    *
    * <!-- Start of user code doc for value -->
    * <!-- End of user code doc for value -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.value_linkEndData
    */
  def value: Option[UMLInputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      linkEndData_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLLinkEndData
    *
    * <!-- Start of user code doc for linkEndData_metaAttributes -->
    * <!-- End of user code doc for linkEndData_metaAttributes -->
    */
  def linkEndData_metaAttributes: MetaAttributeFunctions = 
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
    linkEndData_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLLinkEndData
    *
    * <!-- Start of user code doc for linkEndData_compositeMetaProperties -->
    * <!-- End of user code doc for linkEndData_compositeMetaProperties -->
    */
  def linkEndData_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](LinkEndData_qualifier))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    linkEndData_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLLinkEndData
    *
    * <!-- Start of user code doc for linkEndData_referenceMetaProperties -->
    * <!-- End of user code doc for linkEndData_referenceMetaProperties -->
    */
  def linkEndData_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](LinkEndData_end,
      	LinkEndData_value))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    linkEndData_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLLinkEndData
    *
    * <!-- Start of user code doc for linkEndData_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for linkEndData_forwardReferencesFromMetamodelAssociations -->
    */
  def linkEndData_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    end ++
    value

  // Start of user code for additional features
  // End of user code
} //UMLLinkEndData
