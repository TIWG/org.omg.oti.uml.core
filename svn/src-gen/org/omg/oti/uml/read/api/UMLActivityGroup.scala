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
import org.omg.oti.uml.read.operations.UMLActivityGroupOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * ActivityGroup is an abstract class for defining sets of ActivityNodes and ActivityEdges in an Activity.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActivityGroup[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLActivityGroupOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * ActivityEdges immediately contained in the ActivityGroup.
    *
    * <!-- Start of user code doc for containedEdge -->
    * <!-- End of user code doc for containedEdge -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityEdge.inGroup
    */
  def containedEdge: Set[UMLActivityEdge[Uml]]

  /**
    * ActivityNodes immediately contained in the ActivityGroup.
    *
    * <!-- Start of user code doc for containedNode -->
    * <!-- End of user code doc for containedNode -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityNode.inGroup
    */
  def containedNode: Set[UMLActivityNode[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      activityGroup_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLActivityGroup
    *
    * <!-- Start of user code doc for activityGroup_metaAttributes -->
    * <!-- End of user code doc for activityGroup_metaAttributes -->
    */
  def activityGroup_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namedElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    activityGroup_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLActivityGroup
    *
    * <!-- Start of user code doc for activityGroup_compositeMetaProperties -->
    * <!-- End of user code doc for activityGroup_compositeMetaProperties -->
    */
  def activityGroup_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    activityGroup_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLActivityGroup
    *
    * <!-- Start of user code doc for activityGroup_referenceMetaProperties -->
    * <!-- End of user code doc for activityGroup_referenceMetaProperties -->
    */
  def activityGroup_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    activityGroup_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLActivityGroup
    *
    * <!-- Start of user code doc for activityGroup_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for activityGroup_forwardReferencesFromMetamodelAssociations -->
    */
  def activityGroup_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLActivityGroup
