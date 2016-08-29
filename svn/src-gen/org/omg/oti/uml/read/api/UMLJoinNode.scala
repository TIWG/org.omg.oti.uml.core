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
import org.omg.oti.uml.read.operations.UMLJoinNodeOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A JoinNode is a ControlNode that synchronizes multiple flows.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLJoinNode[Uml <: UML]
  extends UMLControlNode[Uml]
  with UMLJoinNodeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Indicates whether incoming tokens having objects with the same identity are combined into one by the JoinNode.
    *
    * <!-- Start of user code doc for isCombineDuplicate -->
    * <!-- End of user code doc for isCombineDuplicate -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isCombineDuplicate: Boolean

  /**
    * A ValueSpecification giving the condition under which the JoinNode will offer a token on its outgoing ActivityEdge. If no joinSpec is specified, then the JoinNode will offer an outgoing token if tokens are offered on all of its incoming ActivityEdges (an "and" condition).
    *
    * <!-- Start of user code doc for joinSpec -->
    * <!-- End of user code doc for joinSpec -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.joinSpec_joinNode
    */
  def joinSpec: Option[UMLValueSpecification[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      joinNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLJoinNode
    *
    * <!-- Start of user code doc for joinNode_metaAttributes -->
    * <!-- End of user code doc for joinNode_metaAttributes -->
    */
  def joinNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     controlNode_metaAttributes,
     Seq[MetaAttributeFunction](JoinNode_isCombineDuplicate))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    joinNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLJoinNode
    *
    * <!-- Start of user code doc for joinNode_compositeMetaProperties -->
    * <!-- End of user code doc for joinNode_compositeMetaProperties -->
    */
  def joinNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      controlNode_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](JoinNode_joinSpec))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    joinNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLJoinNode
    *
    * <!-- Start of user code doc for joinNode_referenceMetaProperties -->
    * <!-- End of user code doc for joinNode_referenceMetaProperties -->
    */
  def joinNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      controlNode_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    joinNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLJoinNode
    *
    * <!-- Start of user code doc for joinNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for joinNode_forwardReferencesFromMetamodelAssociations -->
    */
  def joinNode_forwardReferencesFromMetamodelAssociations: Elements =
    controlNode_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLJoinNode
