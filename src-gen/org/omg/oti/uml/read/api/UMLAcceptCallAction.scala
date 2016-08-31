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
import org.omg.oti.uml.read.operations.UMLAcceptCallActionOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An AcceptCallAction is an AcceptEventAction that handles the receipt of a synchronous call request. In addition to the values from the Operation input parameters, the Action produces an output that is needed later to supply the information to the ReplyAction necessary to return control to the caller. An AcceptCallAction is for synchronous calls. If it is used to handle an asynchronous call, execution of the subsequent ReplyAction will complete immediately with no effect.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAcceptCallAction[Uml <: UML]
  extends UMLAcceptEventAction[Uml]
  with UMLAcceptCallActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * An OutputPin where a value is placed containing sufficient information to perform a subsequent ReplyAction and return control to the caller. The contents of this value are opaque. It can be passed and copied but it cannot be manipulated by the model.
    *
    * <!-- Start of user code doc for returnInformation -->
    * <!-- End of user code doc for returnInformation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.returnInformation_acceptCallAction
    */
  def returnInformation: Option[UMLOutputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      acceptCallAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLAcceptCallAction
    *
    * <!-- Start of user code doc for acceptCallAction_metaAttributes -->
    * <!-- End of user code doc for acceptCallAction_metaAttributes -->
    */
  def acceptCallAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     acceptEventAction_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    acceptCallAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLAcceptCallAction
    *
    * <!-- Start of user code doc for acceptCallAction_compositeMetaProperties -->
    * <!-- End of user code doc for acceptCallAction_compositeMetaProperties -->
    */
  def acceptCallAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      acceptEventAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](AcceptCallAction_returnInformation))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    acceptCallAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLAcceptCallAction
    *
    * <!-- Start of user code doc for acceptCallAction_referenceMetaProperties -->
    * <!-- End of user code doc for acceptCallAction_referenceMetaProperties -->
    */
  def acceptCallAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      acceptEventAction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    acceptCallAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLAcceptCallAction
    *
    * <!-- Start of user code doc for acceptCallAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for acceptCallAction_forwardReferencesFromMetamodelAssociations -->
    */
  def acceptCallAction_forwardReferencesFromMetamodelAssociations: Elements =
    acceptEventAction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLAcceptCallAction
