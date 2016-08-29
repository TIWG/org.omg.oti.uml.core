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
import org.omg.oti.uml.read.operations.UMLClearStructuralFeatureActionOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ClearStructuralFeatureAction is a StructuralFeatureAction that removes all values of a StructuralFeature.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLClearStructuralFeatureAction[Uml <: UML]
  extends UMLStructuralFeatureAction[Uml]
  with UMLClearStructuralFeatureActionOps[Uml] {

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
      clearStructuralFeatureAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLClearStructuralFeatureAction
    *
    * <!-- Start of user code doc for clearStructuralFeatureAction_metaAttributes -->
    * <!-- End of user code doc for clearStructuralFeatureAction_metaAttributes -->
    */
  def clearStructuralFeatureAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     structuralFeatureAction_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    clearStructuralFeatureAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLClearStructuralFeatureAction
    *
    * <!-- Start of user code doc for clearStructuralFeatureAction_compositeMetaProperties -->
    * <!-- End of user code doc for clearStructuralFeatureAction_compositeMetaProperties -->
    */
  def clearStructuralFeatureAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      structuralFeatureAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ClearStructuralFeatureAction_result))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    clearStructuralFeatureAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLClearStructuralFeatureAction
    *
    * <!-- Start of user code doc for clearStructuralFeatureAction_referenceMetaProperties -->
    * <!-- End of user code doc for clearStructuralFeatureAction_referenceMetaProperties -->
    */
  def clearStructuralFeatureAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      structuralFeatureAction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    clearStructuralFeatureAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLClearStructuralFeatureAction
    *
    * <!-- Start of user code doc for clearStructuralFeatureAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for clearStructuralFeatureAction_forwardReferencesFromMetamodelAssociations -->
    */
  def clearStructuralFeatureAction_forwardReferencesFromMetamodelAssociations: Elements =
    structuralFeatureAction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLClearStructuralFeatureAction
