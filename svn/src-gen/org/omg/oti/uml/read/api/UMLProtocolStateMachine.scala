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
import org.omg.oti.uml.read.operations.UMLProtocolStateMachineOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ProtocolStateMachine is always defined in the context of a Classifier. It specifies which BehavioralFeatures of the Classifier can be called in which State and under which conditions, thus specifying the allowed invocation sequences on the Classifier's BehavioralFeatures. A ProtocolStateMachine specifies the possible and permitted Transitions on the instances of its context Classifier, together with the BehavioralFeatures that carry the Transitions. In this manner, an instance lifecycle can be specified for a Classifier, by defining the order in which the BehavioralFeatures can be activated and the States through which an instance progresses during its existence.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLProtocolStateMachine[Uml <: UML]
  extends UMLStateMachine[Uml]
  with UMLProtocolStateMachineOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies the namespace in which the protocol state machine is defined.
    *
    * <!-- Start of user code doc for protocol_interface -->
    * <!-- End of user code doc for protocol_interface -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.protocol
    */
  def protocol_interface: Option[UMLInterface[Uml]]

  /**
    * <!-- Start of user code doc for protocol_port -->
    * <!-- End of user code doc for protocol_port -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPort.protocol
    */
  def protocol_port: Set[UMLPort[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      protocolStateMachine_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLProtocolStateMachine
    *
    * <!-- Start of user code doc for protocolStateMachine_metaAttributes -->
    * <!-- End of user code doc for protocolStateMachine_metaAttributes -->
    */
  def protocolStateMachine_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     stateMachine_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    protocolStateMachine_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLProtocolStateMachine
    *
    * <!-- Start of user code doc for protocolStateMachine_compositeMetaProperties -->
    * <!-- End of user code doc for protocolStateMachine_compositeMetaProperties -->
    */
  def protocolStateMachine_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      stateMachine_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ProtocolStateMachine_conformance))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    protocolStateMachine_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLProtocolStateMachine
    *
    * <!-- Start of user code doc for protocolStateMachine_referenceMetaProperties -->
    * <!-- End of user code doc for protocolStateMachine_referenceMetaProperties -->
    */
  def protocolStateMachine_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      stateMachine_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    protocolStateMachine_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLProtocolStateMachine
    *
    * <!-- Start of user code doc for protocolStateMachine_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for protocolStateMachine_forwardReferencesFromMetamodelAssociations -->
    */
  def protocolStateMachine_forwardReferencesFromMetamodelAssociations: Elements =
    stateMachine_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLProtocolStateMachine
