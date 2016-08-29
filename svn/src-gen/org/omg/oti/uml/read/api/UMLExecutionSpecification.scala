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
import org.omg.oti.uml.read.operations.UMLExecutionSpecificationOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An ExecutionSpecification is a specification of the execution of a unit of Behavior or Action within the Lifeline. The duration of an ExecutionSpecification is represented by two OccurrenceSpecifications, the start OccurrenceSpecification and the finish OccurrenceSpecification.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExecutionSpecification[Uml <: UML]
  extends UMLInteractionFragment[Uml]
  with UMLExecutionSpecificationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * References the OccurrenceSpecification that designates the finish of the Action or Behavior.
    *
    * <!-- Start of user code doc for finish -->
    * <!-- End of user code doc for finish -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOccurrenceSpecification.finish_executionSpecification
    */
  def finish: Option[UMLOccurrenceSpecification[Uml]]

  /**
    * References the OccurrenceSpecification that designates the start of the Action or Behavior.
    *
    * <!-- Start of user code doc for start -->
    * <!-- End of user code doc for start -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOccurrenceSpecification.start_executionSpecification
    */
  def start: Option[UMLOccurrenceSpecification[Uml]]

  /**
    * <!-- Start of user code doc for execution_executionOccurrenceSpecification -->
    * <!-- End of user code doc for execution_executionOccurrenceSpecification -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..2"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExecutionOccurrenceSpecification.execution
    */
  def execution_executionOccurrenceSpecification: Set[UMLExecutionOccurrenceSpecification[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      executionSpecification_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLExecutionSpecification
    *
    * <!-- Start of user code doc for executionSpecification_metaAttributes -->
    * <!-- End of user code doc for executionSpecification_metaAttributes -->
    */
  def executionSpecification_metaAttributes: MetaAttributeFunctions = 
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
    executionSpecification_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLExecutionSpecification
    *
    * <!-- Start of user code doc for executionSpecification_compositeMetaProperties -->
    * <!-- End of user code doc for executionSpecification_compositeMetaProperties -->
    */
  def executionSpecification_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interactionFragment_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    executionSpecification_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLExecutionSpecification
    *
    * <!-- Start of user code doc for executionSpecification_referenceMetaProperties -->
    * <!-- End of user code doc for executionSpecification_referenceMetaProperties -->
    */
  def executionSpecification_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interactionFragment_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ExecutionSpecification_finish,
      	ExecutionSpecification_start))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    executionSpecification_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLExecutionSpecification
    *
    * <!-- Start of user code doc for executionSpecification_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for executionSpecification_forwardReferencesFromMetamodelAssociations -->
    */
  def executionSpecification_forwardReferencesFromMetamodelAssociations: Elements =
    interactionFragment_forwardReferencesFromMetamodelAssociations ++
    finish ++
    start

  // Start of user code for additional features
  // End of user code
} //UMLExecutionSpecification
