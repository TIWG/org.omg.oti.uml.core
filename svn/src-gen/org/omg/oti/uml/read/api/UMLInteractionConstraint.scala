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
import org.omg.oti.uml.read.operations.UMLInteractionConstraintOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An InteractionConstraint is a Boolean expression that guards an operand in a CombinedFragment.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInteractionConstraint[Uml <: UML]
  extends UMLConstraint[Uml]
  with UMLInteractionConstraintOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The maximum number of iterations of a loop
    *
    * <!-- Start of user code doc for maxint -->
    * <!-- End of user code doc for maxint -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.maxint_interactionConstraint
    */
  def maxint: Option[UMLValueSpecification[Uml]]

  /**
    * The minimum number of iterations of a loop
    *
    * <!-- Start of user code doc for minint -->
    * <!-- End of user code doc for minint -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.minint_interactionConstraint
    */
  def minint: Option[UMLValueSpecification[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      interactionConstraint_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInteractionConstraint
    *
    * <!-- Start of user code doc for interactionConstraint_metaAttributes -->
    * <!-- End of user code doc for interactionConstraint_metaAttributes -->
    */
  def interactionConstraint_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     constraint_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    interactionConstraint_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInteractionConstraint
    *
    * <!-- Start of user code doc for interactionConstraint_compositeMetaProperties -->
    * <!-- End of user code doc for interactionConstraint_compositeMetaProperties -->
    */
  def interactionConstraint_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      constraint_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](InteractionConstraint_maxint,
      	InteractionConstraint_minint))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    interactionConstraint_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInteractionConstraint
    *
    * <!-- Start of user code doc for interactionConstraint_referenceMetaProperties -->
    * <!-- End of user code doc for interactionConstraint_referenceMetaProperties -->
    */
  def interactionConstraint_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      constraint_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    interactionConstraint_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInteractionConstraint
    *
    * <!-- Start of user code doc for interactionConstraint_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for interactionConstraint_forwardReferencesFromMetamodelAssociations -->
    */
  def interactionConstraint_forwardReferencesFromMetamodelAssociations: Elements =
    constraint_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLInteractionConstraint
