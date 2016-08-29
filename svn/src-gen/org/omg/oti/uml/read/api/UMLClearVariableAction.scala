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
import org.omg.oti.uml.read.operations.UMLClearVariableActionOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ClearVariableAction is a VariableAction that removes all values of a Variable.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLClearVariableAction[Uml <: UML]
  extends UMLVariableAction[Uml]
  with UMLClearVariableActionOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      clearVariableAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLClearVariableAction
    *
    * <!-- Start of user code doc for clearVariableAction_metaAttributes -->
    * <!-- End of user code doc for clearVariableAction_metaAttributes -->
    */
  def clearVariableAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     variableAction_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    clearVariableAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLClearVariableAction
    *
    * <!-- Start of user code doc for clearVariableAction_compositeMetaProperties -->
    * <!-- End of user code doc for clearVariableAction_compositeMetaProperties -->
    */
  def clearVariableAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      variableAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    clearVariableAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLClearVariableAction
    *
    * <!-- Start of user code doc for clearVariableAction_referenceMetaProperties -->
    * <!-- End of user code doc for clearVariableAction_referenceMetaProperties -->
    */
  def clearVariableAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      variableAction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    clearVariableAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLClearVariableAction
    *
    * <!-- Start of user code doc for clearVariableAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for clearVariableAction_forwardReferencesFromMetamodelAssociations -->
    */
  def clearVariableAction_forwardReferencesFromMetamodelAssociations: Elements =
    variableAction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLClearVariableAction
