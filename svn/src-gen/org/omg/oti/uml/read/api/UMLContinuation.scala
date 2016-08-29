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
import org.omg.oti.uml.read.operations.UMLContinuationOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Continuation is a syntactic way to define continuations of different branches of an alternative CombinedFragment. Continuations are intuitively similar to labels representing intermediate points in a flow of control.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLContinuation[Uml <: UML]
  extends UMLInteractionFragment[Uml]
  with UMLContinuationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * True: when the Continuation is at the end of the enclosing InteractionFragment and False when it is in the beginning.
    *
    * <!-- Start of user code doc for setting -->
    * <!-- End of user code doc for setting -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def setting: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      continuation_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLContinuation
    *
    * <!-- Start of user code doc for continuation_metaAttributes -->
    * <!-- End of user code doc for continuation_metaAttributes -->
    */
  def continuation_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     interactionFragment_metaAttributes,
     Seq[MetaAttributeFunction](Continuation_setting))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    continuation_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLContinuation
    *
    * <!-- Start of user code doc for continuation_compositeMetaProperties -->
    * <!-- End of user code doc for continuation_compositeMetaProperties -->
    */
  def continuation_compositeMetaProperties: MetaPropertyFunctions = 
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
    continuation_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLContinuation
    *
    * <!-- Start of user code doc for continuation_referenceMetaProperties -->
    * <!-- End of user code doc for continuation_referenceMetaProperties -->
    */
  def continuation_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interactionFragment_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    continuation_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLContinuation
    *
    * <!-- Start of user code doc for continuation_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for continuation_forwardReferencesFromMetamodelAssociations -->
    */
  def continuation_forwardReferencesFromMetamodelAssociations: Elements =
    interactionFragment_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLContinuation
