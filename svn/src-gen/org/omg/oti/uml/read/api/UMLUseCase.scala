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
import org.omg.oti.uml.read.operations.UMLUseCaseOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A UseCase specifies a set of actions performed by its subjects, which yields an observable result that is of value for one or more Actors or other stakeholders of each subject.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLUseCase[Uml <: UML]
  extends UMLBehavioredClassifier[Uml]
  with UMLUseCaseOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The subjects to which this UseCase applies. Each subject or its parts realize all the UseCases that apply to it.
    *
    * <!-- Start of user code doc for subject -->
    * <!-- End of user code doc for subject -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.useCase
    */
  def subject: Set[UMLClassifier[Uml]]

  /**
    * <!-- Start of user code doc for ownedUseCase_classifier -->
    * <!-- End of user code doc for ownedUseCase_classifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.ownedUseCase
    */
  def ownedUseCase_classifier: Option[UMLClassifier[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      useCase_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLUseCase
    *
    * <!-- Start of user code doc for useCase_metaAttributes -->
    * <!-- End of user code doc for useCase_metaAttributes -->
    */
  def useCase_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     behavioredClassifier_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    useCase_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLUseCase
    *
    * <!-- Start of user code doc for useCase_compositeMetaProperties -->
    * <!-- End of user code doc for useCase_compositeMetaProperties -->
    */
  def useCase_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavioredClassifier_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](UseCase_extend,
      	UseCase_extensionPoint,
      	UseCase_include))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    useCase_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLUseCase
    *
    * <!-- Start of user code doc for useCase_referenceMetaProperties -->
    * <!-- End of user code doc for useCase_referenceMetaProperties -->
    */
  def useCase_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavioredClassifier_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](UseCase_subject))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    useCase_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLUseCase
    *
    * <!-- Start of user code doc for useCase_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for useCase_forwardReferencesFromMetamodelAssociations -->
    */
  def useCase_forwardReferencesFromMetamodelAssociations: Elements =
    behavioredClassifier_forwardReferencesFromMetamodelAssociations ++
    subject

  // Start of user code for additional features
  // End of user code
} //UMLUseCase
