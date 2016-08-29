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
import org.omg.oti.uml.read.operations.UMLExpressionOps

import scala.Option
import scala.Predef.String
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An Expression represents a node in an expression tree, which may be non-terminal or terminal. It defines a symbol, and has a possibly empty sequence of operands that are ValueSpecifications. It denotes a (possibly empty) set of values when evaluated in a context.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExpression[Uml <: UML]
  extends UMLValueSpecification[Uml]
  with UMLExpressionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies a sequence of operand ValueSpecifications.
    *
    * <!-- Start of user code doc for operand -->
    * <!-- End of user code doc for operand -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.operand_expression
    */
  def operand: Seq[UMLValueSpecification[Uml]]

  /**
    * The symbol associated with this node in the expression tree.
    *
    * <!-- Start of user code doc for symbol -->
    * <!-- End of user code doc for symbol -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def symbol: Option[String]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      expression_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLExpression
    *
    * <!-- Start of user code doc for expression_metaAttributes -->
    * <!-- End of user code doc for expression_metaAttributes -->
    */
  def expression_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     valueSpecification_metaAttributes,
     Seq[MetaAttributeFunction](Expression_symbol))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    expression_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLExpression
    *
    * <!-- Start of user code doc for expression_compositeMetaProperties -->
    * <!-- End of user code doc for expression_compositeMetaProperties -->
    */
  def expression_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      valueSpecification_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Expression_operand))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    expression_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLExpression
    *
    * <!-- Start of user code doc for expression_referenceMetaProperties -->
    * <!-- End of user code doc for expression_referenceMetaProperties -->
    */
  def expression_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      valueSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    expression_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLExpression
    *
    * <!-- Start of user code doc for expression_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for expression_forwardReferencesFromMetamodelAssociations -->
    */
  def expression_forwardReferencesFromMetamodelAssociations: Elements =
    valueSpecification_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLExpression
