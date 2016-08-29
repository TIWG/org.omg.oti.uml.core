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
import org.omg.oti.uml.read.operations.UMLValueSpecificationOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ValueSpecification is the specification of a (possibly empty) set of values. A ValueSpecification is a ParameterableElement that may be exposed as a formal TemplateParameter and provided as the actual parameter in the binding of a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLValueSpecification[Uml <: UML]
  extends UMLPackageableElement[Uml]
	with UMLTypedElement[Uml]
  with UMLValueSpecificationOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * <!-- Start of user code doc for argument_interactionUse -->
    * <!-- End of user code doc for argument_interactionUse -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionUse.argument
    */
  def argument_interactionUse: Option[UMLInteractionUse[Uml]]

  /**
    * <!-- Start of user code doc for guard_activityEdge -->
    * <!-- End of user code doc for guard_activityEdge -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityEdge.guard
    */
  def guard_activityEdge: Option[UMLActivityEdge[Uml]]

  /**
    * <!-- Start of user code doc for lowerValue_owningLower -->
    * <!-- End of user code doc for lowerValue_owningLower -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLMultiplicityElement.lowerValue
    */
  def lowerValue_owningLower: Option[UMLMultiplicityElement[Uml]]

  /**
    * <!-- Start of user code doc for max_interval -->
    * <!-- End of user code doc for max_interval -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterval.max
    */
  def max_interval: Set[UMLInterval[Uml]]

  /**
    * <!-- Start of user code doc for maxint_interactionConstraint -->
    * <!-- End of user code doc for maxint_interactionConstraint -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionConstraint.maxint
    */
  def maxint_interactionConstraint: Option[UMLInteractionConstraint[Uml]]

  /**
    * <!-- Start of user code doc for min_interval -->
    * <!-- End of user code doc for min_interval -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterval.min
    */
  def min_interval: Set[UMLInterval[Uml]]

  /**
    * <!-- Start of user code doc for minint_interactionConstraint -->
    * <!-- End of user code doc for minint_interactionConstraint -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionConstraint.minint
    */
  def minint_interactionConstraint: Option[UMLInteractionConstraint[Uml]]

  /**
    * <!-- Start of user code doc for returnValue_interactionUse -->
    * <!-- End of user code doc for returnValue_interactionUse -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionUse.returnValue
    */
  def returnValue_interactionUse: Option[UMLInteractionUse[Uml]]

  /**
    * <!-- Start of user code doc for specification_owningConstraint -->
    * <!-- End of user code doc for specification_owningConstraint -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.specification
    */
  def specification_owningConstraint: Option[UMLConstraint[Uml]]

  /**
    * <!-- Start of user code doc for upperBound_objectNode -->
    * <!-- End of user code doc for upperBound_objectNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLObjectNode.upperBound
    */
  def upperBound_objectNode: Option[UMLObjectNode[Uml]]

  /**
    * <!-- Start of user code doc for upperValue_owningUpper -->
    * <!-- End of user code doc for upperValue_owningUpper -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLMultiplicityElement.upperValue
    */
  def upperValue_owningUpper: Option[UMLMultiplicityElement[Uml]]

  /**
    * <!-- Start of user code doc for weight_activityEdge -->
    * <!-- End of user code doc for weight_activityEdge -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityEdge.weight
    */
  def weight_activityEdge: Option[UMLActivityEdge[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      valueSpecification_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLValueSpecification
    *
    * <!-- Start of user code doc for valueSpecification_metaAttributes -->
    * <!-- End of user code doc for valueSpecification_metaAttributes -->
    */
  def valueSpecification_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     packageableElement_metaAttributes,
     typedElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    valueSpecification_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLValueSpecification
    *
    * <!-- Start of user code doc for valueSpecification_compositeMetaProperties -->
    * <!-- End of user code doc for valueSpecification_compositeMetaProperties -->
    */
  def valueSpecification_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      packageableElement_compositeMetaProperties,
      typedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    valueSpecification_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLValueSpecification
    *
    * <!-- Start of user code doc for valueSpecification_referenceMetaProperties -->
    * <!-- End of user code doc for valueSpecification_referenceMetaProperties -->
    */
  def valueSpecification_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      packageableElement_referenceMetaProperties,
      typedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    valueSpecification_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLValueSpecification
    *
    * <!-- Start of user code doc for valueSpecification_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for valueSpecification_forwardReferencesFromMetamodelAssociations -->
    */
  def valueSpecification_forwardReferencesFromMetamodelAssociations: Elements =
    packageableElement_forwardReferencesFromMetamodelAssociations ++
    typedElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLValueSpecification
