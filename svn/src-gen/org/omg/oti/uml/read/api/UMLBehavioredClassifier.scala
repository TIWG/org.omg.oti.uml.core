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
import org.omg.oti.uml.read.operations.UMLBehavioredClassifierOps

import scala.collection.immutable.Seq
// End of user code


/**
  * A BehavioredClassifier may have InterfaceRealizations, and owns a set of Behaviors one of which may specify the behavior of the BehavioredClassifier itself.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLBehavioredClassifier[Uml <: UML]
  extends UMLClassifier[Uml]
  with UMLBehavioredClassifierOps[Uml] {

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
      behavioredClassifier_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLBehavioredClassifier
    *
    * <!-- Start of user code doc for behavioredClassifier_metaAttributes -->
    * <!-- End of user code doc for behavioredClassifier_metaAttributes -->
    */
  def behavioredClassifier_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     classifier_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    behavioredClassifier_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLBehavioredClassifier
    *
    * <!-- Start of user code doc for behavioredClassifier_compositeMetaProperties -->
    * <!-- End of user code doc for behavioredClassifier_compositeMetaProperties -->
    */
  def behavioredClassifier_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](BehavioredClassifier_interfaceRealization,
      	BehavioredClassifier_ownedBehavior))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    behavioredClassifier_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLBehavioredClassifier
    *
    * <!-- Start of user code doc for behavioredClassifier_referenceMetaProperties -->
    * <!-- End of user code doc for behavioredClassifier_referenceMetaProperties -->
    */
  def behavioredClassifier_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](BehavioredClassifier_classifierBehavior))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    behavioredClassifier_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLBehavioredClassifier
    *
    * <!-- Start of user code doc for behavioredClassifier_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for behavioredClassifier_forwardReferencesFromMetamodelAssociations -->
    */
  def behavioredClassifier_forwardReferencesFromMetamodelAssociations: Elements =
    classifier_forwardReferencesFromMetamodelAssociations ++
    classifierBehavior

  // Start of user code for additional features
  // End of user code
} //UMLBehavioredClassifier
