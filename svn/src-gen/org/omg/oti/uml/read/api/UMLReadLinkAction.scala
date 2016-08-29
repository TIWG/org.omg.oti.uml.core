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
import org.omg.oti.uml.read.operations.UMLReadLinkActionOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ReadLinkAction is a LinkAction that navigates across an Association to retrieve the objects on one end.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReadLinkAction[Uml <: UML]
  extends UMLLinkAction[Uml]
  with UMLReadLinkActionOps[Uml] {

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
      readLinkAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLReadLinkAction
    *
    * <!-- Start of user code doc for readLinkAction_metaAttributes -->
    * <!-- End of user code doc for readLinkAction_metaAttributes -->
    */
  def readLinkAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     linkAction_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    readLinkAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLReadLinkAction
    *
    * <!-- Start of user code doc for readLinkAction_compositeMetaProperties -->
    * <!-- End of user code doc for readLinkAction_compositeMetaProperties -->
    */
  def readLinkAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      linkAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ReadLinkAction_result))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    readLinkAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLReadLinkAction
    *
    * <!-- Start of user code doc for readLinkAction_referenceMetaProperties -->
    * <!-- End of user code doc for readLinkAction_referenceMetaProperties -->
    */
  def readLinkAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      linkAction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    readLinkAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLReadLinkAction
    *
    * <!-- Start of user code doc for readLinkAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for readLinkAction_forwardReferencesFromMetamodelAssociations -->
    */
  def readLinkAction_forwardReferencesFromMetamodelAssociations: Elements =
    linkAction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLReadLinkAction
