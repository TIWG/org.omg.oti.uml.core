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
import org.omg.oti.uml.read.operations.UMLWriteStructuralFeatureActionOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * WriteStructuralFeatureAction is an abstract class for StructuralFeatureActions that change StructuralFeature values.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLWriteStructuralFeatureAction[Uml <: UML]
  extends UMLStructuralFeatureAction[Uml]
  with UMLWriteStructuralFeatureActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The InputPin that provides the value to be added or removed from the StructuralFeature.
    *
    * <!-- Start of user code doc for value -->
    * <!-- End of user code doc for value -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.value_writeStructuralFeatureAction
    */
  def value: Option[UMLInputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      writeStructuralFeatureAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLWriteStructuralFeatureAction
    *
    * <!-- Start of user code doc for writeStructuralFeatureAction_metaAttributes -->
    * <!-- End of user code doc for writeStructuralFeatureAction_metaAttributes -->
    */
  def writeStructuralFeatureAction_metaAttributes: MetaAttributeFunctions = 
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
    writeStructuralFeatureAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLWriteStructuralFeatureAction
    *
    * <!-- Start of user code doc for writeStructuralFeatureAction_compositeMetaProperties -->
    * <!-- End of user code doc for writeStructuralFeatureAction_compositeMetaProperties -->
    */
  def writeStructuralFeatureAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      structuralFeatureAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](WriteStructuralFeatureAction_result,
      	WriteStructuralFeatureAction_value))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    writeStructuralFeatureAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLWriteStructuralFeatureAction
    *
    * <!-- Start of user code doc for writeStructuralFeatureAction_referenceMetaProperties -->
    * <!-- End of user code doc for writeStructuralFeatureAction_referenceMetaProperties -->
    */
  def writeStructuralFeatureAction_referenceMetaProperties: MetaPropertyFunctions = 
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
    writeStructuralFeatureAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLWriteStructuralFeatureAction
    *
    * <!-- Start of user code doc for writeStructuralFeatureAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for writeStructuralFeatureAction_forwardReferencesFromMetamodelAssociations -->
    */
  def writeStructuralFeatureAction_forwardReferencesFromMetamodelAssociations: Elements =
    structuralFeatureAction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLWriteStructuralFeatureAction
