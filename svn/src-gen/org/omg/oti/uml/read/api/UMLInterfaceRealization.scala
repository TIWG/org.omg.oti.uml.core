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
import org.omg.oti.uml.read.operations.UMLInterfaceRealizationOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * An InterfaceRealization is a specialized realization relationship between a BehavioredClassifier and an Interface. This relationship signifies that the realizing BehavioredClassifier conforms to the contract specified by the Interface.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInterfaceRealization[Uml <: UML]
  extends UMLRealization[Uml]
  with UMLInterfaceRealizationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * References the Interface specifying the conformance contract.
    *
    * <!-- Start of user code doc for contract -->
    * <!-- End of user code doc for contract -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.contract_interfaceRealization
    */
  def contract: Option[UMLInterface[Uml]]

  /**
    * References the BehavioredClassifier that owns this InterfaceRealization, i.e., the BehavioredClassifier that realizes the Interface to which it refers.
    *
    * <!-- Start of user code doc for implementingClassifier -->
    * <!-- End of user code doc for implementingClassifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavioredClassifier.interfaceRealization
    */
  def implementingClassifier: Option[UMLBehavioredClassifier[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      interfaceRealization_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInterfaceRealization
    *
    * <!-- Start of user code doc for interfaceRealization_metaAttributes -->
    * <!-- End of user code doc for interfaceRealization_metaAttributes -->
    */
  def interfaceRealization_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     realization_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    interfaceRealization_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInterfaceRealization
    *
    * <!-- Start of user code doc for interfaceRealization_compositeMetaProperties -->
    * <!-- End of user code doc for interfaceRealization_compositeMetaProperties -->
    */
  def interfaceRealization_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      realization_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    interfaceRealization_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInterfaceRealization
    *
    * <!-- Start of user code doc for interfaceRealization_referenceMetaProperties -->
    * <!-- End of user code doc for interfaceRealization_referenceMetaProperties -->
    */
  def interfaceRealization_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      realization_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](InterfaceRealization_contract))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    interfaceRealization_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInterfaceRealization
    *
    * <!-- Start of user code doc for interfaceRealization_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for interfaceRealization_forwardReferencesFromMetamodelAssociations -->
    */
  def interfaceRealization_forwardReferencesFromMetamodelAssociations: Elements =
    realization_forwardReferencesFromMetamodelAssociations ++
    contract

  // Start of user code for additional features
  // End of user code
} //UMLInterfaceRealization
