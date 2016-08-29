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
import org.omg.oti.uml.read.operations.UMLExpansionNodeOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * An ExpansionNode is an ObjectNode used to indicate a collection input or output for an ExpansionRegion. A collection input of an ExpansionRegion contains a collection that is broken into its individual elements inside the region, whose content is executed once per element. A collection output of an ExpansionRegion combines individual elements produced by the execution of the region into a collection for use outside the region.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExpansionNode[Uml <: UML]
  extends UMLObjectNode[Uml]
  with UMLExpansionNodeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The ExpansionRegion for which the ExpansionNode is an input.
    *
    * <!-- Start of user code doc for regionAsInput -->
    * <!-- End of user code doc for regionAsInput -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExpansionRegion.inputElement
    */
  def regionAsInput: Option[UMLExpansionRegion[Uml]]

  /**
    * The ExpansionRegion for which the ExpansionNode is an output.
    *
    * <!-- Start of user code doc for regionAsOutput -->
    * <!-- End of user code doc for regionAsOutput -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExpansionRegion.outputElement
    */
  def regionAsOutput: Option[UMLExpansionRegion[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      expansionNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLExpansionNode
    *
    * <!-- Start of user code doc for expansionNode_metaAttributes -->
    * <!-- End of user code doc for expansionNode_metaAttributes -->
    */
  def expansionNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     objectNode_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    expansionNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLExpansionNode
    *
    * <!-- Start of user code doc for expansionNode_compositeMetaProperties -->
    * <!-- End of user code doc for expansionNode_compositeMetaProperties -->
    */
  def expansionNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      objectNode_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    expansionNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLExpansionNode
    *
    * <!-- Start of user code doc for expansionNode_referenceMetaProperties -->
    * <!-- End of user code doc for expansionNode_referenceMetaProperties -->
    */
  def expansionNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      objectNode_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ExpansionNode_regionAsInput,
      	ExpansionNode_regionAsOutput))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    expansionNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLExpansionNode
    *
    * <!-- Start of user code doc for expansionNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for expansionNode_forwardReferencesFromMetamodelAssociations -->
    */
  def expansionNode_forwardReferencesFromMetamodelAssociations: Elements =
    objectNode_forwardReferencesFromMetamodelAssociations ++
    regionAsInput ++
    regionAsOutput

  // Start of user code for additional features
  // End of user code
} //UMLExpansionNode
