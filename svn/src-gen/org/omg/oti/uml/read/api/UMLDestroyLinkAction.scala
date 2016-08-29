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
import org.omg.oti.uml.read.operations.UMLDestroyLinkActionOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A DestroyLinkAction is a WriteLinkAction that destroys links (including link objects).
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDestroyLinkAction[Uml <: UML]
  extends UMLWriteLinkAction[Uml]
  with UMLDestroyLinkActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      destroyLinkAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDestroyLinkAction
    *
    * <!-- Start of user code doc for destroyLinkAction_metaAttributes -->
    * <!-- End of user code doc for destroyLinkAction_metaAttributes -->
    */
  def destroyLinkAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     writeLinkAction_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    destroyLinkAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDestroyLinkAction
    *
    * <!-- Start of user code doc for destroyLinkAction_compositeMetaProperties -->
    * <!-- End of user code doc for destroyLinkAction_compositeMetaProperties -->
    */
  def destroyLinkAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      writeLinkAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](DestroyLinkAction_endData))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    destroyLinkAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDestroyLinkAction
    *
    * <!-- Start of user code doc for destroyLinkAction_referenceMetaProperties -->
    * <!-- End of user code doc for destroyLinkAction_referenceMetaProperties -->
    */
  def destroyLinkAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      writeLinkAction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    destroyLinkAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDestroyLinkAction
    *
    * <!-- Start of user code doc for destroyLinkAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for destroyLinkAction_forwardReferencesFromMetamodelAssociations -->
    */
  def destroyLinkAction_forwardReferencesFromMetamodelAssociations: Elements =
    writeLinkAction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLDestroyLinkAction
