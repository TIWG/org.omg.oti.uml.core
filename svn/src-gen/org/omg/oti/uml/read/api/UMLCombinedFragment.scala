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
import org.omg.oti.uml.read.operations.UMLCombinedFragmentOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A CombinedFragment defines an expression of InteractionFragments. A CombinedFragment is defined by an interaction operator and corresponding InteractionOperands. Through the use of CombinedFragments the user will be able to describe a number of traces in a compact and concise manner.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCombinedFragment[Uml <: UML]
  extends UMLInteractionFragment[Uml]
  with UMLCombinedFragmentOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies the operation which defines the semantics of this combination of InteractionFragments.
    *
    * <!-- Start of user code doc for interactionOperator -->
    * <!-- End of user code doc for interactionOperator -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def interactionOperator: Option[UMLInteractionOperatorKind.Value]

  /**
    * The set of operands of the combined fragment.
    *
    * <!-- Start of user code doc for operand -->
    * <!-- End of user code doc for operand -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionOperand.operand_combinedFragment
    */
  def operand: Seq[UMLInteractionOperand[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      combinedFragment_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLCombinedFragment
    *
    * <!-- Start of user code doc for combinedFragment_metaAttributes -->
    * <!-- End of user code doc for combinedFragment_metaAttributes -->
    */
  def combinedFragment_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     interactionFragment_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    combinedFragment_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLCombinedFragment
    *
    * <!-- Start of user code doc for combinedFragment_compositeMetaProperties -->
    * <!-- End of user code doc for combinedFragment_compositeMetaProperties -->
    */
  def combinedFragment_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interactionFragment_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](CombinedFragment_cfragmentGate,
      	CombinedFragment_operand))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    combinedFragment_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLCombinedFragment
    *
    * <!-- Start of user code doc for combinedFragment_referenceMetaProperties -->
    * <!-- End of user code doc for combinedFragment_referenceMetaProperties -->
    */
  def combinedFragment_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interactionFragment_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    combinedFragment_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLCombinedFragment
    *
    * <!-- Start of user code doc for combinedFragment_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for combinedFragment_forwardReferencesFromMetamodelAssociations -->
    */
  def combinedFragment_forwardReferencesFromMetamodelAssociations: Elements =
    interactionFragment_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLCombinedFragment
