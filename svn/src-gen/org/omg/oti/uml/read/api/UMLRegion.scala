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
import org.omg.oti.uml.read.operations.UMLRegionOps

import scala.collection.immutable.Seq
// End of user code


/**
  * A Region is a top-level part of a StateMachine or a composite State, that serves as a container for the Vertices and Transitions of the StateMachine. A StateMachine or composite State may contain multiple Regions representing behaviors that may occur in parallel.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLRegion[Uml <: UML]
  extends UMLNamespace[Uml]
	with UMLRedefinableElement[Uml]
  with UMLRegionOps[Uml] {

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
      region_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLRegion
    *
    * <!-- Start of user code doc for region_metaAttributes -->
    * <!-- End of user code doc for region_metaAttributes -->
    */
  def region_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namespace_metaAttributes,
     redefinableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    region_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLRegion
    *
    * <!-- Start of user code doc for region_compositeMetaProperties -->
    * <!-- End of user code doc for region_compositeMetaProperties -->
    */
  def region_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namespace_compositeMetaProperties,
      redefinableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Region_subvertex,
      	Region_transition))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    region_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLRegion
    *
    * <!-- Start of user code doc for region_referenceMetaProperties -->
    * <!-- End of user code doc for region_referenceMetaProperties -->
    */
  def region_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namespace_referenceMetaProperties,
      redefinableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Region_extendedRegion))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    region_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLRegion
    *
    * <!-- Start of user code doc for region_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for region_forwardReferencesFromMetamodelAssociations -->
    */
  def region_forwardReferencesFromMetamodelAssociations: Elements =
    namespace_forwardReferencesFromMetamodelAssociations ++
    redefinableElement_forwardReferencesFromMetamodelAssociations ++
    extendedRegion

  // Start of user code for additional features
  // End of user code
} //UMLRegion
