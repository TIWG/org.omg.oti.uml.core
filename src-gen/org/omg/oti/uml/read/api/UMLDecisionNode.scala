/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.uml.read.operations.UMLDecisionNodeOps

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

  import ops._

  /**
   * A Behavior that is executed to provide an input to guard ValueSpecifications on ActivityEdges outgoing from the DecisionNode.
   *
   * <!-- Start of user code doc for decisionInput -->
   * <!-- End of user code doc for decisionInput -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
   * @opposite org.omg.oti.api.UMLBehavior.decisionInput_decisionNode
   */
  def decisionInput: Option[UMLBehavior[Uml]]

  /**
   * An additional ActivityEdge incoming to the DecisionNode that provides a decision input value for the guards ValueSpecifications on ActivityEdges outgoing from the DecisionNode.
   *
   * <!-- Start of user code doc for decisionInputFlow -->
   * <!-- End of user code doc for decisionInputFlow -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
   * @opposite org.omg.oti.api.UMLObjectFlow.decisionInputFlow_decisionNode
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
      Seq ())

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
      Seq ())

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
      Seq (DecisionNode_decisionInput,
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
