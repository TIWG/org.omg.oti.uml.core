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
import org.omg.oti.uml.read.operations.UMLTemplateParameterSubstitutionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A TemplateParameterSubstitution relates the actual parameter to a formal TemplateParameter as part of a template binding.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTemplateParameterSubstitution[Uml <: UML]
  extends UMLElement[Uml]
  with UMLTemplateParameterSubstitutionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The ParameterableElement that is the actual parameter for this TemplateParameterSubstitution.
    *
    * <!-- Start of user code doc for actual -->
    * <!-- End of user code doc for actual -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLParameterableElement.actual_templateParameterSubstitution
    */
  def actual: Option[UMLParameterableElement[Uml]]

  /**
    * The formal TemplateParameter that is associated with this TemplateParameterSubstitution.
    *
    * <!-- Start of user code doc for formal -->
    * <!-- End of user code doc for formal -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateParameter.formal_templateParameterSubstitution
    */
  def formal: Option[UMLTemplateParameter[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      templateParameterSubstitution_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLTemplateParameterSubstitution
    *
    * <!-- Start of user code doc for templateParameterSubstitution_metaAttributes -->
    * <!-- End of user code doc for templateParameterSubstitution_metaAttributes -->
    */
  def templateParameterSubstitution_metaAttributes: MetaAttributeFunctions = 
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
    templateParameterSubstitution_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLTemplateParameterSubstitution
    *
    * <!-- Start of user code doc for templateParameterSubstitution_compositeMetaProperties -->
    * <!-- End of user code doc for templateParameterSubstitution_compositeMetaProperties -->
    */
  def templateParameterSubstitution_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](TemplateParameterSubstitution_ownedActual))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    templateParameterSubstitution_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLTemplateParameterSubstitution
    *
    * <!-- Start of user code doc for templateParameterSubstitution_referenceMetaProperties -->
    * <!-- End of user code doc for templateParameterSubstitution_referenceMetaProperties -->
    */
  def templateParameterSubstitution_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](TemplateParameterSubstitution_actual,
      	TemplateParameterSubstitution_formal))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    templateParameterSubstitution_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLTemplateParameterSubstitution
    *
    * <!-- Start of user code doc for templateParameterSubstitution_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for templateParameterSubstitution_forwardReferencesFromMetamodelAssociations -->
    */
  def templateParameterSubstitution_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    actual ++
    formal

  // Start of user code for additional features
  // End of user code
} //UMLTemplateParameterSubstitution
