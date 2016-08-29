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
import org.omg.oti.uml.read.operations.UMLInteractionOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An Interaction is a unit of Behavior that focuses on the observable exchange of information between connectable elements.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInteraction[Uml <: UML]
  extends UMLBehavior[Uml]
	with UMLInteractionFragment[Uml]
  with UMLInteractionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The ordered set of fragments in the Interaction.
    *
    * <!-- Start of user code doc for fragment -->
    * <!-- End of user code doc for fragment -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionFragment.enclosingInteraction
    */
  def fragment: Seq[UMLInteractionFragment[Uml]]

  /**
    * <!-- Start of user code doc for refersTo_interactionUse -->
    * <!-- End of user code doc for refersTo_interactionUse -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionUse.refersTo
    */
  def refersTo_interactionUse: Set[UMLInteractionUse[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      interaction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInteraction
    *
    * <!-- Start of user code doc for interaction_metaAttributes -->
    * <!-- End of user code doc for interaction_metaAttributes -->
    */
  def interaction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     behavior_metaAttributes,
     interactionFragment_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    interaction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInteraction
    *
    * <!-- Start of user code doc for interaction_compositeMetaProperties -->
    * <!-- End of user code doc for interaction_compositeMetaProperties -->
    */
  def interaction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavior_compositeMetaProperties,
      interactionFragment_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Interaction_action,
      	Interaction_formalGate,
      	Interaction_fragment,
      	Interaction_lifeline,
      	Interaction_message))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    interaction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInteraction
    *
    * <!-- Start of user code doc for interaction_referenceMetaProperties -->
    * <!-- End of user code doc for interaction_referenceMetaProperties -->
    */
  def interaction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavior_referenceMetaProperties,
      interactionFragment_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    interaction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInteraction
    *
    * <!-- Start of user code doc for interaction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for interaction_forwardReferencesFromMetamodelAssociations -->
    */
  def interaction_forwardReferencesFromMetamodelAssociations: Elements =
    behavior_forwardReferencesFromMetamodelAssociations ++
    interactionFragment_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLInteraction
