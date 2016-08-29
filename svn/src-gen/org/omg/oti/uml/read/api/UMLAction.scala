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
import org.omg.oti.uml.read.operations.UMLActionOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An Action is the fundamental unit of executable functionality. The execution of an Action represents some transformation or processing in the modeled system. Actions provide the ExecutableNodes within Activities and may also be used within Interactions.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAction[Uml <: UML]
  extends UMLExecutableNode[Uml]
  with UMLActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The ordered set of InputPins representing the inputs to the Action.
    *
    * <!-- Start of user code doc for input -->
    * <!-- End of user code doc for input -->
    *
    * UML Property derived="true" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.input_action
    */
  def input: Seq[UMLInputPin[Uml]]

  /**
    * If true, the Action can begin a new, concurrent execution, even if there is already another execution of the Action ongoing. If false, the Action cannot begin a new execution until any previous execution has completed.
    *
    * <!-- Start of user code doc for isLocallyReentrant -->
    * <!-- End of user code doc for isLocallyReentrant -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isLocallyReentrant: Boolean

  /**
    * A Constraint that must be satisfied when execution of the Action is completed.
    *
    * <!-- Start of user code doc for localPostcondition -->
    * <!-- End of user code doc for localPostcondition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.localPostcondition_action
    */
  def localPostcondition: Set[UMLConstraint[Uml]]

  /**
    * A Constraint that must be satisfied when execution of the Action is started.
    *
    * <!-- Start of user code doc for localPrecondition -->
    * <!-- End of user code doc for localPrecondition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.localPrecondition_action
    */
  def localPrecondition: Set[UMLConstraint[Uml]]

  /**
    * The ordered set of OutputPins representing outputs from the Action.
    *
    * <!-- Start of user code doc for output -->
    * <!-- End of user code doc for output -->
    *
    * UML Property derived="true" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.output_action
    */
  def output: Seq[UMLOutputPin[Uml]]

  /**
    * <!-- Start of user code doc for action_actionExecutionSpecification -->
    * <!-- End of user code doc for action_actionExecutionSpecification -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActionExecutionSpecification.action
    */
  def action_actionExecutionSpecification: Set[UMLActionExecutionSpecification[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      action_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLAction
    *
    * <!-- Start of user code doc for action_metaAttributes -->
    * <!-- End of user code doc for action_metaAttributes -->
    */
  def action_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     executableNode_metaAttributes,
     Seq[MetaAttributeFunction](Action_isLocallyReentrant))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    action_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLAction
    *
    * <!-- Start of user code doc for action_compositeMetaProperties -->
    * <!-- End of user code doc for action_compositeMetaProperties -->
    */
  def action_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      executableNode_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Action_localPostcondition,
      	Action_localPrecondition))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    action_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLAction
    *
    * <!-- Start of user code doc for action_referenceMetaProperties -->
    * <!-- End of user code doc for action_referenceMetaProperties -->
    */
  def action_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      executableNode_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLAction
    *
    * <!-- Start of user code doc for action_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for action_forwardReferencesFromMetamodelAssociations -->
    */
  def action_forwardReferencesFromMetamodelAssociations: Elements =
    executableNode_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLAction
