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
import org.omg.oti.uml.read.operations.UMLReadExtentActionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A ReadExtentAction is an Action that retrieves the current instances of a Classifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReadExtentAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLReadExtentActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Classifier whose instances are to be retrieved.
    *
    * <!-- Start of user code doc for classifier -->
    * <!-- End of user code doc for classifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.classifier_readExtentAction
    */
  def classifier: Option[UMLClassifier[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      readExtentAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLReadExtentAction
    *
    * <!-- Start of user code doc for readExtentAction_metaAttributes -->
    * <!-- End of user code doc for readExtentAction_metaAttributes -->
    */
  def readExtentAction_metaAttributes: MetaAttributeFunctions = 
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
    readExtentAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLReadExtentAction
    *
    * <!-- Start of user code doc for readExtentAction_compositeMetaProperties -->
    * <!-- End of user code doc for readExtentAction_compositeMetaProperties -->
    */
  def readExtentAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ReadExtentAction_result))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    readExtentAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLReadExtentAction
    *
    * <!-- Start of user code doc for readExtentAction_referenceMetaProperties -->
    * <!-- End of user code doc for readExtentAction_referenceMetaProperties -->
    */
  def readExtentAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ReadExtentAction_classifier))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    readExtentAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLReadExtentAction
    *
    * <!-- Start of user code doc for readExtentAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for readExtentAction_forwardReferencesFromMetamodelAssociations -->
    */
  def readExtentAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    classifier

  // Start of user code for additional features
  // End of user code
} //UMLReadExtentAction
