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
import org.omg.oti.uml.read.operations.UMLStructuralFeatureActionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * StructuralFeatureAction is an abstract class for all Actions that operate on StructuralFeatures.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStructuralFeatureAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLStructuralFeatureActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The StructuralFeature to be read or written.
    *
    * <!-- Start of user code doc for structuralFeature -->
    * <!-- End of user code doc for structuralFeature -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuralFeature.structuralFeature_structuralFeatureAction
    */
  def structuralFeature: Option[UMLStructuralFeature[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      structuralFeatureAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLStructuralFeatureAction
    *
    * <!-- Start of user code doc for structuralFeatureAction_metaAttributes -->
    * <!-- End of user code doc for structuralFeatureAction_metaAttributes -->
    */
  def structuralFeatureAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    structuralFeatureAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLStructuralFeatureAction
    *
    * <!-- Start of user code doc for structuralFeatureAction_compositeMetaProperties -->
    * <!-- End of user code doc for structuralFeatureAction_compositeMetaProperties -->
    */
  def structuralFeatureAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](StructuralFeatureAction_object))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    structuralFeatureAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLStructuralFeatureAction
    *
    * <!-- Start of user code doc for structuralFeatureAction_referenceMetaProperties -->
    * <!-- End of user code doc for structuralFeatureAction_referenceMetaProperties -->
    */
  def structuralFeatureAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](StructuralFeatureAction_structuralFeature))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    structuralFeatureAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLStructuralFeatureAction
    *
    * <!-- Start of user code doc for structuralFeatureAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for structuralFeatureAction_forwardReferencesFromMetamodelAssociations -->
    */
  def structuralFeatureAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    structuralFeature

  // Start of user code for additional features
  // End of user code
} //UMLStructuralFeatureAction
