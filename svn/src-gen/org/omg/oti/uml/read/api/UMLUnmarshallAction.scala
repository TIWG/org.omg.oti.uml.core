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
import org.omg.oti.uml.read.operations.UMLUnmarshallActionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * An UnmarshallAction is an Action that retrieves the values of the StructuralFeatures of an object and places them on OutputPins. 
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLUnmarshallAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLUnmarshallActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The OutputPins on which are placed the values of the StructuralFeatures of the input object.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_unmarshallAction
    */
  def result: Seq[UMLOutputPin[Uml]]

  /**
    * The type of the object to be unmarshalled.
    *
    * <!-- Start of user code doc for unmarshallType -->
    * <!-- End of user code doc for unmarshallType -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.unmarshallType_unmarshallAction
    */
  def unmarshallType: Option[UMLClassifier[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      unmarshallAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLUnmarshallAction
    *
    * <!-- Start of user code doc for unmarshallAction_metaAttributes -->
    * <!-- End of user code doc for unmarshallAction_metaAttributes -->
    */
  def unmarshallAction_metaAttributes: MetaAttributeFunctions = 
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
    unmarshallAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLUnmarshallAction
    *
    * <!-- Start of user code doc for unmarshallAction_compositeMetaProperties -->
    * <!-- End of user code doc for unmarshallAction_compositeMetaProperties -->
    */
  def unmarshallAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](UnmarshallAction_object,
      	UnmarshallAction_result))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    unmarshallAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLUnmarshallAction
    *
    * <!-- Start of user code doc for unmarshallAction_referenceMetaProperties -->
    * <!-- End of user code doc for unmarshallAction_referenceMetaProperties -->
    */
  def unmarshallAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](UnmarshallAction_unmarshallType))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    unmarshallAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLUnmarshallAction
    *
    * <!-- Start of user code doc for unmarshallAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for unmarshallAction_forwardReferencesFromMetamodelAssociations -->
    */
  def unmarshallAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    unmarshallType

  // Start of user code for additional features
  // End of user code
} //UMLUnmarshallAction
