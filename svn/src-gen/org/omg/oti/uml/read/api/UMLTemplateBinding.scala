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
import org.omg.oti.uml.read.operations.UMLTemplateBindingOps

import scala.collection.immutable.Seq
// End of user code


/**
  * A TemplateBinding is a DirectedRelationship between a TemplateableElement and a template. A TemplateBinding specifies the TemplateParameterSubstitutions of actual parameters for the formal parameters of the template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTemplateBinding[Uml <: UML]
  extends UMLDirectedRelationship[Uml]
  with UMLTemplateBindingOps[Uml] {

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
      templateBinding_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLTemplateBinding
    *
    * <!-- Start of user code doc for templateBinding_metaAttributes -->
    * <!-- End of user code doc for templateBinding_metaAttributes -->
    */
  def templateBinding_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     directedRelationship_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    templateBinding_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLTemplateBinding
    *
    * <!-- Start of user code doc for templateBinding_compositeMetaProperties -->
    * <!-- End of user code doc for templateBinding_compositeMetaProperties -->
    */
  def templateBinding_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](TemplateBinding_parameterSubstitution))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    templateBinding_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLTemplateBinding
    *
    * <!-- Start of user code doc for templateBinding_referenceMetaProperties -->
    * <!-- End of user code doc for templateBinding_referenceMetaProperties -->
    */
  def templateBinding_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](TemplateBinding_signature))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    templateBinding_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLTemplateBinding
    *
    * <!-- Start of user code doc for templateBinding_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for templateBinding_forwardReferencesFromMetamodelAssociations -->
    */
  def templateBinding_forwardReferencesFromMetamodelAssociations: Elements =
    directedRelationship_forwardReferencesFromMetamodelAssociations ++
    signature

  // Start of user code for additional features
  // End of user code
} //UMLTemplateBinding
