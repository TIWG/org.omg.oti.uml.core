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
import org.omg.oti.uml.read.operations.UMLOperationTemplateParameterOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * An OperationTemplateParameter exposes an Operation as a formal parameter for a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLOperationTemplateParameter[Uml <: UML]
  extends UMLTemplateParameter[Uml]
  with UMLOperationTemplateParameterOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Operation exposed by this OperationTemplateParameter.
    *
    * <!-- Start of user code doc for parameteredElement -->
    * <!-- End of user code doc for parameteredElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.templateParameter
    */
  override def parameteredElement: Option[UMLOperation[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      operationTemplateParameter_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLOperationTemplateParameter
    *
    * <!-- Start of user code doc for operationTemplateParameter_metaAttributes -->
    * <!-- End of user code doc for operationTemplateParameter_metaAttributes -->
    */
  def operationTemplateParameter_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     templateParameter_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    operationTemplateParameter_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLOperationTemplateParameter
    *
    * <!-- Start of user code doc for operationTemplateParameter_compositeMetaProperties -->
    * <!-- End of user code doc for operationTemplateParameter_compositeMetaProperties -->
    */
  def operationTemplateParameter_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      templateParameter_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    operationTemplateParameter_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLOperationTemplateParameter
    *
    * <!-- Start of user code doc for operationTemplateParameter_referenceMetaProperties -->
    * <!-- End of user code doc for operationTemplateParameter_referenceMetaProperties -->
    */
  def operationTemplateParameter_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      templateParameter_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](OperationTemplateParameter_parameteredElement))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    operationTemplateParameter_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLOperationTemplateParameter
    *
    * <!-- Start of user code doc for operationTemplateParameter_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for operationTemplateParameter_forwardReferencesFromMetamodelAssociations -->
    */
  def operationTemplateParameter_forwardReferencesFromMetamodelAssociations: Elements =
    templateParameter_forwardReferencesFromMetamodelAssociations ++
    parameteredElement

  // Start of user code for additional features
  // End of user code
} //UMLOperationTemplateParameter
