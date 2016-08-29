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
import org.omg.oti.uml.read.operations.UMLTimeConstraintOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A TimeConstraint is a Constraint that refers to a TimeInterval.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTimeConstraint[Uml <: UML]
  extends UMLIntervalConstraint[Uml]
  with UMLTimeConstraintOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The value of firstEvent is related to the constrainedElement. If firstEvent is true, then the corresponding observation event is the first time instant the execution enters the constrainedElement. If firstEvent is false, then the corresponding observation event is the last time instant the execution is within the constrainedElement.
    *
    * <!-- Start of user code doc for firstEvent -->
    * <!-- End of user code doc for firstEvent -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def firstEvent: Option[Boolean]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      timeConstraint_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLTimeConstraint
    *
    * <!-- Start of user code doc for timeConstraint_metaAttributes -->
    * <!-- End of user code doc for timeConstraint_metaAttributes -->
    */
  def timeConstraint_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     intervalConstraint_metaAttributes,
     Seq[MetaAttributeFunction](TimeConstraint_firstEvent))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    timeConstraint_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLTimeConstraint
    *
    * <!-- Start of user code doc for timeConstraint_compositeMetaProperties -->
    * <!-- End of user code doc for timeConstraint_compositeMetaProperties -->
    */
  def timeConstraint_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      intervalConstraint_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](TimeConstraint_specification))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    timeConstraint_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLTimeConstraint
    *
    * <!-- Start of user code doc for timeConstraint_referenceMetaProperties -->
    * <!-- End of user code doc for timeConstraint_referenceMetaProperties -->
    */
  def timeConstraint_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      intervalConstraint_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    timeConstraint_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLTimeConstraint
    *
    * <!-- Start of user code doc for timeConstraint_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for timeConstraint_forwardReferencesFromMetamodelAssociations -->
    */
  def timeConstraint_forwardReferencesFromMetamodelAssociations: Elements =
    intervalConstraint_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLTimeConstraint
