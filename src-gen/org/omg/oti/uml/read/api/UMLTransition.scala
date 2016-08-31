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
import org.omg.oti.uml.read.operations.UMLTransitionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A Transition represents an arc between exactly one source Vertex and exactly one Target vertex (the source and targets may be the same Vertex). It may form part of a compound transition, which takes the StateMachine from one steady State configuration to another, representing the full response of the StateMachine to an occurrence of an Event that triggered it.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTransition[Uml <: UML]
  extends UMLNamespace[Uml]
	with UMLRedefinableElement[Uml]
  with UMLTransitionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * A guard is a Constraint that provides a fine-grained control over the firing of the Transition. The guard is evaluated when an Event occurrence is dispatched by the StateMachine. If the guard is true at that time, the Transition may be enabled, otherwise, it is disabled. Guards should be pure expressions without side effects. Guard expressions with side effects are ill formed.
    *
    * <!-- Start of user code doc for guard -->
    * <!-- End of user code doc for guard -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.guard_transition
    */
  def guard: Option[UMLConstraint[Uml]]

  /**
    * Indicates the precise type of the Transition.
    *
    * <!-- Start of user code doc for kind -->
    * <!-- End of user code doc for kind -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def kind: Option[UMLTransitionKind.Value]

  /**
    * Designates the originating Vertex (State or Pseudostate) of the Transition.
    *
    * <!-- Start of user code doc for source -->
    * <!-- End of user code doc for source -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLVertex.outgoing
    */
  def source: Option[UMLVertex[Uml]]

  /**
    * Designates the target Vertex that is reached when the Transition is taken.
    *
    * <!-- Start of user code doc for target -->
    * <!-- End of user code doc for target -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLVertex.incoming
    */
  def target: Option[UMLVertex[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      transition_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLTransition
    *
    * <!-- Start of user code doc for transition_metaAttributes -->
    * <!-- End of user code doc for transition_metaAttributes -->
    */
  def transition_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namespace_metaAttributes,
     redefinableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    transition_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLTransition
    *
    * <!-- Start of user code doc for transition_compositeMetaProperties -->
    * <!-- End of user code doc for transition_compositeMetaProperties -->
    */
  def transition_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namespace_compositeMetaProperties,
      redefinableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Transition_effect,
      	Transition_guard,
      	Transition_trigger))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    transition_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLTransition
    *
    * <!-- Start of user code doc for transition_referenceMetaProperties -->
    * <!-- End of user code doc for transition_referenceMetaProperties -->
    */
  def transition_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namespace_referenceMetaProperties,
      redefinableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Transition_redefinedTransition,
      	Transition_source,
      	Transition_target))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    transition_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLTransition
    *
    * <!-- Start of user code doc for transition_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for transition_forwardReferencesFromMetamodelAssociations -->
    */
  def transition_forwardReferencesFromMetamodelAssociations: Elements =
    namespace_forwardReferencesFromMetamodelAssociations ++
    redefinableElement_forwardReferencesFromMetamodelAssociations ++
    redefinedTransition ++
    source ++
    target

  // Start of user code for additional features
  // End of user code
} //UMLTransition
