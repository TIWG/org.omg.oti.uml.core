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
import org.omg.oti.uml.read.operations.UMLStructuralFeatureOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A StructuralFeature is a typed feature of a Classifier that specifies the structure of instances of the Classifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStructuralFeature[Uml <: UML]
  extends UMLFeature[Uml]
	with UMLMultiplicityElement[Uml]
	with UMLTypedElement[Uml]
  with UMLStructuralFeatureOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * If isReadOnly is true, the StructuralFeature may not be written to after initialization.
    *
    * <!-- Start of user code doc for isReadOnly -->
    * <!-- End of user code doc for isReadOnly -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isReadOnly: Boolean

  /**
    * <!-- Start of user code doc for definingFeature_slot -->
    * <!-- End of user code doc for definingFeature_slot -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSlot.definingFeature
    */
  def definingFeature_slot: Set[UMLSlot[Uml]]

  /**
    * <!-- Start of user code doc for structuralFeature_structuralFeatureAction -->
    * <!-- End of user code doc for structuralFeature_structuralFeatureAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuralFeatureAction.structuralFeature
    */
  def structuralFeature_structuralFeatureAction: Set[UMLStructuralFeatureAction[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      structuralFeature_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLStructuralFeature
    *
    * <!-- Start of user code doc for structuralFeature_metaAttributes -->
    * <!-- End of user code doc for structuralFeature_metaAttributes -->
    */
  def structuralFeature_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     feature_metaAttributes,
     multiplicityElement_metaAttributes,
     typedElement_metaAttributes,
     Seq[MetaAttributeFunction](StructuralFeature_isReadOnly))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    structuralFeature_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLStructuralFeature
    *
    * <!-- Start of user code doc for structuralFeature_compositeMetaProperties -->
    * <!-- End of user code doc for structuralFeature_compositeMetaProperties -->
    */
  def structuralFeature_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      feature_compositeMetaProperties,
      multiplicityElement_compositeMetaProperties,
      typedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    structuralFeature_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLStructuralFeature
    *
    * <!-- Start of user code doc for structuralFeature_referenceMetaProperties -->
    * <!-- End of user code doc for structuralFeature_referenceMetaProperties -->
    */
  def structuralFeature_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      feature_referenceMetaProperties,
      multiplicityElement_referenceMetaProperties,
      typedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    structuralFeature_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLStructuralFeature
    *
    * <!-- Start of user code doc for structuralFeature_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for structuralFeature_forwardReferencesFromMetamodelAssociations -->
    */
  def structuralFeature_forwardReferencesFromMetamodelAssociations: Elements =
    feature_forwardReferencesFromMetamodelAssociations ++
    multiplicityElement_forwardReferencesFromMetamodelAssociations ++
    typedElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLStructuralFeature
