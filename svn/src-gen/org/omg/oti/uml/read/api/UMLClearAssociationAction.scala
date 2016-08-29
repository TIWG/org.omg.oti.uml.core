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
import org.omg.oti.uml.read.operations.UMLClearAssociationActionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A ClearAssociationAction is an Action that destroys all links of an Association in which a particular object participates.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLClearAssociationAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLClearAssociationActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Association to be cleared.
    *
    * <!-- Start of user code doc for association -->
    * <!-- End of user code doc for association -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAssociation.association_clearAssociationAction
    */
  def association: Option[UMLAssociation[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      clearAssociationAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLClearAssociationAction
    *
    * <!-- Start of user code doc for clearAssociationAction_metaAttributes -->
    * <!-- End of user code doc for clearAssociationAction_metaAttributes -->
    */
  def clearAssociationAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    clearAssociationAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLClearAssociationAction
    *
    * <!-- Start of user code doc for clearAssociationAction_compositeMetaProperties -->
    * <!-- End of user code doc for clearAssociationAction_compositeMetaProperties -->
    */
  def clearAssociationAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ClearAssociationAction_object))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    clearAssociationAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLClearAssociationAction
    *
    * <!-- Start of user code doc for clearAssociationAction_referenceMetaProperties -->
    * <!-- End of user code doc for clearAssociationAction_referenceMetaProperties -->
    */
  def clearAssociationAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ClearAssociationAction_association))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    clearAssociationAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLClearAssociationAction
    *
    * <!-- Start of user code doc for clearAssociationAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for clearAssociationAction_forwardReferencesFromMetamodelAssociations -->
    */
  def clearAssociationAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    association

  // Start of user code for additional features
  // End of user code
} //UMLClearAssociationAction
