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
import org.omg.oti.uml.read.operations.UMLClassifierTemplateParameterOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ClassifierTemplateParameter exposes a Classifier as a formal template parameter.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLClassifierTemplateParameter[Uml <: UML]
  extends UMLTemplateParameter[Uml]
  with UMLClassifierTemplateParameterOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Constrains the required relationship between an actual parameter and the parameteredElement for this formal parameter.
    *
    * <!-- Start of user code doc for allowSubstitutable -->
    * <!-- End of user code doc for allowSubstitutable -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def allowSubstitutable: Boolean

  /**
    * The classifiers that constrain the argument that can be used for the parameter. If the allowSubstitutable attribute is true, then any Classifier that is compatible with this constraining Classifier can be substituted; otherwise, it must be either this Classifier or one of its specializations. If this property is empty, there are no constraints on the Classifier that can be used as an argument.
    *
    * <!-- Start of user code doc for constrainingClassifier -->
    * <!-- End of user code doc for constrainingClassifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.constrainingClassifier_classifierTemplateParameter
    */
  def constrainingClassifier: Set[UMLClassifier[Uml]]

  /**
    * The Classifier exposed by this ClassifierTemplateParameter.
    *
    * <!-- Start of user code doc for parameteredElement -->
    * <!-- End of user code doc for parameteredElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.templateParameter
    */
  override def parameteredElement: Option[UMLClassifier[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      classifierTemplateParameter_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLClassifierTemplateParameter
    *
    * <!-- Start of user code doc for classifierTemplateParameter_metaAttributes -->
    * <!-- End of user code doc for classifierTemplateParameter_metaAttributes -->
    */
  def classifierTemplateParameter_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     templateParameter_metaAttributes,
     Seq[MetaAttributeFunction](ClassifierTemplateParameter_allowSubstitutable))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    classifierTemplateParameter_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLClassifierTemplateParameter
    *
    * <!-- Start of user code doc for classifierTemplateParameter_compositeMetaProperties -->
    * <!-- End of user code doc for classifierTemplateParameter_compositeMetaProperties -->
    */
  def classifierTemplateParameter_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      templateParameter_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    classifierTemplateParameter_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLClassifierTemplateParameter
    *
    * <!-- Start of user code doc for classifierTemplateParameter_referenceMetaProperties -->
    * <!-- End of user code doc for classifierTemplateParameter_referenceMetaProperties -->
    */
  def classifierTemplateParameter_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      templateParameter_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ClassifierTemplateParameter_constrainingClassifier,
      	ClassifierTemplateParameter_parameteredElement))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    classifierTemplateParameter_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLClassifierTemplateParameter
    *
    * <!-- Start of user code doc for classifierTemplateParameter_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for classifierTemplateParameter_forwardReferencesFromMetamodelAssociations -->
    */
  def classifierTemplateParameter_forwardReferencesFromMetamodelAssociations: Elements =
    templateParameter_forwardReferencesFromMetamodelAssociations ++
    constrainingClassifier ++
    parameteredElement

  // Start of user code for additional features
  // End of user code
} //UMLClassifierTemplateParameter
