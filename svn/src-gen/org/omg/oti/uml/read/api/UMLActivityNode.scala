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
import org.omg.oti.uml.read.operations.UMLActivityNodeOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * ActivityNode is an abstract class for points in the flow of an Activity connected by ActivityEdges.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActivityNode[Uml <: UML]
  extends UMLRedefinableElement[Uml]
  with UMLActivityNodeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * ActivityGroups containing the ActivityNode.
    *
    * <!-- Start of user code doc for inGroup -->
    * <!-- End of user code doc for inGroup -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityGroup.containedNode
    */
  def inGroup: Set[UMLActivityGroup[Uml]]

  /**
    * ActivityEdges that have the ActivityNode as their target.
    *
    * <!-- Start of user code doc for incoming -->
    * <!-- End of user code doc for incoming -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityEdge.target
    */
  def incoming: Set[UMLActivityEdge[Uml]]

  /**
    * ActivityEdges that have the ActivityNode as their source.
    *
    * <!-- Start of user code doc for outgoing -->
    * <!-- End of user code doc for outgoing -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityEdge.source
    */
  def outgoing: Set[UMLActivityEdge[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      activityNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLActivityNode
    *
    * <!-- Start of user code doc for activityNode_metaAttributes -->
    * <!-- End of user code doc for activityNode_metaAttributes -->
    */
  def activityNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     redefinableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    activityNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLActivityNode
    *
    * <!-- Start of user code doc for activityNode_compositeMetaProperties -->
    * <!-- End of user code doc for activityNode_compositeMetaProperties -->
    */
  def activityNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      redefinableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    activityNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLActivityNode
    *
    * <!-- Start of user code doc for activityNode_referenceMetaProperties -->
    * <!-- End of user code doc for activityNode_referenceMetaProperties -->
    */
  def activityNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      redefinableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ActivityNode_inInterruptibleRegion,
      	ActivityNode_inPartition,
      	ActivityNode_incoming,
      	ActivityNode_outgoing,
      	ActivityNode_redefinedNode))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    activityNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLActivityNode
    *
    * <!-- Start of user code doc for activityNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for activityNode_forwardReferencesFromMetamodelAssociations -->
    */
  def activityNode_forwardReferencesFromMetamodelAssociations: Elements =
    redefinableElement_forwardReferencesFromMetamodelAssociations ++
    inInterruptibleRegion ++
    inPartition ++
    incoming ++
    outgoing ++
    redefinedNode

  // Start of user code for additional features
  // End of user code
} //UMLActivityNode
