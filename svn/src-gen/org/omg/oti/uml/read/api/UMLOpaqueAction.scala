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
import org.omg.oti.uml.read.operations.UMLOpaqueActionOps

import scala.Predef.String
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An OpaqueAction is an Action whose functionality is not specified within UML.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLOpaqueAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLOpaqueActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Provides a textual specification of the functionality of the Action, in one or more languages other than UML.
    *
    * <!-- Start of user code doc for body -->
    * <!-- End of user code doc for body -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    */
  def body: Seq[String]

  /**
    * If provided, a specification of the language used for each of the body Strings.
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
      opaqueAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLOpaqueAction
    *
    * <!-- Start of user code doc for opaqueAction_metaAttributes -->
    * <!-- End of user code doc for opaqueAction_metaAttributes -->
    */
  def opaqueAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     Seq[MetaAttributeFunction](OpaqueAction_body,
     	OpaqueAction_language))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    opaqueAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLOpaqueAction
    *
    * <!-- Start of user code doc for opaqueAction_compositeMetaProperties -->
    * <!-- End of user code doc for opaqueAction_compositeMetaProperties -->
    */
  def opaqueAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](OpaqueAction_inputValue,
      	OpaqueAction_outputValue))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    opaqueAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLOpaqueAction
    *
    * <!-- Start of user code doc for opaqueAction_referenceMetaProperties -->
    * <!-- End of user code doc for opaqueAction_referenceMetaProperties -->
    */
  def opaqueAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    opaqueAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLOpaqueAction
    *
    * <!-- Start of user code doc for opaqueAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for opaqueAction_forwardReferencesFromMetamodelAssociations -->
    */
  def opaqueAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLOpaqueAction
