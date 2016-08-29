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
import org.omg.oti.uml.read.operations.{UMLElementOps,UMLOps}

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An Element is a constituent of a model. As such, it has the capability of owning other Elements.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLElement[Uml <: UML]
  extends UMLElementOps[Uml] {

  implicit val ops: UMLOps[Uml]
  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Elements owned by this Element.
    *
    * <!-- Start of user code doc for ownedElement -->
    * <!-- End of user code doc for ownedElement -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElement.owner
    */
  def ownedElement: Set[UMLElement[Uml]]

  /**
    * The Element that owns this Element.
    *
    * <!-- Start of user code doc for owner -->
    * <!-- End of user code doc for owner -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElement.ownedElement
    */
  def owner: Option[UMLElement[Uml]]

  /**
    * <!-- Start of user code doc for annotatedElement_comment -->
    * <!-- End of user code doc for annotatedElement_comment -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLComment.annotatedElement
    */
  def annotatedElement_comment: Set[UMLComment[Uml]]

  /**
    * <!-- Start of user code doc for constrainedElement_constraint -->
    * <!-- End of user code doc for constrainedElement_constraint -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.constrainedElement
    */
  def constrainedElement_constraint: Set[UMLConstraint[Uml]]

  /**
    * <!-- Start of user code doc for context_diagram -->
    * <!-- End of user code doc for context_diagram -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDiagram.context
    */
  def context_diagram: Set[UMLDiagram[Uml]]

  /**
    * <!-- Start of user code doc for element_elementValue -->
    * <!-- End of user code doc for element_elementValue -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElementValue.element
    */
  def element_elementValue: Set[UMLElementValue[Uml]]

  /**
    * <!-- Start of user code doc for relatedElement_relationship -->
    * <!-- End of user code doc for relatedElement_relationship -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRelationship.relatedElement
    */
  def relatedElement_relationship: Set[UMLRelationship[Uml]]

  /**
    * <!-- Start of user code doc for represents_activityPartition -->
    * <!-- End of user code doc for represents_activityPartition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityPartition.represents
    */
  def represents_activityPartition: Set[UMLActivityPartition[Uml]]

  /**
    * <!-- Start of user code doc for source_directedRelationship -->
    * <!-- End of user code doc for source_directedRelationship -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDirectedRelationship.source
    */
  def source_directedRelationship: Set[UMLDirectedRelationship[Uml]]

  /**
    * <!-- Start of user code doc for target_directedRelationship -->
    * <!-- End of user code doc for target_directedRelationship -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDirectedRelationship.target
    */
  def target_directedRelationship: Set[UMLDirectedRelationship[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    def metaAttributes: MetaAttributeFunctions =
      element_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLElement
    *
    * <!-- Start of user code doc for element_metaAttributes -->
    * <!-- End of user code doc for element_metaAttributes -->
    */
  def element_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * The order matters; more general composite meta properties must be before more specific ones.
    * - composite meta-properties defined in a superclass are more general than composite meta-properties defined in a subclass
    * - subsetted/redefined composite meta-properties are more general than subsetting/redefining composite meta-properties
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  def compositeMetaProperties: MetaPropertyFunctions =
    element_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLElement
    *
    * <!-- Start of user code doc for element_compositeMetaProperties -->
    * <!-- End of user code doc for element_compositeMetaProperties -->
    */
  def element_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      Seq[MetaPropertyEvaluator](Element_ownedComment))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * The order matters; more general reference meta properties must be before more specific ones.
    * - reference meta-properties defined in a superclass are more general than reference meta-properties defined in a subclass
    * - subsetted/redefined reference meta-properties are more general than subsetting/redefining reference meta-properties
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  def referenceMetaProperties: MetaPropertyFunctions =
    element_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLElement
    *
    * <!-- Start of user code doc for element_referenceMetaProperties -->
    * <!-- End of user code doc for element_referenceMetaProperties -->
    */
  def element_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  def forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLElement
    *
    * <!-- Start of user code doc for element_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for element_forwardReferencesFromMetamodelAssociations -->
    */
  def element_forwardReferencesFromMetamodelAssociations: Elements =
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLElement
