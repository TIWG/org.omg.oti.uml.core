/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
