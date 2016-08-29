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
import org.omg.oti.uml.read.operations.UMLComponentRealizationOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * Realization is specialized to (optionally) define the Classifiers that realize the contract offered by a Component in terms of its provided and required Interfaces. The Component forms an abstraction from these various Classifiers.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLComponentRealization[Uml <: UML]
  extends UMLRealization[Uml]
  with UMLComponentRealizationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Component that owns this ComponentRealization and which is implemented by its realizing Classifiers.
    *
    * <!-- Start of user code doc for abstraction -->
    * <!-- End of user code doc for abstraction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLComponent.realization
    */
  def abstraction: Option[UMLComponent[Uml]]

  /**
    * The Classifiers that are involved in the implementation of the Component that owns this Realization.
    *
    * <!-- Start of user code doc for realizingClassifier -->
    * <!-- End of user code doc for realizingClassifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.realizingClassifier_componentRealization
    */
  def realizingClassifier: Set[UMLClassifier[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      componentRealization_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLComponentRealization
    *
    * <!-- Start of user code doc for componentRealization_metaAttributes -->
    * <!-- End of user code doc for componentRealization_metaAttributes -->
    */
  def componentRealization_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     realization_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    componentRealization_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLComponentRealization
    *
    * <!-- Start of user code doc for componentRealization_compositeMetaProperties -->
    * <!-- End of user code doc for componentRealization_compositeMetaProperties -->
    */
  def componentRealization_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      realization_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    componentRealization_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLComponentRealization
    *
    * <!-- Start of user code doc for componentRealization_referenceMetaProperties -->
    * <!-- End of user code doc for componentRealization_referenceMetaProperties -->
    */
  def componentRealization_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      realization_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ComponentRealization_realizingClassifier))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    componentRealization_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLComponentRealization
    *
    * <!-- Start of user code doc for componentRealization_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for componentRealization_forwardReferencesFromMetamodelAssociations -->
    */
  def componentRealization_forwardReferencesFromMetamodelAssociations: Elements =
    realization_forwardReferencesFromMetamodelAssociations ++
    realizingClassifier

  // Start of user code for additional features
  // End of user code
} //UMLComponentRealization
