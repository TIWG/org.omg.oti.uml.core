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
import org.omg.oti.uml.read.operations.UMLReadIsClassifiedObjectActionOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A ReadIsClassifiedObjectAction is an Action that determines whether an object is classified by a given Classifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReadIsClassifiedObjectAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLReadIsClassifiedObjectActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Classifier against which the classification of the input object is tested.
    *
    * <!-- Start of user code doc for classifier -->
    * <!-- End of user code doc for classifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.classifier_readIsClassifiedObjectAction
    */
  def classifier: Option[UMLClassifier[Uml]]

  /**
    * Indicates whether the input object must be directly classified by the given Classifier or whether it may also be an instance of a specialization of the given Classifier.
    *
    * <!-- Start of user code doc for isDirect -->
    * <!-- End of user code doc for isDirect -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isDirect: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      readIsClassifiedObjectAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLReadIsClassifiedObjectAction
    *
    * <!-- Start of user code doc for readIsClassifiedObjectAction_metaAttributes -->
    * <!-- End of user code doc for readIsClassifiedObjectAction_metaAttributes -->
    */
  def readIsClassifiedObjectAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     Seq[MetaAttributeFunction](ReadIsClassifiedObjectAction_isDirect))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    readIsClassifiedObjectAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLReadIsClassifiedObjectAction
    *
    * <!-- Start of user code doc for readIsClassifiedObjectAction_compositeMetaProperties -->
    * <!-- End of user code doc for readIsClassifiedObjectAction_compositeMetaProperties -->
    */
  def readIsClassifiedObjectAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ReadIsClassifiedObjectAction_object,
      	ReadIsClassifiedObjectAction_result))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    readIsClassifiedObjectAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLReadIsClassifiedObjectAction
    *
    * <!-- Start of user code doc for readIsClassifiedObjectAction_referenceMetaProperties -->
    * <!-- End of user code doc for readIsClassifiedObjectAction_referenceMetaProperties -->
    */
  def readIsClassifiedObjectAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ReadIsClassifiedObjectAction_classifier))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    readIsClassifiedObjectAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLReadIsClassifiedObjectAction
    *
    * <!-- Start of user code doc for readIsClassifiedObjectAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for readIsClassifiedObjectAction_forwardReferencesFromMetamodelAssociations -->
    */
  def readIsClassifiedObjectAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    classifier

  // Start of user code for additional features
  // End of user code
} //UMLReadIsClassifiedObjectAction
