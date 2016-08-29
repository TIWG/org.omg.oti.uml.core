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
import org.omg.oti.uml.read.operations.UMLConnectableElementOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * ConnectableElement is an abstract metaclass representing a set of instances that play roles of a StructuredClassifier. ConnectableElements may be joined by attached Connectors and specify configurations of linked instances to be created within an instance of the containing StructuredClassifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConnectableElement[Uml <: UML]
  extends UMLParameterableElement[Uml]
	with UMLTypedElement[Uml]
  with UMLConnectableElementOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The ConnectableElementTemplateParameter for this ConnectableElement parameter.
    *
    * <!-- Start of user code doc for templateParameter -->
    * <!-- End of user code doc for templateParameter -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnectableElementTemplateParameter.parameteredElement
    */
  override def templateParameter: Option[UMLConnectableElementTemplateParameter[Uml]]

  /**
    * <!-- Start of user code doc for represents_lifeline -->
    * <!-- End of user code doc for represents_lifeline -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLifeline.represents
    */
  def represents_lifeline: Set[UMLLifeline[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      connectableElement_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLConnectableElement
    *
    * <!-- Start of user code doc for connectableElement_metaAttributes -->
    * <!-- End of user code doc for connectableElement_metaAttributes -->
    */
  def connectableElement_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     parameterableElement_metaAttributes,
     typedElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    connectableElement_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLConnectableElement
    *
    * <!-- Start of user code doc for connectableElement_compositeMetaProperties -->
    * <!-- End of user code doc for connectableElement_compositeMetaProperties -->
    */
  def connectableElement_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      parameterableElement_compositeMetaProperties,
      typedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    connectableElement_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLConnectableElement
    *
    * <!-- Start of user code doc for connectableElement_referenceMetaProperties -->
    * <!-- End of user code doc for connectableElement_referenceMetaProperties -->
    */
  def connectableElement_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      parameterableElement_referenceMetaProperties,
      typedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ConnectableElement_templateParameter))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    connectableElement_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLConnectableElement
    *
    * <!-- Start of user code doc for connectableElement_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for connectableElement_forwardReferencesFromMetamodelAssociations -->
    */
  def connectableElement_forwardReferencesFromMetamodelAssociations: Elements =
    parameterableElement_forwardReferencesFromMetamodelAssociations ++
    typedElement_forwardReferencesFromMetamodelAssociations ++
    templateParameter

  // Start of user code for additional features
  // End of user code
} //UMLConnectableElement
