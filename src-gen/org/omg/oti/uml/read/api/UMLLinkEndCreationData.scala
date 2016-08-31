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
import org.omg.oti.uml.read.operations.UMLLinkEndCreationDataOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * LinkEndCreationData is LinkEndData used to provide values for one end of a link to be created by a CreateLinkAction.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLinkEndCreationData[Uml <: UML]
  extends UMLLinkEndData[Uml]
  with UMLLinkEndCreationDataOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * For ordered Association ends, the InputPin that provides the position where the new link should be inserted or where an existing link should be moved to. The type of the insertAt InputPin is UnlimitedNatural, but the input cannot be zero. It is omitted for Association ends that are not ordered.
    *
    * <!-- Start of user code doc for insertAt -->
    * <!-- End of user code doc for insertAt -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.insertAt_linkEndCreationData
    */
  def insertAt: Option[UMLInputPin[Uml]]

  /**
    * Specifies whether the existing links emanating from the object on this end should be destroyed before creating a new link.
    *
    * <!-- Start of user code doc for isReplaceAll -->
    * <!-- End of user code doc for isReplaceAll -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isReplaceAll: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      linkEndCreationData_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLLinkEndCreationData
    *
    * <!-- Start of user code doc for linkEndCreationData_metaAttributes -->
    * <!-- End of user code doc for linkEndCreationData_metaAttributes -->
    */
  def linkEndCreationData_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     linkEndData_metaAttributes,
     Seq[MetaAttributeFunction](LinkEndCreationData_isReplaceAll))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    linkEndCreationData_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLLinkEndCreationData
    *
    * <!-- Start of user code doc for linkEndCreationData_compositeMetaProperties -->
    * <!-- End of user code doc for linkEndCreationData_compositeMetaProperties -->
    */
  def linkEndCreationData_compositeMetaProperties: MetaPropertyFunctions = 
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
    linkEndCreationData_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLLinkEndCreationData
    *
    * <!-- Start of user code doc for linkEndCreationData_referenceMetaProperties -->
    * <!-- End of user code doc for linkEndCreationData_referenceMetaProperties -->
    */
  def linkEndCreationData_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      linkEndData_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](LinkEndCreationData_insertAt))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    linkEndCreationData_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLLinkEndCreationData
    *
    * <!-- Start of user code doc for linkEndCreationData_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for linkEndCreationData_forwardReferencesFromMetamodelAssociations -->
    */
  def linkEndCreationData_forwardReferencesFromMetamodelAssociations: Elements =
    linkEndData_forwardReferencesFromMetamodelAssociations ++
    insertAt

  // Start of user code for additional features
  // End of user code
} //UMLLinkEndCreationData
