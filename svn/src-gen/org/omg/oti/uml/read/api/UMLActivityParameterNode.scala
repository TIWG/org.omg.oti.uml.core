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
import org.omg.oti.uml.read.operations.UMLActivityParameterNodeOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * An ActivityParameterNode is an ObjectNode for accepting values from the input Parameters or providing values to the output Parameters of an Activity.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActivityParameterNode[Uml <: UML]
  extends UMLObjectNode[Uml]
  with UMLActivityParameterNodeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Parameter for which the ActivityParameterNode will be accepting or providing values.
    *
    * <!-- Start of user code doc for parameter -->
    * <!-- End of user code doc for parameter -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLParameter.parameter_activityParameterNode
    */
  def parameter: Option[UMLParameter[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      activityParameterNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLActivityParameterNode
    *
    * <!-- Start of user code doc for activityParameterNode_metaAttributes -->
    * <!-- End of user code doc for activityParameterNode_metaAttributes -->
    */
  def activityParameterNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     objectNode_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    activityParameterNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLActivityParameterNode
    *
    * <!-- Start of user code doc for activityParameterNode_compositeMetaProperties -->
    * <!-- End of user code doc for activityParameterNode_compositeMetaProperties -->
    */
  def activityParameterNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      objectNode_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    activityParameterNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLActivityParameterNode
    *
    * <!-- Start of user code doc for activityParameterNode_referenceMetaProperties -->
    * <!-- End of user code doc for activityParameterNode_referenceMetaProperties -->
    */
  def activityParameterNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      objectNode_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ActivityParameterNode_parameter))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    activityParameterNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLActivityParameterNode
    *
    * <!-- Start of user code doc for activityParameterNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for activityParameterNode_forwardReferencesFromMetamodelAssociations -->
    */
  def activityParameterNode_forwardReferencesFromMetamodelAssociations: Elements =
    objectNode_forwardReferencesFromMetamodelAssociations ++
    parameter

  // Start of user code for additional features
  // End of user code
} //UMLActivityParameterNode
