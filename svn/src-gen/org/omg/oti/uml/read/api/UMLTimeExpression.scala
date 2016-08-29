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
import org.omg.oti.uml.read.operations.UMLTimeExpressionOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A TimeExpression is a ValueSpecification that represents a time value.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTimeExpression[Uml <: UML]
  extends UMLValueSpecification[Uml]
  with UMLTimeExpressionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * A ValueSpecification that evaluates to the value of the TimeExpression.
    *
    * <!-- Start of user code doc for expr -->
    * <!-- End of user code doc for expr -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.expr_timeExpression
    */
  def expr: Option[UMLValueSpecification[Uml]]

  /**
    * Refers to the Observations that are involved in the computation of the TimeExpression value.
    *
    * <!-- Start of user code doc for observation -->
    * <!-- End of user code doc for observation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLObservation.observation_timeExpression
    */
  def observation: Set[UMLObservation[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      timeExpression_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLTimeExpression
    *
    * <!-- Start of user code doc for timeExpression_metaAttributes -->
    * <!-- End of user code doc for timeExpression_metaAttributes -->
    */
  def timeExpression_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     valueSpecification_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    timeExpression_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLTimeExpression
    *
    * <!-- Start of user code doc for timeExpression_compositeMetaProperties -->
    * <!-- End of user code doc for timeExpression_compositeMetaProperties -->
    */
  def timeExpression_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      valueSpecification_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](TimeExpression_expr))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    timeExpression_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLTimeExpression
    *
    * <!-- Start of user code doc for timeExpression_referenceMetaProperties -->
    * <!-- End of user code doc for timeExpression_referenceMetaProperties -->
    */
  def timeExpression_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      valueSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](TimeExpression_observation))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    timeExpression_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLTimeExpression
    *
    * <!-- Start of user code doc for timeExpression_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for timeExpression_forwardReferencesFromMetamodelAssociations -->
    */
  def timeExpression_forwardReferencesFromMetamodelAssociations: Elements =
    valueSpecification_forwardReferencesFromMetamodelAssociations ++
    observation

  // Start of user code for additional features
  // End of user code
} //UMLTimeExpression
