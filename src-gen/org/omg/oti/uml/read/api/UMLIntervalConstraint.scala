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
import org.omg.oti.uml.read.operations.UMLIntervalConstraintOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An IntervalConstraint is a Constraint that is specified by an Interval.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLIntervalConstraint[Uml <: UML]
  extends UMLConstraint[Uml]
  with UMLIntervalConstraintOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      intervalConstraint_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLIntervalConstraint
    *
    * <!-- Start of user code doc for intervalConstraint_metaAttributes -->
    * <!-- End of user code doc for intervalConstraint_metaAttributes -->
    */
  def intervalConstraint_metaAttributes: MetaAttributeFunctions = 
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
    intervalConstraint_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLIntervalConstraint
    *
    * <!-- Start of user code doc for intervalConstraint_compositeMetaProperties -->
    * <!-- End of user code doc for intervalConstraint_compositeMetaProperties -->
    */
  def intervalConstraint_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      constraint_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](IntervalConstraint_specification))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    intervalConstraint_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLIntervalConstraint
    *
    * <!-- Start of user code doc for intervalConstraint_referenceMetaProperties -->
    * <!-- End of user code doc for intervalConstraint_referenceMetaProperties -->
    */
  def intervalConstraint_referenceMetaProperties: MetaPropertyFunctions = 
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
    intervalConstraint_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLIntervalConstraint
    *
    * <!-- Start of user code doc for intervalConstraint_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for intervalConstraint_forwardReferencesFromMetamodelAssociations -->
    */
  def intervalConstraint_forwardReferencesFromMetamodelAssociations: Elements =
    constraint_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLIntervalConstraint
