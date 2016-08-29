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
import org.omg.oti.uml.read.operations.UMLConnectableElementTemplateParameterOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A ConnectableElementTemplateParameter exposes a ConnectableElement as a formal parameter for a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConnectableElementTemplateParameter[Uml <: UML]
  extends UMLTemplateParameter[Uml]
  with UMLConnectableElementTemplateParameterOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The ConnectableElement for this ConnectableElementTemplateParameter.
    *
    * <!-- Start of user code doc for parameteredElement -->
    * <!-- End of user code doc for parameteredElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnectableElement.templateParameter
    */
  override def parameteredElement: Option[UMLConnectableElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      connectableElementTemplateParameter_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLConnectableElementTemplateParameter
    *
    * <!-- Start of user code doc for connectableElementTemplateParameter_metaAttributes -->
    * <!-- End of user code doc for connectableElementTemplateParameter_metaAttributes -->
    */
  def connectableElementTemplateParameter_metaAttributes: MetaAttributeFunctions = 
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
    connectableElementTemplateParameter_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLConnectableElementTemplateParameter
    *
    * <!-- Start of user code doc for connectableElementTemplateParameter_compositeMetaProperties -->
    * <!-- End of user code doc for connectableElementTemplateParameter_compositeMetaProperties -->
    */
  def connectableElementTemplateParameter_compositeMetaProperties: MetaPropertyFunctions = 
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
    connectableElementTemplateParameter_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLConnectableElementTemplateParameter
    *
    * <!-- Start of user code doc for connectableElementTemplateParameter_referenceMetaProperties -->
    * <!-- End of user code doc for connectableElementTemplateParameter_referenceMetaProperties -->
    */
  def connectableElementTemplateParameter_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      templateParameter_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ConnectableElementTemplateParameter_parameteredElement))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    connectableElementTemplateParameter_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLConnectableElementTemplateParameter
    *
    * <!-- Start of user code doc for connectableElementTemplateParameter_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for connectableElementTemplateParameter_forwardReferencesFromMetamodelAssociations -->
    */
  def connectableElementTemplateParameter_forwardReferencesFromMetamodelAssociations: Elements =
    templateParameter_forwardReferencesFromMetamodelAssociations ++
    parameteredElement

  // Start of user code for additional features
  // End of user code
} //UMLConnectableElementTemplateParameter
