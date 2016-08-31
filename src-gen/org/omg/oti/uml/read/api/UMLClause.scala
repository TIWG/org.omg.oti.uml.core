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
import org.omg.oti.uml.read.operations.UMLClauseOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Clause is an Element that represents a single branch of a ConditionalNode, including a test and a body section. The body section is executed only if (but not necessarily if) the test section evaluates to true.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLClause[Uml <: UML]
  extends UMLElement[Uml]
  with UMLClauseOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The set of ExecutableNodes that are executed if the test evaluates to true and the Clause is chosen over other Clauses within the ConditionalNode that also have tests that evaluate to true.
    *
    * <!-- Start of user code doc for body -->
    * <!-- End of user code doc for body -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExecutableNode.body_clause
    */
  def body: Set[UMLExecutableNode[Uml]]

  /**
    * The OutputPins on Actions within the body section whose values are moved to the result OutputPins of the containing ConditionalNode after execution of the body.
    *
    * <!-- Start of user code doc for bodyOutput -->
    * <!-- End of user code doc for bodyOutput -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.bodyOutput_clause
    */
  def bodyOutput: Seq[UMLOutputPin[Uml]]

  /**
    * An OutputPin on an Action in the test section whose Boolean value determines the result of the test.
    *
    * <!-- Start of user code doc for decider -->
    * <!-- End of user code doc for decider -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.decider_clause
    */
  def decider: Option[UMLOutputPin[Uml]]

  /**
    * A set of Clauses whose tests must all evaluate to false before this Clause can evaluate its test.
    *
    * <!-- Start of user code doc for predecessorClause -->
    * <!-- End of user code doc for predecessorClause -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClause.successorClause
    */
  def predecessorClause: Set[UMLClause[Uml]]

  /**
    * A set of Clauses that may not evaluate their tests unless the test for this Clause evaluates to false.
    *
    * <!-- Start of user code doc for successorClause -->
    * <!-- End of user code doc for successorClause -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClause.predecessorClause
    */
  def successorClause: Set[UMLClause[Uml]]

  /**
    * The set of ExecutableNodes that are executed in order to provide a test result for the Clause.
    *
    * <!-- Start of user code doc for test -->
    * <!-- End of user code doc for test -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExecutableNode.test_clause
    */
  def test: Set[UMLExecutableNode[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      clause_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLClause
    *
    * <!-- Start of user code doc for clause_metaAttributes -->
    * <!-- End of user code doc for clause_metaAttributes -->
    */
  def clause_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     element_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    clause_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLClause
    *
    * <!-- Start of user code doc for clause_compositeMetaProperties -->
    * <!-- End of user code doc for clause_compositeMetaProperties -->
    */
  def clause_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    clause_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLClause
    *
    * <!-- Start of user code doc for clause_referenceMetaProperties -->
    * <!-- End of user code doc for clause_referenceMetaProperties -->
    */
  def clause_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Clause_body,
      	Clause_bodyOutput,
      	Clause_decider,
      	Clause_predecessorClause,
      	Clause_successorClause,
      	Clause_test))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    clause_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLClause
    *
    * <!-- Start of user code doc for clause_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for clause_forwardReferencesFromMetamodelAssociations -->
    */
  def clause_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    body ++
    bodyOutput ++
    decider ++
    predecessorClause ++
    successorClause ++
    test

  // Start of user code for additional features
  // End of user code
} //UMLClause
