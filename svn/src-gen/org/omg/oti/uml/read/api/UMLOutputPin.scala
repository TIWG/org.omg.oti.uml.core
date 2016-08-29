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
import org.omg.oti.uml.read.operations.UMLOutputPinOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An OutputPin is a Pin that holds output values produced by an Action.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLOutputPin[Uml <: UML]
  extends UMLPin[Uml]
  with UMLOutputPinOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * <!-- Start of user code doc for bodyOutput_clause -->
    * <!-- End of user code doc for bodyOutput_clause -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClause.bodyOutput
    */
  def bodyOutput_clause: Set[UMLClause[Uml]]

  /**
    * <!-- Start of user code doc for bodyOutput_loopNode -->
    * <!-- End of user code doc for bodyOutput_loopNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLoopNode.bodyOutput
    */
  def bodyOutput_loopNode: Set[UMLLoopNode[Uml]]

  /**
    * <!-- Start of user code doc for decider_clause -->
    * <!-- End of user code doc for decider_clause -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClause.decider
    */
  def decider_clause: Option[UMLClause[Uml]]

  /**
    * <!-- Start of user code doc for decider_loopNode -->
    * <!-- End of user code doc for decider_loopNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLoopNode.decider
    */
  def decider_loopNode: Option[UMLLoopNode[Uml]]

  /**
    * <!-- Start of user code doc for loopVariable_loopNode -->
    * <!-- End of user code doc for loopVariable_loopNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLoopNode.loopVariable
    */
  def loopVariable_loopNode: Option[UMLLoopNode[Uml]]

  /**
    * <!-- Start of user code doc for output_action -->
    * <!-- End of user code doc for output_action -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAction.output
    */
  def output_action: Option[UMLAction[Uml]]

  /**
    * <!-- Start of user code doc for result_acceptEventAction -->
    * <!-- End of user code doc for result_acceptEventAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAcceptEventAction.result
    */
  def result_acceptEventAction: Option[UMLAcceptEventAction[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      outputPin_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLOutputPin
    *
    * <!-- Start of user code doc for outputPin_metaAttributes -->
    * <!-- End of user code doc for outputPin_metaAttributes -->
    */
  def outputPin_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     pin_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    outputPin_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLOutputPin
    *
    * <!-- Start of user code doc for outputPin_compositeMetaProperties -->
    * <!-- End of user code doc for outputPin_compositeMetaProperties -->
    */
  def outputPin_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      pin_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    outputPin_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLOutputPin
    *
    * <!-- Start of user code doc for outputPin_referenceMetaProperties -->
    * <!-- End of user code doc for outputPin_referenceMetaProperties -->
    */
  def outputPin_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      pin_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    outputPin_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLOutputPin
    *
    * <!-- Start of user code doc for outputPin_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for outputPin_forwardReferencesFromMetamodelAssociations -->
    */
  def outputPin_forwardReferencesFromMetamodelAssociations: Elements =
    pin_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLOutputPin
