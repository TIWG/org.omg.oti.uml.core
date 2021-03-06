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
import org.omg.oti.uml.read.operations.UMLChangeEventOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ChangeEvent models a change in the system configuration that makes a condition true.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLChangeEvent[Uml <: UML]
  extends UMLEvent[Uml]
  with UMLChangeEventOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * A Boolean-valued ValueSpecification that will result in a ChangeEvent whenever its value changes from false to true.
    *
    * <!-- Start of user code doc for changeExpression -->
    * <!-- End of user code doc for changeExpression -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.changeExpression_changeEvent
    */
  def changeExpression: Option[UMLValueSpecification[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      changeEvent_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLChangeEvent
    *
    * <!-- Start of user code doc for changeEvent_metaAttributes -->
    * <!-- End of user code doc for changeEvent_metaAttributes -->
    */
  def changeEvent_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     event_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    changeEvent_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLChangeEvent
    *
    * <!-- Start of user code doc for changeEvent_compositeMetaProperties -->
    * <!-- End of user code doc for changeEvent_compositeMetaProperties -->
    */
  def changeEvent_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      event_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ChangeEvent_changeExpression))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    changeEvent_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLChangeEvent
    *
    * <!-- Start of user code doc for changeEvent_referenceMetaProperties -->
    * <!-- End of user code doc for changeEvent_referenceMetaProperties -->
    */
  def changeEvent_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      event_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    changeEvent_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLChangeEvent
    *
    * <!-- Start of user code doc for changeEvent_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for changeEvent_forwardReferencesFromMetamodelAssociations -->
    */
  def changeEvent_forwardReferencesFromMetamodelAssociations: Elements =
    event_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLChangeEvent
