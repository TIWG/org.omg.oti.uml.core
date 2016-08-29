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
import org.omg.oti.uml.read.operations.UMLOpaqueBehaviorOps

import scala.Predef.String
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An OpaqueBehavior is a Behavior whose specification is given in a textual language other than UML.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLOpaqueBehavior[Uml <: UML]
  extends UMLBehavior[Uml]
  with UMLOpaqueBehaviorOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies the behavior in one or more languages.
    *
    * <!-- Start of user code doc for body -->
    * <!-- End of user code doc for body -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    */
  def body: Seq[String]

  /**
    * Languages the body strings use in the same order as the body strings.
    *
    * <!-- Start of user code doc for language -->
    * <!-- End of user code doc for language -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    */
  def language: Seq[String]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      opaqueBehavior_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLOpaqueBehavior
    *
    * <!-- Start of user code doc for opaqueBehavior_metaAttributes -->
    * <!-- End of user code doc for opaqueBehavior_metaAttributes -->
    */
  def opaqueBehavior_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     behavior_metaAttributes,
     Seq[MetaAttributeFunction](OpaqueBehavior_body,
     	OpaqueBehavior_language))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    opaqueBehavior_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLOpaqueBehavior
    *
    * <!-- Start of user code doc for opaqueBehavior_compositeMetaProperties -->
    * <!-- End of user code doc for opaqueBehavior_compositeMetaProperties -->
    */
  def opaqueBehavior_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavior_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    opaqueBehavior_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLOpaqueBehavior
    *
    * <!-- Start of user code doc for opaqueBehavior_referenceMetaProperties -->
    * <!-- End of user code doc for opaqueBehavior_referenceMetaProperties -->
    */
  def opaqueBehavior_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavior_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    opaqueBehavior_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLOpaqueBehavior
    *
    * <!-- Start of user code doc for opaqueBehavior_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for opaqueBehavior_forwardReferencesFromMetamodelAssociations -->
    */
  def opaqueBehavior_forwardReferencesFromMetamodelAssociations: Elements =
    behavior_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLOpaqueBehavior
