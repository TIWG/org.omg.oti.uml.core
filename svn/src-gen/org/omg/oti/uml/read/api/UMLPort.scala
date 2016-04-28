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
import org.omg.oti.uml.read.operations.UMLPortOps

import scala.Boolean
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Port is a property of an EncapsulatedClassifier that specifies a distinct interaction point between that EncapsulatedClassifier and its environment or between the (behavior of the) EncapsulatedClassifier and its internal parts. Ports are connected to Properties of the EncapsulatedClassifier by Connectors through which requests can be made to invoke BehavioralFeatures. A Port may specify the services an EncapsulatedClassifier provides (offers) to its environment as well as the services that an EncapsulatedClassifier expects (requires) of its environment.  A Port may have an associated ProtocolStateMachine.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPort[Uml <: UML]
  extends UMLProperty[Uml]
  with UMLPortOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies whether requests arriving at this Port are sent to the classifier behavior of this EncapsulatedClassifier. Such a Port is referred to as a behavior Port. Any invocation of a BehavioralFeature targeted at a behavior Port will be handled by the instance of the owning EncapsulatedClassifier itself, rather than by any instances that it may contain.
    *
    * <!-- Start of user code doc for isBehavior -->
    * <!-- End of user code doc for isBehavior -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isBehavior: Boolean

  /**
    * Specifies the way that the provided and required Interfaces are derived from the Port?s Type.
    *
    * <!-- Start of user code doc for isConjugated -->
    * <!-- End of user code doc for isConjugated -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isConjugated: Boolean

  /**
    * If true, indicates that this Port is used to provide the published functionality of an EncapsulatedClassifier.  If false, this Port is used to implement the EncapsulatedClassifier but is not part of the essential externally-visible functionality of the EncapsulatedClassifier and can, therefore, be altered or deleted along with the internal implementation of the EncapsulatedClassifier and other properties that are considered part of its implementation.
    *
    * <!-- Start of user code doc for isService -->
    * <!-- End of user code doc for isService -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isService: Boolean

  /**
    * An optional ProtocolStateMachine which describes valid interactions at this interaction point.
    *
    * <!-- Start of user code doc for protocol -->
    * <!-- End of user code doc for protocol -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProtocolStateMachine.protocol_port
    */
  def protocol: Option[UMLProtocolStateMachine[Uml]]

  /**
    * A Port may be redefined when its containing EncapsulatedClassifier is specialized. The redefining Port may have additional Interfaces to those that are associated with the redefined Port or it may replace an Interface by one of its subtypes.
    *
    * <!-- Start of user code doc for redefinedPort -->
    * <!-- End of user code doc for redefinedPort -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPort.redefinedPort_port
    */
  def redefinedPort: Set[UMLPort[Uml]]

  /**
    * <!-- Start of user code doc for onPort_invocationAction -->
    * <!-- End of user code doc for onPort_invocationAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInvocationAction.onPort
    */
  def onPort_invocationAction: Set[UMLInvocationAction[Uml]]

  /**
    * <!-- Start of user code doc for ownedPort_encapsulatedClassifier -->
    * <!-- End of user code doc for ownedPort_encapsulatedClassifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLEncapsulatedClassifier.ownedPort
    */
  def ownedPort_encapsulatedClassifier: Option[UMLEncapsulatedClassifier[Uml]]

  /**
    * <!-- Start of user code doc for port_trigger -->
    * <!-- End of user code doc for port_trigger -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTrigger.port
    */
  def port_trigger: Set[UMLTrigger[Uml]]

  /**
    * <!-- Start of user code doc for redefinedPort_port -->
    * <!-- End of user code doc for redefinedPort_port -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPort.redefinedPort
    */
  def redefinedPort_port: Set[UMLPort[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      port_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLPort
    *
    * <!-- Start of user code doc for port_metaAttributes -->
    * <!-- End of user code doc for port_metaAttributes -->
    */
  def port_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     property_metaAttributes,
     Seq[MetaAttributeFunction](Port_isBehavior,
     	Port_isConjugated,
     	Port_isService))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    port_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLPort
    *
    * <!-- Start of user code doc for port_compositeMetaProperties -->
    * <!-- End of user code doc for port_compositeMetaProperties -->
    */
  def port_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      property_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    port_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLPort
    *
    * <!-- Start of user code doc for port_referenceMetaProperties -->
    * <!-- End of user code doc for port_referenceMetaProperties -->
    */
  def port_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      property_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Port_protocol,
      	Port_redefinedPort))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    port_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLPort
    *
    * <!-- Start of user code doc for port_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for port_forwardReferencesFromMetamodelAssociations -->
    */
  def port_forwardReferencesFromMetamodelAssociations: Elements =
    property_forwardReferencesFromMetamodelAssociations ++
    protocol ++
    redefinedPort

  // Start of user code for additional features
  // End of user code
} //UMLPort
