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
import org.omg.oti.uml.read.operations.UMLValueSpecificationActionOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ValueSpecificationAction is an Action that evaluates a ValueSpecification and provides a result.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLValueSpecificationAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLValueSpecificationActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The ValueSpecification to be evaluated.
    *
    * <!-- Start of user code doc for value -->
    * <!-- End of user code doc for value -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.value_valueSpecificationAction
    */
  def value: Option[UMLValueSpecification[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      valueSpecificationAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLValueSpecificationAction
    *
    * <!-- Start of user code doc for valueSpecificationAction_metaAttributes -->
    * <!-- End of user code doc for valueSpecificationAction_metaAttributes -->
    */
  def valueSpecificationAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    valueSpecificationAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLValueSpecificationAction
    *
    * <!-- Start of user code doc for valueSpecificationAction_compositeMetaProperties -->
    * <!-- End of user code doc for valueSpecificationAction_compositeMetaProperties -->
    */
  def valueSpecificationAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ValueSpecificationAction_result,
      	ValueSpecificationAction_value))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    valueSpecificationAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLValueSpecificationAction
    *
    * <!-- Start of user code doc for valueSpecificationAction_referenceMetaProperties -->
    * <!-- End of user code doc for valueSpecificationAction_referenceMetaProperties -->
    */
  def valueSpecificationAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    valueSpecificationAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLValueSpecificationAction
    *
    * <!-- Start of user code doc for valueSpecificationAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for valueSpecificationAction_forwardReferencesFromMetamodelAssociations -->
    */
  def valueSpecificationAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLValueSpecificationAction
