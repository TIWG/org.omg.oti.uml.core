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
import org.omg.oti.uml.read.operations.UMLStateOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A State models a situation during which some (usually implicit) invariant condition holds.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLState[Uml <: UML]
  extends UMLNamespace[Uml]
	with UMLRedefinableElement[Uml]
	with UMLVertex[Uml]
  with UMLStateOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * An optional Behavior that is executed while being in the State. The execution starts when this State is entered, and ceases either by itself when done, or when the State is exited, whichever comes first.
    *
    * <!-- Start of user code doc for doActivity -->
    * <!-- End of user code doc for doActivity -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.doActivity_state
    */
  def doActivity: Option[UMLBehavior[Uml]]

  /**
    * An optional Behavior that is executed whenever this State is entered regardless of the Transition taken to reach the State. If defined, entry Behaviors are always executed to completion prior to any internal Behavior or Transitions performed within the State.
    *
    * <!-- Start of user code doc for entry -->
    * <!-- End of user code doc for entry -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.entry_state
    */
  def entry: Option[UMLBehavior[Uml]]

  /**
    * An optional Behavior that is executed whenever this State is exited regardless of which Transition was taken out of the State. If defined, exit Behaviors are always executed to completion only after all internal and transition Behaviors have completed execution.
    *
    * <!-- Start of user code doc for exit -->
    * <!-- End of user code doc for exit -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.exit_state
    */
  def exit: Option[UMLBehavior[Uml]]

  /**
    * Specifies conditions that are always true when this State is the current State. In ProtocolStateMachines state invariants are additional conditions to the preconditions of the outgoing Transitions, and to the postcondition of the incoming Transitions.
    *
    * <!-- Start of user code doc for stateInvariant -->
    * <!-- End of user code doc for stateInvariant -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.stateInvariant_owningState
    */
  def stateInvariant: Option[UMLConstraint[Uml]]

  /**
    * The StateMachine that is to be inserted in place of the (submachine) State.
    *
    * <!-- Start of user code doc for submachine -->
    * <!-- End of user code doc for submachine -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStateMachine.submachineState
    */
  def submachine: Option[UMLStateMachine[Uml]]

  /**
    * <!-- Start of user code doc for inState_objectNode -->
    * <!-- End of user code doc for inState_objectNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLObjectNode.inState
    */
  def inState_objectNode: Set[UMLObjectNode[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      state_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLState
    *
    * <!-- Start of user code doc for state_metaAttributes -->
    * <!-- End of user code doc for state_metaAttributes -->
    */
  def state_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namespace_metaAttributes,
     redefinableElement_metaAttributes,
     vertex_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    state_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLState
    *
    * <!-- Start of user code doc for state_compositeMetaProperties -->
    * <!-- End of user code doc for state_compositeMetaProperties -->
    */
  def state_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namespace_compositeMetaProperties,
      redefinableElement_compositeMetaProperties,
      vertex_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](State_connection,
      	State_connectionPoint,
      	State_deferrableTrigger,
      	State_doActivity,
      	State_entry,
      	State_exit,
      	State_region,
      	State_stateInvariant))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    state_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLState
    *
    * <!-- Start of user code doc for state_referenceMetaProperties -->
    * <!-- End of user code doc for state_referenceMetaProperties -->
    */
  def state_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namespace_referenceMetaProperties,
      redefinableElement_referenceMetaProperties,
      vertex_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](State_redefinedState,
      	State_submachine))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    state_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLState
    *
    * <!-- Start of user code doc for state_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for state_forwardReferencesFromMetamodelAssociations -->
    */
  def state_forwardReferencesFromMetamodelAssociations: Elements =
    namespace_forwardReferencesFromMetamodelAssociations ++
    redefinableElement_forwardReferencesFromMetamodelAssociations ++
    vertex_forwardReferencesFromMetamodelAssociations ++
    redefinedState ++
    submachine

  // Start of user code for additional features
  // End of user code
} //UMLState
