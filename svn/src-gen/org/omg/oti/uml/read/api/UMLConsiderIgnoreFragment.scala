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
import org.omg.oti.uml.read.operations.UMLConsiderIgnoreFragmentOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ConsiderIgnoreFragment is a kind of CombinedFragment that is used for the consider and ignore cases, which require lists of pertinent Messages to be specified.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConsiderIgnoreFragment[Uml <: UML]
  extends UMLCombinedFragment[Uml]
  with UMLConsiderIgnoreFragmentOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The set of messages that apply to this fragment.
    *
    * <!-- Start of user code doc for message -->
    * <!-- End of user code doc for message -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamedElement.message_considerIgnoreFragment
    */
  def message: Set[UMLNamedElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      considerIgnoreFragment_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLConsiderIgnoreFragment
    *
    * <!-- Start of user code doc for considerIgnoreFragment_metaAttributes -->
    * <!-- End of user code doc for considerIgnoreFragment_metaAttributes -->
    */
  def considerIgnoreFragment_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     combinedFragment_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    considerIgnoreFragment_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLConsiderIgnoreFragment
    *
    * <!-- Start of user code doc for considerIgnoreFragment_compositeMetaProperties -->
    * <!-- End of user code doc for considerIgnoreFragment_compositeMetaProperties -->
    */
  def considerIgnoreFragment_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      combinedFragment_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    considerIgnoreFragment_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLConsiderIgnoreFragment
    *
    * <!-- Start of user code doc for considerIgnoreFragment_referenceMetaProperties -->
    * <!-- End of user code doc for considerIgnoreFragment_referenceMetaProperties -->
    */
  def considerIgnoreFragment_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      combinedFragment_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ConsiderIgnoreFragment_message))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    considerIgnoreFragment_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLConsiderIgnoreFragment
    *
    * <!-- Start of user code doc for considerIgnoreFragment_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for considerIgnoreFragment_forwardReferencesFromMetamodelAssociations -->
    */
  def considerIgnoreFragment_forwardReferencesFromMetamodelAssociations: Elements =
    combinedFragment_forwardReferencesFromMetamodelAssociations ++
    message

  // Start of user code for additional features
  // End of user code
} //UMLConsiderIgnoreFragment
