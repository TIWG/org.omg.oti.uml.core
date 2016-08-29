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
import org.omg.oti.uml.read.operations.UMLObjectNodeOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
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

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The States required to be associated with the values held by tokens on this ObjectNode.
    *
    * <!-- Start of user code doc for inState -->
    * <!-- End of user code doc for inState -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLState.inState_objectNode
    */
  def inState: Set[UMLState[Uml]]

  /**
    * Indicates whether the type of the ObjectNode is to be treated as representing control values that may traverse ControlFlows.
    *
    * <!-- Start of user code doc for isControlType -->
    * <!-- End of user code doc for isControlType -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isControlType: Boolean

  /**
    * Indicates how the tokens held by the ObjectNode are ordered for selection to traverse ActivityEdges outgoing from the ObjectNode.
    *
    * <!-- Start of user code doc for ordering -->
    * <!-- End of user code doc for ordering -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def ordering: Option[UMLObjectNodeOrderingKind.Value]

  /**
    * A Behavior used to select tokens to be offered on outgoing ActivityEdges.
    *
    * <!-- Start of user code doc for selection -->
    * <!-- End of user code doc for selection -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.selection_objectNode
    */
  def selection: Option[UMLBehavior[Uml]]

  /**
    * The maximum number of tokens that may be held by this ObjectNode. Tokens cannot flow into the ObjectNode if the upperBound is reached. If no upperBound is specified, then there is no limit on how many tokens the ObjectNode can hold.
    *
    * <!-- Start of user code doc for upperBound -->
    * <!-- End of user code doc for upperBound -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.upperBound_objectNode
    */
  def upperBound: Option[UMLValueSpecification[Uml]]

  /**
    * <!-- Start of user code doc for exceptionInput_exceptionHandler -->
    * <!-- End of user code doc for exceptionInput_exceptionHandler -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExceptionHandler.exceptionInput
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
     Seq[MetaAttributeFunction](ObjectNode_isControlType))

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
      Seq[MetaPropertyEvaluator](ObjectNode_upperBound))

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
      Seq[MetaPropertyEvaluator](ObjectNode_inState,
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
