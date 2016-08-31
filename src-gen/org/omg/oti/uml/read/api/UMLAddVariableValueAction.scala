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
import org.omg.oti.uml.read.operations.UMLAddVariableValueActionOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An AddVariableValueAction is a WriteVariableAction for adding values to a Variable.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAddVariableValueAction[Uml <: UML]
  extends UMLWriteVariableAction[Uml]
  with UMLAddVariableValueActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The InputPin that gives the position at which to insert a new value or move an existing value in ordered Variables. The type of the insertAt InputPin is UnlimitedNatural, but the value cannot be zero. It is omitted for unordered Variables.
    *
    * <!-- Start of user code doc for insertAt -->
    * <!-- End of user code doc for insertAt -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.insertAt_addVariableValueAction
    */
  def insertAt: Option[UMLInputPin[Uml]]

  /**
    * Specifies whether existing values of the Variable should be removed before adding the new value.
    *
    * <!-- Start of user code doc for isReplaceAll -->
    * <!-- End of user code doc for isReplaceAll -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isReplaceAll: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      addVariableValueAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLAddVariableValueAction
    *
    * <!-- Start of user code doc for addVariableValueAction_metaAttributes -->
    * <!-- End of user code doc for addVariableValueAction_metaAttributes -->
    */
  def addVariableValueAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     writeVariableAction_metaAttributes,
     Seq[MetaAttributeFunction](AddVariableValueAction_isReplaceAll))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    addVariableValueAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLAddVariableValueAction
    *
    * <!-- Start of user code doc for addVariableValueAction_compositeMetaProperties -->
    * <!-- End of user code doc for addVariableValueAction_compositeMetaProperties -->
    */
  def addVariableValueAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      writeVariableAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](AddVariableValueAction_insertAt))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    addVariableValueAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLAddVariableValueAction
    *
    * <!-- Start of user code doc for addVariableValueAction_referenceMetaProperties -->
    * <!-- End of user code doc for addVariableValueAction_referenceMetaProperties -->
    */
  def addVariableValueAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      writeVariableAction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    addVariableValueAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLAddVariableValueAction
    *
    * <!-- Start of user code doc for addVariableValueAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for addVariableValueAction_forwardReferencesFromMetamodelAssociations -->
    */
  def addVariableValueAction_forwardReferencesFromMetamodelAssociations: Elements =
    writeVariableAction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLAddVariableValueAction
