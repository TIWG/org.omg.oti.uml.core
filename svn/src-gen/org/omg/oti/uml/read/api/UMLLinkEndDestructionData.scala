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
import org.omg.oti.uml.read.operations.UMLLinkEndDestructionDataOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * LinkEndDestructionData is LinkEndData used to provide values for one end of a link to be destroyed by a DestroyLinkAction.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLinkEndDestructionData[Uml <: UML]
  extends UMLLinkEndData[Uml]
  with UMLLinkEndDestructionDataOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The InputPin that provides the position of an existing link to be destroyed in an ordered, nonunique Association end. The type of the destroyAt InputPin is UnlimitedNatural, but the value cannot be zero or unlimited.
    *
    * <!-- Start of user code doc for destroyAt -->
    * <!-- End of user code doc for destroyAt -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.destroyAt_linkEndDestructionData
    */
  def destroyAt: Option[UMLInputPin[Uml]]

  /**
    * Specifies whether to destroy duplicates of the value in nonunique Association ends.
    *
    * <!-- Start of user code doc for isDestroyDuplicates -->
    * <!-- End of user code doc for isDestroyDuplicates -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isDestroyDuplicates: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      linkEndDestructionData_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLLinkEndDestructionData
    *
    * <!-- Start of user code doc for linkEndDestructionData_metaAttributes -->
    * <!-- End of user code doc for linkEndDestructionData_metaAttributes -->
    */
  def linkEndDestructionData_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     linkEndData_metaAttributes,
     Seq[MetaAttributeFunction](LinkEndDestructionData_isDestroyDuplicates))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    linkEndDestructionData_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLLinkEndDestructionData
    *
    * <!-- Start of user code doc for linkEndDestructionData_compositeMetaProperties -->
    * <!-- End of user code doc for linkEndDestructionData_compositeMetaProperties -->
    */
  def linkEndDestructionData_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      linkEndData_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    linkEndDestructionData_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLLinkEndDestructionData
    *
    * <!-- Start of user code doc for linkEndDestructionData_referenceMetaProperties -->
    * <!-- End of user code doc for linkEndDestructionData_referenceMetaProperties -->
    */
  def linkEndDestructionData_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      linkEndData_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](LinkEndDestructionData_destroyAt))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    linkEndDestructionData_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLLinkEndDestructionData
    *
    * <!-- Start of user code doc for linkEndDestructionData_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for linkEndDestructionData_forwardReferencesFromMetamodelAssociations -->
    */
  def linkEndDestructionData_forwardReferencesFromMetamodelAssociations: Elements =
    linkEndData_forwardReferencesFromMetamodelAssociations ++
    destroyAt

  // Start of user code for additional features
  // End of user code
} //UMLLinkEndDestructionData
