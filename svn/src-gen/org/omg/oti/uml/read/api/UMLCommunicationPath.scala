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
import org.omg.oti.uml.read.operations.UMLCommunicationPathOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A communication path is an association between two deployment targets, through which they are able to exchange signals and messages.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCommunicationPath[Uml <: UML]
  extends UMLAssociation[Uml]
  with UMLCommunicationPathOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      communicationPath_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLCommunicationPath
    *
    * <!-- Start of user code doc for communicationPath_metaAttributes -->
    * <!-- End of user code doc for communicationPath_metaAttributes -->
    */
  def communicationPath_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     association_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    communicationPath_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLCommunicationPath
    *
    * <!-- Start of user code doc for communicationPath_compositeMetaProperties -->
    * <!-- End of user code doc for communicationPath_compositeMetaProperties -->
    */
  def communicationPath_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      association_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    communicationPath_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLCommunicationPath
    *
    * <!-- Start of user code doc for communicationPath_referenceMetaProperties -->
    * <!-- End of user code doc for communicationPath_referenceMetaProperties -->
    */
  def communicationPath_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      association_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    communicationPath_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLCommunicationPath
    *
    * <!-- Start of user code doc for communicationPath_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for communicationPath_forwardReferencesFromMetamodelAssociations -->
    */
  def communicationPath_forwardReferencesFromMetamodelAssociations: Elements =
    association_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLCommunicationPath
