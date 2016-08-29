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
import org.omg.oti.uml.read.operations.UMLDestroyObjectActionOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A DestroyObjectAction is an Action that destroys objects.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDestroyObjectAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLDestroyObjectActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies whether links in which the object participates are destroyed along with the object.
    *
    * <!-- Start of user code doc for isDestroyLinks -->
    * <!-- End of user code doc for isDestroyLinks -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isDestroyLinks: Boolean

  /**
    * Specifies whether objects owned by the object (via composition) are destroyed along with the object.
    *
    * <!-- Start of user code doc for isDestroyOwnedObjects -->
    * <!-- End of user code doc for isDestroyOwnedObjects -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isDestroyOwnedObjects: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      destroyObjectAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDestroyObjectAction
    *
    * <!-- Start of user code doc for destroyObjectAction_metaAttributes -->
    * <!-- End of user code doc for destroyObjectAction_metaAttributes -->
    */
  def destroyObjectAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     Seq[MetaAttributeFunction](DestroyObjectAction_isDestroyLinks,
     	DestroyObjectAction_isDestroyOwnedObjects))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    destroyObjectAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDestroyObjectAction
    *
    * <!-- Start of user code doc for destroyObjectAction_compositeMetaProperties -->
    * <!-- End of user code doc for destroyObjectAction_compositeMetaProperties -->
    */
  def destroyObjectAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](DestroyObjectAction_target))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    destroyObjectAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDestroyObjectAction
    *
    * <!-- Start of user code doc for destroyObjectAction_referenceMetaProperties -->
    * <!-- End of user code doc for destroyObjectAction_referenceMetaProperties -->
    */
  def destroyObjectAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    destroyObjectAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDestroyObjectAction
    *
    * <!-- Start of user code doc for destroyObjectAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for destroyObjectAction_forwardReferencesFromMetamodelAssociations -->
    */
  def destroyObjectAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLDestroyObjectAction
