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
import org.omg.oti.uml.read.operations.UMLFinalStateOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A special kind of State, which, when entered, signifies that the enclosing Region has completed. If the enclosing Region is directly contained in a StateMachine and all other Regions in that StateMachine also are completed, then it means that the entire StateMachine behavior is completed.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLFinalState[Uml <: UML]
  extends UMLState[Uml]
  with UMLFinalStateOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      finalState_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLFinalState
    *
    * <!-- Start of user code doc for finalState_metaAttributes -->
    * <!-- End of user code doc for finalState_metaAttributes -->
    */
  def finalState_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     state_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    finalState_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLFinalState
    *
    * <!-- Start of user code doc for finalState_compositeMetaProperties -->
    * <!-- End of user code doc for finalState_compositeMetaProperties -->
    */
  def finalState_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      state_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    finalState_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLFinalState
    *
    * <!-- Start of user code doc for finalState_referenceMetaProperties -->
    * <!-- End of user code doc for finalState_referenceMetaProperties -->
    */
  def finalState_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      state_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    finalState_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLFinalState
    *
    * <!-- Start of user code doc for finalState_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for finalState_forwardReferencesFromMetamodelAssociations -->
    */
  def finalState_forwardReferencesFromMetamodelAssociations: Elements =
    state_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLFinalState
