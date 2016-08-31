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
import org.omg.oti.uml.read.operations.UMLFeatureOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Feature declares a behavioral or structural characteristic of Classifiers.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLFeature[Uml <: UML]
  extends UMLRedefinableElement[Uml]
  with UMLFeatureOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Classifiers that have this Feature as a feature.
    *
    * <!-- Start of user code doc for featuringClassifier -->
    * <!-- End of user code doc for featuringClassifier -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.feature
    */
  def featuringClassifier: Option[UMLClassifier[Uml]]

  /**
    * Specifies whether this Feature characterizes individual instances classified by the Classifier (false) or the Classifier itself (true).
    *
    * <!-- Start of user code doc for isStatic -->
    * <!-- End of user code doc for isStatic -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isStatic: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      feature_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLFeature
    *
    * <!-- Start of user code doc for feature_metaAttributes -->
    * <!-- End of user code doc for feature_metaAttributes -->
    */
  def feature_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     redefinableElement_metaAttributes,
     Seq[MetaAttributeFunction](Feature_isStatic))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    feature_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLFeature
    *
    * <!-- Start of user code doc for feature_compositeMetaProperties -->
    * <!-- End of user code doc for feature_compositeMetaProperties -->
    */
  def feature_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      redefinableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    feature_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLFeature
    *
    * <!-- Start of user code doc for feature_referenceMetaProperties -->
    * <!-- End of user code doc for feature_referenceMetaProperties -->
    */
  def feature_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      redefinableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    feature_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLFeature
    *
    * <!-- Start of user code doc for feature_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for feature_forwardReferencesFromMetamodelAssociations -->
    */
  def feature_forwardReferencesFromMetamodelAssociations: Elements =
    redefinableElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLFeature
