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
import org.omg.oti.uml.read.operations.UMLAbstractionOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An Abstraction is a Relationship that relates two Elements or sets of Elements that represent the same concept at different levels of abstraction or from different viewpoints.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAbstraction[Uml <: UML]
  extends UMLDependency[Uml]
  with UMLAbstractionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      abstraction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLAbstraction
    *
    * <!-- Start of user code doc for abstraction_metaAttributes -->
    * <!-- End of user code doc for abstraction_metaAttributes -->
    */
  def abstraction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     dependency_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    abstraction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLAbstraction
    *
    * <!-- Start of user code doc for abstraction_compositeMetaProperties -->
    * <!-- End of user code doc for abstraction_compositeMetaProperties -->
    */
  def abstraction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      dependency_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Abstraction_mapping))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    abstraction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLAbstraction
    *
    * <!-- Start of user code doc for abstraction_referenceMetaProperties -->
    * <!-- End of user code doc for abstraction_referenceMetaProperties -->
    */
  def abstraction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      dependency_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    abstraction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLAbstraction
    *
    * <!-- Start of user code doc for abstraction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for abstraction_forwardReferencesFromMetamodelAssociations -->
    */
  def abstraction_forwardReferencesFromMetamodelAssociations: Elements =
    dependency_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLAbstraction
