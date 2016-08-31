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
import org.omg.oti.uml.read.operations.UMLRedefinableTemplateSignatureOps

import scala.collection.immutable.Seq
// End of user code


/**
  * A RedefinableTemplateSignature supports the addition of formal template parameters in a specialization of a template classifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLRedefinableTemplateSignature[Uml <: UML]
  extends UMLRedefinableElement[Uml]
	with UMLTemplateSignature[Uml]
  with UMLRedefinableTemplateSignatureOps[Uml] {

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
      redefinableTemplateSignature_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLRedefinableTemplateSignature
    *
    * <!-- Start of user code doc for redefinableTemplateSignature_metaAttributes -->
    * <!-- End of user code doc for redefinableTemplateSignature_metaAttributes -->
    */
  def redefinableTemplateSignature_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     redefinableElement_metaAttributes,
     templateSignature_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    redefinableTemplateSignature_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLRedefinableTemplateSignature
    *
    * <!-- Start of user code doc for redefinableTemplateSignature_compositeMetaProperties -->
    * <!-- End of user code doc for redefinableTemplateSignature_compositeMetaProperties -->
    */
  def redefinableTemplateSignature_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      redefinableElement_compositeMetaProperties,
      templateSignature_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    redefinableTemplateSignature_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLRedefinableTemplateSignature
    *
    * <!-- Start of user code doc for redefinableTemplateSignature_referenceMetaProperties -->
    * <!-- End of user code doc for redefinableTemplateSignature_referenceMetaProperties -->
    */
  def redefinableTemplateSignature_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      redefinableElement_referenceMetaProperties,
      templateSignature_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](RedefinableTemplateSignature_extendedSignature))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    redefinableTemplateSignature_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLRedefinableTemplateSignature
    *
    * <!-- Start of user code doc for redefinableTemplateSignature_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for redefinableTemplateSignature_forwardReferencesFromMetamodelAssociations -->
    */
  def redefinableTemplateSignature_forwardReferencesFromMetamodelAssociations: Elements =
    redefinableElement_forwardReferencesFromMetamodelAssociations ++
    templateSignature_forwardReferencesFromMetamodelAssociations ++
    extendedSignature

  // Start of user code for additional features
  // End of user code
} //UMLRedefinableTemplateSignature
