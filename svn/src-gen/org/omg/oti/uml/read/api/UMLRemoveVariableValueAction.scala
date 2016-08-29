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
import org.omg.oti.uml.read.operations.UMLRemoveVariableValueActionOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A RemoveVariableValueAction is a WriteVariableAction that removes values from a Variables.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLRemoveVariableValueAction[Uml <: UML]
  extends UMLWriteVariableAction[Uml]
  with UMLRemoveVariableValueActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies whether to remove duplicates of the value in nonunique Variables.
    *
    * <!-- Start of user code doc for isRemoveDuplicates -->
    * <!-- End of user code doc for isRemoveDuplicates -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isRemoveDuplicates: Boolean

  /**
    * An InputPin that provides the position of an existing value to remove in ordered, nonunique Variables. The type of the removeAt InputPin is UnlimitedNatural, but the value cannot be zero or unlimited.
    *
    * <!-- Start of user code doc for removeAt -->
    * <!-- End of user code doc for removeAt -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.removeAt_removeVariableValueAction
    */
  def removeAt: Option[UMLInputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      removeVariableValueAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLRemoveVariableValueAction
    *
    * <!-- Start of user code doc for removeVariableValueAction_metaAttributes -->
    * <!-- End of user code doc for removeVariableValueAction_metaAttributes -->
    */
  def removeVariableValueAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     writeVariableAction_metaAttributes,
     Seq[MetaAttributeFunction](RemoveVariableValueAction_isRemoveDuplicates))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    removeVariableValueAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLRemoveVariableValueAction
    *
    * <!-- Start of user code doc for removeVariableValueAction_compositeMetaProperties -->
    * <!-- End of user code doc for removeVariableValueAction_compositeMetaProperties -->
    */
  def removeVariableValueAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      writeVariableAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](RemoveVariableValueAction_removeAt))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    removeVariableValueAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLRemoveVariableValueAction
    *
    * <!-- Start of user code doc for removeVariableValueAction_referenceMetaProperties -->
    * <!-- End of user code doc for removeVariableValueAction_referenceMetaProperties -->
    */
  def removeVariableValueAction_referenceMetaProperties: MetaPropertyFunctions = 
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
    removeVariableValueAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLRemoveVariableValueAction
    *
    * <!-- Start of user code doc for removeVariableValueAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for removeVariableValueAction_forwardReferencesFromMetamodelAssociations -->
    */
  def removeVariableValueAction_forwardReferencesFromMetamodelAssociations: Elements =
    writeVariableAction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLRemoveVariableValueAction
