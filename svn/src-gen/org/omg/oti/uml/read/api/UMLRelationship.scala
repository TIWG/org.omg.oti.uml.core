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
import org.omg.oti.uml.read.operations.UMLRelationshipOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * Relationship is an abstract concept that specifies some kind of relationship between Elements.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLRelationship[Uml <: UML]
  extends UMLElement[Uml]
  with UMLRelationshipOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * Specifies the elements related by the Relationship.
    *
    * <!-- Start of user code doc for relatedElement -->
    * <!-- End of user code doc for relatedElement -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElement.relatedElement_relationship
    */
  def relatedElement: Set[UMLElement[Uml]]

  /**
    * <!-- Start of user code doc for realization_abstraction -->
    * <!-- End of user code doc for realization_abstraction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInformationFlow.realization
    */
  def realization_abstraction: Set[UMLInformationFlow[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      relationship_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLRelationship
    *
    * <!-- Start of user code doc for relationship_metaAttributes -->
    * <!-- End of user code doc for relationship_metaAttributes -->
    */
  def relationship_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     element_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    relationship_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLRelationship
    *
    * <!-- Start of user code doc for relationship_compositeMetaProperties -->
    * <!-- End of user code doc for relationship_compositeMetaProperties -->
    */
  def relationship_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    relationship_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLRelationship
    *
    * <!-- Start of user code doc for relationship_referenceMetaProperties -->
    * <!-- End of user code doc for relationship_referenceMetaProperties -->
    */
  def relationship_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    relationship_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLRelationship
    *
    * <!-- Start of user code doc for relationship_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for relationship_forwardReferencesFromMetamodelAssociations -->
    */
  def relationship_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLRelationship
