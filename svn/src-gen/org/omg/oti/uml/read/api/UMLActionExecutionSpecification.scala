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
import org.omg.oti.uml.read.operations.UMLActionExecutionSpecificationOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * An ActionExecutionSpecification is a kind of ExecutionSpecification representing the execution of an Action.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActionExecutionSpecification[Uml <: UML]
  extends UMLExecutionSpecification[Uml]
  with UMLActionExecutionSpecificationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Action whose execution is occurring.
    *
    * <!-- Start of user code doc for action -->
    * <!-- End of user code doc for action -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAction.action_actionExecutionSpecification
    */
  def action: Option[UMLAction[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      actionExecutionSpecification_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLActionExecutionSpecification
    *
    * <!-- Start of user code doc for actionExecutionSpecification_metaAttributes -->
    * <!-- End of user code doc for actionExecutionSpecification_metaAttributes -->
    */
  def actionExecutionSpecification_metaAttributes: MetaAttributeFunctions = 
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
    actionExecutionSpecification_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLActionExecutionSpecification
    *
    * <!-- Start of user code doc for actionExecutionSpecification_compositeMetaProperties -->
    * <!-- End of user code doc for actionExecutionSpecification_compositeMetaProperties -->
    */
  def actionExecutionSpecification_compositeMetaProperties: MetaPropertyFunctions = 
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
    actionExecutionSpecification_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLActionExecutionSpecification
    *
    * <!-- Start of user code doc for actionExecutionSpecification_referenceMetaProperties -->
    * <!-- End of user code doc for actionExecutionSpecification_referenceMetaProperties -->
    */
  def actionExecutionSpecification_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      executionSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ActionExecutionSpecification_action))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    actionExecutionSpecification_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLActionExecutionSpecification
    *
    * <!-- Start of user code doc for actionExecutionSpecification_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for actionExecutionSpecification_forwardReferencesFromMetamodelAssociations -->
    */
  def actionExecutionSpecification_forwardReferencesFromMetamodelAssociations: Elements =
    executionSpecification_forwardReferencesFromMetamodelAssociations ++
    action

  // Start of user code for additional features
  // End of user code
} //UMLActionExecutionSpecification
