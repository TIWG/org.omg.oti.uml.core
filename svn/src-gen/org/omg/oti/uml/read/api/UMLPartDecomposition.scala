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
import org.omg.oti.uml.read.operations.UMLPartDecompositionOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A PartDecomposition is a description of the internal Interactions of one Lifeline relative to an Interaction.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPartDecomposition[Uml <: UML]
  extends UMLInteractionUse[Uml]
  with UMLPartDecompositionOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * <!-- Start of user code doc for decomposedAs_lifeline -->
    * <!-- End of user code doc for decomposedAs_lifeline -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLifeline.decomposedAs
    */
  def decomposedAs_lifeline: Option[UMLLifeline[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      partDecomposition_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLPartDecomposition
    *
    * <!-- Start of user code doc for partDecomposition_metaAttributes -->
    * <!-- End of user code doc for partDecomposition_metaAttributes -->
    */
  def partDecomposition_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     interactionUse_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    partDecomposition_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLPartDecomposition
    *
    * <!-- Start of user code doc for partDecomposition_compositeMetaProperties -->
    * <!-- End of user code doc for partDecomposition_compositeMetaProperties -->
    */
  def partDecomposition_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interactionUse_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    partDecomposition_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLPartDecomposition
    *
    * <!-- Start of user code doc for partDecomposition_referenceMetaProperties -->
    * <!-- End of user code doc for partDecomposition_referenceMetaProperties -->
    */
  def partDecomposition_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interactionUse_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    partDecomposition_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLPartDecomposition
    *
    * <!-- Start of user code doc for partDecomposition_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for partDecomposition_forwardReferencesFromMetamodelAssociations -->
    */
  def partDecomposition_forwardReferencesFromMetamodelAssociations: Elements =
    interactionUse_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLPartDecomposition
