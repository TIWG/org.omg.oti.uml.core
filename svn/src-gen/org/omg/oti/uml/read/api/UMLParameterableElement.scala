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
import org.omg.oti.uml.read.operations.UMLParameterableElementOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ParameterableElement is an Element that can be exposed as a formal TemplateParameter for a template, or specified as an actual parameter in a binding of a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLParameterableElement[Uml <: UML]
  extends UMLElement[Uml]
  with UMLParameterableElementOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The formal TemplateParameter that owns this ParameterableElement.
    *
    * <!-- Start of user code doc for owningTemplateParameter -->
    * <!-- End of user code doc for owningTemplateParameter -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateParameter.ownedParameteredElement
    */
  def owningTemplateParameter: Option[UMLTemplateParameter[Uml]]

  /**
    * The TemplateParameter that exposes this ParameterableElement as a formal parameter.
    *
    * <!-- Start of user code doc for templateParameter -->
    * <!-- End of user code doc for templateParameter -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateParameter.parameteredElement
    */
  def templateParameter: Option[UMLTemplateParameter[Uml]]

  /**
    * <!-- Start of user code doc for actual_templateParameterSubstitution -->
    * <!-- End of user code doc for actual_templateParameterSubstitution -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateParameterSubstitution.actual
    */
  def actual_templateParameterSubstitution: Set[UMLTemplateParameterSubstitution[Uml]]

  /**
    * <!-- Start of user code doc for default_templateParameter -->
    * <!-- End of user code doc for default_templateParameter -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateParameter.default
    */
  def default_templateParameter: Set[UMLTemplateParameter[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      parameterableElement_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLParameterableElement
    *
    * <!-- Start of user code doc for parameterableElement_metaAttributes -->
    * <!-- End of user code doc for parameterableElement_metaAttributes -->
    */
  def parameterableElement_metaAttributes: MetaAttributeFunctions = 
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
    parameterableElement_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLParameterableElement
    *
    * <!-- Start of user code doc for parameterableElement_compositeMetaProperties -->
    * <!-- End of user code doc for parameterableElement_compositeMetaProperties -->
    */
  def parameterableElement_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    parameterableElement_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLParameterableElement
    *
    * <!-- Start of user code doc for parameterableElement_referenceMetaProperties -->
    * <!-- End of user code doc for parameterableElement_referenceMetaProperties -->
    */
  def parameterableElement_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ParameterableElement_templateParameter))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    parameterableElement_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLParameterableElement
    *
    * <!-- Start of user code doc for parameterableElement_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for parameterableElement_forwardReferencesFromMetamodelAssociations -->
    */
  def parameterableElement_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    templateParameter

  // Start of user code for additional features
  // End of user code
} //UMLParameterableElement
