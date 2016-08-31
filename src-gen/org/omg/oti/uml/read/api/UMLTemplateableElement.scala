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
import org.omg.oti.uml.read.operations.UMLTemplateableElementOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A TemplateableElement is an Element that can optionally be defined as a template and bound to other templates.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTemplateableElement[Uml <: UML]
  extends UMLElement[Uml]
  with UMLTemplateableElementOps[Uml] {

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
      templateableElement_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLTemplateableElement
    *
    * <!-- Start of user code doc for templateableElement_metaAttributes -->
    * <!-- End of user code doc for templateableElement_metaAttributes -->
    */
  def templateableElement_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     element_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    templateableElement_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLTemplateableElement
    *
    * <!-- Start of user code doc for templateableElement_compositeMetaProperties -->
    * <!-- End of user code doc for templateableElement_compositeMetaProperties -->
    */
  def templateableElement_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](TemplateableElement_ownedTemplateSignature,
      	TemplateableElement_templateBinding))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    templateableElement_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLTemplateableElement
    *
    * <!-- Start of user code doc for templateableElement_referenceMetaProperties -->
    * <!-- End of user code doc for templateableElement_referenceMetaProperties -->
    */
  def templateableElement_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    templateableElement_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLTemplateableElement
    *
    * <!-- Start of user code doc for templateableElement_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for templateableElement_forwardReferencesFromMetamodelAssociations -->
    */
  def templateableElement_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLTemplateableElement
