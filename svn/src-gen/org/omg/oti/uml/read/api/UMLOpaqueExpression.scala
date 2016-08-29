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
import org.omg.oti.uml.read.operations.UMLOpaqueExpressionOps

import scala.Option
import scala.Predef.String
import scala.collection.immutable.Seq
// End of user code


/**
  * An OpaqueExpression is a ValueSpecification that specifies the computation of a collection of values either in terms of a UML Behavior or based on a textual statement in a language other than UML
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLOpaqueExpression[Uml <: UML]
  extends UMLValueSpecification[Uml]
  with UMLOpaqueExpressionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies the behavior of the OpaqueExpression as a UML Behavior.
    *
    * <!-- Start of user code doc for behavior -->
    * <!-- End of user code doc for behavior -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.behavior_opaqueExpression
    */
  def behavior: Option[UMLBehavior[Uml]]

  /**
    * A textual definition of the behavior of the OpaqueExpression, possibly in multiple languages.
    *
    * <!-- Start of user code doc for body -->
    * <!-- End of user code doc for body -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    */
  def body: Seq[String]

  /**
    * Specifies the languages used to express the textual bodies of the OpaqueExpression.  Languages are matched to body Strings by order. The interpretation of the body depends on the languages. If the languages are unspecified, they may be implicit from the expression body or the context.
    *
    * <!-- Start of user code doc for language -->
    * <!-- End of user code doc for language -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    */
  def language: Seq[String]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      opaqueExpression_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLOpaqueExpression
    *
    * <!-- Start of user code doc for opaqueExpression_metaAttributes -->
    * <!-- End of user code doc for opaqueExpression_metaAttributes -->
    */
  def opaqueExpression_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     valueSpecification_metaAttributes,
     Seq[MetaAttributeFunction](OpaqueExpression_body,
     	OpaqueExpression_language))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    opaqueExpression_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLOpaqueExpression
    *
    * <!-- Start of user code doc for opaqueExpression_compositeMetaProperties -->
    * <!-- End of user code doc for opaqueExpression_compositeMetaProperties -->
    */
  def opaqueExpression_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      valueSpecification_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    opaqueExpression_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLOpaqueExpression
    *
    * <!-- Start of user code doc for opaqueExpression_referenceMetaProperties -->
    * <!-- End of user code doc for opaqueExpression_referenceMetaProperties -->
    */
  def opaqueExpression_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      valueSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](OpaqueExpression_behavior))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    opaqueExpression_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLOpaqueExpression
    *
    * <!-- Start of user code doc for opaqueExpression_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for opaqueExpression_forwardReferencesFromMetamodelAssociations -->
    */
  def opaqueExpression_forwardReferencesFromMetamodelAssociations: Elements =
    valueSpecification_forwardReferencesFromMetamodelAssociations ++
    behavior

  // Start of user code for additional features
  // End of user code
} //UMLOpaqueExpression
