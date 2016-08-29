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
import org.omg.oti.uml.read.operations.UMLOccurrenceSpecificationOps

import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An OccurrenceSpecification is the basic semantic unit of Interactions. The sequences of occurrences specified by them are the meanings of Interactions.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLOccurrenceSpecification[Uml <: UML]
  extends UMLInteractionFragment[Uml]
  with UMLOccurrenceSpecificationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * References the Lifeline on which the OccurrenceSpecification appears.
    *
    * <!-- Start of user code doc for covered -->
    * <!-- End of user code doc for covered -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLifeline.covered_events
    */
  override def covered: Iterable[UMLLifeline[Uml]]

  /**
    * References the GeneralOrderings that specify EventOcurrences that must occur after this OccurrenceSpecification.
    *
    * <!-- Start of user code doc for toAfter -->
    * <!-- End of user code doc for toAfter -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLGeneralOrdering.before
    */
  def toAfter: Set[UMLGeneralOrdering[Uml]]

  /**
    * References the GeneralOrderings that specify EventOcurrences that must occur before this OccurrenceSpecification.
    *
    * <!-- Start of user code doc for toBefore -->
    * <!-- End of user code doc for toBefore -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLGeneralOrdering.after
    */
  def toBefore: Set[UMLGeneralOrdering[Uml]]

  /**
    * <!-- Start of user code doc for finish_executionSpecification -->
    * <!-- End of user code doc for finish_executionSpecification -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExecutionSpecification.finish
    */
  def finish_executionSpecification: Set[UMLExecutionSpecification[Uml]]

  /**
    * <!-- Start of user code doc for start_executionSpecification -->
    * <!-- End of user code doc for start_executionSpecification -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExecutionSpecification.start
    */
  def start_executionSpecification: Set[UMLExecutionSpecification[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      occurrenceSpecification_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLOccurrenceSpecification
    *
    * <!-- Start of user code doc for occurrenceSpecification_metaAttributes -->
    * <!-- End of user code doc for occurrenceSpecification_metaAttributes -->
    */
  def occurrenceSpecification_metaAttributes: MetaAttributeFunctions = 
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
    occurrenceSpecification_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLOccurrenceSpecification
    *
    * <!-- Start of user code doc for occurrenceSpecification_compositeMetaProperties -->
    * <!-- End of user code doc for occurrenceSpecification_compositeMetaProperties -->
    */
  def occurrenceSpecification_compositeMetaProperties: MetaPropertyFunctions = 
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
    occurrenceSpecification_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLOccurrenceSpecification
    *
    * <!-- Start of user code doc for occurrenceSpecification_referenceMetaProperties -->
    * <!-- End of user code doc for occurrenceSpecification_referenceMetaProperties -->
    */
  def occurrenceSpecification_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interactionFragment_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](OccurrenceSpecification_covered,
      	OccurrenceSpecification_toAfter,
      	OccurrenceSpecification_toBefore))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    occurrenceSpecification_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLOccurrenceSpecification
    *
    * <!-- Start of user code doc for occurrenceSpecification_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for occurrenceSpecification_forwardReferencesFromMetamodelAssociations -->
    */
  def occurrenceSpecification_forwardReferencesFromMetamodelAssociations: Elements =
    interactionFragment_forwardReferencesFromMetamodelAssociations ++
    covered ++
    toAfter ++
    toBefore

  // Start of user code for additional features
  // End of user code
} //UMLOccurrenceSpecification
