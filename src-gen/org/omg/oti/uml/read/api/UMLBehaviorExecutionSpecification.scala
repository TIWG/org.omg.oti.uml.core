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
import org.omg.oti.uml.read.operations.UMLBehaviorExecutionSpecificationOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A BehaviorExecutionSpecification is a kind of ExecutionSpecification representing the execution of a Behavior.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLBehaviorExecutionSpecification[Uml <: UML]
  extends UMLExecutionSpecification[Uml]
  with UMLBehaviorExecutionSpecificationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Behavior whose execution is occurring.
    *
    * <!-- Start of user code doc for behavior -->
    * <!-- End of user code doc for behavior -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.behavior_behaviorExecutionSpecification
    */
  def behavior: Option[UMLBehavior[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      behaviorExecutionSpecification_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLBehaviorExecutionSpecification
    *
    * <!-- Start of user code doc for behaviorExecutionSpecification_metaAttributes -->
    * <!-- End of user code doc for behaviorExecutionSpecification_metaAttributes -->
    */
  def behaviorExecutionSpecification_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     executionSpecification_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    behaviorExecutionSpecification_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLBehaviorExecutionSpecification
    *
    * <!-- Start of user code doc for behaviorExecutionSpecification_compositeMetaProperties -->
    * <!-- End of user code doc for behaviorExecutionSpecification_compositeMetaProperties -->
    */
  def behaviorExecutionSpecification_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      executionSpecification_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    behaviorExecutionSpecification_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLBehaviorExecutionSpecification
    *
    * <!-- Start of user code doc for behaviorExecutionSpecification_referenceMetaProperties -->
    * <!-- End of user code doc for behaviorExecutionSpecification_referenceMetaProperties -->
    */
  def behaviorExecutionSpecification_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      executionSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](BehaviorExecutionSpecification_behavior))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    behaviorExecutionSpecification_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLBehaviorExecutionSpecification
    *
    * <!-- Start of user code doc for behaviorExecutionSpecification_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for behaviorExecutionSpecification_forwardReferencesFromMetamodelAssociations -->
    */
  def behaviorExecutionSpecification_forwardReferencesFromMetamodelAssociations: Elements =
    executionSpecification_forwardReferencesFromMetamodelAssociations ++
    behavior

  // Start of user code for additional features
  // End of user code
} //UMLBehaviorExecutionSpecification
