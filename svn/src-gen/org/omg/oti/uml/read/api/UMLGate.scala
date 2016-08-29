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
import org.omg.oti.uml.read.operations.UMLGateOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Gate is a MessageEnd which serves as a connection point for relating a Message which has a MessageEnd (sendEvent / receiveEvent) outside an InteractionFragment with another Message which has a MessageEnd (receiveEvent / sendEvent)  inside that InteractionFragment.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLGate[Uml <: UML]
  extends UMLMessageEnd[Uml]
  with UMLGateOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      gate_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLGate
    *
    * <!-- Start of user code doc for gate_metaAttributes -->
    * <!-- End of user code doc for gate_metaAttributes -->
    */
  def gate_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     messageEnd_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    gate_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLGate
    *
    * <!-- Start of user code doc for gate_compositeMetaProperties -->
    * <!-- End of user code doc for gate_compositeMetaProperties -->
    */
  def gate_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      messageEnd_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    gate_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLGate
    *
    * <!-- Start of user code doc for gate_referenceMetaProperties -->
    * <!-- End of user code doc for gate_referenceMetaProperties -->
    */
  def gate_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      messageEnd_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    gate_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLGate
    *
    * <!-- Start of user code doc for gate_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for gate_forwardReferencesFromMetamodelAssociations -->
    */
  def gate_forwardReferencesFromMetamodelAssociations: Elements =
    messageEnd_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLGate
