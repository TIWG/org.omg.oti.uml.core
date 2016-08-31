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
import org.omg.oti.uml.read.operations.UMLProtocolTransitionOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
import scala.Option
// End of user code


/**
  * A ProtocolTransition specifies a legal Transition for an Operation. Transitions of ProtocolStateMachines have the following information: a pre-condition (guard), a Trigger, and a post-condition. Every ProtocolTransition is associated with at most one BehavioralFeature belonging to the context Classifier of the ProtocolStateMachine.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLProtocolTransition[Uml <: UML]
  extends UMLTransition[Uml]
  with UMLProtocolTransitionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies the post condition of the Transition which is the Condition that should be obtained once the Transition is triggered. This post condition is part of the post condition of the Operation connected to the Transition.
    *
    * <!-- Start of user code doc for postCondition -->
    * <!-- End of user code doc for postCondition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.postCondition_owningTransition
    */
  def postCondition: Option[UMLConstraint[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      protocolTransition_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLProtocolTransition
    *
    * <!-- Start of user code doc for protocolTransition_metaAttributes -->
    * <!-- End of user code doc for protocolTransition_metaAttributes -->
    */
  def protocolTransition_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     transition_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    protocolTransition_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLProtocolTransition
    *
    * <!-- Start of user code doc for protocolTransition_compositeMetaProperties -->
    * <!-- End of user code doc for protocolTransition_compositeMetaProperties -->
    */
  def protocolTransition_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      transition_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ProtocolTransition_postCondition,
      	ProtocolTransition_preCondition))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    protocolTransition_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLProtocolTransition
    *
    * <!-- Start of user code doc for protocolTransition_referenceMetaProperties -->
    * <!-- End of user code doc for protocolTransition_referenceMetaProperties -->
    */
  def protocolTransition_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      transition_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    protocolTransition_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLProtocolTransition
    *
    * <!-- Start of user code doc for protocolTransition_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for protocolTransition_forwardReferencesFromMetamodelAssociations -->
    */
  def protocolTransition_forwardReferencesFromMetamodelAssociations: Elements =
    transition_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLProtocolTransition
