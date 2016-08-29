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
import org.omg.oti.uml.read.operations.UMLObjectFlowOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * An ObjectFlow is an ActivityEdge that is traversed by object tokens that may hold values. Object flows also support multicast/receive, token selection from object nodes, and transformation of tokens.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLObjectFlow[Uml <: UML]
  extends UMLActivityEdge[Uml]
  with UMLObjectFlowOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Indicates whether the objects in the ObjectFlow are passed by multicasting.
    *
    * <!-- Start of user code doc for isMulticast -->
    * <!-- End of user code doc for isMulticast -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isMulticast: Boolean

  /**
    * Indicates whether the objects in the ObjectFlow are gathered from respondents to multicasting.
    *
    * <!-- Start of user code doc for isMultireceive -->
    * <!-- End of user code doc for isMultireceive -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isMultireceive: Boolean

  /**
    * A Behavior used to select tokens from a source ObjectNode.
    *
    * <!-- Start of user code doc for selection -->
    * <!-- End of user code doc for selection -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.selection_objectFlow
    */
  def selection: Option[UMLBehavior[Uml]]

  /**
    * A Behavior used to change or replace object tokens flowing along the ObjectFlow.
    *
    * <!-- Start of user code doc for transformation -->
    * <!-- End of user code doc for transformation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.transformation_objectFlow
    */
  def transformation: Option[UMLBehavior[Uml]]

  /**
    * <!-- Start of user code doc for decisionInputFlow_decisionNode -->
    * <!-- End of user code doc for decisionInputFlow_decisionNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDecisionNode.decisionInputFlow
    */
  def decisionInputFlow_decisionNode: Option[UMLDecisionNode[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      objectFlow_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLObjectFlow
    *
    * <!-- Start of user code doc for objectFlow_metaAttributes -->
    * <!-- End of user code doc for objectFlow_metaAttributes -->
    */
  def objectFlow_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     activityEdge_metaAttributes,
     Seq[MetaAttributeFunction](ObjectFlow_isMulticast,
     	ObjectFlow_isMultireceive))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    objectFlow_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLObjectFlow
    *
    * <!-- Start of user code doc for objectFlow_compositeMetaProperties -->
    * <!-- End of user code doc for objectFlow_compositeMetaProperties -->
    */
  def objectFlow_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      activityEdge_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    objectFlow_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLObjectFlow
    *
    * <!-- Start of user code doc for objectFlow_referenceMetaProperties -->
    * <!-- End of user code doc for objectFlow_referenceMetaProperties -->
    */
  def objectFlow_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      activityEdge_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ObjectFlow_selection,
      	ObjectFlow_transformation))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    objectFlow_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLObjectFlow
    *
    * <!-- Start of user code doc for objectFlow_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for objectFlow_forwardReferencesFromMetamodelAssociations -->
    */
  def objectFlow_forwardReferencesFromMetamodelAssociations: Elements =
    activityEdge_forwardReferencesFromMetamodelAssociations ++
    selection ++
    transformation

  // Start of user code for additional features
  // End of user code
} //UMLObjectFlow
