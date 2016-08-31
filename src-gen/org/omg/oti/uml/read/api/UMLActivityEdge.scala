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
import org.omg.oti.uml.read.operations.UMLActivityEdgeOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An ActivityEdge is an abstract class for directed connections between two ActivityNodes.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActivityEdge[Uml <: UML]
  extends UMLRedefinableElement[Uml]
  with UMLActivityEdgeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * A ValueSpecification that is evaluated to determine if a token can traverse the ActivityEdge. If an ActivityEdge has no guard, then there is no restriction on tokens traversing the edge.
    *
    * <!-- Start of user code doc for guard -->
    * <!-- End of user code doc for guard -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.guard_activityEdge
    */
  def guard: Option[UMLValueSpecification[Uml]]

  /**
    * ActivityGroups containing the ActivityEdge.
    *
    * <!-- Start of user code doc for inGroup -->
    * <!-- End of user code doc for inGroup -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityGroup.containedEdge
    */
  def inGroup: Set[UMLActivityGroup[Uml]]

  /**
    * The InterruptibleActivityRegion for which this ActivityEdge is an interruptingEdge.
    *
    * <!-- Start of user code doc for interrupts -->
    * <!-- End of user code doc for interrupts -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterruptibleActivityRegion.interruptingEdge
    */
  def interrupts: Option[UMLInterruptibleActivityRegion[Uml]]

  /**
    * The ActivityNode from which tokens are taken when they traverse the ActivityEdge.
    *
    * <!-- Start of user code doc for source -->
    * <!-- End of user code doc for source -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityNode.outgoing
    */
  def source: Option[UMLActivityNode[Uml]]

  /**
    * The ActivityNode to which tokens are put when they traverse the ActivityEdge.
    *
    * <!-- Start of user code doc for target -->
    * <!-- End of user code doc for target -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityNode.incoming
    */
  def target: Option[UMLActivityNode[Uml]]

  /**
    * The minimum number of tokens that must traverse the ActivityEdge at the same time. If no weight is specified, this is equivalent to specifying a constant value of 1.
    *
    * <!-- Start of user code doc for weight -->
    * <!-- End of user code doc for weight -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.weight_activityEdge
    */
  def weight: Option[UMLValueSpecification[Uml]]

  /**
    * <!-- Start of user code doc for realizingActivityEdge_informationFlow -->
    * <!-- End of user code doc for realizingActivityEdge_informationFlow -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInformationFlow.realizingActivityEdge
    */
  def realizingActivityEdge_informationFlow: Set[UMLInformationFlow[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      activityEdge_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLActivityEdge
    *
    * <!-- Start of user code doc for activityEdge_metaAttributes -->
    * <!-- End of user code doc for activityEdge_metaAttributes -->
    */
  def activityEdge_metaAttributes: MetaAttributeFunctions = 
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
    activityEdge_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLActivityEdge
    *
    * <!-- Start of user code doc for activityEdge_compositeMetaProperties -->
    * <!-- End of user code doc for activityEdge_compositeMetaProperties -->
    */
  def activityEdge_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      redefinableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ActivityEdge_guard,
      	ActivityEdge_weight))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    activityEdge_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLActivityEdge
    *
    * <!-- Start of user code doc for activityEdge_referenceMetaProperties -->
    * <!-- End of user code doc for activityEdge_referenceMetaProperties -->
    */
  def activityEdge_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      redefinableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ActivityEdge_inPartition,
      	ActivityEdge_interrupts,
      	ActivityEdge_redefinedEdge,
      	ActivityEdge_source,
      	ActivityEdge_target))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    activityEdge_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLActivityEdge
    *
    * <!-- Start of user code doc for activityEdge_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for activityEdge_forwardReferencesFromMetamodelAssociations -->
    */
  def activityEdge_forwardReferencesFromMetamodelAssociations: Elements =
    redefinableElement_forwardReferencesFromMetamodelAssociations ++
    inPartition ++
    interrupts ++
    redefinedEdge ++
    source ++
    target

  // Start of user code for additional features
  // End of user code
} //UMLActivityEdge
