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
import org.omg.oti.uml.read.operations.UMLConnectorEndOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A ConnectorEnd is an endpoint of a Connector, which attaches the Connector to a ConnectableElement.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConnectorEnd[Uml <: UML]
  extends UMLMultiplicityElement[Uml]
  with UMLConnectorEndOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Indicates the role of the internal structure of a Classifier with the Port to which the ConnectorEnd is attached.
    *
    * <!-- Start of user code doc for partWithPort -->
    * <!-- End of user code doc for partWithPort -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.partWithPort_connectorEnd
    */
  def partWithPort: Option[UMLProperty[Uml]]

  /**
    * The ConnectableElement attached at this ConnectorEnd. When an instance of the containing Classifier is created, a link may (depending on the multiplicities) be created to an instance of the Classifier that types this ConnectableElement.
    *
    * <!-- Start of user code doc for role -->
    * <!-- End of user code doc for role -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnectableElement.end
    */
  def role: Option[UMLConnectableElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      connectorEnd_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLConnectorEnd
    *
    * <!-- Start of user code doc for connectorEnd_metaAttributes -->
    * <!-- End of user code doc for connectorEnd_metaAttributes -->
    */
  def connectorEnd_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     multiplicityElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    connectorEnd_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLConnectorEnd
    *
    * <!-- Start of user code doc for connectorEnd_compositeMetaProperties -->
    * <!-- End of user code doc for connectorEnd_compositeMetaProperties -->
    */
  def connectorEnd_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      multiplicityElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    connectorEnd_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLConnectorEnd
    *
    * <!-- Start of user code doc for connectorEnd_referenceMetaProperties -->
    * <!-- End of user code doc for connectorEnd_referenceMetaProperties -->
    */
  def connectorEnd_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      multiplicityElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ConnectorEnd_partWithPort,
      	ConnectorEnd_role))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    connectorEnd_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLConnectorEnd
    *
    * <!-- Start of user code doc for connectorEnd_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for connectorEnd_forwardReferencesFromMetamodelAssociations -->
    */
  def connectorEnd_forwardReferencesFromMetamodelAssociations: Elements =
    multiplicityElement_forwardReferencesFromMetamodelAssociations ++
    partWithPort ++
    role

  // Start of user code for additional features
  // End of user code
} //UMLConnectorEnd
