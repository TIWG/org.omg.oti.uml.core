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
import org.omg.oti.uml.read.operations.UMLActionInputPinOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An ActionInputPin is a kind of InputPin that executes an Action to determine the values to input to another Action.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActionInputPin[Uml <: UML]
  extends UMLInputPin[Uml]
  with UMLActionInputPinOps[Uml] {

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
      actionInputPin_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLActionInputPin
    *
    * <!-- Start of user code doc for actionInputPin_metaAttributes -->
    * <!-- End of user code doc for actionInputPin_metaAttributes -->
    */
  def actionInputPin_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     inputPin_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    actionInputPin_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLActionInputPin
    *
    * <!-- Start of user code doc for actionInputPin_compositeMetaProperties -->
    * <!-- End of user code doc for actionInputPin_compositeMetaProperties -->
    */
  def actionInputPin_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      inputPin_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ActionInputPin_fromAction))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    actionInputPin_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLActionInputPin
    *
    * <!-- Start of user code doc for actionInputPin_referenceMetaProperties -->
    * <!-- End of user code doc for actionInputPin_referenceMetaProperties -->
    */
  def actionInputPin_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      inputPin_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    actionInputPin_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLActionInputPin
    *
    * <!-- Start of user code doc for actionInputPin_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for actionInputPin_forwardReferencesFromMetamodelAssociations -->
    */
  def actionInputPin_forwardReferencesFromMetamodelAssociations: Elements =
    inputPin_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLActionInputPin
