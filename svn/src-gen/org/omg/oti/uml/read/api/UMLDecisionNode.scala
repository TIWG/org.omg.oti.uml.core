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
import org.omg.oti.uml.read.operations.UMLDecisionNodeOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A DecisionNode is a ControlNode that chooses between outgoing ActivityEdges for the routing of tokens.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDecisionNode[Uml <: UML]
  extends UMLControlNode[Uml]
  with UMLDecisionNodeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * A Behavior that is executed to provide an input to guard ValueSpecifications on ActivityEdges outgoing from the DecisionNode.
    *
    * <!-- Start of user code doc for decisionInput -->
    * <!-- End of user code doc for decisionInput -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.decisionInput_decisionNode
    */
  def decisionInput: Option[UMLBehavior[Uml]]

  /**
    * An additional ActivityEdge incoming to the DecisionNode that provides a decision input value for the guards ValueSpecifications on ActivityEdges outgoing from the DecisionNode.
    *
    * <!-- Start of user code doc for decisionInputFlow -->
    * <!-- End of user code doc for decisionInputFlow -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLObjectFlow.decisionInputFlow_decisionNode
    */
  def decisionInputFlow: Option[UMLObjectFlow[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      decisionNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDecisionNode
    *
    * <!-- Start of user code doc for decisionNode_metaAttributes -->
    * <!-- End of user code doc for decisionNode_metaAttributes -->
    */
  def decisionNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     controlNode_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    decisionNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDecisionNode
    *
    * <!-- Start of user code doc for decisionNode_compositeMetaProperties -->
    * <!-- End of user code doc for decisionNode_compositeMetaProperties -->
    */
  def decisionNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      controlNode_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    decisionNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDecisionNode
    *
    * <!-- Start of user code doc for decisionNode_referenceMetaProperties -->
    * <!-- End of user code doc for decisionNode_referenceMetaProperties -->
    */
  def decisionNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      controlNode_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](DecisionNode_decisionInput,
      	DecisionNode_decisionInputFlow))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    decisionNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDecisionNode
    *
    * <!-- Start of user code doc for decisionNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for decisionNode_forwardReferencesFromMetamodelAssociations -->
    */
  def decisionNode_forwardReferencesFromMetamodelAssociations: Elements =
    controlNode_forwardReferencesFromMetamodelAssociations ++
    decisionInput ++
    decisionInputFlow

  // Start of user code for additional features
  // End of user code
} //UMLDecisionNode
