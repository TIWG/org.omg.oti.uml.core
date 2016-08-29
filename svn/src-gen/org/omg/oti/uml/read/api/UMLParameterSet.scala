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
import org.omg.oti.uml.read.operations.UMLParameterSetOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ParameterSet designates alternative sets of inputs or outputs that a Behavior may use.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLParameterSet[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLParameterSetOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Parameters in the ParameterSet.
    *
    * <!-- Start of user code doc for parameter -->
    * <!-- End of user code doc for parameter -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLParameter.parameterSet
    */
  def parameter: Set[UMLParameter[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      parameterSet_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLParameterSet
    *
    * <!-- Start of user code doc for parameterSet_metaAttributes -->
    * <!-- End of user code doc for parameterSet_metaAttributes -->
    */
  def parameterSet_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namedElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    parameterSet_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLParameterSet
    *
    * <!-- Start of user code doc for parameterSet_compositeMetaProperties -->
    * <!-- End of user code doc for parameterSet_compositeMetaProperties -->
    */
  def parameterSet_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ParameterSet_condition))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    parameterSet_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLParameterSet
    *
    * <!-- Start of user code doc for parameterSet_referenceMetaProperties -->
    * <!-- End of user code doc for parameterSet_referenceMetaProperties -->
    */
  def parameterSet_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ParameterSet_parameter))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    parameterSet_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLParameterSet
    *
    * <!-- Start of user code doc for parameterSet_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for parameterSet_forwardReferencesFromMetamodelAssociations -->
    */
  def parameterSet_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    parameter

  // Start of user code for additional features
  // End of user code
} //UMLParameterSet
