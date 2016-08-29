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
import org.omg.oti.uml.read.operations.UMLReduceActionOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A ReduceAction is an Action that reduces a collection to a single value by repeatedly combining the elements of the collection using a reducer Behavior.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReduceAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLReduceActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Indicates whether the order of the input collection should determine the order in which the reducer Behavior is applied to its elements.
    *
    * <!-- Start of user code doc for isOrdered -->
    * <!-- End of user code doc for isOrdered -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isOrdered: Boolean

  /**
    * A Behavior that is repreatedly applied to two elements of the input collection to produce a value that is of the same type as elements of the collection.
    *
    * <!-- Start of user code doc for reducer -->
    * <!-- End of user code doc for reducer -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.reducer_reduceAction
    */
  def reducer: Option[UMLBehavior[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      reduceAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLReduceAction
    *
    * <!-- Start of user code doc for reduceAction_metaAttributes -->
    * <!-- End of user code doc for reduceAction_metaAttributes -->
    */
  def reduceAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     Seq[MetaAttributeFunction](ReduceAction_isOrdered))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    reduceAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLReduceAction
    *
    * <!-- Start of user code doc for reduceAction_compositeMetaProperties -->
    * <!-- End of user code doc for reduceAction_compositeMetaProperties -->
    */
  def reduceAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ReduceAction_collection,
      	ReduceAction_result))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    reduceAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLReduceAction
    *
    * <!-- Start of user code doc for reduceAction_referenceMetaProperties -->
    * <!-- End of user code doc for reduceAction_referenceMetaProperties -->
    */
  def reduceAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ReduceAction_reducer))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    reduceAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLReduceAction
    *
    * <!-- Start of user code doc for reduceAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for reduceAction_forwardReferencesFromMetamodelAssociations -->
    */
  def reduceAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    reducer

  // Start of user code for additional features
  // End of user code
} //UMLReduceAction
