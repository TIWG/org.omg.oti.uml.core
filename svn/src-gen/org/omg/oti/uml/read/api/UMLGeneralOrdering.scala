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
import org.omg.oti.uml.read.operations.UMLGeneralOrderingOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A GeneralOrdering represents a binary relation between two OccurrenceSpecifications, to describe that one OccurrenceSpecification must occur before the other in a valid trace. This mechanism provides the ability to define partial orders of OccurrenceSpecifications that may otherwise not have a specified order.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLGeneralOrdering[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLGeneralOrderingOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The OccurrenceSpecification referenced comes after the OccurrenceSpecification referenced by before.
    *
    * <!-- Start of user code doc for after -->
    * <!-- End of user code doc for after -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOccurrenceSpecification.toBefore
    */
  def after: Option[UMLOccurrenceSpecification[Uml]]

  /**
    * The OccurrenceSpecification referenced comes before the OccurrenceSpecification referenced by after.
    *
    * <!-- Start of user code doc for before -->
    * <!-- End of user code doc for before -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOccurrenceSpecification.toAfter
    */
  def before: Option[UMLOccurrenceSpecification[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      generalOrdering_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLGeneralOrdering
    *
    * <!-- Start of user code doc for generalOrdering_metaAttributes -->
    * <!-- End of user code doc for generalOrdering_metaAttributes -->
    */
  def generalOrdering_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namedElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    generalOrdering_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLGeneralOrdering
    *
    * <!-- Start of user code doc for generalOrdering_compositeMetaProperties -->
    * <!-- End of user code doc for generalOrdering_compositeMetaProperties -->
    */
  def generalOrdering_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    generalOrdering_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLGeneralOrdering
    *
    * <!-- Start of user code doc for generalOrdering_referenceMetaProperties -->
    * <!-- End of user code doc for generalOrdering_referenceMetaProperties -->
    */
  def generalOrdering_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](GeneralOrdering_after,
      	GeneralOrdering_before))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    generalOrdering_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLGeneralOrdering
    *
    * <!-- Start of user code doc for generalOrdering_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for generalOrdering_forwardReferencesFromMetamodelAssociations -->
    */
  def generalOrdering_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    after ++
    before

  // Start of user code for additional features
  // End of user code
} //UMLGeneralOrdering
