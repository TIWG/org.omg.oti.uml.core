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
import org.omg.oti.uml.read.operations.UMLInteractionUseOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * An InteractionUse refers to an Interaction. The InteractionUse is a shorthand for copying the contents of the referenced Interaction where the InteractionUse is. To be accurate the copying must take into account substituting parameters with arguments and connect the formal Gates with the actual ones.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInteractionUse[Uml <: UML]
  extends UMLInteractionFragment[Uml]
  with UMLInteractionUseOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The actual arguments of the Interaction.
    *
    * <!-- Start of user code doc for argument -->
    * <!-- End of user code doc for argument -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.argument_interactionUse
    */
  def argument: Seq[UMLValueSpecification[Uml]]

  /**
    * Refers to the Interaction that defines its meaning.
    *
    * <!-- Start of user code doc for refersTo -->
    * <!-- End of user code doc for refersTo -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteraction.refersTo_interactionUse
    */
  def refersTo: Option[UMLInteraction[Uml]]

  /**
    * The value of the executed Interaction.
    *
    * <!-- Start of user code doc for returnValue -->
    * <!-- End of user code doc for returnValue -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.returnValue_interactionUse
    */
  def returnValue: Option[UMLValueSpecification[Uml]]

  /**
    * The recipient of the return value.
    *
    * <!-- Start of user code doc for returnValueRecipient -->
    * <!-- End of user code doc for returnValueRecipient -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.returnValueRecipient_interactionUse
    */
  def returnValueRecipient: Option[UMLProperty[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      interactionUse_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInteractionUse
    *
    * <!-- Start of user code doc for interactionUse_metaAttributes -->
    * <!-- End of user code doc for interactionUse_metaAttributes -->
    */
  def interactionUse_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     interactionFragment_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    interactionUse_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInteractionUse
    *
    * <!-- Start of user code doc for interactionUse_compositeMetaProperties -->
    * <!-- End of user code doc for interactionUse_compositeMetaProperties -->
    */
  def interactionUse_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interactionFragment_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](InteractionUse_actualGate,
      	InteractionUse_argument,
      	InteractionUse_returnValue))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    interactionUse_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInteractionUse
    *
    * <!-- Start of user code doc for interactionUse_referenceMetaProperties -->
    * <!-- End of user code doc for interactionUse_referenceMetaProperties -->
    */
  def interactionUse_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interactionFragment_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](InteractionUse_refersTo,
      	InteractionUse_returnValueRecipient))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    interactionUse_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInteractionUse
    *
    * <!-- Start of user code doc for interactionUse_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for interactionUse_forwardReferencesFromMetamodelAssociations -->
    */
  def interactionUse_forwardReferencesFromMetamodelAssociations: Elements =
    interactionFragment_forwardReferencesFromMetamodelAssociations ++
    refersTo ++
    returnValueRecipient

  // Start of user code for additional features
  // End of user code
} //UMLInteractionUse
