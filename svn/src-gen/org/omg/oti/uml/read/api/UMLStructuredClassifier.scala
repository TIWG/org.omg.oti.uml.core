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
import org.omg.oti.uml.read.operations.UMLStructuredClassifierOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * StructuredClassifiers may contain an internal structure of connected elements each of which plays a role in the overall Behavior modeled by the StructuredClassifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStructuredClassifier[Uml <: UML]
  extends UMLClassifier[Uml]
  with UMLStructuredClassifierOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Properties owned by the StructuredClassifier.
    *
    * <!-- Start of user code doc for ownedAttribute -->
    * <!-- End of user code doc for ownedAttribute -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.ownedAttribute_structuredClassifier
    */
  def ownedAttribute: Seq[UMLProperty[Uml]]

  /**
    * The roles that instances may play in this StructuredClassifier.
    *
    * <!-- Start of user code doc for role -->
    * <!-- End of user code doc for role -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnectableElement.role_structuredClassifier
    */
  def role: Set[UMLConnectableElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      structuredClassifier_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLStructuredClassifier
    *
    * <!-- Start of user code doc for structuredClassifier_metaAttributes -->
    * <!-- End of user code doc for structuredClassifier_metaAttributes -->
    */
  def structuredClassifier_metaAttributes: MetaAttributeFunctions = 
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
    structuredClassifier_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLStructuredClassifier
    *
    * <!-- Start of user code doc for structuredClassifier_compositeMetaProperties -->
    * <!-- End of user code doc for structuredClassifier_compositeMetaProperties -->
    */
  def structuredClassifier_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](StructuredClassifier_ownedAttribute,
      	StructuredClassifier_ownedConnector))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    structuredClassifier_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLStructuredClassifier
    *
    * <!-- Start of user code doc for structuredClassifier_referenceMetaProperties -->
    * <!-- End of user code doc for structuredClassifier_referenceMetaProperties -->
    */
  def structuredClassifier_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    structuredClassifier_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLStructuredClassifier
    *
    * <!-- Start of user code doc for structuredClassifier_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for structuredClassifier_forwardReferencesFromMetamodelAssociations -->
    */
  def structuredClassifier_forwardReferencesFromMetamodelAssociations: Elements =
    classifier_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLStructuredClassifier
