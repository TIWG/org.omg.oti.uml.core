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
import org.omg.oti.uml.read.operations.UMLRealizationOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * Realization is a specialized Abstraction relationship between two sets of model Elements, one representing a specification (the supplier) and the other represents an implementation of the latter (the client). Realization can be used to model stepwise refinement, optimizations, transformations, templates, model synthesis, framework composition, etc.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLRealization[Uml <: UML]
  extends UMLAbstraction[Uml]
  with UMLRealizationOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      realization_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLRealization
    *
    * <!-- Start of user code doc for realization_metaAttributes -->
    * <!-- End of user code doc for realization_metaAttributes -->
    */
  def realization_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     abstraction_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    realization_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLRealization
    *
    * <!-- Start of user code doc for realization_compositeMetaProperties -->
    * <!-- End of user code doc for realization_compositeMetaProperties -->
    */
  def realization_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      abstraction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    realization_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLRealization
    *
    * <!-- Start of user code doc for realization_referenceMetaProperties -->
    * <!-- End of user code doc for realization_referenceMetaProperties -->
    */
  def realization_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      abstraction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    realization_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLRealization
    *
    * <!-- Start of user code doc for realization_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for realization_forwardReferencesFromMetamodelAssociations -->
    */
  def realization_forwardReferencesFromMetamodelAssociations: Elements =
    abstraction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLRealization
