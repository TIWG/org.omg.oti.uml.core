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
import org.omg.oti.uml.read.operations.UMLDirectedRelationshipOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A DirectedRelationship represents a relationship between a collection of source model Elements and a collection of target model Elements.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDirectedRelationship[Uml <: UML]
  extends UMLRelationship[Uml]
  with UMLDirectedRelationshipOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * Specifies the source Element(s) of the DirectedRelationship.
    *
    * <!-- Start of user code doc for source -->
    * <!-- End of user code doc for source -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElement.source_directedRelationship
    */
  def source: Set[UMLElement[Uml]]

  /**
    * Specifies the target Element(s) of the DirectedRelationship.
    *
    * <!-- Start of user code doc for target -->
    * <!-- End of user code doc for target -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElement.target_directedRelationship
    */
  def target: Set[UMLElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      directedRelationship_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDirectedRelationship
    *
    * <!-- Start of user code doc for directedRelationship_metaAttributes -->
    * <!-- End of user code doc for directedRelationship_metaAttributes -->
    */
  def directedRelationship_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     relationship_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    directedRelationship_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDirectedRelationship
    *
    * <!-- Start of user code doc for directedRelationship_compositeMetaProperties -->
    * <!-- End of user code doc for directedRelationship_compositeMetaProperties -->
    */
  def directedRelationship_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      relationship_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    directedRelationship_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDirectedRelationship
    *
    * <!-- Start of user code doc for directedRelationship_referenceMetaProperties -->
    * <!-- End of user code doc for directedRelationship_referenceMetaProperties -->
    */
  def directedRelationship_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      relationship_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    directedRelationship_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDirectedRelationship
    *
    * <!-- Start of user code doc for directedRelationship_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for directedRelationship_forwardReferencesFromMetamodelAssociations -->
    */
  def directedRelationship_forwardReferencesFromMetamodelAssociations: Elements =
    relationship_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLDirectedRelationship
