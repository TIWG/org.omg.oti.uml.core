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
import org.omg.oti.uml.read.operations.UMLCollaborationOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Collaboration describes a structure of collaborating elements (roles), each performing a specialized function, which collectively accomplish some desired functionality. 
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCollaboration[Uml <: UML]
  extends UMLBehavioredClassifier[Uml]
	with UMLStructuredClassifier[Uml]
  with UMLCollaborationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Represents the participants in the Collaboration.
    *
    * <!-- Start of user code doc for collaborationRole -->
    * <!-- End of user code doc for collaborationRole -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnectableElement.collaborationRole_collaboration
    */
  def collaborationRole: Set[UMLConnectableElement[Uml]]

  /**
    * <!-- Start of user code doc for type_collaborationUse -->
    * <!-- End of user code doc for type_collaborationUse -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLCollaborationUse._type
    */
  def type_collaborationUse: Set[UMLCollaborationUse[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      collaboration_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLCollaboration
    *
    * <!-- Start of user code doc for collaboration_metaAttributes -->
    * <!-- End of user code doc for collaboration_metaAttributes -->
    */
  def collaboration_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     behavioredClassifier_metaAttributes,
     structuredClassifier_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    collaboration_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLCollaboration
    *
    * <!-- Start of user code doc for collaboration_compositeMetaProperties -->
    * <!-- End of user code doc for collaboration_compositeMetaProperties -->
    */
  def collaboration_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavioredClassifier_compositeMetaProperties,
      structuredClassifier_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    collaboration_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLCollaboration
    *
    * <!-- Start of user code doc for collaboration_referenceMetaProperties -->
    * <!-- End of user code doc for collaboration_referenceMetaProperties -->
    */
  def collaboration_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavioredClassifier_referenceMetaProperties,
      structuredClassifier_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Collaboration_collaborationRole))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    collaboration_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLCollaboration
    *
    * <!-- Start of user code doc for collaboration_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for collaboration_forwardReferencesFromMetamodelAssociations -->
    */
  def collaboration_forwardReferencesFromMetamodelAssociations: Elements =
    behavioredClassifier_forwardReferencesFromMetamodelAssociations ++
    structuredClassifier_forwardReferencesFromMetamodelAssociations ++
    collaborationRole

  // Start of user code for additional features
  // End of user code
} //UMLCollaboration
