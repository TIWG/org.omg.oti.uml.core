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
import org.omg.oti.uml.read.operations.UMLCollaborationUseOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A CollaborationUse is used to specify the application of a pattern specified by a Collaboration to a specific situation.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCollaborationUse[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLCollaborationUseOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Collaboration which is used in this CollaborationUse. The Collaboration defines the cooperation between its roles which are mapped to ConnectableElements relating to the Classifier owning the CollaborationUse.
    *
    * <!-- Start of user code doc for _type -->
    * <!-- End of user code doc for _type -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLCollaboration.type_collaborationUse
    */
  def _type: Option[UMLCollaboration[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      collaborationUse_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLCollaborationUse
    *
    * <!-- Start of user code doc for collaborationUse_metaAttributes -->
    * <!-- End of user code doc for collaborationUse_metaAttributes -->
    */
  def collaborationUse_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namedElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    collaborationUse_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLCollaborationUse
    *
    * <!-- Start of user code doc for collaborationUse_compositeMetaProperties -->
    * <!-- End of user code doc for collaborationUse_compositeMetaProperties -->
    */
  def collaborationUse_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](CollaborationUse_roleBinding))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    collaborationUse_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLCollaborationUse
    *
    * <!-- Start of user code doc for collaborationUse_referenceMetaProperties -->
    * <!-- End of user code doc for collaborationUse_referenceMetaProperties -->
    */
  def collaborationUse_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](CollaborationUse_type))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    collaborationUse_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLCollaborationUse
    *
    * <!-- Start of user code doc for collaborationUse_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for collaborationUse_forwardReferencesFromMetamodelAssociations -->
    */
  def collaborationUse_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    _type

  // Start of user code for additional features
  // End of user code
} //UMLCollaborationUse
