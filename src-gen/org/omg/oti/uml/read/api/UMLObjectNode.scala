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
import org.omg.oti.uml.read.operations.UMLObjectNodeOps

// End of user code

/**
 * An ObjectNode is an abstract ActivityNode that may hold tokens within the object flow in an Activity. ObjectNodes also support token selection, limitation on the number of tokens held, specification of the state required for tokens being held, and carrying control values.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLObjectNode[Uml <: UML]
  extends UMLActivityNode[Uml]
  with UMLTypedElement[Uml]
  with UMLObjectNodeOps[Uml] {

  import ops._

  /**
   * The States required to be associated with the values held by tokens on this ObjectNode.
   *
   * <!-- Start of user code doc for inState -->
   * <!-- End of user code doc for inState -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
   * @opposite org.omg.oti.api.UMLState.inState_objectNode
   */
  def inState: Set[UMLState[Uml]]

  /**
   * Indicates whether the type of the ObjectNode is to be treated as representing control values that may traverse ControlFlows.
   *
   * <!-- Start of user code doc for isControlType -->
   * <!-- End of user code doc for isControlType -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
   */
  def isControlType: Boolean

  /**
   * Indicates how the tokens held by the ObjectNode are ordered for selection to traverse ActivityEdges outgoing from the ObjectNode.
   *
   * <!-- Start of user code doc for ordering -->
   * <!-- End of user code doc for ordering -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
   */
  def ordering: UMLObjectNodeOrderingKind.Value

  /**
   * A Behavior used to select tokens to be offered on outgoing ActivityEdges.
   *
   * <!-- Start of user code doc for selection -->
   * <!-- End of user code doc for selection -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
   * @opposite org.omg.oti.api.UMLBehavior.selection_objectNode
   */
  def selection: Option[UMLBehavior[Uml]]

  /**
   * The maximum number of tokens that may be held by this ObjectNode. Tokens cannot flow into the ObjectNode if the upperBound is reached. If no upperBound is specified, then there is no limit on how many tokens the ObjectNode can hold.
   *
   * <!-- Start of user code doc for upperBound -->
   * <!-- End of user code doc for upperBound -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
   * @opposite org.omg.oti.api.UMLValueSpecification.upperBound_objectNode
   */
  def upperBound: Option[UMLValueSpecification[Uml]]

  /**
   * <!-- Start of user code doc for exceptionInput_exceptionHandler -->
   * <!-- End of user code doc for exceptionInput_exceptionHandler -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
   * @opposite org.omg.oti.api.UMLExceptionHandler.exceptionInput
   */
  def exceptionInput_exceptionHandler: Set[UMLExceptionHandler[Uml]]

  /**
   * The XMI meta-attributes relevant to this object
   *
   * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
   */
  override def metaAttributes: MetaAttributeFunctions =
    objectNode_metaAttributes

  /**
   * The XMI meta-attributes relevant to class UMLObjectNode
   *
   * <!-- Start of user code doc for objectNode_metaAttributes -->
   * <!-- End of user code doc for objectNode_metaAttributes -->
   */
  def objectNode_metaAttributes: MetaAttributeFunctions =
    appendUnique(
      activityNode_metaAttributes,
      typedElement_metaAttributes,
      Seq (ObjectNode_isControlType))

  /**
   * The XMI composite meta-properties relevant to this object
   *
   * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
   */
  override def compositeMetaProperties: MetaPropertyFunctions =
    objectNode_compositeMetaProperties

  /**
   * The XMI composite meta-properties relevant to class UMLObjectNode
   *
   * <!-- Start of user code doc for objectNode_compositeMetaProperties -->
   * <!-- End of user code doc for objectNode_compositeMetaProperties -->
   */
  def objectNode_compositeMetaProperties: MetaPropertyFunctions =
    appendUnique(
      activityNode_compositeMetaProperties,
      typedElement_compositeMetaProperties,
      Seq (ObjectNode_upperBound))

  /**
   * The XMI reference meta-properties relevant to this object
   *
   * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
   */
  override def referenceMetaProperties: MetaPropertyFunctions =
    objectNode_referenceMetaProperties

  /**
   * The XMI reference meta-properties relevant to class UMLObjectNode
   *
   * <!-- Start of user code doc for objectNode_referenceMetaProperties -->
   * <!-- End of user code doc for objectNode_referenceMetaProperties -->
   */
  def objectNode_referenceMetaProperties: MetaPropertyFunctions =
    appendUnique(
      activityNode_referenceMetaProperties,
      typedElement_referenceMetaProperties,
      Seq (ObjectNode_inState,
        ObjectNode_selection))

  /**
   * The XMI forward references from metamodel associations relevant to this object
   *
   * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
   */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    objectNode_forwardReferencesFromMetamodelAssociations

  /**
   * The XMI forward references from metamodel associations relevant to class UMLObjectNode
   *
   * <!-- Start of user code doc for objectNode_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for objectNode_forwardReferencesFromMetamodelAssociations -->
   */
  def objectNode_forwardReferencesFromMetamodelAssociations: Elements =
    activityNode_forwardReferencesFromMetamodelAssociations ++
    typedElement_forwardReferencesFromMetamodelAssociations ++
    inState ++
    selection

  // Start of user code for additional features
  // End of user code
} //UMLObjectNode
