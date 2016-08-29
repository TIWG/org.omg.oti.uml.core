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
import org.omg.oti.uml.read.operations.UMLReadLinkObjectEndActionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A ReadLinkObjectEndAction is an Action that retrieves an end object from a link object.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReadLinkObjectEndAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLReadLinkObjectEndActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Association end to be read.
    *
    * <!-- Start of user code doc for end -->
    * <!-- End of user code doc for end -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.end_readLinkObjectEndAction
    */
  def end: Option[UMLProperty[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      readLinkObjectEndAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLReadLinkObjectEndAction
    *
    * <!-- Start of user code doc for readLinkObjectEndAction_metaAttributes -->
    * <!-- End of user code doc for readLinkObjectEndAction_metaAttributes -->
    */
  def readLinkObjectEndAction_metaAttributes: MetaAttributeFunctions = 
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
    readLinkObjectEndAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLReadLinkObjectEndAction
    *
    * <!-- Start of user code doc for readLinkObjectEndAction_compositeMetaProperties -->
    * <!-- End of user code doc for readLinkObjectEndAction_compositeMetaProperties -->
    */
  def readLinkObjectEndAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ReadLinkObjectEndAction_object,
      	ReadLinkObjectEndAction_result))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    readLinkObjectEndAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLReadLinkObjectEndAction
    *
    * <!-- Start of user code doc for readLinkObjectEndAction_referenceMetaProperties -->
    * <!-- End of user code doc for readLinkObjectEndAction_referenceMetaProperties -->
    */
  def readLinkObjectEndAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ReadLinkObjectEndAction_end))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    readLinkObjectEndAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLReadLinkObjectEndAction
    *
    * <!-- Start of user code doc for readLinkObjectEndAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for readLinkObjectEndAction_forwardReferencesFromMetamodelAssociations -->
    */
  def readLinkObjectEndAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    end

  // Start of user code for additional features
  // End of user code
} //UMLReadLinkObjectEndAction
