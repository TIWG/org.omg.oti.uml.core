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
import org.omg.oti.uml.read.operations.UMLLifelineOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Lifeline represents an individual participant in the Interaction. While parts and structural features may have multiplicity greater than 1, Lifelines represent only one interacting entity.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLifeline[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLLifelineOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * References the InteractionFragments in which this Lifeline takes part.
    *
    * <!-- Start of user code doc for coveredBy -->
    * <!-- End of user code doc for coveredBy -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionFragment.covered
    */
  def coveredBy: Set[UMLInteractionFragment[Uml]]

  /**
    * References the Interaction that represents the decomposition.
    *
    * <!-- Start of user code doc for decomposedAs -->
    * <!-- End of user code doc for decomposedAs -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPartDecomposition.decomposedAs_lifeline
    */
  def decomposedAs: Option[UMLPartDecomposition[Uml]]

  /**
    * References the ConnectableElement within the classifier that contains the enclosing interaction.
    *
    * <!-- Start of user code doc for represents -->
    * <!-- End of user code doc for represents -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnectableElement.represents_lifeline
    */
  def represents: Option[UMLConnectableElement[Uml]]

  /**
    * If the referenced ConnectableElement is multivalued, then this specifies the specific individual part within that set.
    *
    * <!-- Start of user code doc for selector -->
    * <!-- End of user code doc for selector -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.selector_lifeline
    */
  def selector: Option[UMLValueSpecification[Uml]]

  /**
    * <!-- Start of user code doc for covered_events -->
    * <!-- End of user code doc for covered_events -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOccurrenceSpecification.covered
    */
  def covered_events: Seq[UMLOccurrenceSpecification[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      lifeline_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLLifeline
    *
    * <!-- Start of user code doc for lifeline_metaAttributes -->
    * <!-- End of user code doc for lifeline_metaAttributes -->
    */
  def lifeline_metaAttributes: MetaAttributeFunctions = 
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
    lifeline_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLLifeline
    *
    * <!-- Start of user code doc for lifeline_compositeMetaProperties -->
    * <!-- End of user code doc for lifeline_compositeMetaProperties -->
    */
  def lifeline_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Lifeline_selector))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    lifeline_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLLifeline
    *
    * <!-- Start of user code doc for lifeline_referenceMetaProperties -->
    * <!-- End of user code doc for lifeline_referenceMetaProperties -->
    */
  def lifeline_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Lifeline_coveredBy,
      	Lifeline_decomposedAs,
      	Lifeline_represents))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    lifeline_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLLifeline
    *
    * <!-- Start of user code doc for lifeline_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for lifeline_forwardReferencesFromMetamodelAssociations -->
    */
  def lifeline_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    coveredBy ++
    decomposedAs ++
    represents

  // Start of user code for additional features
  // End of user code
} //UMLLifeline
