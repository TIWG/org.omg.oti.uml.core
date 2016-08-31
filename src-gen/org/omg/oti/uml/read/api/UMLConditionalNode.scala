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
import org.omg.oti.uml.read.operations.UMLConditionalNodeOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ConditionalNode is a StructuredActivityNode that chooses one among some number of alternative collections of ExecutableNodes to execute.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConditionalNode[Uml <: UML]
  extends UMLStructuredActivityNode[Uml]
  with UMLConditionalNodeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * If true, the modeler asserts that the test for at least one Clause of the ConditionalNode will succeed.
    *
    * <!-- Start of user code doc for isAssured -->
    * <!-- End of user code doc for isAssured -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isAssured: Boolean

  /**
    * If true, the modeler asserts that the test for at most one Clause of the ConditionalNode will succeed.
    *
    * <!-- Start of user code doc for isDeterminate -->
    * <!-- End of user code doc for isDeterminate -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isDeterminate: Boolean

  /**
    * The OutputPins that onto which are moved values from the bodyOutputs of the Clause selected for execution.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_conditionalNode
    */
  def result: Seq[UMLOutputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      conditionalNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLConditionalNode
    *
    * <!-- Start of user code doc for conditionalNode_metaAttributes -->
    * <!-- End of user code doc for conditionalNode_metaAttributes -->
    */
  def conditionalNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     structuredActivityNode_metaAttributes,
     Seq[MetaAttributeFunction](ConditionalNode_isAssured,
     	ConditionalNode_isDeterminate))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    conditionalNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLConditionalNode
    *
    * <!-- Start of user code doc for conditionalNode_compositeMetaProperties -->
    * <!-- End of user code doc for conditionalNode_compositeMetaProperties -->
    */
  def conditionalNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      structuredActivityNode_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ConditionalNode_clause,
      	ConditionalNode_result))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    conditionalNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLConditionalNode
    *
    * <!-- Start of user code doc for conditionalNode_referenceMetaProperties -->
    * <!-- End of user code doc for conditionalNode_referenceMetaProperties -->
    */
  def conditionalNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      structuredActivityNode_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    conditionalNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLConditionalNode
    *
    * <!-- Start of user code doc for conditionalNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for conditionalNode_forwardReferencesFromMetamodelAssociations -->
    */
  def conditionalNode_forwardReferencesFromMetamodelAssociations: Elements =
    structuredActivityNode_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLConditionalNode
