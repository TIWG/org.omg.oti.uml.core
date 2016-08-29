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
import org.omg.oti.uml.read.operations.UMLRaiseExceptionActionOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A RaiseExceptionAction is an Action that causes an exception to occur. The input value becomes the exception object.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLRaiseExceptionAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLRaiseExceptionActionOps[Uml] {

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
      raiseExceptionAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLRaiseExceptionAction
    *
    * <!-- Start of user code doc for raiseExceptionAction_metaAttributes -->
    * <!-- End of user code doc for raiseExceptionAction_metaAttributes -->
    */
  def raiseExceptionAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    raiseExceptionAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLRaiseExceptionAction
    *
    * <!-- Start of user code doc for raiseExceptionAction_compositeMetaProperties -->
    * <!-- End of user code doc for raiseExceptionAction_compositeMetaProperties -->
    */
  def raiseExceptionAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](RaiseExceptionAction_exception))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    raiseExceptionAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLRaiseExceptionAction
    *
    * <!-- Start of user code doc for raiseExceptionAction_referenceMetaProperties -->
    * <!-- End of user code doc for raiseExceptionAction_referenceMetaProperties -->
    */
  def raiseExceptionAction_referenceMetaProperties: MetaPropertyFunctions = 
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
    raiseExceptionAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLRaiseExceptionAction
    *
    * <!-- Start of user code doc for raiseExceptionAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for raiseExceptionAction_forwardReferencesFromMetamodelAssociations -->
    */
  def raiseExceptionAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLRaiseExceptionAction
