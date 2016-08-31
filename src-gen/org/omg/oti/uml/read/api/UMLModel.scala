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
import org.omg.oti.uml.read.operations.UMLModelOps

import scala.Predef.String
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A model captures a view of a physical system. It is an abstraction of the physical system, with a certain purpose. This purpose determines what is to be included in the model and what is irrelevant. Thus the model completely describes those aspects of the physical system that are relevant to the purpose of the model, at the appropriate level of detail.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLModel[Uml <: UML]
  extends UMLPackage[Uml]
  with UMLModelOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The name of the viewpoint that is expressed by a model (this name may refer to a profile definition).
    *
    * <!-- Start of user code doc for viewpoint -->
    * <!-- End of user code doc for viewpoint -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def viewpoint: Option[String]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      model_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLModel
    *
    * <!-- Start of user code doc for model_metaAttributes -->
    * <!-- End of user code doc for model_metaAttributes -->
    */
  def model_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     package_metaAttributes,
     Seq[MetaAttributeFunction](Model_viewpoint))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    model_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLModel
    *
    * <!-- Start of user code doc for model_compositeMetaProperties -->
    * <!-- End of user code doc for model_compositeMetaProperties -->
    */
  def model_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      package_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    model_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLModel
    *
    * <!-- Start of user code doc for model_referenceMetaProperties -->
    * <!-- End of user code doc for model_referenceMetaProperties -->
    */
  def model_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      package_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    model_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLModel
    *
    * <!-- Start of user code doc for model_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for model_forwardReferencesFromMetamodelAssociations -->
    */
  def model_forwardReferencesFromMetamodelAssociations: Elements =
    package_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLModel
