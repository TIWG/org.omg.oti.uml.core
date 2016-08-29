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
import org.omg.oti.uml.read.operations.UMLInformationItemOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * InformationItems represent many kinds of information that can flow from sources to targets in very abstract ways.? They represent the kinds of information that may move within a system, but do not elaborate details of the transferred information.? Details of transferred information are the province of other Classifiers that may ultimately define InformationItems.? Consequently, InformationItems cannot be instantiated and do not themselves have features, generalizations, or associations.?An important use of InformationItems is to represent information during early design stages, possibly before the detailed modeling decisions that will ultimately define them have been made. Another purpose of InformationItems is to abstract portions of complex models in less precise, but perhaps more general and communicable, ways. 
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInformationItem[Uml <: UML]
  extends UMLClassifier[Uml]
  with UMLInformationItemOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Determines the classifiers that will specify the structure and nature of the information. An information item represents all its represented classifiers.
    *
    * <!-- Start of user code doc for represented -->
    * <!-- End of user code doc for represented -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.represented_representation
    */
  def represented: Set[UMLClassifier[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      informationItem_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInformationItem
    *
    * <!-- Start of user code doc for informationItem_metaAttributes -->
    * <!-- End of user code doc for informationItem_metaAttributes -->
    */
  def informationItem_metaAttributes: MetaAttributeFunctions = 
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
    informationItem_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInformationItem
    *
    * <!-- Start of user code doc for informationItem_compositeMetaProperties -->
    * <!-- End of user code doc for informationItem_compositeMetaProperties -->
    */
  def informationItem_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    informationItem_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInformationItem
    *
    * <!-- Start of user code doc for informationItem_referenceMetaProperties -->
    * <!-- End of user code doc for informationItem_referenceMetaProperties -->
    */
  def informationItem_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](InformationItem_represented))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    informationItem_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInformationItem
    *
    * <!-- Start of user code doc for informationItem_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for informationItem_forwardReferencesFromMetamodelAssociations -->
    */
  def informationItem_forwardReferencesFromMetamodelAssociations: Elements =
    classifier_forwardReferencesFromMetamodelAssociations ++
    represented

  // Start of user code for additional features
  // End of user code
} //UMLInformationItem
