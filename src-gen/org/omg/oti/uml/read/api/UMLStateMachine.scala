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
import org.omg.oti.uml.read.operations.UMLStateMachineOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * StateMachines can be used to express event-driven behaviors of parts of a system. Behavior is modeled as a traversal of a graph of Vertices interconnected by one or more joined Transition arcs that are triggered by the dispatching of successive Event occurrences. During this traversal, the StateMachine may execute a sequence of Behaviors associated with various elements of the StateMachine.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStateMachine[Uml <: UML]
  extends UMLBehavior[Uml]
  with UMLStateMachineOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * References the submachine(s) in case of a submachine State. Multiple machines are referenced in case of a concurrent State.
    *
    * <!-- Start of user code doc for submachineState -->
    * <!-- End of user code doc for submachineState -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLState.submachine
    */
  def submachineState: Set[UMLState[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      stateMachine_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLStateMachine
    *
    * <!-- Start of user code doc for stateMachine_metaAttributes -->
    * <!-- End of user code doc for stateMachine_metaAttributes -->
    */
  def stateMachine_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     behavior_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    stateMachine_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLStateMachine
    *
    * <!-- Start of user code doc for stateMachine_compositeMetaProperties -->
    * <!-- End of user code doc for stateMachine_compositeMetaProperties -->
    */
  def stateMachine_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavior_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](StateMachine_connectionPoint,
      	StateMachine_region))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    stateMachine_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLStateMachine
    *
    * <!-- Start of user code doc for stateMachine_referenceMetaProperties -->
    * <!-- End of user code doc for stateMachine_referenceMetaProperties -->
    */
  def stateMachine_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavior_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](StateMachine_extendedStateMachine,
      	StateMachine_submachineState))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    stateMachine_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLStateMachine
    *
    * <!-- Start of user code doc for stateMachine_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for stateMachine_forwardReferencesFromMetamodelAssociations -->
    */
  def stateMachine_forwardReferencesFromMetamodelAssociations: Elements =
    behavior_forwardReferencesFromMetamodelAssociations ++
    extendedStateMachine ++
    submachineState

  // Start of user code for additional features
  // End of user code
} //UMLStateMachine
