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
import org.omg.oti.uml.read.operations.UMLStringExpressionOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A StringExpression is an Expression that specifies a String value that is derived by concatenating a sequence of operands with String values or a sequence of subExpressions, some of which might be template parameters.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStringExpression[Uml <: UML]
  extends UMLExpression[Uml]
	with UMLTemplateableElement[Uml]
  with UMLStringExpressionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The StringExpressions that constitute this StringExpression.
    *
    * <!-- Start of user code doc for subExpression -->
    * <!-- End of user code doc for subExpression -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStringExpression.owningExpression
    */
  def subExpression: Seq[UMLStringExpression[Uml]]

  /**
    * <!-- Start of user code doc for nameExpression_namedElement -->
    * <!-- End of user code doc for nameExpression_namedElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamedElement.nameExpression
    */
  def nameExpression_namedElement: Option[UMLNamedElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      stringExpression_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLStringExpression
    *
    * <!-- Start of user code doc for stringExpression_metaAttributes -->
    * <!-- End of user code doc for stringExpression_metaAttributes -->
    */
  def stringExpression_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     expression_metaAttributes,
     templateableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    stringExpression_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLStringExpression
    *
    * <!-- Start of user code doc for stringExpression_compositeMetaProperties -->
    * <!-- End of user code doc for stringExpression_compositeMetaProperties -->
    */
  def stringExpression_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      expression_compositeMetaProperties,
      templateableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](StringExpression_subExpression))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    stringExpression_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLStringExpression
    *
    * <!-- Start of user code doc for stringExpression_referenceMetaProperties -->
    * <!-- End of user code doc for stringExpression_referenceMetaProperties -->
    */
  def stringExpression_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      expression_referenceMetaProperties,
      templateableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    stringExpression_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLStringExpression
    *
    * <!-- Start of user code doc for stringExpression_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for stringExpression_forwardReferencesFromMetamodelAssociations -->
    */
  def stringExpression_forwardReferencesFromMetamodelAssociations: Elements =
    expression_forwardReferencesFromMetamodelAssociations ++
    templateableElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLStringExpression
