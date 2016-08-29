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
import org.omg.oti.uml.read.operations.UMLInterfaceOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * Interfaces declare coherent services that are implemented by BehavioredClassifiers that implement the Interfaces via InterfaceRealizations.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInterface[Uml <: UML]
  extends UMLClassifier[Uml]
  with UMLInterfaceOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * References all the Classifiers that are defined (nested) within the Interface.
    *
    * <!-- Start of user code doc for nestedClassifier -->
    * <!-- End of user code doc for nestedClassifier -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.nestedClassifier_interface
    */
  def nestedClassifier: Seq[UMLClassifier[Uml]]

  /**
    * The attributes (i.e., the Properties) owned by the Interface.
    *
    * <!-- Start of user code doc for ownedAttribute -->
    * <!-- End of user code doc for ownedAttribute -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.interface
    */
  def ownedAttribute: Seq[UMLProperty[Uml]]

  /**
    * The Operations owned by the Interface.
    *
    * <!-- Start of user code doc for ownedOperation -->
    * <!-- End of user code doc for ownedOperation -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.interface
    */
  def ownedOperation: Seq[UMLOperation[Uml]]

  /**
    * References all the Interfaces redefined by this Interface.
    *
    * <!-- Start of user code doc for redefinedInterface -->
    * <!-- End of user code doc for redefinedInterface -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.redefinedInterface_interface
    */
  def redefinedInterface: Set[UMLInterface[Uml]]

  /**
    * <!-- Start of user code doc for contract_interfaceRealization -->
    * <!-- End of user code doc for contract_interfaceRealization -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterfaceRealization.contract
    */
  def contract_interfaceRealization: Set[UMLInterfaceRealization[Uml]]

  /**
    * <!-- Start of user code doc for provided_component -->
    * <!-- End of user code doc for provided_component -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLComponent.provided
    */
  def provided_component: Set[UMLComponent[Uml]]

  /**
    * <!-- Start of user code doc for provided_port -->
    * <!-- End of user code doc for provided_port -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPort.provided
    */
  def provided_port: Set[UMLPort[Uml]]

  /**
    * <!-- Start of user code doc for redefinedInterface_interface -->
    * <!-- End of user code doc for redefinedInterface_interface -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.redefinedInterface
    */
  def redefinedInterface_interface: Set[UMLInterface[Uml]]

  /**
    * <!-- Start of user code doc for required_component -->
    * <!-- End of user code doc for required_component -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLComponent.required
    */
  def required_component: Set[UMLComponent[Uml]]

  /**
    * <!-- Start of user code doc for required_port -->
    * <!-- End of user code doc for required_port -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPort.required
    */
  def required_port: Set[UMLPort[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      interface_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInterface
    *
    * <!-- Start of user code doc for interface_metaAttributes -->
    * <!-- End of user code doc for interface_metaAttributes -->
    */
  def interface_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     classifier_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    interface_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInterface
    *
    * <!-- Start of user code doc for interface_compositeMetaProperties -->
    * <!-- End of user code doc for interface_compositeMetaProperties -->
    */
  def interface_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Interface_nestedClassifier,
      	Interface_ownedAttribute,
      	Interface_ownedOperation,
      	Interface_ownedReception,
      	Interface_protocol))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    interface_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInterface
    *
    * <!-- Start of user code doc for interface_referenceMetaProperties -->
    * <!-- End of user code doc for interface_referenceMetaProperties -->
    */
  def interface_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Interface_redefinedInterface))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    interface_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInterface
    *
    * <!-- Start of user code doc for interface_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for interface_forwardReferencesFromMetamodelAssociations -->
    */
  def interface_forwardReferencesFromMetamodelAssociations: Elements =
    classifier_forwardReferencesFromMetamodelAssociations ++
    redefinedInterface

  // Start of user code for additional features
  // End of user code
} //UMLInterface
